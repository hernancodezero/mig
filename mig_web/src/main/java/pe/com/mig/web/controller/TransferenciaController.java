package pe.com.mig.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.converters.IntegerConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import pe.com.mig.model.bean.DetalleTransferenciaBean;
import pe.com.mig.model.bean.FuenteFinanciamientoBean;
import pe.com.mig.model.bean.TipoComprobanteBean;
import pe.com.mig.model.bean.TipoMonedaBean;
import pe.com.mig.model.bean.TransferenciaBean;
import pe.com.mig.model.bean.sernanp.UnidadOperativaBean;
import pe.com.mig.model.bean.sernanp.UsuarioBean;
import pe.com.mig.model.bean.sppi.EspecificaBean;
import pe.com.mig.service.IMaestroService;
import pe.com.mig.service.ITransferenciaService;
import pe.com.mig.util.Constantes;

/**
 * @className: TransferenciaController.java
 * @description: 
 * @date: 11 de jun. de 2016
 * @author: SUMERIO.
 */
@Controller
public class TransferenciaController extends BaseController {

	private static final long serialVersionUID = 1L;
	
	@Autowired 
	private IMaestroService iMaestroService;
	
	@Autowired 
	private ITransferenciaService iTransferenciaService;

	/**
	 * Metodo que retorna a la Bandeja Registro de Transferencias.
	 * @return - Retorna a la vista JSP.
	 */
	@RequestMapping("/transferencias")
    public ModelAndView transferencias() {
		ModelAndView model = new ModelAndView("lis_reg_transferencias");
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
	 * @return
	 */
	@RequestMapping(value = "/listarTransferencias", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<TransferenciaBean> listarTransferencias(HttpServletRequest request, HttpServletResponse response) {
		List<TransferenciaBean> lista = null;
		try {			
			TransferenciaBean transferencia = new TransferenciaBean();			
			// Copia los parametros del cliente al objeto
			BeanUtils.populate(transferencia, request.getParameterMap());			
			lista = iTransferenciaService.listarTransferencias(transferencia);
		} catch (Exception e) {
			log.error(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(),
									  Constantes.NIVEL_APP_CONSTROLLER, 
									  this.getClass().getName(), e.getMessage()));
		}
		return lista;
	}
	
	/**
	 * Metodo que retorna a la Bandeja Registro de Transferencias.
	 * @param codigo - Codigo de transferencia.
	 * @return - Retorna a la vista JSP.
	 */
	@RequestMapping("/mnt_transferencia/{codigo}")
    public ModelAndView mnt_transferencia(@PathVariable("codigo") Integer codigo) {
		ModelAndView model = new ModelAndView("mnt_reg_transferencias");		
		try {
			List<TipoComprobanteBean> lis_tip_comprobante = new ArrayList<TipoComprobanteBean>();		
			lis_tip_comprobante = iMaestroService.listarTipoComprobante(new TipoComprobanteBean(Constantes.FLAG_ACTIVO));
			model.addObject("lis_tip_comprobante", lis_tip_comprobante);
			
			List<TipoMonedaBean> lis_tip_moneda = new ArrayList<TipoMonedaBean>();		
			lis_tip_moneda = iMaestroService.listarTipoMoneda(new TipoMonedaBean(Constantes.FLAG_ACTIVO));			
			model.addObject("lis_tip_moneda", lis_tip_moneda);
			
			List<FuenteFinanciamientoBean> lis_fue_financiamiento = new ArrayList<FuenteFinanciamientoBean>();		
			lis_fue_financiamiento = iMaestroService.listarFuenteFinanciamiento(new FuenteFinanciamientoBean(Constantes.FLAG_ACTIVO));			
			model.addObject("lis_fue_financiamiento", lis_fue_financiamiento);
			
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
			
			if (!isNullInteger(codigo)) {
				
				model.addObject("codigo", codigo);
			
				TransferenciaBean transferencia = iTransferenciaService.listarTransferencias(new TransferenciaBean(codigo)).get(0);
				model.addObject("transferencia", transferencia);
				
				List<UnidadOperativaBean> lis_anp = new ArrayList<UnidadOperativaBean>();
				UnidadOperativaBean unidad = new UnidadOperativaBean();
				unidad.setInd_uni_operativa(1);
				unidad.setCod_uni_operativa(transferencia.getCod_uni_operativa());
				lis_anp = iMaestroService.listarUnidadOperativa(unidad);			
				model.addObject("lis_anp", lis_anp);
				
				List<DetalleTransferenciaBean> lis_det_transferencia = iTransferenciaService.listarDetalleTransferencias(new DetalleTransferenciaBean(codigo));																	   
				model.addObject("lis_det_transferencia", lis_det_transferencia);				
			} else {
				model.addObject("codigo", "");
			}
			
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
	 * @return
	 */
	@RequestMapping(value = "/verificarPartida", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public EspecificaBean verificarPartida(HttpServletRequest request, HttpServletResponse response) {
		EspecificaBean especifica = new EspecificaBean();
		try {			
			String partida = request.getParameter("partida");
			List<EspecificaBean> lis_especifica = new ArrayList<EspecificaBean>();
			lis_especifica = iMaestroService.listarEspecifica(new EspecificaBean(partida));
			if (!isEmpty(lis_especifica)) {
				especifica = lis_especifica.get(0);
			}
		} catch (Exception e) {
			log.error(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(),
									  Constantes.NIVEL_APP_CONSTROLLER, 
									  this.getClass().getName(), e.getMessage()));
		}
		return especifica;
	}
	
	/**
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/listarUnidadOperativa", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<UnidadOperativaBean> listarUnidadOperativa(HttpServletRequest request, HttpServletResponse response) {
		List<UnidadOperativaBean> lista = null;
		try {			
			UnidadOperativaBean unidad = new UnidadOperativaBean();
			// Convierte los vacios en nulos en los enteros
			IntegerConverter con_integer = new IntegerConverter(null);			
			BeanUtilsBean beanUtilsBean = new BeanUtilsBean();
			beanUtilsBean.getConvertUtils().register(con_integer, Integer.class);
			// Copia los parametros del cliente al objeto
			beanUtilsBean.populate(unidad, request.getParameterMap());
			lista = iMaestroService.listarUnidadOperativa(unidad);
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
	 * @return Retorna el codigo de la tabla de transferencia.
	 */
	@RequestMapping(value = "/grabarTransferencia", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public Integer grabarTransferencia(HttpServletRequest request, HttpServletResponse response) {
		Integer codigo = null;
		try {
			TransferenciaBean transferencia = new TransferenciaBean();	
			
			// Convierte los vacios en nulos en los enteros
			IntegerConverter converter = new IntegerConverter(null); 
			BeanUtilsBean beanUtilsBean = new BeanUtilsBean();
			beanUtilsBean.getConvertUtils().register(converter, Integer.class);
			// Copia los parametros del cliente al objeto
			beanUtilsBean.populate(transferencia, request.getParameterMap());
			
			// Retorno los datos de session
			usuarioBean = (UsuarioBean) context().getAttribute("usuarioBean", RequestAttributes.SCOPE_SESSION);
			transferencia.setVnomusuario(usuarioBean.getDes_usuario());		
			
			String arr_partida[] = request.getParameter("arr_partida").split("\\|", -1);
			String arr_meta[] = request.getParameter("arr_meta").split("\\|", -1);
			String arr_importe[] = request.getParameter("arr_importe").split("\\|", -1);
			
			List<DetalleTransferenciaBean> detalle = new ArrayList<DetalleTransferenciaBean>();
			for (int i = 0; i < arr_partida.length; i++) {
				DetalleTransferenciaBean detalleTransf = new DetalleTransferenciaBean();
				detalleTransf.setCod_especifica(getLong(arr_partida[i]));
				detalleTransf.setCod_meta(getString(arr_meta[i]));
				detalleTransf.setImp_partida(getBigDecimal(arr_importe[i]));
				detalleTransf.setVnomusuario(usuarioBean.getDes_usuario());
				detalle.add(detalleTransf);
			}
			
			codigo = iTransferenciaService.grabarTransferencia(transferencia, detalle);
			
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
	 * @return
	 */
	@RequestMapping(value = "/eliminarTransferencia", method = RequestMethod.POST)
	@ResponseBody
	public String eliminarTransferencia(HttpServletRequest request, HttpServletResponse response) {
		String estado = null;
		try {			
			TransferenciaBean transferencia = new TransferenciaBean(getInteger(request.getParameter("codigo")));
			// Retorno los datos de session
			usuarioBean = (UsuarioBean) context().getAttribute("usuarioBean", RequestAttributes.SCOPE_SESSION);
			transferencia.setVnomusuario(usuarioBean.getDes_usuario());
			iTransferenciaService.eliminarTransferencia(transferencia);
			estado = Constantes.ACCION_CORRECTA_JSON;
		} catch (Exception e) {
			log.error(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(),
									  Constantes.NIVEL_APP_CONSTROLLER, 
									  this.getClass().getName(), e.getMessage()));
		}
		return estado;
	}
	
}
