<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="es">
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta charset="utf-8" />
		<title>Bandeja Registro de Compras</title>

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
							<c:set var="ind_transaccion" value="${fn:substring(indicador, 0, 1)}"/>
							<c:choose>
								<c:when test="${indicador == 1}">							
									<li class="active">
										<i class="ace-icon fa fa-sign-out"></i>
										Compras
									</li>
									<li class="active">Registro de Compras</li>							
								</c:when>
								<c:when test="${indicador == 11}">							
									<li class="active">
										<i class="ace-icon fa fa-sign-out"></i>
										Compras
									</li>
									<li class="active">Monitoreo</li>								
								</c:when>
								<c:when test="${indicador == 2}">							
									<li class="active">
										<i class="ace-icon fa fa-sign-out"></i>
										Ingresos
									</li>
									<li class="active">Registro de Ingresos</li>							
								</c:when>
								<c:when test="${indicador == 22}">							
									<li class="active">
										<i class="ace-icon fa fa-sign-out"></i>
										Ingresos
									</li>
									<li class="active">Monitoreo</li>							
								</c:when>
							</c:choose>
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
													<label class="col-sm-2 control-label label-sm no-padding-left">Tipo de Operación:</label>
														
													<div class="col-sm-1">
														<div class="radio">
															<label class="input-sm">
																<input type="radio" class="ace input-sm" name="rb_tip_operacion" value="1">
																<span id="sp_tip_operacion" class="lbl"></span>
															</label>
														</div>
													</div>
													
													<div class="col-sm-1">	
														<div class="radio">
															<label class="input-sm">
																<input type="radio" class="ace input-sm" name="rb_tip_operacion" value="2">
																<span class="lbl"> Sede</span>
															</label>
														</div>
													</div>
													<label class="col-sm-2 control-label label-sm no-padding-right">SIAF:</label>
													<div class="col-sm-2">
														<input type="text" id="txt_siaf" class="form-control input-sm onlyNumbers" maxlength="10" />
													</div>													
													<label class="col-sm-2 control-label label-sm no-padding-right">Nro. R/C :</label>
														<div class="col-sm-2">
															<input type="text" id="txt_rendicion" class="form-control input-sm" />
														</div>
																						
												</div>
																
												<div class="form-group">
													<label class="col-sm-2 control-label label-sm no-padding-right">U.O. Solicitante:</label>
													<div class="col-sm-2">
														<select id="sel_uni_operativa" class="form-control input-sm">
															<option value="">(Seleccione)</option>
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
													
													<label class="col-sm-2 control-label label-sm no-padding-right">Nro Transferencia:</label>
													<div class="col-sm-2">
														<input type="text" id="txt_nro_cp" class="form-control input-sm onlyNumbers" maxlength="10" />
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
													
													<label class="col-sm-2 control-label label-sm no-padding-right">Nro Comprobante:</label>
													<div class="col-sm-2">
														<input type="text" id="txt_nro_comprobante" class="form-control input-sm onlyNumbers" maxlength="10" />
													</div>
													
													<label class="col-sm-2 control-label label-sm no-padding-right">Nro RUC:</label>
													<div class="col-sm-2">
														<input type="text" id="txt_ruc" class="form-control input-sm onlyNumbers" maxlength="11" />
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
													<label class="col-sm-1 control-label label-sm no-padding-right">Año:</label>
													<div class="col-sm-1">														
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
													<label class="col-sm-1 control-label label-sm no-padding-right">Periodo:</label>
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
														<c:if test="${indicador < 3}">
															<button id="btn_nuevo" class="btn btn-sm btn-success" type="button">
																<i class="ace-icon fa fa-plus-square"></i>
																Nuevo
															</button>
														</c:if>
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
												<th>Nro de Comprobante</th>
												<th>Nro SIAF</th>
												<th>RUC</th>
												<th>Razón Social</th>
												<th>Tip.Documento</th>
												<th>Fecha</th>
												<th>Importe</th>
												<th>Dias T.</th>
												<th>Sede Origen</th>
												<th>Periodo</th>
												<th>Estado</th>
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
				
				$('.chosen-select').chosen({allow_single_deselect:true}); 
				//resize the chosen on window resize
		
				$(window)
				.off('resize.chosen')
				.on('resize.chosen', function() {
					$('.chosen-select').each(function() {
						 var $this = $(this);
						 $this.next().css({'width': $this.parent().width()});
					})
				}).trigger('resize.chosen');
				
				//resize chosen on sidebar collapse/expand
				$(document).on('settings.ace.chosen', function(e, event_name, event_val) {
					if(event_name != 'sidebar_collapsed') return;
					$('.chosen-select').each(function() {
						 var $this = $(this);
						 $this.next().css({'width': $this.parent().width()});
					})
				});
				
				inicializarDatos();

				$('.date-picker').datepicker({
					autoclose: true,
					todayHighlight: true
				});
				
				$('.input-group-addon').click(function(e){
					e.preventDefault();
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
								
				$('#sel_uni_operativa').on('change', function() {
					if (!esnulo($(this).val())) {
						obtenerAnp($(this).val());
					} else {
						$('#sel_anp').empty();
					}
				});		

				$('#btn_buscar').click(function(e) {					
					e.preventDefault(); //evita que vaya a un formulario
					search();  //Funcion Search()
				});
				
				$('#btn_nuevo').click(function(e) {					
					e.preventDefault();					
					var url = '${pageContext.request.contextPath}/mnt_com_ingresos/${indicador}/0';
					$(location).attr('href', url);
					
					startAjax();
				});
				
			});
			
			function search() {	

				var eva_operacion = $('input[name="rb_tip_operacion"]:checked');
				var tip_operacion = null;
				if (eva_operacion.length > 0) {
					tip_operacion = $('input[name="rb_tip_operacion"]:checked').val();
				}				
				var fec_desde = $('#txt_fec_desde').val();
				var fec_hasta = $('#txt_fec_hasta').val();
				if (!esnulo(fec_desde) && !esnulo(fec_hasta)) {
					if (!checkdate(fec_desde) || !checkdate(fec_hasta)) {
						var msg = 'El campo "Fecha" tiene formato de fecha incorrecto.';
						addWarnMessage(null, msg);
						return;
					}
				}
				var cod_uni_operativa = $('#sel_uni_operativa').val();
				if ('${ind_sed_principal}' == '0') { // No es sede principal
					if (esnulo(cod_uni_operativa)) {
						cod_uni_operativa = $('#sel_uni_operativa option').last().val();
					}					
				}
				var nro_ruc    = $('#txt_ruc').val();
				var nro_doc_rc = $('#txt_rendicion').val();
				var mes        = $('#sel_periodo').val();
				var anno       = $('#sel_anno').val();
				var href       = '/listarIngresoCompras';
				var params = {
					int_transaccion   : '${ind_transaccion}', // Identificador de la transacción Compras e Ingresos
					cod_uni_operativa : cod_uni_operativa,
					cod_reg_nac       : $('#sel_anp').val(),
					cod_comprobante   : $('#sel_tip_comprobante').val(),					
					nro_cp            : $('#txt_nro_cp').val(),
					nro_comprobante   : $('#txt_nro_comprobante').val(),					
					num_ruc           : $('#txt_ruc').val(),
					fec_desde         : fec_desde,
					fec_hasta         : fec_hasta,
					nro_siaf          : $('#txt_siaf').val(),
					tip_operacion     : tip_operacion,
					//raz_soc_prov      : raz_soc_prov,
					nro_doc_rc        : nro_doc_rc,
					cod_mes           : $('#sel_periodo').val(),
					cod_anno          : $('#sel_anno').val()
				};
				var fields = [
					'cod_com_ingresos', 
					'ser_comprobante', 
					'nro_comprobante'
				];
				var layout = [{
					title: 'Item',
					type: 'enum',
					'class': 'center no-sort'
				}, {
					title: 'Tipo Comp.',
					field: 'tip_com_siglas',
					'class': 'no-sort'
				}, {
					title: 'Numero de Comprobante',
					field: fields,
					type: 'link',
					label: '',
					method: 'editar',
					'class': 'no-sort',
				}, {
					title: 'SIAF',
					field: 'nro_siaf',
					'class': 'no-sort'
				}, {
					title: 'RUC',
					field: 'ruc_nro_doc_prov',
					'class': 'no-sort'
				}, {
					title: 'Razon Social',
					field: 'raz_soc_prov',
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
				},{
					title: 'Año',
					field: 'cod_anno',
					'class': 'no-sort'
				}, {
					title: 'Periodo',
					field: 'cod_mes',
					'class': 'no-sort'
				}, {
					title: 'Sede Origen',
					field: 'des_uni_operativa',
					'class': 'no-sort'
				}, {					
					title: 'Estado',
					field: 'estado',
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
					containerTable: '.div_com_ingresos',
					idTable: 'tbl_com_ingresos',
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
				var url = '${pageContext.request.contextPath}/mnt_com_ingresos/${indicador}/'+object;
				$(location).attr('href', url);	//Se va a la edicion del registro (objeto=id del comprobante)			
				startAjax();
			}
			
			function obtenerAnp(cod_uni_operativa) {
				var params = new Object();								
 				params['ind_uni_operativa'] = 1; // ANP
 				params['cod_uni_operativa'] = cod_uni_operativa;
 				simpleCboAjaxPopulateParam('#sel_anp', ['cod_reg_nac', 'des_reg_nac'], '/listarUnidadOperativa', params, true, false);
			}
			
			function inicializarDatos() {
				var indicador = parseInt('${indicador}');
				if (indicador == 1) {
					$('#li_compras').addClass('active');
					$('#li_reg_compras').addClass('active');
					$('#sp_tip_operacion').html(' Rendicion');
				} else if (indicador == 11) {
					$('#li_compras').addClass('active');
					$('#li_mon_compras').addClass('active');
					$('#sp_tip_operacion').html(' Rendicion');
				} else if (indicador == 2) {
					$('#li_ingresos').addClass('active');
					$('#li_reg_ingresos').addClass('active');
					$('#sp_tip_operacion').html(' Unidad Operativa');
				} else if (indicador == 22) {
					$('#li_ingresos').addClass('active');
					$('#li_mon_ingresos').addClass('active');
					$('#sp_tip_operacion').html(' Unidad Operativa');
				}
				
				if ('${ind_sed_principal}' == '1') { // Usuario de Sede Central						
					$('input[name=rb_tip_operacion][value="2"]').prop('checked', true);
				} else {
					$('input[name=rb_tip_operacion][value="1"]').prop('checked', true);
					$('#sel_uni_operativa option:eq(1)').attr('selected', 'selected');
					obtenerAnp($('#sel_uni_operativa').val());
					$('input[name=rb_tip_operacion]').prop('disabled', true);
				}
				
				$('#sel_tip_comprobante').val('');
				$('#sel_tip_comprobante').trigger('chosen:updated');
				
			}
		
		</script>
		
	</body>
</html>