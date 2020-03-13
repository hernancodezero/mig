<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta charset="utf-8" />
		<title>Mantenimiento de Tipos de Monedas</title>

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
							<li class="active">Mantenimiento de Tipos de Monedas</li>
						</ul>
					</div>
			
					<div class="page-content">		
						<div class="row">
							<div class="col-xs-12">
								<form class="form-horizontal" role="form">
									
									<fieldset class="fsStyle">
										<legend class="legendStyle">Búsqueda de Información</legend>
											
										<div class="form-group">	
											<div class="col-sm-10">
												<div class="form-group">
													<label class="col-sm-2 control-label label-sm no-padding-right">Codigo:</label>
													<div class="col-sm-2">
														<input type="text" id="txt_codigo" class="form-control input-sm onlyNumbers" maxlength="7" />
													</div>
												</div>		
															
												<div class="form-group">
													<label class="col-sm-2 control-label label-sm no-padding-right">Descripción:</label>
													<div class="col-sm-4">
														<input type="text" id="txt_descripcion" class="form-control input-sm " maxlength="15" />
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
								<div class="table-responsive div_lis_tip_moneda">
									<table class="table table-striped table-bordered table-hover">
										<thead>
											<tr>
												<th>ID</th>
												<th>Codigo</th>
												<th>Tipo de Proveedor</th>
												<th>RUC</th>
												<th>Razón Social</th>
												<th>Apellidos</th>
												<th>Nombre</th>
												<th>Usuario</th>
											</tr>
										</thead>
									</table>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div><!-- /.main-content -->
			
			<div id="div_tip_moneda" class="modal" tabindex="-1" data-keyboard="false" data-backdrop="static">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">&times;</button>
							<h4 id="h_tip_moneda" class="white bigger center"></h4>
						</div>
						
						<div class="modal-body">
							<div class="row">
								<div class="col-xs-12">
									<form id="form_tip_moneda" class="form-horizontal" role="form">
										<div class="form-group">																				
											<label class="col-sm-3 control-label input-sm no-padding-right">Codigo:</label>											
											<div class="col-sm-5">
												<input type="text" id="txt_mnt_codigo" class="form-control input-sm onlyAmounts" disabled />
											</div>											
										</div>										

										<div class="form-group">																				
											<label class="col-sm-3 control-label input-sm no-padding-right">Nombre de Moneda:</label>											
											<div class="col-sm-9">
												<input type="text" id="txt_nom_moneda" class="form-control input-sm" maxlength="50" />
											</div>	
										</div>									
										
										<div class="form-group">																				
											<label class="col-sm-3 control-label input-sm no-padding-right">Siglas:</label>											
											<div class="col-sm-5">
												<input type="text" id="txt_siglas" class="form-control input-sm" maxlength="3" />
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
				$("#li_mnt_tip_moneda").addClass('active');
				$('#chk_activo').attr('checked', true);

				$('#btn_buscar').click(function(e) {					
					e.preventDefault();
					search();
				});
				
				 $('#txt_descripcion').keyup(function() {
				        this.value = this.value.toUpperCase();
				   });
				 $('#txt_nom_moneda').keyup(function() {
				        this.value = this.value.toUpperCase();
				   });
				
				$('#btn_nuevo').click(function(e) {					
					e.preventDefault();
					$('#h_tip_moneda').html('Registro de Tipos de Moneda');
					$('#form_tip_moneda').trigger("reset");
					$('#div_tip_moneda').modal('show');
				});
				
				$('#btn_grabar').click(function(e) {					
					e.preventDefault();
					
					var cod_moneda = $('#txt_mnt_codigo').val();
					var nom_moneda = $('#txt_nom_moneda').val();
					var siglas = $('#txt_siglas').val();
					var fla_activo = 'N';
					if ($('#chk_mnt_activo').is(':checked')) {
						fla_activo = 'S';
					}
					
					var msg = '';
								
					if (esnulo(nom_moneda)) {
						msg = msg + 'Campo "Nombre de Moneda" es Obligatoria.<br/>';
					}
					
					if (!esnulo(msg)) {
						showMessage(msg);
						return;
					}
					
					var new_record = true;
					if (!esnulo(cod_moneda)) {
						new_record = false;
					}
													
					$.ajax({
						type: 'POST',
						url: VAR_CONTEXT + '/grabarTipoMoneda',
						data: { 
							cod_moneda : cod_moneda,
							nom_moneda : nom_moneda,
							siglas : siglas,
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
								$('#div_tip_moneda').modal('hide');
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
				var href = '/listarTipoMoneda';				
				var fla_activo = 'N';
				if ($('#chk_activo').is(':checked')) {
					fla_activo = 'S';
				}				
				var params = {
					cod_moneda : $('#txt_codigo').val(),
					nom_moneda : $('#txt_nom_moneda').val(),
					fla_activo : fla_activo
				};
				var fields = [
					'cod_moneda',
					'cod_moneda'
				];
				var layout = [{
					title: 'Item',
					type: 'enum',
					'class': 'center no-sort'
				}, {
					title: 'Codigo T/M',
					field: fields,
					type: 'link',					
					label: '',
					method: 'editar',
				}, {
					title: 'Tipo de Moneda',
					field: 'nom_moneda',
				}, {
					title: 'Fec. Creacion',
					field: 'mnt_fec_creacion',
				}, {
					title: 'Fec. Modificacion',
					field: 'mnt_fec_modificacion',
				}, {
					title: 'Usuario',
					field: 'mnt_usu_creacion',
				},{
					title: 'Usuario Modificación',
					field: 'mnt_usu_modificacion',
				}];
				var options = {
					containerTable: '.div_lis_tip_moneda',
					idTable: 'tbl_lis_tip_moneda',
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
					url: '${pageContext.request.contextPath}/listarTipoMoneda',
					data: {
						cod_moneda : object
					},
					dataType: 'json',
					success: function(paramJson) {						
						if (paramJson[0] != null) {	
							$('#h_tip_moneda').html('Edicion de Tipos de Moneda');
							$('#form_tip_moneda').trigger("reset");
							$('#txt_mnt_codigo').val(paramJson[0].cod_moneda);
							$('#txt_nom_moneda').val(paramJson[0].nom_moneda);	
							$('#txt_siglas').val(paramJson[0].siglas);
							if (paramJson[0].fla_activo = 'S') {
								$('#chk_mnt_activo').attr('checked', true);
							}
							$('#txt_fec_creacion').val(paramJson[0].mnt_fec_creacion);
							$('#txt_fec_modificacion').val(paramJson[0].mnt_fec_modificacion);
							$('#txt_creacion').val(paramJson[0].mnt_usu_creacion);
							$('#txt_modificado').val(paramJson[0].mnt_usu_modificacion);
							$('#div_tip_moneda').modal('show');
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