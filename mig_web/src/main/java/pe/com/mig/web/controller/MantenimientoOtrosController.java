
package pe.com.mig.web.controller;

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

import pe.com.mig.model.bean.OtrosBean;
import pe.com.mig.model.bean.sernanp.UsuarioBean;
import pe.com.mig.service.IMaestroService;
import pe.com.mig.util.Constantes;

/**
 * @className: MantenimientoOtrosController.java
 * @description: 
 * @date: 16 de oct. de 2019
 * @author: RMM.
 */
@Controller
public class MantenimientoOtrosController extends BaseController {

	private static final long serialVersionUID = 1L;
	
	@Autowired 
	private IMaestroService iMaestroService;
	

	/**
	 * Metodo que retorna a la Bandeja Registro de Otros.
	 * @return - Retorna a la vista JSP.
	 */
	@RequestMapping("/mantenimientoOtros")
    public ModelAndView mantenimientoOtros() {
		ModelAndView model = new ModelAndView("mnt_otros");		
		return model;
    }
	
	/**
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/listarOtros", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<OtrosBean> listarOtros(HttpServletRequest request, HttpServletResponse response) {
		List<OtrosBean> lista = null;
		try {			
			OtrosBean otros = new OtrosBean();			
			// Copia los parametros del cliente al objeto
			BeanUtils.populate(otros, request.getParameterMap());	
			lista = iMaestroService.listarOtros(otros);
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
	 * @return Retorna el codigo de la tabla de tipo moneda.
	 */
	@RequestMapping(value = "/grabarOtros", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public Integer grabarOtros(HttpServletRequest request, HttpServletResponse response) {
		Integer codigo = null;
		try {
			OtrosBean otros = new OtrosBean();	
			
			// Copia los parametros del cliente al objeto
			BeanUtils.populate(otros, request.getParameterMap());
			
			// Retorno los datos de session
			usuarioBean = (UsuarioBean) context().getAttribute("usuarioBean", RequestAttributes.SCOPE_SESSION);
			otros.setVnomusuario(usuarioBean.getDes_usuario());					

			codigo = iMaestroService.grabarOtros(otros);
			
		} catch (Exception e) {
			log.error(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(),
									  Constantes.NIVEL_APP_CONSTROLLER, 
									  this.getClass().getName(), e.getMessage()));
		}
		return codigo;
	}
	
}
