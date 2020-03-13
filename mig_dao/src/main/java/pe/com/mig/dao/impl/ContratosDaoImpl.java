package pe.com.mig.dao.impl;

import java.util.Calendar;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.com.mig.dao.IContratosDao;
import pe.com.mig.model.bean.ContratosBean;
import pe.com.mig.model.bean.DetalleContratosBean;
import pe.com.mig.model.entity.TContratos;
import pe.com.mig.model.entity.TDetalleContratos;
import pe.com.mig.model.entity.TDocumentoIdentidad;
import pe.com.mig.model.entity.TTipoProveedor;
import pe.com.mig.model.entity.sde.TbtRegistroNac;
import pe.com.mig.model.entity.sernanp.Unidadoperativa;
import pe.com.mig.util.Constantes;

/**
 * @className: ContratosDaoImpl.java
 * @description: 
 * @date: 25 de jun. de 2016
 * @author: SUMERIO.
 */
@Repository
public class ContratosDaoImpl extends GenericDaoImpl implements IContratosDao {

	private static final long serialVersionUID = 1L;

	/* (non-Javadoc)
	 * @see pe.com.mig.dao.IContratosDao#listarContrato(pe.com.mig.model.bean.ContratosBean)
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<ContratosBean> listarContrato(ContratosBean contrato) throws Exception {
		try {
			StringBuilder hql = new StringBuilder();			
			hql.append("select tco.srlIdContrato as cod_contrato, tco.chrNumContrato as num_contrato, ");
			hql.append("tdi.srlIdDocumento as cod_documento, tdi.chrNomDocumento as nom_documento, ");						
			hql.append("ttp.srlIdProveedor as cod_proveedor, ttp.numRuc as num_ruc, ");			
			hql.append("ttp.chrTipProveedor as tip_proveedor, ttp.chrTipEstado as tip_estado, ");
			hql.append("ttp.numRuc as num_ruc, ttp.chrNumDocumento as num_documento, ");
			hql.append("ttp.chrRazSocial as raz_social, ttp.chrNombres as nombres, ");
			hql.append("ttp.chrApePaterno as ape_paterno, ttp.chrApeMaterno as ape_materno, ");
			hql.append("tco.chrNumContrato as num_contrato, ");			
			hql.append("to_char(tco.dteFecInicio, 'DD/MM/YYYY') as fec_inicio, ");
			hql.append("to_char(tco.dteFecFinal, 'DD/MM/YYYY') as fec_final, ");			
			hql.append("tco.chrTipContrato as tip_contrato, ");
			hql.append("tco.chrNomConcedente as nom_concedente, tco.chrApeConcedente as ape_concedente, ");
			hql.append("tco.chrTipPago as tip_pago, tco.chrNumComprobante as num_comprobante, ");
			hql.append("to_char(tco.dteFecComprobante, 'DD/MM/YYYY') as fec_comprobante, ");			
			hql.append("tco.chrConcepto as concepto, tco.intImpContrato as num_imp_contrato, ");
			hql.append("tco.intImpGarantia as num_imp_garantia, tco.intImpAlquiler as num_imp_alquiler, ");
			hql.append("tco.intImpTributo as num_imp_tributo, tco.intImpInteres as num_imp_interes, ");
			hql.append("tco.intIdfRegistro as int_id_registro, ");	
			hql.append("tco.srlIdMoneda as srlIdMoneda,");
			hql.append("uni.idunidad as cod_uni_operativa, uni.nomunidad as des_uni_operativa, ");
			hql.append("reg.idRanac as cod_reg_nac, reg.nombre as des_reg_nac, ");
			hql.append("tco.chrCodUsuaModifica as mnt_usu_modificacion ");
			hql.append("from TContratos tco ");
			hql.append("left join tco.TDocumentoIdentidad tdi ");
			hql.append("left join tco.TTipoProveedor ttp ");
			hql.append("left join tco.unidadoperativa uni ");
			hql.append("left join tco.tbtRegistroNac reg ");			
			hql.append("where tco.intIdfRegistro = :int_id_registro ");
			
			if (!isNullOrEmpty(contrato.getChrTipOperacion())) {
				hql.append("and tco.chrTipOperacion = :chrTipOperacion ");
			} 
			if (!isNullInteger(contrato.getCod_contrato())) {
				hql.append("and tco.srlIdContrato = :cod_contrato ");
			}
			if (!isNullOrEmpty(contrato.getNum_contrato())) {
				hql.append("and trim(tco.chrNumContrato) = :num_contrato ");
			}
			if (!isNullInteger(contrato.getCod_reg_nac())) {
				hql.append("and reg.idRanac  = :cod_reg_nac ");
			}
			if (!isNullInteger(contrato.getCod_uni_operativa())) {
				hql.append("and uni.idunidad = :cod_uni_operativa ");
			}
			if (!isNullOrEmpty(contrato.getFec_desde()) && !isNullOrEmpty(contrato.getFec_hasta())) {
				hql.append("and tco.dteFecComprobante between :fechaInicio and :fechaFin ");
			}
			hql.append("order by tco.chrNumContrato");	
			Query query = super.getSession().createQuery(hql.toString());
			query.setParameter("int_id_registro", Constantes.ESTADO_ACTIVO);
			if (!isNullInteger(contrato.getCod_contrato())) {
				query.setParameter("cod_contrato", contrato.getCod_contrato());
			}
			if (!isNullOrEmpty(contrato.getChrTipOperacion())) {
				query.setParameter("chrTipOperacion", contrato.getChrTipOperacion());
			} 
			if (!isNullOrEmpty(contrato.getNum_contrato())) {
				query.setParameter("num_contrato", contrato.getNum_contrato());
			}
			if (!isNullInteger(contrato.getCod_reg_nac())) {
				query.setParameter("cod_reg_nac", contrato.getCod_reg_nac());
			}
			if (!isNullInteger(contrato.getCod_uni_operativa())) {
				query.setParameter("cod_uni_operativa", contrato.getCod_uni_operativa());
			}
			if (!isNullOrEmpty(contrato.getFec_desde()) && !isNullOrEmpty(contrato.getFec_hasta())) {
				query.setParameter("fechaInicio", getDate(contrato.getFec_desde()));
				query.setParameter("fechaFin", getDate(contrato.getFec_hasta()));
			}
			return query.setResultTransformer(Transformers.aliasToBean(ContratosBean.class)).list();		
		} catch (Exception e) {
			throw new Exception(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(), 
								Constantes.NIVEL_APP_DAO, 
								this.getClass().getName(), e.getMessage()));
		}
	}

	/* (non-Javadoc)
	 * @see pe.com.mig.dao.IContratosDao#grabarContrato(pe.com.mig.model.bean.ContratosBean)
	 */
	@Transactional
	@Override
	public Integer grabarContrato(ContratosBean contrato, List<DetalleContratosBean> detalle) throws Exception {
		Integer codigo = contrato.getCod_contrato();
		try {		
			TContratos tcontratos = new TContratos();
			if (!isNullInteger(codigo)) {				
				tcontratos = (TContratos) getById(TContratos.class, codigo);
			}
			tcontratos.setTDocumentoIdentidad(new TDocumentoIdentidad(contrato.getCod_documento()));			
			tcontratos.setTTipoProveedor(new TTipoProveedor(contrato.getCod_proveedor()));		
			tcontratos.setChrNomConcedente(contrato.getNom_concedente().trim());
			tcontratos.setChrApeConcedente(contrato.getApe_concedente().trim());
			if (contrato.getCod_uni_operativa() != 0) {
				tcontratos.setUnidadoperativa(new Unidadoperativa(contrato.getCod_uni_operativa())); // Default : 1
			}
			if (contrato.getCod_reg_nac() != 0) {
				tcontratos.setTbtRegistroNac(new TbtRegistroNac(contrato.getCod_reg_nac())); // Default : 1	
			}
			tcontratos.setDteFecInicio(getDate(contrato.getFec_inicio()));
			tcontratos.setDteFecFinal(getDate(contrato.getFec_final()));
			tcontratos.setChrNumContrato(contrato.getNum_contrato().trim());
			tcontratos.setChrTipContrato(contrato.getTip_contrato());
			tcontratos.setChrTipPago(contrato.getTip_pago());
			tcontratos.setChrNumComprobante(contrato.getNum_comprobante());
			tcontratos.setDteFecComprobante(getDate(contrato.getFec_comprobante()));	
			System.out.println(contrato.getSrlIdMoneda());
			tcontratos.setSrlIdMoneda(contrato.getSrlIdMoneda());
			tcontratos.setChrConcepto(contrato.getConcepto());
			
			tcontratos.setIntImpContrato(contrato.getNum_imp_contrato());
			
			tcontratos.setIntImpGarantia(contrato.getNum_imp_garantia());
			
			tcontratos.setIntImpAlquiler(contrato.getNum_imp_alquiler());
			
			tcontratos.setIntImpTributo(contrato.getNum_imp_tributo());
			
			tcontratos.setIntImpInteres(contrato.getNum_imp_interes());
			
			tcontratos.setChrTipOperacion(contrato.getChrTipOperacion());
			if (!isNullInteger(codigo)) {
				tcontratos.setChrCodUsuaModifica(contrato.getVnomusuario());
				tcontratos.setDteFecModifica(Calendar.getInstance().getTime());
				update(tcontratos);	
				DetalleContratosBean detalleBuscar = new DetalleContratosBean();
				detalleBuscar.setCod_contrato(codigo);
				List<DetalleContratosBean> listaDetContrato = listarDetalleContrato(detalleBuscar);
				for (DetalleContratosBean detEliminar : listaDetContrato) {		
					TDetalleContratos tDetalleElimina = (TDetalleContratos) getById(TDetalleContratos.class, detEliminar.getCod_detalle());
					tDetalleElimina.setIntIdfRegistro(Constantes.ESTADO_ELIMINADO);
					tDetalleElimina.setChrCodUsuaModifica(contrato.getVnomusuario());
					tDetalleElimina.setDteFecModifica(Calendar.getInstance().getTime());
					update(tDetalleElimina);
				}
			} else {
				tcontratos.setIntIdfRegistro(Constantes.ESTADO_ACTIVO);
				tcontratos.setChrCodUsuaCreacion(contrato.getVnomusuario());
				tcontratos.setDteFecCreacion(Calendar.getInstance().getTime());
				codigo = getByIdSave(tcontratos);
			}
			
			for (DetalleContratosBean det : detalle) {		
				TDetalleContratos tdetalleContratos = new TDetalleContratos();					
				tdetalleContratos.setTContratos(tcontratos);	
				tdetalleContratos.setNumMes(det.getMes());
				tdetalleContratos.setNumImpPago(det.getMonto_mes());
				tdetalleContratos.setDteFecPago(getDate(det.getFec_pago()));
				tdetalleContratos.setChrNumCompPago(det.getChrNumCompPago());
				tdetalleContratos.setDteFecCompPago(getDate(det.getDteFecCompPago()));
				tdetalleContratos.setChrCodUsuaCreacion(contrato.getVnomusuario());
				tdetalleContratos.setDteFecCreacion(Calendar.getInstance().getTime());
				tdetalleContratos.setIntIdfRegistro(Constantes.ESTADO_ACTIVO);
				save(tdetalleContratos);
			}		
		} catch (Exception e) {
			throw new Exception(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(), 
								Constantes.NIVEL_APP_DAO, 
								this.getClass().getName(), e.getMessage()));
		}
		return codigo;
	}

	/* (non-Javadoc)
	 * @see pe.com.mig.dao.IContratosDao#eliminarContrato(pe.com.mig.model.bean.ContratosBean)
	 */
	@Transactional
	@Override
	public void eliminarContrato(ContratosBean contrato) throws Exception {
		try {
			TContratos tcontratos = new TContratos(); 
			tcontratos = (TContratos) getById(TContratos.class, contrato.getCod_contrato());			
			tcontratos.setIntIdfRegistro(Constantes.ESTADO_ELIMINADO);
			tcontratos.setChrCodUsuaModifica(contrato.getVnomusuario());
			tcontratos.setDteFecModifica(Calendar.getInstance().getTime());
			DetalleContratosBean detalleBuscar = new DetalleContratosBean();
			detalleBuscar.setCod_contrato(contrato.getCod_contrato());
			List<DetalleContratosBean> listaDetContrato = listarDetalleContrato(detalleBuscar);
			for (DetalleContratosBean detEliminar : listaDetContrato) {		
				TDetalleContratos tDetalleElimina = (TDetalleContratos) getById(TDetalleContratos.class, detEliminar.getCod_detalle());
				tDetalleElimina.setIntIdfRegistro(Constantes.ESTADO_ELIMINADO);
				tDetalleElimina.setChrCodUsuaModifica(contrato.getVnomusuario());
				tDetalleElimina.setDteFecModifica(Calendar.getInstance().getTime());
				update(tDetalleElimina);
			}
			update(tcontratos);
		} catch (Exception e) {
			throw new Exception(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(), 
								Constantes.NIVEL_APP_DAO, 
								this.getClass().getName(), e.getMessage()));
		}
	}
	/* (non-Javadoc)
	 * @see pe.com.mig.dao.IContratosDao#listarDetalleContrato(pe.com.mig.model.bean.DetalleContratosBean)
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<DetalleContratosBean> listarDetalleContrato(DetalleContratosBean detalle) throws Exception {
		try {
			StringBuilder hql = new StringBuilder();			
			hql.append("select tco.srlIdContrato as cod_contrato, ");
			hql.append("tdet.srlIdDetalle as cod_detalle, ");	
			hql.append("tdet.numMes as mes, ");	
			hql.append("tdet.numImpPago as monto_mes, ");	
			hql.append("case ");
			hql.append("when (tdet.dteFecPago is not null) then to_char(tdet.dteFecPago, 'DD/MM/YYYY') ");
			hql.append("else '' end as fec_pago, ");	
			hql.append("tdet.chrNumCompPago as chrNumCompPago ");	
			hql.append("from TDetalleContratos tdet ");		
			hql.append("inner join tdet.TContratos tco ");
			hql.append("where tdet.intIdfRegistro = :int_id_registro ");
			if (!isNullInteger(detalle.getCod_contrato())) {
				hql.append("and tco.srlIdContrato = :cod_contrato ");
			}
			hql.append("order by tco.chrNumContrato");	
			Query query = super.getSession().createQuery(hql.toString());
			query.setParameter("int_id_registro", Constantes.ESTADO_ACTIVO);
			if (!isNullInteger(detalle.getCod_contrato())) {
				query.setParameter("cod_contrato", detalle.getCod_contrato());
			}
			return query.setResultTransformer(Transformers.aliasToBean(DetalleContratosBean.class)).list();		
		} catch (Exception e) {
			throw new Exception(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(), 
								Constantes.NIVEL_APP_DAO, 
								this.getClass().getName(), e.getMessage()));
		}
	}

}
