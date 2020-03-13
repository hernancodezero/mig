<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta charset="utf-8" />
		<title>Registro Ingreso de Boletos</title>

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
							<li class="active">Registro de Ingresos Servicios</li>
						</ul>
					</div>
			
					<div class="page-content">		
						<div class="row">
							<div class="col-sm-12">					
								<form id="frm_servicios" class="form-horizontal" role="form">
									<input type="hidden" id="hid_reg_compras" value="${codigo}">
									<input type="hidden" id="hid_proveedor">
									<input type="hidden" id="hid_partida">

									<div class="col-sm-6">
										<div class="form-group">
											<label class="col-sm-3 control-label label-sm no-padding-right">ANP:</label>
											<div class="col-sm-9">
												<select id="sel_anp" class="form-control input-sm">
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
											<fieldset class="fsStyle">
												<legend class="legendStyle">Detalle de Boletos</legend>
												
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
																		<th>Tarifa</th>
																		<th>Dias</th>
																		<th>Precio</th>
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
								</form>
							</div>
						</div>
					</div>
				</div>
			</div><!-- /.main-content -->	
		</div><!-- /.main-content -->	
		<%@ include file="scripts_ini.jsp" %>	

		<!-- inline scripts related to this page -->
		<script type="text/javascript">
		
			$(document).ready(function() {
				
				$("#li_ingresos").addClass('active');
				$("#li_reg_ing_boletos").addClass('active');
				
				$('.date-picker').datepicker({
					autoclose: true,
					todayHighlight: true
				});
				
				$('.input-group-addon').click(function(event){
					event.preventDefault();
					var id_sp = $(this).attr('id').substring(7);
					$('#txt_'+id_sp).datepicker('show');
				});
				
				$('#txt_serie').change(function() {
 					$('#txt_serie').val(padDigits($(this).val(), 7));
 				});
				
				$('#btn_buscar').click(function(e) {					
					e.preventDefault();
					search();
				});
				
				$('#btn_nuevo').click(function(e) {					
					e.preventDefault();					
					var url = '${pageContext.request.contextPath}/mnt_com_ingresos/0';
					$(location).attr('href', url);		
				});
				
			});
			
			function search() {
				var fec_desde = $('#txt_fec_desde').val();
				var fec_hasta = $('#txt_fec_hasta').val();
				if (!esnulo(fec_desde) && !esnulo(fec_hasta)) {
					if (!checkdate(fec_desde) && !checkdate(fec_hasta)) {
						var msg = 'El campo "Fecha" tiene formato de fecha incorrecto.';
						showMessage(msg);
						return;
					}
				}
				var href = '/listarCompras';
				var params = { 
					cod_comprobante : $('#sel_tip_comprobante').val(),
					uni_operativa : $.trim($('#txt_uni_operativa').val()),
					ser_comprobante : $('#txt_serie').val(),
					nro_siaf : $('#txt_siaf').val(),
					ruc_proveedor : $('#txt_ruc').val(),
					fec_desde : fec_desde,
					fec_hasta : fec_hasta,
					nro_cp : $('#txt_nro_cp').val()
				};
				var fields = [
					'cod_com_ingresos', 
					'ser_comprobante', 
					'num_comprobante'
				];
				var layout = [{
					title: 'Item',
					type: 'enum',
					'class': 'center no-sort'
				}, {
					title: 'Numero de Documento',
					field: fields,
					type: 'link',					
					label: '',
					method: 'editar',
					'class': 'no-sort',
				}, {
					title: 'Nro C/P',
					field: 'num_comprobante',
					'class': 'no-sort'
				}, {
					title: 'Tipo Documento',
					field: 'tip_comprobante',
					'class': 'no-sort'
				}, {
					title: 'Fecha',
					field: 'fec_comprobante',
					'class': 'no-sort'
				}, {
					title: 'Importe',
					field: 'imp_total',
					'class': 'no-sort'
				}, {
					title: 'Dias T.',
					field: 'tip_moneda',
					'class': 'no-sort'
				}, {
					title: 'Sede Origen',
					field: 'tip_moneda',
					'class': 'no-sort'
				}];
				var options = {
					containerTable: '.div_com_ingresos',
					idTable: 'tbl_com_ingresos',
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
				var url = '${pageContext.request.contextPath}/mnt_com_ingresos/'+object;
				$(location).attr('href', url);
			}
		
		</script>
		
	</body>
</html>
