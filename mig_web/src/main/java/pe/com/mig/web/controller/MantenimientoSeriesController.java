
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
import pe.com.mig.model.bean.SeriesBean;
import pe.com.mig.model.bean.TarifaBoletoBean;
import pe.com.mig.model.bean.TipoComprobanteBean;
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
public class MantenimientoSeriesController extends BaseController {

	private static final long serialVersionUID = 1L;
	
	@Autowired 
	private IMaestroService iMaestroService;
	
	/**
	 * Metodo que retorna a la Bandeja Registro de Cuarta Categoria.
	 * @return - Retorna a la vista JSP.
	 */
	@RequestMapping("/mantenimientoSerie")
    public ModelAndView mantenimientoserie() {
		ModelAndView model = new ModelAndView("mnt_serie");	
		try {
			List<UnidadOperativaBean> lis_uni_operativa = new ArrayList<UnidadOperativaBean>();		
			lis_uni_operativa = iMaestroService.listarUnidadOperativa(new UnidadOperativaBean());			
			model.addObject("lis_uni_operativa", lis_uni_operativa);
			
			List<TipoComprobanteBean> lis_tip_comprobante = new ArrayList<TipoComprobanteBean>();		
			lis_tip_comprobante = iMaestroService.listarTipoComprobante(new TipoComprobanteBean(Constantes.FLAG_ACTIVO));			
			model.addObject("lis_tip_comprobante", lis_tip_comprobante);
			
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
	@RequestMapping(value = "/listarSerie", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<SeriesBean> listarSerie(HttpServletRequest request, HttpServletResponse response) {
		List<SeriesBean> lista = null;
		try {			
			SeriesBean serie = new SeriesBean();			
			// Copia los parametros del cliente al objeto
			BeanUtils.populate(serie, request.getParameterMap());	
			lista = iMaestroService.listarSerie(serie);
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
	@RequestMapping(value = "/grabarseries", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public Integer grabarseries(HttpServletRequest request, HttpServletResponse response) {
		Integer codigo = null;
		try {
			SeriesBean serie = new SeriesBean();	
			
			// Copia los parametros del cliente al objeto
			BeanUtils.populate(serie, request.getParameterMap());
			
			// Retorno los datos de session
			usuarioBean = (UsuarioBean) context().getAttribute("usuarioBean", RequestAttributes.SCOPE_SESSION);
			serie.setVnomusuario(usuarioBean.getDes_usuario());					

			codigo = iMaestroService.grabarseries(serie);
			
		} catch (Exception e) {
			log.error(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(),
									  Constantes.NIVEL_APP_CONSTROLLER, 
									  this.getClass().getName(), e.getMessage()));
		}
		return codigo;
	}
	
}
