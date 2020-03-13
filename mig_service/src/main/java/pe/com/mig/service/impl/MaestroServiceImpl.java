package pe.com.mig.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
import pe.com.mig.service.IMaestroService;

/**
 * @className: MaestroServiceImpl.java
 * @description: 
 * @date: 16 de jun. de 2016
 * @author: SUMERIO.
 */
@Service
public class MaestroServiceImpl extends GenericServiceImpl implements IMaestroService {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private IMaestroDao iMaestroDao;
	
	/* (non-Javadoc)
	 * @see pe.com.mig.service.IMaestroService#verificarSedePrincipal(java.lang.Integer)
	 */
	@Override
	public List<UnidadOperativaBean> verificarSedePrincipal(Integer cod_usuario) throws Exception {
		return iMaestroDao.verificarSedePrincipal(cod_usuario);
	}	
	
	/* (non-Javadoc)
	 * @see pe.com.mig.service.IMaestroService#listarUnidadOperativa(pe.com.mig.model.bean.sernanp.UnidadOperativaBean)
	 */
	@Override
	public List<UnidadOperativaBean> listarUnidadOperativa(UnidadOperativaBean unidad) throws Exception {
		return iMaestroDao.listarUnidadOperativa(unidad);
	}

	/* (non-Javadoc)
	 * @see pe.com.mig.service.IMaestroService#listarTipoComprobante(pe.com.mig.model.bean.TipoComprobanteBean)
	 */
	@Override
	public List<TipoComprobanteBean> listarTipoComprobante(TipoComprobanteBean comprobante) throws Exception {
		return iMaestroDao.listarTipoComprobante(comprobante);
	}
	/* (non-Javadoc)
	 * @see pe.com.mig.service.IMaestroService#grabarTipoComprobante(pe.com.mig.model.bean.TipoComprobanteBean)
	 */
	@Override
	public Integer grabarTipoComprobante(TipoComprobanteBean comprobante) throws Exception {
		return iMaestroDao.grabarTipoComprobante(comprobante);
	}
	/* (non-Javadoc)
	 * @see pe.com.mig.service.IMaestroService#listarUnidadMedida(pe.com.mig.model.bean.UnidadMedidaBean)
	 */
	@Override
	public List<UnidadMedidaBean> listarUnidadMedida(UnidadMedidaBean unidadMedida) throws Exception {
		return iMaestroDao.listarUnidadMedida(unidadMedida);
	}
	/* (non-Javadoc)
	 * @see pe.com.mig.service.IMaestroService#grabarUnidadMedida(pe.com.mig.model.bean.UnidadMedidaBean)
	 */
	@Override
	public Integer grabarUnidadMedida(UnidadMedidaBean unidadMedida) throws Exception {
		return iMaestroDao.grabarUnidadMedida(unidadMedida);
	}	
	/* (non-Javadoc)
	 * @see pe.com.mig.service.IMaestroService#listarTipoDocumento(pe.com.mig.model.bean.TipoDocumentoBean)
	 */
	@Override
	public List<TipoDocumentoBean> listarTipoDocumento(TipoDocumentoBean documento) throws Exception {
		return iMaestroDao.listarTipoDocumento(documento);
	}
	/* (non-Javadoc)
	 * @see pe.com.mig.service.IMaestroService#grabarTipoDocumento(pe.com.mig.model.bean.TipoDocumentoBean)
	 */
	@Override
	public Integer grabarTipoDocumento(TipoDocumentoBean tipoDocumento) throws Exception {
		return iMaestroDao.grabarTipoDocumento(tipoDocumento);
	}
	/* (non-Javadoc)
	 * @see pe.com.mig.service.IMaestroService#listarTipoMoneda(pe.com.mig.model.bean.TipoMonedaBean)
	 */
	@Override
	public List<TipoMonedaBean> listarTipoMoneda(TipoMonedaBean moneda) throws Exception {
		return iMaestroDao.listarTipoMoneda(moneda);
	}
	/* (non-Javadoc)
	 * @see pe.com.mig.service.IMaestroService#listarOtros(pe.com.mig.model.bean.OtrosBean)
	 */
	@Override
	public List<OtrosBean> listarOtros(OtrosBean otros) throws Exception {
		return iMaestroDao.listarOtros(otros);
	}
	
	/* (non-Javadoc)
	 * @see pe.com.mig.service.IMaestroService#grabarTipoMoneda(pe.com.mig.model.bean.TipoMonedaBean)
	 */
	@Override
	public Integer grabarOtros(OtrosBean otros) throws Exception {
		return iMaestroDao.grabarOtros(otros);
	}
	
	/* (non-Javadoc)
	 * @see pe.com.mig.service.IMaestroService#listarEspecifica(pe.com.mig.model.bean.EspecificaBean)
	 */
	@Override
	public List<EspecificaBean> listarEspecifica(EspecificaBean especifica) throws Exception {
		return iMaestroDao.listarEspecifica(especifica);
	}

	/* (non-Javadoc)
	 * @see pe.com.mig.service.IMaestroService#listarFuenteFinanciamiento(pe.com.mig.model.bean.FuenteFinanciamientoBean)
	 */
	@Override
	public List<FuenteFinanciamientoBean> listarFuenteFinanciamiento(FuenteFinanciamientoBean fuente) throws Exception {
		return iMaestroDao.listarFuenteFinanciamiento(fuente);
	}

	/* (non-Javadoc)
	 * @see pe.com.mig.service.IMaestroService#listarFuenteFinanciamiento(pe.com.mig.model.bean.FuenteFinanciamientoBean)
	 */
	@Override
	public List<CuentaCorrienteBean> listarCuentaCorriente(CuentaCorrienteBean ctacte) throws Exception {
		return iMaestroDao.listarCuentaCorriente(ctacte);
	}
	/* (non-Javadoc)
	 * @see pe.com.mig.service.IMaestroService#listarProveedor(pe.com.mig.model.bean.ProveedorBean)
	 */
	@Override
	public List<ProveedorBean> listarProveedor(ProveedorBean proveedor) throws Exception {
		return iMaestroDao.listarProveedor(proveedor);
	}

	/* (non-Javadoc)
	 * @see pe.com.mig.service.IMaestroService#grabarProveedor(pe.com.mig.model.bean.ProveedorBean)
	 */
	@Override
	public Integer grabarProveedor(ProveedorBean proveedor) throws Exception {
		return iMaestroDao.grabarProveedor(proveedor);
	}

	/* (non-Javadoc)
	 * @see pe.com.mig.service.IMaestroService#grabarTipoMoneda(pe.com.mig.model.bean.TipoMonedaBean)
	 */
	@Override
	public Integer grabarTipoMoneda(TipoMonedaBean tipoMoneda) throws Exception {
		return iMaestroDao.grabarTipoMoneda(tipoMoneda);
	}
	/* (non-Javadoc)
	 * @see pe.com.mig.service.IMaestroService#listarFinanciero(pe.com.mig.model.bean.EntidadFinancieraBean)
	 */
	@Override
	public List<EntidadFinancieraBean> listarFinanciero(EntidadFinancieraBean financiero) throws Exception {
		return iMaestroDao.listarFinanciero(financiero);
	}
	/* (non-Javadoc)
	 * @see pe.com.mig.service.IMaestroService#grabarEntidadFinanciera(pe.com.mig.model.bean.EntidadFinancieraBean)
	 */
	@Override
	public Integer grabarEntidadFinanciera(EntidadFinancieraBean financiero) throws Exception {
		return iMaestroDao.grabarEntidadFinanciera(financiero);
	}
	/* (non-Javadoc)
	 * @see pe.com.mig.service.IMaestroService#listarProveedor(pe.com.mig.model.bean.ProveedorBean)
	 */
	@Override
	public List<MediosPagosBean> listarMedioPago(MediosPagosBean financiero) throws Exception {
		return iMaestroDao.listarMedioPago(financiero);
	}
	/* (non-Javadoc)
	 * @see pe.com.mig.service.IMaestroService#listarProveedor(pe.com.mig.model.bean.ProveedorBean)
	 */
	@Override
	public Integer grabarMedioPago(MediosPagosBean financiero) throws Exception {
		return iMaestroDao.grabarMedioPago(financiero);
	}
	/* (non-Javadoc)
	 * @see pe.com.mig.service.IMaestroService#listarProveedor(pe.com.mig.model.bean.ProveedorBean)
	 */
	@Override
	public List<LibroRegistroBean> listarLibroRegistro(LibroRegistroBean financiero) throws Exception {
		return iMaestroDao.listarLibroRegistro(financiero);
	}
	/* (non-Javadoc)
	 * @see pe.com.mig.service.IMaestroService#listarProveedor(pe.com.mig.model.bean.ProveedorBean)
	 */
	@Override
	public Integer grabarLibroRegistro(LibroRegistroBean financiero) throws Exception {
		return iMaestroDao.grabarLibroRegistro(financiero);
	}
	/* (non-Javadoc)
	 * @see pe.com.mig.service.IMaestroService#listarProveedor(pe.com.mig.model.bean.ProveedorBean)
	 */
	@Override
	public List<ProductoBean> listarproductos(ProductoBean financiero) throws Exception {
		return iMaestroDao.listarproductos(financiero);
	}
	/* (non-Javadoc)
	 * @see pe.com.mig.service.IMaestroService#listarProveedor(pe.com.mig.model.bean.ProveedorBean)
	 */
	@Override
	public Integer grabarproductos(ProductoBean financiero) throws Exception {
		return iMaestroDao.grabarproductos(financiero);
	}
	
	/* (non-Javadoc)
	 * @see pe.com.mig.service.IMaestroService#listarCierresMes(pe.com.mig.model.bean.ProveedorBean)
	 */
	@Override
	public List<CierreMesBean> listarCierresMes(CierreMesBean cierre) throws Exception {
		return iMaestroDao.listarCierresMes(cierre);
	}
	
	/* (non-Javadoc)
	 * @see pe.com.mig.service.IMaestroService#grabarCierre(pe.com.mig.model.bean.ProveedorBean)
	 */
	@Override
	public Integer grabarCierre(CierreMesBean cierre) throws Exception {
		return iMaestroDao.grabarCierre(cierre);
	}
	
	public List<UnidadMedidaBean> listarUnidadesMedida(UnidadMedidaBean unidad) throws Exception {
	return iMaestroDao.listarUnidadesMedida(unidad);
	}
	/* (non-Javadoc)
	 * @see pe.com.mig.service.IMaestroService#listarProveedor(pe.com.mig.model.bean.ProveedorBean)
	 */
	@Override
	public List<TarifaBoletoBean> listarboletos(TarifaBoletoBean unidad) throws Exception {
		return iMaestroDao.listarboletos(unidad);
		}
	/* (non-Javadoc)
	 * @see pe.com.mig.service.IMaestroService#listarProveedor(pe.com.mig.model.bean.ProveedorBean)
	 */
	@Override
	public Integer grabartarifaboletos(TarifaBoletoBean financiero) throws Exception {
		return iMaestroDao.grabartarifaboletos(financiero);
	}
	/* (non-Javadoc)
	 * @see pe.com.mig.service.IMaestroService#listarProveedor(pe.com.mig.model.bean.ProveedorBean)
	 */
	@Override
	public List<CuartaCategoriaBean> listarCuartaCategoria(CuartaCategoriaBean unidad) throws Exception {
		return iMaestroDao.listarCuartaCategoria(unidad);
	}
	/* (non-Javadoc)
	 * @see pe.com.mig.service.IMaestroService#listarProveedor(pe.com.mig.model.bean.ProveedorBean)
	 */
	@Override
	public Integer grabarCuartaCategoria(CuartaCategoriaBean finaciero) throws Exception {
		return iMaestroDao.grabarCuartaCategoria(finaciero);
	}
	
	
	/* (non-Javadoc)
	 * @see pe.com.mig.service.IMaestroService#listarProveedor(pe.com.mig.model.bean.ProveedorBean)
	 */
	@Override
	public List<PersonaCuartaBean> verificarRucCuarta(PersonaCuartaBean financiero) throws Exception {
		return iMaestroDao.verificarRucCuarta(financiero);
	}

	/* (non-Javadoc)
	 * @see pe.com.mig.service.IMaestroService#listarCuentaContable(pe.com.mig.model.bean.CuentaContableBean)
	 */
	@Override
	public List<CuentaContableBean> listarCuentaContable(CuentaContableBean cuenta) throws Exception {
		return iMaestroDao.listarCuentaContable(cuenta);
	}

	/* (non-Javadoc)
	 * @see pe.com.mig.service.IMaestroService#grabarCuentaContable(pe.com.mig.model.bean.CuentaContableBean)
	 */
	@Override
	public Integer grabarCuentaContable(CuentaContableBean cuenta) throws Exception {
		return iMaestroDao.grabarCuentaContable(cuenta);
	}
	/* (non-Javadoc)
	 * @see pe.com.mig.service.IMaestroService#listarTipoComprobante(pe.com.mig.model.bean.TipoComprobanteBean)
	 */
	@Override
	public List<TipoComprobanteCuartaBean> listarTipoComprobanteCuarta(TipoComprobanteCuartaBean comprobante) throws Exception {
		return iMaestroDao.listarTipoComprobanteCuarta(comprobante);
	}
	/* (non-Javadoc)
	 * @see pe.com.mig.service.IMaestroService#listarTipoComprobante(pe.com.mig.model.bean.TipoComprobanteBean)
	 */
	@Override
	public List<NacionalidadBean> listarNacionalidad(NacionalidadBean comprobante) throws Exception {
		return iMaestroDao.listarNacionalidad(comprobante);
	}
	/* (non-Javadoc)
	 * @see pe.com.mig.service.IMaestroService#listarTipoComprobante(pe.com.mig.model.bean.TipoComprobanteBean)
	 */
	@Override
	public List<ViaBean> listarVia(ViaBean comprobante) throws Exception {
		return iMaestroDao.listarVia(comprobante);
	}
	/* (non-Javadoc)
	 * @see pe.com.mig.service.IMaestroService#listarTipoComprobante(pe.com.mig.model.bean.TipoComprobanteBean)
	 */
	@Override
	public List<ZonaBean> listarZona(ZonaBean comprobante) throws Exception {
		return iMaestroDao.listarZona(comprobante);
	}
	/* (non-Javadoc)
	 * @see pe.com.mig.service.IMaestroService#listarTipoComprobante(pe.com.mig.model.bean.TipoComprobanteBean)
	 */
	@Override
	public List<DocumentoCuartaBean> listarDocumentoCuarta(DocumentoCuartaBean comprobante) throws Exception {
		return iMaestroDao.listarDocumentoCuarta(comprobante);
	}
	/* (non-Javadoc)
	 * @see pe.com.mig.service.IMaestroService#listarTipoComprobante(pe.com.mig.model.bean.TipoComprobanteBean)
	 */
	@Override
	public List<ConvenioCuartaBean> listarConvenio(ConvenioCuartaBean comprobante) throws Exception {
		return iMaestroDao.listarConvenio(comprobante);
	}
	/* (non-Javadoc)
	 * @see pe.com.mig.service.IMaestroService#grabarCuentaContable(pe.com.mig.model.bean.CuentaContableBean)
	 */
	@Override
	public Integer grabarPersonaCuartaCategoria(PersonaCuartaBean cuarta) throws Exception {
		return iMaestroDao.grabarPersonaCuartaCategoria(cuarta);
	}
	/* (non-Javadoc)
	 * @see pe.com.mig.service.IMaestroService#listarTipoComprobante(pe.com.mig.model.bean.TipoComprobanteBean)
	 */
	@Override
	public List<CartaFianzaBean> listarCartaFianza(CartaFianzaBean comprobante) throws Exception {
		return iMaestroDao.listarCartaFianza(comprobante);
	}
	/* (non-Javadoc)
	 * @see pe.com.mig.service.IMaestroService#grabarCuentaContable(pe.com.mig.model.bean.CuentaContableBean)
	 */
	@Override
	public Integer grabarCartaFianza(CartaFianzaBean comprobante) throws Exception {
		return iMaestroDao.grabarCartaFianza(comprobante);
	}
	/* (non-Javadoc)
	 * @see pe.com.mig.service.IMaestroService#listarTipoComprobante(pe.com.mig.model.bean.TipoComprobanteBean)
	 */
	@Override
	public List<UbigeoBean> listarUbigeo(UbigeoBean comprobante) throws Exception {
		return iMaestroDao.listarUbigeo(comprobante);
	}
	/* (non-Javadoc)
	 * @see pe.com.mig.service.IMaestroService#listarTipoComprobante(pe.com.mig.model.bean.TipoComprobanteBean)
	 */
	@Override
	public List<SucursalBean> listarSucursal(SucursalBean sucursal) throws Exception {
		return iMaestroDao.listarSucursal(sucursal);
	}	
	/* (non-Javadoc)
	 * @see pe.com.mig.service.IMaestroService#listarTipoComprobante(pe.com.mig.model.bean.TipoComprobanteBean)
	 */
	@Override
	public List<SeriesBean> listarSerieCp(ComprasIngresosBean cod_serie) throws Exception {
		return iMaestroDao.listarSerieCp(cod_serie);
	}	
	/* (non-Javadoc)
	 * @see pe.com.mig.service.IMaestroService#listarTipoComprobante(pe.com.mig.model.bean.TipoComprobanteBean)
	 */
	@Override
	public List<SeriesBean> listarSerieNum(SeriesBean series) throws Exception {
		return iMaestroDao.listarSerieNum(series);
	}	
	/* (non-Javadoc)
	 * @see pe.com.mig.service.IMaestroService#listarTipoComprobante(pe.com.mig.model.bean.TipoComprobanteBean)
	 */
	@Override
	public List<SeriesBean> listarSerie(SeriesBean serie) throws Exception {
		return iMaestroDao.listarSerie(serie);
	}	
	@Override
	public Integer grabarseries(SeriesBean serie) throws Exception {
		return iMaestroDao.grabarseries(serie);
	}
	@Override
	public List<PersonaCuartaBean> listarPersonaCuarta(PersonaCuartaBean persona) throws Exception {
		return iMaestroDao.listarPersonaCuarta(persona);
	}
	@Override
	public Integer grabarpersona(PersonaCuartaBean persona) throws Exception {
		return iMaestroDao.grabarpersona(persona);
	}
	@Override
	public List<DireccionFacturaBean> listarDirecFact(DireccionFacturaBean factura) throws Exception {
		return iMaestroDao.listarDirecFact(factura);
	}	
}
