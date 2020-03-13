<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta charset="utf-8" />
		<title>Mantenimiento de Cierre de Mes</title>

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
							<li class="active">Mantenimiento de Cierre de Mes</li>
						</ul>
					</div>
			
					<div class="page-content">		
						<div class="row">
							<div class="col-xs-12">
								<form class="form-horizontal" role="form">
									
									<fieldset class="fsStyle">
										<legend class="legendStyle">Filtros para la Búsqueda de Información cierre</legend>
											
										<div class="form-group">	
											<div class="col-sm-10">												
												<label class="col-sm-2 control-label label-sm no-padding-right">U.O. Solicitante:</label>
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
													<option>Seleccionar</option>
													</select>
												</div>
											
												<div class="col-sm-2">
													<div class="checkbox">
														<label class="input-sm">
															<input type="checkbox" id="chk_activo" class="ace input-sm" />
															<span class="lbl"> Activo</span>
														</label>
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
											</div>											
										</div>	
										

										<div class="form-group">		
											<div class="col-sm-10">		
												<label class="col-sm-2 control-label label-sm no-padding-right">Periodo:</label>
												<div class="col-sm-2">
														<select id="sel_anno" class="form-control input-sm">
															<option value="">Seleccione</option>
															<script>
															var myDate = new Date();
															var year = myDate.getFullYear();
															var anno =2016;
															for(var i = year; i >= anno+1; i--){
																document.write('<option value="'+i+'">'+i+'</option>');
															}
															</script>	
														</select>	
												</div>
												<label class="col-sm-2 control-label label-sm no-padding-right">Mes:</label>
												<div class="col-sm-2">
													<select id="sel_mes" class="form-control input-sm">
														<option value="">Seleccione</option>
														<option value="1">Enero</option>
														<option value="2">Febrero</option>
														<option value="3">Marzo</option>
														<option value="4">Abril</option>
														<option value="5">Mayo</option>
														<option value="6">Junio</option>
														<option value="7">Julio</option>
														<option value="8">Agosto</option>
														<option value="9">Setiembre</option>
														<option value="10">Octubre</option>
														<option value="11">Noviembre</option>
														<option value="12">Diciembre</option>
													</select>
												</div>												
											</div>
											
											<div class="col-sm-2">
												<div class="form-group">	
													<div class="col-sm-12">
														<button id="btn_nuevo" class="btn btn-sm btn-success" type="button">
															<i class="ace-icon fa fa-plus-square"></i>
																Nuevo.
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
						       <legend class="legendStyle">Lista de la Información de Cierres de Mes</legend>
								<div class="table-responsive div_lis_cierre_mes">
									<table class="table table-striped table-bordered table-hover">
										<thead>
											<tr>
												<th>ID</th>
												<th>Año</th>
												<th>Mes</th>
												<th>Fecha Cierre</th>
												<th>Fecha Descierre</th>
												<th>ANP</th>
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
			
			<div id="div_cierre_mes" class="modal" tabindex="-1" data-keyboard="false" data-backdrop="static">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">&times;</button>
							<h4 id="h_cierre_mes" class="white bigger center"></h4>
						</div>
						<div class="modal-body">
							<div class="row">
								<div class="col-xs-12">
									<form id="form_cierre_mes" class="form-horizontal" role="form">
										<div class="form-group">		
											<div class="form-group">	
												<input type="text" id="txt_mnt_codigo" class="form-control input-sm onlyAmounts hidden" maxlength="15" />	
												<input type="text" id="txt_fecha_cierre_inicio" class="form-control hidden" maxlength="15" />
												<input type="text" id="txt_fecha_cierre_actual" class="form-control hidden" maxlength="15" text="${dte_actual}" />
											</div>																		
											<label class="col-sm-3 control-label label-sm no-padding-right">Unidad Operativa:</label>
											<div class="col-sm-3">
												<select id="sel_mnt_uni_dest" class="form-control input-sm">
															<option>Seleccionar</option>
													<c:forEach items="${lis_uni_operativa}" var="item">
														    <option value="${item.cod_uni_operativa}">${item.des_uni_operativa}</option>
													</c:forEach>
												</select>
											</div>
												<label class="col-sm-2 control-label label-sm no-padding-right">ANP:</label>
												<div class="col-sm-4">
													<select id="sel_mnt_anp" class="form-control input-sm">
														<option value="">Seleccione</option>
													</select>
												</div>
										</div>										
										<div class="form-group">	

										</div>

										<fieldset class="fsStyle">
											<legend class="legendStyle">Seccion del Cierre</legend>
												
												<div class="form-group col-sm-12">
													<div class="col-sm-6">
														<div class="checkbox">
															<label class="input-sm">
															<input type="checkbox" id="chk_mnt_cerrar_todas" class="ace input-sm" />
																<span class="lbl"> Cerrar todas las unidades operativas</span>
															</label>
														</div>
													</div>
				
													<div class="col-sm-4">
														<div class="checkbox">
															<label class="input-sm">
															<input type="checkbox" id="chk_mnt_activo" class="ace input-sm" />
																<span class="lbl"> Mes Activo</span>
															</label>
														</div>
													</div>
												</div>			
												&nbsp;
				
												<div class="form-group">
													<label class="col-sm-2 control-label label-sm no-padding-right">Fecha Cierre:</label>
													<div class="col-sm-3">
														<div class="input-group">
															<input class="form-control input-sm date-picker " id="txt_mnt_fec_cierre" type="text" placeholder="dd/mm/yyyy" pattern="\d{1,2}/\d{1,2}/\d{4}" maxlength="10"/>
															<span class="input-group-addon" id="sp_ico_fec_cierre">
																<i class="fa fa-calendar bigger-110"></i>
															</span>
														</div>	
													</div>							
													<label class="col-sm-1 control-label label-sm no-padding-right">Mes:</label>
													<div class="col-sm-2">
														<input type="number" id="txt_mes" class="form-control input-sm onlyNumbers" maxlength="2" min = "1" max = "12"/>
													</div>
																									
													<label class="col-sm-1 control-label label-sm no-padding-right">Año:</label>
													<div class="col-sm-2">
														<input type="number" id="txt_anio" class="form-control input-sm onlyNumbers" maxlength="4" min = "2016"/>
													</div>															
												</div>	
				
												<label class="col-sm-2 control-label label-sm no-padding-right">Indicadores de Cierres :</label>
												<div class="form-group">									
													<div class="col-sm-4">
														<div class="checkbox">
															<label class="input-sm">
															<input type="checkbox" id="chk_mnt_compra" class="ace input-sm" />
															<span class="lbl"> Compras</span>
															</label>
														</div>
													</div>
													<div class="col-sm-4">
														<div class="checkbox">
															<label class="input-sm">
															<input type="checkbox" id="chk_mnt_venta" class="ace input-sm" />
																<span class="lbl"> Ventas</span>
															</label>
														</div>
													</div>
												</div>
				
												
										</fieldset>
										<fieldset class="fsStyle">
											<legend class="legendStyle">Seccion de Re-Apertura</legend>
											<div class="form-group">
												<label class="col-sm-3 control-label label-sm no-padding-right">Fecha Compras :</label>
												<div class="col-sm-4">
													<div class="input-group">
														<input class="form-control input-sm date-picker " id="txt_mnt_fec_descierre" type="text" placeholder="dd/mm/yyyy" pattern="\d{1,2}/\d{1,2}/\d{4}" maxlength="10"/>
														<span class="input-group-addon" id="sp_ico_fec_descierre" >
															<i class="fa fa-calendar bigger-110"></i>
														</span>
													</div>
												</div>											
												<div class="col-sm-5">
													<div class="checkbox">
														<label class="input-sm">
															<input type="checkbox" id="chk_ap_activo" class="ace input-sm" />
															<span class="lbl"> Apert.Compras</span>
														</label>
													</div>
												</div>											
											</div>
											<div class="form-group">
												<label class="col-sm-3 control-label label-sm no-padding-right">Fecha Ventas :</label>
												<div class="col-sm-4">
													<div class="input-group">
														<input class="form-control input-sm date-picker " id="txt_mnt_fec_descierre_vta" type="text" placeholder="dd/mm/yyyy" pattern="\d{1,2}/\d{1,2}/\d{4}" maxlength="10"/>
														<span class="input-group-addon" id="sp_ico_fec_descierre_vta" >
															<i class="fa fa-calendar bigger-110"></i>
														</span>
													</div>
												</div>											
												<div class="col-sm-5">
													<div class="checkbox">
														<label class="input-sm">
															<input type="checkbox" id="chk_ap_activo_vta" class="ace input-sm" />
															<span class="lbl"> Apert.Ventas</span>
														</label>
													</div>
												</div>											
											</div>												
										</fieldset>
								
										<fieldset class="fsStyle">
											<legend class="legendStyle">Seccion de Auditoria</legend>
											<div class="form-group">																				
												<label class="col-sm-3 control-label input-sm no-padding-right">Fecha de Creacion:</label>											
												<div class="col-sm-3">
													<input type="text" id="txt_fec_creacion" class="form-control input-sm " disabled />
												</div>	
																																	
												<label class="col-sm-3 control-label input-sm no-padding-right">Fecha Modificacion: </label>											
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
										</fieldset>
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
				$("#li_mnt_cie_mes").addClass('active');			
				$('#chk_activo').attr('checked', true);
				obtenerAnp($('#sel_uni_operativa').val());
				obtenerAnpMnt($('#sel_mnt_uni_dest').val());
		
				$('#btn_buscar').click(function(e) {					
					e.preventDefault();
					search();
				});
				
				$('#sel_uni_operativa').on('change', function() {
					if (!esnulo($(this).val())) {
						obtenerAnp($(this).val());
					} else {
						$('#sel_anp').empty();
					}
				});	
				
				$('#sel_mnt_uni_dest').on('change', function() {
					if (!esnulo($(this).val())) {
						obtenerAnpMnt($(this).val());
					} else {
						$('#sel_mnt_anp').empty();
					}
				});	
				
				$('.date-picker').datepicker({
					autoclose: true,
					todayHighlight: true
				});
				
				$('.input-group-addon').click(function(event){
					event.preventDefault();
					var id_sp = $(this).attr('id').substring(7);
					$('#txt_mnt_'+id_sp).datepicker('show');
				});
				
				$('#chk_mnt_cerrar_todas').change(function() {
				    if(this.checked) {
				    //	$('#sel_mnt_anp').prop('selectedIndex', 0);	
				        $("#sel_mnt_anp").prop("disabled", true);		
					//	$('#sel_mnt_uni_dest').prop('selectedIndex', 0);
					    $("#sel_mnt_uni_dest").prop("disabled", true);
				    } else {
				        $("#sel_mnt_anp").prop("disabled", false);		
					    $("#sel_mnt_uni_dest").prop("disabled", false);				    	
				    }
				});
				$('#chk_ap_activo').change(function() {
				    if(this.checked) {
				  	$("#txt_mnt_fec_descierre").val('${dte_actual}');
				    } else {
				    $("#txt_mnt_fec_descierre").val('');
				    }
				});
				$('#chk_ap_activo_vta').change(function() {
				    if(this.checked) {
				  	$("#txt_mnt_fec_descierre_vta").val('${dte_actual}');
				    } else {
				    $("#txt_mnt_fec_descierre_vta").val('');
				    }
				});				
				$('#txt_mnt_fec_descierre').change(function() {
				    if ($('#txt_mnt_fec_descierre').val()!='') {
				    	$('#chk_ap_activo').attr('checked', true);
				    } else {
				    	$('#chk_ap_activo').attr('checked', false);			    	
				    }
				});
				$('#btn_nuevo').click(function(e) {					
					e.preventDefault();
					$('#chk_mnt_activo').attr('checked', true);
					$('#chk_ap_activo').attr('checked', false);
				    $("#chk_ap_activo").prop("disabled", true);	
					$('#chk_ap_activo_vta').attr('checked', false);
				    $("#chk_ap_activo_vta").prop("disabled", true);					    
				    $("#chk_mnt_cerrar_todas").prop("disabled", false);	
				    $("#txt_mnt_fec_descierre").prop("disabled", true);	     //Apertura Compras
				    $("#txt_mnt_fec_descierre_vta").prop("disabled", true);	 //Apertura Ventas
				    
					$('#sel_mnt_anp').empty();
					$("#sel_mnt_anp").append($("<option></option>").html("Seleccionar"));
					$('#h_cierre_mes').html('Registro de Cierre de Mes');
					$('#form_cierre_mes').trigger("reset");
					$('#div_cierre_mes').modal('show');
					
					$('#txt_fecha_cierre_inicio').val('');
					$('#txt_fecha_cierre_venta').val('');
					
					//$("#txt_mnt_descierre").datepicker();
					//$("#txt_mnt_fec_cierre").datepicker();
			        $("#sel_mnt_anp").prop("disabled", false);		
				    $("#sel_mnt_uni_dest").prop("disabled", false);		
				});
				
				$('#btn_grabar').click(function(e) {					
					e.preventDefault();
					var cod_mes = $('#txt_mnt_codigo').val();
					var anio = $('#txt_anio').val();	
					var mes = $('#txt_mes').val();
					var cod_uni_operativa = $('#sel_mnt_uni_dest').val();
					var cod_reg_nac= $('#sel_mnt_anp').val();
					var fec_cierre = $('#txt_mnt_fec_cierre').val();  //Fecha de Cierre
					var fec_apertura;
					var fec_des_cierre = $('#txt_mnt_fec_descierre').val();  //Apertura Compras
					var fec_des_cierre_vta = $('#txt_mnt_fec_descierre_vta').val(); //Apertura Ventas
					var fec_actual = '${dte_actual}';

					var mes_activo = 'N';
					if ($('#chk_mnt_activo').is(':checked')) {
						mes_activo = 'S';
					}
					var tip_compra = 0;
					if ($('#chk_mnt_compra').is(':checked')) {
						tip_compra = 1;
					}
					var tip_venta = 0;
					if ($('#chk_mnt_venta').is(':checked')) {
						tip_venta = 2;
					}
					var msg = '';
					if (esnulo(anio)) {
						msg = msg + 'El campo "Año" es obligatorio.<br/>';
					}
					if (esnulo(mes)) {
						msg = msg + 'El campo "Mes" es obligatorio.<br/>';
					}
					var fecha_cierre_inicio = $('#txt_fecha_cierre_inicio').val();
					if (fecha_cierre_inicio != '' && fec_cierre=='') {
						msg = msg + 'El campo "Fecha de cierre" ya tenía datos. No puede ser borrado.<br/>';						
					}
					var fla_apertura = 'N';   //Indicador de Apertura Compras
					if ($('#chk_ap_activo').is(':checked')) {
						fla_apertura = 'S';
					}
					var fla_apertura_vta = 'N'; //Indicador de Apertura Ventas
					if ($('#chk_ap_activo_vta').is(':checked')) {
						fla_apertura_vta = 'S';
					}
					var fla_cerrar_todo = 'N';
					if ($('#chk_mnt_cerrar_todas').is(':checked')) {
						fla_cerrar_todo = 'S';
					}
					/* if (comparafecha(fec_actual, fec_cierre)>=2) {
						msg = msg + 'La fecha de cierre debe ser menor o igual a la fecha actual.<br/>';						
					}
					 */
					
					/* if (fec_des_cierre != '' && comparafecha(fec_cierre, fec_des_cierre)<2) {
						msg = msg + 'La fecha de descierre debe ser mayor a la fecha de cierre.<br/>';						
					} */
					fec_apertura = 	fec_actual;
					if (!esnulo(msg)) {
						addWarnMessage(null, msg);
						return;
					}
					var new_record = true;
					if (!esnulo(cod_mes)) {
						new_record = false;
					}
													
					$.ajax({
						type: 'POST',
						url: VAR_CONTEXT + '/grabarCierre',
						data: { 
							cod_mes : cod_mes,
							anio : anio,
							mes : mes,
							cod_uni_operativa  : cod_uni_operativa,
							cod_reg_nac        : cod_reg_nac,
							fec_cierre         : fec_cierre,
							fec_apertura       : fec_apertura,
							fec_des_cierre     : fec_des_cierre,							
							fec_des_cierre_vta : fec_des_cierre_vta,
							mes_activo         : mes_activo,
							fla_apertura       : fla_apertura,
							fla_apertura_vta   : fla_apertura_vta,
							ind_cie_todos      : fla_cerrar_todo,
							ind_tip_compra     :tip_compra,
							ind_tip_venta      :tip_venta 
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
								$('#div_cierre_mes').modal('hide');
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
				var href = '/listarCierresMes';				
				var mes_activo = 'N';
				if ($('#chk_activo').is(':checked')) {
					mes_activo = 'S';
				}				
				var params = {
						 anio  :$('#sel_anno').val(),
						 mes   :$('#sel_mes').val(),
		     cod_uni_operativa : $('#sel_uni_operativa').val(),
		    	   cod_reg_nac : $('#sel_anp').val(),
					mes_activo : mes_activo
				};
				var fields = [
					'cod_mes',
					'cod_mes'
				];
				var layout = [{
					title: 'Item',
					type: 'enum'
				}, {
					title: 'Codigo T/M',
					field: fields,
					type: 'link',					
					label: '',
					method: 'editar',
				 
				}, {
					title: 'Año',
					field: 'anio',
				},{
					title: 'Mes',
					field: 'mes',
				},{
					title: 'Uni. Operativa',
					field: 'des_uni_operativa',
				},{
					title: 'ANP',
					field: 'des_reg_nac',
				},{
					title: 'Fec. Cierre',
					field: 'fec_cierre',
				}, {
					title: 'Fec.Apert.Compra',
					field: 'fec_des_cierre',
				},{
					title: 'Estado.Compras',
					field: 'nom_compra',
				},{
					title: 'Fec.Apert.Vta',
					field: 'fec_des_cierre_vta',
				},{
					title: 'Estado.Vta',
					field: 'nom_venta',
				},{
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
					containerTable: '.div_lis_cierre_mes',
					idTable: 'tbl_lis_cierre_mes',
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
				$('#chk_mnt_cerrar_todas').removeAttr("disabled");
				$('#chk_ap_activo').removeAttr("disabled");
				$('#chk_ap_activo_vta').removeAttr("disabled");
				$('#txt_mnt_fec_descierre').prop("disabled", true);
				$('#sp_ico_fec_descierre').prop("disabled", true);
				$('#txt_mnt_fec_descierre_vta').prop("disabled", true);
				$('#sp_ico_fec_descierre_vta').prop("disabled", true);
				$.ajax({
					type: 'GET',
					url: '${pageContext.request.contextPath}/listarCierresMes',
					data: {
						cod_mes : object
					},
					dataType: 'json',
					success: function(paramJson) {						
						if (paramJson[0] != null) {	
							$('#h_cierre_mes').html('Edicion de Cierre de Mes');
							$('#form_cierre_mes').trigger("reset");
							$('#txt_mnt_codigo').val(paramJson[0].cod_mes);
							$('#txt_anio').val(paramJson[0].anio);	
							$('#txt_mes').val(paramJson[0].mes);	
							$('#sel_mnt_uni_dest').val(paramJson[0].cod_uni_operativa);	
							setAnpBoleto(paramJson[0].cod_uni_operativa, paramJson[0].cod_reg_nac);
							$('#sel_mnt_anp').val(paramJson[0].cod_reg_nac);
							$('#txt_mnt_fec_cierre').val(paramJson[0].fec_cierre);	              //Fecha de Cierre
							$('#txt_fecha_cierre_inicio').val(paramJson[0].fec_des_cierre);
							$('#txt_mnt_fec_descierre').val(paramJson[0].fec_des_cierre);	      //Fecha Apertura de Compras
							$('#txt_mnt_fec_descierre_vta').val(paramJson[0].fec_des_cierre_vta); //Fecha Apertura de Ventas							
							//$('input[name="chk_mnt_compra"][value="${compra.tip_proveedor}"]').prop('checked', true);
							
				
							if (paramJson[0].mes_activo == 'S') {
								$('#chk_mnt_activo').attr('checked', true);  
							}else{
								$('#chk_mnt_activo').attr('checked', false);
							}
							if (paramJson[0].ind_tip_compra == 1) {           //Indicador Cierre Compras
								$('#chk_mnt_compra').attr('checked', true);
							}else{
								$('#chk_mnt_compra').attr('checked', false);
							}
							if (paramJson[0].ind_tip_venta == 2) {            //Indicador Cierre Ventas
								$('#chk_mnt_venta').attr('checked', true);
							}else{
								$('#chk_mnt_venta').attr('checked', false);
							}							
							if (paramJson[0].fla_apertura == 'S') {           //Indicador Apertura Compras
								$('#chk_ap_activo').attr('checked', true);
							}else {
								$('#chk_ap_activo').attr('checked', false);
							}
							
							if (paramJson[0].fla_apertura_vta == 'S') {       //Indicador Apertura Ventas
								$('#chk_ap_activo_vta').attr('checked', true);
							}else {
								$('#chk_ap_activo_vta').attr('checked', false);
							}		
							$('#txt_fec_creacion').val(paramJson[0].mnt_fec_creacion);
							$('#txt_fec_modificacion').val(paramJson[0].mnt_fec_modificacion);
							$('#txt_creacion').val(paramJson[0].mnt_usu_creacion);
							$('#txt_modificado').val(paramJson[0].mnt_usu_modificacion);
							$('#div_cierre_mes').modal('show');
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
				if (cod_uni_operativa == 'Seleccionar') {
					$('#sel_anp').empty();
					$("#sel_anp").append($("<option></option>").html("Seleccionar"));
				}else {
				var params = new Object();				
 				params['ind_uni_operativa'] = 1; // ANP
 				params['cod_uni_operativa'] = cod_uni_operativa;
 				simpleCboAjaxPopulateParam('#sel_anp', ['cod_reg_nac', 'des_reg_nac'], '/listarUnidadOperativa', params, true, false);
				}
			};
			
			function obtenerAnpMnt(cod_uni_operativa) {
				if (cod_uni_operativa == 'Seleccionar') {
					$('#sel_mnt_anp').empty();
					$("#sel_mnt_anp").append($("<option></option>").html("Seleccionar"));
				}else {
				var params = new Object();	
				params['ind_uni_operativa'] = 1; // ANP
 				params['cod_uni_operativa'] = cod_uni_operativa;
 				simpleCboAjaxPopulateParam('#sel_mnt_anp', ['cod_reg_nac', 'des_reg_nac'], '/listarUnidadOperativa', params, true, false);
				}
			};
			
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
							$('#sel_mnt_anp').html(options);							
							$('#sel_mnt_anp').val(cod_anp);

						} else {
							$('#sel_mnt_anp').html('');
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