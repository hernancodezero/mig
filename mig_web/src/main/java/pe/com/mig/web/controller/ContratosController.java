package pe.com.mig.web.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import pe.com.mig.model.bean.ContratosBean;
import pe.com.mig.model.bean.DetalleContratosBean;
import pe.com.mig.model.bean.TipoDocumentoBean;
import pe.com.mig.model.bean.TipoMonedaBean;
import pe.com.mig.model.bean.sernanp.UnidadOperativaBean;
import pe.com.mig.model.bean.sernanp.UsuarioBean;
import pe.com.mig.service.IContratosService;
import pe.com.mig.service.IMaestroService;
import pe.com.mig.util.Constantes;

/**
 * @className: ContratosController.java
 * @description: 
 * @date: 25 de jun. de 2016
 * @author: SUMERIO.
 */
@Controller
public class ContratosController extends BaseController {

	private static final long serialVersionUID = 1L;
	
	@Autowired 
	private IMaestroService iMaestroService;
	
	@Autowired 
	private IContratosService iContratosService;
	
	/**
	 * Metodo que retorna a la Bandeja Registro de Compras.
	 * @return - Retorna a la vista JSP.
	 */
	@RequestMapping("/registroContratos")
    public ModelAndView registroContratos() {
		ModelAndView model = new ModelAndView("lis_reg_contratos");		
		try {
			// Retorno los datos de session
				usuarioBean = (UsuarioBean) context().getAttribute("usuarioBean", RequestAttributes.SCOPE_SESSION);
				
				List<TipoMonedaBean> lis_tip_moneda = new ArrayList<TipoMonedaBean>();		
				lis_tip_moneda = iMaestroService.listarTipoMoneda(new TipoMonedaBean(Constantes.FLAG_ACTIVO));			
				model.addObject("lis_tip_moneda", lis_tip_moneda);
				
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
				unidad.setInd_uni_operativa(1);
				List<UnidadOperativaBean> lis_anp = iMaestroService.listarUnidadOperativa(unidad);			

				model.addObject("lis_anp", lis_anp);
						
						List<TipoDocumentoBean> lis_tip_documento = new ArrayList<TipoDocumentoBean>();		
						lis_tip_documento = iMaestroService.listarTipoDocumento(new TipoDocumentoBean(Constantes.FLAG_ACTIVO));			
						model.addObject("lis_tip_documento", lis_tip_documento);
					 
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
	 * @return Retorna el codigo de la tabla de contratos.
	 */
	@RequestMapping(value = "/grabarContratos", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public Integer grabarContratos(HttpServletRequest request, HttpServletResponse response) {
		Integer codigo = null;
		try {
			ContratosBean contrato = new ContratosBean();			
			BeanUtilsBean beanUtilsBean = new BeanUtilsBean();
			// Copia los parametros del cliente al objeto
			beanUtilsBean.populate(contrato, request.getParameterMap());
			
			// Retorno los datos de session
			usuarioBean = (UsuarioBean) context().getAttribute("usuarioBean", RequestAttributes.SCOPE_SESSION);
			contrato.setVnomusuario(usuarioBean.getDes_usuario());
						
			
			String arr_detalle = request.getParameter("arr_detalle");
			String[] detalleString = arr_detalle.split("_");
			List<DetalleContratosBean> listaDetalleContrato = new ArrayList<DetalleContratosBean>();
			for(String detalle  : detalleString)
			{
				String[] arrDetalle = detalle.split("\\|");
				if (arrDetalle != null && arrDetalle.length>0 && !isNullOrEmpty(arrDetalle[0])) {
					int mes = Integer.parseInt(arrDetalle[0]);
					BigDecimal monto_mes = BigDecimal.valueOf(Double.parseDouble(arrDetalle[1]));
					String fec_pago = arrDetalle[2];
					
					DetalleContratosBean detalleContrato = new DetalleContratosBean();
					detalleContrato.setMes(mes);
					detalleContrato.setMonto_mes(monto_mes);
					detalleContrato.setFec_pago(fec_pago);
					if (!isNullOrEmpty(arrDetalle[3])) {
						Integer chrNumCompPago = getInteger(arrDetalle[3]);
						detalleContrato.setChrNumCompPago(chrNumCompPago);
					}
					if (!isNullOrEmpty(arrDetalle[4])) {
						String dteFecCompPago = arrDetalle[4];
						detalleContrato.setDteFecCompPago(dteFecCompPago);
					}
					
					listaDetalleContrato.add(detalleContrato);					
				}
			}
			
			codigo = iContratosService.grabarContrato(contrato, listaDetalleContrato);
			
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
	 * @return Actualiza el estado de contrato.
	 */
	@RequestMapping(value = "/eliminarContrato", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public Integer eliminarContrato(HttpServletRequest request, HttpServletResponse response) {
		Integer codigo = null;
		try {
			ContratosBean contrato = new ContratosBean();			
			BeanUtilsBean beanUtilsBean = new BeanUtilsBean();
			// Copia los parametros del cliente al objeto
			beanUtilsBean.populate(contrato, request.getParameterMap());
			
			// Retorno los datos de session
			usuarioBean = (UsuarioBean) context().getAttribute("usuarioBean", RequestAttributes.SCOPE_SESSION);
			contrato.setVnomusuario(usuarioBean.getDes_usuario());
			
			iContratosService.eliminarContrato(contrato);
			
		} catch (Exception e) {
			log.error(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(),
					  Constantes.NIVEL_APP_CONSTROLLER, 
					  this.getClass().getName(), e.getMessage()));
		}
		return 0;
	}
	/**
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/listarContratos", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<ContratosBean> listarContratos(HttpServletRequest request, HttpServletResponse response) {
		List<ContratosBean> lista = null;
		try {			
			ContratosBean contrato = new ContratosBean();
			// Copia los parametros del cliente al objeto
			BeanUtils.populate(contrato, request.getParameterMap());
			lista = iContratosService.listarContrato(contrato);
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
	@RequestMapping(value = "/listarDetallesContrato", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<DetalleContratosBean> listarDetallesContrato(HttpServletRequest request, HttpServletResponse response) {
		List<DetalleContratosBean> lista = null;
		try {			
			DetalleContratosBean detalle = new DetalleContratosBean();
			// Copia los parametros del cliente al objeto
			BeanUtils.populate(detalle, request.getParameterMap());
			lista = iContratosService.listarDetalleContrato(detalle);
		} catch (Exception e) {
			log.error(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(),
									  Constantes.NIVEL_APP_CONSTROLLER, 
									  this.getClass().getName(), e.getMessage()));
		}
		return lista;
	}

}
