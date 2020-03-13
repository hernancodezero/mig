<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta charset="utf-8" />
		<title>Bandeja Registro de Ingresos</title>

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
							<li class="active">Registro de Ingresos</li>
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
													<label class="col-sm-2 control-label label-sm no-padding-right">UO:</label>
													<div class="col-sm-2">
														<select id="sel_unidad_operativa" class="form-control input-sm">
															<option value=''>&#60Seleccione&#62</option>
															<c:forEach items="${lis_tip_comprobante}" var="item">
															    <option value="${item.cod_comprobante}">${item.nom_comprobante}</option>
															</c:forEach>
														</select>
													</div>
												
													<label class="col-sm-2 control-label label-sm no-padding-right">ANP:</label>
													<div class="col-sm-2">
														<select id="sel_anp" class="form-control input-sm">
															<option value=''>&#60Seleccione&#62</option>
															<c:forEach items="${lis_tip_comprobante}" var="item">
															    <option value="${item.cod_comprobante}">${item.nom_comprobante}</option>
															</c:forEach>
														</select>
													</div>
													
													<label class="col-sm-2 control-label label-sm no-padding-right">Tipo de Comprobante:</label>
													<div class="col-sm-2">
														<select id="sel_anp" class="form-control input-sm">
															<option value=''>&#60Seleccione&#62</option>
															<c:forEach items="${lis_tip_comprobante}" var="item">
															    <option value="${item.cod_comprobante}">${item.nom_comprobante}</option>
															</c:forEach>
														</select>
													</div> 
												</div>
												
												<div class="form-group">
													<label class="col-sm-2 control-label label-sm no-padding-right">Nro. de Serie:</label>
													<div class="col-sm-2">
														<input type="text" id="txt_serie" class="form-control input-sm" maxlength="10" />
													</div>
												 	<label class="col-sm-2 control-label label-sm no-padding-right">Nro Documento:</label>
													<div class="col-sm-2">
														<input type="text" id="txt_nro_documento" class="form-control input-sm" maxlength="10" />
													</div>
													<label class="col-sm-2 control-label label-sm no-padding-right">Nro RUC:</label>
													<div class="col-sm-2">
														<input type="text" id="txt_ruc" class="form-control input-sm" maxlength="11" />
													</div>
													
												</div>
												
												<div class="form-group">
													<label class="col-sm-2 control-label label-sm no-padding-right">Fecha Desde:</label>
													<div class="col-sm-3">
														<div class="input-group">
															<input class="form-control input-sm date-picker" id="txt_fec_desde" type="text" />
															<span class="input-group-addon" id="sp_ico_fec_desde">
																<i class="fa fa-calendar bigger-110"></i>
															</span>
														</div>
													</div>
													
													<label class="col-sm-1 control-label label-sm no-padding-right">Hasta:</label>
													<div class="col-sm-3">
														<div class="input-group">
															<input class="form-control input-sm date-picker" id="txt_fec_hasta" type="text" />
															<span class="input-group-addon" id="sp_ico_fec_hasta">
																<i class="fa fa-calendar bigger-110"></i>
															</span>
														</div>
													</div>
													<label class="col-sm-1 control-label label-sm no-padding-right">SIAF:</label>
													<div class="col-sm-2">
														<input type="text" id="txt_siaf" class="form-control input-sm" maxlength="10" />
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
								<div class="table-responsive div_com_ingresos">
									<table class="table table-striped table-bordered table-hover">
										<thead>
											<tr>
												<th>Item</th>
												<th>Numero Doc</th>
												<th>Nro C/P</th>
												<th>RUC</th>
												<th>Razón Social</th>
												<th>Tipo Documento</th>
												<th>Fecha</th>
												<th>Importe</th>
												<th>IGV</th>
												<th>Afecto</th>
												<th>Inafecto</th>
												<th>Dias T.</th>
												<th>Sede Origen</th>
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
				
				$("#li_ingresos").addClass('active');
				$("#li_reg_ingresos").addClass('active');
				
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
							[20, 50, 100],
							[20, 50, 100]
						]
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
