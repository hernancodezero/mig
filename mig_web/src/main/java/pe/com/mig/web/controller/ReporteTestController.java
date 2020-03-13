/**
 * 
 */
package pe.com.mig.web.controller;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import pe.com.mig.model.bean.TipoComprobanteBean;
import pe.com.mig.util.Constantes;
import pe.com.mig.util.ExportarArchivo;

/**
 * @author 1607314
 *
 */
@Controller
@RequestMapping("/reporte-test")
public class ReporteTestController extends BaseController {

	private static final long serialVersionUID = 1L;
	
	
	/**
	 * Metodo que retorna a la Bandeja Registro de Cuarta Categoria.
	 * @return - Retorna a la vista JSP.
	 */
	@RequestMapping("/mantenimientoReporteTest")
    public ModelAndView mantenimientoReporteTest() {
		ModelAndView model = new ModelAndView("reporte_test");	
		try {
//			List<UnidadOperativaBean> lis_uni_operativa = new ArrayList<UnidadOperativaBean>();		
//			lis_uni_operativa = iMaestroService.listarUnidadOperativa(new UnidadOperativaBean());			
//			model.addObject("lis_uni_operativa", lis_uni_operativa);
			
		} catch (Exception e) {
			log.error(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(),
									  Constantes.NIVEL_APP_CONSTROLLER, 
									  this.getClass().getName(), e.getMessage()));
		}		
		return model;
    }
	
	/**
	 * @param tipoOrigen 
	 * @param idAlmacen 
	 * @param idDdi 
	 * @param idProducto 
	 * @param request 
	 * @param response
	 * @return Objeto.
	 */
	@RequestMapping(value = "/exportarPdf", method = RequestMethod.GET)
	@ResponseBody
	public String exportarPdf(HttpServletRequest request, HttpServletResponse response) {
		try {
				
			List<TipoComprobanteBean> lista_tipo_comprobante = new ArrayList<TipoComprobanteBean>();
			
			TipoComprobanteBean tipoComprobanteBean_1 = new TipoComprobanteBean();
			tipoComprobanteBean_1.setCod_comprobante(1);
			tipoComprobanteBean_1.setNom_comprobante("000000045");
			tipoComprobanteBean_1.setCompras("ARROZ GRANEL");
			lista_tipo_comprobante.add(tipoComprobanteBean_1);
			
			TipoComprobanteBean tipoComprobanteBean_2 = new TipoComprobanteBean();
			tipoComprobanteBean_2.setCod_comprobante(2);
			tipoComprobanteBean_2.setNom_comprobante("000000046");
			tipoComprobanteBean_2.setCompras("ARROZ COSTEÑA");
			lista_tipo_comprobante.add(tipoComprobanteBean_2);
			
			String nombreAlmacen = "ALMACEN LURIN";
			
			/////////////////////////////////////////////////////////
			
			ExportarArchivo printer = new ExportarArchivo();
			StringBuilder jasperFile = new StringBuilder();
			jasperFile.append(getPath(request));
			jasperFile.append(File.separator);
			jasperFile.append(Constantes.REPORT_PATH_ALMACENES);
			jasperFile.append("Stock_Almacen.jrxml");
			
			Map<String, Object> parameters = new HashMap<String, Object>();

			// Agregando los parámetros del reporte
			StringBuilder logo_indeci_path = new StringBuilder();
			logo_indeci_path.append(getPath(request));
			logo_indeci_path.append(File.separator);
			logo_indeci_path.append(Constantes.IMAGE_REPORT_PATH);
			parameters.put("P_LOGO_INDECI", logo_indeci_path.toString());
			parameters.put("P_ALMACEN", nombreAlmacen);
//			parameters.put("P_NRO_KARDEX", stockAlmacen.getNroKardex());			
//			parameters.put("P_NOMBRE_PRODUCTO", stockAlmacen.getNombreAlmacen());
//			parameters.put("P_CODIGO", stockAlmacen.getCodigoProducto());


			byte[] array = printer.exportPdf(jasperFile.toString(), parameters, lista_tipo_comprobante);
			InputStream input = new ByteArrayInputStream(array);
	        
	        String file_name = "Reporte_Stock_Almacen";
			file_name = file_name.concat(Constantes.EXTENSION_FORMATO_PDF);
	    	
	        response.resetBuffer();
            response.setContentType(Constantes.MIME_APPLICATION_PDF);
            response.setHeader("Content-Disposition", "attachment; filename="+file_name);            
			response.setHeader("Pragma", "no-cache");
			response.setHeader("Cache-Control", "no-store");
			response.setHeader("Pragma", "private");
			response.setHeader("Set-Cookie", "fileDownload=true; path=/");
			response.setDateHeader("Expires", 1);
			
			byte[] buffer = new byte[4096];
	    	int n = 0;

	    	OutputStream output = response.getOutputStream();
	    	while ((n = input.read(buffer)) != -1) {
	    	    output.write(buffer, 0, n);
	    	}
	    	output.close();

	    	return Constantes.COD_EXITO_GENERAL;
	    } catch (Exception e) {
	    	log.error(e.getMessage(), e);
	    	return Constantes.COD_ERROR_GENERAL;
	    } 
	}
	
	/**
	 * @param idAlmacen 
	 * @param codigoCategoria 
	 * @param nombreProducto
	 * @param response
	 * @return Objeto.
	 */
	@RequestMapping(value = "/exportarExcel", method = RequestMethod.GET)
	@ResponseBody
	public String exportarExcel(HttpServletRequest request, HttpServletResponse response) {
	    try {
/*	    	StockAlmacenBean stockAlmacenBean = new StockAlmacenBean();
	    	stockAlmacenBean.setIdAlmacen(idAlmacen);
	    	stockAlmacenBean.setCodigoCategoria(verificaParametro(codigoCategoria));
	    	stockAlmacenBean.setNombreProducto(verificaParametro(nombreProducto));
	    	stockAlmacenBean.setCantidadStock(cantidadStock);
	    	stockAlmacenBean.setTipoOrigen(Constantes.TIPO_ORIGEN_ALMACENES);
	    	
			List<StockAlmacenBean> lista = logisticaService.listarStockAlmacen(stockAlmacenBean);
	    	
			String file_name = "StockAlmacen";
			file_name = file_name.concat(Constantes.EXTENSION_FORMATO_XLS);
			
			ReporteStockAlmacen reporte = new ReporteStockAlmacen();
		    HSSFWorkbook wb = reporte.generaReporteExcelStockAlmacen(lista);
			
			response.resetBuffer();
            response.setContentType(Constantes.MIME_APPLICATION_XLS);
            response.setHeader("Content-Disposition", "attachment; filename="+file_name);            
			response.setHeader("Pragma", "no-cache");
			response.setHeader("Cache-Control", "no-store");
			response.setHeader("Pragma", "private");
			response.setHeader("Set-Cookie", "fileDownload=true; path=/");
			response.setDateHeader("Expires", 1);
            
		    // Captured backflow
	    	OutputStream out = response.getOutputStream();
	    	wb.write(out); // We write in that flow
	    	out.flush(); // We emptied the flow
	    	out.close(); // We close the flow
*/	    	
	    	
	    	List<TipoComprobanteBean> lista_tipo_comprobante = new ArrayList<TipoComprobanteBean>();
			
			TipoComprobanteBean tipoComprobanteBean_1 = new TipoComprobanteBean();
			tipoComprobanteBean_1.setCod_comprobante(1);
			tipoComprobanteBean_1.setNom_comprobante("000000045");
			tipoComprobanteBean_1.setCompras("ARROZ GRANEL");
			lista_tipo_comprobante.add(tipoComprobanteBean_1);
			
			TipoComprobanteBean tipoComprobanteBean_2 = new TipoComprobanteBean();
			tipoComprobanteBean_2.setCod_comprobante(2);
			tipoComprobanteBean_2.setNom_comprobante("000000046");
			tipoComprobanteBean_2.setCompras("ARROZ COSTEÑA");
			lista_tipo_comprobante.add(tipoComprobanteBean_2);
			
			String nombreAlmacen = "ALMACEN LURIN";
			
			/////////////////////////////////////////////////////////
			
			ExportarArchivo printer = new ExportarArchivo();
			StringBuilder jasperFile = new StringBuilder();
			jasperFile.append(getPath(request));
			jasperFile.append(File.separator);
			jasperFile.append(Constantes.REPORT_PATH_ALMACENES);
			jasperFile.append("Stock_Almacen.jrxml");
			
			Map<String, Object> parameters = new HashMap<String, Object>();

			// Agregando los parámetros del reporte
			StringBuilder logo_indeci_path = new StringBuilder();
			logo_indeci_path.append(getPath(request));
			logo_indeci_path.append(File.separator);
			logo_indeci_path.append(Constantes.IMAGE_REPORT_PATH);
			parameters.put("P_LOGO_INDECI", logo_indeci_path.toString());
			parameters.put("P_ALMACEN", nombreAlmacen);
//			parameters.put("P_NRO_KARDEX", stockAlmacen.getNroKardex());			
//			parameters.put("P_NOMBRE_PRODUCTO", stockAlmacen.getNombreAlmacen());
//			parameters.put("P_CODIGO", stockAlmacen.getCodigoProducto());


			byte[] array = printer.exportXls(jasperFile.toString(), parameters, lista_tipo_comprobante, true);
			
			InputStream input = new ByteArrayInputStream(array);
	        
	        String file_name = "Reporte_Stock_Almacen";
			file_name = file_name.concat(Constantes.EXTENSION_FORMATO_XLS);
	    	
	        response.resetBuffer();
            response.setContentType(Constantes.MIME_APPLICATION_XLS);
            response.setHeader("Content-Disposition", "attachment; filename="+file_name);            
			response.setHeader("Pragma", "no-cache");
			response.setHeader("Cache-Control", "no-store");
			response.setHeader("Pragma", "private");
			response.setHeader("Set-Cookie", "fileDownload=true; path=/");
			response.setDateHeader("Expires", 1);
			
			byte[] buffer = new byte[4096];
	    	int n = 0;

	    	OutputStream output = response.getOutputStream();
	    	while ((n = input.read(buffer)) != -1) {
	    	    output.write(buffer, 0, n);
	    	}
	    	output.close();
	    	
	    	return Constantes.COD_EXITO_GENERAL;   	
	    } catch (Exception e) {
	    	log.error(e.getMessage(), e);
	    	return Constantes.COD_ERROR_GENERAL;
	    } 
	}

}
