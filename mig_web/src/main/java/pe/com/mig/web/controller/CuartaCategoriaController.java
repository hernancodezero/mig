package pe.com.mig.web.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.converters.BigDecimalConverter;
import org.apache.commons.beanutils.converters.IntegerConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import pe.com.mig.model.bean.ConvenioCuartaBean;
import pe.com.mig.model.bean.CuartaCategoriaBean;
import pe.com.mig.model.bean.DocumentoCuartaBean;
import pe.com.mig.model.bean.NacionalidadBean;
import pe.com.mig.model.bean.PersonaCuartaBean;
import pe.com.mig.model.bean.TipoComprobanteCuartaBean;
import pe.com.mig.model.bean.UbigeoBean;
import pe.com.mig.model.bean.ViaBean;
import pe.com.mig.model.bean.ZonaBean;
import pe.com.mig.model.bean.sernanp.UnidadOperativaBean;
import pe.com.mig.model.bean.sernanp.UsuarioBean;
import pe.com.mig.service.IMaestroService;
import pe.com.mig.util.Constantes;

/**
 * @className: CuartaCategoriaController.java
 * @description: 
 * @date: 23 de jun. de 2016
 * @author: Administrador.
 */
@Controller
public class CuartaCategoriaController extends BaseController {

	private static final long serialVersionUID = 1L;
	
	@Autowired 
	private IMaestroService iMaestroService;
	

	/**
	 * Metodo que retorna a la Bandeja Registro de Cuarta Categoria.
	 * @return - Retorna a la vista JSP.
	 */
	@RequestMapping("/cuartaCategoria")
    public ModelAndView cuartaCategoria() {
		ModelAndView model = new ModelAndView("lis_reg_cua_categoria");		
		try {
					
			List<TipoComprobanteCuartaBean> lis_tip_comprobante = new ArrayList<TipoComprobanteCuartaBean>();		
			lis_tip_comprobante = iMaestroService.listarTipoComprobanteCuarta(new TipoComprobanteCuartaBean(Constantes.FLAG_ACTIVO));			
			model.addObject("lis_tip_comprobante", lis_tip_comprobante);
			//Documento Cuarta
			List<DocumentoCuartaBean> lis_documento_cuarta = new ArrayList<DocumentoCuartaBean>();		
			lis_documento_cuarta = iMaestroService.listarDocumentoCuarta(new DocumentoCuartaBean(Constantes.FLAG_ACTIVO));			
			model.addObject("lis_documento_cuarta", lis_documento_cuarta);
			//Retorno Nacionalidad
			List<NacionalidadBean> lis_tip_nacionalidad = new ArrayList<NacionalidadBean>();		
			lis_tip_nacionalidad = iMaestroService.listarNacionalidad (new NacionalidadBean(Constantes.FLAG_ACTIVO));			
			model.addObject("lis_tip_nacionalidad", lis_tip_nacionalidad);
			//Retorno via
			List<ViaBean> lis_via = new ArrayList<ViaBean>();		
			lis_via = iMaestroService.listarVia(new ViaBean(Constantes.FLAG_ACTIVO));			
			model.addObject("lis_tip_via", lis_via);
			//Retorno Zona
			List<ZonaBean> lis_zona = new ArrayList<ZonaBean>();		
			lis_zona = iMaestroService.listarZona (new ZonaBean(Constantes.FLAG_ACTIVO));			
			model.addObject("lis_tip_zona", lis_zona);
			//Retorno Convenio
			List<ConvenioCuartaBean> lis_convenio = new ArrayList<ConvenioCuartaBean>();		
			lis_convenio = iMaestroService.listarConvenio (new ConvenioCuartaBean(Constantes.FLAG_ACTIVO));			
			model.addObject("lis_convenio", lis_convenio);
			//Retorno Ubigeo
			List<UbigeoBean> lis_ubigeo = new ArrayList<UbigeoBean>();		
			lis_ubigeo = iMaestroService.listarUbigeo(new UbigeoBean());			
			model.addObject("lis_ubigeo", lis_ubigeo);
			
			// Retorno los datos de session
//			usuarioBean = (UsuarioBean) context().getAttribute("usuarioBean", RequestAttributes.SCOPE_SESSION);
//			
//			List<UnidadOperativaBean> lis_uni_operativa = new ArrayList<UnidadOperativaBean>();		
//			lis_uni_operativa = iMaestroService.listarUnidadOperativa(new UnidadOperativaBean());			
//			model.addObject("lis_uni_operativa", lis_uni_operativa);
			// Retorno los datos de session
			usuarioBean = (UsuarioBean) context().getAttribute("usuarioBean", RequestAttributes.SCOPE_SESSION);

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
			
			UnidadOperativaBean unidad = new UnidadOperativaBean();
			//unidad.setCod_uni_operativa(lis_uni_operativa.get(0).getCod_uni_operativa());
			unidad.setInd_uni_operativa(1);
			List<UnidadOperativaBean> lis_anp = iMaestroService.listarUnidadOperativa(unidad);			

			model.addObject("lis_anp", lis_anp);
			
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
	@RequestMapping(value = "/listarUbigeo", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<UbigeoBean> listarUbigeo(HttpServletRequest request, HttpServletResponse response) {
		List<UbigeoBean> lista = null;
		try {			
			UbigeoBean ubigeo = new UbigeoBean();			
			// Copia los parametros del cliente al objeto
			BeanUtils.populate(ubigeo, request.getParameterMap());	
			lista = iMaestroService.listarUbigeo(ubigeo);
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
	 * @return
	 */
	@RequestMapping(value = "/listarCuartaCategoria", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<CuartaCategoriaBean> listarCuartaCategoria(HttpServletRequest request, HttpServletResponse response) {
		List<CuartaCategoriaBean> lista = null;
		try {			
			CuartaCategoriaBean cuarta = new CuartaCategoriaBean();			
			// Copia los parametros del cliente al objeto
			BeanUtils.populate(cuarta, request.getParameterMap());	
			lista = iMaestroService.listarCuartaCategoria(cuarta);
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
	 * @return Retorna el codigo de la tabla de entidad financiera.
	 */
	@RequestMapping(value = "/grabarCuartaCategoria", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public Integer grabarCuartaCategoria(HttpServletRequest request, HttpServletResponse response) {
		Integer codigo = null;
		try {
			CuartaCategoriaBean cuarta = new CuartaCategoriaBean();	
			
			
			// Convierte los vacios en nulos en los enteros
			IntegerConverter con_integer = new IntegerConverter(null);			
			BeanUtilsBean beanUtilsBean = new BeanUtilsBean();
			beanUtilsBean.getConvertUtils().register(con_integer, Integer.class);
			// Convierte los vacios en nulos en los decimales
			BigDecimalConverter con_decimal = new BigDecimalConverter(null);
			beanUtilsBean.getConvertUtils().register(con_decimal, BigDecimal.class);
			// Copia los parametros del cliente al objeto
			beanUtilsBean.populate(cuarta, request.getParameterMap());
			
			
			// Retorno los datos de session
			usuarioBean = (UsuarioBean) context().getAttribute("usuarioBean", RequestAttributes.SCOPE_SESSION);
			cuarta.setVnomusuario(usuarioBean.getDes_usuario());					

			codigo = iMaestroService.grabarCuartaCategoria(cuarta);
			
		} catch (Exception e) {
		log.error(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(),
									  Constantes.NIVEL_APP_CONSTROLLER, 
									  this.getClass().getName(), e.getMessage()));
//			e.printStackTrace();
		}
		return codigo;
	}
	/**
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/verificarRucCuarta", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<PersonaCuartaBean> verificarRucCuarta(HttpServletRequest request, HttpServletResponse response) {
		List<PersonaCuartaBean> lista = new ArrayList<PersonaCuartaBean>();
		try {			
			PersonaCuartaBean financiero = new PersonaCuartaBean();			
			// Copia los parametros del cliente al objeto
			BeanUtils.populate(financiero, request.getParameterMap());	
			lista = iMaestroService.verificarRucCuarta(financiero);	
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
	 * @return Retorna el codigo de la tabla de entidad financiera.
	 */
	@RequestMapping(value = "/grabarPersonaCuartaCategoria", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public Integer grabarPersonaCuartaCategoria(HttpServletRequest request, HttpServletResponse response) {
		Integer codigo = null;
		try {
			PersonaCuartaBean cuarta = new PersonaCuartaBean();	
			
			IntegerConverter con_integer = new IntegerConverter(null);			
			BeanUtilsBean beanUtilsBean = new BeanUtilsBean();
			beanUtilsBean.getConvertUtils().register(con_integer, Integer.class);
			// Convierte los vacios en nulos en los decimales
			BigDecimalConverter con_decimal = new BigDecimalConverter(null);
			beanUtilsBean.getConvertUtils().register(con_decimal, BigDecimal.class);
			// Copia los parametros del cliente al objeto
			beanUtilsBean.populate(cuarta, request.getParameterMap());
			
			
			// Retorno los datos de session
			usuarioBean = (UsuarioBean) context().getAttribute("usuarioBean", RequestAttributes.SCOPE_SESSION);
			cuarta.setVnomusuario(usuarioBean.getDes_usuario());					

			codigo = iMaestroService.grabarPersonaCuartaCategoria(cuarta);
			
		} catch (Exception e) {
		log.error(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(),
									  Constantes.NIVEL_APP_CONSTROLLER, 
									  this.getClass().getName(), e.getMessage()));
//			e.printStackTrace();
		}
		return codigo;
	}
	
}
