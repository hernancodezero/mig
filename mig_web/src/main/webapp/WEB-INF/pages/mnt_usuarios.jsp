<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta charset="utf-8" />
		<title>Generación de Perfiles y Usuarios</title>

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
								Seguridad
							</li>
							<li class="active">Generación de Perfiles y Usuarios</li>
						</ul>
					</div>
			
					<div class="page-content">		
						<div class="row">
							<div class="col-xs-12">
								<form class="form-horizontal" role="form">
									
									<fieldset class="fsStyle">
										<legend class="legendStyle">Búsqueda de Información de Usuarios</legend>
											
										<div class="form-group">	
											<div class="col-sm-10">
												<div class="form-group">
													<label class="col-sm-3 control-label label-sm no-padding-right">Nombre del Perfil:</label>
													<div class="col-sm-3">
														<select id="sel_perfil" class="form-control input-sm">
															<option value="">&#60Seleccione&#62</option>
															<c:forEach items="${lis_perfil}" var="item">
 															    <option value="${item.cod_rol}">${item.des_rol}</option>
															</c:forEach>
														</select>
													</div>
												</div>
													
												<div class="form-group">
													<label class="col-sm-3 control-label label-sm no-padding-right">Nombre del Usuario:</label>
													<div class="col-sm-3">
														<input type="text" id="txt_nom_usuario" class="form-control input-sm upperValue" maxlength="40" />
													</div>
													
													<div class="col-sm-3">
														<div class="checkbox">
															<label class="input-sm">
																<input type="checkbox" id="chk_activo" class="ace input-sm" />
																<span class="lbl"> Activo</span>
															</label>
														</div>
													</div>	
												</div>
												
												<div class="form-group">																				
													<label class="col-sm-3 control-label input-sm no-padding-right">Nombres:</label>											
													<div class="col-sm-3">
														<input type="text" id="txt_nombres" class="form-control input-sm upperValue" maxlength="30" />
													</div>
																				
													<label class="col-sm-3 control-label input-sm no-padding-right">Apellidos:</label>											
													<div class="col-sm-3">
														<input type="text" id="txt_apellidos" class="form-control input-sm upperValue" maxlength="40" />
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
												
												<div class="form-group"></div>
												<div class="form-group"></div>
												<div class="form-group"></div>
																						
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
								<div class="table-responsive div_lis_usuario">
									<table class="table table-striped table-bordered table-hover">
										<thead>
											<tr>
												<th>ID</th>
												<th>Apellidos</th>
												<th>Nombres</th>
												<th>Usuario</th>
												<th>Oficina</th>
												<th>Perfil</th>
											</tr>
										</thead>
									</table>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div><!-- /.main-content -->
			
			<div id="div_usuario" class="modal" tabindex="-1" data-keyboard="false" data-backdrop="static">
				<div class="modal-dialog modal-lg">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">&times;</button>
							<h4 id="h_usuario" class="white bigger center"></h4>
						</div>
						
						<div class="modal-body">
							<div class="row">
								<div class="col-xs-12">
									<form id="form_usuario" class="form-horizontal" role="form">
									
										<input type="hidden" id="hid_usuario">
										<input type="hidden" id="hid_rol_act">
										
										<div id="div_mnt_usuario" class="form-group">																				
											<label class="col-sm-3 control-label input-sm no-padding-right">Nombre del Usuario:</label>											
											<div class="col-sm-3">
												<input type="text" id="txt_mnt_usuario" class="form-control input-sm" disabled />
											</div>
										</div>
									
										<div class="form-group">																				
											<label class="col-sm-3 control-label input-sm no-padding-right">Nombres:</label>											
											<div class="col-sm-3">
												<input type="text" id="txt_mnt_nombres" class="form-control input-sm upperValue" maxlength="30" />
											</div>
																		
											<label class="col-sm-2 control-label input-sm no-padding-right">Apellidos:</label>											
											<div class="col-sm-3">
												<input type="text" id="txt_mnt_apellidos" class="form-control input-sm upperValue" maxlength="40" />
											</div>
											
											<div id="div_btn_bus_usuarios" class="col-sm-1">
												<button id="btn_bus_usuarios" class="btn btn-sm btn-info input-sm" type="button">
													<i class="ace-icon fa fa-search-plus"></i>
												</button>
											</div>
										</div>									
										
										<div id="div_bus_usuarios" class="table-responsive div_bus_usuarios">
						 				
						 				</div>
						 				
						 				<br>
										
										<div class="form-group">
											<label class="col-sm-3 control-label label-sm no-padding-right">Nombre del Perfil:</label>
											<div class="col-sm-3">
												<select id="sel_mnt_perfil" class="form-control input-sm">
													<c:forEach items="${lis_perfil}" var="item">
														    <option value="${item.cod_rol}">${item.des_rol}</option>
													</c:forEach>
												</select>
											</div>
										
											<div class="col-sm-3">
												<div class="checkbox">
													<label class="input-sm">
														<input type="checkbox" class="ace input-sm" id="chk_mnt_activo" />
														<span class="lbl"> Activo</span>
													</label>
												</div>
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
				
				$("#li_seguridad").addClass('active');
				$("#li_mnt_usuarios").addClass('active');
				
				$('#chk_activo').attr('checked', true);

				$('#btn_buscar').click(function(e) {					
					e.preventDefault();
					search();
				});
				
				$('#btn_nuevo').click(function(e) {					
					e.preventDefault();
					$('#h_usuario').html('Registro de Nuevo Usuario');
					$('#hid_usuario').val('');
					$('#hid_rol_act').val('');
					$('#div_mnt_usuario').hide();
					$('#div_btn_bus_usuarios').show();
					$('#div_bus_usuarios').html('');
					$('#txt_mnt_nombres').val('');
					$('#txt_mnt_apellidos').val('');
					$('#sel_mnt_perfil').val(78);
					$('#txt_mnt_nombres').prop('disabled', false);
					$('#txt_mnt_apellidos').prop('disabled', false);
					$('#chk_mnt_activo').attr('checked', true);
					$('#div_usuario').modal('show');
				});
				
				$('#btn_bus_usuarios').click(function(e) {					
					e.preventDefault();
					
					var nombres = $.trim($('#txt_mnt_nombres').val());
					var apellidos = $.trim($('#txt_mnt_apellidos').val());					
					if (esnulo(nombres) && esnulo(apellidos)) {
						addWarnMessage(null, 'Debe ingresar un campo busqueda como minimo.');
						return;
					}
					$('#hid_usuario').val('');
										
					startAjax();
					
					// Validamos que exista el usuario en la lista usuarios no asociados al perfil actual
					$.ajax({
						type: 'GET',
						url: '${pageContext.request.contextPath}/listarUsuarios',
						data: {
							nombres : nombres,
							apellidos : apellidos,
							ind_per_mig : 1,
							cod_estado : 1
						},
						dataType: 'json',
						success: function(paramJson) {				
							if (paramJson != null && paramJson.length > 0) {
								
								endAjax();
								
								var href = '/listarUsuarios';
				 			    var params = {
				 			    	nombres : nombres,
									apellidos : apellidos,
									ind_per_mig : 1,
									cod_estado : 1
				 			    };
				 			    var layout = [{
				 			        title: 'N°',
				 			        type: 'enum',
				 			        'class': 'center no-sort'
				 			    }, {
				 			        title: 'Usuario',
				 			        field: 'des_usuario',
				 			        'class': 'no-sort'
				 			   }, {
				 			        title: 'Nombres',
				 			        field: 'nombres',
				 			        'class': 'no-sort'
				 			    }, {
				 			        title: 'Apellidos',
				 			        field: 'apellidos',
				 			        'class': 'no-sort'
				 			    }, {
				 			        title: '',
				 			        field: 'cod_usuario',
				 			        'class': 'hide'
				 			    }];
				 			    var options = {
				 			        containerTable: '.div_bus_usuarios',
				 			        idTable: 'tbl_bus_usuarios',
				 			        styleTable: '',
				 			        loading: true,
				 			        parameters: params,
				 			        vTableOptions: {
				 			            bFilter: false,
				 			            paging: true,
				 			            info: false,
				 			            aLengthMenu: [
				 			                [5, 10, 20],
				 			                [5, 10, 20]
				 			            ],
				 			   			iDisplayLength: 10
				 			        }
				 			    };
				 			    simpleGenerateDatatable(href, layout, options, 'selUsuario', null);
				 			    
							} else {
								
								$.ajax({
									type: 'GET',
									url: '${pageContext.request.contextPath}/listarUsuarios',
									data: {
										nombres : nombres,
										apellidos : apellidos,
										cod_estado : 1
									},
									dataType: 'json',
									success: function(paramJsonChild) {
										endAjax();
										if (paramJsonChild != null && paramJsonChild.length > 0) {
											addWarnMessage(null, 'El usuario ya se encuentra registrado con un Perfil.');
											return;
										} else {
											$('#div_bus_usuarios').html('');
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
				
				$('#btn_grabar').click(function(e) {					
					e.preventDefault();
					
					var cod_usuario = $('#hid_usuario').val();
					var ind_per_mig = $('#hid_rol_act').val();
					var cod_rol = $('#sel_mnt_perfil').val();					
					var fla_activo = '0';
					
					if (esnulo(ind_per_mig)) {
						var row_det = $('#tbl_bus_usuarios td').closest('tr').length;
						if (row_det > 0) {
							if (esnulo(cod_usuario)) {
								addWarnMessage(null, 'Debe seleccionar un registro.');
								return;
							}
						} else {
							addWarnMessage(null, 'Debe buscar al usuario previamente para el registro.');
							return;
						}
					}
					
					if ($('#chk_mnt_activo').is(':checked')) {
						fla_activo = '1';
					}	
					var new_record = true;
					if (!esnulo(ind_per_mig)) {
						new_record = false;
					}
													
					$.ajax({
						type: 'POST',
						url: VAR_CONTEXT + '/grabarUsuario',
						data: { 
							cod_usuario : cod_usuario,
							ind_per_mig : ind_per_mig,
							cod_rol : cod_rol,
							cod_estado : fla_activo
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
								$('#div_usuario').modal('hide');
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

			});			
						
			function search() {
				var href = '/listarUsuarios';				
				var fla_activo = '0';
				if ($('#chk_activo').is(':checked')) {
					fla_activo = '1';
				}				
				var params = {
					cod_rol : $('#sel_perfil').val(),
					des_usuario : $('#txt_nom_usuario').val(),
					nombres : $('#txt_nombres').val(),
					apellidos : $('#txt_apellidos').val(),
					cod_estado : fla_activo
				};
				var fields = [
					'cod_usuario',
					'cod_usuario'
				];
				var layout = [{
					title: 'ID',
					field: fields,
					type: 'link',					
					label: '',
					method: 'editar',
					'class': 'no-sort',
				}, {
					title: 'Apellidos',
					field: 'apellidos',
					'class': 'no-sort'
				}, {
					title: 'Nombres',
					field: 'nombres',
					'class': 'no-sort'
				}, {
					title: 'Usuario',
					field: 'des_usuario',
					'class': 'no-sort'
				}, {
					title: 'Oficina',
					field: 'des_area',
					'class': 'no-sort'
				}, {
					title: 'Perfil',
					field: 'des_rol',
					'class': 'no-sort'
				}];
				var options = {
					containerTable: '.div_lis_usuario',
					idTable: 'tbl_lis_usuario',
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
				var fla_activo = '0';
				if ($('#chk_activo').is(':checked')) {
					fla_activo = '1';
				}
				$.ajax({
					type: 'GET',
					url: '${pageContext.request.contextPath}/listarUsuarios',
					data: {
						cod_usuario : object,
						cod_estado : fla_activo
					},
					dataType: 'json',
					success: function(paramJson) {						
						if (paramJson[0] != null) {	
							$('#h_usuario').html('Edicion de Usuario');
							$('#hid_usuario').val(paramJson[0].cod_usuario);
							$('#hid_rol_act').val(paramJson[0].cod_rol);					
							$('#div_mnt_usuario').show();
							$('#div_btn_bus_usuarios').hide();
							$('#div_bus_usuarios').html('');							
							$('#txt_mnt_usuario').val(paramJson[0].des_usuario);
							$('#txt_mnt_nombres').val(paramJson[0].nombres);
							$('#txt_mnt_apellidos').val(paramJson[0].apellidos);
							$('#sel_mnt_perfil').val(paramJson[0].cod_rol);
							$('#txt_mnt_nombres').prop('disabled', true);
							$('#txt_mnt_apellidos').prop('disabled', true);
							if (paramJson[0].cod_estado = '1') {
								$('#chk_mnt_activo').attr('checked', true);
							} else {
								$('#chk_mnt_activo').attr('checked', false);
							}
							
							endAjax();
							
							$('#div_usuario').modal('show');
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