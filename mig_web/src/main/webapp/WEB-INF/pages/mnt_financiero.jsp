<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta charset="utf-8" />
		<title>Mantenimiento Financiero</title>

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
							<li class="active">Mantenimiento Financiero</li>
						</ul>
					</div>
			
					<div class="page-content">		
						<div class="row">
							<div class="col-xs-12">
								<form class="form-horizontal" role="form">
									<input type="hidden" id="hid_financiero">
									
									<fieldset class="fsStyle">
										<legend class="legendStyle">Filtros para la Busqueda de Entidades Financieras</legend>
											
										<div class="form-group">	
											<div class="col-sm-10">
												<div class="form-group">
													<label class="col-sm-2 control-label label-sm no-padding-right">Codigo:</label>
													<div class="col-sm-2">
														<input type="text" id="txt_codigo" class="form-control input-sm onlyNumbers" maxlength="2" />
													</div>
												</div>		
															
												<div class="form-group">
													<label class="col-sm-2 control-label label-sm no-padding-right">Nombre Bco:</label>
													<div class="col-sm-4">
														<input type="text" id="txt_nom_bco" class="form-control input-sm " maxlength="30" />
													</div>
													
													<div class="col-sm-6">
														<div class="checkbox">
															<label class="input-sm">
																<input type="checkbox" class="ace input-sm" id="chk_activo" checked />
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
								<fieldset class="fsStyle">
								 <legend class="legendStyle">Listado de Entidades Financieras</legend>
										<div class="table-responsive div_financiero">
											<table class="table table-striped table-bordered table-hover">
												<thead>
													<tr>
														<th>ID</th>
														<th>Codigo E/F</th>
														<th>Entidad Financiera</th>
														<th>Fecha de Creación</th>
														<th>Fecha de Modificación</th>
														<th>Usuarios</th>
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
			
			<div id="div_financiero_modal" class="modal" tabindex="-1" data-keyboard="false" data-backdrop="static">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">&times;</button>
							<h4 id="h_financiero" class="white bigger center"></h4>
						</div>
						
						<div class="modal-body">
							<div class="row">
								<div class="col-xs-12">
									<form id="form_financiero" class="form-horizontal" role="form">
										<div class="form-group">	
											<input type="text" id="txt_mnt_codigo" class="form-control input-sm onlyAmounts hidden" maxlength="15" />																					
										</div>					
										<div class="form-group">																				
											<label class="col-sm-3 control-label input-sm no-padding-right">Codigo:</label>											
											<div class="col-sm-2">
												<input type="text" id="txt_mnt_codigo_entidad" class="form-control input-sm onlyAmounts" maxlength="2" />
											</div>											
										</div>										

										<div class="form-group">																				
											<label class="col-sm-3 control-label input-sm no-padding-right">Nombre Bco:</label>											
											<div class="col-sm-9">
												<input type="text" id="txt_mnt_nom_bco" class="form-control input-sm" maxlength="30" />
											</div>	
										</div>									
										
										<div class="form-group">																				
											<label class="col-sm-3 control-label input-sm no-padding-right">Ruc:</label>											
											<div class="col-sm-5">
												<input type="text" id="txt_mnt_Ruc" class="form-control input-sm onlyAmounts" maxlength="11" />
											</div>
										</div>	
										
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
									
										<div class="form-group">																				
											<label class="col-sm-3 control-label input-sm no-padding-right">Fecha de Creacion:</label>											
											<div class="col-sm-3">
												<input type="text" id="txt_fec_creacion" class="form-control input-sm" disabled />
											</div>	
																													
											<label class="col-sm-3 control-label input-sm no-padding-right">Fecha de Modificacion:</label>											
											<div class="col-sm-3">
												<input type="text" id="txt_fec_modificacion" class="form-control input-sm" disabled  />
											</div>	
										</div>	
										
										<div class="form-group">																				
											<label class="col-sm-3 control-label input-sm no-padding-right">Creación:</label>											
											<div class="col-sm-3">
												<input type="text" id="txt_creacion" class="form-control input-sm"  disabled/>
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
				$("#li_mnt_financieras").addClass('active');			

				$('#btn_buscar').click(function(e) {					
					e.preventDefault();
					search();
				});
				 $('#txt_nom_bco').keyup(function() {
				        this.value = this.value.toUpperCase();
				   });
				 $('#txt_mnt_nom_bco').keyup(function() {
				        this.value = this.value.toUpperCase();
				   });
				
			
				$('#btn_nuevo').click(function(e) {					
					e.preventDefault();
					$('#h_financiero').html('Registro de Entidades Financieras');
					$('#form_financiero').trigger("reset");
					$('#div_financiero_modal').modal('show');
				});
				
				$('#btn_grabar').click(function(e) {					
					e.preventDefault();

					var cod_financiero = $('#txt_mnt_codigo').val();
					var cod_entidad = $('#txt_mnt_codigo_entidad').val();
					var nom_entidad = $('#txt_mnt_nom_bco').val();
					var num_ruc = $('#txt_mnt_Ruc').val();
					var fla_activo = 'N';
					if ($('#chk_mnt_activo').is(':checked')) {
						fla_activo = 'S';
					}
					
					var msg = '';
					 
					if (num_ruc.legnth < 11) {
						msg = msg + 'La RUC no es Valida.<br/>';
					}
					
					if (esnulo(nom_entidad)) {
						msg = msg + 'Ingresar Nombre Bco Obligatorio.<br/>';
					}
					
					if (!esnulo(msg)) {
						showMessage(msg);
						return;
					}
					
					
					var new_record = true;
					if (!esnulo(cod_financiero)) {
						new_record = false;
					}
													
					$.ajax({
						type: 'POST',
						url: VAR_CONTEXT + '/grabarFinanciero',
						data: { 
							cod_financiero : cod_financiero,
							cod_entidad : cod_entidad,
							nom_entidad : nom_entidad,
							num_ruc : num_ruc,
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
								$('#div_financiero_modal').modal('hide');	
								search();
							}	
						},
						error: function(jqXHR, error, errorThrown) {
							var msg = 'Error:<br/>';
							if (jqXHR.status && jqXHR.status == 400) {
								msg = msg + jqXHR.responseText;
							} else {
								msg = msg + errorThrown;								
								if (msg.indexOf("unexpected end of data at line 1 column 1") > 0) {
									addWarnMessage(null, 'El Codigo de Unidad, ya se encuentra registrado.');
									return;
								}								
							}
							addErrorMessage(null, msg);
						}
					});
					
				});
			});
			
						
			function search() {
				var href = '/listarFinanciero';
				var fla_activo = 'N';
				if ($('#chk_activo').is(':checked')) {
					fla_activo = 'S';
				}	
				var params = {
						cod_entidad : $('#txt_codigo').val(),
						nom_entidad : $('#txt_nom_bco').val(),
						fla_activo : fla_activo
				};
				var fields = [
					'cod_financiero', 
					'cod_financiero'
				];
				var layout = [ {
					title: 'ID',
					field: fields,
					type: 'link',					
					label: '',
					method: 'editar',
				}, {
					title: 'Código E/F',
					field: 'cod_entidad',
				}, {
					title: 'Entidad Financiera',
					field: 'nom_entidad',
				}, {
					title: 'Fec. Creación',
					field: 'mnt_fec_creacion',
				}, {
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
					containerTable: '.div_financiero',
					idTable: 'tbl_financiero',
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
			
			//function editar(object) {				
			//	var url = '${pageContext.request.contextPath}/mnt_com_ingresos/'+object;
			//	$(location).attr('href', url);
			//}
			function editar(object) {				
				$.ajax({
					type: 'GET',
					url: '${pageContext.request.contextPath}/listarFinanciero',
					data: {
						cod_financiero : object
					},
					dataType: 'json',
					success: function(paramJson) {						
						if (paramJson[0] != null) {	
							$('#h_financiero').html('Edicion de Entidades Financieras');
							$('#form_financiero').trigger("reset");
							$('#txt_mnt_codigo').val(paramJson[0].cod_financiero);
							$('#txt_mnt_codigo_entidad').val(paramJson[0].cod_entidad);
							$('#txt_mnt_nom_bco').val(paramJson[0].nom_entidad);	
							$('#txt_mnt_Ruc').val(paramJson[0].num_ruc);
							if (paramJson[0].fla_activo == 'S') {
								$('#chk_mnt_activo').attr('checked', true);
							} else {
								$('#chk_mnt_activo').attr('checked', false);
							}
							$('#txt_fec_creacion').val(paramJson[0].mnt_fec_creacion);
							$('#txt_fec_modificacion').val(paramJson[0].mnt_fec_modificacion);
							$('#txt_creacion').val(paramJson[0].mnt_usu_creacion);
							$('#txt_modificado').val(paramJson[0].mnt_usu_modificacion);
							$('#div_financiero_modal').modal('show');
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
