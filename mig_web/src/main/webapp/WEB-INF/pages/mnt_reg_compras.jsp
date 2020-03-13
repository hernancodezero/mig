<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta charset="utf-8" />
		<title>Registro de Compras</title>

		<%@ include file="components.jsp" %>
	</head>

	<body class="no-skin">
		de
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
							<li class="active">Registro de Compras</li>
						</ul>
					</div>
			
					<div class="page-content">		
						<div class="row">
							<div class="col-xs-12">					
								<form id="frm_compras" class="form-horizontal" role="form">
								
									<input type="hidden" id="hid_reg_compras" value="${codigo}">
									<input type="hidden" id="hid_proveedor">
									<input type="hidden" id="hid_partida">
									<input type="hidden" id="hid_meta">
									<input type="hidden" id="hid_par_ant">
									<input type="hidden" id="hid_cue_con">
									<input type="hidden" id="hid_cue_con_ant">
									<input type="hidden" id="hid_nro_cue_con">
									<input type="hidden" id="hid_tip_venta">
									<input type="hidden" id="hid_contrato">
									<input type="hidden" id="hid_uni_ope">
									<input type="hidden" id="hid_anp">
									<input type="hidden" id="hid_cod_pad_com">
									<input type="hidden" id="hid_personal">
								
									<fieldset class="fsStyle">
										<legend class="legendStyle">Datos de Operación Tesorería</legend>														
										<div class="form-group">
											<div class="col-sm-3">												
												<label class="control-label label-sm no-padding-left">Tipo de Operación:</label>
												
												<div class="radio">
													<label class="input-sm">
														<input type="radio" class="ace input-sm" name="rb_tip_operacion" value="1">
														<span class="lbl"> Rendicion</span>
													</label>
												</div>
												
												<div class="radio">
													<label class="input-sm">
														<input type="radio" class="ace input-sm" name="rb_tip_operacion" value="2">
														<span class="lbl"> Sede</span>
													</label>
												</div>
												<label class="col-sm-4 control-label label-sm no-padding-right">Nro Doc. R/C:</label>
												<div class="col-sm-7">
													<input type="text" id="txt_nro_doc_rc" class="form-control input-sm" maxlength="15" />
												</div>
												

											</div>
										
											<div class="col-sm-9">
												<div class="form-group">	
													<label class="col-sm-2 control-label label-sm no-padding-right">Año:</label>
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

													<label class="col-sm-2 control-label label-sm no-padding-right">Nro C/P:</label>
													<div class="col-sm-2">
														<input type="text" id="txt_nro_cp" class="form-control input-sm onlyNumbers" maxlength="10" />
													</div>
													
													<label class="col-sm-2 control-label label-sm no-padding-right">Imp. C/P:</label>
													<div class="col-sm-2">
														<input type="text" id="txt_imp_cp" class="form-control input-sm onlyAmounts" maxlength="10" />
													</div>
												</div>	
												
												<div class="form-group">
													<label class="col-sm-2 control-label label-sm no-padding-right">Periodo:</label>
													<div class="col-sm-2">
														<select id="sel_periodo" class="form-control input-sm">
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
													
													<label class="col-sm-2 control-label label-sm no-padding-right">Nro de SIAF:</label>
													<div class="col-sm-2">
														<input type="text" id="txt_nro_sia_operacion" class="form-control input-sm onlyNumbers" maxlength="10" />
													</div>												

													<label class="col-sm-2 control-label label-sm no-padding-right">Saldo:</label>
													<div class="col-sm-2">
														<input type="text" id="txt_saldo" class="form-control input-sm" disabled />
													</div>													
												</div>
												
												<div class="form-group">												
													<label class="col-sm-2 control-label label-sm no-padding-right">Fecha de Doc. R/C:</label>
													<div class="col-sm-2">
														<div class="input-group">
															<input class="form-control input-sm date-picker" id="txt_fec_doc_rc" type="text" />
															<span class="input-group-addon" id="sp_ico_fec_doc_rc">
																<i class="fa fa-calendar bigger-110"></i>
															</span>
														</div>
													</div>
													
													<label class="col-sm-2 control-label label-sm no-padding-right">Imp. R/C:</label>
													<div class="col-sm-2">
														<input type="text" id="txt_imp_rc" class="form-control input-sm" disabled />
													</div>
													
													<label class="col-sm-2 control-label label-sm no-padding-right">Estado:</label>
													<div class="col-sm-2">
														<input style="color:#FE2E2E;text-align:center;" type="text" id="txt_estado" class="form-control input-sm" disabled />
													</div>														

												</div>
											</div>
										</div>

									</fieldset>
									<div class="form-group">
										<div class="col-sm-6">
											<fieldset class="fsStyle">
												<legend class="legendStyle">Datos de los Tipos de Comprobantes de Gastos</legend>								
										
												<div class="form-group">
													<label class="col-sm-3 control-label label-sm no-padding-right">Fecha de Comprobante:</label>
													<div class="col-sm-3">
														<div class="input-group">
															<input class="form-control input-sm date-picker" id="txt_fec_comprobante" type="text" />
															<span class="input-group-addon" id="sp_ico_fec_comprobante">
																<i class="fa fa-calendar bigger-110"></i>
															</span>
														</div>
													</div>
																									
													<label class="col-sm-3 control-label label-sm no-padding-right">Tipo de Comprobante:</label>
													<div class="col-sm-3">
														<select id="sel_tip_comprobante" class="chosen-select form-control input-sm">
															<c:forEach items="${lis_tip_comprobante}" var="item">
																<option value="${item.cod_comprobante}">${item.nom_comprobante}</option>
															</c:forEach>
														</select>
													</div>
												</div>
												
												<div class="form-group">
													<label class="col-sm-3 control-label label-sm no-padding-right">Serie Comprobante:</label>
													<div class="col-sm-3">
														<input type="text" id="txt_ser_comprobante" class="form-control input-sm upperValue" maxlength="20" />
													</div>
													<label class="col-sm-3 control-label label-sm no-padding-right">Nro Comprobante:</label>
													<div class="col-sm-3">
														<input type="text" id="txt_nro_comprobante" class="form-control input-sm upperValue" maxlength="20" />
													</div>													
												</div>
												
												<div class="form-group">
													<label class="col-sm-3 control-label label-sm no-padding-right">Nro de C/P:</label>
													<div class="col-sm-3">
														<input type="text" id="txt_nro_cp_giro" class="form-control input-sm onlyNumbers" maxlength="10" />
													</div>
													
													<label class="col-sm-3 control-label label-sm no-padding-right">Nro de SIAF:</label>
													<div class="col-sm-3">
														<input type="text" id="txt_nro_siaf" class="form-control input-sm onlyNumbers" maxlength="10" />
													</div>
												</div>
												
												<div class="form-group">
													<label class="col-sm-3 control-label label-sm no-padding-right">Fte Fto:</label>
													<div class="col-sm-3">
														<select id="sel_fue_financiamiento" class="form-control input-sm">
															<c:forEach items="${lis_fue_financiamiento}" var="item">
																<option value="${item.cod_fte}">${item.nom_fte}</option>
															</c:forEach>
														</select>
													</div>
																									
													<label class="col-sm-3 control-label label-sm no-padding-right">Nro Cta Cte:</label>
													<div class="col-sm-3">
														<input type="text" id="txt_nro_ctacte" class="form-control input-sm onlyNumbers" maxlength="10" />
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
														<input type="text" id="txt_tip_cambio" class="form-control input-sm onlyAmounts" maxlength="10" disabled />
													</div>
												</div>
												<div class="form-group">
													<label class="col-sm-3 control-label label-sm no-padding-right">Forma de Pago:</label>
													<div class="col-sm-3">
														<select id="sel_for_pago" class="form-control input-sm">
															<c:forEach items="${lis_med_pago}" var="item">
																<option value="${item.cod_mediopagos}">${item.nom_entidad}</option>
															</c:forEach>
														</select>
													</div>	
																										<label class="col-sm-3 control-label label-sm no-padding-right">Nro Contrato:</label>
													<div class="col-sm-3">
														<input type="text" id="txt_nro_contrato" class="form-control input-sm onlyNumbers" maxlength="5" />
													</div>												
												</div>
												
												<div id="div_fact_afec" class="form-group">
													<label class="col-sm-3 control-label label-sm no-padding-right">Fact. Afectada:</label>
													<div class="col-sm-3">
														<input type="text" id="txt_fac_afectada" class="form-control input-sm" disabled />
													</div>
												</div>
												<div id="div_fact_ret" class="form-group">
													<label class="col-sm-3 control-label label-sm no-padding-right">Reten. Afectada:</label>
													<div class="col-sm-4">
														<select id="sel_tip_comprobante" class="chosen-select form-control input-sm">
															<c:forEach items="${lis_tip_comprobante}" var="item">
																<option value="${item.cod_comprobante}">${item.cod_comprobante}</option>
															</c:forEach>
														</select>
													</div>
												</div>
											</fieldset>
											
											<fieldset class="fsStyle">
												<legend class="legendStyle">Datos de Logistica (O/S - O/C)</legend>
												<div class="form-group">
													<label class="col-sm-3 control-label label-sm no-padding-right">Tipo de Orden:</label>
													<div class="col-sm-3">														
														<div class="radio">
															<label class="input-sm">
																<input type="radio" class="ace input-sm" name="rb_tip_orden" value="1" checked>
																<span class="lbl"> O/S</span>
															</label>
															<!--  &nbsp;-->													
															<label class="input-sm">
																<input type="radio" class="ace input-sm" name="rb_tip_orden" value="2" checked>
																<span class="lbl"> O/C</span>
															</label>
															<!--  &nbsp;-->
															<label class="input-sm">
																<input type="radio" class="ace input-sm" name="rb_tip_orden" value="3" checked>
																<span class="lbl"> N/A</span>
															</label>
														</div>
													</div>	
													<label class="col-sm-3 control-label label-sm no-padding-right">Fec de Orden:</label>
													<div class="col-sm-3">
														<div class="input-group">
														<input class="form-control input-sm date-picker" id="txt_fec_orden" type="text" />
															<span class="input-group-addon" id="sp_ico_fec_orden">
																<i class="fa fa-calendar bigger-110"></i>
															</span>
														</div>
													</div>	
													<label class="col-sm-3 control-label label-sm no-padding-right">Nro de Orden:</label>
													<div class="col-sm-3">
														<input type="text" id="txt_nro_orden" class="form-control input-sm onlyNumbers" maxlength="10" />
													</div>	
													<label class="col-sm-3 control-label label-sm no-padding-right">Fecha de Pago Orden:</label>
													<div class="col-sm-3">
														<div class="input-group">
														<input class="form-control input-sm date-picker" id="txt_fec_orden_pago" type="text" />
															<span class="input-group-addon" id="sp_ico_fec_orden_pago">
																<i class="fa fa-calendar bigger-110"></i>
															</span>
														</div>
													</div>																										
												</div>																						
											</fieldset>											
											
											
											<fieldset class="fsStyle">
												<legend class="legendStyle">Datos del Proveedor</legend>												
												<div class="form-group">
													<label class="col-sm-4 control-label label-sm">Tipo de Proveedor:</label>												
													<div class="col-sm-6">
														<div class="radio">
															<label class="input-sm">
																<input type="radio" class="ace input-sm" name="rb_tip_proveedor" value="1" disabled>
																<span class="lbl"> Natural</span>
															</label>
															&nbsp;&nbsp;
															<label class="input-sm">
																<input type="radio" class="ace input-sm" name="rb_tip_proveedor" value="2" disabled>
																<span class="lbl"> Juridico</span>
															</label>
														</div>
													</div>
												</div>
												
												<div class="form-group">
													<label class="col-sm-2 control-label label-sm no-padding-right">Nro RUC:</label>
													<div class="col-sm-3">
														<input type="text" id="txt_nro_ruc" class="form-control input-sm onlyNumbers" maxlength="11" />
													</div>
													<label class="col-sm-3 control-label label-sm">Entidades Públicas:</label>												
													<div class="col-sm-4">
														<div class="radio">
															<label class="input-sm">
																<input type="radio" class="ace input-sm" name="rb_ent_publicas" value="1" disabled>
																<span class="lbl"> Si</span>
															</label>
															<label class="input-sm">
																<input type="radio" class="ace input-sm" name="rb_ent_publicas" value="2" disabled	>
																<span class="lbl"> No</span>
															</label>
														</div>
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

										<div class="col-sm-6">
				
											<fieldset class="fsStyle">
												<legend class="legendStyle">Importes Gravadas y No Gravadas</legend>
												
												<div class="form-group">
													<div class="col-sm-12">													
														<div class="table-responsive">
															<table id="tbl_det_reg_gravado" class="table table-striped table-bordered table-hover">
																<thead>
																	<tr>
																		<th>Item</th>
																		<th>Partida</th>
																		<th>Meta</th>
																		<th>Servicio</th>
																		<th>Cuenta Contable</th>
																		<th>Importe</th>
																		<th id="th_tip_venta">Tipo de Compra</th>
																		<th class="hide"></th>
																		<th class="hide"></th>
																		<th class="hide"></th>
																		<th class="hide"></th>
																		<th class="hide"></th>
																		<th class="hide"></th>
																		<th class="hide"></th>
																		<th class="hide"></th>
																		<th class="hide"></th>
																		<th class="hide"></th>
																		<th class="hide"></th>
																		<th class="hide"></th>
																		<th></th>
																		<th></th>
																	</tr>
																</thead>
																
																<c:if test="${not empty lis_det_compras}">
																	<c:set var="count" value="1" scope="page" />
																	<c:forEach items="${lis_det_compras}" var="item">
																		<tr class="item">
																			<td>${count}</td>
																			<td class="par">${item.vcod_especifica}</td>
																			<td class="met">${item.cod_meta}</td>
																			<td class="ser">${item.des_especifica}</td>
																			<td class="cue">${item.nom_cuenta}</td>
																			<td class="imp">${item.num_imp_servicio}</td>
																			<td class="tip">${item.des_tip_venta}</td>
																			<td class="hide cod_ser">${item.cod_especifica}</td>
																			<td class="hide cod_cue">${item.cod_cuenta}</td>
																			<td class="hide nro_cue">${item.vcod_cuenta}</td>
																			<td class="hide cod_tip">${item.cod_tip_venta}</td>																			
																			<td class="hide imp_afecto">${item.num_imp_afecto}</td>
																			<td class="hide imp_igv">${item.num_imp_igv}</td>
																			<td class="hide imp_no_afecto">${item.num_imp_no_afecto}</td>
																			<td class="hide imp_isc">${item.num_imp_isc}</td>																			
																			<td class="hide ind_ret">${item.ind_retencion}</td>
																			<td class="hide num_ret">${item.num_retencion}</td>																			
																			<td class="hide fec_pag">${item.fec_pago}</td>														
																			<td>
																				<button class="btn btn-sm btn-warning input-sm btn_edi_partida">
																					<i class="ace-icon fa fa-pencil-square-o"></i>
																				</button>
																			</td>
																			<td>																		
																				<button class="btn btn-sm btn-danger input-sm btn_rem_partida">
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
																			<button class="btn btn-xs btn-success btn_agr_partida">
																				<i class="ace-icon fa fa-plus"></i>
																			</button>
																		</div>																	
																	</td>
																	<td class="par"></td>
																	<td class="met"></td>
																	<td class="ser"></td>
																	<td class="cue"></td>
																	<td class="imp"></td>
																	<td class="tip"></td>
																	<td class="hide cod_ser"></td>
																	<td class="hide cod_met"></td>
																	<td class="hide cod_cue"></td>
																	<td class="hide nro_cue"></td>																	
																	<td class="hide cod_tip"></td>																	
																	<td class="hide imp_afecto"></td>
																	<td class="hide imp_igv"></td>
																	<td class="hide imp_no_afecto"></td>
																	<td class="hide imp_isc"></td>
																	<td class="hide ind_ret"></td>
																	<td class="hide num_ret"></td>
																	<td class="hide fec_pag"></td>
																	<td></td>
																	<td></td>
																</tr>
																
															</table>
														</div>
													</div>		
												</div>
												
												<div class="form-group">
													<label class="col-sm-3 control-label label-sm no-padding-right">Importe Afecto:</label>
													<div class="col-sm-3">
														<input type="text" id="txt_imp_afecto" class="form-control input-sm" disabled />
													</div>
													
													<label class="col-sm-3 control-label label-sm no-padding-right">Impuesto:</label>
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
												   <div class="col-sm-6">
												          <label class="checkbox-inlne control-label label-sm no-padding-right">
												            <input type="checkbox" name="checkboxOpc1" value="1">
												            <span class="lbl">Retencion</span>												            
												          </label>
												          <!--  <label class="checkbox-inlne control-label label-sm no-padding-right">
												            <input type="checkbox" name="checkboxOpc2" value="1">
												            <span class="lbl">Medio de Pago</span>												            
												          </label>-->
									        
												   </div> 										
													
													<label class="col-sm-3 control-label label-sm no-padding-right">Importe Total:</label>
													<div class="col-sm-3">
														<input type="text" id="txt_imp_total" class="form-control input-sm" disabled />
													</div>
												</div>
																					
											</fieldset>
											<fieldset class="fsStyle">
												<legend class="legendStyle">Datos Servicios Públicos</legend>												
												<div class="form-group">
													<div class="col-sm-4">
														<div class="radio">
															<label class="input-sm">
																&nbsp;
																<input type="radio" class="ace input-sm" name="rb_ser_publico" value="1">
																<span class="lbl"> Pago Serv. Agua</span>
															</label>
														</div>
													</div>													
													<div class="col-sm-4">
														<div class="radio">
															<label class="input-sm">
																<input type="radio" class="ace input-sm" name="rb_ser_publico" value="2">
																<span class="lbl"> Pago Serv. Luz</span>
															</label>
														</div>
													</div>													
													<div class="col-sm-4">
														<div class="radio">
															<label class="input-sm">
																<input type="radio" class="ace input-sm" name="rb_ser_publico" value="3">
																<span class="lbl"> Pago Serv. Telefonía</span>
															</label>
														</div>
													</div>
												</div>												
												<div class="form-group">
													<label class="col-sm-2 control-label label-sm no-padding-right">Monto:</label>
													<div class="col-sm-3">
														<input type="text" id="txt_mon_ser_publico" class="form-control input-sm onlyAmounts" maxlength="10" />
													</div>
													
													<label class="col-sm-3 control-label label-sm no-padding-right">Fec. Pago:</label>
													<div class="col-sm-4">
														<div class="input-group">
															<input class="form-control input-sm date-picker" id="txt_fec_pago" type="text" />
															<span class="input-group-addon" id="sp_ico_fec_pago">
																<i class="fa fa-calendar bigger-110"></i>
															</span>
														</div>
													</div>
												</div>
												
												<div class="form-group">
													<div class="col-sm-5"></div>
												
													<label class="col-sm-3 control-label label-sm no-padding-right">Fec. Vto.:</label>
													<div class="col-sm-4">
														<div class="input-group">
															<input class="form-control input-sm date-picker" id="txt_fec_vto" type="text" />
															<span class="input-group-addon" id="sp_ico_fec_vto">
																<i class="fa fa-calendar bigger-110"></i>
															</span>
														</div>
													</div>
												</div>
												
											</fieldset>											
				
											<fieldset class="fsStyle">
												<legend class="legendStyle">Constancia de Depósito de Detracción</legend>
												
												<div class="form-group">
													<label class="col-sm-2 control-label label-sm no-padding-right">Número:</label>
													<div class="col-sm-3">
														<input type="text" id="txt_num_constancia" class="form-control input-sm" maxlength="18" />
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
											
											<div class="form-group">&nbsp;</div>
											
											<div class="form-group">
												<div class="col-sm-2">
													<c:if test="${indicador == 1}">
														<button id="btn_grabar" class="btn btn-sm btn-primary input-sm">
															<i class="ace-icon fa fa-check"></i>
															Grabar
														</button>
													</c:if>
												</div>
												
												<div class="col-sm-2">
													<c:if test="${indicador == 1}">
														<button id="btn_eliminar" class="btn btn-sm btn-danger input-sm">
															<i class="ace-icon fa fa-times"></i>
															Eliminar
														</button>
													</c:if>
												</div>
												<div class="col-sm-2">
													<c:if test="${indicador == 1}">
														<button id="btn_nuevo" class="btn btn-sm btn-success input-sm">
															<i class="ace-icon fa fa-plus-square"></i>
															Nuevo
														</button>
													</c:if>
												</div>																								
												<div class="col-sm-2">
													<c:if test="${indicador == 1}">
														<button id="btn_notas" class="btn btn-sm btn-purple input-sm">
															<i class="ace-icon fa fa-sticky-note-o"></i>
															Notas
														</button>
													</c:if>
												</div>
												
												<div class="col-sm-2">
													<button id="btn_salir" class="btn btn-sm input-sm">
														<i class="ace-icon fa fa-reply"></i>
														Salir
													</button>
												</div>																								
											</div>
										</div>
									</div>									
								</form>
							</div>
						</div>
					</div>
				</div>
			</div><!-- /.main-content -->
			<!-- Seccion de la Pantalla del Detalle del Comprobante -->
			<div id="div_det_reg_gravado" class="modal" tabindex="-1" data-keyboard="false" data-backdrop="static">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">&times;</button>
							<h4 id="h_det_reg_gravado" class="white bigger center"></h4>
						</div>
						
						<div class="modal-body">
							<div class="row">
								<div class="col-xs-12">
									<form id="form_det_reg_gravado" class="form-horizontal" role="form">
										<div class="form-group">																				
											<label class="col-sm-3 control-label input-sm no-padding-right">Partida:</label>											
											<div class="col-sm-4">
												<select id="sel_partida" class="form-control input-sm">
												</select>
												<input id="txt_partida" type="text" class="form-control input-sm" />
											</div>	
											<label class="col-sm-2 control-label input-sm no-padding-right">Meta:</label>											
											<div class="col-sm-2">
												<input type="text" id="txt_meta" class="form-control input-sm onlyAmounts" disabled />
											</div>																		
										</div>										

										<div class="form-group">																				
											<label class="col-sm-3 control-label input-sm no-padding-right">Servicio:</label>											
											<div class="col-sm-9">
												<input type="text" id="txt_servicio" class="form-control input-sm" disabled />
											</div>	
										</div>
										
										<div class="form-group">																				
											<label class="col-sm-3 control-label input-sm no-padding-right">Cuenta Contable:</label>											
											<div class="col-sm-6">
												<select id="sel_cue_contable" class="form-control input-sm">
												</select>
											</div>								
										</div>								
										
										<div id="div_ind_retencion" class="form-group">																				
											<label class="col-sm-3 control-label input-sm no-padding-right">Retención 4ta:</label>	
											<div class="col-sm-4">		
												<div class="radio">
													<label class="input-sm">
														<input type="radio" class="ace input-sm" name="rb_ind_retencion" value="S">
														<span class="lbl"> Si</span>
													</label>
													&nbsp;&nbsp;
													<label class="input-sm">
														<input type="radio" class="ace input-sm" name="rb_ind_retencion" value="N">
														<span class="lbl"> No</span>
													</label>
												</div>
											</div>
											
											<label class="col-sm-2 control-label label-sm no-padding-right">Fecha de Pago:</label>
											<div class="col-sm-3">
												<div class="input-group">
													<input class="form-control input-sm date-picker" id="txt_fec_pag_rec_hon" type="text" />
													<span class="input-group-addon" id="sp_ico_fec_pag_rec_hon">
														<i class="fa fa-calendar bigger-110"></i>
													</span>
												</div>
											</div>
										</div>
										
										<div id="div_num_retencion" class="form-group">																				
											<label class="col-sm-3 control-label input-sm no-padding-right">Número Suspensión:</label>											
											<div class="col-sm-5">
												<input type="text" id="txt_num_retencion" class="form-control input-sm" />
											</div>											
										</div>
										
										<div class="form-group">																				
											<label class="col-sm-3 control-label input-sm no-padding-right">Importe:</label>											
											<div class="col-sm-5">
												<input type="text" id="txt_importe" class="form-control input-sm onlyAmountsNegative" maxlength="10" />
											</div>
											
											<label id="lbl_sal_det_partida" class="col-sm-2 control-label input-sm no-padding-right">Saldo:</label>											
											<div class="col-sm-2">
												<input type="text" id="txt_sal_det_partida" class="form-control input-sm onlyAmounts" disabled />
											</div>										
										</div>
										
										<div id="div_tip_venta" class="form-group">																				
											<label class="col-sm-3 control-label input-sm no-padding-right">Tipo de Compra:</label>											
											<div class="col-sm-5">
												<select id="sel_tip_venta" class="form-control input-sm">
													<!--  <option value="1">Gravada</option>
													<option value="2">No Gravada</option>
													<option value="3">Exonerado</option> -->
													
													<option value="2">001 Gravada c/expor</option>
													<option value="1">002 Gravada Sernanp</option>
													<option value="3">003 Gravada s/expor</option>
													<option value="4">004 No Gravada</option>									
												</select>
											</div>	
										</div>
										
										<div id="div_imp_isc_cam" class="form-group">																				
											<label class="col-sm-3 control-label input-sm no-padding-right">Importe Camioneta:</label>											
											<div class="col-sm-5">
												<input type="text" id="txt_imp_isc_cam" class="form-control input-sm onlyAmounts" maxlength="10" />
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

			<!-- Seccion de la Pantalla de Proveedores -->
			<div id="div_reg_proveedor" class="modal" tabindex="-1" data-keyboard="false" data-backdrop="static">
				<div class="modal-dialog">
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
												<input type="text" id="txt_reg_raz_social" class="form-control input-sm upperValue" maxlength="100" />
											</div>	
										</div>									
										
										<div class="form-group">
											<label class="col-sm-3 control-label label-sm no-padding-right">Tipo Doc.:</label>
											<div class="col-sm-3">
												<select id="sel_tip_doc" class="form-control input-sm">
													<option>Seleccionar</option>
													<c:forEach items="${lis_tip_documento}" var="item">
														<option value="${item.cod_documento}">${item.nom_documento}</option>
													</c:forEach>
												</select>
											</div>
										
											<label class="col-sm-3 control-label input-sm no-padding-right">Nro Doc.:</label>											
											<div class="col-sm-3">
												<input type="text" id="txt_nro_doc" class="form-control input-sm onlyNumbers" maxlength="14" />
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

			<!-- Seccion de la Pantalla de las Notas -->
			<div id="div_reg_not_credito" class="modal" tabindex="-1" data-keyboard="false" data-backdrop="static">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">&times;</button>
							<h4 class="white bigger center">Registro de Información de C/P asociadas a: Fact, Boletas y RxH</h4>
						</div>
						
						<div class="modal-body">
							<div class="row">
								<div class="col-xs-12">
									<form id="form_det_reg_gravado" class="form-horizontal" role="form">
										<div class="form-group">																				
											<label class="col-sm-3 control-label input-sm no-padding-right">Tipo Comprobante:</label>											
											<div class="col-sm-3">
												<select id="sel_tip_com_nc" class="form-control input-sm">
													<option value="8">Nota de Crédito</option>
													<option value="9">Nota de Dédito</option>
													<option value="21">Retenciones IGV</option>
												</select>
											</div>
											
											<label class="col-sm-3 control-label label-sm no-padding-right">Fecha de Doc.:</label>
											<div class="col-sm-3">
												<div class="input-group">
													<input class="form-control input-sm date-picker" id="txt_fec_doc_nc" type="text" />
													<span class="input-group-addon" id="sp_ico_fec_doc_nc">
														<i class="fa fa-calendar bigger-110"></i>
													</span>
												</div>
											</div>							
										</div>										

										<div class="form-group">																				
											<label class="col-sm-3 control-label input-sm no-padding-right">Serie:</label>											
											<div class="col-sm-3">
												<input type="text" id="txt_ser_nc" class="form-control input-sm upperValue" maxlength="7" />
											</div>	
											
											<label class="col-sm-3 control-label label-sm no-padding-right">Nro Doc.:</label>
											<div class="col-sm-3">
												<input type="text" id="txt_nro_doc_nc" class="form-control input-sm upperValue" maxlength="10" />
											</div>
										</div>
										
										<div class="form-group">																				
											<label class="col-sm-3 control-label input-sm no-padding-right">Nro Fact.:</label>											
											<div class="col-sm-3">
												<input type="text" id="txt_nro_fac_nc" class="form-control input-sm" disabled />
											</div>					
											<label class="col-sm-3 control-label input-sm no-padding-right">Meta:</label>											
											<div class="col-sm-3">
												<input type="text" id="txt_meta_nc" class="form-control input-sm" disabled />
											</div>																		
										</div>														
												
										<div class="form-group">																				
											<label class="col-sm-2 control-label input-sm no-padding-right">Partida:</label>											
											<div class="col-sm-3">
												<input type="text" id="txt_nro_par_nc" class="form-control input-sm" disabled />
											</div>
											<div class="col-sm-7">
												<input type="text" id="txt_des_ser_nc" class="form-control input-sm" disabled />
											</div>										
										</div>
												
										<div class="form-group">																				
											<label class="col-sm-2 control-label input-sm no-padding-right">Cuenta:</label>											
											<div class="col-sm-3">
												<input type="text" id="txt_nro_cue_nc" class="form-control input-sm" disabled />
											</div>
											<div class="col-sm-7">
												<input type="text" id="txt_des_cue_nc" class="form-control input-sm" disabled />
											</div>										
										</div>														
										<div class="form-group">																				
											<label class="col-sm-2 control-label input-sm no-padding-right">Ruc:</label>											
											<div class="col-sm-3">
												<input type="text" id="txt_ruc_nc" class="form-control input-sm" disabled />
											</div>
											<div class="col-sm-7">
												<input type="text" id="txt_raz_soc_nc" class="form-control input-sm" disabled />
											</div>										
										</div>	
																				
										<div class="form-group">																				
											<label class="col-sm-2 control-label input-sm no-padding-right">Importe:</label>											
											<div class="col-sm-3">
												<input type="text" id="txt_imp_nc" class="form-control input-sm onlyAmounts" maxlength="10" />
											</div>
											
											<label id="lbl_tip_ven_nc" class="col-sm-2 control-label input-sm no-padding-right">Tipo de Compra:</label>											
											<div id="div_tip_ven_nc"  class="col-sm-3">
												<input type="text" id="txt_tip_ven_nc" class="form-control input-sm" disabled />
											</div>										
										</div>
										
										<div id="div_imp_isc_cam_nc" class="form-group">																				
											<label class="col-sm-3 control-label input-sm no-padding-right">Importe Camioneta:</label>											
											<div class="col-sm-5">
												<input type="text" id="txt_imp_isc_cam_nc" class="form-control input-sm onlyAmounts" maxlength="10" />
											</div>											
										</div>
										
										<div class="form-group">
											<label class="col-sm-3 control-label label-sm no-padding-right">Importe Afecto:</label>
											<div class="col-sm-3">
												<input type="text" id="txt_imp_afe_nc" class="form-control input-sm" disabled />
											</div>
											
											<label class="col-sm-3 control-label label-sm no-padding-right">Impuesto:</label>
											<div class="col-sm-3">
												<input type="text" id="txt_imp_igv_nc" class="form-control input-sm" disabled />
											</div>
										</div>
										
										<div class="form-group">
											<label class="col-sm-3 control-label label-sm no-padding-right">Importe No Afecto:</label>
											<div class="col-sm-3">
												<input type="text" id="txt_imp_no_afe_nc" class="form-control input-sm" disabled />
											</div>
											
											<label class="col-sm-3 control-label label-sm no-padding-right">Impuesto ISC:</label>
											<div class="col-sm-3">
												<input type="text" id="txt_imp_isc_nc" class="form-control input-sm" disabled />
											</div>
										</div>
										
										<div class="form-group">
											<div class="col-sm-6"></div>
											
											<label class="col-sm-3 control-label label-sm no-padding-right">Importe Total:</label>
											<div class="col-sm-3">
												<input type="text" id="txt_imp_tot_nc" class="form-control input-sm" disabled />
											</div>
										</div>																			
									</form>
								</div>
							</div>			
						</div>

						<div class="modal-footer">				
							<button id="btn_gra_not_credito" class="btn btn-sm btn-primary">
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
			
			<div id="div_reg_prestador" class="modal" tabindex="-1" data-keyboard="false" data-backdrop="static">
				<div class="modal-dialog modal-lg">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">&times;</button>
							<h4 class="white bigger center">Datos del Prestador</h4>
						</div>
						
						<div class="modal-body">
							<div class="row">
								<div class="col-xs-12">
									<form id="form_reg_prestador" class="form-horizontal" role="form">
									
										<div class="form-group">																				
											<label class="col-sm-1 control-label input-sm no-padding-right">RUC:</label>											
											<div class="col-sm-3">
												<input type="text" id="txt_reg_ruc_cuarta" class="form-control input-sm onlyNumbers" maxlength = "11" disabled/>
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
											<label class="col-sm-1 control-label input-sm no-padding-right">Correo ElÃƒÂ©ctronico:</label>											
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
		
			var arr_det_trans = [];
			var arr_det_recno = [];
			var arr_cue_contable = [];
			var arr_tip_com = [];
			var mon_imp_actual = 0;
			var tip_com = '';
			var num_ser = '';
			var num_com = '';
			var num_ser_nc = '';
			var num_com_nc = '';
			var indicador = parseInt('${indicador}');
		    <c:forEach items="${lis_tip_comprobante}" var="item">
		    	//valores de los comprobantes y la cantidad de digitos de serie y numero
		    	tip_com = '${item.cod_comprobante}_${item.num_serie}_${item.num_comprobante}';
				arr_tip_com.push(tip_com); 
			</c:forEach>
			
			<c:if test="${not empty lis_detalle}">
				arr_det_trans = [];
				arr_det_recno = [];
				var options = '';
				<c:forEach items="${lis_detalle}" var="item">
			    	var cod_esp = '${item.cod_especifica}'+'_'+'${item.des_especifica}'+'_'+trim('${item.cod_meta}');
					options += '<option value="'+cod_esp+'">'+'${item.vcod_especifica}'+' | '+'${item.cod_meta}'+'</option>';
					arr_det_trans.push(cod_esp+'_'+'${item.vcod_especifica}'+'_'+'${item.imp_saldo}'+'_'+'${item.cod_meta}');
					arr_det_recno.push(cod_esp);
				</c:forEach>
				$('#sel_partida').html(options);
			</c:if>
		
			$(document).ready(function() {
				
				$("#li_compras").addClass('active');
				if (indicador == 1) {
					$("#li_reg_compras").addClass('active');
				} else {					
					$("#li_mon_compras").addClass('active');					
				}

				$('.date-picker').datepicker({
					autoclose: true,
					todayHighlight: true
				});
				
				$('.input-group-addon').click(function(event){
					event.preventDefault();
					var id_sp = $(this).attr('id').substring(7);
					$('#txt_'+id_sp).datepicker('show');
				});
				
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
				
				$('#div_fact_ret').hide();
				inicializarDatos();
				
				$('input:radio[name="rb_tip_operacion"]').change(function() {			       
			        if ($(this).val() == 2) { // Sede
						$('#txt_nro_doc_rc').prop('disabled', true);
						$('#txt_fec_doc_rc').prop('disabled', true);
						$('#txt_nro_cp').prop('disabled', true);
						$('#txt_imp_cp').prop('disabled', true);						
						$('#txt_nro_sia_operacion').prop('disabled', true);						
						$('#txt_nro_doc_rc').val('');
						$('#txt_nro_cp').val('');
						$('#txt_imp_cp').val('');
						$('#txt_fec_doc_rc').val('');
						$('#txt_nro_sia_operacion').val('');
						$('#sel_partida').html('');						
						$('#hid_uni_ope').val(19); // UNIDAD OPERATIVA DE LIMA
						$('#hid_anp').val('');						
						$('#sel_partida').show();
						$('#txt_partida').hide();
			        } else { // Rendicion
						$('#txt_nro_doc_rc').prop('disabled', false);
						$('#txt_nro_cp').prop('disabled', false);
						$('#txt_fec_doc_rc').prop('disabled', false);
						$('#txt_nro_sia_operacion').prop('disabled', false);
						$('#sel_partida').hide();
						$('#txt_partida').show();
					}
			    });	
				
				$('#sel_periodo').on('change', function() {
					set_fec_cp($(this).val());
				});
								
				$('#sel_tip_comprobante').on('change', function() {
					var cod_comprobante = $(this).val();
					if(cod_comprobante==68){
						$('#div_fact_afec').hide();
						$('#div_fact_ret').show();						
					}else{
						$('#div_fact_afec').show();
						$('#div_fact_ret').hide();
					}
					for (var i=0; i < arr_tip_com.length; i++) {
						var fields = arr_tip_com[i].split('_');
						if (fields[0] == cod_comprobante) {
							num_ser = fields[1];							
							if (!esnulo(num_ser))	{						
								$('#txt_ser_comprobante').attr('maxlength', num_ser);
								var val_num_ser = $('#txt_ser_comprobante').val();
								if (!esnulo(val_num_ser)) {						
			 						$('#txt_ser_comprobante').val(padDigits(val_num_ser, parseInt(num_ser)));
								}
							} else {
								num_ser = '';
							}
							num_com = fields[2];
							if (!esnulo(num_com))	{	
								$('#txt_nro_comprobante').attr('maxlength', num_com);								
								var val_num_com = $('#txt_nro_comprobante').val();
								if (!esnulo(val_num_com)) {						
			 						$('#txt_nro_comprobante').val(padDigits(val_num_com, parseInt(num_com)));
								}
							} else {
								num_com = '';
							}
							break;
						}						
					}
					
					if (cod_comprobante == '3') { // Recibo por Honorarios						
						$('#txt_nro_ruc').attr('maxlength', 11);
						$('#th_tip_venta').hide();
						$('.tip').hide();
					} else {
						$('#txt_nro_ruc').attr('maxlength', 14);
						$('.tip').show();
					}

				});
				
				$('#txt_ser_comprobante').change(function() {
 					if (!esnulo(num_ser)) {						
 						$('#txt_ser_comprobante').val(padDigits($(this).val(), parseInt(num_ser)));
					}
 				});

				$('#txt_nro_comprobante').change(function() {
					if (!esnulo(num_com)) {						
 						$('#txt_nro_comprobante').val(padDigits($(this).val(), parseInt(num_com)));
					}
 				});

				$('#txt_nro_ctacte').change(function() {
					if (!esnulo(num_cta_cte)) {						
 						$('#txt_nro_ctacte').val(padDigits($(this).val(), parseInt(num_cta_cte)));
					}
 				});
				
				$('#txt_nro_cp_giro').change(function() {
					if (!esnulo(num_cp_giro)) {						
 						$('#txt_nro_cp_giro').val(padDigits($(this).val(), parseInt(num_cp_giro)));
					}
 				});

				$('#txt_nro_orden').change(function() {
					if (!esnulo(num_orden)) {						
 						$('#txt_nro_orden').val(padDigits($(this).val(), parseInt(num_orden)));
					}
 				});
				
				$('#sel_tip_moneda').on('change', function() {
					if ($(this).val() == '1') {
						$('#txt_tip_cambio').prop('disabled', true);
						$('#txt_tip_cambio').val('');
					} else {
						$('#txt_tip_cambio').prop('disabled', false);
					}
				});
				
				$('#txt_nro_cp').change(function() {
					if (!esnulo($(this).val())) {
						$.ajax({
							type: 'GET',
							url: '${pageContext.request.contextPath}/verificarTransferencia',
							data: {
								num_comprobante : $(this).val()
							},
							dataType: 'json',
							success: function(paramJson) {						
								if (paramJson.num_comprobante != null) {
									if (paramJson.int_id_registro == 1) {
										var imp_total = parseFloat(paramJson.imp_total);
										$('#txt_nro_sia_operacion').val(paramJson.num_siaf);											
										$('#txt_imp_cp').val(imp_total.toFixed(2));
										$('#hid_uni_ope').val(paramJson.cod_uni_operativa);
										$('#hid_anp').val(paramJson.cod_reg_nac);										
										if (!esnulo(paramJson.nro_doc_rc)) {
											$('#txt_nro_doc_rc').val(paramJson.nro_doc_rc);
										}
										if (!esnulo(paramJson.fec_doc_rc)) {
											$('#txt_fec_doc_rc').datepicker('setDate', get_for_date(paramJson.fec_doc_rc));
										}
										obt_det_transferencia(paramJson.imp_tot_rc, paramJson.imp_total, paramJson.lis_detalle);				
									} else {	
										addWarnMessage(null, 'La transferencia asociada no pertenece a la Unidad Operativa del usuario actual.');
										$('#txt_nro_sia_operacion').val('');
										$('#txt_imp_cp').val('');
										$('#hid_uni_ope').val('');
										$('#hid_anp').val('');
										$('#sel_partida').html('');
										arr_det_trans = null;
									}
								} else {
									addWarnMessage(null, 'El C/P no esta¡ registrado en transferencias.');
									$('#txt_nro_sia_operacion').val('');
									$('#txt_imp_cp').val('');
									$('#hid_uni_ope').val('');
									$('#hid_anp').val('');
									$('#sel_partida').html('');
									arr_det_trans = null;
								}	
							},
							error: function(jqXHR, error, errorThrown) {
								var msg = 'Error: Problemas con los datos de la Transferencia<br/>';
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
				
				$('#txt_nro_sia_operacion').change(function() {
					if (!esnulo($(this).val())) {
						$.ajax({
							type: 'GET',
							url: '${pageContext.request.contextPath}/verificarTransferencia',
							data: {
								num_siaf : $(this).val()
							},
							dataType: 'json',
							success: function(paramJson) {						
								if (paramJson.num_comprobante != null) {
									if (paramJson.int_id_registro == 1) {
										var imp_total = parseFloat(paramJson.imp_total);
										$('#txt_nro_cp').val(paramJson.num_comprobante);
										$('#txt_imp_cp').val(imp_total.toFixed(2));
										$('#hid_uni_ope').val(paramJson.cod_uni_operativa);
										$('#hid_anp').val(paramJson.cod_reg_nac);
										if (!esnulo(paramJson.nro_doc_rc)) {
											$('#txt_nro_doc_rc').val(paramJson.nro_doc_rc);
										}
										if (!esnulo(paramJson.fec_doc_rc)) {
											$('#txt_fec_doc_rc').datepicker('setDate', get_for_date(paramJson.fec_doc_rc));
										}
										obt_det_transferencia(paramJson.imp_tot_rc, paramJson.imp_total, paramJson.lis_detalle);
									} else {
										addWarnMessage(null, 'La transferencia asociada no pertenece a la Unidad Operativa del usuario actual.');
										$('#txt_nro_cp').val('');
										$('#txt_imp_cp').val('');
									}
								} else {
									addWarnMessage(null, 'El C/P no estÃ¡Â¡ registrado en transferencias.');
									$('#txt_nro_cp').val('');
									$('#txt_imp_cp').val('');
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
				
				$('#sel_partida').on('change', function() {
					var arr_partida = $(this).val().split('_');
					$('#hid_partida').val(arr_partida[0]);
					var servicio = arr_partida[1];
					var meta = arr_partida[2];
					$('#txt_servicio').val(servicio);
					$('#txt_meta').val(meta);
					if (servicio.indexOf('COMIONETA') > 0) {
						$('#div_imp_isc_cam').show();
					}
					
					for (var i=0; i < arr_det_trans.length; i++) {
						var fields = arr_det_trans[i].split('_');
						var field = arr_det_recno[i].split('_');
						//if (arr_partida[0]=== fields[0]+fields[1]+fields[2]) {
						if (arr_partida[0]+arr_partida[1]+arr_partida[2] === field[0]+field[1]+field[2]) {
							if(field[0]+field[1]+field[2] === fields[0]+fields[1]+fields[2]){
								//var fields = arr_det_trans[0].split('_');
								$('#txt_sal_det_partida').val(fields[4]);
								break;	
							}
						}		
					}
					
					obt_cue_contable(arr_partida[0], null);
				});
				
				$('#btn_cancelar').click(function(e) {					
					e.preventDefault();
					// Removemos las partidas utilizadas y validamos el detalle	
// 					rem_det_transferencia();
					$('#div_det_reg_gravado').modal('hide');
				});
				
				$('.btn_agr_partida').click(function(e) {					
					e.preventDefault();
					$('#h_det_reg_gravado').html('Nueva Partida');
					
					var tip_comprobante = $('#sel_tip_comprobante').val();
					if (tip_comprobante == '3') { // Recibo por Honorarios
						$('#div_ind_retencion').show();
						$('#div_num_retencion').show();
						$('input[name=rb_ind_retencion]').prop('checked', false);
						$('#txt_num_retencion').val('');
						$('#txt_num_retencion').prop('disabled', false);
						$('#txt_fec_pag_rec_hon').val('');
						$('#div_tip_venta').hide();
					} else {
						$('#div_ind_retencion').hide();
						$('#div_num_retencion').hide();
						$('#div_tip_venta').show();
						$('#sel_tip_venta').val('1');
					}	
					
					var tip_operacion = $('input[name="rb_tip_operacion"]:checked').val();
					if (tip_operacion == '1') { // Rendicion
						
						// Removemos las partidas utilizadas y validamos el detalle					
// 						var estado = rem_det_transferencia();
// 						if (!esnulo(estado)) {
// 							addWarnMessage(null, estado);
// 							return;
// 						}
						
						var arr_partida = $('#sel_partida').val().split('_');
						$('#hid_partida').val(arr_partida[0]);
						var servicio = arr_partida[1];
						var meta =  arr_partida[2];
						$('#txt_servicio').val(servicio);
						$('#txt_meta').val(meta);
						if (servicio.indexOf('COMIONETA') > 0) {
							$('#div_imp_isc_cam').show();
						} else {
							$('#txt_imp_isc_cam').val('');
							$('#div_imp_isc_cam').hide();
						}
						
						$('#sel_partida').show();
						$('#txt_partida').hide();
						$('#lbl_sal_det_partida').show();
						$('#txt_sal_det_partida').show();
						
						for (var i=0; i < arr_det_trans.length; i++) {
							var fields = arr_det_trans[i].split('_');
							if (arr_partida[0] == fields[0]) {
								$('#txt_sal_det_partida').val(fields[4]);
								break;							
							}						
						}
						
						obt_cue_contable(arr_partida[0], null);
						
					} else { // Sede
												
						$('#sel_partida').hide();
						$('#txt_partida').val('');
						$('#txt_partida').show();
						$('#txt_servicio').val('');
						$('#txt_meta').prop('disabled', false);;
						$('#txt_meta').val('');
						$('#hid_partida').val('');
						$('#hid_meta').val('');
						$('#lbl_sal_det_partida').hide();
						$('#txt_sal_det_partida').hide();
						$('#txt_sal_det_partida').val('');
						$('#sel_cue_contable').html('');
						$('#div_imp_isc_cam').hide();
					}

					$('#txt_importe').val('');
					
					$('#btn_anadir').show();
					$('#btn_editar').hide();
					$('#div_det_reg_gravado').modal('show');
				});
				
				$("#txt_partida").change(function() {
					$.ajax({
						type: 'GET',
						url: VAR_CONTEXT + '/verificarPartida',
						data: {
							partida: $(this).val()
						},
						dataType: 'json',
						success: function(paramJson) {						
							if (paramJson.srl_id_esp != null) {
								$('#hid_partida').val(paramJson.srl_id_esp);
								var servicio = paramJson.var_nom_especifica;
								$('#txt_servicio').val(servicio);								
								if (servicio.indexOf('COMIONETA') > 0) {
									$('#div_imp_isc_cam').show();
								} else {
									$('#txt_imp_isc_cam').val('');
									$('#div_imp_isc_cam').hide();
								}
								
								obt_cue_contable(paramJson.srl_id_esp, null);
							} else {
								$('#hid_partida').val('');
								addWarnMessage(null, 'No se encuentra registrado la actual partida.');
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
				
				$('#sel_tip_venta').change(function() {
					if ($(this).val() == '1') {
						var servicio = $('#txt_servicio').val();
						if (servicio.indexOf('COMIONETA') > 0) {
							$('#div_imp_isc_cam').show();
						}						
					} else {
						$('#txt_imp_isc_cam').val('');
						$('#div_imp_isc_cam').hide();
					}	
				});
				
				$('#btn_anadir').click(function(e) {					
					e.preventDefault();
					
					var cod_partida = null;					
					var partida = null;					
					var meta =$('#txt_meta').val();
					var cod_cuenta = $('#sel_cue_contable').val();
					var cuenta = $('#sel_cue_contable option[value="'+cod_cuenta+'"]').text();
					var servicio = $('#txt_servicio').val();
					var importe = parseFloat($('#txt_importe').val());
					var cod_tip_venta = $('#sel_tip_venta').val();
					var des_tip_venta = $('#sel_tip_venta').find('option:selected').text();
					var val_partida = $('#hid_partida').val();
					
					var tip_operacion = $('input[name="rb_tip_operacion"]:checked').val();
					if (tip_operacion == '1') { // Rendicion
						cod_partida = $('#sel_partida').val();
						partida = $('#sel_partida option[value="'+cod_partida+'"]').text();
						codigo_par = partida.substring(0,13);
					} else { // Sede
						partida = $('#txt_partida').val();
						codigo_par = partida.substring(0,13);
					}					
					
					var tip_comprobante = $('#sel_tip_comprobante').val();
					var ind_retencion = '';
					var num_retencion = '';
					var fec_pago = '';
					var impuesto = 0;
					if (tip_comprobante == '3') { // Recibo por Honorarios
						ind_retencion = $('input[name="rb_ind_retencion"]:checked').val();
						num_retencion = $('#txt_num_retencion').val();
						fec_pago = $('#txt_fec_pag_rec_hon').val();
						if (esnulo(ind_retencion)) {
							addWarnMessage(null, 'El campo "Retención" es obligatorio.');
							return;
						} else {
							if (ind_retencion == 'N' && esnulo(num_retencion)) {
								addWarnMessage(null, 'El campo "Número Suspensión" es obligatorio.');
								return;
							}
							if (ind_retencion == 'S') {
								impuesto = 0.08;
							}							
						}
						if (esnulo(fec_pago)) {
							addWarnMessage(null, 'El campo "Fecha de Pago" es obligatorio.');
							return;
						}
						des_tip_venta = '';
					} else {
						impuesto = 0.18;
					}
					
					if (esnulo(val_partida)) {
						addWarnMessage(null, 'No se encuentra registrado la actual partida, es necesario que exista previamente.');
						return;
					}			
				
					if (esnulo($('#txt_meta').val())) {
						addWarnMessage(null, 'El campo "Meta" es obligatorio.');
						return;
					}
					if (esnulo($('#txt_importe').val())) {
						addWarnMessage(null, 'El campo "Importe" es obligatorio.');
						return;
					}						
					if (esnulo(cod_cuenta)) {
						addWarnMessage(null, 'El campo "Cuenta Contable" es obligatorio.');
						return;
					}
					
					// Validamos que el monto este dentro del rango del detalle transfencia					
					for (var i=0; i < arr_det_trans.length; i++) {
						var fields = arr_det_trans[i].split('_');
						var field = arr_det_recno[i].split('_');
						var codigo = [val_partida,servicio,meta];
						//if (val_partida[0] == fields[0]) {
						if (codigo[0]+codigo[1]+codigo[2]===field[0]+field[1]+field[2] ) {
							if(field[0]+field[1]+field[2] === fields[0]+fields[1]+fields[2]){
								var imp_transferencia = parseFloat(fields[4]);
								if (importe > imp_transferencia) {
									addWarnMessage(null, 'El campo "Importe" no puede superar al monto de la partida transferencia.');
									return;
								}
								if (importe == 0) {
									addWarnMessage(null, 'El valor "Importe" es cero no es posible agregar la partida transferencia.');
									return;
								}
							}
						}						
					}

					
					var row = 0;										
					var imp_afecto = 0;
					var imp_igv = 0;
					var imp_no_afecto = 0;
					var imp_isc = 0;

					if (cod_tip_venta == '1' || cod_tip_venta == '2' || cod_tip_venta == '3') { // Gravada
						if (servicio.indexOf('COMIONETA') > 0) {
							imp_isc = parseFloat($('#txt_imp_isc_cam').val());
							imp_igv = (importe + imp_isc) * impuesto;
						} else {
							if (tip_comprobante == '3') { // Recibo por Honorarios
								imp_igv = importe * impuesto;
								imp_afecto = importe - imp_igv;
							} else {							
								imp_afecto = importe / (impuesto + 1);
								imp_igv = imp_afecto * impuesto;
							}
						}
					} else if (cod_tip_venta == '4' ) { // No Gravada
						imp_no_afecto = importe;
					} else { // Exonerado
						imp_no_afecto = importe;
					}					
					
					var imp_tot_afecto = imp_afecto;
					var imp_tot_igv = imp_igv;
					var imp_tot_no_afecto = imp_no_afecto;
					var imp_tot_isc = imp_isc;					
					var imp_total = imp_tot_afecto + imp_tot_igv + imp_tot_no_afecto + imp_tot_isc;

					$('tr.item').each(function() {
						row = row + 1;		
						var imp_partida = $(this).find('.imp').text();
						if (!esnulo(imp_partida)) {
							imp_total = imp_total + parseFloat(imp_partida);
							imp_tot_afecto = imp_tot_afecto + parseFloat($(this).find('.imp_afecto').text());
							imp_tot_igv = imp_tot_igv + parseFloat($(this).find('.imp_igv').text());
							imp_tot_no_afecto = imp_tot_no_afecto + parseFloat($(this).find('.imp_no_afecto').text());
							imp_tot_isc = imp_tot_isc + parseFloat($(this).find('.imp_isc').text());
						}
					});
					 
					$('#txt_imp_total').val(imp_total.toFixed(2));
					$('#txt_imp_afecto').val(imp_tot_afecto.toFixed(2));
					$('#txt_imp_igv').val(imp_tot_igv.toFixed(2));
					$('#txt_imp_no_afecto').val(imp_tot_no_afecto.toFixed(2));
					$('#txt_imp_isc').val(imp_tot_isc.toFixed(2));
					
					var row_det = '<tr id="tr_'+row+'" class="item">'+
									'<td>'+row+'</td>'+
									//'<td class="par">'+partida+'</td>'+
									'<td class="par">'+codigo_par+'</td>'+
									'<td class="met">'+meta+'</td>'+
									'<td class="cue">'+cuenta+'</td>'+
									'<td class="ser">'+servicio+'</td>'+
									'<td class="imp">'+importe.toFixed(2)+'</td>';
									
					if (tip_comprobante != '3') { // Diferente de Recibo por Honorarios
						row_det = row_det + '<td class="tip">'+des_tip_venta+'</td>';
					} else {
						row_det = row_det + '<td class="hide tip"></td>';
					}
					
					row_det = row_det + '<td class="hide cod_ser">'+val_partida+'</td>'+
										'<td class="hide cod_cue">'+cod_cuenta+'</td>'+									
										'<td class="hide nro_cue">'+obt_nro_cue_contable(cod_cuenta)+'</td>'+
										'<td class="hide cod_tip">'+cod_tip_venta+'</td>'+									
										'<td class="hide imp_afecto">'+imp_afecto+'</td>'+
										'<td class="hide imp_igv">'+imp_igv+'</td>'+
										'<td class="hide imp_no_afecto">'+imp_no_afecto+'</td>'+
										'<td class="hide imp_isc">'+imp_isc+'</td>'+									
										'<td class="hide ind_ret">'+ind_retencion+'</td>'+
										'<td class="hide num_ret">'+num_retencion+'</td>'+
										'<td class="hide fec_pag">'+fec_pago+'</td>'+
										'<td>'+
											'<button class="btn btn-sm btn-warning input-sm btn_edi_partida">'+
												'<i class="ace-icon fa fa-pencil-square-o"></i>'+
											'</button>'+
										'</td>'+
										'<td>'+
											'<button class="btn btn-sm btn-danger input-sm btn_rem_partida">'+
												'<i class="ace-icon fa fa-trash-o"></i>'+
											'</button>'+																																	
										'</td>'+
									  '</tr>';		  
								  
					$('#tbl_det_reg_gravado tr').eq(row-1).after(row_det);
					
					$('#div_det_reg_gravado').modal('hide');
				});
				
				$('#tbl_det_reg_gravado').on('click', '.btn_edi_partida', function(e) {
					e.preventDefault();
					$('#h_det_reg_gravado').html('Editar Partida de Transferencia');
					
					var row = $(this).closest('tr'); // Find the row
					
					// Extraemos los datos del registro
					var tip = $.trim(row.find('.tip').text());
				    var par = $.trim(row.find('.par').text());
				    var met = $.trim(row.find('.met').text());
				    var ser = $.trim(row.find('.ser').text());
				    var cue = $.trim(row.find('.cue').text());
				    var imp = $.trim(row.find('.imp').text());
				    
				    var cod_ser = $.trim(row.find('.cod_ser').text());
				    var cod_cue = $.trim(row.find('.cod_cue').text());
				    var nro_cue = $.trim(row.find('.nro_cue').text());
				    var cod_tip = $.trim(row.find('.cod_tip').text());	

					var tip_comprobante = $('#sel_tip_comprobante').val();
					var ind_retencion = '';
					var num_retencion = '';
					var fec_pago = '';
					if (tip_comprobante == '3') { // Recibo por Honorarios
						ind_retencion = $.trim(row.find('.ind_ret').text());
						num_retencion = $.trim(row.find('.num_ret').text());
						fec_pago = $.trim(row.find('.fec_pag').text());
						$('#div_ind_retencion').show();
						$('#div_num_retencion').show();
						if (ind_retencion == 'S') {
							$('#txt_num_retencion').prop('disabled', true);
						} else {
							$('#txt_num_retencion').prop('disabled', false);
						}						
						$('#div_tip_venta').hide();
					} else {
						$('#div_tip_venta').show();
						$('#div_ind_retencion').hide();
						$('#div_num_retencion').hide();
					}
					

				 	// Asignamos los datos del registro al formulario
				    var tip_operacion = $('input[name="rb_tip_operacion"]:checked').val();
					if (tip_operacion == '1') { // Rendicion
						
						// Removemos las partidas utilizadas y validamos el detalle					
// 						rem_det_transferencia();
						
						// Agregamos la partida utilizada al combo detalle
// 					    $('#sel_partida').append($('<option>', {
// 						    value: cod_ser+'_'+ser,
// 						    text: par
// 						}));
						
						$('#sel_partida').show();
						//$('#sel_partida').val(cod_ser+'_'+ser+'_'+met);
						$('#sel_partida').val(cod_ser);
						$('#txt_partida').hide();
						$('#lbl_sal_det_partida').show();
						$('#txt_sal_det_partida').show();	
				
						
						for (var i=0; i < arr_det_trans.length; i++) {
							var fields = arr_det_trans[i].split('_');
							var codigo =[cod_ser,ser,met];
							//if (cod_ser == fields[0]) {
							if (codigo[0,1,2] === fields[0,1,2]) {
								var imp_transferencia = parseFloat(fields[4]);
								$('#txt_sal_det_partida').val(imp_transferencia);
								break;
							}						
						}
						
					} else { // Sede
						$('#sel_partida').hide();
						$('#txt_partida').show();
						$('#txt_partida').val(par);
						$('#lbl_sal_det_partida').hide();
						$('#txt_sal_det_partida').hide();
						$('#txt_sal_det_partida').val('');
					}
					
					obt_cue_contable(cod_ser, cod_cue);
					
					$('#sel_cue_contable').val(cod_cue);
					
					$('#hid_cue_con').val(cod_cue);
					$('#hid_cue_con_ant').val(cod_cue);
					$('#hid_nro_cue_con').val(nro_cue);
					
					$('#txt_servicio').val(ser);
					$('#txt_meta').val(met);
					$('#txt_importe').val(imp);
					
					//$('#hid_partida').val(cod_ser);
					$('#hid_partida').val(cod_ser+'_'+ser+'_'+met);
					
					
					if (tip_comprobante == '3') { // Recibo por Honorarios
						$('input[name=rb_ind_retencion][value="'+ind_retencion+'"]').prop('checked', true);
						$('#txt_num_retencion').val(num_retencion);
						$('#sel_tip_venta').prop('disabled', true);
						$('#txt_fec_pag_rec_hon').val(fec_pago);
					} else {
						$('#sel_tip_venta').prop('disabled', false);
						$('#sel_tip_venta').val(cod_tip);
					}
					
					
					if (ser.indexOf('COMIONETA') > 0) {
						$('#div_imp_isc_cam').show();
					} else {
						$('#txt_imp_isc_cam').val(''); // Evaluar campo
						$('#div_imp_isc_cam').hide();
					}
					
					$('#btn_anadir').hide();
					$('#btn_editar').show();
					$('#hid_par_ant').val(cod_ser);
					
					$('#div_det_reg_gravado').modal('show');
				});
				
				$('#btn_editar').click(function(e) {
					e.preventDefault();
					
					var cod_partida = null;					
					var partida = null;
					var meta = $('#txt_meta').val();
					var cod_cuenta = $('#sel_cue_contable').val();
					var cuenta = $('#sel_cue_contable option[value="'+cod_cuenta+'"]').text();
					var servicio = $('#txt_servicio').val();
					var importe = parseFloat($('#txt_importe').val());
					var cod_tip_venta = $('#sel_tip_venta').val();
					var des_tip_venta = $('#sel_tip_venta').find('option:selected').text();
					var val_partida = $('#hid_partida').val();
					var val_par_ant = $('#hid_par_ant').val();
					
					
					var tip_operacion = $('input[name="rb_tip_operacion"]:checked').val();
					if (tip_operacion == '1') { // Rendicion
						cod_partida = $('#sel_partida').val();					
						partida = $('#sel_partida option[value="'+cod_partida+'"]').text();
						codigo_par = partida.substring(0,13);
					} else { // Sede
						partida = $('#txt_partida').val();
						codigo_par = partida.substring(0,13);
					}
					
					var tip_comprobante = $('#sel_tip_comprobante').val();
					var ind_retencion = '';
					var num_retencion = '';
					var fec_pago = '';
					var impuesto = 0;
					if (tip_comprobante == '3') { // Recibo por Honorarios
						ind_retencion = $('input[name="rb_ind_retencion"]:checked').val();
						num_retencion = $('#txt_num_retencion').val();	
						fec_pago = $('#txt_fec_pag_rec_hon').val();
						if (esnulo(ind_retencion)) {
							addWarnMessage(null, 'El campo "Retención" es obligatorio.');
							return;
						} else {
							if (ind_retencion == 'N' && esnulo(num_retencion)) {
								addWarnMessage(null, 'El campo "Número Suspensión" es obligatorio.');
								return;
							}
						}
						if (esnulo(fec_pago)) {
							addWarnMessage(null, 'El campo "Fecha de Pago" es obligatorio.');
							return;
						}
						des_tip_venta = '';
						if (ind_retencion == 'S') {
							impuesto = 0.08;
						}
					} else {
						impuesto = 0.18;
					}
					
					// Validamos que el monto este dentro del rango del detalle transfencia					
					for (var i=0; i < arr_det_trans.length; i++) {
						var fields = arr_det_trans[i].split('_');
						var codigo=[val_partida,servicio,meta];
						//if (val_partida == fields[0]) {
						if (codigo[0]+codigo[1]+codigo[2]==fields[0]+fields[1]+fields[2]) {
							var imp_transferencia = parseFloat(fields[4]);
							if (importe > imp_transferencia) {
								addWarnMessage(null, 'El campo "Importe" no puede superar al monto de la partida transferencia.');
								return;
							}
							if (importe == 0) {
								addWarnMessage(null, 'El valor "Importe" es cero no es posible agregar la partida transferencia.');
								return;
							}
						}						
					}
											
					// Editamos el registro actual
					var row = 0;				
					$('tr.item').each(function() {
						row = row + 1;
						var srl_cod_ser = $(this).find('.cod_ser').text();						
						if (srl_cod_ser == val_par_ant) {
							return false;
						}
					});

					if (cod_tip_venta == '1' || cod_tip_venta == '2' || cod_tip_venta == '3') { // Gravada
						if (servicio.indexOf('COMIONETA') > 0) {
							imp_isc = parseFloat($('#txt_imp_isc_cam').val());
							imp_igv = (importe + imp_isc) * impuesto;
						} else {
							if (tip_comprobante == '3') { // Recibo por Honorarios
								imp_igv = importe * impuesto;
								imp_afecto = importe - imp_igv;
								imp_no_afecto=0;
							} else {							
								imp_no_afecto=0;
								imp_afecto = importe / (impuesto + 1);
								imp_igv = imp_afecto * impuesto;
								$('#tbl_det_reg_gravado tr').eq(row).find('td').eq(13).html(imp_no_afecto);
							}
						}
					} else if (cod_tip_venta == '4') { // No Gravada
						imp_no_afecto = importe;						
						imp_isc=0;
						imp_afecto=0;
						imp_igv=0;
						$('#tbl_det_reg_gravado tr').eq(row).find('td').eq(13).html(imp_no_afecto);
						$('#tbl_det_reg_gravado tr').eq(row).find('td').eq(14).html(imp_isc);
					} /*else { // Exonerado
						imp_no_afecto = importe;
						$('#tbl_det_reg_gravado tr').eq(row).find('td').eq(13).html(imp_no_afecto);
						$('#tbl_det_reg_gravado tr').eq(row).find('td').eq(14).html(imp_isc);					
					}*/
					
					$('#tbl_det_reg_gravado tr').eq(row).find('td').eq(1).html(partida);
					//$('#tbl_det_reg_gravado tr').eq(row).find('td').eq(1).html(codigo_par);
					$('#tbl_det_reg_gravado tr').eq(row).find('td').eq(2).html(meta);
					$('#tbl_det_reg_gravado tr').eq(row).find('td').eq(3).html(servicio);
					$('#tbl_det_reg_gravado tr').eq(row).find('td').eq(4).html(cuenta);
					$('#tbl_det_reg_gravado tr').eq(row).find('td').eq(5).html(importe.toFixed(2));
					if (tip_comprobante != '3') { // Diferente de Recibo por Honorarios
						$('#tbl_det_reg_gravado tr').eq(row).find('td').eq(6).html(des_tip_venta);
					} else {
						$('#tbl_det_reg_gravado tr').eq(row).find('td').eq(6).html('');
					}
					$('#tbl_det_reg_gravado tr').eq(row).find('td').eq(7).html(val_partida);
					//$('#tbl_det_reg_gravado tr').eq(row).find('td').eq(1).html(codigo_par);
					$('#tbl_det_reg_gravado tr').eq(row).find('td').eq(8).html(cod_cuenta);
					$('#tbl_det_reg_gravado tr').eq(row).find('td').eq(9).html(obt_nro_cue_contable(cod_cuenta));
					$('#tbl_det_reg_gravado tr').eq(row).find('td').eq(10).html(cod_tip_venta);
					$('#tbl_det_reg_gravado tr').eq(row).find('td').eq(11).html(imp_afecto);
					$('#tbl_det_reg_gravado tr').eq(row).find('td').eq(12).html(imp_igv);

					$('#tbl_det_reg_gravado tr').eq(row).find('td').eq(15).html(ind_retencion);
					$('#tbl_det_reg_gravado tr').eq(row).find('td').eq(16).html(num_retencion);
					$('#tbl_det_reg_gravado tr').eq(row).find('td').eq(17).html(fec_pago);
					

					// Recalculamos el monto total considerando el registro actual
					var imp_tot_afecto = 0;
					var imp_tot_igv = 0;
					var imp_tot_no_afecto = 0;
					var imp_tot_isc = 0;					
					var imp_total = imp_tot_afecto + imp_tot_igv + imp_tot_no_afecto + imp_tot_isc;

					$('tr.item').each(function() {
						var imp_partida = $(this).find('.imp').text();
						var cod_tip_venta = $(this).val();
						
						if (!esnulo(imp_partida)) {
							
							imp_total = imp_total + parseFloat(imp_partida);					
							imp_tot_afecto = imp_tot_afecto + parseFloat($(this).find('.imp_afecto').text());
							imp_tot_igv = imp_tot_igv + parseFloat($(this).find('.imp_igv').text());
							imp_tot_no_afecto = imp_tot_no_afecto + parseFloat($(this).find('.imp_no_afecto').text());
							imp_tot_isc = imp_tot_isc + parseFloat($(this).find('.imp_isc').text());
						}
					});					 
					$('#txt_imp_total').val(imp_total.toFixed(2));
					$('#txt_imp_afecto').val(imp_tot_afecto.toFixed(2));
					$('#txt_imp_igv').val(imp_tot_igv.toFixed(2));
					$('#txt_imp_no_afecto').val(imp_tot_no_afecto.toFixed(2));
					$('#txt_imp_isc').val(imp_tot_isc.toFixed(2));
					
					// Removemos las partidas utilizadas y validamos el detalle	
// 					rem_det_transferencia();

					$('#div_det_reg_gravado').modal('hide');
				});
				
				$('#tbl_det_reg_gravado').on('click', '.btn_rem_partida', function(e) {				
					e.preventDefault();
					
					var row = $(this).closest('tr');
					
					bootbox.dialog({
						message: "<span class='bigger-110'>Esta seguro de eliminar el registro ?</span>",
						buttons: {
							"click" : {
								"label" : "Aceptar",
								"className" : "btn-sm btn-primary",
								"callback": function() {								
									
									// Extraemos los datos del registro
								    var par = row.find(".par").text();
								    var met = row.find(".met").text();
								    var ser = row.find(".ser").text();
								    var cod_ser = row.find(".cod_ser").text();					

								 	// Agregamos las partida utilizada al combo detalle
// 								    $('#sel_partida').append($('<option>', {
// 									    value: cod_ser+'_'+ser,
// 									    text: par
// 									}));
									
								 	// Removemos el registro actual
									row.remove();
									
									// Recalculamos el monto total
									var imp_tot_afecto = 0;
									var imp_tot_igv = 0;
									var imp_tot_no_afecto = 0;
									var imp_tot_isc = 0;					
									var imp_total = imp_tot_afecto + imp_tot_igv + imp_tot_no_afecto + imp_tot_isc;
									var row_num = 0;
									$('tr.item').each(function() {
										row_num = row_num + 1;		
										var imp_partida = $(this).find('.imp').text();
										if (!esnulo(imp_partida)) {
											imp_total = imp_total + parseFloat(imp_partida);
											imp_tot_afecto = imp_tot_afecto + parseFloat($(this).find('.imp_afecto').text());
											imp_tot_igv = imp_tot_igv + parseFloat($(this).find('.imp_igv').text());
											imp_tot_no_afecto = imp_tot_no_afecto + parseFloat($(this).find('.imp_no_afecto').text());
											imp_tot_isc = imp_tot_isc + parseFloat($(this).find('.imp_isc').text());
											$('#tbl_det_reg_gravado tr').eq(row_num).find('td').eq(0).html(row_num);
										}
									});
									 
									$('#txt_imp_total').val(imp_total.toFixed(2));
									$('#txt_imp_afecto').val(imp_tot_afecto.toFixed(2));
									$('#txt_imp_igv').val(imp_tot_igv.toFixed(2));
									$('#txt_imp_no_afecto').val(imp_tot_no_afecto.toFixed(2));
									$('#txt_imp_isc').val(imp_tot_isc.toFixed(2));									
								}
							}, 
							"button" : {
								"label" : "Cancelar",
								"className" : "btn-sm"
							}
						}
					});									
				});	
				
				$('#txt_nro_ruc').change(function() {
					var nro_ruc = $(this).val();
					if (!esnulo(nro_ruc)) {
						var tip_comprobante = $('#sel_tip_comprobante').val();
						if (tip_comprobante == '3') { // Recibo por Honorarios
							
							$.ajax({
								type: 'GET',
								url: '${pageContext.request.contextPath}/verificarRucCuarta',
								data: {
									numRuc : nro_ruc
								},
								dataType: 'json',
								success: function(paramJson) {						
									if (paramJson[0] != null) {	
										$('#hid_personal').val(paramJson[0].srlIdPersonal);
										$('#txt_nombres').val(paramJson[0].chrNombres);
										$('#txt_apellidos').val(trim(paramJson[0].chrApePaterno)+ ' '+trim(paramJson[0].chrApeMaterno));
									} else {
										bootbox.dialog({
											message: "<span class='bigger-110'>El prestador no existe, desea registrarlo?</span>",
											buttons: {
												"click" : {
													"label" : "Si",
													"className" : "btn-sm btn-primary",
													"callback": function() {												
														$('#form_reg_prestador').trigger('reset');
														$('#txt_reg_ruc_cuarta').val(nro_ruc);
														$('#sel_tip_doc_prestador').val('1'); // DNI
													 	$('#sel_tip_nacionalidad').val('193'); // Peru
													 	$('#sel_tip_convenio').val('N');
													 	$('#sel_convenio').val('1');
													 	$('#sel_domiciliado').val('S');
														$('#div_reg_prestador').modal('show');
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
							
						} else {	

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
										$('input[name="rb_tip_proveedor"][value="'+paramJson.tip_proveedor+'"]').prop('checked', true);
										$('input[name="rb_ent_publicas"][value="'+paramJson.tip_estado+'"]').prop('checked', true);
										$('#txt_raz_social').val(paramJson.raz_social);
										$('#txt_nombres').val(paramJson.nombres);
										$('#txt_apellidos').val(paramJson.ape_paterno+ ' '+paramJson.ape_materno);
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
														} else {
															$('input[name=rb_tip_empresa][value="1"]').prop('checked', true);
															$('#txt_reg_raz_social').prop('disabled', true);
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
					}
 				});

				$('#btn_gra_proveedor').click(function(e) {					
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
								
				$('#txt_nro_contrato').change(function() {
					if (!esnulo($(this).val())) {					
						$.ajax({
							type: 'GET',
							url: '${pageContext.request.contextPath}/listarContratos',
							data: {
								num_contrato : $(this).val()
							},
							dataType: 'json',
							success: function(paramJson) {						
								if (paramJson[0] != null) {							
									$('#hid_contrato').val(paramJson[0].cod_contrato);
									$('input[name="rb_tip_proveedor"][value="'+paramJson[0].tip_proveedor+'"]').prop('checked', true);
									$('input[name="rb_ent_publicas"][value="'+paramJson[0].tip_estado+'"]').prop('checked', true);								
									$('#hid_proveedor').val(paramJson[0].cod_proveedor);
									$('#txt_nro_ruc').val(paramJson[0].num_ruc);
									$('#txt_raz_social').val(paramJson[0].raz_social);
									$('#txt_nombres').val(paramJson[0].nombres);
									$('#txt_apellidos').val($.trim(paramJson[0].ape_paterno)+ ' '+$.trim(paramJson[0].ape_materno));
									$('#div_reg_proveedor').hide();
								} else {
									$('#hid_contrato').val('');
									addWarnMessage(null, 'El Numero de Contrato no estÃƒÂ¡ registrado en transferencias.');
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

				$('#btn_nuevo').click(function(e) {					
					e.preventDefault();					
					var url = '${pageContext.request.contextPath}/mnt_com_ingresos/${indicador}/0';
					$(location).attr('href', url);
					
					startAjax();
				});
				
				$('#btn_salir').click(function(e) {					
					e.preventDefault();					
					var url = '${pageContext.request.contextPath}/comprasIngreso/1';
					$(location).attr('href', url);		
				});
				
				
				$('#btn_grabar').click(function(e) {		
					e.preventDefault();

					var codigo = $('#hid_reg_compras').val();
					var tip_operacion = $('input[name="rb_tip_operacion"]:checked').val();
					var nro_doc_rc = $('#txt_nro_doc_rc').val();
					var nro_cp = $('#txt_nro_cp').val();
					var nro_sia_operacion = $('#txt_nro_sia_operacion').val();
					var imp_cp = $('#txt_imp_cp').val();					
					var fec_doc_rc = $('#txt_fec_doc_rc').val(); 
					var cod_comprobante = $('#sel_tip_comprobante').val();					
					var fec_comprobante = $('#txt_fec_comprobante').val();
					var ser_comprobante = $('#txt_ser_comprobante').val();
					var cod_fue_financiamiento = $('#sel_fue_financiamiento').val();
					var nro_comprobante = $('#txt_nro_comprobante').val();
					var nro_siaf = $('#txt_nro_siaf').val();
					var cod_moneda = $('#sel_tip_moneda').val();
					var num_tip_cambio = $('#txt_tip_cambio').val();					
					var cod_proveedor = $('#hid_proveedor').val();
					var ind_ser_publico = $('input[name="rb_ser_publico"]:checked').val();					
					var mon_ser_publico = $('#txt_mon_ser_publico').val();
					var fec_pago = $('#txt_fec_pago').val();
					var fec_vto = $('#txt_fec_vto').val();
					var imp_saldo = parseFloat($('#txt_saldo').val());
					var imp_total = parseFloat($('#txt_imp_total').val());
					var num_constancia = $('#txt_num_constancia').val();
					var fec_pag_deposito = $('#txt_fec_pag_deposito').val();
					var imp_deposito = $('#txt_imp_deposito').val();
					var por_deposito = $('#txt_por_deposito').val();
					var cod_contrato = $('#hid_contrato').val();
					var cod_uni_ope = $('#hid_uni_ope').val();
					var cod_anp = $('#hid_anp').val();
					var cod_mes = $('#sel_periodo').val();
					var cod_personal = $('#hid_personal').val();
					var num_cta_cte = $('#txt_nro_ctacte').val();
					var num_cp_giro = $('#txt_nro_cp_giro').val();		
					var ind_tip_orden = $('input[name="rb_tip_orden"]:checked').val();
					var fec_orden = $('#txt_fec_orden').val();
					var num_orden = $('#txt_nro_orden').val();
					var ind_cp_reten = $('input[name="checkboxOpc1"]:checked').val();
					var ind_med_pago = $('input[name="checkboxOpc2"]:checked').val();
					var cod_med_pago = $('#sel_for_pago').val();
					var fec_pago_cp = $('#txt_fec_orden_pago').val();
					var cod_anno = $('#sel_anno').val();
					var est_detraccion = false;					
					var msg = '';
					/*
					if (typeof ind_cp_reten === "undefined"){
						ind_cp_reten='';
					}
					if (typeof ind_med_pago === "undefined"){
						ind_med_pago='';
					}
					if (typeof ind_ser_publico === "undefined"){
						ind_ser_publico='';
					}*/
					if (cod_comprobante == '3') { // Recibo por Honorarios
						cod_proveedor = '';
					} else {
						cod_personal = '';
					}
					
// 					if (esnulo(ser_comprobante)) {
// 						msg = msg + 'El campo "Serie Comprobante" es obligatorio.<br/>';
// 					}				
// 					if (esnulo(nro_comprobante)) {
// 						msg = msg + 'El campo "Nro Comprobante" es obligatorio.<br/>';
// 					}
					if (esnulo(fec_comprobante)) {
						msg = msg + 'El campo "Fecha de Comprobante" es obligatorio.<br/>';
					} else {
						if (!checkdate(fec_comprobante)) {
							msg = msg + 'El campo "Fecha de Comprobante" tiene formato de fecha incorrecto.<br/>';
						}						
					}
					if (esnulo(cod_fue_financiamiento)) {
						msg = msg + 'El campo "Fte Fto" es obligatorio.<br/>';
					}
// 					if (esnulo(nro_siaf)) {
// 						msg = msg + 'El campo "SIAF" es obligatorio.<br/>';
// 					}	
					 // Diferente de Moneda Soles
					if (cod_moneda > 1 && esnulo(num_tip_cambio)) {
						msg = msg + 'El campo "Tipo de Cambio" es obligatorio.<br/>';
					}
					 					 
					if (!esnulo(cod_mes)) {										
						var anio = new Date().getFullYear();
						var dia = new Date(anio, cod_mes, 0).getUTCDate(); // Ultimo dia del mes
						var fec_periodo = dia + '/' + pad_zero(cod_mes, 2) + '/' + anio;
						if (comparafecha(fec_comprobante, fec_periodo) == 1) {
							msg = msg + 'El campo "Fecha de Comprobante" no puede ser mayor al periodo.';
						}
					}
					 
					if (!esnulo(msg)) {
						addWarnMessage(null, msg);
						return;
					}	
					
					// 1era Validacion - Nro de C/P					
					if (!esnulo(nro_cp) && tip_operacion == '1') { // Rendicion	
						if (esnulo(nro_doc_rc)) {
							msg = msg + 'El campo "Nro de Doc. R/C" es obligatorio.<br/>';
						}
						if (esnulo(nro_sia_operacion)) {
							msg = msg + 'El campo "Nro de SIAF" es obligatorio.<br/>';
						}
						if (esnulo(imp_cp)) {
							msg = msg + 'El campo "Imp. C/P" es obligatorio.<br/>';
						}
						if (!esnulo(msg)) {
							addWarnMessage(null, msg);
							return;
						}
					}
					
					// 2da Validacion - Deposito de Detraccion				
//					if (imp_total > 700) {
// 						msg = val_dep_detraccion(num_constancia, fec_pag_deposito, imp_deposito, por_deposito);
// 						if (!esnulo(msg)) {
// 							addWarnMessage(null, msg);
// 							return;
// 						}
//					}
					
					// 3era Validacion - Monto Total de Transferencia
					if (tip_operacion == '1') { // Rendicion
						if (imp_saldo == 0) {
							if (imp_total > imp_cp) {
								addWarnMessage(null, 'El Importe Total no puede superar al monto de la transferencia.');
								return;
							}
						} else {
							if (!esnulo(codigo)) { // Validacion de registro actual modificado
							var nue_monto = imp_saldo + mon_imp_actual;
								if (imp_total > nue_monto) {
									addWarnMessage(null, 'El Importe Total no puede superar al monto saldo de la transferencia.');
									return;
								}
							} else { // Validacion de registro nuevo					
								if (imp_total > imp_saldo) {
									addWarnMessage(null, 'El Importe Total no puede superar al monto saldo de la transferencia.');
									return;
								}
							}
						}
					}
					
					var arr_partida = '';
					var arr_meta = '';
					var arr_cue_contable = '';
					var arr_importe = '';
					var arr_tip_venta = '';					
					var arr_imp_afecto = '';
					var arr_imp_igv = '';
					var arr_imp_no_afecto = '';
					var arr_imp_isc = '';
					var arr_ind_ret = '';
					var arr_num_ret = '';
					var arr_fec_pag = '';
					var ser='';
					var row = 0;
					
					$('tr.item').each(function() {		
						var ind_servicio = $(this).find('.ser').text();
						if (!esnulo(ind_servicio)) {
							ser = $(this).find('.cod_ser').text();
							arr_partida = arr_partida + $(this).find('.cod_ser').text() + '|';
						    arr_meta = arr_meta + $(this).find('.met').text() + '|';
							arr_cue_contable = arr_cue_contable + $(this).find('.cod_cue').text() + '|';
							arr_importe = arr_importe + $(this).find('.imp').text() + '|';
							arr_tip_venta = arr_tip_venta + $(this).find('.cod_tip').text() + '|';							
							arr_imp_afecto = arr_imp_afecto + $(this).find('.imp_afecto').text() + '|';
							arr_imp_igv = arr_imp_igv + $(this).find('.imp_igv').text() + '|';
							arr_imp_no_afecto = arr_imp_no_afecto + $(this).find('.imp_no_afecto').text() + '|';
							arr_imp_isc = arr_imp_isc + $(this).find('.imp_isc').text() + '|';
							arr_ind_ret = arr_ind_ret + $(this).find('.ind_ret').text() + '|';
							arr_num_ret = arr_num_ret + $(this).find('.num_ret').text() + '|';
							arr_fec_pag = arr_fec_pag + $(this).find('.fec_pag').text() + '|';
							var servicio = $(this).find('.ser').text();
							var importe = parseFloat($(this).find('.imp').text());
							if (servicio.indexOf('MENSAJERIA') > 0 && importe > 400) {
								est_detraccion = true;
							}							
							row = row + 1;
						}						
					});
					
					if (row > 0) {
						arr_partida = arr_partida.substring(0, arr_partida.length - 1);
						arr_meta = arr_meta.substring(0, arr_meta.length - 1);
						arr_cue_contable = arr_cue_contable.substring(0, arr_cue_contable.length - 1);
						arr_importe = arr_importe.substring(0, arr_importe.length - 1);
						arr_tip_venta = arr_tip_venta.substring(0, arr_tip_venta.length - 1);						
						arr_imp_afecto = arr_imp_afecto.substring(0, arr_imp_afecto.length - 1);
						arr_imp_igv = arr_imp_igv.substring(0, arr_imp_igv.length - 1);
						arr_imp_no_afecto = arr_imp_no_afecto.substring(0, arr_imp_no_afecto.length - 1);
						arr_imp_isc = arr_imp_isc.substring(0, arr_imp_isc.length - 1);
						arr_ind_ret = arr_ind_ret.substring(0, arr_ind_ret.length - 1);
						arr_num_ret = arr_num_ret.substring(0, arr_num_ret.length - 1);
						arr_fec_pag = arr_fec_pag.substring(0, arr_fec_pag.length - 1);
					} else {
						addWarnMessage(null, 'Debe Agregar Detalle Partidas.');
						return;
					}
					
					
					var new_record = true;
					if (!esnulo(codigo)) {
						new_record = false;
					}
					
					var params = {
						cod_com_ingresos : codigo,
						tip_operacion : tip_operacion,						
						nro_doc_rc : nro_doc_rc,
						nro_cp : nro_cp,
						nro_sia_operacion : nro_sia_operacion,
						imp_cp : imp_cp,
						fec_doc_rc : fec_doc_rc,
						cod_comprobante : cod_comprobante,
						fec_comprobante : fec_comprobante,
						int_transaccion : 1, // Identificador de la transacciÃƒÂ³n Compras
						ser_comprobante : ser_comprobante,
						cod_fue_financiamiento : cod_fue_financiamiento,
						nro_comprobante : nro_comprobante,
						nro_siaf : nro_siaf,
						cod_moneda : cod_moneda,							
						num_tip_cambio : num_tip_cambio,
						cod_proveedor : cod_proveedor,
						ind_ser_publico : ind_ser_publico,
						mon_ser_publico : mon_ser_publico,
						fec_pago : fec_pago,
						fec_vto : fec_vto,
						imp_total : imp_total,
						num_constancia : num_constancia,
						fec_pag_deposito : fec_pag_deposito,
						imp_deposito : imp_deposito,
						por_deposito : por_deposito,
						cod_contrato : cod_contrato,							
						cod_uni_operativa : cod_uni_ope,
						cod_reg_nac : cod_anp,
						cod_mes : cod_mes,
						cod_anno : cod_anno,
						arr_partida : arr_partida,
						arr_meta: arr_meta, 
						arr_cue_contable : arr_cue_contable,
						arr_importe : arr_importe,
						arr_tip_venta : arr_tip_venta,
						arr_imp_afecto : arr_imp_afecto,
						arr_imp_no_afecto : arr_imp_no_afecto,
						arr_imp_igv : arr_imp_igv,
						arr_imp_isc : arr_imp_isc,
						arr_ind_ret : arr_ind_ret,
						arr_num_ret : arr_num_ret,
						arr_fec_pag : arr_fec_pag,
						cod_personal : cod_personal,
						num_cta_cte : num_cta_cte,
						num_cp_giro : num_cp_giro,
						ind_tip_orden : ind_tip_orden,
						fec_orden : fec_orden,
						num_orden : num_orden,
						ind_cp_reten : ind_cp_reten,
						ind_med_pago : ind_med_pago,
						cod_med_pago : cod_med_pago,
						fec_pago_cp : fec_pago_cp
					};
					
					if (esnulo(codigo)) { //Nuevo Registro
						startAjax();
						
						// Validamos el comprobante nuevo
						$.ajax({
							type: 'GET',
							url: '${pageContext.request.contextPath}/validarComprobante',
							data: {
								// Primera Validacion
								int_transaccion : 1, // Identificador de la transacciÃƒÂ³n Compras
								cod_uni_operativa : cod_uni_ope,
								cod_reg_nac : cod_anp,
								ser_comprobante : ser_comprobante,
								nro_comprobante : nro_comprobante,
								fec_comprobante : fec_comprobante,
								cod_mes : cod_mes,
								// Segunda Validacion
								cod_comprobante : cod_comprobante,
								cod_proveedor : cod_proveedor,
								cod_personal : cod_personal
							},
							dataType: 'json',
							success: function(paramJsonCom) {
								if (paramJsonCom == '1') {
									
									endAjax();
									addWarnMessage(null, 'Comprobante ya registrado.');
									return;
									
								} else if (paramJsonCom == '2') {
								
									endAjax();
									addWarnMessage(null, 'Su registro se encuentra dentro de un mes cerrado.');
									return;
									
								} else {
									
									// Validacion de registro de campos Serie, Numero y SIAF					
									if (esnulo(ser_comprobante) || esnulo(nro_comprobante) || esnulo(nro_siaf)) {
										bootbox.dialog({
											message: "<span class='bigger-110'>Uno de los siguientes campos: Serie, Nro C/P o SIAF, no han sido registrado, Desea Continuar?</span>",
											buttons: {
												"click" : {
													"label" : "Aceptar",
													"className" : "btn-sm btn-primary",
													"callback": function() {

														startAjax();
														
														$.ajax({
															type: 'POST',
															url: VAR_CONTEXT + '/grabarIngresoCompras',
															data: params,
															dataType: 'json',
															success: function(paramJson) {						
																if (paramJson != null) {
																	endAjax();
																	if (new_record) {
																		$('#hid_reg_compras').val(paramJson);
																		$('#btn_eliminar').show();
																		$('#btn_nuevo').show();
																		$('#btn_notas').show();
																		addInfoMessage(null, 'El registro fue grabado.');
																	} else {
																		addInfoMessage(null, 'Registro Actualizado.');
																	}								
																}
																$('#btn_nuevo').show();
															},
															error: function(jqXHR, error, errorThrown) {
																var msg = 'Error (Serie, Numero y SIAF):<br/>';
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
									} else {
																				
										$.ajax({
											type: 'POST',
											url: VAR_CONTEXT + '/grabarIngresoCompras',
											data: params,
											dataType: 'json',
											success: function(paramJson) {						
												if (paramJson != null) {
													endAjax();
													if (new_record) {
														$('#hid_reg_compras').val(paramJson);
														$('#btn_eliminar').show();
														$('#btn_nuevo').show();
														$('#btn_notas').show();
														addInfoMessage(null, 'El registro fue grabado.');
													} else {
														addInfoMessage(null, 'Registro Actualizado.');
													}								
												}	
												
											},
											error: function(jqXHR, error, errorThrown) {
												var msg = 'Error revisar los campos Serie, Numero y SIAF :<br/>';
												if (jqXHR.status && jqXHR.status == 400) {
													msg = msg + jqXHR.responseText;
												} else {
													msg = msg + errorThrown;
												}
												addErrorMessage(null, msg);
											}
										});
										
									}									
									
								}
							},
							error: function(jqXHR, error, errorThrown) {
								var msg = 'Error de Grabacion Nuevo Registro :<br/>';
								if (jqXHR.status && jqXHR.status == 400) {
									msg = msg + jqXHR.responseText;
								} else {
									msg = msg + errorThrown;
								}
								addErrorMessage(null, msg);
							}
						});
					
					//Actualizacion de Registro
					} else {
						
						startAjax();
						
						$.ajax({
							type: 'POST',
							url: VAR_CONTEXT + '/grabarIngresoCompras',
							data: params,
							dataType: 'json',
							success: function(paramJson) {						
								if (paramJson != null) {
									endAjax();
									addInfoMessage(null, 'Registro Actualizado.');							
								}	
							},
							//error: function(jqXHR, error, errorThrown) {
								error: function(jqXHR, textStatus, errorThrown) {
								var msg = 'Error No se Actualizo el Final del Registro:<br/>';

							/*	if (jqXHR.status && jqXHR.status == 400) {
									msg = msg + jqXHR.responseText;
								} else {
									msg = msg + errorThrown;
								}
								addErrorMessage(null, msg);*/
								if (jqXHR.status === 0) {
								    alert('Sin conectarse: Verificar Red.');
								  } else if (jqXHR.status == 404) {
								    alert('PÃ¡gina Solicitada no Encontrada [404]');
								  } else if (jqXHR.status == 500) {
								    alert('Error de Servidor Interno [500].');
								  } else if (textStatus === 'parsererror') {
								    alert('El analisis JSON solicitado fallo.');
								  } else if (textStatus === 'timeout') {
								    alert('Error de tiempo de espera.');
								  } else if (textStatus === 'abort') {
								    alert('Solicitud de Ajax abortada.');
								  } else {
								    alert('Error no Detectado: ' + jqXHR.responseText);
								  }
								//console.log(data);
							}



						});
						
					}
					
				});
				
				$('#btn_eliminar').click(function(e) {					
					e.preventDefault();
					bootbox.dialog({
						message: "<span class='bigger-110'>Esta seguro de ELIMINAR el Registro de la compra?</span>",
						buttons: {
							"click" : {
								"label" : "Aceptar",
								"className" : "btn-sm btn-primary",
								"callback": function() {
									var codigo = $('#hid_reg_compras').val();
									$.ajax({
										type: 'POST',
										url: VAR_CONTEXT + '/eliminarCompra',
										data: {
											cod_com_ingresos : $('#hid_reg_compras').val(),	
											cod_pad_com_ingresos : $('#hid_cod_pad_com').val() // Codigo padre
										},
										dataType: 'json',
										success: function(paramJson) {						
											if (paramJson != null) {								
												var url = VAR_CONTEXT + '/comprasIngreso/1';
												$(location).attr('href', url);
											}	
										},
										error: function(jqXHR, error, errorThrown) {
											var msg = 'Error - No se puede Eliminar el Registro:<br/>';
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
				
				//Notas de Credito
				$('#btn_notas').click(function(e) {					
					e.preventDefault(); //Evitar que un enlace abra la URL
					
					var cod_comprobante = $('#sel_tip_comprobante').val();
					var row = 0;
					var cod_par_nc = null;
					var cod_met_nc = null;
					var nro_par_nc = null;
					var des_ser_nc = null;
					var cod_cue_nc = null;
					var nro_cue_nc = null;
					var des_cue_nc = null;
					var cod_tip = null;
					var des_tip = null;

					
					$('tr.item').each(function() {						
						nro_cue_nc = $(this).find('.nro_cue').text();

						if (!esnulo(nro_cue_nc)) {
								cod_par_nc = $(this).find('.cod_ser').text();
								cod_met_nc = $(this).find('.met').text();
								nro_par_nc = $(this).find('.par').text();
								des_ser_nc = $(this).find('.ser').text();							
								cod_cue_nc = $(this).find('.cod_cue').text();							
								nro_cue_nc = $(this).find('.nro_cue').text();
								des_cue_nc = $(this).find('.cue').text();
								cod_tip = $(this).find('.cod_tip').text();
								des_tip = $(this).find('.tip').text();
								imp_afecto = $(this).find('.imp_afecto').text();
								imp_nafecto = $(this).find('.imp_no_afecto').text();
								imp_igv     = $(this).find('.imp_igv').text();
								imp_isc     = $(this).find('.imp_isc').text();
								row = row + 1;
								console.log("imp_afecto -> ", imp_afecto);
								return false;
						}									
					});
					
					if(esnulo(nro_cue_nc)){
						addWarnMessage(null,'Falta colocar el Nro de Cuenta Contable, Comuniquese con el Area de Tributos.');
						return;
					}
					if (row > 1) {
						addWarnMessage(null, 'No se puede generar una nota de credito, con mas de un detalle partidas.');
						return;
					}  

					if (cod_comprobante == '2' ||     // Factura
							cod_comprobante == '3' || // Recibo por Honorarios
							cod_comprobante == '4' || // Boleta de Venta
							cod_comprobante == '21') { //Retenciones Igv
						
						$('#txt_nro_fac_nc').val($('#txt_ser_comprobante').val()+'-'+$('#txt_nro_comprobante').val());
						$('#txt_ruc_nc').val($('#txt_nro_ruc').val());
						$('#txt_raz_soc_nc').val($('#txt_raz_social').val());
						$('#hid_partida').val(cod_par_nc);						
						$('#txt_nro_par_nc').val(nro_par_nc);
						$('#txt_meta_nc').val(cod_met_nc);
						$('#txt_des_ser_nc').val(des_ser_nc);
						$('#hid_cue_con').val(cod_cue_nc);
						$('#txt_nro_cue_nc').val(nro_cue_nc);
						$('#txt_des_cue_nc').val(des_cue_nc);
						$('#hid_tip_venta').val(cod_tip);
						$('#txt_imp_afe_nc').val(imp_afecto);
						$('#txt_imp_no_afe_nc').val(imp_nafecto);
						$('#txt_imp_igv_nc').val(imp_igv);
						$('#txt_imp_isc_nc').val(imp_isc);

						if (cod_comprobante == '3') { // Recibo por Honorarios
							$('#lbl_tip_ven_nc').hide();
							$('#div_tip_ven_nc').hide();
						} else {
							$('#txt_tip_ven_nc').val(des_tip);
						}
						
						if (cod_comprobante == '21') { // Comprobante de Retención
							$('#lbl_tip_ven_nc').hide();
							$('#div_tip_ven_nc').hide();
						} else {
							$('#txt_tip_ven_nc').val(des_tip);
						}						

						if (des_tip.indexOf('COMIONETA') > 0) {
							$('#div_imp_isc_cam_nc').show();
						} else {
							$('#txt_imp_isc_cam_nc').val('');
							$('#div_imp_isc_cam_nc').hide();
						}	
					} else {
						addWarnMessage(null, 'No se puede generar una nota de credito, con un "Tipo de Comprobante" que no sea Factura ó Recibo por Honorarios ó Boleta de Venta.');
						return;					
					}
						
					for (var i=0; i < arr_tip_com.length; i++) {
						var fields = arr_tip_com[i].split('_');
						if (fields[0] == $('#sel_tip_com_nc').val()) {
							num_ser_nc = fields[1];							
							if (!esnulo(num_ser_nc))	{						
								$('#txt_ser_nc').attr('maxlength', num_ser_nc);
								var val_num_ser = $('#txt_ser_comprobante').val();
								if (!esnulo(val_num_ser)) {						
			 						$('#txt_ser_nc').val(padDigits(val_num_ser, parseInt(num_ser_nc)));
								}
							} else {
								num_ser_nc = '';
							}
							num_com_nc = fields[2];
							if (!esnulo(num_com_nc))	{	
								$('#txt_nro_doc_nc').attr('maxlength', num_com_nc);								
								var val_num_com = $('#txt_nro_doc_nc').val();
								if (!esnulo(val_num_com)) {						
			 						$('#txt_nro_doc_nc').val(padDigits(val_num_com, parseInt(num_com_nc)));
								}
							} else {
								num_com_nc = '';
							}
							break;
						}						
					}
					
					$('#div_reg_not_credito').modal('show');
					
				});
				
				//Seleccion de Tipo de N/C
				
				$('#sel_tip_com_nc').on('change', function() {
					var cod_tip_nc = $(this).val(); 
					var cod_tip_venta = $('#hid_tip_venta').val();
					var importe_nr = 0;
					for (var i=0; i < arr_tip_com.length; i++) {
						var fields = arr_tip_com[i].split('_');
						if (fields[0] == $(this).val()) {
							num_ser_nc = fields[1];							
							if (!esnulo(num_ser_nc))	{						
								$('#txt_ser_nc').attr('maxlength', num_ser_nc);
								var val_num_ser = $('#txt_ser_comprobante').val();
								if (!esnulo(val_num_ser)) {						
			 						$('#txt_ser_nc').val(padDigits(val_num_ser, parseInt(num_ser_nc)));
								}
							} else {
								num_ser_nc = '';
							}
							num_com_nc = fields[2];
							if (!esnulo(num_com_nc))	{	
								$('#txt_nro_doc_nc').attr('maxlength', num_com_nc);								
								var val_num_com = $('#txt_nro_doc_nc').val();
								if (!esnulo(val_num_com)) {						
			 						$('#txt_nro_doc_nc').val(padDigits(val_num_com, parseInt(num_com_nc)));
								}
							} else {
								num_com_nc = '';
							}
							break;
						}	

					}	
					if(cod_tip_nc=='21' &&cod_tip_venta=='1'){						
						var importe_nr = (parseFloat(imp_afecto) + parseFloat(imp_igv) + parseFloat(imp_isc))*0.03;
						imp_total = importe_nr;
						imp_igv=0;
						imp_isc=0;
						imp_afecto=0,
						imp_no_afecto=0;
						$('#txt_imp_afe_nc').val(imp_afecto.toFixed(2));
						$('#txt_imp_igv_nc').val(imp_igv.toFixed(2));
						$('#txt_imp_nc').val(importe_nr.toFixed(2));
						$('#txt_imp_no_afe_nc').val(importe_nr.toFixed(2));
						$('#txt_imp_isc_nc').val(imp_isc.toFixed(2));						
						$('#txt_imp_tot_nc').val(imp_total.toFixed(2));		
					}
				});
				
				$('#txt_ser_nc').change(function() {
 					if (!esnulo(num_ser_nc)) {						
 						$('#txt_ser_nc').val(padDigits($(this).val(), parseInt(num_ser_nc)));
					}
 				});

				$('#txt_nro_doc_nc').change(function() {
					if (!esnulo(num_com_nc)) {						
 						$('#txt_nro_doc_nc').val(padDigits($(this).val(), parseInt(num_com_nc)));
					}
 				});
				
				$('#txt_imp_nc').change(function() {
					var cod_tip_nc =$('#sel_tip_com_nc').val()
					if (!esnulo($(this).val())) {					
						
						var importe = parseFloat($(this).val());	
						var cod_tip_venta = $('#hid_tip_venta').val();
						var servicio = $('#txt_tip_ven_nc').val();
						var imp_afecto = 0;
						var imp_igv = 0;
						var imp_no_afecto = 0;
						var imp_isc = 0;
						var imp_total = 0;

						if (cod_tip_venta == '1') { // Gravada
							if (servicio.indexOf('COMIONETA') > 0) {
								imp_isc = parseFloat($('#txt_imp_isc_cam_nc').val());
								imp_igv = (importe + imp_isc) * 0.18;
							} else {
								imp_afecto = importe / 1.18;
								imp_igv = imp_afecto * 0.18;							
							}
						} else if (cod_tip_venta == '2') { // No Gravada
							imp_no_afecto = importe;
						} else { // Exonerado
							imp_no_afecto = importe;
						}					
						
						if(cod_tip_nc=='8'||cod_tip_nc=='9'){
							imp_total = imp_afecto + imp_igv + imp_no_afecto + imp_isc;
							$('#txt_imp_afe_nc').val(imp_afecto.toFixed(2));
							$('#txt_imp_igv_nc').val(imp_igv.toFixed(2));
							$('#txt_imp_no_afe_nc').val(imp_no_afecto.toFixed(2));
							$('#txt_imp_isc_nc').val(imp_isc.toFixed(2));
							$('#txt_imp_tot_nc').val(imp_total.toFixed(2));							
						}
					}
 				});
				
				//Funcion Grabar Notas de Credito
				$('#btn_gra_not_credito').click(function(e) {					
					e.preventDefault();
					
					var cod_pad_com_ingresos = $('#hid_reg_compras').val();
					var cod_comprobante = $('#sel_tip_com_nc').val();
					var fec_comprobante = $('#txt_fec_doc_nc').val();
					var ser_comprobante = $('#txt_ser_nc').val();
					var nro_comprobante = $('#txt_nro_doc_nc').val();
					var importe = $('#txt_imp_nc').val();					
					var cod_partida = $('#hid_partida').val();
					var cod_meta = $('#txt_meta_nc').val();
					var cod_cue_con = $('#hid_cue_con').val();
					var cod_tip_venta = $('#hid_tip_venta').val();
					var imp_afecto = $('#txt_imp_afe_nc').val();
					var imp_igv = $('#txt_imp_igv_nc').val();
					var imp_no_afecto = $('#txt_imp_no_afe_nc').val();
					var imp_isc = $('#txt_imp_isc_nc').val();
					var imp_total = parseFloat($('#txt_imp_total').val());
					var msg = '';
					
					if (esnulo(fec_comprobante)) {
						msg = msg + 'El campo "Fecha Doc." es obligatorio.<br/>';
					} else {
						if (!checkdate(fec_comprobante)) {
							msg = msg + 'El campo "Fecha Doc." tiene formato de fecha incorrecto.<br/>';
						}						
					}
 					if (esnulo(ser_comprobante)) {
 						msg = msg + 'El campo "Serie" es obligatorio.<br/>';
 					}				
 					if (esnulo(nro_comprobante)) {
 						msg = msg + 'El campo "NÃƒÂºmero Doc." es obligatorio.<br/>';
 					}
 					if (esnulo(importe)) {
 						msg = msg + 'El campo "Importe" es obligatorio.<br/>';
 					} else {
 						if (parseFloat(importe) > imp_total) {
 							msg = msg + 'El importe no debe ser mayor al Importe Total.';
 						} 						
 					}
 					if (!esnulo(msg)) {
						addWarnMessage(null, msg);
						return;
					}
					
					startAjax();
					
					$.ajax({
						type: 'POST',
						url: VAR_CONTEXT + '/grabarNotaCredito',
						data: {
							cod_pad_com_ingresos : cod_pad_com_ingresos, // Codigo padre
							cod_comprobante : cod_comprobante,
							fec_comprobante : fec_comprobante,
							int_transaccion : 1, // Identificador de la transacciÃƒÂ³n Compras
							ser_comprobante : ser_comprobante,							
							nro_comprobante : nro_comprobante,							
							cod_partida : cod_partida,
							cod_meta : cod_meta,
							cod_cue_con : cod_cue_con,
							importe : importe,
							cod_tip_venta : cod_tip_venta,
							imp_afecto : imp_afecto,
							imp_no_afecto : imp_no_afecto,
							imp_igv : imp_igv,
							imp_isc : imp_isc,
							imp_total : $('#txt_imp_tot_nc').val()
						},
						dataType: 'json',
						success: function(paramJson) {						
							if (paramJson != null) {
								endAjax();
								$('#btn_notas').prop('disabled', true);
								addInfoMessage(null, 'El registro fue grabado.');								
								$('#div_reg_not_credito').modal('hide');
							}	
						},
						error: function(jqXHR, error, errorThrown) {
							var msg = 'Error al Grabar la N/C:<br/>';
							if (jqXHR.status && jqXHR.status == 400) {
								msg = msg + jqXHR.responseText;
							} else {
								msg = msg + errorThrown;
							}
							addErrorMessage(null, msg);
						}
					});
					
				});
				
				$('#sel_departamento').on('change', function() {
					obtenerprovincia($(this).val());
				});
				$('#sel_provincia').on('change', function() {
					obtenerdistrito($(this).val());
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
					if (departamento  == "Seleccionar" ) {
						msg = msg + 'El campo "Tipo de Departamento" es obligatorio.<br/>';
					}
					if (provincia  == "Seleccionar" ) {
						msg = msg + 'El campo "Tipo de Provincia" es obligatorio.<br/>';
					}
					if (distrito  == "Seleccionar" ) {
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
							   	idubigeo		 :	idubigeo 
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
				
				$('input[type=radio][name=rb_ind_retencion]').on('change', function() {
				    if ($(this).val() == 'S') {
				    	$('#sel_tip_venta').val('1');
				    	$('#txt_num_retencion').prop('disabled', true);
				    } else {
				    	$('#sel_tip_venta').val('3');
				    	$('#txt_num_retencion').prop('disabled', false);
				    }
				});
					
			});
			
			function inicializarDatos() {
				
				if (!esnulo($('#hid_reg_compras').val())) {
					var tip_operacion = '${compra.tip_operacion}';
					$('input[name=rb_tip_operacion][value="'+tip_operacion+'"]').prop('checked', true);
					$('#txt_nro_doc_rc').val('${compra.nro_doc_rc}');
					$('#txt_nro_cp').val('${compra.nro_cp}');
					$('#txt_nro_sia_operacion').val('${compra.nro_sia_operacion}');					
					$('#txt_imp_cp').val('${compra.imp_cp}');
					$('#txt_fec_doc_rc').val('${compra.fec_doc_rc}');
					var cod_comprobante = '${compra.cod_comprobante}';
					$('#txt_estado').val('${compra.estado}');
					var estado = '${compra.estado}'
					if(estado='ANULADO'){
						$('#btn_eliminar').prop('disabled', true);
					}
					if(estado='ACTIVO'){
						$('#btn_eliminar').prop('disabled', false);
					}					
					$('#sel_tip_comprobante').val(cod_comprobante);
					$('#txt_fec_comprobante').val('${compra.fec_comprobante}');
					$('#txt_ser_comprobante').val('${compra.ser_comprobante}');
					$('#sel_fue_financiamiento').val('${compra.cod_fue_financiamiento}');					
					$('#txt_nro_comprobante').val('${compra.nro_comprobante}');
					$('#txt_nro_siaf').val('${compra.nro_siaf}');
					$('#sel_tip_moneda').val('${compra.cod_moneda}');
					$('#txt_tip_cambio').val('${compra.num_tip_cambio}');
					if (cod_comprobante == '3') { // Recibo por Honorarios
						$('#hid_personal').val('${compra.cod_personal}');
						$('#txt_nro_ruc').val('${compra.num_ruc_personal}');
						$('#txt_nombres').val('${compra.nom_personal}');
						$('#txt_apellidos').val('${compra.ape_pat_personal}'+ ' '+'${compra.ape_mat_personal}');
						$('#th_tip_venta').hide();
						$('.tip').hide();
					} else {
						$('#hid_proveedor').val('${compra.cod_proveedor}');
						$('input[name="rb_tip_proveedor"][value="${compra.tip_proveedor}"]').prop('checked', true);
						$('input[name="rb_ent_publicas"][value="${compra.tip_estado}"]').prop('checked', true);
						$('#txt_nro_ruc').val('${compra.num_ruc}');
						$('#txt_raz_social').val('${compra.raz_social}');
						$('#txt_nombres').val('${compra.nombres}');
						$('#txt_apellidos').val('${compra.ape_paterno}'+ ' '+'${compra.ape_materno}');
					}
					$('#hid_contrato').val('${compra.cod_contrato}');
					$('#txt_nro_contrato').val('${compra.num_contrato}');
					$('#hid_uni_ope').val('${compra.cod_uni_operativa}');
					$('#hid_anp').val('${compra.cod_reg_nac}');
					$('input[name=rb_ser_publico][value="'+'${compra.ind_ser_publico}'+'"]').prop('checked', true);
					$('#txt_mon_ser_publico').val('${compra.mon_ser_publico}');
					$('#txt_fec_pago').val('${compra.fec_pago}');
					$('#txt_fec_vto').val('${compra.fec_vto}');
					$('#txt_num_constancia').val('${compra.num_constancia}');
					$('#txt_fec_pag_deposito').val('${compra.fec_pag_deposito}');
					$('#txt_imp_deposito').val('${compra.imp_deposito}');
					$('#txt_por_deposito').val('${compra.por_deposito}');
					$('#sel_periodo').val('${compra.cod_mes}');
					$('#sel_anno').val('${compra.cod_anno}');
					$('#txt_nro_ctacte').val('${compra.num_cta_cte}');
					$('#txt_nro_cp_giro').val('${compra.num_cp_giro}');
					$('input[name=rb_tip_orden][value="'+'${compra.ind_tip_orden}'+'"]').prop('checked', true);
					$('#txt_fec_orden').val('${compra.fec_orden}');
					$('#txt_nro_orden').val('${compra.num_orden}');
					$('input[name=checkboxOpc1][value="'+'${compra.ind_cp_reten}'+'"]').prop('checked', true);
					$('input[name=checkboxOpc2][value="'+'${compra.ind_med_pago}'+'"]').prop('checked', true);
					$('#txt_fec_orden_pago').val('${compra.fec_pago_cp}');
					
					var row = 0;
					var imp_tot_afecto = 0;
					var imp_tot_igv = 0;
					var imp_tot_no_afecto = 0;
					var imp_tot_isc = 0;
					$('tr.item').each(function() {
						row = row + 1;		
						var imp_partida = $(this).find('.imp').text();
						if (!esnulo(imp_partida)) {
							imp_tot_afecto = imp_tot_afecto + parseFloat($(this).find('.imp_afecto').text());
							imp_tot_igv = imp_tot_igv + parseFloat($(this).find('.imp_igv').text());
							imp_tot_no_afecto = imp_tot_no_afecto + parseFloat($(this).find('.imp_no_afecto').text());
							imp_tot_isc = imp_tot_isc + parseFloat($(this).find('.imp_isc').text());
						}
					});
					var imp_total = imp_tot_afecto + imp_tot_igv + imp_tot_no_afecto + imp_tot_isc;
					$('#txt_imp_total').val(imp_total.toFixed(2));
					$('#txt_imp_afecto').val(imp_tot_afecto.toFixed(2));
					$('#txt_imp_igv').val(imp_tot_igv.toFixed(2));
					$('#txt_imp_no_afecto').val(imp_tot_no_afecto.toFixed(2));
					$('#txt_imp_isc').val(imp_tot_isc.toFixed(2));
					
					mon_imp_actual = imp_total;
					
					if (tip_operacion == '1') { // Rendicion
						obt_det_transferencia('${transferencia.imp_tot_rc}', '${transferencia.imp_total}', null);
					}

					// Removemos las partidas utilizadas y validamos el detalle	
// 					rem_det_transferencia();
					
					if (indicador > 1) {
						$('#txt_nro_ruc').prop('disabled', true);
					}
					
					// Consultamos si el registro se puede editar de acuerdo al cierre de mes
					var ind_mes_cierre = '${ind_mes_cierre}';
					if (ind_mes_cierre == '0') {
						$('#btn_grabar').prop('disabled', true);
						$('#btn_eliminar').prop('disabled', true);
						$('#btn_nuevo').prop('disabled', true);
						$('#txt_nro_ruc').prop('disabled', true);
						$('#txt_nro_contrato').prop('disabled', true);
						$('.btn_agr_partida').prop('disabled', true);
						$('.btn_edi_partida').prop('disabled', true);
						$('.btn_rem_partida').prop('disabled', true);
						addWarnMessage(null, 'Su registro se encuentra dentro de un mes cerrado.');
					}
					
					// Validamos si esta habilitado la nota de credito
					var ind_not_credito = '${ind_not_credito}';
					if (ind_mes_cierre != '0' && 
							parseInt('${count}') <= 2 && // Solo asociar un detalle a la nota de credito o debito
							(cod_comprobante == '2' || // Factura
								cod_comprobante == '3' || // Recibo por Honorarios
								cod_comprobante == '4') && // Boleta de Venta
							ind_not_credito == '1') {
						$('#btn_notas').prop('disabled', false);
						
					} else {
						$('#btn_notas').prop('disabled', true);
					}		
					var cod_pad_com_ingresos = '${compra.cod_pad_com_ingresos}';
					$('#hid_cod_pad_com').val(cod_pad_com_ingresos);
					if (parseInt(cod_pad_com_ingresos) > 0) { // Si es una nota credito de debito
						$('.btn_agr_partida').prop('disabled', true);
						$('.btn_rem_partida').prop('disabled', true);
						$('#txt_fac_afectada').val('${nro_factura}');
					}	
					
					set_fec_cp('${compra.cod_mes}');
										
				} else {
					$('#btn_eliminar').hide();
					$('#btn_nuevo').hide();
					$('#btn_notas').hide();
					$('#sel_tip_comprobante').val('62'); // Comprobantes de Pago
					$('#sel_tip_moneda').val('1'); // Moneda Soles
					$('#sel_fue_financiamiento').val('1'); // Recursos Ordinarios
					$('#txt_imp_afecto').val(0);
					$('#txt_imp_igv').val(0);
					$('#txt_imp_no_afecto').val(0);
					$('#txt_imp_isc').val(0);
					
					var d = new Date();
					var mes = parseInt(d.getMonth()) + 1;
					$('#sel_periodo').val(mes);					
					
					set_fec_cp(mes);
								
				}
				
				$('#sel_tip_comprobante').trigger('chosen:updated');
				
				if ('${ind_sed_principal}' == '1') { // Usuario de Sede Central						
					$('input[name=rb_tip_operacion][value="'+2+'"]').prop('checked', true);
					$('#txt_nro_doc_rc').prop('disabled', false);
					$('#txt_fec_doc_rc').prop('disabled', false);
					$('#txt_nro_cp').prop('disabled', true);
					$('#txt_imp_cp').prop('disabled', true);
					$('#sp_ico_fec_doc_rc').hide();
					$('#txt_nro_sia_operacion').prop('disabled', true);
					$('#sel_partida').show();
					$('#txt_partida').hide();
					$('#hid_uni_ope').val('19'); // Lima
				}else { // Rendicion
					$('input[name=rb_tip_operacion][value="'+1+'"]').prop('checked', true);	
					$('#txt_nro_doc_rc').prop('disabled', false);
					$('#txt_nro_cp').prop('disabled', false);
					$('#txt_imp_cp').prop('disabled', true);
					$('#txt_fec_doc_rc').prop('disabled', false);
					$('#txt_nro_sia_operacion').prop('disabled', false);	
					$('#sel_partida').hide();
					$('#txt_partida').show();
				}
				$('input[name=rb_tip_operacion]').prop('disabled', true);
				
				for (var i=0; i < arr_tip_com.length; i++) {
					var fields = arr_tip_com[i].split('_');
					if (fields[0] == $('#sel_tip_comprobante').val()) {
						num_ser = fields[1];							
						if (!esnulo(num_ser))	{						
							$('#txt_ser_comprobante').attr('maxlength', num_ser);
						} else {
							num_ser = '';
						}
						num_com = fields[2];
						if (!esnulo(num_com))	{	
							$('#txt_nro_comprobante').attr('maxlength', num_com);
						} else {
							num_com = '';
						}
						break;
					}						
				}
				
			}
			
			//Funcion para validar Deposito de Detraccion
			function val_dep_detraccion(num_constancia, fec_pag_deposito, imp_deposito, por_deposito) {
				var msg = '';
				if (esnulo(num_constancia)) {
					msg = msg + 'El campo "Numero" es obligatorio.<br/>';
				}
				if (esnulo(fec_pag_deposito)) {
					msg = msg + 'El campo "Fecha de Pago" es obligatorio.<br/>';
				} else {
					if (!checkdate(fec_pag_deposito)) {
						msg = msg + 'El campo "Fecha de Comprobante" tiene formato de fecha incorrecto.<br/>';
					}						
				}
				if (esnulo(imp_deposito)) {
					msg = msg + 'El campo "Importe" es obligatorio.<br/>';
				}
				if (esnulo(por_deposito)) {
					msg = msg + 'El campo "Porcentaje" es obligatorio.<br/>';
				}
				return msg;				
			}
			
			//Obtener el detalle de la Transferencia
			function obt_det_transferencia(imp_tot_rc, imp_total, lis_detalle) {				
				var imp_tot_det = parseFloat(imp_tot_rc);
				if (imp_tot_det > 0) {
					var imp_saldo = parseFloat(imp_total) - imp_tot_det;
					$('#txt_imp_rc').val(imp_tot_det.toFixed(2));
					$('#txt_saldo').val(imp_saldo.toFixed(2));											
				} else {
					$('#txt_imp_rc').val(0.00);
					$('#txt_saldo').val(parseFloat(imp_total).toFixed(2))
					//$('#txt_saldo').val(parseFloat(imp_saldo).toFixed(2))
				}
				
				if (lis_detalle != null) {				
					// Cargamos el detalle de las partidas asociadas a la transferencia
					arr_det_trans = null;
					arr_det_trans = [];
					var options = '';
					$.each(lis_detalle, function(index, item) {
						//var cod_esp = trim(item.cod_especifica)+'_'+trim(item.des_especifica)+'_'+trim(item.cod_meta);
						if(trim(item.cod_meta)==null){
							addWarnMessage(null, 'La transferencia no tiene meta asociada');				
							
						}else{
							b=item.cod_meta.replace(/ /g, "");
						}
						
						var cod_esp = item.cod_especifica+'_'+item.des_especifica+'_'+b;
						options += '<option value="'+cod_esp+'">'+trim(item.vcod_especifica)+'  | '+trim(item.cod_meta)+'</option>';											
						arr_det_trans.push(cod_esp+'_'+item.vcod_especifica+'_'+item.imp_saldo); 
						arr_det_recno.push(cod_esp);

					});
					$('#sel_partida').html(options);
				}
			}
			
			//Remover detalles de la transferencia
			function rem_det_transferencia() {
				var row = 0;
				var ind_opc = 0;
				var det_trans = arr_det_trans.length;
				var arr_partida = '';
				
				// Removemos los duplicados
				var map = {};
				$('#sel_partida option').each(function () {
				    if (map[this.value]) {
				        $(this).remove()
				    }
				    map[this.value] = true;
				})

				$('tr.item').each(function() {		
					var ind_servicio = $(this).find('.ser').text();
					if (!esnulo(ind_servicio)) {
						row = row + 1;
					}						
				});					
				if (row > 0) {
					for (var i=0; i < det_trans; i++) {
						var fields = arr_det_trans[i].split('_');
						$('tr.item').each(function() {		
							var ind_partida = $(this).find('.par').text();
							if (!esnulo(ind_partida)) {
								if (fields[2] == ind_partida) {
									$('#sel_partida option:contains("'+ind_partida+'")').remove();
									ind_opc = ind_opc + 1;
								}									
							}						
						});							
					}						
					if (det_trans == ind_opc) {
						return 'No se puede agregar mas Importes Gravadas y No Gravadas';
					}
				}
				return '';
			}
			
			//Funcion de Obtener la Cuenta Contable de la Partida
			function obt_cue_contable(cod_especifica, sel_cue_contable) {
				$.ajax({
					type: 'GET',
					url: '${pageContext.request.contextPath}/listarCuentaContable',
					data: {
						cod_especifica : cod_especifica,
						fla_activo : 'S'
					},
					dataType: 'json',
					success: function(paramJson) {						
						if (paramJson != null) {							
							// Cargamos el detalle de las cuentas contables asociadas
							arr_cue_contable = null;
							arr_cue_contable = [];
							var options = '';
							$.each(paramJson, function(index, item) {
								options += '<option value="'+item.cod_cuenta+'">'+item.nom_cuenta+'</option>';											
								arr_cue_contable.push(item.cod_cuenta+'_'+item.nom_cuenta+'_'+item.vcod_cuenta);
							});
							$('#sel_cue_contable').html(options);
							if (sel_cue_contable != null) {
								$('#sel_cue_contable').val(sel_cue_contable);								
							}
						}
					},
					error: function(jqXHR, error, errorThrown) {
						var msg = 'Error de la Partidas y Cuentas Contables:<br/>';
						if (jqXHR.status && jqXHR.status == 400) {
							msg = msg + jqXHR.responseText;
						} else {
							msg = msg + errorThrown;
						}
						addErrorMessage(null, msg);
					}
				});
			}
			
			//Funcion de Obtener la Cuenta Contable
			function obt_nro_cue_contable(cod_cuenta) {
				for (var i=0; i < arr_cue_contable.length; i++) {
					var fields = arr_cue_contable[i].split('_');
					if (fields[0] == cod_cuenta) {
						return fields[2];
					}		
				}
			}
			
			//Funcion para setear el campo fecha de comprobante
			function set_fec_cp(campo) {
				var mes = parseInt(campo);
				var anio = new Date().getFullYear();
				var dia = new Date(anio, mes, 0).getUTCDate(); // Ultimo dia del mes
				var fecha = anio + '-' + mes + '-' + dia;
				// var fec_act = anio + '-' + mes + '-' + '01';
				// $('#txt_fec_comprobante').datepicker('setStartDate', new Date(fec_act));		
				$('#txt_fec_comprobante').datepicker('setEndDate', new Date(fecha));
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