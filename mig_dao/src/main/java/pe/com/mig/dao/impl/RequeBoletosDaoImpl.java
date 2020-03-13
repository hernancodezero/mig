package pe.com.mig.dao.impl;

import java.util.Calendar;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.com.mig.dao.IRequeBoletosDao;
import pe.com.mig.model.bean.DetalleBoletosBean;
import pe.com.mig.model.bean.EntregaBoletosBean;
import pe.com.mig.model.bean.RequeBoletosBean;
import pe.com.mig.model.entity.TDetalleBoleto;
import pe.com.mig.model.entity.TEntregaBoleto;
import pe.com.mig.model.entity.TRequeBoletos;
import pe.com.mig.model.entity.TTariBoleto;
import pe.com.mig.model.entity.sde.TbtRegistroNac;
import pe.com.mig.model.entity.sernanp.Unidadoperativa;
import pe.com.mig.util.Constantes;

/**
 * @className: RequeBoletosDaoImpl.java
 * @description: 
 * @date: 18 de jul. de 2016
 * @author: SUMERIO.
 */
@Repository
public class RequeBoletosDaoImpl extends GenericDaoImpl implements IRequeBoletosDao {

	private static final long serialVersionUID = 1L;

	/* (non-Javadoc)
	 * @see pe.com.mig.dao.IRequeBoletosDao#listarRequeBoletos(pe.com.mig.model.bean.RequeBoletosBean)
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<RequeBoletosBean> listarRequeBoletos(RequeBoletosBean boleto) throws Exception {
		try {
			StringBuilder hql = new StringBuilder();			
			hql.append("select trb.srlIdRboleto as cod_req_boleto, ");
			hql.append("uni.idunidad as cod_uni_operativa, uni.nomunidad as des_uni_operativa, ");
			hql.append("reg.idRanac as cod_reg_nac, reg.nombre as des_reg_nac, ");			
			hql.append("trb.chrNumDocu as num_docu, ");
			hql.append("to_char(trb.dteFecDocumento, 'DD/MM/YYYY') as fec_documento, ");		
			hql.append("trb.chrCodUsuaCreacion as mnt_usu_creacion, ");			
			hql.append("to_char(trb.dteFecCreacion, 'DD/MM/YYYY') as mnt_fec_creacion, ");
			hql.append("trb.chrCodUsuaModifica as mnt_usu_modificacion, ");
			hql.append("to_char(trb.dteFecModifica, 'DD/MM/YYYY') as mnt_fec_modificacion ");
			if (!isNullInteger(boleto.getInd_detalle())) {
				hql.append(",(select sum(tidb.numCntBoleto) ");				
				hql.append("from TDetalleBoleto tidb ");
				hql.append("inner join tidb.TRequeBoletos tirb ");
				hql.append("where tirb.srlIdRboleto = trb.srlIdRboleto ");
				hql.append("and tidb.intIdfRegistro = :int_id_registro) as num_can_boleto ");				
			}
			hql.append("from TRequeBoletos trb ");
			hql.append("inner join trb.unidadoperativa uni ");
			hql.append("inner join trb.tbtRegistroNac reg ");
			hql.append("where trb.intIdfRegistro = :int_id_registro ");
			if (!isNullInteger(boleto.getCod_req_boleto())) {
				hql.append("and trb.srlIdRboleto = :cod_req_boleto ");
			}			
			if (!isNullInteger(boleto.getCod_uni_operativa())) {
				hql.append("and uni.idunidad = :cod_uni_operativa ");
			}
			if (!isNullInteger(boleto.getCod_reg_nac())) {
				hql.append("and reg.idRanac = :cod_reg_nac ");
			}			
			if (!isNullOrEmpty(boleto.getFec_ini()) && !isNullOrEmpty(boleto.getFec_fin())) {
				hql.append("and trb.dteFecDocumento between :fec_ini and :fec_fin ");
			}
			if (!isNullOrEmpty(boleto.getNum_docu())) {
				hql.append("and trb.chrNumDocu = :num_docu ");
			}
			hql.append("order by trb.srlIdRboleto");
			Query query = super.getSession().createQuery(hql.toString());
			query.setParameter("int_id_registro", Constantes.ESTADO_ACTIVO);
			if (!isNullInteger(boleto.getCod_req_boleto())) {
				query.setParameter("cod_req_boleto", boleto.getCod_req_boleto());
			}
			if (!isNullInteger(boleto.getCod_uni_operativa())) {
				query.setParameter("cod_uni_operativa", boleto.getCod_uni_operativa());
			}
			if (!isNullInteger(boleto.getCod_reg_nac())) {
				query.setParameter("cod_reg_nac", boleto.getCod_reg_nac());
			}
			if (!isNullOrEmpty(boleto.getFec_ini()) && !isNullOrEmpty(boleto.getFec_fin())) {
				query.setParameter("fec_ini", getDate(boleto.getFec_ini()));
				query.setParameter("fec_fin", getDate(boleto.getFec_fin()));
			}
			if (!isNullOrEmpty(boleto.getNum_docu())) {
				query.setParameter("num_docu", boleto.getNum_docu());
			}
			return query.setResultTransformer(Transformers.aliasToBean(RequeBoletosBean.class)).list();		
		} catch (Exception e) {
			throw new Exception(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(), 
								Constantes.NIVEL_APP_DAO, 
								this.getClass().getName(), e.getMessage()));
		}
	}

	/* (non-Javadoc)
	 * @see pe.com.mig.dao.IRequeBoletosDao#listarDetalleBoletos(pe.com.mig.model.bean.DetalleBoletosBean)
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<DetalleBoletosBean> listarDetalleBoletos(DetalleBoletosBean detalle) throws Exception {
		try {
			StringBuilder hql = new StringBuilder();			
			hql.append("select tdb.srlIdDboleto as cod_det_boleto, ");
			hql.append("trb.srlIdRboleto as cod_req_boleto, ");
			hql.append("to_char(trb.dteFecDocumento, 'DD/MM/YYYY') as fec_documento, ");	
			hql.append("ttb.srlIdBoleto as cod_tar_boleto, ");
			hql.append("ttb.intNumSerie as num_serie, ttb.chrNomBoleto as nom_boleto, ");	
			hql.append("case ttb.intIdfTarifa when 1 then 'Tarifa Plana' ");
			hql.append("when 2 then 'Tarifa Social' ");
			hql.append("when 3 then 'Tarifa Promocion' end as des_ind_tarifa, ");
			hql.append("tdb.numCntBoleto as num_can_boleto, tdb.numInicio as num_inicio, ");
			hql.append("tdb.numFinal as num_final, ");
			hql.append("tdb.chrCodUsuaCreacion as mnt_usu_creacion, ");			
			hql.append("to_char(tdb.dteFecCreacion, 'DD/MM/YYYY') as mnt_fec_creacion, ");
			hql.append("tdb.chrCodUsuaModifica as mnt_usu_modificacion, ");
			hql.append("to_char(tdb.dteFecModifica, 'DD/MM/YYYY') as mnt_fec_modificacion ");	
			hql.append("from TDetalleBoleto tdb ");
			hql.append("inner join tdb.TRequeBoletos trb ");
			hql.append("inner join tdb.TTariBoleto ttb ");
			hql.append("where tdb.intIdfRegistro = :int_id_registro ");
			if (!isNullInteger(detalle.getCod_req_boleto())) {
				hql.append("and trb.srlIdRboleto = :cod_req_boleto ");
			}			
			hql.append("order by tdb.srlIdDboleto");
			Query query = super.getSession().createQuery(hql.toString());
			query.setParameter("int_id_registro", Constantes.ESTADO_ACTIVO);
			if (!isNullInteger(detalle.getCod_req_boleto())) {
				query.setParameter("cod_req_boleto", detalle.getCod_req_boleto());
			}
			return query.setResultTransformer(Transformers.aliasToBean(DetalleBoletosBean.class)).list();		
		} catch (Exception e) {
			throw new Exception(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(), 
								Constantes.NIVEL_APP_DAO, 
								this.getClass().getName(), e.getMessage()));
		}
	}

	/* (non-Javadoc)
	 * @see pe.com.mig.dao.IRequeBoletosDao#listarEntregaBoletos(pe.com.mig.model.bean.EntregaBoletosBean)
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<EntregaBoletosBean> listarEntregaBoletos(EntregaBoletosBean entrega) throws Exception {
		try {
			StringBuilder hql = new StringBuilder();			
			hql.append("select teb.srlIdSalida as cod_ent_boleto, ");
			hql.append("tdb.srlIdDboleto as cod_det_boleto, ");
			hql.append("ttb.srlIdBoleto as cod_tar_boleto, ttb.intNumSerie as num_serie,");
			hql.append("teb.chrNumActa as num_acta, ");
			hql.append("to_char(teb.dteFecActa, 'DD/MM/YYYY') as fec_acta, ");
			hql.append("teb.numCntBoleto as num_can_boleto, teb.numInicio as num_inicio, ");
			hql.append("teb.numFinal as num_final, ");			
		//	hql.append("(tdb.numCntBoleto - teb.numCntBoleto) as can_sal_bol, ");			
			hql.append("teb.chrCodUsuaCreacion as mnt_usu_creacion, ");			
			hql.append("to_char(teb.dteFecCreacion, 'DD/MM/YYYY') as mnt_fec_creacion, ");
			hql.append("teb.chrCodUsuaModifica as mnt_usu_modificacion, ");
			hql.append("to_char(teb.dteFecModifica, 'DD/MM/YYYY') as mnt_fec_modificacion ");	
			hql.append("from TEntregaBoleto teb ");
			hql.append("inner join teb.TDetalleBoleto tdb ");
			hql.append("inner join tdb.TTariBoleto ttb ");
			hql.append("where teb.intIdfRegistro = :int_id_registro ");
			if (!isNullInteger(entrega.getCod_det_boleto())) {
				hql.append("and tdb.srlIdDboleto = :cod_det_boleto ");
			}			
			hql.append("order by teb.srlIdSalida");
			Query query = super.getSession().createQuery(hql.toString());
			query.setParameter("int_id_registro", Constantes.ESTADO_ACTIVO);
			if (!isNullInteger(entrega.getCod_det_boleto())) {
				query.setParameter("cod_det_boleto", entrega.getCod_det_boleto());
			}
			return query.setResultTransformer(Transformers.aliasToBean(EntregaBoletosBean.class)).list();		
		} catch (Exception e) {
			throw new Exception(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(), 
								Constantes.NIVEL_APP_DAO, 
								this.getClass().getName(), e.getMessage()));
		}
	}

	/* (non-Javadoc)
	 * @see pe.com.mig.dao.IRequeBoletosDao#grabarRequeBoletos(pe.com.mig.model.bean.RequeBoletosBean, java.util.List, java.util.List)
	 */
	@Transactional
	@Override
	public Integer grabarRequeBoletos(RequeBoletosBean boleto, List<DetalleBoletosBean> detalle, List<EntregaBoletosBean> entrega) throws Exception {
		Integer codigo = boleto.getCod_req_boleto();
		try {		
			TRequeBoletos trequeboletos = new TRequeBoletos();
			if (!isNullInteger(codigo)) {				
				trequeboletos = (TRequeBoletos) getById(TRequeBoletos.class, codigo);
			}
			trequeboletos.setUnidadoperativa(new Unidadoperativa(boleto.getCod_uni_operativa()));
			trequeboletos.setTbtRegistroNac(new TbtRegistroNac(boleto.getCod_reg_nac()));
			trequeboletos.setChrNumDocu(boleto.getNum_docu());
			trequeboletos.setDteFecDocumento(getDate(boleto.getFec_documento()));
			
			if (!isNullInteger(codigo)) {
				// Eliminamos logicamente el detalle anterior
				List<DetalleBoletosBean> lista = listarDetalleBoletos(new DetalleBoletosBean(codigo));
				for (DetalleBoletosBean det : lista) {
					TDetalleBoleto tdetalleboleto = new TDetalleBoleto();
					tdetalleboleto.setSrlIdDboleto(det.getCod_det_boleto());
					tdetalleboleto.setTRequeBoletos(new TRequeBoletos(codigo));
					tdetalleboleto.setTTariBoleto(new TTariBoleto(det.getCod_tar_boleto()));					
					tdetalleboleto.setNumCntBoleto(det.getNum_can_boleto());
					tdetalleboleto.setNumInicio(det.getNum_inicio());
					tdetalleboleto.setNumFinal(det.getNum_final());
					tdetalleboleto.setChrCodUsuaCreacion(det.getMnt_usu_creacion());
					tdetalleboleto.setDteFecCreacion(getDate(det.getMnt_fec_creacion()));
					tdetalleboleto.setIntIdfRegistro(Constantes.ESTADO_ELIMINADO);
					tdetalleboleto.setChrCodUsuaModifica(boleto.getVnomusuario());
					tdetalleboleto.setDteFecModifica(Calendar.getInstance().getTime());
					update(tdetalleboleto);
					
					List<EntregaBoletosBean> lis_entrega = listarEntregaBoletos(new EntregaBoletosBean(det.getCod_det_boleto()));
					for (EntregaBoletosBean ent : lis_entrega) {
						TEntregaBoleto tentregaboleto = new TEntregaBoleto();
						tentregaboleto.setSrlIdSalida(ent.getCod_ent_boleto());
						tentregaboleto.setTDetalleBoleto(new TDetalleBoleto(ent.getCod_det_boleto()));
						tentregaboleto.setChrNumActa(ent.getNum_acta());
						tentregaboleto.setDteFecActa(getDate(ent.getFec_acta()));						
						tentregaboleto.setNumCntBoleto(ent.getNum_can_boleto());
						tentregaboleto.setNumInicio(ent.getNum_inicio());
						tentregaboleto.setNumFinal(ent.getNum_final());
						tentregaboleto.setChrCodUsuaCreacion(ent.getMnt_usu_creacion());
						tentregaboleto.setDteFecCreacion(getDate(ent.getMnt_fec_creacion()));
						tentregaboleto.setIntIdfRegistro(Constantes.ESTADO_ELIMINADO);
						tentregaboleto.setChrCodUsuaModifica(boleto.getVnomusuario());
						tentregaboleto.setDteFecModifica(Calendar.getInstance().getTime());
						update(tentregaboleto);
					}
				}
				
				trequeboletos.setChrCodUsuaModifica(boleto.getVnomusuario());
				trequeboletos.setDteFecModifica(Calendar.getInstance().getTime());
				update(trequeboletos);			
			} else {
				trequeboletos.setIntIdfRegistro(Constantes.ESTADO_ACTIVO);
				trequeboletos.setChrCodUsuaCreacion(boleto.getVnomusuario());
				trequeboletos.setDteFecCreacion(Calendar.getInstance().getTime());
				codigo = getByIdSave(trequeboletos);
			}
			// Grabamos los detalles de requerimientos de boletos
			for (DetalleBoletosBean det : detalle) {		
				TDetalleBoleto tdetalleboleto = new TDetalleBoleto();					
				tdetalleboleto.setTRequeBoletos(new TRequeBoletos(codigo));
				tdetalleboleto.setTTariBoleto(new TTariBoleto(det.getCod_tar_boleto()));					
				tdetalleboleto.setNumCntBoleto(det.getNum_can_boleto());
				tdetalleboleto.setNumInicio(det.getNum_inicio());
				tdetalleboleto.setNumFinal(det.getNum_final());				
				tdetalleboleto.setChrCodUsuaCreacion(det.getVnomusuario());
				tdetalleboleto.setDteFecCreacion(Calendar.getInstance().getTime());
				tdetalleboleto.setIntIdfRegistro(Constantes.ESTADO_ACTIVO);
				
				Integer cod_detalle = getByIdSave(tdetalleboleto);
				
				// Grabamos las entregas de boletos
				for (EntregaBoletosBean ent : entrega) {
					if (ent.getCod_tar_boleto().equals(det.getCod_tar_boleto())) {					
						TEntregaBoleto tentregaboleto = new TEntregaBoleto();					
						tentregaboleto.setTDetalleBoleto(new TDetalleBoleto(cod_detalle));					
						tentregaboleto.setChrNumActa(ent.getNum_acta());
						tentregaboleto.setDteFecActa(getDate(ent.getFec_acta()));					
						tentregaboleto.setNumCntBoleto(ent.getNum_can_boleto());
						tentregaboleto.setNumInicio(ent.getNum_inicio());
						tentregaboleto.setNumFinal(ent.getNum_final());				
						tentregaboleto.setChrCodUsuaCreacion(ent.getVnomusuario());
						tentregaboleto.setDteFecCreacion(Calendar.getInstance().getTime());
						tentregaboleto.setIntIdfRegistro(Constantes.ESTADO_ACTIVO);
						save(tentregaboleto);
					}
				}
				
				// Validamos boletos entregados
				if (!isNullInteger(det.getCan_adi_boleto())) {
					actualizarTarifaBoleto(det);
				}				
			}
		} catch (Exception e) {
			throw new Exception(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(), 
								Constantes.NIVEL_APP_DAO, 
								this.getClass().getName(), e.getMessage()));
		}
		return codigo;
	}

	/* (non-Javadoc)
	 * @see pe.com.mig.dao.IRequeBoletosDao#eliminarRequeBoletos(pe.com.mig.model.bean.RequeBoletosBean)
	 */
	@Transactional
	@Override
	public void eliminarRequeBoletos(RequeBoletosBean boleto) throws Exception {
		try {
			TRequeBoletos trequeboletos = new TRequeBoletos(); 
			trequeboletos = (TRequeBoletos) getById(TRequeBoletos.class, boleto.getCod_req_boleto());			
			trequeboletos.setIntIdfRegistro(Constantes.ESTADO_ELIMINADO);
			trequeboletos.setChrCodUsuaModifica(boleto.getVnomusuario());
			trequeboletos.setDteFecModifica(Calendar.getInstance().getTime());
			update(trequeboletos);
		} catch (Exception e) {
			throw new Exception(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(), 
								Constantes.NIVEL_APP_DAO, 
								this.getClass().getName(), e.getMessage()));
		}
	}

	/* (non-Javadoc)
	 * @see pe.com.mig.dao.IRequeBoletosDao#actualizarTarifaBoleto(pe.com.mig.model.bean.DetalleBoletosBean)
	 */
	@Transactional
	@Override
	public void actualizarTarifaBoleto(DetalleBoletosBean detalle) throws Exception {
		try {
			TTariBoleto ttariboleto = new TTariBoleto(); 
			ttariboleto = (TTariBoleto) getById(TTariBoleto.class, detalle.getCod_tar_boleto());			
			Integer can_ing_actual = ttariboleto.getNumCntIngreso();
			if (isNullInteger(can_ing_actual)) {
				can_ing_actual = Constantes.ZERO_INT;
			}
			ttariboleto.setNumCntIngreso(can_ing_actual + detalle.getCan_adi_boleto());
			Integer can_sto_actual = ttariboleto.getNumCntStock();	
			if (isNullInteger(can_sto_actual)) {
				can_sto_actual = Constantes.ZERO_INT;
			}
			ttariboleto.setNumCntStock(can_sto_actual + detalle.getCan_adi_boleto());			
			ttariboleto.setChrCodUsuaModifica(detalle.getVnomusuario());
			ttariboleto.setDteFecModifica(Calendar.getInstance().getTime());
			update(ttariboleto);
		} catch (Exception e) {
			throw new Exception(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(), 
								Constantes.NIVEL_APP_DAO, 
								this.getClass().getName(), e.getMessage()));
		}
	}

}
