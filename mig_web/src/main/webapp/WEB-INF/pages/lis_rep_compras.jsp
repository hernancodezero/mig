<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta charset="utf-8" />
		<title>Reportes de Compras</title>

		<%@ include file="components.jsp" %>
	</head>

	<body class="no-skin">
		
		<%@ include file="header.jsp" %>
		
		<!-- /section:basics/navbar.layout -->
		<div class="main-container" id="main-container">

			<%@ include file="menu.jsp" %>
			
			<div class="main-content">
				<div class="main-content-inner">				
					<!-- #section:basics/content.breadcrumbs -->
					<div class="breadcrumbs" id="breadcrumbs">
						<ul class="breadcrumb">						
							<li class="active">
								<i class="ace-icon fa fa-sign-out"></i>
								Compras
							</li>
							<li class="active">Reportes</li>
						</ul>
					</div>
			
					<div class="page-content">		
						<div class="row">
							<div class="col-xs-12">
								<form id="frm_rep_compras" class="form-horizontal" role="form" method="get" 
								  	  action="${pageContext.request.contextPath}/imprimirReporteCompras">
								  	  
									<input type="hidden" id="hid_fil_busqueda" name="fil_busqueda">  	  
									
									<fieldset class="fsStyle">
										<legend class="legendStyle">Filtros para la Búsqueda de Información</legend>
										
										<div class="form-group">
											<div class="col-sm-10">
												<div class="form-group">																									
													<label class="col-sm-3 control-label label-sm no-padding-left">Tipo de Operación:</label>
														
													<div class="col-sm-2">
														<div class="radio">
															<label class="input-sm">
																<input type="radio" class="ace input-sm" name="rb_tip_operacion" value="1">
																<span class="lbl"> U.O.</span>
															</label>
														</div>
													</div>
													
													<div class="col-sm-2">	
														<div class="radio">
															<label class="input-sm">
																<input type="radio" class="ace input-sm" name="rb_tip_operacion" value="2">
																<span class="lbl"> Sede</span>
															</label>
														</div>
													</div>
													
													<label class="col-sm-2 control-label label-sm no-padding-right">Tipo de Reporte:</label>
													<div class="col-sm-3">
														<select id="sel_tip_reporte" class="form-control input-sm">
															<option value="1">Consolidado de Partidas por Rendición de Cuenta</option>
															<option value="2">Documentos de la Rendición de Cuenta</option>
															<option value="3">Reporte de Compras</option>
															<option value="4">Registro de Compras</option>
														</select>
													</div>											
												</div>
																
												<div class="form-group">
													<label class="col-sm-2 control-label label-sm no-padding-right">Nro R/C:</label>
													<div class="col-sm-2">
														<input type="text" id="txt_nro_rc" class="form-control input-sm" maxlength="15" />
													</div>
													
													<label class="col-sm-2 control-label label-sm no-padding-right">Ruc:</label>
													<div class="col-sm-2">
														<input type="text" id="txt_ruc" class="form-control input-sm onlyNumbers" maxlength="11" />
													</div>
													
													<label class="col-sm-2 control-label label-sm no-padding-right">Nro C/P:</label>
													<div class="col-sm-2">
														<input type="text" id="txt_nro_cp" class="form-control input-sm onlyNumbers" maxlength="10" />
													</div>
												</div>
													
												<div class="form-group">
													<label class="col-sm-2 control-label label-sm no-padding-right">U.O. Solicitante:</label>
													<div class="col-sm-2">
														<select id="sel_uni_operativa" class="form-control input-sm">
															<option value=''>&#60Seleccione&#62</option>
															<c:forEach items="${lis_uni_operativa}" var="item">
															    <option value="${item.cod_uni_operativa}">${item.des_uni_operativa}</option>
															</c:forEach>
														</select>
													</div>
																																		
													<label class="col-sm-2 control-label label-sm no-padding-right">ANP:</label>
													<div class="col-sm-2">
														<select id="sel_anp" class="form-control input-sm">
														</select>
													</div>
													
													<label class="col-sm-2 control-label label-sm no-padding-right">Año:</label>
													<div class="col-sm-2">
														<select id="sel_anno" class="form-control input-sm">
															<option value="">Seleccione</option>
															<script>
															var myDate = new Date();
															var year = myDate.getFullYear();
															for(var i = 2017; i < year+1; i++){
															document.write('<option value="'+i+'">'+i+'</option>');
															}
															</script>	
														</select>												
													</div>
												</div>
												
												<div class="form-group">
													<label class="col-sm-2 control-label label-sm no-padding-right">Fecha Inicial:</label>
													<div class="col-sm-2">
														<div class="input-group">
															<input class="form-control input-sm date-picker" id="txt_fec_inicial" type="text" />
															<span class="input-group-addon" id="sp_ico_fec_inicial">
																<i class="fa fa-calendar bigger-110"></i>
															</span>
														</div>
													</div>
													
													<label class="col-sm-2 control-label label-sm no-padding-right">Fecha Final:</label>
													<div class="col-sm-2">
														<div class="input-group">
															<input class="form-control input-sm date-picker" id="txt_fec_final" type="text" />
															<span class="input-group-addon" id="sp_ico_fec_final">
																<i class="fa fa-calendar bigger-110"></i>
															</span>
														</div>
													</div>
													
													<label class="col-sm-2 control-label label-sm no-padding-right">Periodo:</label>
													<div class="col-sm-2">
														<select id="sel_periodo" class="form-control input-sm">
															<option value="">Seleccione</option>
															<option value="1">Enero</option>
															<option value="2">Febrero</option>
															<option value="3">Marzo</option>
															<option value="4">Abril</option>
															<option value="5">Mayo</option>
															<option value="6">Junio</option>
															<option value="7">Julio</option>
															<option value="8">Agosto</option>
															<option value="9">Setiembre</option>
															<option value="10">Octubre</option>
															<option value="11">Noviembre</option>
															<option value="12">Diciembre</option>
														</select>
													</div>
												</div>											
											</div>	
											
											<div class="col-sm-2">
												<div class="form-group">	
													<div class="col-sm-12">
														<button id="btn_buscar" class="btn btn-sm btn-info input-sm" type="button">
															<i class="ace-icon fa fa-search"></i>
															Buscar
														</button>
													</div>
												</div>
												
												<div class="form-group">	
													<div class="col-sm-12">
														<button id="btn_salir" class="btn btn-sm input-sm" type="button">
															<i class="ace-icon fa fa-reply"></i>
															Salir
														</button>
													</div>
												</div>
												
												<div class="form-group">	
													<div class="col-sm-12">
														<button id="btn_gen_plame_ps4" class="btn btn-sm btn-danger input-sm" type="button">
															<i class="ace-icon fa fa-file-text-o"></i>
															PLAME PS4
														</button>
													</div>
												</div>

												<div class="form-group">	
													<div class="col-sm-12">
														<button id="btn_gen_plame_4ta" class="btn btn-sm btn-danger input-sm" type="button">
															<i class="ace-icon fa fa-file-text-o"></i>
															PLAME 4TA
														</button>
													</div>
												</div>
												
												<div class="form-group">	
													<div class="col-sm-12">
														<button id="btn_gen_ple" class="btn btn-sm btn-danger input-sm" type="button">
															<i class="ace-icon fa fa-file-text-o"></i>
															PLE
														</button>
													</div>
												</div>
												
												<div class="form-group">	
													<div class="col-sm-12">
														<button id="btn_gen_coa" class="btn btn-sm btn-danger input-sm" type="button">
															<i class="ace-icon fa fa-file-text-o"></i>
															COA
														</button>
													</div>
												</div>												
											</div>		
										</div>	
									</fieldset>
									<br>
								</form>
							</div>			
						</div>
						
						<div class="row">
							<div class="col-xs-12">
								<div class="clearfix">
									<div class="pull-right">
									   <div class="btn-group btn-overlap">
									      <a title="Exportar a PDF" class="btn btn-white btn-primary btn-bold" id="too_tables_imp_pdf">
									         <span>
												<i class="fa fa-file-pdf-o bigger-110 red"></i>
											 </span>
									      </a>
									      <a title="Exportar a Excel" class="btn btn-white btn-primary btn-bold" id="too_tables_imp_excel">
									         <span>
												<i class="fa fa-file-excel-o bigger-110 green"></i>
											 </span>
									      </a>									      
									   </div>
									</div>
								</div>
								<div class="table-responsive div_rep_compras">
									<table id="tbl_rep_compras" class="table table-striped table-bordered table-hover">
										<thead>
											<tr>
												<th>Item</th>
												<th>Nro R/C</th>
												<th>Especifica</th>
												<th>Fecha C/P</th>
												<th>SIAF</th>
												<th>Comp. de Pago</th>
												<th>Nro</th>
												<th>RUC</th>
												<th>Razon Social</th>
												<th>Monto</th>
												<th>Afecto</th>
												<th>No Afecto</th>
												<th>IGV</th>
												<th>ISC</th>
												<th>Total</th>
											</tr>
										</thead>
										<tbody></tbody>
									</table>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div><!-- /.main-content -->
		
		</div><!-- /.main-container -->
	
		<%@ include file="scripts_ini.jsp" %>	

		<!-- inline scripts related to this page -->
		<script type="text/javascript">
		
			$(document).ready(function() {		
				
				inicializarDatos();

				$('.date-picker').datepicker({
					autoclose: true,
					todayHighlight: true
				});
				
				$('.input-group-addon').click(function(e){
					e.preventDefault();
					var id_sp = $(this).attr('id').substring(7);
					$('#txt_'+id_sp).datepicker('show');
				});
				
				$('#txt_fec_inicial').datepicker().on('changeDate', function (ev) {
					$('#txt_fec_final').datepicker('setStartDate', get_for_date($(this).val()));
				});
				
				$('#sel_periodo').on('change', function() {
					set_fec_cp($(this).val());
				});
								
				$('#sel_uni_operativa').on('change', function() {
					if (!esnulo($(this).val())) {
						obtenerAnp($(this).val());
					} else {
						$('#sel_anp').empty();
					}
				});

				$('#btn_buscar').click(function(e) {					
					e.preventDefault();
					search();
				});
				
				$('#btn_salir').click(function(e) {					
					e.preventDefault();					
					var url = '${pageContext.request.contextPath}/comprasIngreso/1';
					$(location).attr('href', url);		
				});
		
				$('#too_tables_imp_pdf').click(function(e) {					
					e.preventDefault();
					
					var row = $('#tbl_rep_compras > tbody > tr').length;
					var empty = null;
					$('tr.odd').each(function() {		
						empty = $(this).find('.dataTables_empty').text();
						return false;
					});					
					if (!esnulo(empty) || row < 1) {
						addWarnMessage(null, 'No se encuentran registros para generar el reporte.');
						return;
					}
					startAjax();
					
					var tip_operacion = $('input[name="rb_tip_operacion"]:checked').val();				
					var fec_inicio = $('#txt_fec_inicial').val();
					var fec_final = $('#txt_fec_final').val();
					var cod_uni_operativa = $('#sel_uni_operativa').val();
					var des_uni_operativa = ' ';
					if (!esnulo(cod_uni_operativa)) {
						des_uni_operativa = $('#sel_uni_operativa option:selected').text();
					}
					var cod_anp = $('#sel_anp').val();
					var des_anp = ' ';
					if (esnulo(cod_anp)) {
						cod_anp = ' ';
					} else {
						des_anp = $('#sel_anp option:selected').text();
					}
					var cod_mes = $('#sel_periodo').val();
					if (esnulo(cod_mes)) {
						cod_mes = ' ';
					}
					var fil_busqueda = '';
					fil_busqueda = fil_busqueda + '1' + '_'; // Identificador de la transacción de Compras
					fil_busqueda = fil_busqueda + cod_uni_operativa + '_';
					fil_busqueda = fil_busqueda + cod_anp + '_';
					fil_busqueda = fil_busqueda + $('#txt_ruc').val() + '_';
					fil_busqueda = fil_busqueda + fec_inicio + '_';
					fil_busqueda = fil_busqueda + fec_final + '_';
					fil_busqueda = fil_busqueda + tip_operacion + '_';
					fil_busqueda = fil_busqueda + $('#sel_tip_reporte').val() + '_';
					fil_busqueda = fil_busqueda + $('#txt_nro_rc').val() + '_';
					fil_busqueda = fil_busqueda + $('#txt_nro_cp').val() + '_';
					fil_busqueda = fil_busqueda + des_uni_operativa + '_';
					fil_busqueda = fil_busqueda + des_anp + '_';
					fil_busqueda = fil_busqueda + 1 + '_'; // Indicador PDF
					fil_busqueda = fil_busqueda + cod_mes;
					$('#hid_fil_busqueda').val(fil_busqueda);
					
					$('#frm_rep_compras').attr('action', '${pageContext.request.contextPath}/imprimirReporteCompras');
					
	                $('#frm_rep_compras').submit();
	                endAjax();
				});	

				$('#too_tables_imp_excel').click(function(e) {					
					e.preventDefault();
					
					var row = $('#tbl_rep_compras > tbody > tr').length;
					var empty = null;
					$('tr.odd').each(function() {		
						empty = $(this).find('.dataTables_empty').text();
						return false;
					});					
					if (!esnulo(empty) || row < 1) {
						addWarnMessage(null, 'No se encuentran registros para generar el reporte.');
						return;
					}
					startAjax();
					
					var tip_operacion = $('input[name="rb_tip_operacion"]:checked').val();				
					var fec_inicio = $('#txt_fec_inicial').val();
					var fec_final = $('#txt_fec_final').val();
					var cod_uni_operativa = $('#sel_uni_operativa').val();
					var des_uni_operativa = ' ';
					if (!esnulo(cod_uni_operativa)) {
						des_uni_operativa = $('#sel_uni_operativa option:selected').text();
					}
					var cod_anp = $('#sel_anp').val();
					var des_anp = ' ';
					if (esnulo(cod_anp)) {
						cod_anp = ' ';
					} else {
						des_anp = $('#sel_anp option:selected').text();
					}
					var cod_mes = $('#sel_periodo').val();
					if (esnulo(cod_mes)) {
						cod_mes = ' ';
					}
					var cod_anno = $('#sel_anno').val();
					if (esnulo(cod_anno)) {
						cod_anno = ' ';
					}
					var fil_busqueda = '';
					fil_busqueda = fil_busqueda + '1' + '_'; // Identificador de la transacción de Compras
					fil_busqueda = fil_busqueda + cod_uni_operativa + '_';
					fil_busqueda = fil_busqueda + cod_anp + '_';
					fil_busqueda = fil_busqueda + $('#txt_ruc').val() + '_';
					fil_busqueda = fil_busqueda + fec_inicio + '_';
					fil_busqueda = fil_busqueda + fec_final + '_';
					fil_busqueda = fil_busqueda + tip_operacion + '_';
					fil_busqueda = fil_busqueda + $('#sel_tip_reporte').val() + '_';
					fil_busqueda = fil_busqueda + $('#txt_nro_rc').val() + '_';
					fil_busqueda = fil_busqueda + $('#txt_nro_cp').val() + '_';
					fil_busqueda = fil_busqueda + des_uni_operativa + '_';
					fil_busqueda = fil_busqueda + des_anp + '_';
					fil_busqueda = fil_busqueda + 2 + '_'; // Indicador Excel
					fil_busqueda = fil_busqueda + cod_mes + '_';
					fil_busqueda = fil_busqueda + cod_anno;
					$('#hid_fil_busqueda').val(fil_busqueda);
					
					$('#frm_rep_compras').attr('action', '${pageContext.request.contextPath}/imprimirReporteCompras');
					
	                $('#frm_rep_compras').submit();
	                endAjax();
				});
				
				$('#btn_gen_plame_ps4').click(function(e) {					
					e.preventDefault();
					
					var tip_operacion = $('input[name="rb_tip_operacion"]:checked').val();				
					var fec_inicio = $('#txt_fec_inicial').val();
					var fec_final = $('#txt_fec_final').val();
					var cod_uni_operativa = $('#sel_uni_operativa').val();
					var des_uni_operativa = ' ';
					if (!esnulo(cod_uni_operativa)) {
						des_uni_operativa = $('#sel_uni_operativa option:selected').text();
					}
					var cod_anp = $('#sel_anp').val();
					var des_anp = ' ';
					if (esnulo(cod_anp)) {
						cod_anp = ' ';
					} else {
						des_anp = $('#sel_anp option:selected').text();
					}
					var cod_mes = $('#sel_periodo').val();
					if (esnulo(cod_mes)) {
						addWarnMessage(null, 'El campo "Periodo" es obligatorio.');
						return;
					}		
					var cod_anno = $('#sel_anno').val();
					if (esnulo(cod_anno)) {
						cod_anno = ' ';
					}
					
					startAjax();
					
					var fil_busqueda = '';
					fil_busqueda = fil_busqueda + '1' + '_'; // Identificador de la transacción de Compras
					fil_busqueda = fil_busqueda + cod_uni_operativa + '_';
					fil_busqueda = fil_busqueda + cod_anp + '_';
					fil_busqueda = fil_busqueda + $('#txt_ruc').val() + '_';
					fil_busqueda = fil_busqueda + fec_inicio + '_';
					fil_busqueda = fil_busqueda + fec_final + '_';
					fil_busqueda = fil_busqueda + tip_operacion + '_';
					fil_busqueda = fil_busqueda + '3' + '_'; // Reporte de Compras
					fil_busqueda = fil_busqueda + $('#txt_nro_rc').val() + '_';
					fil_busqueda = fil_busqueda + $('#txt_nro_cp').val() + '_';
					fil_busqueda = fil_busqueda + des_uni_operativa + '_';
					fil_busqueda = fil_busqueda + des_anp + '_';
					fil_busqueda = fil_busqueda + cod_mes + '_';
					fil_busqueda = fil_busqueda + cod_anno;
					$('#hid_fil_busqueda').val(fil_busqueda);
					
					$('#frm_rep_compras').attr('action', '${pageContext.request.contextPath}/generarArchivoPlameps4');
					
	                $('#frm_rep_compras').submit();
	                endAjax();
				});
				
				$('#btn_gen_plame_4ta').click(function(e) {					
					e.preventDefault();
					
					var tip_operacion = $('input[name="rb_tip_operacion"]:checked').val();				
					var fec_inicio = $('#txt_fec_inicial').val();
					var fec_final = $('#txt_fec_final').val();
					var cod_uni_operativa = $('#sel_uni_operativa').val();
					var des_uni_operativa = ' ';
					if (!esnulo(cod_uni_operativa)) {
						des_uni_operativa = $('#sel_uni_operativa option:selected').text();
					}
					var cod_anp = $('#sel_anp').val();
					var des_anp = ' ';
					if (esnulo(cod_anp)) {
						cod_anp = ' ';
					} else {
						des_anp = $('#sel_anp option:selected').text();
					}
					var cod_mes = $('#sel_periodo').val();
					if (esnulo(cod_mes)) {
						addWarnMessage(null, 'El campo "Periodo" es obligatorio, para este reporte.');
						return;
					}		
					var cod_anno = $('#sel_anno').val();
					if (esnulo(cod_anno)) {
						addWarnMessage(null, 'El campo "Periodo" es obligatorio, para este reporte.');
						return;
					}					
					startAjax();
					
					var fil_busqueda = '';
					fil_busqueda = fil_busqueda + '1' + '_'; // Identificador de la transacción de Compras
					fil_busqueda = fil_busqueda + cod_uni_operativa + '_';
					fil_busqueda = fil_busqueda + cod_anp + '_';
					fil_busqueda = fil_busqueda + $('#txt_ruc').val() + '_';
					fil_busqueda = fil_busqueda + fec_inicio + '_';
					fil_busqueda = fil_busqueda + fec_final + '_';
					fil_busqueda = fil_busqueda + tip_operacion + '_';
					fil_busqueda = fil_busqueda + '3' + '_'; // Reporte de Compras
					fil_busqueda = fil_busqueda + $('#txt_nro_rc').val() + '_';
					fil_busqueda = fil_busqueda + $('#txt_nro_cp').val() + '_';
					fil_busqueda = fil_busqueda + des_uni_operativa + '_';
					fil_busqueda = fil_busqueda + des_anp + '_';
					fil_busqueda = fil_busqueda + cod_mes + '_';
					fil_busqueda = fil_busqueda + cod_anno;
					$('#hid_fil_busqueda').val(fil_busqueda);
					
					$('#frm_rep_compras').attr('action', '${pageContext.request.contextPath}/generarArchivoPlame4ta');
					
	                $('#frm_rep_compras').submit();
	                endAjax();
				});
								
				$('#btn_gen_ple').click(function(e) {					
					e.preventDefault();

					var tip_operacion = $('input[name="rb_tip_operacion"]:checked').val();				
					var fec_inicio = $('#txt_fec_inicial').val();
					var fec_final = $('#txt_fec_final').val();
					var cod_uni_operativa = $('#sel_uni_operativa').val();
					var des_uni_operativa = ' ';
					if (!esnulo(cod_uni_operativa)) {
						des_uni_operativa = $('#sel_uni_operativa option:selected').text();
					}
					var cod_anp = $('#sel_anp').val();
					var des_anp = ' ';
					if (esnulo(cod_anp)) {
						cod_anp = ' ';
					} else {
						des_anp = $('#sel_anp option:selected').text();
					}
					
					var cod_anno = $('#sel_anno').val();
					if (esnulo(cod_anno)) {
						addWarnMessage(null, 'El campo "Año" es obligatorio para este reporte.');
						return;
					}						
					var cod_mes = $('#sel_periodo').val();
					if (esnulo(cod_mes)) {
						addWarnMessage(null, 'El campo "Periodo" es obligatorio.');
						return;
					}			
					
					startAjax();
					
					var fil_busqueda = '';
					fil_busqueda = fil_busqueda + '1' + '_'; // Identificador de la transacción de Compras
					fil_busqueda = fil_busqueda + cod_uni_operativa + '_';
					fil_busqueda = fil_busqueda + cod_anp + '_';
					fil_busqueda = fil_busqueda + $('#txt_ruc').val() + '_';
					fil_busqueda = fil_busqueda + fec_inicio + '_';
					fil_busqueda = fil_busqueda + fec_final + '_';
					fil_busqueda = fil_busqueda + tip_operacion + '_';
					fil_busqueda = fil_busqueda + '3' + '_'; // Reporte de Compras
					fil_busqueda = fil_busqueda + $('#txt_nro_rc').val() + '_';
					fil_busqueda = fil_busqueda + $('#txt_nro_cp').val() + '_';
					fil_busqueda = fil_busqueda + des_uni_operativa + '_';
					fil_busqueda = fil_busqueda + des_anp + '_';
					fil_busqueda = fil_busqueda + cod_mes + '_';
					fil_busqueda = fil_busqueda + cod_anno;
					$('#hid_fil_busqueda').val(fil_busqueda);
					
					$('#frm_rep_compras').attr('action', '${pageContext.request.contextPath}/generarArchivoPle');
					
	                $('#frm_rep_compras').submit();
	                endAjax();
				});
				
				$('#btn_gen_coa').click(function(e) {					
					e.preventDefault();

					var tip_operacion = $('input[name="rb_tip_operacion"]:checked').val();				
					var fec_inicio = $('#txt_fec_inicial').val();
					var fec_final = $('#txt_fec_final').val();
					var cod_uni_operativa = $('#sel_uni_operativa').val();
					var des_uni_operativa = ' ';
					if (!esnulo(cod_uni_operativa)) {
						des_uni_operativa = $('#sel_uni_operativa option:selected').text();
					}
					var cod_anp = $('#sel_anp').val();
					var des_anp = ' ';
					if (esnulo(cod_anp)) {
						cod_anp = ' ';
					} else {
						des_anp = $('#sel_anp option:selected').text();
					}
					var cod_anno = $('#sel_anno').val();
					if (esnulo(cod_anno)) {
						addWarnMessage(null, 'El campo "Año" es obligatorio para este reporte.');
						return;
					}			
										
					var cod_mes = $('#sel_periodo').val();
					if (esnulo(cod_mes)) {
						addWarnMessage(null, 'El campo "Periodo" es obligatorio para este reporte.');
						return;
					}			
					
					startAjax();
					
					var fil_busqueda = '';
					fil_busqueda = fil_busqueda + '1' + '_'; // Identificador de la transacción de Compras
					fil_busqueda = fil_busqueda + cod_uni_operativa + '_';
					fil_busqueda = fil_busqueda + cod_anp + '_';
					fil_busqueda = fil_busqueda + $('#txt_ruc').val() + '_';
					fil_busqueda = fil_busqueda + fec_inicio + '_';
					fil_busqueda = fil_busqueda + fec_final + '_';
					fil_busqueda = fil_busqueda + tip_operacion + '_';
					fil_busqueda = fil_busqueda + '3' + '_'; // Reporte de Compras
					fil_busqueda = fil_busqueda + $('#txt_nro_rc').val() + '_';
					fil_busqueda = fil_busqueda + $('#txt_nro_cp').val() + '_';
					fil_busqueda = fil_busqueda + des_uni_operativa + '_';
					fil_busqueda = fil_busqueda + des_anp + '_';
					fil_busqueda = fil_busqueda + cod_mes + '_';
					fil_busqueda = fil_busqueda + cod_anno;
					$('#hid_fil_busqueda').val(fil_busqueda);
					
					$('#frm_rep_compras').attr('action', '${pageContext.request.contextPath}/generarArchivoCoa');
					
	                $('#frm_rep_compras').submit();
	                endAjax();
				});
				
			});
			
			function search() {
				var tip_operacion = $('input[name="rb_tip_operacion"]:checked').val();				
				var fec_inicio = $('#txt_fec_inicial').val();
				var fec_final = $('#txt_fec_final').val();
				var fec_final = $('#txt_fec_final').val();
				var cod_mes = $('#sel_periodo').val();
				var cod_anno = $('#sel_anno').val();
				var tip_reporte = $('#sel_tip_reporte').val();
				if (tip_reporte == '3' || tip_reporte == '4') { // Reporte de Compras
					if (esnulo(cod_anno)) {
						addWarnMessage(null, 'El campo "Año" es obligatorio, Para este reporte.');
						return;
					}
					if (esnulo(cod_mes)) {
						addWarnMessage(null, 'El campo "Periodo" es obligatorio,Para este reporte.');
						return;
					}
				} else {
					/*
					if (esnulo(fec_inicio) || esnulo(fec_final)) {
						addWarnMessage(null, 'El campo "Fecha" es obligatorio.');
						return;
					} else {
						if (!checkdate(fec_inicio) || !checkdate(fec_final)) {
							addWarnMessage(null, 'El campo "Fecha" tiene formato de fecha incorrecto.');
							return;
						}					
					}
					
					if (!checkdate(fec_inicio) || !checkdate(fec_final)) {
						addWarnMessage(null, 'El campo "Fecha" tiene formato de fecha incorrecto.');
						return;
					}	
					*/
				}
				
				var cod_uni_operativa = $('#sel_uni_operativa').val();
				
				var href = '/listarReporteCompras';
				var params = {
					int_transaccion : 1, // Identificador de la transacción de Compras
					cod_uni_operativa : cod_uni_operativa,
					cod_reg_nac : $('#sel_anp').val(),								
					num_ruc : $('#txt_ruc').val(),
					fec_inicio : fec_inicio,
					fec_final : fec_final,
					tip_operacion : tip_operacion,
					cod_servicio : tip_reporte,
					nro_doc_rc : $('#txt_nro_rc').val(),
					nro_cp : $('#txt_nro_cp').val(),
					cod_mes : cod_mes,
					cod_anno : cod_anno
				};				
				var layout = null;
				if (tip_reporte == '1') { // Consolidado de Partidas por Rendición de Cuenta
					layout = [{
						title: 'Item',
						type: 'enum',
						'class': 'center no-sort'
					}, {
						title: 'Partida Especifica',
						field: 'vcod_especifica',
						'class': 'no-sort'
					}, {
						title: 'Meta',
						field: 'cod_meta',
						'class': 'no-sort'
					}, {						
						title: 'POA',
						field: 'imp_partida',
						'class': 'utilRight no-sort'
					}, {
						title: 'Transferido',
						field: 'imp_partida',
						'class': 'utilRight no-sort'
					}, {
						title: 'Ejecutado',
						field: 'imp_det_total',
						'class': 'utilRight no-sort'
					}, {
						title: 'Devoluciones',
						field: 'imp_devolucion',
						'class': 'utilRight no-sort'							
					}, {
						title: 'Saldo',
						field: 'imp_saldo',
						'class': 'utilRight no-sort'				
					}];
				} else if (tip_reporte == '2') { // Documentos de la Rendición de Cuenta
					layout = [{
						title: 'Item',
						type: 'enum',
						'class': 'center no-sort'
					}, {
						title: 'Nro R/C',
						field: 'nro_doc_rc',
						'class': 'no-sort'
					}, {
						title: 'Part. Esp.',
						field: 'vcod_especifica',
						'class': 'no-sort'
					}, {
						title: 'Especifica',
						field: 'des_especifica',
						'class': 'no-sort'
					}, {
						title: 'Fecha C/P',
						field: 'fec_comprobante',
						'class': 'no-sort'
					}, {
						title: 'Meta',
						field: 'cod_meta',
						'class': 'no-sort'						
					}, {
						title: 'SIAF',
						field: 'nro_siaf',
						'class': 'no-sort'
					}, {
						title: 'Comp. de Pago',
						field: 'tip_comprobante',
						'class': 'no-sort'
					}, {
						title: 'Nro',
						field: 'nro_ser_comprobante',
						'class': 'no-sort'
					}, {
						title: 'RUC',
						field: 'ruc_nro_doc_prov',
						'class': 'no-sort'
					}, {
						title: 'Razon Social',
						field: 'raz_soc_prov',
						'class': 'no-sort'
					}, {
						title: 'Monto',
						field: 'num_imp_servicio',
						'class': 'utilRight no-sort'
					}, {
						title: 'Afecto',
						field: 'num_imp_afecto',
						'class': 'utilRight no-sort'
					}, {
						title: 'No Afecto',
						field: 'num_imp_no_afecto',
						'class': 'utilRight no-sort'				
					}, {
						title: 'IGV',
						field: 'num_imp_igv',
						'class': 'utilRight no-sort'				
					}, {
						title: 'ISC',
						field: 'num_imp_isc',
						'class': 'utilRight no-sort'				
					}, {
						title: 'Total',
						field: 'imp_det_total',
						'class': 'utilRight no-sort'				
					}];
				} else if (tip_reporte == '3') { // Reporte de Compras
					layout = [{
						title: 'Item',
						type: 'enum',
						'class': 'center no-sort'
					}, {
						title: 'Nro C/P',
						field: 'ser_nro_comprobante',
						'class': 'no-sort'
					}, {
						title: 'Fecha C/P',
						field: 'fec_comprobante',
						'class': 'no-sort'
					}, {
						title: 'Comp. de Pago',
						field: 'tip_comprobante',
						'class': 'no-sort'
					}, {
						title: 'RUC',
						field: 'ruc_nro_doc_prov',
						'class': 'no-sort'
					}, {
						title: 'Razon Social',
						field: 'raz_soc_prov',
						'class': 'no-sort'
					}, {
						title: 'Afecto',
						field: 'num_imp_afecto',
						'class': 'utilRight no-sort'
					}, {
						title: 'No Afecto',
						field: 'num_imp_no_afecto',
						'class': 'utilRight no-sort'				
					}, {
						title: 'IGV',
						field: 'num_imp_igv',
						'class': 'utilRight no-sort'				
					}, {
						title: 'ISC',
						field: 'num_imp_isc',
						'class': 'utilRight no-sort'				
					}, {
						title: 'Importe Total',
						field: 'imp_det_total',
						'class': 'utilRight no-sort'				
					}];
				} else if (tip_reporte == '4') { // Registro de Compras
					layout = [{
						title: 'Item',
						type: 'enum',
						'class': 'center no-sort'
					}, {
						title: 'Nro C/P',
						field: 'ser_nro_comprobante',
						'class': 'no-sort'
					}, {
						title: 'Fecha C/P',
						field: 'fec_comprobante',
						'class': 'no-sort'
					}, {
						title: 'Comp. de Pago',
						field: 'tip_comprobante',
						'class': 'no-sort'
					}, {
						title: 'RUC',
						field: 'ruc_nro_doc_prov',
						'class': 'no-sort'
					}, {
						title: 'Razon Social',
						field: 'raz_soc_prov',
						'class': 'no-sort'
					}, {
						title: 'Afecto',
						field: 'num_imp_afecto',
						'class': 'utilRight no-sort'
					}, {
						title: 'No Afecto',
						field: 'num_imp_no_afecto',
						'class': 'utilRight no-sort'				
					}, {
						title: 'IGV',
						field: 'num_imp_igv',
						'class': 'utilRight no-sort'				
					}, {
						title: 'ISC',
						field: 'num_imp_isc',
						'class': 'utilRight no-sort'				
					}, {
						title: 'Importe Total',
						field: 'imp_det_total',
						'class': 'utilRight no-sort'				
					}];
				}
						
				var options = {
					containerTable: '.div_rep_compras',
					idTable: 'tbl_rep_compras',
					styleTable: '.util1200Rw',
					loading: true,
					parameters: params,
					vTableOptions: {
						bFilter: false,
						paging: true,
						info: true,
						aLengthMenu: [
							[15, 50, 100],
							[15, 50, 100]
						],
						iDisplayLength: 15
					}
				};
				simpleGenerateDatatable(href, layout, options, null, null);
			}
			
			function obtenerAnp(cod_uni_operativa) {
				var params = new Object();								
 				params['ind_uni_operativa'] = 1; // ANP
 				params['cod_uni_operativa'] = cod_uni_operativa;
 				simpleCboAjaxPopulateParam('#sel_anp', ['cod_reg_nac', 'des_reg_nac'], '/listarUnidadOperativa', params, true, false);
			}
			
			function inicializarDatos() {
				
				$("#li_compras").addClass('active');
				$("#li_rep_compras").addClass('active');

				if ('${ind_sed_principal}' == '1') { // Usuario de Sede Central						
					$('input[name=rb_tip_operacion][value="2"]').prop('checked', true);
				} else {
					$('input[name=rb_tip_operacion][value="1"]').prop('checked', true);
					$('#sel_uni_operativa option:eq(1)').attr('selected', 'selected');
					$('input[name=rb_tip_operacion]').prop('disabled', true);
					obtenerAnp($('#sel_uni_operativa').val());
				}
				
			}
			
			function set_fec_cp(campo) {
				if (!esnulo(campo)) {
					var mes = parseInt(campo);
					var anio = new Date().getFullYear();
					var dia = new Date(anio, mes, 0).getUTCDate(); // Ultimo dia del mes
					var fecha = anio + '-' + mes + '-' + dia;
					var fec_act = anio + '-' + mes + '-' + '01';
					$('#txt_fec_inicial').datepicker('setStartDate', new Date(fec_act));		
					$('#txt_fec_inicial').datepicker('setEndDate', new Date(fecha));
				} else {
					var mes = 1;
					var anio = new Date().getFullYear();
					var dia = new Date(anio, mes, 0).getUTCDate(); // Ultimo dia del mes enero
					var dia_dic = new Date(anio, 12, 0).getUTCDate(); // Ultimo dia del mes diciembre
					var fecha = anio + '-' + 12 + '-' + dia_dic;
					var fec_act = anio + '-' + dia + '-' + '01';
					$('#txt_fec_inicial').datepicker('setStartDate', new Date(fec_act));		
					$('#txt_fec_inicial').datepicker('setEndDate', new Date(fecha));
				}					
			}
		
		</script>
		
	</body>
</html>