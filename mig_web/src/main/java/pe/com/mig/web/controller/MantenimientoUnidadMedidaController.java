
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

import pe.com.mig.model.bean.UnidadMedidaBean;
import pe.com.mig.model.bean.sernanp.UsuarioBean;
import pe.com.mig.service.IMaestroService;
import pe.com.mig.util.Constantes;

/**
 * @className: MantenimientoTipoMonedaController.java
 * @description: 
 * @date: 23 de jun. de 2016
 * @author: Administrador.
 */
@Controller
public class MantenimientoUnidadMedidaController extends BaseController {

	private static final long serialVersionUID = 1L;
	
	@Autowired 
	private IMaestroService iMaestroService;
	

	/**
	 * Metodo que retorna a la Bandeja Registro de Cuarta Categoria.
	 * @return - Retorna a la vista JSP.
	 */
	@RequestMapping("/mantenimientoUnidadMedida")
    public ModelAndView mantenimientoUnidadMedida() {
		ModelAndView model = new ModelAndView("mnt_unid_medida");		
		return model;
    }
	
	/**
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/listarUnidadMedida", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<UnidadMedidaBean> listarUnidadMedida(HttpServletRequest request, HttpServletResponse response) {
		List<UnidadMedidaBean> lista = null;
		try {			
			UnidadMedidaBean unidadMedida = new UnidadMedidaBean();			
			// Copia los parametros del cliente al objeto
			BeanUtils.populate(unidadMedida, request.getParameterMap());	
			lista = iMaestroService.listarUnidadMedida(unidadMedida);
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
	 * @return Retorna el codigo de la tabla de unidad de medida.
	 */
	@RequestMapping(value = "/grabarUnidadMedida", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public Integer grabarUnidadMedida(HttpServletRequest request, HttpServletResponse response) {
		Integer codigo = null;
		try {
			UnidadMedidaBean unidadMedida = new UnidadMedidaBean();	
			
			// Copia los parametros del cliente al objeto
			BeanUtils.populate(unidadMedida, request.getParameterMap());
			
			// Retorno los datos de session
			usuarioBean = (UsuarioBean) context().getAttribute("usuarioBean", RequestAttributes.SCOPE_SESSION);
			unidadMedida.setVnomusuario(usuarioBean.getDes_usuario());					

			codigo = iMaestroService.grabarUnidadMedida(unidadMedida);
			
		} catch (Exception e) {
			log.error(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(),
									  Constantes.NIVEL_APP_CONSTROLLER, 
									  this.getClass().getName(), e.getMessage()));
		}
		return codigo;
	}
	
}
