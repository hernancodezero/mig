package pe.com.mig.dao.impl;

import java.util.Calendar;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.com.mig.dao.ITransferenciaDao;
import pe.com.mig.model.bean.DetalleTransferenciaBean;
import pe.com.mig.model.bean.TransferenciaBean;
import pe.com.mig.model.entity.TDetalleTranfer;
import pe.com.mig.model.entity.TTipoComprobante;
import pe.com.mig.model.entity.TTipoMoneda;
import pe.com.mig.model.entity.TTransferencia;
import pe.com.mig.model.entity.sde.TbtRegistroNac;
import pe.com.mig.model.entity.sernanp.Unidadoperativa;
import pe.com.mig.model.entity.sppi.TEspecifica;
import pe.com.mig.util.Constantes;

/**
 * @className: TransferenciaDaoImpl.java
 * @description: 
 * @date: 12 de jun. de 2016
 * @author: SUMERIO.
 */
@Repository
public class TransferenciaDaoImpl extends GenericDaoImpl implements ITransferenciaDao {

	private static final long serialVersionUID = 1L;

	/* (non-Javadoc)
	 * @see pe.com.mig.dao.ITransferenciaDao#listarTransferencias(pe.com.mig.model.bean.TransferenciaBean)
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<TransferenciaBean> listarTransferencias(TransferenciaBean transferencia) throws Exception {
		try {
			StringBuilder hql = new StringBuilder();			
			hql.append("select tra.idTransferencia as cod_transferencia, ");	
			hql.append("com.srlIdComprobante as cod_comprobante, com.chrNomComprobante as tip_comprobante, ");
			hql.append("mon.srlIdMoneda as cod_moneda, mon.chrNomMoneda as tip_moneda, ");			
			hql.append("tra.intIdfTransaccion as int_transaccion, tra.chrSerComprobante as ser_comprobante, ");
			hql.append("trim(tra.chrNumComprobante) as num_comprobante, tra.chrCodFte as cod_fue_financiamiento,");
			hql.append("to_char(tra.dteFecComprobante, 'DD/MM/YYYY') as fec_comprobante, ");			
			hql.append("tra.intNumSiaf as num_siaf, tra.numTipCambio as num_tip_cambio, ");
			hql.append("trim(tra.chrNumDocuOperacion) as num_doc_operacion, ");			
			hql.append("to_char(tra.dteFecDocoperacion, 'DD/MM/YYYY') as fec_doc_operacion, ");
			hql.append("to_char(tra.dteFecTransferencia, 'DD/MM/YYYY') as fec_transferencia, ");
			hql.append("tra.numImpTotal as imp_total, tra.chrConcepto as concepto, ");
			hql.append("uni.idunidad as cod_uni_operativa, uni.nomunidad as des_uni_operativa, ");
			hql.append("reg.idRanac as cod_reg_nac, reg.nombre as des_reg_nac, ");
			hql.append("(current_date() - tra.dteFecComprobante) as can_dia_transcurridos, ");
			hql.append("trim(tra.chrNumRendicion) as num_doc_rendicion, tra.indTipoFPE as ind_tipo_fpe,");
			hql.append("tra.intMes as cod_mes, tra.intAnno as cod_anno, "); 
			hql.append("tra.chrCodUsuaCreacion as mnt_usu_creacion, ");			
			hql.append("to_char(tra.dteFecCreacion, 'DD/MM/YYYY') as mnt_fec_creacion, ");
			hql.append("tra.chrCodUsuaModifica as mnt_usu_modificacion, ");
			hql.append("to_char(tra.dteFecModifica, 'DD/MM/YYYY') as mnt_fec_modificacion ");	
			hql.append("from TTransferencia tra ");			
			hql.append("inner join tra.TTipoMoneda mon ");
			hql.append("inner join tra.TTipoComprobante com ");
			hql.append("inner join tra.unidadoperativa uni ");
			hql.append("left join tra.tbtRegistroNac reg ");
			hql.append("where tra.intIdfRegistro = :int_id_registro ");
			if (!isNullInteger(transferencia.getCod_transferencia())) {
				hql.append("and tra.idTransferencia = :cod_transferencia ");
			}
			if (!isNullOrEmpty(transferencia.getInd_transaccion())) {
				if (transferencia.getInd_transaccion().length() == 1) { 
					hql.append("and tra.intIdfTransaccion = :ind_transaccion ");
				} else {
					hql.append("and tra.intIdfTransaccion in (1, 2) ");
				}
			}			
			if (!isNullInteger(transferencia.getCod_uni_operativa())) {
				hql.append("and uni.idunidad = :cod_uni_operativa ");
			}			
			if (!isNullInteger(transferencia.getCod_comprobante())) {
				hql.append("and com.srlIdComprobante = :cod_comprobante ");
			}
			if (!isNullOrEmpty(transferencia.getFec_desde()) && !isNullOrEmpty(transferencia.getFec_hasta())) {
				hql.append("and tra.dteFecComprobante between :fechaInicio and :fechaFin ");
			}
			if (!isNullOrEmpty(transferencia.getSer_comprobante())) {
				hql.append("and tra.chrSerComprobante = :ser_comprobante ");
			}
			if (!isNullOrEmpty(transferencia.getNum_comprobante())) {
				//hql.append("and trim(tra.chrNumComprobante) = :num_comprobante and EXTRACT(YEAR FROM tra.dteFecComprobante) = extract(year from current_date) ");
				hql.append("and trim(tra.chrNumComprobante) = :num_comprobante ");
			}			
			if (!isNullInteger(transferencia.getNum_siaf())) {
				hql.append("and tra.intNumSiaf = :num_siaf ");
			}
			if (!isNullInteger(transferencia.getCod_anno())) {
				hql.append("and tra.intAnno = :cod_anno ");
			}			
			if (!isNullInteger(transferencia.getCod_mes())) {
				hql.append("and tra.intMes = :cod_mes ");
			}			
			hql.append("order by tra.idTransferencia");	
					
			Query query = super.getSession().createQuery(hql.toString());
			query.setParameter("int_id_registro", Constantes.ESTADO_ACTIVO);
			
			if (!isNullInteger(transferencia.getCod_transferencia())) {
				query.setParameter("cod_transferencia", transferencia.getCod_transferencia());
			}
			if (!isNullOrEmpty(transferencia.getInd_transaccion())) {
				if (transferencia.getInd_transaccion().length() == 1) {  
					query.setParameter("ind_transaccion", getInteger(transferencia.getInd_transaccion()));
				}
			}
			if (!isNullInteger(transferencia.getCod_uni_operativa())) {
				query.setParameter("cod_uni_operativa", transferencia.getCod_uni_operativa());
			}
			if (!isNullInteger(transferencia.getCod_comprobante())) {
				query.setParameter("cod_comprobante", transferencia.getCod_comprobante());
			}
			if (!isNullOrEmpty(transferencia.getFec_desde()) && !isNullOrEmpty(transferencia.getFec_hasta())) {
				query.setParameter("fechaInicio", getDate(transferencia.getFec_desde()));
				query.setParameter("fechaFin", getDate(transferencia.getFec_hasta()));
			}
			if (!isNullOrEmpty(transferencia.getSer_comprobante())) {
				query.setParameter("ser_comprobante", transferencia.getSer_comprobante());
			}
			if (!isNullOrEmpty(transferencia.getNum_comprobante())) {
				query.setParameter("num_comprobante", transferencia.getNum_comprobante().trim());
			}
			if (!isNullInteger(transferencia.getNum_siaf())) {
				query.setParameter("num_siaf", transferencia.getNum_siaf());
			}
			if (!isNullInteger(transferencia.getCod_anno())) {
				query.setParameter("cod_anno", transferencia.getCod_anno());
			}
			if (!isNullInteger(transferencia.getCod_mes())) {
				query.setParameter("cod_mes", transferencia.getCod_mes());
			}
			return query.setResultTransformer(Transformers.aliasToBean(TransferenciaBean.class)).list();		
		} catch (Exception e) {
			throw new Exception( getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(), 
								 Constantes.NIVEL_APP_DAO, this.getClass().getName(), e.getMessage()) );
		}
	}

	/* (non-Javadoc)
	 * @see pe.com.mig.dao.ITransferenciaDao#listarDetalleTransferencias(pe.com.mig.model.bean.DetalleTransferenciaBean)
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<DetalleTransferenciaBean> listarDetalleTransferencias(DetalleTransferenciaBean detalle) throws Exception {
		
		try {
			StringBuilder hql = new StringBuilder();				
			hql.append("select det.srlIdDetalle as cod_det_transferencia, tra.idTransferencia as cod_transferencia, ");	
			hql.append("esp.srl_id_esp as cod_especifica, trim(esp.var_nom_especifica) as des_especifica, ");
			hql.append("trim(det.chrCodMeta) as cod_meta, ");
			hql.append("trim(esp.chr_cod_especifica) as vcod_especifica, det.numImpPartida as imp_partida, ");			
			hql.append("det.chrCodUsuaCreacion as vnomusuario, det.dteFecCreacion as fec_creacion, ");
			hql.append("det.intIdfRegistro as int_id_registro ");
			if (!isNullInteger(detalle.getInd_saldo())) {
				hql.append(",(det.numImpPartida - ");
				hql.append("(select coalesce(sum(tdc.numCntServicio), 0)");			
				hql.append("from TDetalleCompras tdc ");			
				hql.append("inner join tdc.TComprasIngresos tci ");
				hql.append("inner join tdc.TEspecifica tes ");
				hql.append("where tes.srl_id_esp = esp.srl_id_esp ");
				hql.append("and tdc.intIdfRegistro = :int_id_registro ");
				hql.append("and tci.intIdfRegistro = :int_id_registro ");
				hql.append("and tci.intIdfRegistro = :int_id_registro ");
				hql.append("and trim(tdc.chrCodMeta)=trim(det.chrCodMeta) ");
				hql.append("and tci.chrNumCompOperacion = tra.chrNumComprobante ");
				hql.append("and tci.intNumSiafOperacion = tra.intNumSiaf) + ");				
				hql.append("(select coalesce(sum(tde.numCntServicio), 0)");			
				hql.append("from TDetalleCompras tde ");
				hql.append("inner join tde.TEspecifica tes ");
				hql.append("inner join tde.TComprasIngresos tci ");				
				hql.append("inner join tci.TTipoComprobante ttc ");				
				hql.append("where tes.srl_id_esp = esp.srl_id_esp ");
				hql.append("and tde.intIdfRegistro = :int_id_registro ");
				hql.append("and tci.intCodPadComIngresos > 0 ");
				hql.append("and tci.intIdfRegistro = :int_id_registro ");
				hql.append("and ttc.srlIdComprobante = :cod_comprobante "); // Nota de Credito			
				hql.append("and tci.chrNumCompOperacion = tra.chrNumComprobante ");
				hql.append("and tci.intNumSiafOperacion = tra.intNumSiaf)) as imp_saldo ");	
			}
			hql.append("from TDetalleTranfer det ");			
			hql.append("inner join det.TTransferencia tra ");
			hql.append("inner join det.TEspecifica esp ");
			hql.append("where det.intIdfRegistro = :int_id_registro ");
			if (!isNull(detalle.getCod_transferencia())) {
				hql.append("and tra.idTransferencia = :cod_transferencia ");
			}
			hql.append("order by trim(det.chrCodMeta),det.srlIdDetalle");	
			Query query = super.getSession().createQuery(hql.toString());
			query.setParameter("int_id_registro", Constantes.ESTADO_ACTIVO);
			if (!isNull(detalle.getCod_transferencia())) {
				query.setParameter("cod_transferencia", detalle.getCod_transferencia());
			}
			if (!isNullInteger(detalle.getInd_saldo())) {
				query.setParameter("cod_comprobante", Constantes.EIGHT_INT); // Nota de Credito	
			}
			return query.setResultTransformer(Transformers.aliasToBean(DetalleTransferenciaBean.class)).list();		
		} catch (Exception e) {
			throw new Exception( getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(), 
								 Constantes.NIVEL_APP_DAO, this.getClass().getName(), e.getMessage()) );
		}
	}
	
	/* (non-Javadoc)
	 * @see pe.com.mig.dao.ITransferenciaDao#grabarTransferencia(pe.com.mig.model.bean.TransferenciaBean, java.util.List)
	 */
	@Transactional
	@Override
	public Integer grabarTransferencia(TransferenciaBean transferencia, List<DetalleTransferenciaBean> detalle) throws Exception {
		Integer codigo = transferencia.getCod_transferencia();
		try {		
			TTransferencia ttransferencia = new TTransferencia();
			if (!isNullInteger(codigo)) {				
				ttransferencia = (TTransferencia) getById(TTransferencia.class, codigo);
			}
			ttransferencia.setTTipoComprobante(new TTipoComprobante(transferencia.getCod_comprobante()));
			ttransferencia.setTTipoMoneda(new TTipoMoneda(transferencia.getCod_moneda()));
			ttransferencia.setIntIdfTransaccion(transferencia.getInt_transaccion());			
			// ttransferencia.setChrSerComprobante(transferencia.getSer_comprobante());
			ttransferencia.setChrNumComprobante(transferencia.getNum_comprobante().trim());
			ttransferencia.setDteFecComprobante(getDate(transferencia.getFec_comprobante()));
			ttransferencia.setChrCodFte(transferencia.getCod_fue_financiamiento());
			ttransferencia.setIntNumSiaf(transferencia.getNum_siaf());
			// ttransferencia.setNumTipCambio(transferencia.getNum_tip_cambio());			
			ttransferencia.setUnidadoperativa(new Unidadoperativa(transferencia.getCod_uni_operativa())); // Default : 1			 
			if (!isNullInteger(transferencia.getCod_reg_nac())) {
				ttransferencia.setTbtRegistroNac(new TbtRegistroNac(transferencia.getCod_reg_nac())); // Default : 1
			} else {
				ttransferencia.setTbtRegistroNac(null);
			}
			//ttransferencia.setIntIdunidad(transferencia.getUni_operativa());
			ttransferencia.setChrNumDocuOperacion(transferencia.getNum_doc_operacion());
			ttransferencia.setDteFecDocoperacion(getDate(transferencia.getFec_doc_operacion()));
			ttransferencia.setDteFecTransferencia(getDate(transferencia.getFec_transferencia()));
			ttransferencia.setNumImpTotal(transferencia.getImp_total());
			ttransferencia.setChrConcepto(transferencia.getConcepto());
			ttransferencia.setChrNumRendicion(transferencia.getNum_doc_rendicion());
			ttransferencia.setIndTipoFPE(transferencia.getInd_tipo_fpe());
			ttransferencia.setIntAnno(transferencia.getCod_anno());
			ttransferencia.setIntMes(transferencia.getCod_mes());
			
			if (!isNullInteger(codigo)) {
				// Eliminamos logicamente el detalle anterior
				List<DetalleTransferenciaBean> lista = listarDetalleTransferencias(new DetalleTransferenciaBean(codigo));
				for (DetalleTransferenciaBean det : lista) {		
					TDetalleTranfer tdetalleCompras = new TDetalleTranfer();
					tdetalleCompras.setSrlIdDetalle(det.getCod_det_transferencia());					
					tdetalleCompras.setTTransferencia(new TTransferencia(codigo));					
					tdetalleCompras.setTEspecifica(new TEspecifica(det.getCod_especifica()));		
					tdetalleCompras.setChrCodMeta(det.getCod_meta());
					tdetalleCompras.setNumImpPartida(det.getImp_partida());
					tdetalleCompras.setChrCodUsuaCreacion(det.getVnomusuario());
					tdetalleCompras.setDteFecCreacion(det.getFec_creacion());
					tdetalleCompras.setIntIdfRegistro(Constantes.ESTADO_ELIMINADO);
					tdetalleCompras.setChrCodUsuaModifica(transferencia.getVnomusuario());
					tdetalleCompras.setDteFecModifica(Calendar.getInstance().getTime());
					update(tdetalleCompras);
				}
				
				ttransferencia.setChrCodUsuaModifica(transferencia.getVnomusuario());
				ttransferencia.setDteFecModifica(Calendar.getInstance().getTime());
				update(ttransferencia);			
			} else {
				ttransferencia.setIntIdfRegistro(Constantes.ESTADO_ACTIVO);
				ttransferencia.setChrCodUsuaCreacion(transferencia.getVnomusuario());
				ttransferencia.setDteFecCreacion(Calendar.getInstance().getTime());
				codigo = getByIdSave(ttransferencia);
			}
			for (DetalleTransferenciaBean det : detalle) {		
				TDetalleTranfer tdetalleCompras = new TDetalleTranfer();					
				tdetalleCompras.setTTransferencia(new TTransferencia(codigo));
				tdetalleCompras.setTEspecifica(new TEspecifica(det.getCod_especifica()));			
				tdetalleCompras.setChrCodMeta(det.getCod_meta());
				tdetalleCompras.setNumImpPartida(det.getImp_partida());
				tdetalleCompras.setChrCodUsuaCreacion(transferencia.getVnomusuario());
				tdetalleCompras.setDteFecCreacion(Calendar.getInstance().getTime());
				tdetalleCompras.setIntIdfRegistro(Constantes.ESTADO_ACTIVO);
				save(tdetalleCompras);
			}		
		} catch (Exception e) {
			throw new Exception(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(), 
								Constantes.NIVEL_APP_DAO, 
								this.getClass().getName(), e.getMessage()));
		}
		return codigo;
	}

	/* (non-Javadoc)
	 * @see pe.com.mig.dao.ITransferenciaDao#eliminarTransferencia(pe.com.mig.model.bean.TransferenciaBean)
	 */
	@Transactional
	@Override
	public void eliminarTransferencia(TransferenciaBean transferencia) throws Exception {
		try {
			TTransferencia ttransferencia = new TTransferencia(); 
			ttransferencia = (TTransferencia) getById(TTransferencia.class, transferencia.getCod_transferencia());			
			ttransferencia.setIntIdfRegistro(Constantes.ESTADO_ELIMINADO);
			ttransferencia.setChrCodUsuaModifica(transferencia.getVnomusuario());
			ttransferencia.setDteFecModifica(Calendar.getInstance().getTime());
			update(ttransferencia);
		} catch (Exception e) {
			throw new Exception(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(), 
								Constantes.NIVEL_APP_DAO, 
								this.getClass().getName(), e.getMessage()));
		}
	}

}
