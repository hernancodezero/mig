package pe.com.mig.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.converters.IntegerConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import pe.com.mig.model.bean.DetalleBoletosBean;
import pe.com.mig.model.bean.EntregaBoletosBean;
import pe.com.mig.model.bean.RequeBoletosBean;
import pe.com.mig.model.bean.sernanp.UnidadOperativaBean;
import pe.com.mig.model.bean.sernanp.UsuarioBean;
import pe.com.mig.service.IMaestroService;
import pe.com.mig.service.IRequeBoletosService;
import pe.com.mig.util.Constantes;

/**
 * @className: RequeBoletosController.java
 * @description: 
 * @date: 18 de jul. de 2016
 * @author: SUMERIO.
 */
@Controller
public class RequeBoletosController extends BaseController {

	private static final long serialVersionUID = 1L;
	
	@Autowired 
	private IMaestroService iMaestroService;
	
	@Autowired 
	private IRequeBoletosService iRequeBoletosService;
	
	
	/**
	 * Metodo que retorna a la Bandeja Requerimientos de Boletos.
	 * @return - Retorna a la vista JSP.
	 */
	@RequestMapping("/reqBoletos")
    public ModelAndView reqBoletos() {
		ModelAndView model = new ModelAndView("lis_reg_req_boletos");
		try {
			// Retorno los datos de session
			usuarioBean = (UsuarioBean) context().getAttribute("usuarioBean", RequestAttributes.SCOPE_SESSION);
			// Consultamos si el usuario es de Sede Central
			String ind_sed_principal = null;
			List<UnidadOperativaBean> lis_uni_ope_principal = new ArrayList<UnidadOperativaBean>();
			lis_uni_ope_principal = iMaestroService.verificarSedePrincipal(usuarioBean.getCod_usuario());
			if (!isEmpty(lis_uni_ope_principal)) {
				ind_sed_principal = "1";
			} else {
				ind_sed_principal = "0";
			}
			model.addObject("ind_sed_principal", ind_sed_principal);
			
			List<UnidadOperativaBean> lis_uni_operativa = new ArrayList<UnidadOperativaBean>();	
			if (!isEmpty(lis_uni_ope_principal)) {
				lis_uni_operativa = iMaestroService.listarUnidadOperativa(new UnidadOperativaBean());
			} else {
				lis_uni_operativa = iMaestroService.listarUnidadOperativa(new UnidadOperativaBean(usuarioBean.getCod_usuario()));
			}			
			model.addObject("lis_uni_operativa", lis_uni_operativa);
			
			
			UnidadOperativaBean unidad = new UnidadOperativaBean();
			unidad.setCod_uni_operativa(lis_uni_operativa.get(0).getCod_uni_operativa());
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
	@RequestMapping(value = "/listarRequeBoletos", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<RequeBoletosBean> listarRequeBoletos(HttpServletRequest request, HttpServletResponse response) {
		List<RequeBoletosBean> lista = null;
		try {			
			RequeBoletosBean boleto = new RequeBoletosBean();			
			// Copia los parametros del cliente al objeto
			BeanUtils.populate(boleto, request.getParameterMap());			
			lista = iRequeBoletosService.listarRequeBoletos(boleto);
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
	 * @return Retorna el codigo de la tabla de boleto.
	 */
	@RequestMapping(value = "/grabarRequeBoletos", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public Integer grabarRequeBoletos(HttpServletRequest request, HttpServletResponse response) {
		Integer codigo = null;
		try {
			RequeBoletosBean boleto = new RequeBoletosBean();
			List<DetalleBoletosBean> detalle = new ArrayList<DetalleBoletosBean>();			
			List<EntregaBoletosBean> entrega = new ArrayList<EntregaBoletosBean>();
			
			// Convierte los vacios en nulos en los enteros
			IntegerConverter converter = new IntegerConverter(null); 
			BeanUtilsBean beanUtilsBean = new BeanUtilsBean();
			beanUtilsBean.getConvertUtils().register(converter, Integer.class);
			// Copia los parametros del cliente al objeto
			beanUtilsBean.populate(boleto, request.getParameterMap());
			
			// Retorno los datos de session
			usuarioBean = (UsuarioBean) context().getAttribute("usuarioBean", RequestAttributes.SCOPE_SESSION);
			boleto.setVnomusuario(usuarioBean.getDes_usuario());		
			
			String arr_cod_tar_bol[] = request.getParameter("arr_cod_tar_bol").split("\\|", -1);
			String arr_can_req_bol[] = request.getParameter("arr_can_req_bol").split("\\|", -1);
			String arr_num_req_ini[] = request.getParameter("arr_num_req_ini").split("\\|", -1);
			String arr_num_req_fin[] = request.getParameter("arr_num_req_fin").split("\\|", -1);
			
			for (int i = 0; i < arr_cod_tar_bol.length; i++) {
				DetalleBoletosBean detalleBoletos = new DetalleBoletosBean();
				detalleBoletos.setCod_tar_boleto(getInteger(arr_cod_tar_bol[i]));
				detalleBoletos.setNum_can_boleto(getInteger(arr_can_req_bol[i]));
				detalleBoletos.setNum_inicio(getInteger(arr_num_req_ini[i]));
				detalleBoletos.setNum_final(getInteger(arr_num_req_fin[i]));				
				detalleBoletos.setVnomusuario(usuarioBean.getDes_usuario());
				detalle.add(detalleBoletos);
			}
			
			String cod_tar_bol_dis = request.getParameter("arr_cod_tar_bol_dis");
			if (!isNullOrEmpty(cod_tar_bol_dis)) {
				String arr_cod_tar_bol_dis[] = request.getParameter("arr_cod_tar_bol_dis").split("\\|", -1);
				String arr_num_dis_bol_dis[] = request.getParameter("arr_num_dis_bol_dis").split("\\|", -1);
				String arr_fec_dis_bol_dis[] = request.getParameter("arr_fec_dis_bol_dis").split("\\|", -1);
				String arr_can_dis_bol_dis[] = request.getParameter("arr_can_dis_bol_dis").split("\\|", -1);
				String arr_num_req_ini_dis[] = request.getParameter("arr_num_req_ini_dis").split("\\|", -1);
				String arr_num_req_fin_dis[] = request.getParameter("arr_num_req_fin_dis").split("\\|", -1);
				
				for (int i = 0; i < arr_cod_tar_bol_dis.length; i++) {
					EntregaBoletosBean entregaBoletos = new EntregaBoletosBean();
					entregaBoletos.setCod_tar_boleto(getInteger(arr_cod_tar_bol_dis[i]));					
					entregaBoletos.setNum_acta(arr_num_dis_bol_dis[i]);
					entregaBoletos.setFec_acta(arr_fec_dis_bol_dis[i]);					
					entregaBoletos.setNum_can_boleto(getInteger(arr_can_dis_bol_dis[i]));
					entregaBoletos.setNum_inicio(getInteger(arr_num_req_ini_dis[i]));
					entregaBoletos.setNum_final(getInteger(arr_num_req_fin_dis[i]));				
					entregaBoletos.setVnomusuario(usuarioBean.getDes_usuario());
					entrega.add(entregaBoletos);
				}
			}
			
			// Obtenemos la cantidad boleto entregada por cada detalle
			for (DetalleBoletosBean det : detalle) {
				int can_adi_boleto = 0;
				for (EntregaBoletosBean ent : entrega) {
					if (det.getCod_tar_boleto() == ent.getCod_tar_boleto()) {
						can_adi_boleto = can_adi_boleto + ent.getNum_can_boleto();
					}					
				}
				det.setCan_adi_boleto(can_adi_boleto);
			}
			
			codigo = iRequeBoletosService.grabarRequeBoletos(boleto, detalle, entrega);
			
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
	@RequestMapping(value = "/eliminarRequeBoletos", method = RequestMethod.POST)
	@ResponseBody
	public String eliminarRequeBoletos(HttpServletRequest request, HttpServletResponse response) {
		String estado = null;
		try {			
			RequeBoletosBean boleto = new RequeBoletosBean(getInteger(request.getParameter("codigo")));
			// Retorno los datos de session
			usuarioBean = (UsuarioBean) context().getAttribute("usuarioBean", RequestAttributes.SCOPE_SESSION);
			boleto.setVnomusuario(usuarioBean.getDes_usuario());
			iRequeBoletosService.eliminarRequeBoletos(boleto);
			estado = Constantes.ACCION_CORRECTA_JSON;
		} catch (Exception e) {
			log.error(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(),
									  Constantes.NIVEL_APP_CONSTROLLER, 
									  this.getClass().getName(), e.getMessage()));
		}
		return estado;
	}
	
	/**
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/obtenerRequeBoleto", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public RequeBoletosBean obtenerRequeBoleto(HttpServletRequest request, HttpServletResponse response) {
		RequeBoletosBean requeBoletosBean = new RequeBoletosBean();
		try {	
			RequeBoletosBean boleto = new RequeBoletosBean(getInteger(request.getParameter("codigo")));
			List<RequeBoletosBean> lista = iRequeBoletosService.listarRequeBoletos(boleto);
			requeBoletosBean = lista.get(0);
			
			DetalleBoletosBean det = new DetalleBoletosBean(boleto.getCod_req_boleto());
			List<DetalleBoletosBean> detalle = iRequeBoletosService.listarDetalleBoletos(det);
			requeBoletosBean.setDetalle(detalle);
			
			List<EntregaBoletosBean> entrega = new ArrayList<EntregaBoletosBean>();
			for (DetalleBoletosBean det_boleto : detalle) {
				EntregaBoletosBean ent = new EntregaBoletosBean(det_boleto.getCod_det_boleto());
				List<EntregaBoletosBean> lis_entrega = iRequeBoletosService.listarEntregaBoletos(ent);
				if (!isEmpty(lis_entrega)) {
					int can_saldo = 0;
					int row = 1;
					for (EntregaBoletosBean det_entrega : lis_entrega) {
						EntregaBoletosBean ent_boleto = det_entrega;
						if (row == 1) {							
							can_saldo = det_boleto.getNum_can_boleto() - ent_boleto.getNum_can_boleto();							
						} else {
							can_saldo = can_saldo - ent_boleto.getNum_can_boleto();
						}
						ent_boleto.setCan_sal_bol(can_saldo);
						entrega.add(ent_boleto);
						row++;
					}
				}
			}
			
			requeBoletosBean.setEntrega(entrega);
		
		} catch (Exception e) {
			log.error(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(),
									  Constantes.NIVEL_APP_CONSTROLLER, 
									  this.getClass().getName(), e.getMessage()));
		}
		return requeBoletosBean;
	}

}
