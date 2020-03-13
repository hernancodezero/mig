package pe.com.mig.web.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
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

import pe.com.mig.model.bean.CartaFianzaBean;
import pe.com.mig.model.bean.EntidadFinancieraBean;
import pe.com.mig.model.bean.TipoComprobanteBean;
import pe.com.mig.model.bean.TipoDocumentoBean;
import pe.com.mig.model.bean.sernanp.UnidadOperativaBean;
import pe.com.mig.model.bean.sernanp.UsuarioBean;
import pe.com.mig.service.IMaestroService;
import pe.com.mig.util.Constantes;
import pe.com.mig.web.commons.Reporteador;

/**
 * @className: MantenimientoFinancieroController.java
 * @description: 
 * @date: 23 de jun. de 2016
 * @author: Administrador.
 */
@Controller
public class CartaFianzaController extends BaseController {

	private static final long serialVersionUID = 1L;
	
	@Autowired 
	private IMaestroService iMaestroService;
	
	/**
	 * Metodo que retorna a la Bandeja Mantenimiento Financiero.
	 * @return - Retorna a la vista JSP.
	 */
	@RequestMapping("/mantenimientoCartaFianza")
    public ModelAndView mantenimientoCartaFianza() {
		ModelAndView model = new ModelAndView("lis_reg_carta_fianza");		
		try {			
			// Retorno los datos de session
			usuarioBean = (UsuarioBean) context().getAttribute("usuarioBean", RequestAttributes.SCOPE_SESSION);

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
			
			List<EntidadFinancieraBean> lis_financiero = new ArrayList<EntidadFinancieraBean>();		
			lis_financiero = iMaestroService.listarFinanciero(new EntidadFinancieraBean());			
			model.addObject("lis_financiero", lis_financiero);
			
			List<TipoComprobanteBean> lis_tip_comprobante = new ArrayList<TipoComprobanteBean>();		
			lis_tip_comprobante = iMaestroService.listarTipoComprobante(new TipoComprobanteBean(Constantes.FLAG_ACTIVO));			
			model.addObject("lis_tip_comprobante", lis_tip_comprobante);
			
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
	 * @return
	 */
	@RequestMapping(value = "/listarCartaFianza", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<CartaFianzaBean> listarCartaFianza(HttpServletRequest request, HttpServletResponse response) {
		List<CartaFianzaBean> lista = null;
		try {			
			CartaFianzaBean financiero = new CartaFianzaBean();			
			// Copia los parametros del cliente al objeto
			BeanUtils.populate(financiero, request.getParameterMap());	
			lista = iMaestroService.listarCartaFianza(financiero);
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
	@RequestMapping(value = "/grabarCartaFianza", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public Integer grabarCartaFianza(HttpServletRequest request, HttpServletResponse response) {
		Integer codigo = null;
		try {
			CartaFianzaBean CartaFianzaBean = new CartaFianzaBean();	
			
			// Copia los parametros del cliente al objeto
			BeanUtils.populate(CartaFianzaBean, request.getParameterMap());
			
			// Retorno los datos de session*
			usuarioBean = (UsuarioBean) context().getAttribute("usuarioBean", RequestAttributes.SCOPE_SESSION);
			CartaFianzaBean.setVnomusuario(usuarioBean.getDes_usuario());					

			codigo = iMaestroService.grabarCartaFianza(CartaFianzaBean);
			
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
	 */
	@RequestMapping(value = "/imprimirCartaFianza")
	public void imprimirCartaFianza(HttpServletRequest request, HttpServletResponse response) {
 
		final ServletContext servletContext = request.getSession().getServletContext();
	    final File tempDirectory = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
	    final String temperotyFilePath = tempDirectory.getAbsolutePath();
 
	    String fileName = "Carta_Fianza.pdf";
	    response.setContentType(Constantes.MIME_APPLICATION_PDF);
	    response.setHeader("Content-disposition", "attachment; filename="+ fileName);
	    
	    String fil_busqueda = request.getParameter("fil_busqueda");
    	String[] arr_busqueda = fil_busqueda.split(Constantes.UNDERLINE);
    	
	    try {
	    	CartaFianzaBean carta = new CartaFianzaBean();
	      	carta.setChrNumCarta(arr_busqueda[0]); // Añades los parametros
	      	carta.setChrTipOperacion(arr_busqueda[1]);
	    	carta.setCod_uni_operativa(getInteger(arr_busqueda[2]));
	    	carta.setCod_reg_nac(getInteger(arr_busqueda[3]));
	    	carta.setDteFecInicio(arr_busqueda[4]);
	    	carta.setDteFecFinal(arr_busqueda[5]);
	    	List<CartaFianzaBean> lista = iMaestroService.listarCartaFianza(carta);
	    	
	    	if (getInteger(arr_busqueda[6]) == 1) {
	    	String ruta = temperotyFilePath + "\\" + fileName;
	    	Reporteador rep = new Reporteador();
	       	rep.generaPDFCartaFianza(ruta, lista);

	        ByteArrayOutputStream baos = new ByteArrayOutputStream();
	        baos = convertPDFToByteArrayOutputStream(temperotyFilePath+"\\"+fileName);
	        OutputStream os = response.getOutputStream();
	        baos.writeTo(os);
	        os.flush();
	        
	    	}else {
	    	String file_name = "Carta_Fianza";
	    	file_name = file_name.concat(Constantes.EXTENSION_FORMATO_XLS);
            response.setContentType(Constantes.MIME_APPLICATION_XLS);
            response.setHeader("Content-Disposition", "attachment; filename=" + file_name);				
		    Reporteador rep = new Reporteador();
	    	rep.generaExcelReporteCartaFianza(response, lista);
	    	}
	    } catch (Exception e) {
	    	log.error(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(),
					  Constantes.NIVEL_APP_CONSTROLLER, 
					  this.getClass().getName(), e.getMessage()));
	    } 
	}
	
}
