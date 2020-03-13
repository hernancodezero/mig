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

import pe.com.mig.model.bean.ProveedorBean;
import pe.com.mig.model.bean.TipoDocumentoBean;
import pe.com.mig.model.bean.sernanp.UnidadOperativaBean;
import pe.com.mig.model.bean.sernanp.UsuarioBean;
import pe.com.mig.service.IMaestroService;
import pe.com.mig.util.Constantes;

/**
 * @className: MantenimientoProveedoresController.java
 * @description: 
 * @date: 23 de jun. de 2016
 * @author: Administrador.
 */
@Controller
public class MantenimientoProveedoresController extends BaseController {

	private static final long serialVersionUID = 1L;
	
	@Autowired 
	private IMaestroService iMaestroService;
	

	/**
	 * Metodo que retorna a la Bandeja Registro de Cuarta Categoria.
	 * @return - Retorna a la vista JSP.
	 */
	@RequestMapping("/mantenimientoProveedores")
    public ModelAndView mantenimientoProveedores() {
		ModelAndView model = new ModelAndView("mnt_proveedores");		
		try {
			List<TipoDocumentoBean> lis_tip_documento = new ArrayList<TipoDocumentoBean>();		
			lis_tip_documento = iMaestroService.listarTipoDocumento(new TipoDocumentoBean());			
			model.addObject("lis_tip_documento", lis_tip_documento);
			
			// Retorno los datos de session
			usuarioBean = (UsuarioBean) context().getAttribute("usuarioBean", RequestAttributes.SCOPE_SESSION);
			
			List<UnidadOperativaBean> lis_uni_operativa = new ArrayList<UnidadOperativaBean>();		
			lis_uni_operativa = iMaestroService.listarUnidadOperativa(new UnidadOperativaBean(usuarioBean.getCod_usuario()));			
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
	@RequestMapping(value = "/listarProveedor", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<ProveedorBean> listarProveedor(HttpServletRequest request, HttpServletResponse response) {
		List<ProveedorBean> lista = null;
		try {			
			ProveedorBean proveedor = new ProveedorBean();			
			// Copia los parametros del cliente al objeto
			BeanUtils.populate(proveedor, request.getParameterMap());	
			lista = iMaestroService.listarProveedor(proveedor);
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
	@RequestMapping(value = "/registrarProveedor", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public Integer registrarProveedor(HttpServletRequest request, HttpServletResponse response) {
		Integer codigo = null;
		try {
			ProveedorBean proveedor = new ProveedorBean();	
			
			// Copia los parametros del cliente al objeto
			BeanUtils.populate(proveedor, request.getParameterMap());
			
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
	 * @return
	 */
	@RequestMapping(value = "/verificarRucMantenimiento", method = RequestMethod.GET)
	@ResponseBody
	public ProveedorBean verificarRucMantenimiento(HttpServletRequest request, HttpServletResponse response) {
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
	
	
}
