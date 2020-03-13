<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta charset="utf-8" />
		<title>Reportes de Ingresos</title>

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
								Ingresos
							</li>
							<li class="active">Reportes</li>
						</ul>
					</div>
			
					<div class="page-content">		
						<div class="row">
							<div class="col-xs-12">
								<form id="frm_rep_ingresos" class="form-horizontal" role="form" method="get" 
								  	  action="${pageContext.request.contextPath}/imprimirReporteIngresos">
								  	  
									<input type="hidden" id="hid_fil_busqueda" name="fil_busqueda">  	  
									
									<fieldset class="fsStyle">
										<legend class="legendStyle">Filtros para la Búsqueda de Información</legend>
										
										<div class="form-group">
											<div class="col-sm-10">
												<div class="form-group">																									
													<label class="col-sm-3 control-label label-sm no-padding-left">Tipo de Operación:</label>
														
													<div class="col-sm-3">
														<div class="radio">
															<label class="input-sm">
																<input type="radio" class="ace input-sm" name="rb_tip_operacion" value="1">
																<span class="lbl"> Unidad Operativa</span>
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
												</div>
																
												<div class="form-group">
													<label class="col-sm-2 control-label label-sm no-padding-right">Tipo de Reporte:</label>
													<div class="col-sm-2">
														<select id="sel_tip_reporte" class="form-control input-sm">
															<option value=''>&#60Seleccione&#62</option>
															<option value="1">Ingresos de Servicios</option>
															<option value="2">Ingresos de Productos</option>
															<option value="3">Ingresos de Boletos</option>
															<option value="4">Ingresos Tupa</option>
															<option value="5">Ingresos Otros</option>
															<option value="6">Registro de Ventas</option>
															<option value="7">Formato 14.1 - Registro de Ventas e Ingresos</option>
														</select>
													</div>
												
													<label class="col-sm-2 control-label label-sm no-padding-right">Servicios:</label>
													<div class="col-sm-2">
														<select id="sel_servicio" class="form-control input-sm">
														</select>
													</div>
													
													<label class="col-sm-2 control-label label-sm no-padding-right">Ruc:</label>
													<div class="col-sm-2">
														<input type="text" id="txt_ruc" class="form-control input-sm onlyNumbers" maxlength="11" />
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
														<button id="btn_gen_ple" class="btn btn-sm btn-danger input-sm" type="button">
															<i class="ace-icon fa fa-file-text-o"></i>
															PLE
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
								<div class="table-responsive div_rep_ingresos">
									<table id="tbl_rep_ingresos" class="table table-striped table-bordered table-hover">
										<thead>
											<tr>
												<th>Item</th>
												<th>C/P</th>
												<th>Nro C/P</th>
												<th>Fecha C/P</th>
												<th>Unid. Oper.</th>
												<th>ANP</th>
												<th>RUC</th>
												<th>Razon Social</th>
												<th>Servicio</th>
												<th>Cantidad</th>
												<th>Prec. Vta.</th>
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
		
		var arr_tar_servicio = [];
		var arr_productos = [];
		var arr_tar_boletos = [];
		var arr_tar_tupa = [];
		var arr_tar_otros = [];
		
		<c:forEach items="${lis_tar_servicio}" var="item">
	    	arr_tar_servicio.push('${item.cod_servicio}'+'|'+'${item.vcod_servicio}'+'|'+'${item.nom_servicio}'+'|'+'${item.num_imp_pre_venta}');
		</c:forEach>
		
		<c:forEach items="${lis_productos}" var="item">
			arr_productos.push('${item.cod_producto}'+'|'+'${item.vcod_producto}'+'|'+'${item.nom_producto}'+'|'+'${item.num_imp_pre_venta}');
		</c:forEach>
		
		<c:forEach items="${lis_tar_boletos}" var="item">
			var det_boleto = '${item.cod_boleto}'+'|'+'${item.des_ind_tarifa}'+'|'+'${item.nom_boleto}'+'|'+'${item.num_serie}'+'|';
			det_boleto = det_boleto + '${item.num_inicio}'+'|'+'${item.num_final}'+'|'+'${item.can_sal_stock}'+'|'+'${item.num_imp_unit}';			
			arr_tar_boletos.push(det_boleto);
		</c:forEach>
		
		<c:forEach items="${lis_tar_tupa}" var="item">
			arr_tar_tupa.push('${item.cod_tupa}'+'|'+'${item.vcod_tupa}'+'|'+'${item.nom_tupa}'+'|'+'${item.num_imp_unit}');
		</c:forEach>
		
		<c:forEach items="${lis_otros}" var="item">
			arr_tar_otros.push('${item.cod_otros}'+'|'+'${item.nom_otros}'+'|'+'${item.cod_especifica}');
		</c:forEach>
		
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
				
				$('#sel_tip_reporte').on('change', function(e) {
					e.preventDefault();
					
					var opt_detalle = '<option value="">&#60Seleccione&#62</option>';
					var cod_tip_transaccion = $(this).val(); 
					switch (cod_tip_transaccion) {
						case '1': // Servicios
	
							for (var i = 0; i < arr_tar_servicio.length; i++) {
								var fields = arr_tar_servicio[i].split('|');				
								opt_detalle += '<option value="'+fields[0]+'">'+fields[1]+' - '+fields[2]+'</option>';								
								if (i == 0) {
									$('#txt_servicio').val(fields[2]);
									$('#txt_precio').val(fields[3]);
								}
							}
							$('#sel_servicio').html(opt_detalle);
							
							break;
						case '2': // Productos

							for (var i = 0; i < arr_productos.length; i++) {
								var fields = arr_productos[i].split('|');								
								opt_detalle += '<option value="'+fields[0]+'">'+fields[1]+' - '+fields[2]+'</option>';								
								if (i == 0) {
									$('#txt_producto').val(fields[2]);
									$('#txt_precio').val(fields[3]);
								}
							}
							$('#sel_servicio').html(opt_detalle);
							
							break;
						case '3': // Boletos

							obtenerTarifaBoleto($('#sel_uni_operativa').val(), $('#sel_anp').val());
							
							break;
						case '4': // Tupa							
							
							for (var i = 0; i < arr_tar_tupa.length; i++) {
								var fields = arr_tar_tupa[i].split('|');								
								opt_detalle += '<option value="'+fields[0]+'">'+fields[1]+' - '+fields[2]+'</option>';								
								if (i == 0) {
									$('#txt_formato').val(fields[1]);
									$('#txt_precio').val(fields[3]);
								}
							}
							$('#sel_servicio').html(opt_detalle);
							
							break;
						case '5': // Otros
						
							for (var i = 0; i < arr_tar_otros.length; i++) {
								var fields = arr_tar_otros[i].split('|');								
								opt_detalle += '<option value="'+fields[0]+'">'+fields[1]+'</option>';
							}
							$('#sel_servicio').html(opt_detalle);							
							
							break;
						default:
							$('#sel_servicio').html('');
							break;
					}
					
				});
		
				$('#too_tables_imp_pdf').click(function(e) {					
					e.preventDefault();
					
					var row = $('#tbl_rep_ingresos > tbody > tr').length;
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
					var cod_servicio = $('#sel_servicio').val();
					if (esnulo(cod_servicio)) {
						cod_servicio = ' ';
					}
					var cod_mes = $('#sel_periodo').val();
					if (esnulo(cod_mes)) {
						cod_mes = ' ';
					}
					var fil_busqueda = '';
					fil_busqueda = fil_busqueda + '2' + '_'; // Identificador de la transacción de Ingresos
					fil_busqueda = fil_busqueda + cod_uni_operativa + '_';
					fil_busqueda = fil_busqueda + cod_anp + '_';
					fil_busqueda = fil_busqueda + $('#txt_ruc').val() + '_';
					fil_busqueda = fil_busqueda + fec_inicio + '_';
					fil_busqueda = fil_busqueda + fec_final + '_';
					fil_busqueda = fil_busqueda + tip_operacion + '_';
					fil_busqueda = fil_busqueda + $('#sel_tip_reporte').val() + '_';
					fil_busqueda = fil_busqueda + cod_servicio + '_';
					fil_busqueda = fil_busqueda + des_uni_operativa + '_';
					fil_busqueda = fil_busqueda + des_anp + '_';
					fil_busqueda = fil_busqueda + 1 + '_'; // Indicador PDF
					fil_busqueda = fil_busqueda + cod_mes;
					$('#hid_fil_busqueda').val(fil_busqueda);
					
					$('#frm_rep_ingresos').attr('action', '${pageContext.request.contextPath}/imprimirReporteIngresos');
					
	                $("#frm_rep_ingresos").submit();
	                endAjax();
				});	

				$('#too_tables_imp_excel').click(function(e) {					
					e.preventDefault();
					
					var row = $('#tbl_rep_ingresos > tbody > tr').length;
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
					var cod_servicio = $('#sel_servicio').val();
					if (esnulo(cod_servicio)) {
						cod_servicio = ' ';
					}
					var cod_mes = $('#sel_periodo').val();
					if (esnulo(cod_mes)) {
						cod_mes = ' ';
					}
					var fil_busqueda = '';
					fil_busqueda = fil_busqueda + '2' + '_'; // Identificador de la transacción de Ingresos
					fil_busqueda = fil_busqueda + cod_uni_operativa + '_';
					fil_busqueda = fil_busqueda + cod_anp + '_';
					fil_busqueda = fil_busqueda + $('#txt_ruc').val() + '_';
					fil_busqueda = fil_busqueda + fec_inicio + '_';
					fil_busqueda = fil_busqueda + fec_final + '_';
					fil_busqueda = fil_busqueda + tip_operacion + '_';
					fil_busqueda = fil_busqueda + $('#sel_tip_reporte').val() + '_';
					fil_busqueda = fil_busqueda + cod_servicio + '_';
					fil_busqueda = fil_busqueda + des_uni_operativa + '_';
					fil_busqueda = fil_busqueda + des_anp + '_';
					fil_busqueda = fil_busqueda + 2 + '_'; // Indicador Excel
					fil_busqueda = fil_busqueda + cod_mes;
					$('#hid_fil_busqueda').val(fil_busqueda);
					
					$('#frm_rep_ingresos').attr('action', '${pageContext.request.contextPath}/imprimirReporteIngresos');
					
	                $("#frm_rep_ingresos").submit();
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
					var cod_mes = $('#sel_periodo').val();
					if (esnulo(cod_mes)) {
						addWarnMessage(null, 'El campo "Periodo" es obligatorio.');
						return;
					}					
					var cod_servicio = $('#sel_servicio').val();
					if (esnulo(cod_servicio)) {
						cod_servicio = ' ';
					}
					
					startAjax();
					
					var fil_busqueda = '';
					fil_busqueda = fil_busqueda + '2' + '_'; // Identificador de la transacción de Ingresos
					fil_busqueda = fil_busqueda + cod_uni_operativa + '_';
					fil_busqueda = fil_busqueda + cod_anp + '_';
					fil_busqueda = fil_busqueda + $('#txt_ruc').val() + '_';
					fil_busqueda = fil_busqueda + fec_inicio + '_';
					fil_busqueda = fil_busqueda + fec_final + '_';
					fil_busqueda = fil_busqueda + tip_operacion + '_';
					fil_busqueda = fil_busqueda + '6' + '_'; // Registro de Ventas
					fil_busqueda = fil_busqueda + cod_servicio + '_';
					fil_busqueda = fil_busqueda + des_uni_operativa + '_';
					fil_busqueda = fil_busqueda + des_anp + '_';
					fil_busqueda = fil_busqueda + cod_mes;
					$('#hid_fil_busqueda').val(fil_busqueda);
					
					$('#frm_rep_ingresos').attr('action', '${pageContext.request.contextPath}/generarArchivoPle');
					
	                $('#frm_rep_ingresos').submit();
	                endAjax();
				});
				
			});
			
			function search() {
				var tip_operacion = $('input[name="rb_tip_operacion"]:checked').val();				
				var fec_inicio = $('#txt_fec_inicial').val();
				var fec_final = $('#txt_fec_final').val();				
				var cod_mes = $('#sel_periodo').val();
				var tip_reporte = $('#sel_tip_reporte').val();
				if (tip_reporte == '6' || tip_reporte == '7') { // Registro de Ventas
					if (esnulo(cod_mes)) {
						addWarnMessage(null, 'El campo "Periodo" es obligatorio.');
						return;
					}
				} else {
					if (esnulo(fec_inicio) || esnulo(fec_final)) {
						addWarnMessage(null, 'El campo "Fecha" es obligatorio.');
						return;
					} else {
						if (!checkdate(fec_inicio) || !checkdate(fec_final)) {
							addWarnMessage(null, 'El campo "Fecha" tiene formato de fecha incorrecto.');
							return;
						}
					}
				}
				var cod_uni_operativa = $('#sel_uni_operativa').val();
				var href = '/listarReporteIngresos';
				var params = {
					int_transaccion : 2, // Identificador de la transacción de Ingresos
					cod_uni_operativa : cod_uni_operativa,
					cod_reg_nac : $('#sel_anp').val(),								
					num_ruc : $('#txt_ruc').val(),
					fec_inicio : fec_inicio,
					fec_final : fec_final,
					tip_operacion : tip_operacion,
					tip_transaccion : tip_reporte,
					cod_servicio : $('#sel_servicio').val(),
					cod_mes : cod_mes
				};
				
				var layout = null;				
				var cod_tip_transaccion = $('#sel_tip_reporte').val();
				switch (cod_tip_transaccion) {
					case '1': // Servicios
						layout = [{
							title: 'Item',
							type: 'enum',
							'class': 'center no-sort'
						}, {
							title: 'C/P',
							field: 'tip_comprobante',
							'class': 'no-sort'
						}, {
							title: 'Nro C/P',
							field: 'nro_comprobante',
							'class': 'no-sort'
						}, {
							title: 'Fecha C/P',
							field: 'fec_comprobante',
							'class': 'no-sort'
						}, {
							title: 'Unid. Oper.',
							field: 'des_uni_operativa',
							'class': 'no-sort'
						}, {
							title: 'ANP',
							field: 'des_reg_nac',
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
							title: 'Servicio',
							field: 'des_servicio',
							'class': 'no-sort'
						}, {
							title: 'Dias',
							field: 'can_dias',
							'class': 'utilRight no-sort'
						}, {
							title: 'Prec. Vta.',
							field: 'num_pre_unitario',
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
							title: 'Importe Total',
							field: 'imp_det_total',
							'class': 'utilRight no-sort'				
						}];		
						break;
					case '2': // Productos
						layout = [{
							title: 'Item',
							type: 'enum',
							'class': 'center no-sort'
						}, {
							title: 'C/P',
							field: 'tip_comprobante',
							'class': 'no-sort'
						}, {
							title: 'Nro C/P',
							field: 'nro_comprobante',
							'class': 'no-sort'
						}, {
							title: 'Fecha C/P',
							field: 'fec_comprobante',
							'class': 'no-sort'
						}, {
							title: 'Unid. Oper.',
							field: 'des_uni_operativa',
							'class': 'no-sort'
						}, {
							title: 'ANP',
							field: 'des_reg_nac',
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
							title: 'Producto',
							field: 'nom_producto',
							'class': 'no-sort'
						}, {
							title: 'Cantidad',
							field: 'can_producto',
							'class': 'utilRight no-sort'
						}, {
							title: 'Prec. Vta.',
							field: 'num_pre_unitario',
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
							title: 'Importe Total',
							field: 'imp_det_total',
							'class': 'utilRight no-sort'				
						}];					
						break;
					case '3': // Boletos
						layout = [{
							title: 'Item',
							type: 'enum',
							'class': 'center no-sort'
						}, {
							title: 'C/P',
							field: 'tip_comprobante',
							'class': 'no-sort'
						}, {
							title: 'Nro C/P',
							field: 'nro_comprobante',
							'class': 'no-sort'
						}, {
							title: 'Fecha C/P',
							field: 'fec_comprobante',
							'class': 'no-sort'
						}, {
							title: 'Unid. Oper.',
							field: 'des_uni_operativa',
							'class': 'no-sort'
						}, {
							title: 'ANP',
							field: 'des_reg_nac',
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
							title: 'Serie Tarifa',
							field: 'num_ser_boleto',
							'class': 'no-sort'
						}, {
							title: 'Tarifa',
							field: 'des_boleto',
							'class': 'no-sort'
						}, {
							title: 'Cantidad',
							field: 'can_producto',
							'class': 'utilRight no-sort'
						}, {
							title: 'Prec. Vta.',
							field: 'num_pre_unitario',
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
							title: 'Importe Total',
							field: 'imp_det_total',
							'class': 'utilRight no-sort'				
						}];
						break;
					case '4': // Tupa							
						layout = [{
							title: 'Item',
							type: 'enum',
							'class': 'center no-sort'
						}, {
							title: 'C/P',
							field: 'tip_comprobante',
							'class': 'no-sort'
						}, {
							title: 'Nro C/P',
							field: 'nro_comprobante',
							'class': 'no-sort'
						}, {
							title: 'Fecha C/P',
							field: 'fec_comprobante',
							'class': 'no-sort'
						}, {
							title: 'Unid. Oper.',
							field: 'des_uni_operativa',
							'class': 'no-sort'
						}, {
							title: 'ANP',
							field: 'des_reg_nac',
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
							title: 'Tarifa',
							field: 'nom_tupa',
							'class': 'no-sort'
						}, {
							title: 'Cantidad',
							field: 'can_producto',
							'class': 'utilRight no-sort'
						}, {
							title: 'Prec. Vta.',
							field: 'num_pre_unitario',
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
							title: 'Importe Total',
							field: 'imp_det_total',
							'class': 'utilRight no-sort'				
						}];
						break;
					case '5': // Otros
						layout = [{
							title: 'Item',
							type: 'enum',
							'class': 'center no-sort'
						}, {
							title: 'C/P',
							field: 'tip_comprobante',
							'class': 'no-sort'
						}, {
							title: 'Nro C/P',
							field: 'nro_comprobante',
							'class': 'no-sort'
						}, {
							title: 'Fecha C/P',
							field: 'fec_comprobante',
							'class': 'no-sort'
						}, {
							title: 'Unid. Oper.',
							field: 'des_uni_operativa',
							'class': 'no-sort'
						}, {
							title: 'ANP',
							field: 'des_reg_nac',
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
							title: 'Tarifa',
							field: 'des_otros',
							'class': 'no-sort'
						}, {
							title: 'Cantidad',
							field: 'can_producto',
							'class': 'utilRight no-sort'
						}, {
							title: 'Prec. Vta.',
							field: 'num_pre_unitario',
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
							title: 'Importe Total',
							field: 'imp_det_total',
							'class': 'utilRight no-sort'				
						}];
						break;
					case '6': // Registro de Ventas
						layout = [{
							title: 'Item',
							type: 'enum',
							'class': 'center no-sort'
						}, {
							title: 'N° Documento',
							field: 'ser_nro_comprobante',
							'class': 'no-sort'
						}, {
							title: 'Fecha',
							field: 'fec_comprobante',
							'class': 'no-sort'
						}, {
							title: 'Doc',
							field: 'tip_documento',
							'class': 'no-sort'
						}, {
							title: 'Num',
							field: 'ruc_nro_doc_prov',
							'class': 'no-sort'
						}, {
							title: 'Nombre',
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
						break;
					case '7': // Registro de Ventas
						layout = [{
							title: 'Item',
							type: 'enum',
							'class': 'center no-sort'
						}, {
							title: 'N° Documento',
							field: 'ser_nro_comprobante',
							'class': 'no-sort'
						}, {
							title: 'Fecha',
							field: 'fec_comprobante',
							'class': 'no-sort'
						}, {
							title: 'Doc',
							field: 'tip_documento',
							'class': 'no-sort'
						}, {
							title: 'Num',
							field: 'ruc_nro_doc_prov',
							'class': 'no-sort'
						}, {
							title: 'Nombre',
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
						break;
					default:
						layout = [{
							title: 'Item',
							type: 'enum',
							'class': 'center no-sort'
						}, {
							title: 'Tip. C/P',
							field: 'tip_com_siglas',
							'class': 'no-sort'
						}, {
							title: 'Nro C/P',
							field: 'nro_comprobante',
							'class': 'no-sort'
						}, {
							title: 'Fecha C/P',
							field: 'fec_comprobante',
							'class': 'no-sort'
						}, {
							title: 'Unid. Oper.',
							field: 'des_uni_operativa',
							'class': 'no-sort'
						}, {
							title: 'ANP',
							field: 'des_reg_nac',
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
							title: 'Servicio',
							field: 'des_servicio',
							'class': 'no-sort'
						}, {
							title: 'Producto',
							field: 'nom_producto',
							'class': 'no-sort'
						}, {
							title: 'Serie Tarifa',
							field: 'num_ser_boleto',
							'class': 'no-sort'
						}, {
							title: 'Tarifa Boleto',
							field: 'des_boleto',
							'class': 'no-sort'
						}, {
							title: 'Tarifa Tupa',
							field: 'nom_tupa',
							'class': 'no-sort'
						}, {
							title: 'Tarifa Otros',
							field: 'des_otros',
							'class': 'no-sort'
						}, {
							title: 'Cantidad',
							field: 'can_producto',
							'class': 'utilRight no-sort'	
						}, {
							title: 'Dias',
							field: 'can_dias',
							'class': 'utilRight no-sort'
						}, {
							title: 'Prec. Vta.',
							field: 'num_pre_unitario',
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
						break;
				}
				var options = {
					containerTable: '.div_rep_ingresos',
					idTable: 'tbl_rep_ingresos',
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
				
				$("#li_ingresos").addClass('active');
				$("#li_rep_ingresos").addClass('active');

				if ('${ind_sed_principal}' == '1') { // Usuario de Sede Central						
					$('input[name=rb_tip_operacion][value="2"]').prop('checked', true);
				} else {
					$('input[name=rb_tip_operacion][value="1"]').prop('checked', true);
					$('#sel_uni_operativa option:eq(1)').attr('selected', 'selected');
					$('input[name=rb_tip_operacion]').prop('disabled', true);
					obtenerAnp($('#sel_uni_operativa').val());
				}				
				
			}
			
			function obtenerTarifaBoleto(cod_uni_operativa, cod_reg_nac) {
				$.ajax({
					type: 'GET',
					url: '${pageContext.request.contextPath}/listarTarifaBoleto',
					data: {
						cod_uni_operativa : cod_uni_operativa,
						cod_reg_nac : cod_reg_nac
					},
					dataType: 'json',
					success: function(paramJson) {						
						if (paramJson != null) {
							arr_tar_boletos = null;
							arr_tar_boletos = [];
							var options = '<option value="">&#60Seleccione&#62</option>';
							var row = 0;
							$.each(paramJson, function(index, item) {
								options += '<option value="'+item.cod_boleto+'">'+item.des_ind_tarifa+' - '+item.nom_boleto+'</option>';											
								var det_boleto = item.cod_boleto+'|'+item.des_ind_tarifa+'|'+item.nom_boleto+'|'+item.num_serie+'|';
								det_boleto = det_boleto + item.num_inicio+'|'+item.num_final+'|'+item.can_sal_stock+'|'+item.num_imp_unit;			
								arr_tar_boletos.push(det_boleto);
							});
							$('#sel_servicio').html(options);
						} else {
							$('#sel_servicio').html('');
						}
					},
					error: function(jqXHR, error, errorThrown) {
						var msg = 'Error:<br/>';
						if (jqXHR.status && jqXHR.status == 400) {
							msg = msg + jqXHR.responseText;
						} else {
							msg = msg + errorThrown;
						}
						addErrorMessage(null, msg);
					}
				});
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