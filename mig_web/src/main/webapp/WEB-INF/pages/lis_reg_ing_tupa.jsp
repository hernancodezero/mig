<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta charset="utf-8" />
		<title>Registro de Tupa</title>

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
							<li class="active">Registro de Ingresos TUPA</li>
						</ul>
					</div>
			
					<div class="page-content">		
						<div class="row">
							<div class="col-sm-12">					
								<form id="frm_ingresos" class="form-horizontal" role="form">
								
									<input type="hidden" id="hid_reg_compras" value="${codigo}">
									<input type="hidden" id="hid_proveedor">
									<input type="hidden" id="hid_partida">

									<div class="col-sm-6">
										<div class="form-group">
											<label class="col-sm-3 control-label label-sm no-padding-right">ANP:</label>
											<div class="col-sm-9">
												<select id="sel_tip_comprobante" class="form-control input-sm">
													<c:forEach items="${lis_area_natural}" var="item">
														<option value="${item.cod}">${item.des}</option>
													</c:forEach>
												</select>
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-3 control-label label-sm no-padding-right">Tipo de Comprobante:</label>
											<div class="col-sm-3">
												<select id="sel_tip_comprobante" class="form-control input-sm">
													<c:forEach items="${lis_tip_comprobante}" var="item">
														<option value="${item.cod_comprobante}">${item.nom_comprobante}</option>
													</c:forEach>
												</select>
											</div>
											<label class="col-sm-3 control-label label-sm no-padding-right">Fecha de Comprobante:</label>
											<div class="col-sm-3">
												<div class="input-group">
													<input class="form-control input-sm date-picker" id="txt_fec_comprobante" type="text" />
													<span class="input-group-addon" id="sp_ico_fec_comprobante">
														<i class="fa fa-calendar bigger-110"></i>
													</span>
												</div>
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-3 control-label label-sm no-padding-right">Serie Comprobante:</label>
											<div class="col-sm-3">
												<input type="text" id="txt_ser_comprobante" class="form-control input-sm onlyNumbers" maxlength="7" />
											</div>
											
											<label class="col-sm-3 control-label label-sm no-padding-right">Fte Fto:</label>
											<div class="col-sm-3">
												<select id="sel_fue_financiamiento" class="form-control input-sm">
													<c:forEach items="${lis_fue_financiamiento}" var="item">
														<option value="${item.cod_fte}">${item.nom_fte}</option>
													</c:forEach>
												</select>
											</div>
										</div>
										<div class="form-group">
										
											<label class="col-sm-3 control-label label-sm no-padding-right">Nro Comprobante:</label>
											<div class="col-sm-3">
												<input type="text" id="txt_nro_comprobante" class="form-control input-sm onlyNumbers" maxlength="7" />
											</div>
											
											<label class="col-sm-3 control-label label-sm no-padding-right">SIAF:</label>
											<div class="col-sm-3">
												<input type="text" id="txt_nro_siaf" class="form-control input-sm onlyNumbers" maxlength="10" />
											</div>
										</div>
										<div class="form-group">
										
											<label class="col-sm-3 control-label label-sm no-padding-right">Tipo de Moneda:</label>
											<div class="col-sm-3">
												<select id="sel_tip_moneda" class="form-control input-sm">
													<c:forEach items="${lis_tip_moneda}" var="item">
														<option value="${item.cod_moneda}">${item.nom_moneda}</option>
													</c:forEach>
												</select>
											</div>
											
											<label class="col-sm-3 control-label label-sm no-padding-right">Tipo de Cambio:</label>
											<div class="col-sm-3">
												<input type="text" id="txt_tip_cambio" class="form-control input-sm onlyAmounts" maxlength="10" />
											</div>
										</div>
										<div class="form-group">
											
											<fieldset class="fsStyle">
												<legend class="legendStyle">Datos del Proveedor</legend>
												
												<div class="form-group">
													<label class="col-sm-4 control-label label-sm">Tipo de Proveedor:</label>												
													<div class="col-sm-6">
														<div class="radio">
															<label class="label-sm">
																<input type="radio" name="rb_tip_proveedor" value="1">
																Natural
															</label>
															&nbsp;&nbsp;
															<label class="label-sm">
																<input type="radio" name="rb_tip_proveedor" value="2">
																Juridico
															</label>
														</div>
													</div>
												</div>
												
												<div class="form-group">
													<label class="col-sm-2 control-label label-sm no-padding-right">Nro RUC:</label>
													<div class="col-sm-3">
														<input type="text" id="txt_nro_ruc" class="form-control input-sm onlyNumbers" maxlength="11" />
													</div>
													<div class="col-sm-1">	
														<button id="btn_buscar" class="btn btn-sm btn-info" type="button">
															<i class="ace-icon fa fa-search bigger-110"></i>
														</button>
													</div>
												</div>												
												<div class="form-group">
													<label class="col-sm-2 control-label label-sm no-padding-right">Razon Social:</label>
													<div class="col-sm-10">
														<input type="text" id="txt_raz_social" class="form-control input-sm" disabled />
													</div>
												</div>
												
												<div class="form-group">
													<label class="col-sm-2 control-label label-sm no-padding-right">Nombres:</label>
													<div class="col-sm-4">
														<input type="text" id="txt_nombres" class="form-control input-sm" disabled />
													</div>
													
													<label class="col-sm-2 control-label label-sm no-padding-right">Apellidos:</label>
													<div class="col-sm-4">
														<input type="text" id="txt_apellidos" class="form-control input-sm" disabled />
													</div>
												</div>
												
											</fieldset>
										</div>			
										<div class="form-group">						
											<fieldset class="fsStyle">
												<legend class="legendStyle">Constancia de Depósito</legend>
												
												<div class="form-group">
													<label class="col-sm-2 control-label label-sm no-padding-right">Número:</label>
													<div class="col-sm-3">
														<input type="text" id="txt_num_constancia" class="form-control input-sm onlyNumbers" maxlength="7" />
													</div>
													
													<label class="col-sm-3 control-label label-sm no-padding-right">Fecha de Pago:</label>
													<div class="col-sm-4">
														<div class="input-group">
															<input class="form-control input-sm date-picker" id="txt_fec_pag_deposito" type="text" />
															<span class="input-group-addon" id="sp_ico_fec_pag_deposito">
																<i class="fa fa-calendar bigger-110"></i>
															</span>
														</div>
													</div>
												</div>
												
												<div class="form-group">
													<label class="col-sm-2 control-label label-sm no-padding-right">Importe:</label>
													<div class="col-sm-3">
														<input type="text" id="txt_imp_deposito" class="form-control input-sm onlyAmounts" maxlength="10" />
													</div>
													
													<label class="col-sm-3 control-label label-sm no-padding-right">Porcentaje:</label>
													<div class="col-sm-4">
														<input type="text" id="txt_por_deposito" class="form-control input-sm onlyNumbers" maxlength="10" />
													</div>
												</div>
												
											</fieldset>
										</div>			
									</div>
								
									<div class="col-sm-6">

										<div class="form-group">
				
											<fieldset class="fsStyle">
												<legend class="legendStyle">Detalle de facturas</legend>
												
												<div class="form-group">
													<div class="form-group">
														<label class="col-sm-4 control-label label-sm">Tipo de Transacción:</label>												
											 			<div class="col-sm-6">
											 				<select id="sel_transaccion" class="form-control input-sm">
													     	<option value=''>&#60Seleccione&#62</option>
												  	 	 	 <option value='1'>Servicios</option>
												  	 	 	 <option value='2'>Productos</option>
												  	 	 	 <option value='3'>Servicios</option>
												  	 	 	 <option value='4'>Tupa</option>
												  	 	 	 <option value='5'>Otros</option>
													 	 </select>
											       		</div>
													</div>
												</div>
												<div class="form-group">
													<div class="col-sm-1"></div>
													<div class="col-sm-10">													
														<div class="table-responsive div_cor_com_pago">
															<table id="tbl_det_partida" class="table table-striped table-bordered table-hover">
																<thead>
																	<tr>
																		<th>Item</th>
																		<th>Partida</th>
																		<th>Serie</th>
																		<th>Nro. Inicio</th>
																		<th>Cantidad</th>
																		<th>Precio Bol</th>																		
																		<th>Total</th>
																		<th class="hide"></th>
																		<th class="hide"></th>
																	</tr>
																</thead>
																
																<c:if test="${not empty lis_det_compra}" >
																	<c:set var="count" value="1" scope="page" />
																	<c:forEach items="${lis_det_compra}" var="item">
																		<tr class="item">
																			<td>${count}</td>
																			<td class="par">${item.vcod_especifica}</td>
																			<td class="ser">${item.des_especifica}</td>
																			<td class="imp">${item.num_imp_servicio}</td>
																			<td class="tip">${item.des_tip_venta}</td>
																			<td class="hide cod_ser">${item.cod_especifica}</td>
																			<td class="hide cod_tip">${item.cod_tip_venta}</td>							
																		</tr>
																		<c:set var="count" value="${count + 1}" scope="page"/>
																	</c:forEach>
																</c:if>
																
																<tr class="item">
																	<td>
																		<div class="hidden-sm hidden-xs btn-group">
																			<button class="btn btn-xs btn-success btn_agr_partida">
																				<i class="ace-icon fa fa-plus"></i>
																			</button>
																		</div>																	
																	</td>
																	<td class="par"></td>
																	<td class="ser"></td>
																	<td class="imp"></td>
																	<td class="tip"></td>
																	<td class="hide cod_ser"></td>
																	<td class="hide cod_tip"></td>
																</tr>
																
															</table>
														</div>
													</div>
													<div class="col-sm-1"></div>		
												</div>
												
												<div class="form-group">
													<label class="col-sm-3 control-label label-sm no-padding-right">Importe Afecto:</label>
													<div class="col-sm-3">
														<input type="text" id="txt_imp_afecto" class="form-control input-sm" disabled />
													</div>
													
													<label class="col-sm-3 control-label label-sm no-padding-right">Impuesto IGV:</label>
													<div class="col-sm-3">
														<input type="text" id="txt_imp_igv" class="form-control input-sm" disabled />
													</div>
												</div>
												
												<div class="form-group">
													<label class="col-sm-3 control-label label-sm no-padding-right">Importe No Afecto:</label>
													<div class="col-sm-3">
														<input type="text" id="txt_imp_no_afecto" class="form-control input-sm" disabled />
													</div>
													
													<label class="col-sm-3 control-label label-sm no-padding-right">Impuesto ISC:</label>
													<div class="col-sm-3">
														<input type="text" id="txt_imp_isc" class="form-control input-sm" disabled />
													</div>
												</div>
												
												<div class="form-group">
													<div class="col-sm-6"></div>
													
													<label class="col-sm-3 control-label label-sm no-padding-right">Impuesto Total:</label>
													<div class="col-sm-3">
														<input type="text" id="txt_imp_total" class="form-control input-sm" disabled />
													</div>
												</div>
												
											</fieldset>
											
											<br>
				
											
											
											
											<div class="form-group">
												<div class="col-sm-3">
													<button id="btn_grabar" class="btn btn-sm btn-primary input-sm">
														<i class="ace-icon fa fa-check"></i>
														Grabar
													</button>
												</div>
												
												<div class="col-sm-3">
													<button id="btn_eliminar" class="btn btn-sm btn-danger input-sm">
														<i class="ace-icon fa fa-times"></i>
														Eliminar
													</button>
												</div>
												
												<div class="col-sm-3">
													<button id="btn_salir" class="btn btn-sm input-sm">
														<i class="ace-icon fa fa-times"></i>
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
			
			<div id="div_det_reg_gravado" class="modal" tabindex="-1" data-keyboard="false" data-backdrop="static">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">&times;</button>
							<h4 id="h_det_reg_gravado" class="white bigger center"></h4>
						</div>
						
						<div class="modal-body">
							<div class="row">
								<div class="col-xs-12">
									<form id="form_det_reg_gravado" class="form-horizontal" role="form">
										<div class="form-group">																				
											<label class="col-sm-3 control-label input-sm no-padding-right">Partida:</label>											
											<div class="col-sm-5">
												<input type="text" id="txt_partida" class="form-control input-sm onlyAmounts" maxlength="15" />
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
										
										<div class="form-group">																				
											<label class="col-sm-3 control-label input-sm no-padding-right">Tipo Venta:</label>											
											<div class="col-sm-5">
												<select id="sel_tip_venta" class="form-control input-sm">
													<option value="1">Gravada</option>
													<option value="2">No Gravada</option>
													<option value="3">Exonerado</option>
												</select>
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
							<button class="btn btn-sm" data-dismiss="modal">
								<i class="ace-icon fa fa-times"></i>
								Cancelar
							</button>
						</div>
					</div>
				</div>
			</div>
			
			<div id="div_reg_proveedor" class="modal" tabindex="-1" data-keyboard="false" data-backdrop="static">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">&times;</button>
							<h4 class="white bigger center">Datos del Proveedor</h4>
						</div>
						
						<div class="modal-body">
							<div class="row">
								<div class="col-xs-12">
									<form id="form_reg_proveedor" class="form-horizontal" role="form">
										<div class="form-group">																				
											<label class="col-sm-3 control-label input-sm no-padding-right">Número de RUC:</label>											
											<div class="col-sm-3">
												<input type="text" id="txt_reg_ruc" class="form-control input-sm onlyNumbers" disabled />
											</div>

											<label class="col-sm-2 control-label label-sm no-padding-right">Tipo Empresa:</label>													
											<div class="col-sm-2">
												<div class="radio">
													<label class="label-sm">
														<input type="radio" name="rb_tip_empresa" value="1">
														Natural
													</label>
												</div>
											</div>
											<div class="col-sm-2">
												<div class="radio">
													<label class="label-sm">
														<input type="radio" name="rb_tip_empresa" value="2">
														Juridica
													</label>
												</div>
											</div>
										</div>
										
										<div class="form-group">																				
											<div class="col-sm-5"></div>

											<label class="col-sm-3 control-label label-sm no-padding-right">Entidad:</label>													
											<div class="col-sm-2">
												<div class="radio">
													<label class="label-sm">
														<input type="radio" name="rb_entidad" value="1">
														Público
													</label>
												</div>
											</div>
											<div class="col-sm-2">
												<div class="radio">
													<label class="label-sm">
														<input type="radio" name="rb_entidad" value="2">
														Privado
													</label>
												</div>
											</div>
										</div>										

										<div class="form-group">																				
											<label class="col-sm-3 control-label input-sm no-padding-right">Razon Social:</label>											
											<div class="col-sm-9">
												<input type="text" id="txt_reg_raz_social" class="form-control input-sm" />
											</div>	
										</div>									
										
										<div class="form-group">
											<label class="col-sm-3 control-label label-sm no-padding-right">Tipo Doc.:</label>
											<div class="col-sm-3">
												<select id="sel_tip_doc" class="form-control input-sm">
													<c:forEach items="${lis_tip_documento}" var="item">
														<option value="${item.cod_documento}">${item.nom_documento}</option>
													</c:forEach>
												</select>
											</div>
										
											<label class="col-sm-3 control-label input-sm no-padding-right">Nro Doc.:</label>											
											<div class="col-sm-3">
												<input type="text" id="txt_nro_doc" class="form-control input-sm onlyNumbers" maxlength="8" />
											</div>											
										</div>
										
										<div class="form-group">																				
											<label class="col-sm-3 control-label input-sm no-padding-right">Ape. Paterno:</label>											
											<div class="col-sm-6">
												<input type="text" id="txt_ape_paterno" class="form-control input-sm" />
											</div>	
										</div>
										
										<div class="form-group">																				
											<label class="col-sm-3 control-label input-sm no-padding-right">Ape. Materno:</label>											
											<div class="col-sm-6">
												<input type="text" id="txt_ape_materno" class="form-control input-sm" />
											</div>	
										</div>
										
										<div class="form-group">																				
											<label class="col-sm-3 control-label input-sm no-padding-right">Nombres:</label>											
											<div class="col-sm-6">
												<input type="text" id="txt_reg_nombres" class="form-control input-sm" />
											</div>
										</div>
											
										<div class="form-group">
											<label class="col-sm-3 control-label input-sm no-padding-right">Correo Eléctronico:</label>											
											<div class="col-sm-6">
												<input type="text" id="txt_reg_correo" class="form-control input-sm" />
											</div>
										</div>
										
										<div class="form-group">																				
											<label class="col-sm-3 control-label input-sm no-padding-right">Direccion:</label>											
											<div class="col-sm-6">
												<input type="text" id="txt_reg_direccion" class="form-control input-sm" />
											</div>
										</div>
										
										<div class="form-group">																				
											<label class="col-sm-3 control-label input-sm no-padding-right">Giro de Negocio:</label>											
											<div class="col-sm-3">
												<input type="text" id="txt_gir_negocio" class="form-control input-sm" />
											</div>
											
											<label class="col-sm-3 control-label input-sm no-padding-right">Telefono Contacto:</label>											
											<div class="col-sm-3">
												<input type="text" id="txt_tel_contacto" class="form-control input-sm" />
											</div>
										</div>										
									</form>
								</div>
							</div>			
						</div>

						<div class="modal-footer">				
							<button id="btn_gra_proveedor" class="btn btn-sm btn-primary">
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
				
				$("#li_ingreso").addClass('active');
				$("#lis_reg_ing_tupa").addClass('active');
				
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
				
				$('input:radio[name="rb_tip_operacion"]').change(function() {			       
			        if ($(this).val() == 2) { // Otros
						$('#txt_nro_doc_rc').prop('disabled', true);
						$('#txt_nro_cp').prop('disabled', true);
						$('#txt_imp_cp').prop('disabled', true);
						$('#txt_anp').prop('disabled', true);
						$('#txt_fec_doc_rc').prop('disabled', true);
						$('#txt_nro_sia_operacion').prop('disabled', true);
			        } else {
						$('#txt_nro_doc_rc').prop('disabled', false);
						$('#txt_nro_cp').prop('disabled', false);
						$('#txt_imp_cp').prop('disabled', false);
						$('#txt_anp').prop('disabled', false);
						$('#txt_fec_doc_rc').prop('disabled', false);
						$('#txt_nro_sia_operacion').prop('disabled', false);
					}
			    });
				
				$('#txt_ser_comprobante').change(function() {
 					$('#txt_ser_comprobante').val(padDigits($(this).val(), 7));
 				});

				$('#txt_nro_comprobante').change(function() {
 					$('#txt_nro_comprobante').val(padDigits($(this).val(), 7));
 				});
				
				$('#txt_nro_cp').change(function() {
					$.ajax({
						type: 'GET',
						url: '${pageContext.request.contextPath}/listarCompras',
						data: {
							num_comprobante : $(this).val()
						},
						dataType: 'json',
						success: function(paramJson) {						
							if (paramJson.num_siaf[0] != null) {
								$('#txt_nro_sia_operacion').val(paramJson.num_siaf);
							} else {
								showMessage('El C/P no está registrado en transferencias.');
							}	
						},
						error: function(jqXHR, error, errorThrown) {
							var msg = 'Error:<br/>';
							if (jqXHR.status && jqXHR.status == 400) {
								msg = msg + jqXHR.responseText;
								showMessage(msg);
							} else {
								msg = msg + errorThrown;
								showMessage(msg);
							}
						}
					});
 				});				
				
				$('.btn_agr_partida').click(function(e) {					
					e.preventDefault();
					$('#h_det_reg_gravado').html('Nueva Partida');
					$('#form_det_reg_gravado').trigger("reset");
					$('#hid_partida').val('');
					$('#div_det_reg_gravado').modal('show');
				});
				
				$('#txt_partida').change(function() {
					$.ajax({
						type: 'GET',
						url: '${pageContext.request.contextPath}/verificarPartida',
						data: {
							partida : $.trim($(this).val())
						},
						dataType: 'json',
						success: function(paramJson) {						
							if (paramJson.srl_id_esp != null) {								
								$('#hid_partida').val(paramJson.srl_id_esp);
								$('#txt_servicio').val(paramJson.var_nom_especifica);
							} else {
								showMessage('La partida especifica no pertenece a la transferencia.');
							}	
						},
						error: function(jqXHR, error, errorThrown) {
							var msg = 'Error:<br/>';
							if (jqXHR.status && jqXHR.status == 400) {
								msg = msg + jqXHR.responseText;
								showMessage(msg);
							} else {
								msg = msg + errorThrown;
								showMessage(msg);
							}
						}
					});
 				});
				
				$('#btn_anadir').click(function(e) {					
					e.preventDefault();
					
					var partida = $('#txt_partida').val();
					var servicio = $('#txt_servicio').val();
					var importe = $('#txt_importe').val();
					var cod_tip_venta = $('#sel_tip_venta').val();
					var des_tip_venta = $('#sel_tip_venta').find('option:selected').text();
					var val_partida = $('#hid_partida').val();
					if (esnulo(val_partida)) {
						showMessage('No se encuentra registrado la actual partida, es necesario que exista previamente.');
						return;
					}
					
					var row = 0;
					var imp_total = parseFloat(importe);
					$('tr.item').each(function() {
						row = row + 1;		
						var imp_partida = $(this).find('.imp').text();
						if (!esnulo(imp_partida)) {
							imp_total = imp_total + parseFloat(imp_partida);
						}
					});
					$('#txt_imp_total').val(imp_total);
					
					var row_det = '<tr id="tr_'+row+'" class="item">'+
									'<td>'+row+'</td>'+
									'<td class="par">'+partida+'</td>'+
									'<td class="ser">'+servicio+'</td>'+
									'<td class="imp">'+importe+'</td>'+
									'<td class="tip">'+des_tip_venta+'</td>'+
									'<td class="hide cod_ser">'+val_partida+'</td>'+
									'<td class="hide cod_tip">'+cod_tip_venta+'</td>'+
								  '</tr>';		  
								  
					$('#tbl_det_partida tr').eq(row-1).after(row_det);
					$('#div_det_reg_gravado').modal('hide');
				});
				
				$('#btn_buscar').click(function(e) {
					e.preventDefault();
				
					$.ajax({
						type: 'GET',
						url: '${pageContext.request.contextPath}/verificarRuc',
						data: {
							nro_ruc : $.trim($('#txt_nro_ruc').val())
						},
						dataType: 'json',
						success: function(paramJson) {						
							if (paramJson.num_ruc != null) {								
								$('#hid_proveedor').val(paramJson.cod_proveedor);
								$('#txt_raz_social').val(paramJson.raz_social);
								$('#txt_nombres').val(paramJson.nombres);
								$('#txt_apellidos').val(paramJson.ape_paterno+ ' '+paramJson.ape_materno);
							} else {
								bootbox.dialog({
									message: "<span class='bigger-110'>El proveedor no existe, desea registrarlo?</span>",
									buttons: {
										"click" : {
											"label" : "Si",
											"className" : "btn-sm btn-primary",
											"callback": function() {												
												$('#form_reg_proveedor').trigger("reset");
												$('#txt_reg_ruc').val($('#txt_nro_ruc').val());
												$('#div_reg_proveedor').modal('show');										
											}
										}, 
										"button" : {
											"label" : "No",
											"className" : "btn-sm"
										}
									}
								});
							}	
						},
						error: function(jqXHR, error, errorThrown) {
							var msg = 'Error:<br/>';
							if (jqXHR.status && jqXHR.status == 400) {
								msg = msg + jqXHR.responseText;
								showMessage(msg);
							} else {
								msg = msg + errorThrown;
								showMessage(msg);
							}
						}
					});
 				});

				$('#btn_gra_proveedor').click(function(e) {					
					e.preventDefault();
										
					var num_ruc = $('#txt_reg_ruc').val();
					var tip_proveedor = $('input[name="rb_tip_empresa"]:checked').val();
					var tip_estado = $('input[name="rb_entidad"]:checked').val();
					var raz_social = $.trim($('#txt_reg_raz_social').val());
					var cod_documento = $('#sel_tip_doc').val();
					var num_documento = $('#txt_nro_doc').val();
					var ape_paterno = $.trim($('#txt_ape_paterno').val());
					var ape_materno = $.trim($('#txt_ape_materno').val());
					var nombres = $.trim($('#txt_reg_nombres').val());
					var mail = $.trim($('#txt_reg_correo').val());					
					var direccion = $.trim($('#txt_reg_direccion').val());
					var giro = $.trim($('#txt_gir_negocio').val());
					var telefono = $.trim($('#txt_tel_contacto').val());
					
					var msg = '';
					
					if (esnulo(num_ruc)) {
						msg = msg + 'El campo "Número de RUC" es obligatorio.<br/>';
					}				
					if (esnulo(tip_proveedor)) {
						msg = msg + 'El campo "Tipo Empresa" es obligatorio.<br/>';
					}
					if (esnulo(tip_estado)) {
						msg = msg + 'El campo "Entidad" es obligatorio.<br/>';
					}
					if (esnulo(raz_social)) {
						msg = msg + 'El campo "Razon Social" es obligatorio.<br/>';
					}
					if (!esnulo(msg)) {
						showMessage(msg);
						return;
					}	
											
					$.ajax({
						type: 'POST',
						url: VAR_CONTEXT + '/grabarProveedor',
						data: { 
							num_ruc : num_ruc,
							tip_proveedor : tip_proveedor,
							tip_estado : tip_estado,
							raz_social : raz_social,
							cod_documento : cod_documento,
							num_documento : num_documento,
							ape_paterno : ape_paterno,
							ape_materno : ape_materno,
							nombres : nombres,
							mail : mail,
							direccion : direccion,
							giro : giro,
							telefono : telefono
						},
						dataType: 'json',
						success: function(paramJson) {						
							if (paramJson != null) {
								endAjax();
								$('#div_reg_proveedor').hide();
								showMessage('El registro fue grabado.');							
							}	
						},
						error: function(jqXHR, error, errorThrown) {
							var msg = 'Error:<br/>';
							if (jqXHR.status && jqXHR.status == 400) {
								msg = msg + jqXHR.responseText;
								showMessage(msg);
							} else {
								msg = msg + errorThrown;
								showMessage(msg);
							}
						}
					});
				});
				
				$('#btn_salir').click(function(e) {					
					e.preventDefault();					
					var url = '${pageContext.request.contextPath}/comprasIngreso';
					$(location).attr('href', url);		
				});
				
				$('#btn_grabar').click(function(e) {					
					e.preventDefault();
					
					var codigo = $('#hid_reg_compras').val();
					var tip_operacion = $('input[name="rb_tip_operacion"]:checked').val();
					var nro_doc_rc = $('#txt_nro_doc_rc').val();
					var nro_cp = $('#txt_nro_cp').val();
					var nro_sia_operacion = $('#txt_nro_sia_operacion').val();
					var imp_cp = $('#txt_imp_cp').val();					
					var fec_doc_rc = $('#txt_fec_doc_rc').val(); 
					var cod_comprobante = $('#sel_tip_comprobante').val();					
					var fec_comprobante = $('#txt_fec_comprobante').val();
					var ser_comprobante = $('#txt_ser_comprobante').val();
					var cod_fue_financiamiento = $('#sel_fue_financiamiento').val();
					var nro_comprobante = $('#txt_nro_comprobante').val();
					var nro_siaf = $('#txt_nro_siaf').val();
					var cod_moneda = $('#sel_tip_moneda').val();
					var num_tip_cambio = $('#txt_tip_cambio').val();					
					var cod_proveedor = $('#hid_proveedor').val();
					var ind_ser_publico = $('input[name="rb_ser_publico"]:checked').val();					
					var mon_ser_publico = $('#txt_mon_ser_publico').val();
					var fec_pago = $('#txt_fec_pago').val();
					var fec_vto = $('#txt_fec_vto').val();
					var imp_total = $('#txt_imp_total').val();
					var num_constancia = $('#txt_num_constancia').val();
					var fec_pag_deposito = $('#txt_fec_pag_deposito').val();
					var imp_deposito = $('#txt_imp_deposito').val();
					var por_deposito = $('#txt_por_deposito').val();
					
					var msg = '';
					
					if (esnulo(ser_comprobante)) {
						msg = msg + 'El campo "Serie Comprobante" es obligatorio.<br/>';
					}				
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
					if (esnulo(cod_fue_financiamiento)) {
						msg = msg + 'El campo "Fte Fto" es obligatorio.<br/>';
					}
					if (esnulo(nro_siaf)) {
						msg = msg + 'El campo "SIAF" es obligatorio.<br/>';
					}		
					if (esnulo(num_tip_cambio)) {
						msg = msg + 'El campo "Tipo de Cambio" es obligatorio.<br/>';
					}
					if (!esnulo(msg)) {
						showMessage(msg);
						return;
					}	
					
					// 1era Validacion - Nro de C/P					
					if (!esnulo(nro_cp)) {
						if (esnulo(tip_operacion)) {
							msg = msg + 'El campo "Tipo Operación" es obligatorio.<br/>';
						}		
						if (esnulo(nro_doc_rc)) {
							msg = msg + 'El campo "Nro de Doc. R/C" es obligatorio.<br/>';
						}
						if (esnulo(nro_sia_operacion)) {
							msg = msg + 'El campo "Nro de SIAF" es obligatorio.<br/>';
						}
						if (esnulo(imp_cp)) {
							msg = msg + 'El campo "Imp. C/P" es obligatorio.<br/>';
						}
						if (!esnulo(msg)) {
							showMessage(msg);
							return;
						}
					}
					
					var arr_partida = '';
					var arr_importe = '';
					var arr_tip_venta = '';
					var row = 0;
					$('tr.item').each(function() {		
						var ind_servicio = $(this).find('.ser').text();
						if (!esnulo(ind_servicio)) {
							arr_partida = arr_partida + $(this).find('.cod_ser').text() + '|';
							arr_importe = arr_importe + $(this).find('.imp').text() + '|';
							arr_tip_venta = arr_tip_venta + $(this).find('.cod_tip').text() + '|';
							row = row + 1;
						}						
					});
					if (row > 0) {
						arr_partida = arr_partida.substring(0, arr_partida.length - 1);
						arr_importe = arr_importe.substring(0, arr_importe.length - 1);
						arr_tip_venta = arr_tip_venta.substring(0, arr_tip_venta.length - 1);
					} else {
						showMessage('Debe Agregar Detalle Partidas.');
						return;
					}
					
					var new_record = true;
					if (!esnulo(codigo)) {
						new_record = false;
					}
													
					$.ajax({
						type: 'POST',
						url: VAR_CONTEXT + '/grabarIngresoCompras',
						data: { 
							cod_com_ingresos : codigo,
							tip_operacion : tip_operacion,						
							nro_doc_rc : nro_doc_rc,
							nro_cp : nro_cp,
							nro_sia_operacion : nro_sia_operacion,
							imp_cp : imp_cp,
							fec_doc_rc : fec_doc_rc,
							cod_comprobante : cod_comprobante,
							fec_comprobante : fec_comprobante,
							ser_comprobante : ser_comprobante,
							cod_fue_financiamiento : cod_fue_financiamiento,
							nro_comprobante : nro_comprobante,
							nro_siaf : nro_siaf,
							cod_moneda : cod_moneda,							
							num_tip_cambio : num_tip_cambio,
							cod_proveedor : cod_proveedor,
							ind_ser_publico : ind_ser_publico,
							mon_ser_publico : mon_ser_publico,
							fec_pago : fec_pago,
							fec_vto : fec_vto,
							imp_total : imp_total,
							num_constancia : num_constancia,
							fec_pag_deposito : fec_pag_deposito,
							imp_deposito : imp_deposito,
							por_deposito : por_deposito,							
							arr_partida : arr_partida,
							arr_importe : arr_importe,
							arr_tip_venta : arr_tip_venta
						},
						dataType: 'json',
						success: function(paramJson) {						
							if (paramJson != null) {
								endAjax();
								if (new_record) {
									$('#hid_reg_compras').val(paramJson);
									showMessage('El registro fue grabado.');
								} else {
									showMessage('Registro Actualizado.');					
								}								
							}	
						},
						error: function(jqXHR, error, errorThrown) {
							var msg = 'Error:<br/>';
							if (jqXHR.status && jqXHR.status == 400) {
								msg = msg + jqXHR.responseText;
								showMessage(msg);
							} else {
								msg = msg + errorThrown;
								showMessage(msg);
							}
						}
					});
				});
				
				$('#btn_eliminar').click(function(e) {					
					e.preventDefault();
					bootbox.dialog({
						message: "<span class='bigger-110'>Esta seguro de eliminar la compra?</span>",
						buttons: {
							"click" : {
								"label" : "Aceptar",
								"className" : "btn-sm btn-primary",
								"callback": function() {
									var codigo = $('#hid_reg_compras').val();
									$.ajax({
										type: 'POST',
										url: VAR_CONTEXT + '/eliminarCompra',
										data: { codigo: codigo },
										dataType: 'json',
										success: function(paramJson) {						
											if (paramJson != null) {								
												var url = VAR_CONTEXT + '/comprasIngreso';
												$(location).attr('href', url);
											}	
										},
										error: function(jqXHR, error, errorThrown) {
											var msg = 'Error:<br/>';
											if (jqXHR.status && jqXHR.status == 400) {
												msg = msg + jqXHR.responseText;
												showMessage(msg);
											} else {
												msg = msg + errorThrown;
												showMessage(msg);
											}
										}
									});
								}
							}, 
							"button" : {
								"label" : "Salir",
								"className" : "btn-sm"
							}
						}
					});
				});
				
			});
			
			function inicializarDatos() {
				
				$('#txt_nro_doc_rc').prop('disabled', true);
				$('#txt_nro_cp').prop('disabled', true);
				$('#txt_imp_cp').prop('disabled', true);
				$('#txt_anp').prop('disabled', true);
				$('#txt_fec_doc_rc').prop('disabled', true);
				$('#txt_nro_sia_operacion').prop('disabled', true);
				
				if (!esnulo($('#hid_reg_compras').val())) {
					$('input[name=rb_tip_operacion][value="'+'${compra.ind_transaccion}'+'"]').prop('checked', true);
					$('#txt_nro_doc_rc').val('${compra.nro_doc_rc}');
					$('#txt_nro_cp').val('${compra.nro_cp}');
					$('#txt_nro_sia_operacion').val('${compra.nro_sia_operacion}');					
					$('#txt_imp_cp').val('${compra.imp_cp}');
					$('#txt_fec_doc_rc').val('${compra.fec_doc_rc}');
					$('#sel_tip_comprobante').val('${compra.cod_comprobante}');
					$('#txt_fec_comprobante').val('${compra.fec_comprobante}');
					$('#txt_ser_comprobante').val('${compra.ser_comprobante}');
					$('#sel_fue_financiamiento').val('${compra.cod_fue_financiamiento}');					
					$('#txt_nro_comprobante').val('${compra.nro_comprobante}');
					$('#txt_nro_siaf').val('${compra.nro_siaf}');
					$('#sel_tip_moneda').val('${compra.cod_moneda}');
					$('#txt_tip_cambio').val('${compra.num_tip_cambio}');					
					$('#hid_proveedor').val('${compra.cod_proveedor}');					
					$('#txt_nro_ruc').val('${compra.ruc_proveedor}');
					$('#txt_raz_social').val('${compra.des_proveedor}');
					$('input[name=rb_ser_publico][value="'+'${compra.ind_ser_publico}'+'"]').prop('checked', true);
					$('#txt_mon_ser_publico').val('${compra.mon_ser_publico}');
					$('#txt_fec_pago').val('${compra.fec_pago}');
					$('#txt_fec_vto').val('${compra.fec_vto}');
					$('#txt_imp_total').val('${compra.imp_total}');
					$('#txt_num_constancia').val('${compra.num_constancia}');
					$('#txt_fec_pag_deposito').val('${compra.fec_pag_deposito}');
					$('#txt_imp_deposito').val('${compra.imp_deposito}');
					$('#txt_por_deposito').val('${compra.por_deposito}');
				} else {
					$('#btn_eliminar').hide();
				}
			}
		
		</script>
		
	</body>
</html>