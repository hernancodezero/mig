
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

import pe.com.mig.model.bean.CuentaContableBean;
import pe.com.mig.model.bean.sernanp.UnidadOperativaBean;
import pe.com.mig.model.bean.sernanp.UsuarioBean;
import pe.com.mig.model.bean.sppi.EspecificaBean;
import pe.com.mig.service.IMaestroService;
import pe.com.mig.util.Constantes;

/**
 * @className: MantenimientoTipoMonedaController.java
 * @description: 
 * @date: 23 de jun. de 2016
 * @author: Administrador.
 */
@Controller
public class MantenimientoCtaContableController extends BaseController {

	private static final long serialVersionUID = 1L;
	
	@Autowired 
	private IMaestroService iMaestroService;
	/**
	 * Metodo que retorna a la Bandeja Registro de Cuarta Categoria.
	 * @return - Retorna a la vista JSP.
	 */
	@RequestMapping("/mantenimientoCtaContable")
    public ModelAndView mantenimientoCtaContable() {
		ModelAndView model = new ModelAndView("mnt_cta_contable");	
		try {
			List<UnidadOperativaBean> lis_uni_operativa = new ArrayList<UnidadOperativaBean>();		
			lis_uni_operativa = iMaestroService.listarUnidadOperativa(new UnidadOperativaBean());			
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
	 * @return
	 */
	@RequestMapping(value = "/listarCtaContable", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<CuentaContableBean> listarCtaContable(HttpServletRequest request, HttpServletResponse response) {
		List<CuentaContableBean> lista = null;
		try {			
			CuentaContableBean financiero = new CuentaContableBean();			
			// Copia los parametros del cliente al objeto
			BeanUtils.populate(financiero, request.getParameterMap());	
			lista = iMaestroService.listarCuentaContable(financiero);
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
	@RequestMapping(value = "/grabarCuentaContable", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public Integer grabarCuentaContable(HttpServletRequest request, HttpServletResponse response) {
		Integer codigo = null;
		try {
			CuentaContableBean entidadFinanciera = new CuentaContableBean();	
			
			// Copia los parametros del cliente al objeto
			BeanUtils.populate(entidadFinanciera, request.getParameterMap());
			
			// Retorno los datos de session
			usuarioBean = (UsuarioBean) context().getAttribute("usuarioBean", RequestAttributes.SCOPE_SESSION);
			entidadFinanciera.setVnomusuario(usuarioBean.getDes_usuario());					

			codigo = iMaestroService.grabarCuentaContable(entidadFinanciera);
			
		} catch (Exception e) {
			log.error(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(),
									  Constantes.NIVEL_APP_CONSTROLLER, 
									  this.getClass().getName(), e.getMessage()));
		}
		return codigo;
	}/**
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/verificarEspecifica", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public EspecificaBean verificarRucCuarta(HttpServletRequest request, HttpServletResponse response) {
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
	
	
	
}
