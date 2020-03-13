<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta charset="utf-8" />
		<title>Mantenimiento de Series y Numeros de C/P</title>

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
								Mantenimiento de Series y Numeros de C/P
							</li>
							<li class="active">Mantenimiento de Series y Numeros</li>
						</ul>
					</div>
			
					<div class="page-content">		
						<div class="row">
							<div class="col-xs-12">
								<form class="form-horizontal" role="form">
									<input type="hidden" id="hid_financiero">
									
									<fieldset class="fsStyle">
										<legend class="legendStyle">Filtros para la Busqueda de Series y Numeros de C/P</legend>
											
										<div class="form-group">	
											<div class="col-sm-10">
												<div class="form-group">
													<div class="form-group">	
														<input type="text" id="txt_mnt_codigo" class="form-control input-sm onlyAmounts hidden" maxlength="15" />																					
													</div>														
													<label class="col-sm-2 control-label label-sm no-padding-right">Unidad Operativa:</label>
													<div class="col-sm-2">
														<select id="sel_uni_operativa" class="form-control input-sm">
																<option>Seleccionar</option>
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
													<label class="col-sm-2 control-label label-sm no-padding-right">Tipo de Comprobante:</label>
													<div class="col-sm-2">
														<select id="sel_tip_comprobante" class="chosen-select form-control input-sm">
															<option value="">(Seleccione)</option>
															<c:forEach items="${lis_tip_comprobante}" var="item">
															    <option value="${item.cod_comprobante}">${item.nom_comprobante}</option>
															</c:forEach>
														</select>
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
										<div class="table-responsive div_tari_boleto">
											<table class="table table-striped table-bordered table-hover">
												<thead>
													<tr>
														<th>ID</th>
														<th>Tipo Tarifa</th>
														<th>Nombre de Boleto</th>
														<th>Nro de Serie</th>
														<th>Precio Unitario</th>
														<th>Fecha de Creación</th>
														<th>Fecha de Modificación</th>
														<th>Usuarios</th>
														<th>Usuario Modifica</th>
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
			
			<div id="div_tari_boleto_modal" class="modal" tabindex="-1" data-keyboard="false" data-backdrop="static">
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
											<div class="form-group">	
												<input type="text" id="txt_mnt_codigo" class="form-control input-sm onlyAmounts hidden" maxlength="15" />																					
											</div>																		
											<label class="col-sm-3 control-label label-sm no-padding-right">Unidad Operativa:</label>
											<div class="col-sm-4">
												<select id="sel_mnt_uni_dest" class="form-control input-sm">
															<option>Seleccionar</option>
													<c:forEach items="${lis_uni_operativa}" var="item">
														    <option value="${item.cod_uni_operativa}">${item.des_uni_operativa}</option>
													</c:forEach>
												</select>
											</div>
										</div>										
										<div class="form-group">	
											<label class="col-sm-3 control-label label-sm no-padding-right">ANP:</label>
											<div class="col-sm-4">
												<select id="sel_mnt_anp" class="form-control input-sm">
												</select>
											</div>												
										</div>
										<div class="form-group">	
											<label class="col-sm-3 control-label label-sm no-padding-right">Tipo de C/P:</label>
											<div class="col-sm-4">
												<select id="sel_mnt_cp" class="form-control input-sm">
															<option>Seleccionar</option>
													<c:forEach items="${lis_tip_comprobante}" var="item">
														    <option value="${item.cod_comprobante}">${item.nom_comprobante}</option>
													</c:forEach>
												</select>												
											</div>
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
											<label class="col-sm-2 control-label input-sm no-padding-right">Cod.Sunat:</label>											
											<div class="col-sm-2">
												<input type="text" id="txt_mnt_sunat" class="form-control input-sm"  />
											</div>
											<label class="col-sm-2 control-label input-sm no-padding-right">Nro Serie</label>											
											<div class="col-sm-2">
												<input type="text" id="txt_mnt_serie" class="form-control input-sm"   />
											</div>
											<label class="col-sm-2 control-label input-sm no-padding-right">Nro C/P:</label>											
											<div class="col-sm-2">
												<input type="text" id="txt_mnt_cp" class="form-control input-sm"  />
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
			 	
				$('#sel_uni_operativa').on('change', function() {
					obtenerAnp($(this).val());
				});
				
				$('#btn_buscar').click(function(e) {					
					e.preventDefault();
					search();
				});
				obtenerAnpMnt($('#sel_mnt_uni_dest').val());
				$('#sel_mnt_uni_dest').on('change', function() {
					obtenerAnpMnt($(this).val());
				});
			
				$('#btn_nuevo').click(function(e) {					
					e.preventDefault();
					$('#h_financiero').html('Registro de Tarifa de Boletos');
					$('#form_financiero').trigger("reset");
					$('#chk_mnt_activo').attr('checked', true);
					$('#div_tari_boleto_modal').modal('show');
				});
				
				$('#btn_grabar').click(function(e) {					
					e.preventDefault();
					var cod_serie = $('#txt_mnt_codigo').val();
					var cod_uni_operativa = $('#sel_mnt_uni_dest').val();
					var cod_reg_nac= $('#sel_mnt_anp').val();
					var cod_comprobante= $('#sel_mnt_cp').val();
					var cod_sunat = $('#txt_mnt_sunat').val();
					var num_serie= $('#txt_mnt_serie').val();
					var num_cp= $('#txt_mnt_cp').val();

					var fla_activo = 'S';
					//var fla_activo = 'S';
					if ($('#chk_mnt_activo').is(':checked')) {
						fla_activo = 'S';
						//fla_activo = 'N';
					}
					
					var new_record = true;
					if (!esnulo(cod_serie)) {
						new_record = false;
					}
										
					$.ajax({
						type: 'POST',
						url: VAR_CONTEXT + '/grabarseries',
						data: { 
							cod_serie : cod_serie,
							cod_uni_operativa : cod_uni_operativa,
							cod_reg_nac : cod_reg_nac,
							cod_comprobante : cod_comprobante,
							cod_sunat : cod_sunat,
							num_serie : num_serie,
							num_cp : num_cp

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
								$('#div_tari_boleto_modal').modal('hide');	
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
				var href = '/listarSerie';
				var fla_activo = 'N';
				if ($('#chk_activo').is(':checked')) {
					fla_activo = 'S';
				}	
				var params = {
						cod_serie         : $('#txt_mnt_codigo').val(),
						cod_uni_operativa : $('#sel_uni_operativa').val(),
						cod_reg_nac       : $('#sel_anp').val(),
						cod_comprobante   : $('#sel_tip_comprobante').val(),
						fla_activo        : fla_activo
				};
				
				var fields = [
					'cod_serie', 
					'cod_serie'
				];
				var layout = [ {
					title: 'ID',
					field: fields,
					type: 'link',					
					label: '',
					method: 'editar',
					
				}, {
					title: 'Unidad Operativa',
					field: 'des_uni_operativa',
					'class': 'no-sort'
				}, {
					title: 'ANP',
					field: 'des_reg_nac',
					'class': 'no-sort'
				}, {
					title: 'Comprobante',
					field: 'nom_cp',
					'class': 'no-sort'
				},{
					title: 'Cod. Sunat',
					field: 'cod_sunat',
					'class': 'no-sort'
				},{
					title: 'Num. Serie',
					field: 'num_serie',	
					'class': 'no-sort'
				},{
					title: 'Num. C/P',
					field: 'num_cp',					
					'class': 'no-sort'
				},{
					title: 'Fec. Creación',
					field: 'mnt_fec_creacion',
					'class': 'no-sort'
				}, {
					title: 'Fec. Modificación',
					field: 'mnt_fec_modificacion',
					'class': 'no-sort'
				}, {
					title: 'Usuario',
					field: 'mnt_usu_creacion',
					'class': 'no-sort' 
				}, {
					title: 'Usuario Modificación',
					field: 'mnt_usu_modificacion',
					'class': 'no-sort' 
				}];
				var options = {
					containerTable: '.div_tari_boleto',
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
					url: '${pageContext.request.contextPath}/listarSerie',
					data: {
						cod_serie : object
					},
					dataType: 'json',
					success: function(paramJson) {						
						if (paramJson[0] != null) {	
							$('#h_financiero').html('Edicion de Serie y Numero');
							$('#form_financiero').trigger("reset");
							$('#txt_mnt_codigo').val(paramJson[0].cod_serie);
							$('#sel_mnt_uni_dest').val(paramJson[0].cod_uni_operativa);
							$('#sel_mnt_anp').val(paramJson[0].cod_reg_nac);
							$('#sel_mnt_cp').val(paramJson[0].cod_comprobante);							
							$('#txt_mnt_sunat').val(paramJson[0].cod_sunat);
							$('#txt_mnt_serie').val(paramJson[0].num_serie);
							$('#txt_mnt_cp').val(paramJson[0].num_cp);

							
							if (paramJson[0].fla_activo == 'S') {
								$('#chk_mnt_activo').attr('checked', true);
							} else {
								$('#chk_mnt_activo').attr('checked', false);
							}
							$('#txt_fec_creacion').val(paramJson[0].mnt_fec_creacion);
							$('#txt_fec_modificacion').val(paramJson[0].mnt_fec_modificacion);
							$('#txt_creacion').val(paramJson[0].mnt_usu_creacion);
							$('#txt_modificado').val(paramJson[0].mnt_usu_modificacion);
							$('#div_tari_boleto_modal').modal('show');
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
			
			function obtenerAnp(cod_uni_operativa) {
				var params = new Object();
 				params['ind_uni_operativa'] = 1;
 				params['cod_uni_operativa'] = cod_uni_operativa;
 				simpleCboAjaxPopulateParam('#sel_anp', ['cod_reg_nac', 'des_reg_nac'], '/listarUnidadOperativa', params, true, false);
			}
			
			function obtenerAnpMnt(cod_uni_operativa) {
				var params = new Object();
 				params['ind_uni_operativa'] = 1;
 				params['cod_uni_operativa'] = cod_uni_operativa;
 				simpleCboAjaxPopulateParam('#sel_mnt_anp', ['cod_reg_nac', 'des_reg_nac'], '/listarUnidadOperativa', params, true, false);
			}

		</script>
		
	</body>
</html>
