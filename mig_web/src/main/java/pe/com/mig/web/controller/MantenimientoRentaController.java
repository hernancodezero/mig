
package pe.com.mig.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import pe.com.mig.model.bean.ConvenioCuartaBean;
import pe.com.mig.model.bean.CuentaContableBean;
import pe.com.mig.model.bean.DocumentoCuartaBean;
import pe.com.mig.model.bean.NacionalidadBean;
import pe.com.mig.model.bean.PersonaCuartaBean;
import pe.com.mig.model.bean.SeriesBean;
import pe.com.mig.model.bean.TarifaBoletoBean;
import pe.com.mig.model.bean.TipoComprobanteBean;
import pe.com.mig.model.bean.UbigeoBean;
import pe.com.mig.model.bean.ViaBean;
import pe.com.mig.model.bean.ZonaBean;
import pe.com.mig.model.bean.sernanp.UnidadOperativaBean;
import pe.com.mig.model.bean.sernanp.UsuarioBean;
import pe.com.mig.service.IMaestroService;
import pe.com.mig.util.Constantes;

/**
 * @className: MantenimientoSeriesController.java
 * @description: 
 * @date: 23 de jun. de 2016
 * @author: Administrador.
 */
@Controller
public class MantenimientoRentaController extends BaseController {

	private static final long serialVersionUID = 1L;
	
	@Autowired 
	private IMaestroService iMaestroService;
	
	/**
	 * Metodo que retorna a la Bandeja Registro de Cuarta Categoria.
	 * @return - Retorna a la vista JSP.
	 */
	@RequestMapping("/mantenimientoRenta")
    public ModelAndView mantenimientoserie() {
		ModelAndView model = new ModelAndView("mnt_renta");	
		try {
			List<UnidadOperativaBean> lis_uni_operativa = new ArrayList<UnidadOperativaBean>();		
			lis_uni_operativa = iMaestroService.listarUnidadOperativa(new UnidadOperativaBean());			
			model.addObject("lis_uni_operativa", lis_uni_operativa);
			
			List<TipoComprobanteBean> lis_tip_comprobante = new ArrayList<TipoComprobanteBean>();		
			lis_tip_comprobante = iMaestroService.listarTipoComprobante(new TipoComprobanteBean(Constantes.FLAG_ACTIVO));			
			model.addObject("lis_tip_comprobante", lis_tip_comprobante);
			
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
	@RequestMapping(value = "/listarPersonaCuarta", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<PersonaCuartaBean> listarPersonaCuarta(HttpServletRequest request, HttpServletResponse response) {
		List<PersonaCuartaBean> lista = null;
		try {			
			PersonaCuartaBean persona = new PersonaCuartaBean();			
			// Copia los parametros del cliente al objeto
			BeanUtils.populate(persona, request.getParameterMap());	
			lista = iMaestroService.listarPersonaCuarta(persona);
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
	 * @return Retorna el codigo de la persona de cuarta.
	 */
	@RequestMapping(value = "/grabarpersona", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public Integer grabarpersona(HttpServletRequest request, HttpServletResponse response) {
		Integer codigo = null;
		try {
			PersonaCuartaBean persona = new PersonaCuartaBean();	
			
			// Copia los parametros del cliente al objeto
			BeanUtils.populate(persona, request.getParameterMap());
			
			// Retorno los datos de session
			usuarioBean = (UsuarioBean) context().getAttribute("usuarioBean", RequestAttributes.SCOPE_SESSION);
			persona.setVnomusuario(usuarioBean.getDes_usuario());					

			codigo = iMaestroService.grabarpersona(persona);
			
		} catch (Exception e) {
			log.error(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(),
									  Constantes.NIVEL_APP_CONSTROLLER, 
									  this.getClass().getName(), e.getMessage()));
		}
		return codigo;
	}
	
}
