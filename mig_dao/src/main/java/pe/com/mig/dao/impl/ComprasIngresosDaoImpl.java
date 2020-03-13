package pe.com.mig.dao.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.com.mig.dao.IComprasIngresosDao;
import pe.com.mig.dao.IMaestroDao;
import pe.com.mig.model.bean.CierreMesBean;
import pe.com.mig.model.bean.ComprasIngresosBean;
import pe.com.mig.model.bean.DetalleComprasBean;
import pe.com.mig.model.bean.DetalleIngresosBean;
import pe.com.mig.model.bean.DetalleOtrosBean;
import pe.com.mig.model.bean.DetalleVoucherBean;
import pe.com.mig.model.bean.ProductoBean;
import pe.com.mig.model.bean.ProveedorBean;
import pe.com.mig.model.bean.ReporteDetalleComprasBean;
import pe.com.mig.model.bean.ReporteDetalleIngresosBean;
import pe.com.mig.model.bean.SeriesBean;
import pe.com.mig.model.bean.SucursalBean;
import pe.com.mig.model.bean.TarifaBoletoBean;
import pe.com.mig.model.bean.TarifaServicioBean;
import pe.com.mig.model.bean.TarifaTupaBean;
import pe.com.mig.model.bean.TransferenciaBean;
import pe.com.mig.model.entity.TComprasIngresos;
import pe.com.mig.model.entity.TContratos;
import pe.com.mig.model.entity.TCuentaContable;
import pe.com.mig.model.entity.TDetalleCompras;
import pe.com.mig.model.entity.TDetalleIngresos;
import pe.com.mig.model.entity.TDetalleVoucher;
import pe.com.mig.model.entity.TDireccionFactura;
import pe.com.mig.model.entity.TFteFto;
import pe.com.mig.model.entity.TMedioPago;
import pe.com.mig.model.entity.TOtros;
import pe.com.mig.model.entity.TPersonalCuarta;
import pe.com.mig.model.entity.TProducto;
import pe.com.mig.model.entity.TSeries;
import pe.com.mig.model.entity.TSucursal;
import pe.com.mig.model.entity.TTariBoleto;
import pe.com.mig.model.entity.TTariServicio;
import pe.com.mig.model.entity.TTariTupa;
import pe.com.mig.model.entity.TTipoComprobante;
import pe.com.mig.model.entity.TTipoMoneda;
import pe.com.mig.model.entity.TTipoProveedor;
import pe.com.mig.model.entity.sde.TbtRegistroNac;
import pe.com.mig.model.entity.sernanp.Unidadoperativa;
import pe.com.mig.model.entity.sppi.TEspecifica;
import pe.com.mig.util.Constantes;
import pe.com.mig.util.DateUtil;
import pe.com.mig.util.ReadParameterProperties;

/**
 * @className: ComprasIngresosDaoImpl.java
 * @description: 
 * @date: 14 de jun. de 2016
 * @author: SUMERIO.
 */
@Repository
public class ComprasIngresosDaoImpl extends GenericDaoImpl implements IComprasIngresosDao {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private IMaestroDao iMaestroDao;
	
	/* (non-Javadoc)
	 * @see pe.com.mig.dao.ICompraDao#listarCompras(pe.com.mig.model.bean.ComprasBean)
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<ComprasIngresosBean> listarComprasSerie(ComprasIngresosBean serie) throws Exception {
		try {
			StringBuilder hql = new StringBuilder();			
			hql.append("select distinct tci.TSeries as cod_serie ");
			hql.append("from TComprasIngresos tci; Tserie tss ");
			hql.append("where tci.intIdfRegistro = :int_id_registro ");
			hql.append("and tci.TSeries = tss.srl_id_serie ");

			if (!isNullInteger(serie.getCod_serie())) {
				hql.append("and tci.srlIdCompras =: compra ");
			}
			hql.append("order by tci.srlIdCompras");
			
			Query query = super.getSession().createQuery(hql.toString());
			query.setParameter("int_id_registro", Constantes.ESTADO_ACTIVO);

			if (!isNullInteger(serie.getCod_serie())) {
				query.setParameter("cod_serie", serie.getInt_transaccion());
			}
			return query.setResultTransformer(Transformers.aliasToBean(ComprasIngresosBean.class)).list();		
		} catch (Exception e) {
			throw new Exception(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(), 
								Constantes.NIVEL_APP_DAO, 
								this.getClass().getName(), e.getMessage()));
		}
	}


	/* (non-Javadoc)
	 * @see pe.com.mig.dao.ICompraDao#listarCompras(pe.com.mig.model.bean.ComprasBean)
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<ComprasIngresosBean> listarNotasRet(ComprasIngresosBean compra) throws Exception {
		try {
			StringBuilder hql = new StringBuilder();			
			hql.append("select distinct tci.TSeries as cod_serie ");
			hql.append("from TComprasIngresos tci; Tserie tss ");
			hql.append("where tci.intIdfRegistro = :int_id_registro ");
			hql.append("and tci.TSeries = tss.srl_id_serie ");
			
			if (!isNullInteger(compra.getInt_transaccion())) {
				hql.append("and tci.intIdfTransaccion = :int_transaccion ");
			}
			if (!isNullInteger(compra.getCod_mes())) {
				hql.append("and tci.intMes = :cod_mes ");
			}	
			if (!isNullInteger(compra.getCod_anno())) {
				hql.append("and tci.intAnno = :cod_anno ");
			}			
			hql.append("order by tci.srlIdCompras");
			
			Query query = super.getSession().createQuery(hql.toString());
			query.setParameter("int_id_registro", Constantes.ESTADO_ACTIVO);

			if (!isNullInteger(compra.getInt_transaccion())) {
				query.setParameter("int_transaccion", compra.getInt_transaccion());
			}
			if (!isNullInteger(compra.getCod_mes())) {
				query.setParameter("cod_mes", compra.getCod_mes());
			}
			if (!isNullInteger(compra.getCod_anno())) {
				query.setParameter("cod_anno", compra.getCod_anno());
			}
			return query.setResultTransformer(Transformers.aliasToBean(ComprasIngresosBean.class)).list();		
		} catch (Exception e) {
			throw new Exception(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(), 
								Constantes.NIVEL_APP_DAO, 
								this.getClass().getName(), e.getMessage()));
		}
	}
	/* (non-Javadoc)
	 * @see pe.com.mig.dao.ICompraDao#listarCompras(pe.com.mig.model.bean.ComprasBean)
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<ComprasIngresosBean> listarCompras(ComprasIngresosBean compra) throws Exception {
		try {
			StringBuilder hql = new StringBuilder();			
			hql.append("select tci.srlIdCompras as cod_com_ingresos, ");	
			hql.append("ttc.srlIdComprobante as cod_comprobante, ttc.chrNomComprobante as tip_comprobante, ");
			hql.append("ttc.chrSiglas as tip_com_siglas, ttc.chrCodComprobante as vcod_comprobante, ");
			hql.append("ttm.srlIdMoneda as cod_moneda, ttm.chrNomMoneda as tip_moneda, ");	
			hql.append("ttp.srlIdProveedor as cod_proveedor, ttp.numRuc as num_ruc, ");			
			hql.append("ttp.chrTipProveedor as tip_proveedor, ttp.chrTipEstado as tip_estado, ");
			hql.append("ttp.chrRazSocial as raz_social, ttp.chrNombres as nombres, ");			
			hql.append("ttp.chrApePaterno as ape_paterno, ttp.chrApeMaterno as ape_materno, ");
			hql.append("case ");			
			hql.append("when (ttc.srlIdComprobante = 3 and tpc.numRuc is not null) then tpc.numRuc ");
			hql.append("when (ttc.srlIdComprobante != 3 and ttp.numRuc is not null) then cast(ttp.numRuc as string) ");
			hql.append("when (ttc.srlIdComprobante != 3 and ttp.chrNumDocumento is not null) then ttp.chrNumDocumento ");
			hql.append("else '' ");
			hql.append("end as ruc_nro_doc_prov, ");
			hql.append("case ");			
			hql.append("when (ttc.srlIdComprobante = 3 and trim(tpc.chrNombres) != '') then concat(tpc.chrNombres, ' ', tpc.chrApePaterno, ' ', tpc.chrApeMaterno) ");
			hql.append("when (ttc.srlIdComprobante != 3 and trim(ttp.chrRazSocial) != '') then ttp.chrRazSocial ");
			hql.append("when (ttc.srlIdComprobante != 3 and trim(ttp.chrNombres) != '') then concat(ttp.chrNombres, ' ', ttp.chrApePaterno, ' ', ttp.chrApeMaterno) ");
			hql.append("else '' ");
			hql.append("end as raz_soc_prov, ");
			hql.append("case ");			
			hql.append("when (tci.intIdfRegistro = 0) then 'ELIMINADO' ");
			hql.append("when (tci.intIdfRegistro = 1) then 'ACTIVO' ");
			hql.append("when (tci.intIdfRegistro = 2) then 'ANULADO' ");
			hql.append("end as estado, ");
			hql.append("ttp.chrNumDocumento as num_documento, ");
			hql.append("tci.srlIdCtaCte as cod_ctacte, ");
			hql.append("tff.srlIdFte as cod_fue_financiamiento, tff.chrNomFte as des_fue_financiamiento, ");
			hql.append("tdf.srlIdDirec as cod_dir_fact, tdf.chrDirec as nom_dir_fact, ");
			hql.append("tci.chrTipFact as ind_tip_fact, ");
			hql.append("tci.intIdfTransaccion as int_transaccion, trim(tci.chrSerComprobante) as ser_comprobante, ");
			hql.append("trim(tci.chrNumComprobante) as nro_comprobante, ");
			hql.append("to_char(tci.dteFecComprobante, 'DD/MM/YYYY') as fec_comprobante, ");			
			hql.append("tci.intNumSiaf as nro_siaf, ");
			hql.append("tci.numTipCambio as num_tip_cambio, tci.chrTipOperacion as tip_operacion, ");
			hql.append("trim(tci.chrNumDocuOperacion) as nro_doc_rc, ");
			hql.append("to_char(tci.dteFecDocoperacion, 'DD/MM/YYYY') as fec_doc_rc, ");			
			hql.append("tci.chrNumCompOperacion as nro_cp, tci.intNumSiafOperacion as nro_sia_operacion, ");
			hql.append("tci.numImpCompOperacion as imp_cp, tci.numImpTotal as imp_total, ");
			hql.append("tci.chrTipServicio as ind_ser_publico, tci.numImpServicio as mon_ser_publico, ");
			hql.append("to_char(tci.dteFecPagservicio, 'DD/MM/YYYY') as fec_pago, ");
			hql.append("to_char(tci.dteFecVtoservicio, 'DD/MM/YYYY') as fec_vto, ");			
			hql.append("trim(tci.chrNumConstancia) as num_constancia, tci.numImpDeposito as imp_deposito, ");
			hql.append("trim(tci.chrDesGlosa) as des_glosa, ");
			hql.append("to_char(tci.dteFecCondeposito, 'DD/MM/YYYY') as fec_pag_deposito, ");
			hql.append("tci.intPorDeposito as por_deposito, tci.intIdfRegistro as int_id_registro, ");
			hql.append("tco.srlIdContrato as cod_contrato, trim(tco.chrNumContrato) as num_contrato, ");			
			hql.append("to_char(tco.dteFecInicio, 'DD/MM/YYYY') as fec_inicio, ");
			hql.append("to_char(tco.dteFecFinal, 'DD/MM/YYYY') as fec_final, ");
			hql.append("tco.intImpContrato as num_imp_contrato, tco.intImpInteres as num_imp_interes, ");
			hql.append("uni.idunidad as cod_uni_operativa, uni.nomunidad as des_uni_operativa, ");
			hql.append("reg.idRanac as cod_reg_nac, reg.nombre as des_reg_nac, ");	
			hql.append("suc.srlIdSucur as cod_sucur, suc.chrDesSuc as des_sucur, ");
			hql.append("tmp.srlIdMedio as cod_med_pago, tmp.chrNomMedio as des_med_pago, ");			
			hql.append("tci.chrNumDocuEmpresa as num_doc_empresa, tci.chrNumDocuDerivacion as num_doc_derivacion, ");
			hql.append("to_char(tci.dteFecDocuEmpresa, 'DD/MM/YYYY') as fec_doc_empresa, ");
			hql.append("to_char(tci.dteFecDocuDerivacion, 'DD/MM/YYYY') as fec_doc_derivacion, ");
			hql.append("(current_date() - tci.dteFecComprobante) as can_dia_transcurridos, ");
			hql.append("tci.intCodPadComIngresos as cod_pad_com_ingresos, trim(tci.chrNumVoucher) as num_voucher, ");
			hql.append("to_char(tci.dteFecVoucher, 'DD/MM/YYYY') as fec_voucher, ");
			hql.append("tci.numImpVoucher as num_imp_voucher, tci.intMes as cod_mes,tci.intAnno as cod_anno, ");			
			hql.append("trim(tci.chrNumCtaCte) as num_cta_cte, tci.chrCodUsuaCreacion as mnt_usu_creacion, ");
			hql.append("trim(tci.chrNumCpGiro) as num_cp_giro, ");
			hql.append("tci.chrTipOrden as ind_tip_orden," );
			hql.append("to_char(tci.dteFecOrden, 'DD/MM/YYYY') as fec_orden, ");
			hql.append("trim(tci.chrNumOrden) as num_orden, ");
			hql.append("trim(tci.chrCpReten) as ind_cp_reten, ");
			hql.append("trim(tci.chrMedPago) as ind_med_pago, ");
			hql.append("to_char(tci.dteFecPagoCP, 'DD/MM/YYYY') as fec_pago_cp, ");
			hql.append("to_char(tci.dteFecCreacion, 'DD/MM/YYYY') as mnt_fec_creacion, ");
			hql.append("tci.chrCodUsuaModifica as mnt_usu_modificacion, ");
			hql.append("to_char(tci.dteFecModifica, 'DD/MM/YYYY') as mnt_fec_modificacion, ");			
			hql.append("tpc.srlIdPersonal as cod_personal, tpc.numRuc as num_ruc_personal, ");			
			hql.append("tpc.chrNombres as nom_personal, ");			
			hql.append("tpc.chrApePaterno as ape_pat_personal, tpc.chrApeMaterno as ape_mat_personal ");			
			hql.append("from TComprasIngresos tci ");			
			hql.append("inner join tci.TTipoComprobante ttc ");
			hql.append("inner join tci.TTipoMoneda ttm ");
			hql.append("inner join tci.TFteFto tff ");
			hql.append("left join tci.TTipoProveedor ttp ");
			hql.append("left join tci.TPersonalCuarta tpc ");
			hql.append("left join tci.TContratos tco ");
			hql.append("left join tci.TMedioPago tmp ");
			hql.append("left join tci.unidadoperativa uni ");
			hql.append("left join tci.tbtRegistroNac reg ");
			hql.append("left join tci.TSucursal suc ");
			hql.append("left join tci.TDireccionFactura tdf ");
			hql.append("where tci.intIdfRegistro = :int_id_registro ");
			//hql.append("where tci.intIdfRegistro in (0,1,2) ");
			int cod_rec_honorarios = getInteger(ReadParameterProperties.getPropiedad("codigo.comprobante.recibo.honorarios")).intValue();
			
			if (!isNullInteger(compra.getInt_transaccion())) {
				hql.append("and tci.intIdfTransaccion = :int_transaccion ");
			}
			if (!isNullInteger(compra.getCod_com_ingresos())) {
				hql.append("and tci.srlIdCompras = :cod_com_ingresos ");
			}			
			if (!isNullOrEmpty(compra.getTip_operacion())) {
				hql.append("and tci.chrTipOperacion = :tip_operacion "); 
			}	
			if (!isNullOrEmpty(compra.getRaz_soc_prov())) {
				hql.append("and ttp.chrRazSocial LIKE :raz_soc_prov "); 
				//hql.append("and ttp.chrRazSocial =:raz_social ");
			}			
			if (!isNullOrEmpty(compra.getNro_doc_rc())) {
				hql.append("and trim(tci.chrNumDocuOperacion) =:nro_doc_rc "); 
				//hql.append("and ttp.chrRazSocial =:raz_social ");
			}			
			
			if (!isNullInteger(compra.getCod_comprobante())) {  
				hql.append("and ttc.srlIdComprobante = :cod_comprobante "); //Tipo de Comprobante
			}			
			if (!isNullInteger(compra.getCod_uni_operativa())) {
				hql.append("and uni.idunidad = :cod_uni_operativa ");
			}
			if (!isNullInteger(compra.getCod_reg_nac())) {
				hql.append("and reg.idRanac = :cod_reg_nac ");
			}
			if (!isNullInteger(compra.getCod_sucur())) {
				hql.append("and suc.srlIdSucur = :cod_sucur ");
			}			
			if (!isNullOrEmpty(compra.getSer_comprobante())) { //Serie Comprobante
				hql.append("and tci.chrSerComprobante = :ser_comprobante ");
			}
			if (!isNullOrEmpty(compra.getNro_comprobante())) { //Nro Comprobante
				hql.append("and trim(tci.chrNumComprobante) = :nro_comprobante ");
			}			
			if (!isNullInteger(compra.getNro_siaf())) {
				hql.append("and tci.intNumSiaf = :nro_siaf ");
			}
			if (!isNullLong(compra.getNum_ruc())) {
				if (!isNullInteger(compra.getCod_comprobante())) {
					if (cod_rec_honorarios == compra.getCod_comprobante().intValue()) { // Recibo por Honorarios
						hql.append("and tpc.numRuc = :num_ruc ");
					} else {
						// hql.append("and (ttp.numRuc = :num_ruc or trim(ttp.chrNumDocumento) = :num_ruc) ");
						hql.append("and ttp.numRuc = :num_ruc ");
					}
				} else {
					// hql.append("and (ttp.numRuc = :num_ruc or trim(ttp.chrNumDocumento) = :num_ruc) ");
					hql.append("and ttp.numRuc = :num_ruc ");
				}
			}
			if (!isNullOrEmpty(compra.getFec_desde()) && !isNullOrEmpty(compra.getFec_hasta())) {
				hql.append("and tci.dteFecComprobante between :fechaInicio and :fechaFin ");
			}			
			if (!isNullOrEmpty(compra.getNro_cp())) {
				hql.append("and trim(tci.chrNumCompOperacion) = :nro_cp ");
			}
			if (!isNullOrEmpty(compra.getNro_comprobante())) {
				hql.append("and trim(tci.chrNumComprobante) = :nro_comprobante ");
			}			
			if (!isNullInteger(compra.getNro_sia_operacion())) {
				hql.append("and tci.intNumSiafOperacion = :nro_sia_operacion ");
			}
			if (!isNullInteger(compra.getCod_proveedor())) {
				hql.append("and ttp.srlIdProveedor = :cod_proveedor ");
			}
			if (!isNullInteger(compra.getCod_personal())) {
				hql.append("and tpc.srlIdPersonal = :cod_personal ");
			}
			if (!isNullInteger(compra.getInd_not_credito())) {
				hql.append("and tci.intCodPadComIngresos = 0 ");
			}
			if (!isNullInteger(compra.getCod_mes())) {
				hql.append("and tci.intMes = :cod_mes ");
			}	
			if (!isNullInteger(compra.getCod_anno())) {
				hql.append("and tci.intAnno = :cod_anno ");
			}			
			hql.append("order by tci.srlIdCompras");	
			
			Query query = super.getSession().createQuery(hql.toString());
			query.setParameter("int_id_registro", Constantes.ESTADO_ACTIVO);

			if (!isNullInteger(compra.getInt_transaccion())) {
				query.setParameter("int_transaccion", compra.getInt_transaccion());
			}
			if (!isNullInteger(compra.getCod_com_ingresos())) {
				query.setParameter("cod_com_ingresos", compra.getCod_com_ingresos());
			}
			if (!isNullOrEmpty(compra.getTip_operacion())) {
				query.setParameter("tip_operacion", compra.getTip_operacion());
			}
			if (!isNullOrEmpty(compra.getRaz_soc_prov())) {
				query.setParameter("raz_soc_prov", compra.getRaz_soc_prov());
			}
			if (!isNullOrEmpty(compra.getNro_doc_rc())) {
				query.setParameter("nro_doc_rc", compra.getNro_doc_rc());
			}
			if (!isNullInteger(compra.getCod_comprobante())) {
				query.setParameter("cod_comprobante", compra.getCod_comprobante());
			}
			if (!isNullInteger(compra.getCod_uni_operativa())) {
				query.setParameter("cod_uni_operativa", compra.getCod_uni_operativa());
			}
			if (!isNullInteger(compra.getCod_reg_nac())) {
				query.setParameter("cod_reg_nac", compra.getCod_reg_nac());
			}
			if (!isNullOrEmpty(compra.getSer_comprobante())) {
				query.setParameter("ser_comprobante", compra.getSer_comprobante());
			}
			if (!isNullInteger(compra.getNro_siaf())) {
				query.setParameter("nro_siaf", compra.getNro_siaf());
			}
			if (!isNullLong(compra.getNum_ruc())) {
				if (!isNullInteger(compra.getCod_comprobante())) {
					if (cod_rec_honorarios == compra.getCod_comprobante().intValue()) { // Recibo por Honorarios
						query.setParameter("num_ruc", compra.getNum_ruc().toString());
					} else {
						query.setParameter("num_ruc", compra.getNum_ruc());
					}
				} else {
					query.setParameter("num_ruc", compra.getNum_ruc());
				}
			}
			if (!isNullOrEmpty(compra.getFec_desde()) && !isNullOrEmpty(compra.getFec_hasta())) {
				query.setParameter("fechaInicio", getDate(compra.getFec_desde()));
				query.setParameter("fechaFin", getDate(compra.getFec_hasta()));
			}
			if (!isNullOrEmpty(compra.getNro_cp())) {
				query.setParameter("nro_cp", compra.getNro_cp());
			}
			if (!isNullOrEmpty(compra.getNro_comprobante())) {
				query.setParameter("nro_comprobante", compra.getNro_comprobante());
			}
			if (!isNullInteger(compra.getNro_sia_operacion())) {
				query.setParameter("nro_sia_operacion", compra.getNro_sia_operacion());
			}
			if (!isNullInteger(compra.getCod_proveedor())) {
				query.setParameter("cod_proveedor", compra.getCod_proveedor());
			}
			if (!isNullInteger(compra.getCod_personal())) {
				query.setParameter("cod_personal", compra.getCod_personal());
			}
			if (!isNullInteger(compra.getCod_mes())) {
				query.setParameter("cod_mes", compra.getCod_mes());
			}
			if (!isNullInteger(compra.getCod_anno())) {
				query.setParameter("cod_anno", compra.getCod_anno());
			}				
			return query.setResultTransformer(Transformers.aliasToBean(ComprasIngresosBean.class)).list();		
		} catch (Exception e) {
			throw new Exception(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(), 
								Constantes.NIVEL_APP_DAO, 
								this.getClass().getName(), e.getMessage()));
		}
	}
	
	/* (non-Javadoc)
	 * @see pe.com.mig.dao.ICompraDao#listarDetalleCompras(pe.com.mig.model.bean.ComprasBean)
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<DetalleComprasBean> listarDetalleCompras(ComprasIngresosBean compra) throws Exception {
		try {
			StringBuilder hql = new StringBuilder();			
			hql.append("select tdc.srlIdDetalle as cod_det_compra, tci.srlIdCompras as cod_compra, ");			
			hql.append("esp.srl_id_esp as cod_especifica, trim(esp.var_nom_especifica) as des_especifica, ");
			hql.append("trim(esp.chr_cod_especifica) as vcod_especifica, tdc.numCntServicio as num_imp_servicio, ");			
			hql.append("tcc.srlIdCuenta as cod_cuenta, trim(tcc.chrCodCuenta) as vcod_cuenta, ");
			hql.append("trim(tcc.chrNomCuenta) as nom_cuenta, trim(tdc.chrCodMeta) as cod_meta, ");
			hql.append("tdc.chrTipVenta as cod_tip_venta, ");			
			hql.append("case tdc.chrTipVenta when '1' then ' 002 Gravada Sernanp' ");
			hql.append("when '2' then '001 Gravada c/expor' ");
			hql.append("when '3' then '003 Gravada s/expor' ");
			hql.append("when '4' then '004 No Gravada' ");
			hql.append("end as des_tip_venta, ");			
			hql.append("tdc.numImpAfecto as num_imp_afecto, ");
			hql.append("tdc.numImpNoafecto as num_imp_no_afecto, tdc.numImpIgv as num_imp_igv, ");
			hql.append("tdc.numImpIsc as num_imp_isc, tdc.chrCodUsuaCreacion as vnomusuario, ");
			hql.append("tdc.dteFecCreacion as fec_creacion, tdc.intIdfRegistro as int_id_registro, ");
			hql.append("tdc.chrIndRetencion as ind_retencion, tdc.chrNumRetencion as num_retencion, ");			
			hql.append("to_char(tdc.dteFecPago, 'DD/MM/YYYY') as fec_pago ");			
			hql.append("from TDetalleCompras tdc ");			
			hql.append("inner join tdc.TComprasIngresos tci ");
			hql.append("inner join tdc.TEspecifica esp ");
			hql.append("inner join tdc.TCuentaContable tcc ");
			hql.append("where tdc.intIdfRegistro = :int_id_registro ");
			if (!isNull(compra.getCod_com_ingresos())) {
				hql.append("and tci.srlIdCompras = :cod_com_ingresos ");
			}
			hql.append("order by tdc.srlIdDetalle");	
			Query query = super.getSession().createQuery(hql.toString());
			query.setParameter("int_id_registro", Constantes.ESTADO_ACTIVO);
			if (!isNull(compra.getCod_com_ingresos())) {
				query.setParameter("cod_com_ingresos", compra.getCod_com_ingresos());
			}
			return query.setResultTransformer(Transformers.aliasToBean(DetalleComprasBean.class)).list();		
		} catch (Exception e) {
			throw new Exception(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(), 
								Constantes.NIVEL_APP_DAO, 
								this.getClass().getName(), e.getMessage()));
		}
	}
	
	/* (non-Javadoc)
	 * @see pe.com.mig.dao.ICompraDao#grabarCompra(pe.com.mig.model.bean.ComprasBean, java.util.List)
	 */
	@Transactional
	@Override
	public Integer grabarCompra(ComprasIngresosBean compra, List<DetalleComprasBean> detalle) throws Exception {
		Integer codigo = compra.getCod_com_ingresos();
		try {		
			TComprasIngresos tcomprasIngresos = new TComprasIngresos();
			if (!isNullInteger(codigo)) {
				tcomprasIngresos = (TComprasIngresos) getById(TComprasIngresos.class, codigo);
			}
			tcomprasIngresos.setTTipoComprobante(new TTipoComprobante(compra.getCod_comprobante()));
			tcomprasIngresos.setTTipoMoneda(new TTipoMoneda(compra.getCod_moneda()));
			if (compra.getCod_comprobante().equals(Constantes.THREE_INT)) { // Recibo por Honorarios
				if (!isNullInteger(compra.getCod_personal())) {
					tcomprasIngresos.setTPersonalCuarta(new TPersonalCuarta(compra.getCod_personal()));
				}
			} else {
				if (!isNullInteger(compra.getCod_proveedor())) {
					tcomprasIngresos.setTTipoProveedor(new TTipoProveedor(compra.getCod_proveedor()));
				}
			}
			tcomprasIngresos.setTFteFto(new TFteFto(compra.getCod_fue_financiamiento()));			
			if (!isNullInteger(compra.getCod_contrato())) {
				tcomprasIngresos.setTContratos(new TContratos(compra.getCod_contrato()));
			}
			if (!isNullInteger(compra.getCod_med_pago())) {
				tcomprasIngresos.setTMedioPago(new TMedioPago(compra.getCod_med_pago()));
			}			
			if (!isNullInteger(compra.getCod_uni_operativa())) {
				tcomprasIngresos.setUnidadoperativa(new Unidadoperativa(compra.getCod_uni_operativa()));
			}
			if (!isNullInteger(compra.getCod_reg_nac())) {
				tcomprasIngresos.setTbtRegistroNac(new TbtRegistroNac(compra.getCod_reg_nac()));
			}			
			tcomprasIngresos.setChrTipOperacion(compra.getTip_operacion());			
			tcomprasIngresos.setChrNumDocuOperacion(compra.getNro_doc_rc());
			tcomprasIngresos.setChrNumCompOperacion(compra.getNro_cp());
			tcomprasIngresos.setIntNumSiafOperacion(compra.getNro_sia_operacion());
			tcomprasIngresos.setNumImpCompOperacion(compra.getImp_cp());
			tcomprasIngresos.setNumImpTotal(compra.getImp_total());
			tcomprasIngresos.setDteFecDocoperacion(getDate(compra.getFec_doc_rc()));
			tcomprasIngresos.setDteFecComprobante(getDate(compra.getFec_comprobante()));
			tcomprasIngresos.setIntIdfTransaccion(compra.getInt_transaccion());
			tcomprasIngresos.setChrSerComprobante(compra.getSer_comprobante().trim());
			tcomprasIngresos.setChrNumComprobante(compra.getNro_comprobante().trim());
			tcomprasIngresos.setIntNumSiaf(compra.getNro_siaf());
			tcomprasIngresos.setNumTipCambio(compra.getNum_tip_cambio());
			tcomprasIngresos.setChrTipServicio(compra.getInd_ser_publico());
			tcomprasIngresos.setNumImpServicio(compra.getMon_ser_publico());
			tcomprasIngresos.setDteFecPagservicio(getDate(compra.getFec_pago()));			
			tcomprasIngresos.setDteFecVtoservicio(getDate(compra.getFec_vto()));
			tcomprasIngresos.setNumImpVtotal(compra.getNum_imp_tot_venta());
			tcomprasIngresos.setChrNumConstancia(compra.getNum_constancia());
			tcomprasIngresos.setDteFecCondeposito(getDate(compra.getFec_pag_deposito()));
			tcomprasIngresos.setNumImpDeposito(compra.getImp_deposito());
			tcomprasIngresos.setIntPorDeposito(compra.getPor_deposito());
			tcomprasIngresos.setIntMes(compra.getCod_mes());
			tcomprasIngresos.setChrNumCtaCte(compra.getNum_cta_cte());
			tcomprasIngresos.setChrNumCpGiro(compra.getNum_cp_giro());
			tcomprasIngresos.setChrTipOrden(compra.getInd_tip_orden());
			tcomprasIngresos.setDteFecOrden(getDate(compra.getFec_orden()));
			tcomprasIngresos.setChrNumOrden(compra.getNum_orden());
			tcomprasIngresos.setChrCpReten(compra.getInd_cp_reten());
			tcomprasIngresos.setChrMedPago(compra.getInd_med_pago());
			tcomprasIngresos.setDteFecPagoCP(getDate(compra.getFec_pago_cp()));
			tcomprasIngresos.setIntAnno(compra.getCod_anno());
			
			if (!isNullInteger(codigo)) {
				// Eliminamos logicamente el detalle anterior
				List<DetalleComprasBean> lista = listarDetalleCompras(new ComprasIngresosBean(codigo));
				for (DetalleComprasBean det : lista) {		
					TDetalleCompras tdetalleCompras = new TDetalleCompras();
					tdetalleCompras.setSrlIdDetalle(det.getCod_det_compra());					
					tdetalleCompras.setTComprasIngresos(new TComprasIngresos(codigo));				
					tdetalleCompras.setTEspecifica(new TEspecifica(det.getCod_especifica()));	
					tdetalleCompras.setTCuentaContable(new TCuentaContable(det.getCod_cuenta()));
					tdetalleCompras.setChrCodMeta(det.getCod_meta());
					tdetalleCompras.setChrTipVenta(det.getCod_tip_venta());
					tdetalleCompras.setNumCntServicio(det.getNum_imp_servicio());					
					tdetalleCompras.setNumImpAfecto(det.getNum_imp_afecto());
					tdetalleCompras.setNumImpNoafecto(det.getNum_imp_no_afecto());
					tdetalleCompras.setNumImpIgv(det.getNum_imp_igv());
					tdetalleCompras.setNumImpIsc(det.getNum_imp_isc());					
					tdetalleCompras.setChrIndRetencion(det.getInd_retencion());
					tdetalleCompras.setChrNumRetencion(det.getNum_retencion());					
					tdetalleCompras.setDteFecPago(getDate(det.getFec_pago()));
					tdetalleCompras.setChrCodUsuaCreacion(det.getVnomusuario());
					tdetalleCompras.setDteFecCreacion(det.getFec_creacion());
					tdetalleCompras.setIntIdfRegistro(Constantes.ESTADO_INACTIVO);
					tdetalleCompras.setChrCodUsuaModifica(compra.getVnomusuario());
					tdetalleCompras.setDteFecModifica(Calendar.getInstance().getTime());
					tdetalleCompras.setChrCodMeta(det.getCod_meta());
					update(tdetalleCompras);
				}
				
				tcomprasIngresos.setChrCodUsuaModifica(compra.getVnomusuario());
				tcomprasIngresos.setDteFecModifica(Calendar.getInstance().getTime());
				update(tcomprasIngresos);			
			} else {
				tcomprasIngresos.setIntIdfRegistro(Constantes.ESTADO_ACTIVO);
				tcomprasIngresos.setChrCodUsuaCreacion(compra.getVnomusuario());
				tcomprasIngresos.setDteFecCreacion(Calendar.getInstance().getTime());
				codigo = getByIdSave(tcomprasIngresos);
			}
			for (DetalleComprasBean det : detalle) {		
				TDetalleCompras tdetalleCompras = new TDetalleCompras();					
				tdetalleCompras.setTComprasIngresos(new TComprasIngresos(codigo));				
				tdetalleCompras.setTEspecifica(new TEspecifica(det.getCod_especifica()));
				tdetalleCompras.setTCuentaContable(new TCuentaContable(det.getCod_cuenta()));
				tdetalleCompras.setChrCodMeta(det.getCod_meta());
				if (!compra.getCod_comprobante().equals(Constantes.THREE_INT)) { // Diferente de Recibo por Honorarios
					tdetalleCompras.setChrTipVenta(det.getCod_tip_venta());
				} else { // Recibo por Honorarios
					tdetalleCompras.setDteFecPago(getDate(det.getFec_pago()));
				}
				tdetalleCompras.setNumCntServicio(det.getNum_imp_servicio());
				tdetalleCompras.setNumImpAfecto(det.getNum_imp_afecto());
				tdetalleCompras.setNumImpNoafecto(det.getNum_imp_no_afecto());
				tdetalleCompras.setNumImpIgv(det.getNum_imp_igv());
				tdetalleCompras.setNumImpIsc(det.getNum_imp_isc());
				tdetalleCompras.setChrIndRetencion(det.getInd_retencion());
				tdetalleCompras.setChrNumRetencion(det.getNum_retencion());				
				tdetalleCompras.setChrCodUsuaCreacion(compra.getVnomusuario());
				tdetalleCompras.setDteFecCreacion(Calendar.getInstance().getTime());
				tdetalleCompras.setIntIdfRegistro(Constantes.ESTADO_ACTIVO);
				tdetalleCompras.setChrCodMeta(det.getCod_meta());
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
	 * @see pe.com.mig.service.ICompraService#eliminarCompra(pe.com.mig.model.bean.ComprasBean)
	 */
	@Transactional
	@Override
	public void eliminarCompra(ComprasIngresosBean compra) throws Exception {
		try {
			TComprasIngresos tcomprasIngresos = new TComprasIngresos(); 
			tcomprasIngresos = (TComprasIngresos) getById(TComprasIngresos.class, compra.getCod_com_ingresos());			
			tcomprasIngresos.setIntIdfRegistro(Constantes.ESTADO_ELIMINADO);
			tcomprasIngresos.setChrCodUsuaModifica(compra.getVnomusuario());
			tcomprasIngresos.setDteFecModifica(Calendar.getInstance().getTime());
			update(tcomprasIngresos);
			
			// En caso de ser una nota de credito
			if (!isNullInteger(compra.getCod_pad_com_ingresos())) {
				TComprasIngresos tcom_ing_padre = new TComprasIngresos(); 
				tcom_ing_padre = (TComprasIngresos) getById(TComprasIngresos.class, compra.getCod_pad_com_ingresos());			
				tcom_ing_padre.setIntCodPadComIngresos(null);
				tcom_ing_padre.setChrCodUsuaModifica(compra.getVnomusuario());
				tcom_ing_padre.setDteFecModifica(Calendar.getInstance().getTime());
				update(tcom_ing_padre);				
			}			
			
		} catch (Exception e) {
			throw new Exception(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(), 
								Constantes.NIVEL_APP_DAO, 
								this.getClass().getName(), e.getMessage()));
		}
	}

	/* (non-Javadoc)
	 * @see pe.com.mig.dao.IComprasIngresosDao#montoTransferencia(pe.com.mig.model.bean.TransferenciaBean)
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public BigDecimal montoTransferencia(TransferenciaBean transferencia) throws Exception {
		try {
			List<Map<String, Object>> lista = new ArrayList<Map<String, Object>>();
			StringBuilder hql = new StringBuilder();
			hql.append("select distinct new Map(tci.srlIdCompras, ");
			hql.append("coalesce(tci.numImpTotal, 0) as num_imp_total) ");	
			hql.append("from TComprasIngresos tci ");
			hql.append("inner join tci.TTipoComprobante ttc, ");
			hql.append("TTransferencia ttr ");
			hql.append("where tci.chrNumCompOperacion = ttr.chrNumComprobante ");
			hql.append("and tci.intNumSiafOperacion = ttr.intNumSiaf ");
			hql.append("and (tci.intCodPadComIngresos is null or tci.intCodPadComIngresos = 0) ");
			//hql.append("and EXTRACT(YEAR FROM ttr.dteFecComprobante) = extract(year from current_date) ");
			if (!isNullOrEmpty(transferencia.getNum_comprobante())) {
				hql.append("and tci.chrNumCompOperacion = :num_comprobante ");
			}
			if (!isNullInteger(transferencia.getNum_siaf())) {
				hql.append("and tci.intNumSiafOperacion = :num_siaf ");
			}
			hql.append("and tci.intIdfRegistro = :int_id_registro ");
			Query query = super.getSession().createQuery(hql.toString());
			if (!isNullOrEmpty(transferencia.getNum_comprobante())) {
				query.setParameter("num_comprobante", transferencia.getNum_comprobante());
			}
			if (!isNullInteger(transferencia.getNum_siaf())) {
				query.setParameter("num_siaf", transferencia.getNum_siaf());
			}
			query.setParameter("int_id_registro", Constantes.ESTADO_ACTIVO);						
			lista = query.list();
			if (!isEmpty(lista)) {
				BigDecimal monto = BigDecimal.ZERO;
				for (Map<String, Object> map : lista) {
					monto = monto.add(getBigDecimal(map.get("num_imp_total").toString()));
				}
				return monto;
			} else {
				return BigDecimal.ZERO;
			}		
		} catch (Exception e) {
			throw new Exception(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(), 
								Constantes.NIVEL_APP_DAO, 
								this.getClass().getName(), e.getMessage()));
		}
	}
	
	/* (non-Javadoc)
	 * @see pe.com.mig.dao.IComprasIngresosDao#montoCompraNota(pe.com.mig.model.bean.TransferenciaBean)
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public BigDecimal montoCompraNota(TransferenciaBean transferencia) throws Exception {
		try {
			List<Map<String, Object>> lista = new ArrayList<Map<String, Object>>();
			StringBuilder hql = new StringBuilder();
			hql.append("select distinct new Map(tcd.srlIdCompras, ");
			hql.append("coalesce(tcd.numImpTotal, 0) as num_imp_total) ");
			hql.append("from TComprasIngresos tcd ");
			hql.append("inner join tcd.TTipoComprobante ttc, ");
			hql.append("TTransferencia tte ");
			hql.append("where tcd.intIdfRegistro = :int_id_registro ");
			hql.append("and tcd.intCodPadComIngresos > 0 ");		
			hql.append("and tcd.chrNumCompOperacion = tte.chrNumComprobante ");
			hql.append("and tcd.intNumSiafOperacion = tte.intNumSiaf ");
			//hql.append("and EXTRACT(YEAR FROM tte.dteFecComprobante) = extract(year from current_date) ");
			if (!isNullOrEmpty(transferencia.getNum_comprobante())) {
				hql.append("and tcd.chrNumCompOperacion = :num_comprobante ");
			}
			if (!isNullInteger(transferencia.getNum_siaf())) {
				hql.append("and tcd.intNumSiafOperacion = :num_siaf ");
			}
			if (!isNullInteger(transferencia.getCod_comprobante())) {
				hql.append("and ttc.srlIdComprobante = :cod_comprobante ");
			}
			Query query = super.getSession().createQuery(hql.toString());
			query.setParameter("int_id_registro", Constantes.ESTADO_ACTIVO);
			if (!isNullOrEmpty(transferencia.getNum_comprobante())) {
				query.setParameter("num_comprobante", transferencia.getNum_comprobante());
			}
			if (!isNullInteger(transferencia.getNum_siaf())) {
				query.setParameter("num_siaf", transferencia.getNum_siaf());
			}
			if (!isNullInteger(transferencia.getCod_comprobante())) {
				query.setParameter("cod_comprobante", transferencia.getCod_comprobante());
			}
			lista = query.list();
			if (!isEmpty(lista)) {
				BigDecimal monto = BigDecimal.ZERO;
				for (Map<String, Object> map : lista) {
					monto = monto.add(getBigDecimal(map.get("num_imp_total").toString()));
				}
				return monto;
			} else {
				return BigDecimal.ZERO;
			}			
		} catch (Exception e) {
			throw new Exception(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(), 
								Constantes.NIVEL_APP_DAO, 
								this.getClass().getName(), e.getMessage()));
		}
	}

	/* (non-Javadoc)
	 * @see pe.com.mig.dao.IComprasIngresosDao#listarTarifaServicios(pe.com.mig.model.bean.TarifaServicioBean)
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<TarifaServicioBean> listarTarifaServicios(TarifaServicioBean servicio) throws Exception {
		try {
			StringBuilder hql = new StringBuilder();			
			hql.append("select tar.srlIdServicio as cod_servicio, tar.chrCodServicio as vcod_servicio, ");			
			hql.append("tar.chrNomServicio as nom_servicio, tar.numPctUit as num_pct_uit, ");
			hql.append("tar.numImpVventa as num_imp_val_venta, tar.numImpIgv as num_imp_igv, ");
			hql.append("tar.numImpPventa as num_imp_pre_venta, tar.chrCodEspecifica as cod_especifica, ");
			hql.append("tar.chrCodCuenta as cod_cuenta, tar.chrFlgActivo as fla_activo ");
			hql.append("from TTariServicio tar ");			
			hql.append("where tar.chrFlgActivo = :fla_activo ");
			if (!isNullInteger(servicio.getCod_servicio())) {
				hql.append("and tar.srlIdServicio = :cod_servicio ");
			}
			hql.append("order by tar.chrNomServicio");	
			Query query = super.getSession().createQuery(hql.toString());
			query.setParameter("fla_activo", Constantes.FLAG_ACTIVO);
			if (!isNullInteger(servicio.getCod_servicio())) {
				query.setParameter("cod_servicio", servicio.getCod_servicio());
			}
			return query.setResultTransformer(Transformers.aliasToBean(TarifaServicioBean.class)).list();		
		} catch (Exception e) {
			throw new Exception(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(), 
								Constantes.NIVEL_APP_DAO, 
								this.getClass().getName(), e.getMessage()));
		}
	}

	/* (non-Javadoc)
	 * @see pe.com.mig.dao.IComprasIngresosDao#listarProductos(pe.com.mig.model.bean.ProductoBean)
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<ProductoBean> listarProductos(ProductoBean producto) throws Exception {
		try {
			StringBuilder hql = new StringBuilder();			
			hql.append("select tpr.srlIdProducto as cod_producto, tun.srlIdUnidad as cod_uni_medida, ");			
			hql.append("tun.chrNomUnidad as nom_uni_medida, tpr.chrCodProducto as vcod_producto, ");
			hql.append("tpr.chrNomProducto as nom_producto, tpr.impPctUit as imp_pct_uit, ");
			hql.append("tpr.numImpUnit as num_imp_unit, tpr.numImpIgv as num_imp_igv, ");
			hql.append("tpr.numImpPventa as num_imp_pre_venta, tpr.numImpProducto as num_imp_producto, ");
			hql.append("tpr.chrFlgActivo as fla_activo ");
			hql.append("from TProducto tpr ");
			hql.append("inner join tpr.TUnidadMedida tun ");
			hql.append("where tpr.chrFlgActivo = :fla_activo ");
			if (!isNullInteger(producto.getCod_producto())) {
				hql.append("and tpr.srlIdProducto = :cod_producto ");
			}
			hql.append("order by tpr.chrNomProducto");	
			Query query = super.getSession().createQuery(hql.toString());
			query.setParameter("fla_activo", Constantes.FLAG_ACTIVO);
			if (!isNullInteger(producto.getCod_producto())) {
				query.setParameter("cod_producto", producto.getCod_producto());
			}
			return query.setResultTransformer(Transformers.aliasToBean(ProductoBean.class)).list();		
		} catch (Exception e) {
			throw new Exception(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(), 
								Constantes.NIVEL_APP_DAO, 
								this.getClass().getName(), e.getMessage()));
		}
	}

	/* (non-Javadoc)
	 * @see pe.com.mig.dao.IComprasIngresosDao#listarBoletos(pe.com.mig.model.bean.TarifaBoletoBean)
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<TarifaBoletoBean> listarBoletos(TarifaBoletoBean boleto) throws Exception {
		try {
			StringBuilder hql = new StringBuilder();			
			hql.append("select ttb.srlIdBoleto as cod_boleto, reg.idRanac as cod_reg_nac, ");			
			hql.append("reg.nombre as des_reg_nac, ttb.chrNomBoleto as nom_boleto, ");
			hql.append("ttb.chrCodBoleto as vcod_boleto, ttb.intIdfTarifa as ind_tarifa, ");			
			hql.append("case ttb.intIdfTarifa when 1 then 'Tarifa Plana' ");
			hql.append("when 2 then 'Tarifa Social' ");
			hql.append("when 3 then 'Tarifa Promocion' ");
			
			hql.append("when 4 then 'Tarifa Unica' ");
			hql.append("when 5 then 'Tarifa Convencional' ");
			hql.append("when 6 then 'Tarifa Promocionales' end as des_ind_tarifa, ");
			
			hql.append("ttb.numImpUnit as num_imp_unit, ttb.intNumSerie as num_serie, ");
			hql.append("ttb.numCntIngreso as can_ingreso, ttb.numCntSalida as can_salida, ");			
			hql.append("ttb.numCntStock as can_stock, ttb.chrFlgActivo as fla_activo, ");
			hql.append("ttb.numInicio as num_inicio, ttb.numFinal as num_final, ");	
			hql.append("ttb.chrCodPartida as cod_partida, ttb.chrCodCuenta as cod_cuenta ");
			if (!isNullInteger(boleto.getInd_saldo())) {
				hql.append(",(ttb.numCntStock - ");
				hql.append(" (select coalesce(sum(tdi.intCanProducto), 0)");			
				hql.append("from TDetalleIngresos tdi ");			
				hql.append("inner join tdi.TTariBoleto tbd ");
				hql.append("where tbd.srlIdBoleto = ttb.srlIdBoleto ");	
				hql.append("and tdi.intIdfRegistro = :int_id_registro)) as can_sal_stock ");
			}
			hql.append("from TTariBoleto ttb ");
			hql.append("inner join ttb.unidadoperativa uni ");
			hql.append("inner join ttb.tbtRegistroNac reg ");
			hql.append("where ttb.chrFlgActivo = :fla_activo ");
			if (!isNullInteger(boleto.getCod_boleto())) {
				hql.append("and ttb.srlIdBoleto = :cod_boleto ");
			}
			if (!isNullInteger(boleto.getCod_uni_operativa())) {
				hql.append("and uni.idunidad = :cod_uni_operativa ");
			}
			if (!isNullInteger(boleto.getCod_reg_nac())) {
				hql.append("and reg.idRanac = :cod_reg_nac ");
			}
			hql.append("order by ttb.chrNomBoleto");	
			Query query = super.getSession().createQuery(hql.toString());
			query.setParameter("fla_activo", Constantes.FLAG_ACTIVO);
			if (!isNullInteger(boleto.getCod_boleto())) {
				query.setParameter("cod_boleto", boleto.getCod_boleto());
			}
			if (!isNullInteger(boleto.getCod_uni_operativa())) {
				query.setParameter("cod_uni_operativa", boleto.getCod_uni_operativa());
			}
			if (!isNullInteger(boleto.getCod_reg_nac())) {
				query.setParameter("cod_reg_nac", boleto.getCod_reg_nac());
			}
			if (!isNullInteger(boleto.getInd_saldo())) {
				query.setParameter("int_id_registro", Constantes.ESTADO_ACTIVO);
			}
			return query.setResultTransformer(Transformers.aliasToBean(TarifaBoletoBean.class)).list();		
		} catch (Exception e) {
			throw new Exception(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(), 
								Constantes.NIVEL_APP_DAO, 
								this.getClass().getName(), e.getMessage()));
		}
	}

	/* (non-Javadoc)
	 * @see pe.com.mig.dao.IComprasIngresosDao#listarTupas(pe.com.mig.model.bean.TarifaTupaBean)
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<TarifaTupaBean> listarTupas(TarifaTupaBean tupa) throws Exception {
		try {
			StringBuilder hql = new StringBuilder();			
			hql.append("select ttt.srlIdTupa as cod_tupa, ttt.chrCodTupa as vcod_tupa, ");			
			hql.append("ttt.chrNomTupa as nom_tupa, ttt.numPctUit as num_pct_uit, ");
			hql.append("ttt.numImpUnit as num_imp_unit, ttt.chrCodEspecifica as cod_especifica, ");
			hql.append("ttt.chrCodCuenta as cod_cuenta, ttt.chrFlgActivo as fla_activo ");
			hql.append("from TTariTupa ttt ");			
			hql.append("where ttt.chrFlgActivo = :fla_activo ");
			if (!isNullInteger(tupa.getCod_tupa())) {
				hql.append("and ttt.srlIdTupa = :cod_tupa ");
			}
			hql.append("order by ttt.chrNomTupa");	
			Query query = super.getSession().createQuery(hql.toString());
			query.setParameter("fla_activo", Constantes.FLAG_ACTIVO);
			if (!isNullInteger(tupa.getCod_tupa())) {
				query.setParameter("cod_tupa", tupa.getCod_tupa());
			}
			return query.setResultTransformer(Transformers.aliasToBean(TarifaTupaBean.class)).list();		
		} catch (Exception e) {
			throw new Exception(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(), 
								Constantes.NIVEL_APP_DAO, 
								this.getClass().getName(), e.getMessage()));
		}
	}
	
	/* (non-Javadoc)
	 * @see pe.com.mig.service.IComprasIngresosService#listarOtros(pe.com.mig.model.bean.DetalleOtrosBean)
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<DetalleOtrosBean> listarOtros(DetalleOtrosBean otros) throws Exception {
		try {
			StringBuilder hql = new StringBuilder();			
			hql.append("select tot.srlIdOtros as cod_otros, tot.chrNomOtros as nom_otros, ");			
			hql.append("tot.chrFlgActivo as fla_activo, tot.chrCodEspecifica as cod_especifica, ");
			hql.append("tot.chrCodCuenta as cod_cuenta ");
			hql.append("from TOtros tot ");			
			hql.append("where tot.chrFlgActivo = :fla_activo ");
			if (!isNullInteger(otros.getCod_otros())) {
				hql.append("and tot.srlIdOtros = :cod_otros ");
			}
			hql.append("order by tot.chrNomOtros");	
			Query query = super.getSession().createQuery(hql.toString());
			query.setParameter("fla_activo", Constantes.FLAG_ACTIVO);
			if (!isNullInteger(otros.getCod_otros())) {
				query.setParameter("cod_otros", otros.getCod_otros());
			}
			return query.setResultTransformer(Transformers.aliasToBean(DetalleOtrosBean.class)).list();		
		} catch (Exception e) {
			throw new Exception(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(), 
								Constantes.NIVEL_APP_DAO, 
								this.getClass().getName(), e.getMessage()));
		}
	}

	/* (non-Javadoc)
	 * @see pe.com.mig.dao.IComprasIngresosDao#listarDetalleIngresos(pe.com.mig.model.bean.ComprasIngresosBean)
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<DetalleIngresosBean> listarDetalleIngresos(ComprasIngresosBean ingreso) throws Exception {
		try {
			StringBuilder hql = new StringBuilder();			
			hql.append("select tdi.srlIdDetalle as cod_det_ingreso, tci.srlIdCompras as cod_compra, ");			
			hql.append("tdi.numPreUnitario as num_pre_unitario, tdi.intCanDias as can_dias, ");
			hql.append("tdi.intCanPers as can_pers, ");
			hql.append("tdi.intCanProducto as can_producto, tdi.intIniBoleto as ini_boleto, ");
			hql.append("tdi.chrTipTransaccion as tip_transaccion, tts.srlIdServicio as cod_servicio, ");
			hql.append("tts.chrCodServicio as vcod_servicio, tts.chrNomServicio as des_servicio, ");
			hql.append("tts.numImpPventa as num_imp_pre_ven_servicio, ");			
			hql.append("tpr.srlIdProducto as cod_producto, tpr.chrCodProducto as vcod_producto, ");
			hql.append("tpr.chrNomProducto as nom_producto, tpr.numImpPventa as num_pre_uni_producto, ");
			hql.append("ttb.srlIdBoleto as cod_boleto, ttb.chrNomBoleto as des_boleto, ");
			hql.append("ttb.intNumSerie as num_ser_boleto, ttb.numImpUnit as num_imp_unit_boleto, ");
			hql.append("case ttb.intIdfTarifa when 1 then 'Tarifa Plana' ");
			hql.append("when 2 then 'Tarifa Social' ");
			hql.append("when 3 then 'Tarifa Promocion' end as des_ind_tarifa, ");
			hql.append("ttt.srlIdTupa as cod_tupa, ttt.chrCodTupa as vcod_tupa, ");
			hql.append("ttt.chrNomTupa as nom_tupa, ttt.numImpUnit as num_imp_unit_tupa, ");			
			hql.append("tot.srlIdOtros as cod_otros, tot.chrNomOtros as des_otros, ");
			hql.append("tcc.srlIdCuenta as cod_cuenta, tcc.chrCodCuenta as vcod_cuenta, tcc.chrNomCuenta as nom_cuenta, ");
			hql.append("tce.srl_id_esp as cod_espec, tce.chr_cod_especifica as vcod_especifica, tce.var_nom_especifica as des_especifica, ");
			hql.append("tdi.chrCodMeta as cod_meta, ");
			hql.append("tdi.chrTipVenta as cod_tip_venta, ");		
			hql.append("case tdi.chrTipVenta when '1' then ' 002 Gravada Sernanp' ");
			hql.append("when '2' then '001 Gravada c/expor' ");
			hql.append("when '3' then '003 Gravada s/expor' ");
			hql.append("when '4' then '004 No Gravada' ");
			hql.append("end as des_tip_venta, ");
			hql.append("ttt.chrNomTupa as nom_tupa, ttt.numImpUnit as num_imp_unit_tupa, ");
			hql.append("tdi.numImpAfecto as num_imp_afecto, ");
			hql.append("tdi.numImpNoafecto as num_imp_no_afecto, tdi.numImpIgv as num_imp_igv, ");
			hql.append("tdi.numImpIsc as num_imp_isc, tdi.chrCodUsuaCreacion as vnomusuario, ");
			hql.append("tdi.dteFecCreacion as fec_creacion, tdi.intIdfRegistro as int_id_registro ");			
			hql.append("from TDetalleIngresos tdi ");			
			hql.append("inner join tdi.TComprasIngresos tci ");
			hql.append("left join tdi.TTariServicio tts ");
			hql.append("left join tdi.TProducto tpr ");
			hql.append("left join tdi.TTariBoleto ttb ");
			hql.append("left join tdi.TTariTupa ttt ");
			hql.append("left join tdi.TOtros tot ");
			hql.append("left join tdi.TCuentaContable tcc ");
			hql.append("left join tdi.TEspecifica tce ");
			hql.append("where tdi.intIdfRegistro = :int_id_registro ");
			if (!isNull(ingreso.getCod_com_ingresos())) {
				hql.append("and tci.srlIdCompras = :cod_com_ingresos ");
			}
			hql.append("order by tdi.srlIdDetalle");	
			Query query = super.getSession().createQuery(hql.toString());
			query.setParameter("int_id_registro", Constantes.ESTADO_ACTIVO);
			if (!isNull(ingreso.getCod_com_ingresos())) {
				query.setParameter("cod_com_ingresos", ingreso.getCod_com_ingresos());
			}
			return query.setResultTransformer(Transformers.aliasToBean(DetalleIngresosBean.class)).list();		
		} catch (Exception e) {
			throw new Exception(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(), 
								Constantes.NIVEL_APP_DAO, 
								this.getClass().getName(), e.getMessage()));
		}
	}

	/* (non-Javadoc)
	 * @see pe.com.mig.dao.IComprasIngresosDao#|(pe.com.mig.model.bean.ComprasIngresosBean, java.util.List, java.util.List)
	 */
	@Transactional
	@Override
	public Integer grabarIngreso(ComprasIngresosBean ingreso, List<DetalleIngresosBean> detalle, List<DetalleVoucherBean> det_voucher) throws Exception {
		Integer codigo = ingreso.getCod_com_ingresos();
		
		try {		 
			TComprasIngresos tcomprasIngresos = new TComprasIngresos();
			
			if (!isNullInteger(codigo)) {				
				tcomprasIngresos = (TComprasIngresos) getById(TComprasIngresos.class, codigo);			
			}
			tcomprasIngresos.setTTipoComprobante(new TTipoComprobante(ingreso.getCod_comprobante()));
			tcomprasIngresos.setTTipoMoneda(new TTipoMoneda(ingreso.getCod_moneda()));
			// Verificamos el contiene varios proveedores
			if (!isNullInteger(ingreso.getInd_pro_varios())) {
				if (ingreso.getInd_pro_varios().equals(Constantes.FOUR_INT)) { // Varios proveedores
					ProveedorBean proveedor = new ProveedorBean();
					proveedor.setTip_proveedor(Constantes.FOUR_STRING);
					List<ProveedorBean> lis_proveedor = iMaestroDao.listarProveedor(proveedor);
					if (!isEmpty(lis_proveedor)) {
						tcomprasIngresos.setTTipoProveedor(new TTipoProveedor(lis_proveedor.get(0).getCod_proveedor()));
					} else {
						TTipoProveedor ttipoproveedor = new TTipoProveedor();
						ttipoproveedor.setChrTipProveedor(Constantes.FOUR_STRING);
						Integer cod_proveedor = getByIdSave(ttipoproveedor);
						tcomprasIngresos.setTTipoProveedor(new TTipoProveedor(cod_proveedor));
					}
				} else {
					if (!isNullInteger(ingreso.getCod_proveedor())) {
						tcomprasIngresos.setTTipoProveedor(new TTipoProveedor(ingreso.getCod_proveedor()));
					}
				}	
			} else {
				if (!isNullInteger(ingreso.getCod_proveedor())) {
					tcomprasIngresos.setTTipoProveedor(new TTipoProveedor(ingreso.getCod_proveedor()));
				}
			}
			
			tcomprasIngresos.setTFteFto(new TFteFto(ingreso.getCod_fue_financiamiento()));			
			if (!isNullInteger(ingreso.getCod_contrato())) {			
				tcomprasIngresos.setTContratos(new TContratos(ingreso.getCod_contrato()));
			}
			if (!isNullInteger(ingreso.getCod_med_pago())) {
				tcomprasIngresos.setTMedioPago(new TMedioPago(ingreso.getCod_med_pago()));
			}				
			if (!isNullInteger(ingreso.getCod_uni_operativa())) {
				tcomprasIngresos.setUnidadoperativa(new Unidadoperativa(ingreso.getCod_uni_operativa()));
			}
			if (!isNullInteger(ingreso.getCod_reg_nac())) {
				tcomprasIngresos.setTbtRegistroNac(new TbtRegistroNac(ingreso.getCod_reg_nac()));
			}
			if (!isNullInteger(ingreso.getCod_sucur())) {
				tcomprasIngresos.setTSucursal(new TSucursal(ingreso.getCod_sucur()));
			}
			if (!isNullInteger(ingreso.getCod_dir_fact())) {
				tcomprasIngresos.setTDireccionFactura(new TDireccionFactura(ingreso.getCod_dir_fact()));
			}
			if (!isNullInteger(ingreso.getCod_serie())) {
				tcomprasIngresos.setTSeries(new TSeries(ingreso.getCod_serie()));
				
				SeriesBean serie = new SeriesBean();
				serie.setCod_serie(ingreso.getCod_serie());
				List<SeriesBean> lis_serie = iMaestroDao.listarSerie(serie);
				for (SeriesBean det: lis_serie) {
					TSeries tseries = (TSeries) getById(TSeries.class, det.getCod_serie());
					tseries.setIntNumCp(ingreso.getNro_comprobante());
					update(tseries);
				}
			}
			
			tcomprasIngresos.setChrTipOperacion(ingreso.getTip_operacion());			
			tcomprasIngresos.setChrNumDocuOperacion(ingreso.getNro_doc_rc());
			tcomprasIngresos.setChrNumCompOperacion(ingreso.getNro_cp());
			tcomprasIngresos.setIntNumSiafOperacion(ingreso.getNro_sia_operacion());
			tcomprasIngresos.setNumImpCompOperacion(ingreso.getImp_cp());
			tcomprasIngresos.setNumImpTotal(ingreso.getImp_total());
			tcomprasIngresos.setDteFecDocoperacion(getDate(ingreso.getFec_doc_rc()));
			tcomprasIngresos.setDteFecComprobante(getDate(ingreso.getFec_comprobante()));
			tcomprasIngresos.setIntIdfTransaccion(ingreso.getInt_transaccion());
			tcomprasIngresos.setChrSerComprobante(ingreso.getSer_comprobante().trim());
			tcomprasIngresos.setChrNumComprobante(ingreso.getNro_comprobante().trim());
			tcomprasIngresos.setIntNumSiaf(ingreso.getNro_siaf());
			tcomprasIngresos.setNumTipCambio(ingreso.getNum_tip_cambio());
			tcomprasIngresos.setChrTipServicio(ingreso.getInd_ser_publico());
			tcomprasIngresos.setNumImpServicio(ingreso.getMon_ser_publico());
			tcomprasIngresos.setDteFecPagservicio(getDate(ingreso.getFec_pago()));			
			tcomprasIngresos.setDteFecVtoservicio(getDate(ingreso.getFec_vto()));
			tcomprasIngresos.setNumImpVtotal(ingreso.getNum_imp_tot_venta());
			tcomprasIngresos.setChrNumConstancia(ingreso.getNum_constancia());
			tcomprasIngresos.setDteFecCondeposito(getDate(ingreso.getFec_pag_deposito()));
			tcomprasIngresos.setNumImpDeposito(ingreso.getImp_deposito());
			tcomprasIngresos.setIntPorDeposito(ingreso.getPor_deposito());
			tcomprasIngresos.setChrNumDocuEmpresa(ingreso.getNum_doc_empresa());
			tcomprasIngresos.setDteFecDocuEmpresa(getDate(ingreso.getFec_doc_empresa()));
			tcomprasIngresos.setChrNumDocuDerivacion(ingreso.getNum_doc_derivacion());
			tcomprasIngresos.setDteFecDocuDerivacion(getDate(ingreso.getFec_doc_derivacion()));			
			tcomprasIngresos.setChrNumVoucher(ingreso.getNum_voucher());
			tcomprasIngresos.setDteFecVoucher(getDate(ingreso.getFec_voucher()));
			tcomprasIngresos.setNumImpVoucher(ingreso.getNum_imp_voucher());
			tcomprasIngresos.setIntMes(ingreso.getCod_mes());
			tcomprasIngresos.setChrNumCtaCte(ingreso.getNum_cta_cte());
			tcomprasIngresos.setChrDesGlosa(ingreso.getDes_glosa());
			tcomprasIngresos.setSrlIdCtaCte(ingreso.getCod_ctacte());
			tcomprasIngresos.setChrTipFact(ingreso.getInd_tip_fact());
			tcomprasIngresos.setIntAnno(ingreso.getCod_anno());
	
			
			if (!isNullInteger(codigo)) {
				// Eliminamos logicamente el detalle de ingresos anterior
				List<DetalleIngresosBean> lista = listarDetalleIngresos(new ComprasIngresosBean(codigo));
				for (DetalleIngresosBean det : lista) {		
					TDetalleIngresos tdetalleIngresos = (TDetalleIngresos) getById(TDetalleIngresos.class, det.getCod_det_ingreso());					
					tdetalleIngresos.setIntIdfRegistro(Constantes.ESTADO_ELIMINADO);
					tdetalleIngresos.setChrCodUsuaModifica(ingreso.getVnomusuario());
					tdetalleIngresos.setDteFecModifica(Calendar.getInstance().getTime());
					update(tdetalleIngresos);
				}
				
				// Eliminamos logicamente el detalle de papeletas anterior
				List<DetalleVoucherBean> lis_voucher = listarDetalleVoucher(new DetalleVoucherBean(codigo));
				for (DetalleVoucherBean vou : lis_voucher) {
					TDetalleVoucher tdetallevoucher = new TDetalleVoucher();
					tdetallevoucher.setSrlIdVoucher(vou.getCod_voucher());
					tdetallevoucher.setTComprasIngresos(new TComprasIngresos(codigo));
					tdetallevoucher.setChrNumVoucher(vou.getNum_voucher());
					tdetallevoucher.setDteFecVoucher(getDate(vou.getFec_voucher()));
					tdetallevoucher.setNumImpVoucher(vou.getImp_voucher());
					tdetallevoucher.setImgVoucher(vou.getImg_voucher());					
					tdetallevoucher.setChrCodUsuaCreacion(vou.getVnomusuario());
					tdetallevoucher.setDteFecCreacion(vou.getFec_creacion());					
					tdetallevoucher.setIntIdfRegistro(Constantes.ESTADO_ELIMINADO);
					tdetallevoucher.setChrCodUsuaModifica(ingreso.getVnomusuario());
					tdetallevoucher.setDteFecModifica(Calendar.getInstance().getTime());
					update(tdetallevoucher);
				}
				
				tcomprasIngresos.setChrCodUsuaModifica(ingreso.getVnomusuario());
				tcomprasIngresos.setDteFecModifica(Calendar.getInstance().getTime());
				update(tcomprasIngresos);
			} else {
				tcomprasIngresos.setIntIdfRegistro(Constantes.ESTADO_ACTIVO);
				tcomprasIngresos.setChrCodUsuaCreacion(ingreso.getVnomusuario());
				tcomprasIngresos.setDteFecCreacion(Calendar.getInstance().getTime());
				codigo = getByIdSave(tcomprasIngresos);
			}
			
			
			String tip_transaccion = detalle.get(0).getTip_transaccion();
			for (DetalleIngresosBean det : detalle) {		
				TDetalleIngresos tdetalleIngresos = new TDetalleIngresos();					
				tdetalleIngresos.setTComprasIngresos(new TComprasIngresos(codigo));				
	
				if (tip_transaccion.equals("1")) { // Servicios
					tdetalleIngresos.setTTariServicio(new TTariServicio(det.getCod_especifica()));
					tdetalleIngresos.setIntCanDias(det.getCan_dias());
					tdetalleIngresos.setIntCanPers(det.getCan_pers());
				} else if (tip_transaccion.equals("2")) { // Productos
					tdetalleIngresos.setTProducto(new TProducto(det.getCod_especifica()));
					tdetalleIngresos.setIntCanProducto(det.getCan_producto());
				} else if (tip_transaccion.equals("3")) { // Boletos
					tdetalleIngresos.setTTariBoleto(new TTariBoleto(det.getCod_especifica()));
					tdetalleIngresos.setIntCanProducto(det.getCan_producto());
					tdetalleIngresos.setIntIniBoleto(det.getIni_boleto());
					Integer fin_boleto = (det.getCan_producto()).intValue() + det.getIni_boleto() - 1;					
					tdetalleIngresos.setIntFinBoleto(fin_boleto);					
				} else if (tip_transaccion.equals("4")) { // Tupa
					tdetalleIngresos.setTTariTupa(new TTariTupa(det.getCod_especifica()));
					tdetalleIngresos.setIntCanProducto(det.getCan_producto());
				} else if (tip_transaccion.equals("5")) { // Otros
					tdetalleIngresos.setTOtros(new TOtros(det.getCod_especifica()));
					tdetalleIngresos.setIntCanProducto(det.getCan_producto());
				}	
				
				tdetalleIngresos.setNumPreUnitario(det.getNum_pre_unitario());				
				tdetalleIngresos.setChrTipTransaccion(tip_transaccion);
				tdetalleIngresos.setChrTipVenta(det.getCod_tip_venta());
				tdetalleIngresos.setNumImpAfecto(det.getNum_imp_afecto());
				tdetalleIngresos.setNumImpNoafecto(det.getNum_imp_no_afecto());
				tdetalleIngresos.setNumImpIgv(det.getNum_imp_igv());
				tdetalleIngresos.setNumImpIsc(det.getNum_imp_isc());
				tdetalleIngresos.setChrCodUsuaCreacion(ingreso.getVnomusuario());
				tdetalleIngresos.setDteFecCreacion(Calendar.getInstance().getTime());
				tdetalleIngresos.setIntIdfRegistro(Constantes.ESTADO_ACTIVO);
				save(tdetalleIngresos);
			}	
			
			for (DetalleVoucherBean vou : det_voucher) {
				TDetalleVoucher tdetallevoucher = new TDetalleVoucher();
				tdetallevoucher.setTComprasIngresos(new TComprasIngresos(codigo));
				tdetallevoucher.setChrNumVoucher(vou.getNum_voucher());
				tdetallevoucher.setDteFecVoucher(getDate(vou.getFec_voucher()));
				tdetallevoucher.setNumImpVoucher(vou.getImp_voucher());
				tdetallevoucher.setImgVoucher(vou.getImg_voucher());					
				tdetallevoucher.setChrCodUsuaCreacion(vou.getVnomusuario());
				tdetallevoucher.setDteFecCreacion(Calendar.getInstance().getTime());					
				tdetallevoucher.setIntIdfRegistro(Constantes.ESTADO_ACTIVO);
				save(tdetallevoucher);
			}
	
			
		} catch (Exception e) {
			throw new Exception(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(), 
								Constantes.NIVEL_APP_DAO, 
								this.getClass().getName(), e.getMessage()));
		}
		return codigo;
	}


	/* (non-Javadoc)
	 * @see pe.com.mig.dao.IComprasIngresosDao#grabarNotaCredito(pe.com.mig.model.bean.ComprasIngresosBean, pe.com.mig.model.bean.DetalleComprasBean, pe.com.mig.model.bean.DetalleIngresosBean)
	 */
	@Transactional
	@Override
	public Integer grabarNotaCredito(ComprasIngresosBean com_ingreso, DetalleComprasBean det_compras, DetalleIngresosBean det_ingresos) throws Exception {
		Integer codigo = null;
		try {
			TComprasIngresos tcom_ing_padre = (TComprasIngresos) getById(TComprasIngresos.class, com_ingreso.getCod_pad_com_ingresos());

			TComprasIngresos tcomprasIngresos = new TComprasIngresos();
			tcomprasIngresos.setTTipoMoneda(tcom_ing_padre.getTTipoMoneda());
			if (!isNull(tcom_ing_padre.getTTipoProveedor())) {
				tcomprasIngresos.setTTipoProveedor(tcom_ing_padre.getTTipoProveedor());
			}
			if (!isNull(tcom_ing_padre.getTPersonalCuarta())) {
				tcomprasIngresos.setTPersonalCuarta(tcom_ing_padre.getTPersonalCuarta());
			}
			tcomprasIngresos.setTFteFto(tcom_ing_padre.getTFteFto());			
			if (!isNull(tcom_ing_padre.getTContratos())) {
				tcomprasIngresos.setTContratos(tcom_ing_padre.getTContratos());
			}
			if (!isNull(tcom_ing_padre.getTMedioPago())) {
				tcomprasIngresos.setTMedioPago(tcom_ing_padre.getTMedioPago());
			}			
			if (!isNull(tcom_ing_padre.getUnidadoperativa())) {
				tcomprasIngresos.setUnidadoperativa(tcom_ing_padre.getUnidadoperativa());
			}
			if (!isNull(tcom_ing_padre.getTbtRegistroNac())) {
				tcomprasIngresos.setTbtRegistroNac(tcom_ing_padre.getTbtRegistroNac());
			}			
			tcomprasIngresos.setChrTipOperacion(tcom_ing_padre.getChrTipOperacion());			
			tcomprasIngresos.setChrNumDocuOperacion(tcom_ing_padre.getChrNumDocuOperacion());
			tcomprasIngresos.setChrNumCompOperacion(tcom_ing_padre.getChrNumCompOperacion());
			tcomprasIngresos.setIntNumSiafOperacion(tcom_ing_padre.getIntNumSiafOperacion());
			tcomprasIngresos.setNumImpCompOperacion(tcom_ing_padre.getNumImpCompOperacion());
			tcomprasIngresos.setNumImpVtotal(tcom_ing_padre.getNumImpVtotal());
			tcomprasIngresos.setDteFecDocoperacion(tcom_ing_padre.getDteFecDocoperacion());
			tcomprasIngresos.setIntNumSiaf(tcom_ing_padre.getIntNumSiaf());
			tcomprasIngresos.setNumTipCambio(tcom_ing_padre.getNumTipCambio());
			tcomprasIngresos.setChrTipServicio(tcom_ing_padre.getChrTipServicio());
			tcomprasIngresos.setNumImpServicio(tcom_ing_padre.getNumImpServicio());
			tcomprasIngresos.setDteFecPagservicio(tcom_ing_padre.getDteFecPagservicio());			
			tcomprasIngresos.setDteFecVtoservicio(tcom_ing_padre.getDteFecVtoservicio());			
			tcomprasIngresos.setChrNumConstancia(tcom_ing_padre.getChrNumConstancia());
			tcomprasIngresos.setDteFecCondeposito(tcom_ing_padre.getDteFecCondeposito());
			tcomprasIngresos.setNumImpDeposito(tcom_ing_padre.getNumImpDeposito());
			tcomprasIngresos.setIntPorDeposito(tcom_ing_padre.getIntPorDeposito());
			tcomprasIngresos.setChrNumDocuEmpresa(tcom_ing_padre.getChrNumDocuEmpresa());
			tcomprasIngresos.setDteFecDocuEmpresa(tcom_ing_padre.getDteFecDocuEmpresa());
			tcomprasIngresos.setChrNumDocuDerivacion(tcom_ing_padre.getChrNumDocuDerivacion());
			tcomprasIngresos.setDteFecDocuDerivacion(tcom_ing_padre.getDteFecDocuDerivacion());
			tcomprasIngresos.setChrNumVoucher(tcom_ing_padre.getChrNumVoucher());
			tcomprasIngresos.setDteFecVoucher(tcom_ing_padre.getDteFecVoucher());
			tcomprasIngresos.setNumImpVoucher(tcom_ing_padre.getNumImpVoucher());
			tcomprasIngresos.setIntMes(tcom_ing_padre.getIntMes());
			tcomprasIngresos.setIntAnno(tcom_ing_padre.getIntAnno());
			tcomprasIngresos.setChrNumCtaCte(tcom_ing_padre.getChrNumCtaCte());
			// Valores nuevos de nota de credito
			tcomprasIngresos.setTTipoComprobante(new TTipoComprobante(com_ingreso.getCod_comprobante()));	
			tcomprasIngresos.setDteFecComprobante(getDate(com_ingreso.getFec_comprobante()));
			tcomprasIngresos.setIntIdfTransaccion(com_ingreso.getInt_transaccion());
			tcomprasIngresos.setChrSerComprobante(com_ingreso.getSer_comprobante().trim());
			tcomprasIngresos.setChrNumComprobante(com_ingreso.getNro_comprobante().trim());
			tcomprasIngresos.setNumImpTotal(com_ingreso.getImp_total());			
			tcomprasIngresos.setIntIdfRegistro(Constantes.ESTADO_ACTIVO);
			tcomprasIngresos.setIntCodPadComIngresos(com_ingreso.getCod_pad_com_ingresos());
			tcomprasIngresos.setChrCodUsuaCreacion(com_ingreso.getVnomusuario());
			tcomprasIngresos.setDteFecCreacion(Calendar.getInstance().getTime());
			codigo = getByIdSave(tcomprasIngresos);
				
			if (com_ingreso.getInt_transaccion().equals(Constantes.ONE_INT)) { // Compras
				TDetalleCompras tdetalleCompras = new TDetalleCompras();					
				tdetalleCompras.setTComprasIngresos(new TComprasIngresos(codigo));				
				tdetalleCompras.setTEspecifica(new TEspecifica(det_compras.getCod_especifica()));
				tdetalleCompras.setTCuentaContable(new TCuentaContable(det_compras.getCod_cuenta()));
				tdetalleCompras.setChrTipVenta(det_compras.getCod_tip_venta());
				tdetalleCompras.setNumCntServicio(det_compras.getNum_imp_servicio());
				tdetalleCompras.setNumImpAfecto(det_compras.getNum_imp_afecto());
				tdetalleCompras.setNumImpNoafecto(det_compras.getNum_imp_no_afecto());
				tdetalleCompras.setNumImpIgv(det_compras.getNum_imp_igv());
				tdetalleCompras.setNumImpIsc(det_compras.getNum_imp_isc());
				tdetalleCompras.setChrCodUsuaCreacion(com_ingreso.getVnomusuario());
				tdetalleCompras.setDteFecCreacion(Calendar.getInstance().getTime());
				tdetalleCompras.setIntIdfRegistro(Constantes.ESTADO_ACTIVO);
				save(tdetalleCompras);				
			} else if (com_ingreso.getInt_transaccion().equals(Constantes.TWO_INT)) { // Ingresos	
				TDetalleIngresos tdetalleIngresos = new TDetalleIngresos();					
				tdetalleIngresos.setTComprasIngresos(new TComprasIngresos(codigo));
				String tip_transaccion = det_ingresos.getTip_transaccion();
				if (tip_transaccion.equals("1")) { // Servicios
					tdetalleIngresos.setTTariServicio(new TTariServicio(det_ingresos.getCod_especifica()));
					tdetalleIngresos.setIntCanDias(det_ingresos.getCan_dias());
				} else if (tip_transaccion.equals("2")) { // Productos
					tdetalleIngresos.setTProducto(new TProducto(det_ingresos.getCod_especifica()));
					tdetalleIngresos.setIntCanProducto(det_ingresos.getCan_producto());
				} else if (tip_transaccion.equals("3")) { // Boletos
					tdetalleIngresos.setTTariBoleto(new TTariBoleto(det_ingresos.getCod_especifica()));
					tdetalleIngresos.setIntCanProducto(det_ingresos.getCan_producto());
					tdetalleIngresos.setIntIniBoleto(det_ingresos.getIni_boleto());					
				} else if (tip_transaccion.equals("4")) { // Tupa
					tdetalleIngresos.setTTariTupa(new TTariTupa(det_ingresos.getCod_especifica()));
					tdetalleIngresos.setIntCanProducto(det_ingresos.getCan_producto());
				} else if (tip_transaccion.equals("5")) { // Otros
					tdetalleIngresos.setTOtros(new TOtros(det_ingresos.getCod_especifica()));
					tdetalleIngresos.setIntCanProducto(det_ingresos.getCan_producto());
				}				
				tdetalleIngresos.setNumPreUnitario(det_ingresos.getNum_pre_unitario());				
				tdetalleIngresos.setChrTipTransaccion(tip_transaccion);
				tdetalleIngresos.setChrTipVenta(det_ingresos.getCod_tip_venta());
				tdetalleIngresos.setNumImpAfecto(det_ingresos.getNum_imp_afecto());
				tdetalleIngresos.setNumImpNoafecto(det_ingresos.getNum_imp_no_afecto());
				tdetalleIngresos.setNumImpIgv(det_ingresos.getNum_imp_igv());
				tdetalleIngresos.setNumImpIsc(det_ingresos.getNum_imp_isc());
				tdetalleIngresos.setChrCodUsuaCreacion(com_ingreso.getVnomusuario());
				tdetalleIngresos.setDteFecCreacion(Calendar.getInstance().getTime());
				tdetalleIngresos.setIntIdfRegistro(Constantes.ESTADO_ACTIVO);
				save(tdetalleIngresos);				
			}
			
			tcom_ing_padre.setIntCodPadComIngresos(Constantes.ZERO_INT);
			tcom_ing_padre.setChrCodUsuaModifica(com_ingreso.getVnomusuario());
			tcom_ing_padre.setDteFecModifica(Calendar.getInstance().getTime());
			update(tcom_ing_padre);
			
		} catch (Exception e) {
			throw new Exception(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(), 
					Constantes.NIVEL_APP_DAO, 
					this.getClass().getName(), e.getMessage()));
		}
		return codigo;
	}
	
	/* (non-Javadoc)
	 * @see pe.com.mig.dao.IComprasIngresosDao#listarReporteCompras(pe.com.mig.model.bean.ComprasIngresosBean)
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<ReporteDetalleComprasBean> listarReporteCompras(ComprasIngresosBean compra) throws Exception {
		try {
			StringBuilder hql = new StringBuilder();
			if (compra.getCod_servicio().equals(Constantes.ONE_INT)) { // Consolidado de Partidas por Rendición de Cuenta				
				hql.append("select esp.srl_id_esp as cod_especifica, ");
				hql.append("trim(esp.chr_cod_especifica) as vcod_especifica, ");		
				hql.append("trim(det.chrCodMeta) as cod_meta, ");
				hql.append("sum(det.numImpPartida) as imp_partida, ");
				hql.append("coalesce((select sum(tdc.numImpAfecto + tdc.numImpNoafecto + ");
			    hql.append("tdc.numImpIgv + tdc.numImpIsc) as imp_det_total ");			
				hql.append("from TDetalleCompras tdc ");			
				hql.append("inner join tdc.TComprasIngresos tci ");
				hql.append("inner join tci.TTipoComprobante ttc ");
				hql.append("left join tci.TTipoProveedor ttp ");
				hql.append("left join tci.unidadoperativa uni ");
				hql.append("left join tci.tbtRegistroNac reg ");
				hql.append("inner join tdc.TEspecifica tes ");				
				hql.append("where tci.intIdfRegistro = :int_id_registro ");	
				hql.append("and tci.intIdfTransaccion = :int_transaccion ");
				hql.append("and ttc.srlIdComprobante != :cod_comprobante ");
				hql.append("and tdc.intIdfRegistro = :int_id_registro ");				
				hql.append("and tes.srl_id_esp = esp.srl_id_esp ");
				hql.append("and det.chrCodMeta=tdc.chrCodMeta ");
				if (!isNullOrEmpty(compra.getTip_operacion())) {
					hql.append("and tci.chrTipOperacion = :tip_operacion ");
				}					
				if (!isNullInteger(compra.getCod_uni_operativa())) {
					hql.append("and uni.idunidad = :cod_uni_operativa ");
				}
				if (!isNullInteger(compra.getCod_reg_nac())) {
					hql.append("and reg.idRanac = :cod_reg_nac ");
				}
				if (!isNullLong(compra.getNum_ruc())) {
					hql.append("and ttp.numRuc = :num_ruc ");
				}
				if (!isNullOrEmpty(compra.getFec_inicio()) && !isNullOrEmpty(compra.getFec_final())) {
					hql.append("and tci.dteFecComprobante between :fec_inicio and :fec_final ");
				}
				if (!isNullOrEmpty(compra.getNro_doc_rc())) {
					hql.append("and tci.chrNumDocuOperacion = :nro_doc_rc ");
				}
				if (!isNullOrEmpty(compra.getNro_cp())) {
					hql.append("and tci.chrNumCompOperacion = :nro_cp ");
				}
				hql.append("), 0) as imp_det_total, ");
				
				
				
				
				hql.append("(sum(det.numImpPartida) - ");
				hql.append("coalesce((select sum(tdc.numImpAfecto + tdc.numImpNoafecto + ");
			    hql.append("tdc.numImpIgv + tdc.numImpIsc) as imp_det_total ");			
				hql.append("from TDetalleCompras tdc ");			
				hql.append("inner join tdc.TComprasIngresos tci ");
				hql.append("inner join tci.TTipoComprobante ttc ");
				hql.append("left join tci.TTipoProveedor ttp ");
				hql.append("left join tci.unidadoperativa uni ");
				hql.append("left join tci.tbtRegistroNac reg ");
				hql.append("inner join tdc.TEspecifica tes ");				
				hql.append("where tci.intIdfRegistro = :int_id_registro ");	
				hql.append("and tci.intIdfTransaccion = :int_transaccion ");
				//hql.append("and ttc.srlIdComprobante != :cod_comprobante ");
				hql.append("and tdc.intIdfRegistro = :int_id_registro ");				
				hql.append("and tes.srl_id_esp = esp.srl_id_esp ");		
				hql.append("and det.chrCodMeta=tdc.chrCodMeta ");
				if (!isNullOrEmpty(compra.getTip_operacion())) {
					hql.append("and tci.chrTipOperacion = :tip_operacion ");
				}					
				if (!isNullInteger(compra.getCod_uni_operativa())) {
					hql.append("and uni.idunidad = :cod_uni_operativa ");
				}
				if (!isNullInteger(compra.getCod_reg_nac())) {
					hql.append("and reg.idRanac = :cod_reg_nac ");
				}
				if (!isNullLong(compra.getNum_ruc())) {
					hql.append("and ttp.numRuc = :num_ruc ");
				}
				if (!isNullOrEmpty(compra.getFec_inicio()) && !isNullOrEmpty(compra.getFec_final())) {
					hql.append("and tci.dteFecComprobante between :fec_inicio and :fec_final ");
				}
				if (!isNullOrEmpty(compra.getNro_doc_rc())) {
					hql.append("and tci.chrNumDocuOperacion = :nro_doc_rc ");
				}
				if (!isNullOrEmpty(compra.getNro_cp())) {
					hql.append("and tci.chrNumCompOperacion = :nro_cp ");
				}
				hql.append("), 0)) as imp_saldo, ");
				hql.append("coalesce((select sum(tdc.numImpAfecto + tdc.numImpNoafecto + ");
			    hql.append("tdc.numImpIgv + tdc.numImpIsc) as imp_det_total ");			
				hql.append("from TDetalleCompras tdc ");			
				hql.append("inner join tdc.TComprasIngresos tci ");
				hql.append("inner join tci.TTipoComprobante ttc ");
				hql.append("left join tci.TTipoProveedor ttp ");
				hql.append("left join tci.unidadoperativa uni ");
				hql.append("left join tci.tbtRegistroNac reg ");
				hql.append("inner join tdc.TEspecifica tes ");				
				hql.append("where tci.intIdfRegistro = :int_id_registro ");	
				hql.append("and tci.intIdfTransaccion = :int_transaccion ");
				hql.append("and ttc.srlIdComprobante = :cod_comprobante ");
				hql.append("and tdc.intIdfRegistro = :int_id_registro ");				
				hql.append("and tes.srl_id_esp = esp.srl_id_esp ");		
				hql.append("and det.chrCodMeta=tdc.chrCodMeta ");

				if (!isNullOrEmpty(compra.getTip_operacion())) {
					hql.append("and tci.chrTipOperacion = :tip_operacion ");
				}					
				if (!isNullInteger(compra.getCod_uni_operativa())) {
					hql.append("and uni.idunidad = :cod_uni_operativa ");
				}
				if (!isNullInteger(compra.getCod_reg_nac())) {
					hql.append("and reg.idRanac = :cod_reg_nac ");
				}
				if (!isNullLong(compra.getNum_ruc())) {
					hql.append("and ttp.numRuc = :num_ruc ");
				}
				if (!isNullOrEmpty(compra.getFec_inicio()) && !isNullOrEmpty(compra.getFec_final())) {
					hql.append("and tci.dteFecComprobante between :fec_inicio and :fec_final ");
				}
				if (!isNullOrEmpty(compra.getNro_doc_rc())) {
					hql.append("and tci.chrNumDocuOperacion = :nro_doc_rc ");
				}
				if (!isNullOrEmpty(compra.getNro_cp())) {
					hql.append("and tci.chrNumCompOperacion = :nro_cp ");
				}
				hql.append("), 0) as imp_devolucion ");
				hql.append("from TDetalleTranfer det ");			
				hql.append("inner join det.TTransferencia tra ");
				hql.append("inner join det.TEspecifica esp ");
				hql.append("where det.intIdfRegistro = :int_id_registro ");
				hql.append("and tra.intIdfRegistro = :int_id_registro ");
				
				//hql.append("and EXTRACT(YEAR FROM tra.dteFecComprobante) = extract(year from current_date) ");
				
				if (!isNullOrEmpty(compra.getNro_cp())) {
					hql.append("and tra.chrNumComprobante = :nro_cp ");
				}
				hql.append("group by esp.chr_cod_especifica, esp.srl_id_esp, det.chrCodMeta ");
				hql.append("order by det.chrCodMeta,esp.chr_cod_especifica");
				
			} else if (compra.getCod_servicio().equals(Constantes.TWO_INT)) {  // Documentos de la Rendición de Cuenta
				hql.append("select distinct tci.srlIdCompras as cod_compra, ");	
				hql.append("ttc.srlIdComprobante as cod_comprobante, ttc.chrNomComprobante as tip_comprobante, ");
				hql.append("ttp.srlIdProveedor as cod_proveedor, ttp.numRuc as num_ruc, ");			
				hql.append("ttp.chrTipProveedor as tip_proveedor, ttp.chrTipEstado as tip_estado, ");
				hql.append("ttp.chrRazSocial as raz_social, ttp.chrNombres as nombres, ");			
				hql.append("ttp.chrApePaterno as ape_paterno, ttp.chrApeMaterno as ape_materno, ");				
				hql.append("case ");			
				hql.append("when (ttc.srlIdComprobante = 3 and tpc.numRuc is not null) then tpc.numRuc ");
				hql.append("when (ttc.srlIdComprobante != 3 and ttp.numRuc is not null) then cast(ttp.numRuc as string) ");
				hql.append("when (ttc.srlIdComprobante != 3 and ttp.chrNumDocumento is not null) then ttp.chrNumDocumento ");
				hql.append("else '' ");
				hql.append("end as ruc_nro_doc_prov, ");
				hql.append("case ");			
				hql.append("when (ttc.srlIdComprobante = 3 and trim(tpc.chrNombres) != '') then concat(tpc.chrNombres, ' ', tpc.chrApePaterno, ' ', tpc.chrApeMaterno) ");
				hql.append("when (ttc.srlIdComprobante != 3 and trim(ttp.chrRazSocial) != '') then ttp.chrRazSocial ");
				hql.append("when (ttc.srlIdComprobante != 3 and trim(ttp.chrNombres) != '') then concat(ttp.chrNombres, ' ', ttp.chrApePaterno, ' ', ttp.chrApeMaterno) ");
				hql.append("else '' ");
				hql.append("end as raz_soc_prov, ");				
				hql.append("tpc.srlIdPersonal as cod_personal, tpc.numRuc as num_ruc_personal, ");			
				hql.append("tpc.chrNombres as nom_personal, ");			
				hql.append("tpc.chrApePaterno as ape_pat_personal, tpc.chrApeMaterno as ape_mat_personal, ");				
				hql.append("tci.intIdfTransaccion as int_transaccion, trim(tci.chrSerComprobante) as ser_comprobante, ");
				hql.append("trim(tci.chrNumComprobante) as nro_comprobante, ");				
				hql.append("concat(trim(tci.chrSerComprobante), '-', trim(tci.chrNumComprobante)) as nro_ser_comprobante, ");				
				hql.append("to_char(tci.dteFecComprobante, 'DD/MM/YYYY') as fec_comprobante, ");			
				hql.append("tci.intNumSiaf as nro_siaf, ");
				hql.append("tci.numTipCambio as num_tip_cambio, tci.chrTipOperacion as tip_operacion, ");
				hql.append("tci.chrNumDocuOperacion as nro_doc_rc, ");
				hql.append("to_char(tci.dteFecDocoperacion, 'DD/MM/YYYY') as fec_doc_rc, ");			
				hql.append("tci.chrNumCompOperacion as nro_cp, tci.intNumSiafOperacion as nro_sia_operacion, ");
				hql.append("tci.numImpCompOperacion as imp_cp, tci.numImpTotal as imp_total, ");
				hql.append("uni.idunidad as cod_uni_operativa, uni.nomunidad as des_uni_operativa, ");
				hql.append("reg.idRanac as cod_reg_nac, coalesce(reg.nombre, '') as des_reg_nac, ");
				hql.append("tdc.srlIdDetalle as cod_det_compra, ");			
				hql.append("esp.srl_id_esp as cod_especifica, trim(esp.var_nom_especifica) as des_especifica, ");
				hql.append("trim(esp.chr_cod_especifica) as vcod_especifica, tdc.numCntServicio as num_imp_servicio, ");
				hql.append("tdc.chrCodMeta as cod_meta, ");
				hql.append("case tci.chrTipOrden when '1' then 'O/S' ");
				hql.append("when '2' then 'O/C' ");				
				hql.append("end as tip_orden, ");
				hql.append("to_char(tci.dteFecOrden, 'DD/MM/YYYY') as fec_orden, ");
				hql.append("tci.chrNumOrden as num_orden, ");
				hql.append("case tci.chrCpReten when '1' then 'CRET' ");		
				hql.append("end as ind_cp_reten, ");
				hql.append("tcc.srlIdCuenta as cod_cuenta, trim(tcc.chrCodCuenta) as vcod_cuenta, ");
				hql.append("trim(tcc.chrNomCuenta) as nom_cuenta, ");			
				hql.append("tdc.chrTipVenta as cod_tip_venta, ");			
				hql.append("case tdc.chrTipVenta when '1' then '002 Gravada Sernanp' ");
				hql.append("when '2' then '001 Gravada c/expor' ");
				hql.append("when '3' then '003 Gravada s/expor' ");
				hql.append("when '4' then '004 No Gravada' ");
				hql.append("end as des_tip_venta, ");			
				hql.append("tdc.numImpAfecto as num_imp_afecto, ");
				hql.append("tdc.numImpNoafecto as num_imp_no_afecto, tdc.numImpIgv as num_imp_igv, ");
				hql.append("tdc.numImpIsc as num_imp_isc, (tdc.numImpAfecto + tdc.numImpNoafecto + ");
			    hql.append("tdc.numImpIgv + tdc.numImpIsc) as imp_det_total, ");
			    hql.append("tci.intMes as cod_mes,tci.intAnno as cod_anno ");
				hql.append("from TComprasIngresos tci ");			
				hql.append("inner join tci.TTipoComprobante ttc ");
				hql.append("left join tci.TTipoProveedor ttp ");
				hql.append("left join tci.TPersonalCuarta tpc ");
				hql.append("left join tci.unidadoperativa uni ");
				hql.append("left join tci.tbtRegistroNac reg, ");				
				hql.append("TDetalleCompras tdc ");			
				hql.append("inner join tdc.TComprasIngresos tcd ");
				hql.append("inner join tdc.TEspecifica esp ");
				hql.append("inner join tdc.TCuentaContable tcc ");
				hql.append("where tci.intIdfRegistro = :int_id_registro ");	
				hql.append("and tci.intIdfTransaccion = :int_transaccion ");
				hql.append("and tdc.intIdfRegistro = :int_id_registro ");
				hql.append("and tcd.srlIdCompras = tci.srlIdCompras ");
				if (!isNullOrEmpty(compra.getTip_operacion())) {
					hql.append("and tci.chrTipOperacion = :tip_operacion ");
				}					
				if (!isNullInteger(compra.getCod_uni_operativa())) {
					hql.append("and uni.idunidad = :cod_uni_operativa ");
				}
				if (!isNullInteger(compra.getCod_reg_nac())) {
					hql.append("and reg.idRanac = :cod_reg_nac ");
				}
				if (!isNullOrEmpty(compra.getNro_doc_rc())) {
					hql.append("and tci.chrNumDocuOperacion = :nro_doc_rc ");
				}
				if (!isNullLong(compra.getNum_ruc())) {
					hql.append("and ttp.numRuc = :num_ruc ");
				}
				if (!isNullOrEmpty(compra.getFec_inicio()) && !isNullOrEmpty(compra.getFec_final())) {
					hql.append("and tci.dteFecComprobante between :fec_inicio and :fec_final ");
				}
				if (!isNullOrEmpty(compra.getNro_cp())) {
					hql.append("and trim(tci.chrNumCompOperacion) = :nro_cp ");
				}
				if (!isNullInteger(compra.getCod_mes())) {
					hql.append("and tci.intMes = :cod_mes ");
				}
				if (!isNullInteger(compra.getCod_anno())) {
					hql.append("and tci.intAnno = :cod_anno ");
				}
				hql.append("order by tdc.chrCodMeta,trim(esp.chr_cod_especifica),tci.srlIdCompras");

			} else if (compra.getCod_servicio().equals(Constantes.THREE_INT)) { // Reporte de Compras
				hql.append("select tci.srlIdCompras as cod_compra, ");	
				hql.append("ttc.srlIdComprobante as cod_comprobante, ttc.chrNomComprobante as tip_comprobante, ");
				hql.append("ttc.chrCodComprobante as vcod_comprobante, ");				
				hql.append("case ");			
				hql.append("when (ttp.srlIdProveedor > 0) then '06' ");				
				hql.append("when (ttp.srlIdProveedor is null and ttc.chrCodComprobante = '02') then '06' ");
				hql.append("else '' ");
				hql.append("end as tip_documento, ");
				hql.append("ttm.srlIdMoneda as cod_moneda, ttm.chrNomMoneda as tip_moneda, ");				
				hql.append("ttm.chrSiglas as sig_moneda, ");				
				hql.append("case ttm.chrCodMoneda ");			
				hql.append("when '2' then '0' ");
				hql.append("when '1' then '1' ");
				hql.append("else '' ");
				hql.append("end as tip_mon_coa, ");				
				hql.append("case ");			
				hql.append("when (ttc.chrCodComprobante = '02' and tpc.numRuc is not null) then tpc.numRuc ");
				hql.append("when (ttc.chrCodComprobante != '02' and ttp.numRuc is not null) then cast(ttp.numRuc as string) ");
				hql.append("when (ttc.chrCodComprobante != '02' and ttp.chrNumDocumento is not null) then ttp.chrNumDocumento ");
				hql.append("else '' ");
				hql.append("end as ruc_nro_doc_prov, ");
				hql.append("case ");			
				hql.append("when (ttc.chrCodComprobante = '02' and trim(tpc.chrNombres) != '') then concat(tpc.chrNombres, ' ', tpc.chrApePaterno, ' ', tpc.chrApeMaterno) ");
				hql.append("when (ttc.chrCodComprobante != '02' and trim(ttp.chrRazSocial) != '') then ttp.chrRazSocial ");
				hql.append("when (ttc.chrCodComprobante != '02' and trim(ttp.chrNombres) != '') then concat(ttp.chrNombres, ' ', ttp.chrApePaterno, ' ', ttp.chrApeMaterno) ");
				hql.append("else '' ");
				hql.append("end as raz_soc_prov, ");
				hql.append("trim(tci.chrSerComprobante) as ser_comprobante, trim(tci.chrNumComprobante) as nro_comprobante, ");
				hql.append("concat(trim(tci.chrSerComprobante), '-', trim(tci.chrNumComprobante)) as ser_nro_comprobante, ");
				hql.append("to_char(tci.dteFecComprobante, 'DD/MM/YYYY') as fec_comprobante, ");				
				hql.append("case ");			
				hql.append("when (tci.dteFecVtoservicio is not null) then to_char(tci.dteFecVtoservicio, 'DD/MM/YYYY') ");
				hql.append("else to_char(tci.dteFecComprobante, 'DD/MM/YYYY') ");
				hql.append("end as fec_vto, ");				
				hql.append("to_char(tci.dteFecVtoservicio, 'DD/MM/YYYY') as fec_vencimiento, ");
				hql.append("uni.idunidad as cod_uni_operativa, uni.nomunidad as des_uni_operativa, ");
				hql.append("reg.idRanac as cod_reg_nac, coalesce(reg.nombre, '') as des_reg_nac, ");			
				hql.append("tci.numTipCambio as num_tip_cambio,tci.chrCpReten as ind_cp_reten, ");
				hql.append("to_char(tci.dteFecCondeposito, 'DD/MM/YYYY') as fec_pag_deposito, ");	
				hql.append("tci.intCodPadComIngresos as cod_pad_com_ingresos, ");				
				hql.append("case when (tci.numTipCambio > 0) then (tci.numTipCambio * ");
				hql.append("sum(tdc.numImpAfecto)) ");
				hql.append("else ");
				hql.append("sum(tdc.numImpAfecto) ");
				hql.append("end as num_imp_afecto, ");				
				hql.append("case when (tci.numTipCambio > 0) then (tci.numTipCambio * ");
				hql.append("sum(tdc.numImpNoafecto)) ");
				hql.append("else ");
				hql.append("sum(tdc.numImpNoafecto) ");
				hql.append("end as num_imp_no_afecto, ");				
				hql.append("case when (tci.numTipCambio > 0) then (tci.numTipCambio * ");
				hql.append("sum(tdc.numImpIgv)) ");
				hql.append("else ");
				hql.append("sum(tdc.numImpIgv) ");
				hql.append("end as num_imp_igv, ");				
				hql.append("case when (tci.numTipCambio > 0) then (tci.numTipCambio * ");
				hql.append("sum(tdc.numImpIsc)) ");
				hql.append("else ");
				hql.append("sum(tdc.numImpIsc) ");
				hql.append("end as num_imp_isc, ");
				hql.append("case when (tci.numTipCambio > 0) then (tci.numTipCambio * ");
				hql.append("(sum(tdc.numImpAfecto) + sum(tdc.numImpNoafecto) + ");
				hql.append("sum(tdc.numImpIgv) + sum(tdc.numImpIsc))) ");
				hql.append("else ");
				hql.append("(sum(tdc.numImpAfecto) + sum(tdc.numImpNoafecto) + ");
				hql.append("sum(tdc.numImpIgv) + sum(tdc.numImpIsc)) ");
				hql.append("end as imp_det_total, ");
				hql.append("trim(tci.chrNumConstancia) as num_constancia, ");
				hql.append("to_char(tci.dteFecCondeposito, 'DD/MM/YYYY') as fec_pag_deposito, ");
				hql.append("trim(tci.chrCpReten) as ind_cp_reten, ");
				hql.append("case when (tci.numTipCambio > 0) then (tci.numTipCambio * ");
				hql.append("(sum(tdc.numImpNoafecto) * 0.18)) ");
				hql.append("else ");
				hql.append("(sum(tdc.numImpNoafecto) * 0.18) ");
				hql.append("end as imp_no_gra_igv, ");
				hql.append("case when (tci.numTipCambio > 0) then (tci.numTipCambio * ");
				hql.append("(sum(tdc.numImpNoafecto) + (sum(tdc.numImpNoafecto) * 0.18))) ");
				hql.append("else ");
				hql.append("(sum(tdc.numImpNoafecto) + (sum(tdc.numImpNoafecto) * 0.18)) ");
				hql.append("end as imp_gra_total, ");
				hql.append("case ");			
				hql.append("when (ttc.chrCodComprobante != '02' and tdc.chrTipVenta = '2') then '004' ");
				hql.append("when (ttc.chrCodComprobante != '02' and tdc.chrTipVenta = '3') then '004' ");
				hql.append("when (ttc.chrCodComprobante != '02' and tdc.chrTipVenta = '4') then '004' ");
				hql.append("when (ttc.chrCodComprobante = '02' and tdc.chrTipVenta = '1') then '002' ");
				hql.append("else '' ");
				hql.append("end as cod_adq_coa, ");
				hql.append("case ");			
				hql.append("when (ttp.chrTipProveedor = '1') then '6' ");
				hql.append("when (ttp.chrTipProveedor = '2') then '6' ");
				hql.append("when (ttp.chrTipProveedor = '3' and tdi.srlIdDocumento = '2') then '1' ");				
				hql.append("when (ttp.chrTipProveedor = '3' and tdi.srlIdDocumento = '3') then '4' ");
				hql.append("when (ttp.chrTipProveedor = '4') then '0' ");
				hql.append("else '' ");
				hql.append("end as tip_doc_proveedor ");
				hql.append("from TComprasIngresos tci ");			
				hql.append("inner join tci.TTipoComprobante ttc ");
				hql.append("inner join tci.TTipoMoneda ttm ");
				hql.append("left join tci.TTipoProveedor ttp ");
				hql.append("left join ttp.TDocumentoIdentidad tdi ");
				hql.append("left join tci.unidadoperativa uni ");
				hql.append("left join tci.tbtRegistroNac reg ");
				hql.append("left join tci.TPersonalCuarta tpc, ");
				hql.append("TDetalleCompras tdc ");			
				hql.append("inner join tdc.TComprasIngresos tcd ");
				hql.append("where tci.intIdfRegistro = :int_id_registro ");
				hql.append("and tci.intIdfTransaccion = :int_transaccion ");
				hql.append("and tci.srlIdCompras = tcd.srlIdCompras ");
				hql.append("and tdc.intIdfRegistro = :int_id_registro ");
				hql.append("and ttc.chrFlgCompras = :flg_compras ");
				if (!isNullOrEmpty(compra.getTip_operacion()) && 
						compra.getTip_operacion().equals(Constantes.ONE_STRING)) { // Unidad Operativa
					hql.append("and tci.chrTipOperacion = :tip_operacion ");
				}					
				if (!isNullInteger(compra.getCod_uni_operativa())) {
					hql.append("and uni.idunidad = :cod_uni_operativa ");
				}
				if (!isNullInteger(compra.getCod_reg_nac())) {
					hql.append("and reg.idRanac = :cod_reg_nac ");
				}
				if (!isNullLong(compra.getNum_ruc())) {
					hql.append("and ttp.numRuc = :num_ruc ");
				}
				if (!isNullOrEmpty(compra.getFec_inicio()) && !isNullOrEmpty(compra.getFec_final())) {
					hql.append("and tci.dteFecComprobante between :fec_inicio and :fec_final ");
				}
				if (!isNullOrEmpty(compra.getNro_cp())) {
					hql.append("and tci.chrNumCompOperacion = :nro_cp ");
				}
				if (!isNullInteger(compra.getCod_mes())) {
					hql.append("and tci.intMes = :cod_mes ");
				}			
				
				if (!isNullInteger(compra.getCod_anno())) {
					hql.append("and tci.intAnno = :cod_anno ");
				}
				
				hql.append("group by tci.srlIdCompras, ttc.srlIdComprobante, ttc.chrNomComprobante, ");				
				hql.append("ttc.chrCodComprobante, ttp.srlIdProveedor, ttm.srlIdMoneda, ttm.chrNomMoneda, ttm.chrCodMoneda, ttm.chrSiglas, ");				
				hql.append("tci.chrSerComprobante, tci.chrNumComprobante, tci.dteFecComprobante, uni.idunidad, uni.nomunidad, reg.idRanac, ");				
				hql.append("tpc.numRuc, ttp.numRuc, ttp.chrNumDocumento, ttp.chrRazSocial, tpc.chrNombres, ");
				hql.append("tpc.chrApePaterno, tpc.chrApeMaterno, ttp.chrNombres, ttp.chrApePaterno, ttp.chrApeMaterno, ");
				hql.append("tci.dteFecVtoservicio, reg.nombre, tci.numTipCambio, tci.chrNumConstancia, tci.dteFecCondeposito, tdc.chrTipVenta, ");				
				hql.append("ttp.chrTipProveedor, tdi.srlIdDocumento ");
				hql.append("order by tci.dteFecComprobante, ttc.chrNomComprobante, tci.chrSerComprobante, tci.chrNumComprobante,tpc.numRuc ");
			} else if (compra.getCod_servicio().equals(Constantes.FOUR_INT)) { // Registro de Compras
				hql.append("select tci.srlIdCompras as cod_compra, ");	
				hql.append("ttc.srlIdComprobante as cod_comprobante, ttc.chrNomComprobante as tip_comprobante, ");
				hql.append("ttc.chrCodComprobante as vcod_comprobante, ");				
				hql.append("case ");			
				hql.append("when (ttp.srlIdProveedor > 0) then '06' ");				
				hql.append("when (ttp.srlIdProveedor is null and ttc.chrCodComprobante = '02') then '06' ");
				hql.append("else '' ");
				hql.append("end as tip_documento, ");
				hql.append("ttm.srlIdMoneda as cod_moneda, ttm.chrNomMoneda as tip_moneda, ");				
				hql.append("ttm.chrSiglas as sig_moneda, ");				
				hql.append("case ttm.chrCodMoneda ");			
				hql.append("when '2' then '0' ");
				hql.append("when '1' then '1' ");
				hql.append("else '' ");
				hql.append("end as tip_mon_coa, ");				
				hql.append("case ");			
				hql.append("when (ttc.chrCodComprobante = '02' and tpc.numRuc is not null) then tpc.numRuc ");
				hql.append("when (ttc.chrCodComprobante != '02' and ttp.numRuc is not null) then cast(ttp.numRuc as string) ");
				hql.append("when (ttc.chrCodComprobante != '02' and ttp.chrNumDocumento is not null) then ttp.chrNumDocumento ");
				hql.append("else '' ");
				hql.append("end as ruc_nro_doc_prov, ");
				hql.append("case ");			
				hql.append("when (ttc.chrCodComprobante = '02' and trim(tpc.chrNombres) != '') then concat(tpc.chrNombres, ' ', tpc.chrApePaterno, ' ', tpc.chrApeMaterno) ");
				hql.append("when (ttc.chrCodComprobante != '02' and trim(ttp.chrRazSocial) != '') then ttp.chrRazSocial ");
				hql.append("when (ttc.chrCodComprobante != '02' and trim(ttp.chrNombres) != '') then concat(ttp.chrNombres, ' ', ttp.chrApePaterno, ' ', ttp.chrApeMaterno) ");
				hql.append("else '' ");
				hql.append("end as raz_soc_prov, ");
				hql.append("trim(tci.chrSerComprobante) as ser_comprobante, trim(tci.chrNumComprobante) as nro_comprobante, ");
				hql.append("concat(trim(tci.chrSerComprobante), '-', trim(tci.chrNumComprobante)) as ser_nro_comprobante, ");
				hql.append("to_char(tci.dteFecComprobante, 'DD/MM/YYYY') as fec_comprobante, ");				
				hql.append("case ");			
				hql.append("when (tci.dteFecVtoservicio is not null) then to_char(tci.dteFecVtoservicio, 'DD/MM/YYYY') ");
				hql.append("else to_char(tci.dteFecComprobante, 'DD/MM/YYYY') ");
				hql.append("end as fec_vto, ");				
				hql.append("to_char(tci.dteFecVtoservicio, 'DD/MM/YYYY') as fec_vencimiento, ");
				hql.append("uni.idunidad as cod_uni_operativa, uni.nomunidad as des_uni_operativa, ");
				hql.append("reg.idRanac as cod_reg_nac, coalesce(reg.nombre, '') as des_reg_nac, ");			
				hql.append("tci.numTipCambio as num_tip_cambio, trim(tci.chrNumConstancia) as num_constancia, ");
				hql.append("to_char(tci.dteFecCondeposito, 'DD/MM/YYYY') as fec_pag_deposito, ");				
				hql.append("tci.intCodPadComIngresos as cod_pad_com_ingresos, ");				
				hql.append("case when (tci.numTipCambio > 0) then (tci.numTipCambio * ");
				hql.append("sum(tdc.numImpAfecto)) ");
				hql.append("else ");
				hql.append("sum(tdc.numImpAfecto) ");
				hql.append("end as num_imp_afecto, ");				
				hql.append("case when (tci.numTipCambio > 0) then (tci.numTipCambio * ");
				hql.append("sum(tdc.numImpNoafecto)) ");
				hql.append("else ");
				hql.append("sum(tdc.numImpNoafecto) ");
				hql.append("end as num_imp_no_afecto, ");				
				hql.append("case when (tci.numTipCambio > 0) then (tci.numTipCambio * ");
				hql.append("sum(tdc.numImpIgv)) ");
				hql.append("else ");
				hql.append("sum(tdc.numImpIgv) ");
				hql.append("end as num_imp_igv, ");				
				hql.append("case when (tci.numTipCambio > 0) then (tci.numTipCambio * ");
				hql.append("sum(tdc.numImpIsc)) ");
				hql.append("else ");
				hql.append("sum(tdc.numImpIsc) ");
				hql.append("end as num_imp_isc, ");
				hql.append("case when (tci.numTipCambio > 0) then (tci.numTipCambio * ");
				hql.append("(sum(tdc.numImpAfecto) + sum(tdc.numImpNoafecto) + ");
				hql.append("sum(tdc.numImpIgv) + sum(tdc.numImpIsc))) ");
				hql.append("else ");
				hql.append("(sum(tdc.numImpAfecto) + sum(tdc.numImpNoafecto) + ");
				hql.append("sum(tdc.numImpIgv) + sum(tdc.numImpIsc)) ");
				hql.append("end as imp_det_total, ");
				hql.append("case when (tci.numTipCambio > 0) then (tci.numTipCambio * ");
				hql.append("(sum(tdc.numImpNoafecto) * 0.18)) ");
				hql.append("else ");
				hql.append("(sum(tdc.numImpNoafecto) * 0.18) ");
				hql.append("end as imp_no_gra_igv, ");
				hql.append("case when (tci.numTipCambio > 0) then (tci.numTipCambio * ");
				hql.append("(sum(tdc.numImpNoafecto) + (sum(tdc.numImpNoafecto) * 0.18))) ");
				hql.append("else ");
				hql.append("(sum(tdc.numImpNoafecto) + (sum(tdc.numImpNoafecto) * 0.18)) ");
				hql.append("end as imp_gra_total, ");
				hql.append("case ");			
				hql.append("when (ttc.chrCodComprobante != '02' and tdc.chrTipVenta = '2') then '004' ");
				hql.append("when (ttc.chrCodComprobante != '02' and tdc.chrTipVenta = '3') then '004' ");
				hql.append("when (ttc.chrCodComprobante != '02' and tdc.chrTipVenta = '4') then '004' ");
				hql.append("when (ttc.chrCodComprobante = '02' and tdc.chrTipVenta = '1') then '002' ");
				hql.append("else '' ");
				hql.append("end as cod_adq_coa, ");
				hql.append("case ");			
				hql.append("when (ttp.chrTipProveedor = '1') then '6' ");
				hql.append("when (ttp.chrTipProveedor = '2') then '6' ");
				hql.append("when (ttp.chrTipProveedor = '3' and tdi.srlIdDocumento = '2') then '1' ");				
				hql.append("when (ttp.chrTipProveedor = '3' and tdi.srlIdDocumento = '3') then '4' ");
				hql.append("when (ttp.chrTipProveedor = '4') then '0' ");
				hql.append("else '' ");
				hql.append("end as tip_doc_proveedor, ");
				hql.append("tci.chrTipOperacion as tip_operacion, ");				
				hql.append("case ");			
				hql.append("when (ttp.chrTipProveedor = '1') then 'RUC' ");
				hql.append("when (ttp.chrTipProveedor = '2') then 'RUC' ");
				hql.append("when (ttp.chrTipProveedor = '3' and tdi.srlIdDocumento = '2') then 'DNI' ");				
				hql.append("when (ttp.chrTipProveedor = '3' and tdi.srlIdDocumento = '3') then 'C/E' ");
				hql.append("when (ttp.chrTipProveedor = '4') then 'VAR' ");
				hql.append("else '' ");
				hql.append("end as des_tip_documento, ");				
				hql.append("(sum(tdc.numImpAfecto) + sum(tdc.numImpNoafecto) + ");
				hql.append("sum(tdc.numImpIgv) + sum(tdc.numImpIsc)) as imp_det_total_dolares ");				
				hql.append("from TComprasIngresos tci ");			
				hql.append("inner join tci.TTipoComprobante ttc ");
				hql.append("inner join tci.TTipoMoneda ttm ");
				hql.append("left join tci.TTipoProveedor ttp ");
				hql.append("left join ttp.TDocumentoIdentidad tdi ");
				hql.append("left join tci.unidadoperativa uni ");
				hql.append("left join tci.tbtRegistroNac reg ");
				hql.append("left join tci.TPersonalCuarta tpc, ");
				hql.append("TDetalleCompras tdc ");			
				hql.append("inner join tdc.TComprasIngresos tcd ");
				hql.append("where tci.intIdfRegistro = :int_id_registro ");
				hql.append("and tci.intIdfTransaccion = :int_transaccion ");
				hql.append("and tci.srlIdCompras = tcd.srlIdCompras ");
				hql.append("and tdc.intIdfRegistro = :int_id_registro ");
				hql.append("and ttc.chrFlgCompras = :flg_compras ");
				if (!isNullOrEmpty(compra.getTip_operacion()) && 
						compra.getTip_operacion().equals(Constantes.ONE_STRING)) { // Unidad Operativa
					hql.append("and tci.chrTipOperacion = :tip_operacion ");
				}					
				if (!isNullInteger(compra.getCod_uni_operativa())) {
					hql.append("and uni.idunidad = :cod_uni_operativa ");
				}
				if (!isNullInteger(compra.getCod_reg_nac())) {
					hql.append("and reg.idRanac = :cod_reg_nac ");
				}
				if (!isNullLong(compra.getNum_ruc())) {
					hql.append("and ttp.numRuc = :num_ruc ");
				}
				if (!isNullOrEmpty(compra.getFec_inicio()) && !isNullOrEmpty(compra.getFec_final())) {
					hql.append("and tci.dteFecComprobante between :fec_inicio and :fec_final ");
				}
				if (!isNullOrEmpty(compra.getNro_cp())) {
					hql.append("and tci.chrNumCompOperacion = :nro_cp ");
				}
				if (!isNullInteger(compra.getCod_mes())) {
					hql.append("and tci.intMes = :cod_mes ");
				}
				if (!isNullInteger(compra.getCod_anno())) {
					hql.append("and tci.intAnno = :cod_anno ");
				}				
				hql.append("group by tci.srlIdCompras, ttc.srlIdComprobante, ttc.chrNomComprobante, ");				
				hql.append("ttc.chrCodComprobante, ttp.srlIdProveedor, ttm.srlIdMoneda, ttm.chrNomMoneda, ttm.chrCodMoneda, ttm.chrSiglas, ");				
				hql.append("tci.chrSerComprobante, tci.chrNumComprobante, tci.dteFecComprobante, uni.idunidad, uni.nomunidad, reg.idRanac, ");				
				hql.append("tpc.numRuc, ttp.numRuc, ttp.chrNumDocumento, ttp.chrRazSocial, tpc.chrNombres, ");
				hql.append("tpc.chrApePaterno, tpc.chrApeMaterno, ttp.chrNombres, ttp.chrApePaterno, ttp.chrApeMaterno, ");
				hql.append("tci.dteFecVtoservicio, reg.nombre, tci.numTipCambio, tci.chrNumConstancia, tci.dteFecCondeposito, tdc.chrTipVenta, ");				
				hql.append("ttp.chrTipProveedor, tdi.srlIdDocumento, tci.chrTipOperacion ");
				hql.append("order by uni.nomunidad, reg.nombre, ttc.chrNomComprobante, tci.dteFecComprobante, ");
				hql.append("tci.chrSerComprobante, tci.chrNumComprobante ");
			}
			Query query = super.getSession().createQuery(hql.toString());
			query.setParameter("int_id_registro", Constantes.ESTADO_ACTIVO);
			query.setParameter("int_transaccion", compra.getInt_transaccion());
			boolean ind_rep = true;
			if ((compra.getCod_servicio().equals(Constantes.THREE_INT)  || 
					compra.getCod_servicio().equals(Constantes.FOUR_INT)) && 
					compra.getTip_operacion().equals(Constantes.TWO_STRING)) {
				ind_rep = false;
			}			
			if (!isNullOrEmpty(compra.getTip_operacion()) && ind_rep) { // Unidad Operativa
				query.setParameter("tip_operacion", compra.getTip_operacion());
			}
			if (!isNullInteger(compra.getCod_uni_operativa())) {
				query.setParameter("cod_uni_operativa", compra.getCod_uni_operativa());
			}
			if (!isNullInteger(compra.getCod_reg_nac())) {
				query.setParameter("cod_reg_nac", compra.getCod_reg_nac());
			}
			if (!isNullLong(compra.getNum_ruc())) {
				query.setParameter("num_ruc", compra.getNum_ruc());
			}
			if (!isNullOrEmpty(compra.getFec_inicio()) && !isNullOrEmpty(compra.getFec_final())) {
				query.setParameter("fec_inicio", getDate(compra.getFec_inicio()));
				query.setParameter("fec_final", getDate(compra.getFec_final()));
			}
			if (compra.getCod_servicio().equals(Constantes.ONE_INT)||compra.getCod_servicio().equals(Constantes.TWO_INT)) { // Consolidado de Partidas por Rendición de Cuenta
				if (!isNullOrEmpty(compra.getNro_doc_rc())) {
					query.setParameter("nro_doc_rc", compra.getNro_doc_rc());
				}
			}
			if (!isNullOrEmpty(compra.getNro_cp())) {
				query.setParameter("nro_cp", compra.getNro_cp());
			}
			
			if (compra.getCod_servicio().equals(Constantes.ONE_INT)) { // Consolidado de Partidas por Rendición de Cuenta
				query.setParameter("cod_comprobante", getInteger(ReadParameterProperties.getPropiedad("codigo.comprobante.devoluciones"))); // Devoluciones
			} else {
				if (!isNullInteger(compra.getCod_mes())) {
					query.setParameter("cod_mes", compra.getCod_mes());
				}
				if (!isNullInteger(compra.getCod_anno())) {
					query.setParameter("cod_anno", compra.getCod_anno());
				}				
				if (compra.getCod_servicio().equals(Constantes.THREE_INT) || 
						compra.getCod_servicio().equals(Constantes.FOUR_INT)) { // Reporte de Compras
					query.setParameter("flg_compras", Constantes.FLAG_ACTIVO);
				}
			}

						
			return query.setResultTransformer(Transformers.aliasToBean(ReporteDetalleComprasBean.class)).list();
		} catch (Exception e) {
			throw new Exception(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(), 
								Constantes.NIVEL_APP_DAO, 
								this.getClass().getName(), e.getMessage()));
		}
	}

	/* (non-Javadoc)
	 * @see pe.com.mig.dao.IComprasIngresosDao#listarReporteIngresos(pe.com.mig.model.bean.ComprasIngresosBean)
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<ReporteDetalleIngresosBean> listarReporteIngresos(ComprasIngresosBean ingreso) throws Exception {
		try {
			StringBuilder hql = new StringBuilder();
			if (!ingreso.getTip_transaccion().equals(Constantes.SIX_STRING) &&
	        		!ingreso.getTip_transaccion().equals(Constantes.SEVEN_STRING)) {
				hql.append("select tci.srlIdCompras as cod_com_ingresos, ");	
				hql.append("ttc.srlIdComprobante as cod_comprobante, ttc.chrNomComprobante as tip_comprobante, ");
				hql.append("ttc.chrSiglas as tip_com_siglas, ttc.chrCodComprobante as vcod_comprobante, ");
				hql.append("case tdn.chrCodDocumento ");			
				hql.append("when '1' then '01' ");
				hql.append("when '4' then '04' ");
				hql.append("when '6' then '06' ");
				hql.append("when '7' then '07' ");
				hql.append("else '' ");
				hql.append("end as tip_documento, ");
				hql.append("ttm.srlIdMoneda as cod_moneda, ttm.chrNomMoneda as tip_moneda, ");
				hql.append("ttp.srlIdProveedor as cod_proveedor, ttp.numRuc as num_ruc, ");			
				hql.append("ttp.chrTipProveedor as tip_proveedor, ttp.chrTipEstado as tip_estado, ");
				hql.append("case ttp.chrTipProveedor ");			
				hql.append("when '1' then concat(ttp.chrNombres, ' ', ttp.chrApePaterno, ' ', ttp.chrApeMaterno) ");
				hql.append("when '2' then ttp.chrRazSocial ");
				hql.append("end as raz_social, ");			
				hql.append("case ");			
				hql.append("when (ttp.numRuc is not null) then cast(ttp.numRuc as string) ");
				hql.append("else ttp.chrNumDocumento ");
				hql.append("end as ruc_nro_doc_prov, ");
				hql.append("case ");			
				hql.append("when (ttp.chrRazSocial is not null and trim(ttp.chrRazSocial) != '') then ttp.chrRazSocial ");
				hql.append("else concat(ttp.chrNombres, ' ', ttp.chrApePaterno, ' ', ttp.chrApeMaterno) ");
				hql.append("end as raz_soc_prov, ");
				hql.append("tci.intIdfTransaccion as int_transaccion, trim(tci.chrSerComprobante) as ser_comprobante, ");
				hql.append("trim(tci.chrNumComprobante) as nro_comprobante, tci.numImpTotal as imp_total, ");
				hql.append("to_char(tci.dteFecComprobante, 'DD/MM/YYYY') as fec_comprobante, ");
				hql.append("to_char(tci.dteFecVtoservicio, 'DD/MM/YYYY') as fec_vto, ");				
				hql.append("uni.idunidad as cod_uni_operativa, uni.nomunidad as des_uni_operativa, ");
				hql.append("reg.idRanac as cod_reg_nac, coalesce(reg.nombre, '') as des_reg_nac, ");			
				hql.append("tci.intCodPadComIngresos as cod_pad_com_ingresos, ");
				hql.append("tci.numImpVoucher as num_imp_voucher, tci.numTipCambio as num_tip_cambio, ");
				hql.append("tdi.srlIdDetalle as cod_det_ingreso, ");		
				hql.append("tdi.numPreUnitario as num_pre_unitario, tdi.intCanDias as can_dias, ");
				hql.append("tdi.intCanProducto as can_producto, tdi.intIniBoleto as ini_boleto, ");
				hql.append("case when (tdi.intFinBoleto is not null) then tdi.intFinBoleto ");
				hql.append("when (tdi.intIniBoleto is not null) then (tdi.intCanProducto + tdi.intIniBoleto - 1) ");
				hql.append("else null ");			
				hql.append("end as fin_boleto, ");
				hql.append("tdi.chrTipTransaccion as tip_transaccion, tdi.chrTipVenta as cod_tip_venta, ");			
				hql.append("case tdi.chrTipVenta when '1' then ' 002 Gravada Sernanp' ");
				hql.append("when '2' then '001 Gravada c/expor' ");
				hql.append("when '3' then '003 Gravada s/expor' ");
				hql.append("when '4' then '004 No Gravada' ");
				hql.append("end as des_tip_venta, ");									
				hql.append("case when (tci.numTipCambio > 0) then (tci.numTipCambio * tdi.numImpAfecto) ");
				hql.append("else tdi.numImpAfecto ");
				hql.append("end as num_imp_afecto, ");			
				hql.append("case when (tci.numTipCambio > 0) then (tci.numTipCambio * tdi.numImpNoafecto) ");
				hql.append("else tdi.numImpNoafecto ");
				hql.append("end as num_imp_no_afecto, ");			
				hql.append("case when (tci.numTipCambio > 0) then (tci.numTipCambio * tdi.numImpIgv) ");
				hql.append("else tdi.numImpIgv ");
				hql.append("end as num_imp_igv, ");			
				hql.append("case when (tci.numTipCambio > 0) then (tci.numTipCambio * tdi.numImpIsc) ");
				hql.append("else tdi.numImpIsc ");
				hql.append("end as num_imp_isc, ");
				hql.append("case when (tci.numTipCambio > 0) then (tci.numTipCambio * (tdi.numImpAfecto + ");
				hql.append("tdi.numImpNoafecto + tdi.numImpIgv + tdi.numImpIsc)) ");
				hql.append("else (tdi.numImpAfecto + tdi.numImpNoafecto + ");
				hql.append("tdi.numImpIgv + tdi.numImpIsc) ");			
				hql.append("end as imp_det_total, ");					
				hql.append("trim(tci.chrNumCtaCte) as num_cta_cte, ");
				hql.append("tts.srlIdServicio as cod_servicio, ");
				hql.append("tts.chrCodServicio as vcod_servicio, tts.chrNomServicio as des_servicio, ");
				hql.append("tts.numImpPventa as num_imp_pre_ven_servicio, ");			
				hql.append("tpr.srlIdProducto as cod_producto, tpr.chrCodProducto as vcod_producto, ");
				hql.append("tpr.chrNomProducto as nom_producto, tpr.numImpPventa as num_pre_uni_producto, ");
				hql.append("ttb.srlIdBoleto as cod_boleto, ttb.chrNomBoleto as des_boleto, ");
				hql.append("ttb.intNumSerie as num_ser_boleto, ttb.numImpUnit as num_imp_unit_boleto, ");				
				hql.append("case ttb.intIdfTarifa when 1 then 'Tarifa Plana' ");
				hql.append("when 2 then 'Tarifa Social' ");
				//hql.append("when 3 then 'Tarifa Promocion' end as des_ind_tarifa, ");
				hql.append("when 3 then 'Tarifa Promocion' ");				
				hql.append("when 4 then 'Tarifa Unica'");
				hql.append("when 5 then 'Tarifa Convencional' ");
				hql.append("when 6 then 'Tarifa Promocionales' end as des_ind_tarifa, ");
				
				hql.append("ttt.srlIdTupa as cod_tupa, ttt.chrCodTupa as vcod_tupa, ");
				hql.append("ttt.chrNomTupa as nom_tupa, ttt.numImpUnit as num_imp_unit_tupa, ");		
				hql.append("tot.srlIdOtros as cod_otros, tot.chrNomOtros as des_otros, ");			
				hql.append("case tci.intMes ");
				hql.append("when 1 then 'Enero' ");
				hql.append("when 2 then 'Febrero' ");
				hql.append("when 3 then 'Marzo' ");
				hql.append("when 4 then 'Abril' ");
				hql.append("when 5 then 'Mayo' ");
				hql.append("when 6 then 'Junio' ");
				hql.append("when 7 then 'Julio' ");
				hql.append("when 8 then 'Agosto' ");
				hql.append("when 9 then 'Setiembre' ");
				hql.append("when 10 then 'Octubre' ");
				hql.append("when 11 then 'Noviembre' ");
				hql.append("when 12 then 'Diciembre' ");			
				hql.append("else '' ");
				hql.append("end as periodo, ");
				hql.append("case ");
				hql.append("when (tts.srlIdServicio > 0) then trim(tts.chrCodEspecifica) ");
				hql.append("when (tpr.srlIdProducto > 0) then trim(tpr.chrCodEspecifica) ");
				hql.append("when (ttb.srlIdBoleto > 0) then trim(ttb.chrCodPartida) ");
				hql.append("when (ttt.srlIdTupa > 0) then trim(ttt.chrCodEspecifica) ");
				hql.append("when (tot.srlIdOtros > 0) then trim(tot.chrCodEspecifica) ");
				hql.append("end as cod_especifica, ");
				hql.append("case ");
				hql.append("when (tts.srlIdServicio > 0) then trim(tts.chrCodCuenta) ");
				hql.append("when (tpr.srlIdProducto > 0) then trim(tpr.chrCodCuenta) ");
				hql.append("when (ttb.srlIdBoleto > 0) then trim(ttb.chrCodCuenta) ");
				hql.append("when (ttt.srlIdTupa > 0) then trim(ttt.chrCodCuenta) ");
				hql.append("when (tot.srlIdOtros > 0) then trim(tot.chrCodCuenta) ");
				hql.append("end as cod_cuenta ");
				hql.append("from TComprasIngresos tci ");			
				hql.append("inner join tci.TTipoComprobante ttc ");
				hql.append("inner join tci.TTipoMoneda ttm ");
				hql.append("left join tci.TTipoProveedor ttp ");
				hql.append("left join ttp.TDocumentoIdentidad tdn ");
				hql.append("left join tci.unidadoperativa uni ");
				hql.append("left join tci.tbtRegistroNac reg, ");
				hql.append("TDetalleIngresos tdi ");			
				hql.append("inner join tdi.TComprasIngresos tcd ");
				hql.append("left join tdi.TTariServicio tts ");
				hql.append("left join tdi.TProducto tpr ");
				hql.append("left join tdi.TTariBoleto ttb ");
				hql.append("left join tdi.TTariTupa ttt ");
				hql.append("left join tdi.TOtros tot ");
				hql.append("where tci.intIdfRegistro = :int_id_registro ");
				hql.append("and tci.intIdfTransaccion = :int_transaccion ");
				hql.append("and tci.srlIdCompras = tcd.srlIdCompras ");
				hql.append("and tdi.intIdfRegistro = :int_id_registro ");
			} else if (ingreso.getTip_transaccion().equals(Constantes.SIX_STRING)) { // Registro de Ventas		
				hql.append("select tci.srlIdCompras as cod_com_ingresos, ");	
				hql.append("ttc.srlIdComprobante as cod_comprobante, ttc.chrNomComprobante as tip_comprobante, ");
				hql.append("ttc.chrSiglas as tip_com_siglas, ttc.chrCodComprobante as vcod_comprobante, ");
				hql.append("ttm.srlIdMoneda as cod_moneda, ttm.chrNomMoneda as tip_moneda, ");
				hql.append("ttm.chrSiglas as sig_moneda, ");
				hql.append("ttp.srlIdProveedor as cod_proveedor, ttp.numRuc as num_ruc, ");			
				hql.append("ttp.chrTipProveedor as tip_proveedor, ttp.chrTipEstado as tip_estado, ");
				hql.append("case ");			
				hql.append("when (ttp.numRuc is not null) then cast(ttp.numRuc as string) ");				
				hql.append("when (ttp.numRuc is null and ttp.chrTipProveedor = '4') then 'VARIOS' ");
				hql.append("else ttp.chrNumDocumento ");
				hql.append("end as ruc_nro_doc_prov, ");
				hql.append("case ");
				hql.append("when (ttp.chrRazSocial is not null and trim(ttp.chrRazSocial) != '') then ttp.chrRazSocial ");
				hql.append("when (ttp.chrRazSocial is null and ttp.chrTipProveedor = '4') then 'VARIOS' ");
				hql.append("else concat(ttp.chrNombres, ' ', ttp.chrApePaterno, ' ', ttp.chrApeMaterno) ");
				hql.append("end as raz_social, ");				
				hql.append("case ");			
				hql.append("when (ttp.chrRazSocial is not null and trim(ttp.chrRazSocial) != '') then ttp.chrRazSocial ");
				hql.append("when (ttp.chrRazSocial is null and ttp.chrTipProveedor = '4') then 'VARIOS' ");
				hql.append("else concat(ttp.chrNombres, ' ', ttp.chrApePaterno, ' ', ttp.chrApeMaterno) ");
				hql.append("end as raz_soc_prov, ");
				hql.append("case ");			
				hql.append("when (ttp.chrTipProveedor = '1') then 'RUC' ");
				hql.append("when (ttp.chrTipProveedor = '2') then 'RUC' ");
				hql.append("when (ttp.chrTipProveedor = '3' and tdn.srlIdDocumento = '2') then 'DNI' ");				
				hql.append("when (ttp.chrTipProveedor = '3' and tdn.srlIdDocumento = '3') then 'C/E' ");
				hql.append("when (ttp.chrTipProveedor = '4') then 'VAR' ");
				hql.append("else '' ");
				hql.append("end as tip_documento, ");
				hql.append("case ");			
				hql.append("when (ttp.chrTipProveedor = '1') then '6' ");
				hql.append("when (ttp.chrTipProveedor = '2') then '6' ");
				hql.append("when (ttp.chrTipProveedor = '3' and tdn.srlIdDocumento = '2') then '1' ");
				hql.append("when (ttp.chrTipProveedor = '3' and tdn.srlIdDocumento = '3') then '4' ");
				hql.append("when (ttp.chrTipProveedor = '4') then '0' ");
				hql.append("else '' ");
				hql.append("end as cod_tip_doc_proveedor, ");
				hql.append("trim(tci.chrSerComprobante) as ser_comprobante, trim(tci.chrNumComprobante) as nro_comprobante, ");
				hql.append("concat(trim(tci.chrSerComprobante), '-', trim(tci.chrNumComprobante)) as ser_nro_comprobante, ");
				hql.append("to_char(tci.dteFecComprobante, 'DD/MM/YYYY') as fec_comprobante, ");
				hql.append("to_char(tci.dteFecVtoservicio, 'DD/MM/YYYY') as fec_vto, ");
				hql.append("uni.idunidad as cod_uni_operativa, uni.nomunidad as des_uni_operativa, ");
				hql.append("reg.idRanac as cod_reg_nac, coalesce(reg.nombre, '') as des_reg_nac, ");			
				hql.append("tci.numTipCambio as num_tip_cambio, ");
				hql.append("case when (tci.numTipCambio > 0) then (tci.numTipCambio * ");
				hql.append("sum(tdi.numImpAfecto)) ");
				hql.append("else ");
				hql.append("sum(tdi.numImpAfecto) ");
				hql.append("end as num_imp_afecto, ");				
				hql.append("case when (tci.numTipCambio > 0) then (tci.numTipCambio * ");
				hql.append("sum(tdi.numImpNoafecto)) ");
				hql.append("else ");
				hql.append("sum(tdi.numImpNoafecto) ");
				hql.append("end as num_imp_no_afecto, ");				
				hql.append("case when (tci.numTipCambio > 0) then (tci.numTipCambio * ");
				hql.append("sum(tdi.numImpIgv)) ");
				hql.append("else ");
				hql.append("sum(tdi.numImpIgv) ");
				hql.append("end as num_imp_igv, ");				
				hql.append("case when (tci.numTipCambio > 0) then (tci.numTipCambio * ");
				hql.append("sum(tdi.numImpIsc)) ");
				hql.append("else ");
				hql.append("sum(tdi.numImpIsc) ");
				hql.append("end as num_imp_isc, ");
				hql.append("case when (tci.numTipCambio > 0) then (tci.numTipCambio * ");
				hql.append("(sum(tdi.numImpAfecto) + sum(tdi.numImpNoafecto) + ");
				hql.append("sum(tdi.numImpIgv) + sum(tdi.numImpIsc))) ");
				hql.append("else ");
				hql.append("(sum(tdi.numImpAfecto) + sum(tdi.numImpNoafecto) + ");
				hql.append("sum(tdi.numImpIgv) + sum(tdi.numImpIsc)) ");
				hql.append("end as imp_det_total, ");				
				hql.append("(sum(tdi.numImpAfecto) + sum(tdi.numImpNoafecto) + ");
				hql.append("sum(tdi.numImpIgv) + sum(tdi.numImpIsc)) as imp_det_total_dolares, ");			
				hql.append("case when (tci.numTipCambio > 0 and tdi.chrTipVenta = '3') ");
				hql.append("then (tci.numTipCambio * sum(tdi.numImpNoafecto)) ");
				hql.append("else ");
				hql.append("sum(tdi.numImpNoafecto) ");
				hql.append("end as imp_no_afe_tip_ven_exo, ");				
				hql.append("case when (tci.numTipCambio > 0 and tdi.chrTipVenta = '2') ");
				hql.append("then (tci.numTipCambio * sum(tdi.numImpNoafecto)) ");
				hql.append("else ");
				hql.append("sum(tdi.numImpNoafecto) ");
				hql.append("end as imp_no_afe_tip_ven_no_gra, ");
				hql.append("tci.chrTipOperacion as tip_operacion, ");
				hql.append("case ");			
				hql.append("when (ttp.chrTipProveedor = '1') then '06' ");
				hql.append("when (ttp.chrTipProveedor = '2') then '06' ");
				hql.append("when (ttp.chrTipProveedor = '3' and tdn.srlIdDocumento = '2') then '01' ");
				hql.append("when (ttp.chrTipProveedor = '3' and tdn.srlIdDocumento = '3') then '04' ");
				hql.append("else '' ");
				hql.append("end as tip_doc_proveedor, ");
				hql.append("tci.intCodPadComIngresos as cod_pad_com_ingresos ");
				hql.append("from TComprasIngresos tci ");			
				hql.append("inner join tci.TTipoComprobante ttc ");
				hql.append("inner join tci.TTipoMoneda ttm ");
				hql.append("left join tci.TTipoProveedor ttp ");
				hql.append("left join ttp.TDocumentoIdentidad tdn ");
				hql.append("left join tci.unidadoperativa uni ");
				hql.append("left join tci.tbtRegistroNac reg, ");
				hql.append("TDetalleIngresos tdi ");			
				hql.append("inner join tdi.TComprasIngresos tcd ");
				hql.append("where tci.intIdfRegistro = :int_id_registro ");
				hql.append("and tci.intIdfTransaccion = :int_transaccion ");
				hql.append("and tci.srlIdCompras = tcd.srlIdCompras ");
				hql.append("and tdi.intIdfRegistro = :int_id_registro ");
				hql.append("and ttc.chrFlgVentas = :flg_ventas ");
			} else if (ingreso.getTip_transaccion().equals(Constantes.SEVEN_STRING)) { // Formato 14.1 - Registro de Ventas
				hql.append("select tci.srlIdCompras as cod_com_ingresos, ");	
				hql.append("ttc.srlIdComprobante as cod_comprobante, ttc.chrNomComprobante as tip_comprobante, ");
				hql.append("ttc.chrSiglas as tip_com_siglas, ttc.chrCodComprobante as vcod_comprobante, ");
				hql.append("ttm.srlIdMoneda as cod_moneda, ttm.chrNomMoneda as tip_moneda, ");
				hql.append("ttp.srlIdProveedor as cod_proveedor, ttp.numRuc as num_ruc, ");			
				hql.append("ttp.chrTipProveedor as tip_proveedor, ttp.chrTipEstado as tip_estado, ");
				hql.append("case ");			
				hql.append("when (ttp.numRuc is not null) then cast(ttp.numRuc as string) ");				
				hql.append("when (ttp.numRuc is null and ttp.chrTipProveedor = '4') then 'VARIOS' ");
				hql.append("else ttp.chrNumDocumento ");
				hql.append("end as ruc_nro_doc_prov, ");
				hql.append("case ");
				hql.append("when (ttp.chrRazSocial is not null and trim(ttp.chrRazSocial) != '') then ttp.chrRazSocial ");
				hql.append("when (ttp.chrRazSocial is null and ttp.chrTipProveedor = '4') then 'VARIOS' ");
				hql.append("else concat(ttp.chrNombres, ' ', ttp.chrApePaterno, ' ', ttp.chrApeMaterno) ");
				hql.append("end as raz_social, ");				
				hql.append("case ");			
				hql.append("when (ttp.chrRazSocial is not null and trim(ttp.chrRazSocial) != '') then ttp.chrRazSocial ");
				hql.append("else concat(ttp.chrNombres, ' ', ttp.chrApePaterno, ' ', ttp.chrApeMaterno) ");
				hql.append("end as raz_soc_prov, ");
				hql.append("case ");			
				hql.append("when (ttp.chrTipProveedor = '1') then 'RUC' ");
				hql.append("when (ttp.chrTipProveedor = '2') then 'RUC' ");
				hql.append("when (ttp.chrTipProveedor = '3' and tdn.srlIdDocumento = '2') then 'DNI' ");				
				hql.append("when (ttp.chrTipProveedor = '3' and tdn.srlIdDocumento = '3') then 'C/E' ");
				hql.append("when (ttp.chrTipProveedor = '4') then 'VAR' ");
				hql.append("else '' ");
				hql.append("end as tip_documento, ");
				hql.append("case ");			
				hql.append("when (ttp.chrTipProveedor = '1') then '6' ");
				hql.append("when (ttp.chrTipProveedor = '2') then '6' ");
				hql.append("when (ttp.chrTipProveedor = '3' and tdn.srlIdDocumento = '2') then '1' ");
				hql.append("when (ttp.chrTipProveedor = '3' and tdn.srlIdDocumento = '3') then '4' ");
				hql.append("when (ttp.chrTipProveedor = '4') then '0' ");
				hql.append("else '' ");
				hql.append("end as cod_tip_doc_proveedor, ");
				hql.append("trim(tci.chrSerComprobante) as ser_comprobante, trim(tci.chrNumComprobante) as nro_comprobante, ");
				hql.append("concat(trim(tci.chrSerComprobante), '-', trim(tci.chrNumComprobante)) as ser_nro_comprobante, ");
				hql.append("to_char(tci.dteFecComprobante, 'DD/MM/YYYY') as fec_comprobante, ");
				hql.append("case ");			
				hql.append("when (tci.dteFecVtoservicio is not null) then to_char(tci.dteFecVtoservicio, 'DD/MM/YYYY') ");
				hql.append("else to_char(tci.dteFecComprobante, 'DD/MM/YYYY') ");
				hql.append("end as fec_vto, ");				
				hql.append("to_char(tci.dteFecVtoservicio, 'DD/MM/YYYY') as fec_vencimiento, ");
				hql.append("uni.idunidad as cod_uni_operativa, uni.nomunidad as des_uni_operativa, ");
				hql.append("reg.idRanac as cod_reg_nac, coalesce(reg.nombre, '') as des_reg_nac, ");			
				hql.append("tci.numTipCambio as num_tip_cambio, ");
				hql.append("case when (tci.numTipCambio > 0) then (tci.numTipCambio * ");
				hql.append("sum(tdi.numImpAfecto)) ");
				hql.append("else ");
				hql.append("sum(tdi.numImpAfecto) ");
				hql.append("end as num_imp_afecto, ");				
				hql.append("case when (tci.numTipCambio > 0) then (tci.numTipCambio * ");
				hql.append("sum(tdi.numImpNoafecto)) ");
				hql.append("else ");
				hql.append("sum(tdi.numImpNoafecto) ");
				hql.append("end as num_imp_no_afecto, ");				
				hql.append("case when (tci.numTipCambio > 0) then (tci.numTipCambio * ");
				hql.append("sum(tdi.numImpIgv)) ");
				hql.append("else ");
				hql.append("sum(tdi.numImpIgv) ");
				hql.append("end as num_imp_igv, ");				
				hql.append("case when (tci.numTipCambio > 0) then (tci.numTipCambio * ");
				hql.append("sum(tdi.numImpIsc)) ");
				hql.append("else ");
				hql.append("sum(tdi.numImpIsc) ");
				hql.append("end as num_imp_isc, ");
				hql.append("case when (tci.numTipCambio > 0) then (tci.numTipCambio * ");
				hql.append("(sum(tdi.numImpAfecto) + sum(tdi.numImpNoafecto) + ");
				hql.append("sum(tdi.numImpIgv) + sum(tdi.numImpIsc))) ");
				hql.append("else ");
				hql.append("(sum(tdi.numImpAfecto) + sum(tdi.numImpNoafecto) + ");
				hql.append("sum(tdi.numImpIgv) + sum(tdi.numImpIsc)) ");
				hql.append("end as imp_det_total, ");
				hql.append("(sum(tdi.numImpAfecto) + sum(tdi.numImpNoafecto) + ");
				hql.append("sum(tdi.numImpIgv) + sum(tdi.numImpIsc)) as imp_det_total_dolares, ");
				hql.append("tci.chrTipOperacion as tip_operacion, ");
				hql.append("case ");			
				hql.append("when (ttp.chrTipProveedor = '1') then '06' ");
				hql.append("when (ttp.chrTipProveedor = '2') then '06' ");
				hql.append("when (ttp.chrTipProveedor = '3' and tdn.srlIdDocumento = '2') then '01' ");
				hql.append("when (ttp.chrTipProveedor = '3' and tdn.srlIdDocumento = '3') then '04' ");
				hql.append("else '' ");
				hql.append("end as tip_doc_proveedor, ");
				hql.append("tci.intCodPadComIngresos as cod_pad_com_ingresos ");
				hql.append("from TComprasIngresos tci ");			
				hql.append("inner join tci.TTipoComprobante ttc ");
				hql.append("inner join tci.TTipoMoneda ttm ");
				hql.append("left join tci.TTipoProveedor ttp ");
				hql.append("left join ttp.TDocumentoIdentidad tdn ");
				hql.append("left join tci.unidadoperativa uni ");
				hql.append("left join tci.tbtRegistroNac reg, ");
				hql.append("TDetalleIngresos tdi ");			
				hql.append("inner join tdi.TComprasIngresos tcd ");
				hql.append("where tci.intIdfRegistro = :int_id_registro ");
				hql.append("and tci.intIdfTransaccion = :int_transaccion ");
				hql.append("and tci.srlIdCompras = tcd.srlIdCompras ");
				hql.append("and tdi.intIdfRegistro = :int_id_registro ");
				hql.append("and ttc.chrFlgVentas = :flg_ventas ");
			}
			if (!isNullOrEmpty(ingreso.getTip_operacion())) {
				boolean ind_rep = true;
				if ((ingreso.getTip_transaccion().equals(Constantes.SIX_STRING) ||
						ingreso.getTip_transaccion().equals(Constantes.SEVEN_STRING)) &&
						ingreso.getTip_operacion().equals(Constantes.TWO_STRING)) { // Sede Central
					ind_rep = false;
				}
				if (ind_rep) {
					hql.append("and tci.chrTipOperacion = :tip_operacion ");
				}
			}					
			if (!isNullInteger(ingreso.getCod_uni_operativa())) {
				hql.append("and uni.idunidad = :cod_uni_operativa ");
			}
			if (!isNullInteger(ingreso.getCod_reg_nac())) {
				hql.append("and reg.idRanac = :cod_reg_nac ");
			}
			if (!isNullLong(ingreso.getNum_ruc())) {
				hql.append("and ttp.numRuc = :num_ruc ");
			}
			if (!isNullOrEmpty(ingreso.getFec_inicio()) && !isNullOrEmpty(ingreso.getFec_final())) {
				hql.append("and tci.dteFecComprobante between :fec_inicio and :fec_final ");
			}
			if (!ingreso.getTip_transaccion().equals(Constantes.SIX_STRING) && 
	        		!ingreso.getTip_transaccion().equals(Constantes.SEVEN_STRING) &&
					!isNullOrEmpty(ingreso.getTip_transaccion())) {
				hql.append("and tdi.chrTipTransaccion = :tip_transaccion ");
			}
			if (!isNullInteger(ingreso.getCod_servicio())) {
				if (ingreso.getTip_transaccion().equals(Constantes.ONE_STRING)) {
					hql.append("and tts.srlIdServicio = :cod_servicio ");					
				} else if (ingreso.getTip_transaccion().equals(Constantes.TWO_STRING)) {
					hql.append("and tpr.srlIdProducto = :cod_servicio ");
				} else if (ingreso.getTip_transaccion().equals(Constantes.THREE_STRING)) {
					hql.append("and ttb.srlIdBoleto = :cod_servicio ");
				} else if (ingreso.getTip_transaccion().equals(Constantes.FOUR_STRING)) {
					hql.append("and ttt.srlIdTupa = :cod_servicio ");
				} else if (ingreso.getTip_transaccion().equals(Constantes.FIVE_STRING)) {
					hql.append("and tot.srlIdOtros = :cod_servicio ");
				}			
			}
			if (!isNullInteger(ingreso.getCod_mes())) {
				hql.append("and tci.intMes = :cod_mes ");
			}
			if (!isNullInteger(ingreso.getCod_anno())) {
				hql.append("and tci.intAnno = :cod_anno ");
			}			
			if (!ingreso.getTip_transaccion().equals(Constantes.SIX_STRING) &&
	        		!ingreso.getTip_transaccion().equals(Constantes.SEVEN_STRING)) {
				hql.append("order by tci.srlIdCompras");
			} else if (ingreso.getTip_transaccion().equals(Constantes.SIX_STRING)) { // Registro de Ventas
				hql.append("group by tci.srlIdCompras, ttc.srlIdComprobante, ttc.chrNomComprobante, ttc.chrSiglas, ");				
				hql.append("ttc.chrCodComprobante, ttm.srlIdMoneda, ttm.chrNomMoneda, ttm.chrSiglas, ttp.srlIdProveedor, ttp.numRuc, ");
				hql.append("ttp.chrTipProveedor, ttp.chrTipEstado, tci.chrSerComprobante, tci.chrNumComprobante, ");				
				hql.append("tci.dteFecComprobante, tci.dteFecVtoservicio, uni.idunidad, uni.nomunidad, reg.idRanac, tci.intCodPadComIngresos, ");
				hql.append("reg.nombre, tci.numTipCambio, tci.chrTipOperacion, tdn.srlIdDocumento, tdn.chrCodDocumento, tdi.chrTipVenta ");				
				if (!isNullInteger(ingreso.getInd_gen_archivo())) {
					hql.append("order by tci.dteFecComprobante asc");
				} else {				
					hql.append("order by uni.nomunidad, reg.nombre, ttc.chrNomComprobante, tci.dteFecComprobante, ttc.chrCodComprobante, ");
					hql.append("tci.chrSerComprobante, tci.chrNumComprobante");
				}
			} else if (ingreso.getTip_transaccion().equals(Constantes.SEVEN_STRING)) { // Formato 14.1 - Registro de Ventas
				hql.append("group by tci.srlIdCompras, ttc.srlIdComprobante, ttc.chrNomComprobante, ttc.chrSiglas, ");				
				hql.append("ttc.chrCodComprobante, ttm.srlIdMoneda, ttm.chrNomMoneda, ttp.srlIdProveedor, ttp.numRuc, ");
				hql.append("ttp.chrTipProveedor, ttp.chrTipEstado, tci.chrSerComprobante, tci.chrNumComprobante, ");				
				hql.append("tci.dteFecComprobante, tci.dteFecVtoservicio, uni.idunidad, uni.nomunidad, reg.idRanac, tdi.chrTipVenta, ");
				hql.append("reg.nombre, tci.numTipCambio, tci.chrTipOperacion, tdn.srlIdDocumento, tdn.chrCodDocumento, tci.intCodPadComIngresos ");
				hql.append("order by uni.nomunidad, reg.nombre, ttc.chrNomComprobante");
			}
			Query query = super.getSession().createQuery(hql.toString());
			query.setParameter("int_id_registro", Constantes.ESTADO_ACTIVO);
			query.setParameter("int_transaccion", ingreso.getInt_transaccion());
			if (!isNullOrEmpty(ingreso.getTip_operacion())) {
				boolean ind_rep = true;
				if ((ingreso.getTip_transaccion().equals(Constantes.SIX_STRING) ||
						ingreso.getTip_transaccion().equals(Constantes.SEVEN_STRING)) &&
						ingreso.getTip_operacion().equals(Constantes.TWO_STRING)) { // Sede Central
					ind_rep = false;
				}
				if (ind_rep) {
					query.setParameter("tip_operacion", ingreso.getTip_operacion());
				}
			}
			if (!isNullInteger(ingreso.getCod_uni_operativa())) {
				query.setParameter("cod_uni_operativa", ingreso.getCod_uni_operativa());
			}
			if (!isNullInteger(ingreso.getCod_reg_nac())) {
				query.setParameter("cod_reg_nac", ingreso.getCod_reg_nac());
			}
			if (!isNullLong(ingreso.getNum_ruc())) {
				query.setParameter("num_ruc", ingreso.getNum_ruc());
			}
			if (!isNullOrEmpty(ingreso.getFec_inicio()) && !isNullOrEmpty(ingreso.getFec_final())) {
				query.setParameter("fec_inicio", getDate(ingreso.getFec_inicio()));
				query.setParameter("fec_final", getDate(ingreso.getFec_final()));
			}
			if (!ingreso.getTip_transaccion().equals(Constantes.SIX_STRING) && 
					!ingreso.getTip_transaccion().equals(Constantes.SEVEN_STRING) &&
					!isNullOrEmpty(ingreso.getTip_transaccion())) {
				query.setParameter("tip_transaccion", ingreso.getTip_transaccion());
			} else if (ingreso.getTip_transaccion().equals(Constantes.SIX_STRING)) { // Registro de Ventas
				query.setParameter("flg_ventas", Constantes.FLAG_ACTIVO);
			} else if (ingreso.getTip_transaccion().equals(Constantes.SEVEN_STRING)) { // Registro de Ventas
				query.setParameter("flg_ventas", Constantes.FLAG_ACTIVO);
			}
			if (!isNullInteger(ingreso.getCod_servicio())) {
				query.setParameter("cod_servicio", ingreso.getCod_servicio());
			}
			if (!isNullInteger(ingreso.getCod_mes())) {
				query.setParameter("cod_mes", ingreso.getCod_mes());
			}
			if (!isNullInteger(ingreso.getCod_anno())) {
				query.setParameter("cod_anno", ingreso.getCod_anno());
			}
			return query.setResultTransformer(Transformers.aliasToBean(ReporteDetalleIngresosBean.class)).list();		
		} catch (Exception e) {
			throw new Exception(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(), 
								Constantes.NIVEL_APP_DAO, 
								this.getClass().getName(), e.getMessage()));
		}
	}

	/* (non-Javadoc)
	 * @see pe.com.mig.dao.IComprasIngresosDao#listarDetalleCompraTransferencia(pe.com.mig.model.bean.ComprasIngresosBean)
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<DetalleComprasBean> listarDetalleCompraTransferencia(ComprasIngresosBean compra) throws Exception {
		try {
			StringBuilder hql = new StringBuilder();			
			hql.append("select distinct esp.srl_id_esp as cod_especifica, ");
			hql.append("trim(esp.chr_cod_especifica) as vcod_especifica, ");			
			hql.append("tff.chrNomFte as fue_financiamiento, ");
			hql.append("tra.intNumSiaf as num_siaf, ");
			hql.append("trim(tra.chrNumComprobante) as num_comprobante, ");
			hql.append("to_char(tra.dteFecComprobante, 'DD/MM/YYYY') as fec_com_transferencia ");
			hql.append("from TDetalleTranfer det ");			
			hql.append("inner join det.TTransferencia tra ");
			hql.append("inner join det.TEspecifica esp, ");
			hql.append("TFteFto tff ");
			hql.append("where det.intIdfRegistro = :int_id_registro ");	
			hql.append("and tra.intIdfRegistro = :int_id_registro ");
			hql.append("and tff.srlIdFte = cast(tra.chrCodFte as int) ");
			hql.append("and tra.chrNumComprobante = :num_comprobante ");
			
			//hql.append("and EXTRACT(YEAR FROM tra.dteFecComprobante) = extract(year from current_date) ");
			
			hql.append("order by trim(esp.chr_cod_especifica)");	
			Query query = super.getSession().createQuery(hql.toString());
			query.setParameter("int_id_registro", Constantes.ESTADO_ACTIVO);
			query.setParameter("num_comprobante", compra.getNro_doc_rc());			
			return query.setResultTransformer(Transformers.aliasToBean(DetalleComprasBean.class)).list();		
		} catch (Exception e) {
			throw new Exception(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(), 
								Constantes.NIVEL_APP_DAO, 
								this.getClass().getName(), e.getMessage()));
		}
	}

	/* (non-Javadoc)
	 * @see pe.com.mig.dao.IComprasIngresosDao#listarDetalleVoucher(pe.com.mig.model.bean.DetalleVoucherBean)
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<DetalleVoucherBean> listarDetalleVoucher(DetalleVoucherBean voucher) throws Exception {
		try {
			StringBuilder hql = new StringBuilder();			
			hql.append("select tdv.srlIdVoucher as cod_voucher, ");
			hql.append("trim(tdv.chrNumVoucher) as num_voucher, ");			
			hql.append("to_char(tdv.dteFecVoucher, 'DD/MM/YYYY') as fec_voucher, ");
			hql.append("tdv.numImpVoucher as imp_voucher, ");
			hql.append("tdv.imgVoucher as img_voucher, ");
			hql.append("tdv.chrCodUsuaCreacion as vnomusuario, ");
			hql.append("tdv.dteFecCreacion as fec_creacion, ");
			hql.append("tci.srlIdCompras as cod_com_ingresos ");
			hql.append("from TDetalleVoucher tdv ");			
			hql.append("inner join tdv.TComprasIngresos tci ");
			hql.append("where tdv.intIdfRegistro = :int_id_registro ");	
			if (!isNullInteger(voucher.getCod_com_ingresos())) {
				hql.append("and tci.srlIdCompras = :cod_com_ingresos ");
			}
			if (!isNullOrEmpty(voucher.getFec_inicio()) && !isNullOrEmpty(voucher.getFec_final())) {
				hql.append("and tci.dteFecComprobante between :fec_inicio and :fec_final ");
			}
			if (!isNullInteger(voucher.getCod_mes())) {
				hql.append("and tci.intMes = :cod_mes ");
			}
			hql.append("order by tdv.srlIdVoucher");	
			Query query = super.getSession().createQuery(hql.toString());
			query.setParameter("int_id_registro", Constantes.ESTADO_ACTIVO);
			if (!isNullInteger(voucher.getCod_com_ingresos())) {
				query.setParameter("cod_com_ingresos", voucher.getCod_com_ingresos());
			}
			if (!isNullOrEmpty(voucher.getFec_inicio()) && !isNullOrEmpty(voucher.getFec_final())) {
				query.setParameter("fec_inicio", getDate(voucher.getFec_inicio()));
				query.setParameter("fec_final", getDate(voucher.getFec_final()));
			}
			if (!isNullInteger(voucher.getCod_mes())) {
				query.setParameter("cod_mes", voucher.getCod_mes());
			}
			return query.setResultTransformer(Transformers.aliasToBean(DetalleVoucherBean.class)).list();		
		} catch (Exception e) {
			throw new Exception(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(), 
								Constantes.NIVEL_APP_DAO, 
								this.getClass().getName(), e.getMessage()));
		}
	}

	/* (non-Javadoc)
	 * @see pe.com.mig.dao.IComprasIngresosDao#listarCierresMes(pe.com.mig.model.bean.CierreMesBean)
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<CierreMesBean> listarCierresMes(CierreMesBean cierre) throws Exception {
		try {
			StringBuilder hql = new StringBuilder();			
			hql.append("select distinct tcm.srlIdMes as cod_mes, ");					
			hql.append("tcm.intAno as anio, tcm.intMes as mes, ");	
			hql.append("to_char(tcm.dteFecCierre, 'DD/MM/YYYY') as fec_cierre, ");
			hql.append("to_char(tcm.dteFecDescierre, 'DD/MM/YYYY') as fec_des_cierre, ");			
			hql.append("to_char(tcm.dteFecDescierreVta, 'DD/MM/YYYY') as fec_des_cierre_vta, ");
			hql.append("to_char(tcm.dteFecApertura, 'DD/MM/YYYY') as fec_apertura, ");
			hql.append("tcm.chrFlgApertura as fla_apertura, ");
			hql.append("tcm.chrFlgAperturaVta as fla_apertura_vta, ");
			hql.append("reg.idRanac as cod_reg_nac, uni.idunidad as cod_uni_operativa, ");	
			hql.append("reg.nombre as des_reg_nac, uni.nomunidad as des_uni_operativa, ");
			hql.append("tcm.chrCodUsuaCreacion as mnt_usu_creacion, ");
			hql.append("to_char(tcm.dteFecCreacion, 'DD/MM/YYYY') as mnt_fec_creacion, ");
			hql.append("tcm.chrCodUsuaModifica as mnt_usu_modificacion, ");
			hql.append("to_char(tcm.dteFecModifica, 'DD/MM/YYYY') as mnt_fec_modificacion ");
			hql.append("from TComprasIngresos tci, ");
			hql.append("TCierreMes tcm ");
			hql.append("left join tcm.unidadoperativa uni ");
			hql.append("left join tcm.tbtRegistroNac reg ");
			hql.append("where tci.intMes = tcm.intMes "); 
			hql.append("and tci.intAnno = tcm.intAno ");
			hql.append("and tcm.chrMesActivo = :mes_activo ");
			//hql.append("and tcm.chrIndCompra = :ind_tip_compra ");
			
			if (!isNullInteger(cierre.getAnio())) {
				hql.append("and tcm.intAno = :anio ");
			}
			if (!isNullInteger(cierre.getCod_mes())) {
				hql.append("and tcm.intMes = :cod_mes ");
			}
			if (!isNullInteger(cierre.getCod_uni_operativa())) {
				hql.append("and uni.idunidad = :cod_uni_operativa ");
			}			
			if (!isNullInteger(cierre.getCod_reg_nac())) {
				hql.append("and reg.idRanac = :cod_reg_nac ");
			}
			if (!isNullInteger(cierre.getInd_tip_compra())) {
				hql.append("and tcm.chrIndCompra = :ind_tip_compra ");
			}
			if (!isNullInteger(cierre.getInd_tip_venta())) {
				hql.append("and tcm.chrIndVenta = :ind_tip_venta ");
			}
			if (!isNullOrEmpty(cierre.getFla_apertura())) {
				hql.append("and tcm.chrFlgApertura = :fla_apertura ");
			}
			if (!isNullOrEmpty(cierre.getFla_apertura_vta())) {
				hql.append("and tcm.chrFlgAperturaVta = :fla_apertura_vta ");
			}			
			hql.append("and tcm.dteFecCierre is not null ");
			Query query = super.getSession().createQuery(hql.toString());
			
			if (!isNullInteger(cierre.getAnio())) {
				query.setParameter("anio", cierre.getAnio());
			}			
			if (!isNullInteger(cierre.getCod_mes())) {
				query.setParameter("cod_mes", cierre.getCod_mes());
			}
			if (!isNullInteger(cierre.getCod_uni_operativa())) {
				query.setParameter("cod_uni_operativa", cierre.getCod_uni_operativa());
			}
			if (!isNullInteger(cierre.getCod_reg_nac())) {
				query.setParameter("cod_reg_nac", cierre.getCod_reg_nac());
			}			
			//query.setParameter("cod_anio", DateUtil.getAnioActual());
			
			if (!isNullInteger(cierre.getInd_tip_compra())) {
				query.setParameter("ind_tip_compra", cierre.getInd_tip_compra());
			}
			if (!isNullInteger(cierre.getInd_tip_venta())) {
				query.setParameter("ind_tip_venta", cierre.getInd_tip_venta());
			}	
			if (!isNullOrEmpty(cierre.getFla_apertura())) {
				query.setParameter("fla_apertura", cierre.getFla_apertura());
			}
			if (!isNullOrEmpty(cierre.getFla_apertura_vta())) {
				query.setParameter("fla_apertura_vta", cierre.getFla_apertura_vta());
			}
			query.setParameter("mes_activo", cierre.getMes_activo());
			
			
			return query.setResultTransformer(Transformers.aliasToBean(CierreMesBean.class)).list();		
		} catch (Exception e) {
			throw new Exception(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(), 
								Constantes.NIVEL_APP_DAO, 
								this.getClass().getName(), e.getMessage()));
		}
	}
	/* (non-Javadoc)
	 * @see pe.com.mig.dao.IComprasIngresosDao#listarCierresMesV(pe.com.mig.model.bean.CierreMesBean)
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<CierreMesBean> listarCierresMesV(CierreMesBean cierre) throws Exception {
		try {
			StringBuilder hql = new StringBuilder();			
			hql.append("select distinct tcm.srlIdMes as cod_mes, ");					
			hql.append("tcm.intAno as anio, tcm.intMes as mes, ");	
			hql.append("to_char(tcm.dteFecCierre, 'DD/MM/YYYY') as fec_cierre, ");
			hql.append("to_char(tcm.dteFecDescierre, 'DD/MM/YYYY') as fec_des_cierre, ");	
			hql.append("to_char(tcm.dteFecDescierreVta, 'DD/MM/YYYY') as fec_des_cierre_vta, ");			
			hql.append("to_char(tcm.dteFecApertura, 'DD/MM/YYYY') as fec_apertura, ");
			hql.append("tcm.chrFlgApertura as fla_apertura, ");
			hql.append("tcm.chrFlgAperturaVta as fla_apertura_vta, ");			
			hql.append("reg.idRanac as cod_reg_nac, uni.idunidad as cod_uni_operativa, ");	
			hql.append("reg.nombre as des_reg_nac, uni.nomunidad as des_uni_operativa, ");
			hql.append("tcm.chrCodUsuaCreacion as mnt_usu_creacion, ");
			hql.append("to_char(tcm.dteFecCreacion, 'DD/MM/YYYY') as mnt_fec_creacion, ");
			hql.append("tcm.chrCodUsuaModifica as mnt_usu_modificacion, ");
			hql.append("to_char(tcm.dteFecModifica, 'DD/MM/YYYY') as mnt_fec_modificacion ");
			hql.append("from TComprasIngresos tci, ");
			hql.append("TCierreMes tcm ");
			hql.append("left join tcm.unidadoperativa uni ");
			hql.append("left join tcm.tbtRegistroNac reg ");
			hql.append("where tci.intMes = tcm.intMes "); 
			hql.append("and tci.intAnno = tcm.intAno ");
			hql.append("and tcm.chrMesActivo = :mes_activo ");
			hql.append("and tcm.chrIndVenta = :ind_tip_venta ");
			
			if (!isNullInteger(cierre.getCod_uni_operativa())) {
				hql.append("and uni.idunidad = :cod_uni_operativa ");
			}			
			if (!isNullInteger(cierre.getCod_reg_nac())) {
				hql.append("and reg.idRanac = :cod_reg_nac ");
			}
			if (!isNullInteger(cierre.getAnio())) {
				hql.append("and tcm.intAno = :anio ");
			}
			if (!isNullInteger(cierre.getCod_mes())) {
				hql.append("and tcm.intMes = :cod_mes ");
			}				
			hql.append("and tcm.dteFecCierre is not null ");
			hql.append("and tcm.chrFlgAperturaVta = :fla_apertura_vta ");
			//hql.append("and tcm.intAno = :cod_anio ");
			Query query = super.getSession().createQuery(hql.toString());
			
			if (!isNullInteger(cierre.getCod_uni_operativa())) {
				query.setParameter("cod_uni_operativa", cierre.getCod_uni_operativa());
			}
			if (!isNullInteger(cierre.getCod_reg_nac())) {
				query.setParameter("cod_reg_nac", cierre.getCod_reg_nac());
			}			
			//query.setParameter("cod_anio", DateUtil.getAnioActual());
			if (!isNullInteger(cierre.getAnio())) {
				query.setParameter("anio", cierre.getAnio());
			}			
			if (!isNullInteger(cierre.getCod_mes())) {
				query.setParameter("cod_mes", cierre.getCod_mes());
			}			
			if (!isNullInteger(cierre.getInd_tip_venta())) {
				query.setParameter("ind_tip_venta", cierre.getInd_tip_venta());
			}			
			query.setParameter("mes_activo", cierre.getMes_activo());
			query.setParameter("fla_apertura_vta", cierre.getFla_apertura());
			return query.setResultTransformer(Transformers.aliasToBean(CierreMesBean.class)).list();		
		} catch (Exception e) {
			throw new Exception(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(), 
								Constantes.NIVEL_APP_DAO, 
								this.getClass().getName(), e.getMessage()));
		}
	}
	/* (non-Javadoc)
	 * @see pe.com.mig.dao.IComprasIngresosDao#listarDatosPs4(pe.com.mig.model.bean.ComprasIngresosBean)
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<ComprasIngresosBean> listarDatosPs4(ComprasIngresosBean com_ingreso) throws Exception {
		try {
			StringBuilder hql = new StringBuilder();			
			hql.append("select distinct tpc.numRuc as nro_ruc, ");			
			hql.append("trim(tpc.chrNombres) as nombres, ");			
			hql.append("trim(tpc.chrApePaterno) as ape_paterno, ");
			hql.append("trim(tpc.chrApeMaterno) as ape_materno, ");			
			hql.append("to_char(tpc.dteFecNacimiento, 'DD/MM/YYYY') as fec_nacimiento, ");			
			hql.append("case tpc.chrIndDomiciliario ");			
			hql.append("when 'S' then '1' ");
			hql.append("when 'N' then '2' ");
			hql.append("else '' ");
			hql.append("end as tip_sexo, ");
			hql.append("case tpc.chrIndEssalud ");			
			hql.append("when 'S' then '1' ");
			hql.append("when 'N' then '0' ");
			hql.append("else '' ");
			hql.append("end as ind_es_salud ");			
			hql.append("from TComprasIngresos tci ");
			hql.append("inner join tci.TTipoComprobante ttc ");
			hql.append("left join tci.TPersonalCuarta tpc ");
			hql.append("where tci.intIdfRegistro = :int_id_registro ");
			hql.append("and tci.intIdfTransaccion = :int_transaccion ");
			hql.append("and tci.intMes = :cod_mes ");
			hql.append("and tci.intAnno = :cod_anno ");
			hql.append("and ttc.chrCodComprobante in ('02') ");
			hql.append("and ttc.chrFlgCompras = :flf_compra ");
			Query query = super.getSession().createQuery(hql.toString());
			query.setParameter("int_id_registro", Constantes.ESTADO_ACTIVO);
			query.setParameter("int_transaccion", com_ingreso.getInt_transaccion());
			query.setParameter("cod_mes", com_ingreso.getCod_mes());
			query.setParameter("cod_anno", com_ingreso.getCod_anno());
			query.setParameter("flf_compra", Constantes.FLAG_INACTIVO);
			return query.setResultTransformer(Transformers.aliasToBean(ComprasIngresosBean.class)).list();
		} catch (Exception e) {
			throw new Exception(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(), 
								Constantes.NIVEL_APP_DAO, 
								this.getClass().getName(), e.getMessage()));
		}
	}

	/* (non-Javadoc)
	 * @see pe.com.mig.dao.IComprasIngresosDao#listarDatos4ta(pe.com.mig.model.bean.ComprasIngresosBean)
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<ComprasIngresosBean> listarDatos4ta(ComprasIngresosBean com_ingreso) throws Exception {
		try {
			StringBuilder hql = new StringBuilder();			
			hql.append("select tci.srlIdCompras as cod_com_ingresos, tci.intMes as cod_mes, ");	
			hql.append("ttc.srlIdComprobante as cod_comprobante,  ");
			hql.append("tpc.numRuc as nro_ruc, ");			
			hql.append("case ttc.chrCodComprobante ");			
			hql.append("when '02' then 'R' ");
			hql.append("when '07' then 'N' ");
			hql.append("end as vcod_comprobante, ");			
			hql.append("trim(tci.chrSerComprobante) as ser_comprobante, ");
			hql.append("trim(tci.chrNumComprobante) as nro_comprobante, ");	
			hql.append("to_char(tci.dteFecComprobante, 'DD/MM/YYYY') as fec_comprobante, ");
			hql.append("tci.numImpTotal as imp_total, ");
			hql.append("case tdc.chrIndRetencion ");			
			hql.append("when 'S' then '1' ");
			hql.append("when 'N' then '0' ");
			hql.append("else '' ");
			hql.append("end as ind_retencion, ");
			hql.append("case ttc.chrCodComprobante ");			
			hql.append("when '02' then to_char(tdc.dteFecPago, 'DD/MM/YYYY') ");
			hql.append("when '07' then to_char(tci.dteFecComprobante, 'DD/MM/YYYY') ");
			hql.append("else '' ");
			hql.append("end as fec_pago, ");
			hql.append("tci.intCodPadComIngresos as cod_pad_com_ingresos ");
			hql.append("from TComprasIngresos tci ");
			hql.append("inner join tci.TTipoComprobante ttc ");
			hql.append("left join tci.TPersonalCuarta tpc, ");
			hql.append("TDetalleCompras tdc ");			
			hql.append("inner join tdc.TComprasIngresos tcd ");
			hql.append("where tci.intIdfRegistro = :int_id_registro ");
			hql.append("and tci.intIdfTransaccion = :int_transaccion ");
			hql.append("and tci.srlIdCompras = tcd.srlIdCompras ");
			hql.append("and tdc.intIdfRegistro = :int_id_registro ");	
			hql.append("and tci.intMes = :cod_mes ");
			hql.append("and tci.intAnno = :cod_anno ");
			if (isNullInteger(com_ingreso.getInd_cua_categoria())) {			
				hql.append("and ttc.chrCodComprobante in ('02') "); // Recibo por Honorarios
			} else {
				hql.append("and ttc.chrCodComprobante in ('07') "); // Nota de Credito
				hql.append("and tci.intCodPadComIngresos > 0 ");
			}				
			hql.append("and ttc.chrFlgCompras = :flf_compra ");
			Query query = super.getSession().createQuery(hql.toString());
			query.setParameter("int_id_registro", Constantes.ESTADO_ACTIVO);
			query.setParameter("int_transaccion", com_ingreso.getInt_transaccion());
			query.setParameter("cod_mes", com_ingreso.getCod_mes());
			query.setParameter("cod_anno", com_ingreso.getCod_anno());
			query.setParameter("flf_compra", Constantes.FLAG_INACTIVO);
			return query.setResultTransformer(Transformers.aliasToBean(ComprasIngresosBean.class)).list();	
		} catch (Exception e) {
			throw new Exception(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(), 
								Constantes.NIVEL_APP_DAO, 
								this.getClass().getName(), e.getMessage()));
		}
	}

}