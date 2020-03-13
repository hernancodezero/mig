<!-- basic scripts -->

<!--[if !IE]> -->
<script type="text/javascript">
	window.jQuery || document.write("<script src='${pageContext.request.contextPath}/resources/js/jquery.js'>"+"<"+"/script>");
</script>

<!-- <![endif]-->

<!--[if IE]>
	<script type="text/javascript">
	 	window.jQuery || document.write("<script src='${pageContext.request.contextPath}/resources/js/jquery1x.js'>"+"<"+"/script>");
	</script>
<![endif]-->

<script type="text/javascript">
	if ('ontouchstart' in document.documentElement) {
		 document.write("<script src='${pageContext.request.contextPath}/resources/js/jquery.mobile.custom.js'>"+"<"+"/script>");
	}
</script>

<script src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>

<!-- page specific plugin scripts -->
<script src="${pageContext.request.contextPath}/resources/js/jquery-ui.custom.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.ui.touch-punch.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/chosen.jquery.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/fuelux/fuelux.spinner.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/date-time/bootstrap-datepicker.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrap-tag.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.maskedinput.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/dataTables/jquery.dataTables.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/dataTables/jquery.dataTables.bootstrap.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/dataTables/extensions/TableTools/js/dataTables.tableTools.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/dataTables/extensions/ColVis/js/dataTables.colVis.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.gritter.js"></script>

<script src="${pageContext.request.contextPath}/resources/js/general.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/bootbox.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jasny-bootstrap.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jstree.min.js"></script>


<!-- ace scripts -->
<script src="${pageContext.request.contextPath}/resources/js/ace/elements.scroller.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/ace/elements.colorpicker.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/ace/elements.fileinput.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/ace/elements.typeahead.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/ace/elements.wysiwyg.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/ace/elements.spinner.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/ace/elements.treeview.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/ace/elements.wizard.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/ace/elements.aside.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/ace/ace.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/ace/ace.ajax-content.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/ace/ace.touch-drag.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/ace/ace.sidebar.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/ace/ace.sidebar-scroll-1.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/ace/ace.submenu-hover.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/ace/ace.widget-box.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/ace/ace.settings.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/ace/ace.settings-rtl.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/ace/ace.settings-skin.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/ace/ace.widget-on-reload.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/ace/ace.searchbox-autocomplete.js"></script>


<script src="${pageContext.request.contextPath}/resources/js/jquery.fileDownload-1.4.0.js"></script>

<script type="text/javascript">
	// CODIGOS DE RETORNO GENERALES
	var NOTIFICACION_VIGENCIA = '03';
	var NOTIFICACION_VALIDACION = '02';
	var NOTIFICACION_OK = '01';
	var NOTIFICACION_ERROR = '00';
	var CODIGO_DDI_INDECI_CENTRAL = '27';
	var ESTADO_GENERADO = '13';
	var ESTADO_APROBADO = '3';
	var ESTADO_AJUSTE = '14';
	var ESTADO_ANULADO = '0';
	var ESTADO_ACTIVO = '1';
	var RUTA_PDF = "mig_web/resources/";
	
	var mensajeReporteExito = 'El archivo se descarg&oacute; exitosamente.';
	var mensajeReporteError = 'No se pudo completar la descarga del archivo, por favor intentar nuevamente.';
	var mensajeCargaArchivoError = 'No se pudo completar la carga del archivo, por favor intentar nuevamente.';
	var mensajeReporteValidacion = 'No cuenta con registros asociados para generar el reporte.';
	var mensajeReporteRegistroValidacion = 'No se encuentran registros para generar el reporte.';
	var mensajeValidacionSeleccionarRegistro = 'Debe de seleccionar por lo menos un registro.';
	var mensajeValidacionSeleccionarSoloUnRegistro = 'Debe de seleccionar solo un registro.';
	var mensajeValidacionAnulado = 'No se puede editar el registro porque se encuentra en estado anulado.';
	var mensajeValidacionDocumento = 'No dispone de documento adjunto asociado.';
	var mensajeValidacionSinRegistros = 'No se encuentran registros para generar el proceso.';
	var mensajeValidacionAnioMesCerrado = 'La fecha no corresponde al año y mes de trabajo.';
	var mensajeValidacionEdicionAnioMesCerrado = 'El registro no se puede editarse porque el mes está cerrado.';
	var mensajeConfirmacionEliminacionVariosRegistros = 'Está seguro de eliminar los siguientes registros ?';
	var mensajeConfirmacionEliminacionSoloUnRegistro = 'Está seguro de eliminar el registro ?';
</script>
