<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="es">
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
	<meta charset="utf-8" />
	<title>Reporte Test</title>
	
	<%@ include file="components.jsp"%>
</head>

<body class="no-skin">

	<%@ include file="header_test.jsp"%>

	<!-- /section:basics/navbar.layout -->
	<div class="main-container" id="main-container">

		<%@ include file="menu.jsp"%>

		<div class="main-content">
			<div class="main-content-inner">
				<!-- #section:basics/content.breadcrumbs -->
				<div class="breadcrumbs" id="breadcrumbs">
					<ul class="breadcrumb">
						<li class="active"><i class="ace-icon fa fa-sign-out"></i>
							Reporte Test</li>
					</ul>
				</div>

				<div class="page-content">
					<div class="row">
						<div class="col-xs-12">
							
							<div class="form-group"></div>
							<div class="form-group"></div>
							<div class="form-group"></div>

							<div class="form-group">
								<div class="col-sm-6">
									<button id="btn_reporte_pdf" class="btn btn-sm btn-success" type="button">
										<i class="ace-icon fa fa-plus-square"></i> Reporte PDF
									</button>
								</div>
								
								<div class="col-sm-6">
									<button id="btn_reporte_xls" class="btn btn-sm btn-success" type="button">
										<i class="ace-icon fa fa-plus-square"></i> Reporte XLS
									</button>
								</div>
							</div>
							
						</div>
					</div>
				</div>
				
			</div>
		</div>
		<!-- /.main-content -->

	</div>
	<!-- /.main-container -->

	<%@ include file="scripts_ini.jsp"%>

	<!-- inline scripts related to this page -->
	<script type="text/javascript">
		
			$(document).ready(function() {

				$('#btn_reporte_pdf').click(function(e) {					
					e.preventDefault();
					
					var url = VAR_CONTEXT + '/reporte-test/exportarPdf';
// 					url = url + tipoOrigen + '/' + idAlmacen + '/' + idDdi + '/' + codigo;

					startAjax();

					$.fileDownload(url).done(function(respuesta) {
						endAjax();
						if (respuesta == NOTIFICACION_ERROR) {
							addErrorMessage(null, mensajeReporteError);
						} else {
							addInfoMessage(null, mensajeReporteExito);
						}
					}).fail(function (respuesta) {
						endAjax();
						if (respuesta == NOTIFICACION_ERROR) {
							addErrorMessage(null, mensajeReporteError);
						} else if (respuesta == NOTIFICACION_VALIDACION) {
							addWarnMessage(null, mensajeReporteValidacion);
						}
					});					
					
				});
				
				$('#btn_reporte_xls').click(function(e) {					
					e.preventDefault();
					
// 					var idAlmacen = $('#sel_almacen').val();
// 					var codigoCategoria = $('#sel_cat_producto').val();
// 					var nombreProducto = $('#txt_producto').val().toUpperCase();
// 					var cantidadStock = $('#sel_stock').val();
					var url = VAR_CONTEXT + '/reporte-test/exportarExcel';
// 					url += verificaParametroInt(idAlmacen) + '/';
// 					url += verificaParametro(codigoCategoria) + '/';
// 					url += verificaParametro(nombreProducto) + '/';
// 					url += verificaParametro(cantidadStock);
					
					
					startAjax();
					
					$.fileDownload(url).done(function(respuesta) {
						endAjax();
						if (respuesta == NOTIFICACION_ERROR) {
							addErrorMessage(null, mensajeReporteError);
						} else {
							addInfoMessage(null, mensajeReporteExito);
						}
					}).fail(function (respuesta) {
						
						addErrorMessage(null, mensajeReporteError);
					});				
					
				});
				
			});
	 
		</script>

</body>
</html>
