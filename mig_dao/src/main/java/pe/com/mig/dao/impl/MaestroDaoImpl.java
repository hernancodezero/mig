package pe.com.mig.dao.impl;

import java.util.Calendar;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.com.mig.dao.IMaestroDao;
import pe.com.mig.model.bean.CartaFianzaBean;
import pe.com.mig.model.bean.CierreMesBean;
import pe.com.mig.model.bean.ComprasIngresosBean;
import pe.com.mig.model.bean.ConvenioCuartaBean;
import pe.com.mig.model.bean.CuartaCategoriaBean;
import pe.com.mig.model.bean.CuentaContableBean;
import pe.com.mig.model.bean.DocumentoCuartaBean;
import pe.com.mig.model.bean.EntidadFinancieraBean;
import pe.com.mig.model.bean.FuenteFinanciamientoBean;
import pe.com.mig.model.bean.CuentaCorrienteBean;
import pe.com.mig.model.bean.DireccionFacturaBean;
import pe.com.mig.model.bean.LibroRegistroBean;
import pe.com.mig.model.bean.MediosPagosBean;
import pe.com.mig.model.bean.NacionalidadBean;
import pe.com.mig.model.bean.OtrosBean;
import pe.com.mig.model.bean.PersonaCuartaBean;
import pe.com.mig.model.bean.ProductoBean;
import pe.com.mig.model.bean.ProveedorBean;
import pe.com.mig.model.bean.SeriesBean;
import pe.com.mig.model.bean.SucursalBean;
import pe.com.mig.model.bean.TarifaBoletoBean;
import pe.com.mig.model.bean.TipoComprobanteBean;
import pe.com.mig.model.bean.TipoComprobanteCuartaBean;
import pe.com.mig.model.bean.TipoDocumentoBean;
import pe.com.mig.model.bean.TipoMonedaBean;
import pe.com.mig.model.bean.UbigeoBean;
import pe.com.mig.model.bean.UnidadMedidaBean;
import pe.com.mig.model.bean.ViaBean;
import pe.com.mig.model.bean.ZonaBean;
import pe.com.mig.model.bean.sernanp.UnidadOperativaBean;
import pe.com.mig.model.bean.sppi.EspecificaBean;
import pe.com.mig.model.entity.TCartaFianza;
import pe.com.mig.model.entity.TCierreMes;
import pe.com.mig.model.entity.TComprasIngresos;
import pe.com.mig.model.entity.TComprobanteCuarta;
import pe.com.mig.model.entity.TConvenioCuarta;
import pe.com.mig.model.entity.TCuentaContable;
import pe.com.mig.model.entity.TDocumentoCuarta;
import pe.com.mig.model.entity.TDocumentoIdentidad;
import pe.com.mig.model.entity.TEntidadFinanciera;
import pe.com.mig.model.entity.TLibroRegistro;
import pe.com.mig.model.entity.TMedioPago;
import pe.com.mig.model.entity.TNacionalidad;
import pe.com.mig.model.entity.TOtros;
import pe.com.mig.model.entity.TPersonalCuarta;
import pe.com.mig.model.entity.TProducto;
import pe.com.mig.model.entity.TRetenciones;
import pe.com.mig.model.entity.TSeries;
import pe.com.mig.model.entity.TTariBoleto;
import pe.com.mig.model.entity.TTipoComprobante;
import pe.com.mig.model.entity.TTipoMoneda;
import pe.com.mig.model.entity.TTipoProveedor;
import pe.com.mig.model.entity.TUnidadMedida;
import pe.com.mig.model.entity.TVia;
import pe.com.mig.model.entity.TZona;
import pe.com.mig.model.entity.sde.TbtRegistroNac;
import pe.com.mig.model.entity.sernanp.Unidadoperativa;
import pe.com.mig.model.entity.sppi.TEspecifica;
import pe.com.mig.util.Constantes;
import pe.com.mig.util.DateUtil;

/**
 * @className: MaestroDaoImpl.java
 * @description: 
 * @date: 16 de jun. de 2016
 * @author: SUMERIO.
 */
@Repository
public class MaestroDaoImpl extends GenericDaoImpl implements IMaestroDao {

	private static final long serialVersionUID = 1L;
	
	/* (non-Javadoc)
	 * @see pe.com.mig.dao.IMaestroDao#verificarSedePrincipal(java.lang.Integer)
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<UnidadOperativaBean> verificarSedePrincipal(Integer cod_usuario) throws Exception {
		try {
			StringBuilder hql = new StringBuilder();		
			hql.append("select distinct usu.idusuario as cod_usuario, usu.usuario as des_usuario, ");	
			hql.append("are.idarea as cod_area, are.desarea as des_area, ");
			hql.append("sed.idsede as cod_sede, sed.dessede as des_sede ");	
			hql.append("from Usuario usu ");			
			hql.append("inner join usu.areaorganica are ");
			hql.append("inner join are.sede sed ");
			hql.append("where sed.idsede = :cod_sede ");
			hql.append("and usu.idusuario = :cod_usuario ");
			Query query = super.getSession().createQuery(hql.toString());
			query.setParameter("cod_sede", Constantes.CODIGO_SEDE_CENTRAL);
			query.setParameter("cod_usuario", cod_usuario);
			return query.setResultTransformer(Transformers.aliasToBean(UnidadOperativaBean.class)).list();
		} catch (Exception e) {
			throw new Exception(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(), 
								Constantes.NIVEL_APP_DAO, 
								this.getClass().getName(), e.getMessage()));
		}
	}
	
	/* (non-Javadoc)
	 * @see pe.com.mig.dao.IMaestroDao#listarUnidadOperativa(pe.com.mig.model.bean.sernanp.UnidadOperativaBean)
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<UnidadOperativaBean> listarUnidadOperativa(UnidadOperativaBean unidad) throws Exception {
		try {
			Query query = null;
			StringBuilder hql = new StringBuilder();
			if (!isNullInteger(unidad.getCod_usuario())) {			
				if (unidad.getInd_uni_operativa() == 0) {
					hql.append("select distinct uni.idunidad as cod_uni_operativa, ");	
					hql.append("uni.nomunidad as des_uni_operativa ");
				} else {
					hql.append("select distinct usu.idusuario as cod_usuario, usu.usuario as des_usuario, ");	
					hql.append("are.idarea as cod_area, are.desarea as des_area, ");
					hql.append("sed.idsede as cod_sede, sed.dessede as des_sede, ");			
					hql.append("reg.idRanac as cod_reg_nac, reg.nombre as des_reg_nac, ");	
					hql.append("anp.idRanac as cod_uni_ope_anp, uni.idunidad as cod_uni_operativa, ");	
					hql.append("uni.nomunidad as des_uni_operativa ");	
				}		
				hql.append("from Usuario usu ");			
				hql.append("inner join usu.areaorganica are ");
				hql.append("inner join are.sede sed ");			
				hql.append("inner join sed.registronac reg, ");
				hql.append("TUnidadoperativaAnpAdm anp, ");
				hql.append("Unidadoperativa uni ");
				hql.append("where reg.idRanac = anp.idRanac ");
				hql.append("and anp.idunidad = uni.idunidad ");
				hql.append("and usu.idusuario = :cod_usuario ");
				if (!isNullInteger(unidad.getCod_uni_operativa())) {
					hql.append("and uni.idunidad = :cod_uni_operativa ");
				}
				query = super.getSession().createQuery(hql.toString());
				query.setParameter("cod_usuario", unidad.getCod_usuario());
				if (!isNullInteger(unidad.getCod_uni_operativa())) {
					query.setParameter("cod_uni_operativa", unidad.getCod_uni_operativa());
				}
			} else {
				if (unidad.getInd_uni_operativa() == 0) {
					hql.append("select distinct uni.idunidad as cod_uni_operativa, ");	
					hql.append("uni.nomunidad as des_uni_operativa ");
					hql.append("from TUnidadoperativaAnpAdm anp, ");
					hql.append("Unidadoperativa uni ");
					hql.append("where anp.idunidad = uni.idunidad ");
					hql.append("order by uni.nomunidad");
					query = super.getSession().createQuery(hql.toString());
				} else {
					hql.append("select distinct reg.idRanac as cod_reg_nac, ");	
					hql.append("concat(reg.codanp, '-', reg.nombre) as des_reg_nac ");
					hql.append("from TbtRegistroNac reg, ");
					hql.append("TUnidadoperativaAnpAdm anp, ");
					hql.append("Unidadoperativa uni ");
					hql.append("where reg.idRanac = anp.idRanac ");
					hql.append("and anp.idunidad = uni.idunidad ");
					if (!isNullInteger(unidad.getCod_uni_operativa())) {
						hql.append("and uni.idunidad = :cod_uni_operativa ");
					}
					hql.append("order by des_reg_nac");
					query = super.getSession().createQuery(hql.toString());
					if (!isNullInteger(unidad.getCod_uni_operativa())) {
						query.setParameter("cod_uni_operativa", unidad.getCod_uni_operativa());
					}						
				}				
			}
			return query.setResultTransformer(Transformers.aliasToBean(UnidadOperativaBean.class)).list();		
		} catch (Exception e) {
			throw new Exception(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(), 
								Constantes.NIVEL_APP_DAO, 
								this.getClass().getName(), e.getMessage()));
		}
	}

	/* (non-Javadoc)
	 * @see pe.com.mig.dao.IMaestroDao#listarSucursal(pe.com.mig.model.bean.TSucursalBean)
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<SucursalBean> listarSucursal(SucursalBean sucursal) throws Exception {
		try {
			StringBuilder hql = new StringBuilder();			
			hql.append("select tts.srlIdSucur as cod_sucur, tts.intUnidad as cod_uni_operativa, ");			
			hql.append("tts.intAnp as cod_reg_nac, tts.srlIdSucur as cod_sucur, ");
			hql.append("tts.chrDesSuc as des_sucur, ");
			hql.append("tts.chrFlgActivo as fla_activo,  tts.chrCodUsuaCreacion as mnt_usu_creacion, ");			
			hql.append("to_char(tts.dteFecCreacion, 'DD/MM/YYYY') as mnt_fec_creacion, ");
			hql.append("tts.chrCodUsuaModifica as mnt_usu_modificacion, ");
			hql.append("to_char(tts.dteFecModifica, 'DD/MM/YYYY') as mnt_fec_modificacion ");			
			hql.append("from TSucursal tts ");
			hql.append("where 1=1 ");

			if (!isNullInteger(sucursal.getCod_uni_operativa())) {
				hql.append("and tts.intUnidad = :cod_uni_operativa ");
			} 
			if (!isNullInteger(sucursal.getCod_reg_nac())) {
				hql.append("and tts.intAnp = :cod_reg_nac ");
			} 			

			hql.append("order by tts.chrDesSuc");
			Query query = super.getSession().createQuery(hql.toString());
	
			if (!isNullInteger(sucursal.getCod_uni_operativa())) {
				query.setParameter("cod_uni_operativa", sucursal.getCod_uni_operativa());
			} 
			if (!isNullInteger(sucursal.getCod_reg_nac())) {
				query.setParameter("cod_reg_nac", sucursal.getCod_reg_nac());
			} 			
			
			return query.setResultTransformer(Transformers.aliasToBean(SucursalBean.class)).list();		
		} catch (Exception e) {
			throw new Exception(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(), 
								Constantes.NIVEL_APP_DAO, 
								this.getClass().getName(), e.getMessage()));
		}
	}	
	/* (non-Javadoc)
	 * @see pe.com.mig.dao.IMaestroDao#listarSerieCp(pe.com.mig.model.bean.TSeriesBean)
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<SeriesBean> listarSerieCp(ComprasIngresosBean cod_serie) throws Exception {
		try {
			StringBuilder hql = new StringBuilder();			
			hql.append("select distinct tss.srlIdSerie as cod_serie, ");
			hql.append("tss.intCodUnidad as cod_uni_operativa, ");
			hql.append("tss.intCodRanac as cod_reg_nac, "); 
			hql.append("tss.intCodCp as cod_comprobante, ");
			hql.append("tss.chrCodSunat as cod_sunat, tss.numSerie as num_serie, ");
			hql.append("tss.intNumCp as num_cp ");	
			hql.append("from TSeriesCp tss , TComprasIngresos tci ");
			//hql.append("left join tss.TComprasIngresos tci ");
			hql.append("where 1=1 and tss.srlIdSerie=tci.TSeries ");
			if (!isNullInteger(cod_serie.getCod_serie())) {
				hql.append("and tss.srlIdSerie = :cod_serie ");
			}
			hql.append("order by tss.srlIdSerie");
			Query query = super.getSession().createQuery(hql.toString());
			if (!isNullInteger(cod_serie.getCod_serie())) {
				query.setParameter("cod_serie", cod_serie.getCod_serie());
			}						
			return query.setResultTransformer(Transformers.aliasToBean(SeriesBean.class)).list();		
		} catch (Exception e) {
			throw new Exception(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(), 
								Constantes.NIVEL_APP_DAO, 
								this.getClass().getName(), e.getMessage()));
		}
	}	
	/* (non-Javadoc)
	 * @see pe.com.mig.dao.IMaestroDao#listarSerie(pe.com.mig.model.bean.TSeriesBean)
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<SeriesBean> listarSerieNum(SeriesBean series) throws Exception {
		try {
			StringBuilder hql = new StringBuilder();			
			hql.append("select tss.srlIdSerie as cod_serie, ");
			hql.append("tss.intCodUnidad as cod_uni_operativa, ");
			hql.append("tss.intCodRanac as cod_reg_nac, "); 
			hql.append("tss.intCodCp as cod_comprobante, ");
			hql.append("tss.chrCodSunat as cod_sunat, tss.numSerie as num_serie, ");
			hql.append("tss.intNumCp as num_cp, ");
			hql.append("tss.chrFlgActivo as fla_activo,  tss.chrCodUsuaCreacion as mnt_usu_creacion, ");			
			hql.append("to_char(tss.dteFecCreacion, 'DD/MM/YYYY') as mnt_fec_creacion, ");
			hql.append("tss.chrCodUsuaModifica as mnt_usu_modificacion, ");
			hql.append("to_char(tss.dteFecModifica, 'DD/MM/YYYY') as mnt_fec_modificacion ");			
			hql.append("from TSeriesNum tss ");
			hql.append("where 1=1 ");
			if (!isNullInteger(series.getCod_serie())) {
				hql.append("and tss.srlIdSerie = :cod_serie ");
			}
			if (!isNullInteger(series.getCod_uni_operativa())) {
				hql.append("and tss.intCodUnidad = :cod_uni_operativa ");
			} 
			if (!isNullInteger(series.getCod_reg_nac())) {
				hql.append("and tss.intCodRanac = :cod_reg_nac ");
			} 			
			if (!isNullInteger(series.getCod_comprobante())) {
				hql.append("and tss.intCodCp = :cod_comprobante ");
			}
			hql.append("order by tss.srlIdSerie");
			Query query = super.getSession().createQuery(hql.toString());
			if (!isNullInteger(series.getCod_serie())) {
				query.setParameter("cod_serie", series.getCod_serie());
			}			
			if (!isNullInteger(series.getCod_uni_operativa())) {
				query.setParameter("cod_uni_operativa", series.getCod_uni_operativa());
			} 
			if (!isNullInteger(series.getCod_reg_nac())) {
				query.setParameter("cod_reg_nac", series.getCod_reg_nac());
			} 			
			if (!isNullInteger(series.getCod_comprobante())) {
				query.setParameter("cod_comprobante", series.getCod_comprobante());
			} 			
			return query.setResultTransformer(Transformers.aliasToBean(SeriesBean.class)).list();		
		} catch (Exception e) {
			throw new Exception(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(), 
								Constantes.NIVEL_APP_DAO, 
								this.getClass().getName(), e.getMessage()));
		}
	}	
	/* (non-Javadoc)
	 * @see pe.com.mig.dao.IMaestroDao#listarSerie(pe.com.mig.model.bean.TSeriesBean)
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<SeriesBean> listarSerie(SeriesBean serie) throws Exception {
		try {
			StringBuilder hql = new StringBuilder();			
			hql.append("select tss.srlIdSerie as cod_serie, ");
			//hql.append("tss.unidadoperativa as cod_uni_operativa, trim(uni.nomunidad) as des_uni_operativa,");
			//hql.append("tss.tbtRegistroNac as cod_reg_nac, trim(reg.nombre) as des_reg_nac, ");
			hql.append("uni.idunidad as cod_uni_operativa, trim(uni.nomunidad) as des_uni_operativa, ");
			hql.append("reg.idRanac as cod_reg_nac, reg.nombre as des_reg_nac, "); 
			hql.append("tcp.srlIdComprobante as cod_comprobante,tcp.chrNomComprobante as nom_cp, ");
			hql.append("tss.chrCodSunat as cod_sunat, tss.numSerie as num_serie, ");
			hql.append("tss.intNumCp as num_cp, ");
			hql.append("tss.chrFlgActivo as fla_activo,  tss.chrCodUsuaCreacion as mnt_usu_creacion, ");			
			hql.append("to_char(tss.dteFecCreacion, 'DD/MM/YYYY') as mnt_fec_creacion, ");
			hql.append("tss.chrCodUsuaModifica as mnt_usu_modificacion, ");
			hql.append("to_char(tss.dteFecModifica, 'DD/MM/YYYY') as mnt_fec_modificacion ");			
			hql.append("from TSeries tss ");
			hql.append("left join tss.unidadoperativa uni ");
			hql.append("left join tss.tbtRegistroNac reg ");
			hql.append("left join tss.TTipoComprobante tcp ");
			hql.append("where 1=1 ");
			if (!isNullInteger(serie.getCod_serie())) {
				hql.append("and tss.srlIdSerie = :cod_serie ");
			}
			if (!isNullInteger(serie.getCod_uni_operativa())) {
				hql.append("and uni.idunidad = :cod_uni_operativa ");
			} 
			if (!isNullInteger(serie.getCod_reg_nac())) {
				hql.append("and reg.idRanac = :cod_reg_nac ");
			} 			
			if (!isNullInteger(serie.getCod_comprobante())) {
				hql.append("and tcp.srlIdComprobante = :cod_comprobante ");
			}
			hql.append("order by tss.srlIdSerie");
			Query query = super.getSession().createQuery(hql.toString());
			if (!isNullInteger(serie.getCod_serie())) {
				query.setParameter("cod_serie", serie.getCod_serie());
			}			
			if (!isNullInteger(serie.getCod_uni_operativa())) {
				query.setParameter("cod_uni_operativa", serie.getCod_uni_operativa());
			} 
			if (!isNullInteger(serie.getCod_reg_nac())) {
				query.setParameter("cod_reg_nac", serie.getCod_reg_nac());
			} 			
			if (!isNullInteger(serie.getCod_comprobante())) {
				query.setParameter("cod_comprobante", serie.getCod_comprobante());
			} 			
			return query.setResultTransformer(Transformers.aliasToBean(SeriesBean.class)).list();		
		} catch (Exception e) {
			throw new Exception(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(), 
								Constantes.NIVEL_APP_DAO, 
								this.getClass().getName(), e.getMessage()));
		}
	}
	/* (non-Javadoc)
	 * @see pe.com.mig.service.IMaestroService#grabarseries(pe.com.mig.model.bean.SeriesBean)
	 */
	@Transactional
	@Override	
	public Integer grabarseries(SeriesBean serie) throws Exception {
		Integer codigo = serie.getCod_serie();
		try {		
			TSeries tserie = new TSeries();
			if (!isNullInteger(codigo)) {				
				tserie = (TSeries) getById(TSeries.class, codigo);
			}
			
			tserie.setChrCodSunat(serie.getCod_sunat());
			tserie.setNumSerie(serie.getNum_serie());
			tserie.setIntNumCp(serie.getNum_cp());
			
			tserie.setUnidadoperativa(new Unidadoperativa(serie.getCod_uni_operativa())); 
			tserie.setTbtRegistroNac(new TbtRegistroNac(serie.getCod_reg_nac()));
			tserie.setTTipoComprobante(new TTipoComprobante(serie.getCod_comprobante()));
			
			if (!isNullInteger(codigo)) {
				tserie.setChrCodUsuaModifica(serie.getVnomusuario());
				tserie.setDteFecModifica(Calendar.getInstance().getTime());
				tserie.setChrFlgActivo(serie.getFla_activo()); 
				update(tserie);			
			} else {
				tserie.setChrFlgActivo(Constantes.FLAG_ACTIVO);
				tserie.setChrCodUsuaCreacion(serie.getVnomusuario());
				tserie.setDteFecCreacion(Calendar.getInstance().getTime());
				codigo = getByIdSave(tserie);
			}
		} catch (Exception e) {
			throw new Exception(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(), 
								Constantes.NIVEL_APP_DAO, 
								this.getClass().getName(), e.getMessage()));
		}
		return codigo;
	}
	
	/* (non-Javadoc)
	 * @see pe.com.mig.dao.IMaestroDao#listarPersonaCuarta(pe.com.mig.model.bean.TSeriesBean)
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<PersonaCuartaBean> listarPersonaCuarta(PersonaCuartaBean persona) throws Exception {
		try {
			StringBuilder hql = new StringBuilder();
			hql.append("select tpc.srlIdPersonal as srlIdPersonal, ");
			hql.append("tpc.chrNombres as chrNombres,tpc.chrApePaterno as chrApePaterno, tpc.chrApeMaterno as chrApeMaterno, ");
			hql.append("tpc.chrNombres || ' ' || tpc.chrApePaterno || ' ' || tpc.chrApeMaterno as nombre, ");
			hql.append("tpc.numRuc as numRuc, tpc.chrNumDocumento as chrNumDocumento, ");
			hql.append("to_char(tpc.dteFecNacimiento, 'DD/MM/YYYY') as dteFecNacimiento, ");	
			hql.append("tpc.chrTipSexo as chrTipSexo, tpc.chrNumTelefono as chrNumTelefono, tpc.chrCorreo as chrCorreo, ");
			hql.append("tpc.chrIndEssalud as chrIndEssalud, tpc.chrIndDomiciliario as chrIndDomiciliario, tpc.numRucConvenio as numRucConvenio, ");
			hql.append("tpc.chrNomVia as chrNomVia, tpc.chrNumHogar as chrNumHogar, tpc.chrNumInterior as chrNumInterior, ");
			hql.append(" trim(tvi.chrNomVia)||' '||tpc.chrNomVia ||' '||tpc.chrNumHogar||' Referencia:'||tpc.chrReferencia as direccion_persona, "); 
			hql.append("tpc.chrNomZona as chrNomZona, tpc.chrReferencia as chrReferencia, ");
			hql.append("substring(cast(tpc.idubigeo as string),1,2) as coddpto, ");
			hql.append("substring(cast(tpc.idubigeo as string),3,2) as codprov, ");
			hql.append("substring(cast(tpc.idubigeo as string),5,2) as coddist, ");
			hql.append("tcc.srlIdConvenio as srlIdConvenio,tcc.chrCodConvenio as cod_convenio, trim(tcc.chrNomConvenio) as nom_convenio, ");
			hql.append("tdc.srlIdDocumento as srlIdDocumento,tdc.chrCodDocumento as cod_documento, trim(tdc.chrNomDocumento) as nom_documento, ");
			hql.append("tnp.srlIdNacion as srlIdNacion,trim(tnp.chrNomNacion) as chrNomNacion, ");
			hql.append("tvi.srlIdVia as srlIdVia,tvi.chrCodVia as cod_via, trim(tvi.chrNomVia) as nom_via, ");
			hql.append("tzo.srlIdZona as srlIdZona,tzo.chrCodZona as cod_zona, trim(tzo.chrNomZona) as nom_zona, ");
			hql.append("tpc.chrCodUsuaCreacion as chrCodUsuaCreacion, tpc.dteFecCreacion as dteFecCreacion, ");
			hql.append("tpc.chrCodUsuaModifica as chrCodUsuaModifica, tpc.dteFecModifica as dteFecModifica ");			
			hql.append("from TPersonalCuarta tpc ");
			hql.append("left join tpc.TConvenioCuarta tcc ");
			hql.append("left join tpc.TDocumentoCuarta tdc ");
			hql.append("left join tpc.TNacionalidad tnp ");
			hql.append("left join tpc.TVia tvi ");
			hql.append("left join tpc.TZona tzo ");
			hql.append("where 1=1 ");
			if (!isNullInteger(persona.getSrlIdPersonal())) {
				hql.append("and tpc.srlIdPersonal = :srlIdPersonal ");
			}
			if (!isNullOrEmpty(persona.getChrNombres())) {
				hql.append("and trim(tpc.chrNombres) LIKE :chrNombres "); 
			}
			if (!isNullOrEmpty(persona.getChrApePaterno())) {
				hql.append("and trim(tpc.chrApePaterno) LIKE :chrApePaterno ");
			}
			if (!isNullOrEmpty(persona.getChrApeMaterno())) {
				hql.append("and trim(tpc.chrApeMaterno) LIKE :chrApeMaterno ");
			}
			if (!isNullOrEmpty(persona.getNumRuc())) {
				hql.append("and tpc.numRuc = :numRuc ");
			}
			if (!isNullOrEmpty(persona.getChrNumDocumento())) {
				hql.append("and tpc.chrNumDocumento = :chrNumDocumento ");
			}			
			hql.append("order by tpc.srlIdPersonal");
			Query query = super.getSession().createQuery(hql.toString());
			if (!isNullInteger(persona.getSrlIdPersonal())) {
				query.setParameter("srlIdPersonal", persona.getSrlIdPersonal());
			}			
			if (!isNullOrEmpty(persona.getChrNombres())) {
				query.setParameter("chrNombres", "%" + persona.getChrNombres()+ "%");
			}
			
			if (!isNullOrEmpty(persona.getChrApePaterno())) {
				query.setParameter("chrApePaterno", "%" + persona.getChrApePaterno()+ "%");
			}
			if (!isNullOrEmpty(persona.getChrApeMaterno())) {
				query.setParameter("chrApeMaterno", "%" +persona.getChrApeMaterno()+ "%");				
			}
			if (!isNullOrEmpty(persona.getNumRuc())) {
				query.setParameter("numRuc", persona.getNumRuc());				
			}
			if (!isNullOrEmpty(persona.getChrNumDocumento())) {
				query.setParameter("chrNumDocumento", persona.getChrNumDocumento());				
			}
			return query.setResultTransformer(Transformers.aliasToBean(PersonaCuartaBean.class)).list();		
		} catch (Exception e) {
			throw new Exception(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(), 
								Constantes.NIVEL_APP_DAO, 
								this.getClass().getName(), e.getMessage()));
		}
	}
	
	/* (non-Javadoc)
	 * @see pe.com.mig.service.IMaestroService#grabarpersona(pe.com.mig.model.bean.PersonaCuartaBean)
	 */
	@Transactional
	@Override	
	public Integer grabarpersona(PersonaCuartaBean persona) throws Exception {
		Integer codigo = persona.getSrlIdPersonal();
		try {		
			TPersonalCuarta tpersona = new TPersonalCuarta();
			if (!isNullInteger(codigo)) {				
				tpersona = (TPersonalCuarta) getById(TPersonalCuarta.class, codigo);
			}			
		} catch (Exception e) {
			throw new Exception(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(), 
								Constantes.NIVEL_APP_DAO, 
								this.getClass().getName(), e.getMessage()));
		}
		return codigo;
	}
	
	/* (non-Javadoc)
	 * @see pe.com.mig.dao.IMaestroDao#listarTipoComprobante(pe.com.mig.model.bean.TipoComprobanteBean)
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<TipoComprobanteBean> listarTipoComprobante(TipoComprobanteBean comprobante) throws Exception {
		try {
			StringBuilder hql = new StringBuilder();			
			hql.append("select ttc.srlIdComprobante as cod_comprobante, ttc.chrCodComprobante as vcod_comprobante, ");			
			hql.append("ttc.chrNomComprobante as nom_comprobante, ttc.chrSiglas as siglas, ");			
			hql.append("ttc.intNumDias as num_dias, ttc.intNumMes as num_mes, ");
			hql.append("ttc.chrFlgCompras as compras, ttc.chrFlgVentas as ventas, ");
			hql.append("ttc.numSerie as num_serie, ttc.numComprobante as num_comprobante, ");			
			hql.append("ttc.chrFlgActivo as fla_activo, ttc.chrFlgFactu as fla_factura,  ttc.chrCodUsuaCreacion as mnt_usu_creacion, ");			
			hql.append("to_char(ttc.dteFecCreacion, 'DD/MM/YYYY') as mnt_fec_creacion, ");
			hql.append("ttc.chrCodUsuaModifica as mnt_usu_modificacion, ");
			hql.append("to_char(ttc.dteFecModifica, 'DD/MM/YYYY') as mnt_fec_modificacion ");			
			hql.append("from TTipoComprobante ttc ");
			hql.append("where 1=1 ");
			if (!isNullInteger(comprobante.getCod_comprobante())) {
				hql.append("and ttc.srlIdComprobante = :cod_comprobante ");
			} 
			if (!isNullOrEmpty(comprobante.getVcod_comprobante())) {
				hql.append("and ttc.chrCodComprobante = :vcod_comprobante ");
			} 
			if (!isNullOrEmpty(comprobante.getNom_comprobante())) {
				hql.append("and ttc.chrNomComprobante like :nom_comprobante ");
			} 
			if (!isNullOrEmpty(comprobante.getFla_activo())) {
				hql.append("and ttc.chrFlgActivo = :fla_activo ");
			}
			hql.append("order by ttc.chrCodComprobante");
			Query query = super.getSession().createQuery(hql.toString());
			if (!isNullInteger(comprobante.getCod_comprobante())) {
				query.setParameter("cod_comprobante", comprobante.getCod_comprobante());
			} 
			if (!isNullOrEmpty(comprobante.getVcod_comprobante())) {
				query.setParameter("vcod_comprobante", comprobante.getVcod_comprobante());
			} 
			if (!isNullOrEmpty(comprobante.getNom_comprobante())) {
				query.setParameter("nom_comprobante", "%" + comprobante.getNom_comprobante() + "%");
			} 		
			if (!isNullOrEmpty(comprobante.getFla_activo())) {
				query.setParameter("fla_activo", comprobante.getFla_activo());
			}				
			return query.setResultTransformer(Transformers.aliasToBean(TipoComprobanteBean.class)).list();		
		} catch (Exception e) {
			throw new Exception(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(), 
								Constantes.NIVEL_APP_DAO, 
								this.getClass().getName(), e.getMessage()));
		}
	}


	/* (non-Javadoc)
	 * @see pe.com.mig.service.IMaestroService#grabarUnidadMedida(pe.com.mig.model.bean.UnidadMedidaBean)
	 */
	@Transactional
	@Override	
	public Integer grabarUnidadMedida(UnidadMedidaBean unidadMedida) throws Exception {
		Integer codigo = unidadMedida.getcod_mediopagos();
		try {		
			TUnidadMedida tunidadmedida = new TUnidadMedida();
			if (!isNullInteger(codigo)) {				
				tunidadmedida = (TUnidadMedida) getById(TUnidadMedida.class, codigo);
			}
			tunidadmedida.setChrCodUnidad(unidadMedida.getCod_entidad());
			tunidadmedida.setChrNomUnidad(unidadMedida.getNom_entidad());
			tunidadmedida.setChrFlgActiva(unidadMedida.getFla_activo());
			if (!isNullInteger(codigo)) {
				tunidadmedida.setChrCodUsuaModifica(unidadMedida.getVnomusuario());
				tunidadmedida.setDteFecModifica(Calendar.getInstance().getTime());
				update(tunidadmedida);			
			} else {				
				tunidadmedida.setChrCodUsuaCreacion(unidadMedida.getVnomusuario());
				tunidadmedida.setDteFecCreacion(Calendar.getInstance().getTime());
				codigo = getByIdSave(tunidadmedida);
			}
		} catch (Exception e) {
			throw new Exception(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(), 
								Constantes.NIVEL_APP_DAO, 
								this.getClass().getName(), e.getMessage()));
		}
		return codigo;
	}	
	/* (non-Javadoc)
	 * @see pe.com.mig.dao.IMaestroDao#listarTipoDocumento(pe.com.mig.model.bean.TipoDocumentoBean)
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<TipoDocumentoBean> listarTipoDocumento(TipoDocumentoBean documento) throws Exception {
		try {
			StringBuilder hql = new StringBuilder();			
			hql.append("select tdi.srlIdDocumento as cod_documento, tdi.chrCodDocumento as vcod_documento, ");			
			hql.append("tdi.chrNomDocumento as nom_documento, tdi.chrDocSiglas as doc_siglas, ");	
			hql.append("tdi.chrFlgActivo as fla_activo,  tdi.chrCodUsuaCreacion as mnt_usu_creacion, ");			
			hql.append("to_char(tdi.dteFecCreacion, 'DD/MM/YYYY') as mnt_fec_creacion, ");
			hql.append("tdi.chrCodUsuaModifica as mnt_usu_modificacion, ");
			hql.append("to_char(tdi.dteFecModifica, 'DD/MM/YYYY') as mnt_fec_modificacion ");		
			hql.append("from TDocumentoIdentidad tdi ");	
			hql.append("where 1=1 ");
			if (!isNullInteger(documento.getCod_documento())) {
				hql.append("and tdi.srlIdDocumento = :cod_documento ");
			} 
			if (!isNullOrEmpty(documento.getVcod_documento())) {
				hql.append("and tdi.chrCodDocumento = :vcod_documento ");
			} 
			if (!isNullOrEmpty(documento.getNom_documento())) {
				hql.append("and tdi.chrNomDocumento like :nom_documento ");
			} 
			if (!isNullOrEmpty(documento.getFla_activo())) {
				hql.append("and tdi.chrFlgActivo = :fla_activo ");
			}
			hql.append("order by tdi.chrCodDocumento");
			Query query = super.getSession().createQuery(hql.toString());
			if (!isNullInteger(documento.getCod_documento())) {
				query.setParameter("cod_documento", documento.getCod_documento());
			} 
			if (!isNullOrEmpty(documento.getVcod_documento())) {
				query.setParameter("vcod_documento", documento.getVcod_documento());
			} 
			if (!isNullOrEmpty(documento.getNom_documento())) {
				query.setParameter("nom_documento", "%" + documento.getNom_documento() + "%");
			} 		
			if (!isNullOrEmpty(documento.getFla_activo())) {
				query.setParameter("fla_activo", documento.getFla_activo());
			}			
			return query.setResultTransformer(Transformers.aliasToBean(TipoDocumentoBean.class)).list();		
		} catch (Exception e) {
			throw new Exception(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(), 
								Constantes.NIVEL_APP_DAO, 
								this.getClass().getName(), e.getMessage()));
		}
	}
	/* (non-Javadoc)
	 * @see pe.com.mig.dao.IMaestroDao#grabarTipoDocumento(pe.com.mig.model.bean.TipoDocumentoBean)
	 */
	@Transactional
	@Override
	public Integer grabarTipoDocumento(TipoDocumentoBean tipoDocumento) throws Exception {
		Integer codigo = tipoDocumento.getCod_documento();
		try {		
			TDocumentoIdentidad tdocumento = new TDocumentoIdentidad();
			if (!isNullInteger(codigo)) {				
				tdocumento = (TDocumentoIdentidad) getById(TDocumentoIdentidad.class, codigo);
			}
			tdocumento.setChrCodDocumento(tipoDocumento.getVcod_documento());
			tdocumento.setChrNomDocumento(tipoDocumento.getNom_documento());
			tdocumento.setChrDocSiglas(tipoDocumento.getDoc_siglas());
			tdocumento.setChrFlgActivo(tipoDocumento.getFla_activo());
			if (!isNullInteger(codigo)) {
				tdocumento.setChrCodUsuaModifica(tipoDocumento.getVnomusuario());
				tdocumento.setDteFecModifica(Calendar.getInstance().getTime());
				update(tdocumento);			
			} else {				
				tdocumento.setChrCodUsuaCreacion(tipoDocumento.getVnomusuario());
				tdocumento.setDteFecCreacion(Calendar.getInstance().getTime());
				codigo = getByIdSave(tdocumento);
			}
		} catch (Exception e) {
			throw new Exception(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(), 
								Constantes.NIVEL_APP_DAO, 
								this.getClass().getName(), e.getMessage()));
		}
		return codigo;
	}
	/* (non-Javadoc)
	 * @see pe.com.mig.dao.IMaestroDao#listarTipoMoneda(pe.com.mig.model.bean.TipoMonedaBean)
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<TipoMonedaBean> listarTipoMoneda(TipoMonedaBean moneda) throws Exception {
		try {
			StringBuilder hql = new StringBuilder();			
			hql.append("select ttm.srlIdMoneda as cod_moneda, ttm.chrCodMoneda as vcod_moneda, ");			
			hql.append("ttm.chrNomMoneda as nom_moneda, ttm.chrSiglas as siglas, ");
			hql.append("ttm.chrFlgActivo as fla_activo,  ttm.chrCodUsuaCreacion as mnt_usu_creacion, ");			
			hql.append("to_char(ttm.dteFecCreacion, 'DD/MM/YYYY') as mnt_fec_creacion, ");
			hql.append("ttm.chrCodUsuaModifica as mnt_usu_modificacion, ");
			hql.append("to_char(ttm.dteFecModifica, 'DD/MM/YYYY') as mnt_fec_modificacion ");
			hql.append("from TTipoMoneda ttm ");
			hql.append("where 1=1 ");
		
			if (!isNullInteger(moneda.getCod_moneda())) {
				hql.append("and ttm.srlIdMoneda = :cod_moneda ");
			}
			if (!isNullOrEmpty(moneda.getFla_activo())) {
				hql.append("and ttm.chrFlgActivo = :fla_activo ");
			}			
			hql.append("order by ttm.chrCodMoneda");	
			Query query = super.getSession().createQuery(hql.toString());
			if (!isNullInteger(moneda.getCod_moneda())) {
				query.setParameter("cod_moneda", moneda.getCod_moneda());
			}
			if (!isNullOrEmpty(moneda.getFla_activo())) {
				query.setParameter("fla_activo", moneda.getFla_activo());
			}
			return query.setResultTransformer(Transformers.aliasToBean(TipoMonedaBean.class)).list();		
		} catch (Exception e) {
			throw new Exception(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(), 
								Constantes.NIVEL_APP_DAO, 
								this.getClass().getName(), e.getMessage()));
		}
	}

	/* (non-Javadoc)
	 * @see pe.com.mig.dao.IMaestroDao#listarTipoMoneda(pe.com.mig.model.bean.TipoMonedaBean)
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<OtrosBean> listarOtros(OtrosBean otros) throws Exception {
		try {
			StringBuilder hql = new StringBuilder();			
			hql.append("select ttm.srlIdOtros as cod_otro, ");			
			hql.append("ttm.chrNomOtros as nom_otro, ttm.chrSiglas as siglas, ");
			hql.append("ttm.chrFlgActivo as fla_activo,  ttm.chrCodUsuaCreacion as mnt_usu_creacion, ");			
			hql.append("to_char(ttm.dteFecCreacion, 'DD/MM/YYYY') as mnt_fec_creacion, ");
			hql.append("ttm.chrCodUsuaModifica as mnt_usu_modificacion, ");
			hql.append("to_char(ttm.dteFecModifica, 'DD/MM/YYYY') as mnt_fec_modificacion ");
			hql.append("from TOtros ttm ");
			hql.append("where 1=1 ");
		
			if (!isNullInteger(otros.getCod_otro())) {
				hql.append("and ttm.srlIdOtros = :cod_otro ");
			}
			if (!isNullOrEmpty(otros.getFla_activo())) {
				hql.append("and ttm.chrFlgActivo = :fla_activo ");
			}			
			hql.append("order by ttm.srlIdOtros");	
			Query query = super.getSession().createQuery(hql.toString());
			if (!isNullInteger(otros.getCod_otro())) {
				query.setParameter("cod_otro", otros.getCod_otro());
			}
			if (!isNullOrEmpty(otros.getFla_activo())) {
				query.setParameter("fla_activo", otros.getFla_activo());
			}
			return query.setResultTransformer(Transformers.aliasToBean(OtrosBean.class)).list();		
		} catch (Exception e) {
			throw new Exception(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(), 
								Constantes.NIVEL_APP_DAO, 
								this.getClass().getName(), e.getMessage()));
		}
	}

	/* (non-Javadoc)
	 * @see pe.com.mig.service.IMaestroService#grabarTipoMoneda(pe.com.mig.model.bean.TipoMonedaBean)
	 */
	@Transactional
	@Override
	public Integer grabarOtros(OtrosBean otros) throws Exception {
		Integer codigo = otros.getCod_otro();
		try {		
			TOtros totros = new TOtros();
			if (!isNullInteger(codigo)) {				
				totros = (TOtros) getById(TOtros.class, codigo);
			}
			totros.setChrNomOtros(otros.getNom_otro());
			totros.setChrSiglas(otros.getSiglas());
			totros.setChrFlgActivo(otros.getFla_activo());
			if (!isNullInteger(codigo)) {
				totros.setChrCodUsuaModifica(otros.getVnomusuario());
				totros.setDteFecModifica(Calendar.getInstance().getTime());
				update(totros);			
			} else {				
				totros.setChrCodUsuaCreacion(otros.getVnomusuario());
				totros.setDteFecCreacion(Calendar.getInstance().getTime());
				codigo = getByIdSave(totros);
			}
		} catch (Exception e) {
			throw new Exception(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(), 
								Constantes.NIVEL_APP_DAO, 
								this.getClass().getName(), e.getMessage()));
		}
		return codigo;
	}
	
	/* (non-Javadoc)
	 * @see pe.com.mig.dao.IMaestroDao#listarEspecifica(pe.com.mig.model.bean.EspecificaBean)
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<EspecificaBean> listarEspecifica(EspecificaBean especifica) throws Exception {
		try {
			StringBuilder hql = new StringBuilder();			
			hql.append("select tep.srl_id_esp as srl_id_esp, trim(tep.chr_cod_especifica) as chr_cod_especifica, ");			
			hql.append("trim(tep.var_nom_especifica) as var_nom_especifica, tep.chr_anio as chr_anio, ");
			hql.append("tep.chr_estado as chr_estado, tep.int_idmigra as int_idmigra ");			
			hql.append("from TEspecifica tep ");
			hql.append("where 1 = 1 ");
			if (!isNullOrEmpty(especifica.getChr_cod_especifica())) {
				hql.append("and trim(tep.chr_cod_especifica) = :vcod_especifica ");
			}
			hql.append("and tep.chr_anio = '2019' ");
			hql.append("order by tep.var_nom_especifica");	
			Query query = super.getSession().createQuery(hql.toString());
			if (!isNullOrEmpty(especifica.getChr_cod_especifica())) {
				query.setParameter("vcod_especifica", especifica.getChr_cod_especifica());
			}
			//query.setParameter("anio", String.valueOf(DateUtil.getAnioActual()));
			return query.setResultTransformer(Transformers.aliasToBean(EspecificaBean.class)).list();		
		} catch (Exception e) {
			throw new Exception(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(), 
								Constantes.NIVEL_APP_DAO, 
								this.getClass().getName(), e.getMessage()));
		}
	}

	/* (non-Javadoc)
	 * @see pe.com.mig.dao.IMaestroDao#listarFuenteFinanciamiento(pe.com.mig.model.bean.FuenteFinanciamientoBean)
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<FuenteFinanciamientoBean> listarFuenteFinanciamiento(FuenteFinanciamientoBean fuente) throws Exception {
		try {
			StringBuilder hql = new StringBuilder();			
			hql.append("select tff.srlIdFte as cod_fte, tff.chrCodFte as vcod_fte, ");			
			hql.append("tff.chrNomFte as nom_fte, tff.chrFlgActivo as fla_activo ");			
			hql.append("from TFteFto tff ");			
			hql.append("where 1=1 ");
			if (!isNullOrEmpty(fuente.getFla_activo())) {
				hql.append("and tff.chrFlgActivo = :fla_activo ");
			}
			hql.append("order by tff.chrNomFte");	
			Query query = super.getSession().createQuery(hql.toString());
			if (!isNullOrEmpty(fuente.getFla_activo())) {
				query.setParameter("fla_activo", fuente.getFla_activo());
			}
			return query.setResultTransformer(Transformers.aliasToBean(FuenteFinanciamientoBean.class)).list();		
		} catch (Exception e) {
			throw new Exception(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(), 
								Constantes.NIVEL_APP_DAO, 
								this.getClass().getName(), e.getMessage()));
		}
	}

	/* (non-Javadoc)
	 * @see pe.com.mig.dao.IMaestroDao#listarCuentaCorriente(pe.com.mig.model.bean.CuentaCorrienteBean)
	 */
	/* (non-Javadoc)
	 * @see pe.com.mig.dao.IMaestroDao#listarCuentaCorriente(pe.com.mig.model.bean.listarCuentaCorrienteBean)
	 */
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<CuentaCorrienteBean> listarCuentaCorriente(CuentaCorrienteBean ctacte) throws Exception {
		try {
			StringBuilder hql = new StringBuilder();			
			hql.append("select tcc.srlIdFte as cod_fte, tcc.srlIdCta as cod_cta,tcc.chrCodCta as vcod_cta, ");			
			hql.append("tcc.chrNomCta as nom_cta, tcc.chrFlgActivo as fla_activo ");			
			hql.append("from TCtaCte tcc ");			
			hql.append("where 1=1 ");
			/*if (!isNullOrEmpty(ctacte.getVcod_cta())) {
				hql.append("and tcc.chrCodCta = :cod_fte ");
			}*/
			if (!isNullOrEmpty(ctacte.getFla_activo())) {
				hql.append("and tcc.chrFlgActivo = :fla_activo ");
			}
			
			hql.append("order by tcc.chrNomCta");	
			Query query = super.getSession().createQuery(hql.toString());
			if (!isNullOrEmpty(ctacte.getFla_activo())) {
				query.setParameter("fla_activo", ctacte.getFla_activo());
			}
			return query.setResultTransformer(Transformers.aliasToBean(CuentaCorrienteBean.class)).list();		
		} catch (Exception e) {
			throw new Exception(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(), 
								Constantes.NIVEL_APP_DAO, 
								this.getClass().getName(), e.getMessage()));
		}
	}
	
	/* (non-Javadoc)
	 * @see pe.com.mig.dao.IMaestroDao#listarProveedor(pe.com.mig.model.bean.ProveedorBean)
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<ProveedorBean> listarProveedor(ProveedorBean proveedor) throws Exception {
		try {
			StringBuilder hql = new StringBuilder();			
			hql.append("select ttp.srlIdProveedor as cod_proveedor, tdi.srlIdDocumento as cod_documento, ");
			hql.append("tdi.chrCodDocumento as vcod_documento, tdi.chrNomDocumento as nom_documento, ");						
			hql.append("ttp.numRuc as num_ruc, ttp.chrTipProveedor as tip_proveedor, ");
			hql.append("CASE WHEN (ttp.chrTipProveedor = '1') THEN 'Natural' WHEN (ttp.chrTipProveedor = '2') THEN 'Juridico' END AS desc_tip_proveedor,	");
			hql.append("ttp.chrTipEstado as tip_estado, ttp.chrRazSocial as raz_social, ");
			hql.append("ttp.chrNumDocumento as num_documento, ttp.chrNombres as nombres, ");
			hql.append("ttp.chrApePaterno as ape_paterno, ttp.chrApeMaterno as ape_materno, ");			
			hql.append("ttp.chrDireccion as direccion, ttp.chrTelefono as telefono, ");
			hql.append("ttp.chrMail as mail, ttp.chrGiro as giro, ");
			hql.append("ttp.chrFlgActivo as fla_activo,  ttp.chrCodUsuaCreacion as mnt_usu_creacion, ");			
			hql.append("to_char(ttp.dteFecCreacion, 'DD/MM/YYYY') as mnt_fec_creacion, ");
			hql.append("ttp.chrCodUsuaModifica as mnt_usu_modificacion, ");
			hql.append("to_char(ttp.dteFecModifica, 'DD/MM/YYYY') as mnt_fec_modificacion ");			
			hql.append("from TTipoProveedor ttp ");
			hql.append("left join ttp.TDocumentoIdentidad tdi ");
			hql.append("where 1=1 ");
			if (!isNullInteger(proveedor.getCod_proveedor())) {
				hql.append("and ttp.srlIdProveedor = :cod_proveedor ");
			} 
			if (!isNullInteger(proveedor.getCod_documento())) {
				hql.append("and tdi.srlIdDocumento = :cod_documento ");
			} 
			if (!isNullOrEmpty(proveedor.getNum_documento())) {
				hql.append("and ttp.chrNumDocumento = :num_documento ");
			} 
			if (!isNullOrEmpty(proveedor.getTip_proveedor())) {
				hql.append("and ttp.chrTipProveedor = :tip_proveedor ");
			} 
			if (!isNullOrEmpty(proveedor.getTip_estado())) {
				hql.append("and ttp.chrTipEstado = :tip_estado ");
			} 
			if (!isNullLong(proveedor.getNum_ruc())) {
				hql.append("and ttp.numRuc = :num_ruc ");
			} 
			if (!isNullOrEmpty(proveedor.getFla_activo())) {
				hql.append("and ttp.chrFlgActivo = :fla_activo ");
			}
			hql.append("order by ttp.numRuc");	

			Query query = super.getSession().createQuery(hql.toString());
			if (!isNullInteger(proveedor.getCod_proveedor())) {
				query.setParameter("cod_proveedor", proveedor.getCod_proveedor());
			} 
			if (!isNullInteger(proveedor.getCod_documento())) {
				query.setParameter("cod_documento", proveedor.getCod_documento());
			} 
			if (!isNullOrEmpty(proveedor.getNum_documento())) {
				query.setParameter("num_documento", proveedor.getNum_documento());
			} 
			if (!isNullOrEmpty(proveedor.getTip_proveedor())) {
				query.setParameter("tip_proveedor", proveedor.getTip_proveedor());
			} 
			if (!isNullOrEmpty(proveedor.getTip_estado())) {
				query.setParameter("tip_estado", proveedor.getTip_estado());
			} 
			if (!isNullLong(proveedor.getNum_ruc())) {
				query.setParameter("num_ruc", proveedor.getNum_ruc());
			}
			if (!isNullOrEmpty(proveedor.getFla_activo())) {
				query.setParameter("fla_activo", proveedor.getFla_activo());
			} 	
			return query.setResultTransformer(Transformers.aliasToBean(ProveedorBean.class)).list();	
		} catch (Exception e) {
			throw new Exception(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(), 
								Constantes.NIVEL_APP_DAO, 
								this.getClass().getName(), e.getMessage()));
		}
	}

	/* (non-Javadoc)
	 * @see pe.com.mig.dao.IMaestroDao#grabarProveedor(pe.com.mig.model.bean.ProveedorBean)
	 */
	@Transactional
	@Override
	public Integer grabarProveedor(ProveedorBean proveedor) throws Exception {
		Integer codigo = proveedor.getCod_proveedor();
		try {		
			TTipoProveedor ttipoProveedor = new TTipoProveedor();
			if (!isNullInteger(codigo)) {				
				ttipoProveedor = (TTipoProveedor) getById(TTipoProveedor.class, codigo);
			}
			if (!isNullInteger(proveedor.getCod_documento())) {
				ttipoProveedor.setTDocumentoIdentidad(new TDocumentoIdentidad(proveedor.getCod_documento()));
			}
			ttipoProveedor.setNumRuc(proveedor.getNum_ruc());
			ttipoProveedor.setChrTipProveedor(proveedor.getTip_proveedor());
			ttipoProveedor.setChrTipEstado(proveedor.getTip_estado());
			ttipoProveedor.setChrRazSocial(proveedor.getRaz_social());
			ttipoProveedor.setChrNumDocumento(proveedor.getNum_documento());
			ttipoProveedor.setChrNombres(proveedor.getNombres());
			ttipoProveedor.setChrApePaterno(proveedor.getApe_paterno());
			ttipoProveedor.setChrApeMaterno(proveedor.getApe_materno());
			ttipoProveedor.setChrDireccion(proveedor.getDireccion());			
			ttipoProveedor.setChrTelefono(proveedor.getTelefono());
			ttipoProveedor.setChrMail(proveedor.getMail());
			ttipoProveedor.setChrGiro(proveedor.getGiro());
			if (!isNullInteger(codigo)) {
				ttipoProveedor.setChrCodUsuaModifica(proveedor.getVnomusuario());
				ttipoProveedor.setDteFecModifica(Calendar.getInstance().getTime());
				update(ttipoProveedor);			
			} else {
				ttipoProveedor.setChrFlgActivo(Constantes.FLAG_ACTIVO);
				ttipoProveedor.setChrCodUsuaCreacion(proveedor.getVnomusuario());
				ttipoProveedor.setDteFecCreacion(Calendar.getInstance().getTime());
				codigo = getByIdSave(ttipoProveedor);
			}
		} catch (Exception e) {
			throw new Exception(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(), 
								Constantes.NIVEL_APP_DAO, 
								this.getClass().getName(), e.getMessage()));
		}
		return codigo;		
	}

	/* (non-Javadoc)
	 * @see pe.com.mig.service.IMaestroService#grabarTipoMoneda(pe.com.mig.model.bean.TipoMonedaBean)
	 */
	@Transactional
	@Override
	public Integer grabarTipoMoneda(TipoMonedaBean tipoMoneda) throws Exception {
		Integer codigo = tipoMoneda.getCod_moneda();
		try {		
			TTipoMoneda ttipoMoneda = new TTipoMoneda();
			if (!isNullInteger(codigo)) {				
				ttipoMoneda = (TTipoMoneda) getById(TTipoMoneda.class, codigo);
			}
			ttipoMoneda.setChrNomMoneda(tipoMoneda.getNom_moneda());
			ttipoMoneda.setChrSiglas(tipoMoneda.getSiglas());
			ttipoMoneda.setChrFlgActivo(tipoMoneda.getFla_activo());
			if (!isNullInteger(codigo)) {
				ttipoMoneda.setChrCodUsuaModifica(tipoMoneda.getVnomusuario());
				ttipoMoneda.setDteFecModifica(Calendar.getInstance().getTime());
				update(ttipoMoneda);			
			} else {				
				ttipoMoneda.setChrCodUsuaCreacion(tipoMoneda.getVnomusuario());
				ttipoMoneda.setDteFecCreacion(Calendar.getInstance().getTime());
				codigo = getByIdSave(ttipoMoneda);
			}
		} catch (Exception e) {
			throw new Exception(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(), 
								Constantes.NIVEL_APP_DAO, 
								this.getClass().getName(), e.getMessage()));
		}
		return codigo;
	}
	/* (non-Javadoc)
	 * @see pe.com.mig.dao.IMaestroDao#listarFinanciero(pe.com.mig.model.bean.EntidadFinancieraBean)
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<EntidadFinancieraBean> listarFinanciero(EntidadFinancieraBean financiero) throws Exception {
		try {
			StringBuilder hql = new StringBuilder();			
			hql.append("select tef.srlIdEntidad as cod_financiero, ");					
			hql.append("tef.chrCodEntidad as cod_entidad,  tef.chrNomEntidad as nom_entidad, ");	
			hql.append("tef.numRuc as num_ruc, ");		
			hql.append("tef.chrFlgActivo as fla_activo,  tef.chrCodUsuaCreacion as mnt_usu_creacion, ");			
			hql.append("to_char(tef.dteFecCreacion, 'DD/MM/YYYY') as mnt_fec_creacion, ");
			hql.append("tef.chrCodUsuaModifica as mnt_usu_modificacion,");
			hql.append("to_char(tef.dteFecModifica, 'DD/MM/YYYY') as mnt_fec_modificacion ");			
			hql.append("from TEntidadFinanciera tef ");
			hql.append("where 1=1 ");
			if (!isNullInteger(financiero.getCod_financiero())) {
				hql.append("and tef.srlIdEntidad = :cod_financiero ");
			} 
			if (!isNullOrEmpty(financiero.getCod_entidad())) {
				hql.append("and tef.chrCodEntidad = :cod_entidad ");
			} 
			if (!isNullOrEmpty(financiero.getNom_entidad())) {
				hql.append("and tef.chrNomEntidad LIKE :nom_entidad ");
			} 
			if (!isNullOrEmpty(financiero.getFla_activo())) {
				hql.append("and tef.chrFlgActivo = :fla_activo ");
			}
			hql.append("order by tef.chrCodEntidad");
			Query query = super.getSession().createQuery(hql.toString());
			if (!isNullInteger(financiero.getCod_financiero())) {
				query.setParameter("cod_financiero", financiero.getCod_financiero());
			} 
			if (!isNullOrEmpty(financiero.getCod_entidad())) {
				query.setParameter("cod_entidad", financiero.getCod_entidad());
			} 
			if (!isNullOrEmpty(financiero.getNom_entidad())) {
				query.setParameter("nom_entidad", "%" + financiero.getNom_entidad() + "%");
			} 		
			if (!isNullOrEmpty(financiero.getFla_activo())) {
				query.setParameter("fla_activo", financiero.getFla_activo());
			} 			
			

			return query.setResultTransformer(Transformers.aliasToBean(EntidadFinancieraBean.class)).list();		
		} catch (Exception e) {
			throw new Exception(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(), 
								Constantes.NIVEL_APP_DAO, 
								this.getClass().getName(), e.getMessage()));
		}
	}
	/* (non-Javadoc)
	 * @see pe.com.mig.service.IMaestroService#grabarEntidadFinanciera(pe.com.mig.model.bean.EntidadFinancieraBean)
	 */
	@Transactional
	@Override	
	public Integer grabarEntidadFinanciera(EntidadFinancieraBean financiero) throws Exception {
		Integer codigo = financiero.getCod_financiero();
		try {		
			TEntidadFinanciera tentidadFinanciera = new TEntidadFinanciera();
			if (!isNullInteger(codigo)) {				
				tentidadFinanciera = (TEntidadFinanciera) getById(TEntidadFinanciera.class, codigo);
			}
			tentidadFinanciera.setChrCodEntidad(financiero.getCod_entidad());
			tentidadFinanciera.setChrNomEntidad(financiero.getNom_entidad());
			tentidadFinanciera.setNumRuc(financiero.getNum_ruc());
			tentidadFinanciera.setChrFlgActivo(financiero.getFla_activo());
			if (!isNullInteger(codigo)) {
				tentidadFinanciera.setChrCodUsuaModifica(financiero.getVnomusuario());
				tentidadFinanciera.setDteFecModifica(Calendar.getInstance().getTime());
				update(tentidadFinanciera);			
			} else {				
				tentidadFinanciera.setChrCodUsuaCreacion(financiero.getVnomusuario());
				tentidadFinanciera.setDteFecCreacion(Calendar.getInstance().getTime());
				codigo = getByIdSave(tentidadFinanciera);
			}
		} catch (Exception e) {
			throw new Exception(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(), 
								Constantes.NIVEL_APP_DAO, 
								this.getClass().getName(), e.getMessage()));
		}
		return codigo;
	}
	/* (non-Javadoc)
	 * @see pe.com.mig.dao.IMaestroDao#listarMedioPago(pe.com.mig.model.bean.MediosPagosBean)
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<MediosPagosBean> listarMedioPago(MediosPagosBean financiero) throws Exception {
		try {
			StringBuilder hql = new StringBuilder();			
			hql.append("select tme.srlIdMedio as cod_mediopagos, ");					
			hql.append("tme.chrCodMedio as cod_entidad,  tme.chrNomMedio as nom_entidad, ");	
			hql.append("tme.chrFlgActivo as fla_activo,  tme.chrCodUsuaCreacion as mnt_usu_creacion, ");
			hql.append("tme.chrCodUsuaModifica as mnt_usu_modificacion,");
			hql.append("to_char(tme.dteFecCreacion, 'DD/MM/YYYY') as mnt_fec_creacion, ");
			hql.append("tme.chrCodUsuaCreacion as mnt_usu_creacion, ");
			hql.append("to_char(tme.dteFecModifica, 'DD/MM/YYYY') as mnt_fec_modificacion ");			
			hql.append("from TMedioPago tme ");
			hql.append("where 1=1 ");
			if (!isNullInteger(financiero.getcod_mediopagos())) {
				hql.append("and tme.srlIdMedio = :cod_mediopagos ");
			} 
			if (!isNullOrEmpty(financiero.getCod_entidad())) {
				hql.append("and tme.chrCodMedio = :cod_entidad ");
			} 
			if (!isNullOrEmpty(financiero.getNom_entidad())) {
				hql.append("and tme.chrNomMedio like :nom_entidad ");
			} 
			if (!isNullOrEmpty(financiero.getFla_activo())) {
				hql.append("and tme.chrFlgActivo = :fla_activo ");
			}
			hql.append("order by tme.chrCodMedio");
			Query query = super.getSession().createQuery(hql.toString());
			if (!isNullInteger(financiero.getcod_mediopagos())) {
				query.setParameter("cod_mediopagos", financiero.getcod_mediopagos());
			} 
			if (!isNullOrEmpty(financiero.getCod_entidad())) {
				query.setParameter("cod_entidad", financiero.getCod_entidad());
			} 
			if (!isNullOrEmpty(financiero.getNom_entidad())) {
				query.setParameter("nom_entidad", "%" + financiero.getNom_entidad() + "%");
			} 		
			if (!isNullOrEmpty(financiero.getFla_activo())) {
				query.setParameter("fla_activo", financiero.getFla_activo());
			} 			
			return query.setResultTransformer(Transformers.aliasToBean(MediosPagosBean.class)).list();		
		} catch (Exception e) {
			throw new Exception(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(), 
								Constantes.NIVEL_APP_DAO, 
								this.getClass().getName(), e.getMessage()));
		}
	}
	/* (non-Javadoc)
	 * @see pe.com.mig.dao.IMaestroDao#listarMedioPago(pe.com.mig.model.bean.MediosPagosBean)
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<DireccionFacturaBean> listarDirecFact(DireccionFacturaBean factura) throws Exception {
		try {
			StringBuilder hql = new StringBuilder();			
			hql.append("select tdf.srlIdDirec as srl_direc, ");					
			hql.append("tdf.chrCodDirec as cod_direc,  tdf.chrTipOficina as tip_oficina, ");	
			hql.append("tdf.chrNomAnp as nom_anp,  tdf.chrNomUbigeo as nom_ubigeo, ");	
			hql.append("tdf.chrDirec as chr_direc,  tdf.chrRefDirec as chr_ref_direc, ");
			hql.append("tdf.chrLegal as chr_legal ");
			hql.append("from TDireccionFactura tdf ");
			hql.append("where 1=1 ");
			if (!isNullInteger(factura.getSrl_direc())) {
				hql.append("and tdf.srlIdDirec = :srl_direc ");
			} 
			if (!isNullOrEmpty(factura.getCod_direc())) {
				hql.append("and tdf.chrCodDirec = :cod_direc ");
			} 
			if (!isNullOrEmpty(factura.getChr_direc())) {
				hql.append("and tdf.chrDirec = :chr_direc ");
			} 
			hql.append("order by tdf.chrCodDirec");
			Query query = super.getSession().createQuery(hql.toString());
			if (!isNullInteger(factura.getSrl_direc())) {
				query.setParameter("srl_direc", factura.getSrl_direc());
			} 
			if (!isNullOrEmpty(factura.getCod_direc())) {
				query.setParameter("cod_direc", factura.getCod_direc());
			} 
			if (!isNullOrEmpty(factura.getChr_direc())) {
				query.setParameter("chr_direc", factura.getChr_direc());
			} 					
			return query.setResultTransformer(Transformers.aliasToBean(DireccionFacturaBean.class)).list();		
		} catch (Exception e) {
			throw new Exception(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(), 
								Constantes.NIVEL_APP_DAO, 
								this.getClass().getName(), e.getMessage()));
		}
	}	
	/* (non-Javadoc)
	 * @see pe.com.mig.dao.IMaestroDao#listarFinanciero(pe.com.mig.model.bean.EntidadFinancieraBean)
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<LibroRegistroBean> listarLibroRegistro(LibroRegistroBean financiero) throws Exception {
		try {
			StringBuilder hql = new StringBuilder();			
			hql.append("select tlib.srlIdLibro as cod_libroregistro, ");					
			hql.append("tlib.chrCodLibro as cod_entidad,  tlib.chrNomLibro as nom_entidad, ");	
			hql.append("tlib.chrFlgActivo as fla_activo,  tlib.chrCodUsuaCreacion as mnt_usu_creacion, ");			
			hql.append("to_char(tlib.dteFecCreacion, 'DD/MM/YYYY') as mnt_fec_creacion, ");
			hql.append("tlib.chrCodUsuaModifica as mnt_usu_modificacion, ");
			hql.append("to_char(tlib.dteFecModifica, 'DD/MM/YYYY') as mnt_fec_modificacion ");			
			hql.append("from TLibroRegistro tlib ");
			hql.append("where 1=1 ");
			if (!isNullInteger(financiero.getcod_libroregistro())) {
				hql.append("and tlib.srlIdLibro = :cod_libroregistro ");
			} 
			if (!isNullOrEmpty(financiero.getCod_entidad())) {
				hql.append("and tlib.chrCodLibro = :cod_entidad ");
			} 
			if (!isNullOrEmpty(financiero.getNom_entidad())) {
				hql.append("and tlib.chrNomLibro LIKE :nom_entidad ");
			} 
			if (!isNullOrEmpty(financiero.getFla_activo())) {
				hql.append("and tlib.chrFlgActivo = :fla_activo ");
			}
			hql.append("order by tlib.chrCodLibro");	
			Query query = super.getSession().createQuery(hql.toString());
			if (!isNullInteger(financiero.getcod_libroregistro())) {
				query.setParameter("cod_libroregistro", financiero.getcod_libroregistro());
			} 
			if (!isNullOrEmpty(financiero.getCod_entidad())) {
				query.setParameter("cod_entidad", financiero.getCod_entidad());
			} 
			if (!isNullOrEmpty(financiero.getNom_entidad())) {
				query.setParameter("nom_entidad", "%" + financiero.getNom_entidad() + "%");
			} 		
			if (!isNullOrEmpty(financiero.getFla_activo())) {
				query.setParameter("fla_activo", financiero.getFla_activo());
			}
			return query.setResultTransformer(Transformers.aliasToBean(LibroRegistroBean.class)).list();		
		} catch (Exception e) {
			throw new Exception(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(), 
								Constantes.NIVEL_APP_DAO, 
								this.getClass().getName(), e.getMessage()));
		}
	}
	/* (non-Javadoc)
	 * @see pe.com.mig.service.IMaestroService#grabarMedioPago(pe.com.mig.model.bean.MediosPagosBean)
	 */
	@Transactional
	@Override	
	public Integer grabarLibroRegistro(LibroRegistroBean financiero) throws Exception {
		Integer codigo = financiero.getcod_libroregistro();
		try {		
			TLibroRegistro tentidadFinanciera = new TLibroRegistro();
			if (!isNullInteger(codigo)) {				
				tentidadFinanciera = (TLibroRegistro) getById(TLibroRegistro.class, codigo);
			}
			tentidadFinanciera.setChrCodLibro(financiero.getCod_entidad());
			tentidadFinanciera.setChrNomLibro(financiero.getNom_entidad());
			tentidadFinanciera.setChrFlgActivo(financiero.getFla_activo());
			if (!isNullInteger(codigo)) {
				tentidadFinanciera.setChrCodUsuaModifica(financiero.getVnomusuario());
				tentidadFinanciera.setDteFecModifica(Calendar.getInstance().getTime());
				update(tentidadFinanciera);			
			} else {				
				tentidadFinanciera.setChrCodUsuaCreacion(financiero.getVnomusuario());
				tentidadFinanciera.setDteFecCreacion(Calendar.getInstance().getTime());
				codigo = getByIdSave(tentidadFinanciera);
			}
		} catch (Exception e) {
			throw new Exception(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(), 
								Constantes.NIVEL_APP_DAO, 
								this.getClass().getName(), e.getMessage()));
		}
		return codigo;
	}
	/* (non-Javadoc)
	 * @see pe.com.mig.service.IMaestroService#grabarMedioPago(pe.com.mig.model.bean.MediosPagosBean)
	 */
	@Transactional
	@Override	
	public Integer grabarMedioPago(MediosPagosBean financiero) throws Exception {
		Integer codigo = financiero.getcod_mediopagos();
		try {		
			TMedioPago tentidadFinanciera = new TMedioPago();
			if (!isNullInteger(codigo)) {				
				tentidadFinanciera = (TMedioPago) getById(TMedioPago.class, codigo);
			}
			tentidadFinanciera.setChrCodMedio(financiero.getCod_entidad());
			tentidadFinanciera.setChrNomMedio(financiero.getNom_entidad());
			tentidadFinanciera.setChrFlgActivo(financiero.getFla_activo());
			if (!isNullInteger(codigo)) {
				tentidadFinanciera.setChrCodUsuaModifica(financiero.getVnomusuario());
				tentidadFinanciera.setDteFecModifica(Calendar.getInstance().getTime());
				update(tentidadFinanciera);			
			} else {				
				tentidadFinanciera.setChrCodUsuaCreacion(financiero.getVnomusuario());
				tentidadFinanciera.setDteFecCreacion(Calendar.getInstance().getTime());
				codigo = getByIdSave(tentidadFinanciera);
			}
		} catch (Exception e) {
			throw new Exception(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(), 
								Constantes.NIVEL_APP_DAO, 
								this.getClass().getName(), e.getMessage()));
		}
		return codigo;
	}
	/* (non-Javadoc)
	 * @see pe.com.mig.service.IMaestroService#grabarTipoComprobante(pe.com.mig.model.bean.TipoComprobanteBean)
	 */
	@Transactional
	@Override
	public Integer grabarTipoComprobante(TipoComprobanteBean comprobante) throws Exception {
		Integer codigo = comprobante.getCod_comprobante();
		try {		
			TTipoComprobante ttipocomprobante = new TTipoComprobante();
			if (!isNullInteger(codigo)) {				
				ttipocomprobante = (TTipoComprobante) getById(TTipoComprobante.class, codigo);
			}
			ttipocomprobante.setChrCodComprobante(comprobante.getVcod_comprobante());
			ttipocomprobante.setChrNomComprobante(comprobante.getNom_comprobante());
			ttipocomprobante.setChrSiglas(comprobante.getSiglas());
			ttipocomprobante.setIntNumMes(comprobante.getNum_mes());
			ttipocomprobante.setNumSerie(comprobante.getNum_serie());
			ttipocomprobante.setNumComprobante(comprobante.getNum_comprobante());
			ttipocomprobante.setChrFlgActivo(comprobante.getFla_activo());	
			ttipocomprobante.setChrFlgCompras(comprobante.getCompras());
			ttipocomprobante.setChrFlgVentas(comprobante.getVentas());
			ttipocomprobante.setChrFlgFactu(comprobante.getFla_factura());
			if (!isNullInteger(codigo)) {
				ttipocomprobante.setChrCodUsuaModifica(comprobante.getVnomusuario());
				ttipocomprobante.setDteFecModifica(Calendar.getInstance().getTime());
				update(ttipocomprobante);			
			} else {				
				ttipocomprobante.setChrCodUsuaCreacion(comprobante.getVnomusuario());
				ttipocomprobante.setDteFecCreacion(Calendar.getInstance().getTime());
				codigo = getByIdSave(ttipocomprobante);
			}
		} catch (Exception e) {
			throw new Exception(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(), 
								Constantes.NIVEL_APP_DAO, 
								this.getClass().getName(), e.getMessage()));
		}
		return codigo;
	}
	/* (non-Javadoc)
	 * @see pe.com.mig.service.IMaestroService#listarUnidadMedida(pe.com.mig.model.bean.UnidadMedidaBean)
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<UnidadMedidaBean> listarUnidadMedida(UnidadMedidaBean unidadMedida) throws Exception {
		try {
			StringBuilder hql = new StringBuilder();			
			hql.append("select tum.srlIdUnidad as cod_mediopagos, tum.chrCodUnidad as cod_entidad, ");			
			hql.append("tum.chrNomUnidad as nom_entidad, ");		
			hql.append("tum.chrFlgActiva as fla_activo,  tum.chrCodUsuaCreacion as mnt_usu_creacion, ");			
			hql.append("to_char(tum.dteFecCreacion, 'DD/MM/YYYY') as mnt_fec_creacion, ");
			hql.append("tum.chrCodUsuaModifica as mnt_usu_modificacion, ");
			hql.append("to_char(tum.dteFecModifica, 'DD/MM/YYYY') as mnt_fec_modificacion ");			
			hql.append("from TUnidadMedida tum ");
			hql.append("where 1=1 ");
			if (!isNullInteger(unidadMedida.getcod_mediopagos())) {
				hql.append("and tum.srlIdUnidad = :cod_mediopagos ");
			} 
			if (!isNullOrEmpty(unidadMedida.getCod_entidad())) {
				hql.append("and tum.chrCodUnidad = :cod_entidad ");
			} 
			if (!isNullOrEmpty(unidadMedida.getNom_entidad())) {
				hql.append("and tum.chrNomUnidad LIKE :nom_entidad ");
			} 
			if (!isNullOrEmpty(unidadMedida.getFla_activo())) {
				hql.append("and tum.chrFlgActiva = :fla_activo ");
			}
			hql.append("order by tum.chrCodUnidad");
			Query query = super.getSession().createQuery(hql.toString());
			if (!isNullInteger(unidadMedida.getcod_mediopagos())) {
				query.setParameter("cod_mediopagos", unidadMedida.getcod_mediopagos());
			} 
			if (!isNullOrEmpty(unidadMedida.getCod_entidad())) {
				query.setParameter("cod_entidad", unidadMedida.getCod_entidad());
			} 
			if (!isNullOrEmpty(unidadMedida.getNom_entidad())) {
				query.setParameter("nom_entidad", "%" + unidadMedida.getNom_entidad() + "%");
			} 		
			if (!isNullOrEmpty(unidadMedida.getFla_activo())) {
				query.setParameter("fla_activo", unidadMedida.getFla_activo());
			} 	
			
			return query.setResultTransformer(Transformers.aliasToBean(UnidadMedidaBean.class)).list();		
		} catch (Exception e) {
			throw new Exception(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(), 
								Constantes.NIVEL_APP_DAO, 
								this.getClass().getName(), e.getMessage()));
		}
	}
	/* (non-Javadoc)
	 * @see pe.com.mig.service.IMaestroService#grabarMedioPago(pe.com.mig.model.bean.MediosPagosBean)
	 */
	@Transactional
	@Override	
	public Integer grabarproductos(ProductoBean financiero) throws Exception {
		Integer codigo = financiero.getCod_producto();
		try {		
			TProducto tentidadFinanciera = new TProducto();
			if (!isNullInteger(codigo)) {				
				tentidadFinanciera = (TProducto) getById(TProducto.class, codigo);
			}
			tentidadFinanciera.setTUnidadMedida(new TUnidadMedida(financiero.getCod_uni_medida()));
			tentidadFinanciera.setChrCodProducto(financiero.getVcod_producto());
			tentidadFinanciera.setChrNomProducto(financiero.getNom_producto());
			tentidadFinanciera.setChrNomCuenta(financiero.getChrNomCuenta());
			tentidadFinanciera.setChrCodEspecifica(financiero.getCod_especifica());
			tentidadFinanciera.setChrCodCuenta(financiero.getCod_cuenta());
			tentidadFinanciera.setChrFlgActivo(financiero.getFla_activo());
			tentidadFinanciera.setNumImpUnit(financiero.getNum_imp_unit());
			 
			if (!isNullInteger(codigo)) {
				tentidadFinanciera.setChrCodUsuaModifica(financiero.getVnomusuario());
				tentidadFinanciera.setDteFecModifica(Calendar.getInstance().getTime());
				update(tentidadFinanciera);			
			} else {				
				tentidadFinanciera.setChrCodUsuaCreacion(financiero.getVnomusuario());
				tentidadFinanciera.setDteFecCreacion(Calendar.getInstance().getTime());
				codigo = getByIdSave(tentidadFinanciera);
			}
		} catch (Exception e) {
			throw new Exception(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(), 
								Constantes.NIVEL_APP_DAO, 
								this.getClass().getName(), e.getMessage()));
		}
		return codigo;
	}
	/* (non-Javadoc)
	 * @see pe.com.mig.dao.IMaestroDao#listarFinanciero(pe.com.mig.model.bean.EntidadFinancieraBean)
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<ProductoBean> listarproductos(ProductoBean financiero) throws Exception {
		try {
			StringBuilder hql = new StringBuilder();			
			hql.append("select tprod.srlIdProducto as cod_producto, ");					
			hql.append("tprod.chrCodProducto as vcod_producto,  tprod.chrNomProducto as nom_producto, ");	
			hql.append("cast(unid.chrCodUnidad as integer) as cod_uni_medida,  unid.chrNomUnidad as nom_uni_medida, ");	
			hql.append("tprod.chrCodEspecifica as cod_especifica, tprod.chrCodCuenta as cod_cuenta, ");	
			hql.append("tprod.chrNomCuenta as chrNomCuenta,");
			hql.append("tprod.chrFlgActivo as fla_activo,  tprod.chrCodUsuaCreacion as mnt_usu_creacion, ");			
			hql.append("to_char(tprod.dteFecCreacion, 'DD/MM/YYYY') as mnt_fec_creacion, ");
			hql.append("tprod.numImpUnit as num_imp_unit, ");
			hql.append("tprod.chrCodUsuaModifica as mnt_usu_modificacion, ");
			hql.append("to_char(tprod.dteFecModifica, 'DD/MM/YYYY') as mnt_fec_modificacion ");			
			hql.append("from TProducto tprod ");
			hql.append("inner join tprod.TUnidadMedida unid ");
			hql.append("where 1=1 ");
			if (!isNullInteger(financiero.getCod_producto())) {
				hql.append("and tprod.srlIdProducto = :cod_producto ");
			} 
			if (!isNullInteger(financiero.getCod_uni_medida())) {
				hql.append("and unid.srlIdUnidad = :cod_uni_medida ");
			} 
			if (!isNullOrEmpty(financiero.getVcod_producto())) {
				hql.append("and tprod.chrCodProducto = :vcod_producto ");
			} 
			if (!isNullOrEmpty(financiero.getNom_producto())) {
				hql.append("and tprod.chrNomProducto LIKE :nom_producto ");
			} 
			if (!isNullOrEmpty(financiero.getFla_activo())) {
				hql.append("and tprod.chrFlgActivo = :fla_activo ");
			}
			hql.append("order by trim(tprod.chrCodProducto) asc");	
			Query query = super.getSession().createQuery(hql.toString());
			if (!isNullInteger(financiero.getCod_producto())) {
				query.setParameter("cod_producto", financiero.getCod_producto());
			} 
			if (!isNullInteger(financiero.getCod_uni_medida())) {
				query.setParameter("cod_uni_medida", financiero.getCod_uni_medida());
			} 
			if (!isNullOrEmpty(financiero.getVcod_producto())) {
				query.setParameter("vcod_producto", financiero.getVcod_producto());
			} 
			if (!isNullOrEmpty(financiero.getNom_producto())) {
				query.setParameter("nom_producto", "%" + financiero.getNom_producto() + "%");
			} 		
			if (!isNullOrEmpty(financiero.getFla_activo())) {
				query.setParameter("fla_activo", financiero.getFla_activo());
			} 			
			
			return query.setResultTransformer(Transformers.aliasToBean(ProductoBean.class)).list();		
		} catch (Exception e) {
			throw new Exception(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(), 
								Constantes.NIVEL_APP_DAO, 
								this.getClass().getName(), e.getMessage()));
		}
	}
	
	/* (non-Javadoc)
	 * @see pe.com.mig.dao.IMaestroDao#listarCierresMes(pe.com.mig.model.bean.CierreMesBean)
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<CierreMesBean> listarCierresMes(CierreMesBean cierre) throws Exception {
		try {
			StringBuilder hql = new StringBuilder();			
			hql.append("select distinct tcierre.srlIdMes as cod_mes, ");					
			hql.append("tcierre.intAno as anio, tcierre.intMes as mes, ");	
			hql.append("to_char(tcierre.dteFecCierre, 'DD/MM/YYYY') as fec_cierre, ");
			hql.append("to_char(tcierre.dteFecApertura, 'DD/MM/YYYY') as fec_apertura, ");
			hql.append("to_char(tcierre.dteFecDescierre, 'DD/MM/YYYY') as fec_des_cierre, ");			
			hql.append("to_char(tcierre.dteFecDescierreVta, 'DD/MM/YYYY') as fec_des_cierre_vta, ");				
			hql.append("tcierre.chrFlgApertura as fla_apertura, ");	
			hql.append("tcierre.chrFlgAperturaVta as fla_apertura_vta, ");		
			hql.append("CASE WHEN tcierre.dteFecCierre is not null and tcierre.chrFlgApertura='N' and tcierre.chrIndCompra=1 THEN 'CERRADO' ");
			hql.append("     WHEN tcierre.dteFecCierre is not null and tcierre.chrFlgApertura='S' and tcierre.chrIndCompra=1 THEN 'Re-Abierto' ");
			hql.append("else 'ABIERTO' END AS nom_compra, ");
			hql.append("CASE WHEN tcierre.dteFecCierre is not null and tcierre.chrFlgAperturaVta='N' and tcierre.chrIndVenta=2 THEN 'CERRADO' ");
			hql.append("     WHEN tcierre.dteFecCierre is not null and tcierre.chrFlgAperturaVta='S' and tcierre.chrIndVenta=2 THEN 'Re-Abierto' ");
			hql.append("else 'ABIERTO' END AS nom_venta, ");
			hql.append("tcierre.chrIndCompra as ind_tip_compra,tcierre.chrIndVenta as ind_tip_venta, ");
			hql.append("reg.idRanac as cod_reg_nac, uni.idunidad as cod_uni_operativa, ");	
			hql.append("reg.nombre as des_reg_nac, uni.nomunidad as des_uni_operativa, ");	
			hql.append("tcierre.chrCodUsuaCreacion as mnt_usu_creacion, ");
			hql.append("tcierre.chrMesActivo as mes_activo,");
			hql.append("to_char(tcierre.dteFecCreacion, 'DD/MM/YYYY') as mnt_fec_creacion, ");
			hql.append("tcierre.chrCodUsuaModifica as mnt_usu_modificacion, ");
			hql.append("to_char(tcierre.dteFecModifica, 'DD/MM/YYYY') as mnt_fec_modificacion ");			
			hql.append("from TCierreMes tcierre ");
			hql.append("left join tcierre.unidadoperativa uni ");
			hql.append("left join tcierre.tbtRegistroNac reg ");
			hql.append("where 1=1 ");
			
			if (!isNullInteger(cierre.getCod_mes())) {
				hql.append("and tcierre.srlIdMes = :cod_mes ");
			}
			if (!isNullInteger(cierre.getAnio())) {
				hql.append("and tcierre.intAno = :anio ");
			} 
			if (!isNullInteger(cierre.getMes())) {
				hql.append("and tcierre.intMes = :mes ");
			} 
			if (!isNullOrEmpty(cierre.getMes_activo())) {
				hql.append("and tcierre.chrMesActivo = :mes_activo ");
			}			
			if (!isNullInteger(cierre.getCod_uni_operativa())) {
				hql.append("and uni.idunidad = :cod_uni_operativa ");
			}			
			if (!isNullInteger(cierre.getCod_reg_nac())) {
				hql.append("and reg.idRanac = :cod_reg_nac ");
			}
			if (!isNullOrEmpty(cierre.getFec_cierre())) {
				hql.append("and tcierre.dteFecCierre >= :fec_cierre ");
			}
			if (!isNullOrEmpty(cierre.getFec_des_cierre())) {
				hql.append("and tcierre.dteFecDescierre >= :fec_des_cierre ");
			}
			if (!isNullOrEmpty(cierre.getFec_des_cierre_vta())) {
				hql.append("and tcierre.dteFecDescierreVta >= :fec_des_cierre_vta ");
			}
			if (!isNullOrEmpty(cierre.getFla_apertura())) {
				hql.append("and tcierre.chrFlgApertura = :fla_apertura ");
			}
			if (!isNullOrEmpty(cierre.getFla_apertura_vta())) {
				hql.append("and tcierre.chrFlgAperturaVta = :fla_apertura_vta ");
			}			
			Query query = super.getSession().createQuery(hql.toString());
			if (!isNullInteger(cierre.getCod_mes())) {
				query.setParameter("cod_mes", cierre.getCod_mes());
			}			
			if (!isNullInteger(cierre.getAnio())) {
				query.setParameter("anio", cierre.getAnio());
			}			
			if (!isNullInteger(cierre.getMes())) {
				query.setParameter("mes", cierre.getMes());
			} 
			if (!isNullOrEmpty(cierre.getMes_activo())) {
				query.setParameter("mes_activo", cierre.getMes_activo());
			} 			
			if (!isNullInteger(cierre.getCod_uni_operativa())) {
				query.setParameter("cod_uni_operativa", cierre.getCod_uni_operativa());
			}
			if (!isNullInteger(cierre.getCod_reg_nac())) {
				query.setParameter("cod_reg_nac", cierre.getCod_reg_nac());
			}
			if (!isNullOrEmpty(cierre.getFec_cierre())) {
				query.setParameter("fec_cierre", getDate(cierre.getFec_cierre()));
			}
			if (!isNullOrEmpty(cierre.getFec_des_cierre())) {
				query.setParameter("fec_des_cierre", getDate(cierre.getFec_des_cierre()));
			}
			
			if (!isNullOrEmpty(cierre.getFec_des_cierre_vta())) {
				query.setParameter("fec_des_cierre_vta", getDate(cierre.getFec_des_cierre_vta()));
			}
			if (!isNullOrEmpty(cierre.getFla_apertura())) {
				query.setParameter("fla_apertura", cierre.getFla_apertura());
			}
			if (!isNullOrEmpty(cierre.getFla_apertura_vta())) {
				query.setParameter("fla_apertura_vta", cierre.getFla_apertura_vta());
			}
			return query.setResultTransformer(Transformers.aliasToBean(CierreMesBean.class)).list();		
		} catch (Exception e) {
			throw new Exception(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(), 
								Constantes.NIVEL_APP_DAO, 
								this.getClass().getName(), e.getMessage()));
		}
	}
	/* (non-Javadoc)
	 * @see pe.com.mig.service.IMaestroService#grabarCierre(pe.com.mig.model.bean.CierreMesBean)
	 */
	@Transactional
	@Override	
	public Integer grabarCierre(CierreMesBean cierre) throws Exception {
		Integer codigo = cierre.getCod_mes();

		try {		
			if (!cierre.getInd_cie_todos().equals(Constantes.FLAG_ACTIVO)) {
				TCierreMes tcierremes = new TCierreMes();
				if (!isNullInteger(codigo)) {				
					tcierremes = (TCierreMes) getById(TCierreMes.class, codigo);
				}			
				tcierremes.setIntAno(cierre.getAnio());
				tcierremes.setIntMes(cierre.getMes());
				tcierremes.setDteFecCierre(getDate(cierre.getFec_cierre()));
				tcierremes.setChrMesActivo(cierre.getMes_activo());
				tcierremes.setChrFlgApertura(cierre.getFla_apertura());
				tcierremes.setIntAno(cierre.getAnio());
				tcierremes.setChrIndCompra(cierre.getInd_tip_compra());
				tcierremes.setChrIndVenta(cierre.getInd_tip_venta());
			 	tcierremes.setUnidadoperativa(new Unidadoperativa(cierre.getCod_uni_operativa())); 
				tcierremes.setTbtRegistroNac(new TbtRegistroNac(cierre.getCod_reg_nac()));			
				if (!isNullInteger(codigo)) {
					tcierremes.setChrCodUsuaModifica(cierre.getVnomusuario());
					if(cierre.getFla_apertura().equals("S")){
						tcierremes.setDteFecDescierre(Calendar.getInstance().getTime());
						tcierremes.setDteFecApertura(Calendar.getInstance().getTime());
						tcierremes.setChrFlgApertura(cierre.getFla_apertura());
					}else if (cierre.getFla_apertura().equals("N")) {
						tcierremes.setChrFlgApertura(cierre.getFla_apertura());
						tcierremes.setDteFecDescierre(null);
					}
					if(cierre.getFla_apertura_vta().equals("S")){
						tcierremes.setDteFecApertura(Calendar.getInstance().getTime());
						tcierremes.setDteFecDescierreVta(Calendar.getInstance().getTime());
						tcierremes.setChrFlgAperturaVta(cierre.getFla_apertura_vta());
					}else if (cierre.getFla_apertura_vta().equals("N")) {
						tcierremes.setChrFlgAperturaVta(cierre.getFla_apertura_vta());
						tcierremes.setDteFecDescierreVta(null);
					}
					tcierremes.setDteFecModifica(Calendar.getInstance().getTime());
					update(tcierremes);			
				} else {
	 			//	tcierremes.setChrFlgApertura(Constantes.FLAG_ACTIVO);
					tcierremes.setChrCodUsuaCreacion(cierre.getVnomusuario());
					tcierremes.setDteFecCreacion(Calendar.getInstance().getTime());
					codigo = getByIdSave(tcierremes);
				}
			} else { // Cerrar todas las unidades operativas	
				StringBuilder hql = new StringBuilder(); 
				Query query1 = super.getSession().createQuery(" Select count(*) as suma from TCierreMesA tcm where tcm.intAno is null and tcm.chrMesActivo='S' group by tcm.intAno ");
				List list = query1.list();
				int lis = list.size();
				//int num = list.get(0).hashCode();
				if(lis==0) {
					/*
					Query query2 = super.getSession().createQuery("insert into TCierreMesA(intUnidad)" +
			                "Select idunidad from Unidadoperativa where idsede>0 order by idunidad");
			        */
					
					Query query2 = super.getSession().createQuery("insert into TCierreMesA(intUnidad,srlIdAdm) Select tua.idunidad, trn.idRanac from TUnidadoperativaAnpAdm tua, TbtRegistroNac trn "
			                + "where tua.idunidad<>0 and tua.intEstado=1 and tua.idRanac=trn.idRanac "
			                + "order by tua.idunidad,tua.idRanac");
					int result2 = query2.executeUpdate();
					
					hql.append("update TCierreMes ");
					hql.append("set dteFecCierre = :fec_cierre, ");
					hql.append("chrCodUsuaCreacion = :cod_usu_mod, ");
					hql.append("dteFecCreacion = :fec_mod, ");
					hql.append("intAno = :anio, ");
					hql.append("intMes = :mes, ");
					hql.append("chrMesActivo = 'S', ");
					hql.append("chrIndCompra = 1, ");
					hql.append("ind_tip_venta = 2, ");
					hql.append("chrFlgApertura = 'N' ");
					hql.append("Where intAno is null ");
				
					Query query = super.getSession().createQuery(hql.toString());
					query.setParameter("fec_cierre", getDate(cierre.getFec_cierre()));
					query.setParameter("cod_usu_mod", cierre.getVnomusuario());
					query.setParameter("fec_mod", Calendar.getInstance().getTime());
					query.setParameter("anio", cierre.getAnio());
					query.setParameter("mes", cierre.getMes());
					query.executeUpdate();
				}
			};				
							
		} catch (Exception e) {
			throw new Exception(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(), 
								Constantes.NIVEL_APP_DAO, 
								this.getClass().getName(), e.getMessage()));
		}
		return codigo;
	}
	
	/* (non-Javadoc)
	 * @see pe.com.mig.dao.IMaestroDao#listarFinanciero(pe.com.mig.model.bean.EntidadFinancieraBean)
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<UnidadMedidaBean> listarUnidadesMedida(UnidadMedidaBean financiero) throws Exception {
		try {
			StringBuilder hql = new StringBuilder();			
			hql.append("select distinct tunid.srlIdUnidad as cod_mediopagos,");					
			hql.append("tunid.chrNomUnidad as nom_entidad ");	
			hql.append("from TUnidadMedida tunid ");
			hql.append("where 1=1 ");
			Query query = super.getSession().createQuery(hql.toString());
			return query.setResultTransformer(Transformers.aliasToBean(UnidadMedidaBean.class)).list();		
		} catch (Exception e) {
			throw new Exception(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(), 
								Constantes.NIVEL_APP_DAO, 
								this.getClass().getName(), e.getMessage()));
		}
	}
	/* (non-Javadoc)
	 * @see pe.com.mig.dao.IMaestroDao#listarFinanciero(pe.com.mig.model.bean.EntidadFinancieraBean)
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<TarifaBoletoBean> listarboletos(TarifaBoletoBean financiero) throws Exception {
		try {
			StringBuilder hql = new StringBuilder();			
			hql.append("select tcierre.srlIdBoleto as cod_boleto, ");					
			hql.append("tcierre.intIdfTarifa as ind_tarifa,  tcierre.chrNomBoleto as nom_boleto, ");	
			hql.append("tcierre.chrCodBoleto as vcod_boleto,  ");	
			hql.append("tcierre.numCntIngreso as can_ingreso,  ");	
			hql.append("tcierre.numCntSalida as can_salida,  ");	
			hql.append("tcierre.chrCodPartida as cod_partida,  ");	
			hql.append("tcierre.numCntStock as can_stock,  ");	
			hql.append("tcierre.chrCodCuenta as cod_cuenta,  ");	
			hql.append("tcierre.chrNomCuenta as chrNomCuenta,");
			hql.append("CASE WHEN (tcierre.intIdfTarifa = 1) THEN 'Tarifa Plana' WHEN (tcierre.intIdfTarifa = 2) THEN 'T.Social' WHEN (tcierre.intIdfTarifa = 3) THEN 'Promoción' WHEN (tcierre.intIdfTarifa = 4) THEN 'Tarifa Unica' WHEN (tcierre.intIdfTarifa = 5) THEN 'Tarifa Convencional' WHEN (tcierre.intIdfTarifa = 6) THEN 'Tarifa Promocionales'  END AS des_ind_tarifa,	");	
			hql.append("tcierre.intNumSerie as num_serie , tcierre.numCntIngreso as can_ingreso, ");	
			hql.append("tcierre.numImpUnit as num_imp_unit , tcierre.chrFlgActivo as fla_activo, ");	
			hql.append("tcierre.numInicio as num_inicio , tcierre.numFinal as num_final, ");
			hql.append("tcierre.numCntStock as can_stock , tcierre.numCntSalida as can_salida, ");
			hql.append("reg.nombre as des_reg_nac, uni.nomunidad as des_uni_operativa, ");	
			hql.append("reg.idRanac as cod_reg_nac,  ");	
			hql.append("uni.idunidad as cod_uni_operativa, ");	
			hql.append("tcierre.chrCodUsuaCreacion as mnt_usu_creacion, ");
			hql.append("to_char(tcierre.dteFecCreacion, 'DD/MM/YYYY') as mnt_fec_creacion, ");
			hql.append("tcierre.chrCodUsuaModifica as mnt_usu_modificacion, ");
			hql.append("to_char(tcierre.dteFecModifica, 'DD/MM/YYYY') as mnt_fec_modificacion ");			
			hql.append("from TTariBoleto tcierre ");
			hql.append("left join tcierre.unidadoperativa uni ");
			hql.append("left join tcierre.tbtRegistroNac reg ");
			hql.append("where 1=1 ");
			
			if (!isNullInteger(financiero.getCod_boleto())) {
				hql.append("and tcierre.srlIdBoleto = :cod_boleto ");
			} 
			if (!isNullInteger(financiero.getInd_tarifa())) {
				hql.append("and tcierre.intIdfTarifa = :ind_tarifa ");
			}
			if (!isNullOrEmpty(financiero.getFla_activo())) {
				hql.append("and tcierre.chrFlgActivo = :fla_activo ");
			}
			
			if (!isNullInteger(financiero.getCod_uni_operativa())) {
				hql.append("and uni.idunidad = :cod_uni_operativa ");
			}
			
			if (!isNullInteger(financiero.getCod_reg_nac())) {
				hql.append("and reg.idRanac = :cod_reg_nac ");
			}
			hql.append("order by tcierre.chrCodBoleto");	
 			Query query = super.getSession().createQuery(hql.toString());
 			
			if (!isNullInteger(financiero.getCod_boleto())) {
				query.setParameter("cod_boleto", financiero.getCod_boleto());
			} 
			if (!isNullInteger(financiero.getInd_tarifa())) {
				query.setParameter("ind_tarifa", financiero.getInd_tarifa());
			} 	
			if (!isNullOrEmpty(financiero.getFla_activo())) {
				query.setParameter("fla_activo", financiero.getFla_activo());
			} 	
			if (!isNullInteger(financiero.getCod_uni_operativa())) {
				query.setParameter("cod_uni_operativa", financiero.getCod_uni_operativa());
			}
			if (!isNullInteger(financiero.getCod_reg_nac())) {
				query.setParameter("cod_reg_nac", financiero.getCod_reg_nac());
			}

			return query.setResultTransformer(Transformers.aliasToBean(TarifaBoletoBean.class)).list();		
		} catch (Exception e) {
			throw new Exception(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(), 
								Constantes.NIVEL_APP_DAO, 
								this.getClass().getName(), e.getMessage()));
		}
	}
	/* (non-Javadoc)
	 * @see pe.com.mig.service.IMaestroService#grabarMedioPago(pe.com.mig.model.bean.TarifaBoletoBean)
	 */
	@Transactional
	@Override	
	public Integer grabartarifaboletos(TarifaBoletoBean financiero) throws Exception {
		Integer codigo = financiero.getCod_boleto();
		try {		
			TTariBoleto tcierremes = new TTariBoleto();
			if (!isNullInteger(codigo)) {				
				tcierremes = (TTariBoleto) getById(TTariBoleto.class, codigo);
			}
			
			tcierremes.setChrCodBoleto(financiero.getVcod_boleto());
			tcierremes.setChrNomBoleto(financiero.getNom_boleto());
			tcierremes.setIntIdfTarifa(financiero.getInd_tarifa());
			tcierremes.setNumImpUnit(financiero.getNum_imp_unit());
			if (!isNullInteger(financiero.getNum_inicio()))
			{tcierremes.setNumInicio(financiero.getNum_inicio());}
			
			if (!isNullInteger(financiero.getNum_final()))
			{tcierremes.setNumFinal(financiero.getNum_final());}
			if (!isNullInteger(financiero.getCan_ingreso()))
			{tcierremes.setNumCntIngreso(financiero.getCan_ingreso());}
			if (!isNullInteger(financiero.getCan_salida()))
			{tcierremes.setNumFinal(financiero.getCan_salida());}
			if (!isNullInteger(financiero.getCan_stock()))
			{tcierremes.setNumFinal(financiero.getCan_stock());}
			
			tcierremes.setChrCodCuenta(financiero.getCod_cuenta());
			tcierremes.setChrCodPartida(financiero.getCod_partida());
			tcierremes.setChrNomBoleto(financiero.getNom_boleto());
			tcierremes.setIntNumSerie(financiero.getNum_serie());

			tcierremes.setChrNomCuenta(financiero.getChrNomCuenta());
			  
		 	tcierremes.setUnidadoperativa(new Unidadoperativa(financiero.getCod_uni_operativa())); 
			tcierremes.setTbtRegistroNac(new TbtRegistroNac(financiero.getCod_reg_nac())); 
			if (!isNullInteger(codigo)) {
				tcierremes.setChrCodUsuaModifica(financiero.getVnomusuario());
				tcierremes.setDteFecModifica(Calendar.getInstance().getTime());
				tcierremes.setChrFlgActivo(financiero.getFla_activo()); //Agredado 31-12-2018 09:59h Y.C.
				update(tcierremes);			
			} else {
 				tcierremes.setChrFlgActivo(Constantes.FLAG_ACTIVO);
				tcierremes.setChrCodUsuaCreacion(financiero.getVnomusuario());
				tcierremes.setDteFecCreacion(Calendar.getInstance().getTime());
				codigo = getByIdSave(tcierremes);
			}
		} catch (Exception e) {
			throw new Exception(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(), 
								Constantes.NIVEL_APP_DAO, 
								this.getClass().getName(), e.getMessage()));
		}
		return codigo;
	}
	/* (non-Javadoc)
	 * @see pe.com.mig.dao.IMaestroDao#listarFinanciero(pe.com.mig.model.bean.EntidadFinancieraBean)
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<CuartaCategoriaBean> listarCuartaCategoria(CuartaCategoriaBean financiero) throws Exception {
		try {
			StringBuilder hql = new StringBuilder();			
			hql.append("select tcierre.srlIdRetenciones as cod_retenciones, ");					
			hql.append("tpc.srlIdPersonal as cod_personalCuarta,  ttc.srlIdComprobante as cod_tipoComprobante, ");	
			hql.append("tcierre.chrNumSerie as chrNumSerie, ");
			hql.append("reg.nombre as des_reg_nac, uni.nomunidad as des_uni_operativa, ");	
			hql.append("reg.idRanac as cod_reg_nac,  ");	
			hql.append("uni.idunidad as cod_uni_operativa, ");	
			hql.append("tcierre.chrTipOperacion as chrTipOperacion, ");	
			hql.append("tpc.numRuc as numRuc, ttc.chrNomComprobante as chrNomComprobante, ");			
			hql.append("tpc.chrNombres as nombres, ");			
			hql.append("tpc.chrApePaterno as ape_paterno, tpc.chrApeMaterno as ape_materno, ");			
			hql.append("to_char(tcierre.dteFecDocumento, 'DD/MM/YYYY') as dteFecDocumento, ");	
			hql.append("to_char(tcierre.dteFecPago, 'DD/MM/YYYY') as dteFecPago, tcierre.chrIndRetencion as chrIndRetencion, ");
			hql.append("tcierre.chrNumComprobante as chrNumComprobante, ");
			hql.append("tcierre.chrNumRetencion as chrNumRetencion, ");
			hql.append("tcierre.intNumSubtotal as numImpSubtotal, ");
			hql.append("tcierre.chrNumRetencion as chrNumRetencion, ");
			hql.append("tcierre.intImpRetenido as numImpRetenido, ");
			hql.append("tcierre.intIdfRegistro as intIdfRegistro, ");
			hql.append("tcierre.intImpTotal as numImpTotal, ");
			hql.append("to_char(tcierre.dteFecCreacion, 'DD/MM/YYYY') as mnt_fec_creacion, ");
			hql.append("tcierre.chrCodUsuaModificacion as mnt_usu_modificacion, ");
			hql.append("tcierre.chrCodUsuaCreacion as mnt_usu_creacion, ");
			hql.append("to_char(tcierre.dteFecModifica, 'DD/MM/YYYY') as mnt_fec_modificacion, ");
			hql.append("tcierre.intCodPadComRecibo as intCodPadComRecibo ");
			hql.append("from TRetenciones tcierre ");
			hql.append("inner join tcierre.TPersonalCuarta tpc ");
			hql.append("inner join tcierre.TComprobanteCuarta ttc ");
			hql.append("left join tcierre.unidadoperativa uni ");
			hql.append("left join tcierre.tbtRegistroNac reg ");
			hql.append("where 1=1 ");
			hql.append("and tcierre.intIdfRegistro = :int_id_registro ");
			if (!isNullInteger(financiero.getCod_retenciones())) {
				hql.append("and tcierre.srlIdRetenciones = :cod_retenciones ");
			} 
			if (!isNullOrEmpty(financiero.getDteFecDocumentoInicial()) && !isNullOrEmpty(financiero.getDteFecDocumentoFinal()) ) {
				hql.append("and tcierre.dteFecDocumento between :dteFecDocumentoInicial  and :dteFecDocumentoFinal ");
			}
			if (!isNullInteger(financiero.getCod_tipoComprobante())) {
				hql.append("and ttc.srlIdComprobante = :cod_tipoComprobante ");
			}
			if (!isNullOrEmpty(financiero.getChrTipOperacion())) {
				hql.append("and tcierre.chrTipOperacion = :chrTipOperacion ");
			}
			if (!isNullOrEmpty(financiero.getChrNumSerie())) {
				hql.append("and tcierre.chrNumSerie = :chrNumSerie ");
			}
			if (!isNullOrEmpty(financiero.getChrNumComprobante())) {
				hql.append("and tcierre.chrNumComprobante = :chrNumComprobante ");
			}
			if (!isNullInteger(financiero.getCod_uni_operativa())) {
				hql.append("and uni.idunidad = :cod_uni_operativa ");
			}			
			if (!isNullInteger(financiero.getCod_reg_nac())) {
				hql.append("and reg.idRanac = :cod_reg_nac ");
			}
			if (!isNullOrEmpty(financiero.getNumRuc())) {
				hql.append("and trim(tpc.numRuc) = :numRuc ");
			}
			
			Query query = super.getSession().createQuery(hql.toString());
			query.setParameter("int_id_registro", Constantes.ESTADO_ACTIVO);
			if (!isNullOrEmpty(financiero.getDteFecDocumentoInicial())) {
				query.setParameter("dteFecDocumentoInicial", getDate(financiero.getDteFecDocumentoInicial()));
			} 
			if (!isNullOrEmpty(financiero.getDteFecDocumentoFinal())) {
				query.setParameter("dteFecDocumentoFinal", getDate(financiero.getDteFecDocumentoFinal()));
			} 		
			if (!isNullInteger(financiero.getCod_tipoComprobante())) {
				query.setParameter("cod_tipoComprobante", financiero.getCod_tipoComprobante());
			} 		
			if (!isNullOrEmpty(financiero.getChrTipOperacion())) {
				query.setParameter("chrTipOperacion", financiero.getChrTipOperacion());
			}
			if (!isNullOrEmpty(financiero.getChrNumSerie())) {
				query.setParameter("chrNumSerie", financiero.getChrNumSerie());
			} 		
			if (!isNullOrEmpty(financiero.getChrNumComprobante())) {
				query.setParameter("chrNumComprobante", financiero.getChrNumComprobante());
			}
			if (!isNullInteger(financiero.getCod_uni_operativa())) {
				query.setParameter("cod_uni_operativa", financiero.getCod_uni_operativa());
			}
			if (!isNullInteger(financiero.getCod_reg_nac())) {
				query.setParameter("cod_reg_nac", financiero.getCod_reg_nac());
			}  
			if (!isNullOrEmpty(financiero.getNumRuc())) {
				query.setParameter("numRuc", financiero.getNumRuc());
			}
			if (!isNullInteger(financiero.getCod_retenciones())) {
				query.setParameter("cod_retenciones", financiero.getCod_retenciones());
			}

			return query.setResultTransformer(Transformers.aliasToBean(CuartaCategoriaBean.class)).list();		
		} catch (Exception e) {
			throw new Exception(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(), 
								Constantes.NIVEL_APP_DAO, 
								this.getClass().getName(), e.getMessage()));
		}
	}
	
	/* (non-Javadoc)
	 * @see pe.com.mig.service.IMaestroService#grabarMedioPago(pe.com.mig.model.bean.TarifaBoletoBean)
	 */
	@Transactional
	@Override	
	public Integer grabarCuartaCategoria(CuartaCategoriaBean financiero) throws Exception {
		Integer codigo = financiero.getCod_retenciones();
		Integer codigonota = financiero.getIntCodPadComRecibo();
		String nota = financiero.getChrNotadeCredito();
		TRetenciones tretenciones = new TRetenciones();
		
		try {		
			
			if(!isNullOrEmpty(nota)){
				  // Nota de credito
				
				if (!isNullInteger(codigonota)) {				
					tretenciones = (TRetenciones) getById(TRetenciones.class, codigonota);
				}
				TRetenciones ret_padre = (TRetenciones) getById(TRetenciones.class, codigo);
				
			//	 Setear los campos padre
				tretenciones.setTPersonalCuarta(ret_padre.getTPersonalCuarta());
				tretenciones.setUnidadoperativa(ret_padre.getUnidadoperativa());
				tretenciones.setTbtRegistroNac(ret_padre.getTbtRegistroNac());
				tretenciones.setChrNumRetencion(ret_padre.getChrNumRetencion());
				tretenciones.setChrIndRetencion(ret_padre.getChrIndRetencion());
				tretenciones.setChrTipOperacion(ret_padre.getChrTipOperacion());
				tretenciones.setChrNumSerie(financiero.getChrNumSerie());
				tretenciones.setChrNumComprobante(financiero.getChrNumComprobante());
				tretenciones.setDteFecDocumento(getDate(financiero.getDteFecDocumento()));
				tretenciones.setTComprobanteCuarta(new TComprobanteCuarta(financiero.getCod_tipoComprobante()));
				
				tretenciones.setIntIdfRegistro(financiero.getIntIdfRegistro());
				
				if(financiero.getIntIdfRegistro() !=2){
					tretenciones.setIntNumSubtotal(financiero.getNumImpSubtotal());
					tretenciones.setIntImpRetenido(financiero.getNumImpRetenido());
					tretenciones.setIntImpTotal(financiero.getNumImpTotal());
					tretenciones.setIntCodPadComRecibo(codigo);
				}
				
				if (!isNullInteger(codigonota)) {
					tretenciones.setChrCodUsuaModificacion(financiero.getVnomusuario());
					tretenciones.setDteFecModifica(Calendar.getInstance().getTime());
					update(tretenciones);			
				} else {
					tretenciones.setChrCodUsuaCreacion(financiero.getVnomusuario());
					tretenciones.setDteFecCreacion(Calendar.getInstance().getTime());
					codigo = getByIdSave(tretenciones);
					ret_padre.setIntCodPadComRecibo(0);
					update(ret_padre);
				}
			} else { // Registro Cuarta Categoria
								
				if (!isNullInteger(codigo)) {				
					tretenciones = (TRetenciones) getById(TRetenciones.class, codigo);
				}
			
				if (!isNullInteger(financiero.getCod_uni_operativa())) {	
					tretenciones.setUnidadoperativa(new Unidadoperativa(financiero.getCod_uni_operativa()));  
					}

				if (!isNullInteger(financiero.getCod_reg_nac())) {	
						tretenciones.setTbtRegistroNac(new TbtRegistroNac(financiero.getCod_reg_nac()));  
					}
				
				tretenciones.setTComprobanteCuarta(new TComprobanteCuarta(financiero.getCod_tipoComprobante()));  
				tretenciones.setTPersonalCuarta(new TPersonalCuarta(financiero.getCod_personalCuarta()));
				
				tretenciones.setChrNumSerie(financiero.getChrNumSerie());
				tretenciones.setChrNumComprobante(financiero.getChrNumComprobante());
				tretenciones.setDteFecDocumento(getDate(financiero.getDteFecDocumento()));
				
				tretenciones.setIntNumSubtotal(financiero.getNumImpSubtotal());
				tretenciones.setIntImpRetenido(financiero.getNumImpRetenido());
				tretenciones.setIntImpTotal(financiero.getNumImpTotal());
				tretenciones.setChrTipOperacion(financiero.getChrTipOperacion()); 
				tretenciones.setChrNumRetencion(financiero.getChrNumRetencion());
				tretenciones.setChrIndRetencion(financiero.getChrFlgRetencion());
				tretenciones.setIntIdfRegistro(financiero.getIntIdfRegistro());
				tretenciones.setDteFecPago(getDate(financiero.getDteFecPago()));
				
				if (!isNullInteger(codigo)) {
					
					tretenciones.setChrCodUsuaModificacion(financiero.getVnomusuario());
					tretenciones.setDteFecModifica(Calendar.getInstance().getTime());
					update(tretenciones);			
					
				} else {
					tretenciones.setChrCodUsuaCreacion(financiero.getVnomusuario());
					tretenciones.setDteFecCreacion(Calendar.getInstance().getTime());
					codigo = getByIdSave(tretenciones);
				}
			}
		
		} catch (Exception e) {
	/*		 throw new Exception(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(), 
								Constantes.NIVEL_APP_DAO, 
								this.getClass().getName(), e.getMessage())); */
			e.printStackTrace();
		}
		return codigo;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<PersonaCuartaBean> verificarRucCuarta(PersonaCuartaBean financiero) throws Exception {
		try {
			StringBuilder hql = new StringBuilder();			
			hql.append("select  tunid.numRuc as numRuc, tunid.srlIdPersonal as srlIdPersonal,");					
			hql.append("tunid.chrApePaterno as chrApePaterno, ");	
			hql.append("tunid.chrApeMaterno as chrApeMaterno, ");	
			hql.append("tunid.chrNombres as chrNombres, ");	
			hql.append("tunid.chrTipSexo as chrTipSexo, ");	
			hql.append("tunid.chrNumTelefono as chrNumTelefono, ");	
			hql.append("tunid.chrCorreo as chrCorreo, ");	
			hql.append("tunid.chrIndEssalud as chrIndEssalud, ");	
			hql.append("tunid.chrIndDomiciliario as chrIndDomiciliario, ");	
			hql.append("tunid.numRucConvenio as numRucConvenio ,");	
			hql.append("tunid.chrNumHogar as chrNumHogar ,");	
			hql.append("tunid.chrNumInterior as chrNumInterior ");	
			hql.append("from TPersonalCuarta tunid ");
			hql.append("where 1=1 ");
			if (!isNullInteger(financiero.getSrlIdPersonal())) {
			    hql.append("and tunid.srlIdPersonal = :srlIdPersonal ");
			} 
			if (!isNullOrEmpty(financiero.getNumRuc())) {
				hql.append("and trim(tunid.numRuc) = :NumRuc ");
			}
			Query query = super.getSession().createQuery(hql.toString());
			
			if (!isNullInteger(financiero.getSrlIdPersonal())) {
				query.setParameter("srlIdPersonal", financiero.getSrlIdPersonal());
			}
			if (!isNullOrEmpty(financiero.getNumRuc())) {
			query.setParameter("NumRuc", financiero.getNumRuc());
			}
			return query.setResultTransformer(Transformers.aliasToBean(PersonaCuartaBean.class)).list();	
			
		} catch (Exception e) {
			throw new Exception(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(), 
								Constantes.NIVEL_APP_DAO, 
								this.getClass().getName(), e.getMessage()));
		}
	}

	/* (non-Javadoc)
	 * @see pe.com.mig.dao.IMaestroDao#listarCuentaContable(pe.com.mig.model.bean.CuentaContableBean)
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<CuentaContableBean> listarCuentaContable(CuentaContableBean cuenta) throws Exception {
		try {
			StringBuilder hql = new StringBuilder();			
			hql.append("select tcc.srlIdCuenta as cod_cuenta, ");			
			hql.append("esp.srl_id_esp as cod_especifica, trim(esp.var_nom_especifica) as des_especifica, ");
			hql.append("trim(esp.chr_cod_especifica) as vcod_especifica, ");			
			hql.append("trim(tcc.chrCodCuenta) as vcod_cuenta, trim(tcc.chrNomCuenta) as nom_cuenta, ");
			hql.append("tcc.chrFlgActivo as fla_activo,  tcc.chrCodUsuaCreacion as mnt_usu_creacion, ");			
			hql.append("to_char(tcc.dteFecCreacion, 'DD/MM/YYYY') as mnt_fec_creacion, ");
			hql.append("tcc.chrCodUsuaModifica as mnt_usu_modificacion, ");
			hql.append("to_char(tcc.dteFecModifica, 'DD/MM/YYYY') as mnt_fec_modificacion ");
			hql.append("from TCuentaContable tcc ");
			hql.append("inner join tcc.TEspecifica esp ");
			hql.append("where 1=1 ");
			if (!isNullInteger(cuenta.getCod_cuenta())) {
				hql.append("and tcc.srlIdCuenta = :cod_cuenta ");
			}
			if (!isNullLong(cuenta.getCod_especifica())) {
				hql.append("and esp.srl_id_esp = :cod_especifica ");
			}
			if (!isNullOrEmpty(cuenta.getFla_activo())) {
				hql.append("and tcc.chrFlgActivo = :fla_activo ");
			}			
			if (!isNullOrEmpty(cuenta.getVcod_especifica())) {
				hql.append("and esp.chr_cod_especifica = :vcod_especifica ");
			}
			if (!isNullOrEmpty(cuenta.getDes_especifica())) {
				hql.append("and ttc.var_nom_especifica like :des_especifica ");
			} 
			if (!isNullOrEmpty(cuenta.getNom_cuenta())) {
				hql.append("and ttc.chrNomCuenta like :nom_cuenta ");
			}
			hql.append("order by tcc.chrCodCuenta");	
			Query query = super.getSession().createQuery(hql.toString());
			if (!isNullInteger(cuenta.getCod_cuenta())) {
				query.setParameter("cod_cuenta", cuenta.getCod_cuenta());
			}
			if (!isNullLong(cuenta.getCod_especifica())) {
				query.setParameter("cod_especifica", cuenta.getCod_especifica());
			}
			if (!isNullOrEmpty(cuenta.getVcod_especifica())) {
				query.setParameter("vcod_especifica", cuenta.getVcod_especifica());
			}
			if (!isNullOrEmpty(cuenta.getDes_especifica())) {
				query.setParameter("des_especifica", cuenta.getDes_especifica());
			}
			if (!isNullOrEmpty(cuenta.getNom_cuenta())) {
				query.setParameter("nom_cuenta", cuenta.getNom_cuenta());
			}
			if (!isNullOrEmpty(cuenta.getFla_activo())) {
				query.setParameter("fla_activo", cuenta.getFla_activo());
			}
			return query.setResultTransformer(Transformers.aliasToBean(CuentaContableBean.class)).list();		
		} catch (Exception e) {
			throw new Exception(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(), 
								Constantes.NIVEL_APP_DAO, 
								this.getClass().getName(), e.getMessage()));
		}
	}
	/* (non-Javadoc)
	 * @see pe.com.mig.dao.IMaestroDao#listarTipoComprobante(pe.com.mig.model.bean.TipoComprobanteBean)
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<TipoComprobanteCuartaBean> listarTipoComprobanteCuarta(TipoComprobanteCuartaBean comprobante) throws Exception {
		try {
			StringBuilder hql = new StringBuilder();	
		
			hql.append("select ttc.srlIdComprobante as cod_comprobante, ttc.chrCodComprobante as vcod_comprobante, ");			
			hql.append("ttc.chrNomComprobante as nom_comprobante,  ");			
			hql.append("ttc.chrFlgActivo as fla_activo,  ttc.chrCodUsuaCreacion as mnt_usu_creacion, ");			
			hql.append("to_char(ttc.dteFecCreacion, 'DD/MM/YYYY') as mnt_fec_creacion, ");
			hql.append("ttc.chrCodUsuaModifica as mnt_usu_modificacion, ");
			hql.append("to_char(ttc.dteFecModifica, 'DD/MM/YYYY') as mnt_fec_modificacion ");			
			hql.append("from TComprobanteCuarta ttc ");
			hql.append("where 1=1 ");
			if (!isNullInteger(comprobante.getCod_comprobante())) {
				hql.append("and ttc.srlIdComprobante = :cod_comprobante ");
			} 
			if (!isNullOrEmpty(comprobante.getVcod_comprobante())) {
				hql.append("and ttc.chrCodComprobante = :vcod_comprobante ");
			} 
		 
			if (!isNullOrEmpty(comprobante.getFla_activo())) {
				hql.append("and ttc.chrFlgActivo = :fla_activo ");
			}
			hql.append("order by ttc.chrNomComprobante");
			Query query = super.getSession().createQuery(hql.toString());
			if (!isNullInteger(comprobante.getCod_comprobante())) {
				query.setParameter("cod_comprobante", comprobante.getCod_comprobante());
			} 
			if (!isNullOrEmpty(comprobante.getVcod_comprobante())) {
				query.setParameter("vcod_comprobante", comprobante.getVcod_comprobante());
			} 
		 		
			if (!isNullOrEmpty(comprobante.getFla_activo())) {
				query.setParameter("fla_activo", comprobante.getFla_activo());
			}				
			return query.setResultTransformer(Transformers.aliasToBean(TipoComprobanteBean.class)).list();		
		} catch (Exception e) {
			throw new Exception(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(), 
								Constantes.NIVEL_APP_DAO, 
								this.getClass().getName(), e.getMessage()));
		}
	}
	
	/* (non-Javadoc)
	 * @see pe.com.mig.dao.IMaestroDao#listarTipoComprobante(pe.com.mig.model.bean.TipoComprobanteBean)
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<NacionalidadBean> listarNacionalidad(NacionalidadBean comprobante) throws Exception {
		try {
			StringBuilder hql = new StringBuilder();	
		
			hql.append("select ttc.srlIdNacion as srlIdNacion, ttc.chrCodNacion as chrCodNacion, ");			
			hql.append("ttc.chrNomNacion as chrNomNacion,  ");			
			hql.append("ttc.chrFlgActivo as chrFlgActivo,  ttc.chrCodUsuaCreacion as chrCodUsuaCreacion, ");			
			hql.append("to_char(ttc.dteFecCreacion, 'DD/MM/YYYY') as dteFecCreacion, ");
			hql.append("ttc.chrCodUsuaModifica as chrCodUsuaModifica, ");
			hql.append("to_char(ttc.dteFecModifica, 'DD/MM/YYYY') as dteFecModifica ");			
			hql.append("from TNacionalidad ttc ");
			hql.append("where 1=1 ");
			if (!isNullInteger(comprobante.getSrlIdNacion())) {
				hql.append("and ttc.srlIdNacion = :srlIdNacion ");
			} 
			if (!isNullOrEmpty(comprobante.getChrCodNacion())) {
				hql.append("and ttc.chrCodNacion = :chrCodNacion ");
			} 
		 
			if (!isNullOrEmpty(comprobante.getChrFlgActivo())) {
				hql.append("and ttc.chrFlgActivo = :chrFlgActivo ");
			}
			hql.append("order by ttc.chrNomNacion");
			Query query = super.getSession().createQuery(hql.toString());
			if (!isNullInteger(comprobante.getSrlIdNacion())) {
				query.setParameter("srlIdNacion", comprobante.getSrlIdNacion());
			} 
			if (!isNullOrEmpty(comprobante.getChrCodNacion())) {
				query.setParameter("chrCodNacion", comprobante.getChrCodNacion());
			} 
		 		
			if (!isNullOrEmpty(comprobante.getChrFlgActivo())) {
				query.setParameter("chrFlgActivo", comprobante.getChrFlgActivo());
			}				
			return query.setResultTransformer(Transformers.aliasToBean(NacionalidadBean.class)).list();		
		} catch (Exception e) {
			throw new Exception(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(), 
								Constantes.NIVEL_APP_DAO, 
								this.getClass().getName(), e.getMessage()));
		}
	}
	
	/* (non-Javadoc)
	 * @see pe.com.mig.dao.IMaestroDao#listarTipoComprobante(pe.com.mig.model.bean.TipoComprobanteBean)
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<ViaBean> listarVia(ViaBean comprobante) throws Exception {
		try {
			StringBuilder hql = new StringBuilder();	
		 
			hql.append("select ttc.srlIdVia as srlIdVia, ttc.chrCodVia as chrCodVia, ");			
			hql.append("ttc.chrNomVia as chrNomVia,  ");			
			hql.append("ttc.chrFlgActivo as chrFlgActivo,  ttc.chrCodUsuaCreacion as chrCodUsuaCreacion, ");			
			hql.append("to_char(ttc.dteFecCreacion, 'DD/MM/YYYY') as dteFecCreacion, ");
			hql.append("ttc.chrCodUsuaModifica as chrCodUsuaModifica, ");
			hql.append("to_char(ttc.dteFecModifica, 'DD/MM/YYYY') as dteFecModifica ");			
			hql.append("from TVia ttc ");
			hql.append("where 1=1 ");
			if (!isNullInteger(comprobante.getSrlIdVia())) {
				hql.append("and ttc.srlIdVia = :srlIdVia ");
			} 
			if (!isNullOrEmpty(comprobante.getChrCodVia())) {
				hql.append("and ttc.chrCodVia = :chrCodVia ");
			} 
		 
			if (!isNullOrEmpty(comprobante.getChrFlgActivo())) {
				hql.append("and ttc.chrFlgActivo = :chrFlgActivo ");
			}
			hql.append("order by ttc.chrNomVia");
			Query query = super.getSession().createQuery(hql.toString());
			
			if (!isNullInteger(comprobante.getSrlIdVia())) {
				query.setParameter("srlIdVia", comprobante.getSrlIdVia());
			} 
			if (!isNullOrEmpty(comprobante.getChrCodVia())) {
				query.setParameter("chrCodVia", comprobante.getChrCodVia());
			} 
		 		
			if (!isNullOrEmpty(comprobante.getChrFlgActivo())) {
				query.setParameter("chrFlgActivo", comprobante.getChrFlgActivo());
			}				
			return query.setResultTransformer(Transformers.aliasToBean(ViaBean.class)).list();		
		} catch (Exception e) {
			throw new Exception(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(), 
								Constantes.NIVEL_APP_DAO, 
								this.getClass().getName(), e.getMessage()));
		}
	}
	/* (non-Javadoc)
	 * @see pe.com.mig.dao.IMaestroDao#listarTipoComprobante(pe.com.mig.model.bean.TipoComprobanteBean)
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<ZonaBean> listarZona(ZonaBean comprobante) throws Exception {
		try {
			StringBuilder hql = new StringBuilder();	
			hql.append("select ttc.srlIdZona as srlIdZona, ttc.chrCodZona as chrCodZona, ");			
			hql.append("ttc.chrNomZona as chrNomZona,  ");			
			hql.append("ttc.chrFlgActivo as chrFlgActivo,  ttc.chrCodUsuaCreacion as chrCodUsuaCreacion, ");			
			hql.append("to_char(ttc.dteFecCreacion, 'DD/MM/YYYY') as dteFecCreacion, ");
			hql.append("ttc.chrCodUsuaModifica as chrCodUsuaModifica, ");
			hql.append("to_char(ttc.dteFecModifica, 'DD/MM/YYYY') as dteFecModifica ");			
			hql.append("from TZona ttc ");
			hql.append("where 1=1 ");
			if (!isNullInteger(comprobante.getSrlIdZona())) {
				hql.append("and ttc.srlIdZona = :srlIdZona ");
			} 
			if (!isNullOrEmpty(comprobante.getChrCodZona())) {
				hql.append("and ttc.chrCodZona = :chrCodZona ");
			} 
		 
			if (!isNullOrEmpty(comprobante.getChrFlgActivo())) {
				hql.append("and ttc.chrFlgActivo = :chrFlgActivo ");
			}
			hql.append("order by ttc.chrNomZona");
			Query query = super.getSession().createQuery(hql.toString());
			if (!isNullInteger(comprobante.getSrlIdZona())) {
				query.setParameter("srlIdZona", comprobante.getSrlIdZona());
			} 
			if (!isNullOrEmpty(comprobante.getChrCodZona())) {
				query.setParameter("chrCodZona", comprobante.getChrCodZona());
			} 
		 		
			if (!isNullOrEmpty(comprobante.getChrFlgActivo())) {
				query.setParameter("chrFlgActivo", comprobante.getChrFlgActivo());
			}				
			return query.setResultTransformer(Transformers.aliasToBean(ZonaBean.class)).list();		
		} catch (Exception e) {
			throw new Exception(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(), 
								Constantes.NIVEL_APP_DAO, 
								this.getClass().getName(), e.getMessage()));
		}
	}
	/* (non-Javadoc)
	 * @see pe.com.mig.dao.IMaestroDao#listarTipoComprobante(pe.com.mig.model.bean.TipoComprobanteBean)
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<DocumentoCuartaBean> listarDocumentoCuarta(DocumentoCuartaBean comprobante) throws Exception {

		try {
			StringBuilder hql = new StringBuilder();	
			hql.append("select ttc.srlIdDocumento as srlIdDocumento, ttc.chrCodDocumento as chrCodDocumento, ");			
			hql.append("ttc.chrNomDocumento as chrNomDocumento,  ");			
			hql.append("ttc.chrFlgActivo as chrFlgActivo,  ttc.chrCodUsuaCreacion as chrCodUsuaCreacion, ");			
			hql.append("to_char(ttc.dteFecCreacion, 'DD/MM/YYYY') as dteFecCreacion, ");
			hql.append("ttc.chrCodUsuaModifica as chrCodUsuaModifica, ");
			hql.append("to_char(ttc.dteFecModifica, 'DD/MM/YYYY') as dteFecModifica ");			
			hql.append("from TDocumentoCuarta ttc ");
			hql.append("where 1=1 ");
			if (!isNullInteger(comprobante.getSrlIdDocumento())) {
				hql.append("and ttc.srlIdDocumento = :srlIdDocumento ");
			} 
			if (!isNullOrEmpty(comprobante.getChrCodDocumento())) {
				hql.append("and ttc.chrCodDocumento = :chrCodDocumento ");
			} 
			if (!isNullOrEmpty(comprobante.getChrFlgActivo())) {
				hql.append("and ttc.chrFlgActivo = :chrFlgActivo ");
			}
			hql.append("order by ttc.chrNomDocumento");
			Query query = super.getSession().createQuery(hql.toString());
			if (!isNullInteger(comprobante.getSrlIdDocumento())) {
				query.setParameter("srlIdDocumento", comprobante.getSrlIdDocumento());
			} 
			if (!isNullOrEmpty(comprobante.getChrCodDocumento())) {
				query.setParameter("chrCodDocumento", comprobante.getChrCodDocumento());
			} 
		 		
			if (!isNullOrEmpty(comprobante.getChrFlgActivo())) {
				query.setParameter("chrFlgActivo", comprobante.getChrFlgActivo());
			}				
			return query.setResultTransformer(Transformers.aliasToBean(DocumentoCuartaBean.class)).list();		
		} catch (Exception e) {
			throw new Exception(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(), 
								Constantes.NIVEL_APP_DAO, 
								this.getClass().getName(), e.getMessage()));
		}
	}
	/* (non-Javadoc)
	 * @see pe.com.mig.dao.IMaestroDao#listarTipoComprobante(pe.com.mig.model.bean.TipoComprobanteBean)
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<ConvenioCuartaBean> listarConvenio(ConvenioCuartaBean comprobante) throws Exception {
		try {
			StringBuilder hql = new StringBuilder();	
			hql.append("select ttc.srlIdConvenio as srlIdConvenio, ttc.chrCodConvenio as chrCodConvenio, ");			
			hql.append("ttc.chrNomConvenio as chrNomConvenio,  ");			
			hql.append("ttc.chrFlgActivo as chrFlgActivo,  ttc.chrCodUsuaCreacion as chrCodUsuaCreacion, ");			
			hql.append("to_char(ttc.dteFecCreacion, 'DD/MM/YYYY') as dteFecCreacion, ");
			hql.append("ttc.chrCodUsuaModifica as chrCodUsuaModifica, ");
			hql.append("to_char(ttc.dteFecModifica, 'DD/MM/YYYY') as dteFecModifica ");			
			hql.append("from TConvenioCuarta ttc ");
			hql.append("where 1=1 ");
			if (!isNullInteger(comprobante.getSrlIdConvenio())) {
				hql.append("and ttc.srlIdConvenio = :srlIdConvenio ");
			} 
			if (!isNullOrEmpty(comprobante.getChrNomConvenio())) {
				hql.append("and ttc.chrNomConvenio = :chrNomConvenio ");
			} 
			if (!isNullOrEmpty(comprobante.getChrFlgActivo())) {
				hql.append("and ttc.chrFlgActivo = :chrFlgActivo ");
			}
			hql.append("order by ttc.chrNomConvenio");
			Query query = super.getSession().createQuery(hql.toString());
			if (!isNullInteger(comprobante.getSrlIdConvenio())) {
				query.setParameter("srlIdConvenio", comprobante.getSrlIdConvenio());
			} 
			if (!isNullOrEmpty(comprobante.getChrNomConvenio())) {
				query.setParameter("chrNomConvenio", comprobante.getChrNomConvenio());
			} 
		 		
			if (!isNullOrEmpty(comprobante.getChrFlgActivo())) {
				query.setParameter("chrFlgActivo", comprobante.getChrFlgActivo());
			}				
			return query.setResultTransformer(Transformers.aliasToBean(ConvenioCuartaBean.class)).list();		
		} catch (Exception e) {
			throw new Exception(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(), 
								Constantes.NIVEL_APP_DAO, 
								this.getClass().getName(), e.getMessage()));
		}
	}
	/* (non-Javadoc)
	 * @see pe.com.mig.service.IMaestroService#grabarMedioPago(pe.com.mig.model.bean.TarifaBoletoBean)
	 */
	@Transactional
	@Override	
	public Integer grabarPersonaCuartaCategoria(PersonaCuartaBean financiero) throws Exception {
		Integer codigo = financiero.getSrlIdPersonal();
		try {		
			TPersonalCuarta tcierremes = new TPersonalCuarta();
			tcierremes.setTDocumentoCuarta(new TDocumentoCuarta(financiero.getTDocumentoCuarta())); 
			tcierremes.setTNacionalidad(new TNacionalidad(financiero.getTNacionalidad())); 
			tcierremes.setTConvenioCuarta(new TConvenioCuarta(financiero.getTConvenioCuarta())); 
			tcierremes.setNumRuc(financiero.getNumRuc());
			tcierremes.setChrNumDocumento(financiero.getChrNumDocumento());
			tcierremes.setChrApePaterno(financiero.getChrApePaterno());
			tcierremes.setChrApeMaterno(financiero.getChrApeMaterno());
			tcierremes.setChrNombres(financiero.getChrNombres());
			tcierremes.setChrTipSexo(financiero.getChrTipSexo());
			tcierremes.setDteFecNacimiento(getDate(financiero.getDteFecNacimiento()));
			tcierremes.setChrNumTelefono(financiero.getChrNumTelefono());
			tcierremes.setChrCorreo(financiero.getChrCorreo());
			tcierremes.setChrIndEssalud(financiero.getChrIndEssalud());
			tcierremes.setChrIndDomiciliario(financiero.getChrIndDomiciliario());
			tcierremes.setNumRucConvenio(financiero.getNumRucConvenio());
			if (financiero.getTVia() > 0) {
				tcierremes.setTVia(new TVia(financiero.getTVia())); 
			}
			tcierremes.setChrNomVia(financiero.getChrNomVia());
			tcierremes.setChrNumHogar(financiero.getChrNumHogar());
			if (financiero.getTZona() > 0) {
				tcierremes.setTZona(new TZona(financiero.getTZona()));
			}
			tcierremes.setChrNomZona(financiero.getChrNomZona());
			tcierremes.setChrReferencia(financiero.getChrReferencia());
			if (!isNullInteger(financiero.getIdubigeo())) {
				tcierremes.setIdubigeo(financiero.getIdubigeo());
			}	
			if (!isNullInteger(codigo)) {
				tcierremes.setChrCodUsuaModifica(financiero.getVnomusuario());
				tcierremes.setDteFecModifica(Calendar.getInstance().getTime());
				update(tcierremes);			
			} else {				
				tcierremes.setChrCodUsuaCreacion(financiero.getVnomusuario());
				tcierremes.setDteFecCreacion(Calendar.getInstance().getTime());
				codigo = getByIdSave(tcierremes);
			}
	 
		} catch (Exception e) {
			 
 			e.printStackTrace();
		}
		return codigo;
	}
	/* (non-Javadoc)
	 * @see pe.com.mig.dao.IMaestroDao#listarFinanciero(pe.com.mig.model.bean.EntidadFinancieraBean)
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<CartaFianzaBean> listarCartaFianza(CartaFianzaBean financiero) throws Exception {
		try {
			StringBuilder hql = new StringBuilder();			
			hql.append("select tef.srlIdFianza as srlIdFianza, ");					
			hql.append("finan.srlIdEntidad as TEntidadFinanciera,  ttp.srlIdProveedor as TTipoProveedor, ");	
			hql.append("tef.chrCodDocumento as chrCodDocumento,");
			hql.append("case tef.chrCodDocumento ");			
			hql.append("when '1' then 'OFICIO' ");
			hql.append("when '2' then 'CARTA' ");
			hql.append("when '3' then 'MEMO' ");
			hql.append("end as concepto, ");
			hql.append("finan.chrNomEntidad as nom_entidad,");
			hql.append("tef.chrNumCarta as chrNumCarta, ");		
			hql.append("tef.chrNumFianza as chrNumFianza, ");		
			hql.append("to_char(tef.dteFecRecepcion, 'DD/MM/YYYY') as dteFecRecepcion, ");
			hql.append("tef.chrConcepto as chrConcepto, ");
			hql.append("tef.chrSigOficina as chrSigOficina, ");
			hql.append("case ttp.chrTipProveedor ");			
			hql.append("when '1' then concat(ttp.chrNombres, ' ', ttp.chrApePaterno, ' ', ttp.chrApeMaterno) ");
			hql.append("when '2' then ttp.chrRazSocial ");
			hql.append("end as Razonsocial, ");
			hql.append("to_char(tef.dteFecInicio, 'DD/MM/YYYY') as dteFecInicio, ");
			hql.append("to_char(tef.dteFecFinal, 'DD/MM/YYYY') as dteFecFinal, ");
			hql.append("to_char(tef.dteFecDevolucion, 'DD/MM/YYYY') as dteFecDevolucion, ");	
			hql.append("tef.intImpCarta as intImpCarta, ");	
			hql.append("ttp.numRuc as numRuc, ");
			hql.append("(tef.dteFecFinal - current_date()) as can_dia_transcurridos, ");	
			hql.append("case  ");			
			hql.append("when (tef.dteFecFinal - current_date() < 26) then '1' ");
			hql.append("else '0' ");
			hql.append("end as validacion, ");
			hql.append("tef.chrNumDocumento as chrNumDocumento, ");	
			hql.append("tef.intIdfRegistro as intIdfRegistro, ");	
			hql.append("uni.idunidad as cod_uni_operativa, ");
			hql.append("reg.idRanac as cod_reg_nac, ");
			hql.append("concat(tef.chrNumDocumento,' - ', to_char(tef.dteFecDocumento, 'DD/MM/YYYY') ) as concatenado, ");
			hql.append(" tef.chrCodUsuaCreacion as chrCodUsuaCreacion, ");		
			hql.append(" tef.chrflglegal as legalidad, ");
			hql.append("to_char(tef.dteFecCreacion, 'DD/MM/YYYY') as dteFecCreacion, ");
			hql.append("tef.chrCodUsuaModifica as chrCodUsuaModifica,");
			hql.append("to_char(tef.dteFecModifica, 'DD/MM/YYYY') as dteFecModifica, ");			
			hql.append("to_char(tef.dteFecCarta, 'DD/MM/YYYY') as dteFecCarta, ");
			hql.append("to_char(tef.dteFecDocumento, 'DD/MM/YYYY') as dteFecDocumento, ");
			hql.append("tef.chrNomEstado as chrNomEstado,");
			hql.append("case tef.chrNomEstado ");			
			hql.append("when '1' then 'DEVUELTO A ENTIDAD FINANCIERA' ");
			hql.append("when '2' then 'DEVUELTO AL PROVEEDOR' ");
			hql.append("when '3' then 'EN EJECUCION' ");
			hql.append("when '4' then 'EJECUTADO' ");
			hql.append("when '5' then 'VIGENTE' ");
			hql.append("when '6' then 'VENCIDO' ");
			hql.append("end as desChrNomEstado ");
			hql.append("from TCartaFianza tef ");
			hql.append("inner join tef.TTipoProveedor as ttp ");
			hql.append("inner join tef.TEntidadFinanciera as finan ");
			hql.append("left join tef.unidadoperativa uni ");
			hql.append("left join tef.tbtRegistroNac reg ");
			hql.append("where 1=1 ");
			hql.append("and tef.intIdfRegistro = 1 ");
			if (!isNullInteger(financiero.getSrlIdFianza())) {
				hql.append("and tef.srlIdFianza = :srlIdFianza ");
			} 
			if (!isNullOrEmpty(financiero.getChrNumCarta())) {
				hql.append("and tef.chrNumCarta = :chrNumCarta ");
			} 
			if (!isNullOrEmpty(financiero.getDteFecInicio()) && !isNullOrEmpty(financiero.getDteFecFinal()) ) {
				hql.append("and tef.dteFecCarta between :dteFecInicio  and :dteFecFinal ");
			}
			if (!isNullInteger(financiero.getTTipoProveedor())) {
				hql.append("and ttp.srlIdProveedor = :TTipoProveedor ");
			}
			if (!isNullOrEmpty(financiero.getChrTipOperacion())) {
				hql.append("and tef.chrTipOperacion = :chrTipOperacion ");
			} 
			if (!isNullInteger(financiero.getCod_uni_operativa())) {
				hql.append("and uni.idunidad = :cod_uni_operativa ");
			}
			
			if (!isNullInteger(financiero.getCod_reg_nac())) {
				hql.append("and reg.idRanac = :cod_reg_nac ");
			}
			Query query = super.getSession().createQuery(hql.toString());
			
			if (!isNullInteger(financiero.getSrlIdFianza())) {
				query.setParameter("srlIdFianza", financiero.getSrlIdFianza());
			} 
			if (!isNullOrEmpty(financiero.getChrTipOperacion())) {
				query.setParameter("chrTipOperacion", financiero.getChrTipOperacion());
			} 
			if (!isNullOrEmpty(financiero.getDteFecInicio())) {
				query.setParameter("dteFecInicio", getDate(financiero.getDteFecInicio()));
			} 
			if (!isNullOrEmpty(financiero.getDteFecFinal())) {
				query.setParameter("dteFecFinal", getDate(financiero.getDteFecFinal()));
			} 
			if (!isNullOrEmpty(financiero.getChrNumCarta())) {
				query.setParameter("chrNumCarta", financiero.getChrNumCarta());
			} 
			if (!isNullInteger(financiero.getTTipoProveedor())) {
				query.setParameter("TTipoProveedor", financiero.getTTipoProveedor());
			} 
			if (!isNullInteger(financiero.getCod_uni_operativa())) {
				query.setParameter("cod_uni_operativa", financiero.getCod_uni_operativa());
			}
			if (!isNullInteger(financiero.getCod_reg_nac())) {
				query.setParameter("cod_reg_nac", financiero.getCod_reg_nac());
			}
			
			
			return query.setResultTransformer(Transformers.aliasToBean(CartaFianzaBean.class)).list();		
		} catch (Exception e) {
			throw new Exception(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(), 
								Constantes.NIVEL_APP_DAO, 
								this.getClass().getName(), e.getMessage()));
		}
	}
	/* (non-Javadoc)
	 * @see pe.com.mig.service.IMaestroService#grabarMedioPago(pe.com.mig.model.bean.TarifaBoletoBean)
	 */
	@Transactional
	@Override	
	public Integer grabarCartaFianza(CartaFianzaBean cartaFianza) throws Exception {
		Integer codigo = cartaFianza.getSrlIdFianza();
		try {		
			TCartaFianza tcartaFianza = new TCartaFianza();
			if (!isNullInteger(codigo)) {				
				tcartaFianza = (TCartaFianza) getById(TCartaFianza.class, codigo);
			}
			
			if(cartaFianza.getIntIdfRegistro() == 2){
				tcartaFianza.setIntIdfRegistro(cartaFianza.getIntIdfRegistro());
			}else{
			tcartaFianza.setChrCodDocumento(cartaFianza.getChrCodDocumento());  
			tcartaFianza.setDteFecRecepcion(getDate(cartaFianza.getDteFecRecepcion()));
			tcartaFianza.setDteFecCarta(getDate(cartaFianza.getDteFecCarta()));
			tcartaFianza.setChrNumCarta(cartaFianza.getChrNumCarta());
			tcartaFianza.setDteFecInicio(getDate(cartaFianza.getDteFecInicio()));
			tcartaFianza.setDteFecFinal(getDate(cartaFianza.getDteFecFinal()));
			tcartaFianza.setDteFecDevolucion(getDate(cartaFianza.getDteFecDevolucion()));
			tcartaFianza.setChrSigOficina(cartaFianza.getChrSigOficina());
			tcartaFianza.setChrConcepto(cartaFianza.getChrConcepto());
			tcartaFianza.setTTipoProveedor(new TTipoProveedor (cartaFianza.getTTipoProveedor()));
			tcartaFianza.setTEntidadFinanciera(new TEntidadFinanciera(cartaFianza.getTEntidadFinanciera()));
			tcartaFianza.setIntImpCarta(cartaFianza.getIntImpCarta());
			tcartaFianza.setIntIdfRegistro(cartaFianza.getIntIdfRegistro());
			tcartaFianza.setDteFecDocumento(getDate(cartaFianza.getDteFecDocumento()));
			tcartaFianza.setChrNumDocumento(cartaFianza.getChrNumDocumento());
			tcartaFianza.setChrTipOperacion(cartaFianza.getChrTipOperacion());
			tcartaFianza.setChrNumFianza(cartaFianza.getChrNumFianza()); 
			tcartaFianza.setChrflglegal(cartaFianza.getLegalidad());
			tcartaFianza.setChrNomEstado(cartaFianza.getChrNomEstado());
				if (!isNullInteger(cartaFianza.getCod_uni_operativa())) {	
				tcartaFianza.setUnidadoperativa(new Unidadoperativa(cartaFianza.getCod_uni_operativa())); 
				}
				if (!isNullInteger(cartaFianza.getCod_reg_nac())) {	
				tcartaFianza.setTbtRegistroNac(new TbtRegistroNac(cartaFianza.getCod_reg_nac())); 
				}
			}
		 	
			if (!isNullInteger(codigo)) {
				tcartaFianza.setChrCodUsuaModifica(cartaFianza.getVnomusuario());
				tcartaFianza.setDteFecModifica(Calendar.getInstance().getTime());
				update(tcartaFianza);			
			} else {
				tcartaFianza.setChrCodUsuaCreacion(cartaFianza.getVnomusuario());
				tcartaFianza.setDteFecCreacion(Calendar.getInstance().getTime());
				codigo = getByIdSave(tcartaFianza);
			}
		} catch (Exception e) {
			 throw new Exception(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(), 
								Constantes.NIVEL_APP_DAO, 
								this.getClass().getName(), e.getMessage())); 
//			e.printStackTrace();
		}
		return codigo;
	}
	/* (non-Javadoc)
	 * @see pe.com.mig.dao.IMaestroDao#listarTipoComprobante(pe.com.mig.model.bean.TipoComprobanteBean)
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<UbigeoBean> listarUbigeo(UbigeoBean comprobante) throws Exception {
		try {
			StringBuilder hql = new StringBuilder();	
			hql.append("select ttc.idubigeo as idubigeo, ttc.coddpto as coddpto, ");			
			hql.append("ttc.coddist as coddist, ttc.codprov as codprov, ");		
			hql.append("ttc.nombre as nombre ");	
			hql.append("from Ubigeo ttc ");
			hql.append("where 1=1 ");
			if(isNull(comprobante.getCodprov()) &&  isNull(comprobante.getCoddist()) && isNullOrEmpty(comprobante.getCoddpto() )){
				hql.append("and ttc.codprov = '00' and ttc.coddist = '00'");
			}
			if (!isNullInteger(comprobante.getIdubigeo())) {
				hql.append("and ttc.idubigeo = :idubigeo ");
			} 
			if (!isNullOrEmpty(comprobante.getCoddpto()) &&  isNull(comprobante.getCoddist()) && isNull(comprobante.getCodprov())) {
				hql.append("and ttc.coddpto = :coddpto and ttc.coddist = '00' and ttc.codprov <> '00' ");
			} 
			if (!isNullOrEmpty(comprobante.getCodprov()) &&  !isNullOrEmpty(comprobante.getCoddpto()) && isNull(comprobante.getCoddist())) {
				hql.append("and ttc.codprov = :codprov and ttc.coddpto = :coddpto and ttc.coddist <> '00' ");
			} 
			if (!isNullOrEmpty(comprobante.getCodprov())) {
				hql.append("and ttc.codprov = :codprov ");
			} 
			if (!isNullOrEmpty(comprobante.getCoddist())) {
				hql.append("and ttc.coddist = :coddist ");
			} 
			hql.append("order by ttc.nombre");
			Query query = super.getSession().createQuery(hql.toString());
			
			if (!isNullInteger(comprobante.getIdubigeo())) {
				query.setParameter("idubigeo", comprobante.getIdubigeo());
			} 
			if (!isNullOrEmpty(comprobante.getCoddpto())) {
				query.setParameter("coddpto", comprobante.getCoddpto());
			} 
			if (!isNullOrEmpty(comprobante.getCodprov())) {
				query.setParameter("codprov", comprobante.getCodprov());
			}
			if (!isNullOrEmpty(comprobante.getCoddist())) {
				query.setParameter("coddist", comprobante.getCoddist());
			} 
			
		  		
			return query.setResultTransformer(Transformers.aliasToBean(UbigeoBean.class)).list();		
		} catch (Exception e) {
			throw new Exception(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(), 
								Constantes.NIVEL_APP_DAO, 
								this.getClass().getName(), e.getMessage()));
		}
	}
	  
	/* (non-Javadoc)
	 * @see pe.com.mig.service.IMaestroService#grabarEntidadFinanciera(pe.com.mig.model.bean.EntidadFinancieraBean)
	 */
	@Transactional
	@Override	
	public Integer grabarCuentaContable(CuentaContableBean financiero) throws Exception {
		Integer codigo = financiero.getCod_cuenta();
		try {		
			TCuentaContable tentidadFinanciera = new TCuentaContable();
			if (!isNullInteger(codigo)) {				
				tentidadFinanciera = (TCuentaContable) getById(TCuentaContable.class, codigo);
			}
			tentidadFinanciera.setTEspecifica(new TEspecifica(financiero.getCod_especifica()));
			tentidadFinanciera.setChrCodCuenta(financiero.getVcod_cuenta());
			tentidadFinanciera.setChrNomCuenta(financiero.getNom_cuenta());
			tentidadFinanciera.setChrFlgActivo(financiero.getFla_activo());
			if (!isNullInteger(codigo)) {
				tentidadFinanciera.setChrCodUsuaModifica(financiero.getVnomusuario());
				tentidadFinanciera.setDteFecModifica(Calendar.getInstance().getTime());
				update(tentidadFinanciera);			
			} else {				
				tentidadFinanciera.setChrCodUsuaCreacion(financiero.getVnomusuario());
				tentidadFinanciera.setDteFecCreacion(Calendar.getInstance().getTime());
				codigo = getByIdSave(tentidadFinanciera);
			}
		} catch (Exception e) {
			throw new Exception(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(), 
								Constantes.NIVEL_APP_DAO, 
								this.getClass().getName(), e.getMessage()));
		}
		return codigo;
	}
	
}