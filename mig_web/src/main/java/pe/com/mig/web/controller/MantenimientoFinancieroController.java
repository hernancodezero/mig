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

import pe.com.mig.model.bean.EntidadFinancieraBean;
import pe.com.mig.model.bean.sernanp.UsuarioBean;
import pe.com.mig.service.IMaestroService;
import pe.com.mig.util.Constantes;

/**
 * @className: MantenimientoFinancieroController.java
 * @description: 
 * @date: 23 de jun. de 2016
 * @author: Administrador.
 */
@Controller
public class MantenimientoFinancieroController extends BaseController {

	private static final long serialVersionUID = 1L;
	
	@Autowired 
	private IMaestroService iMaestroService;
	
	/**
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/listarFinanciero", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<EntidadFinancieraBean> listarFinanciero(HttpServletRequest request, HttpServletResponse response) {
		List<EntidadFinancieraBean> lista = null;
		try {			
			EntidadFinancieraBean financiero = new EntidadFinancieraBean();			
			// Copia los parametros del cliente al objeto
			BeanUtils.populate(financiero, request.getParameterMap());	
			lista = iMaestroService.listarFinanciero(financiero);
		} catch (Exception e) {
			log.error(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(),
									  Constantes.NIVEL_APP_CONSTROLLER, 
									  this.getClass().getName(), e.getMessage()));
		}
		return lista;
	}
	/**
	 * Metodo que retorna a la Bandeja Mantenimiento Financiero.
	 * @return - Retorna a la vista JSP.
	 */
	@RequestMapping("/mantenimientoFinanciero")
    public ModelAndView mantenimientoFinanciero() {
		ModelAndView model = new ModelAndView("mnt_financiero");		
		try {			
			// Retorno los datos de session
			usuarioBean = (UsuarioBean) context().getAttribute("usuarioBean", RequestAttributes.SCOPE_SESSION);

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
	 * @return Retorna el codigo de la tabla de entidad financiera.
	 */
	@RequestMapping(value = "/grabarFinanciero", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public Integer grabarFinanciero(HttpServletRequest request, HttpServletResponse response) {
		Integer codigo = null;
		try {
			EntidadFinancieraBean entidadFinanciera = new EntidadFinancieraBean();	
			
			// Copia los parametros del cliente al objeto
			BeanUtils.populate(entidadFinanciera, request.getParameterMap());
			
			// Retorno los datos de session
			usuarioBean = (UsuarioBean) context().getAttribute("usuarioBean", RequestAttributes.SCOPE_SESSION);
			entidadFinanciera.setVnomusuario(usuarioBean.getDes_usuario());					

			codigo = iMaestroService.grabarEntidadFinanciera(entidadFinanciera);
			
		} catch (Exception e) {
			log.error(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(),
									  Constantes.NIVEL_APP_CONSTROLLER, 
									  this.getClass().getName(), e.getMessage()));
		}
		return codigo;
	}
}
