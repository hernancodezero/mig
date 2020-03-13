<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta charset="utf-8" />
<title>Registro Contratos</title>

<%@ include file="components.jsp"%>
</head>

<body class="no-skin">

	<%@ include file="header.jsp"%>

	<!-- /section:basics/navbar.layout -->
	<div class="main-container" id="main-container">

		<%@ include file="menu.jsp"%>
		<div class="main-content">
			<div class="main-content-inner">
				<!-- #section:basics/content.breadcrumbs -->
				<div class="breadcrumbs" id="breadcrumbs">
					<ul class="breadcrumb">
						<li class="active"><i class="ace-icon fa fa-sign-out"></i>
							Control y Seguimiento</li>
						<li class="active">Registro Contratos</li>
					</ul>
				</div>

				<div class="page-content">
					<div class="row">
						<div class="col-xs-12">
							<form class="form-horizontal" role="form">

								<fieldset class="fsStyle">
									<legend class="legendStyle">Registro de Contratos</legend>

									<div class="form-group">
										<div class="col-sm-10">
											<div class="form-group">
											    <label class="col-sm-3 control-label label-sm no-padding-right">Tipo Operación:</label>
												<div class="col-sm-6">	
													<label class="input-sm">
														<input type="radio" class="ace input-sm" name="rb_tip_operacion" value="2">
														<span class="lbl"> UO</span>
													</label>
												
													<label class="input-sm">
														<input type="radio" class="ace input-sm" name="rb_tip_operacion" value="1">
														<span class="lbl"> Sede</span>
													</label>
										 		</div>
										 	</div>	
										 	
											<div class="form-group">
												<label
													class="col-sm-2 control-label label-sm no-padding-right">U.O.:</label>
												<div class="col-sm-2">
													<select id="sel_uni_operativa"
														class="form-control input-sm">
														<option value="0">Seleccionar</option>
														<c:forEach items="${lis_uni_operativa}" var="item">
															<option value="${item.cod_uni_operativa}">${item.des_uni_operativa}</option>
														</c:forEach>
													</select>
												</div>

												<label
													class="col-sm-2 control-label label-sm no-padding-right">Nro.
													Contrato:</label>
												<div class="col-sm-2">
													<input type="text" id="txt_num_contrato"
														class="form-control input-sm" maxlength="20" />
												</div>

												<label
													class="col-sm-2 control-label label-sm no-padding-right">Fecha
													Inicio:</label>
												<div class="col-sm-2">
													<div class="input-group">
														<input class="form-control input-sm date-picker"
															id="txt_fec_inicial" type="text" /> <span
															class="input-group-addon" id="sp_ico_fec_inicial">
															<i class="fa fa-calendar bigger-110"></i>
														</span>
													</div>
												</div>
											</div>
											<div class="form-group">
												<label
													class="col-sm-2 control-label label-sm no-padding-right">ANP:</label>
												<div class="col-sm-2">
													<select id="sel_anp" class="form-control input-sm">
													<option>Seleccionar</option>
													</select>
												</div>


												<label
													class="col-sm-2 control-label label-sm no-padding-right">RUC:</label>
												<div class="col-sm-2">
													<input type="text" id="txt_ruc"
														class="form-control input-sm" maxlength="11" />
												</div>

												<label
													class="col-sm-2 control-label label-sm no-padding-right">Fecha
													Fin:</label>
												<div class="col-sm-2">
													<div class="input-group">
														<input class="form-control input-sm date-picker"
															id="txt_fec_final" type="text" /> <span
															class="input-group-addon" id="sp_ico_fec_final">
															<i class="fa fa-calendar bigger-110"></i>
														</span>
													</div>
												</div>
											</div>
										</div>
										<div class="col-sm-2">
											<div class="form-group">
												<div class="col-sm-12">
													<button id="btn_buscar" class="btn btn-sm btn-info"
														type="button">
														<i class="ace-icon fa fa-search"></i> Buscar
													</button>
												</div>
											</div>

											<div class="form-group">
												<div class="col-sm-12">
													<button id="btn_nuevo" class="btn btn-sm btn-success"
														type="button">
														<i class="ace-icon fa fa-plus-square"></i> Nuevo
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
											<th>RUC</th>
											<th>Numero Contrato</th>
											<th>Fecha Inicio</th>
											<th>Fecha Fin</th>
											<th>Usuario</th>
										</tr>
									</thead>
								</table>
							</div>
						</div>
					</div>


				</div>
			</div>

			<div id="div_contratos" class="modal" tabindex="-1"
				data-keyboard="false" data-backdrop="static">
				<div class="modal-dialog modal-lg">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">&times;</button>
							<h4 id="h_contratos" class="white bigger center"></h4>
						</div>
						<div class="modal-body">
							<div class="row">
								<div class="col-xs-12">
									<form id="form_contratos" class="form-horizontal" role="form">
								 	
								 	<div class="form-group">
									    <label class="col-sm-3 control-label label-sm no-padding-right">Tipo Operación:</label>
										<div class="col-sm-6">	
											<label class="input-sm">
												<input type="radio" class="ace input-sm" name="rb_mnt_tip_operacion" value="2">
												<span class="lbl"> UO</span>
											</label>
										
											<label class="input-sm">
												<input type="radio" class="ace input-sm" name="rb_mnt_tip_operacion" value="1">
												<span class="lbl"> Sede</span>
											</label>
								 		</div>
								 	 </div>	
								 	 
										<div class="form-group">
											<input type="hidden" id="hid_contrato">
											<label class="col-sm-2 control-label label-sm no-padding-right">U.O.:</label>
											<div class="col-sm-4">
												<select id="sel_mnt_uni_operativa"
													class="form-control input-sm">
													<option>Seleccionar</option>
													<c:forEach items="${lis_uni_operativa}" var="item">
														<option value="${item.cod_uni_operativa}">${item.des_uni_operativa}</option>
													</c:forEach>
												</select>
											</div>
											<label
												class="col-sm-2 control-label label-sm no-padding-right">ANP:</label>
											<div class="col-sm-4">
												<select id="sel_mnt_anp" class="form-control input-sm">
													<option value=''>&#60Seleccione&#62</option>
													<c:forEach items="${lis_anp}" var="item">
													    <option value="${item.cod_reg_nac}">${item.des_reg_nac}</option>
													</c:forEach>
												</select>
											</div>
										</div>
										<div class="form-group">
											<label
												class="col-sm-2 control-label label-sm no-padding-right">Tipo
												de Contrato:</label>
											<div class="col-sm-4">
												<select id="sel_mnt_tip_contrato"
													class="form-control input-sm">
													<option value='1'>Alquiler</option>
													<option value='2'>Concesión</option>
													<option value='3'>Derecho de Aprovechamiento Turistico</option>
													<option value='4'>Servicios Turisticos</option>
													<option value='5'>Servicios</option>
													<option value='6'>Bienes</option>
													<option value='7'>Obras</option>
												</select>
											</div>
											<label
													class="col-sm-2 control-label label-sm no-padding-right">Nro.
													Contrato:</label>
											<div class="col-sm-4">
												<input type="text" id="txt_mnt_num_contrato"
													class="form-control input-sm" maxlength="20" />
											</div>
										</div>
										<div class="form-group">
											<label
												class="col-sm-2 control-label label-sm no-padding-right">Fecha
												Inicio:</label>
											<div class="col-sm-4">
												<div class="input-group">
													<input class="form-control input-sm date-picker"
														id="txt_mnt_fec_inicio" type="text" /> <span
														class="input-group-addon" id="sp_ico_mnt_fec_inicio">
														<i class="fa fa-calendar bigger-110"></i>
													</span>
												</div>
											</div>
											<label
												class="col-sm-2 control-label label-sm no-padding-right">Fecha
												Fin:</label>
											<div class="col-sm-4">
												<div class="input-group">
													<input class="form-control input-sm date-picker"
														id="txt_mnt_fec_fin" type="text" /> <span
														class="input-group-addon" id="sp_ico_mnt_fec_fin">
														<i class="fa fa-calendar bigger-110"></i>
													</span>
												</div>
											</div>
										</div>
										<div class="form-group">
											<label
												class="col-sm-2 control-label label-sm no-padding-right">Concepto:</label>
												<div class="col-sm-10">
													<textarea class="form-control input-sm" rows="3" id="txt_mnt_concepto"  maxlength = "500"></textarea>
												</div>
										</div>
										<div class="form-group">
											<label
												class="col-sm-2 control-label label-sm no-padding-right">Importe Contrato:</label>
												<div class="col-sm-4">
													<input class="form-control input-sm"
														id="txt_mnt_monto_contrato" type="text" maxlength = "10" />
												</div>
											<label
												class="col-sm-2 control-label label-sm no-padding-right">Importe Garantía:</label>
											<div class="col-sm-4">
												<input class="form-control input-sm"
													id="txt_mnt_monto_garantia" type="text"  maxlength = "10"  />
											</div>
										</div>
										<div class="form-group">
											<label
												class="col-sm-2 control-label label-sm no-padding-right">Importe Alquiler:</label>
												<div class="col-sm-2">
													<input class="form-control input-sm"
														id="txt_mnt_monto_alquiler" type="text"  maxlength = "10" />
												</div>
											<label
												class="col-sm-2 control-label label-sm no-padding-right">Importe Tributo:</label>
												<div class="col-sm-2">
													<input class="form-control input-sm"
														id="txt_mnt_monto_tributo" type="text"  maxlength = "10"/>
												</div>
											<label
												class="col-sm-2 control-label label-sm no-padding-right">Intereses:</label>
												<div class="col-sm-2">
													<input class="form-control input-sm"
														id="txt_mnt_intereses" type="text"   maxlength = "10"/>
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
											<div class="col-sm-2">
											</div>
											<label
												class="col-sm-2 control-label label-sm no-padding-right">Inter. Variable:</label>
											<div class="col-sm-2">
												<div class="input-group">
													<input class="form-control input-sm"
														id="txt_mnt_inter_variable" type="text" />
												</div>
											</div>
										</div>
										<fieldset class="fsStyle">
											<legend class="legendStyle">Datos del Concedente</legend>
											<input type="hidden" id="hid_proveedor">
											<div class="form-group">
												<div class="col-sm-12">
													<div class="form-group">
														<label
															class="col-sm-2 control-label label-sm no-padding-right">Nombres:</label>
														<div class="col-sm-4">
															<input type="text" id="txt_mnt_nombres"
																class="form-control input-sm" maxlength="30" />
														</div>
														<label
															class="col-sm-2 control-label label-sm no-padding-right">Apellido:</label>
														<div class="col-sm-4">
															<input type="text" id="txt_mnt_apellidos"
																class="form-control input-sm" maxlength="30" />
														</div>
													</div>
													<div class="form-group">
														<label class="col-sm-2 control-label label-sm no-padding-right">Doc Identidad:</label>
															<div class="col-sm-4">
																<select id="sel_mnt_tip_doc" class="form-control input-sm">
																	<option value="0">SELECCIONAR</option>
																	<c:forEach items="${lis_tip_documento}" var="item">
																		<option value="${item.cod_documento}" ${item.cod_documento == 2 ? 'selected="selected"' : ''}>${item.nom_documento}</option>
																	</c:forEach>
																</select>
															</div>
														<label class="col-sm-2 control-label label-sm no-padding-right">Nro de Documento:</label>
														<div class="col-sm-4">
															<input type="text" id="txt_mnt_nro_doc" class="form-control input-sm " maxlength="8" />
														</div>
													</div>
													<div class="form-group">
														<label
															class="col-sm-2 control-label label-sm no-padding-right">RUC:</label>
														<div class="col-sm-4">
															<input type="text" id="txt_mnt_ruc"
																class="form-control input-sm" maxlength="11" />
														</div>
														<label
															class="col-sm-2 control-label label-sm no-padding-right">Razon
															Social:</label>
														<div class="col-sm-4">
															<input type="text" id="txt_mnt_razon_social"
																class="form-control input-sm" maxlength="50" />
														</div>
													</div>
												</div>
											</div>
										</fieldset>
										<fieldset class="fsStyle">
												<legend class="legendStyle">Cronograma de pagos</legend>
												<input type="hidden" id="hid_par_detalle">
												
												<div class="form-group">
													<div class="col-sm-12">													
														<div class="table-responsive">
															<table id="tbl_det_contrato" class="table table-striped table-bordered table-hover">
																<thead>
																	<tr>
																		<th>Mes</th>
																		<th>Monto Mes</th>
																		<th>Fec. Prog. Pago</th>
																		<th>Nro C/P</th>
																		<th>Fec. Pago</th>
																		<td></td>
																		<td></td>
																	</tr>
																</thead>
																
																<c:if test="${not empty lis_det_contratos}">
																	<c:set var="count" value="1" scope="page" />
																	<c:forEach items="${lis_det_contratos}" var="item">
																		<tr class="item">
																			<td>${count}</td>
																			<td class="par">${item.vcod_especifica}</td>
																			<td class="ser">${item.des_especifica}</td>
																			<td class="hide cod_ser">${item.cod_especifica}</td>
																			<td class="hide cod_cue">${item.cod_cuenta}</td>	
																			<td class="hide imp_no_afecto">${item.num_imp_no_afecto}</td>
																			<td class="hide imp_isc">${item.num_imp_isc}</td>
																			<td>
																				<button class="btn btn-sm btn-warning input-sm btn_edi_detalle">
																					<i class="ace-icon fa fa-pencil-square-o"></i>
																				</button>
																			</td>
																			<td>																		
																				<button class="btn btn-sm btn-danger input-sm btn_rem_detalle">
																					<i class="ace-icon fa fa-trash-o"></i>
																				</button>																																	
																			</td>					
																		</tr>
																		<c:set var="count" value="${count + 1}" scope="page"/>
																	</c:forEach>
																</c:if>
																
																<tr class="item">
																	<td>
																		<div class="hidden-sm hidden-xs btn-group">
																			<button class="btn btn-xs btn-success btn_agr_detalle">
																				<i class="ace-icon fa fa-plus"></i>
																			</button>
																		</div>																	
																	</td>
																	<td></td>
																	<td></td>
																	<td></td>
																	<td></td>
																	<td></td>
																	<td></td>
																</tr>
																
															</table>
														</div>
													</div>		
												</div>
																						
											</fieldset>
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
													<button id="btn_salir" class="btn btn-sm input-sm" data-dismiss="modal">
														<i class="ace-icon fa fa-times"></i>
														Salir
													</button>
												</div>
											</div>
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- /.main-container -->
		</div>
		<div id="div_det_contrato" class="modal" tabindex="-1" data-keyboard="false" data-backdrop="static">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 id="h_det_contrato" class="white bigger center"></h4>
					</div>
					
					<div class="modal-body">
						<div class="row">
							<div class="col-xs-12">
								<form id="form_det_reg_gravado" class="form-horizontal" role="form">						

									<div class="form-group">																				
										<label class="col-sm-1 control-label input-sm no-padding-right">Mes:</label>											
										<div class="col-sm-3">
											<input type="text" id="txt_mes" class="form-control input-sm onlyAmounts" maxlength="2" />
										</div>
										
										<label id="lbl_monto_mes" class="col-sm-1 control-label input-sm no-padding-right">Monto Mes:</label>											
										<div class="col-sm-3">
											<input type="text" id="txt_monto_mes" class="form-control input-sm" maxlength = "8" />
										</div>	
										<label
											class="col-sm-1 control-label label-sm no-padding-right">Fecha Prog.
											Pago:</label>
										<div class="col-sm-3">
											<div class="input-group">
												<input class="form-control input-sm date-picker"
													id="txt_fec_pago" type="text" /> <span
													class="input-group-addon" id="sp_ico_fec_pago">
													<i class="fa fa-calendar bigger-110"></i>
												</span>
											</div>
										</div>									
									</div>	
									<div class="form-group">
										<label class="col-sm-1 control-label input-sm no-padding-right">Nro C/P:</label>											
											<div class="col-sm-3">
												<input type="text" id="txt_chrNumCompPago" class="form-control input-sm" maxlength = "7" />
											</div>	
											
										<label	class="col-sm-1 control-label label-sm no-padding-right">Fecha Pago:</label>
											<div class="col-sm-3">
												<div class="input-group">
													<input class="form-control input-sm date-picker" id="txt_dteFecCompPago" type="text" /> 
													<span class="input-group-addon" id="sp_ico_dteFecCompPago">
														<i class="fa fa-calendar bigger-110"></i>
													</span>
												</div>
											</div>		
									</div>
									 														
								</form>
							</div>
						</div>			
					</div>

					<div class="modal-footer">				
						<button id="btn_anadir" class="btn btn-sm btn-primary">
							<i class="ace-icon fa fa-check"></i>
							Añadir
						</button>
						<button id="btn_editar" class="btn btn-sm btn-primary">
							<i class="ace-icon fa fa-check"></i>
							Grabar
						</button>
						<button id="btn_cancelar" class="btn btn-sm">
							<i class="ace-icon fa fa-times"></i>
							Cancelar
						</button>
					</div>
				</div>
			</div>
		</div>
		<div id="div_reg_proveedor" class="modal" tabindex="-1" data-keyboard="false" data-backdrop="static">
			<div class="modal-dialog modal-lg" >
			
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="white bigger center">Datos del Proveedor</h4>
					</div>
					
					<div class="modal-body">
						<div class="row">
							<div class="col-xs-12">
								<form id="form_reg_proveedor" class="form-horizontal" role="form">
									<div class="form-group">																				
										<label class="col-sm-3 control-label input-sm no-padding-right">Número de RUC:</label>											
										<div class="col-sm-3">
											<input type="text" id="txt_reg_ruc" class="form-control input-sm onlyNumbers" disabled />
										</div>
									</div>

									<div class="form-group">
										<label class="col-sm-3 control-label label-sm no-padding-right">Tipo Empresa:</label>													
										<div class="col-sm-3">
											<div class="radio">
												<label class="input-sm">
													<input type="radio" class="ace input-sm" name="rb_tip_empresa" value="1">
													<span class="lbl"> Natural</span>
												</label>
											</div>
										</div>
										<div class="col-sm-3">
											<div class="radio">
												<label class="input-sm">
													<input type="radio" class="ace input-sm" name="rb_tip_empresa" value="2">
													<span class="lbl"> Juridica</span>
												</label>
											</div>
										</div>
									</div>
									
									<div class="form-group">																				
										<label class="col-sm-3 control-label label-sm no-padding-right">Entidad:</label>													
										<div class="col-sm-3">
											<div class="radio">
												<label class="input-sm">
													<input type="radio" class="ace input-sm" name="rb_entidad" value="1">
													<span class="lbl"> Público</span>
												</label>
											</div>
										</div>
										
										<div class="col-sm-3">
											<div class="radio">
												<label class="input-sm">
													<input type="radio" class="ace input-sm" name="rb_entidad" value="2">
													<span class="lbl"> Privado</span>
												</label>
											</div>
										</div>
									</div>										

									<div class="form-group">																				
										<label class="col-sm-3 control-label input-sm no-padding-right">Razon Social:</label>											
										<div class="col-sm-9">
											<input type="text" id="txt_reg_raz_social" class="form-control input-sm upperValue" maxlength="100" disabled/>
										</div>	
									</div>									
									
									<div class="form-group">
										<label class="col-sm-3 control-label label-sm no-padding-right">Tipo Doc.:</label>
										<div class="col-sm-3">
											<select id="sel_tip_doc" class="form-control input-sm">
												<c:forEach items="${lis_tip_documento}" var="item">
													<option value="${item.cod_documento}">${item.nom_documento}</option>
												</c:forEach>
											</select>
										</div>
									
										<label class="col-sm-3 control-label input-sm no-padding-right">Nro Doc.:</label>											
										<div class="col-sm-3">
											<input type="text" id="txt_nro_doc" class="form-control input-sm onlyNumbers" maxlength="8" />
										</div>											
									</div>
									
									<div class="form-group">																				
										<label class="col-sm-3 control-label input-sm no-padding-right">Ape. Paterno:</label>											
										<div class="col-sm-6">
											<input type="text" id="txt_ape_paterno" class="form-control input-sm upperValue" maxlength="30" />
										</div>	
									</div>
									
									<div class="form-group">																				
										<label class="col-sm-3 control-label input-sm no-padding-right">Ape. Materno:</label>											
										<div class="col-sm-6">
											<input type="text" id="txt_ape_materno" class="form-control input-sm upperValue" maxlength="30" />
										</div>	
									</div>
									
									<div class="form-group">																				
										<label class="col-sm-3 control-label input-sm no-padding-right">Nombres:</label>											
										<div class="col-sm-6">
											<input type="text" id="txt_reg_nombres" class="form-control input-sm upperValue" maxlength="30" />
										</div>
									</div>
										
									<div class="form-group">
										<label class="col-sm-3 control-label input-sm no-padding-right">Correo Eléctronico:</label>											
										<div class="col-sm-6">
											<input type="text" id="txt_reg_correo" class="form-control input-sm" maxlength="50" />
										</div>
									</div>
									
									<div class="form-group">																				
										<label class="col-sm-3 control-label input-sm no-padding-right">Direccion:</label>											
										<div class="col-sm-6">
											<input type="text" id="txt_reg_direccion" class="form-control input-sm upperValue" maxlength="50" />
										</div>
									</div>
									
									<div class="form-group">																				
										<label class="col-sm-3 control-label input-sm no-padding-right">Giro de Negocio:</label>											
										<div class="col-sm-3">
											<input type="text" id="txt_gir_negocio" class="form-control input-sm upperValue" maxlength="50" />
										</div>
									</div>
										
									<div class="form-group">
										<label class="col-sm-3 control-label input-sm no-padding-right">Telefono Contacto:</label>											
										<div class="col-sm-3">
											<input type="text" id="txt_tel_contacto" class="form-control input-sm onlyNumbers" maxlength="11" />
										</div>
									</div>										
								</form>
							</div>
						</div>			
					</div>

					<div class="modal-footer">				
						<button id="btn_gra_proveedor" class="btn btn-sm btn-primary">
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
		
	</div>
			<%@ include file="scripts_ini.jsp"%>

			<!-- inline scripts related to this page -->
			<script type="text/javascript">
			
				var arr_det_contrato = [];
				
				<c:if test="${not empty lis_detalle}">
				arr_det_contrato = [];
					var options = '';
					<c:forEach items="${lis_detalle}" var="item">
				    	var cod_esp = '${item.cod_especifica}'+'_'+'${item.des_especifica}';
						options += '<option value="'+cod_esp+'">'+'${item.vcod_especifica}'+'</option>';											
						arr_det_contrato.push(cod_esp+'_'+'${item.vcod_especifica}'+'_'+'${item.imp_saldo}');
					</c:forEach>
					$('#sel_partida').html(options);
				</c:if>
				
				$(document).ready(function() {
				
					$("#li_con_seguimiento").addClass('active');
					$("#li_reg_contratos").addClass('active');
					inicializarDatos();
					$('.date-picker').datepicker({
						autoclose : true,
						todayHighlight : true
					});
					
					$("#txt_mnt_monto_contrato").change(function() {
						 var num1 = "";
					  	 var num =  this.value
					  	 num = num.replace(",","");
					  	 num = num.replace(",","");
					  	 num = num.replace(",","");
					  	 num = num.replace(",","");
					 	
					  	if(num.indexOf('.') != -1){
				//	     	 num1 = num.substring(num.indexOf('.'), num.indexOf('.') +2);
					    	 num1 = num.substring(num.length,num.length -2);
						     num =	num.substring(0, num.indexOf('.')+1);
						  	}
						 
						 num = num.toString().split('').reverse().join('').replace(/(?=\d*\.?)(\d{3})/g,'$1,');
						 num = num.split('').reverse().join('').replace(/^[\.]/,'');
						 
						 if (num.substring(0, 1) == ','){
							 num = num.substring(1,num.length);
						 }
 							
							if(num.indexOf('.') != -1){
								num = num +''+num1;
							}  
					
							
				     	$("#txt_mnt_monto_contrato").val(num);
					});
					
					$("#txt_mnt_monto_garantia").change(function() {
						 var num1 = "";
					  	 var num =  this.value
					  	 num = num.replace(",","");
					  	 num = num.replace(",","");
					  	 num = num.replace(",","");
					  	 num = num.replace(",","");
					 	
					  	if(num.indexOf('.') != -1){
				//	     	 num1 = num.substring(num.indexOf('.'), num.indexOf('.') +2);
					    	 num1 = num.substring(num.length,num.length -2);
						     num =	num.substring(0, num.indexOf('.')+1);
						  	}
						 
						 num = num.toString().split('').reverse().join('').replace(/(?=\d*\.?)(\d{3})/g,'$1,');
						 num = num.split('').reverse().join('').replace(/^[\.]/,'');
						 
						 if (num.substring(0, 1) == ','){
							 num = num.substring(1,num.length);
						 }
 							
							if(num.indexOf('.') != -1){
								num = num +''+num1;
							}  
					
						
				     	$("#txt_mnt_monto_garantia").val(num);
					});
					$("#txt_mnt_monto_alquiler").change(function() {
						 var num1 = "";
					  	 var num =  this.value
					  	 num = num.replace(",","");
					  	 num = num.replace(",","");
					  	 num = num.replace(",","");
					  	 num = num.replace(",","");
					 	
					  	if(num.indexOf('.') != -1){
				//	     	 num1 = num.substring(num.indexOf('.'), num.indexOf('.') +2);
					    	 num1 = num.substring(num.length,num.length -2);
						     num =	num.substring(0, num.indexOf('.')+1);
						  	}
						 
						 num = num.toString().split('').reverse().join('').replace(/(?=\d*\.?)(\d{3})/g,'$1,');
						 num = num.split('').reverse().join('').replace(/^[\.]/,'');
						 
						 if (num.substring(0, 1) == ','){
							 num = num.substring(1,num.length);
						 }
 							
							if(num.indexOf('.') != -1){
								num = num +''+num1;
							}  
					
				     	$("#txt_mnt_monto_alquiler").val(num);
					});
					$("#txt_mnt_monto_tributo").change(function() {
						 var num1 = "";
					  	 var num =  this.value
					  	 num = num.replace(",","");
					  	 num = num.replace(",","");
					  	 num = num.replace(",","");
					  	 num = num.replace(",","");
					 	
					  	if(num.indexOf('.') != -1){
				//	     	 num1 = num.substring(num.indexOf('.'), num.indexOf('.') +2);
					    	 num1 = num.substring(num.length,num.length -2);
						     num =	num.substring(0, num.indexOf('.')+1);
						  	}
						 
						 num = num.toString().split('').reverse().join('').replace(/(?=\d*\.?)(\d{3})/g,'$1,');
						 num = num.split('').reverse().join('').replace(/^[\.]/,'');
						 
						 if (num.substring(0, 1) == ','){
							 num = num.substring(1,num.length);
						 }
 							
							if(num.indexOf('.') != -1){
								num = num +''+num1;
							}  
					
				     	$("#txt_mnt_monto_tributo").val(num);
					});
					$("#txt_mnt_intereses").change(function() {
						 var num1 = "";
					  	 var num =  this.value
					  	 num = num.replace(",","");
					  	 num = num.replace(",","");
					  	 num = num.replace(",","");
					  	 num = num.replace(",","");
					 	
					  	if(num.indexOf('.') != -1){
				//	     	 num1 = num.substring(num.indexOf('.'), num.indexOf('.') +2);
					    	 num1 = num.substring(num.length,num.length -2);
						     num =	num.substring(0, num.indexOf('.')+1);
						  	}
						 
						 num = num.toString().split('').reverse().join('').replace(/(?=\d*\.?)(\d{3})/g,'$1,');
						 num = num.split('').reverse().join('').replace(/^[\.]/,'');
						 
						 if (num.substring(0, 1) == ','){
							 num = num.substring(1,num.length);
						 }
 							
							if(num.indexOf('.') != -1){
								num = num +''+num1;
							}  
				     	$("#txt_mnt_intereses").val(num);
					});
					
					$("#txt_mnt_inter_variable").change(function() {
						 var num1 = "";
					  	 var num =  this.value
					  	 num = num.replace(",","");
					  	 num = num.replace(",","");
					  	 num = num.replace(",","");
					  	 num = num.replace(",","");
					 	
					  	if(num.indexOf('.') != -1){
				//	     	 num1 = num.substring(num.indexOf('.'), num.indexOf('.') +2);
					    	 num1 = num.substring(num.length,num.length -2);
						     num =	num.substring(0, num.indexOf('.')+1);
						  	}
						 
						 num = num.toString().split('').reverse().join('').replace(/(?=\d*\.?)(\d{3})/g,'$1,');
						 num = num.split('').reverse().join('').replace(/^[\.]/,'');
						 
						 if (num.substring(0, 1) == ','){
							 num = num.substring(1,num.length);
						 }
							
							if(num.indexOf('.') != -1){
								num = num +''+num1;
							}  
					
						
				     	$("#txt_mnt_inter_variable").val(num);
					});
			 
					
					$('.input-group-addon').click(function(event) {
						event.preventDefault();
						var id_sp = $(this).attr('id').substring(7);
						$('#txt_' + id_sp).datepicker('show');
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

						$('#h_contratos').html('Registro de Contratos');
						$('#form_contratos').trigger("reset");
						$('#sel_mnt_anp').val(0);
						$('#sel_tip_moneda').val(1);
						$('#div_contratos').modal('show');	
						$("#tbl_det_contrato > thead").find("tr:gt(0)").remove();
						$("#txt_mnt_fec_inicio").datepicker();
						$("#txt_mnt_fec_fin").datepicker();
						$("#txt_fec_pago").datepicker();
						$('#btn_eliminar').hide();
						$('#hid_contrato').val('');
				 
						if ('${ind_sed_principal}' == '1') { // Usuario de Sede Central		
							$('input[name=rb_mnt_tip_operacion][value="1"]').prop('checked', true);
						 	$('#sel_mnt_uni_operativa').val('Seleccionar'); // Lima
					 	}  else {
					 		$('input[name=rb_mnt_tip_operacion][value="2"]').prop('checked', true);
					 	}
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
					var href = '/listarContratos';
					var params = {
						cod_uni_operativa : $('#sel_uni_operativa').val(),
						cod_reg_nac : $('#sel_anp').val(),
						num_contrato : $('#txt_num_contrato').val(),
						num_ruc : $('#txt_ruc').val(),
						fec_desde : fec_desde,
						fec_hasta : fec_hasta,
					    chrTipOperacion : $('input[name="rb_mnt_tip_operacion"]:checked').val()
					};
					var fields = [ 'cod_contrato', 'num_ruc'];
					var layout = [ 
					{
						title : 'RUC',
						field : fields,
						type : 'link',
						label : '',
						method : 'editar',
					}, {
						title : 'Numero Contrato',
						field : 'num_contrato',
					}, {
						title : 'Fecha Inicio',
						field : 'fec_inicio',
					}, {
						title : 'Fecha Fin',
						field : 'fec_final',
					}, {
						title : 'Usuario',
						field : 'mnt_usu_modificacion',
					} ];
					var options = {
						containerTable : '.div_com_ingresos',
						idTable : 'tbl_com_ingresos',
						styleTable : '.util1200Rw',
						loading : true,
						parameters : params,
						vTableOptions : {
							bFilter : false,
							paging : true,
							info : true,
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
						url: '${pageContext.request.contextPath}/listarContratos',
						data: {
							cod_contrato : object
						},
						dataType: 'json',
						success: function(paramJson) {						
							if (paramJson[0] != null) {
								var datos_cont = paramJson[0];
								inicializarDatos();
								$('#h_contratos').html('Edicion de Contrato');
								$('#form_contratos').trigger("reset");
								$('#hid_contrato').val(datos_cont.cod_contrato); 
								$('#sel_mnt_uni_operativa').val(datos_cont.cod_uni_operativa);
								$('#sel_mnt_anp').val(datos_cont.cod_reg_nac);
								setAnpBoleto(paramJson[0].cod_uni_operativa, paramJson[0].cod_reg_nac);
								$('#sel_mnt_tip_contrato').val(datos_cont.tip_contrato);
								$('#txt_mnt_num_contrato').val(datos_cont.num_contrato);
								$('#txt_mnt_fec_inicio').val(datos_cont.fec_inicio);
								$('#txt_mnt_fec_fin').val(datos_cont.fec_final);
								$('#txt_mnt_concepto').val(datos_cont.concepto);
								$('#txt_mnt_monto_contrato').val(datos_cont.num_imp_contrato);
								$('#txt_mnt_monto_garantia').val(datos_cont.num_imp_garantia);
								$('#txt_mnt_monto_alquiler').val(datos_cont.num_imp_alquiler);
								$('#txt_mnt_monto_tributo').val(datos_cont.num_imp_tributo);
								$('#txt_mnt_intereses').val(datos_cont.num_imp_interes);
								$('#hid_proveedor').val(datos_cont.cod_proveedor); 
								$('#sel_mnt_tip_doc').val(datos_cont.cod_documento);
								$('#txt_mnt_nro_doc').val(datos_cont.num_documento);								
								$('#hid_proveedor').val(datos_cont.cod_proveedor); 
								$('#txt_mnt_nombres').val(datos_cont.nom_concedente); 
								$('#txt_mnt_apellidos').val(datos_cont.ape_concedente); 
								$('#txt_mnt_razon_social').val(datos_cont.raz_social); 
								$('#txt_mnt_ruc').val(datos_cont.num_ruc); 
								$('#sel_tip_moneda').val(datos_cont.srlIdMoneda);
								
								if ('${ind_sed_principal}' == '1') { // Usuario de Sede Central	
									$('input[name=rb_mnt_tip_operacion][value="1"]').prop('checked', true);
								 
							 	}  else {
							 		$('input[name=rb_mnt_tip_operacion][value="2"]').prop('checked', true);
							 	}
								var num_ruc = $('#txt_mnt_ruc').val();  
								$('#div_contratos').modal('show');
						 
								//$("#tbl_det_contrato > thead").find("tr:gt(0)").remove();
								
								$('tr.item').each(function() {		
									var cod_tar_bol = $(this).find('.mes').text();
									if (!esnulo(cod_tar_bol)) {
										var row = $(this).closest('tr');
										row.remove();
									}						
								});	
								
								$('#btn_eliminar').show();								

								$.ajax({
									type: 'GET',
									url: '${pageContext.request.contextPath}/listarDetallesContrato',
									data: {
										cod_contrato : object
									},
									dataType: 'json',
									success: function(paramJson) {						
										if (paramJson[0] != null) {
											var datos_det_cont = paramJson[0];
											var row = 0;
											paramJson.forEach(function(entry) {
												row = row + 1;	
												var row_det = '<tr id="tr_'+row+'" class="item">'+
																'<td class="mes">'+entry.mes+'</td>'+
																'<td class="monto_mes">'+entry.monto_mes+'</td>'+
																'<td class="fec_pago">'+entry.fec_pago+'</td>';
																if (!esnulo(entry.chrNumCompPago)) {
																	row_det = row_det + '<td class="chrNumCompPago">'+entry.chrNumCompPago+'</td>';
																} else {
																	row_det = row_det + '<td class="chrNumCompPago"></td>';
																}
																if (!esnulo(entry.dteFecCompPago)) {
																	row_det = row_det + '<td class="dteFecCompPago">'+entry.dteFecCompPago+'</td>';
																} else {
																	row_det = row_det + '<td class="dteFecCompPago"></td>';
																}
										   						 row_det = row_det +  
																'<td>'+
																	'<button class="btn btn-sm btn-warning input-sm btn_edi_contrato">'+
																		'<i class="ace-icon fa fa-pencil-square-o"></i>'+
																	'</button>'+
																'</td>'+
																'<td>'+
																	'<button class="btn btn-sm btn-danger input-sm btn_rem_contrato">'+
																		'<i class="ace-icon fa fa-trash-o"></i>'+
																	'</button>'+																																	
																'</td>'+
															  '</tr>';		  
															  
												$('#tbl_det_contrato tr').eq(row-1).after(row_det);
											});
											
											
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
				$('#btn_eliminar').click(function(e) {					
					e.preventDefault();
					bootbox.dialog({
						message: "<span class='bigger-110'>Esta seguro de eliminar el contrato?</span>",
						buttons: {
							"click" : {
								"label" : "Aceptar",
								"className" : "btn-sm btn-primary",
								"callback": function() {
									var cod_contrato = $('#hid_contrato').val(); 
									$.ajax({
										type: 'POST',
										url: VAR_CONTEXT + '/eliminarContrato',
										data: {
											cod_contrato : cod_contrato
										},
										dataType: 'json',
										success: function(paramJson) {	
											endAjax();
											addInfoMessage(null, 'El registro fue eliminado.');
											$('#div_contratos').modal('hide');
											search();
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
							}, 
							"button" : {
								"label" : "Salir",
								"className" : "btn-sm"
							}
						}
					});
				});
				
				$('#btn_grabar').click(function(e) {		
					e.preventDefault();
					
					var cod_contrato = $('#hid_contrato').val(); 
					var cod_uni_operativa = $('#sel_mnt_uni_operativa').val();
					var cod_reg_nac = $('#sel_mnt_anp').val();
					var tip_contrato = $('#sel_mnt_tip_contrato').val();
					var num_contrato = $('#txt_mnt_num_contrato').val();
					var fec_inicio = $('#txt_mnt_fec_inicio').val();
					var fec_final = $('#txt_mnt_fec_fin').val();
					var concepto = $('#txt_mnt_concepto').val();
				
					if($('#txt_mnt_monto_contrato').val() != ''){
						var num_imp_contrato = $('#txt_mnt_monto_contrato').val();
						num_imp_contrato = num_imp_contrato.replace(",","");
						num_imp_contrato = num_imp_contrato.replace(",","");
					}
					if($('#txt_mnt_monto_garantia').val() != ''){
						var num_imp_garantia = $('#txt_mnt_monto_garantia').val();
						num_imp_garantia = num_imp_garantia.replace(",","");
						num_imp_garantia = num_imp_garantia.replace(",","");
					}
					if($('#txt_mnt_monto_alquiler').val() != ''){
						var num_imp_alquiler = $('#txt_mnt_monto_alquiler').val();
						num_imp_alquiler = num_imp_alquiler.replace(",","");
						num_imp_alquiler = num_imp_alquiler.replace(",","");
					}
					if($('#txt_mnt_monto_tributo').val() != ''){
						var num_imp_tributo = $('#txt_mnt_monto_tributo').val();
						num_imp_tributo = num_imp_tributo.replace(",","");
						num_imp_tributo = num_imp_tributo.replace(",","");
					}
					if($('#txt_mnt_intereses').val() != ''){
						var num_imp_interes = $('#txt_mnt_intereses').val();
						num_imp_interes = num_imp_interes.replace(",","");
						num_imp_interes = num_imp_interes.replace(",","");
					}
					if ('${ind_sed_principal}' == '1') {
			        	var chrTipOperacion = '${ind_sed_principal}';
			        }else {
			        	var chrTipOperacion = $('input[name="rb_mnt_tip_operacion"]:checked').val();	
			        }
		 			var cod_proveedor = $('#hid_proveedor').val(); 
					var cod_documento = $('#sel_mnt_tip_doc').val(); 
					var nom_concedente = $('#txt_mnt_nombres').val(); 
					var ape_concedente = $('#txt_mnt_apellidos').val(); 
					var raz_social = $('#txt_mnt_razon_social').val();  
					var num_ruc = $('#txt_mnt_ruc').val();    
					var srlIdMoneda = $('#sel_tip_moneda').val();
					
					
					var msg = '';
				 
					if (esnulo(num_contrato)) {
						msg = msg + 'El campo "Número de contrato" es obligatorio.<br/>';
					}
					
					if (esnulo(fec_inicio)) {
						msg = msg + 'El campo "Fecha Inicio" es obligatorio.<br/>';
					}
					if (esnulo(fec_final)) {
						msg = msg + 'El campo "Fecha Final" es obligatorio.<br/>';
					}
					
					if (esnulo(cod_proveedor)){
						msg = msg + 'El campo "Ruc " es obligatorio.<br/>';
					}
					
					if (!esnulo(msg)) {
						addWarnMessage(null, msg);
						return;
					}	
					
					var arr_detalle = '';					
					var row = 0;
					
					$('tr.item').each(function() {   
						var mes = $(this).find('.mes').text();
						if (!esnulo(mes)) {
							var monto_mes = $(this).find('.monto_mes').text();
							var fec_pago = $(this).find('.fec_pago').text();
							var chrNumCompPago = $(this).find('.chrNumCompPago').text();
							var dteFecCompPago =   $(this).find('.dteFecCompPago').text();
							if (esnulo(chrNumCompPago)) {
								chrNumCompPago = ' ';
							}
							if (esnulo(dteFecCompPago)) {
								dteFecCompPago = ' ';
							}													 
							arr_detalle = arr_detalle + mes + '|' + monto_mes + '|' + fec_pago +'|' + chrNumCompPago +'|' + dteFecCompPago + '_';
							row = row + 1;
						}
					});					
					
					if (!esnulo(arr_detalle)) {
						arr_detalle = arr_detalle.substring(0, arr_detalle.length - 1);
					}
					
					var new_record = true;
					if (!esnulo(cod_contrato)) {
						new_record = false;
					}
					startAjax();
													
					$.ajax({
						type: 'POST',
						url: VAR_CONTEXT + '/grabarContratos',
						data: { 
							cod_contrato : cod_contrato,
							cod_uni_operativa : cod_uni_operativa,
							cod_reg_nac : cod_reg_nac,						
							tip_contrato : tip_contrato,					
							num_contrato : num_contrato,					
							fec_inicio : fec_inicio,					
							fec_final : fec_final,					
							concepto : concepto,					
							num_imp_contrato : num_imp_contrato,					
							num_imp_garantia : num_imp_garantia,					
							num_imp_alquiler : num_imp_alquiler,					
							num_imp_tributo : num_imp_tributo,					
							num_imp_interes : num_imp_interes,					
							cod_proveedor : cod_proveedor,
							cod_documento : cod_documento,
							nom_concedente : nom_concedente,
							ape_concedente : ape_concedente,
							raz_social : raz_social,
							num_ruc : num_ruc,
							srlIdMoneda : srlIdMoneda,
							arr_detalle : arr_detalle,
							chrTipOperacion : chrTipOperacion
						},
						dataType: 'json',
						success: function(paramJson) {						
							if (paramJson != null) {
								endAjax();
								if (new_record) {
									$('#hid_contrato').val(paramJson);
									$('#btn_eliminar').show();
									addInfoMessage(null, 'El registro fue grabado.');
								} else {
									addInfoMessage(null, 'Registro Actualizado.');
								}
								$('#div_contratos').modal('hide');
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
				
				$('input:radio[name="rb_mnt_tip_operacion"]').change(function () {
			 		if ($(this).val() == "1") {
			 				$('#sel_mnt_uni_operativa').val("Seleccionar"); // Lima
			 				$('#sel_mnt_uni_operativa').prop('disabled', true);
			 				$('#sel_mnt_anp').prop('disabled', true);
			 			
			 		} else if($(this).val() == "2") {			 			
			 			$('#sel_mnt_anp').val("");			 			
			 			$('#sel_mnt_uni_operativa').val("Seleccionar");
			 			$('#sel_mnt_uni_operativa').removeAttr("disabled"); 
			 			$('#sel_mnt_anp').removeAttr("disabled"); 
			 		}
			 	});
				
				$('input:radio[name="rb_tip_operacion"]').change(function () {
			 		if ($(this).val() == "1") {
			 			$('#sel_mnt_uni_operativa').val("Seleccionar"); // Lima
				 				$('#sel_mnt_uni_operativa').prop('disabled', true);
				 				$('#sel_mnt_anp').prop('disabled', true);
			 		} else if($(this).val() == "2") {			 			
			 			$('#sel_mnt_anp').val("");			 			
			 			$('#sel_mnt_uni_operativa').val("Seleccionar");
			 			$('#sel_mnt_uni_operativa').removeAttr("disabled"); 
			 			$('#sel_mnt_anp').removeAttr("disabled"); 
			 		}
			 	});
				
				$('#tbl_det_contrato').on('click', '.btn_edi_contrato', function(e) { //erick 2
					e.preventDefault();
					$('#h_det_contrato').html('Editar Detalle');
					var row = $(this).closest('tr'); // Find the row
					$('#hid_par_detalle').val(row.attr('id'));
					
					// Extraemos los datos del registro
				    var mes = $.trim(row.find(".mes").text());
				    var monto_mes = $.trim(row.find(".monto_mes").text());
				    var fec_pago = $.trim(row.find(".fec_pago").text());
				    var chrNumCompPago = $.trim(row.find(".chrNumCompPago").text());
				    var dteFecCompPago = $.trim(row.find(".dteFecCompPago").text());
				 
					$('#txt_mes').val(mes);
					$('#txt_monto_mes').val(monto_mes);		
					$('#txt_fec_pago').val(fec_pago);		
					$('#txt_chrNumCompPago').val(chrNumCompPago);
					$('#txt_dteFecCompPago').val(dteFecCompPago);
					
					$('#btn_anadir').hide();
					$('#btn_editar').show();
					
					$('#div_det_contrato').modal('show');
				});
				
				
				 $('#txt_mnt_concepto').keyup(function() {
				        this.value = this.value.toUpperCase();
				   });
				 $('#txt_mnt_nombres').keyup(function() {
				        this.value = this.value.toUpperCase();
				   });
				 $('#txt_mnt_apellidos').keyup(function() {
				        this.value = this.value.toUpperCase();
				   });

				$('#btn_editar').click(function(e) {
					e.preventDefault();
					var mes = parseFloat($('#txt_mes').val());
					var monto_mes = parseFloat($('#txt_monto_mes').val());
					var fec_pago = $('#txt_fec_pago').val();
					var mes = parseInt($('#txt_mes').val());
					var monto_mes = parseFloat($('#txt_monto_mes').val());
					var fec_pago = $('#txt_fec_pago').val();
					
					
					var chrNumCompPago = parseFloat($('#txt_chrNumCompPago').val());
					var dteFecCompPago = $('#txt_dteFecCompPago').val();
					var chrNumCompPago = parseInt($('#txt_chrNumCompPago').val());
					
					if (!esnumero(mes)) {
						addWarnMessage(null, 'El campo "Mes" debe tener un valor entero mayor a 0.');
						return;
					}									
					if (!esnumero(monto_mes)) {
						addWarnMessage(null, 'El campo "Monto Mes" debe tener un valor numérico mayor a 0.');
						return;
					}								
					if (esnulo(fec_pago)) {
						addWarnMessage(null, 'El campo "Fecha de Pago" es obligatorio.');
						return;
					}
					
					var det_row = $('#hid_par_detalle').val();
								
					// Editamos el registro actual
					var row = 0;				
					var row_edit = '';	
					var valido = true;
					$('tr.item').each(function() {						
						row = row + 1;
						
						if (det_row == "tr_" + row) {
							row_edit = row;
						} else {
							var mes_val = $(this).find('.mes').text();
							if (mes_val == mes) {
								addWarnMessage(null, 'Mes ya registrado.');
								valido = false;
								return;
							}
							var monto_mes_val = $(this).find('.monto_mes').text();
							
							var fec_pago_val = $(this).find('.fec_pago').text();
							if (fec_pago_val == fec_pago) {
								addWarnMessage(null, 'Fecha de pago ya registrada.');
								valido = false;
								return;
							}
							var chrNumCompPago = $(this).find('.chrNumCompPago').text();
							var dteFecCompPago = $(this).find('.dteFecCompPago').text();
						}
					});
					if (!valido) {
						return;
					}
					$('#tbl_det_contrato tr').eq(row_edit).find('td').eq(0).html(mes);
					$('#tbl_det_contrato tr').eq(row_edit).find('td').eq(1).html(monto_mes);
					$('#tbl_det_contrato tr').eq(row_edit).find('td').eq(2).html(fec_pago);
					$('#tbl_det_contrato tr').eq(row_edit).find('td').eq(3).html(chrNumCompPago);
					$('#tbl_det_contrato tr').eq(row_edit).find('td').eq(4).html(dteFecCompPago);
					
					$('#div_det_contrato').modal('hide');
				});
				
				$('#tbl_det_contrato').on('click', '.btn_rem_contrato', function(e) {				
					e.preventDefault();
					
					var row = $(this).closest('tr');
					
					bootbox.dialog({
						message: "<span class='bigger-110'>Está seguro de eliminar el registro ?</span>",
						buttons: {
							"click" : {
								"label" : "Aceptar",
								"className" : "btn-sm btn-primary",
								"callback": function() {					
								 	// Removemos el registro actual
									row.remove();									
								}
							}, 
							"button" : {
								"label" : "Cancelar",
								"className" : "btn-sm"
							}
						}
					});									
				});	
				
				$('#sel_uni_operativa').on('change', function() {
					if (!esnulo($(this).val())) {
						obtenerAnp($(this).val());
					} else {
						$('#sel_anp').empty();
					}
				});	
				$('#sel_mnt_uni_operativa').on('change', function() {
					if (!esnulo($(this).val())) {
						obtenerAnpMnt($(this).val());
					} else {
						$('#sel_mnt_anp').empty();
					}
				});	

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
				function simpleCboAjaxPopulateParamWithSelect(parentId, parentParam, href, keyParamas, selectValue) {
				    $(parentId).html("");
				    getMapToDataSet(function(dataSet) {
				        var options = "";
				        options += "<option value=''>&#60Seleccione&#62</option>";
				        $.each(dataSet, function(i, item) {
				            options += "<option ";
				            if ((selectValue != null) && (selectValue == item[0])) {
				            	options += " selected ";
				            };
				            	options += " value='" + item[0] + "'>" + item[1] + "</option>";
				        });
				        $(parentId).html(options);
				    }, href, keyParamas, parentParam);
				}
				$('#txt_mnt_ruc').change(function() {
					$('#txt_mnt_nombres').val("");
					$('#txt_mnt_apellidos').val("");
					$('#txt_mnt_nro_doc').val("");
					$('#txt_mnt_razon_social').val("");
					
					var nro_ruc = $(this).val();
					if (!esnulo(nro_ruc)) {
						$.ajax({
							type: 'GET',
							url: '${pageContext.request.contextPath}/verificarRuc',
							data: {
								nro_ruc : nro_ruc
							},
							dataType: 'json',
							success: function(paramJson) {						
								if (paramJson.num_ruc != null) {								
									$('#hid_proveedor').val(paramJson.cod_proveedor);
									$('#txt_mnt_razon_social').val(paramJson.raz_social);
									$('#txt_mnt_nombres').val(paramJson.nombres.trim());
									$('#txt_mnt_apellidos').val(paramJson.ape_paterno.trim() + ' '+paramJson.ape_materno.trim());
									$('#sel_mnt_tip_doc').val(paramJson.cod_documento);
									$('#txt_mnt_nro_doc').val(paramJson.num_documento);
									
								} else {
									bootbox.dialog({
										message: "<span class='bigger-110'>El proveedor no existe, desea registrarlo?</span>",
										buttons: {
											"click" : {
												"label" : "Si",
												"className" : "btn-sm btn-primary",
												"callback": function() {												
													$('#form_reg_proveedor').trigger("reset");
													$('#txt_reg_ruc').val(nro_ruc);
													if (parseInt(nro_ruc.substring(0, 2)) == 20) { // Persona Juridica
														$('input[name=rb_tip_empresa][value="2"]').prop('checked', true);
														$('#txt_ape_paterno').prop('disabled', true);
														$('#txt_ape_materno').prop('disabled', true);
														$('#txt_reg_nombres').prop('disabled', true);
														$('#txt_reg_raz_social').prop('disabled', false);
													} else {
														$('input[name=rb_tip_empresa][value="1"]').prop('checked', true);
														$('#txt_reg_raz_social').prop('disabled', true);
														$('#txt_ape_paterno').prop('disabled', false);
														$('#txt_ape_materno').prop('disabled', false);
														$('#txt_reg_nombres').prop('disabled', false);
													}													
													$('#div_reg_proveedor').modal('show');										
												}
											}, 
											"button" : {
												"label" : "No",
												"className" : "btn-sm"
											}
										}
									});
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
 				});
				$('#btn_cancelar').click(function(e) {					
					e.preventDefault();
					$('#div_det_contrato').modal('hide');
				});
				$('.btn_agr_detalle').click(function(e) {					
					e.preventDefault();
					$('#h_det_contrato').html('Nuevo Detalle');
															
					$('#txt_mes').val('');
					$('#txt_monto_mes').val('');
					$('#txt_fec_pago').val('');
					$('#txt_chrNumCompPago').val('');
					$('#txt_dteFecCompPago').val('');
					
					$('#hid_partida').val('');
					$('#btn_anadir').show();
					$('#btn_editar').hide();
					$('#div_det_contrato').modal('show');
				});
				
				$('#btn_anadir').click(function(e) {					
					e.preventDefault();		
					var mes = parseInt($('#txt_mes').val());
					var monto_mes = parseFloat($('#txt_monto_mes').val());
					var fec_pago = $('#txt_fec_pago').val();
					var chrNumCompPago = $('#txt_chrNumCompPago').val();
					var dteFecCompPago = $('#txt_dteFecCompPago').val();
					
					if (!esnumero(mes)) {
						addWarnMessage(null, 'El campo "Mes" debe tener un valor entero mayor a 0.');
						return;
					}									
					if (!esnumero(monto_mes)) {
						addWarnMessage(null, 'El campo "Monto Mes" debe tener un valor numérico mayor a 0.');
						return;
					}								
					if (esnulo($('#txt_fec_pago').val())) {
						addWarnMessage(null, 'El campo "Fecha de Pago" es obligatorio.');
						return;
					}
					var row = 0;
					var valido = true;
					
					$('tr.item').each(function() {
						row = row + 1;	
						var mes_val = $(this).find('.mes').text();
						if (mes_val == mes) {
							addWarnMessage(null, 'Mes ya registrado.');
							valido = false;
							return;
						}
						var monto_mes_val = $(this).find('.monto_mes').text();
						
						var fec_pago_val = $(this).find('.fec_pago').text();
						if (fec_pago_val == fec_pago) {
							addWarnMessage(null, 'Fecha de pago ya registrada.');
							valido = false;
							return;
						}
						var chrNumCompPago_val = $(this).find('.chrNumCompPago').text();
						var dteFecCompPago_val = $(this).find('.dteFecCompPago').text();
						
					});
					if (!valido) {
						return;
					}
					var row_det = '<tr id="tr_'+row+'" class="item">'+
									'<td class="mes">'+mes+'</td>'+
									'<td class="monto_mes">'+monto_mes+'</td>'+
									'<td class="fec_pago">'+fec_pago+'</td>'+
									'<td class="chrNumCompPago">'+chrNumCompPago+'</td>'+
									'<td class="dteFecCompPago">'+dteFecCompPago+'</td>'+
									'<td>'+
										'<button class="btn btn-sm btn-warning input-sm btn_edi_contrato">'+
											'<i class="ace-icon fa fa-pencil-square-o"></i>'+
										'</button>'+
									'</td>'+
									'<td>'+
										'<button class="btn btn-sm btn-danger input-sm btn_rem_contrato">'+
											'<i class="ace-icon fa fa-trash-o"></i>'+
										'</button>'+																																	
									'</td>'+
								  '</tr>';		  
								  
					$('#tbl_det_contrato tr').eq(row-1).after(row_det);
					
					$('#div_det_contrato').modal('hide');
				});
				
				$('#btn_gra_proveedor').click(function(e) {			//erick		
					e.preventDefault();
										
					var num_ruc = $('#txt_reg_ruc').val();
					var tip_proveedor = $('input[name="rb_tip_empresa"]:checked').val();
					var tip_estado = $('input[name="rb_entidad"]:checked').val();
					var raz_social = $.trim($('#txt_reg_raz_social').val());
					var cod_documento = $('#sel_tip_doc').val();
					var num_documento = $('#txt_nro_doc').val();
					var ape_paterno = $.trim($('#txt_ape_paterno').val());
					var ape_materno = $.trim($('#txt_ape_materno').val());
					var nombres = $.trim($('#txt_reg_nombres').val());
					var mail = $.trim($('#txt_reg_correo').val());					
					var direccion = $.trim($('#txt_reg_direccion').val());
					var giro = $.trim($('#txt_gir_negocio').val());
					var telefono = $.trim($('#txt_tel_contacto').val());
					
					var msg = '';
					
					if (esnulo(tip_estado)) {
						msg = msg + 'El campo "Entidad" es obligatorio.<br/>';
					}
					
					if (parseInt(num_ruc.substring(0, 2)) == 20) {
						if (esnulo(raz_social)) {
							msg = msg + 'El campo "Razon Social" es obligatorio.<br/>';
						}						
					} else {
						if (esnulo(ape_paterno)) {
							msg = msg + 'El campo "Ape. Paterno" es obligatorio.<br/>';
						}
						if (esnulo(ape_materno)) {
							msg = msg + 'El campo "Ape. Materno" es obligatorio.<br/>';
						}
						if (esnulo(nombres)) {
							msg = msg + 'El campo "Nombres" es obligatorio.<br/>';
						}
					}
					
					if (!esnulo(msg)) {
						addWarnMessage(null, msg);
						return;
					}	
											
					$.ajax({
						type: 'POST',
						url: VAR_CONTEXT + '/grabarProveedor',
						data: { 
							num_ruc : num_ruc,
							tip_proveedor : tip_proveedor,
							tip_estado : tip_estado,
							raz_social : raz_social,
							cod_documento : cod_documento,
							num_documento : num_documento,
							ape_paterno : ape_paterno,
							ape_materno : ape_materno,
							nombres : nombres,
							mail : mail,
							direccion : direccion,
							giro : giro,
							telefono : telefono
						},
						dataType: 'json',
						success: function(paramJson) {						
							if (paramJson != null) {
								endAjax();
								$('input[name="rb_tip_proveedor"][value="'+tip_proveedor+'"]').prop('checked', true);
								$('input[name="rb_ent_publicas"][value="'+tip_estado+'"]').prop('checked', true);								
								$('#hid_proveedor').val(paramJson);
								$('#txt_raz_social').val(raz_social);
								$('#txt_nombres').val(nombres);
								$('#txt_apellidos').val(ape_paterno+ ' '+ape_materno);
								
								if (!esnulo(num_ruc)) {
									$.ajax({
										type: 'GET',
										url: '${pageContext.request.contextPath}/verificarRuc',
										data: {
											nro_ruc : num_ruc
										},
										dataType: 'json',
										success: function(paramJson) {						
											if (paramJson.num_ruc != null) {								
												$('#hid_proveedor').val(paramJson.cod_proveedor);
												$('#txt_mnt_razon_social').val(paramJson.raz_social);
												$('#txt_mnt_nombres').val(paramJson.nombres.trim());
												$('#txt_mnt_apellidos').val(paramJson.ape_paterno.trim() + ' '+paramJson.ape_materno.trim());
												$('#sel_mnt_tip_doc').val(paramJson.cod_documento);
												$('#txt_mnt_nro_doc').val(paramJson.num_documento);
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
								$('#div_reg_proveedor').hide();
								addInfoMessage(null, 'El registro fue grabado.');
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
				
				function inicializarDatos() {
					if ('${ind_sed_principal}' == '1') { // Usuario de Sede Central						
						$('input[name=rb_tip_operacion][value="1"]').prop('checked', true);
						$('input[name=rb_mnt_tip_operacion][value="1"]').prop('checked', true);
						
					} else {
						$('input[name=rb_tip_operacion][value="2"]').prop('checked', true);
						$('input[name=rb_mnt_tip_operacion][value="2"]').prop('checked', true);
					}
					$('input[name=rb_tip_operacion]').prop('disabled', true);
					$('input[name=rb_mnt_tip_operacion]').prop('disabled', true);
				}
				
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
