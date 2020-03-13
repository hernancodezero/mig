<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta charset="utf-8" />
		<title>Mantenimiento de Datos de Renta de 4ta Categoria</title>

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
							<li class="active">Mantenimiento de Datos de Personal de 4ta Categoria</li>
						</ul>
					</div>
			
					<div class="page-content">		
						<div class="row">
							<div class="col-xs-12">
								<form class="form-horizontal" role="form">
									<input type="hidden" id="hid_renta">
									<fieldset class="fsStyle">
										<legend class="legendStyle">Búsqueda de Información</legend>
											
										<div class="form-group">	
											<div class="col-sm-10">		
												<div class="form-group">
													<div class="form-group">	
														<input type="text" id="txt_mnt_codigo" class="form-control input-sm onlyAmounts hidden" maxlength="15" />																					
													</div>	
													<label class="col-sm-2 control-label label-sm no-padding-right">Nombres:</label>
													<div class="col-sm-3">
														<input type="text" id="txt_nombres" class="form-control input-sm " maxlength="15" />
													</div>
																					
													<label class="col-sm-2 control-label label-sm no-padding-right">Nro Ruc:</label>
													<div class="col-sm-2">
														<input type="text" id="txt_ruc" class="form-control input-sm " maxlength="11" />
													</div>
																																
												</div>	
												
												<div class="form-group">
													<label class="col-sm-2 control-label label-sm no-padding-right">Apellido Paterno:</label>
													<div class="col-sm-3">
														<input type="text" id="txt_paterno" class="form-control input-sm " />
													</div>		
													
													<label class="col-sm-2 control-label label-sm no-padding-right">Nro Ident.:</label>
													<div class="col-sm-2">
														<input type="text" id="txt_dni" class="form-control input-sm " maxlength="15" />
													</div>											
												</div>	
												<div class="form-group">
													<label class="col-sm-2 control-label label-sm no-padding-right">Apellido Materno:</label>
													<div class="col-sm-3">
														<input type="text" id="txt_materno" class="form-control input-sm " />
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
																							
	
										</div>	

									</fieldset>
									<br>
								</form>
							</div>			
						</div>
						
						<div class="row">
							<div class="col-xs-12">
								<div class="table-responsive div_lis_otros">
									<table class="table table-striped table-bordered table-hover">
										<thead>
											<tr>
												<th>Item</th>
												<th>Codigo</th>
												<th>Nombres</th>
												<th>Nro Ruc</th>
												<th>Nro Doc Ident</th>												
												<th>Direccion</th>
												<th>Nro Telefono</th>
												<th>Correo</th>
												<th>Fec.Creacion</th>
												<th>Usuario Crea.</th>
												<th>Fec.Modific.</th>
												<th>Usuario Modif.</th>
											</tr>
										</thead>
									</table>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div><!-- /.main-content -->
			
			<div id="div_reg_prestador_modal" class="modal" tabindex="-1" data-keyboard="false" data-backdrop="static">
				<div class="modal-dialog modal-lg">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">&times;</button>
							<h4 id="h_renta" class="white bigger center">Datos del Prestador</h4>
						</div>
						
						<div class="modal-body">
							<div class="row">
								<div class="col-xs-12">
									<form id="form_reg_prestador" class="form-horizontal" role="form">
									
										<div class="form-group">																				
											<label class="col-sm-1 control-label input-sm no-padding-right">RUC:</label>											
											<div class="col-sm-3">
												<input type="text" id="txt_reg_ruc_cuarta" class="form-control input-sm onlyNumbers" maxlength = "11" />
											</div>
											
											<label class="col-sm-1 control-label label-sm no-padding-right">Tipo Doc.:</label>
											<div class="col-sm-2">
												<select id="sel_tip_doc_prestador" class="form-control input-sm">
													<option>Seleccionar</option>
													<c:forEach items="${lis_documento_cuarta}" var="item">
													    <option value="${item.srlIdDocumento}">${item.chrNomDocumento}</option>
													</c:forEach>
												</select>
											</div>
											
										    <label class="col-sm-1 control-label input-sm no-padding-right">Nro:</label>											
											<div class="col-sm-3">
												<input type="text" id="txt_nro_doc_cuarta" class="form-control input-sm onlyNumbers" maxlength = "8" />
											</div>	
										</div>
										
										<div class="form-group">																				
											<label class="col-sm-1 control-label input-sm no-padding-right">Ape. Paterno:</label>											
											<div class="col-sm-2">
												<input type="text" id="txt_ape_pat_prestador" class="form-control input-sm upperValue" maxlength = "30"/>
											</div>	
										 																			
											<label class="col-sm-1 control-label input-sm no-padding-right">Ape. Materno:</label>											
											<div class="col-sm-2">
												<input type="text" id="txt_ape_mat_prestador" class="form-control input-sm upperValue" maxlength = "30" />
											</div>	
										 																			
											<label class="col-sm-1 control-label input-sm no-padding-right">Nombres:</label>											
											<div class="col-sm-2">
												<input type="text" id="txt_reg_nom_prestador" class="form-control input-sm upperValue" maxlength = "50"/>
											</div>
											<label class="col-sm-1 control-label input-sm no-padding-right">Fec. Nac.:</label>		
											<div class="col-sm-2">
												<div class="input-group">
													<input class="form-control input-sm date-picker " id="txt_reg_fec_nac" type="text" maxlength="10"/>
												</div>
											</div>
										</div>
										
										<div class="form-group">	
											<label class="col-sm-1 control-label label-sm no-padding-right">Nacionalidad.:</label>
											<div class="col-sm-2">
												<select id="sel_tip_nacionalidad" class="form-control input-sm" >
													<option>Seleccionar</option>
													<c:forEach items="${lis_tip_nacionalidad}" var="item">
													    <option value="${item.srlIdNacion}">${item.chrNomNacion}</option>
													</c:forEach>
												</select>
											</div>
											
											<label class="col-sm-1 control-label label-sm no-padding-right">Sexo.:</label>
											<div class="col-sm-2">
												<select id="sel_tip_sexo" class="form-control input-sm">
													<option>Seleccionar</option>
												    <option value="M">Masculino</option>
												    <option value="F">Femenino</option>
												</select>
											</div>
													
											<label class="col-sm-1 control-label input-sm no-padding-right">Telefono:</label>											
											<div class="col-sm-2">
												<input type="text" id="txt_telefomo" class="form-control input-sm" maxlength = "10" />
											</div>
										</div>
										
										<div class="form-group">
											<label class="col-sm-1 control-label input-sm no-padding-right">Correo Electronico:</label>											
											<div class="col-sm-2">
												<input type="text" id="txt_reg_cor_prestador" class="form-control input-sm" maxlength = "15"/>
											</div>
											
											<label class="col-sm-1 control-label label-sm no-padding-right">ESSALUD.:</label>
											<div class="col-sm-2">
												<select id="sel_tip_convenio" class="form-control input-sm">
													<option>Seleccionar</option>
												    <option value="S">Tiene</option>
												    <option value="N">No Tiene</option>
												</select>
											</div>			
									       <label class="col-sm-1 control-label label-sm no-padding-right">Domiciliado.:</label>
											<div class="col-sm-2">
												<select id="sel_domiciliado" class="form-control input-sm">
													<option>Seleccionar</option>
												    <option value="S">Domiciliado</option>
												    <option value="N">No Domiciliado</option>
												</select>
											</div>												
										</div>
										
										<div class="form-group">																				
											<label class="col-sm-1 control-label input-sm no-padding-right">Ruc:</label>											
											<div class="col-sm-3">
												<input type="text" id="txt_ruc_convenio" class="form-control input-sm onlyNumbers" maxlength = "11" />
											</div>
											<label class="col-sm-1 control-label label-sm no-padding-right">Convenio.:</label>
											<div class="col-sm-3">
												<select id="sel_convenio" class="form-control input-sm">
													<option>Seleccionar</option>
													<c:forEach items="${lis_convenio}" var="item">
													    <option value="${item.srlIdConvenio}">${item.chrNomConvenio}</option>
													</c:forEach>
												</select>
											</div>
										</div>
										
										<div class="form-group">
											<label class="col-sm-1 control-label label-sm no-padding-right">Tipo Via.:</label>
											<div class="col-sm-2">
												<select id="sel_tip_via" class="form-control input-sm">
													<option>Seleccionar</option>
													<c:forEach items="${lis_tip_via}" var="item">
													    <option value="${item.srlIdVia}">${item.chrNomVia}</option>
													</c:forEach>
												</select>
											</div>
											
										    <label class="col-sm-1 control-label input-sm no-padding-right">Nombre de via :</label>											
											<div class="col-sm-2">
												<input type="text" id="txt_nom_via" class="form-control input-sm upperValue" maxlength = "30"/>
											</div>
											
											<label class="col-sm-1 control-label input-sm no-padding-right">Numero:</label>											
											<div class="col-sm-2">
												<input type="text" id="txt_nro_via" class="form-control input-sm upperValue" maxlength = "3" />
											</div>
											
											<label class="col-sm-1 control-label input-sm no-padding-right">Interior:</label>											
											<div class="col-sm-2">
												<input type="text" id="txt_interior" class="form-control input-sm upperValue" maxlength = "3"/>
											</div>
											
										</div>
										
										<div class="form-group">		
											<label class="col-sm-1 control-label label-sm no-padding-right">Tipo Zona.:</label>																		
											<div class="col-sm-2">
												<select id="sel_tip_zona" class="form-control input-sm">
													<option>Seleccionar</option>
													<c:forEach items="${lis_tip_zona}" var="item">
													    <option value="${item.srlIdZona}">${item.chrNomZona}</option>
													</c:forEach>
												</select>
											</div>
											
										 	<label class="col-sm-2 control-label input-sm no-padding-right">Nomb de Zona:</label>											
											<div class="col-sm-6">
												<input type="text" id="txt_zona" class="form-control input-sm upperValue" maxlength = "50"/>
											</div>
										</div>										
										
										<div class="form-group">																				
											<label class="col-sm-2 control-label input-sm no-padding-right">Referencia:</label>											
											<div class="col-sm-9">
												<input type="text" id="txt_referencia" class="form-control input-sm upperValue" maxlength = "100"/>
											</div>
										</div>
										
										<div class="form-group">	
								       	    <label class="col-sm-2 control-label label-sm no-padding-right">Departamento:</label>																		
											<div class="col-sm-2">
												<select id="sel_departamento" class="form-control input-sm">
													<option>Seleccionar</option>
													<c:forEach items="${lis_ubigeo}" var="item">
													    <option value="${item.coddpto}">${item.nombre}</option>
													</c:forEach>  
												</select>
											</div>	
											<label class="col-sm-2 control-label label-sm no-padding-right">Provincia:</label>	
											<div class="col-sm-2">
												<select id="sel_provincia" class="form-control input-sm">
													 <option>Seleccionar</option>
													 <c:forEach items="${lis_ubigeo}" var="item">
													    <option value="${item.codprov}">${item.nombre}</option>
													</c:forEach>
												</select>
											</div>	
											<label class="col-sm-2 control-label label-sm no-padding-right">Distrito:</label>	
											<div class="col-sm-2">
												<select id="sel_distrito" class="form-control input-sm">
													<option>Seleccionar</option>
												</select>
											</div>	
									    </div>									
									</form>
								</div>
							</div>
						</div>
						<div class="modal-footer">				
							<button id="btn_gra_prestador" class="btn btn-sm btn-primary">
								<i class="ace-icon fa fa-check"></i>
								Grabar
							</button>
							<button class="btn btn-sm" data-dismiss="modal">
								<i class="ace-icon fa fa-times"></i>
								Cancelar
							</button>
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
				$("#li_mnt_renta").addClass('active');		
				
				$('#sel_departamento').on('change', function() {
					obtenerprovincia($(this).val());
				});
				$('#sel_provincia').on('change', function() {
					obtenerdistrito($(this).val());
				});
				var nac = $('#sel_tip_nacionalidad').val();
				//obtenerNacionalidad($('#sel_tip_nacionalidad').val());
				$('#txt_nombres').keyup(function() {
			        this.value = this.value.toUpperCase();
			    });
				$('#txt_nombres').keyup(function() {
			        this.value = this.value.toUpperCase();
			    });
				$('#txt_paterno').keyup(function() {
			        this.value = this.value.toUpperCase();
			    });
				$('#txt_materno').keyup(function() {
			        this.value = this.value.toUpperCase();
			    });					
				$('#txt_mnt_nombres').keyup(function() {
			        this.value = this.value.toUpperCase();
			    });
				
				$('#sel_departamento').on('change', function() {
					obtenerprovincia($(this).val());
				});
				$('#sel_provincia').on('change', function() {
					obtenerdistrito($(this).val());
				});
				$('#btn_buscar').click(function(e) {					
					e.preventDefault();
					search();
				});

				
				$('#btn_nuevo').click(function(e) {					
					e.preventDefault();
					$('#h_renta').html('Registro de Personal de Cuarta');
					$('#form_reg_prestador').trigger("reset");
					$('#div_reg_prestador_modal').modal('show');
				});
				
				$('#btn_gra_prestador').click(function(e) {					
					e.preventDefault();
					
					var	numRuc=$('#txt_reg_ruc_cuarta').val();
					var TDocumentoCuarta=$('#sel_tip_doc_prestador').val();
					var chrNumDocumento=$('#txt_nro_doc_cuarta').val();
					var	chrApePaterno=$('#txt_ape_pat_prestador').val();
					var	chrApeMaterno=$('#txt_ape_mat_prestador').val();
					var	chrNombres=$('#txt_reg_nom_prestador').val();
					var dteFecNacimiento=$('#txt_reg_fec_nac').val();
					var TNacionalidad=$('#sel_tip_nacionalidad').val();
					var	chrTipSexo=$('#sel_tip_sexo').val();
					var chrNumTelefono=$('#txt_telefomo').val();
					var	chrCorreo=$('#txt_reg_cor_prestador').val();
					var	chrIndEssalud=$('#sel_tip_convenio').val();
					var chrIndDomiciliario=$('#sel_domiciliado').val();
					var numRucConvenio=$('#txt_ruc_convenio').val();
					var	TConvenioCuarta= $('#sel_convenio').val();
					var TVia=$('#sel_tip_via').val();
					var	chrNomVia=$('#txt_nom_via').val();
					var	chrNumHogar=$('#txt_nro_via').val();
					var chrNumInterior=$('#txt_interior').val();
					var TZona=$('#sel_tip_zona').val();
					var	chrNomZona=$('#txt_zona').val();
					var	chrReferencia=$('#txt_referencia').val();
					var departamento = $('#sel_departamento').val();
					var provincia = $('#sel_provincia').val();
					var distrito = $('#sel_distrito').val();
				    var	idubigeo= trim($('#sel_departamento').val())+ ''+trim($('#sel_provincia').val()) + '' +trim($('#sel_distrito').val());
					var msg = '';					
					
					if (chrTipSexo == "Seleccionar") {
						msg = msg + 'El campo "Sexo" es obligatorio.<br/>';
					}	
					if (chrIndEssalud == "Seleccionar") {
						msg = msg + 'El campo "Tipo Salud" es obligatorio.<br/>';
					}	
					if (chrIndDomiciliario == "Seleccionar") {
						msg = msg + 'El campo "Tipo Domiciliado" es obligatorio.<br/>';
					}	
					if (TNacionalidad == "Seleccionar") {
						msg = msg + 'El campo "Tipo Nacionalidad" es obligatorio.<br/>';
					}				
					if (TConvenioCuarta  == "Seleccionar" ) {
						msg = msg + 'El campo "Tipo Convenio" es obligatorio.<br/>';
					} 
					if (TVia    == "Seleccionar" ) {
						msg = msg + 'El campo "Tipo Via" es obligatorio.<br/>';
					}
					if (TZona  == "Seleccionar" ) {
						msg = msg + 'El campo "Tipo de Zona" es obligatorio.<br/>';
					}
					if (departamento  == "Seleccionar" || esnulo(departamento)) {
						msg = msg + 'El campo "Tipo de Departamento" es obligatorio.<br/>';
					}
					if (provincia  == "Seleccionar" || esnulo(provincia)) {
						msg = msg + 'El campo "Tipo de Provincia" es obligatorio.<br/>';
					}
					if (distrito  == "Seleccionar" || esnulo(distrito)) {
						msg = msg + 'El campo "Tipo de Distrito" es obligatorio.<br/>';
					}
					if (esnulo(chrNumInterior)) {
						msg = msg + 'El campo "Numero" es obligatorio.<br/>';
					}
					
					if (!esnulo(msg)) {
						showMessage(msg);
						return;
					}

					$.ajax({
						type: 'POST',
						url: VAR_CONTEXT + '/grabarPersonaCuartaCategoria',
						data: { 
								TConvenioCuarta	 : TConvenioCuarta,
								TDocumentoCuarta : TDocumentoCuarta,
								TNacionalidad    : TNacionalidad,
								TVia 	 		 : TVia,
								TZona    		 : TZona,
								numRuc	 		 : numRuc,
								chrNumDocumento  : chrNumDocumento,
							  	chrApePaterno	 : chrApePaterno,
							  	chrApeMaterno	 : chrApeMaterno,
							  	chrNombres	     : chrNombres,
							  	dteFecNacimiento : dteFecNacimiento,
							  	chrTipSexo	     : chrTipSexo,
							  	chrNumTelefono   : chrNumTelefono,
							  	chrCorreo		 : chrCorreo,
							  	chrIndEssalud	 : chrIndEssalud,
							  	chrIndDomiciliario: chrIndDomiciliario,
							  	numRucConvenio   : numRucConvenio,
							  	chrNomVia		 : chrNomVia,
							  	chrNumHogar	     : chrNumHogar,
							  	chrNumInterior   : chrNumInterior,
							  	chrNomZona	     : chrNomZona,
							  	chrReferencia	 : chrReferencia,
							   	idubigeo		 : idubigeo 
							},
						dataType: 'json',
						success: function(paramJson) {						
							if (paramJson != null) {	
								endAjax();			
				       		    $('#hid_personal').val(paramJson);
								$('#txt_nombres').val(trim(chrNombres));
								$('#txt_apellidos').val(trim(chrApeMaterno) + ' ' +trim(chrApePaterno));
				       			$('#div_reg_prestador').modal('hide');				       			
				       			addInfoMessage(null, 'El registro fue grabado.');
							}	
						},
						error: function(jqXHR, error, errorThrown) {
							var msg = 'Error al Grabar la Persona Juridica:<br/>';
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
				var href = '/listarPersonaCuarta';								
				var params = {
					srlIdPersonal   : $('#txt_mnt_codigo').val(),
					chrNombres      : $('#txt_nombres').val(),
					chrApePaterno   : $('#txt_paterno').val(),
					chrApeMaterno   : $('#txt_materno').val(),
					numRuc          : $('#txt_ruc').val(),
					chrNumDocumento : $('#txt_dni').val()				
				};
				var fields = [
					'srlIdPersonal',
					'srlIdPersonal'
				];
				var layout = [{
					title: 'ID',
					field: fields,
					type: 'link',					
					label: '',
					method: 'editar',
				}, {
					title: 'Nombres',
					field: 'nombre',				
				}, {		
					title: 'Nro RUC',
					field: 'numRuc',				
				}, {		
					title: 'Nro Ident.',
					field: 'chrNumDocumento',				
				}, {		
					title: 'Direccion.',
					field: 'direccion_persona',				
				}, {		
					title: 'Nro. Telef.',
					field: 'chrNumTelefono',				
				}, {		
					title: 'E-Mail',
					field: 'chrCorreo',				
				}, {						
					title: 'Fec. Creacion',
					field: 'dteFecCreacion',
				}, {
					title: 'Usuario',
					field: 'chrCodUsuaCreacion',
				}, {
					title: 'Fec. Modificacion',
					field: 'dteFecModifica',
				}, {
					title: 'Usuario Modif.',
					field: 'chrCodUsuaModifica',
				}];
				var options = {
					containerTable: '.div_lis_otros',
					idTable: 'tbl_lis_otros',
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
					url: '${pageContext.request.contextPath}/listarPersonaCuarta',
					data: {
						srlIdPersonal : object
					},
					dataType: 'json',
					success: function(paramJson) {						
						if (paramJson[0] != null) {	
							$('#h_renta').html('Edicion de Prestadores de Cuarta');
							$('#form_reg_prestador').trigger("reset");
							$('#txt_reg_ruc_cuarta').val(paramJson[0].numRuc);
							$('#sel_tip_doc_prestador').val(paramJson[0].srlIdDocumento);
							$('#txt_nro_doc_cuarta').val(paramJson[0].chrNumDocumento);
							$('#txt_ape_pat_prestador').val(paramJson[0].chrApePaterno);
							$('#txt_ape_mat_prestador').val(paramJson[0].chrApeMaterno);
							$('#txt_reg_nom_prestador').val(paramJson[0].chrNombres);
							$('#txt_reg_fec_nac').val(paramJson[0].dteFecNacimiento);
							$('#sel_tip_nacionalidad').val(paramJson[0].srlIdNacion);
							$('#sel_tip_sexo').val(paramJson[0].chrTipSexo);
							$('#txt_telefomo').val(paramJson[0].chrNumTelefono);
							$('#txt_reg_cor_prestador').val(paramJson[0].chrCorreo);
							$('#sel_tip_convenio').val(paramJson[0].chrIndEssalud);
							$('#sel_domiciliado').val(paramJson[0].chrIndDomiciliario);
							$('#txt_ruc_convenio').val(paramJson[0].numRucConvenio);
							$('#sel_convenio').val(paramJson[0].srlIdConvenio);
							$('#sel_tip_via').val(paramJson[0].srlIdVia);
							$('#txt_nom_via').val(paramJson[0].chrNomVia);
							$('#txt_nro_via').val(paramJson[0].chrNumHogar);
							$('#txt_interior').val(paramJson[0].chrNumInterior);
							$('#sel_tip_zona').val(paramJson[0].srlIdZona);
							$('#txt_zona').val(paramJson[0].chrNomZona);
							$('#txt_referencia').val(paramJson[0].chrReferencia);
							$('#sel_departamento').val(paramJson[0].coddpto);							
							$('#sel_provincia').val(paramJson[0].codprov);
							$('#sel_distrito').val(paramJson[0].coddist);
							/*
							$('#sel_uni_operativa').val('${compra.cod_uni_operativa}');
							var coddpto=$('#sel_departamento').val(paramJson[0].coddpto);							
							obtenerdistrito($(this).val());
							var codprov=$('#sel_provincia').val(paramJson[0].codprov);
							obtenerprovincia(coddpto);
							obtenerdistrito(codprov);
							*/
							$('#div_reg_prestador_modal').modal('show');
						}	
					},
					error: function(jqXHR, error, errorThrown) {
						var msg = 'Error al Editar el Registro:<br/>';
						if (jqXHR.status && jqXHR.status == 400) {
							msg = msg + jqXHR.responseText;
						} else {
							msg = msg + errorThrown;
						}
						addErrorMessage(null, msg);
					}
				});
			}
			
			
			//funcion para obtener la provincia del departamento Ubigeo
			function obtenerprovincia(coddpto) {
				var params = new Object();
 				params['coddpto'] = coddpto;
 				simpleCboAjaxPopulateParam('#sel_provincia', ['codprov', 'nombre'], '/listarUbigeo', params, true, false);
			}
			
			//funcion para obtener el distrito del departamento y provincia Ubigeo
			function obtenerdistrito(codprov) {
				var params = new Object();
				var coddpto = $('#sel_departamento').val();
 				params['coddpto'] = coddpto;
 				params['codprov'] = codprov;
 				simpleCboAjaxPopulateParam('#sel_distrito', ['coddist', 'nombre'], '/listarUbigeo', params, true, false);
			}
			
		</script>
		
	</body>
</html>