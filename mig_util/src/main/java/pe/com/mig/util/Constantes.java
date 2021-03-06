package pe.com.mig.util;

import java.io.File;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @className: Constantes.java
 * @description: Clase que guarda las constantes del sistema.
 * @date: 18/02/2015 22:26:30
 * @author: Hernando Huaman.
 */
@SuppressWarnings("javadoc")
public final class Constantes implements Serializable {

	private static final long serialVersionUID = 1L;

	/* MANEJO DE ERRORES */
	public static final String DIVISOR_ERROR_1 	= "[";
	public static final String DIVISOR_ERROR_2	= "]";
	public static final String DIVISOR_ERROR_3 	= ": ";
	public static final String DIVISOR_ERROR_4 	= "ERROR MIG: ";
	public static final String NIVEL_APP_DAO		 = "DAO";
	public static final String NIVEL_APP_SERVICE	 = "SERVICE";
	public static final String NIVEL_APP_CONSTROLLER = "CONTROLLER";
	public static final String NIVEL_APP_REPORTER	 = "REPORTER";
	public static final String ERROR_DOS_REGISTROS   = "query did not return a unique result: 2";

	/* DATOS GENERALES */
	public static final String EMPTY = "";
	public static final short ZERO_SHORT = 0;
	public static final int ZERO_INT = 0;
	public static final long ZERO_LONG = 0;
	public static final String ZERO_STRING = "0";
	public static final short ONE_SHORT = 1;
	public static final int ONE_INT = 1;
	public static final String ONE_STRING = "1";
	public static final short TWO_SHORT = 2;
	public static final int TWO_INT = 2;
	public static final String TWO_STRING = "2";
	public static final short THREE_SHORT = 3;
	public static final int THREE_INT = 3;
	public static final String THREE_STRING = "3";
	public static final short FOUR_SHORT = 4;
	public static final int FOUR_INT = 4;
	public static final String FOUR_STRING = "4";
	public static final short FIVE_SHORT = 5;
	public static final int FIVE_INT = 5;
	public static final String FIVE_STRING = "5";
	public static final short SIX_SHORT = 6;
	public static final String SIX_STRING = "6";
	public static final short SEVEN_SHORT = 7;
	public static final String SEVEN_STRING = "7";
	public static final short EIGHT_SHORT = 8;
	public static final int EIGHT_INT = 8;
	public static final short NINE_SHORT = 9;
	public static final int NINE_INT = 9;
	public static final short TEN_SHORT = 10;
	public static final String CONDICION_Y = "and";
	public static final String CONDICION_O = "or";	
	public static final String CONDICION_I = "i";
	public static final String CONDICION_SI = "si";
	public static final String ESPACIO = " ";
	public static final BigDecimal IGV = BigDecimal.valueOf(0.18);
	public static final String EXPRESION_MONEDA = "###,###,##0.00";
	public static final String EXPRESION_MONEDA_DECIMAL = "###,###,##0.000";
												
	
	/* CODIGO SISTEMA MIG */
	public static final int CODIGO_SISTEMA_MIG = Integer.valueOf(ReadParameterProperties.getPropiedad("codigo.sistema.mig"));
	public static final String CODIGO_MODULO_MIG = "MIYG";
	public static final String CODIGO_ROL_ACTIVO = "1";
	public static final String NOMBRE_MODULO = "Ingresos y Gastos";
	public static final String TABLA_NOMBRE_MODULO = "nombremodulo";
	

	/* ESTADO ACTIVO */
	public static final int ESTADO_INACTIVO = 0;
	public static final int ESTADO_ACTIVO = 1;
	public static final int ESTADO_ELIMINADO = 2;
	
	public static final String FLAG_ACTIVO = "S";
	public static final String FLAG_INACTIVO = "N";
	

	public static final boolean ESTADO_ACTIVO_TRUE = true;
	public static final boolean ESTADO_ACTIVO_FALSE = false;

	public static final boolean ULTIMO_SECUENCIA_TRUE = true;
	public static final boolean ULTIMO_SECUENCIA_FALSE = false;

	/* ESTADOS MIGRACION DE DATOS */
	public static final boolean MIGRADO_TRUE = true;
	public static final boolean MIGRADO_FALSE = false;

	/* RESPUESTAS */
	public static final String RESPUESTA_SI = "Si";
	public static final String RESPUESTA_NO = "No";
	public static final String ACCION_CORRECTA = "Ok";
	public static final String ACCION_CORRECTA_JSON = "{\"success\":1}";

	/* ABREVIATURAS PARTES */
	public static final String PARTE_DEMANDANTE = "DTE";
	public static final String PARTE_DEMANDADO = "DDO";
	public static final short NIVEL_SUB_MENU_PRIMARIO = 1;
	public static final short NIVEL_SUB_MENU_SECUNDARIO = 2;
	public static final short NIVEL_SUB_MENU_TERCIARIO = 3;
	
	/* MARCAS PARA MENSAJES DE ERROR */
	public static final String MARCA_INICIO = ":mi:";
	public static final String MARCA_FINAL = ":mf:";
	public static final String MARCA_ISNULL_OJ = "[isNullcodOJ]";
	public static final String MARCA_EXPEDIENTE = "Nro. Expediente : ";
	public static final String ERROR_GRABAR_ARCHIVO_REPORTE = "Error al guardar el archivo reporte asociado.";
	
	/* TABLAS MAESTRAS */
	public static final String TABLA_EMPRESA = "Tabempresa";
	public static final String TABLA_EMPRESA_CODIGO = "icodempresa";
	public static final String TABLA_EMPRESA_DESCRIPCION = "vrazsocial";
	public static final String TABLA_TIPO_COMPROBANTE = "TTipoComprobante";
	public static final String TABLA_USUARIO = "Tabusuario";
	public static final String TABLA_USUARIO_CODIGO = "icodusuario";
	
	
	/* TABLA UBIGEO Y PAIS */
	public static final short CODIGO_PAIS_PERU = 80;
	public static final short CODIGO_UBIGEO_DPTO_LIMA = 674;
	public static final short CODIGO_UBIGEO_PROV_LIMA = 676;	
	public static final String CODIGO_POSTAL_DPTO_LIMA = "15";
	public static final String CODIGO_POSTAL_PROV_LIMA = "1501";
	public static final short UBIGEO_DEPARTAMENTO = 1;
	public static final short UBIGEO_PROVINCIA = 2;
	public static final short UBIGEO_DISTRITO = 3;
	
	/* UNIDADES DE MEDIDA */
	public static final String UNIDAD_MEDIDA_GLOBAL = "gbl";	

	/* FECHA Y HORA */
	public static final String FORMATO_FECHA = "dd/MM/yyyy";
	public static final String FORMATO_FECHA_DB = "yyyy-MM-dd";
	public static final int DIA_ULTIMA_HORA = 23;
	public static final int DIA_ULTIMO_SEGUNDO = 59;
	public static final long L_23_HOURS_59 = 86400000;
	public static final String COD_FORMATO_FECHA = "104";

	/* PROYECTO */
	public static final BigDecimal AVANCE_CERO_POR_CIENTO = BigDecimal.valueOf(0);
	public static final BigDecimal AVANCE_CIEN_POR_CIENTO = BigDecimal.valueOf(100);

	/* REPORTES */
	public static final String REPORT_PATH = new StringBuilder("page")
			.append(File.separator).append("modulos").append(File.separator)
			.append("reporte").append(File.separator).append("jrxml")
			.append(File.separator).toString();
	public static final String REPORT_JASPER_PATH = new StringBuilder("page")
			.append(File.separator).append("modulos").append(File.separator)
			.append("reporte").append(File.separator).append("jasper")
			.append(File.separator).toString();
	public static final String IMAGE_REPORT_PATH = new StringBuilder("util")
			.append(File.separator).append("images").append(File.separator)
			.append("principal").append(File.separator).append("logo.jpg")
			.toString();
	
	public static final String NOMBRE_REPORTE_ESPPROMAT_DET = "reporteEspMatProDetallado";
	public static final String NOMBRE_REPORTE_ESPPROMAT_EST = "reporteEspMatProEstadistico";
	public static final short TIPO_REPORTE_DETALLADO = 1;
	public static final short TIPO_REPORTE_ESTADISTICO = 2;
	public static final short CODIGO_FORMATO_REPORTE_PDF = 1;
	public static final short CODIGO_FORMATO_REPORTE_XLS = 2;

	/* EXTENSIONES DE ARCHIVO */
	public static final String EXTENSION_FORMATO_PDF = ".pdf";
	public static final String EXTENSION_FORMATO_XLS = ".xls";
	public static final String EXTENSION_FORMATO_DOC = ".doc";
	public static final String EXTENSION_FORMATO_DOCX = ".docx";
	public static final String EXTENSION_FORMATO_JPG = ".jpg";
	public static final String EXTENSION_FORMATO_PNG = ".png";
	public static final String EXTENSION_FORMATO_GIF = ".gif";
	public static final String EXTENSION_FORMATO_RPT = ".rpt";
	public static final String EXTENSION_FORMATO_TXT = ".TXT";
	public static final String EXTENSION_FORMATO_PS4 = ".ps4";
	public static final String EXTENSION_FORMATO_4TA = ".4ta";

	/* MEDIA TYPE */
	public static final String MIME_APPLICATION_DOCX = "application/vnd.openxmlformats-officedocument.wordprocessingml.document";
	public static final String MIME_APPLICATION_DOC = "application/msword";
	public static final String MIME_APPLICATION_PDF = "application/pdf";
	public static final String MIME_APPLICATION_XLS = "application/vnd.ms-excel";
	public static final String MIME_APPLICATION_TXT = "text/plain";
	public static final String MIME_IMAGE_JPG = "image/jpeg";
	public static final String MIME_IMAGE_PNG = "image/png";
	public static final String MIME_IMAGE_GIF = "image/gif";
	
	/* CODIGOS PARA MANEJO DE CADENAS */
	public static final String COD_CADENA_CORTADA = "...(*)";
	public static final String SEPARADOR = "-";
	public static final String DIVISOR = "/";
	public static final String PORCENTAJE = "%";
	public static final String EXPRESION_OR = "||";
	public static final String EXPRESION_AND = "&&";
	public static final String UNDERLINE = "_";
	public static final String PIPELINE = "|";
	public static final String SALTO_LINEA = "\r\n";
	public static final String IMAGEN_NO_DISPONIBLE	= "no-disponible.png";
	
	/* CODIGOS PARA MESES */
	public static final short ENERO = 1;
	public static final short FEBRERO = 2;
	public static final short MARZO = 3;
	public static final short ABRIL = 4;
	public static final short MAYO = 5;
	public static final short JUNIO = 6;
	public static final short JULIO = 7;
	public static final short AGOSTO = 8;
	public static final short SEPTIEMBRE = 9;
	public static final short OCTUBRE = 10;
	public static final short NOVIEMBRE = 11;
	public static final short DICIEMBRE = 12;
	
	/* CODIGO PARA USUARIO VISITANTE Y MENU */
	public static final short CODIGO_USUARIO_VISITANTE = 2;
	public static final short CODIGO_ROL_VISITANTE = 2;
	public static final int CODIGO_MENU_CATEGORIA = 4;
	
	/* CODIGO USUARIO TEMPORAL */
	public static final String CODIGO_USUARIO = "admin";
	public static final int CODIGO_SEDE_CENTRAL = 1;
	
}
