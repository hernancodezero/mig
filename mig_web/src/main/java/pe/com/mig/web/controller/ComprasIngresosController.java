package pe.com.mig.web.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.converters.BigDecimalConverter;
import org.apache.commons.beanutils.converters.IntegerConverter;
import org.apache.commons.beanutils.converters.LongConverter;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import pe.com.mig.model.bean.CierreMesBean;
import pe.com.mig.model.bean.ComprasIngresosBean;
import pe.com.mig.model.bean.ConvenioCuartaBean;
import pe.com.mig.model.bean.CuentaCorrienteBean;
import pe.com.mig.model.bean.DetalleComprasBean;
import pe.com.mig.model.bean.DetalleIngresosBean;
import pe.com.mig.model.bean.DetalleOtrosBean;
import pe.com.mig.model.bean.DetalleTransferenciaBean;
import pe.com.mig.model.bean.DetalleVoucherBean;
import pe.com.mig.model.bean.DireccionFacturaBean;
import pe.com.mig.model.bean.DocumentoCuartaBean;
import pe.com.mig.model.bean.FuenteFinanciamientoBean;
import pe.com.mig.model.bean.MediosPagosBean;
import pe.com.mig.model.bean.NacionalidadBean;
import pe.com.mig.model.bean.ProductoBean;
import pe.com.mig.model.bean.ProveedorBean;
import pe.com.mig.model.bean.ReporteDetalleComprasBean;
import pe.com.mig.model.bean.ReporteDetalleIngresosBean;
import pe.com.mig.model.bean.SeriesBean;
import pe.com.mig.model.bean.SucursalBean;
import pe.com.mig.model.bean.TarifaBoletoBean;
import pe.com.mig.model.bean.TarifaServicioBean;
import pe.com.mig.model.bean.TarifaTupaBean;
import pe.com.mig.model.bean.TipoComprobanteBean;
import pe.com.mig.model.bean.TipoDocumentoBean;
import pe.com.mig.model.bean.TipoMonedaBean;
import pe.com.mig.model.bean.TransferenciaBean;
import pe.com.mig.model.bean.UbigeoBean;
import pe.com.mig.model.bean.ViaBean;
import pe.com.mig.model.bean.ZonaBean;
import pe.com.mig.model.bean.sernanp.UnidadOperativaBean;
import pe.com.mig.model.bean.sernanp.UsuarioBean;
import pe.com.mig.service.IComprasIngresosService;
import pe.com.mig.service.IMaestroService;
import pe.com.mig.service.ITransferenciaService;
import pe.com.mig.util.Constantes;
import pe.com.mig.util.DateUtil;
import pe.com.mig.util.ReadParameterProperties;
import pe.com.mig.web.commons.Reporteador;

/**
 * @className: ComprasController.java
 * @description: grabarCartaFianza
 * @date: 11 de jun. de 2016
 * @author: SUMERIO.
 */
@Controller
public class ComprasIngresosController extends BaseController {

	private static final long serialVersionUID = 1L;
	
	@Autowired 
	private IMaestroService iMaestroService;
	
	@Autowired 
	private IComprasIngresosService iCompraService;
	
	@Autowired 
	private ITransferenciaService iTransferenciaService;

	/**
	 * Metodo que retorna a la Bandeja Registro de Compras.
	 * @param indicador 
	 * @return - Retorna a la vista JSP.
	 */
	@RequestMapping("/comprasIngreso/{indicador}")
    public ModelAndView comprasIngreso(@PathVariable("indicador") Integer indicador) {
		ModelAndView model = new ModelAndView("lis_reg_com_ingresos");		
		try {
			// Retorno los datos de session
			usuarioBean = (UsuarioBean) context().getAttribute("usuarioBean", RequestAttributes.SCOPE_SESSION);

			List<TipoComprobanteBean> lis_tip_comprobante = new ArrayList<TipoComprobanteBean>();		
			lis_tip_comprobante = iMaestroService.listarTipoComprobante(new TipoComprobanteBean(Constantes.FLAG_ACTIVO));			
			model.addObject("lis_tip_comprobante", lis_tip_comprobante);
			
			List<UnidadOperativaBean> lis_uni_operativa = new ArrayList<UnidadOperativaBean>();	
			String ind_sed_principal = null;
			List<UnidadOperativaBean> lis_uni_ope_principal = new ArrayList<UnidadOperativaBean>();
			lis_uni_ope_principal = iMaestroService.verificarSedePrincipal(usuarioBean.getCod_usuario());
			if (!isEmpty(lis_uni_ope_principal)) {
				lis_uni_operativa = iMaestroService.listarUnidadOperativa(new UnidadOperativaBean());
				ind_sed_principal = "1";
			} else {
				lis_uni_operativa = iMaestroService.listarUnidadOperativa(new UnidadOperativaBean(usuarioBean.getCod_usuario()));
				ind_sed_principal = "0";
			}			
			model.addObject("lis_uni_operativa", lis_uni_operativa);
			
			model.addObject("ind_sed_principal", ind_sed_principal);
			
			model.addObject("indicador", indicador);
			
		} catch (Exception e) {
			log.error(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(),
									  Constantes.NIVEL_APP_CONSTROLLER, 
									  this.getClass().getName(), e.getMessage()));
		}		
		return model;
    }
	
	/**
	 * @param request
	 * @param response
	 * @return - Retorna a la vista JSP.
	 */
	@RequestMapping(value = "/listarIngresoCompras", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<ComprasIngresosBean> listarIngresoCompras(HttpServletRequest request, HttpServletResponse response) {
		List<ComprasIngresosBean> lista = null;
		try {			
			ComprasIngresosBean compra = new ComprasIngresosBean();
			// Copia los parametros del cliente al objeto
			BeanUtils.populate(compra, request.getParameterMap());
			lista = iCompraService.listarCompras(compra);
			
		} catch (Exception e) {
			log.error(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(),
									  Constantes.NIVEL_APP_CONSTROLLER, 
									  this.getClass().getName(), e.getMessage()));
		}
		return lista;
	}
	
	/**
	 * Metodo que retorna a la Bandeja Registro de Compras.
	 * @param indicador 
	 * @param codigo - Id Codigo de compra.
	 * @return - Retorna a la vista JSP.
	 */
	@RequestMapping("/mnt_com_ingresos/{indicador}/{codigo}")  // codigo = id del comprobante
    public ModelAndView mnt_com_ingresos(@PathVariable("indicador") Integer indicador, @PathVariable("codigo") Integer codigo) {
		ModelAndView model = null;	
		try {
			String ind_transaccion = indicador.toString().substring(0, 1);
			ComprasIngresosBean compra = null;

			String ind_sed_principal = null;
			
			// Retorno los datos de session
			usuarioBean = (UsuarioBean) context().getAttribute("usuarioBean", RequestAttributes.SCOPE_SESSION);
	 
			// Consultamos si el usuario es de Sede Central
			List<UnidadOperativaBean> lis_uni_ope_principal = new ArrayList<UnidadOperativaBean>();
			lis_uni_ope_principal = iMaestroService.verificarSedePrincipal(usuarioBean.getCod_usuario());
			if (!isEmpty(lis_uni_ope_principal)) {
				ind_sed_principal = "1";				
			} else {
				ind_sed_principal = "0";
			}			
						
			if (getInteger(ind_transaccion) == 1) { // Compras
												
				model = new ModelAndView("mnt_reg_compras");
				
				model.addObject("ind_sed_principal", ind_sed_principal);
				
				if (!isNullInteger(codigo)) { //codigo=id del comprobante
					
					model.addObject("codigo", codigo);
				
					compra = iCompraService.listarCompras(new ComprasIngresosBean(codigo)).get(0);
					model.addObject("compra", compra);
					
					List<DetalleComprasBean> lis_det_compras = iCompraService.listarDetalleCompras(new ComprasIngresosBean(codigo));																	   
					model.addObject("lis_det_compras", lis_det_compras);
					
					TransferenciaBean transferencia = new TransferenciaBean();
					transferencia.setNum_comprobante(compra.getNro_cp());
					transferencia.setNum_siaf(compra.getNro_sia_operacion());
					List<TransferenciaBean> lista = iTransferenciaService.listarTransferencias(transferencia);
					transferencia = lista.get(0);				
					
					
					BigDecimal monto = iCompraService.montoTransferencia(transferencia);
					TransferenciaBean tra_not_cre = transferencia;
					tra_not_cre.setCod_comprobante(Constantes.EIGHT_INT); // Nota de Credito
					BigDecimal mon_not_cre = iCompraService.montoCompraNota(tra_not_cre);
					TransferenciaBean tra_not_deb = transferencia;
					tra_not_deb.setCod_comprobante(Constantes.NINE_INT); // Nota de Debito
					BigDecimal mon_not_deb = iCompraService.montoCompraNota(tra_not_deb);
					
					transferencia.setImp_tot_rc(monto.add(mon_not_deb).subtract(mon_not_cre));
															
					
					model.addObject("transferencia", transferencia);
					
					// Retornamos las partidas asociadas a la transferencia
					DetalleTransferenciaBean detalle = new DetalleTransferenciaBean();
					detalle.setCod_transferencia(transferencia.getCod_transferencia());		
					detalle.setInd_saldo(1);
					List<DetalleTransferenciaBean> lis_detalle = iTransferenciaService.listarDetalleTransferencias(detalle);
					model.addObject("lis_detalle", lis_detalle);
					
					// Consultamos si el registro se puede editar de acuerdo al cierre de mes
					String ind_mes_cierre = "1";
					CierreMesBean cierre = new CierreMesBean();

					cierre.setAnio(compra.getCod_anno());
					cierre.setCod_mes(compra.getCod_mes());
					cierre.setCod_uni_operativa(compra.getCod_uni_operativa());
					cierre.setCod_reg_nac(compra.getCod_reg_nac());					
					cierre.setMes_activo(Constantes.FLAG_ACTIVO);
					cierre.setFla_apertura(Constantes.FLAG_INACTIVO);
					cierre.setInd_tip_compra(Constantes.ONE_INT);
					List<CierreMesBean> lis_cie_mes = iCompraService.listarCierresMes(cierre);
					if (!isEmpty(lis_cie_mes) && !isNullInteger(compra.getCod_mes())) {
						boolean ind_cierre = false;
						for (CierreMesBean cie : lis_cie_mes) {
							if (cie.getMes().equals(compra.getCod_mes())) {
								ind_cierre = true;
								break;
							}
						}
						if (ind_cierre) {
							ind_mes_cierre = "0";
						}	
					}
					model.addObject("ind_mes_cierre", ind_mes_cierre);					
					
					// Verificamos si la compra contiene una nota de credito o debito asociado	
					if (!isNull(compra.getCod_pad_com_ingresos())) {
						model.addObject("ind_not_credito", "0"); // Deshabilitamos opcion nota de credito o debito
						// Traemos la factura asociada al registro padre
						if (!isNullInteger(compra.getCod_pad_com_ingresos())) {
							ComprasIngresosBean com_ing_padre = iCompraService.listarCompras(new ComprasIngresosBean(compra.getCod_pad_com_ingresos())).get(0);
							StringBuilder nro_factura = new StringBuilder();
							nro_factura.append(com_ing_padre.getSer_comprobante());
							nro_factura.append(Constantes.ESPACIO);
							nro_factura.append(Constantes.SEPARADOR);
							nro_factura.append(Constantes.ESPACIO);
							nro_factura.append(com_ing_padre.getNro_comprobante());
							model.addObject("nro_factura", nro_factura.toString());
						}						
					} else {
						model.addObject("ind_not_credito", "1"); // Habilitamos opcion nota de credito o debito
					}					
					
				} else {
					model.addObject("codigo", "");
				}
				
				//Medios de Pago
				List<MediosPagosBean> lis_med_pago = new ArrayList<MediosPagosBean>();		
				lis_med_pago = iMaestroService.listarMedioPago(new MediosPagosBean(Constantes.FLAG_ACTIVO));			
				model.addObject("lis_med_pago", lis_med_pago);
				
				// Documento Cuarta
				List<DocumentoCuartaBean> lis_documento_cuarta = new ArrayList<DocumentoCuartaBean>();		
				lis_documento_cuarta = iMaestroService.listarDocumentoCuarta(new DocumentoCuartaBean(Constantes.FLAG_ACTIVO));			
				model.addObject("lis_documento_cuarta", lis_documento_cuarta);
				
				// Retorno Nacionalidad
				List<NacionalidadBean> lis_tip_nacionalidad = new ArrayList<NacionalidadBean>();		
				lis_tip_nacionalidad = iMaestroService.listarNacionalidad (new NacionalidadBean(Constantes.FLAG_ACTIVO));			
				model.addObject("lis_tip_nacionalidad", lis_tip_nacionalidad);
				
				//Retorno via
				List<ViaBean> lis_via = new ArrayList<ViaBean>();		
				lis_via = iMaestroService.listarVia(new ViaBean(Constantes.FLAG_ACTIVO));			
				model.addObject("lis_tip_via", lis_via);
				
				// Retorno Zona
				List<ZonaBean> lis_zona = new ArrayList<ZonaBean>();		
				lis_zona = iMaestroService.listarZona(new ZonaBean(Constantes.FLAG_ACTIVO));			
				model.addObject("lis_tip_zona", lis_zona);
				
				// Retorno Convenio
				List<ConvenioCuartaBean> lis_convenio = new ArrayList<ConvenioCuartaBean>();		
				lis_convenio = iMaestroService.listarConvenio (new ConvenioCuartaBean(Constantes.FLAG_ACTIVO));			
				model.addObject("lis_convenio", lis_convenio);
				
				// Retorno Ubigeo
				List<UbigeoBean> lis_ubigeo = new ArrayList<UbigeoBean>();		
				lis_ubigeo = iMaestroService.listarUbigeo(new UbigeoBean());			
				model.addObject("lis_ubigeo", lis_ubigeo);
				
			} else { // Ingresos

				model = new ModelAndView("mnt_reg_ingresos");
				
				model.addObject("ind_sed_principal", ind_sed_principal);
		
	
				List<UnidadOperativaBean> lis_uni_operativa = new ArrayList<UnidadOperativaBean>();	
				if (!isEmpty(lis_uni_ope_principal)) {
					lis_uni_operativa = iMaestroService.listarUnidadOperativa(new UnidadOperativaBean());
				} else {
					lis_uni_operativa = iMaestroService.listarUnidadOperativa(new UnidadOperativaBean(usuarioBean.getCod_usuario()));
				}			
				model.addObject("lis_uni_operativa", lis_uni_operativa);			
				
				List<MediosPagosBean> lis_med_pago = new ArrayList<MediosPagosBean>();		
				lis_med_pago = iMaestroService.listarMedioPago(new MediosPagosBean(Constantes.FLAG_ACTIVO));			
				model.addObject("lis_med_pago", lis_med_pago);
				
				List<DireccionFacturaBean> lis_dir_fact = new ArrayList<DireccionFacturaBean>();		
				lis_dir_fact = iMaestroService.listarDirecFact(new DireccionFacturaBean());			
				model.addObject("lis_dir_fact", lis_dir_fact);
				
				List<TarifaServicioBean> lis_tar_servicio = new ArrayList<TarifaServicioBean>();		
				lis_tar_servicio = iCompraService.listarTarifaServicios(new TarifaServicioBean());
				model.addObject("lis_tar_servicio", lis_tar_servicio);
				
				List<ProductoBean> lis_productos = new ArrayList<ProductoBean>();		
				lis_productos = iCompraService.listarProductos(new ProductoBean());
				model.addObject("lis_productos", lis_productos);
				
				TarifaBoletoBean tar_boleto = new TarifaBoletoBean();
				
				List<TarifaTupaBean> lis_tar_tupa = new ArrayList<TarifaTupaBean>();		
				lis_tar_tupa = iCompraService.listarTupas(new TarifaTupaBean());
				model.addObject("lis_tar_tupa", lis_tar_tupa);	
				
				List<DetalleOtrosBean> lis_otros = new ArrayList<DetalleOtrosBean>();		
				lis_otros = iCompraService.listarOtros(new DetalleOtrosBean());
				model.addObject("lis_otros", lis_otros);
				
				if (!isNullInteger(codigo)) {
					model.addObject("codigo", codigo);
					
					compra = iCompraService.listarCompras(new ComprasIngresosBean(codigo)).get(0);
					model.addObject("compra", compra);
					
					List<DetalleIngresosBean> lis_det_ingresos = iCompraService.listarDetalleIngresos(new ComprasIngresosBean(codigo));																	   
					model.addObject("lis_det_ingresos", lis_det_ingresos);
					
					List<DetalleVoucherBean> lis_det_voucher = iCompraService.listarDetalleVoucher(new DetalleVoucherBean(codigo));																	   
					model.addObject("lis_det_voucher", lis_det_voucher);

					tar_boleto.setCod_uni_operativa(compra.getCod_uni_operativa());	
					tar_boleto.setCod_reg_nac(compra.getCod_reg_nac());
					
					model.addObject("tip_transaccion", (lis_det_ingresos.size() > 0 ) ? lis_det_ingresos.get(0).getTip_transaccion() : null);
					//model.addObject("tip_transaccion", lis_det_ingresos.get(0).getTip_transaccion());
					
					// Consultamos si el registro se puede editar de acuerdo al cierre de109037 mes
					String ind_mes_cierre = "1";
					CierreMesBean cierre = new CierreMesBean();
					
					cierre.setAnio(compra.getCod_anno());
					cierre.setCod_mes(compra.getCod_mes());
					cierre.setCod_uni_operativa(compra.getCod_uni_operativa());
					cierre.setCod_reg_nac(compra.getCod_reg_nac());
					cierre.setInd_tip_venta(Constantes.TWO_INT);
					cierre.setMes_activo(Constantes.FLAG_ACTIVO);
					cierre.setFla_apertura_vta(Constantes.FLAG_INACTIVO);
					List<CierreMesBean> lis_cie_mes = iCompraService.listarCierresMes(cierre);
					if (!isEmpty(lis_cie_mes) && !isNullInteger(compra.getCod_mes())) {
						boolean ind_cierre = false;
						for (CierreMesBean cie : lis_cie_mes) {
							if (cie.getMes().equals(compra.getCod_mes())) {
								ind_cierre = true;
								break;
							}
						}
						if (ind_cierre) {
							ind_mes_cierre = "0";
						}	
					}
					model.addObject("ind_mes_cierre", ind_mes_cierre);
					
					// Verificamos si la compra contiene una nota de credito o debito asociado	
					if (!isNull(compra.getCod_pad_com_ingresos())) {
						model.addObject("ind_not_credito", "0"); // Deshabilitamos opcion nota de credito o debito
						// Traemos la factura asociada al registro padre
						if (!isNullInteger(compra.getCod_pad_com_ingresos())) {
							ComprasIngresosBean com_ing_padre = iCompraService.listarCompras(new ComprasIngresosBean(compra.getCod_pad_com_ingresos())).get(0);
							StringBuilder nro_factura = new StringBuilder();
							nro_factura.append(com_ing_padre.getSer_comprobante());
							nro_factura.append(Constantes.ESPACIO);
							nro_factura.append(Constantes.SEPARADOR);
							nro_factura.append(Constantes.ESPACIO);
							nro_factura.append(com_ing_padre.getNro_comprobante());
							model.addObject("nro_factura", nro_factura.toString());
						}
					} else {
						model.addObject("ind_not_credito", "1"); // Habilitamos opcion nota de credito o debito
					}
				
				} else {
					model.addObject("codigo", "");
					
					tar_boleto.setCod_uni_operativa(lis_uni_operativa.get(0).getCod_uni_operativa());	
					
					UnidadOperativaBean unidad = new UnidadOperativaBean();
					unidad.setCod_uni_operativa(lis_uni_operativa.get(0).getCod_uni_operativa());
					unidad.setInd_uni_operativa(1);	
					
					List<UnidadOperativaBean> lis_anp = iMaestroService.listarUnidadOperativa(unidad);			
					tar_boleto.setCod_reg_nac(lis_anp.get(0).getCod_reg_nac());		
				}
				
				tar_boleto.setInd_saldo(1); // Indicador saldo actual
				
				List<TarifaBoletoBean> lis_tar_boletos = new ArrayList<TarifaBoletoBean>();		
				lis_tar_boletos = iCompraService.listarBoletos(tar_boleto);
				model.addObject("lis_tar_boletos", lis_tar_boletos);				
			}
			
			List<TipoComprobanteBean> lis_tip_comprobante = new ArrayList<TipoComprobanteBean>();		
			lis_tip_comprobante = iMaestroService.listarTipoComprobante(new TipoComprobanteBean(Constantes.FLAG_ACTIVO));
			model.addObject("lis_tip_comprobante", lis_tip_comprobante);
			
			List<FuenteFinanciamientoBean> lis_fue_financiamiento = new ArrayList<FuenteFinanciamientoBean>();		
			lis_fue_financiamiento = iMaestroService.listarFuenteFinanciamiento(new FuenteFinanciamientoBean(Constantes.FLAG_ACTIVO));			
			model.addObject("lis_fue_financiamiento", lis_fue_financiamiento);

			List<CuentaCorrienteBean> lis_cta_corriente = new ArrayList<CuentaCorrienteBean>();		
			lis_cta_corriente = iMaestroService.listarCuentaCorriente(new CuentaCorrienteBean(Constantes.FLAG_ACTIVO));			
			model.addObject("lis_cta_corriente", lis_cta_corriente);		
			
			List<TipoMonedaBean> lis_tip_moneda = new ArrayList<TipoMonedaBean>();		
			lis_tip_moneda = iMaestroService.listarTipoMoneda(new TipoMonedaBean(Constantes.FLAG_ACTIVO));			
			model.addObject("lis_tip_moneda", lis_tip_moneda);
			
			List<TipoDocumentoBean> lis_tip_documento = new ArrayList<TipoDocumentoBean>();		
			lis_tip_documento = iMaestroService.listarTipoDocumento(new TipoDocumentoBean(Constantes.FLAG_ACTIVO));			
			model.addObject("lis_tip_documento", lis_tip_documento);
			
			model.addObject("indicador", indicador);
			
		} catch (Exception e) {
			log.error(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(),
									  Constantes.NIVEL_APP_CONSTROLLER, 
									  this.getClass().getName(), e.getMessage()));
			
		}		
		return model;
    }
	
	/**
	 * @param request
	 * @param response
	 * @return Retorna el codigo de la tabla de compra.
	 */
	@RequestMapping(value = "/grabarIngresoCompras", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public Integer grabarIngresoCompras(HttpServletRequest request, HttpServletResponse response) {
		Integer codigo = null;
		try {
			ComprasIngresosBean com_ingreso = new ComprasIngresosBean();
			
			// Convierte los vacios en nulos en los enteros
			IntegerConverter con_integer = new IntegerConverter(null);			
			BeanUtilsBean beanUtilsBean = new BeanUtilsBean();
			beanUtilsBean.getConvertUtils().register(con_integer, Integer.class);
			// Convierte los vacios en nulos en los decimales
			BigDecimalConverter con_decimal = new BigDecimalConverter(null);
			beanUtilsBean.getConvertUtils().register(con_decimal, BigDecimal.class);
			// Copia los parametros del cliente al objeto
			beanUtilsBean.populate(com_ingreso, request.getParameterMap());
			
			// Retorno los datos de session
			usuarioBean = (UsuarioBean) context().getAttribute("usuarioBean", RequestAttributes.SCOPE_SESSION);
			com_ingreso.setVnomusuario(usuarioBean.getDes_usuario());
			
			String arr_partida[] = request.getParameter("arr_partida").split("\\|", -1);			
			String arr_importe[] = request.getParameter("arr_importe").split("\\|", -1);
			String arr_tip_venta[] = request.getParameter("arr_tip_venta").split("\\|", -1);			
			String arr_imp_afecto[] = request.getParameter("arr_imp_afecto").split("\\|", -1);
			String arr_imp_no_afecto[] = request.getParameter("arr_imp_no_afecto").split("\\|", -1);
			String arr_imp_igv[] = request.getParameter("arr_imp_igv").split("\\|", -1);
			String arr_imp_isc[] = request.getParameter("arr_imp_isc").split("\\|", -1);
						
			if (com_ingreso.getInt_transaccion() == 1) { // Compras
				String arr_meta[] = request.getParameter("arr_meta").split("\\|", -1);
				String arr_cue_contable[] = request.getParameter("arr_cue_contable").split("\\|", -1);
				String arr_ind_ret[] = request.getParameter("arr_ind_ret").split("\\|", -1);
				String arr_num_ret[] = request.getParameter("arr_num_ret").split("\\|", -1);
				String arr_fec_pag[] = request.getParameter("arr_fec_pag").split("\\|", -1);

				List<DetalleComprasBean> detalle = new ArrayList<DetalleComprasBean>();
				for (int i = 0; i < arr_partida.length; i++) {
					DetalleComprasBean detalleComprasBean = new DetalleComprasBean();
					detalleComprasBean.setCod_especifica(getLong(arr_partida[i]));
					detalleComprasBean.setCod_meta(getString(arr_meta[i]));
					detalleComprasBean.setCod_cuenta(getInteger(arr_cue_contable[i]));
					detalleComprasBean.setNum_imp_servicio(getBigDecimal(arr_importe[i]));
					detalleComprasBean.setCod_tip_venta(arr_tip_venta[i]);				
					detalleComprasBean.setNum_imp_afecto(getBigDecimal(arr_imp_afecto[i]));
					detalleComprasBean.setNum_imp_no_afecto(getBigDecimal(arr_imp_no_afecto[i]));
					detalleComprasBean.setNum_imp_igv(getBigDecimal(arr_imp_igv[i]));
					detalleComprasBean.setNum_imp_isc(getBigDecimal(arr_imp_isc[i]));
					detalleComprasBean.setInd_retencion(arr_ind_ret[i]);
					detalleComprasBean.setNum_retencion(arr_num_ret[i]);
					detalleComprasBean.setFec_pago(arr_fec_pag[i]);
					detalleComprasBean.setVnomusuario(usuarioBean.getDes_usuario());
					detalle.add(detalleComprasBean);
				}
				
				codigo = iCompraService.grabarCompra(com_ingreso, detalle);
				
			} else if (com_ingreso.getInt_transaccion() == 2) { // Ingresos
				
				String cod_tip_transaccion = request.getParameter("cod_tip_transaccion");				
				String arr_dias[] = request.getParameter("arr_dias").split("\\|", -1); 
				String arr_pers[] = request.getParameter("arr_pers").split("\\|", -1);
				String arr_cantidad[] = request.getParameter("arr_cantidad").split("\\|", -1);
				/*
				String arr_part[] = request.getParameter("arr_part").split("\\|", -1);				
				String arr_meta[] = request.getParameter("arr_meta").split("\\|", -1);
				String arr_cuen[] = request.getParameter("arr_cuen").split("\\|", -1);
				*/
				String arr_pre_unitario[] = request.getParameter("arr_pre_unitario").split("\\|", -1);
				String arr_num_ini_boleto[] = request.getParameter("arr_num_ini_boleto").split("\\|", -1);
				
				List<DetalleIngresosBean> detalle = new ArrayList<DetalleIngresosBean>();
				for (int i = 0; i < arr_partida.length; i++) {
					DetalleIngresosBean detalleIngresosBean = new DetalleIngresosBean();
					detalleIngresosBean.setTip_transaccion(cod_tip_transaccion);				
					detalleIngresosBean.setCan_dias(getInteger(arr_dias[i]));
					detalleIngresosBean.setCan_pers(getInteger(arr_pers[i]));
					//detalleIngresosBean.setCod_especifica(getInteger(arr_part[i]));
					detalleIngresosBean.setCan_producto(getBigDecimal(arr_cantidad[i]));
					detalleIngresosBean.setNum_pre_unitario(getBigDecimal(arr_pre_unitario[i]));
					detalleIngresosBean.setIni_boleto(getInteger(arr_num_ini_boleto[i]));					
					detalleIngresosBean.setCod_especifica(getInteger(arr_partida[i]));
					detalleIngresosBean.setCod_tip_venta(arr_tip_venta[i]);				
					detalleIngresosBean.setNum_imp_afecto(getBigDecimal(arr_imp_afecto[i]));
					detalleIngresosBean.setNum_imp_no_afecto(getBigDecimal(arr_imp_no_afecto[i]));
					detalleIngresosBean.setNum_imp_igv(getBigDecimal(arr_imp_igv[i]));
					detalleIngresosBean.setNum_imp_isc(getBigDecimal(arr_imp_isc[i]));	
					detalleIngresosBean.setVnomusuario(usuarioBean.getDes_usuario());
					detalle.add(detalleIngresosBean);
				}
				
				String arr_nro_papeleta[] = request.getParameter("arr_nro_papeleta").split("\\|", -1);			
				String arr_fec_papeleta[] = request.getParameter("arr_fec_papeleta").split("\\|", -1); 
				String arr_imp_papeleta[] = request.getParameter("arr_imp_papeleta").split("\\|", -1);
				String arr_arc_pap[] = request.getParameter("arr_arc_pap").split("\\|", -1);
				List<DetalleVoucherBean> det_voucher = new ArrayList<DetalleVoucherBean>();
				if (!isNullOrEmpty(arr_nro_papeleta[0])) {
					for (int k = 0; k < arr_nro_papeleta.length; k++) {
						DetalleVoucherBean detalleVoucherBean = new DetalleVoucherBean();
						detalleVoucherBean.setNum_voucher(arr_nro_papeleta[k]);					
						detalleVoucherBean.setFec_voucher(arr_fec_papeleta[k]);
						detalleVoucherBean.setImp_voucher(getBigDecimal(arr_imp_papeleta[k]));	
						detalleVoucherBean.setImg_voucher(arr_arc_pap[k]);
						detalleVoucherBean.setVnomusuario(usuarioBean.getDes_usuario());
						det_voucher.add(detalleVoucherBean);
					}
				}
				
				codigo = iCompraService.grabarIngreso(com_ingreso, detalle, det_voucher);
			}
			
		} catch (Exception e) {
			log.error(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(),
					  Constantes.NIVEL_APP_CONSTROLLER, 
					  this.getClass().getName(), e.getMessage()));
		}
		return codigo;
	}
	
	/**
	 * @param request
	 * @param response
	 * @return - Retorna a la vista JSP.
	 */
	@RequestMapping(value = "/verificarRuc", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public ProveedorBean verificarRuc(HttpServletRequest request, HttpServletResponse response) {
		ProveedorBean proveedor = new ProveedorBean();
		try {
			List<ProveedorBean> lista = new ArrayList<ProveedorBean>();
			lista = iMaestroService.listarProveedor(new ProveedorBean(getLong(request.getParameter("nro_ruc"))));
			if (!isEmpty(lista)) {
				proveedor = lista.get(0);
			}
		} catch (Exception e) {
			log.error(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(),
									  Constantes.NIVEL_APP_CONSTROLLER, 
									  this.getClass().getName(), e.getMessage()));
		}
		return proveedor;
	}
	
	/**
	 * @param request
	 * @param response
	 * @return - Retorna a la vista JSP.
	 */
	@RequestMapping(value = "/verificarDni", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public ProveedorBean verificarDni(HttpServletRequest request, HttpServletResponse response) {
		ProveedorBean proveedor = new ProveedorBean();
		try {
			List<ProveedorBean> lista = new ArrayList<ProveedorBean>();
			lista = iMaestroService.listarProveedor(new ProveedorBean(request.getParameter("nro_dni")));
			if (!isEmpty(lista)) {
				proveedor = lista.get(0);
			}
		} catch (Exception e) {
			log.error(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(),
									  Constantes.NIVEL_APP_CONSTROLLER, 
									  this.getClass().getName(), e.getMessage()));
		}
		return proveedor;
	}
	
	/**
	 * @param request
	 * @param response
	 * @return Retorna el codigo de la tabla de proveedor.
	 */
	@RequestMapping(value = "/grabarProveedor", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public Integer grabarProveedor(HttpServletRequest request, HttpServletResponse response) {
		Integer codigo = null;
		try {
			ProveedorBean proveedor = new ProveedorBean();
			// Convierte los vacios en nulos en los enteros
			IntegerConverter converter = new IntegerConverter(null); 
			BeanUtilsBean beanUtilsBean = new BeanUtilsBean();
			beanUtilsBean.getConvertUtils().register(converter, Integer.class);			
			// Convierte los vacios en nulos en long
			LongConverter con_long = new LongConverter(null); 
			beanUtilsBean.getConvertUtils().register(con_long, Long.class);			
			// Copia los parametros del cliente al objeto
			beanUtilsBean.populate(proveedor, request.getParameterMap());
			// Retorno los datos de session
			usuarioBean = (UsuarioBean) context().getAttribute("usuarioBean", RequestAttributes.SCOPE_SESSION);
			proveedor.setVnomusuario(usuarioBean.getDes_usuario());
			codigo = iMaestroService.grabarProveedor(proveedor);			
		} catch (Exception e) {
			log.error(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(),
									  Constantes.NIVEL_APP_CONSTROLLER, 
									  this.getClass().getName(), e.getMessage()));
		}
		return codigo;
	}
	
	/**
	 * @param request
	 * @param response
	 * @return - Retorna a la vista JSP.
	 */
	@RequestMapping(value = "/eliminarCompra", method = RequestMethod.POST)
	@ResponseBody
	public String eliminarCompra(HttpServletRequest request, HttpServletResponse response) {
		String estado = null;
		try {			
			ComprasIngresosBean compra = new ComprasIngresosBean();
			// Copia los parametros del cliente al objeto
			BeanUtils.populate(compra, request.getParameterMap());
			// Retorno los datos de session
			usuarioBean = (UsuarioBean) context().getAttribute("usuarioBean", RequestAttributes.SCOPE_SESSION);
			compra.setVnomusuario(usuarioBean.getDes_usuario());
			iCompraService.eliminarCompra(compra);
			estado = Constantes.ACCION_CORRECTA_JSON;
		} catch (Exception e) {
			log.error(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(),
									  Constantes.NIVEL_APP_CONSTROLLER, 
									  this.getClass().getName(), e.getMessage()));
		}
		return estado;
	}
	
	/**
	 * @param request
	 * @param response
	 * @return - Retorna a la vista JSP.
	 */
	@RequestMapping(value = "/verificarTransferencia", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public TransferenciaBean verificarTransferencia(HttpServletRequest request, HttpServletResponse response) {
		TransferenciaBean transferencia = new TransferenciaBean();
		try {			
			List<TransferenciaBean> lista = new ArrayList<TransferenciaBean>();
			TransferenciaBean trans = new TransferenciaBean();
			// Convierte los vacios en nulos en los enteros
			IntegerConverter con_integer = new IntegerConverter(null);			
			BeanUtilsBean beanUtilsBean = new BeanUtilsBean();
			beanUtilsBean.getConvertUtils().register(con_integer, Integer.class);
			// Copia los parametros del cliente al objeto
			beanUtilsBean.populate(trans, request.getParameterMap());			
			lista = iTransferenciaService.listarTransferencias(trans);
			if (!isEmpty(lista)) {
				boolean estado = false;
				transferencia = lista.get(0);
				
				// Retornamos las partidas asociadas a la transferencia
				DetalleTransferenciaBean detalle = new DetalleTransferenciaBean();
				detalle.setCod_transferencia(transferencia.getCod_transferencia());
				detalle.setInd_saldo(1);
				
				List<DetalleTransferenciaBean> lis_detalle = iTransferenciaService.listarDetalleTransferencias(detalle);				
				transferencia.setLis_detalle(lis_detalle);	
				
				// Retornamos los campos Nro Doc R/C y Fecha de Doc R/C del primer registro ya grabado.
				ComprasIngresosBean compra = new ComprasIngresosBean();
				compra.setInt_transaccion(1); // Identificador de la transacción Compras
				compra.setNro_cp(transferencia.getNum_comprobante());
				compra.setNro_sia_operacion(transferencia.getNum_siaf());
				List<ComprasIngresosBean> lis_compra = iCompraService.listarCompras(compra);
				if (!isEmpty(lis_compra)) {
					transferencia.setNro_doc_rc(lis_compra.get(0).getNro_doc_rc());
					transferencia.setFec_doc_rc(lis_compra.get(0).getFec_doc_rc());
				}

				List<UnidadOperativaBean> lis_uni_operativa = new ArrayList<UnidadOperativaBean>();	
				List<UnidadOperativaBean> lis_uni_ope_principal = new ArrayList<UnidadOperativaBean>();
				lis_uni_ope_principal = iMaestroService.verificarSedePrincipal(usuarioBean.getCod_usuario());
				if (!isEmpty(lis_uni_ope_principal)) {
					lis_uni_operativa = iMaestroService.listarUnidadOperativa(new UnidadOperativaBean());
				} else {
					// Retorno los datos de session
					usuarioBean = (UsuarioBean) context().getAttribute("usuarioBean", RequestAttributes.SCOPE_SESSION);
					// Validamos la lista que las Unidades Operativas del usuario actual pertenescan a la transferencia asociada.
					lis_uni_operativa = iMaestroService.listarUnidadOperativa(new UnidadOperativaBean(usuarioBean.getCod_usuario()));
				}							
					
				for (UnidadOperativaBean unidad : lis_uni_operativa) {
					if (unidad.getCod_uni_operativa() == transferencia.getCod_uni_operativa()) {
						estado = true;
						break;
					}					
				}
				if (estado) {
					transferencia.setInt_id_registro(1);
					trans.setNum_siaf(transferencia.getNum_siaf());
					BigDecimal monto = iCompraService.montoTransferencia(trans);
					TransferenciaBean tra_not_cre = trans;
					tra_not_cre.setCod_comprobante(Constantes.EIGHT_INT); // Nota de Credito
					BigDecimal mon_not_cre = iCompraService.montoCompraNota(tra_not_cre);
					TransferenciaBean tra_not_deb = trans;
					tra_not_deb.setCod_comprobante(Constantes.NINE_INT); // Nota de Debito
					BigDecimal mon_not_deb = iCompraService.montoCompraNota(tra_not_deb);					
					transferencia.setImp_tot_rc(monto.add(mon_not_deb).subtract(mon_not_cre));
				}
			}
		} catch (Exception e) {
			log.error(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(),
									  Constantes.NIVEL_APP_CONSTROLLER, 
									  this.getClass().getName(), e.getMessage()));
		}
		return transferencia;
	}
	
	/**
	 * @param request
	 * @param response
	 * @return - Retorna a la vista JSP.
	 */
	@RequestMapping(value = "/listarTarifaBoleto", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<TarifaBoletoBean> listarTarifaBoleto(HttpServletRequest request, HttpServletResponse response) {
		List<TarifaBoletoBean> lista = null;
		try {			
			TarifaBoletoBean boleto = new TarifaBoletoBean();
			// Copia los parametros del cliente al objeto
			BeanUtils.populate(boleto, request.getParameterMap());
			lista = iCompraService.listarBoletos(boleto);
		} catch (Exception e) {
			log.error(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(),
									  Constantes.NIVEL_APP_CONSTROLLER, 
									  this.getClass().getName(), e.getMessage()));
		}
		return lista;
	}
	
	/**
	 * @param request
	 * @param response
	 * @return - Retorna a la vista JSP.
	 */
	@RequestMapping(value = "/listarSucursal", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<SucursalBean> listarSucursal(HttpServletRequest request, HttpServletResponse response) {
		List<SucursalBean> lista = null;
		try {			
			SucursalBean sucursal = new SucursalBean();
			// Copia los parametros del cliente al objeto
			BeanUtils.populate(sucursal, request.getParameterMap());
			lista = iMaestroService.listarSucursal(sucursal);
		} catch (Exception e) {
			log.error(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(),
									  Constantes.NIVEL_APP_CONSTROLLER, 
									  this.getClass().getName(), e.getMessage()));
		}
		return lista;
	}	
	
	/**
	 * @param request
	 * @param response
	 * @return - Retorna a la vista JSP.
	 */
	@RequestMapping(value = "/listarSerieNum", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<SeriesBean> listarSerieNum(HttpServletRequest request, HttpServletResponse response) {
		List<SeriesBean> lista = null;
		try {			
			SeriesBean series = new SeriesBean();
			// Copia los parametros del cliente al objeto
			BeanUtils.populate(series, request.getParameterMap());
			lista = iMaestroService.listarSerieNum(series);
		} catch (Exception e) {
			log.error(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(),
									  Constantes.NIVEL_APP_CONSTROLLER, 
									  this.getClass().getName(), e.getMessage()));
		}
		return lista;
	}	
	/**
	 * @param request
	 * @param response
	 * @return Retorna el codigo de la tabla de compra.
	 */
	@RequestMapping(value = "/grabarNotaCredito", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public Integer grabarNotaCredito(HttpServletRequest request, HttpServletResponse response) {
		Integer codigo = null;
		try {
			ComprasIngresosBean com_ingreso = new ComprasIngresosBean();		
			
			// Copia los parametros del cliente al objeto
			BeanUtils.populate(com_ingreso, request.getParameterMap());
			
			DetalleComprasBean det_compras = null;
			DetalleIngresosBean det_ingresos = null;
			
			// Retorno los datos de session
			usuarioBean = (UsuarioBean) context().getAttribute("usuarioBean", RequestAttributes.SCOPE_SESSION);
			com_ingreso.setVnomusuario(usuarioBean.getDes_usuario());
			
			String partida = request.getParameter("cod_partida");
			String importe = request.getParameter("importe");
			String tip_venta = request.getParameter("cod_tip_venta");			
			String imp_afecto = request.getParameter("imp_afecto");
			String imp_no_afecto = request.getParameter("imp_no_afecto");
			String imp_igv = request.getParameter("imp_igv");
			String imp_isc = request.getParameter("imp_isc");
						
			if (com_ingreso.getInt_transaccion() == 1) { // Compras
				
				String cue_contable = request.getParameter("cod_cue_con");

				det_compras = new DetalleComprasBean();
				det_compras.setCod_especifica(getLong(partida));
				det_compras.setCod_cuenta(getInteger(cue_contable));
				det_compras.setNum_imp_servicio(getBigDecimal(importe));
				det_compras.setCod_tip_venta(tip_venta);				
				det_compras.setNum_imp_afecto(getBigDecimal(imp_afecto));
				det_compras.setNum_imp_no_afecto(getBigDecimal(imp_no_afecto));
				det_compras.setNum_imp_igv(getBigDecimal(imp_igv));
				det_compras.setNum_imp_isc(getBigDecimal(imp_isc));				
				det_compras.setVnomusuario(usuarioBean.getDes_usuario());
	
			} else if (com_ingreso.getInt_transaccion() == 2) { // Ingresos
				
				String cod_tip_transaccion = request.getParameter("cod_tip_transaccion");				
				String dias = request.getParameter("dias"); 
				String cantidad = request.getParameter("cantidad");
				String pre_unitario = request.getParameter("pre_unitario");
				String num_ini_boleto = request.getParameter("num_ini_boleto");
				
				det_ingresos = new DetalleIngresosBean();
				det_ingresos.setTip_transaccion(cod_tip_transaccion);					
				det_ingresos.setCan_dias(getInteger(dias));
				//det_ingresos.setCan_producto(getInteger(cantidad));	
				det_ingresos.setCan_producto(getBigDecimal(cantidad));
				det_ingresos.setNum_pre_unitario(getBigDecimal(pre_unitario));
				det_ingresos.setIni_boleto(getInteger(num_ini_boleto));					
				det_ingresos.setCod_especifica(getInteger(partida));
				det_ingresos.setCod_tip_venta(tip_venta);				
				det_ingresos.setNum_imp_afecto(getBigDecimal(imp_afecto));
				det_ingresos.setNum_imp_no_afecto(getBigDecimal(imp_no_afecto));
				det_ingresos.setNum_imp_igv(getBigDecimal(imp_igv));
				det_ingresos.setNum_imp_isc(getBigDecimal(imp_isc));	
				det_ingresos.setVnomusuario(usuarioBean.getDes_usuario());
			}
			
			codigo = iCompraService.grabarNotaCredito(com_ingreso, det_compras, det_ingresos);
			
		} catch (Exception e) {
			log.error(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(),
					  Constantes.NIVEL_APP_CONSTROLLER, 
					  this.getClass().getName(), e.getMessage()));
		}
		return codigo;
	}
	
	/**
	 * Metodo que retorna a la Bandeja Reportes Compras.
	 * @return - Retorna a la vista JSP.
	 */
	@RequestMapping("/reporteCompras")
    public ModelAndView reporteCompras() {
		ModelAndView model = new ModelAndView("lis_rep_compras");	
		try {
			// Retorno los datos de session
			usuarioBean = (UsuarioBean) context().getAttribute("usuarioBean", RequestAttributes.SCOPE_SESSION);
			
			String ind_sed_principal = null;			
			// Consultamos si el usuario es de Sede Central
			List<UnidadOperativaBean> lis_uni_ope_principal = new ArrayList<UnidadOperativaBean>();
			lis_uni_ope_principal = iMaestroService.verificarSedePrincipal(usuarioBean.getCod_usuario());
			if (!isEmpty(lis_uni_ope_principal)) {
				ind_sed_principal = "1";
			} else {
				ind_sed_principal = "0";
			}			
			model.addObject("ind_sed_principal", ind_sed_principal);
			
			List<UnidadOperativaBean> lis_uni_operativa = new ArrayList<UnidadOperativaBean>();	
			if (!isEmpty(lis_uni_ope_principal)) {
				lis_uni_operativa = iMaestroService.listarUnidadOperativa(new UnidadOperativaBean());
			} else {
				lis_uni_operativa = iMaestroService.listarUnidadOperativa(new UnidadOperativaBean(usuarioBean.getCod_usuario()));
			}			
			model.addObject("lis_uni_operativa", lis_uni_operativa);
		} catch (Exception e) {
			log.error(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(),
									  Constantes.NIVEL_APP_CONSTROLLER, 
									  this.getClass().getName(), e.getMessage()));
		}		
		return model;
    }
	
	/**
	 * @param request
	 * @param response
	 * @return - Retorna a la vista JSP.
	 */
	@RequestMapping(value = "/listarReporteCompras", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<ReporteDetalleComprasBean> listarReporteCompras(HttpServletRequest request, HttpServletResponse response) {
		List<ReporteDetalleComprasBean> lista = null;
		try {			
			ComprasIngresosBean ingreso = new ComprasIngresosBean();
			// Copia los parametros del cliente al objeto
			BeanUtils.populate(ingreso, request.getParameterMap());
			lista = iCompraService.listarReporteCompras(ingreso);
		} catch (Exception e) {
			log.error(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(),
									  Constantes.NIVEL_APP_CONSTROLLER, 
									  this.getClass().getName(), e.getMessage()));
		}
		return lista;
	}
	
	/**
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/imprimirReporteCompras", method = RequestMethod.GET)
	public void imprimirReporteCompras(HttpServletRequest request, HttpServletResponse response) {
	    try {
	    	String fil_busqueda = request.getParameter("fil_busqueda");
	    	String[] arr_busqueda = fil_busqueda.split(Constantes.UNDERLINE);
	    	
	    	ComprasIngresosBean compra = new ComprasIngresosBean();
	    	compra.setInt_transaccion(getInteger(arr_busqueda[0]));	    	
	    	compra.setCod_uni_operativa(getInteger(arr_busqueda[1]));
	    	compra.setCod_reg_nac(getInteger(arr_busqueda[2]));
	    	compra.setNum_ruc(getLong(arr_busqueda[3]));
	    	compra.setFec_inicio(arr_busqueda[4]);
	    	compra.setFec_final(arr_busqueda[5]);
	    	compra.setTip_operacion(arr_busqueda[6]);
	    	compra.setCod_servicio(getInteger(arr_busqueda[7]));
	    	compra.setNro_doc_rc(arr_busqueda[8]);
	    	compra.setNro_cp(arr_busqueda[9]);
	    	compra.setDes_uni_operativa(arr_busqueda[10]);
	    	compra.setDes_reg_nac(arr_busqueda[11]);
	    	compra.setCod_mes(getInteger(arr_busqueda[13]));
	    	compra.setCod_anno(getInteger(arr_busqueda[14]));
	    	
			List<ReporteDetalleComprasBean> lista = iCompraService.listarReporteCompras(compra);
			
			String file_name = "Reporte_Compras";
			if (getInteger(arr_busqueda[12]) == 1) { // Indicador PDF
				ServletContext servletContext = request.getSession().getServletContext();
			    File tempDirectory = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
			    String temperotyFilePath = tempDirectory.getAbsolutePath();
				
				file_name = file_name.concat(Constantes.EXTENSION_FORMATO_PDF);
				response.setContentType(Constantes.MIME_APPLICATION_PDF);
			    response.setHeader("Content-disposition", "attachment; filename=" + file_name);
			    
			    String ruta = temperotyFilePath + "\\" + file_name;
		    	Reporteador rep = new Reporteador();
		    	rep.generaPDFReporteCompras(ruta, compra, lista);

		        ByteArrayOutputStream baos = new ByteArrayOutputStream();
		        baos = convertPDFToByteArrayOutputStream(temperotyFilePath + "\\" + file_name);
		        OutputStream os = response.getOutputStream();
		        baos.writeTo(os);
		        os.flush();
		        
			} else { // Indicador Excel				
				file_name = file_name.concat(Constantes.EXTENSION_FORMATO_XLS);
	            response.setContentType(Constantes.MIME_APPLICATION_XLS);
	            response.setHeader("Content-Disposition", "attachment; filename=" + file_name);				
			    Reporteador rep = new Reporteador();
		    	rep.generaExcelReporteCompras(response, compra, lista);
			}
	    	
	    } catch (Exception e) {
	    	log.error(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(),
					  Constantes.NIVEL_APP_CONSTROLLER, 
					  this.getClass().getName(), e.getMessage()));
	    } 
	}
	
	/**
	 * Metodo que retorna a la Bandeja Reportes Ingresos.
	 * @return - Retorna a la vista JSP.
	 */
	@RequestMapping("/reporteIngresos")
    public ModelAndView reporteIngresos() {
		ModelAndView model = new ModelAndView("lis_rep_ingresos");	
		try {
			// Retorno los datos de session
			usuarioBean = (UsuarioBean) context().getAttribute("usuarioBean", RequestAttributes.SCOPE_SESSION);
			
			String ind_sed_principal = null;			
			// Consultamos si el usuario es de Sede Central
			List<UnidadOperativaBean> lis_uni_ope_principal = new ArrayList<UnidadOperativaBean>();
			lis_uni_ope_principal = iMaestroService.verificarSedePrincipal(usuarioBean.getCod_usuario());
			if (!isEmpty(lis_uni_ope_principal)) {
				ind_sed_principal = "1";
			} else {
				ind_sed_principal = "0";
			}			
			model.addObject("ind_sed_principal", ind_sed_principal);
			
			List<UnidadOperativaBean> lis_uni_operativa = new ArrayList<UnidadOperativaBean>();	
			if (!isEmpty(lis_uni_ope_principal)) {
				lis_uni_operativa = iMaestroService.listarUnidadOperativa(new UnidadOperativaBean());
			} else {
				lis_uni_operativa = iMaestroService.listarUnidadOperativa(new UnidadOperativaBean(usuarioBean.getCod_usuario()));
			}			
			model.addObject("lis_uni_operativa", lis_uni_operativa);			
			
			List<MediosPagosBean> lis_med_pago = new ArrayList<MediosPagosBean>();		
			lis_med_pago = iMaestroService.listarMedioPago(new MediosPagosBean(Constantes.FLAG_ACTIVO));			
			model.addObject("lis_med_pago", lis_med_pago);
			
			List<TarifaServicioBean> lis_tar_servicio = new ArrayList<TarifaServicioBean>();		
			lis_tar_servicio = iCompraService.listarTarifaServicios(new TarifaServicioBean());
			model.addObject("lis_tar_servicio", lis_tar_servicio);
			
			List<ProductoBean> lis_productos = new ArrayList<ProductoBean>();		
			lis_productos = iCompraService.listarProductos(new ProductoBean());
			model.addObject("lis_productos", lis_productos);
			
			List<TarifaTupaBean> lis_tar_tupa = new ArrayList<TarifaTupaBean>();		
			lis_tar_tupa = iCompraService.listarTupas(new TarifaTupaBean());
			model.addObject("lis_tar_tupa", lis_tar_tupa);	
			
			List<DetalleOtrosBean> lis_otros = new ArrayList<DetalleOtrosBean>();		
			lis_otros = iCompraService.listarOtros(new DetalleOtrosBean());
			model.addObject("lis_otros", lis_otros);
			
			TarifaBoletoBean tar_boleto = new TarifaBoletoBean();
			tar_boleto.setCod_uni_operativa(lis_uni_operativa.get(0).getCod_uni_operativa());	
			
			UnidadOperativaBean unidad = new UnidadOperativaBean();
			unidad.setCod_uni_operativa(lis_uni_operativa.get(0).getCod_uni_operativa());
			unidad.setInd_uni_operativa(1);	
			
			List<UnidadOperativaBean> lis_anp = iMaestroService.listarUnidadOperativa(unidad);		
			model.addObject("lis_anp", lis_anp);
			
			tar_boleto.setCod_reg_nac(lis_anp.get(0).getCod_reg_nac());	
			
			List<TarifaBoletoBean> lis_tar_boletos = new ArrayList<TarifaBoletoBean>();		
			lis_tar_boletos = iCompraService.listarBoletos(tar_boleto);
			model.addObject("lis_tar_boletos", lis_tar_boletos);
			
		} catch (Exception e) {
			log.error(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(),
									  Constantes.NIVEL_APP_CONSTROLLER, 
									  this.getClass().getName(), e.getMessage()));
		}		
		return model;
    }
	
	/**
	 * @param request
	 * @param response
	 * @return - Retorna a la vista JSP.
	 */
	@RequestMapping(value = "/listarReporteIngresos", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<ReporteDetalleIngresosBean> listarReporteIngresos(HttpServletRequest request, HttpServletResponse response) {
		List<ReporteDetalleIngresosBean> lista = null;
		try {			
			ComprasIngresosBean ingreso = new ComprasIngresosBean();
			// Copia los parametros del cliente al objeto
			BeanUtils.populate(ingreso, request.getParameterMap());
			lista = iCompraService.listarReporteIngresos(ingreso);
		} catch (Exception e) {
			log.error(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(),
									  Constantes.NIVEL_APP_CONSTROLLER, 
									  this.getClass().getName(), e.getMessage()));
		}
		return lista;
	}
	
	/**
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/imprimirReporteIngresos", method = RequestMethod.GET)
	public void imprimirReporteIngresos(HttpServletRequest request, HttpServletResponse response) {
	    try {
	    	String fil_busqueda = request.getParameter("fil_busqueda");
	    	String[] arr_busqueda = fil_busqueda.split(Constantes.UNDERLINE);
	    	
	    	ComprasIngresosBean ingreso = new ComprasIngresosBean();
	    	ingreso.setInt_transaccion(getInteger(arr_busqueda[0]));	    	
	    	ingreso.setCod_uni_operativa(getInteger(arr_busqueda[1]));
	    	ingreso.setCod_reg_nac(getInteger(arr_busqueda[2]));
	    	ingreso.setNum_ruc(getLong(arr_busqueda[3]));
	    	ingreso.setFec_inicio(arr_busqueda[4]);
	    	ingreso.setFec_final(arr_busqueda[5]);
	    	ingreso.setTip_operacion(arr_busqueda[6]);
	    	ingreso.setTip_transaccion(arr_busqueda[7]);
	    	ingreso.setCod_servicio(getInteger(arr_busqueda[8]));
	    	ingreso.setDes_uni_operativa(arr_busqueda[9]);
	    	ingreso.setDes_reg_nac(arr_busqueda[10]);
	    	ingreso.setCod_mes(getInteger(arr_busqueda[12]));
	    	
			List<ReporteDetalleIngresosBean> lista = iCompraService.listarReporteIngresos(ingreso);
			
			String file_name = "Reporte_Ingresos";
			if (getInteger(arr_busqueda[11]) == 1) { // Indicador PDF
				ServletContext servletContext = request.getSession().getServletContext();
			    File tempDirectory = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
			    String temperotyFilePath = tempDirectory.getAbsolutePath();
				
				file_name = file_name.concat(Constantes.EXTENSION_FORMATO_PDF);
				response.setContentType(Constantes.MIME_APPLICATION_PDF);
			    response.setHeader("Content-disposition", "attachment; filename=" + file_name);
			    
			    String ruta = temperotyFilePath + "\\" + file_name;
		    	Reporteador rep = new Reporteador();
		    	rep.generaPDFReporteIngresos(ruta, ingreso, lista);

		        ByteArrayOutputStream baos = new ByteArrayOutputStream();
		        baos = convertPDFToByteArrayOutputStream(temperotyFilePath + "\\" + file_name);
		        OutputStream os = response.getOutputStream();
		        baos.writeTo(os);
		        os.flush();				
			} else { // Indicador Excel				
				file_name = file_name.concat(Constantes.EXTENSION_FORMATO_XLS);
	            response.setContentType(Constantes.MIME_APPLICATION_XLS);
	            response.setHeader("Content-Disposition", "attachment; filename=" + file_name);
			    Reporteador rep = new Reporteador();
		    	rep.generaExcelReporteIngresos(response, ingreso, lista);
			}
	    	
	    } catch (Exception e) {
	    	log.error(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(),
					  Constantes.NIVEL_APP_CONSTROLLER, 
					  this.getClass().getName(), e.getMessage()));
	    } 
	}
	
	/**
	 * @param request
	 * @param response
	 * @return - Retorna a la vista JSP.
	 */
	@RequestMapping(value = "/guardarImagen", method = RequestMethod.POST)
	@ResponseBody
	public String guardarImagen(MultipartHttpServletRequest request, HttpServletResponse response) {
		String imagen = null;
		try {			
			StringBuilder path = new StringBuilder();
			path.append(getPath(request));
			path.append(File.separator);
			path.append("resources");
			path.append(File.separator);
			path.append(ReadParameterProperties.getPropiedad("carpeta.imagen"));
			
			Iterator<String> itr =  request.getFileNames();
			MultipartFile mpf = request.getFile(itr.next());
			
			
			StringBuilder file_name = new StringBuilder();
			int pos_file_name = mpf.getOriginalFilename().lastIndexOf(".");
			file_name.append(mpf.getOriginalFilename().substring(0, pos_file_name));
			file_name.append(Constantes.UNDERLINE);
			file_name.append(Calendar.getInstance().getTime().getTime());
			file_name.append(mpf.getOriginalFilename().substring(pos_file_name));
			
			
			StringBuilder file_image = new StringBuilder();
			file_image.append(path.toString());
			file_image.append(File.separator);
			file_image.append(file_name.toString());
			
			mpf.transferTo(new File(file_image.toString()));
			
			imagen = file_name.toString();
		} catch (Exception e) {
			log.error(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(),
									  Constantes.NIVEL_APP_CONSTROLLER, 
									  this.getClass().getName(), e.getMessage()));
		}
		return imagen;
	}
	
	/**
	 * @param request
	 * @param response 
	 * @return - Retorna a la vista JSP.
	 * @throws Exception
	 */
	@RequestMapping(value = "/obtenerImagen", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
    public HashMap<String, Object> obtenerImagen(HttpServletRequest request, HttpServletResponse response) throws Exception {
    /*
        MultipartFile multipartFile = request.getFile("file");
        Long size = multipartFile.getSize();
        String contentType = multipartFile.getContentType();
        InputStream stream = multipartFile.getInputStream();*/
		
		String name = request.getParameter("file_name");
		int pos_file_name = name.lastIndexOf(".");  
		
		StringBuilder path = new StringBuilder();
		path.append(System.getProperty("catalina.base"));
		path.append(File.separator);
		path.append(ReadParameterProperties.getPropiedad("carpeta.imagen"));

		StringBuilder file_image = new StringBuilder();
		file_image.append(path.toString());
		file_image.append(File.separator);
		file_image.append(name);
		

		/*InputStream stream = new FileInputStream(file_image.toString());

        byte[] bytes = IOUtils.toByteArray(stream);
        
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        int b;
        while ((b = stream.read()) != -1) {
            os.write(b);
        }*/
    
        HashMap<String, Object> map = new HashMap<String, Object>();
        //map.put("fileoriginalsize", os.size());
        map.put("contenttype", name.substring(pos_file_name));
        //map.put("base64", new String(Base64Utils.encode(bytes)));
    
        return map;
    }
	
	/**
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/generarArchivoPlameps4", method = RequestMethod.GET, produces = "text/plain")
	public void generarArchivoPlameps4(HttpServletRequest request, HttpServletResponse response) {
		try {
	    	String fil_busqueda = request.getParameter("fil_busqueda");
	    	String[] arr_busqueda = fil_busqueda.split(Constantes.UNDERLINE);

	    	ComprasIngresosBean com_ingresos = new ComprasIngresosBean();
	    	com_ingresos.setInt_transaccion(getInteger(arr_busqueda[0]));	    	
	    	com_ingresos.setCod_uni_operativa(getInteger(arr_busqueda[1]));
	    	com_ingresos.setCod_reg_nac(getInteger(arr_busqueda[2]));
	    	com_ingresos.setNum_ruc(getLong(arr_busqueda[3]));
	    	com_ingresos.setFec_inicio(arr_busqueda[4]);
	    	com_ingresos.setFec_final(arr_busqueda[5]);
	    	com_ingresos.setTip_operacion(arr_busqueda[6]);
    		com_ingresos.setCod_servicio(getInteger(arr_busqueda[7]));
    		com_ingresos.setNro_doc_rc(arr_busqueda[8]);
    		com_ingresos.setNro_cp(arr_busqueda[9]);
    		com_ingresos.setDes_uni_operativa(arr_busqueda[10]);
    		com_ingresos.setDes_reg_nac(arr_busqueda[11]);
    		com_ingresos.setCod_mes(getInteger(arr_busqueda[12]));	    
    		com_ingresos.setCod_anno(getInteger(arr_busqueda[13]));
	    	
			List<ComprasIngresosBean> lis_compra = iCompraService.listarDatosPs4(com_ingresos);
		
			StringBuilder content = new StringBuilder();
			int row = 1;
			for (ComprasIngresosBean compra : lis_compra) {
							
				content.append(StringUtils.leftPad(Constantes.SIX_STRING, 2, '0'));
				content.append(Constantes.PIPELINE);
	
				content.append(getString(compra.getNro_ruc()));
				content.append(Constantes.PIPELINE);
				
				content.append(getString(compra.getApe_paterno()));
				content.append(Constantes.PIPELINE);
				
				content.append(getString(compra.getApe_materno()));
				content.append(Constantes.PIPELINE);
				
				content.append(getString(compra.getNombres()));
				content.append(Constantes.PIPELINE);
				
				content.append(compra.getTip_sexo());
				content.append(Constantes.PIPELINE);
				
				content.append(compra.getInd_es_salud());
				content.append(Constantes.PIPELINE);
			
				if (row < lis_compra.size()) {	    			
    				content.append(Constantes.SALTO_LINEA);
    			}
				
				row++;
			}
			
		    StringBuilder file_name = new StringBuilder();
		    file_name.append("0601");
		    file_name.append(DateUtil.getAnioActual());
		    file_name.append(StringUtils.leftPad(arr_busqueda[12], 2, '0'));
		    file_name.append("20478053178"); // RUC de la empresa
		    file_name.append(Constantes.EXTENSION_FORMATO_PS4);		    
		    
            response.setContentType(Constantes.MIME_APPLICATION_TXT);
            response.setHeader("Content-Disposition", "attachment; filename=" + file_name.toString());
            
            ServletOutputStream out = response.getOutputStream();
            out.println(content.toString());
		    out.flush();
		    out.close();
			
		} catch (Exception e) {
	    	log.error(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(),
					  Constantes.NIVEL_APP_CONSTROLLER, 
					  this.getClass().getName(), e.getMessage()));
	    } 
	}
	
	/**
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/generarArchivoPlame4ta", method = RequestMethod.GET, produces = "text/plain")
	public void generarArchivoPlame4ta(HttpServletRequest request, HttpServletResponse response) {
		try {
			String fil_busqueda = request.getParameter("fil_busqueda");
	    	String[] arr_busqueda = fil_busqueda.split(Constantes.UNDERLINE);

	    	ComprasIngresosBean com_ingresos = new ComprasIngresosBean();
	    	com_ingresos.setInt_transaccion(getInteger(arr_busqueda[0]));	    	
	    	com_ingresos.setCod_uni_operativa(getInteger(arr_busqueda[1]));
	    	com_ingresos.setCod_reg_nac(getInteger(arr_busqueda[2]));
	    	com_ingresos.setNum_ruc(getLong(arr_busqueda[3]));
	    	com_ingresos.setFec_inicio(arr_busqueda[4]);
	    	com_ingresos.setFec_final(arr_busqueda[5]);
	    	com_ingresos.setTip_operacion(arr_busqueda[6]);
    		com_ingresos.setCod_servicio(getInteger(arr_busqueda[7]));
    		com_ingresos.setNro_doc_rc(arr_busqueda[8]);
    		com_ingresos.setNro_cp(arr_busqueda[9]);
    		com_ingresos.setDes_uni_operativa(arr_busqueda[10]);
    		com_ingresos.setDes_reg_nac(arr_busqueda[11]);
    		com_ingresos.setCod_mes(getInteger(arr_busqueda[12]));
    		com_ingresos.setCod_anno(getInteger(arr_busqueda[13]));
	    	
			List<ComprasIngresosBean> lis_compra = iCompraService.listarDatos4ta(com_ingresos);
		
			StringBuilder content = new StringBuilder();
			int row = 1;
			for (ComprasIngresosBean compra : lis_compra) {
							
				content.append(StringUtils.leftPad(Constantes.SIX_STRING, 2, '0'));
				content.append(Constantes.PIPELINE);
	
				content.append(getString(compra.getNro_ruc()));
				content.append(Constantes.PIPELINE);
				
				content.append(compra.getVcod_comprobante());
				content.append(Constantes.PIPELINE);
				
				content.append(compra.getSer_comprobante());
				content.append(Constantes.PIPELINE);
				
				content.append(compra.getNro_comprobante());
				content.append(Constantes.PIPELINE);
				
				content.append(getString(compra.getImp_total()));
				content.append(Constantes.PIPELINE);
				
				content.append(compra.getFec_comprobante());
				content.append(Constantes.PIPELINE);
				
				content.append(getString(compra.getFec_pago()));
				content.append(Constantes.PIPELINE);
				
				content.append(compra.getInd_retencion());
				content.append(Constantes.PIPELINE);
				
				content.append(Constantes.PIPELINE);
				
				content.append(Constantes.PIPELINE);
			
				if (row < lis_compra.size()) {	    			
    				content.append(Constantes.SALTO_LINEA);
    			}
				
				row++;
			}			
		    
		    StringBuilder file_name = new StringBuilder();
		    file_name.append("0601");
		    file_name.append(DateUtil.getAnioActual());
		    file_name.append(StringUtils.leftPad(arr_busqueda[12], 2, '0'));
		    file_name.append("20478053178"); // RUC de la empresa
		    file_name.append(Constantes.EXTENSION_FORMATO_4TA);    
		    
            response.setContentType(Constantes.MIME_APPLICATION_TXT);
            response.setHeader("Content-Disposition", "attachment; filename=" + file_name);

            ServletOutputStream out = response.getOutputStream();
            out.println(content.toString());
            out.flush();
            out.close();
			
		} catch (Exception e) {
	    	log.error(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(),
					  Constantes.NIVEL_APP_CONSTROLLER, 
					  this.getClass().getName(), e.getMessage()));
	    } 
	}
	
	/**
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/generarArchivoPle", method = RequestMethod.GET, produces = "text/plain")
	public void generarArchivoPle(HttpServletRequest request, HttpServletResponse response) {
		try {
	    	String fil_busqueda = request.getParameter("fil_busqueda");
	    	String[] arr_busqueda = fil_busqueda.split(Constantes.UNDERLINE);
	    	
	    	StringBuilder file_name = new StringBuilder();
	    	StringBuilder content = new StringBuilder();
	    	DecimalFormatSymbols other_symbols = new DecimalFormatSymbols(Locale.US);
            DecimalFormat dec_form = new DecimalFormat(Constantes.EXPRESION_MONEDA_DECIMAL, other_symbols);
            int row = 1;
            
	    	int ind_transaccion = getInteger(arr_busqueda[0]);
	    	ComprasIngresosBean com_ingresos = new ComprasIngresosBean();
	    	com_ingresos.setInt_transaccion(ind_transaccion);	    	
	    	com_ingresos.setCod_uni_operativa(getInteger(arr_busqueda[1]));
	    	com_ingresos.setCod_reg_nac(getInteger(arr_busqueda[2]));
	    	com_ingresos.setNum_ruc(getLong(arr_busqueda[3]));
	    	com_ingresos.setFec_inicio(arr_busqueda[4]);
	    	com_ingresos.setFec_final(arr_busqueda[5]);
	    	com_ingresos.setTip_operacion(arr_busqueda[6]);
	    	if (ind_transaccion == Constantes.ONE_INT) { // Reporte de Compras
	    		com_ingresos.setCod_servicio(getInteger(arr_busqueda[7]));
	    		com_ingresos.setNro_doc_rc(arr_busqueda[8]);
	    		com_ingresos.setNro_cp(arr_busqueda[9]);
	    		com_ingresos.setDes_uni_operativa(arr_busqueda[10]);
	    		com_ingresos.setDes_reg_nac(arr_busqueda[11]);
	    		com_ingresos.setCod_mes(getInteger(arr_busqueda[12]));
	    		com_ingresos.setCod_anno(getInteger(arr_busqueda[13]));
	    	} else { // Reporte de Ventas
	    		com_ingresos.setTip_transaccion(arr_busqueda[7]);
	    		com_ingresos.setCod_servicio(getInteger(arr_busqueda[8]));
	    		com_ingresos.setDes_uni_operativa(arr_busqueda[9]);
	    		com_ingresos.setDes_reg_nac(arr_busqueda[10]);
	    		com_ingresos.setCod_mes(getInteger(arr_busqueda[11]));
	    		com_ingresos.setCod_anno(getInteger(arr_busqueda[12]));
	    	}
	    	com_ingresos.setInd_gen_archivo(Constantes.ONE_INT);
	    	
	    	if (ind_transaccion == Constantes.ONE_INT) { // Reporte de Compras
	    		List<ReporteDetalleComprasBean> lis_compra = iCompraService.listarReporteCompras(com_ingresos);
	    		int cod_periodo = getInteger(arr_busqueda[12]);
	    		int anio = DateUtil.getAnioActual();
	    		for (ReporteDetalleComprasBean rep_compra : lis_compra) {
	    			String mes = rep_compra.getFec_comprobante().substring(3, 5);
	    			int ani_com = getInteger(rep_compra.getFec_comprobante().substring(6));
	    			String periodo = String.valueOf(anio).concat(StringUtils.leftPad(String.valueOf(cod_periodo), 2, '0'));	    	
	    			//Columna 1
	    			content.append(StringUtils.rightPad(periodo, 8, '0')); // Periodo
	    			content.append(Constantes.PIPELINE);
	    			//Columna 2
	    			content.append(StringUtils.rightPad(Constantes.EMPTY, 4, '0'));
	    			content.append(Constantes.PIPELINE);
	    			//Columna 3
	    			content.append("M".concat(String.valueOf(row)));
	    			content.append(Constantes.PIPELINE);
	    			//Columna 4
	    			content.append(rep_compra.getFec_comprobante());
	    			content.append(Constantes.PIPELINE);
	    			//Columna 5
	    			content.append(getString(rep_compra.getFec_vencimiento()));
	    			content.append(Constantes.PIPELINE);
	    			//Columna 6
	    			content.append(rep_compra.getVcod_comprobante());
	    			content.append(Constantes.PIPELINE);
	    			//Columna 7
	    			content.append(rep_compra.getSer_comprobante());
	    			content.append(Constantes.PIPELINE);
	      			
	    			// Nulo //Columna 8
	    			content.append(Constantes.PIPELINE);
	    			//Columna 9
	    			content.append(StringUtils.stripStart(rep_compra.getNro_comprobante(), Constantes.ZERO_STRING));
	    			content.append(Constantes.PIPELINE);
	    			// Nulo //Columna 10
	    			// content.append(rep_compra.getTip_doc_proveedor());
	    			content.append(Constantes.PIPELINE);
	    			//Columna 11
	    			if (!isNullOrEmpty(rep_compra.getTip_documento())) {
	    				content.append(getInteger(rep_compra.getTip_documento()));
	    			}
	    			content.append(Constantes.PIPELINE);
	    			//Columna 12
	    			content.append(getString(rep_compra.getRuc_nro_doc_prov()));
	    			content.append(Constantes.PIPELINE);
	    			//Columna 13
	    			content.append(getString(rep_compra.getRaz_soc_prov()));
	    			content.append(Constantes.PIPELINE);
	    			
	    			// Nulo //Columna 14
	    			content.append(Constantes.PIPELINE);
	    			// Nulo //Columna 15
	    			content.append(Constantes.PIPELINE);
	    			
	    			//Columna 16
	    			BigDecimal imp_afecto = rep_compra.getNum_imp_afecto();
			        if (rep_compra.getCod_comprobante().equals(Constantes.EIGHT_INT) && // Nota de Credito
			        		imp_afecto.compareTo(BigDecimal.ZERO) == 1) {
			        	imp_afecto = imp_afecto.negate();
			        }	    			
	    			content.append(imp_afecto);
	    			content.append(Constantes.PIPELINE);
	    			
	    			//Columna 17
	    			BigDecimal imp_igv = rep_compra.getNum_imp_igv();
			        if (rep_compra.getCod_comprobante().equals(Constantes.EIGHT_INT) && // Nota de Credito
			        		imp_igv.compareTo(BigDecimal.ZERO) == 1) {
			        	imp_igv = imp_igv.negate();
			        }
	    			content.append(imp_igv);
	    			content.append(Constantes.PIPELINE);
	    			
	    			//Columna 18
	    			// Nulo
	    			content.append(Constantes.PIPELINE);
	    			//Columna 19
	    			// Nulo
	    			content.append(Constantes.PIPELINE);
	    				    			
	    			//Columna 20
	    			BigDecimal imp_no_afecto = rep_compra.getNum_imp_no_afecto();
			        if (rep_compra.getCod_comprobante().equals(Constantes.EIGHT_INT) && // Nota de Credito
			        		imp_no_afecto.compareTo(BigDecimal.ZERO) == 1) {
			        	imp_no_afecto = imp_no_afecto.negate();
			        }
	    			content.append(imp_no_afecto);
	    			content.append(Constantes.PIPELINE);
	    			
	    			//Columna 21
	    			BigDecimal imp_isc = rep_compra.getNum_imp_isc();
			        if (rep_compra.getCod_comprobante().equals(Constantes.EIGHT_INT) && // Nota de Credito
			        		imp_isc.compareTo(BigDecimal.ZERO) == 1) {
			        	imp_isc = imp_isc.negate();
			        }
	    			content.append(imp_isc);
	    			content.append(Constantes.PIPELINE);
	    			
	    			//Columna 22
	    			// Nulo
	    			content.append(Constantes.PIPELINE);
	    			
	    			//Columna 23
	    			BigDecimal imp_total = rep_compra.getImp_det_total();
			        if (rep_compra.getCod_comprobante().equals(Constantes.EIGHT_INT) && // Nota de Credito
			        		imp_total.compareTo(BigDecimal.ZERO) == 1) {
			        	imp_total = imp_total.negate();
			        }
	    			content.append(imp_total);
	    			content.append(Constantes.PIPELINE);
	    			
	    			//Columna 24
	    			content.append(getString(rep_compra.getSig_moneda()));
	    			content.append(Constantes.PIPELINE);
	    			
	    			//Columna 25
	    			String tip_cambio = null;	    			
	    			if (!isNull(rep_compra.getNum_tip_cambio())) {
	    				tip_cambio = dec_form.format(rep_compra.getNum_tip_cambio());
	    			} else {
	    				tip_cambio = "1.000"; // PEN
	    			}
	    			content.append(tip_cambio);
	    			content.append(Constantes.PIPELINE);
	    			//Columna 26
	    			content.append(getString(rep_compra.getFec_com_not_cre()));
	    			content.append(Constantes.PIPELINE);
	    			//Columna 27
	    			content.append(getString(rep_compra.getTip_com_not_cre()));
	    			content.append(Constantes.PIPELINE);
	    			//Columna 28
	    			content.append(getString(rep_compra.getSer_com_not_cre()));
	    			content.append(Constantes.PIPELINE);
	    			//Columna 29
	    			// Nulo
	    			content.append(Constantes.PIPELINE);
	    			//Columna 30
	    			content.append(StringUtils.stripStart(getString(rep_compra.getNro_com_not_cre()), Constantes.ZERO_STRING));
	    			content.append(Constantes.PIPELINE);
	    			//Columna 31
	    			content.append(getString(rep_compra.getFec_pag_deposito()));
	    			content.append(Constantes.PIPELINE);
	    			//Columna 32
	    			content.append(getString(rep_compra.getNum_constancia()));
	    			content.append(Constantes.PIPELINE);
	    			//Columna 33
	    			content.append(getString(rep_compra.getInd_cp_reten()));
	    			content.append(Constantes.PIPELINE);
	    			//Columna 34
	    			// Nulo
	    			content.append(Constantes.PIPELINE);
	    			//Columna 35
	    			// Nulo
	    			content.append(Constantes.PIPELINE);
	    			//Columna 36
	    			// Nulo
	    			content.append(Constantes.PIPELINE);
	    			//Columna 37
	    			// Nulo
	    			content.append(Constantes.PIPELINE);
	    			//Columna 38
	    			// Nulo
	    			content.append(Constantes.PIPELINE);
	    			//Columna 39
	    			// Nulo
	    			content.append(Constantes.PIPELINE);
	    			//Columna 40
	    			// Nulo
	    			content.append(Constantes.PIPELINE);
	    			
	    			//Columna 41
	    			
	    			if (anio == ani_com && getInteger(mes) == cod_periodo) {
	    				content.append(Constantes.ONE_STRING);
	    			} else if (anio == ani_com && getInteger(mes) < cod_periodo) {
	    				content.append(Constantes.SIX_STRING);
	    			} else {
	    				content.append(Constantes.SIX_STRING);
	    			}
	    			content.append(Constantes.PIPELINE);
	    			
	    			if (row < lis_compra.size()) {	    			
	    				content.append(Constantes.SALTO_LINEA);
	    			}
	    			
	    			row++;
	    		}
	    		
	    		
	    		file_name.append("LE");
	    		file_name.append("20478053178"); // RUC de la empresa
			    file_name.append(DateUtil.getAnioActual());
			    file_name.append(StringUtils.leftPad(arr_busqueda[12], 2, '0'));
			    file_name.append("00");			    
			    file_name.append("080100");
			    file_name.append("00");
			    file_name.append("1");
			    file_name.append("1");
			    file_name.append("1");
			    file_name.append("1");
			    file_name.append(Constantes.EXTENSION_FORMATO_TXT);			    
	    		
	    	} else { // Reporte de Ventas
	    		List<ReporteDetalleIngresosBean> lis_ingreso = iCompraService.listarReporteIngresos(com_ingresos);
	    		
	    		ComprasIngresosBean ing_not_cre = com_ingresos;
	    		ing_not_cre.setInd_not_credito(Constantes.ONE_INT);
	    		List<ComprasIngresosBean> lis_ing_not_cre = iCompraService.listarCompras(ing_not_cre);
	    		String mes = StringUtils.leftPad(arr_busqueda[11], 2, '0');
	    		for (ReporteDetalleIngresosBean rep_ingreso : lis_ingreso) {
	    			String anio = rep_ingreso.getFec_comprobante().substring(6);
	    			String periodo = anio.concat(mes);
	    			//Columna 1
	    			content.append(StringUtils.rightPad(periodo, 8, '0')); // Periodo
	    			content.append(Constantes.PIPELINE);
	    			//Columna 2
	    			content.append(StringUtils.rightPad(Constantes.EMPTY, 4, '0'));
	    			content.append(Constantes.PIPELINE);
	    			//Columna 3
	    			content.append("M".concat(String.valueOf(row)));
	    			content.append(Constantes.PIPELINE);
	    			//Columna 4
	    			content.append(rep_ingreso.getFec_comprobante());
	    			content.append(Constantes.PIPELINE);
	    			//Columna 5
	    			content.append(getString(rep_ingreso.getFec_vto()));
	    			content.append(Constantes.PIPELINE);
	    			//Columna 6
	    			content.append(rep_ingreso.getVcod_comprobante());
	    			content.append(Constantes.PIPELINE);
	    			//Columna 7
	    			content.append(rep_ingreso.getSer_comprobante());
	    			content.append(Constantes.PIPELINE);
	    			//Columna 8
	    			content.append(StringUtils.stripStart(getString(rep_ingreso.getNro_comprobante()), Constantes.ZERO_STRING));
	    			content.append(Constantes.PIPELINE);
	    			
	    			// Nulo - //Columna 9
	    			content.append(Constantes.PIPELINE);
	    			//Columna 10
	    			content.append(rep_ingreso.getCod_tip_doc_proveedor());
	    			content.append(Constantes.PIPELINE);
	    			//Columna 11
	    			content.append(getString(rep_ingreso.getRuc_nro_doc_prov()));
	    			content.append(Constantes.PIPELINE);
	    			//Columna 12
	    			content.append(getString(rep_ingreso.getRaz_soc_prov()));
	    			content.append(Constantes.PIPELINE);
	    			
	    			// Nulo - //Columna 13
	    			content.append(Constantes.PIPELINE);
	    			
	    			//Columna 14
	    			BigDecimal imp_afecto = rep_ingreso.getNum_imp_afecto();
			        if (rep_ingreso.getCod_comprobante().equals(Constantes.EIGHT_INT) && // Nota de Credito
			        		imp_afecto.compareTo(BigDecimal.ZERO) == 1) {
			        	imp_afecto = imp_afecto.negate();
			        }
	    			content.append(imp_afecto);
	    			content.append(Constantes.PIPELINE);
	    			
	    			
	    			// Nulo - //Columna 15
	    			content.append(Constantes.PIPELINE);
	    			
	    			//Columna 16
	    			BigDecimal imp_igv = rep_ingreso.getNum_imp_igv();
			        if (rep_ingreso.getCod_comprobante().equals(Constantes.EIGHT_INT) && // Nota de Credito
			        		imp_igv.compareTo(BigDecimal.ZERO) == 1) {
			        	imp_igv = imp_igv.negate();
			        }
	    			content.append(imp_igv);
	    			content.append(Constantes.PIPELINE);
	    			
	    			
	    			// Nulo //Columna 17
	    			content.append(Constantes.PIPELINE);	    		
	    			
	    			// Nulo //Columna 18
	    			content.append(Constantes.PIPELINE);	 
	    			
	    			//Columna 19
	    			BigDecimal imp_no_afe_tip_ven_no_gra = rep_ingreso.getImp_no_afe_tip_ven_no_gra();
			        if (rep_ingreso.getCod_comprobante().equals(Constantes.EIGHT_INT) && // Nota de Credito
			        		imp_no_afe_tip_ven_no_gra.compareTo(BigDecimal.ZERO) == 1) {
			        	imp_no_afe_tip_ven_no_gra = imp_no_afe_tip_ven_no_gra.negate();
			        }
	    			content.append(imp_no_afe_tip_ven_no_gra);
	    			content.append(Constantes.PIPELINE);
	    			
	    			
	    			// Nulo - //Columna 20
	    			content.append(Constantes.PIPELINE);
	    			
	    			// Nulo - //Columna 21
	    			content.append(Constantes.PIPELINE);
	    			
	    			// Nulo - //Columna 22
	    			content.append(Constantes.PIPELINE);
	    			
	    			// Nulo - //Columna 23
	    			content.append(Constantes.PIPELINE);
	    			
	    			//Columna 24
	    			BigDecimal imp_total = rep_ingreso.getImp_det_total();
			        if (rep_ingreso.getCod_comprobante().equals(Constantes.EIGHT_INT) && // Nota de Credito
			        		imp_total.compareTo(BigDecimal.ZERO) == 1) {
			        	imp_total = imp_total.negate();
			        }
	    			content.append(imp_total);
	    			content.append(Constantes.PIPELINE);
	    			//Columna 25
	    			content.append(getString(rep_ingreso.getSig_moneda()));
	    			content.append(Constantes.PIPELINE);
	    			//Columna 26
	    			String tip_cambio = null;	    			
	    			if (!isNull(rep_ingreso.getNum_tip_cambio())) {
	    				tip_cambio = dec_form.format(rep_ingreso.getNum_tip_cambio());
	    			} else {
	    				tip_cambio = "1.000"; // PEN
	    			}
	    			content.append(tip_cambio);
	    			content.append(Constantes.PIPELINE);
	    			//Columna 27
	    			content.append(val_not_cred(lis_ing_not_cre, rep_ingreso.getCod_pad_com_ingresos(), 3));
	    			content.append(Constantes.PIPELINE);
	    			//Columna 28
	    			content.append(val_not_cred(lis_ing_not_cre, rep_ingreso.getCod_pad_com_ingresos(), 4));
	    			content.append(Constantes.PIPELINE);
	    			//Columna 29
	    			content.append(val_not_cred(lis_ing_not_cre, rep_ingreso.getCod_pad_com_ingresos(), 1));
	    			content.append(Constantes.PIPELINE);
	    			//Columna 30
	    			content.append(val_not_cred(lis_ing_not_cre, rep_ingreso.getCod_pad_com_ingresos(), 2));
	    			content.append(Constantes.PIPELINE);
	    			
	    			// Nulo - Columna 31
	    			content.append(Constantes.PIPELINE);
	    			
	    			// Nulo - Columna 32
	    			content.append(Constantes.PIPELINE);
	    			
	    			// Nulo - Columna 33
	    			content.append(Constantes.PIPELINE);
	    			//Columna 34
	    			content.append(Constantes.ONE_INT);
	    			content.append(Constantes.PIPELINE);
	    			
	    			if (row < lis_ingreso.size()) {	    			
	    				content.append(Constantes.SALTO_LINEA);
	    			}
	    			
	    			row++;
	    		}
	    		
	    		
	    		file_name.append("LE");
	    		file_name.append("20478053178"); // RUC de la empresa
			    file_name.append(DateUtil.getAnioActual());
			    file_name.append(StringUtils.leftPad(arr_busqueda[11], 2, '0'));
			    file_name.append("00");			    
			    file_name.append("140100");
			    file_name.append("00");
			    file_name.append("1");
			    file_name.append("1");
			    file_name.append("1");
			    file_name.append("1");
			    file_name.append(Constantes.EXTENSION_FORMATO_TXT);
			    
	    	}
	    	
            response.setContentType(Constantes.MIME_APPLICATION_TXT);
            response.setHeader("Content-Disposition", "attachment; filename=" + file_name.toString());

		    ServletOutputStream out = response.getOutputStream();
		    out.println(content.toString());
		    out.flush();
		    out.close();
			
		} catch (Exception e) {
			log.error(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(),
					  Constantes.NIVEL_APP_CONSTROLLER, 
					  this.getClass().getName(), e.getMessage()));
	    } 
	}
	
	/**
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/generarArchivoCoa", method = RequestMethod.GET, produces = "text/plain")
	public void generarArchivoCoa(HttpServletRequest request, HttpServletResponse response) {
		try {
	    	String fil_busqueda = request.getParameter("fil_busqueda");
	    	String[] arr_busqueda = fil_busqueda.split(Constantes.UNDERLINE);
	    	
	    	StringBuilder content = new StringBuilder();            
            
	    	int ind_transaccion = getInteger(arr_busqueda[0]);
	    	ComprasIngresosBean com_ingresos = new ComprasIngresosBean();
	    	com_ingresos.setInt_transaccion(ind_transaccion);	    	
	    	com_ingresos.setCod_uni_operativa(getInteger(arr_busqueda[1]));
	    	com_ingresos.setCod_reg_nac(getInteger(arr_busqueda[2]));
	    	com_ingresos.setNum_ruc(getLong(arr_busqueda[3]));
	    	com_ingresos.setFec_inicio(arr_busqueda[4]);
	    	com_ingresos.setFec_final(arr_busqueda[5]);
	    	com_ingresos.setTip_operacion(arr_busqueda[6]);
    		com_ingresos.setCod_servicio(getInteger(arr_busqueda[7]));
    		com_ingresos.setNro_doc_rc(arr_busqueda[8]);
    		com_ingresos.setNro_cp(arr_busqueda[9]);
    		com_ingresos.setDes_uni_operativa(arr_busqueda[10]);
    		com_ingresos.setDes_reg_nac(arr_busqueda[11]);
    		com_ingresos.setCod_mes(getInteger(arr_busqueda[12]));
    		com_ingresos.setCod_anno(getInteger(arr_busqueda[13]));
    		com_ingresos.setInd_gen_archivo(Constantes.ONE_INT);

    		List<ReporteDetalleComprasBean> lis_compra = iCompraService.listarReporteCompras(com_ingresos);
    		String mes = StringUtils.leftPad(arr_busqueda[12], 2, '0');
    		int row = 1;
    		for (ReporteDetalleComprasBean rep_compra : lis_compra) {
    			
    			String dia = rep_compra.getFec_comprobante().substring(0, 2);
    			String anio = rep_compra.getFec_comprobante().substring(6);
    			String periodo = anio.concat(mes);	    			
    			
    			content.append(row);
    			content.append(Constantes.PIPELINE);
    			
    			content.append(getString(rep_compra.getRuc_nro_doc_prov()));
    			content.append(Constantes.PIPELINE);
    			
    			content.append(periodo); // Periodo
    			content.append(Constantes.PIPELINE);
    			
    			StringBuilder fec_com = new StringBuilder();
    			fec_com.append(mes);
    			fec_com.append(Constantes.DIVISOR);
    			fec_com.append(dia);
    			fec_com.append(Constantes.DIVISOR);
    			fec_com.append(anio);    			

    			content.append(fec_com.toString());
    			content.append(Constantes.PIPELINE);
    			
    			content.append(rep_compra.getVcod_comprobante());
    			content.append(Constantes.PIPELINE);
    			
    			content.append(rep_compra.getSer_comprobante());
    			content.append(Constantes.PIPELINE);

    			content.append(rep_compra.getNro_comprobante());
    			content.append(Constantes.PIPELINE);
    			//.toFixed(6)
    			content.append(rep_compra.getImp_det_total());
    			content.append(Constantes.PIPELINE);
    			
    			content.append(rep_compra.getNum_imp_igv());
    			content.append(Constantes.PIPELINE);
    		
    			content.append(rep_compra.getCod_adq_coa());
    			content.append(Constantes.PIPELINE);
    			
    			content.append(rep_compra.getTip_mon_coa());
    			content.append(Constantes.PIPELINE);
    			
    			content.append("000001");
    			
    			if (row < lis_compra.size()) {	    			
    				content.append(Constantes.SALTO_LINEA);
    			}
    			
    			row++;
    		}
    		
    		StringBuilder file_name = new StringBuilder();
    		file_name.append("20478053178"); // RUC de la empresa
    		file_name.append("001"); // Correlativo
		    file_name.append(DateUtil.getAnioActual());
		    file_name.append(StringUtils.leftPad(arr_busqueda[12], 2, '0'));
		    file_name.append(".01");
		    file_name.append(Constantes.EXTENSION_FORMATO_TXT);			    

	    	
            response.setContentType(Constantes.MIME_APPLICATION_TXT);
            response.setHeader("Content-Disposition", "attachment; filename=" + file_name.toString());

		    ServletOutputStream out = response.getOutputStream();
		    out.println(content.toString());
		    out.flush();
		    out.close();
			
		} catch (Exception e) {
			log.error(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(),
					  Constantes.NIVEL_APP_CONSTROLLER, 
					  this.getClass().getName(), e.getMessage()));
	    } 
	}
	
	private String val_not_cred(List<ComprasIngresosBean> lis_ing_not_cre, Integer cod_com_ingresos, int orden) {
		for (ComprasIngresosBean ingreso : lis_ing_not_cre) {
			if (!isNullInteger(cod_com_ingresos) &&	
					cod_com_ingresos.equals(ingreso.getCod_com_ingresos())) {
				switch (orden) {
					case 1:
						return ingreso.getSer_comprobante();
					case 2:
						return StringUtils.stripStart(ingreso.getNro_comprobante(), Constantes.ZERO_STRING);
					case 3:
						return ingreso.getFec_comprobante();
					case 4:
						return ingreso.getVcod_comprobante();	
				}
				
			}			
		}
		return Constantes.EMPTY;
	}
	
	/**
	 * @param request
	 * @param response
	 * @return - Retorna a la vista JSP.
	 */
	@RequestMapping(value = "/validarComprobante", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public Integer validarComprobante(HttpServletRequest request, HttpServletResponse response) {
		Integer estado = Constantes.ZERO_INT;
		try {			
			ComprasIngresosBean compra = new ComprasIngresosBean();
			// Copia los parametros del cliente al objeto
			BeanUtils.populate(compra, request.getParameterMap());
			
			String fec_comprobante = compra.getFec_comprobante();
			
			int cod_rec_honorarios = getInteger(ReadParameterProperties.getPropiedad("codigo.comprobante.recibo.honorarios")).intValue();
			if (cod_rec_honorarios == compra.getCod_comprobante().intValue()) { // Recibo por Honorarios
				ComprasIngresosBean compra_hon = new ComprasIngresosBean();
				compra_hon.setInt_transaccion(compra.getInt_transaccion());
				compra_hon.setCod_comprobante(compra.getCod_comprobante());
				compra_hon.setSer_comprobante(compra.getSer_comprobante());
				compra_hon.setNro_comprobante(compra.getNro_comprobante());
				compra_hon.setCod_personal(compra.getCod_personal());
				compra_hon.setCod_mes(compra.getCod_mes());
				compra = new ComprasIngresosBean();
				compra = compra_hon;
			} else {
				compra.setNum_ruc(null);
				compra.setCod_personal(null);
			}
			
			// Consultamos que el comprobante no exista
			List<ComprasIngresosBean> lista = iCompraService.listarCompras(compra);
			if (!isEmpty(lista)) {
				estado = Constantes.ONE_INT;
				return estado;
			}
			
			// Consultamos si el registro se puede editar de acuerdo al cierre de mes
			CierreMesBean cierre = new CierreMesBean();
			cierre.setFec_cierre(fec_comprobante);
			cierre.setCod_mes(compra.getCod_mes());
			cierre.setMes_activo(Constantes.FLAG_ACTIVO);
			cierre.setFla_apertura(Constantes.FLAG_INACTIVO);
			cierre.setFla_apertura_vta(Constantes.FLAG_INACTIVO);
			cierre.setInd_tip_compra(Constantes.ONE_INT);
			cierre.setInd_tip_venta(Constantes.TWO_INT);
			List<CierreMesBean> lis_cie_mes = iCompraService.listarCierresMes(cierre);
			if (!isEmpty(lis_cie_mes) && !isNullInteger(compra.getCod_mes())) {
				boolean ind_cierre = false;
				for (CierreMesBean cie : lis_cie_mes) {
					if (cie.getMes().equals(compra.getCod_mes())) {
						ind_cierre = true;
						break;
					}
				}
				if (ind_cierre) {
					estado = Constantes.TWO_INT;
				}	
			}
			
		} catch (Exception e) {
			log.error(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(),
									  Constantes.NIVEL_APP_CONSTROLLER, 
									  this.getClass().getName(), e.getMessage()));
		}
		return estado;
	}

}
