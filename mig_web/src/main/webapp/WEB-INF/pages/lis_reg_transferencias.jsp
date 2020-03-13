<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta charset="utf-8" />
		<title>Bandeja Registro de Transferencias</title>

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
								Compras
							</li>
							<li class="active">Bandeja Registro de Transferencias</li>
						</ul>
					</div>
			
					<div class="page-content">		
						<div class="row">
							<div class="col-xs-12">
								<form class="form-horizontal" role="form">

									<fieldset class="fsStyle">
										<legend class="legendStyle">Búsqueda de Información de Transferencias</legend>
										
										<div class="form-group">
											<div class="col-sm-2">
												<label class="control-label label-sm no-padding-left">Tipo de Operación:</label>
											
												<div class="checkbox">
													<label class="input-sm">
														<input type="checkbox" class="ace input-sm" name="chk_tip_operacion" value="1" />
														<span class="lbl"> Transf.</span>
													</label>
												</div>
												
												<div class="checkbox">
													<label class="input-sm">
														<input type="checkbox" class="ace input-sm" name="chk_tip_operacion" value="2" />
														<span class="lbl"> Viáticos</span>
													</label>
												</div>
											</div>
										
											<div class="col-sm-8">							
												<div class="form-group">												
													<label class="col-sm-2 control-label label-sm no-padding-right">Tipo de Comprobante:</label>
													<div class="col-sm-2">
														<select id="sel_tip_comprobante" class="form-control input-sm">
															<option value="">&#60Seleccione&#62</option>
															<c:forEach items="${lis_tip_comprobante}" var="item">
															    <option value="${item.cod_comprobante}">${item.nom_comprobante}</option>
															</c:forEach>
														</select>
													</div>
													
													<label class="col-sm-2 control-label label-sm no-padding-right">Nro C/P:</label>
													<div class="col-sm-2">
														<input type="text" id="txt_nro_cp" class="form-control input-sm" maxlength="10" />
													</div>		
													<label class="col-sm-2 control-label label-sm no-padding-right">SIAF:</label>
													<div class="col-sm-2">
														<input type="text" id="txt_siaf" class="form-control input-sm" maxlength="10" />
													</div>																									
												</div>
												
												<div class="form-group">												
													<label class="col-sm-2 control-label label-sm no-padding-right">U.O.:</label>
													<div class="col-sm-5">
														<select id="sel_uni_operativa" class="form-control input-sm">
															<option value="">&#60Seleccione&#62</option>
															<c:forEach items="${lis_uni_operativa}" var="item">
															    <option value="${item.cod_uni_operativa}">${item.des_uni_operativa}</option>
															</c:forEach>
														</select>
													</div>												
												
													<label class="col-sm-3 control-label label-sm no-padding-right">Año:</label>
													<div class="col-sm-2">	
																											
														<select id="sel_anno" class="form-control input-sm">															
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
												</div>
												
												<div class="form-group">												
													<label class="col-sm-2 control-label label-sm no-padding-right">Fecha Desde:</label>
													<div class="col-sm-2">
														<div class="input-group">
															<input class="form-control input-sm date-picker" id="txt_fec_desde" type="text" />
															<span class="input-group-addon" id="sp_ico_fec_desde">
																<i class="fa fa-calendar bigger-110"></i>
															</span>
														</div>
													</div>
													
													<label class="col-sm-1 control-label label-sm no-padding-right">Hasta:</label>
													<div class="col-sm-2">
														<div class="input-group">
															<input class="form-control input-sm date-picker" id="txt_fec_hasta" type="text" />
															<span class="input-group-addon" id="sp_ico_fec_hasta">
																<i class="fa fa-calendar bigger-110"></i>
															</span>
														</div>
													</div>													
													
													
													<label class="col-sm-3 control-label label-sm no-padding-right">Periodo:</label>
													<div class="col-sm-2">
														<select id="sel_periodo" class="form-control input-sm">
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
											</div>	
											
											<div class="col-sm-2">
												<div class="form-group">	
													<div class="col-sm-12">
														<button id="btn_buscar" class="btn btn-sm btn-info input-sm" type="button">
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
														<button id="btn_nuevo" class="btn btn-sm btn-success input-sm" type="button">
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
								<div class="table-responsive div_reg_transferencias">
									<table id="tbl_reg_transferencias" class="table table-striped table-bordered table-hover">
										<thead>
											<tr>
												<th>Item</th>
												<th>Numero de R/C</th>
												<th>Nro C/P</th>
												<th>Fecha C/P</th>
												<th>Importe</th>
												<th>Dias T.</th>
												<th>Sede Origen</th>
												<th>Usuario Reg.</th>
												<th>Fec. Registro</th>
												<th>Usuario Mod.</th>
												<th>Fec. Modifica</th>	
											</tr>
										</thead>
									</table>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div><!-- /.main-content -->
		
		</div><!-- /.main-container -->
	
		<%@ include file="scripts_ini.jsp" %>	

		<!-- inline scripts related to this page -->
		<script type="text/javascript">
		
			$(document).ready(function() {
				
				$("#li_transferencias").addClass('active');
				$("#li_reg_transferencias").addClass('active');
				
				$('#sel_tip_comprobante').prop('disabled', true);
				$('#sel_tip_comprobante').val('62'); // Comprobantes de Pago
				
				$('.date-picker').datepicker({
					autoclose: true,
					todayHighlight: true
				});
				
				$('.input-group-addon').click(function(event){
					event.preventDefault();
					var id_sp = $(this).attr('id').substring(7);
					$('#txt_'+id_sp).datepicker('show');
				});
				
				$('#txt_fec_desde').datepicker().on('changeDate', function (ev) {
					var fec_desde = $(this).val();
					var dia = parseInt(fec_desde.substring(0, 2)) + 1;
					var mes = fec_desde.substring(3, 5);
					var anio = fec_desde.substring(6, 10);
					var fec_form = anio + '-' + mes + '-' + dia;					
					var fec_act = new Date(fec_form);
					$('#txt_fec_hasta').datepicker('setStartDate', fec_act);
				});
				
				$('#btn_buscar').click(function(e) {					
					e.preventDefault();
					search();
				});
				
				$('#btn_nuevo').click(function(e) {					
					e.preventDefault();					
					var url = VAR_CONTEXT + '/mnt_transferencia/0';
					$(location).attr('href', url);		
				});
				
			});
			
			function search() {
				var arr_tipo_ope = '';
				$.each($('input[name="chk_tip_operacion"]:checked'), function(){            
					arr_tipo_ope = arr_tipo_ope + $(this).val() + '_';
				});
				if (!esnulo(arr_tipo_ope)) {
					arr_tipo_ope = arr_tipo_ope.substring(0, arr_tipo_ope.length - 1);
				}				
				var fec_desde = $('#txt_fec_desde').val();
				var fec_hasta = $('#txt_fec_hasta').val();
				var mes        = $('#sel_periodo').val();
				var anno       = $('#sel_anno').val();
				/*
				if (!esnulo(fec_desde) && !esnulo(fec_hasta)) {
					if (!checkdate(fec_desde) || !checkdate(fec_hasta)) {
						var msg = 'El campo "Fecha" tiene formato de fecha incorrecto.';
						addWarnMessage(null, msg);
						return;
					}
				}
				*/
				var cod_uni_operativa = $('#sel_uni_operativa').val();
				if ('${ind_sed_principal}' == '0') { // No es sede principal
					if (esnulo(cod_uni_operativa)) {
						cod_uni_operativa = $('#sel_uni_operativa option').last().val();
					}					
				}
				var href = '/listarTransferencias';
				var params = { 
					ind_transaccion : arr_tipo_ope,
					cod_uni_operativa : cod_uni_operativa,
					cod_comprobante : $('#sel_tip_comprobante').val(),
					fec_desde : fec_desde,
					fec_hasta : fec_hasta,
					cod_mes   : $('#sel_periodo').val(),
					cod_anno  : $('#sel_anno').val(),
					num_comprobante : $('#txt_nro_cp').val(),
					num_siaf : $('#txt_siaf').val()
				};
				var fields = [
					'cod_transferencia',
					'num_doc_operacion'
				];
				var layout = [{
					title: 'Item',
					type: 'enum',
					'class': 'center no-sort'
				}, {
					title: 'Numero de R/C',
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
					title: 'Fecha C/P',
					field: 'fec_comprobante',
					'class': 'no-sort'
				}, {
					title: 'Importe',
					field: 'imp_total',
					'class': 'utilRight no-sort'
				}, {
					title: 'Dias T.',
					field: 'can_dia_transcurridos',
					'class': 'no-sort'
				}, {
					title: 'Sede Origen',
					field: 'des_uni_operativa',
					'class': 'no-sort'
				}, {
					title: 'Año',
					field: 'cod_anno',
					'class': 'no-sort'
				}, {
					title: 'Periodo',
					field: 'cod_mes',
					'class': 'no-sort'
				}, {
					title: 'Usuario Reg.',
					field: 'mnt_usu_creacion',
					'class': 'no-sort'
				}, {
					title: 'Fec. Registro',
					field: 'mnt_fec_creacion',
					'class': 'no-sort'
				}, {
					title: 'Usuario Mod.',
					field: 'mnt_usu_modificacion',
					'class': 'no-sort'
				}, {
					title: 'Fec. Modifica',
					field: 'mnt_fec_modificacion',
					'class': 'no-sort'				
				}];
				var options = {
					containerTable: '.div_reg_transferencias',
					idTable: 'tbl_reg_transferencias',
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
				var url = VAR_CONTEXT + '/mnt_transferencia/'+object;
				$(location).attr('href', url);
				
				startAjax();
			}
		
		</script>
		
	</body>
</html>
