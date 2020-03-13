<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta charset="utf-8" />
		<title>Registro de Ingresos</title>

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
								<form id="frm_compras" class="form-horizontal" role="form">
								
									<input type="hidden" id="hid_reg_compras" value="${codigo}">
									<input type="hidden" id="hid_proveedor">
									<input type="hidden" id="hid_partida">
									<input type="hidden" id="hid_par_ant">
									<input type="hidden" id="hid_contrato">
									<input type="hidden" id="hid_cod_pad_com">
									<input type="hidden" id="hid_des_tip">
									<input type="hidden" id="hid_pap">
									<input type="hidden" id="hid_cod_serie">

									<div class="form-group">
										<div class="col-sm-6">
										<fieldset class="fsStyle">
											<legend class="legendStyle">Datos de los Tipos de Comprobantes de Gastos</legend>
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
												<label class="col-sm-2 control-label label-sm no-padding-right">Estado:</label>
												<div class="col-sm-2">
													<input style="color:#FE2E2E;text-align:center;" type="text" id="txt_estado" class="form-control input-sm" disabled />
												</div>														
											</div>	
																			
											<div class="form-group">												
												<label class="col-sm-3 control-label label-sm no-padding-left">Tipo de Operación:</label>												
												<div class="col-sm-5">
													<div class="radio">
														<label class="input-sm">
															<input type="radio" class="ace input-sm" name="rb_tip_operacion" value="2">
															<span class="lbl"> Sede</span>
												 		</label>
													<!--</div>
													<div class="radio">		 -->										
														<label class="input-sm">
															<input type="radio" class="ace input-sm" name="rb_tip_operacion" value="1">
															<span class="lbl"> Unidad Operativa</span>
														</label>
													</div>
												</div>


												
											</div>
										
											<div class="form-group">
												<label class="col-sm-3 control-label label-sm no-padding-right">U.O. Solicitante:</label>
												<div class="col-sm-3">
													<select id="sel_uni_operativa" class="form-control input-sm">
														<option value=''>&#60Seleccione&#62</option>
														<c:forEach items="${lis_uni_operativa}" var="item">
														    <option value="${item.cod_uni_operativa}">${item.des_uni_operativa}</option>
														</c:forEach>
													</select>
												</div>
											
												<label class="col-sm-3 control-label label-sm no-padding-right">ANP:</label>
												<div class="col-sm-3">
													<select id="sel_anp" class="form-control input-sm">
													</select>
												</div>
											</div>
											
											<!--  Sucursal: -->
											<div class="form-group">
												<label class="col-sm-9 control-label label-sm no-padding-right">Sucursal:</label>
												<div class="col-sm-3">
												<select id="sel_sucursal" class="form-control input-sm"></select>
												</div>
											</div>
											<!--  Emision -->						
											<div class="form-group" id="div_radio_fact">
												<label id="lbl_emision" class="col-sm-3 control-label label-sm no-padding-right" >Emision del Comprobante:</label>
												<div >													
													<div class="radio">
														<label class="input-sm">
														<input type="radio" class="ace input-sm" id="op_factu" name="rb_tip_factu" value="1" checked>
														<span class="lbl">Electronica</span>
														</label>
														
														<label class="input-sm">
														<input type="radio" class="ace input-sm" id="op_factu" name="rb_tip_factu" value="2">
														<span class="lbl">Manual</span>
														</label>
													</div>
												</div>
													
											</div>
										
											<!--  Tipo de Comprobante: y Fecha de Comprobante:-->										
											<div class="form-group">
												<label class="col-sm-3 control-label label-sm no-padding-right" for="datepicker">Tipo de Comprobante:</label>
												<div class="col-sm-3">
													<select id="sel_tip_comprobante" class="chosen-select form-control input-sm">
														<c:forEach items="${lis_tip_comprobante}" var="item">
															<option value="${item.cod_comprobante}">${item.nom_comprobante}</option>
														</c:forEach>
													</select>
												</div>
												
												<label class="col-sm-3 control-label label-sm no-padding-right">Fecha de Comprobante:</label>
												<div class="col-sm-3">
													<div class="input-group">
														<input class="form-control input-sm date-picker" id="txt_fec_comprobante" type="text" />
														<!--<input type="text" id="txt_fec_comprobante_2" disabled />
														<span class="input-group-addon" id="sp_ico_fec_comprobante">
															<i class="fa fa-calendar bigger-110"></i>
														</span>-->
													</div>
												</div>
											</div>
											
											<div class="form-group">
												<label class="col-sm-3 control-label label-sm no-padding-right">Serie Comprobante:</label>
												<div class="col-sm-3">
													<input type="text" id="txt_ser_comprobante" class="form-control input-sm upperValue" maxlength="10" />
												</div>
												<label class="col-sm-3 control-label label-sm no-padding-right">Nro Comprobante:</label>
												<div class="col-sm-3">
													<input type="text" id="txt_nro_comprobante" class="form-control input-sm upperValue" maxlength="10" />
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
												<label class="col-sm-3 control-label label-sm no-padding-right">Nro. Cta. Cte:</label>
												<div class="col-sm-3">
													<!--  <input type="text" id="txt_num_cta_cte" class="form-control input-sm" maxlength="15" />-->
													<select id="sel_ctacte" class="form-control input-sm">
														<c:forEach items="${lis_cta_corriente}" var="item">
															<option value="${item.cod_cta}">${item.nom_cta}</option>
														</c:forEach>
													</select>													
												</div>												
											</div>
											<!--  Tipo de Cambio  -->
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
											<!--  Forma de Pago y SIAF  -->
											<div class="form-group" ">
												<!--  <div id="div_for_pago_tupa" class="form-group">-->
													<label class="col-sm-3 control-label label-sm no-padding-right">Forma de Pago:</label>
													<div class="col-sm-3">
														<select id="sel_for_pago" class="form-control input-sm">
															<c:forEach items="${lis_med_pago}" var="item">
																<option value="${item.cod_mediopagos}">${item.nom_entidad}</option>
															</c:forEach>
														</select>
													</div>		
												<label class="col-sm-3 control-label label-sm no-padding-right">SIAF:</label>
												<div class="col-sm-3">
													<input type="text" id="txt_nro_siaf" class="form-control input-sm onlyNumbers" maxlength="10" />
												</div>																																			
											</div>			
											<!--  C/P. Afectada  -->								
											<div class="form-group">
												<label class="col-sm-3 control-label label-sm no-padding-right">Fact. Afectada:</label>
												<div class="col-sm-3">
													<input type="text" id="txt_fac_afectada" class="form-control input-sm" disabled />
												</div>												
											</div>
										    <!--  Observaciones  -->
										    <div class="form-group">
										      <label class="col-sm-3 control-label label-sm no-padding-right">Observaciones :</label>
										      <div class="col-sm-9">
										      	<textarea class="form-control" cols="10" rows="5" id="txt_observa"></textarea>
										      </div>
										      
										    </div>	
										 </fieldset>   											
											
											<fieldset class="fsStyle">
												<legend class="legendStyle">Datos del Proveedor</legend>
												<div class="form-group">
													<label class="col-sm-3 control-label label-sm">Direccion del Emisor:</label>
													<div class="col-sm-9">
														<select id="sel_dir_fact" class="form-control input-sm">
															<option value=''>&#60Seleccione Direccion del Emisor&#62</option>
															<c:forEach items="${lis_dir_fact}" var="item">
																<option value="${item.srl_direc}">${item.cod_direc}--${item.chr_direc}</option>
															</c:forEach>
														</select>
													</div>	
												</div>
												<div class="form-group">
													<label class="col-sm-3 control-label label-sm">Tipo de Proveedor:</label>												
													<div class="col-sm-9">
														<div class="radio">
															<label class="input-sm">
																<input type="radio" class="ace input-sm" name="rb_tip_proveedor" value="1" disabled>
																<span class="lbl"> Natural</span>
															</label>
															
															<label class="input-sm">
																<input type="radio" class="ace input-sm" name="rb_tip_proveedor" value="2" disabled>
																<span class="lbl"> Juridico</span>
															</label>
															
															<label class="input-sm">
																<input type="radio" class="ace input-sm" name="rb_tip_proveedor" value="3" disabled>
																<span class="lbl"> Con DNI</span>
															</label>
															
															<label class="input-sm">
																<input type="radio" class="ace input-sm" name="rb_tip_proveedor" value="4">
																<span class="lbl"> Varios</span>
															</label>
														</div>
													</div>
												</div>
												
												<div class="form-group">
													<label class="col-sm-2 control-label label-sm no-padding-right">Nro RUC:</label>
													<div class="col-sm-3">
														<input type="text" id="txt_nro_ruc" class="form-control input-sm onlyNumbers" maxlength="11" />
													</div>

													<label class="col-sm-3 control-label label-sm">Nro DNI / C.Extr.:</label>												
													<div class="col-sm-4">
														<input type="text" id="txt_nro_dni" class="form-control input-sm" maxlength="14" />
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
											
											<br>
											

											
										</div>

										<div class="col-sm-6">
				
											<fieldset class="fsStyle">
												<legend id="leg_det_factura" class="legendStyle">Detalle de Facturas</legend>
												
												<div class="form-group">												
													<label class="col-sm-4 control-label label-sm no-padding-right">Tipo de Transacción:</label>
													<div class="col-sm-4">
														<select id="sel_tip_transaccion" class="form-control input-sm tooltip-info">
															<option value="1">Servicios</option>
												  	 	 	<option value="2">Productos</option>
												  	 	 	<option value="3">Boletos</option>
												  	 	 	<option value="4">Tupa</option>
												  	 	 	<option value="5">Otros</option>														
														</select>
													</div>
												</div>
												
												<br>
												
												<div class="form-group">
													<div class="col-sm-12">													
														<div class="table-responsive">
															<table id="tbl_det_facturas" class="table table-striped table-bordered table-hover">
																														
																<thead>
																	<tr>
																		<th>Item</th>
																		<th id="tr_partida" class="partida">Cod.Servicio</th>
																		<th class="tarifa">Tarifa</th>
																		<th class="servicio">Servicio</th>
																		<th class="dias">Nro.Dias</th>	
																		<th class="pers">Nro.Pers.</th>										
																		<th class="formato">Formato</th>
																		<th class="serie">Serie</th>
																		<th class="nro_inicio">Nro. Inicio</th>
																		<th class="producto">Producto</th>
																		<th class="cantidad">Cant.</th>
																		<th class="importe">Importe</th>																		
																		<th id="tr_precio" class="precio">Precio Venta</th>																		
																		<th class="total">Total</th>
																		<th class="tip_venta">Tipo Venta</th>																		
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
														
																<c:if test="${not empty lis_det_ingresos}">
																	<c:set var="count" value="1" scope="page" />
																	<c:forEach items="${lis_det_ingresos}" var="item">
																		<tr class="item">
																			<td>${count}</td>
																			<c:choose>
																				<c:when test="${item.tip_transaccion == '1'}">
																					<td class="partida">${item.vcod_servicio}</td>
																					<td class="tarifa"></td>
																					<td class="servicio">${item.des_servicio}</td>
																					<td class="dias">${item.can_dias}</td>
																					<td class="pers">${item.can_pers}</td>
																					<td class="formato"></td>
																					<td class="serie"></td>
																					<td class="nro_inicio"></td>
																					<td class="producto"></td>
																					<td class="cantidad"></td>
																					<td class="importe"></td>																	
																					<td class="precio">${item.num_pre_unitario}</td>
																					<td class="total">${item.imp_tot_ser}</td>
																					<td class="tip_venta">${item.des_tip_venta}</td>																
																					<td class="hide cod_ser">${item.cod_servicio}</td>						
																				</c:when>
																				<c:when test="${item.tip_transaccion == '2'}">
																					<td class="partida">${item.vcod_producto}</td>
																					<td class="tarifa"></td>
																					<td class="servicio"></td>
																					<td class="dias"></td>
																					<td class="pers"></td>
																					<td class="formato"></td>
																					<td class="serie"></td>
																					<td class="nro_inicio"></td>
																					<td class="producto">${item.nom_producto}</td>
																					<td class="cantidad">${item.can_producto}</td>
																					<td class="importe"></td>																	
																					<td class="precio">${item.num_pre_unitario}</td>
																					<td class="total">${item.imp_tot_pro}</td>
																					<td class="tip_venta">${item.des_tip_venta}</td>																
																					<td class="hide cod_ser">${item.cod_producto}</td>					
																				</c:when>
																				<c:when test="${item.tip_transaccion == '3'}">
																					<td class="partida">${item.des_ind_tarifa} - ${item.des_boleto}</td>
																					<td class="tarifa"></td>
																					<td class="servicio"></td>
																					<td class="dias"></td>
																					<td class="pers"></td>
																					<td class="formato"></td>
																					<td class="serie">${item.num_ser_boleto}</td>
																					<td class="nro_inicio">${item.ini_boleto}</td>
																					<td class="producto"></td>
																					<td class="cantidad">${item.can_producto}</td>
																					<td class="importe"></td>																	
																					<td class="precio">${item.num_pre_unitario}</td>																	
																					<td class="total">${item.imp_tot_pro}</td>
																					<td class="tip_venta">${item.des_tip_venta}</td>																
																					<td class="hide cod_ser">${item.cod_boleto}</td>						
																				</c:when>
																				<c:when test="${item.tip_transaccion == '4'}">
																					<td class="partida">${item.vcod_tupa}</td>
																					<td class="tarifa"></td>
																					<td class="servicio"></td>
																					<td class="dias"></td>
																					<td class="pers"></td>
																					<td class="formato">${item.nom_tupa}</td>
																					<td class="serie"></td>
																					<td class="nro_inicio"></td>
																					<td class="producto"></td>
																					<td class="cantidad">${item.can_producto}</td>
																					<td class="importe"></td>																	
																					<td class="precio">${item.num_pre_unitario}</td>																	
																					<td class="total">${item.imp_tot_pro}</td>
																					<td class="tip_venta">${item.des_tip_venta}</td>																
																					<td class="hide cod_ser">${item.cod_tupa}</td>		
																				</c:when>
																				<c:when test="${item.tip_transaccion == '5'}">
																					<td class="partida">${item.des_otros}</td>
																					<td class="tarifa"></td>
																					<td class="servicio"></td>
																					<td class="dias"></td>
																					<td class="pers"></td>
																					<td class="formato"></td>
																					<td class="serie"></td>
																					<td class="nro_inicio"></td>
																					<td class="producto"></td>
																					<td class="cantidad">${item.can_producto}</td>
																					<td class="importe"></td>																	
																					<td class="precio">${item.num_pre_unitario}</td>																	
																					<td class="total">${item.imp_tot_pro}</td>
																					<td class="tip_venta">${item.des_tip_venta}</td>																
																					<td class="hide cod_ser">${item.cod_otros}</td>							
																				</c:when>
																			</c:choose>
																																					
																			<td class="hide cod_tip">${item.cod_tip_venta}</td>																			
																			<td class="hide imp_afecto">${item.num_imp_afecto}</td>
																			<td class="hide imp_igv">${item.num_imp_igv}</td>
																			<td class="hide imp_no_afecto">${item.num_imp_no_afecto}</td>
																			<td class="hide imp_isc">${item.num_imp_isc}</td>
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
																	<td class="partida"></td>
																	<td class="hide tarifa"></td>
																	<td class="servicio"></td>
																	<td class="dias"></td>
																	<td class="formato"></td>
																	<td class="serie"></td>
																	<td class="nro_inicio"></td>
																	<td class="producto"></td>
																	<td class="cantidad"></td>
																	<td class="importe"></td>																	
																	<td class="precio"></td>																	
																	<td class="total"></td>
																	<td class="tip_venta"></td>																
																	<td class="hide cod_ser"></td>
																	<td class="hide cod_tip"></td>																	
																	<td class="hide imp_afecto"></td>
																	<td class="hide imp_igv"></td>
																	<td class="hide imp_no_afecto"></td>
																	<td class="hide imp_isc"></td>
																	<td></td>
																	<td></td>
																</tr>
																
															</table>
														</div>
													</div>		
												</div>												
												
												<div id="div_con_fec_inicio" class="form-group">
													<label class="col-sm-3 control-label label-sm no-padding-right">Nro Contrato:</label>
													<div class="col-sm-3">
														<input type="text" id="txt_nro_contrato" class="form-control input-sm" />
													</div>
													
													<label class="col-sm-3 control-label label-sm no-padding-right">Fec. Inicio:</label>
													<div class="col-sm-3">
														<input class="form-control input-sm date-picker" id="txt_fec_inicio" type="text" disabled />
													</div>
												</div>
												
												<div id="div_nro_doc_emp_fec_fin" class="form-group">
													<label class="col-sm-3 control-label label-sm no-padding-right">Nro Doc. Empresa:</label>
													<div class="col-sm-3">
														<input type="text" id="txt_nro_doc_empresa" class="form-control input-sm" />
													</div>
													
													<label class="col-sm-3 control-label label-sm no-padding-right">Fec. Fin:</label>
													<div class="col-sm-3">
														<input class="form-control input-sm date-picker" id="txt_fec_fin" type="text" disabled />
													</div>
												</div>
												
												<div id="div_fec_doc_imp_mensual" class="form-group">
													<label class="col-sm-3 control-label label-sm no-padding-right">Fec. Documento:</label>
													<div class="col-sm-3">
														<div class="input-group">
															<input class="form-control input-sm date-picker" id="txt_fec_documento" type="text" />
															<span class="input-group-addon" id="sp_ico_fec_inicio">
																<i class="fa fa-calendar bigger-110"></i>
															</span>
														</div>
													</div>
													
													<label class="col-sm-3 control-label label-sm no-padding-right">Imp. Mensual:</label>
													<div class="col-sm-3">
														<input type="text" id="txt_imp_mensual" class="form-control input-sm" disabled />
													</div>
												</div>
												
												<div id="div_por_mora" class="form-group">
													<div class="col-sm-6"></div>
													<label class="col-sm-3 control-label label-sm no-padding-right">% Mora:</label>
													<div class="col-sm-3">
														<input type="text" id="txt_por_mora" class="form-control input-sm" disabled />
													</div>
												</div>
												
												<div id="div_nro_doc_emp_fec_doc_tupa" class="form-group">
													<label class="col-sm-3 control-label label-sm no-padding-right">Nro Doc. Empresa:</label>
													<div class="col-sm-3">
														<input type="text" id="txt_nro_doc_emp_tupa" class="form-control input-sm" />
													</div>
													
													<label class="col-sm-3 control-label label-sm no-padding-right">Fec. Fin:</label>
													<div class="col-sm-3">
														<div class="input-group">
															<input class="form-control input-sm date-picker" id="txt_fec_doc_tupa" type="text" />
															<span class="input-group-addon" id="sp_ico_fec_pag_deposito">
																<i class="fa fa-calendar bigger-110"></i>
															</span>
														</div>
													</div>
												</div>
												
												<div id="div_nro_doc_der_fec_der_tupa" class="form-group">
													<label class="col-sm-3 control-label label-sm no-padding-right">Nro Doc. Derivación:</label>
													<div class="col-sm-3">
														<input type="text" id="txt_nro_doc_der_tupa" class="form-control input-sm" />
													</div>
													
													<label class="col-sm-3 control-label label-sm no-padding-right">Fec. Derivación:</label>
													<div class="col-sm-3">
														<div class="input-group">
															<input class="form-control input-sm date-picker" id="txt_fec_der_tupa" type="text" />
															<span class="input-group-addon" id="sp_ico_fec_pag_deposito">
																<i class="fa fa-calendar bigger-110"></i>
															</span>
														</div>
													</div>
												</div>
												<!--  
												<div id="div_for_pago_tupa" class="form-group">
													<label class="col-sm-3 control-label label-sm no-padding-right">Forma de Pago:</label>
													<div class="col-sm-6">
														<select id="sel_for_pago" class="form-control input-sm">
															<c:forEach items="${lis_med_pago}" var="item">
																<option value="${item.cod_mediopagos}">${item.nom_entidad}</option>
															</c:forEach>
														</select>
													</div>												
												</div>											
												-->
												<fieldset class="fsStyle">
													<legend class="legendStyle">Detalle de Papeletas</legend>
												
													<div class="table-responsive div_det_papeletas">
														<table id="tbl_det_papeletas" class="table table-striped table-bordered table-hover">
															<thead>
																<tr class="last">
																	<th>Item</th>
																	<th>Nro Papeleta</th>
																	<th>Fecha</th>
																	<th>Importe</th>
																	<th>Archivo</th>
																	<th class="hide"></th>
																	<th></th>
																	<th></th>
																</tr>
															</thead>															
										
															<c:if test="${not empty lis_det_voucher}">
																<c:set var="count_pap" value="1" scope="page" />
																<c:forEach items="${lis_det_voucher}" var="item">
																	<tr class="item_pap">
																		<td class="nro_item">${count_pap}</td>
																		<td class="nro_pap">${item.num_voucher}</td>
																		<td class="fec_pap">${item.fec_voucher}</td>
																		<td class="imp_pap center">${item.imp_voucher}</td>
																		<td class="arc_pap">${item.img_voucher}</td>																		
																		<td class="hide cod_vou">${item.img_voucher}</td>
																		<td>
																			<button class="btn btn-sm btn-warning input-sm btn_edi_papeleta">
																				<i class="ace-icon fa fa-pencil-square-o"></i>
																			</button>
																		</td>
																		<td>																		
																			<button class="btn btn-sm btn-danger input-sm btn_rem_papeleta">
																				<i class="ace-icon fa fa-trash-o"></i>
																			</button>																																	
																		</td>						
																	</tr>
																	<c:set var="count_pap" value="${count_pap + 1}" scope="page"/>
																</c:forEach>
															</c:if>
															
															<tr class="item_pap">
																<td>
																	<div class="hidden-sm hidden-xs btn-group">
																		<button class="btn btn-xs btn-success btn_agr_papeleta">
																			<i class="ace-icon fa fa-plus"></i>
																		</button>
																	</div>																	
																</td>
																<td class="nro_pap"></td>
																<td class="fec_pap"></td>
																<td class="imp_pap"></td>
																<td class="arc_pap"></td>
																<td class="hide cod_vou"></td>
																<td></td>
																<td></td>
															</tr>														
														</table>
													</div>													
												</fieldset>
												<br>

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
													
													<label class="col-sm-3 control-label label-sm no-padding-right">Importe Total:</label>
													<div class="col-sm-3">
														<input type="text" id="txt_imp_total" class="form-control input-sm" disabled />
													</div>
												</div>
												
											</fieldset>
											<fieldset class="fsStyle">
												<legend class="legendStyle">Constancia de Depósito de Detraccion</legend>
												
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
											<br>
				
											<div class="form-group">&nbsp;</div>
											
											<div class="form-group">
												<div class="col-sm-2">
													<c:if test="${indicador == 2}">
														<button id="btn_grabar" class="btn btn-sm btn-primary input-sm">
															<i class="ace-icon fa fa-check"></i>
															Grabar
														</button>
													</c:if>
												</div>
												
												<div class="col-sm-2">
													<c:if test="${indicador == 2}">
														<button id="btn_eliminar" class="btn btn-sm btn-danger input-sm">
															<i class="ace-icon fa fa-times"></i>
															Anular
														</button>
													</c:if>
												</div>
												<div class="col-sm-2">
													<c:if test="${indicador == 2}">
														<button id="btn_nuevo" class="btn btn-sm btn-success input-sm">
															<i class="ace-icon fa fa-plus-square"></i>
															Nuevo
														</button>
													</c:if>
												</div>
												<div class="col-sm-2">
													<c:if test="${indicador == 2}">
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
			
			<div id="div_det_facturas" class="modal" tabindex="-1" data-keyboard="false" data-backdrop="static">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">&times;</button>
							<h4 id="h_det_facturas" class="white bigger center"></h4>
						</div>
						
						<div class="modal-body">
							<div class="row">
								<div class="col-xs-12">
									<form id="form_det_facturas" class="form-horizontal" role="form">
										<div id="div_partida" class="form-group">																				
											<label id="lbl_partida" class="col-sm-3 control-label input-sm no-padding-right">Partida:</label>											
											<div class="col-sm-5">
												<select id="sel_partida" class="form-control input-sm">
												</select>
											</div>								
										</div>
										
										<div id="div_serie" class="form-group">																				
											<label class="col-sm-3 control-label input-sm no-padding-right">Serie:</label>											
											<div class="col-sm-5">
												<input type="text" id="txt_serie" class="form-control input-sm" disabled />
											</div>								
										</div>
										
										<div id="div_formato" class="form-group">																				
											<label class="col-sm-3 control-label input-sm no-padding-right">Formato:</label>											
											<div class="col-sm-5">
												<input type="text" id="txt_formato" class="form-control input-sm" disabled />
											</div>								
										</div>

										<div id="div_tarifa" class="form-group">																				
											<label id="lbl_tarifa" class="col-sm-3 control-label input-sm no-padding-right">Tarifa:</label>											
											<div class="col-sm-9">
												<input type="text" id="txt_tarifa" class="form-control input-sm" disabled />
											</div>
										</div>										

										<div id="div_servicio" class="form-group">																				
											<label id="lbl_servicio" class="col-sm-3 control-label input-sm no-padding-right">Servicio:</label>											
											<div class="col-sm-9">
												<input type="text" id="txt_servicio" class="form-control input-sm" disabled />
											</div>	
										</div>

										<div id="div_producto" class="form-group">																				
											<label id="lbl_producto" class="col-sm-3 control-label input-sm no-padding-right">Producto:</label>											
											<div class="col-sm-9">
												<input type="text" id="txt_producto" class="form-control input-sm" disabled />
											</div>	
										</div>
										
										<div id="div_nro_inicio" class="form-group">																				
											<label class="col-sm-3 control-label input-sm no-padding-right">Nro. Inicio:</label>											
											<div class="col-sm-5">
												<input type="text" id="txt_nro_inicio" class="form-control input-sm onlyNumbers" />
											</div>	
										</div>
										
										<div id="div_dias" class="form-group">																				
											<label class="col-sm-3 control-label input-sm no-padding-right">Nro. Días:</label>											
											<div class="col-sm-3">
												<input type="text" id="txt_dias" class="form-control input-sm onlyNumbers" maxlength="6" />
											</div>	
											<label class="col-sm-3 control-label input-sm no-padding-right">Nro. Personas:</label>											
											<div class="col-sm-3">
												<input type="text" id="txt_persona" class="form-control input-sm onlyNumbers" maxlength="2" />
											</div>																						
										</div>
										
										<div id="div_cantidad" class="form-group">																				
											<label class="col-sm-3 control-label input-sm no-padding-right">Cantidad:</label>											
											<div class="col-sm-3">
												<input type="text" id="txt_cantidad" class="form-control input-sm onlyDecimals" maxlength="10" />
											</div>											
										</div>
										
										<div id="div_precio" class="form-group">																				
											<label id="lbl_precio" class="col-sm-3 control-label input-sm no-padding-right">Precio Venta:</label>											
											<div class="col-sm-5">
												<input type="text" id="txt_precio" class="form-control input-sm" disabled />
											</div>											
										</div>
										
										<div id="div_total" class="form-group">																				
											<label class="col-sm-3 control-label input-sm no-padding-right">Total:</label>											
											<div class="col-sm-5">
												<input type="text" id="txt_total" class="form-control input-sm onlyDecimals" maxlength="10" disabled />
											</div>											
										</div>
										
										<div id="div_importe" class="form-group">																				
											<label class="col-sm-3 control-label input-sm no-padding-right">Importe:</label>											
											<div class="col-sm-5">
												<input type="text" id="txt_importe" class="form-control input-sm onlyAmounts" maxlength="8" />
											</div>											
										</div>
										
										<div id="div_tip_venta" class="form-group">																				
											<label class="col-sm-3 control-label input-sm no-padding-right">Tipo Venta:</label>											
											<div class="col-sm-5">
												<select id="sel_tip_venta" class="form-control input-sm">
													<!--  <option value="1">Gravada</option>
													<option value="2">No Gravada</option>
													<option value="3">Exonerado</option>-->
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
										
										<div id="div_sto_disponible" class="form-group">																				
											<label class="col-sm-1 control-label input-sm no-padding-right">Stock:</label>											
											<div class="col-sm-2">
												<input type="text" id="txt_stock" class="form-control input-sm" disabled />
											</div>
											
											<label class="col-sm-4 control-label input-sm no-padding-right">Números disponibles del</label>											
											<div class="col-sm-2">
												<input type="text" id="txt_ini_disponible" class="form-control input-sm" disabled />
											</div>
											
											<label class="col-sm-1 control-label input-sm no-padding-right">al</label>											
											<div class="col-sm-2">
												<input type="text" id="txt_fin_disponible" class="form-control input-sm" disabled />
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
			
			<div id="div_reg_not_credito" class="modal" tabindex="-1" data-keyboard="false" data-backdrop="static">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">&times;</button>
							<h4 class="white bigger center">Registro de Información de Nota de Crédito</h4>
						</div>
						
						<div class="modal-body">
							<div class="row">
								<div class="col-xs-12">
									<form id="form_det_reg_gravado" class="form-horizontal" role="form">
											<div class="form-group" id="div_radio_fact_nc">
												<label id="lbl_emision" class="col-sm-3 control-label label-sm no-padding-right" >Emision del Comprobante:</label>
									
													<div class="radio">
														<label class="input-sm">
														<input type="radio" class="ace input-sm" id="op_factu_nc" name="rb_tip_factu_nc" value="1">
														<span class="lbl">Electronica</span>
														</label>
														
														<label class="input-sm">
														<input type="radio" class="ace input-sm" id="op_factu_nc" name="rb_tip_factu_nc" value="2">
														<span class="lbl">Manual</span>
														</label>
													</div>

													
											</div>
																				
										<div class="form-group">																				
											<label class="col-sm-3 control-label input-sm no-padding-right">Tipo Comprobante:</label>											
											<!-- 
											<div class="col-sm-3">
												<select id="sel_tip_com_nc" class="form-control input-sm">
													<option value="8">Nota de Crédito</option>
													<option value="9">Nota de Dédito</option>
												</select>
											</div>
											 -->
												<div class="col-sm-3">
													<select id="sel_tip_comprobante_nc" class="chosen-select form-control input-sm">
														<c:forEach items="${lis_tip_comprobante}" var="item">
															<option value="${item.cod_comprobante}">${item.nom_comprobante}</option>
														</c:forEach>
													</select>
												</div>
												
											<label class="col-sm-3 control-label label-sm no-padding-right"> de Doc.:</label>
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
												<input type="text" id="txt_ser_nc" class="form-control input-sm onlyNumbers" maxlength="7" />
											</div>	
											
											<label class="col-sm-3 control-label label-sm no-padding-right">Nro Doc.:</label>
											<div class="col-sm-3">
												<input type="text" id="txt_nro_doc_nc" class="form-control input-sm onlyNumbers" maxlength="10" />
											</div>
										</div>
										
										<div class="form-group">																				
											<label class="col-sm-2 control-label input-sm no-padding-right">Nro Fact.:</label>											
											<div class="col-sm-3">
												<input type="text" id="txt_nro_fac_nc" class="form-control input-sm" disabled />
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
										
										<div id="div_par_nc" class="form-group">																				
											<label id="lbl_par_nc" class="col-sm-3 control-label input-sm no-padding-right">Partida:</label>											
											<div class="col-sm-5">
												<select id="sel_par_nc" class="form-control input-sm" disabled>
												</select>
											</div>								
										</div>
										
										<div id="div_ser_nc" class="form-group">																				
											<label class="col-sm-3 control-label input-sm no-padding-right">Serie:</label>											
											<div class="col-sm-5">
												<input type="text" id="txt_ser_nc" class="form-control input-sm" disabled />
											</div>								
										</div>
										
										<div id="div_for_nc" class="form-group">																				
											<label class="col-sm-3 control-label input-sm no-padding-right">Formato:</label>											
											<div class="col-sm-5">
												<input type="text" id="txt_for_nc" class="form-control input-sm" disabled />
											</div>								
										</div>

										<div id="div_tar_nc" class="form-group">																				
											<label id="lbl_tar_nc" class="col-sm-3 control-label input-sm no-padding-right">Tarifa:</label>											
											<div class="col-sm-9">
												<input type="text" id="txt_tar_nc" class="form-control input-sm" disabled />
											</div>
										</div>										

										<div id="div_serv_nc" class="form-group">																				
											<label id="lbl_ser_nc" class="col-sm-3 control-label input-sm no-padding-right">Servicio:</label>											
											<div class="col-sm-9">
												<input type="text" id="txt_serv_nc" class="form-control input-sm" disabled />
											</div>	
										</div>

										<div id="div_pro_nc" class="form-group">																				
											<label id="lbl_producto" class="col-sm-3 control-label input-sm no-padding-right">Producto:</label>											
											<div class="col-sm-9">
												<input type="text" id="txt_pro_nc" class="form-control input-sm" disabled />
											</div>	
										</div>
										
										<div id="div_nro_ini_nc" class="form-group">																				
											<label class="col-sm-3 control-label input-sm no-padding-right">Nro. Inicio:</label>											
											<div class="col-sm-5">
												<input type="text" id="txt_nro_ini_nc" class="form-control input-sm onlyNumbers" />
											</div>	
										</div>
										
										<div id="div_dia_nc" class="form-group">																				
											<label class="col-sm-3 control-label input-sm no-padding-right">Nro. Días:</label>											
											<div class="col-sm-3">
												<input type="text" id="txt_dia_nc" class="form-control input-sm onlyNumbers" maxlength="6" />
											</div>											
										</div>
										
										<div id="div_can_nc" class="form-group">																				
											<label class="col-sm-3 control-label input-sm no-padding-right">Cantidad:</label>											
											<div class="col-sm-3">
												<input type="text" id="txt_can_nc" class="form-control input-sm onlyNumbers" maxlength="6" />
											</div>											
										</div>
										
										<div id="div_pre_nc" class="form-group">																				
											<label id="lbl_precio" class="col-sm-3 control-label input-sm no-padding-right">Precio Venta:</label>											
											<div class="col-sm-5">
												<input type="text" id="txt_pre_nc" class="form-control input-sm" disabled />
											</div>											
										</div>
										
										<div id="div_tot_nc" class="form-group">																				
											<label class="col-sm-3 control-label input-sm no-padding-right">Total:</label>											
											<div class="col-sm-5">
												<input type="text" id="txt_tot_nc" class="form-control input-sm onlyAmounts" maxlength="8" disabled />
											</div>											
										</div>
										
										<div id="div_imp_nc" class="form-group">																				
											<label class="col-sm-3 control-label input-sm no-padding-right">Importe:</label>											
											<div class="col-sm-5">
												<input type="text" id="txt_imp_nc" class="form-control input-sm onlyAmounts" maxlength="8" />
											</div>											
										</div>
										
										<div id="div_tip_ven_nc" class="form-group">																				
											<label class="col-sm-3 control-label input-sm no-padding-right">Tipo Venta:</label>											
											<div class="col-sm-5">
												<select id="sel_tip_ven_nc" class="form-control input-sm" disabled>
													<!--  <option value="1">Gravada</option>
													<option value="2">No Gravada</option>
													<option value="3">Exonerado</option>-->
													<option value="2">001 Gravada c/expor</option>
													<option value="1">002 Gravada Sernanp</option>
													<option value="3">003 Gravada s/expor</option>
													<option value="4">004 No Gravada</option>																						
												</select>
											</div>	
										</div>
										
										<div id="div_imp_isc_cam_nc" class="form-group">																				
											<label class="col-sm-3 control-label input-sm no-padding-right">Importe Camioneta:</label>											
											<div class="col-sm-5">
												<input type="text" id="txt_imp_isc_cam_nc" class="form-control input-sm onlyAmounts" maxlength="10" />
											</div>											
										</div>
										
										<div id="div_sto_dis_nc" class="form-group">																				
											<label class="col-sm-1 control-label input-sm no-padding-right">Stock:</label>											
											<div class="col-sm-2">
												<input type="text" id="txt_sto_nc" class="form-control input-sm" disabled />
											</div>
											
											<label class="col-sm-4 control-label input-sm no-padding-right">Números disponibles del</label>											
											<div class="col-sm-2">
												<input type="text" id="txt_ini_dis_nc" class="form-control input-sm" disabled />
											</div>
											
											<label class="col-sm-1 control-label input-sm no-padding-right">al</label>											
											<div class="col-sm-2">
												<input type="text" id="txt_fin_dis_nc" class="form-control input-sm" disabled />
											</div>																						
										</div>
								
										<div class="form-group">
											<label class="col-sm-3 control-label label-sm no-padding-right">Importe Afecto:</label>
											<div class="col-sm-3">
												<input type="text" id="txt_imp_afe_nc" class="form-control input-sm" disabled />
											</div>
											
											<label class="col-sm-3 control-label label-sm no-padding-right">Impuesto IGV:</label>
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
			
			<div id="div_det_papeletas" class="modal" tabindex="-1" data-keyboard="false" data-backdrop="static">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">&times;</button>
							<h4 id="h_det_papeletas" class="white bigger center"></h4>
						</div>
						
						<div class="modal-body">
							<div class="row">
								<div class="col-xs-12">
									<form id="form_det_papeletas" class="form-horizontal" role="form">
										<div class="form-group">																				
											<label class="col-sm-3 control-label input-sm no-padding-right">Nro Papeleta:</label>											
											<div class="col-sm-5">
												<input type="text" id="txt_nro_papeleta" class="form-control input-sm" maxlength="20" />
											</div>											
										</div>										

										<div class="form-group">
											<label class="col-sm-3 control-label label-sm no-padding-right">Fecha:</label>
											<div class="col-sm-5">
												<div class="input-group">
													<input class="form-control input-sm date-picker" id="txt_fec_papeleta" type="text" />
													<span class="input-group-addon" id="sp_ico_fec_papeleta">
														<i class="fa fa-calendar bigger-110"></i>
													</span>
												</div>
											</div>
										</div>								
										
										<div class="form-group">																				
											<label class="col-sm-3 control-label input-sm no-padding-right">Importe:</label>											
											<div class="col-sm-5">
												<input type="text" id="txt_imp_papeleta" class="form-control input-sm onlyAmounts" maxlength="10" />
											</div>											
										</div>
										
										<div class="form-group">																				
											<label class="col-sm-3 control-label input-sm no-padding-right">Archivo:</label>
											<div class="col-sm-5">
												<div id="div_imagen">
													<span class="profile-picture">
														<img id="avatar" class="editable img-responsive" src="#" />
													</span>
													<button id="btn_cambiar" class="btn btn-sm btn-success" type="button">
														<i class="ace-icon fa fa-plus-square bigger-110"></i>
														Cambiar
													</button>
												</div>
												<div id="div_upload_imagen" class="fileinput fileinput-new" data-provides="fileinput">
													<div class="fileinput-preview thumbnail" data-trigger="fileinput" style="width: 200px; height: 200px;"></div>
													<div>
														<span class="btn btn-default btn-file">
															<span class="fileinput-new">Selecione imagen</span>
															<span class="fileinput-exists">Cambiar</span>
															<input type="file" id="file_name_avatar" name="file_name_avatar">
														</span>
														<a href="#" class="btn btn-default fileinput-exists" data-dismiss="fileinput">Remover</a>
													</div>
												</div>
											</div>
										</div>
										
									</form>
								</div>
							</div>			
						</div>

						<div class="modal-footer">				
							<button id="btn_ana_papeletas" class="btn btn-sm btn-primary">
								<i class="ace-icon fa fa-check"></i>
								Añadir
							</button>
							<button id="btn_edi_papeletas" class="btn btn-sm btn-primary">
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
		
			var arr_det_trans = null;
			var arr_tip_com = [];
			
			var arr_tar_servicio = [];
			var arr_productos = [];
			var arr_tar_boletos = [];
			var arr_tar_tupa = [];
			var arr_tar_otros = [];
			
			var mon_imp_actual = 0;
			var tip_com = '';
			var num_ser = '';
			var flg_fac = '';
			var num_com = '';
			var indicador = parseInt('${indicador}');
		    <c:forEach items="${lis_tip_comprobante}" var="item">
		    	tip_com = '${item.cod_comprobante}_${item.num_serie}_${item.num_comprobante}_${item.fla_factura}';
				arr_tip_com.push(tip_com); 
			</c:forEach>
			
			<c:forEach items="${lis_tar_servicio}" var="item">
		    	arr_tar_servicio.push('${item.cod_servicio}'+'|'+'${item.vcod_servicio}'+'|'+'${item.nom_servicio}'+'|'+'${item.num_imp_pre_venta}');
			</c:forEach>
			
			<c:forEach items="${lis_productos}" var="item">
				arr_productos.push('${item.cod_producto}'+'|'+'${item.vcod_producto}'+'|'+'${item.nom_producto}'+'|'+'${item.num_imp_pre_venta}');
			</c:forEach>
			
			<c:forEach items="${lis_tar_boletos}" var="item">
				var det_boleto = '${item.cod_boleto}'+'|'+'${item.des_ind_tarifa}'+'|'+'${item.nom_boleto}'+'|'+'${item.num_serie}'+'|';
				det_boleto = det_boleto + '${item.num_inicio}'+'|'+'${item.num_final}'+'|'+'${item.can_sal_stock}'+'|'+'${item.num_imp_unit}';			
				arr_tar_boletos.push(det_boleto);
			</c:forEach>
			
			<c:forEach items="${lis_tar_tupa}" var="item">
				arr_tar_tupa.push('${item.cod_tupa}'+'|'+'${item.vcod_tupa}'+'|'+'${item.nom_tupa}'+'|'+'${item.num_imp_unit}');
			</c:forEach>
			
			<c:forEach items="${lis_otros}" var="item">
				arr_tar_otros.push('${item.cod_otros}'+'|'+'${item.nom_otros}'+'|'+'${item.cod_especifica}');
			</c:forEach>
			
		
			$(document).ready(function() {
				
				$("#li_ingresos").addClass('active');
				if (indicador == 2) {
					$("#li_reg_ingresos").addClass('active');
				} else {					
					$("#li_mon_ingresos").addClass('active');					
				}

				$('.date-picker').datepicker({
					autoclose: true,
					todayHighlight: true
				});
				
				$('.input-group-addon').click(function(e){
					e.preventDefault();
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
				



				$('input[name=rb_tip_factu]').prop('disabled', true);
								
				inicializarDatos();
				
				$('input:radio[name="rb_tip_operacion"]').change(function() {			       
			        if ($(this).val() == 2) { // Sede
						$('#sel_uni_operativa').prop('disabled', true);
						$('#sel_anp').prop('disabled', true);
			        } else {
			        	$('#sel_uni_operativa').prop('disabled', false);
						$('#sel_anp').prop('disabled', false);
			        }
			    });
				
				$('#sel_periodo').on('change', function() {
					set_fec_cp($(this).val());
				});
				
				$('#sel_uni_operativa').on('change', function() {
					if (!esnulo($(this).val())) {
						if ('${ind_sed_principal}' == '2') { // Usuario de U.O.
							set_anp($(this).val(), false, null);
						} else {						
							set_anp($(this).val(), true, null);
						}
					} else {
						$('#sel_anp').empty();
					}
				});
				
				$('#sel_anp').on('change', function() {
					// set_tari_boleto($('#sel_uni_operativa').val(), $(this).val());
					obtenerTarifaBoleto($('#sel_uni_operativa').val(), $(this).val());
					//obtenerSucursal($('#sel_uni_operativa').val(), $(this).val());
					set_sucursal($('#sel_uni_operativa').val(), $(this).val());
					
				});
				
				$('input:radio[name="rb_tip_factu"]').change(function() {	
					var tip_fact       = $('input[name="rb_tip_factu"]:checked').val();
					var cod_uni_operativa = $('#sel_uni_operativa').val();
					var tip_operacion  = $('input[name="rb_tip_operacion"]:checked').val();
					
					if(tip_fact=="1"){
						var cod_uni_operativa = $('#sel_uni_operativa').val();
						var cod_reg_nac = $('#sel_anp').val();
						var cod_comprobante = $('#sel_tip_comprobante').val();						
						cod_uni_operativa=99;
						cod_reg_nac=99;
						set_serie(cod_uni_operativa,cod_reg_nac,cod_comprobante);
					}
					if(tip_fact=="2" && tip_operacion==2 && cod_uni_operativa==''){
						cod_uni_operativa = 90;
						cod_reg_nac       = 90;
						var cod_comprobante = $('#sel_tip_comprobante').val();
						set_serie(cod_uni_operativa,cod_reg_nac,cod_comprobante);
					}else{
						var cod_uni_operativa = $('#sel_uni_operativa').val();
						var cod_reg_nac = $('#sel_anp').val();
						var cod_comprobante = $('#sel_tip_comprobante').val();	
						set_serie(cod_uni_operativa,cod_reg_nac,cod_comprobante);						
					}
					
				});	
				
				$('input:radio[name="rb_tip_factu_nc"]').change(function() {
					var tip_fact       = $('input[name="rb_tip_factu_nc"]:checked').val();
					var cod_uni_operativa = $('#sel_uni_operativa').val();
					var tip_operacion  = $('input[name="rb_tip_operacion"]:checked').val();
					
					if(tip_fact=="1"){
						var cod_uni_operativa = $('#sel_uni_operativa').val();
						var cod_reg_nac = $('#sel_anp').val();
						var cod_comprobante = $('#sel_tip_comprobante_nc').val();						
						cod_uni_operativa=99;
						cod_reg_nac=99;
						set_serie(cod_uni_operativa,cod_reg_nac,cod_comprobante);
					}
					if(tip_fact=="2" && tip_operacion==2 && cod_uni_operativa==''){
						cod_uni_operativa = 90;
						cod_reg_nac       = 90;
						var cod_comprobante = $('#sel_tip_comprobante_nc').val();
						set_serie(cod_uni_operativa,cod_reg_nac,cod_comprobante);
					}else{
						var cod_uni_operativa = $('#sel_uni_operativa').val();
						var cod_reg_nac = $('#sel_anp').val();
						var cod_comprobante = $('#sel_tip_comprobante_nc').val();	
						set_serie(cod_uni_operativa,cod_reg_nac,cod_comprobante);						
					}
				});
					
				$('#sel_tip_comprobante').on('change', function() {
					var cod_uni_operativa = $('#sel_uni_operativa').val();
					var cod_reg_nac       = $('#sel_anp').val();
					var cod_comprobante   = $('#sel_tip_comprobante').val();
					var tip_operacion     = $('input[name="rb_tip_operacion"]:checked').val();
					var tip_fact     	  = $('input[name="rb_tip_factu"]:checked').val();
					
					if(tip_operacion==2 && cod_uni_operativa=='' && tip_fact=="1"){
						cod_uni_operativa = 99;
						cod_reg_nac       = 99;
						set_serie(cod_uni_operativa,cod_reg_nac,cod_comprobante);
					}
					if(tip_operacion==2 && cod_uni_operativa=='' && tip_fact=="2"){
						cod_uni_operativa = 90;
						cod_reg_nac       = 90;
						set_serie(cod_uni_operativa,cod_reg_nac,cod_comprobante);
					}
					
					for (var i=0; i < arr_tip_com.length; i++) {
						var fields = arr_tip_com[i].split('_');
						if (fields[0] == $(this).val()) {
							cod_com = fields[0];
							num_ser = fields[1];
							flg_fac = fields[3];
							if (!esnulo(num_ser)){

								if(flg_fac=='S'){
									$('#txt_ser_comprobante').prop( "disabled", true );
									$('input[name=rb_tip_factu]').prop('disabled', false);
									$('input[name=rb_tip_factu][value="'+1+'"]').prop('checked', true);
									$(function () {
										$('#txt_fec_comprobante').prop('disabled', true);
										var d = new Date();
										var month = d.getMonth()+1;
										var day   = d.getDate();

										var fecha_actual = ((''+day).length<2 ? '0' : '') + day + '/' +
									    ((''+month).length<2 ? '0' : '') + month + '/' +
									    d.getFullYear();
										
										//$.datepicker.setDefaults($.datepicker.regional["es"]);
										$("#txt_fec_comprobante").val(fecha_actual);
									});										

								}else{
									$('#txt_fec_comprobante').prop('disabled', false);
									$('input[name=rb_tip_factu]').prop('disabled', true);
									$('input[name=rb_tip_factu][value="'+2+'"]').prop('checked', true);
									$('#lbl_emision').modal('hide');
									$('#div_radio_fact').modal('hide');
									$('#txt_ser_comprobante').prop( "disabled", false );
									$('#txt_ser_comprobante').attr('maxlength', num_ser);
									var val_num_ser = $('#txt_ser_comprobante').val();
									if (!esnulo(val_num_ser)) {						
				 						$('#txt_ser_comprobante').val(padDigits(val_num_ser, parseInt(num_ser)));
									}
								}
							} else {
								num_ser = '';
							}
							num_com = fields[2];
							if (!esnulo(num_com))	{
								if(flg_fac=='S'){
									$('#txt_nro_comprobante').prop( "disabled", true );
								}else{
									$('#txt_nro_comprobante').prop( "disabled", false );
									$('#txt_nro_comprobante').attr('maxlength', num_com);								
									var val_num_com = $('#txt_nro_comprobante').val();
									if (!esnulo(val_num_com)) {						
				 						$('#txt_nro_comprobante').val(padDigits(val_num_com, parseInt(num_com)));
									}
								}
							} else {
								num_com = '';
							}
							set_serie(cod_uni_operativa,cod_reg_nac,cod_comprobante);
							break;
						}						
					}					
				});
				
				$('#sel_tip_comprobante_nc').on('change', function() {
					var cod_uni_operativa = $('#sel_uni_operativa').val();
					var cod_reg_nac       = $('#sel_anp').val();
					var cod_comprobante   = $('#sel_tip_comprobante_nc').val();
					var tip_operacion     = $('input[name="rb_tip_operacion"]:checked').val();
					
					if(tip_operacion==2 && cod_uni_operativa==''){
						cod_uni_operativa = 90;
						cod_reg_nac       = 90;
						set_serie(cod_uni_operativa,cod_reg_nac,cod_comprobante);
					}
					
					for (var i=0; i < arr_tip_com.length; i++) {
						var fields = arr_tip_com[i].split('_');
						if (fields[0] == $(this).val()) {
							cod_com = fields[0];
							num_ser = fields[1];
							flg_fac = fields[3];
							if (!esnulo(num_ser)){

								if(flg_fac=='S'){
									$('#txt_ser_comprobante_nc').prop( "disabled", true );
									$('input[name=rb_tip_factu_nc]').prop('disabled', false);
									$('input[name=rb_tip_factu_nc][value="'+1+'"]').prop('checked', true);
									$(function () {
										$('#txt_fec_comprobante_nc').prop('disabled', true);
										var d = new Date();
										var month = d.getMonth()+1;
										var day   = d.getDate();

										var fecha_actual = ((''+day).length<2 ? '0' : '') + day + '/' +
									    ((''+month).length<2 ? '0' : '') + month + '/' +
									    d.getFullYear();
										
										//$.datepicker.setDefaults($.datepicker.regional["es"]);
										$("#txt_fec_comprobante_nc").val(fecha_actual);
									});										

								}else{
									$('#txt_fec_comprobante_nc').prop('disabled', false);
									$('input[name=rb_tip_factu_nc]').prop('disabled', true);
									$('input[name=rb_tip_factu_nc][value="'+2+'"]').prop('checked', true);
									$('#lbl_emision').modal('hide');
									$('#div_radio_fact_nc').modal('hide');
									$('#txt_ser_comprobante_nc').prop( "disabled", false );
									$('#txt_ser_comprobante_nc').attr('maxlength', num_ser);
									var val_num_ser = $('#txt_ser_comprobante').val();
									if (!esnulo(val_num_ser)) {						
				 						$('#txt_ser_comprobante_nc').val(padDigits(val_num_ser_nc, parseInt(num_ser_nc)));
									}
								}
							} else {
								num_ser_nc = '';
							}
							num_com_nc = fields[2];
							if (!esnulo(num_com_nc))	{
								if(flg_fac=='S'){
									$('#txt_nro_comprobante_nc').prop( "disabled", true );
								}else{
									$('#txt_nro_comprobante_nc').prop( "disabled", false );
									$('#txt_nro_comprobante_nc').attr('maxlength', num_com);								
									var val_num_com = $('#txt_nro_comprobante').val();
									if (!esnulo(val_num_com)) {						
				 						$('#txt_nro_comprobante_nc').val(padDigits(val_num_com, parseInt(num_com)));
									}
								}
							} else {
								num_com = '';
							}
							set_serie(cod_uni_operativa,cod_reg_nac,cod_comprobante);
							break;
						}						
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
				
				$('#sel_tip_moneda').on('change', function() {
					if ($(this).val() == '1') {
						$('#txt_tip_cambio').prop('disabled', true);
						$('#txt_tip_cambio').val('');
					} else {
						$('#txt_tip_cambio').prop('disabled', false);
					}
				});
				
				$('#sel_tip_transaccion').on('change', function(e) {
					e.preventDefault();
					
					var opt_detalle = '';
					var cod_tip_transaccion = $(this).val(); 
					switch (cod_tip_transaccion) {
						case '1': // Servicios
							$('.partida').show();
							$('#tr_partida').html('Cod.Servicio');
							$('.tarifa').hide();
							$('.dias').show();
							$('.pers').show();
							$('.servicio').show();
							$('.formato').hide();
							$('.serie').hide();
							$('.nro_inicio').hide();
							$('.producto').hide();
							$('.cantidad').hide();
							$('.importe').hide();
							$('.tip_venta').show();
							$('#tr_precio').html('Precio Venta');
							$('#lbl_precio').val('Precio');
							$('.precio').show();
							$('.total').show();
							$('#div_con_fec_inicio').hide();
							$('#div_nro_doc_emp_fec_fin').hide();
							$('#div_fec_doc_imp_mensual').hide();
							$('#div_por_mora').hide();
							$('#div_nro_doc_emp_fec_doc_tupa').hide();
							$('#div_nro_doc_der_fec_der_tupa').hide();
							$('#div_for_pago_tupa').hide();
														
							
							$('#div_partida').show();
							$('#div_serie').hide();
							$('#div_formato').hide();
							$('#div_tarifa').hide();
							$('#div_servicio').show();
							$('#div_producto').hide();
							$('#div_nro_inicio').hide();
							$('#div_dias').show();
							$('#div_cantidad').hide();
							$('#div_precio').show();
							$('#div_total').show();
							$('#div_importe').hide();
							$('#div_tip_venta').show();
							$('#div_imp_isc_cam').hide();
							$('#div_sto_disponible').hide();
							$('#txt_precio').prop('disabled', true);
							
							
							$('#lbl_partida').html('Servicio');
							$('#lbl_servicio').html('Nombre del Servicio');
							$('#leg_det_factura').html('Detalle de Servicios');
							
							for (var i = 0; i < arr_tar_servicio.length; i++) {
								var fields = arr_tar_servicio[i].split('|');								
								opt_detalle += '<option value="'+fields[0]+'">'+fields[1]+' - '+fields[2]+'</option>';								
								if (i == 0) {
									$('#txt_servicio').val(fields[2]);
									$('#txt_precio').val(fields[3]);
								}
							}
							$('#sel_partida').html(opt_detalle);
							
							break;
						case '2': // Productos
							$('.partida').show();
							$('#tr_partida').html('Cod.Producto');
							$('.tarifa').hide();
							$('.dias').hide();
							$('.pers').hide();
							$('.servicio').hide();
							$('.formato').hide();
							$('.serie').hide();
							$('.nro_inicio').hide();
							$('.producto').show();
							$('.cantidad').show();
							$('.importe').hide();
							$('.tip_venta').show();
							$('#tr_precio').html('Precio Venta');
							$('#lbl_precio').val('Precio Venta');
							$('.precio').show();
							$('.total').show();
							$('#div_con_fec_inicio').hide();
							$('#div_nro_doc_emp_fec_fin').hide();
							$('#div_fec_doc_imp_mensual').hide();
							$('#div_por_mora').hide();
							$('#div_nro_doc_emp_fec_doc_tupa').hide();
							$('#div_nro_doc_der_fec_der_tupa').hide();
							$('#div_for_pago_tupa').hide();
							
							
							$('#leg_det_factura').html('Detalle de Productos');
							
							$('#div_partida').show();
							$('#lbl_partida').html('Cod.Producto');
							$('#div_serie').hide();
							$('#div_formato').hide();
							$('#div_tarifa').hide();
							$('#div_servicio').hide();
							$('#div_producto').show();
							$('#div_nro_inicio').hide();
							$('#div_dias').hide();
							$('#div_cantidad').show();
							$('#div_precio').show();
							$('#div_total').show();
							$('#div_importe').hide();
							$('#div_tip_venta').show();
							$('#div_imp_isc_cam').hide();
							$('#div_sto_disponible').hide();
							$('#txt_precio').prop('disabled', true);
							
							
							for (var i = 0; i < arr_productos.length; i++) {
								var fields = arr_productos[i].split('|');								
								opt_detalle += '<option value="'+fields[0]+'">'+fields[1]+' - '+fields[2]+'</option>';								
								if (i == 0) {
									$('#txt_producto').val(fields[2]);
									$('#txt_precio').val(fields[3]);
								}
							}
							$('#sel_partida').html(opt_detalle);
							
							break;
						case '3': // Boletos
							$('.partida').show();
							$('#tr_partida').html('Tarifa');
							$('.tarifa').hide();
							$('.dias').hide();
							$('.pers').hide();
							$('.servicio').hide();
							$('.formato').hide();
							$('.serie').show();
							$('.nro_inicio').show();
							$('.producto').hide();
							$('.cantidad').show();
							$('.importe').hide();
							$('.tip_venta').show();
							$('#tr_precio').html('Precio Bol.');
							$('#lbl_precio').val('Precio Bol.');
							$('.precio').show();
							$('.total').show();
							$('#div_con_fec_inicio').hide();
							$('#div_nro_doc_emp_fec_fin').hide();
							$('#div_fec_doc_imp_mensual').hide();
							$('#div_por_mora').hide();
							$('#div_nro_doc_emp_fec_doc_tupa').hide();
							$('#div_nro_doc_der_fec_der_tupa').hide();
							$('#div_for_pago_tupa').hide();
							
							
							$('#leg_det_factura').html('Detalle de Boletos');
							
							$('#div_partida').show();
							$('#lbl_partida').html('Tarifa');
							$('#div_serie').show();
							$('#div_formato').hide();
							$('#div_tarifa').hide();
							$('#div_servicio').hide();
							$('#div_producto').hide();
							$('#div_nro_inicio').show();
							$('#div_dias').hide();
							$('#div_cantidad').show();
							$('#div_precio').show();
							$('#div_total').show();
							$('#div_importe').hide();
							$('#div_tip_venta').show();
							$('#div_imp_isc_cam').hide();
							$('#div_sto_disponible').show();
							$('#txt_precio').prop('disabled', true);
							
							obtenerTarifaBoleto($('#sel_uni_operativa').val(), $('#sel_anp').val());
							
							break;
						case '4': // Tupa
							$('.partida').show();
							$('#tr_partida').html('Cod.Tupa');
							$('.tarifa').hide();
							$('.dias').hide();
							$('.pers').hide();
							$('.servicio').hide();
							$('.formato').show();
							$('.serie').hide();
							$('.nro_inicio').hide();
							$('.producto').hide();
							$('.cantidad').show();
							$('.importe').hide();
							$('.tip_venta').show();
							$('#tr_precio').html('Precio Unit.');
							$('#lbl_precio').val('Precio Unit.');
							$('.precio').show();
							$('.total').show();
							$('#div_con_fec_inicio').hide();
							$('#div_nro_doc_emp_fec_fin').hide();
							$('#div_fec_doc_imp_mensual').hide();
							$('#div_por_mora').hide();
							$('#div_nro_doc_emp_fec_doc_tupa').show();
							$('#div_nro_doc_der_fec_der_tupa').show();
							$('#div_for_pago_tupa').show();
							
							
							$('#leg_det_factura').html('Detalle de Tupa');
							
							$('#div_partida').show();
							$('#lbl_partida').html('Cod.Tupa');
							$('#div_serie').hide();
							$('#div_dias').hide();
							$('#div_formato').show();
							$('#div_tarifa').hide();
							$('#div_servicio').hide();
							$('#div_producto').hide();
							$('#div_nro_inicio').hide();
							$('#div_dias').hide();
							$('#div_cantidad').show();
							$('#div_precio').show();
							$('#div_total').show();
							$('#div_importe').hide();
							$('#div_tip_venta').show();
							$('#div_imp_isc_cam').hide();
							$('#div_sto_disponible').hide();
							$('#txt_precio').prop('disabled', true);
							
							
							for (var i = 0; i < arr_tar_tupa.length; i++) {
								var fields = arr_tar_tupa[i].split('|');								
								opt_detalle += '<option value="'+fields[0]+'">'+fields[1]+' - '+fields[2]+'</option>';								
								if (i == 0) {
									$('#txt_formato').val(fields[1]);
									$('#txt_precio').val(fields[3]);
								}
							}
							$('#sel_partida').html(opt_detalle);
							
							break;
						case '5': // Otros
							$('.partida').show();
							$('#tr_partida').html('Cod.Otros');
							$('.tarifa').hide();
							$('.dias').hide();
							$('.servicio').hide();
							$('.formato').hide();
							$('.serie').hide();
							$('.nro_inicio').hide();
							$('.producto').hide();
							$('.cantidad').show();
							$('.importe').hide();
							$('.tip_venta').show();
							$('#tr_precio').html('Precio Venta');
							$('#lbl_precio').val('Precio Venta');
							$('.precio').show();
							$('.total').show();
							$('#div_con_fec_inicio').show();
							$('#div_nro_doc_emp_fec_fin').show();
							$('#div_fec_doc_imp_mensual').show();
							$('#div_por_mora').show();
							$('#div_nro_doc_emp_fec_doc_tupa').hide();
							$('#div_nro_doc_der_fec_der_tupa').hide();
							$('#div_for_pago_tupa').hide();
							
							
							$('#div_partida').show();
							$('#div_serie').hide();
							$('#div_formato').hide();
							$('#div_tarifa').hide();
							$('#div_servicio').hide();
							$('#div_producto').hide();
							$('#div_nro_inicio').hide();
							$('#div_dias').hide();
							$('#div_cantidad').show();
							$('#div_precio').show();
							$('#div_total').show();
							$('#div_importe').hide();
							$('#div_tip_venta').show();
							$('#div_imp_isc_cam').hide();
							$('#div_sto_disponible').hide();
							$('#txt_precio').prop('disabled', false);
							$('#txt_cantidad').val('');
							$('#txt_precio').val('');
							$('#txt_total').val('');
							
							
							$('#lbl_partida').html('Cod.Otros');
							$('#leg_det_factura').html('Detalle de Otros');
							
							for (var i = 0; i < arr_tar_otros.length; i++) {
								var fields = arr_tar_otros[i].split('|');								
								opt_detalle += '<option value="'+fields[0]+'">'+fields[1]+'</option>';
							}
							$('#sel_partida').html(opt_detalle);							
							
							break;
					}					
				});

/* 				$('#txt_dias').change(function() {
 					if (!esnulo($(this).val())) { 	
 						var imp_total = parseInt($(this).val()) * parseFloat($('#txt_precio').val()); 						
 						$('#txt_total').val(imp_total.toFixed(6));
					}
 				}); */
 				$('#txt_persona').change(function() {
					if (!esnulo($(this).val())) { 	
						var imp_total = (parseFloat($('#txt_dias').val())*parseInt($(this).val())) * parseFloat($('#txt_precio').val()); 						
						$('#txt_total').val(imp_total.toFixed(2));
					}
				}); 
				$('#txt_cantidad').change(function() {
					var cod_tip_transaccion = $('#sel_tip_transaccion').val();
					if (cod_tip_transaccion == '5') { // Otros
						if (!esnulo($(this).val()) && !esnulo($('#txt_precio').val())) { 	
	 						//var imp_total = parseInt($(this).val()) * parseFloat($('#txt_precio').val()); 						
	 						var imp_total = parseFloat($(this).val()) * parseFloat($('#txt_precio').val());
	 						$('#txt_total').val(imp_total.toFixed(2));
						}	
					} else {
						if (!esnulo($(this).val())) { 	
	 						//var imp_total = parseInt($(this).val()) * parseFloat($('#txt_precio').val());
	 						var imp_total = parseFloat($(this).val()) * parseFloat($('#txt_precio').val());
	 						$('#txt_total').val(imp_total.toFixed(2));
						}
					}
 				});
				
				$('#txt_precio').change(function() {
 					if (!esnulo($(this).val()) && !esnulo($('#txt_cantidad').val())) { 	 	
 						var imp_total = parseFloat($(this).val()) * parseInt($('#txt_cantidad').val()); 						
 						$('#txt_total').val(imp_total.toFixed(2));
					}
 				});
				
				$('#btn_cancelar').click(function(e) {					
					e.preventDefault();
					
					// Removemos las partidas utilizadas y validamos el detalle	
					rem_det_transferencia();
					
					$('#div_det_facturas').modal('hide');
				});
				
				$('.btn_agr_partida').click(function(e) {					
					e.preventDefault();
					
					// Removemos las partidas utilizadas y validamos el detalle					
					var estado = rem_det_transferencia();
					if (!esnulo(estado)) {
						addWarnMessage(null, estado);
						return;
					}
					
					var cod_tip_transaccion = $('#sel_tip_transaccion').val(); 
					switch (cod_tip_transaccion) {
						case '1': // Servicios				
							$('#h_det_facturas').html('Nuevo Servicio');							
							
							$('#txt_dias').val('');
							$('#txt_persona').val('');
							$('#txt_total').val('');
							$('#sel_tip_venta').val('1');
							break;
							
						case '2': // Productos
							$('#h_det_facturas').html('Nuevo Producto');
							
							$('#txt_cantidad').val('');
							$('#txt_total').val('');
							$('#sel_tip_venta').val('1');
				
							break;
							
						case '3': // Boletos
							$('#h_det_facturas').html('Nuevo Boleto');
							
							$('#txt_nro_inicio').val('');
							$('#txt_cantidad').val('');
							$('#txt_total').val('');
							$('#sel_tip_venta').val('4');
							
							break;
							
						case '4': // Tupa
							$('#h_det_facturas').html('Nueva TUPA');
							
							$('#txt_cantidad').val('');
							$('#txt_total').val('');
							$('#sel_tip_venta').val('1');
							
							break;
							
						case '5': // Otros					
							$('#h_det_facturas').html('Nuevo Detalle Otros');							
							
							$('#txt_cantidad').val('');
							$('#txt_precio').val('');
							$('#txt_total').val('');
							$('#sel_tip_venta').val('4');
							
							break;
					}
					
					setPartida($('#sel_partida').val());
					
					$('#btn_anadir').show();
					$('#btn_editar').hide();
					$('#div_det_facturas').modal('show');
				});
				
				$('#sel_partida').on('change', function() {				
					setPartida($(this).val());
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
					
					var row_det = '';
					var row_num = $('#tbl_det_facturas td').closest('tr').length;
					var servicio = '';
					var importe = 0;
					var imp_afecto = 0;
					var imp_igv = 0;
					var imp_no_afecto = 0;
					var imp_isc = 0;					
					var cod_tip_venta = $('#sel_tip_venta').val();
					var des_tip_venta = $('#sel_tip_venta').find('option:selected').text();
					var cod_partida = $('#sel_partida').val();					
					var partida = $('#sel_partida option[value="'+cod_partida+'"]').text();
					var cod_tip_transaccion = $('#sel_tip_transaccion').val();

					switch (cod_tip_transaccion) {
						case '1': // Servicios			
												
							servicio = $('#txt_servicio').val();							
							var dias = parseInt($('#txt_dias').val());	
							var pers = parseInt($('#txt_persona').val());
							var precio = parseFloat($('#txt_precio').val());							
							var total = parseFloat($('#txt_total').val());							
							if (esnulo($('#txt_dias').val())) {
								addWarnMessage(null, 'El campo "Nro. Días" es obligatorio.');
								return;
							}
							if (esnulo($('#txt_persona').val())) {
								addWarnMessage(null, 'El campo "Nro. Personas" es obligatorio.');
								return;
							}								
							
							// Variable comun a calcular
							importe = total;		
							
							var vcod_partida = partida.split('-')[0];
							
							row_det = '<tr class="item">'+
										'<td>'+row_num+'</td>'+
										'<td class="partida">'+vcod_partida+'</td>'+
										'<td class="tarifa" style="display: none;"></td>'+
										'<td class="servicio">'+servicio+'</td>'+
										'<td class="dias">'+dias+'</td>'+
										'<td class="pers">'+pers+'</td>'+
										'<td class="formato" style="display: none;"></td>'+
										'<td class="serie" style="display: none;"></td>'+
										'<td class="nro_inicio" style="display: none;"></td>'+
										'<td class="producto" style="display: none;"></td>'+
										'<td class="cantidad" style="display: none;"></td>'+
										'<td class="importe" style="display: none;"></td>'+										
										'<td class="precio">'+precio.toFixed(2)+'</td>'+
										'<td class="total">'+total.toFixed(2)+'</td>'+
										'<td class="tip_venta">'+des_tip_venta+'</td>'+
										'<td class="hide cod_ser">'+cod_partida+'</td>'+
										'<td class="hide cod_tip">'+cod_tip_venta+'</td>';						  
							break;
							
						case '2': // Productos
						
							var producto = $('#txt_producto').val();							
							//var cantidad = parseInt($('#txt_cantidad').val());
							var cantidad = parseFloat($('#txt_cantidad').val());
							var precio = parseFloat($('#txt_precio').val());							
							var total = parseFloat($('#txt_total').val());							
							if (esnulo($('#txt_cantidad').val())) {
								addWarnMessage(null, 'El campo "Cantidad" es obligatorio.');
								return;
							}						
							
							// Variable comun a calcular
							importe = total;

							row_det = '<tr class="item">'+
										'<td>'+row_num+'</td>'+
										'<td class="partida">'+partida+'</td>'+
										'<td class="tarifa" style="display: none;"></td>'+
										'<td class="servicio" style="display: none;"></td>'+
										'<td class="dias" style="display: none;"></td>'+										
										'<td class="formato" style="display: none;"></td>'+
										'<td class="serie" style="display: none;"></td>'+
										'<td class="nro_inicio" style="display: none;"></td>'+
										'<td class="producto">'+producto+'</td>'+
										'<td class="cantidad">'+cantidad+'</td>'+
										'<td class="importe" style="display: none;"></td>'+										
										'<td class="precio">'+precio.toFixed(2)+'</td>'+
										'<td class="total">'+total.toFixed(2)+'</td>'+
										'<td class="tip_venta">'+des_tip_venta+'</td>'+
										'<td class="hide cod_ser">'+cod_partida+'</td>'+
										'<td class="hide cod_tip">'+cod_tip_venta+'</td>';
						
							break;
							
						case '3': // Boletos
										
							var serie = $('#txt_serie').val();
							var nro_inicio = parseInt($('#txt_nro_inicio').val());
							var cantidad = parseInt($('#txt_cantidad').val());			
							var precio = parseFloat($('#txt_precio').val());							
							var total = parseFloat($('#txt_total').val());							
							if (esnulo($('#txt_nro_inicio').val())) {
								addWarnMessage(null, 'El campo "Nro Inicio" es obligatorio.');
								return;
							}
							if (esnulo($('#txt_cantidad').val())) {
								addWarnMessage(null, 'El campo "Cantidad" es obligatorio.');
								return;
							}
							
							var num_inicio = parseFloat($('#txt_ini_disponible').val());
							var num_final = parseFloat($('#txt_fin_disponible').val());
							var can_stock = parseFloat($('#txt_stock').val());
							
							
							if (nro_inicio < num_inicio || nro_inicio > num_final) {
								addWarnMessage(null, 'El campo "Nro Inicio" no esta dentro del rango en el boleto asociado.');
								return;
							}
							
							if (cantidad > can_stock) {
								addWarnMessage(null, 'El campo "Cantidad" no esta dentro del rango en el boleto asociado.');
								return;
							}
							
							// Variable comun a calcular
							importe = total;

							row_det = '<tr class="item">'+
										'<td>'+row_num+'</td>'+
										'<td class="partida">'+obt_arr_cadena(partida)+'</td>'+
										'<td class="tarifa" style="display: none;"></td>'+
										'<td class="servicio" style="display: none;"></td>'+
										'<td class="dias" style="display: none;"></td>'+										
										'<td class="formato" style="display: none;"></td>'+
										'<td class="serie">'+serie+'</td>'+
										'<td class="nro_inicio">'+nro_inicio+'</td>'+
										'<td class="producto" style="display: none;"></td>'+
										'<td class="cantidad">'+cantidad+'</td>'+
										'<td class="importe" style="display: none;"></td>'+										
										'<td class="precio">'+precio.toFixed(2)+'</td>'+
										'<td class="total">'+total.toFixed(2)+'</td>'+
										'<td class="tip_venta">'+des_tip_venta+'</td>'+
										'<td class="hide cod_ser">'+cod_partida+'</td>'+
										'<td class="hide cod_tip">'+cod_tip_venta+'</td>';
						
						
							break;
							
						case '4': // Tupa
				
							var formato = $('#txt_formato').val();							
							var cantidad = parseInt($('#txt_cantidad').val());							
							var precio = parseFloat($('#txt_precio').val());							
							var total = parseFloat($('#txt_total').val());							
							if (esnulo($('#txt_cantidad').val())) {
								addWarnMessage(null, 'El campo "Cantidad" es obligatorio.');
								return;
							}						
							
							// Variable comun a calcular
							importe = total;

							row_det = '<tr class="item">'+
										'<td>'+row_num+'</td>'+
										'<td class="partida">'+partida+'</td>'+
										'<td class="tarifa" style="display: none;"></td>'+
										'<td class="servicio" style="display: none;"></td>'+
										'<td class="dias" style="display: none;"></td>'+
										'<td class="pers" style="display: none;"></td>'+
										'<td class="formato">'+formato+'</td>'+
										'<td class="serie" style="display: none;"></td>'+
										'<td class="nro_inicio" style="display: none;"></td>'+
										'<td class="producto" style="display: none;"></td>'+
										'<td class="cantidad">'+cantidad+'</td>'+
										'<td class="importe" style="display: none;"></td>'+										
										'<td class="precio">'+precio.toFixed(2)+'</td>'+
										'<td class="total">'+total.toFixed(2)+'</td>'+
										'<td class="tip_venta">'+des_tip_venta+'</td>'+
										'<td class="hide cod_ser">'+cod_partida+'</td>'+
										'<td class="hide cod_tip">'+cod_tip_venta+'</td>';
						
							break;
							
						case '5': // Otros
											
							var cantidad = parseInt($('#txt_cantidad').val());							
							var precio = parseFloat($('#txt_precio').val());							
							var total = parseFloat($('#txt_total').val());							
							if (esnulo($('#txt_cantidad').val())) {
								addWarnMessage(null, 'El campo "Cantidad" es obligatorio.');
								return;
							}
							if (esnulo($('#txt_precio').val())) {
								addWarnMessage(null, 'El campo "Precio Venta" es obligatorio.');
								return;
							}
							
							// Variable comun a calcular
							importe = total;		
							
							row_det = '<tr class="item">'+
										'<td>'+row_num+'</td>'+
										'<td class="partida">'+partida+'</td>'+
										'<td class="tarifa" style="display: none;"></td>'+
										'<td class="servicio" style="display: none;"></td>'+
										'<td class="dias" style="display: none;"></td>'+										
										'<td class="formato" style="display: none;"></td>'+
										'<td class="serie" style="display: none;"></td>'+
										'<td class="nro_inicio" style="display: none;"></td>'+
										'<td class="producto" style="display: none;"></td>'+
										'<td class="cantidad">'+cantidad+'</td>'+
										'<td class="importe" style="display: none;"></td>'+										
										'<td class="precio">'+precio.toFixed(2)+'</td>'+
										'<td class="total">'+total.toFixed(2)+'</td>'+
										'<td class="tip_venta">'+des_tip_venta+'</td>'+
										'<td class="hide cod_ser">'+cod_partida+'</td>'+
										'<td class="hide cod_tip">'+cod_tip_venta+'</td>';						  
							break;
					}
					
					
					// Calculo comun
					if (cod_tip_venta == '1') { // Gravada
						if (servicio.indexOf('COMIONETA') > 0) {
							imp_isc = parseFloat($('#txt_imp_isc_cam').val());
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
					
					// Calculamos los detalle de los montos
					var imp_tot_afecto = imp_afecto;
					var imp_tot_igv = imp_igv;
					var imp_tot_no_afecto = imp_no_afecto;
					var imp_tot_isc = imp_isc;					
					var imp_total = imp_tot_afecto + imp_tot_igv + imp_tot_no_afecto + imp_tot_isc;
					$('tr.item').each(function() {
						var imp_partida = $(this).find('.total').text();
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
					
					$('#txt_imp_voucher').val(imp_total.toFixed(2));
							  
								  
					var row_cal = '<td class="hide imp_afecto">'+imp_afecto+'</td>'+
								  '<td class="hide imp_igv">'+imp_igv+'</td>'+
								  '<td class="hide imp_no_afecto">'+imp_no_afecto+'</td>'+
								  '<td class="hide imp_isc">'+imp_isc+'</td>'+
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
					
					$('#tbl_det_facturas tr').eq(row_num-1).after(row_det + row_cal);
					
					$('#sel_tip_transaccion').prop('disabled', true);
					
					$('#sel_tip_transaccion').prop('title', 'No se puede cambiar el tipo de transaccion cuando ya se tiene un detalle');
					
					$('#div_det_facturas').modal('hide');
				});
				
				$('#tbl_det_facturas').on('click', '.btn_edi_partida', function(e) {
					e.preventDefault();
					
					var row = $(this).closest('tr'); // Find the row
					
					// Extraemos los datos del registro
				    var partida = $.trim(row.find(".partida").text());
				    var tarifa = $.trim(row.find(".tarifa").text());
				    var servicio = $.trim(row.find(".servicio").text());
				    var dias = $.trim(row.find(".dias").text());
				    var pers = $.trim(row.find(".pers").text());
				    var formato = $.trim(row.find(".formato").text());
				    var serie = $.trim(row.find(".serie").text());
				    var nro_inicio = $.trim(row.find(".nro_inicio").text());
				    var producto = $.trim(row.find(".producto").text());
				    var cantidad = $.trim(row.find(".cantidad").text());
				    var importe = $.trim(row.find(".importe").text());
				    var precio = $.trim(row.find(".precio").text());
				    var total = $.trim(row.find(".total").text());				    
				    var tip_venta = $.trim(row.find(".tip_venta").text());
				    var cod_ser = $.trim(row.find(".cod_ser").text());
				    var cod_tip = $.trim(row.find(".cod_tip").text());
				    
					// Removemos las partidas utilizadas y validamos el detalle	
					rem_det_transferencia();
				    
				    var cod_tip_transaccion = $('#sel_tip_transaccion').val();
					switch (cod_tip_transaccion) {
						case '1': // Servicios				

							// Agregamos la partida utilizada al combo detalle
						    $('#sel_partida').append($('<option>', {
							    value: cod_ser,
							    text: partida+' - '+servicio
							}));
						
						    $('#h_det_facturas').html('Editar Servicio');
						
							// Asignamos los datos del registro al formulario
						    $('#sel_partida').val(cod_ser);													 	
						    $('#txt_servicio').val(servicio);
							$('#txt_dias').val(dias);
							$('#txt_persona').val(pers);
							$('#txt_precio').val(precio);
							$('#txt_total').val(total);
						
							break;
							
						case '2': // Productos

							// Agregamos la partida utilizada al combo detalle
						    $('#sel_partida').append($('<option>', {
							    value: cod_ser,
							    text: partida+' - '+producto
							}));
						
						    $('#h_det_facturas').html('Editar Producto');
						
							// Asignamos los datos del registro al formulario
						    $('#sel_partida').val(cod_ser);													 	
						    $('#txt_producto').val(producto);
							$('#txt_cantidad').val(cantidad);
							$('#txt_precio').val(precio);
							$('#txt_total').val(total);

							break;
							
						case '3': // Boletos

							// Agregamos la partida utilizada al combo detalle
						    $('#sel_partida').append($('<option>', {
							    value: cod_ser,
							    text: serie + ' - ' + partida
							}));
						
						    $('#h_det_facturas').html('Editar Boleto');
						
							// Asignamos los datos del registro al formulario
						    $('#sel_partida').val(cod_ser);													 	
						    $('#txt_serie').val(serie);
						    $('#txt_nro_inicio').val(nro_inicio);
							$('#txt_cantidad').val(cantidad);
							$('#txt_precio').val(precio);
							$('#txt_total').val(total);
												
							break;
							
						case '4': // Tupa
					
							// Agregamos la partida utilizada al combo detalle
						    $('#sel_partida').append($('<option>', {
							    value: cod_ser,
							    text: partida+' - '+producto
							}));
						
						    $('#h_det_facturas').html('Editar Tupa');
						
							// Asignamos los datos del registro al formulario
						    $('#sel_partida').val(cod_ser);													 	
						    $('#txt_formato').val(formato);
							$('#txt_cantidad').val(cantidad);
							$('#txt_precio').val(precio);
							$('#txt_total').val(total);
						
							break;
							
						case '5': // Otros					

							// Agregamos la partida utilizada al combo detalle
						    $('#sel_partida').append($('<option>', {
							    value: cod_ser,
							    text: partida+' - '+servicio
							}));
						
						    $('#h_det_facturas').html('Editar Detalle Otros');
						
							// Asignamos los datos del registro al formulario
						    $('#sel_partida').val(cod_ser);													 	
						    $('#txt_cantidad').val(cantidad);
							$('#txt_precio').val(precio);
							$('#txt_total').val(total);
						
							break;
					}
				    
					$('#sel_tip_venta').val(cod_tip);
					$('#hid_partida').val(cod_ser);	

					$('#btn_anadir').hide();
					$('#btn_editar').show();
					$('#hid_par_ant').val(cod_ser);					
					
					$('#div_det_facturas').modal('show');
				});
				
				$('#btn_editar').click(function(e) {
					e.preventDefault();
					
					var cod_tip_transaccion = $('#sel_tip_transaccion').val();
					var cod_tip_venta = $('#sel_tip_venta').val();
					var des_tip_venta = $('#sel_tip_venta').find('option:selected').text();
					var cod_partida = $('#sel_partida').val();					
					var partida = $('#sel_partida option[value="'+cod_partida+'"]').text();
					
					var servicio = $('#txt_servicio').val();							
					var dias = parseInt($('#txt_dias').val());
					var pers = parseInt($('#txt_persona').val());
										
					var producto = $('#txt_producto').val();							
					//var cantidad = parseInt($('#txt_cantidad').val());
					var cantidad = parseFloat($('#txt_cantidad').val());
					
					var serie = $('#txt_serie').val();
					var nro_inicio = parseInt($('#txt_nro_inicio').val());
					
					var formato = $('#txt_formato').val();
					
					var precio = parseFloat($('#txt_precio').val());
					var total = parseFloat($('#txt_total').val());
					var importe = 0;
					var val_partida = $('#hid_partida').val();
					var val_par_ant = $('#hid_par_ant').val();
					
					
					// Editamos el registro actual
					var row = 0;				
					$('tr.item').each(function() {
						row = row + 1;
						var srl_cod_ser = $(this).find('.cod_ser').text();						
						if (srl_cod_ser == val_par_ant) {
							return false;
						}
					});
					
					
					switch (cod_tip_transaccion) {
						case '1': // Servicios				
	
							if (esnulo($('#txt_dias').val())) {
								addWarnMessage(null, 'El campo "Nro. Días" es obligatorio.');
								return;
							}
							if (esnulo($('#txt_persona').val())) {
								addWarnMessage(null, 'El campo "Nro. de Personas" es obligatorio.');
								return;
							}														
							// Variable comun a calcular
							importe = total;		
							
							break;
						
						case '2': // Productos
	
							if (esnulo($('#txt_cantidad').val())) {
								addWarnMessage(null, 'El campo "Cantidad" es obligatorio.');
								return;
							}						
							
							// Variable comun a calcular
							importe = total;

							break;
						
						case '3': // Boletos
	
							if (esnulo($('#txt_nro_inicio').val())) {
								addWarnMessage(null, 'El campo "Nro Inicio" es obligatorio.');
								return;
							}
							if (esnulo($('#txt_cantidad').val())) {
								addWarnMessage(null, 'El campo "Cantidad" es obligatorio.');
								return;
							}
							
							var num_inicio = parseFloat($('#txt_ini_disponible').val());
							var num_final = parseFloat($('#txt_fin_disponible').val());
							var can_stock = parseFloat($('#txt_stock').val());							
							
							if (nro_inicio < num_inicio || nro_inicio > num_final) {
								addWarnMessage(null, 'El campo "Nro Inicio" no esta dentro del rango en el boleto asociado.');
								return;
							}
							
							if (cantidad > can_stock) {
								addWarnMessage(null, 'El campo "Cantidad" no esta dentro del rango en el boleto asociado.');
								return;
							}
							
							// Variable comun a calcular
							importe = total;
						
							break;
						
						case '4': // Tupa
					
							if (esnulo($('#txt_cantidad').val())) {
								addWarnMessage(null, 'El campo "Cantidad" es obligatorio.');
								return;
							}						
							
							// Variable comun a calcular
							importe = total;
						
							break;
						
						case '5': // Otros					
	
							if (esnulo($('#txt_cantidad').val())) {
								addWarnMessage(null, 'El campo "Cantidad" es obligatorio.');
								return;
							}
						
							if (esnulo($('#txt_precio').val())) {
								addWarnMessage(null, 'El campo "Precio Venta" es obligatorio.');
								return;
							}
							
							// Variable comun a calcular
							importe = total;

							break;
					}
					

					var imp_afecto = 0;
					var imp_igv = 0;
					var imp_no_afecto = 0;
					var imp_isc = 0;
					
					if (cod_tip_venta == '1') { // Gravada
						if (servicio.indexOf('COMIONETA') > 0) {
							imp_isc = parseFloat($('#txt_imp_isc_cam').val());
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
													
					
					switch (cod_tip_transaccion) {
						case '1': // Servicios				
	
							var vcod_partida = partida.split('-')[0];
							
							$('#tbl_det_facturas tr').eq(row).find('td').eq(1).html(vcod_partida);
							$('#tbl_det_facturas tr').eq(row).find('td').eq(2).html('');
							$('#tbl_det_facturas tr').eq(row).find('td').eq(3).html(servicio);
							$('#tbl_det_facturas tr').eq(row).find('td').eq(4).html(dias);
							$('#tbl_det_facturas tr').eq(row).find('td').eq(5).html(pers);
							$('#tbl_det_facturas tr').eq(row).find('td').eq(6).html('');
							$('#tbl_det_facturas tr').eq(row).find('td').eq(7).html('');
							$('#tbl_det_facturas tr').eq(row).find('td').eq(8).html('');
							$('#tbl_det_facturas tr').eq(row).find('td').eq(9).html('');
							$('#tbl_det_facturas tr').eq(row).find('td').eq(10).html('');
							$('#tbl_det_facturas tr').eq(row).find('td').eq(11).html('');
							$('#tbl_det_facturas tr').eq(row).find('td').eq(12).html(precio.toFixed(2));
							$('#tbl_det_facturas tr').eq(row).find('td').eq(13).html(total.toFixed(2));
							$('#tbl_det_facturas tr').eq(row).find('td').eq(14).html(des_tip_venta);
							$('#tbl_det_facturas tr').eq(row).find('td').eq(15).html(cod_partida);
							$('#tbl_det_facturas tr').eq(row).find('td').eq(16).html(cod_tip_venta);
							$('#tbl_det_facturas tr').eq(row).find('td').eq(17).html(imp_afecto);
							$('#tbl_det_facturas tr').eq(row).find('td').eq(18).html(imp_igv);
							$('#tbl_det_facturas tr').eq(row).find('td').eq(19).html(imp_no_afecto);
							$('#tbl_det_facturas tr').eq(row).find('td').eq(29).html(imp_isc);			
						
							break;
						
						case '2': // Productos
						
							$('#tbl_det_facturas tr').eq(row).find('td').eq(1).html(partida);
							$('#tbl_det_facturas tr').eq(row).find('td').eq(2).html('');
							$('#tbl_det_facturas tr').eq(row).find('td').eq(3).html('');
							$('#tbl_det_facturas tr').eq(row).find('td').eq(4).html('');
							$('#tbl_det_facturas tr').eq(row).find('td').eq(5).html('');
							$('#tbl_det_facturas tr').eq(row).find('td').eq(6).html('');
							$('#tbl_det_facturas tr').eq(row).find('td').eq(7).html('');
							$('#tbl_det_facturas tr').eq(row).find('td').eq(8).html(producto);
							$('#tbl_det_facturas tr').eq(row).find('td').eq(9).html(cantidad);
							$('#tbl_det_facturas tr').eq(row).find('td').eq(10).html('');
							$('#tbl_det_facturas tr').eq(row).find('td').eq(11).html(precio.toFixed(2));
							$('#tbl_det_facturas tr').eq(row).find('td').eq(12).html(total.toFixed(2));
							$('#tbl_det_facturas tr').eq(row).find('td').eq(13).html(des_tip_venta);
							$('#tbl_det_facturas tr').eq(row).find('td').eq(14).html(cod_partida);
							$('#tbl_det_facturas tr').eq(row).find('td').eq(15).html(cod_tip_venta);
							$('#tbl_det_facturas tr').eq(row).find('td').eq(16).html(imp_afecto);
							$('#tbl_det_facturas tr').eq(row).find('td').eq(17).html(imp_igv);
							$('#tbl_det_facturas tr').eq(row).find('td').eq(18).html(imp_no_afecto);
							$('#tbl_det_facturas tr').eq(row).find('td').eq(19).html(imp_isc);	
				
							break;
						
						case '3': // Boletos
	
							$('#tbl_det_facturas tr').eq(row).find('td').eq(1).html(obt_arr_cadena(partida));
							$('#tbl_det_facturas tr').eq(row).find('td').eq(2).html('');
							$('#tbl_det_facturas tr').eq(row).find('td').eq(3).html('');
							$('#tbl_det_facturas tr').eq(row).find('td').eq(4).html('');
							$('#tbl_det_facturas tr').eq(row).find('td').eq(5).html('');
							$('#tbl_det_facturas tr').eq(row).find('td').eq(6).html(serie);
							$('#tbl_det_facturas tr').eq(row).find('td').eq(7).html(nro_inicio);
							$('#tbl_det_facturas tr').eq(row).find('td').eq(8).html('');
							$('#tbl_det_facturas tr').eq(row).find('td').eq(9).html(cantidad);
							$('#tbl_det_facturas tr').eq(row).find('td').eq(10).html('');
							$('#tbl_det_facturas tr').eq(row).find('td').eq(11).html(precio.toFixed(2));
							$('#tbl_det_facturas tr').eq(row).find('td').eq(12).html(total.toFixed(2));
							$('#tbl_det_facturas tr').eq(row).find('td').eq(13).html(des_tip_venta);
							$('#tbl_det_facturas tr').eq(row).find('td').eq(14).html(cod_partida);
							$('#tbl_det_facturas tr').eq(row).find('td').eq(15).html(cod_tip_venta);
							$('#tbl_det_facturas tr').eq(row).find('td').eq(16).html(imp_afecto);
							$('#tbl_det_facturas tr').eq(row).find('td').eq(17).html(imp_igv);
							$('#tbl_det_facturas tr').eq(row).find('td').eq(18).html(imp_no_afecto);
							$('#tbl_det_facturas tr').eq(row).find('td').eq(19).html(imp_isc);
						
							break;
						
						case '4': // Tupa
					
							$('#tbl_det_facturas tr').eq(row).find('td').eq(1).html(partida);
							$('#tbl_det_facturas tr').eq(row).find('td').eq(2).html('');
							$('#tbl_det_facturas tr').eq(row).find('td').eq(3).html('');
							$('#tbl_det_facturas tr').eq(row).find('td').eq(4).html('');
							$('#tbl_det_facturas tr').eq(row).find('td').eq(5).html('');
							$('#tbl_det_facturas tr').eq(row).find('td').eq(6).html(formato);
							$('#tbl_det_facturas tr').eq(row).find('td').eq(7).html('');
							$('#tbl_det_facturas tr').eq(row).find('td').eq(8).html('');
							$('#tbl_det_facturas tr').eq(row).find('td').eq(9).html('');
							$('#tbl_det_facturas tr').eq(row).find('td').eq(10).html(cantidad);
							$('#tbl_det_facturas tr').eq(row).find('td').eq(11).html('');
							$('#tbl_det_facturas tr').eq(row).find('td').eq(12).html(precio.toFixed(2));
							$('#tbl_det_facturas tr').eq(row).find('td').eq(13).html(total.toFixed(2));
							$('#tbl_det_facturas tr').eq(row).find('td').eq(14).html(des_tip_venta);
							$('#tbl_det_facturas tr').eq(row).find('td').eq(15).html(cod_tip_venta);
							$('#tbl_det_facturas tr').eq(row).find('td').eq(16).html(imp_afecto);
							$('#tbl_det_facturas tr').eq(row).find('td').eq(17).html(imp_igv);
							$('#tbl_det_facturas tr').eq(row).find('td').eq(18).html(imp_no_afecto);
							$('#tbl_det_facturas tr').eq(row).find('td').eq(19).html(imp_isc);
						
							break;
						
						case '5': // Otros					

							$('#tbl_det_facturas tr').eq(row).find('td').eq(1).html(partida);
							$('#tbl_det_facturas tr').eq(row).find('td').eq(2).html('');
							$('#tbl_det_facturas tr').eq(row).find('td').eq(3).html('');
							$('#tbl_det_facturas tr').eq(row).find('td').eq(4).html('');
							$('#tbl_det_facturas tr').eq(row).find('td').eq(5).html('');
							$('#tbl_det_facturas tr').eq(row).find('td').eq(6).html('');
							$('#tbl_det_facturas tr').eq(row).find('td').eq(7).html('');
							$('#tbl_det_facturas tr').eq(row).find('td').eq(8).html('');
							$('#tbl_det_facturas tr').eq(row).find('td').eq(9).html(cantidad);
							$('#tbl_det_facturas tr').eq(row).find('td').eq(10).html('');
							$('#tbl_det_facturas tr').eq(row).find('td').eq(11).html(precio.toFixed(2));
							$('#tbl_det_facturas tr').eq(row).find('td').eq(12).html(total.toFixed(2));
							$('#tbl_det_facturas tr').eq(row).find('td').eq(13).html(des_tip_venta);
							$('#tbl_det_facturas tr').eq(row).find('td').eq(14).html(cod_partida);
							$('#tbl_det_facturas tr').eq(row).find('td').eq(15).html(cod_tip_venta);
							$('#tbl_det_facturas tr').eq(row).find('td').eq(16).html(imp_afecto);
							$('#tbl_det_facturas tr').eq(row).find('td').eq(17).html(imp_igv);
							$('#tbl_det_facturas tr').eq(row).find('td').eq(18).html(imp_no_afecto);
							$('#tbl_det_facturas tr').eq(row).find('td').eq(19).html(imp_isc);

							break;
					}
					

					// Recalculamos el monto total considerando el registro actual
					var imp_tot_afecto = 0;
					var imp_tot_igv = 0;
					var imp_tot_no_afecto = 0;
					var imp_tot_isc = 0;					
					var imp_total = imp_tot_afecto + imp_tot_igv + imp_tot_no_afecto + imp_tot_isc;

					$('tr.item').each(function() {
						var imp_partida = $(this).find('.total').text();					
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
					
					$('#txt_imp_voucher').val(imp_total.toFixed(2));
					
					// Removemos las partidas utilizadas y validamos el detalle	
					rem_det_transferencia();

					$('#div_det_facturas').modal('hide');
				});
				
				$('#tbl_det_facturas').on('click', '.btn_rem_partida', function(e) {				
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
								 	
									// Recalculamos el monto total
									var imp_tot_afecto = 0;
									var imp_tot_igv = 0;
									var imp_tot_no_afecto = 0;
									var imp_tot_isc = 0;					
									var imp_total = imp_tot_afecto + imp_tot_igv + imp_tot_no_afecto + imp_tot_isc;
									var row_num = 0;
									$('tr.item').each(function() {
										row_num = row_num + 1;		
										var imp_partida = $(this).find('.total').text();
										if (!esnulo(imp_partida)) {
											imp_total = imp_total + parseFloat(imp_partida);
											imp_tot_afecto = imp_tot_afecto + parseFloat($(this).find('.imp_afecto').text());
											imp_tot_igv = imp_tot_igv + parseFloat($(this).find('.imp_igv').text());
											imp_tot_no_afecto = imp_tot_no_afecto + parseFloat($(this).find('.imp_no_afecto').text());
											imp_tot_isc = imp_tot_isc + parseFloat($(this).find('.imp_isc').text());
											$('#tbl_det_facturas tr').eq(row_num).find('td').eq(0).html(row_num);
										}
									});
									 
									$('#txt_imp_total').val(imp_total.toFixed(6));
									$('#txt_imp_afecto').val(imp_tot_afecto.toFixed(6));
									$('#txt_imp_igv').val(imp_tot_igv.toFixed(6));
									$('#txt_imp_no_afecto').val(imp_tot_no_afecto.toFixed(6));
									$('#txt_imp_isc').val(imp_tot_isc.toFixed(6));
									
									$('#txt_imp_voucher').val(imp_total.toFixed(2));
									
									// Habilitamos el combo tipo de transaccion si esta vacio el detalle
									var row_num = $('#tbl_det_facturas td').closest('tr').length;
									if (row_num == 1) {
										$('#sel_tip_transaccion').prop('disabled', false);
										$('#sel_tip_transaccion').prop('title', '');
									}

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
					$('#txt_nro_dni').prop('disabled', true);
					$('input[name=rb_tip_proveedor]').prop('disabled', true);
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
									$('input[name="rb_tip_proveedor"][value="'+paramJson.tip_proveedor+'"]').prop('checked', true);
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
														$('#txt_reg_raz_social').prop('disabled', false);
													} else {
														$('input[name=rb_tip_empresa][value="1"]').prop('checked', true);
														$('#txt_reg_raz_social').prop('disabled', true);
													}		
													$('input[name=rb_entidad]').prop('disabled', false);
													$('input[name=rb_tip_empresa]').prop('disabled', false);
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
				
				$('#txt_nro_dni').change(function() {
					$('#txt_nro_ruc').prop('disabled', true);
					$('input[name=rb_tip_proveedor]').prop('disabled', true);
					var nro_dni = $(this).val();
					if (!esnulo(nro_dni)) {
						$.ajax({
							type: 'GET',
							url: '${pageContext.request.contextPath}/verificarDni',
							data: {
								nro_dni : nro_dni
							},
							dataType: 'json',
							success: function(paramJson) {						
								if (paramJson.num_documento != null) {								
									$('#hid_proveedor').val(paramJson.cod_proveedor);
									$('input[name="rb_tip_proveedor"][value="'+paramJson.tip_proveedor+'"]').prop('checked', true);
									$('#txt_nombres').val(paramJson.nombres);
									$('#txt_apellidos').val(paramJson.ape_paterno+ ' '+paramJson.ape_materno);
								} else {
									bootbox.dialog({
										message: "<span class='bigger-110'>La persona no existe, desea registrarlo?</span>",
										buttons: {
											"click" : {
												"label" : "Si",
												"className" : "btn-sm btn-primary",
												"callback": function() {												
													$('#form_reg_proveedor').trigger("reset");
													$('#txt_nro_doc').val(nro_dni);
													$('#txt_nro_doc').prop('disabled', true);
													$('#txt_reg_raz_social').prop('disabled', true);
													$('input[name=rb_entidad]').prop('disabled', true);
													$('input[name=rb_tip_empresa]').prop('disabled', true);
													$('#txt_ape_paterno').prop('disabled', false);
													$('#txt_ape_materno').prop('disabled', false);
													$('#txt_reg_nombres').prop('disabled', false);
													$('#sel_tip_doc').val('2');
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
				
				$('input:radio[name="rb_tip_proveedor"]').change(function() {			       
			        if ($(this).val() == '4') { // Proveedore Varios
			        	$('#txt_nro_ruc').prop('disabled', true);
			        	$('#txt_nro_dni').prop('disabled', true);
			        	$('#txt_nro_ruc').val('');
			        	$('#txt_nro_dni').val('');
			        } else {
			        	$('#txt_nro_ruc').prop('disabled', false);
			        	$('#txt_nro_dni').prop('disabled', false);
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
					
					// Nro DNI
					var nro_dni = $('#txt_nro_dni').val();
					
					var msg = '';
					
					if (!esnulo(nro_dni)) {
						tip_proveedor = '3';
						if (esnulo(ape_paterno)) {
							msg = msg + 'El campo "Ape. Paterno" es obligatorio.<br/>';
						}
						if (esnulo(ape_materno)) {
							msg = msg + 'El campo "Ape. Materno" es obligatorio.<br/>';
						}
						if (esnulo(nombres)) {
							msg = msg + 'El campo "Nombres" es obligatorio.<br/>';
						}
					} else {					
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
									$('#txt_fec_inicio').val(paramJson[0].fec_inicio);
									$('#txt_fec_fin').val(paramJson[0].fec_final);
									$('#txt_imp_mensual').val(paramJson[0].num_imp_contrato);
									$('#txt_por_mora').val(paramJson[0].num_imp_interes);
								} else {
									$('#hid_contrato').val('');
									addWarnMessage(null, 'El Numero de Contrato no está registrado.');
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
					var url = '${pageContext.request.contextPath}/comprasIngreso/2';
					$(location).attr('href', url);		
				});
				
				$('#btn_grabar').click(function(e) {					
					e.preventDefault();
					
					var codigo = $('#hid_reg_compras').val();
					var tip_operacion = $('input[name="rb_tip_operacion"]:checked').val();
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
					var imp_total = parseFloat($('#txt_imp_total').val());
					var num_constancia = $('#txt_num_constancia').val();
					var fec_pag_deposito = $('#txt_fec_pag_deposito').val();
					var imp_deposito = $('#txt_imp_deposito').val();
					var por_deposito = $('#txt_por_deposito').val();
					var cod_contrato = $('#hid_contrato').val();
					var num_doc_empresa = '';
					var fec_doc_empresa = '';					
					var num_doc_derivacion = $('#txt_nro_doc_der_tupa').val();
					var fec_doc_derivacion = $('#txt_fec_der_tupa').val();
					var cod_med_pago = $('#sel_for_pago').val();					
					var cod_uni_ope = $('#sel_uni_operativa').val();
					var cod_anp = $('#sel_anp').val();					
					var cod_tip_transaccion = $('#sel_tip_transaccion').val();
					var cod_mes = $('#sel_periodo').val();
					var num_cta_cte = $('#txt_num_cta_cte').val();
					var des_glosa = $('#txt_observa').val();
					var cod_ctacte = $('#sel_ctacte').val();
					var num_cta_cte =' ';
					var cod_sucur = $('#sel_sucursal').val();
					var ind_tip_fact = $('input[name="rb_tip_factu"]:checked').val();
					var cod_serie = $('#hid_cod_serie').val();
					var cod_anno = $('#sel_anno').val();					
					var cod_dir_fact = $('#sel_dir_fact').val();
					
					if (cod_tip_transaccion == '4') { // Tupa
						num_doc_empresa = $('#txt_nro_doc_emp_tupa').val();
						fec_doc_empresa = $('#txt_fec_doc_tupa').val();
					} else if (cod_tip_transaccion == '5') { // Otros
						num_doc_empresa = $('#txt_nro_doc_empresa').val();
						fec_doc_empresa = $('#txt_fec_documento').val();
					}
					
					var tip_proveedor = $('input[name="rb_tip_proveedor"]:checked');
					var ind_pro_varios = '';
					if (tip_proveedor.length > 0) {
						ind_pro_varios = $('input[name="rb_tip_proveedor"]:checked').val();
					}
					
					var msg = '';
					
					if (esnulo(ser_comprobante)) {
						msg = msg + 'El campo "Serie Comprobante" es obligatorio.<br/>';
					}				
					if (esnulo(nro_comprobante)) {
						msg = msg + 'El campo "Nro Comprobante" es obligatorio.<br/>';
					}
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
					 // Diferente de Moneda Soles
					if (cod_moneda > 1 && esnulo(num_tip_cambio)) {
						msg = msg + 'El campo "Tipo de Cambio" es obligatorio.<br/>';
					}

					if (!esnulo(msg)) {
						addWarnMessage(null, msg);
						return;
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

					
					// Detalle de Ingresos
					var arr_partida = '';
					var arr_importe = '';
					var arr_dias = '';
					var arr_pers = '';
					var arr_cantidad = '';
					var arr_pre_unitario = '';
					var arr_num_ini_boleto = '';
					var arr_tip_venta = '';					
					var arr_imp_afecto = '';
					var arr_imp_igv = '';
					var arr_imp_no_afecto = '';
					var arr_imp_isc = '';					
					var row = 0;
					
					$('tr.item').each(function() {		
						var ind_partida = $(this).find('.partida').text();
						if (!esnulo(ind_partida)) {
							arr_dias = arr_dias + $(this).find('.dias').text() + '|';
							arr_pers = arr_pers + $(this).find('.pers').text() + '|';
							arr_cantidad = arr_cantidad + $(this).find('.cantidad').text() + '|';
							arr_pre_unitario = arr_pre_unitario + $(this).find('.precio').text() + '|';
							arr_num_ini_boleto = arr_num_ini_boleto + $(this).find('.nro_inicio').text() + '|';
							arr_partida = arr_partida + $(this).find('.cod_ser').text() + '|';
							arr_importe = arr_importe + $(this).find('.importe').text() + '|';
							arr_tip_venta = arr_tip_venta + $(this).find('.cod_tip').text() + '|';							
							arr_imp_afecto = arr_imp_afecto + $(this).find('.imp_afecto').text() + '|';
							arr_imp_igv = arr_imp_igv + $(this).find('.imp_igv').text() + '|';
							arr_imp_no_afecto = arr_imp_no_afecto + $(this).find('.imp_no_afecto').text() + '|';
							arr_imp_isc = arr_imp_isc + $(this).find('.imp_isc').text() + '|';							
							row = row + 1;
						}						
					});
					
					if (row > 0) {
						arr_dias = arr_dias.substring(0, arr_dias.length - 1);
						arr_pers = arr_pers.substring(0, arr_pers.length - 1);
						arr_cantidad = arr_cantidad.substring(0, arr_cantidad.length - 1);
						arr_pre_unitario = arr_pre_unitario.substring(0, arr_pre_unitario.length - 1);
						arr_num_ini_boleto = arr_num_ini_boleto.substring(0, arr_num_ini_boleto.length - 1);						
						arr_partida = arr_partida.substring(0, arr_partida.length - 1);
						arr_importe = arr_importe.substring(0, arr_importe.length - 1);
						arr_tip_venta = arr_tip_venta.substring(0, arr_tip_venta.length - 1);						
						arr_imp_afecto = arr_imp_afecto.substring(0, arr_imp_afecto.length - 1);
						arr_imp_igv = arr_imp_igv.substring(0, arr_imp_igv.length - 1);
						arr_imp_no_afecto = arr_imp_no_afecto.substring(0, arr_imp_no_afecto.length - 1);
						arr_imp_isc = arr_imp_isc.substring(0, arr_imp_isc.length - 1);
					} else {
						
						switch (cod_tip_transaccion) {
							case '1': // Servicios				
	
								addWarnMessage(null, 'Debe Agregar Detalle Servicios.');
							
								break;
							case '2': // Productos
	
								addWarnMessage(null, 'Debe Agregar Detalle Productos.');
					
								break;
							case '3': // Boletos
	
								addWarnMessage(null, 'Debe Agregar Detalle Boletos.');
							
								break;
							case '4': // Tupa
						
								addWarnMessage(null, 'Debe Agregar Detalle Tupa.');
							
								break;
							case '5': // Otros					

								addWarnMessage(null, 'Debe Agregar Detalle Factura.');				
					
								break;
						}

						return;
					}
					
										
					// Detalle de Papeletas
					var arr_nro_papeleta = '';
					var arr_fec_papeleta = '';
					var arr_imp_papeleta = '';
					var arr_arc_pap = '';				
					var row_pap = 0;
					var imp_voucher = 0;
					$('tr.item_pap').each(function() {		
						var ind_nro_pap = $(this).find('.nro_pap').text();
						if (!esnulo(ind_nro_pap)) {
							arr_nro_papeleta = arr_nro_papeleta + ind_nro_pap + '|';
							arr_fec_papeleta = arr_fec_papeleta + $(this).find('.fec_pap').text() + '|';
							var imp_pap = $(this).find('.imp_pap').text()
							arr_imp_papeleta = arr_imp_papeleta + imp_pap + '|';
							arr_arc_pap = arr_arc_pap + $(this).find('.cod_vou').text() + '|';						
							row_pap = row_pap + 1;
							imp_voucher = imp_voucher + parseFloat(imp_pap);
						}						
					});					
					if (row_pap > 0) {
						arr_nro_papeleta = arr_nro_papeleta.substring(0, arr_nro_papeleta.length - 1);
						arr_fec_papeleta = arr_fec_papeleta.substring(0, arr_fec_papeleta.length - 1);
						arr_imp_papeleta = arr_imp_papeleta.substring(0, arr_imp_papeleta.length - 1);
						arr_arc_pap = arr_arc_pap.substring(0, arr_arc_pap.length - 1);
					}
					
					
					if (!esnulo(imp_voucher)) {
						var imp_vou_val = parseFloat(imp_voucher);
						if (imp_vou_val > imp_total) {
							msg = msg + 'El campo "Importe" no puede ser mayor al importe total.<br/>';
						}
					}

					var new_record = true;
					if (!esnulo(codigo)) {
						new_record = false;
					}
					
					
					var params = {
						cod_com_ingresos : codigo,
						tip_operacion : tip_operacion,
						cod_comprobante : cod_comprobante,
						fec_comprobante : fec_comprobante,
						int_transaccion : 2, // Identificador de la transacción Ingresos
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
						num_doc_empresa : num_doc_empresa,
						fec_doc_empresa : fec_doc_empresa,
						num_doc_derivacion : num_doc_derivacion,
						fec_doc_derivacion : fec_doc_derivacion,
						cod_med_pago : cod_med_pago,
						arr_partida : arr_partida,
						cod_uni_operativa : cod_uni_ope,
						cod_reg_nac : cod_anp,
						cod_tip_transaccion : cod_tip_transaccion,
						cod_mes : cod_mes,
						num_cta_cte : num_cta_cte,
						des_glosa : des_glosa,
						cod_ctacte : cod_ctacte,
						cod_sucur : cod_sucur,
						ind_tip_fact : ind_tip_fact,
						cod_serie : cod_serie,
						cod_anno : cod_anno,
						cod_dir_fact : cod_dir_fact,
						arr_dias : arr_dias,
						arr_pers : arr_pers,
						arr_cantidad : arr_cantidad,
						arr_pre_unitario : arr_pre_unitario,
						arr_num_ini_boleto : arr_num_ini_boleto,							
						arr_importe : arr_importe,
						arr_tip_venta : arr_tip_venta,
						arr_imp_afecto : arr_imp_afecto,
						arr_imp_no_afecto : arr_imp_no_afecto,
						arr_imp_igv : arr_imp_igv,
						arr_imp_isc : arr_imp_isc,
						ind_pro_varios : ind_pro_varios,
						arr_nro_papeleta : arr_nro_papeleta,
						arr_fec_papeleta : arr_fec_papeleta,
						arr_imp_papeleta : arr_imp_papeleta,
						arr_arc_pap : arr_arc_pap
					};
					
					
					if (esnulo(codigo)) {
						startAjax();
						
						// Validamos el comprobante nuevo
						$.ajax({
							type: 'GET',
							url: '${pageContext.request.contextPath}/validarComprobante',
							data: {
								// Primera Validacion
								int_transaccion : 2, // Identificador de la transacción Ingresos
								cod_uni_operativa : cod_uni_ope,
								cod_reg_nac : cod_anp,
								ser_comprobante : ser_comprobante,
								nro_comprobante : nro_comprobante,
								fec_comprobante : fec_comprobante,
								cod_mes : cod_mes,
								// Segunda Validacion
								cod_comprobante : cod_comprobante,
								cod_proveedor : cod_proveedor
							},
							dataType: 'json',
							success: function(paramJsonIng) {				
								if (paramJsonIng == '1') {
									
									endAjax();
									addWarnMessage(null, 'Comprobante ya registrado.');
									return;
									
								} else if (paramJsonIng == '2') {
								
									endAjax();
									addWarnMessage(null, 'Su registro se encuentra dentro de un mes cerrado.');
									return;
									
								} else {
																	
									// Validacion de registro de datos del voucher de depósito					
									if (esnulo(arr_nro_papeleta) || esnulo(cod_ctacte)) {
										var msg_val = '';
										var ind_msg_val = false;
										if (esnulo(arr_nro_papeleta)) {
											msg_val = 'No se ha registrado los datos del detalle de papeletas, ';
											ind_msg_val = true;
										}
										if (esnulo(cod_ctacte)) {
											if (ind_msg_val) {
												msg_val = msg_val + '<br> No se ha registrado la Cta Cte, ';
											} else {
												msg_val = msg_val + 'No se ha registrado la Cta Cte, ';
											}
										}

										endAjax();
										
										bootbox.dialog({
											message: "<span class='bigger-110'>"+msg_val+"Desea Continuar?</span>",
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
																		addInfoMessage(null, 'El registro fue grabado.');
																	} else {
																		addInfoMessage(null, 'Registro Actualizado.');
																	}								
																}	
															},
															error: function(jqXHR, error, errorThrown) {
																var msg = 'Error:grabarIngresoCompras NUevo<br/>';
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
														addInfoMessage(null, 'El registro fue grabado.');
													} else {
														addInfoMessage(null, 'Registro Actualizado.');
													}								
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
						
						// Validacion de registro de datos del voucher de depósito					
						if (esnulo(arr_nro_papeleta) || esnulo(cod_ctacte)) {
							var msg_val = '';
							var ind_msg_val = false;
							if (esnulo(arr_nro_papeleta)) {
								msg_val = 'El detalle de papeletas, no contiene informacion ';
								ind_msg_val = true;
							}
							if (esnulo(cod_ctacte)) {
								if (ind_msg_val) {
									msg_val = msg_val + '<br> La Cta Cte, No contine informacion';
								} else {
									msg_val = msg_val + 'No ha actualizado la Cta Cte, ';
								}
							}
							
							bootbox.dialog({
								message: "<span class='bigger-110'>"+msg_val+"Desea Continuar?</span>",
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
												success: function(paramJson){						
													if (paramJson != null) {
														endAjax();
														if (new_record) {
															$('#hid_reg_compras').val(paramJson);
															$('#btn_eliminar').show();
															addInfoMessage(null, 'El registro fue grabado....!!');
														} else {
															addInfoMessage(null, 'Registro Actualizado...!!');
														}								
													}	
												},
												/*error: function(jqXHR, error, errorThrown) {
													var msg = 'Error de Actualizacion: despues de la validacion voucher de depósito<br/>';
													if (jqXHR.status && jqXHR.status == 400) {
														msg = msg + jqXHR.responseText;
													} else {
														msg = msg + errorThrown;
													}
													addErrorMessage(null, msg);
												}*/
												error: function(jqXHR, textStatus, errorThrown) {
													var msg = 'Error No se Actualizo el Final del Registro:<br/>';

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
						} else {  //Actualizacion con los datos de papeletas y ctacte llenos
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
											addInfoMessage(null, 'El registro fue grabado...! con los datos del voucher y ctacte registrados');
										} else {
											addInfoMessage(null, 'Registro Actualizado....! con los datos del voucher y ctacte registrados');
										}								
									}	
								},
								error: function(jqXHR, error, errorThrown) {
									var msg = 'Error: No se pudo actualizar el registro... Los campos papeletas y ctate registrados<br/>';
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
				
				$('#btn_eliminar').click(function(e) {					
					e.preventDefault();
					bootbox.dialog({
						message: "<span class='bigger-110'>Esta seguro de eliminar la compra?</span>",
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
												var url = VAR_CONTEXT + '/comprasIngreso/2';
												$(location).attr('href', url);
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
							"button" : {
								"label" : "Salir",
								"className" : "btn-sm"
							}
						}
					});
				});
				
				$('#btn_notas').click(function(e) {					
					e.preventDefault(); //Evitar que un enlace abra la URL
					
					var cod_comprobante = $('#sel_tip_comprobante').val();
					var row = 0;
					var cod_par_nc = null;
					var nro_par_nc = null;
					var des_ser_nc = null;
					var cod_cue_nc = null;
					var nro_cue_nc = null;
					var des_cue_nc = null;
					var cod_tip = null;
					var des_tip = null;
					var opt_detalle = '';
					
					var cod_tip_transaccion = $('#sel_tip_transaccion').val(); 
					switch (cod_tip_transaccion) {
						case '1': // Servicios				
														
							$('#div_par_nc').show();
							$('#div_ser_nc').hide();
							$('#div_for_nc').hide();
							$('#div_tar_nc').hide();
							$('#div_serv_nc').show();
							$('#div_pro_nc').hide();
							$('#div_nro_ini_nc').hide();
							$('#div_dia_nc').show();
							$('#div_can_nc').hide();
							$('#div_pre_nc').show();
							$('#div_tot_nc').show();
							$('#div_imp_nc').hide();
							$('#div_tip_ven_nc').show();
							$('#div_imp_isc_cam_nc').hide();
							$('#div_sto_dis_nc').hide();
							$('#txt_pre_nc').prop('disabled', true);
							
							
							$('#lbl_par_nc').html('Servicio');
							$('#lbl_ser_nc').html('Nombre del Servicio');
							
							
							$('tr.item').each(function() {		
								des_tip = $(this).find('.tip_venta').text();
								if (!esnulo(des_tip)) {
									cod_par_nc = $(this).find('.cod_ser').text();
									cod_tip = $(this).find('.cod_tip').text();
									$('#hid_des_tip').val($(this).find('.servicio').text());
									row = row + 1;
									return false;
								}						
							});
																					
							for (var i = 0; i < arr_tar_servicio.length; i++) {
								var fields = arr_tar_servicio[i].split('|');		
								if (fields[0] == cod_par_nc) {
									opt_detalle += '<option value="'+fields[0]+'">'+fields[1]+' - '+fields[2]+'</option>';
									$('#txt_serv_nc').val(fields[2]);
									$('#txt_pre_nc').val(fields[3]);
									break;
								}
							}
							$('#sel_par_nc').html(opt_detalle);

							$('#sel_par_nc').val(cod_par_nc);
							$('#hid_partida').val(cod_par_nc);	
							$('#sel_tip_ven_nc').val(cod_tip);
							$('#hid_tip_venta').val(cod_tip);
						
							break;
							
						case '2': // Productos
						
							$('#div_par_nc').show();
							$('#div_ser_nc').hide();
							$('#div_for_nc').hide();
							$('#div_tar_nc').hide();
							$('#div_serv_nc').hide();
							$('#div_pro_nc').show();
							$('#div_nro_ini_nc').hide();
							$('#div_dia_nc').hide();
							$('#div_can_nc').show();
							$('#div_pre_nc').show();
							$('#div_tot_nc').show();
							$('#div_imp_nc').hide();
							$('#div_tip_ven_nc').show();
							$('#div_imp_isc_cam_nc').hide();
							$('#div_sto_dis_nc').hide();
							$('#txt_pre_nc').prop('disabled', true);
							
							
							$('#lbl_par_nc').html('Partida');
														
							
							$('tr.item').each(function() {		
								des_tip = $(this).find('.tip_venta').text();
								if (!esnulo(des_tip)) {
									cod_par_nc = $(this).find('.cod_ser').text();
									cod_tip = $(this).find('.cod_tip').text();
									$('#hid_des_tip').val($(this).find('.servicio').text());
									row = row + 1;
									return false;
								}						
							});
																					
							for (var i = 0; i < arr_productos.length; i++) {
								var fields = arr_productos[i].split('|');		
								if (fields[0] == cod_par_nc) {
									opt_detalle += '<option value="'+fields[0]+'">'+fields[1]+' - '+fields[2]+'</option>';
									$('#txt_pro_nc').val(fields[2]);
									$('#txt_pre_nc').val(fields[3]);
									break;
								}
							}
							$('#sel_par_nc').html(opt_detalle);

							$('#sel_par_nc').val(cod_par_nc);
							$('#hid_partida').val(cod_par_nc);
							$('#sel_tip_ven_nc').val(cod_tip);
							$('#hid_tip_venta').val(cod_tip);
					
							break;
							
						case '3': // Boletos
						
							$('#div_par_nc').show();
							$('#div_ser_nc').show();
							$('#div_for_nc').hide();
							$('#div_tar_nc').hide();
							$('#div_serv_nc').hide();
							$('#div_pro_nc').hide();
							$('#div_nro_ini_nc').show();
							$('#div_dia_nc').hide();
							$('#div_can_nc').show();
							$('#div_pre_nc').show();
							$('#div_tot_nc').show();
							$('#div_imp_nc').hide();
							$('#div_tip_ven_nc').show();
							$('#div_imp_isc_cam_nc').hide();
							$('#div_sto_dis_nc').hide();
							$('#txt_pre_nc').prop('disabled', true);
							
							
							$('#lbl_par_nc').html('Tarifa');
														
						
							$('tr.item').each(function() {		
								des_tip = $(this).find('.tip_venta').text();
								if (!esnulo(des_tip)) {
									cod_par_nc = $(this).find('.cod_ser').text();
									cod_tip = $(this).find('.cod_tip').text(); 
									$('#hid_des_tip').val($(this).find('.servicio').text());
									row = row + 1;
									return false;
								}						
							});						
						
							for (var i = 0; i < arr_tar_boletos.length; i++) {
								var fields = arr_tar_boletos[i].split('|');								
								if (fields[0] == cod_par_nc) {
									opt_detalle += '<option value="'+fields[0]+'">'+fields[1]+' - '+fields[2]+'</option>';
									$('#txt_ser_nc').val(fields[3]);
									$('#txt_pre_nc').val(fields[7]);
									$('#txt_sto_nc').val(fields[6]);
									$('#txt_ini_dis_nc').val(fields[4]);
									$('#txt_fin_dis_nc').val(fields[5]);
									break;
								}
							}
							$('#sel_par_nc').html(opt_detalle);

							$('#sel_par_nc').val(cod_par_nc);
							$('#hid_partida').val(cod_par_nc);
							$('#sel_tip_ven_nc').val(cod_tip);
							$('#hid_tip_venta').val(cod_tip);
												
							break;
							
						case '4': // Tupa
						
							$('#div_par_nc').show();
							$('#div_ser_nc').hide();
							$('#div_for_nc').show();
							$('#div_tar_nc').hide();
							$('#div_serv_nc').hide();
							$('#div_pro_nc').hide();
							$('#div_nro_ini_nc').hide();
							$('#div_dia_nc').hide();
							$('#div_can_nc').show();
							$('#div_pre_nc').show();
							$('#div_tot_nc').show();
							$('#div_imp_nc').hide();
							$('#div_tip_ven_nc').show();
							$('#div_imp_isc_cam_nc').hide();
							$('#div_sto_dis_nc').hide();
							$('#txt_pre_nc').prop('disabled', true);
							
							
							$('#lbl_par_nc').html('Tarifa');
									
									
							$('tr.item').each(function() {		
								des_tip = $(this).find('.tip_venta').text();
								if (!esnulo(des_tip)) {
									cod_par_nc = $(this).find('.cod_ser').text();
									cod_tip = $(this).find('.cod_tip').text();
									$('#hid_des_tip').val($(this).find('.servicio').text());
									row = row + 1;
									return false;
								}						
							});
																					
							for (var i = 0; i < arr_tar_tupa.length; i++) {
								var fields = arr_tar_tupa[i].split('|');		
								if (fields[0] == cod_par_nc) {
									opt_detalle += '<option value="'+fields[0]+'">'+fields[1]+' - '+fields[2]+'</option>';
									$('#txt_for_nc').val(fields[1]);
									$('#txt_pre_nc').val(fields[3]);
									break;
								}
							}
							$('#sel_par_nc').html(opt_detalle);

							$('#sel_par_nc').val(cod_par_nc);
							$('#hid_partida').val(cod_par_nc);
							$('#sel_tip_ven_nc').val(cod_tip);
							$('#hid_tip_venta').val(cod_tip);
						
							break;
							
						case '5': // Otros					
						
							$('#div_par_nc').show();
							$('#div_ser_nc').hide();
							$('#div_for_nc').hide();
							$('#div_tar_nc').hide();
							$('#div_serv_nc').hide();
							$('#div_pro_nc').hide();
							$('#div_nro_ini_nc').hide();
							$('#div_dia_nc').hide();
							$('#div_can_nc').show();
							$('#div_pre_nc').show();
							$('#div_tot_nc').show();
							$('#div_imp_nc').hide();
							$('#div_tip_ven_nc').show();
							$('#div_imp_isc_cam_nc').hide();
							$('#div_sto_dis_nc').hide();
							$('#txt_pre_nc').prop('disabled', false);
							
							
							$('#lbl_par_nc').html('Partida');
														
							
							$('tr.item').each(function() {		
								des_tip = $(this).find('.tip_venta').text();
								if (!esnulo(des_tip)) {
									cod_par_nc = $(this).find('.cod_ser').text();
									cod_tip = $(this).find('.cod_tip').text();
									$('#hid_des_tip').val($(this).find('.servicio').text());
									row = row + 1;
									return false;
								}						
							});
																					
							for (var i = 0; i < arr_tar_otros.length; i++) {
								var fields = arr_tar_otros[i].split('|');		
								if (fields[0] == cod_par_nc) {
									opt_detalle += '<option value="'+fields[0]+'">'+fields[1]+' - '+fields[2]+'</option>';
									break;
								}
							}
							$('#sel_par_nc').html(opt_detalle);

							$('#sel_par_nc').val(cod_par_nc);
							$('#hid_partida').val(cod_par_nc);
							$('#sel_tip_ven_nc').val(cod_tip);
							$('#hid_tip_venta').val(cod_tip);
						
							break;
					}
				
					if (row > 1) {
						addWarnMessage(null, 'No se puede generar una nota de credito, con mas de un detalle partidas.');
						return;
					} else if (cod_comprobante == '2' || // Factura
								cod_comprobante == '4') { // Boleta de Venta
						
						$('#txt_nro_fac_nc').val($('#txt_ser_comprobante').val()+'-'+$('#txt_nro_comprobante').val());
						$('#txt_ruc_nc').val($('#txt_nro_ruc').val());
						$('#txt_raz_soc_nc').val($('#txt_raz_social').val());
						$('#hid_partida').val(cod_par_nc);												
						if (des_tip.indexOf('COMIONETA') > 0) {
							$('#div_imp_isc_cam_nc').show();
						} else {
							$('#txt_imp_isc_cam_nc').val('');
							$('#div_imp_isc_cam_nc').hide();
						}						
					} else {
						addWarnMessage(null, 'No se puede generar una nota de credito, con un "Tipo de Comprobante" que no sea Factura ó Boleta de Venta.');
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
				
				$('#sel_tip_com_nc').on('change', function() {
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
				
				$('#txt_dia_nc').change(function() {
 					if (!esnulo($(this).val())) { 	
 						var imp_total = parseInt($(this).val()) * parseFloat($('#txt_pre_nc').val());						
 						$('#txt_tot_nc').val(imp_total.toFixed(2));
						cal_imp_total(imp_total);
					}
 				});
				
				$('#txt_can_nc').change(function() {
					var cod_tip_transaccion = $('#sel_tip_transaccion').val();
					if (cod_tip_transaccion == '5') { // Otros
						if (!esnulo($(this).val()) && !esnulo($('#txt_pre_nc').val())) { 	
	 						var imp_total = parseInt($(this).val()) * parseFloat($('#txt_pre_nc').val()); 						
	 						$('#txt_tot_nc').val(imp_total.toFixed(2));
							cal_imp_total(imp_total);
						}	
					} else {
						if (!esnulo($(this).val())) { 	
	 						var imp_total = parseInt($(this).val()) * parseFloat($('#txt_pre_nc').val()); 						
	 						$('#txt_tot_nc').val(imp_total.toFixed(2));
							cal_imp_total(imp_total);
						}
					}
 				});
				
				$('#txt_pre_nc').change(function() {
 					if (!esnulo($(this).val()) && !esnulo($('#txt_can_nc').val())) { 	 	
 						var imp_total = parseFloat($(this).val()) * parseInt($('#txt_can_nc').val()); 						
 						$('#txt_tot_nc').val(imp_total.toFixed(2));
						cal_imp_total(imp_total);
					}
 				});
							
				$('#btn_gra_not_credito').click(function(e) {					
					e.preventDefault();
					
					var cod_pad_com_ingresos = $('#hid_reg_compras').val();
					var cod_comprobante = $('#sel_tip_com_nc').val();
					var fec_comprobante = $('#txt_fec_doc_nc').val();
					var ser_comprobante = $('#txt_ser_nc').val();
					var nro_comprobante = $('#txt_nro_doc_nc').val();							
					var cod_partida = $('#hid_partida').val();
					var dias = $('#txt_dia_nc').val();
					var cantidad = $('#txt_can_nc').val();
					var pre_unitario = $('#txt_pre_nc').val();
					var num_ini_boleto = $('#txt_nro_ini_nc').val();
					var cod_tip_venta = $('#hid_tip_venta').val();
					var imp_afecto = $('#txt_imp_afe_nc').val();
					var imp_igv = $('#txt_imp_igv_nc').val();
					var imp_no_afecto = $('#txt_imp_no_afe_nc').val();
					var imp_isc = $('#txt_imp_isc_nc').val();
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
 						msg = msg + 'El campo "Número Doc." es obligatorio.<br/>';
 					}
 										
					var cod_tip_transaccion = $('#sel_tip_transaccion').val(); 
					switch (cod_tip_transaccion) {
						case '1': // Servicios				
							if (esnulo(dias)) {
								msg = msg + 'El campo "Nro. Días" es obligatorio.<br/>';
							}
							break;							
						case '2': // Productos
							if (esnulo(cantidad)) {
								msg = msg + 'El campo "Cantidad" es obligatorio.<br/>';
							}
							break;
						case '3': // Boletos
							if (esnulo(num_ini_boleto)) {
								msg = msg + 'El campo "Nro. Inicio" es obligatorio.<br/>';
							}
							if (esnulo(cantidad)) {
								msg = msg + 'El campo "Cantidad" es obligatorio.<br/>';
							}
							break;
						case '4': // Tupa
							if (esnulo(cantidad)) {
								msg = msg + 'El campo "Cantidad" es obligatorio.<br/>';
							}
							break;
						case '5': // Otros					
							if (esnulo(cantidad)) {
								msg = msg + 'El campo "Cantidad" es obligatorio.<br/>';
							}
							if (esnulo(pre_unitario)) {
								msg = msg + 'El campo "Precio Venta" es obligatorio.<br/>';
							}
							break;
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
							int_transaccion : 2, // Identificador de la transacción Ingresos
							ser_comprobante : ser_comprobante,							
							nro_comprobante : nro_comprobante,
							cod_tip_transaccion : cod_tip_transaccion,
							cod_partida : cod_partida,
							dias : dias,
							cantidad : cantidad,
							pre_unitario : pre_unitario,
							num_ini_boleto : num_ini_boleto,
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
				
				$('.btn_agr_papeleta').click(function(e) {					
					e.preventDefault();
					$('#h_det_papeletas').html('Nueva Papeleta');
					$('.fileinput').fileinput('clear');
					$('#txt_nro_papeleta').val('');
					$('#txt_fec_papeleta').val('');	
					$('#txt_imp_papeleta').val('');	
					$('#div_imagen').hide();
					$('#div_upload_imagen').show();					
					$('#btn_ana_papeletas').show();
					$('#btn_edi_papeletas').hide();
					$('#div_det_papeletas').modal('show');
				});
				
				$('#btn_cambiar').click(function(e) {					
					e.preventDefault();					
					$('#div_imagen').hide();
					$('#div_upload_imagen').show();			
				});

				$('#btn_ana_papeletas').click(function(e) {					
					e.preventDefault();
				
					var nro_papeleta = $('#txt_nro_papeleta').val();
					var fec_papeleta = $('#txt_fec_papeleta').val();
					var imp_papeleta = parseFloat($('#txt_imp_papeleta').val());
					var row_det = null;
					var row_det_pap = $('#tbl_det_papeletas td').closest('tr').length;
					
					var file_name = $('#file_name_avatar').val();
					var file_data = null;
					if (!esnulo(file_name) && typeof file_name !== 'undefined') {
						file_data = $('#file_name_avatar').prop('files')[0];
					}
					
					var msg = '';					
					if (esnulo(nro_papeleta)) {
						msg = msg + 'El campo "Nro Papeleta" es obligatorio.<br/>';
					}
					if (esnulo(fec_papeleta)) {
						msg = msg + 'El campo "Fecha" es obligatorio.<br/>';
					}
					if (esnulo(imp_papeleta)) {
						msg = msg + 'El campo "Importe" es obligatorio.<br/>';
					}
					if (!esnulo(msg)) {
						addWarnMessage(null, msg);
						return;
					}

					if (!esnulo(file_name)) {
						var form_data = new FormData();					
						form_data.append('file_avatar', file_data);					
					
						$.ajax({
							type: 'POST',
							url: VAR_CONTEXT + '/guardarImagen',				
							dataType: 'text',
							cache: false,
							contentType: false,
							processData: false,
							data: form_data,
							success: function(paramJson) {						
								if (paramJson != null) {
									
									row_det = '<tr class="item_pap">'+
												'<td class="nro_item">'+row_det_pap+'</td>'+
												'<td class="nro_pap">'+nro_papeleta+'</td>'+
												'<td class="fec_pap">'+fec_papeleta+'</td>'+
												'<td class="imp_pap">'+imp_papeleta.toFixed(2)+'</td>'+
												'<td class="arc_pap center">'+paramJson+
												'</td>'+
												'<td class="hide cod_vou">'+paramJson+'</td>'+
												'<td>'+
													'<button class="btn btn-sm btn-warning input-sm btn_edi_papeleta">'+
														'<i class="ace-icon fa fa-pencil-square-o"></i>'+
													'</button>'+
												'</td>'+
												'<td>'+
													'<button class="btn btn-sm btn-danger input-sm btn_rem_papeleta">'+
														'<i class="ace-icon fa fa-trash-o"></i>'+
													'</button>'+																																	
												'</td>'+									
											  '</tr>';

									$('#tbl_det_papeletas tr').eq(row_det_pap-1).after(row_det);
									
									$('#div_det_papeletas').modal('hide');
								}	
							},
							error: function(jqXHR, error, errorThrown) {
								endAjax();
								var msg = 'Error:<br/>';
								if (jqXHR.status && jqXHR.status == 400) {
									msg = msg + jqXHR.responseText;
									showMessage(msg);
								} else {
									msg = msg + errorThrown;
									showMessage(msg);
								}
							}
						});
					
					} else {
						
						row_det = '<tr class="item_pap">'+
									'<td class="nro_item">'+row_det_pap+'</td>'+
									'<td class="nro_pap">'+nro_papeleta+'</td>'+
									'<td class="fec_pap">'+fec_papeleta+'</td>'+
									'<td class="imp_pap">'+imp_papeleta.toFixed(2)+'</td>'+
									'<td class="arc_pap center"></td>'+
									'<td class="hide cod_vou"></td>'+
									'<td>'+
										'<button class="btn btn-sm btn-warning input-sm btn_edi_papeleta">'+
											'<i class="ace-icon fa fa-pencil-square-o"></i>'+
										'</button>'+
									'</td>'+
									'<td>'+
										'<button class="btn btn-sm btn-danger input-sm btn_rem_papeleta">'+
											'<i class="ace-icon fa fa-trash-o"></i>'+
										'</button>'+																																	
									'</td>'+									
								  '</tr>';
						
						$('#tbl_det_papeletas tr').eq(row_det_pap-1).after(row_det);
						
						$('#div_det_papeletas').modal('hide');
					}

				});
				
				$('#tbl_det_papeletas').on('click', '.btn_edi_papeleta', function(e) {
					e.preventDefault();
					$('#h_det_papeletas').html('Editar Papeleta');
					
					var row = $(this).closest('tr'); // Find the row
					
					// Extraemos los datos del registro
					var nro_item = $.trim(row.find('.nro_item').text());
				    var nro_pap = $.trim(row.find('.nro_pap').text());
				    var fec_pap = $.trim(row.find('.fec_pap').text());
				    var imp_pap = $.trim(row.find('.imp_pap').text());
				    var cod_vou = $.trim(row.find('.cod_vou').text());
					
				    $('.fileinput').fileinput('clear');
				    
				 	// Asignamos los datos del registro al formulario
				    $('#txt_nro_papeleta').val(nro_pap);
					$('#txt_fec_papeleta').val(fec_pap);
					$('#txt_imp_papeleta').val(imp_pap);
					$('#hid_pap').val(nro_item);
				
					if (!esnulo(cod_vou)) {
						$('#div_imagen').show();
						$('#div_upload_imagen').hide();
						$('#avatar').attr('src', '${pageContext.request.contextPath}/resources/uploads/' + cod_vou);
					} else {
						$('#div_imagen').hide();
						$('#div_upload_imagen').show();
					}
					$('#btn_ana_papeletas').hide();
					$('#btn_edi_papeletas').show();
					$('#div_det_papeletas').modal('show');
				});
				
				$('#btn_edi_papeletas').click(function(e) {
					e.preventDefault();
					
					var nro_papeleta = $('#txt_nro_papeleta').val();
					var fec_papeleta = $('#txt_fec_papeleta').val();
					var imp_papeleta = parseFloat($('#txt_imp_papeleta').val());
					var nro_item = $('#hid_pap').val();
					
					var file_name = $('#file_name_avatar').val();
					var file_data = null;
					if (!esnulo(file_name) && typeof file_name !== 'undefined') {
						file_data = $('#file_name_avatar').prop('files')[0];
					}
					
					var msg = '';					
					if (esnulo(nro_papeleta)) {
						msg = msg + 'El campo "Nro Papeleta" es obligatorio.<br/>';
					}
					if (esnulo(fec_papeleta)) {
						msg = msg + 'El campo "Fecha" es obligatorio.<br/>';
					}
					if (esnulo(imp_papeleta)) {
						msg = msg + 'El campo "Importe" es obligatorio.<br/>';
					}
					if (!esnulo(msg)) {
						addWarnMessage(null, msg);
						return;
					}
					
					// Editamos el registro actual
					var row = 0;					
					$('tr.item_pap').each(function() {
						row = row + 1;
						var srl_item = $(this).find('.nro_item').text();						
						if (srl_item == nro_item) {
							return false;
						}
					});
					
					
					if (!esnulo(file_name)) {
						var form_data = new FormData();					
						form_data.append('file_avatar', file_data);					
					
						$.ajax({
							type: 'POST',
							url: VAR_CONTEXT + '/guardarImagen',				
							dataType: 'text',
							cache: false,
							contentType: false,
							processData: false,
							data: form_data,
							success: function(paramJson) {						
								if (paramJson != null) {

									$('#tbl_det_papeletas tr').eq(row).find('td').eq(1).html(nro_papeleta);
									$('#tbl_det_papeletas tr').eq(row).find('td').eq(2).html(fec_papeleta);
									$('#tbl_det_papeletas tr').eq(row).find('td').eq(3).html(imp_papeleta.toFixed(2));
									$('#tbl_det_papeletas tr').eq(row).find('td').eq(4).html(paramJson);
									$('#tbl_det_papeletas tr').eq(row).find('td').eq(5).html(paramJson);
									
									$('#div_det_papeletas').modal('hide');
								}	
							},
							error: function(jqXHR, error, errorThrown) {
								endAjax();
								var msg = 'Error:<br/>';
								if (jqXHR.status && jqXHR.status == 400) {
									msg = msg + jqXHR.responseText;
									showMessage(msg);
								} else {
									msg = msg + errorThrown;
									showMessage(msg);
								}
							}
						});
					
					} else {
						
						$('#tbl_det_papeletas tr').eq(row).find('td').eq(1).html(nro_papeleta);
						$('#tbl_det_papeletas tr').eq(row).find('td').eq(2).html(fec_papeleta);
						$('#tbl_det_papeletas tr').eq(row).find('td').eq(3).html(imp_papeleta.toFixed(2));
						$('#tbl_det_papeletas tr').eq(row).find('td').eq(4).html('');
						$('#tbl_det_papeletas tr').eq(row).find('td').eq(5).html('');
						$('#div_det_papeletas').modal('hide');
					}
					
				});
				
				$('#tbl_det_papeletas').on('click', '.btn_rem_papeleta', function(e) {				
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
																		
									// Reordenamos el numero registros
									var row_num = 0;
									$('tr.item_pap').each(function() {
										row_num = row_num + 1;
										var nro_pap = $(this).find('.nro_pap').text();
										if (!esnulo(nro_pap)) {
											$('#tbl_det_papeletas tr').eq(row_num).find('td').eq(0).html(row_num);
										}
									});
									
								}
							}, 
							"button" : {
								"label" : "Cancelar",
								"className" : "btn-sm"
							}
						}
					});
				});	
				
			});
			
			function inicializarDatos() {
				
				if (!esnulo($('#hid_reg_compras').val())) {
					var tip_operacion = '${compra.tip_operacion}';
					$('input[name=rb_tip_operacion][value="'+tip_operacion+'"]').prop('checked', true);
					
					$('#sel_uni_operativa').val('${compra.cod_uni_operativa}');
					var cod_comprobante = '${compra.cod_comprobante}';
					$('#sel_tip_comprobante').val(cod_comprobante);					
					$('#txt_fec_comprobante').val('${compra.fec_comprobante}');
					$('#txt_ser_comprobante').val('${compra.ser_comprobante}');
					$('#sel_fue_financiamiento').val('${compra.cod_fue_financiamiento}');					
					$('#txt_nro_comprobante').val('${compra.nro_comprobante}');
					$('#txt_nro_siaf').val('${compra.nro_siaf}');
					$('#sel_tip_moneda').val('${compra.cod_moneda}');
					$('#txt_tip_cambio').val('${compra.num_tip_cambio}');					
					$('#hid_proveedor').val('${compra.cod_proveedor}');
					$('input[name="rb_tip_proveedor"][value="${compra.tip_proveedor}"]').prop('checked', true);				
					if ('${compra.tip_proveedor}' == '3') { // Cliente
						$('#txt_nro_dni').val('${compra.num_documento}');
					} else {
						$('#txt_nro_ruc').val('${compra.num_ruc}');	
					}
					$('input[name=rb_tip_proveedor]').prop('disabled', true);					
					$('#txt_raz_social').val("${compra.raz_social}");
					$('#txt_nombres').val('${compra.nombres}');
					$('#txt_apellidos').val('${compra.ape_paterno}'+ ' '+'${compra.ape_materno}');
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
					var cod_tip_transaccion = '${tip_transaccion}';
					$('#sel_tip_transaccion').val(cod_tip_transaccion);
					$('#sel_periodo').val('${compra.cod_mes}');
					$('#sel_anno').val('${compra.cod_anno}');
					$('#txt_num_cta_cte').val('${compra.num_cta_cte}');
					$('#txt_observa').val("${compra.des_glosa}");  //Este es el campo de texto
					var observa = "${compra.des_glosa}";
					$('#sel_for_pago').val('${compra.cod_med_pago}');
					$('#sel_ctacte').val('${compra.cod_ctacte}');
					$('#sel_dir_fact').val('${compra.cod_dir_fact}');
					$('#txt_estado').val('${compra.estado}');
					$('#sel_sucur').val('${compra.cod_sucur}');
					$('input[name=rb_tip_factu][value="'+'${compra.ind_tip_fact}'+'"]').prop('checked', true);

					var cod_sucur = "${compra.cod_sucur}";
					var estado = '${compra.estado}'
					if(estado='ANULADO'){
						$('#btn_eliminar').prop('disabled', true);
					}
					if(estado='ACTIVO'){
						$('#btn_eliminar').prop('disabled', false);
					}					
					if(estado='ELIMINADO'){
						$('#btn_eliminar').prop('disabled', false);
					}					
										
					var row = 0;
					var imp_tot_afecto = 0;
					var imp_tot_igv = 0;
					var imp_tot_no_afecto = 0;
					var imp_tot_isc = 0;
					$('tr.item').each(function() {
						row = row + 1;		
						var imp_partida = $(this).find('.total').text(); // Parametrizar
						if (!esnulo(imp_partida)) {
							imp_tot_afecto = imp_tot_afecto + parseFloat($(this).find('.imp_afecto').text());
							imp_tot_igv = imp_tot_igv + parseFloat($(this).find('.imp_igv').text());
							imp_tot_no_afecto = imp_tot_no_afecto + parseFloat($(this).find('.imp_no_afecto').text());
							imp_tot_isc = imp_tot_isc + parseFloat($(this).find('.imp_isc').text());
							$()
						}
					});
					var imp_total = imp_tot_afecto + imp_tot_igv + imp_tot_no_afecto + imp_tot_isc;
					$('#txt_imp_total').val(imp_total.toFixed(2));
					$('#txt_imp_afecto').val(imp_tot_afecto.toFixed(2));
					$('#txt_imp_igv').val(imp_tot_igv.toFixed(2));
					$('#txt_imp_no_afecto').val(imp_tot_no_afecto.toFixed(2));
					$('#txt_imp_isc').val(imp_tot_isc.toFixed(2));
					
					mon_imp_actual = imp_total;
					
					// Removemos las partidas utilizadas y validamos el detalle	
					//rem_det_transferencia();
					
					if (indicador > 1) {
						$('#txt_nro_ruc').prop('disabled', true);
						$('#txt_nro_dni').prop('disabled', true);
					}
					
					var opt_detalle = '';
					
					switch (cod_tip_transaccion) {
						case '1': // Servicios
							
							$('#lbl_partida').html('Servicio');
							$('#lbl_servicio').html('Nombre del Servicio');
							$('#leg_det_factura').html('Detalle de Servicios');

							
							$('#tr_partida').html('Codigo');
							$('.tarifa').hide();
							$('.formato').hide();
							$('.serie').hide();
							$('.cantidad').hide();
							$('.nro_inicio').hide();
							$('.producto').hide();							
							$('.importe').hide();
							$('#tr_precio').html('Precio Venta');
							$('#lbl_precio').val('Precio');
							
							
							$('#lbl_partida').html('Partida:');
							$('#div_serie').hide();
							$('#div_formato').hide();
							$('#div_tarifa').hide();
							$('#div_producto').hide();
							$('#div_nro_inicio').hide();
							$('#div_cantidad').hide();
							$('#div_importe').hide();
							$('#div_imp_isc_cam').hide();
							$('#div_sto_disponible').hide();
							$('#txt_precio').prop('disabled', true);
							
						
							$('#div_con_fec_inicio').hide();
							$('#div_nro_doc_emp_fec_fin').hide();
							$('#div_fec_doc_imp_mensual').hide();
							$('#div_por_mora').hide();
							$('#div_nro_doc_emp_fec_doc_tupa').hide();
							$('#div_nro_doc_der_fec_der_tupa').hide();
							$('#div_for_pago_tupa').hide();
							

							for (var i = 0; i < arr_tar_servicio.length; i++) {
								var fields = arr_tar_servicio[i].split('|');								
								opt_detalle += '<option value="'+fields[0]+'">'+fields[1]+' - '+fields[2]+'</option>';								
								if (i == 0) {
									$('#txt_servicio').val(fields[2]);
									$('#txt_precio').val(fields[3]);
								}
							}
							$('#sel_partida').html(opt_detalle);
							
							break;
							
						case '2': // Productos

							$('#leg_det_factura').html('Detalle de Productos');
						
						
							$('#tr_partida').html('Detalle de Productos');
							$('.tarifa').hide();
							$('.dias').hide();
							$('.pers').hide();
							$('.servicio').hide();
							$('.formato').hide();
							$('.serie').hide();
							$('.nro_inicio').hide();
							$('.cantidad').show();
							$('.importe').hide();
							$('#tr_precio').html('Precio Venta');
							$('#lbl_precio').val('Precio Venta');
							
							
							$('#lbl_partida').html('Partida:');
							$('#div_serie').hide();
							$('#div_formato').hide();
							$('#div_tarifa').hide();
							$('#div_servicio').hide();
							$('#div_nro_inicio').hide();
							$('#div_dias').hide();
							$('#div_importe').hide();
							$('#div_imp_isc_cam').hide();
							$('#div_sto_disponible').hide();
							$('#txt_precio').prop('disabled', true);
							
							
							$('#div_con_fec_inicio').hide();
							$('#div_nro_doc_emp_fec_fin').hide();
							$('#div_fec_doc_imp_mensual').hide();
							$('#div_por_mora').hide();
							$('#div_nro_doc_emp_fec_doc_tupa').hide();
							$('#div_nro_doc_der_fec_der_tupa').hide();
							$('#div_for_pago_tupa').hide();
							
							
							for (var i = 0; i < arr_productos.length; i++) {
								var fields = arr_productos[i].split('|');								
								opt_detalle += '<option value="'+fields[0]+'">'+fields[1]+' - '+fields[2]+'</option>';								
								if (i == 0) {
									$('#txt_producto').val(fields[2]);
									$('#txt_precio').val(fields[3]);
								}
							}
							$('#sel_partida').html(opt_detalle);
							
							break;
							
						case '3': // Boletos
						
							$('#leg_det_factura').html('Detalle de Boletos');
						
							$('#tr_partida').html('Detalle de Boletos');
							$('.tarifa').hide();
							$('.dias').hide();
							$('.pers').hide();
							$('.cantidad').show();
							$('.servicio').hide();
							$('.formato').hide();
							$('.producto').hide();
							$('.importe').hide();
							$('#tr_precio').html('Precio Bol.');
							$('#lbl_precio').val('Precio Bol.');
							
							
							$('#lbl_partida').html('Tarifa:');
							$('#div_formato').hide();
							$('#div_tarifa').hide();
							$('#div_servicio').hide();
							$('#div_producto').hide();
							$('#div_dias').hide();
							$('#div_importe').hide();
							$('#div_imp_isc_cam').hide();
							$('#txt_precio').prop('disabled', true);
							
							
							$('#div_con_fec_inicio').hide();
							$('#div_nro_doc_emp_fec_fin').hide();
							$('#div_fec_doc_imp_mensual').hide();
							$('#div_por_mora').hide();
							$('#div_sto_disponible').show();
							
							$('#div_nro_doc_emp_fec_doc_tupa').hide();
							$('#div_nro_doc_der_fec_der_tupa').hide();
							$('#div_for_pago_tupa').hide();

							$('#txt_fec_inicio').val('${compra.fec_inicio}');
							$('#txt_fec_fin').val('${compra.fec_final}');
							$('#txt_imp_mensual').val('${compra.num_imp_contrato}');
							$('#txt_por_mora').val('${compra.num_imp_interes}');
							
							$('#txt_nro_doc_empresa').val('${compra.num_doc_empresa}');
							$('#txt_fec_documento').val('${compra.fec_doc_empresa}');

							
							for (var i = 0; i < arr_tar_boletos.length; i++) {
								var fields = arr_tar_boletos[i].split('|');								
								opt_detalle += '<option value="'+fields[0]+'">'+fields[1]+' - '+fields[2]+'</option>';								
								if (i == 0) {
									$('#txt_serie').val(fields[3]);
									$('#txt_precio').val(fields[7]);
									$('#txt_stock').val(fields[6]);
									$('#txt_ini_disponible').val(fields[4]);
									$('#txt_fin_disponible').val(fields[5]);
								}
							}
							$('#sel_partida').html(opt_detalle);
						
							break;
							
						case '4': // Tupa
						
							$('#leg_det_factura').html('Detalle de Tupa');
						
						
							$('#tr_partida').html('Detalle de Tupa');
							$('.tarifa').hide();
							$('.dias').hide();
							$('.pers').hide();
							$('.servicio').hide();
							$('.serie').hide();
							$('.nro_inicio').hide();
							$('.cantidad').show();
							$('.producto').hide();
							$('.importe').hide();
							$('#tr_precio').html('Precio Unit.');
							$('#lbl_precio').val('Precio Unit.');
							
							
							$('#lbl_partida').html('Tarifa:');
							$('#div_formato').hide();
							$('#div_serie').hide();
							$('#div_tarifa').hide();
							$('#div_servicio').hide();
							$('#div_producto').hide();
							$('#div_nro_inicio').hide();
							$('#div_dias').hide();
							$('#div_importe').hide();
							$('#div_imp_isc_cam').hide();
							$('#div_sto_disponible').hide();
							$('#txt_precio').prop('disabled', true);

							
							$('#div_nro_doc_emp_fec_doc_tupa').show();
							$('#div_nro_doc_der_fec_der_tupa').show();
							$('#div_for_pago_tupa').show();
							
							$('#txt_nro_doc_emp_tupa').val('${compra.num_doc_empresa}');
							$('#txt_fec_doc_tupa').val('${compra.fec_doc_empresa}');
							$('#txt_nro_doc_der_tupa').val('${compra.num_doc_derivacion}');
							$('#txt_fec_der_tupa').val('${compra.fec_doc_derivacion}');
							

							for (var i = 0; i < arr_tar_tupa.length; i++) {
								var fields = arr_tar_tupa[i].split('|');								
								opt_detalle += '<option value="'+fields[0]+'">'+fields[1]+' - '+fields[2]+'</option>';								
								if (i == 0) {
									$('#txt_formato').val(fields[1]);
									$('#txt_precio').val(fields[3]);
								}
							}
							$('#sel_partida').html(opt_detalle);
						
							break;	
							
						case '5': // Otros
						
							$('#lbl_partida').html('Detalle de Otros');
							$('#lbl_servicio').html('Nombre del Servicio');
							$('#leg_det_factura').html('Detalle de Otros');

							
							$('#tr_partida').html('Detalle de Otros');
							$('.tarifa').hide();
							$('.dias').hide();
							$('.pers').hide();
							$('.servicio').hide();
							$('.formato').hide();
							$('.serie').hide();
							$('.nro_inicio').hide();
							$('.producto').hide();
							$('.cantidad').show();
							$('.importe').hide();
							$('#tr_precio').html('Precio Venta');
							$('#lbl_precio').val('Precio');
							
							
							$('#lbl_partida').html('Servicio:');
							$('#div_servicio').hide();
							$('#div_serie').hide();
							$('#div_formato').hide();
							$('#div_tarifa').hide();
							$('#div_producto').hide();
							$('#div_dias').hide();
							$('#div_nro_inicio').hide();
							$('#div_cantidad').show();
							$('#div_importe').hide();
							$('#div_imp_isc_cam').hide();
							$('#div_sto_disponible').hide();
							$('#txt_precio').prop('disabled', false);
							
						
							$('#div_con_fec_inicio').show();
							$('#div_nro_doc_emp_fec_fin').show();
							$('#div_fec_doc_imp_mensual').show();
							$('#div_por_mora').show();
							$('#div_nro_doc_emp_fec_doc_tupa').hide();
							$('#div_nro_doc_der_fec_der_tupa').hide();
							$('#div_for_pago_tupa').hide();

							
							for (var i = 0; i < arr_tar_otros.length; i++) {
								var fields = arr_tar_otros[i].split('|');								
								opt_detalle += '<option value="'+fields[0]+'">'+fields[1]+'</option>';								
							}
							$('#sel_partida').html(opt_detalle);
							
							break;							
					}
					
					
					$('#sel_tip_transaccion').prop('disabled', true);
					$('#sel_tip_transaccion').prop('title', 'No se puede cambiar el tipo de transaccion cuando ya se tiene un detalle');
					
					// Consultamos si el registro se puede editar de acuerdo al cierre de mes
					var ind_mes_cierre = '${ind_mes_cierre}';
					if (ind_mes_cierre == '0') {
						$('#btn_grabar').prop('disabled', true);
						$('#btn_nuevo').prop('disabled', true);
						$('#txt_nro_ruc').prop('disabled', true);
						$('#txt_nro_dni').prop('disabled', true);
						$('.btn_agr_partida').prop('disabled', true);
						addWarnMessage(null, 'Su registro se encuentra dentro de un mes cerrado.');
					}
					
					// Validamos si esta habilitado la nota de credito
					var ind_not_credito = '${ind_not_credito}';
					
					console.log("ind_mes_cierre : " + ind_mes_cierre);
					console.log("count : " + '${count}');
					console.log("cod_comprobante : " + cod_comprobante);
					console.log("ind_not_credito : " + ind_not_credito);
					
					if (ind_mes_cierre != '0' && 
							parseInt('${count}') <= 2 &&  // Solo asociar un detalle a la nota de credito o debito
							(cod_comprobante == '2' || // Factura
								cod_comprobante == '4') && // Boleta de Venta
							ind_not_credito == '1') {
						$('#btn_notas').prop('disabled', false);
					} else {
						$('#btn_notas').prop('disabled', true);
					}					
					
					var cod_pad_com_ingresos = '${compra.cod_pad_com_ingresos}';
					$('#hid_cod_pad_com').val(cod_pad_com_ingresos);
					if (parseInt(cod_pad_com_ingresos) > 0) { // Si es una nota credito ó debito
						$('.btn_agr_partida').prop('disabled', true);
						$('.btn_rem_partida').prop('disabled', true);
						$('#txt_fac_afectada').val('${nro_factura}');
					}
					
					set_fec_cp('${compra.cod_mes}');
					
					if ('${ind_sed_principal}' == '1') { // Usuario de Sede Central					
						set_anp($('#sel_uni_operativa').val(), true, '${compra.cod_reg_nac}');
						set_sucursal($('#sel_uni_operativa').val(),'${compra.cod_reg_nac}','${compra.cod_sucur}');
					} else {
						$('#sel_uni_operativa').find('option').eq(0).remove();
						set_anp($('#sel_uni_operativa').val(), false, '${compra.cod_reg_nac}');
					}

				} else {
					$('#div_con_fec_inicio').hide();
					$('#div_nro_doc_emp_fec_fin').hide();
					$('#div_fec_doc_imp_mensual').hide();
					$('#div_por_mora').hide();
					$('#div_nro_doc_emp_fec_doc_tupa').hide();
					$('#div_nro_doc_der_fec_der_tupa').hide();
					$('#div_for_pago_tupa').hide();
					
					
					$('#btn_eliminar').hide();
					$('#btn_notas').hide();
					$('#sel_tip_comprobante').val('62'); // Comprobantes de Pago
					$('#sel_tip_moneda').val('1'); // Moneda Soles
					$('#sel_fue_financiamiento').val('2'); // Recursos Directamente Recaudados
					$('#sel_ctacte').val('1'); //
					$('#sel_for_pago').val('8'); // EFECTIVO, POR OPERACIONES EN LAS QUE NO EXISTE OBLIGACIÓN DE UTILIZAR MEDIO DE PAGO
					$('#txt_imp_afecto').val(0);
					$('#txt_imp_igv').val(0);
					$('#txt_imp_no_afecto').val(0);
					$('#txt_imp_isc').val(0);
					
				
					$('.tarifa').hide();
					$('.formato').hide();
					$('.serie').hide();
					$('.nro_inicio').hide();
					$('.producto').hide();
					$('.cantidad').hide();
					$('.importe').hide();
					
					
					$('#div_serie').hide();
					$('#div_formato').hide();
					$('#div_tarifa').hide();
					$('#div_producto').hide();
					$('#div_nro_inicio').hide();
					$('#div_cantidad').hide();
					$('#div_importe').hide();
					$('#div_imp_isc_cam').hide();
					$('#div_sto_disponible').hide();
							
					
					$('#lbl_partida').html('Servicio');
					$('#lbl_servicio').html('Nombre del Servicio');
					$('#leg_det_factura').html('Detalle de Servicios');
					
					var opt_detalle = '';
					for (var i = 0; i < arr_tar_servicio.length; i++) {
						var fields = arr_tar_servicio[i].split('|');								
						opt_detalle += '<option value="'+fields[0]+'">'+fields[1]+' - '+fields[2]+'</option>';								
						if (i == 0) {
							$('#txt_servicio').val(fields[2]);
							$('#txt_precio').val(fields[3]);
						}
					}
					$('#sel_partida').html(opt_detalle);
					
					if ('${ind_sed_principal}' == '1') { // Usuario de Sede Central						
						$('input[name=rb_tip_operacion][value="'+2+'"]').prop('checked', true);
					} else {
						$('input[name=rb_tip_operacion][value="'+1+'"]').prop('checked', true);
						$('#sel_uni_operativa').find('option').eq(0).remove();
						set_anp($('#sel_uni_operativa').val(), false, null);
					}
					
					var d = new Date();
					var mes = parseInt(d.getMonth()) + 1;
					$('#sel_periodo').val(mes);					
					
					set_fec_cp(mes);

				}
				
				$('#sel_tip_comprobante').trigger('chosen:updated');
				
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
			
			function val_dep_detraccion() {
				var msg = '';
				if (esnulo(num_constancia)) {
					msg = msg + 'El campo "Número" es obligatorio.<br/>';
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
			
			function rem_det_transferencia() {
				var row_num = $('#tbl_det_facturas td').closest('tr').length;
				var ind_opc = 0;
				var det_trans = 1;
				var arr_partida = '';
				
				// Removemos los duplicados
				var map = {};
				$('#sel_partida option').each(function () {
				    if (map[this.value]) {
				        $(this).remove()
				    }
				    map[this.value] = true;
				})
				
				if (row_num > 1) {
					
					var cod_tip_transaccion = $('#sel_tip_transaccion').val();
					switch (cod_tip_transaccion) {
						case '1': // Servicios	
						
							det_trans = arr_tar_servicio.length;

							for (var i=0; i < det_trans; i++) {
								var fields = arr_tar_servicio[i].split('|');
								$('tr.item').each(function() {		
									var ind_partida = $(this).find('.cod_ser').text();
									if (!esnulo(ind_partida)) {
										if (fields[0] == ind_partida) {
											$('#sel_partida option[value="'+ind_partida+'"]').remove();
											ind_opc = ind_opc + 1;
										}									
									}						
								});							
							}
						
							break;
						case '2': // Productos

							det_trans = arr_productos.length;

							for (var i=0; i < det_trans; i++) {
								var fields = arr_productos[i].split('|');
								$('tr.item').each(function() {		
									var ind_partida = $(this).find('.cod_ser').text();
									if (!esnulo(ind_partida)) {
										if (fields[0] == ind_partida) {
											$('#sel_partida option[value="'+ind_partida+'"]').remove();
											ind_opc = ind_opc + 1;
										}									
									}						
								});							
							}
				
							break;
						case '3': // Boletos

							det_trans = arr_tar_boletos.length;

							for (var i=0; i < det_trans; i++) {
								var fields = arr_tar_boletos[i].split('|');
								$('tr.item').each(function() {		
									var ind_partida = $(this).find('.cod_ser').text();
									if (!esnulo(ind_partida)) {
										if (fields[0] == ind_partida) {
											$('#sel_partida option[value="'+ind_partida+'"]').show();
											ind_opc = ind_opc + 1;
										}									
									}						
								});							
							}
						
							break;
						case '4': // Tupa
					
							det_trans = arr_tar_tupa.length;

							for (var i=0; i < det_trans; i++) {
								var fields = arr_tar_tupa[i].split('|');
								$('tr.item').each(function() {		
									var ind_partida = $(this).find('.cod_ser').text();
									if (!esnulo(ind_partida)) {
										if (fields[0] == ind_partida) {
											$('#sel_partida option[value="'+ind_partida+'"]').show();
											ind_opc = ind_opc + 1;
										}									
									}						
								});							
							}
						
							break;
						case '5': // Otros					

							det_trans = arr_tar_otros.length;

							for (var i=0; i < det_trans; i++) {
								var fields = arr_tar_otros[i].split('|');
								$('tr.item').each(function() {		
									var ind_partida = $(this).find('.cod_ser').text();
									if (!esnulo(ind_partida)) {
										if (fields[0] == ind_partida) {
											$('#sel_partida option[value="'+ind_partida+'"]').show();
											ind_opc = ind_opc + 1;
										}									
									}						
								});							
							}			
				
							break;
					}
										
					if (det_trans == ind_opc) {
						return 'No se puede agregar mas detalle factura.';
					}
				}
				return '';
			}
			
			function setPartida(cod_partida) {
				var cod_tip_transaccion = $('#sel_tip_transaccion').val();
				switch (cod_tip_transaccion) {
					case '1': // Servicios				
					
						for (var i = 0; i < arr_tar_servicio.length; i++) {
							var fields = arr_tar_servicio[i].split('|');								
							if (fields[0] == cod_partida) {
								$('#txt_servicio').val(fields[2]);
								$('#txt_precio').val(fields[3]);									
								if (!esnulo($('#txt_dias').val())) { 	
			 						var imp_total = (parseInt($('#txt_dias').val())*parseInt($('#txt_persona').val()))  * parseFloat(fields[3]); 						
			 						$('#txt_total').val(imp_total.toFixed(2));
								}									
								break;
							}
						}

						break;
						
					case '2': // Productos

						for (var i = 0; i < arr_productos.length; i++) {
							var fields = arr_productos[i].split('|');								
							if (fields[0] == cod_partida) {
								$('#txt_producto').val(fields[2]);
								$('#txt_precio').val(fields[3]);									
								if (!esnulo($('#txt_cantidad').val())) { 	
			 						var imp_total = parseInt($('#txt_cantidad').val()) * parseFloat(fields[3]); 						
			 						$('#txt_total').val(imp_total.toFixed(2));
								}									
								break;
							}
						}
					
						break;
						
					case '3': // Boletos
					
						for (var i = 0; i < arr_tar_boletos.length; i++) {
							var fields = arr_tar_boletos[i].split('|');								
							if (fields[0] == cod_partida) {
								$('#txt_serie').val(fields[3]);
								$('#txt_precio').val(fields[7]);
								if (!esnulo(fields[6])) {
									$('#txt_stock').val(fields[6]);
								}
								if (!esnulo(fields[4])) {
									$('#txt_ini_disponible').val(fields[4]);
								}
								if (!esnulo(fields[5])) {
									$('#txt_fin_disponible').val(fields[5]);
								}
								if (!esnulo($('#txt_cantidad').val())) { 	
			 						var imp_total = parseInt($('#txt_cantidad').val()) * parseFloat(fields[7]); 						
			 						$('#txt_total').val(imp_total.toFixed(2));
								}									
								break;
							}
						}
					
						break;
						
					case '4': // Tupa
					
						for (var i = 0; i < arr_tar_tupa.length; i++) {
							var fields = arr_tar_tupa[i].split('|');								
							if (fields[0] == cod_partida) {
								$('#txt_formato').val(fields[1]);
								$('#txt_precio').val(fields[3]);									
								if (!esnulo($('#txt_cantidad').val())) { 	
			 						var imp_total = parseInt($('#txt_cantidad').val()) * parseFloat(fields[3]); 						
			 						$('#txt_total').val(imp_total.toFixed(2));
								}									
								break;
							}
						}
					
						break;
						
					case '5': // Otros
					
						for (var i = 0; i < arr_tar_otros.length; i++) {
							var fields = arr_tar_otros[i].split('|');								
							if (fields[0] == cod_partida) {
								if (!esnulo($('#txt_cantidad').val()) && !esnulo($('#txt_precio').val())) { 	
			 						var imp_total = parseInt($('#txt_cantidad').val()) * parseFloat($('#txt_precio').val()); 						
			 						$('#txt_total').val(imp_total.toFixed(2));
								}									
								break;
							}
						}
						
						break;
				}
			}
			
			function obtenerAnp(cod_uni_operativa) {
				var params = new Object();			
 				params['ind_uni_operativa'] = 1; // ANP
 				params['cod_uni_operativa'] = cod_uni_operativa;
 				simpleCboAjaxPopulateParam('#sel_anp', ['cod_reg_nac', 'des_reg_nac'], '/listarUnidadOperativa', params, false, false);
			}
			
			function obtenerTarifaBoleto(cod_uni_operativa, cod_reg_nac) {
				$.ajax({
					type: 'GET',
					url: '${pageContext.request.contextPath}/listarTarifaBoleto',
					data: {
						cod_uni_operativa : cod_uni_operativa,
						cod_reg_nac : cod_reg_nac,
						ind_saldo : 1
					},
					dataType: 'json',
					success: function(paramJson) {						
						if (paramJson != null) {							
							// Cargamos el detalle de las cuentas contables asociadas
							arr_tar_boletos = null;
							arr_tar_boletos = [];
							var options = '';
							var row = 0;
							$.each(paramJson, function(index, item) {
								options += '<option value="'+item.cod_boleto+'">'+item.num_serie+' - '+item.des_ind_tarifa+' - '+item.nom_boleto+'</option>';											
								var det_boleto = item.cod_boleto+'|'+item.des_ind_tarifa+'|'+item.nom_boleto+'|'+item.num_serie+'|';
								det_boleto = det_boleto + item.num_inicio+'|'+item.num_final+'|'+item.can_sal_stock+'|'+item.num_imp_unit;			
								arr_tar_boletos.push(det_boleto);
								if (row == 0) {
									$('#txt_serie').val(item.num_serie);
									$('#txt_precio').val(item.num_imp_unit);
									if (!esnulo(item.can_sal_stock)) {
								    	$('#txt_stock').val(item.can_sal_stock);
								    }
									if (!esnulo(item.num_inicio)) {
								    	$('#txt_ini_disponible').val(item.num_inicio);
								    }
									if (!esnulo(item.num_final)) {
								    	$('#txt_fin_disponible').val(item.num_final);
								    }
								}
								row = row + 1;
							});
							$('#sel_partida').html(options);
						} else {
							$('#sel_partida').html('');
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
			
			function cal_imp_total(val_importe) {
				if (!esnulo(val_importe)) {					
					var importe = parseFloat(val_importe);	
					var cod_tip_venta = $('#sel_tip_ven_nc').val();
					var servicio = $('#hid_des_tip').val();			
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
			
					imp_total = imp_afecto + imp_igv + imp_no_afecto + imp_isc;

					$('#txt_imp_afe_nc').val(imp_afecto.toFixed(6));
					$('#txt_imp_igv_nc').val(imp_igv.toFixed(6));
					$('#txt_imp_no_afe_nc').val(imp_no_afecto.toFixed(6));
					$('#txt_imp_isc_nc').val(imp_isc.toFixed(6));
					$('#txt_imp_tot_nc').val(imp_total.toFixed(6));
				}
			}
			
			function obt_arr_cadena(campo) {
			    if (esnulo(campo)) {
			    	return '';
			    } else {
			    	var pos = campo.indexOf(' - ');			    	
			    	return campo.substring(pos + 3);
			    }
			}
			
			function set_fec_cp(campo) {
				//if(mes == '12')anio--; //cambio temporal para el ingreso de comprobantes con fecha diciembre del año anterior
				var mes   = campo;				
				var anio  = new Date().getFullYear();
				var dia   = new Date(anio, mes, 0).getUTCDate(); // Ultimo dia del mes								
				var fecha = anio + '/' + mes + '/' + dia;
				var fec_act = anio + '/' + mes + '/' + '01';
								
				//$('#txt_fec_comprobante').datepicker('setStartDate', new Date(fec_act));				
				$('#txt_fec_comprobante').datepicker('setEndDate', new Date(fecha));
				
			}
					
			function set_anp(cod_uni_operativa, ind_def, val_anp) {				
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
							if (ind_def) {
								options += '<option value="">&#60Seleccione&#62</option>';
					        }
							$.each(paramJson, function(index, item) {
								options += '<option value="'+item.cod_reg_nac+'">'+item.des_reg_nac+'</option>';								
							});
							$('#sel_anp').html(options);
							if (!esnulo(val_anp)) {
								$('#sel_anp').val(val_anp);	
							} else {
								val_anp = '';
							}
							
							set_tari_boleto(cod_uni_operativa, val_anp);
							//set_sucursal(cod_uni_operativa, val_anp);
							
						} else {
							$('#sel_anp').html('');
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
			
			//funcion para obtener el codigo de sucursal
			function obtenerSucursal(cod_uni_operativa, cod_reg_nac) {
				$.ajax({
					type : 'GET',
					url: '${pageContext.request.contextPath}/listarSucursal',
					data: {
						cod_uni_operativa : cod_uni_operativa,
						cod_reg_nac : cod_reg_nac
					},
					dateType : 'json',
					success: function(paramJson) {
						if (paramJson != null) {
							var options = '';
							$.each(paramJson, function(index, item) {
								options += '<option value="'+item.cod_sucur+'">'+item.nom_sucur+'</option>';
							});
							$('#sel_sucursal').html(options);
							if (!esnulo(item.cod_sucur)) {
								$('#sel_sucursal').val(item.cod_sucur);
							}

						}
					},
					error: function(jqXHR, error, errorThrown) {
						var msg = 'Error: obtenersucursal <br/>';
						if (jqXHR.status && jqXHR.status == 400) {
							msg = msg + jqXHR.responseText;
						} else {
							msg = msg + errorThrown;
						}
						addErrorMessage(null, msg);
					}					
				});
			}
			
			//funcion para obtener el codigo de sucursal
			function set_sucursal(cod_uni_operativa, cod_reg_nac,cod_sucur) {								
				$.ajax({
					type : 'GET',
					url: '${pageContext.request.contextPath}/listarSucursal',
					data: {
						cod_uni_operativa : cod_uni_operativa,
						cod_reg_nac : cod_reg_nac
					},
					dateType : 'json',
					success: function(paramJson) {
						if (paramJson != null) {
							var options = '';
							options += '<option value="">&#60Seleccione&#62</option>';
							$.each(paramJson, function(index, item) {
								options += '<option value="'+item.cod_sucur+'">'+item.des_sucur+'</option>';								
							});	
							
							$('#sel_sucursal').html(options);
							if (!esnulo(cod_sucur)) {
								$('#sel_sucursal').val(cod_sucur);	
							} else {
								cod_sucur = '';
							}
							
						}
					},
					error: function(jqXHR, error, errorThrown) {
						var msg = 'Error: set_sucursal <br/>';
						if (jqXHR.status && jqXHR.status == 400) {
							msg = msg + jqXHR.responseText;
						} else {
							msg = msg + errorThrown;
						}
						addErrorMessage(null, msg);
					}					
				});
			}			
			
			//funcion para obtener el codigo de la serie
			function set_serie(cod_uni_operativa, cod_reg_nac,cod_comprobante) {
				
				var tip_fact = $('input[name="rb_tip_factu"]:checked').val();
				if(tip_fact=="1"){
					cod_uni_operativa=99;
					cod_reg_nac=99;
				}
				$.ajax({
					type : 'GET',
					url: '${pageContext.request.contextPath}/listarSerieNum',
					data: {
						cod_uni_operativa : cod_uni_operativa,
						cod_reg_nac : cod_reg_nac,
						cod_comprobante : cod_comprobante
					},
					dateType : 'json',
					success: function(paramJson) {
						if (paramJson != null) {
							var options = '';
							var cod_serie = '';
							var num_serie = '';
							var numero = '';
							var numero_fact = 0;
							$.each(paramJson, function(index, item) {
								options += '<option value="'+item.cod_serie+'">'+item.num_serie+trim(item.num_cp)+'</option>';
								cod_serie = item.cod_serie;
								num_serie = item.num_serie;
								numero = item.num_cp;
								numero_fact = parseInt(numero)+1;
							});
							$('#hid_cod_serie').val(cod_serie);
							$('#txt_ser_comprobante').val(num_serie);
							$('#txt_nro_comprobante').val(numero_fact);
						}else{
							alert("La Unidad Operativa o la ANP No Cuenta con Serie");
						}
					},
					error: function(jqXHR, error, errorThrown) {
						var msg = 'Error en las Series: set_sucursal <br/>';
						if (jqXHR.status && jqXHR.status == 400) {
							msg = msg + jqXHR.responseText;
						} else {
							msg = msg + errorThrown;
						}
						addErrorMessage(null, msg);
					}					
				});
			}
			function set_tari_boleto(cod_uni_operativa, cod_reg_nac) {
				$.ajax({
					type: 'GET',
					url: '${pageContext.request.contextPath}/listarTarifaBoleto',
					data: {
						cod_uni_operativa : cod_uni_operativa,
						cod_reg_nac : cod_reg_nac,
						ind_saldo : 1
					},
					dataType: 'json',
					success: function(paramJson) {						
						if (paramJson != null) {							
							// Cargamos el detalle de las cuentas contables asociadas
							arr_tar_boletos = null;
							arr_tar_boletos = [];
							$.each(paramJson, function(index, item) {
								var det_boleto = item.cod_boleto+'|'+item.des_ind_tarifa+'|'+item.nom_boleto+'|'+item.num_serie+'|';
								det_boleto = det_boleto + item.num_inicio+'|'+item.num_final+'|'+item.can_sal_stock+'|'+item.num_imp_unit;			
								arr_tar_boletos.push(det_boleto);
							});
						}
					},
					error: function(jqXHR, error, errorThrown) {
						var msg = 'Error: set_tari_boleto<br/>';
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