<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta charset="utf-8" />
		<title>Registro de Transferencias</title>

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
							<li class="active">Registro de Transferencias</li>
						</ul>
					</div>
			
					<div class="page-content">		
						<div class="row">
							<div class="col-xs-12">					
								<form class="form-horizontal" role="form">
								
									<input type="hidden" id="hid_cod_transferencia" value="${codigo}">
									<input type="hidden" id="hid_partida">
									<input type="hidden" id="hid_par_ant">
									<input type="hidden" id="hid_met_ant">
															
									<div class="form-group">
										<label class="col-sm-2 control-label label-sm">Tipo de Operación:</label>
										<div class="col-sm-2">
											<div class="radio">
												<label class="input-sm">
													<input type="radio" class="ace input-sm" name="rb_tip_operacion" value="1">
													<span class="lbl"> Transferencia</span>
												</label>
											</div>
										</div>
										
										<div class="col-sm-3">
											<div class="radio">
												<label class="input-sm">
													<input type="radio" class="ace input-sm" name="rb_tip_operacion" value="2">
													<span class="lbl"> Viáticos</span>
												</label>
											</div>
										</div>
										<div class="col-sm-3">
											<div class="radio">
												<label class="input-sm">
													<input type="radio" class="ace input-sm" name="rb_tip_operacion" value="3">
													<span class="lbl"> F.P.E (Sede)</span>
												</label>
											</div>
										</div>										
									</div>

									<div class="form-group">										
										<label class="col-sm-2 control-label label-sm no-padding-right">Tipo de Comprobante:</label>
										<div class="col-sm-2">
											<select id="sel_tip_comprobante" class="form-control input-sm" disabled>
												<c:forEach items="${lis_tip_comprobante}" var="item">
													<option value="${item.cod_comprobante}">${item.nom_comprobante}</option>
												</c:forEach>
											</select>
										</div>
										
										<label class="col-sm-2 control-label label-sm no-padding-right">Nro Comprobante:</label>
										<div class="col-sm-2">
											<input type="text" id="txt_nro_comprobante" class="form-control input-sm onlyNumbers" maxlength="10" />
										</div>
										
										<label class="col-sm-2 control-label label-sm no-padding-right">Nro SIAF:</label>
										<div class="col-sm-2">
											<input type="text" id="txt_siaf" class="form-control input-sm onlyNumbers" maxlength="10" />
										</div>
									</div>
									
									<div class="form-group">
										<label class="col-sm-2 control-label label-sm no-padding-right">Fecha Comprobante:</label>
										<div class="col-sm-2">
											<div class="input-group">
												<input class="form-control input-sm date-picker" id="txt_fec_comprobante" type="text" />
												<span class="input-group-addon" id="sp_ico_fec_comprobante">
													<i class="fa fa-calendar bigger-110"></i>
												</span>
											</div>
										</div>
										
										<label class="col-sm-2 control-label label-sm no-padding-right">Fte Fto:</label>
										<div class="col-sm-2">
											<select id="sel_fue_financiamiento" class="form-control input-sm">
												<c:forEach items="${lis_fue_financiamiento}" var="item">
													<option value="${item.cod_fte}">${item.nom_fte}</option>
												</c:forEach>
											</select>
										</div>
										
										<label class="col-sm-2 control-label label-sm no-padding-right">Moneda:</label>
										<div class="col-sm-2">
											<select id="sel_tip_moneda" class="form-control input-sm" disabled>
												<c:forEach items="${lis_tip_moneda}" var="item">
													<option value="${item.cod_moneda}">${item.nom_moneda}</option>
												</c:forEach>
											</select>
										</div>										
									</div>											
									
									<div class="form-group">		
										<div class="col-sm-5">		
											<fieldset class="fsStyle">
												<legend class="legendStyle">Datos del Trámite Solicitante</legend>
											
												<div class="form-group">
													<label class="col-sm-5 control-label label-sm no-padding-right">U.O. Solicitante:</label>
													<div class="col-sm-7">
														<select id="sel_uni_operativa" class="form-control input-sm">
															<option value="">(Seleccione)</option>
															<c:forEach items="${lis_uni_operativa}" var="item">
															    <option value="${item.cod_uni_operativa}">${item.des_uni_operativa}</option>
															</c:forEach>
														</select>
													</div>
												</div>
												
												<div class="form-group">
													<label class="col-sm-5 control-label label-sm no-padding-right">ANP:</label>
													<div class="col-sm-7">
														<select id="sel_anp" class="form-control input-sm">
															<option value="">(Seleccione)</option>
															<c:if test="${not empty lis_anp}">
																<c:forEach items="${lis_anp}" var="item">
																    <option value="${item.cod_reg_nac}">${item.des_reg_nac}</option>
																</c:forEach>
															</c:if>
														</select>
													</div>
												</div>
												<div class="form-group" >
													<label class="col-sm-5 control-label label-sm">Tipo de FPE :</label>
													<div class="col-sm-2">
														<div class="radio">
															<label class="input-sm">
																<input type="radio" class="ace input-sm" name="rb_tip_fpe" value="1" disabled>
																<span class="lbl">Apert.</span>
															</label>
														</div>
													</div>
													
													<div class="col-sm-2">
														<div class="radio">
															<label class="input-sm">
																<input type="radio" class="ace input-sm" name="rb_tip_fpe" value="2" disabled>
																<span class="lbl">Reemb.</span>
															</label>
														</div>
													</div>	
													<div class="col-sm-2">
														<div class="radio">
															<label class="input-sm">
																<input type="radio" class="ace input-sm" name="rb_tip_fpe" value="2" disabled>
																<span class="lbl">N.A.</span>
															</label>
														</div>
													</div>														
												</div>											
												<div class="form-group">
													<label class="col-sm-5 control-label label-sm no-padding-right" >Nro Rendicion FPE:</label>
													<div class="col-sm-7">
														<input type="text" id="txt_nro_rendicion" class="form-control input-sm" disabled/>
													</div>
												</div>
												
												<div class="form-group">
													<label class="col-sm-5 control-label label-sm no-padding-right">Nro Requerimiento:</label>
													<div class="col-sm-7">
														<input type="text" id="txt_nro_documento" class="form-control input-sm" maxlength="10" />
													</div>
												</div>
												
												<div class="form-group">
													<label class="col-sm-5 control-label label-sm no-padding-right">Fec. Documento:</label>
													<div class="col-sm-7">
														<div class="input-group">
															<input class="form-control input-sm date-picker" id="txt_fec_documento" type="text" />
															<span class="input-group-addon" id="sp_ico_fec_documento">
																<i class="fa fa-calendar bigger-110"></i>
															</span>
														</div>
													</div>
												</div>
												
												<div class="form-group">
													<label class="col-sm-5 control-label label-sm no-padding-right">Fec. Transferencia:</label>
													<div class="col-sm-7">
														<div class="input-group">
															<input class="form-control input-sm date-picker" id="txt_fec_transferencia" type="text" />
															<span class="input-group-addon" id="sp_ico_fec_transferencia">
																<i class="fa fa-calendar bigger-110"></i>
															</span>
														</div>
													</div>
												</div>
												
												<div class="form-group">
													<label class="col-sm-7 control-label label-sm no-padding-left">Concepto de la Transferencia:</label>
												</div>
												
												<div class="form-group">
													<div class="col-sm-12">
														<textarea class="autosize-transition form-control" id="txt_con_transferencia" maxlength="120"></textarea>
													</div>
												</div>																						
											</fieldset>
										</div>	
											
										<div class="col-sm-7">				
											<fieldset class="fsStyle">
												<legend class="legendStyle">Detalle Partidas de la Transferencia</legend>
											
												<div class="table-responsive div_cor_com_pago">
													<table id="tbl_det_partida" class="table table-striped table-bordered table-hover">
														<thead>
															<tr class="last">
																<th>Item</th>
																<th>Partida</th>
																<th>Meta</th>
																<th>Nombre de Especifica</th>
																<th>Importe</th>
																<th class="hide"></th>
																<th></th>
																<th></th>
															</tr>
														</thead>
														
														<tbody id="tbo_det_partida">
															<c:if test="${not empty lis_det_transferencia}" >
																<c:set var="count" value="1" scope="page" />
																<c:forEach items="${lis_det_transferencia}" var="item">
																	<tr class="item">
																		<td class="nro">${count}</td>
																		<td class="par">${item.vcod_especifica}</td>
																		<td class="met">${item.cod_meta}</td>
																		<td class="ser">${item.des_especifica}</td>
																		<td class="imp">${item.imp_partida}</td>
																		<td class="hide cod_ser">${item.cod_especifica}</td>
																		<td>
																			<button class="btn btn-sm btn-warning input-sm btn_edi_partida">
																				<i class="ace-icon fa fa-pencil-square-o"></i>
																			</button>
																		</td>
																		<td>																		
																			<button class="btn btn-sm btn-danger input-sm btn_rem_partida">
																				<i class="ace-icon fa fa-trash-o"></i>
																			</button>																																	
																		</td>						
																	</tr>
																	<c:set var="count" value="${count + 1}" scope="page"/>
																</c:forEach>
															</c:if>
														</tbody>
													</table>
													<button class="btn btn-sm btn-success input-sm btn_agr_partida">
														<i class="ace-icon fa fa-plus"></i>
													</button>
												</div>
												
												<div class="col-md-12 text-center">
											     	<ul class="pagination" id="ul_pag_det_partida"></ul>
											    </div>
												
												<div class="form-group">													
													<label class="col-sm-9 control-label label-sm no-padding-right">Importe Total:</label>
													<div class="col-sm-3">
														<input type="text" id="txt_imp_total" class="form-control input-sm" disabled />
													</div>
												</div>
											</fieldset>
											
											<br/>				
												
											<div class="form-group">
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
													<button id="btn_salir" class="btn btn-sm input-sm">
														<i class="ace-icon fa fa-reply"></i>
														Salir
													</button>
												</div>
											</div>
										</div>
									</div>									
								</form>
							</div>
						</div>
					</div>
				</div>
			</div><!-- /.main-content -->
			
			<!-- Registro de Partidas -->
			<div id="div_det_reg_transferencias" class="modal" tabindex="-1" data-keyboard="false" data-backdrop="static">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">&times;</button>
							<h4 id="h_det_reg_transferencias" class="white bigger center"></h4>
						</div>
						
						<div class="modal-body">
							<div class="row">
								<div class="col-xs-12">
									<form id="form_det_reg_transferencias" class="form-horizontal" role="form">
										<div class="form-group">																				
											<label class="col-sm-3 control-label input-sm no-padding-right">Partida:</label>											
											<div class="col-sm-3">
												<input type="text" id="txt_partida" class="form-control input-sm onlyAmounts" maxlength="15" />
											</div>	
											<label class="col-sm-2 control-label input-sm no-padding-right">Meta:</label>											
											<div class="col-sm-2">
												<input type="text" id="txt_meta" class="form-control input-sm onlyAmounts" maxlength="5" />
											</div>	
										</div>								

										<div class="form-group">																				
											<label class="col-sm-3 control-label input-sm no-padding-right">Servicio:</label>											
											<div class="col-sm-9">
												<input type="text" id="txt_servicio" class="form-control input-sm" disabled />
											</div>	
										</div>									
										
										<div class="form-group">																				
											<label class="col-sm-3 control-label input-sm no-padding-right">Importe:</label>											
											<div class="col-sm-5">
												<input type="text" id="txt_importe" class="form-control input-sm onlyAmounts" maxlength="10" />
											</div>											
										</div>
									</form>
								</div>
							</div>			
						</div>

						<div class="modal-footer">				
							<button id="btn_anadir" class="btn btn-sm btn-primary">
								<i class="ace-icon fa fa-check"></i>
								Añadir
							</button>
							<button id="btn_editar" class="btn btn-sm btn-primary">
								<i class="ace-icon fa fa-check"></i>
								Grabar
							</button>
							<button class="btn btn-sm" data-dismiss="modal">
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
		
			$(document).ready(function() {
				
				$("#li_transferencias").addClass('active');
				$("#li_reg_transferencias").addClass('active');
				
				inicializarDatos();
				
				$('.date-picker').datepicker({
					autoclose: true,
					todayHighlight: true
				});
				
				$('.input-group-addon').click(function(event) {
					event.preventDefault();
					var id_sp = $(this).attr('id').substring(7);
					$('#txt_'+id_sp).datepicker('show');
				});

				$(".from_date").datepicker({
				    format: 'yyyy-mm-dd',
				    autoclose: true,
				}).on('changeDate', function (selected) {
				    var startDate = new Date(selected.date.valueOf());
				    $('.to_date').datepicker('setStartDate', startDate);
				}).on('clearDate', function (selected) {
				    $('.to_date').datepicker('setStartDate', null);
				});
				
				$('#sel_uni_operativa').on('change', function() {
					obtenerAnp($(this).val());
				});

				$('#txt_fec_comprobante').datepicker().on('changeDate', function (ev) {
					var fec_comprobante = $(this).val();
					var dia = parseInt(fec_comprobante.substring(0, 2)) + 1;
					var mes = fec_comprobante.substring(3, 5);
					var anio = fec_comprobante.substring(6, 10);
					var fec_form = anio + '-' + mes + '-' + dia;					
					var fec_act = new Date(fec_form);
					$('#txt_fec_documento').datepicker('setEndDate', fec_act);
					$('#txt_fec_transferencia').datepicker('setStartDate', fec_act);
				});
				
				$('input:radio[name="rb_tip_operacion"]').change(function() {			       
			        if ($(this).val() == 3) { // Sede
						$('#sel_uni_operativa').prop('disabled', true);
						$('#sel_anp').prop('disabled', true);
						$('#txt_nro_rendicion').prop('disabled', false);
						$('input:radio[name="rb_tip_fpe"]').prop('disabled',false);
			        } else {
			        	$('#sel_uni_operativa').prop('disabled', false);
						$('#sel_anp').prop('disabled', false);
						$('#txt_nro_rendicion').prop('disabled', true);
						$('input:radio[name="rb_tip_fpe"]').prop('disabled',true);
			        }
			    });
				
				$('.btn_agr_partida').click(function(e) {					
					e.preventDefault();
					$('#h_det_reg_transferencias').html('Nueva Partida de Transferencia');
					$('#form_det_reg_transferencias').trigger("reset");
					$('#hid_partida').val('');
					$('#btn_anadir').show();
					$('#btn_editar').hide();
					$('#div_det_reg_transferencias').modal('show');
				});
				
				$("#txt_partida").change(function() {
					$.ajax({
						type: 'GET',
						url: VAR_CONTEXT + '/verificarPartida',
						data: {
							partida: $(this).val()
						},
						dataType: 'json',
						success: function(paramJson) {						
							if (paramJson.srl_id_esp != null) {
								$('#hid_partida').val(paramJson.srl_id_esp);
								$('#txt_servicio').val(paramJson.var_nom_especifica);
							} else {
								addWarnMessage(null, 'No se encuentra registrado la actual partida.');
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
				
				$('#btn_anadir').click(function(e) {					
					e.preventDefault();
					
					var partida = $('#txt_partida').val();
					var meta = $('#txt_meta').val();
					var servicio = $('#txt_servicio').val();
					var importe = parseFloat($('#txt_importe').val());
					var val_partida = $('#hid_partida').val();
					var val_met_ant = $('#hid_met_ant').val();
					if (esnulo(val_partida)) {
						addWarnMessage(null, 'No se encuentra registrado la actual partida, es necesario que exista previamente.');
						return;
					}					
					if (esnulo(meta)) {
						addWarnMessage(null, 'Debe de registrar la Meta correspondiente.');
						return;
					}						
					if (isNaN(importe) || importe <= 0) {
						addWarnMessage(null, 'El importe tiene que ser mayor a cero.');
						return;
					}

					var estado = false;
					var row = 1;
					var imp_total = importe;
					$('tr.item').each(function() {						
						var srl_partida = $(this).find('.par').text();
						var srl_cod_meta = $(this).find('.met').text();
						//var srl_cod_meta = $('#txt_meta').val();
						b=srl_cod_meta.replace(/ /g, "");						
						if (srl_partida == partida && b==meta) {
							estado = true;
						}
						
						row = row + 1;		
						var imp_partida = $(this).find('.imp').text();
						if (!esnulo(imp_partida)) {
							imp_total = imp_total + parseFloat(imp_partida);
						}
					});
					
					if (estado) {
						addWarnMessage(null, 'Partida y Meta ya registrada.');
						return;
					}					
					
					$('#txt_imp_total').val(imp_total.toFixed(2));
					
					var row_det = '<tr id="tr_'+row+'" class="item">'+
									'<td class="nro">'+row+'</td>'+
									'<td class="par">'+partida+'</td>'+
									'<td class="met">'+meta+'</td>'+
									'<td class="ser">'+servicio+'</td>'+
									'<td class="imp">'+importe.toFixed(2)+'</td>'+
									'<td class="hide cod_ser">'+val_partida+'</td>'+									
									'<td>'+
										'<button class="btn btn-sm btn-warning input-sm btn_edi_partida">'+
											'<i class="ace-icon fa fa-pencil-square-o"></i>'+
										'</button>'+
									'</td>'+
									'<td>'+
										'<button class="btn btn-sm btn-danger input-sm btn_rem_partida">'+
											'<i class="ace-icon fa fa-trash-o"></i>'+
										'</button>'+																																	
									'</td>'+									
								  '</tr>';		  
					//$('#tbl_det_partida tbody').eq(row-1).after(row_det);
					$("#tbl_det_partida tbody").append(row_det);

					// Si hay mas 7 registros activamos la paginacion
					if (row > 7) {
						$('#ul_pag_det_partida').html('');
						$('#tbo_det_partida').pageMe({pagerSelector : '#ul_pag_det_partida', 
													  showPrevNext : true, 
													  hidePageNumbers : false, 
													  perPage : 7});
					}
					
					$('#div_det_reg_transferencias').modal('hide');
				});
				
				$('#tbl_det_partida').on('click', '.btn_edi_partida', function(e) {
					e.preventDefault();
					$('#h_det_reg_transferencias').html('Editar Partida de Transferencia');
					
					var row = $(this).closest('tr'); // Find the row
					
					// Extraemos los datos del registro
				    var par = $.trim(row.find(".par").text());
				    var met = $.trim(row.find(".met").text());
				    var ser = $.trim(row.find(".ser").text());
				    var imp = $.trim(row.find(".imp").text());
				    var cod_ser = $.trim(row.find(".cod_ser").text());
					
				 	// Asignamos los datos del registro al formulario
				    $('#txt_partida').val(par);
				    $('#txt_meta').val(met);
					$('#txt_servicio').val(ser);
					$('#txt_importe').val(imp);
					$('#hid_partida').val(cod_ser);					
					$('#btn_anadir').hide();
					$('#btn_editar').show();
					$('#hid_par_ant').val(cod_ser);
					$('#hid_met_ant').val(met);
					$('#div_det_reg_transferencias').modal('show');
				});
				
				$('#btn_editar').click(function(e) {
					e.preventDefault();
					var partida = $('#txt_partida').val();
					var meta = $('#txt_meta').val();
					var servicio = $('#txt_servicio').val();
					var importe = parseFloat($('#txt_importe').val());
					var val_partida = $('#hid_partida').val();
					var val_par_ant = $('#hid_par_ant').val();
					var val_met_ant = $('#hid_met_ant').val();
					if (esnulo(val_partida)) {
						addWarnMessage(null, 'No se encuentra registrado la actual partida, es necesario que exista previamente.');
						return;
					}
					if (esnulo(meta)) {
						addWarnMessage(null, 'Debe de registrar la Meta correspondiente.');
						return;
					}					
					if (isNaN(importe) || importe <= 0) {
						addWarnMessage(null, 'El importe tiene que ser mayor a cero.');
						return;
					}
					
					// Editamos el registro actual
					var row = 0;
					var imp_total = importe;					
					$('tr.item').each(function() {
						row = row + 1;
						
						var srl_cod_ser = $(this).find('.cod_ser').text();
						var srl_cod_meta = $(this).find('.met').text();
						b=srl_cod_meta.replace(/ /g, "");
						if (srl_cod_ser == val_par_ant && b==val_met_ant) {
							return false;
						}
						
					});
					
					$('#tbl_det_partida tr').eq(row).find('td').eq(1).html(partida);
					$('#tbl_det_partida tr').eq(row).find('td').eq(2).html(meta);
					$('#tbl_det_partida tr').eq(row).find('td').eq(3).html(servicio);
					$('#tbl_det_partida tr').eq(row).find('td').eq(4).html(importe.toFixed(2));
					$('#tbl_det_partida tr').eq(row).find('td').eq(5).html(val_partida);					

					// Recalculamos el monto total considerando el registro actual
					var estado = false;
					var row_num = 0;
					$('tr.item').each(function() {
						row_num = row_num + 1;
						if (row != row_num) {
							var srl_partida = $(this).find('.par').text();		
							//var srl_cod_meta = $(this).find('.met').text();
							var srl_cod_meta = $('#txt_meta').val();
							b=srl_cod_meta.replace(/ /g, "");
							if (srl_partida == partida && b==val_met_ant) {
								estado = true;
							}
													
							var imp_partida = $(this).find('.imp').text();
							if (!esnulo(imp_partida)) {
								imp_total = imp_total + parseFloat(imp_partida);
							}
						}
					});					
					if (estado) {
						addWarnMessage(null, 'Partida y Meta ya registrada, se actualizaron.');
						return;
					}					
					$('#txt_imp_total').val(imp_total.toFixed(2));
					
					$('#div_det_reg_transferencias').modal('hide');
				});
				
				$('#tbl_det_partida').on('click', '.btn_rem_partida', function(e) {				
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
									
									// Recalculamos el monto total
									var imp_total = 0;
									var row_num = 0;
									$('tr.item').each(function() {
										row_num = row_num + 1;
										var imp_partida = $(this).find('.imp').text();
										if (!esnulo(imp_partida)) {
											imp_total = imp_total + parseFloat(imp_partida);
											$('#tbl_det_partida tr').eq(row_num).find('td').eq(0).html(row_num);
										}
									});
									
									$('#txt_imp_total').val(imp_total.toFixed(2));
									
									// Si hay mas 7 registros activamos la paginacion
									if (row_num == 7) {
										$('#ul_pag_det_partida').html('');										
									} else if (row_num > 7) {
										$('#ul_pag_det_partida').html('');
										$('#tbo_det_partida').pageMe({pagerSelector : '#ul_pag_det_partida', 
																	  showPrevNext : true, 
																	  hidePageNumbers : false, 
																	  perPage : 7});
									}
								}
							}, 
							"button" : {
								"label" : "Cancelar",
								"className" : "btn-sm"
							}
						}
					});
				});				
				
				$('#btn_salir').click(function(e) {					
					e.preventDefault();
					
					var url = VAR_CONTEXT + '/transferencias';
					$(location).attr('href', url);		
				});
				
				$('#btn_grabar').click(function(e) {					
					e.preventDefault();
					var codigo = $('#hid_cod_transferencia').val();
					var tip_operacion = $('input[name="rb_tip_operacion"]:checked').val();
					var cod_comprobante = $('#sel_tip_comprobante').val();
					// var ser_comprobante = $('#txt_ser_comprobante').val();
					var nro_comprobante = $.trim($('#txt_nro_comprobante').val());
					var fec_comprobante = $('#txt_fec_comprobante').val();
					var fue_financiamiento = $.trim($('#sel_fue_financiamiento').val());
					var siaf = $('#txt_siaf').val();
					var cod_moneda = $('#sel_tip_moneda').val();
					// var tip_cambio = $('#txt_tip_cambio').val();					
					var uni_org = $('#sel_uni_operativa').val();
					var anp = $('#sel_anp').val();
					var nro_documento = $.trim($('#txt_nro_documento').val());
					var fec_documento = $('#txt_fec_documento').val();
					var fec_transferencia = $('#txt_fec_transferencia').val();
					var con_transferencia = $('#txt_con_transferencia').val();
					var imp_total = $('#txt_imp_total').val();
					var ind_fpe = $('input[name="rb_tip_fpe"]:checked').val();
					var num_rendicion = $.trim($('#txt_nro_rendicion').val());
					var msg = '';
										
					if (esnulo(nro_comprobante)) {
						msg = msg + 'El campo "Nro Comprobante" es obligatorio.<br/>';
					}
					if (esnulo(fec_comprobante)) {
						msg = msg + 'El campo "Fecha de Comprobante" es obligatorio.<br/>';
					} else {
						if (!checkdate(fec_comprobante)) {
							msg = msg + 'El campo "Fecha de Comprobante" tiene formato de fecha incorrecto.<br/>';
						}						
					}
					if (esnulo(fue_financiamiento)) {
						msg = msg + 'El campo "Fte Fto" es obligatorio.<br/>';
					}
					if (esnulo(siaf)) {
						msg = msg + 'El campo "SIAF" es obligatorio.<br/>';
					}		
					if (esnulo(nro_documento)) {
						msg = msg + 'El campo "Nro Documento" es obligatorio.<br/>';
					}
					if (esnulo(fec_documento)) {
						msg = msg + 'El campo "Fec. Documento" es obligatorio.<br/>';
					} else {
						if (!checkdate(fec_comprobante)) {
							msg = msg + 'El campo "Fec. Documento" tiene formato de fecha incorrecto.<br/>';
						}						
					}
					if (esnulo(fec_transferencia)) {
						msg = msg + 'El campo "Fec. Transferencia" es obligatorio.<br/>';
					} else {
						if (!checkdate(fec_comprobante)) {
							msg = msg + 'El campo "Fec. Transferencia" tiene formato de fecha incorrecto.<br/>';
						}						
					}	
					if (!esnulo(msg)) {
						addWarnMessage(null, msg);
						return;
					}	
					
					var arr_partida = '';
					var arr_meta = '';
					var arr_importe = '';
					var row = 0;
					$('tr.item').each(function() {		
						var ind_servicio = $(this).find('.ser').text();
						if (!esnulo(ind_servicio)) {
							arr_partida = arr_partida + $(this).find('.cod_ser').text() + '|';
							arr_meta = arr_meta + $(this).find('.met').text() + '|';
							arr_importe = arr_importe + $(this).find('.imp').text() + '|';
							row = row + 1;
						}						
					});
					if (row > 0) {
						arr_partida = arr_partida.substring(0, arr_partida.length - 1);
						arr_meta = arr_meta.substring(0, arr_meta.length - 1);
						arr_importe = arr_importe.substring(0, arr_importe.length - 1);
					} else {
						addWarnMessage(null, 'Debe Agregar Detalle Partidas de Transferencia.');
						return;
					}
					
					var new_record = true;
					if (!esnulo(codigo)) {
						new_record = false;
					}
					
					startAjax();
													
					$.ajax({
						type: 'POST',
						url: VAR_CONTEXT + '/grabarTransferencia',
						data: { 
							cod_transferencia : codigo,
							int_transaccion : tip_operacion,
							cod_comprobante : cod_comprobante,
							num_comprobante : nro_comprobante,
							fec_comprobante : fec_comprobante,
							cod_fue_financiamiento : fue_financiamiento,
							num_siaf : siaf,
							cod_moneda : cod_moneda,
							cod_uni_operativa : uni_org,
							cod_reg_nac : anp,
							num_doc_operacion : nro_documento,
							fec_doc_operacion : fec_documento,
							fec_transferencia : fec_transferencia,
							concepto : con_transferencia,
							ind_tipo_fpe : ind_fpe,
							num_doc_rendicion: num_rendicion,
							arr_partida : arr_partida,
							arr_meta : arr_meta,
							arr_importe : arr_importe,
							imp_total : imp_total
						},
						dataType: 'json',
						success: function(paramJson) {						
							if (paramJson != null) {
								endAjax();			
								$('#hid_cod_transferencia').val(paramJson);
								if (new_record) {
									addInfoMessage(null, 'El registro fue grabado.');
									$('#btn_eliminar').show();
								} else {
									addInfoMessage(null, 'Registro Actualizado.');
								}								
							}	
						},
						/*error: function(jqXHR, error, errorThrown) {*/
						error: function(jqXHR, textStatus, errorThrown){
							var msg = 'Error: Al Grabar la Transferencia<br/>';
							/*if (jqXHR.status && jqXHR.status == 400) {
								msg = msg + jqXHR.responseText;
							} else {
								msg = msg + errorThrown;
							}
							addErrorMessage(null, msg);*/
							if (jqXHR.status === 0) {
							    alert('Sin conectarse: Verificar Red.');
							  } else if (jqXHR.status == 404) {
							    alert('Página Solicitada no Encontrada [404]');
							  } else if (jqXHR.status == 500) {
							    alert('Error de Servidor Interno [500].');
							  } else if (textStatus === 'parsererror') {
							    alert('El análisis JSON solicitado fallá al grabar la transferencia.');
							  } else if (textStatus === 'timeout') {
							    alert('Error de tiempo de espera.');
							  } else if (textStatus === 'abort') {
							    alert('Solicitud de Ajax abortada.');
							  } else {
							    alert('Error no Detectado: ' + jqXHR.responseText);
							  }							
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
									var codigo = $('#hid_cod_transferencia').val();
									$.ajax({
										type: 'POST',
										url: VAR_CONTEXT + '/eliminarTransferencia',
										data: { codigo: codigo },
										dataType: 'json',
										success: function(paramJson) {						
											if (paramJson != null) {								
												var url = VAR_CONTEXT + '/transferencias';
												$(location).attr('href', url);
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
			
			function inicializarDatos() {
				if (!esnulo($('#hid_cod_transferencia').val())) {
					// Datos de la transferencia
					$('input[name=rb_tip_operacion][value="'+'${transferencia.int_transaccion}'+'"]').prop('checked', true);
					var tip_fact= $('input[name="rb_tip_operacion"]:checked').val();
					if(tip_fact=='3'){
						$('#sel_uni_operativa').prop('disabled', true);
						$('#sel_anp').prop('disabled', true);
						$('#txt_nro_rendicion').prop('disabled', false);
						$('input:radio[name="rb_tip_fpe"]').prop('disabled',false);
					}					
					$('#sel_tip_moneda').val('1');
					$('#sel_tip_comprobante').val('${transferencia.cod_comprobante}');
					// $('#txt_ser_comprobante').val('${transferencia.ser_comprobante}');
					$('#txt_nro_comprobante').val('${transferencia.num_comprobante}');					
					$('#txt_fec_comprobante').val('${transferencia.fec_comprobante}');
					$('#sel_fue_financiamiento').val('${transferencia.cod_fue_financiamiento}');
					$('#txt_siaf').val('${transferencia.num_siaf}');
					$('#sel_tip_moneda').val('${transferencia.cod_moneda}');
					// $('#txt_tip_cambio').val('${transferencia.num_tip_cambio}');
					$('#sel_uni_operativa').val('${transferencia.cod_uni_operativa}');					
					if (!esnulo('${transferencia.cod_reg_nac}')) {
						$('#sel_anp').val('${transferencia.cod_reg_nac}');
					} else {
						$('#sel_anp').val('');
					}			
					$('#txt_nro_documento').val('${transferencia.num_doc_operacion}');
					$('#txt_fec_documento').val('${transferencia.fec_doc_operacion}');
					$('#txt_fec_transferencia').val('${transferencia.fec_transferencia}');
					$('#txt_con_transferencia').val('${transferencia.concepto}');
					$('#txt_imp_total').val('${transferencia.imp_total}');
					$('input[name=rb_tip_fpe][value="'+'${transferencia.ind_tipo_fpe}'+'"]').prop('checked', true);
					$('#txt_nro_rendicion').val('${transferencia.num_doc_rendicion}');
					// Si hay mas 7 registros activamos la paginacion
					if (parseInt('${count}') > 8) {
						$('#tbo_det_partida').pageMe({pagerSelector : '#ul_pag_det_partida', 
													  showPrevNext : true, 
													  hidePageNumbers : false, 
													  perPage : 7}); // Numero paginacion						
					}
					
				} else {
					$('#sel_tip_moneda').val('1'); // Moneda Soles
					$('#sel_tip_comprobante').val('62'); // Comprabantes de Pago
					$('#sel_fue_financiamiento').val('1'); // Recursos Ordinarios
					$('#btn_eliminar').hide();			
					obtenerAnp($('#sel_uni_operativa').val());
				}
			}
			
			function obtenerAnp(cod_uni_operativa) {
				var params = new Object();
 				params['ind_uni_operativa'] = 1; // ANP
 				params['cod_uni_operativa'] = cod_uni_operativa;
 				simpleCboAjaxPopulateParam('#sel_anp', ['cod_reg_nac', 'des_reg_nac'], '/listarUnidadOperativa', params, true, false);
			}
			
			$.fn.pageMe = function(opts){
			    var $this = this,
			        defaults = {
			            perPage: 7,
			            showPrevNext: false,
			            hidePageNumbers: false
			        },
			        settings = $.extend(defaults, opts);
			    
			    var listElement = $this;
			    var perPage = settings.perPage; 
			    var children = listElement.children();
			    var pager = $('.pager');
			    
			    if (typeof settings.childSelector!="undefined") {
			        children = listElement.find(settings.childSelector);
			    }
			    
			    if (typeof settings.pagerSelector!="undefined") {
			        pager = $(settings.pagerSelector);
			    }
			    
			    var numItems = children.size();
			    var numPages = Math.ceil(numItems/perPage);

			    pager.data("curr",0);
			    
			    if (settings.showPrevNext){
			        $('<li><a href="#" class="prev_link">«</a></li>').appendTo(pager);
			    }
			    
			    var curr = 0;
			    while(numPages > curr && (settings.hidePageNumbers==false)){
			        $('<li><a href="#" class="page_link">'+(curr+1)+'</a></li>').appendTo(pager);
			        curr++;
			    }
			    
			    if (settings.showPrevNext){
			        $('<li><a href="#" class="next_link">»</a></li>').appendTo(pager);
			    }
			    
			    pager.find('.page_link:first').addClass('active');
			    pager.find('.prev_link').hide();
			    if (numPages<=1) {
			        pager.find('.next_link').hide();
			    }
			  	pager.children().eq(1).addClass("active");
			    
			    children.hide();
			    children.slice(0, perPage).show();
			    
			    pager.find('li .page_link').click(function(){
			        var clickedPage = $(this).html().valueOf()-1;
			        goTo(clickedPage,perPage);
			        return false;
			    });
			    pager.find('li .prev_link').click(function(){
			        previous();
			        return false;
			    });
			    pager.find('li .next_link').click(function(){
			        next();
			        return false;
			    });
			    
			    function previous(){
			        var goToPage = parseInt(pager.data("curr")) - 1;
			        goTo(goToPage);
			    }
			     
			    function next(){
			        goToPage = parseInt(pager.data("curr")) + 1;
			        goTo(goToPage);
			    }
			    
			    function goTo(page){
			        var startAt = page * perPage,
			            endOn = startAt + perPage;
			        
			        children.css('display','none').slice(startAt, endOn).show();
			        
			        if (page>=1) {
			            pager.find('.prev_link').show();
			        }
			        else {
			            pager.find('.prev_link').hide();
			        }
			        
			        if (page<(numPages-1)) {
			            pager.find('.next_link').show();
			        }
			        else {
			            pager.find('.next_link').hide();
			        }
			        
			        pager.data("curr",page);
			      	pager.children().removeClass("active");
			        pager.children().eq(page+1).addClass("active");
			    
			    }
			};

		</script>
		
	</body>
</html>