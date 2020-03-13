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
							<li class="active">Generación de Perfiles</li>
						</ul>
					</div>
			
					<div class="page-content">		
						<div class="row">
							<div class="col-xs-12">
								<form class="form-horizontal" role="form">
									
									<fieldset class="fsStyle">
										<legend class="legendStyle">Búsqueda de Información de Perfiles</legend>
											
										<div class="form-group">	
											<div class="col-sm-10">
												<div class="form-group">
													<label class="col-sm-3 control-label label-sm no-padding-right">Nombre del Perfil:</label>
													<div class="col-sm-3">
														<input type="text" id="txt_nom_perfil" class="form-control input-sm upperValue" maxlength="50" />
													</div>
													
													<div class="col-sm-6">
														<div class="checkbox">
															<label class="input-sm">
																<input type="checkbox" id="chk_activo" class="ace input-sm" />
																<span class="lbl"> Activo</span>
															</label>
														</div>
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
								<div class="table-responsive div_lis_perfil">
									<table class="table table-striped table-bordered table-hover">
										<thead>
											<tr>
												<th>ID</th>
												<th>Perfil</th>
												<th>Sistema</th>
											</tr>
										</thead>
									</table>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div><!-- /.main-content -->
			
			<div id="div_perfil" class="modal" tabindex="-1" data-keyboard="false" data-backdrop="static">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">&times;</button>
							<h4 id="h_perfil" class="white bigger center"></h4>
						</div>
						
						<div class="modal-body">
							<div class="row">
								<div class="col-xs-12">
									<form id="form_perfil" class="form-horizontal" role="form">
										<input type="hidden" id="hid_perfil">
									
										<div class="form-group">																				
											<label class="col-sm-3 control-label input-sm no-padding-right">Nombre de Perfil:</label>											
											<div class="col-sm-9">
												<input type="text" id="txt_mnt_perfil" class="form-control input-sm" maxlength="50" />
											</div>	
										</div>									
										
										<div class="well well-lg">
											<h4 class="blue">Opciones de Menú</h4>
											
											<br>
										
											<div id="div_det_menu">
			
											</div>
										</div>

										<br>
										
										<div class="form-group">
											<div class="col-sm-3"></div>										
											<div class="col-sm-5">
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
		
			var arr_pri_modulo = [];
			var arr_seg_modulo = [];
			
			<c:forEach items="${lis_pri_modulo}" var="item">
		    	arr_pri_modulo.push('${item.cod_modulo}_${item.nom_modulo}'); 
			</c:forEach>
			
			<c:forEach items="${lis_seg_modulo}" var="item">
				arr_seg_modulo.push('${item.cod_modulo}_${item.niv_dep_modulo}_${item.nom_modulo}'); 
			</c:forEach>
		
		
			$(document).ready(function() {
				
				$("#li_seguridad").addClass('active');
				$("#li_mnt_perfiles").addClass('active');
				
				$('#chk_activo').attr('checked', true);

				$('#btn_buscar').click(function(e) {					
					e.preventDefault();
					search();
				});
				
				$('#btn_nuevo').click(function(e) {					
					e.preventDefault();
					$('#h_perfil').html('Registro de Nuevo Perfil');
					$('#txt_mnt_perfil').val('');
					$('#hid_perfil').val('');
					$('#chk_mnt_activo').attr('checked', true);
					
					startAjax();
					
					$('#div_det_menu').jstree('destroy').empty();
					
					var arr_datos_pri = [];
					for (var i=0; i < arr_pri_modulo.length; i++) {
						var fie_pri = arr_pri_modulo[i].split('_');					
						var param_pri = {};
						param_pri['id'] = fie_pri[0];
						param_pri['text'] = fie_pri[1];
						
						var arr_datos_seg = [];
						for (var k=0; k < arr_seg_modulo.length; k++) {
							var fie_seg = arr_seg_modulo[k].split('_');					
							if (fie_seg[1] == fie_pri[0]) {
								var param_seg = {};
								param_seg['id'] = fie_seg[0]+'_'+fie_seg[1];
								param_seg['text'] = fie_seg[2];
								param_seg['icon'] = 'jstree-file';												
								arr_datos_seg.push(param_seg);								
							}
						}
						param_pri['children'] = arr_datos_seg;
						arr_datos_pri.push(param_pri);
					}
					
					$('#div_det_menu').jstree({
						'core' : {
							'data' : arr_datos_pri
						},
						"checkbox" : {
						  "keep_selected_style" : false
						},
						"plugins" : [ "checkbox" ]
					});
					
					endAjax();					
					
					$('#div_perfil').modal('show');
				});
				
				$('#btn_grabar').click(function(e) {					
					e.preventDefault();
					
					var cod_rol = $('#hid_perfil').val();
					var nom_perfil = $('#txt_mnt_perfil').val();
					var fla_activo = '0';
					if ($('#chk_mnt_activo').is(':checked')) {
						fla_activo = '1';
					}
					var val_det_menu = $('#div_det_menu').jstree('get_checked');					
					if (val_det_menu.length == 0) {
						addWarnMessage(null, 'Debe de seleccionar al menos una opción del menú.');
						return;
					}
					
					if (esnulo(nom_perfil)) {
						addWarnMessage(null, 'El campo "Nombre de Perfil" es obligatorio.');
						return;
					}
					
					startAjax();
					
					var cod_men_asociado = '';
					$.each(val_det_menu, function(index, value) { 
						cod_men_asociado = cod_men_asociado + value + '|';
					});
					if (!esnulo(cod_men_asociado)) {
						var tamanio = cod_men_asociado.length;
						cod_men_asociado = cod_men_asociado.substring(0, tamanio - 1);
					}					

					var new_record = true;
					if (!esnulo(cod_rol)) {
						new_record = false;
					}
													
					$.ajax({
						type: 'POST',
						url: VAR_CONTEXT + '/grabarPerfil',
						data: { 
							cod_rol : cod_rol,
							des_rol : nom_perfil,
							det_menu : cod_men_asociado,
							fla_rol : fla_activo
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
								$('#div_perfil').modal('hide');
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
				var href = '/listarPerfiles';				
				var fla_activo = '0';
				if ($('#chk_activo').is(':checked')) {
					fla_activo = '1';
				}				
				var params = {
					des_rol : $.trim($('#txt_nom_perfil').val()),
					fla_rol : fla_activo
				};
				var fields = [
					'cod_rol',
					'cod_rol'
				];
				var layout = [{
					title: 'ID',
					field: fields,
					type: 'link',					
					label: '',
					method: 'editar',
					'class': 'no-sort',
				}, {
					title: 'Perfil',
					field: 'des_rol',
					'class': 'no-sort'
				}, {
					title: 'Sistema',
					field: 'des_sistema',
					'class': 'no-sort'
				}];
				var options = {
					containerTable: '.div_lis_perfil',
					idTable: 'tbl_lis_perfil',
					styleTable: '.util1200Rw',
					loading: true,
					parameters: params,
					vTableOptions: {
						bFilter: false,
						paging: false,
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
				
				$('#div_det_menu').jstree('destroy').empty();
				
				var fla_activo = '0';
				if ($('#chk_activo').is(':checked')) {
					fla_activo = '1';
				}
				$.ajax({
					type: 'GET',
					url: '${pageContext.request.contextPath}/listarPerfiles',
					data: {
						cod_rol : object,
						fla_rol : fla_activo
					},
					dataType: 'json',
					success: function(paramJson) {						
						if (paramJson[0] != null) {										
							$.ajax({
								type: 'GET',
								url: '${pageContext.request.contextPath}/listarModulo',
								data: {
									cod_rol : object,
									niv_modulo : 3, // Segundo nivel
									fla_rol_mod : 1 // Estado Activo
								},
								dataType: 'json',
								success: function(paramJsonSeg) {

									$('#h_perfil').html('Edicion de Perfil');
									$('#hid_perfil').val(paramJson[0].cod_rol);
									$('#txt_mnt_perfil').val(paramJson[0].des_rol);
									if (paramJson[0].fla_rol = '1') {
										$('#chk_mnt_activo').attr('checked', true);
									} else {
										$('#chk_mnt_activo').attr('checked', false);
									}
									
									var arr_datos_pri = [];
									for (var i=0; i < arr_pri_modulo.length; i++) {
										var fie_pri = arr_pri_modulo[i].split('_');					
										var param_pri = {};
										param_pri['id'] = fie_pri[0];
										param_pri['text'] = fie_pri[1];
										
										var arr_datos_seg = [];
										for (var k=0; k < arr_seg_modulo.length; k++) {
											var fie_seg = arr_seg_modulo[k].split('_');					
											if (fie_seg[1] == fie_pri[0]) {
												var param_seg = {};
												param_seg['id'] = fie_seg[0]+'_'+fie_seg[1];
												param_seg['text'] = fie_seg[2];
												param_seg['icon'] = 'jstree-file';

												$.each(paramJsonSeg, function(index_seg, item_seg) {
													if (item_seg.cod_modulo == fie_seg[0]) {
														var param_state = {};
														param_state['selected'] = true;
														param_seg['state'] = param_state;
													}
												});

												arr_datos_seg.push(param_seg);								
											}
										}
										param_pri['children'] = arr_datos_seg;
										arr_datos_pri.push(param_pri);
									}
									
									$('#div_det_menu').jstree({
										'core' : {
											'data' : arr_datos_pri
										},
										"checkbox" : {
										  "keep_selected_style" : false
										},
										"plugins" : [ "checkbox" ]
									});
									
									endAjax();
									
									$('#div_perfil').modal('show');

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
			}

		</script>
		
	</body>
</html>