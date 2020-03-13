<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta charset="utf-8" />
		<title>Mantenimiento de Tipos de Comprobantes</title>

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
							<li class="active">Mantenimiento de Tipos de Comprobantes</li>
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
														<input type="text" id="txt_codigo" class="form-control input-sm " maxlength="7" />
													</div>
												</div>		
															
												<div class="form-group">
													<label class="col-sm-2 control-label label-sm no-padding-right">Descripción:</label>
													<div class="col-sm-4">
														<input type="text" id="txt_nom_comprobante" class="form-control input-sm " maxlength="15" />
													</div>
													
													<div class="col-sm-6">
														<div class="checkbox">
															<label class="input-sm">
																<input type="checkbox" id="chk_activo" class="ace input-sm" checked/>
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
								<div class="table-responsive div_lis_tip_comprobante">
									<table class="table table-striped table-bordered table-hover">
										<thead>
											<tr>
												<th>ID</th>
												<th>Codigo</th>
												<th>Descripción</th>
												<th>Siglas</th>
												<th>Fech. Creación</th>
												<th>Fech. Modificación</th>
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
			
			<div id="div_tip_comprobante" class="modal" tabindex="-1" data-keyboard="false" data-backdrop="static">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">&times;</button>
							<h4 id="h_tip_comprobante" class="white bigger center"></h4>
						</div>
						
						<div class="modal-body">
							<div class="row">
								<div class="col-xs-12">
									<form id="form_tip_comprobante" class="form-horizontal" role="form">
										<div class="form-group">	
											<input type="text" id="txt_mnt_codigo" class="form-control input-sm onlyAmounts hidden" maxlength="15" />																					
										</div>					
										<div class="form-group">																				
											<label class="col-sm-3 control-label input-sm no-padding-right">Codigo:</label>											
											<div class="col-sm-2">
												<input type="text" id="txt_mnt_cod_comprobante" class="form-control input-sm " maxlength="2" />
											</div>											
										</div>										

										<div class="form-group">																				
											<label class="col-sm-3 control-label input-sm no-padding-right">Descripción:</label>											
											<div class="col-sm-9">
												<input type="text" id="txt_mnt_nom_comprobante" class="form-control input-sm"  />
											</div>	
										</div>									
										
										<div class="form-group">																				
											<label class="col-sm-3 control-label input-sm no-padding-right">Antigüedad Permitida:</label>											
											<div class="col-sm-2">
												<input type="number" min="0"  id="txt_mnt_num_mes" class="form-control input-sm onlyAmounts" maxlength="5" />
											</div>																							
											<label class="col-sm-3 control-label input-sm no-padding-right">Siglas:</label>											
											<div class="col-sm-2">
												<input type="text" id="txt_mnt_siglas" class="form-control input-sm" maxlength="5" />
											</div>		
										</div>	
										<div class="form-group">																
											<label class="col-sm-3 control-label input-sm no-padding-right">Nro Ceros Serie:</label>											
											<div class="col-sm-2">
												<input type="number" min="0"  id="txt_mnt_num_serie" class="form-control input-sm onlyAmounts" maxlength="5" />
											</div>	
											<label class="col-sm-3 control-label input-sm no-padding-right">Incluir en Reporte Compras:</label>
											<div class="col-sm-2">
												<div class="checkbox">
													<label class="input-sm">
														<input type="checkbox" class="ace input-sm" id="chk_mnt_compras"/>
														<span class="lbl"> Activo</span>
													</label>
												</div>
											</div>			
												
										</div>	
										<div class="form-group">																	
											<label class="col-sm-3 control-label input-sm no-padding-right">Nro Ceros Comp:</label>											
											<div class="col-sm-2">
												<input type="number" min="0"  id="txt_mnt_num_comprobante" class="form-control input-sm onlyAmounts" maxlength="5" />
											</div>
											<label class="col-sm-3 control-label input-sm no-padding-right">Incluir en Reporte Ventas:</label>
											<div class="col-sm-2">
												<div class="checkbox">
													<label class="input-sm">
														<input type="checkbox" class="ace input-sm" id="chk_mnt_ventas"/>
														<span class="lbl"> Activo</span>
													</label>
												</div>
											</div>
										</div>
										<div class="form-group">
											<div class="col-sm-3"></div>										
											<div class="col-sm-2">
												<div class="checkbox">
													<label class="input-sm">
														<input type="checkbox" class="ace input-sm" id="chk_mnt_activo"/>
														<span class="lbl"> Activo</span>
													</label>
												</div>
											</div>	
											<label class="col-sm-3 control-label input-sm no-padding-right">Incluir en Fact.Elect:</label>
											<div class="col-sm-2">
												<div class="checkbox">
													<label class="input-sm">
														<input type="checkbox" class="ace input-sm" id="chk_mnt_factu"/>
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
				$("#li_mnt_comprobantes").addClass('active');			

				$('#btn_buscar').click(function(e) {					
					e.preventDefault();
					search();
				});
				
				$('#btn_nuevo').click(function(e) {					
					e.preventDefault();
					$('#h_tip_comprobante').html('Registro de Tipos de Comprobantes');
					$('#form_tip_comprobante').trigger("reset");
					$('#div_tip_comprobante').modal('show');
					$('#chk_mnt_activo').attr('checked', true);
				});
				 $('#txt_nom_comprobante').keyup(function() {
				        this.value = this.value.toUpperCase();
				   });
				 $('#txt_mnt_nom_comprobante').keyup(function() {
				        this.value = this.value.toUpperCase();
				   });
				$('#btn_grabar').click(function(e) {					
					e.preventDefault();

					var cod_comprobante = $('#txt_mnt_codigo').val();
					var vcod_comprobante = $('#txt_mnt_cod_comprobante').val();
					var nom_comprobante = $('#txt_mnt_nom_comprobante').val();
					var num_mes = $('#txt_mnt_num_mes').val();
					var num_serie = $('#txt_mnt_num_serie').val();
					var num_comprobante = $('#txt_mnt_num_comprobante').val();
					var siglas = $('#txt_mnt_siglas').val();
					var compras =  'N';
					if ($('#chk_mnt_compras').is(':checked')) {
						compras = 'S';
					}
					var ventas =  'N';
					if ($('#chk_mnt_ventas').is(':checked')) {
						ventas = 'S';
					}
				
					var fla_activo = 'N';
					if ($('#chk_mnt_activo').is(':checked')) {
						fla_activo = 'S';
					}
					
					var fla_factura = 'N';
					if ($('#chk_mnt_factu').is(':checked')) {
						fla_factura = 'S';
					}					
					var msg = '';
					 
					if (esnulo(vcod_comprobante)) {
						msg = msg + 'Campo "Codigo" es Obligatorio.<br/>';
					}
					if (esnulo(nom_comprobante)) {
						msg = msg + 'La Descripcion es Obligatoria.<br/>';
					}
					
					if (!esnulo(msg)) {
						showMessage(msg);
						return;
					}
					var new_record = true;
					if (!esnulo(cod_comprobante)) {
						new_record = false;
					}
													
					$.ajax({
						type: 'POST',
						url: VAR_CONTEXT + '/grabarComprobante',
						data: { 
							cod_comprobante : cod_comprobante,
							vcod_comprobante : vcod_comprobante,
							nom_comprobante : nom_comprobante,
							num_mes : num_mes,
							num_serie : num_serie,
							num_comprobante : num_comprobante,
							siglas : siglas,
							fla_activo : fla_activo,
							ventas : ventas,
							compras : compras,
							fla_factura : fla_factura
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
								$('#div_tip_comprobante').modal('hide');
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
				var href = '/listarComprobante';				
				var fla_activo = 'N';
				if ($('#chk_activo').is(':checked')) {
					fla_activo = 'S';
				}				
				var params = {
					vcod_comprobante : $('#txt_codigo').val(),
					nom_comprobante : $('#txt_nom_comprobante').val(),
					fla_activo : fla_activo
				};
				var fields = [
					'cod_comprobante',
					'vcod_comprobante'
				];
				var layout = [{
					title: 'Item',
					type: 'enum',
					'class': 'center no-sort'
				}, {
					title: 'Codigo',
					field: fields,
					type: 'link',					
					label: '',
					method: 'editar',
				}, {
					title: 'Descripción',
					field: 'nom_comprobante',
				}, {
					title: 'Siglas',
					field: 'siglas',
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
					containerTable: '.div_lis_tip_comprobante',
					idTable: 'tbl_lis_tip_comprobante',
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
					url: '${pageContext.request.contextPath}/listarComprobante',
					data: {
						cod_comprobante : object
					},
					dataType: 'json',
					success: function(paramJson) {						
						//if (paramJson[2] != null) {	
							$('#h_tip_comprobante').html('Edicion de Tipos de Comprobante');
							$('#form_tip_comprobante').trigger("reset");
							$('#txt_mnt_codigo').val(paramJson[0].cod_comprobante);
							$('#txt_mnt_cod_comprobante').val(paramJson[0].vcod_comprobante);	
							$('#txt_mnt_nom_comprobante').val(paramJson[0].nom_comprobante);	
							$('#txt_mnt_num_mes').val(paramJson[0].num_mes);	
							$('#txt_mnt_siglas').val(paramJson[0].siglas);	
							$('#txt_mnt_num_serie').val(paramJson[0].num_serie);	
							$('#txt_mnt_num_comprobante').val(paramJson[0].num_comprobante);	
							if (paramJson[0].fla_activo == 'S') {
								$('#chk_mnt_activo').attr('checked', true);
							} else if (paramJson[0].fla_activo == 'N') {
								$('#chk_mnt_activo').attr('checked', false);
							}
							if (paramJson[0].compras == 'S') {
								$('#chk_mnt_compras').attr('checked', true);
							} else if (paramJson[0].compras == 'N') {
								$('#chk_mnt_compras').attr('checked', false);
							}
							if (paramJson[0].ventas == 'S') {
								$('#chk_mnt_ventas').attr('checked', true);
							} else if (paramJson[0].ventas == 'N') {
								$('#chk_mnt_ventas').attr('checked', false);
							}
							if (paramJson[0].fla_factura == 'S') {
								$('#chk_mnt_factu').attr('checked', true);
							} else if (paramJson[0].fla_factura == 'N' || paramJson[0].fla_factura==null) {
								$('#chk_mnt_factu').attr('checked', false);
							}							
							$('#txt_fec_creacion').val(paramJson[0].mnt_fec_creacion);
							$('#txt_fec_modificacion').val(paramJson[0].mnt_fec_modificacion);
							$('#txt_creacion').val(paramJson[0].mnt_usu_creacion);
							$('#txt_modificado').val(paramJson[0].mnt_usu_modificacion);
							$('#div_tip_comprobante').modal('show');
						//}	
					},
					error: function(jqXHR, error, errorThrown) {
						var msg = 'Error al Editarr:<br/>';
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