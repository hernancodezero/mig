package pe.com.mig.web.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

import pe.com.mig.model.bean.CierreMesBean;
import pe.com.mig.model.bean.sernanp.UnidadOperativaBean;
import pe.com.mig.model.bean.sernanp.UsuarioBean;
import pe.com.mig.service.IMaestroService;
import pe.com.mig.util.Constantes;

/**
 * @className: IngresosBoletosController.java
 * @description: 
 * @date: 23 de jun. de 2016
 * @author: Administrador.
 */
@Controller
public class MantenimientoCierreMesController extends BaseController {

	private static final long serialVersionUID = 1L;
	
	@Autowired 
	private IMaestroService iMaestroService;
	

	/**
	 * Metodo que retorna a la Mantenimiento de Cierre de mes
	 * @return - Retorna a la vista JSP.
	 */
	@RequestMapping("/mantenimientoCierreMes")
    public ModelAndView mantenimientoCierreMes() {
		ModelAndView model = new ModelAndView("mnt_cie_mes");	
		try {
			List<UnidadOperativaBean> lis_uni_operativa = new ArrayList<UnidadOperativaBean>();		
			lis_uni_operativa = iMaestroService.listarUnidadOperativa(new UnidadOperativaBean());			
			model.addObject("lis_uni_operativa", lis_uni_operativa);
			
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			Date date = new Date();
			model.addObject("dte_actual", dateFormat.format(date));
			
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
	@RequestMapping(value = "/listarCierresMes", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<CierreMesBean> listarCierresMes(HttpServletRequest request, HttpServletResponse response) {
		List<CierreMesBean> lista = null;
		try {			
			CierreMesBean cierreMes = new CierreMesBean();			
			// Copia los parametros del cliente al objeto
			BeanUtils.populate(cierreMes, request.getParameterMap());	
			lista = iMaestroService.listarCierresMes(cierreMes);
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
	 * @return Retorna el codigo de la tabla de cierre de mes.
	 */
	@RequestMapping(value = "/grabarCierre", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public Integer grabarCierre(HttpServletRequest request, HttpServletResponse response) {
		Integer codigo = null;
		try {
			CierreMesBean cierreMes = new CierreMesBean();
			
			// Copia los parametros del cliente al objeto
			BeanUtils.populate(cierreMes, request.getParameterMap());			
			// Retorno los datos de session
			usuarioBean = (UsuarioBean) context().getAttribute("usuarioBean", RequestAttributes.SCOPE_SESSION);
			cierreMes.setVnomusuario(usuarioBean.getDes_usuario());	
			
			codigo = iMaestroService.grabarCierre(cierreMes);
			
		} catch (Exception e) {
			log.error(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(),
									  Constantes.NIVEL_APP_CONSTROLLER, 
									  this.getClass().getName(), e.getMessage()));
			
			//e.printStackTrace();
		}
		return codigo;
	}
	
}
