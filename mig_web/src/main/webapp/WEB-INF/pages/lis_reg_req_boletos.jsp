<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta charset="utf-8" />
		<title>Bandeja Registro de Transferencias</title>

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
							<li class="active">Requerimiento de Boletos</li>
						</ul>
					</div>
			
					<div class="page-content">		
						<div class="row">
							<div class="col-xs-12">
								<form class="form-horizontal" role="form">

									<fieldset class="fsStyle">
										<legend class="legendStyle">Búsqueda de Información Boletos</legend>
										
										<div class="form-group">
											<div class="col-sm-10">							
												<div class="form-group">												
													<label class="col-sm-2 control-label label-sm no-padding-right">U.O.:</label>
													<div class="col-sm-4">
														<select id="sel_uni_operativa" class="form-control input-sm">
															<option value=''>&#60Seleccione&#62</option>
															<c:forEach items="${lis_uni_operativa}" var="item">
															    <option value="${item.cod_uni_operativa}">${item.des_uni_operativa}</option>
															</c:forEach>
														</select>
													</div>												
												
													<label class="col-sm-2 control-label label-sm no-padding-right">ANP:</label>
													<div class="col-sm-4">
														<select id="sel_anp" class="form-control input-sm">														
														</select>
													</div>
												</div>
												
												<div class="form-group">												
													<label class="col-sm-2 control-label label-sm no-padding-right">Nro Doc.:</label>
													<div class="col-sm-2">
														<input type="text" id="txt_nro_doc" class="form-control input-sm" maxlength="10" />
													</div>	
												
													<label class="col-sm-2 control-label label-sm no-padding-right">Fecha Ini.:</label>
													<div class="col-sm-2">
														<div class="input-group">
															<input class="form-control input-sm date-picker" id="txt_fec_ini" type="text" />
															<span class="input-group-addon" id="sp_ico_fec_ini">
																<i class="fa fa-calendar bigger-110"></i>
															</span>
														</div>
													</div>
													
													<label class="col-sm-2 control-label label-sm no-padding-right">Fecha Fin:</label>
													<div class="col-sm-2">
														<div class="input-group">
															<input class="form-control input-sm date-picker" id="txt_fec_fin" type="text" />
															<span class="input-group-addon" id="sp_ico_fec_fin">
																<i class="fa fa-calendar bigger-110"></i>
															</span>
														</div>
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
														<button id="btn_nuevo" class="btn btn-sm btn-success input-sm" type="button">
															<i class="ace-icon fa fa-plus-square"></i>
															Nuevo
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
								<div class="table-responsive div_reg_req_boletos">
									<table id="tbl_reg_req_boletos" class="table table-striped table-bordered table-hover">
										<thead>
											<tr>
												<th>Item</th>
												<th>Nro Doc.</th>
												<th>Fecha</th>
												<th>Cantidad</th>
												<th>Sede Origen</th>
												<th>Usuario Reg.</th>
												<th>Fec. Registro</th>
												<th>Usuario Mod.</th>
												<th>Fec. Modifica</th>	
											</tr>
										</thead>
									</table>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div><!-- /.main-content -->
			
			<div id="div_det_req_boletos" class="modal" tabindex="-1" data-keyboard="false" data-backdrop="static">
				<div class="modal-dialog modal-lg">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">&times;</button>
							<h4 id="h_det_req_boletos" class="white bigger center"></h4>
						</div>
						
						<div class="modal-body">						
							<fieldset class="fsStyle">
								<legend class="legendStyle">Detalle de Requerimientos Boletos</legend>
								<div class="row">
									<div class="col-xs-12">
										<form id="frm_det_req_boletos" class="form-horizontal" role="form">
										
											<input type="hidden" id="hid_cod_req_boletos">
											<input type="hidden" id="hid_req_boletos">
											<input type="hidden" id="hid_req_bol_ant">
										
											<div class="form-group">																				
												<label class="col-sm-2 control-label label-sm no-padding-right">U.O.:</label>
												<div class="col-sm-4">
													<select id="sel_uni_req_boletos" class="form-control input-sm">
														<c:forEach items="${lis_uni_operativa}" var="item">
														    <option value="${item.cod_uni_operativa}">${item.des_uni_operativa}</option>
														</c:forEach>
													</select>
												</div>												
											
												<label class="col-sm-2 control-label label-sm no-padding-right">ANP:</label>
												<div class="col-sm-4">
													<select id="sel_anp_req_boletos" class="form-control input-sm">
														<c:forEach items="${lis_anp}" var="item">
														    <option value="${item.cod_reg_nac}">${item.des_reg_nac}</option>
														</c:forEach>											
													</select>
												</div>	
											</div>									
											
											<div class="form-group">																				
												<label class="col-sm-2 control-label input-sm no-padding-right">Nro Doc.:</label>											
												<div class="col-sm-5">
													<input type="text" id="txt_nro_doc_req_boletos" class="form-control input-sm" maxlength="10" />
												</div>	
												
												<label class="col-sm-2 control-label label-sm no-padding-right">Fecha Doc.:</label>
												<div class="col-sm-3">
													<div class="input-group">
														<input class="form-control input-sm date-picker" id="txt_fec_doc_req_boletos" type="text" />
														<span class="input-group-addon" id="sp_ico_fec_doc_req_boletos">
															<i class="fa fa-calendar bigger-110"></i>
														</span>
													</div>
												</div>									
											</div>
										</form>
										
										<div class="table-responsive">
											<table id="tbl_det_req_boletos" class="table table-striped table-bordered table-hover">
												<thead>
													<tr class="last">
														<th>Item</th>
														<th>Serie</th>
														<th>Tarifa</th>
														<th>Fecha Doc.</th>
														<th>Cantidad</th>
														<th>Usuario</th>
														<th class="hide"></th>
														<th class="hide"></th>
														<th class="hide"></th>
														<th></th>
														<th></th>
													</tr>
												</thead>
												<tr class="item_det">
													<td>
														<div class="hidden-sm hidden-xs btn-group">
															<button class="btn btn-xs btn-success btn_agr_req_bol">
																<i class="ace-icon fa fa-plus"></i>
															</button>
														</div>																	
													</td>
													<td class="ser_req_bol"></td>
													<td class="tar_req_bol"></td>
													<td class="fec_doc_req_bol"></td>
													<td class="can_req_bol"></td>
													<td class="usu_req_bol"></td>
													<td class="hide cod_tar_bol"></td>
													<td class="hide num_req_ini"></td>
													<td class="hide num_req_fin"></td>
													<td></td>
													<td></td>
												</tr>
											
											</table>
										</div>
									</div>
								</div>	
							</fieldset>
							
							<br/>
							
							<fieldset class="fsStyle">
								<legend class="legendStyle">Distribución de Boletos</legend>
								<div class="row">
									<div class="col-xs-12">
										<div class="table-responsive">
											<table id="tbl_det_dis_boletos" class="table table-striped table-bordered table-hover">
												<thead>
													<tr class="last">
														<th>Item</th>
														<th>Num. Acta</th>
														<th>Fec. Acta</th>
														<th>Serie</th>
														<th>Cantidad</th>
														<th>Saldo</th>
														<th class="hide"></th>
														<th class="hide"></th>
														<th class="hide"></th>
														<th></th>
														<th></th>
													</tr>
												</thead>
												<tr class="item_dis">
													<td>
														<div class="hidden-sm hidden-xs btn-group">
															<button class="btn btn-xs btn-success btn_agr_dis_bol">
																<i class="ace-icon fa fa-plus"></i>
															</button>
														</div>																	
													</td>
													<td class="num_dis_bol"></td>
													<td class="fec_dis_bol"></td>
													<td class="ser_dis_bol"></td>
													<td class="can_dis_bol"></td>
													<td class="sal_dis_bol"></td>													
													<td class="hide cod_tar_bol"></td>
													<td class="hide num_req_ini"></td>
													<td class="hide num_req_fin"></td>
													<td></td>
													<td></td>
												</tr>
											
											</table>
										</div>
									</div>
								</div>	
							</fieldset>
									
						</div>

						<div class="modal-footer">				
							<div class="col-sm-4">
								<button id="btn_grabar" class="btn btn-sm btn-primary input-sm">
									<i class="ace-icon fa fa-check"></i>
									Grabar
								</button>
							</div>
							
							<div class="col-sm-4">
								<button id="btn_eliminar" class="btn btn-sm btn-danger input-sm">
									<i class="ace-icon fa fa-times"></i>
									Eliminar
								</button>
							</div>
							
							<div class="col-sm-4">
								<button class="btn btn-sm input-sm" data-dismiss="modal">
									<i class="ace-icon fa fa-reply"></i>
									Salir
								</button>
							</div>
						</div>
					</div>
				</div>
			</div>			
			
			<div id="div_det_boletos" class="modal" tabindex="-1" data-keyboard="false" data-backdrop="static">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">&times;</button>
							<h4 id="h_det_boletos" class="white bigger center">Solicitado</h4>
						</div>
						
						<div class="modal-body">
							<div class="row">
								<div class="col-xs-12">
									<form id="form_det_boletos" class="form-horizontal" role="form">
										<div class="form-group">																				
											<label class="col-sm-3 control-label input-sm no-padding-right">Tarifa:</label>											
											<div class="col-sm-6">
												<select id="sel_det_tarifa" class="form-control input-sm">
												</select>
											</div>											
										</div>
										
										<div class="form-group">																				
											<label class="col-sm-3 control-label input-sm no-padding-right">Serie:</label>											
											<div class="col-sm-4">
												<input type="text" id="txt_det_serie" class="form-control input-sm" disabled />
											</div>								
										</div>								

										<div class="form-group">																				
											<label class="col-sm-3 control-label input-sm no-padding-right">Cantidad de Boletos:</label>											
											<div class="col-sm-4">
												<input type="text" id="txt_det_can_boletos" class="form-control input-sm onlyNumbers"  />
											</div>	
										</div>
										
										<div class="form-group">																				
											<label class="col-sm-3 control-label input-sm no-padding-right">Numeración Inicial:</label>											
											<div class="col-sm-4">
												<input type="text" id="txt_det_num_inicial" class="form-control input-sm onlyNumbers"  />
											</div>	
										</div>								
										
										<div class="form-group">																				
											<label class="col-sm-3 control-label input-sm no-padding-right">Numeración Final:</label>											
											<div class="col-sm-4">
												<input type="text" id="txt_det_num_final" class="form-control input-sm" disabled />
											</div>											
										</div>
									</form>
								</div>
							</div>			
						</div>

						<div class="modal-footer">				
							<button id="btn_ana_det_boletos" class="btn btn-sm btn-primary">
								<i class="ace-icon fa fa-check"></i>
								Añadir
							</button>
							<button id="btn_edi_det_boletos" class="btn btn-sm btn-primary">
								<i class="ace-icon fa fa-check"></i>
								Grabar
							</button>
							<button id="btn_can_det_boletos" class="btn btn-sm">
								<i class="ace-icon fa fa-times"></i>
								Cancelar
							</button>
						</div>
					</div>
				</div>
			</div>
			
			<div id="div_dis_boletos" class="modal" tabindex="-1" data-keyboard="false" data-backdrop="static">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">&times;</button>
							<h4 id="h_dis_boletos" class="white bigger center">Distribución</h4>
						</div>
						
						<div class="modal-body">
							<div class="row">
								<div class="col-xs-12">
									<form id="form_dis_boletos" class="form-horizontal" role="form">
										<div class="form-group">																				
											<label class="col-sm-3 control-label input-sm no-padding-right">Tarifa:</label>											
											<div class="col-sm-6">
												<select id="sel_dis_tarifa" class="form-control input-sm">
												</select>
											</div>											
										</div>
										
										<div class="form-group">																				
											<label class="col-sm-3 control-label input-sm no-padding-right">Serie:</label>											
											<div class="col-sm-4">
												<input type="text" id="txt_dis_serie" class="form-control input-sm" disabled />
											</div>								
										</div>		
										
										<div class="form-group">																				
											<label class="col-sm-3 control-label input-sm no-padding-right">Nro Acta:</label>											
											<div class="col-sm-4">
												<input type="text" id="txt_dis_nro_acta" class="form-control input-sm" maxlength="10" />
											</div>	
										</div>
											
										<div class="form-group">
											<label class="col-sm-3 control-label label-sm no-padding-right">Fecha Acta:</label>
											<div class="col-sm-4">
												<div class="input-group">
													<input class="form-control input-sm date-picker" id="txt_fec_act_dis" type="text" />
													<span class="input-group-addon" id="sp_ico_fec_act_dis">
														<i class="fa fa-calendar bigger-110"></i>
													</span>
												</div>
											</div>									
										</div>						

										<div class="form-group">																				
											<label class="col-sm-3 control-label input-sm no-padding-right">Cantidad de Boletos:</label>											
											<div class="col-sm-4">
												<input type="text" id="txt_dis_can_boletos" class="form-control input-sm onlyNumbers"  />
											</div>	
										</div>
										
										<div class="form-group">																				
											<label class="col-sm-3 control-label input-sm no-padding-right">Numeración Inicial:</label>											
											<div class="col-sm-4">
												<input type="text" id="txt_dis_num_inicial" class="form-control input-sm onlyNumbers"  />
											</div>	
										</div>								
										
										<div class="form-group">																				
											<label class="col-sm-3 control-label input-sm no-padding-right">Numeración Final:</label>											
											<div class="col-sm-4">
												<input type="text" id="txt_dis_num_final" class="form-control input-sm" disabled />
											</div>											
										</div>
									</form>
								</div>
							</div>			
						</div>

						<div class="modal-footer">				
							<button id="btn_ana_dis_boletos" class="btn btn-sm btn-primary">
								<i class="ace-icon fa fa-check"></i>
								Añadir
							</button>
							<button id="btn_edi_dis_boletos" class="btn btn-sm btn-primary">
								<i class="ace-icon fa fa-check"></i>
								Grabar
							</button>
							<button id="btn_can_dis_boletos" class="btn btn-sm">
								<i class="ace-icon fa fa-times"></i>
								Cancelar
							</button>
						</div>
					</div>
				</div>
			</div>
		
		</div><!-- /.main-container -->
	
		<%@ include file="scripts_ini.jsp" %>	

		<!-- inline scripts related to this page -->
		<script type="text/javascript">
		
			var arr_tar_boletos = [];
		
			$(document).ready(function() {
				
				$("#li_ingresos").addClass('active');
				$("#li_req_boletos").addClass('active');
				
				inicializarDatos();
				
				$('.date-picker').datepicker({
					autoclose: true,
					todayHighlight: true
				});
				
				$('.input-group-addon').click(function(event){
					event.preventDefault();
					var id_sp = $(this).attr('id').substring(7);
					$('#txt_'+id_sp).datepicker('show');
				});
				
				$('#txt_fec_ini').datepicker().on('changeDate', function (ev) {
					var fec_ini = $(this).val();
					var dia = parseInt(fec_ini.substring(0, 2)) + 1;
					var mes = fec_ini.substring(3, 5);
					var anio = fec_ini.substring(6, 10);
					var fec_form = anio + '-' + mes + '-' + dia;					
					var fec_act = new Date(fec_form);
					$('#txt_fec_fin').datepicker('setStartDate', fec_act);
				});
				
				$('#sel_uni_operativa').on('change', function() {					
					if (!esnulo($(this).val())) {
						obtenerAnp($(this).val(), '#sel_anp');
					} else {
						$('#sel_anp').html('');
					}					
				});
				
				$('#sel_uni_req_boletos').on('change', function() {
					var cod_uni_operativa = $(this).val();
					$.ajax({
						type: 'GET',
						url: '${pageContext.request.contextPath}/listarUnidadOperativa',
						data: {
							ind_uni_operativa : 1, // ANP
							cod_uni_operativa : cod_uni_operativa
						},
						dataType: 'json',
						success: function(paramJson) {						
							if (paramJson != null) {							
								var options = '';
								var row = 0;
								var cod_anp = null;
								$.each(paramJson, function(index, item) {
									options += '<option value="'+item.cod_reg_nac+'">'+item.des_reg_nac+'</option>';
									if (row == 0) {
										cod_anp = item.cod_reg_nac;
									}
									row = row + 1;									
								});
								$('#sel_anp_req_boletos').html(options);
								
								obtenerTarifaBoleto(cod_uni_operativa, cod_anp);
							} else {
								$('#sel_anp_req_boletos').html('');
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
					
				});
				
				$('#btn_buscar').click(function(e) {					
					e.preventDefault();
					search();
				});
				
				$('#btn_nuevo').click(function(e) {					
					e.preventDefault();					
					
					$('#h_det_req_boletos').html('Nuevo Requerimiento de Boleto');
					$('#txt_nro_doc_req_boletos').val('');
					$('#txt_fec_doc_req_boletos').val('');
					$('#btn_eliminar').hide();
					$('#div_det_req_boletos').modal('show');
					
					// Eliminamos el detalle
					rem_detalle();

				});
				
				$('#sel_anp_req_boletos').on('change', function() {
					obtenerTarifaBoleto($('#sel_uni_req_boletos').val(), $(this).val());
				});
				
				$('#sel_det_tarifa').on('change', function() {				
					for (var i = 0; i < arr_tar_boletos.length; i++) {
						var fields = arr_tar_boletos[i].split('|');								
						if (fields[0] == $(this).val()) {
							$('#txt_det_serie').val(fields[3]);								
							break;
						}
					}					
				});	
				
				$('.btn_agr_req_bol').click(function(e) {					
					e.preventDefault();	
					
					var nro_doc = $('#txt_nro_doc_req_boletos').val();
					var fec_doc = $('#txt_fec_doc_req_boletos').val();
					if (esnulo(nro_doc)) {
						addWarnMessage(null, 'El campo "Nro Doc." es obligatorio.');
						return;
					}
					if (esnulo(fec_doc)) {
						addWarnMessage(null, 'El campo "Fecha Doc." es obligatorio.');
						return;
					}
										
					// Removemos las tarifas boletos utilizadas y validamos el detalle					
					var estado = rem_det_boleto();
					if (!esnulo(estado)) {
						addWarnMessage(null, estado);
						return;
					}					

					$('#txt_det_can_boletos').val('');
					$('#txt_det_num_inicial').val('');
					$('#txt_det_num_final').val('');		
					
					$('#sel_det_tarifa').prop('disabled', false);
					
					$('#btn_ana_det_boletos').show();
					$('#btn_edi_det_boletos').hide();
					$('#div_det_boletos').modal('show');					
				});
				
				$('#txt_det_can_boletos').change(function() {
					var can_boletos = $(this).val();
					var num_inicial = $('#txt_det_num_inicial').val();
					if (!esnulo(can_boletos) && !esnulo(num_inicial)) {						
 						$('#txt_det_num_final').val(parseInt(can_boletos) + parseInt(num_inicial) - 1);
					}
 				});
				
				$('#txt_det_num_inicial').change(function() {
					var can_boletos = $('#txt_det_can_boletos').val();
					var num_inicial = $(this).val();
					if (!esnulo(can_boletos) && !esnulo(num_inicial)) {						
 						$('#txt_det_num_final').val(parseInt(can_boletos) + parseInt(num_inicial) - 1);
					}
 				});
				
				$('#btn_ana_det_boletos').click(function(e) {					
					e.preventDefault();
					
					var cod_tar_boleto = $('#sel_det_tarifa').val();
					var des_tar_boleto = $('#sel_det_tarifa').find('option:selected').text();
					var num_serie = $('#txt_det_serie').val();					
					var can_boletos = $('#txt_det_can_boletos').val();
					var num_inicial = $('#txt_det_num_inicial').val();
					var num_final = $('#txt_det_num_final').val();
					var fec_doc = $('#txt_fec_doc_req_boletos').val();
					var msg = '';	
					if (esnulo(can_boletos)) {
						msg = msg + 'El campo "Cantidad de Boletos" es obligatorio.<br/>';
					}
					if (esnulo(num_inicial)) {
						msg = msg + 'El campo "Numeración Inicial" es obligatorio.<br/>';
					}
					if (!esnulo(msg)) {
						addWarnMessage(null, msg);
						return;
					}
					
					var row = 0;
					$('tr.item_det').each(function() {
						row = row + 1;
					});
					
					des_tar_boleto = des_tar_boleto.substring(des_tar_boleto.indexOf('-')+2);
					
					var row_det = '<tr class="item_det">'+
									'<td>'+row+'</td>'+
									'<td class="ser_req_bol">'+num_serie+'</td>'+
									'<td class="tar_req_bol">'+des_tar_boleto+'</td>'+
									'<td class="fec_doc_req_bol">'+fec_doc+'</td>'+
									'<td class="can_req_bol">'+can_boletos+'</td>'+
									'<td class="usu_req_bol">'+'${usuarioBean.des_usuario}'+'</td>'+
									'<td class="hide cod_tar_bol">'+cod_tar_boleto+'</td>'+
									'<td class="hide num_req_ini">'+num_inicial+'</td>'+
									'<td class="hide num_req_fin">'+num_final+'</td>'+
									'<td>'+
										'<button class="btn btn-sm btn-warning input-sm btn_edi_req_bol">'+
											'<i class="ace-icon fa fa-pencil-square-o"></i>'+
										'</button>'+
									'</td>'+
									'<td>'+
										'<button class="btn btn-sm btn-danger input-sm btn_rem_req_bol">'+
											'<i class="ace-icon fa fa-trash-o"></i>'+
										'</button>'+																																	
									'</td>'+
								  '</tr>';		  
								  
								  
				  
					$('#tbl_det_req_boletos tr').eq(row-1).after(row_det);
					
					$('#div_det_boletos').modal('hide');					
					
				});
				
				$('#tbl_det_req_boletos').on('click', '.btn_edi_req_bol', function(e) {
					e.preventDefault();
					$('#h_det_reg_transferencias').html('Editar Detalle');
					
					var row = $(this).closest('tr'); // Find the row
					
					// Extraemos los datos del registro
				    var ser_req_bol = $.trim(row.find('.ser_req_bol').text());
				    var tar_req_bol = $.trim(row.find('.tar_req_bol').text());
				    var fec_doc_req_bol = $.trim(row.find('.fec_doc_req_bol').text());
					var can_req_bol = $.trim(row.find('.can_req_bol').text());
				    var usu_req_bol = $.trim(row.find('.usu_req_bol').text());
				    var cod_tar_bol = $.trim(row.find('.cod_tar_bol').text());
				    var num_req_ini = $.trim(row.find('.num_req_ini').text());
					var num_req_fin = $.trim(row.find('.num_req_fin').text());		

					
					// Removemos las tarifas boletos utilizadas y validamos el detalle					
					rem_det_boleto();
					
					// Agregamos la partida utilizada al combo detalle
					$('#sel_det_tarifa').append($('<option>', {
						value: cod_tar_bol,
						text: ser_req_bol + ' - ' + tar_req_bol
					}));
					
					
					// Validamos que la cantidad de boletos entregados al detalle del requerimiento
					var can_dis_bol = 0;
					$('tr.item_dis').each(function() {
						var cod_tar_bol_dis = $(this).find('.cod_tar_bol').text();
						if (cod_tar_bol_dis == cod_tar_bol) {
							can_dis_bol = can_dis_bol + parseInt($(this).find('.can_dis_bol').text());
						}
					});
					if (can_dis_bol > 0) {						
						$('#sel_det_tarifa').prop('disabled', true);		
					} else {
						$('#sel_det_tarifa').prop('disabled', false);
					}
					
					
				 	// Asignamos los datos del registro al formulario
				    $('#sel_det_tarifa').val(cod_tar_bol);
					$('#txt_det_serie').val(ser_req_bol);
					$('#txt_det_can_boletos').val(can_req_bol);
					
					$('#txt_det_num_inicial').val(num_req_ini);
					$('#txt_det_num_final').val(num_req_fin);
					
					$('#hid_req_boletos').val(cod_tar_bol);		
					
					$('#btn_ana_det_boletos').hide();
					$('#btn_edi_det_boletos').show();
					$('#hid_req_bol_ant').val(cod_tar_bol);
					$('#div_det_boletos').modal('show');
				});
				
				$('#btn_edi_det_boletos').click(function(e) {
					e.preventDefault();
					
					var cod_tar_boleto = $('#sel_det_tarifa').val();
					var des_tar_boleto = $('#sel_det_tarifa').find('option:selected').text();
					var num_serie = $('#txt_det_serie').val();					
					var can_boletos = $('#txt_det_can_boletos').val();
					var num_inicial = $('#txt_det_num_inicial').val();
					var num_final = $('#txt_det_num_final').val();
					var fec_doc = $('#txt_fec_doc_req_boletos').val();
					var val_req_bol_ant = $('#hid_req_bol_ant').val();
					var msg = '';	
					if (esnulo(can_boletos)) {
						msg = msg + 'El campo "Cantidad de Boletos" es obligatorio.<br/>';
					}
					if (esnulo(num_inicial)) {
						msg = msg + 'El campo "Numeración Inicial" es obligatorio.<br/>';
					}
					if (!esnulo(msg)) {
						addWarnMessage(null, msg);
						return;
					}
									
					
					// Validamos que la cantidad de boletos entregados sea igual o mayor al detalle del requerimiento
					var can_dis_bol = 0;
					$('tr.item_dis').each(function() {
						var cod_tar_bol_dis = $(this).find('.cod_tar_bol').text();
						if (cod_tar_bol_dis == cod_tar_boleto) {
							can_dis_bol = can_dis_bol + parseInt($(this).find('.can_dis_bol').text());
						}
					});	
					if (can_dis_bol > 0 && can_dis_bol > parseInt(can_boletos)) {						
						addWarnMessage(null, 'El campo "Cantidad de Boletos" no puede ser menor a la cantidad de boletos entregados.');
						return;						
					}
					
										
					// Editamos el registro actual
					var row = 0;
					$('tr.item_det').each(function() {
						row = row + 1;
						var ind_boleto = $(this).find('.cod_tar_bol').text();						
						if (ind_boleto == val_req_bol_ant) {
							return false;
						}
					});
					$('#tbl_det_req_boletos tr').eq(row).find('td').eq(1).html(num_serie);
					$('#tbl_det_req_boletos tr').eq(row).find('td').eq(2).html(des_tar_boleto);
					$('#tbl_det_req_boletos tr').eq(row).find('td').eq(3).html(fec_doc);
					$('#tbl_det_req_boletos tr').eq(row).find('td').eq(4).html(can_boletos);
					$('#tbl_det_req_boletos tr').eq(row).find('td').eq(5).html('${usuarioBean.des_usuario}');
					$('#tbl_det_req_boletos tr').eq(row).find('td').eq(6).html(cod_tar_boleto);
					$('#tbl_det_req_boletos tr').eq(row).find('td').eq(7).html(num_inicial);
					$('#tbl_det_req_boletos tr').eq(row).find('td').eq(8).html(num_final);
					
					// Removemos las tarifas boletos utilizadas y validamos el detalle					
					rem_det_boleto();
					
					$('#div_det_boletos').modal('hide');
				});
				
				$('#tbl_det_req_boletos').on('click', '.btn_rem_req_bol', function(e) {				
					e.preventDefault();
					
					var row = $(this).closest('tr');
					
					bootbox.dialog({
						message: "<span class='bigger-110'>Está seguro de eliminar el registro ?</span>",
						buttons: {
							"click" : {
								"label" : "Aceptar",
								"className" : "btn-sm btn-primary",
								"callback": function() {
									// Removemos el registro actual									
									row.remove();
									
									// Reordernamos el numero de item del detalle
									var row_num = 0;
									$('tr.item_det').each(function() {
										row_num = row_num + 1;
										var ind_boleto = $(this).find('.cod_tar_bol').text();
										if (!esnulo(ind_boleto)) {
											$('#tbl_det_req_boletos tr').eq(row_num).find('td').eq(0).html(row_num);
										}
									});									
								}
							}, 
							"button" : {
								"label" : "Cancelar",
								"className" : "btn-sm"
							}
						}
					});
				});
				
				$('#btn_can_det_boletos').click(function(e) {					
					e.preventDefault();
					// Removemos las tarifas boletos utilizadas y validamos el detalle					
					rem_det_boleto();
					$('#div_det_boletos').modal('hide');
				});
				
				$('.btn_agr_dis_bol').click(function(e) {					
					e.preventDefault();	
					
					var nro_doc = $('#txt_nro_doc_req_boletos').val();
					var fec_doc = $('#txt_fec_doc_req_boletos').val();
					if (esnulo(nro_doc)) {
						addWarnMessage(null, 'El campo "Nro Doc." es obligatorio.');
						return;
					}
					if (esnulo(fec_doc)) {
						addWarnMessage(null, 'El campo "Fecha Doc." es obligatorio.');
						return;
					}
					
					// Validamos que exista un detalle requerimientos de boletos
					var row_num = 0;
					$('tr.item_det').each(function() {						
						var ind_boleto = $(this).find('.cod_tar_bol').text();
						if (!esnulo(ind_boleto)) {
							row_num = row_num + 1;
						}
					});	
					
					if (row_num == 0) {
						addWarnMessage(null, 'Es necesario que exista un detalle requerimientos de boletos previamente.');
						return;
					}
										
					// Cargamos las tarifas del detalle requerimientos de boletos
					obt_dis_boleto();
						
					$('#txt_dis_nro_acta').val('');
					$('#txt_fec_act_dis').val('');
					$('#txt_dis_can_boletos').val('');
					$('#txt_dis_num_inicial').val('');
					$('#txt_dis_num_final').val('');					
					
					$('#sel_dis_tarifa').prop('disabled', false);
					$('#btn_ana_dis_boletos').show();
					$('#btn_edi_dis_boletos').hide();
					$('#div_dis_boletos').modal('show');					
				});
				
				$('#sel_dis_tarifa').on('change', function() {				
					for (var i = 0; i < arr_tar_boletos.length; i++) {
						var fields = arr_tar_boletos[i].split('|');								
						if (fields[0] == $(this).val()) {
							$('#txt_dis_serie').val(fields[3]);								
							break;
						}
					}					
				});
				
				$('#txt_dis_can_boletos').change(function() {
					var can_boletos = $(this).val();
					var num_inicial = $('#txt_dis_num_inicial').val();
					if (!esnulo(can_boletos) && !esnulo(num_inicial)) {						
 						$('#txt_dis_num_final').val(parseInt(can_boletos) + parseInt(num_inicial) - 1);
					}
 				});
				
				$('#txt_dis_num_inicial').change(function() {
					var can_boletos = $('#txt_dis_can_boletos').val();
					var num_inicial = $(this).val();
					if (!esnulo(can_boletos) && !esnulo(num_inicial)) {						
 						$('#txt_dis_num_final').val(parseInt(can_boletos) + parseInt(num_inicial) - 1);
					}
 				});
				
				$('#btn_ana_dis_boletos').click(function(e) {					
					e.preventDefault();
					
					var cod_tar_boleto = $('#sel_dis_tarifa').val();
					var num_serie = $('#txt_dis_serie').val();					
					var nro_acta = $('#txt_dis_nro_acta').val();
					var fec_act = $('#txt_fec_act_dis').val();					
					var can_boletos = parseInt($('#txt_dis_can_boletos').val());
					var num_inicial = $('#txt_dis_num_inicial').val();
					var num_final = $('#txt_dis_num_final').val();
					var msg = '';
					if (esnulo(nro_acta)) {
						msg = msg + 'El campo "Nro Acta" es obligatorio.<br/>';
					}
					if (esnulo(fec_act)) {
						msg = msg + 'El campo "Fecha Acta" es obligatorio.<br/>';
					}					
					if (esnulo(can_boletos)) {
						msg = msg + 'El campo "Cantidad de Boletos" es obligatorio.<br/>';
					}
					if (esnulo(num_inicial)) {
						msg = msg + 'El campo "Numeración Inicial" es obligatorio.<br/>';
					}
					if (!esnulo(msg)) {
						addWarnMessage(null, msg);
						return;
					}
					
					
					// Validamos la cantidad de boletos del detalle requerimientos de boletos
					var can_solicitada = 0; 
					$('tr.item_det').each(function() {						
						var ind_boleto = $(this).find('.cod_tar_bol').text();
						if (ind_boleto == cod_tar_boleto) {
							can_solicitada = parseInt($(this).find('.can_req_bol').text());
							return false;
						}
					});	
					
					var row = 0;
					var can_dis_ant = 0;
					$('tr.item_dis').each(function() {
						row = row + 1;
						var ind_boleto = $(this).find('.cod_tar_bol').text();
						if (ind_boleto == cod_tar_boleto) {
							can_dis_ant = can_dis_ant + parseInt($(this).find('.can_dis_bol').text());
						}						
					});					
					
					var can_dis_bol = can_dis_ant + can_boletos;
					var can_sal_bol = 0;
					if (can_dis_bol > can_solicitada) {
						addWarnMessage(null, 'La cantidad total de boletos por serie no debe ser mayor a lo solicitado.');
						return;
					} else {
						can_sal_bol = can_solicitada - can_dis_bol;
					}										
					
					var row_dis = '<tr class="item_dis">'+
									'<td>'+row+'</td>'+
									'<td class="num_dis_bol">'+nro_acta+'</td>'+
									'<td class="fec_dis_bol">'+fec_act+'</td>'+
									'<td class="ser_dis_bol">'+num_serie+'</td>'+
									'<td class="can_dis_bol">'+can_boletos+'</td>'+
									'<td class="sal_dis_bol">'+can_sal_bol+'</td>'+
									'<td class="hide cod_tar_bol">'+cod_tar_boleto+'</td>'+
									'<td class="hide num_req_ini">'+num_inicial+'</td>'+
									'<td class="hide num_req_fin">'+num_final+'</td>'+
									'<td>'+
										'<button class="btn btn-sm btn-warning input-sm btn_edi_req_bol">'+
											'<i class="ace-icon fa fa-pencil-square-o"></i>'+
										'</button>'+
									'</td>'+
									'<td>'+
										'<button class="btn btn-sm btn-danger input-sm btn_rem_req_bol">'+
											'<i class="ace-icon fa fa-trash-o"></i>'+
										'</button>'+																																	
									'</td>'+
								  '</tr>';		  
								  
								  
				  
					$('#tbl_det_dis_boletos tr').eq(row-1).after(row_dis);
					
					$('#div_dis_boletos').modal('hide');					
					
				});
				
				$('#tbl_det_dis_boletos').on('click', '.btn_edi_req_bol', function(e) {
					e.preventDefault();
					$('#h_det_reg_transferencias').html('Editar Detalle');
					
					var row = $(this).closest('tr'); // Find the row
					
					// Extraemos los datos del registro
					var num_dis_bol = $.trim(row.find('.num_dis_bol').text());
					var fec_dis_bol = $.trim(row.find('.fec_dis_bol').text());					
				    var ser_dis_bol = $.trim(row.find('.ser_dis_bol').text());
				    var can_dis_bol = $.trim(row.find('.can_dis_bol').text());
				    var sal_dis_bol = $.trim(row.find('.sal_dis_bol').text());
				    var cod_tar_bol = $.trim(row.find('.cod_tar_bol').text());
				    var num_req_ini = $.trim(row.find('.num_req_ini').text());
					var num_req_fin = $.trim(row.find('.num_req_fin').text());
					
				 	// Asignamos los datos del registro al formulario
				    $('#sel_dis_tarifa').val(cod_tar_bol);
					$('#txt_dis_serie').val(ser_dis_bol);
					
					$('#txt_dis_nro_acta').val(num_dis_bol);
					$('#txt_fec_act_dis').val(fec_dis_bol);					
					$('#txt_dis_can_boletos').val(can_dis_bol);					
					$('#txt_dis_num_inicial').val(num_req_ini);
					$('#txt_dis_num_final').val(num_req_fin);
					
					$('#hid_req_boletos').val(cod_tar_bol);		
					
					$('#sel_dis_tarifa').prop('disabled', true);
					$('#btn_ana_dis_boletos').hide();
					$('#btn_edi_dis_boletos').show();
					$('#hid_req_bol_ant').val(cod_tar_bol);
					$('#div_dis_boletos').modal('show');
				});
				
				$('#btn_edi_dis_boletos').click(function(e) {
					e.preventDefault();
					
					var cod_tar_boleto = $('#sel_dis_tarifa').val();
					var num_serie = $('#txt_dis_serie').val();					
					var nro_acta = $('#txt_dis_nro_acta').val();
					var fec_act = $('#txt_fec_act_dis').val();					
					var can_boletos = parseInt($('#txt_dis_can_boletos').val());
					var num_inicial = $('#txt_dis_num_inicial').val();
					var num_final = $('#txt_dis_num_final').val();
					var val_req_bol_ant = $('#hid_req_bol_ant').val();
					var msg = '';
					if (esnulo(nro_acta)) {
						msg = msg + 'El campo "Nro Acta" es obligatorio.<br/>';
					}
					if (esnulo(fec_act)) {
						msg = msg + 'El campo "Fecha Acta" es obligatorio.<br/>';
					}					
					if (esnulo(can_boletos)) {
						msg = msg + 'El campo "Cantidad de Boletos" es obligatorio.<br/>';
					}
					if (esnulo(num_inicial)) {
						msg = msg + 'El campo "Numeración Inicial" es obligatorio.<br/>';
					}
					if (!esnulo(msg)) {
						addWarnMessage(null, msg);
						return;
					}
					
					
					// Editamos el registro actual
					var row = 0;
					var can_dis_act = 0;
					$('tr.item_dis').each(function() {
						row = row + 1;
						var ind_boleto = $(this).find('.cod_tar_bol').text();						
						if (ind_boleto == val_req_bol_ant) {
							can_dis_act = parseInt($(this).find('.can_dis_bol').text());
							return false;
						}
					});
					
					
					// Validamos la cantidad de boletos del detalle requerimientos de boletos
					var can_solicitada = 0; 
					$('tr.item_det').each(function() {						
						var ind_boleto = $(this).find('.cod_tar_bol').text();
						if (ind_boleto == cod_tar_boleto) {
							can_solicitada = parseInt($(this).find('.can_req_bol').text());
							return false;
						}
					});	
					
					var can_dis_ant = 0;
					$('tr.item_dis').each(function() {
						var ind_boleto = $(this).find('.cod_tar_bol').text();
						if (ind_boleto == cod_tar_boleto) {
							can_dis_ant = can_dis_ant + parseInt($(this).find('.can_dis_bol').text());
						}						
					});					
					
					var can_dis_bol = can_dis_ant + can_boletos - can_dis_act;
					var can_sal_bol = 0;
					if (can_dis_bol > can_solicitada) {
						addWarnMessage(null, 'La cantidad total de boletos por serie no debe ser mayor a lo solicitado.');
						return;
					} else {
						can_sal_bol = can_solicitada - can_dis_bol;
					}
					
					$('#tbl_det_dis_boletos tr').eq(row).find('td').eq(1).html(nro_acta);
					$('#tbl_det_dis_boletos tr').eq(row).find('td').eq(2).html(fec_act);
					$('#tbl_det_dis_boletos tr').eq(row).find('td').eq(3).html(num_serie);
					$('#tbl_det_dis_boletos tr').eq(row).find('td').eq(4).html(can_boletos);
					$('#tbl_det_dis_boletos tr').eq(row).find('td').eq(5).html(can_sal_bol);
					$('#tbl_det_dis_boletos tr').eq(row).find('td').eq(6).html(cod_tar_boleto);
					$('#tbl_det_dis_boletos tr').eq(row).find('td').eq(7).html(num_inicial);
					$('#tbl_det_dis_boletos tr').eq(row).find('td').eq(8).html(num_final);
					
					$('#div_dis_boletos').modal('hide');
				});
				
				$('#tbl_det_dis_boletos').on('click', '.btn_rem_req_bol', function(e) {				
					e.preventDefault();
					
					var row = $(this).closest('tr');
					
					bootbox.dialog({
						message: "<span class='bigger-110'>Está seguro de eliminar el registro ?</span>",
						buttons: {
							"click" : {
								"label" : "Aceptar",
								"className" : "btn-sm btn-primary",
								"callback": function() {
									// Removemos el registro actual									
									row.remove();
									
									// Reordernamos el numero de item del detalle
									var row_num = 0;
									$('tr.item_dis').each(function() {
										row_num = row_num + 1;
										var ind_boleto = $(this).find('.cod_tar_bol').text();
										if (!esnulo(ind_boleto)) {
											$('#tbl_det_dis_boletos tr').eq(row_num).find('td').eq(0).html(row_num);
										}
									});									
								}
							}, 
							"button" : {
								"label" : "Cancelar",
								"className" : "btn-sm"
							}
						}
					});
				});
				
				$('#btn_can_dis_boletos').click(function(e) {					
					e.preventDefault();
					$('#div_dis_boletos').modal('hide');
				});
				
				$('#btn_grabar').click(function(e) {					
					e.preventDefault();
					
					var codigo = $('#hid_cod_req_boletos').val();
					var num_docu = $('#txt_nro_doc_req_boletos').val();
					var fec_documento = $('#txt_fec_doc_req_boletos').val();
					var msg = '';										
					if (esnulo(num_docu)) {
						msg = msg + 'El campo "Nro Doc." es obligatorio.<br/>';
					}
					if (esnulo(fec_documento)) {
						msg = msg + 'El campo "Fecha Doc." es obligatorio.<br/>';
					} else {
						if (!checkdate(fec_documento)) {
							msg = msg + 'El campo "Fecha Doc." tiene formato de fecha incorrecto.<br/>';
						}						
					}
					
					var arr_cod_tar_bol = '';
					var arr_can_req_bol = '';
					var arr_num_req_ini = '';
					var arr_num_req_fin = '';
					var row = 0;
					$('tr.item_det').each(function() {		
						var ind_boleto = $(this).find('.cod_tar_bol').text();
						if (!esnulo(ind_boleto)) {
							arr_cod_tar_bol = arr_cod_tar_bol + $(this).find('.cod_tar_bol').text() + '|';
							arr_can_req_bol = arr_can_req_bol + $(this).find('.can_req_bol').text() + '|';
							arr_num_req_ini = arr_num_req_ini + $(this).find('.num_req_ini').text() + '|';
							arr_num_req_fin = arr_num_req_fin + $(this).find('.num_req_fin').text() + '|';
							row = row + 1;
						}						
					});
					if (row > 0) {
						arr_cod_tar_bol = arr_cod_tar_bol.substring(0, arr_cod_tar_bol.length - 1);
						arr_can_req_bol = arr_can_req_bol.substring(0, arr_can_req_bol.length - 1);
						arr_num_req_ini = arr_num_req_ini.substring(0, arr_num_req_ini.length - 1);
						arr_num_req_fin = arr_num_req_fin.substring(0, arr_num_req_fin.length - 1);
					} else {
						addWarnMessage(null, 'Debe Agregar Detalle de Requerimientos Boletos.');
						return;
					}
					
					
					var arr_cod_tar_bol_dis = '';
					var arr_num_dis_bol_dis = '';
					var arr_fec_dis_bol_dis = '';
					var arr_can_dis_bol_dis = '';
					var arr_num_req_ini_dis = '';
					var arr_num_req_fin_dis = '';
					var row_dis = 0;
					$('tr.item_dis').each(function() {		
						var ind_boleto = $(this).find('.cod_tar_bol').text();
						if (!esnulo(ind_boleto)) {
							arr_cod_tar_bol_dis = arr_cod_tar_bol_dis + $(this).find('.cod_tar_bol').text() + '|';
							arr_num_dis_bol_dis = arr_num_dis_bol_dis + $(this).find('.num_dis_bol').text() + '|';
							arr_fec_dis_bol_dis = arr_fec_dis_bol_dis + $(this).find('.fec_dis_bol').text() + '|';
							arr_can_dis_bol_dis = arr_can_dis_bol_dis + $(this).find('.can_dis_bol').text() + '|';
							arr_num_req_ini_dis = arr_num_req_ini_dis + $(this).find('.num_req_ini').text() + '|';
							arr_num_req_fin_dis = arr_num_req_fin_dis + $(this).find('.num_req_fin').text() + '|';
							row_dis = row_dis + 1;
						}						
					});
					if (row_dis > 0) {
						arr_cod_tar_bol_dis = arr_cod_tar_bol_dis.substring(0, arr_cod_tar_bol_dis.length - 1);
						arr_num_dis_bol_dis = arr_num_dis_bol_dis.substring(0, arr_num_dis_bol_dis.length - 1);
						arr_fec_dis_bol_dis = arr_fec_dis_bol_dis.substring(0, arr_fec_dis_bol_dis.length - 1);
						arr_can_dis_bol_dis = arr_can_dis_bol_dis.substring(0, arr_can_dis_bol_dis.length - 1);
						arr_num_req_ini_dis = arr_num_req_ini_dis.substring(0, arr_num_req_ini_dis.length - 1);
						arr_num_req_fin_dis = arr_num_req_fin_dis.substring(0, arr_num_req_fin_dis.length - 1);
					}
										
					
					var new_record = true;
					if (!esnulo(codigo)) {
						new_record = false;
					}
													
					$.ajax({
						type: 'POST',
						url: VAR_CONTEXT + '/grabarRequeBoletos',
						data: { 
							cod_req_boleto : codigo,
							num_docu : num_docu,
							fec_documento : fec_documento,
							cod_uni_operativa : $('#sel_uni_req_boletos').val(),
							cod_reg_nac : $('#sel_anp_req_boletos').val(), 
							arr_cod_tar_bol : arr_cod_tar_bol,
							arr_can_req_bol : arr_can_req_bol,
							arr_num_req_ini : arr_num_req_ini,
							arr_num_req_fin : arr_num_req_fin,
							arr_cod_tar_bol_dis : arr_cod_tar_bol_dis,
							arr_num_dis_bol_dis : arr_num_dis_bol_dis,
							arr_fec_dis_bol_dis : arr_fec_dis_bol_dis,
							arr_can_dis_bol_dis : arr_can_dis_bol_dis,
							arr_num_req_ini_dis : arr_num_req_ini_dis,
							arr_num_req_fin_dis : arr_num_req_fin_dis							
						},
						dataType: 'json',
						success: function(paramJson) {						
							if (paramJson != null) {			
								$('#hid_cod_transferencia').val(paramJson);
								if (new_record) {
									addInfoMessage(null, 'El registro fue grabado.');
									$('#div_det_req_boletos').modal('hide');												
									search();
								} else {
									addInfoMessage(null, 'Registro Actualizado.');
									$('#div_det_req_boletos').modal('hide');
								}								
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
				});
				
				$('#btn_eliminar').click(function(e) {					
					e.preventDefault();
					bootbox.dialog({
						message: "<span class='bigger-110'>Está seguro de eliminar el registro ?</span>",
						buttons: {
							"click" : {
								"label" : "Aceptar",
								"className" : "btn-sm btn-primary",
								"callback": function() {
									var codigo = $('#hid_cod_req_boletos').val();
									$.ajax({
										type: 'POST',
										url: VAR_CONTEXT + '/eliminarRequeBoletos',
										data: { codigo: codigo },
										dataType: 'json',
										success: function(paramJson) {						
											if (paramJson != null) {
												$('#div_det_req_boletos').modal('hide');												
												search();
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
							}, 
							"button" : {
								"label" : "Cancelar",
								"className" : "btn-sm"
							}
						}
					});
				});
				
			});
			
			function search() {
				var fec_ini = $('#txt_fec_ini').val();
				var fec_fin = $('#txt_fec_fin').val();
				if (!esnulo(fec_ini) && !esnulo(fec_fin)) {
					if (!checkdate(fec_ini) || !checkdate(fec_fin)) {
						var msg = 'El campo "Fecha" tiene formato de fecha incorrecto.';
						addWarnMessage(null, msg);
						return;
					}
				}
				var cod_uni_operativa = $('#sel_uni_operativa').val();
				if ('${ind_sed_principal}' == '0') { // No es sede principal
					if (esnulo(cod_uni_operativa)) {
						cod_uni_operativa = $('#sel_uni_operativa option').last().val();
					}					
				}
				var href = '/listarRequeBoletos';
				var params = { 
					cod_uni_operativa : cod_uni_operativa,
					cod_reg_nac : $('#sel_anp').val(),
					num_docu : $('#txt_nro_cp').val(),
					fec_ini : fec_ini,
					fec_fin : fec_fin,
					ind_detalle : 1 // Indicador detalle
				};
				var fields = [
					'cod_req_boleto',
					'num_docu'
				];
				var layout = [{
					title: 'Item',
					type: 'enum',
					'class': 'center no-sort'
				}, {
					title: 'Nro Doc.',
					field: fields,
					type: 'link',					
					label: '',
					method: 'editar',
					'class': 'no-sort',
				}, {
					title: 'Fecha',
					field: 'fec_documento',
					'class': 'no-sort'
				}, {
					title: 'Cantidad',
					field: 'num_can_boleto',
					'class': 'utilRight no-sort'
				}, {
					title: 'Sede Origen',
					field: 'des_uni_operativa',
					'class': 'no-sort'
				}, {
					title: 'Usuario Reg.',
					field: 'mnt_usu_creacion',
					'class': 'no-sort'
				}, {
					title: 'Fec. Registro',
					field: 'mnt_fec_creacion',
					'class': 'no-sort'
				}, {
					title: 'Usuario Mod.',
					field: 'mnt_usu_modificacion',
					'class': 'no-sort'
				}, {
					title: 'Fec. Modifica',
					field: 'mnt_fec_modificacion',
					'class': 'no-sort'				
				}];
				var options = {
					containerTable: '.div_reg_req_boletos',
					idTable: 'tbl_reg_req_boletos',
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
			
			function editar(object) {				
				startAjax();
				
				$.ajax({
					type: 'GET',
					url: '${pageContext.request.contextPath}/obtenerRequeBoleto',
					data: {
						codigo : object
					},
					dataType: 'json',
					success: function(paramJson) {						
						if (paramJson != null) {							

							$('#h_det_req_boletos').html('Editar Requerimiento de Boleto');
							$('#sel_uni_req_boletos').val(paramJson.cod_uni_operativa);
							$('#sel_anp_req_boletos').val(paramJson.cod_reg_nac);
							$('#txt_nro_doc_req_boletos').val(paramJson.num_docu);
							$('#txt_fec_doc_req_boletos').val(paramJson.fec_documento);
							
							// Eliminamos el detalle
							rem_detalle();
							
							var row = 0;
							var row_num = 1;
							if (paramJson.detalle != null) {
								$.each(paramJson.detalle, function(index, item) {
									var row_det = '<tr class="item_det">'+
													'<td>'+row_num+'</td>'+
													'<td class="ser_req_bol">'+item.num_serie+'</td>'+
													'<td class="tar_req_bol">'+item.des_ind_tarifa+' - '+item.nom_boleto+'</td>'+
													'<td class="fec_doc_req_bol">'+paramJson.fec_documento+'</td>'+
													'<td class="can_req_bol">'+item.num_can_boleto+'</td>'+
													'<td class="usu_req_bol">'+item.mnt_usu_creacion+'</td>'+
													'<td class="hide cod_tar_bol">'+item.cod_tar_boleto+'</td>'+
													'<td class="hide num_req_ini">'+item.num_inicio+'</td>'+
													'<td class="hide num_req_fin">'+item.num_final+'</td>'+
													'<td>'+
														'<button class="btn btn-sm btn-warning input-sm btn_edi_req_bol">'+
															'<i class="ace-icon fa fa-pencil-square-o"></i>'+
														'</button>'+
													'</td>'+
													'<td>'+
														'<button class="btn btn-sm btn-danger input-sm btn_rem_req_bol">'+
															'<i class="ace-icon fa fa-trash-o"></i>'+
														'</button>'+																																	
													'</td>'+
												  '</tr>';
									$('#tbl_det_req_boletos tr').eq(row).after(row_det);
									row = row + 1;
									row_num = row_num + 1;
								});
							}
														
							row = 0;
							row_num = 1;
							if (paramJson.entrega != null) {
								$.each(paramJson.entrega, function(index, item) {
									var row_dis = '<tr class="item_dis">'+
													'<td>'+row_num+'</td>'+
													'<td class="num_dis_bol">'+item.num_acta+'</td>'+
													'<td class="fec_dis_bol">'+item.fec_acta+'</td>'+
													'<td class="ser_dis_bol">'+item.num_serie+'</td>'+
													'<td class="can_dis_bol">'+item.num_can_boleto+'</td>'+
													'<td class="sal_dis_bol">'+item.can_sal_bol+'</td>'+
													'<td class="hide cod_tar_bol">'+item.cod_tar_boleto+'</td>'+
													'<td class="hide num_req_ini">'+item.num_inicio+'</td>'+
													'<td class="hide num_req_fin">'+item.num_final+'</td>'+
													'<td>'+
														'<button class="btn btn-sm btn-warning input-sm btn_edi_req_bol">'+
															'<i class="ace-icon fa fa-pencil-square-o"></i>'+
														'</button>'+
													'</td>'+
													'<td>'+
														'<button class="btn btn-sm btn-danger input-sm btn_rem_req_bol">'+
															'<i class="ace-icon fa fa-trash-o"></i>'+
														'</button>'+																																	
													'</td>'+
												  '</tr>';			  
												  
									$('#tbl_det_dis_boletos tr').eq(row).after(row_dis);
									row = row + 1;
									row_num = row_num + 1;
								});
							}

							setAnpBoleto(paramJson.cod_uni_operativa, paramJson.cod_reg_nac);

							$('#hid_cod_req_boletos').val(object);
							$('#btn_eliminar').show();
							
							endAjax();
							
							$('#div_det_req_boletos').modal('show');
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
			
			function obtenerAnp(cod_uni_operativa, target) {
				var params = new Object();				
 				params['ind_uni_operativa'] = 1; // ANP
 				params['cod_uni_operativa'] = cod_uni_operativa;
 				simpleCboAjaxPopulateParam(target, ['cod_reg_nac', 'des_reg_nac'], '/listarUnidadOperativa', params, false, false);
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
							var options = '';
							var row = 0;
							$.each(paramJson, function(index, item) {
								options += '<option value="'+item.cod_boleto+'">'+item.num_serie+' - '+item.des_ind_tarifa+' - '+item.nom_boleto+'</option>';											
								var det_boleto = item.cod_boleto+'|'+item.des_ind_tarifa+'|'+item.nom_boleto+'|'+item.num_serie+'|';
								det_boleto = det_boleto + item.num_inicio+'|'+item.num_final+'|'+item.can_stock+'|'+item.num_imp_unit;			
								arr_tar_boletos.push(det_boleto);
								if (row == 0) {
									$('#txt_det_serie').val(item.num_serie);
								}
								row = row + 1;
							});
							$('#sel_det_tarifa').html(options);
						} else {
							$('#sel_det_tarifa').html('');
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
			
			function inicializarDatos() {
				
				obtenerTarifaBoleto($('#sel_uni_req_boletos').val(), $('#sel_anp_req_boletos').val());
				
			}
			
			function rem_det_boleto() {
				var row = 0;
				var ind_opc = 0;
				var det_trans = arr_tar_boletos.length;
				var arr_partida = '';
				
				// Removemos los duplicados
				var map = {};
				$('#sel_det_tarifa option').each(function () {
				    if (map[this.value]) {
				        $(this).remove()
				    }
				    map[this.value] = true;
				})

				$('tr.item_det').each(function() {		
					var ser_req_bol = $(this).find('.ser_req_bol').text();
					if (!esnulo(ser_req_bol)) {
						row = row + 1;
					}						
				});					
				if (row > 0) {
					for (var i=0; i < det_trans; i++) {
						var fields = arr_tar_boletos[i].split('|');
						$('tr.item_det').each(function() {		
							var ind_boleto = $(this).find('.cod_tar_bol').text();
							if (!esnulo(ind_boleto)) {
								if (fields[0] == ind_boleto) {
									$('#sel_det_tarifa option[value="'+ind_boleto+'"]').remove();
									ind_opc = ind_opc + 1;
								}									
							}						
						});							
					}						
					if (det_trans == ind_opc) {
						return 'No se puede agregar mas detalle';
					}
				}
				return '';
			}
			
			function obt_dis_boleto() {				
				$('#sel_dis_tarifa').html('');
				var options = '';
				var row = 0;
				for (var i=0; i < arr_tar_boletos.length; i++) {
					var fields = arr_tar_boletos[i].split('|');
					$('tr.item_det').each(function() {		
						var ind_boleto = $(this).find('.cod_tar_bol').text();
						if (!esnulo(ind_boleto)) {
							if (fields[0] == ind_boleto) {
								options += '<option value="'+fields[0]+'">'+fields[1]+' - '+fields[2]+'</option>';
								if (row == 0) {
									$('#txt_dis_serie').val(fields[3]);
								}
								row = row + 1;
							}									
						}						
					});							
				}
				$('#sel_dis_tarifa').html(options);				
			}
			
			function rem_detalle() {
				// Eliminamos el detalle anterior Detalle de Requerimientos Boletos
				var row_det = $('#tbl_det_req_boletos td').closest('tr').length;
				if (row_det > 1) {
					$('tr.item_det').each(function() {		
						var cod_tar_bol = $(this).find('.cod_tar_bol').text();
						if (!esnulo(cod_tar_bol)) {
							var row = $(this).closest('tr');
							row.remove();
						}						
					});	
				}
				
				// Eliminamos el detalle anterior Distribución de Boletos
				var row_dis = $('#tbl_det_dis_boletos td').closest('tr').length;
				if (row_dis > 1) {
					$('tr.item_dis').each(function() {		
						var cod_tar_bol = $(this).find('.cod_tar_bol').text();
						if (!esnulo(cod_tar_bol)) {
							var row = $(this).closest('tr');
							row.remove();
						}						
					});	
				}
			}
			
			function setAnpBoleto(cod_uni_operativa, cod_anp) {
				$.ajax({
					type: 'GET',
					url: '${pageContext.request.contextPath}/listarUnidadOperativa',
					data: {
						ind_uni_operativa : 1, // ANP
						cod_uni_operativa : cod_uni_operativa
					},
					dataType: 'json',
					success: function(paramJson) {						
						if (paramJson != null) {							
							var options = '';
							$.each(paramJson, function(index, item) {
								options += '<option value="'+item.cod_reg_nac+'">'+item.des_reg_nac+'</option>';								
							});
							$('#sel_anp_req_boletos').html(options);							
							$('#sel_anp_req_boletos').val(cod_anp);
							
							setTarifaBoleto(cod_uni_operativa, cod_anp);

						} else {
							$('#sel_anp_req_boletos').html('');
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
			
			function setTarifaBoleto(cod_uni_operativa, cod_reg_nac) {
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
							var options = '';
							var row = 0;
							$.each(paramJson, function(index, item) {
								options += '<option value="'+item.cod_boleto+'">'+item.num_serie+' - '+item.des_ind_tarifa+' - '+item.nom_boleto+'</option>';											
								var det_boleto = item.cod_boleto+'|'+item.des_ind_tarifa+'|'+item.nom_boleto+'|'+item.num_serie+'|';
								det_boleto = det_boleto + item.num_inicio+'|'+item.num_final+'|'+item.can_stock+'|'+item.num_imp_unit;			
								arr_tar_boletos.push(det_boleto);
								if (row == 0) {
									$('#txt_det_serie').val(item.num_serie);
								}
								row = row + 1;
							});
							$('#sel_det_tarifa').html(options);
							
							// Cargamos las tarifas del detalle requerimientos de boletos
							obt_dis_boleto();
						} else {
							$('#sel_det_tarifa').html('');
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
		
		</script>
		
	</body>
</html>