<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta charset="utf-8" />
		<title>Mantenimiento de Proveedores</title>

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
								Mantenimiento
							</li>
							<li class="active">Mantenimiento de Proveedores</li>
						</ul>
					</div>
			
					<div class="page-content">		
						<div class="row">
							<div class="col-xs-12">
								<form class="form-horizontal" role="form">
									
									<fieldset class="fsStyle">
										<legend class="legendStyle">Filtros para la Búsqueda de Proveedores</legend>
											
										<div class="form-group">	
											<div class="col-sm-10">
												<div class="form-group">
													<label class="col-sm-2 control-label label-sm no-padding-right">Numero de Ruc:</label>
													<div class="col-sm-2">
														<input type="text" id="txt_nro_ruc" class="form-control input-sm onlyNumbers" maxlength="11" />
													</div>
													
													<label class="col-sm-2 control-label label-sm">Tipo de Empresa:</label>												
													<div class="col-sm-2">
														<div class="radio">
															<select id="sel_tip_empresa" class="form-control input-sm">
															<option value="">SELECCIONAR</option>
															<option value="1">ESTATAL</option>
															<option value="2">PRIVADA</option>
														</select>
														</div>
													</div>
												</div>		
															
												<div class="form-group">
													<label class="col-sm-2 control-label label-sm no-padding-right">Tipo de Documento:</label>
														<div class="col-sm-2">
															<select id="sel_tip_doc" class="form-control input-sm">
																<option value="0">SELECCIONAR</option>
																<c:forEach items="${lis_tip_documento}" var="item">
																	<option value="${item.cod_documento}" ${item.cod_documento == 4 ? 'selected="selected"' : ''}>${item.nom_documento}</option>
																</c:forEach>
															</select>
														</div>
													<label class="col-sm-2 control-label label-sm no-padding-right">Nro de Documento:</label>
													<div class="col-sm-2">
														<input type="text" id="txt_nro_doc" class="form-control input-sm " maxlength="15" />
													</div>
													
													<label class="col-sm-2 control-label label-sm">Tipo de Proveedor:</label>												
													<div class="col-sm-2">
														<select id="sel_tip_proveedor" class="form-control input-sm">
															<option value="">SELECCIONAR</option>
															<option value="1">NATURAL</option>
															<option value="2">JURÍDICO</option>
														</select>
													</div>
												</div>
											</div>
												
											<div class="col-sm-2">
												<div class="form-group">	
													<div class="col-sm-12">
														<button id="btn_buscar" class="btn btn-sm btn-info" type="button">
															<i class="ace-icon fa fa-search"></i>
															Buscar
														</button>
													</div>
												</div>
																						
												<div class="form-group">	
													<div class="col-sm-12">
														<button id="btn_nuevo" class="btn btn-sm btn-success" type="button">
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
							<fieldset class="fsStyle">
						       <legend class="legendStyle">Lista de la Información de Proveedores</legend>
								<div class="table-responsive div_lis_proveedor">
									<table class="table table-striped table-bordered table-hover">
										<thead>
											<tr>
												<th>ID</th>
												<th>RUC</th>
												<th>Tipo de Proveedor</th>
												<th>Razón Social</th>
												<th>Apellidos</th>
												<th>Nombre</th>
												<th>Usuario</th>
											</tr>
										</thead>
									</table>
								</div>
							</fieldset>
							</div>
						</div>
					</div>
				</div>
			</div><!-- /.main-content -->
			
			<div id="div_proveedor" class="modal" tabindex="-1" data-keyboard="false" data-backdrop="static">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">&times;</button>
							<h4 id="h_proveedor" class="white bigger center"></h4>
						</div>
						
						<div class="modal-body">
							<div class="row">
								<div class="col-xs-12">
									<form id="form_proveedor" class="form-horizontal" role="form">
										<div class="form-group">																				
											<label class="col-sm-3 control-label input-sm no-padding-right hidden">Codigo:</label>											
											<div class="col-sm-5">
												<input type="text" id="txt_mnt_codigo" class="form-control input-sm onlyAmounts hidden" disabled />
											</div>											
										</div>		
										
										<div class="form-group">																				
											<label class="col-sm-3 control-label input-sm no-padding-right">Ruc:</label>											
											<div class="col-sm-5">
												<input type="text" id="txt_mnt_ruc" class="form-control input-sm onlyAmounts" maxlength="11"  />
											</div>											
										</div>										

										<div class="form-group">																				
											<label class="col-sm-3 control-label input-sm no-padding-right">Razon social:</label>											
											<div class="col-sm-9">
												<input type="text" id="txt_mnt_razon_social" class="form-control input-sm" maxlength="50" style="text-transform:uppercase" />
											</div>	
										</div>									
										
										<div class="form-group">
										<label class="col-sm-3 control-label label-sm">Tipo de Proveedor:</label>												
													<div class="col-sm-8">
														<div class="radio">
															<label class="label-sm">
																<input type="radio" name="rb_mnt_tip_proveedor" value="1" disabled>
																Natural
															</label>
															&nbsp;&nbsp;
															<label class="label-sm">
																<input type="radio" name="rb_mnt_tip_proveedor" value="2" disabled>
																Juridico
															</label>
														</div>
													</div>			
										</div>
										<div class="form-group">
											<label class="col-sm-3 control-label label-sm no-padding-right">Tipo de Empresa:</label>
											<div class="col-sm-8">
														<div class="radio">
															<label class="label-sm">
																<input type="radio" name="rb_mnt_tip_empresa" value="1" checked>
																Estatal
															</label>
															&nbsp;&nbsp;
															<label class="label-sm">
																<input type="radio" name="rb_mnt_tip_empresa" value="2">
																Privado
															</label>
														</div>
													</div>
										</div>
										
										<div class="form-group">
											<label class="col-sm-3 control-label label-sm no-padding-right">Tipo de Documento:</label>
											<div class="col-sm-3">
												<select id="sel_mnt_tip_doc" class="form-control input-sm">
														<option>Seleccionar</option>
													<c:forEach items="${lis_tip_documento}" var="item">
														<option value="${item.cod_documento}">${item.nom_documento}</option>
													</c:forEach>
												</select>
											</div>
											<label class="col-sm-3 control-label input-sm no-padding-right">Nro de Documento:</label>											
											<div class="col-sm-3">
												<input type="text" id="txt_mnt_documento" class="form-control input-sm onlyAmounts" maxlength = "8"  />
											</div>											
							            </div>
										<div class="form-group">																				
											<label class="col-sm-3 control-label input-sm no-padding-right">Nombres:</label>											
											<div class="col-sm-3">
												<input type="text" id="txt_mnt_nombre" class="form-control input-sm" style="text-transform:uppercase" />
											</div>	
																													
											<label class="col-sm-3 control-label input-sm no-padding-right">Apellido Paterno:</label>											
											<div class="col-sm-3">
												<input type="text" id="txt_mnt_ape_paterno" class="form-control input-sm" style="text-transform:uppercase" />
											</div>	
										</div>	
										
										<div class="form-group">	
											<div class="col-sm-6">
										    </div>
										    <label class="col-sm-3 control-label input-sm no-padding-right">Apellido Materno:</label>											
											<div class="col-sm-3">
												<input type="text" id="txt_mnt_ape_materno" class="form-control input-sm" style="text-transform:uppercase" />
											</div>	
										    
										</div>	
										
										 <div class="form-group">
							           	    <label class="col-sm-3 control-label input-sm no-padding-right">Dirección:</label>											
											<div class="col-sm-9">
												<input type="text" id="txt_mnt_direccion" class="form-control input-sm" maxlength="100" style="text-transform:uppercase" />
											</div>
							            </div>
							            
							             <div class="form-group">
							           	    <label class="col-sm-3 control-label input-sm no-padding-right">Correo:</label>											
											<div class="col-sm-3">
												<input type="email" id="txt_mnt_correo" class="form-control input-sm"  maxlength="30" style="text-transform:uppercase"/>
											</div>
											
											<label class="col-sm-3 control-label input-sm no-padding-right">Telefono:</label>											
											<div class="col-sm-3">
												<input type="text" id="txt_mnt_telefono" class="form-control input-sm" maxlength="11" style="text-transform:uppercase" />
											</div>
							            </div>
							            
							             <div class="form-group">
							           	    <label class="col-sm-3 control-label input-sm no-padding-right">Giro:</label>											
											<div class="col-sm-9">
												<input type="text" id="txt_mnt_giro" class="form-control input-sm" style="text-transform:uppercase" />
											</div>
							            </div>
							            
							            
										
										<div class="form-group">																				
											<label class="col-sm-3 control-label input-sm no-padding-right">Fecha de Creacion:</label>											
											<div class="col-sm-3">
												<input type="text" id="txt_fec_creacion" class="form-control input-sm" disabled />
											</div>	
																													
											<label class="col-sm-3 control-label input-sm no-padding-right">Fecha de Modificacion:</label>											
											<div class="col-sm-3">
												<input type="text" id="txt_fec_modificacion" class="form-control input-sm" disabled />
											</div>	
										</div>	
										
										<div class="form-group">																				
											<label class="col-sm-3 control-label input-sm no-padding-right">Creación:</label>											
											<div class="col-sm-3">
												<input type="text" id="txt_creacion" class="form-control input-sm" disabled />
											</div>	
																													
											<label class="col-sm-3 control-label input-sm no-padding-right">Modificado:</label>											
											<div class="col-sm-3">
												<input type="text" id="txt_modificado" class="form-control input-sm" disabled />
											</div>	
										</div>																							
									</form>
								</div>
							</div>			
						</div>

						<div class="modal-footer">				
							<div class="form-group">
								<div class="col-sm-3">
									<button id="btn_grabar" class="btn btn-sm btn-primary input-sm">
										<i class="ace-icon fa fa-check"></i>
										Grabar
									</button>
								</div>

								<div class="col-sm-3">
									<button id="btn_salir" class="btn btn-sm input-sm" data-dismiss="modal">
										<i class="ace-icon fa fa-times"></i>
										Salir
									</button>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		
		</div><!-- /.main-container -->
	
		<%@ include file="scripts_ini.jsp" %>	

		<!-- inline scripts related to this page -->
		<script type="text/javascript">
		
			$(document).ready(function() {
				
				$("#li_mantenimiento").addClass('active');
				$("#li_mnt_proveedores").addClass('active');			

				$('#btn_buscar').click(function(e) {					
					e.preventDefault();
					search();
				 
				});
				
				$('#btn_nuevo').click(function(e) {					
					e.preventDefault();
					$('#h_proveedor').html('Registro de Proveedores');
					$('#form_proveedor').trigger("reset");
					$('#div_proveedor').modal('show');
					$('input[name=rb_mnt_tip_empresa][value="1"]').prop('checked', true);
				
				});
				
				$('#btn_grabar').click(function(e) {					
					e.preventDefault();

					var cod_proveedor = $('#txt_mnt_codigo').val();
					var num_ruc = $('#txt_mnt_ruc').val();
					var raz_social = $('#txt_mnt_razon_social').val();
					var tip_proveedor = $('input[name=rb_mnt_tip_proveedor]:checked').val();
					var tip_estado = $('input[name=rb_mnt_tip_empresa]:checked').val();
					var cod_documento = $('#sel_mnt_tip_doc').val();
					var num_documento = $('#txt_mnt_documento').val();
					var nombres = $('#txt_mnt_nombre').val();
					var ape_paterno = $('#txt_mnt_ape_paterno').val();
					var ape_materno = $('#txt_mnt_ape_materno').val();
					var direccion = $('#txt_mnt_direccion').val();
					var mail = $('#txt_mnt_correo').val();
					var telefono = $('#txt_mnt_telefono').val();
					var giro = $('#txt_mnt_giro').val();
					
					var msg = '';
					
					if (parseInt(num_ruc.substring(0, 2)) == 20){
						if (esnulo(raz_social)) {
							msg = msg + 'Campo "Ruc" es Obligatorio.<br/>';
						}
						if (esnulo(raz_social)) {
							msg = msg + 'Campo "Razon Social" es Obligatorio.<br/>';
						}
					}
					
					
					if (cod_documento == 'Seleccionar') {
						msg = msg + 'Seleccionar el Tipo de Documento.<br/>';
					}
					
					if (!esnulo(msg)) {
						showMessage(msg);
						return;
					}	
					
					var fla_activo = 'N';
					if ($('#chk_mnt_activo').is(':checked')) {
						fla_activo = 'S';
					}
					
					var new_record = true;
					if (!esnulo(cod_proveedor)) {
						new_record = false;
					}
					$.ajax({
						type: 'POST',
						url: VAR_CONTEXT + '/grabarProveedor',
						data: { 
							cod_proveedor : cod_proveedor,
							num_ruc : num_ruc,
							raz_social : raz_social,
							tip_proveedor : tip_proveedor,
							tip_estado : tip_estado,
							cod_documento : cod_documento,
							num_documento : num_documento,
							nombres : nombres,
							ape_paterno : ape_paterno,
							ape_materno : ape_materno,	
							direccion : direccion,	
							mail : mail,	
							telefono : telefono,	
							giro : giro,	
							fla_activo : fla_activo
						},
						dataType: 'json',
						success: function(paramJson) {						
							if (paramJson != null) {
								endAjax();			
								if (new_record) {
									addInfoMessage(null, 'El registro fue grabado.');
								} else {
									addInfoMessage(null, 'Registro Actualizado.');
								}
								$('#div_proveedor').modal('hide');
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
					
				});
				
				 $('#txt_mnt_razon_social').keyup(function() {
				        this.value = this.value.toUpperCase();
				   });
				
				 
				$('#txt_mnt_ruc').change(function() {
					var nro_ruc = $(this).val();
					if (nro_ruc.length < 11){
						 alert("Ingresar el Numero de Ruc");
						 $('#txt_mnt_ruc').val("");
					 
					}else {
						if (parseInt(nro_ruc.substring(0, 2)) == 20) { // Persona Juridica
							$('#sel_mnt_tip_doc').val("4");
						//	$('#sel_mnt_tip_doc').prop('disabled', true);
							$('input[name=rb_mnt_tip_proveedor][value="2"]').prop('checked', true);
							$('#txt_mnt_documento').prop('disabled', true);
							$('#txt_mnt_ape_paterno').prop('disabled', true);
							$('#txt_mnt_ape_materno').prop('disabled', true);
							$('#txt_mnt_nombre').prop('disabled', true);
							$('#txt_mnt_razon_social').prop('disabled', false);
						} else if (parseInt(nro_ruc.substring(0, 1)) == 1) {
							$('input[name=rb_mnt_tip_proveedor][value="1"]').prop('checked', true);
							$('#sel_mnt_tip_doc').val("2");
							$('#sel_mnt_tip_doc').prop('disabled', false);
							$('#txt_mnt_razon_social').prop('disabled', true);
							$('#txt_mnt_documento').prop('disabled', false);
							$('#txt_mnt_ape_paterno').prop('disabled', false);
							$('#txt_mnt_ape_materno').prop('disabled', false);
							$('#txt_mnt_nombre').prop('disabled', false);
						} else {
							$('input[name=rb_mnt_tip_proveedor]').prop('disabled', false);
							$('#txt_mnt_razon_social').prop('disabled', false);
							$('#sel_mnt_tip_doc').prop('disabled', false);
							$('#txt_mnt_razon_social').prop('disabled', false);
							$('#txt_mnt_documento').prop('disabled', false);
							$('#txt_mnt_ape_paterno').prop('disabled', false);
							$('#txt_mnt_ape_materno').prop('disabled', false);
							$('#txt_mnt_nombre').prop('disabled', false);
						}	
					}
				
				//	if (!esnulo(nro_ruc)) {
						// $.ajax({
						//	type: 'GET',
						//	url: '${pageContext.request.contextPath}/verificarRucMantenimiento',
						//	data: {
						//		nro_ruc : nro_ruc
						//	},
						//	dataType: 'json',
						//	success: function(paramJson) {						
						//		if (paramJson.num_ruc != null) {								
						//			$('#hid_proveedor').val(paramJson.cod_proveedor);
						//			$('input[name="rb_tip_proveedor"][value="'+paramJson.tip_proveedor+'"]').prop('checked', true);
						//			$('input[name="rb_ent_publicas"][value="'+paramJson.tip_estado+'"]').prop('checked', true);
						//			$('#txt_mnt_razon_social').val(paramJson.raz_social);
						//			$('#txt_mnt_nombre').val(paramJson.nombres);
						//			$('#txt_mnt_apellido').val(paramJson.ape_paterno+ ' '+paramJson.ape_materno);
						//		}	
						//	},
						//	error: function(jqXHR, error, errorThrown) {
						//		var msg = 'Error:<br/>';
						//		if (jqXHR.status && jqXHR.status == 400) {
						//			msg = msg + jqXHR.responseText;
						//		} else {
						//			msg = msg + errorThrown;
						//		}
						//		addErrorMessage(null, msg);
						//	}
						//});
					//}
 				});

			});			
						
			function search() {
				var href = '/listarProveedor';				
				var fla_activo = 'N';
				if ($('#chk_activo').is(':checked')) {
					fla_activo = 'S';
				}		
				var selectedValTipEmp = "";
				var selectedValTipEmp = $('#sel_tip_empresa').val();
				
				var selectedValTipProv = "";
				var selectedValTipProv = $('#sel_tip_proveedor').val();
				
				var cod_documento = $('#sel_tip_doc').val();
				
				var params = {
					num_ruc : $('#txt_nro_ruc').val(),
					num_documento : $('#txt_nro_doc').val(),
					tip_estado : selectedValTipEmp,
					tip_proveedor : selectedValTipProv,
					cod_documento : cod_documento
					//fla_activo : fla_activo
				};
				var fields = [
					'cod_proveedor',
					'cod_proveedor'
				];
				var layout = [{
					title: 'Item',
					field: fields,
					type: 'link',					
					label: '',
					method: 'editar',
				}, {
					title: 'RUC',
					field: 'num_ruc',
				}, {
					title: 'Tipo de Proveedor',
					field: 'desc_tip_proveedor',
				}, {
					title: 'Razón Social',
					field: 'raz_social',
				}, {
					title: 'Apellidos',
					field: 'ape_paterno',
				}, {
					title: 'Nombre',
					field: 'nombres',
				}, {
					title: 'Fec. Creación',
					field: 'mnt_fec_creacion',
				},{
					title: 'Fec. Modificación',
					field: 'mnt_fec_modificacion',
				}, {
					title: 'Usuario',
					field: 'mnt_usu_creacion',
				},{
					title: 'Usuario Modificación',
					field: 'mnt_usu_modificacion',
				}];
				
				var options = {
					containerTable: '.div_lis_proveedor',
					idTable: 'tbl_lis_proveedor',
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
				$.ajax({
					type: 'GET',
					url: '${pageContext.request.contextPath}/listarProveedor',
					data: {
						cod_proveedor : object
					},
					dataType: 'json',
					success: function(paramJson) {						
					//	if (paramJson[0] != null) {	
							//if (paramJson[0].tip_proveedor="1") {
							//$('input[name=rb_mnt_tip_proveedor][value="1"]').prop('checked', true);
						    //if($radios.is(':checked') === false) {
						      //  $radios.filter('[value=1]').prop('checked', true);
						   // }
							//alert($('input[name=rb_mnt_tip_proveedor][value='+paramJson[0].tip_proveedor+']').is(':checked'));
							//	$('input[name=rb_mnt_tip_proveedor][value='+paramJson[0].tip_proveedor+']').prop('checked', true);								
							//}
							
							$('#h_proveedor').html('Edicion de Proveedores');
							$('#form_proveedor').trigger("reset");
							$('#txt_mnt_codigo').val(paramJson[0].cod_proveedor);
							$('#txt_mnt_razon_social').val(trim(paramJson[0].raz_social));
							$('#txt_mnt_documento').val(paramJson[0].num_documento);
							$('#txt_mnt_nombre').val(paramJson[0].nombres);
							$('#txt_mnt_ape_paterno').val(paramJson[0].ape_paterno);
							$('#txt_mnt_ape_materno').val(paramJson[0].ape_materno);
							$('#txt_mnt_direccion').val(paramJson[0].direccion);
							$('#txt_mnt_correo').val(paramJson[0].mail);
							$('#txt_mnt_giro').val(paramJson[0].giro);
							$('#txt_mnt_telefono').val(paramJson[0].telefono);	
							$('#sel_mnt_tip_doc').val(paramJson[0].cod_documento);							
							
							if (paramJson[0].fla_activo = 'S') {
								$('#chk_mnt_activo').attr('checked', true);
							}
							$('#txt_fec_creacion').val(paramJson[0].mnt_fec_creacion);
							$('#txt_fec_modificacion').val(paramJson[0].mnt_fec_modificacion);
							$('#txt_creacion').val(paramJson[0].mnt_usu_creacion);
							$('#txt_modificado').val(paramJson[0].mnt_usu_modificacion);
							
							$('input[name=rb_mnt_tip_proveedor][value="'+paramJson[0].tip_proveedor+'"]').prop('checked', true);
							$('input[name=rb_mnt_tip_empresa][value="'+paramJson[0].tip_estado+'"]').prop('checked', true);

							$('#txt_mnt_ruc').val(paramJson[0].num_ruc);
							
							var nro_ruc = paramJson[0].num_ruc.toString();
							//alert(nro_ruc);
							if (parseInt(nro_ruc.substring(0, 2)) == 20) { // Persona Juridica
								$('#sel_mnt_tip_doc').val("4");
							//	$('#sel_mnt_tip_doc').prop('disabled', true);
								$('input[name=rb_mnt_tip_proveedor][value="2"]').prop('checked', true);
								$('#txt_mnt_documento').prop('disabled', true);
								$('#txt_mnt_ape_paterno').prop('disabled', true);
								$('#txt_mnt_ape_materno').prop('disabled', true);
								$('#txt_mnt_nombre').prop('disabled', true);
								$('#txt_mnt_razon_social').prop('disabled', false);
							} else if (parseInt(nro_ruc.substring(0, 1)) == 1) {
								$('input[name=rb_mnt_tip_proveedor][value="1"]').prop('checked', true);
								$('#sel_mnt_tip_doc').val("2");
								$('#sel_mnt_tip_doc').prop('disabled', false);
								$('#txt_mnt_razon_social').prop('disabled', true);
								$('#txt_mnt_documento').prop('disabled', false);
								$('#txt_mnt_ape_paterno').prop('disabled', false);
								$('#txt_mnt_ape_materno').prop('disabled', false);
								$('#txt_mnt_nombre').prop('disabled', false);
							} else {
								$('input[name=rb_mnt_tip_proveedor]').prop('disabled', false);
								$('#txt_mnt_razon_social').prop('disabled', false);
								$('#sel_mnt_tip_doc').prop('disabled', false);
								$('#txt_mnt_razon_social').prop('disabled', false);
								$('#txt_mnt_documento').prop('disabled', false);
								$('#txt_mnt_ape_paterno').prop('disabled', false);
								$('#txt_mnt_ape_materno').prop('disabled', false);
								$('#txt_mnt_nombre').prop('disabled', false);
							}
							$('#div_proveedor').modal('show');
					//	}	
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