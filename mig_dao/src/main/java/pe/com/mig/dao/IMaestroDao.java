package pe.com.mig.dao;

import java.util.List;

import pe.com.mig.model.bean.CartaFianzaBean;
import pe.com.mig.model.bean.CierreMesBean;
import pe.com.mig.model.bean.ComprasIngresosBean;
import pe.com.mig.model.bean.ConvenioCuartaBean;
import pe.com.mig.model.bean.CuartaCategoriaBean;
import pe.com.mig.model.bean.CuentaContableBean;
import pe.com.mig.model.bean.DocumentoCuartaBean;
import pe.com.mig.model.bean.EntidadFinancieraBean;
import pe.com.mig.model.bean.CuentaCorrienteBean;
import pe.com.mig.model.bean.DireccionFacturaBean;
import pe.com.mig.model.bean.FuenteFinanciamientoBean;
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

/**
 * @className: IMaestroDao.java
 * @description: 
 * @date: 16 de jun. de 2016
 * @author: SUMERIO.
 */
public interface IMaestroDao {
	
	/**
	 * @param cod_usuario
	 * @return
	 * @throws Exception 
	 */
	public abstract List<UnidadOperativaBean> verificarSedePrincipal(Integer cod_usuario) throws Exception;
	
	/**
	 * @param detalle
	 * @return
	 * @throws Exception 
	 */
	public abstract List<UnidadOperativaBean> listarUnidadOperativa(UnidadOperativaBean unidad) throws Exception;

	/**
	 * @param detalle
	 * @return
	 * @throws Exception 
	 */
	public abstract List<SucursalBean> listarSucursal(SucursalBean sucursal) throws Exception;
	/**
	 * @param detalle
	 * @return
	 * @throws Exception 
	 */
	public abstract List<SeriesBean> listarSerieCp(ComprasIngresosBean cod_serie) throws Exception;
	/**
	 * @param detalle
	 * @return
	 * @throws Exception 
	 */
	public abstract List<SeriesBean> listarSerieNum(SeriesBean series) throws Exception;	
	/**
	 * @param detalle
	 * @return
	 * @throws Exception 
	 */
	public abstract List<SeriesBean> listarSerie(SeriesBean serie) throws Exception;
	/**
	 * @param financiero
	 * @return
	 * @throws Exception
	 */
	public abstract Integer grabarseries(SeriesBean serie) throws Exception;
	/**
	 * @param detalle
	 * @return
	 * @throws Exception 
	 */
	public abstract List<PersonaCuartaBean> listarPersonaCuarta(PersonaCuartaBean persona) throws Exception;
	/**
	 * @param financiero
	 * @return
	 * @throws Exception
	 */
	public abstract Integer grabarpersona(PersonaCuartaBean persona) throws Exception;
	/**
	 * @param comprobante
	 * @return
	 * @throws Exception
	 */
	public abstract List<TipoComprobanteBean> listarTipoComprobante(TipoComprobanteBean comprobante) throws Exception;
	
	/**
	 * @param comprobante
	 * @return
	 * @throws Exception
	 */
	public abstract Integer grabarTipoComprobante(TipoComprobanteBean comprobante) throws Exception;

	/**
	 * @param unidadMedida
	 * @return
	 * @throws Exception
	 */
	public abstract List<UnidadMedidaBean> listarUnidadMedida(UnidadMedidaBean unidadMedida) throws Exception;
	
	/**
	 * @param unidadMedida
	 * @return
	 * @throws Exception
	 */
	public abstract Integer grabarUnidadMedida(UnidadMedidaBean unidadMedida) throws Exception;
	
	/**
	 * @param documento
	 * @return
	 * @throws Exception
	 */
	public abstract List<TipoDocumentoBean> listarTipoDocumento(TipoDocumentoBean documento) throws Exception;
	
	/**
	 * @param moneda
	 * @return
	 * @throws Exception
	 */
	public abstract List<TipoMonedaBean> listarTipoMoneda(TipoMonedaBean moneda) throws Exception;

	/**
	 * @param moneda
	 * @return
	 * @throws Exception
	 */
	public abstract List<OtrosBean> listarOtros(OtrosBean otros) throws Exception;

	/**
	 * @param tipoMoneda
	 * @return
	 * @throws Exception
	 */
	public abstract Integer grabarOtros(OtrosBean otros) throws Exception;
	
	/**
	 * @param especifica
	 * @return
	 * @throws Exception
	 */
	public abstract List<EspecificaBean> listarEspecifica(EspecificaBean especifica) throws Exception;
	
	/**
	 * @param fuente
	 * @return
	 * @throws Exception
	 */
	public abstract List<FuenteFinanciamientoBean> listarFuenteFinanciamiento(FuenteFinanciamientoBean fuente) throws Exception;
	
	/**
	 * @param cuenta corriente
	 * @return
	 * @throws Exception
	 */
	public abstract List<CuentaCorrienteBean> listarCuentaCorriente(CuentaCorrienteBean ctacte) throws Exception;
	
	/**
	 * @param proveedor
	 * @return
	 * @throws Exception
	 */
	public abstract List<ProveedorBean> listarProveedor(ProveedorBean proveedor) throws Exception;
	
	/**
	 * @param proveedor
	 * @return
	 * @throws Exception
	 */
	public abstract Integer grabarProveedor(ProveedorBean proveedor) throws Exception;
	
	/**
	 * @param tipoMoneda
	 * @return
	 * @throws Exception
	 */
	public abstract Integer grabarTipoMoneda(TipoMonedaBean tipoMoneda) throws Exception;
	
	/**
	 * @param financiero
	 * @return
	 * @throws Exception
	 */
	public abstract List<EntidadFinancieraBean> listarFinanciero(EntidadFinancieraBean financiero) throws Exception;
	
	/**
	 * @param financiero
	 * @return
	 * @throws Exception
	 */
	public abstract Integer grabarEntidadFinanciera(EntidadFinancieraBean financiero) throws Exception;
	/**
	 * @param financiero
	 * @return
	 * @throws Exception
	 */
	public abstract List<MediosPagosBean> listarMedioPago(MediosPagosBean financiero) throws Exception;
	/**
	 * @param financiero
	 * @return
	 * @throws Exception
	 */
	public abstract Integer grabarMedioPago(MediosPagosBean financiero) throws Exception;
	/**
	 * @param financiero
	 * @return
	 * @throws Exception
	 */
	public abstract List<LibroRegistroBean> listarLibroRegistro(LibroRegistroBean financiero) throws Exception;
	/**
	 * @param financiero
	 * @return
	 * @throws Exception
	 */
	public abstract Integer grabarLibroRegistro(LibroRegistroBean financiero) throws Exception;
	/**
	 * @param financiero
	 * @return
	 * @throws Exception
	 */
	public abstract List<ProductoBean> listarproductos(ProductoBean financiero) throws Exception;
	/**
	 * @param financiero
	 * @return
	 * @throws Exception
	 */
	public abstract Integer grabarproductos(ProductoBean financiero) throws Exception;
	/**
	 * @param tipoDocumento
	 * @return
	 * @throws Exception
	 */
	public abstract Integer grabarTipoDocumento(TipoDocumentoBean tipoDocumento) throws Exception;
	/**
	 * @param cierre
	 * @return
	 * @throws Exception
	 */
	public abstract List<CierreMesBean> listarCierresMes(CierreMesBean cierre) throws Exception;
	/**
	 * @param cierre
	 * @return
	 * @throws Exception
	 */
	public abstract Integer grabarCierre(CierreMesBean cierre) throws Exception;
	/**
	 * @param financiero
	 * @return
	 * @throws Exception
	 */
	public abstract List<UnidadMedidaBean> listarUnidadesMedida(UnidadMedidaBean financiero) throws Exception;
	/**
	 * @param financiero
	 * @return
	 * @throws Exception
	 */
	public abstract List<TarifaBoletoBean> listarboletos(TarifaBoletoBean financiero) throws Exception;
	/**
	 * @param financiero
	 * @return
	 * @throws Exception
	 */
	public abstract Integer grabartarifaboletos(TarifaBoletoBean financiero) throws Exception;
	/**
	 * @param financiero
	 * @return
	 * @throws Exception
	 */
	public abstract List<CuartaCategoriaBean> listarCuartaCategoria(CuartaCategoriaBean financiero) throws Exception;
	/**
	 * @param financiero
	 * @return
	 * @throws Exception
	 */
	public abstract Integer grabarCuartaCategoria(CuartaCategoriaBean financiero) throws Exception;
	
	/**
	 * @param financiero
	 * @return
	 * @throws Exception
	 */
	public abstract List<PersonaCuartaBean> verificarRucCuarta(PersonaCuartaBean financiero) throws Exception;
	
	/**
	 * @param cuenta
	 * @return
	 * @throws Exception 
	 */
	public abstract List<CuentaContableBean> listarCuentaContable(CuentaContableBean cuenta) throws Exception;
	
	/**
	 * @param cuenta
	 * @return
	 * @throws Exception
	 */
	public abstract Integer grabarCuentaContable(CuentaContableBean cuenta) throws Exception;
	/**
	 * @param cuenta
	 * @return
	 * @throws Exception 
	 */
	public abstract List<TipoComprobanteCuartaBean> listarTipoComprobanteCuarta(TipoComprobanteCuartaBean comprobante) throws Exception;
	/**
	 * @param cuenta
	 * @return
	 * @throws Exception 
	 */
	public abstract List<NacionalidadBean> listarNacionalidad(NacionalidadBean comprobante) throws Exception;
	/**
	 * @param cuenta
	 * @return
	 * @throws Exception 
	 */
	public abstract List<ViaBean> listarVia(ViaBean comprobante) throws Exception;
	/**
	 * @param cuenta
	 * @return
	 * @throws Exception 
	 */
	public abstract List<ZonaBean> listarZona(ZonaBean comprobante) throws Exception;
	/**
	 * @param cuenta
	 * @return
	 * @throws Exception 
	 */
	public abstract List<DocumentoCuartaBean> listarDocumentoCuarta(DocumentoCuartaBean comprobante) throws Exception;
	/**
	 * @param cuenta
	 * @return
	 * @throws Exception 
	 */
	public abstract List<ConvenioCuartaBean> listarConvenio(ConvenioCuartaBean comprobante) throws Exception;
	/**
	 * @param cuenta
	 * @return
	 * @throws Exception
	 */
	public abstract Integer grabarPersonaCuartaCategoria(PersonaCuartaBean cuenta) throws Exception;
	/**
	 * @param cuenta
	 * @return
	 * @throws Exception 
	 */
	public abstract List<CartaFianzaBean> listarCartaFianza(CartaFianzaBean comprobante) throws Exception;
	/**
	 * @param cuenta
	 * @return
	 * @throws Exception
	 */
	public abstract Integer grabarCartaFianza(CartaFianzaBean comprobante) throws Exception;
	/**
	 * @param cuenta
	 * @return
	 * @throws Exception 
	 */
	public abstract List<UbigeoBean> listarUbigeo(UbigeoBean comprobante) throws Exception;

	/**
	 * @param financiero
	 * @return
	 * @throws Exception
	 */
	public abstract List<DireccionFacturaBean> listarDirecFact(DireccionFacturaBean factura) throws Exception;
}