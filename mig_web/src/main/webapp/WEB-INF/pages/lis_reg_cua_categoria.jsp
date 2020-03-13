<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta charset="utf-8" />
		<title>Renta Cuarta Categoria</title>

		<%@ include file="components.jsp" %>
	</head>

	<body class="no-skin">
		
		<%@ include file="header.jsp" %>
		
		<!-- /section:basics/navbar.layout -->
		<div class="main-container" id="main-container">

			<%@ include file="menu.jsp" %>

			<!-- /section:basics/sidebar -->
			<div class="main-content">
				<div class="main-content-inner">
					<!-- #section:basics/content.breadcrumbs -->
					<div class="breadcrumbs" id="breadcrumbs">
						<ul class="breadcrumb">
							<li class="active">
								<i class="ace-icon fa fa-sign-out"></i>
								Mantenimiento Compras
							</li>
							<li class="active">Registro de 4ta Categoría</li>
						</ul>
					</div>
			
					<div class="page-content">		
						<div class="row">
							<div class="col-xs-12">
								<form class="form-horizontal" role="form">
									<fieldset class="fsStyle">
										<legend class="legendStyle">Filtros para la busqueda de Documentos</legend>
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
													<label class="col-sm-1 control-label label-sm no-padding-right">Unidad Operativa:</label>
													<div class="col-sm-2">
														<select id="sel_uni_operativa" class="form-control input-sm">
															<option>Seleccionar</option>
															<c:forEach items="${lis_uni_operativa}" var="item">
															    <option value="${item.cod_uni_operativa}">${item.des_uni_operativa}</option>
															</c:forEach>
														</select>
													</div>
													<label class="col-sm-1 control-label label-sm no-padding-right">Fecha Inicial:</label>
													<div class="col-sm-2">
														<div class="input-group">
															<input class="form-control input-sm date-picker " id="txt_fec_inicial" type="text" maxlength="10"/>
															<span class="input-group-addon" id="sp_ico_fec_inicial">
																<i class="fa fa-calendar bigger-110"></i>
															</span>
														</div>
													</div>
												 
													<label class="col-sm-1 control-label label-sm no-padding-right">Fecha Final:</label>
													<div class="col-sm-2">
														<div class="input-group">
															<input class="form-control input-sm date-picker " id="txt_fec_final" type="text" maxlength="10"/>
															<span class="input-group-addon" id="sp_ico_fec_final">
																<i class="fa fa-calendar bigger-110"></i>
															</span>
														</div>
													</div>
													<label class="col-sm-1 control-label input-sm no-padding-right">Serie:</label>											
													<div class="col-sm-2">
														<input type="text" id="txt_serie" class="form-control input-sm  "  maxlength="5" />
													</div>
												</div>
												
												<div class="form-group">
													<label class="col-sm-1 control-label label-sm no-padding-right">ANP:</label>
													<div class="col-sm-2">
														<select id="sel_anp" class="form-control input-sm">
															<option>Seleccionar</option>
															<c:forEach items="${lis_anp}" var="item">
															    <option value="${item.cod_reg_nac}">${item.des_reg_nac}</option>
															</c:forEach>
														</select>
													</div>
													
													<label class="col-sm-1 control-label label-sm no-padding-right">Tipo de Doc.:</label>
													<div class="col-sm-2">
														<select id="sel_tip_documento" class="form-control input-sm">
															<c:forEach items="${lis_tip_comprobante}" var="item">
																<option value="${item.cod_comprobante}">${item.nom_comprobante}</option>
															</c:forEach>
														</select>
													</div>
													
													<label class="col-sm-1 control-label input-sm no-padding-right">Ruc:</label>											
													<div class="col-sm-2">
														<input type="text" id="txt_ruc" class="form-control input-sm  onlyNumbers "  maxlength="11" />
													</div>
													
												    <label class="col-sm-1 control-label input-sm no-padding-right">Número:</label>											
													<div class="col-sm-2">
														<input type="text" id="txt_nro" class="form-control input-sm onlyNumbers " maxlength="10"  />
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
								<div class="clearfix">
									<div id="div_table_tools" class="pull-right tableTools-container"></div>
								</div>
								<div class="table-responsive div_cor_com_pago">
									<table class="table table-striped table-bordered table-hover">
										<thead>
											<tr>
												<th>Item</th>
												<th>Tipo</th>
												<th>Serie</th>
												<th>Numero RxH</th>
												<th>Fecha</th>
												<th>Fecha Pago</th>
												<th>Opcion Ret.</th>
												<th>Cuarta Categoría</th>
											</tr>
										</thead>
									</table>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- /.main-content -->
			
			<div id="div_cierre_mes" class="modal" tabindex="-1" data-keyboard="false" data-backdrop="static">
				<div class="modal-dialog ">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">&times;</button>
							<h4 id="h_financiero" class="white bigger center"></h4>
						</div>
						<div class="modal-body">
							<div class="row">
								<div class="col-xs-12">
									<form id="form_cierre_mes" class="form-horizontal" role="form">
										<div class="form-group">	
											<input type="text" id="txt_mnt_codigo" class="form-control input-sm onlyAmounts hidden" maxlength="15" />																					
										</div>	
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
										<label class="col-sm-2 control-label label-sm no-padding-right">Unidad Operativa:</label>
											<div class="col-sm-6">
												<select id="sel_mnt_uni_operativa" class="form-control input-sm">
														<option>Seleccionar</option>
													<c:forEach items="${lis_uni_operativa}" var="item">
													    <option value="${item.cod_uni_operativa}">${item.des_uni_operativa}</option>
													</c:forEach>
												</select>
											</div>
										</div> 		
										<div class="form-group">
											<label class="col-sm-2 control-label label-sm no-padding-right">ANP:</label>
											<div class="col-sm-6">
												<select id="sel_mnt_anp" class="form-control input-sm">
													<option>Seleccionar</option>
													<c:forEach items="${lis_anp}" var="item">
													    <option value="${item.cod_reg_nac}">${item.des_reg_nac}</option>
													</c:forEach>
												</select>
											</div>	
										</div> 
										
										<div class="form-group">																		
											<label class="col-sm-2 control-label label-sm no-padding-right">Tipo de Doc.:</label>
											<div class="col-sm-6">
												<select id="sel_mnt_tip_documento" class="form-control input-sm">
													<c:forEach items="${lis_tip_comprobante}" var="item">
													  	<option value="${item.cod_comprobante}">${item.nom_comprobante}</option>
													</c:forEach>
												</select>
											</div>
										</div> 		
										<div class="form-group">	
												<input type="text" id="txt_mnt_id_comprobante" class="form-control input-sm onlyAmounts hidden" maxlength="15" />																					
											</div>	
										<div class="form-group">	
											<label class="col-sm-2 control-label input-sm no-padding-right">RUC:</label>											
											<div class="col-sm-4">
												<input type="text" id="txt_mnt_ruc" class="form-control input-sm onlyNumbers " maxlength="11" onblur = fun() />
											</div>	
										</div>
										<div class="form-group">	
											<label class="col-sm-2 control-label input-sm no-padding-right">Nombres:</label>											
											<div class="col-sm-6">
												<input type="text" id="txt_mnt_nomb" class="form-control input-sm " maxlength="50" disabled/>
											</div>	
										</div>
										<div class="form-group">	
											<label class="col-sm-2 control-label input-sm no-padding-right">Serie:</label>											
											<div class="col-sm-2">
												<input type="text" id="txt_mnt_serie" class="form-control input-sm  "  maxlength="5" />
											</div>
										 		
										    <label class="col-sm-1 control-label input-sm no-padding-right">Número:</label>											
											<div class="col-sm-2">
												<input type="text" id="txt_mnt_nro" class="form-control input-sm onlyNumbers " maxlength="7"  />
											</div>
											<label class="col-sm-1 control-label label-sm no-padding-right">Fecha:</label>
											<div class="col-sm-4">
												<div class="input-group">
													<input class="form-control input-sm date-picker " id="txt_mnt_fec" type="text" maxlength="10"/>
													<span class="input-group-addon" id="sp_ico_mnt_fec">
														<i class="fa fa-calendar bigger-110"></i>
													</span>
												</div>
											</div>
										</div>
										
										<div class="form-group">
											<div class="col-sm-9">
												<div class="form-group">
													<label class="col-sm-3 control-label label-sm no-padding-right">Fecha Pago:</label>
													<div class="col-sm-6">
														<div class="input-group">
															<input class="form-control input-sm date-picker " id="txt_mnt_fec_pago" type="text" maxlength="10"/>
															<span class="input-group-addon" id="sp_ico_mnt_fec_pago">
																<i class="fa fa-calendar bigger-110"></i>
															</span>
														</div>
													</div>	
												</div>		
													
												<div class="form-group">
												    <label class="col-sm-3 control-label label-sm no-padding-right">Retención:</label>
													<div class="col-sm-6">	
														<label class="input-sm">
															<input type="radio" class="ace input-sm" name="rb_tip_ren" value="S">
															<span class="lbl"> Si</span>
														</label>
													
														<label class="input-sm">
															<input type="radio" class="ace input-sm" name="rb_tip_ren" value="N">
															<span class="lbl"> No</span>
														</label>
											 		</div>
												</div>
												
												<div class="form-group">
													<label class="col-sm-3 control-label input-sm no-padding-right">Número Suspension:</label>											
													<div class="col-sm-6">
														<input type="text" id="txt_mnt_nro_suspension" class="form-control input-sm onlyNumbers " maxlength="5"  />
													</div>
												</div>
												<div class="form-group">
													<label class="col-sm-3 control-label input-sm no-padding-right">Importe:</label>											
													<div class="col-sm-6">
														<input type="text" id="txt_mnt_importe" class="form-control input-sm onlyNumbers " maxlength="10"   />
													</div>
												</div>
												<div class="form-group">
													<label class="col-sm-3 control-label input-sm no-padding-right">Monto Retenido:</label>											
													<div class="col-sm-6">
														<input type="text" id="txt_mnt_monto_retenido" class="form-control input-sm onlyNumbers " maxlength="10" disabled />
													</div>
												</div>
												<div class="form-group">
													<label class="col-sm-3 control-label input-sm no-padding-right">Total:</label>											
													<div class="col-sm-6">
														<input type="text" id="txt_mnt_total" class="form-control input-sm onlyNumbers " maxlength="10" disabled />
													</div>
												</div>
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
								<div class="col-sm-3">								
									<button id="btn_notas" class="btn btn-sm btn-purple input-sm">
										<i class="ace-icon fa fa-sticky-note-o"></i>
										Notas
									</button>							
								</div>
							</div>
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
					<input type="text" id="txt_mnt_codigo_hijo" class="form-control input-sm onlyAmounts hidden" maxlength="15" />		
					<div class="modal-body">
						<div class="row">
							<div class="col-xs-12">
								<form id="form_det_reg_gravado" class="form-horizontal" role="form">
									<div class="form-group">																				
										<label class="col-sm-3 control-label input-sm no-padding-right">Tipo Comprobante:</label>											
										<div class="col-sm-6">
											<select id="sel_tip_com_nc" class="form-control input-sm">
												<option value="2">Nota de Crédito</option>
											</select>
										</div>	
									</div>										
	
									<div class="form-group">			
									
										<label class="col-sm-1 control-label input-sm no-padding-right">Serie:</label>											
										<div class="col-sm-2">
											<input type="text" id="txt_ser_nc_hijo" class="form-control input-sm onlyNumbers" maxlength="5" />
										</div>	
										
										<label class="col-sm-1 control-label label-sm no-padding-right">Nro Doc.:</label>
										<div class="col-sm-2">
											<input type="text" id="txt_nro_doc_nc_hijo" class="form-control input-sm onlyNumbers" maxlength="10" />
										</div>
										
										<label class="col-sm-2 control-label label-sm no-padding-right">Fecha de Doc.:</label>
										<div class="col-sm-3">
											<div class="input-group">
												<input class="form-control input-sm date-picker" id="txt_fec_doc_nc_hijo" type="text" />
												<span class="input-group-addon" id="sp_ico_fec_doc_nc">
													<i class="fa fa-calendar bigger-110"></i>
												</span>
											</div>
										</div>	

									</div>	
										<div class="form-group">
											<label class="col-sm-2 control-label input-sm no-padding-right">Importe:</label>											
											<div class="col-sm-3">
												<input type="text" id="txt_nota_importe" class="form-control input-sm onlyNumbers " maxlength="10" required />
											</div>
											
											<label class="col-sm-3 control-label input-sm no-padding-right">Monto Retenido:</label>											
											<div class="col-sm-3">
												<input type="text" id="txt_mnt_nota_retenido" class="form-control input-sm onlyNumbers " maxlength="10" disabled />
											</div>
										</div>
									<div class="form-group">	
											<label class="col-sm-2"></label>
											<div class="col-sm-3">
											</div>
											<label class="col-sm-3 control-label input-sm no-padding-right">Total:</label>											
											<div class="col-sm-3">
												<input type="text" id="txt_nota_total" class="form-control input-sm onlyNumbers " maxlength="10" disabled />
											</div>
									</div>	
										<fieldset class="fsStyle"> 
										<legend class="legendStyle">Filtros para la busqueda de Documentos</legend>
											<div class="form-group">																				
												<label class="col-sm-3 control-label input-sm no-padding-right">Unidad Operativa:</label>											
												<div class="col-sm-6">
													<select id="sel_tip_uni_notas" class="form-control input-sm" disabled >
														<option>Seleccionar</option>
														<c:forEach items="${lis_uni_operativa}" var="item">
														    <option value="${item.cod_uni_operativa}">${item.des_uni_operativa}</option>
														</c:forEach>
													</select>
												</div>	
											</div>	
											<div class="form-group">																				
												<label class="col-sm-3 control-label label-sm no-padding-right">ANP:</label>											
												 <div class="col-sm-6">
													<select id="sel_tip_anp_notas" class="form-control input-sm" disabled>
														<option>Seleccionar</option>
														<c:forEach items="${lis_anp}" var="item">
														    <option value="${item.cod_reg_nac}">${item.des_reg_nac}</option>
														</c:forEach>
													</select>
												 </div>
										    </div>		
									      
										    <div class="form-group">
												<label class="col-sm-1 control-label input-sm no-padding-right">Serie:</label>											
												<div class="col-sm-2">
													<input type="text" id="txt_ser_nc" class="form-control input-sm onlyNumbers" maxlength="5" disabled/>
												</div>	
												
												<label class="col-sm-2 control-label label-sm no-padding-right">Nro Doc.:</label>
												<div class="col-sm-2">
													<input type="text" id="txt_nro_doc_nc" class="form-control input-sm onlyNumbers" maxlength="15" disabled />
												</div>
												
												<label class="col-sm-2 control-label label-sm no-padding-right">Fecha de Doc.:</label>
												<div class="col-sm-3">
													<div class="input-group">
														<input class="form-control input-sm date-picker" id="txt_fec_doc_nc" type="text" disabled/>
														<span class="input-group-addon" id="sp_ico_fec_doc_nc">
															<i class="fa fa-calendar bigger-110"></i>
														</span>
													</div>
												</div>
											</div>	
									        <div class="form-group">
											    <label class="col-sm-3 control-label label-sm no-padding-right">Retención:</label>
												<div class="col-sm-6">	
													<label class="input-sm">
														<input type="radio" class="ace input-sm" name="rb_tip_ren_notas" value="S" disabled >
														<span class="lbl"> Si</span>
													</label>
												
													<label class="input-sm">
														<input type="radio" class="ace input-sm" name="rb_tip_ren_notas" value="N" disabled>
														<span class="lbl"> No</span>
													</label>
										 		</div>
										 	</div>
										</fieldset>   
								</form>
							</div>
						</div>			
					</div>
	
					<div class="modal-footer">				
						<button id="btn_gra_not_credito" class="btn btn-sm btn-primary">
							<i class="ace-icon fa fa-check"></i>
							Grabar
						</button>
					 	<button id="btn_nota_eliminar" class="btn btn-sm btn-danger input-sm">
							<i class="ace-icon fa fa-times"></i>
							Eliminar
					    </button>
						<button class="btn btn-sm" data-dismiss="modal">
							<i class="ace-icon fa fa-times"></i>
							Salir
						</button>
					</div>
				</div>
			</div>
		</div>
			
			<div id="div_reg_proveedor" class="modal" tabindex="-1" data-keyboard="false" data-backdrop="static">
				<div class="modal-dialog modal-lg">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">&times;</button>
							<h4 class="white bigger center">Datos del Prestador</h4>
						</div>
						
						<div class="modal-body">
							<div class="row">
								<div class="col-xs-12">
									<form id="form_reg_proveedor" class="form-horizontal" role="form">
										<div class="form-group">																				
											<label class="col-sm-1 control-label input-sm no-padding-right">RUC:</label>											
											<div class="col-sm-3">
												<input type="text" id="txt_reg_ruc_cuarta" class="form-control input-sm onlyNumbers" maxlength = "11" disabled/>
											</div>
											<label class="col-sm-1 control-label label-sm no-padding-right">Tipo Doc.:</label>
											<div class="col-sm-2">
												<select id="sel_tip_doc" class="form-control input-sm">
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
												<input type="text" id="txt_ape_paterno" class="form-control input-sm" maxlength = "30"/>
											</div>	
										 																			
											<label class="col-sm-1 control-label input-sm no-padding-right">Ape. Materno:</label>											
											<div class="col-sm-2">
												<input type="text" id="txt_ape_materno" class="form-control input-sm" maxlength = "30" />
											</div>	
										 																			
											<label class="col-sm-1 control-label input-sm no-padding-right">Nombres:</label>											
											<div class="col-sm-2">
												<input type="text" id="txt_reg_nombres" class="form-control input-sm" maxlength = "50"/>
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
											<label class="col-sm-1 control-label input-sm no-padding-right">Correo Eléctronico:</label>											
											<div class="col-sm-2">
												<input type="text" id="txt_reg_correo" class="form-control input-sm" maxlength = "15"/>
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
												<input type="text" id="txt_nom_via" class="form-control input-sm" maxlength = "30"/>
											</div>
											
											<label class="col-sm-1 control-label input-sm no-padding-right">Numero:</label>											
											<div class="col-sm-2">
												<input type="text" id="txt_nro_via" class="form-control input-sm" maxlength = "3" />
											</div>
											
											<label class="col-sm-1 control-label input-sm no-padding-right">Interior:</label>											
											<div class="col-sm-2">
												<input type="text" id="txt_interior" class="form-control input-sm" maxlength = "3"/>
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
												<input type="text" id="txt_zona" class="form-control input-sm" maxlength = "50"/>
											</div>
										</div>
										
										
										<div class="form-group">																				
											<label class="col-sm-2 control-label input-sm no-padding-right">Referencia:</label>											
											<div class="col-sm-9">
												<input type="text" id="txt_referencia" class="form-control input-sm" maxlength = "100"/>
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
													<%--<c:forEach items="${lis_tip_zona}" var="item">
													    <option value="${item.srlIdZona}">${item.chrNomZona}</option>
													</c:forEach> --%>
												</select>
											</div>	
											<label class="col-sm-2 control-label label-sm no-padding-right">Distrito:</label>	
											<div class="col-sm-2">
												<select id="sel_distrito" class="form-control input-sm">
														<option>Seleccionar</option>
												<%-- 	<c:forEach items="${lis_tip_zona}" var="item">
													    <option value="${item.srlIdZona}">${item.chrNomZona}</option>
													</c:forEach> --%>
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
							<button  id="btn_cancelar" class="btn btn-sm" data-dismiss="modal">
								<i class="ace-icon fa fa-times"></i>
								Cancelar
							</button>
						</div>
				</div>
			</div>
		</div>	
	</div>
		
	<!-- 	</div>/.main-container -->
	
		<%@ include file="scripts_ini.jsp" %>

		<!-- inline scripts related to this page -->
		<script type="text/javascript">
		
			$(document).ready(function() {
			 	$('#sel_tip_documento').val("1");
			 	
			 	inicializarDatos();
				 $('#txt_ape_paterno').keyup(function() {
				        this.value = this.value.toUpperCase();
				   });
				 $('#txt_ape_materno').keyup(function() {
				        this.value = this.value.toUpperCase();
				   });
				 $('#txt_reg_nombres').keyup(function() {
				        this.value = this.value.toUpperCase();
				   });
				 $('#txt_reg_correo').keyup(function() {
				        this.value = this.value.toUpperCase();
				   });
				 $('#txt_nom_via').keyup(function() {
				        this.value = this.value.toUpperCase();
				   });
				 $('#txt_zona').keyup(function() {
				        this.value = this.value.toUpperCase();
				   });
				 $('#txt_referencia').keyup(function() {
				        this.value = this.value.toUpperCase();
				   });
			 	$("#txt_mnt_importe").keyup(function() {
			 	
			 	 	if( $('input[name=rb_tip_ren]:checked').val() == "S"){
			 		var suspencion=document.getElementById("txt_mnt_importe").value;
			 		var montoretenido= suspencion * 0.08;
			 	        document.getElementById('txt_mnt_monto_retenido').value=""+montoretenido+"";
			 		var total = suspencion - montoretenido;
			 		    document.getElementById('txt_mnt_total').value=""+total+"";
			 	 	}else {
			 	 		var suspencion=document.getElementById("txt_mnt_importe").value;
			 	 		var montoretenido= suspencion * 0;
			 	        document.getElementById('txt_mnt_monto_retenido').value=""+montoretenido+"";
			 	 		var total = suspencion;
			 	 		document.getElementById('txt_mnt_total').value=""+total+"";
			 	 	}
			    });
			 	
				$("#txt_nota_importe").keyup(function() {
			 		  
			 	 	if( $('input[name=rb_tip_ren_notas]:checked').val() == "S"){
			 		var suspencionnota=document.getElementById("txt_nota_importe").value;
			 	
			 		
			 		var montoretenidonota= suspencionnota * 0.08;
			 	        document.getElementById('txt_mnt_nota_retenido').value=""+montoretenidonota+"";
			 		var totalnota = suspencionnota - montoretenidonota;
			 		    document.getElementById('txt_nota_total').value=""+totalnota+"";
			 	 	}else {
			 	 		var suspencionnota=document.getElementById("txt_nota_importe").value;
			 	 		var montoretenidonota= suspencionnota * 0;
			 	        document.getElementById('txt_mnt_nota_retenido').value=""+montoretenidonota+"";
			 	 		var totalnota = suspencionnota;
			 	 		document.getElementById('txt_nota_total').value=""+totalnota+"";
			 	 	}
			    });
			 	
				$("#li_compras").addClass('active');
				$("#li_reg_cua_categoria").addClass('active');
				
				
				$('.date-picker').datepicker({
					autoclose: true,
					todayHighlight: true
				});
				
				$('.input-group-addon').click(function(event) {
					event.preventDefault();
					var id_sp = $(this).attr('id').substring(7);
					$('#txt_'+id_sp).datepicker('show');
				});
		
				$('#sp_ico_fec_hasta').click(function(event){
					event.preventDefault();
					$('#txt_fec_hasta').datepicker('show');
				});
				$('#btn_eliminar').click(function(e) {					
					e.preventDefault();
				 		var intIdfRegistro = 2;
						var cod_uni_operativa = $('#sel_mnt_uni_operativa').val();
						var cod_reg_nac= $('#sel_mnt_anp').val();
						var cod_tipoComprobante =$('#sel_mnt_tip_documento').val();
						var cod_personalCuarta= $('#txt_mnt_id_comprobante').val();
						var numRuc =$('#txt_mnt_ruc').val();
						var numImpSubtotal = $('#txt_mnt_total').val();
						var numImpRetenido = $('#txt_mnt_monto_retenido').val();
						var numImpTotal =$('#txt_mnt_importe').val();
						var chrNumRetencion =$('#txt_mnt_nro_suspension').val();
						var chrFlgRetencion =$('input[name=rb_tip_ren]:checked').val();
						var chrNumComprobante =$('#txt_mnt_nro').val();
						var chrNumSerie =$('#txt_mnt_serie').val();
						var cod_retenciones = $('#txt_mnt_codigo').val();
						
						$.ajax({
							type: 'POST',
							url: VAR_CONTEXT + '/grabarCuartaCategoria',
							data: { 
								 cod_retenciones     : cod_retenciones,
								 cod_uni_operativa	 : cod_uni_operativa,
								 cod_reg_nac		 : cod_reg_nac,
								 cod_tipoComprobante : cod_tipoComprobante,
						     	 numImpSubtotal 	 : numImpSubtotal, 
								 numImpTotal		 : numImpTotal,
								 numRuc				 : numRuc,
								 chrNumRetencion	 : chrNumRetencion,
								 chrFlgRetencion	 : chrFlgRetencion,
								 chrNumComprobante 	 : chrNumComprobante,
								 chrNumSerie 		 : chrNumSerie,
								 intIdfRegistro 	 : intIdfRegistro,
								 cod_personalCuarta  : cod_personalCuarta 
							},
							dataType: 'json',
							success: function(paramJson) {						
								if (paramJson != null) {
									endAjax();			
								    addInfoMessage(null, 'Registro Eliminado.');
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
				
				$('#btn_nota_eliminar').click(function(e) {					
					e.preventDefault();
					
				 		var intIdfRegistro = 2;
						var chrNotadeCredito = "S";
						var cod_uni_operativa = $('#sel_tip_uni_notas').val();
						var cod_reg_nac= $('#sel_tip_anp_notas').val();
						var cod_personalCuarta= $('#txt_mnt_id_comprobante').val();
						var numRuc =$('#txt_mnt_ruc').val();
						var dteFecPago =$('#txt_mnt_fec_pago').val();
						var chrNumRetencion =$('#txt_mnt_nro_suspension').val();
						var chrFlgRetencion =$('input[name=rb_tip_ren]:checked').val();
						
						var numImpSubtotal = $('#txt_nota_total').val();
						var numImpRetenido = $('#txt_mnt_nota_retenido').val();
						var numImpTotal =$('#txt_nota_importe').val();
						var cod_tipoComprobante =$('#sel_tip_com_nc').val();
						var dteFecDocumento =$('#txt_fec_doc_nc_hijo').val();
						var chrNumComprobante =$('#txt_nro_doc_nc_hijo').val();
						var chrNumSerie =$('#txt_ser_nc_hijo').val();
						var cod_retenciones = $('#txt_mnt_codigo').val();
						var intCodPadComRecibo = $('#txt_mnt_codigo_hijo').val();
						
						var total=document.getElementById("txt_mnt_total").value; 
						var totalnota=document.getElementById("txt_nota_total").value;
						
						startAjax();
						var new_record = true;
						if (!esnulo(cod_retenciones)) {
							new_record = false;
						}
						
						$.ajax({
							type: 'POST',
							url: VAR_CONTEXT + '/grabarCuartaCategoria',
							data: { 
								 chrNotadeCredito    : chrNotadeCredito,
								 cod_retenciones     : cod_retenciones,
								 cod_uni_operativa	 : cod_uni_operativa,
								 cod_reg_nac		 : cod_reg_nac,
								 cod_tipoComprobante : cod_tipoComprobante,
						     	 numImpSubtotal 	 : numImpSubtotal, 
								 numImpTotal		 : numImpTotal,
								 numImpRetenido		 : numImpRetenido,
								 dteFecDocumento  	 : dteFecDocumento,
								 dteFecPago 		 : dteFecPago,
								 numRuc				 : numRuc,
								 chrNumRetencion	 : chrNumRetencion,
								 chrFlgRetencion	 : chrFlgRetencion,
								 chrNumComprobante 	 : chrNumComprobante,
								 chrNumSerie 		 : chrNumSerie,
								 intIdfRegistro 	 : intIdfRegistro,
								 cod_personalCuarta  : cod_personalCuarta,
								 intCodPadComRecibo  : intCodPadComRecibo
							},
							dataType: 'json',
							success: function(paramJson) {						
								if (paramJson != null) {
									endAjax();			
									if (new_record) {
										addInfoMessage(null, 'El registro fue grabado.');
									} else {
										addInfoMessage(null, 'Registro Eliminado.');
										search();
									}
									$('#div_reg_not_credito').modal('hide');
									$('#btn_notas').prop('disabled', true);
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
				
				$('#txt_fec_inicial').datepicker().on('changeDate', function (ev) {
					var fec_comprobante = $(this).val();
					var dia = parseInt(fec_comprobante.substring(0, 2)) + 1;
					var mes = fec_comprobante.substring(3, 5);
					var anio = fec_comprobante.substring(6, 10);
					var fec_form = anio + '-' + mes + '-' + dia;					
					var fec_act = new Date(fec_form);
					//$('#txt_fec_documento').datepicker('setEndDate', fec_act);
					$('#txt_fec_final').datepicker('setStartDate', fec_act);
				});
				
				$('#txt_mnt_fec').datepicker().on('changeDate', function (ev) {
					var fec_comprobante = $(this).val();
					var dia = parseInt(fec_comprobante.substring(0, 2)) + 1;
					var mes = fec_comprobante.substring(3, 5);
					var anio = fec_comprobante.substring(6, 10);
					var fec_form = anio + '-' + mes + '-' + dia;					
					var fec_act = new Date(fec_form);
					//$('#txt_fec_documento').datepicker('setEndDate', fec_act);
					$('#txt_mnt_fec_pago').datepicker('setStartDate', fec_act);
				});
				
				$('#txt_mnt_fec').datepicker().on('changeDate', function (ev) {
					var fec_comprobante = $(this).val();
					var dia = parseInt(fec_comprobante.substring(0, 2)) + 1;
					var mes = fec_comprobante.substring(3, 5);
					var anio = fec_comprobante.substring(6, 10);
					var fec_form = anio + '-' + mes + '-' + dia;					
					var fec_act = new Date(fec_form);
					//$('#txt_fec_documento').datepicker('setEndDate', fec_act);
					$('#txt_fec_doc_nc_hijo').datepicker('setStartDate', fec_act);
				});
				
				$('#btn_buscar').click(function(e) {					
					e.preventDefault();
					search();
				});
				$('#sel_uni_operativa').on('change', function() {
					obtenerAnp($(this).val());
				});
				$('#sel_mnt_uni_operativa').on('change', function() {
					obtenermntAnp($(this).val());
				});
				$('#sel_tip_uni_notas').on('change', function() {
					obtenerNotasAnp($(this).val());
				});
				
				$('#sel_departamento').on('change', function() {
					obtenerprovincia($(this).val());
				});
				$('#sel_provincia').on('change', function() {
					obtenerdistrito($(this).val());
				});
				
				
				$('#btn_nuevo').click(function(e) {					
					e.preventDefault();
					$('#sel_mnt_uni_operativa').removeAttr("disabled");  
					$('#sel_mnt_anp').removeAttr("disabled");  
					$('#h_financiero').html('Registro de Cuarta Categoria');
					$('#form_cierre_mes').trigger("reset");
					$('#form_det_reg_gravado').trigger("reset");
					$('#div_cierre_mes').modal('show');
				 	$('#sel_mnt_tip_documento').val("1");
				 	inicializarDatos();
				 	
				 	if ('${ind_sed_principal}' == '1') { // Usuario de Sede Central						
					 	$('#sel_mnt_uni_operativa').val('Seleccionar'); // Lima
				 	} 
				 
				 	$("#btn_eliminar").attr("style","display:none");
				 	$('#btn_notas').prop('disabled', true);
				});
				 
				 $('input[type=radio][name=rb_tip_ren]').change(function() {
					  $('#txt_mnt_nro_suspension').val("");
					  $('#txt_mnt_importe').val("");
					  $('#txt_mnt_monto_retenido').val("");
					  $('#txt_mnt_total').val("");
				    });
				
				});
			
			
			// Nota de Credito o Debito
			$('#btn_notas').click(function(e) {		
			 
				e.preventDefault();
				$('#form_det_reg_gravado').trigger("reset");
				$('#sel_tip_uni_notas').val($('#sel_mnt_uni_operativa').val());
				$('#sel_tip_anp_notas').val($('#sel_mnt_anp').val());
				$('#sel_mnt_uni_operativa').val($('#sel_mnt_uni_operativa').val());
				$('#txt_ser_nc').val($('#txt_mnt_serie').val());
				$('#txt_nro_doc_nc').val($('#txt_mnt_nro').val());
				$('#txt_fec_doc_nc').val($('#txt_mnt_fec').val());
				if( $('input[name=rb_tip_ren]:checked').val() == "S"){
					$('input[name=rb_tip_ren_notas][value="S"]').prop('checked', true);
				}else{
					$('input[name=rb_tip_ren_notas][value="N"]').prop('checked', true);
				}
			
				$('#div_reg_not_credito').modal('show');
			});
			
			$('#btn_gra_not_credito').click(function(e) {					
				 
				e.preventDefault();
				var intIdfRegistro = 1;
				var chrNotadeCredito = "S";
				var cod_uni_operativa = $('#sel_tip_uni_notas').val();
				var cod_reg_nac= $('#sel_tip_anp_notas').val();
				var cod_personalCuarta= $('#txt_mnt_id_comprobante').val();
				var numRuc =$('#txt_mnt_ruc').val();
				var dteFecPago =$('#txt_mnt_fec_pago').val();
				var chrNumRetencion =$('#txt_mnt_nro_suspension').val();
				var chrFlgRetencion =$('input[name=rb_tip_ren]:checked').val();
				
				var numImpSubtotal = $('#txt_nota_total').val();
				var numImpRetenido = $('#txt_mnt_nota_retenido').val();
				var numImpTotal =$('#txt_nota_importe').val();
				var cod_tipoComprobante =$('#sel_tip_com_nc').val();
				var dteFecDocumento =$('#txt_fec_doc_nc_hijo').val();
				var chrNumComprobante =$('#txt_nro_doc_nc_hijo').val();
				var chrNumSerie =$('#txt_ser_nc_hijo').val();
				var cod_retenciones = $('#txt_mnt_codigo').val();
				var intCodPadComRecibo = $('#txt_mnt_codigo_hijo').val();
				
				var total=parseInt(document.getElementById("txt_mnt_total").value); 
				var totalnota=parseInt(document.getElementById("txt_nota_total").value);
				if (totalnota > total){
		 			showMessage("El importe de Nota de Credito = "+totalnota+ " debe ser menor al Importe de Recibo por Honorarios ="+total);
		 			return;
		 		}
				
				startAjax();
				var new_record = true;
				if (!esnulo(cod_retenciones)) {
					new_record = false;
				}
				
				$.ajax({
					type: 'POST',
					url: VAR_CONTEXT + '/grabarCuartaCategoria',
					data: { 
						 chrNotadeCredito    : chrNotadeCredito,
						 cod_retenciones     : cod_retenciones,
						 cod_uni_operativa	 : cod_uni_operativa,
						 cod_reg_nac		 : cod_reg_nac,
						 cod_tipoComprobante : cod_tipoComprobante,
				     	 numImpSubtotal 	 : numImpSubtotal, 
						 numImpTotal		 : numImpTotal,
						 numImpRetenido		 : numImpRetenido,
						 dteFecDocumento  	 : dteFecDocumento,
						 dteFecPago 		 : dteFecPago,
						 numRuc				 : numRuc,
						 chrNumRetencion	 : chrNumRetencion,
						 chrFlgRetencion	 : chrFlgRetencion,
						 chrNumComprobante 	 : chrNumComprobante,
						 chrNumSerie 		 : chrNumSerie,
						 intIdfRegistro 	 : intIdfRegistro,
						 cod_personalCuarta  : cod_personalCuarta,
						 intCodPadComRecibo  : intCodPadComRecibo
					},
					dataType: 'json',
					success: function(paramJson) {						
						if (paramJson != null) {
							endAjax();			
							if (new_record) {
								addInfoMessage(null, 'El registro fue grabado.');
							} else {
								addInfoMessage(null, 'Registro Actualizado.');
								search();
							}
							$('#div_reg_not_credito').modal('hide');
							$('#btn_notas').prop('disabled', true);
							
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
			
			$('#btn_grabar').click(function(e) {					
				e.preventDefault();
			/* 	$('#txt_mnt_monto_retenido').removeAttr("disabled"); */
				var intIdfRegistro = 1;
				var cod_uni_operativa = $('#sel_mnt_uni_operativa').val();
				var cod_reg_nac= $('#sel_mnt_anp').val();
				var cod_tipoComprobante =$('#sel_mnt_tip_documento').val();
				var cod_personalCuarta= $('#txt_mnt_id_comprobante').val();
				var numRuc =$('#txt_mnt_ruc').val();
				var dteFecDocumento =$('#txt_mnt_fec').val();
				var dteFecPago =$('#txt_mnt_fec_pago').val();
				var numImpSubtotal = $('#txt_mnt_total').val();
				var numImpRetenido = $('#txt_mnt_monto_retenido').val();
				var numImpTotal =$('#txt_mnt_importe').val();
				var chrNumRetencion =$('#txt_mnt_nro_suspension').val();
				var chrFlgRetencion =$('input[name=rb_tip_ren]:checked').val();
				var chrNumComprobante =$('#txt_mnt_nro').val();
				var chrNumSerie =$('#txt_mnt_serie').val();
				var cod_retenciones = $('#txt_mnt_codigo').val();
				if ('${ind_sed_principal}' == 1){
					var chrTipOperacion = '${ind_sed_principal}';
				}else {
					var chrTipOperacion = 2;
				}
				var msg = '';
				if(chrTipOperacion != 1){
					if (cod_uni_operativa == "Seleccionar" ) {
						msg = msg + 'El campo "Unidada Operativa" es obligatorio.<br/>';
					}				
					if (cod_reg_nac  == "Seleccionar" ) {
						msg = msg + 'El campo "ANP" es obligatorio.<br/>';
					}
				}
				if (esnulo(cod_tipoComprobante)) {
					msg = msg + 'El campo "Tipo de Comprobante" es obligatorio.<br/>';
				}
				if (esnulo(chrFlgRetencion)) {
					msg = msg + 'El campo "Retención" es obligatorio.<br/>';
				}
				if (esnulo(chrNumRetencion) && chrFlgRetencion == 'S' ) {
					msg = msg + 'El campo "Numero de Retención" es obligatorio.<br/>';
				}
				if (esnulo(numImpSubtotal)) {
					msg = msg + 'El campo "Importe Subtotal" es obligatorio.<br/>';
				}
				
				if (!esnulo(msg)) {
					showMessage(msg);
					return;
				}	
				
				var new_record = true;
				if (!esnulo(cod_retenciones)) {
					new_record = false;
				}
				$.ajax({
					type: 'POST',
					url: VAR_CONTEXT + '/grabarCuartaCategoria',
					data: { 
						 cod_retenciones     : cod_retenciones,
						 cod_uni_operativa	 : cod_uni_operativa,
						 cod_reg_nac		 : cod_reg_nac,
						 cod_tipoComprobante : cod_tipoComprobante,
				     	 numImpSubtotal 	 : numImpSubtotal, 
						 numImpTotal		 : numImpTotal,
						 numImpRetenido		 : numImpRetenido,
						 dteFecDocumento  	 : dteFecDocumento,
						 dteFecPago 		 : dteFecPago,
						 numRuc				 : numRuc,
						 chrNumRetencion	 : chrNumRetencion,
						 chrFlgRetencion	 : chrFlgRetencion,
						 chrNumComprobante 	 : chrNumComprobante,
						 chrNumSerie 		 : chrNumSerie,
						 intIdfRegistro 	 : intIdfRegistro,
						 cod_personalCuarta  : cod_personalCuarta,
						 chrTipOperacion	 : chrTipOperacion
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
			
			$('#btn_gra_prestador').click(function(e) {					
				e.preventDefault();
				
				var	numRuc=$('#txt_reg_ruc_cuarta').val();
				var TDocumentoCuarta=$('#sel_tip_doc').val();
				var chrNumDocumento=$('#txt_nro_doc_cuarta').val();
				var	chrApePaterno=$('#txt_ape_paterno').val();
				var	chrApeMaterno=$('#txt_ape_materno').val();
				var	chrNombres=$('#txt_reg_nombres').val();
				var dteFecNacimiento=$('#txt_reg_fec_nac').val();
				var TNacionalidad=$('#sel_tip_nacionalidad').val();
				var	chrTipSexo=$('#sel_tip_sexo').val();
				var chrNumTelefono=$('#txt_telefomo').val();
				var	chrCorreo=$('#txt_reg_correo').val();
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
									TVia 	 : TVia,
									TZona    : TZona,
									numRuc	 : numRuc,
							  chrNumDocumento: chrNumDocumento,
							  chrApePaterno	 : chrApePaterno,
							  chrApeMaterno	 : chrApeMaterno,
							  chrNombres	 : chrNombres,
							  dteFecNacimiento: dteFecNacimiento,
							  chrTipSexo	 : chrTipSexo,
							  chrNumTelefono : chrNumTelefono,
							  chrCorreo		 : chrCorreo,
							  chrIndEssalud	 : chrIndEssalud,
							  chrIndDomiciliario: chrIndDomiciliario,
							  numRucConvenio : numRucConvenio,
							  chrNomVia		 : chrNomVia,
							  chrNumHogar	 : chrNumHogar,
							  chrNumInterior : chrNumInterior,
							  chrNomZona	 : chrNomZona,
							  chrReferencia	 : chrReferencia,
							   idubigeo		 :	idubigeo 
							},
					dataType: 'json',
					success: function(paramJson) {						
						if (paramJson != null) {	
							endAjax();			
			       		    addInfoMessage(null, 'El registro fue grabado.');
			       			var srlIdPersonal=   paramJson;
			       			$('#txt_mnt_id_comprobante').val(srlIdPersonal);
			       			$('#txt_mnt_ruc').val(numRuc);
							$('#txt_mnt_nomb').val(trim(chrApePaterno)+ ' '+trim(chrApeMaterno) + ' ' +trim(chrNombres));
			       			$('#div_reg_proveedor').modal('hide');
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
				
				$('#txt_imp_nc').change(function() {
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
				
						imp_total = imp_afecto + imp_igv + imp_no_afecto + imp_isc;

						$('#txt_imp_afe_nc').val(imp_afecto.toFixed(2));
						$('#txt_imp_igv_nc').val(imp_igv.toFixed(2));
						$('#txt_imp_no_afe_nc').val(imp_no_afecto.toFixed(2));
						$('#txt_imp_isc_nc').val(imp_isc.toFixed(2));
						$('#txt_imp_tot_nc').val(imp_total.toFixed(2));
					}
 				});
				
							
				
			});
			
			function search() {
				var href = '/listarCuartaCategoria';
				var fla_activo = 'N';
				if ($('#chk_activo').is(':checked')) {
					fla_activo = 'S';
				}	
				var params = {
					   cod_uni_operativa  	: $('#sel_uni_operativa').val(),
			    	   cod_reg_nac 			: $('#sel_anp').val(),
			    	   cod_tipoComprobante  : $('#sel_tip_documento').val(),
			    	   chrNumSerie			: $('#txt_serie').val(),
			    	  dteFecDocumentoInicial: $('#txt_fec_inicial').val(),
			    	  dteFecDocumentoFinal  : $('#txt_fec_final').val(),
			    	  chrNumComprobante  	: $('#txt_nro').val(),
			    	  numRuc				: $('#txt_ruc').val(),
			    	  chrTipOperacion		: $('input[name=rb_tip_operacion]:checked').val()
				};
				var fields = [
					'cod_retenciones', 
					'numRuc'
				];
				var layout = [ {
					title: 'Numero de RUC',
					field: fields,
					type: 'link',					
					label: '',
					method: 'editar',
				},{
					title: 'Tipo de Comprobante',
					field: 'cod_tipoComprobante',
				},{
					title: 'Serie',
					field: 'chrNumSerie',
				}, {
					title: 'Nro de RxH',
					field: 'chrNumComprobante',
				},{
					title: 'Fec. Documento',
					field: 'dteFecDocumento',
				},{
					title: 'Fec. Pago',
					field: 'dteFecPago',
				},{
					title: 'Opción Ret.',
					field: 'chrIndRetencion',
				},{
					title: 'Importe Total.',
					field: 'numImpTotal',
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
					containerTable: '.div_cor_com_pago',
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
				simpleGenerateDatatable(href, layout, options, '', '');
			}
		
			
			function obtenerAnp(cod_uni_operativa) {
				var params = new Object();
 				params['ind_uni_operativa'] = 1;
 				params['cod_uni_operativa'] = cod_uni_operativa;
 				simpleCboAjaxPopulateParam('#sel_anp', ['cod_reg_nac', 'des_reg_nac'], '/listarUnidadOperativa', params, true, false);
			}
			function obtenermntAnp(cod_uni_operativa) {
				var params = new Object();
 				params['ind_uni_operativa'] = 1;
 				params['cod_uni_operativa'] = cod_uni_operativa;
 				simpleCboAjaxPopulateParam('#sel_mnt_anp', ['cod_reg_nac', 'des_reg_nac'], '/listarUnidadOperativa', params, true, false);
			}
			function obtenerNotasAnp(cod_uni_operativa) {
				var params = new Object();
 				params['ind_uni_operativa'] = 1;
 				params['cod_uni_operativa'] = cod_uni_operativa;
 				simpleCboAjaxPopulateParam('#sel_tip_anp_notas', ['cod_reg_nac', 'des_reg_nac'], '/listarUnidadOperativa', params, true, false);
			}
			function obtenerprovincia(coddpto) {
				var params = new Object();
 				params['coddpto'] = coddpto;
 				simpleCboAjaxPopulateParam('#sel_provincia', ['codprov', 'nombre'], '/listarUbigeo', params, true, false);
			}

			function obtenerdistrito(codprov) {
				var params = new Object();
				var coddpto = $('#sel_departamento').val();
 				params['coddpto'] = coddpto;
 				params['codprov'] = codprov;
 				simpleCboAjaxPopulateParam('#sel_distrito', ['coddist', 'nombre'], '/listarUbigeo', params, true, false);
			}
			
			
			function editar(object) {				
				$("#btn_eliminar").attr("style","display:display");
				
				$.ajax({
					type: 'GET',
					url: '${pageContext.request.contextPath}/listarCuartaCategoria',
					data: {
						cod_retenciones : object
					},
					dataType: 'json',
					success: function(paramJson) {						
						if (paramJson[0] != null) {	
							if(paramJson[0].intCodPadComRecibo > 0){
								$.ajax({
									type: 'GET',
									url: '${pageContext.request.contextPath}/listarCuartaCategoria',
									data: {
										cod_retenciones : paramJson[0].intCodPadComRecibo
									},
									dataType: 'json',
									success: function(paramJson) {						
										if (paramJson[0] != null) {
										$('#txt_mnt_total').val(paramJson[0].numImpSubtotal);
										
										} 
										}});
								$('#sel_tip_uni_notas').val(paramJson[0].cod_uni_operativa);
								obtenermntAnp(paramJson[0].cod_uni_operativa);
								$('#txt_fec_doc_nc').val(paramJson[0].dteFecDocumento);
								$('#txt_nro_doc_nc').val(paramJson[0].chrNumComprobante);
								$('#txt_ser_nc').val(paramJson[0].chrNumSerie);
								$('#txt_mnt_codigo_hijo').val(paramJson[0].cod_retenciones);
								$('#txt_nota_total').val(paramJson[0].numImpSubtotal);
								$('#txt_mnt_nota_retenido').val(paramJson[0].numImpRetenido);
								$('#txt_nota_importe').val(paramJson[0].numImpTotal);
								
								if( paramJson[0].chrIndRetencion == "S"){
									$('input[name=rb_tip_ren_notas][value="S"]').prop('checked', true);
								}else{
									$('input[name=rb_tip_ren_notas][value="N"]').prop('checked', true);
								}
								if( paramJson[0].chrTipOperacion == "1"){
									$('input[name=rb_mnt_tip_operacion][value="1"]').prop('checked', true);
								 
								}else{
									$('input[name=rb_mnt_tip_operacion][value="2"]').prop('checked', true);
								}
								if($('input[name=rb_mnt_tip_operacion]:checked').val() == "2") //observado
						 		{			 			
						 			$('#sel_mnt_uni_operativa').val("");
						 			$('#sel_mnt_anp').val("");
						 			$('#sel_mnt_uni_operativa').prop('disabled', true);
						 			$('#sel_mnt_anp').prop('disabled', true);
						 		} 
								
								$('#sel_tip_com_nc').val(paramJson[0].cod_tipoComprobante);
								$('#txt_fec_doc_nc_hijo').val(paramJson[0].dteFecDocumento);
								$('#txt_nro_doc_nc_hijo').val(paramJson[0].chrNumComprobante);
								$('#txt_ser_nc_hijo').val(paramJson[0].chrNumSerie);
								$('#txt_mnt_codigo').val(paramJson[0].cod_retenciones);
								$('#sel_tip_anp_notas').val(paramJson[0].cod_reg_nac);
								
								$('#div_reg_not_credito').modal('show');
							}else{
							
							$('#h_financiero').html('Edicion de Cuarta Categoria');
							$('#form_cierre_mes').trigger("reset");
							
							$('#sel_mnt_uni_operativa').val(paramJson[0].cod_uni_operativa);
							$('#sel_mnt_anp').val(paramJson[0].cod_reg_nac);
							$('#sel_mnt_tip_documento').val(paramJson[0].cod_tipoComprobante);
							$('#txt_mnt_id_comprobante').val(paramJson[0].cod_personalCuarta);
							$('#txt_mnt_ruc').val(trim(paramJson[0].numRuc));
							fun();
							$('#txt_mnt_total').val(paramJson[0].numImpSubtotal);
							$('#txt_mnt_fec').val(paramJson[0].dteFecDocumento);
							$('#txt_mnt_fec_pago').val(paramJson[0].dteFecPago);
							
							$('#txt_mnt_monto_retenido').val(paramJson[0].numImpRetenido);
							$('#txt_mnt_importe').val(paramJson[0].numImpTotal);
							$('#txt_mnt_nro_suspension').val(paramJson[0].chrNumRetencion);
							if( paramJson[0].chrTipOperacion == "1"){
								$('input[name=rb_mnt_tip_operacion][value="1"]').prop('checked', true);
							}else{
								$('input[name=rb_mnt_tip_operacion][value="2"]').prop('checked', true);
							}
							if($('input[name=rb_mnt_tip_operacion]:checked').val() == "2")
					 		{			 			
					 			$('#sel_mnt_uni_operativa').prop('disabled', true);
					 			$('#sel_mnt_anp').prop('disabled', true);
					 		}
							fun();
							if( paramJson[0].chrIndRetencion == "S"){
								$('input[name=rb_tip_ren][value="S"]').prop('checked', true);
							}else{
								$('input[name=rb_tip_ren][value="N"]').prop('checked', true);
							}
							$('#txt_mnt_nro').val(paramJson[0].chrNumComprobante);
							$('#txt_mnt_serie').val(paramJson[0].chrNumSerie);
							$('#txt_mnt_codigo').val(paramJson[0].cod_retenciones);
							
							if (parseInt(paramJson[0].intCodPadComRecibo) == 0) { // Comparo si el registro tiene un registro hijo
								$('#btn_notas').prop('disabled', true);
							} else {
								$('#btn_notas').prop('disabled', false);
							}
							$('#div_cierre_mes').modal('show');
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
			
			function fun(){
				var	numRuc = $('#txt_mnt_ruc').val();

				if( $('#txt_mnt_ruc').val() != null && $('#txt_mnt_ruc').val() != "" ) {
					 $.ajax({
							type: 'GET',
							url: '${pageContext.request.contextPath}/verificarRucCuarta',
							data: {
								numRuc : numRuc
							},
							dataType: 'json',
							success: function(paramJson) {					
								if (paramJson[0] != null) {								
									$('#txt_mnt_id_comprobante').val(paramJson[0]['srlIdPersonal']);
									$('#txt_mnt_ruc').val(paramJson[0]['numRuc']);
									$('#txt_mnt_nomb').val(trim(paramJson[0]['chrApePaterno'])+ ' '+trim(paramJson[0]['chrApeMaterno']) + ' ' +trim(paramJson[0]['chrNombres']));
								} else {
									bootbox.dialog({
										message: "<span class='bigger-110'>El proveedor no existe, desea registrarlo?</span>",
										buttons: {
											"click" : {
												"label" : "Si",
												"className" : "btn-sm btn-primary",
												"callback": function() {												
													$('#form_reg_proveedor').trigger("reset");
													$('#txt_reg_ruc_cuarta').val($('#txt_mnt_ruc').val());
												 	$('#sel_tip_doc').val("1");
												 	$('#sel_tip_nacionalidad').val("193");
												 	$('#sel_tip_convenio').val("N");
												 	$('#sel_domiciliado').val("S");
													$('#sel_convenio').val("1");
													$('#hid_proveedor').val(paramJson.srlIdPersonal);
													$('#hid_proveedor').val(paramJson.numRuc);
													$('#txt_apellidos').val(paramJson.chrApePaterno+ ' '+paramJson.chrApeMaterno + '' +paramJson.chrNombres);
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
									showMessage(msg);
								} else {
									msg = msg + errorThrown;
									showMessage(msg);
								}
							}
						}); 
					}
				}
			
			function inicializarDatos() {
				
				if ('${ind_sed_principal}' == '1') { // Usuario de Sede Central						
					$('input[name=rb_tip_operacion][value="1"]').prop('checked', true);
					$('input[name=rb_mnt_tip_operacion][value="1"]').prop('checked', true);
				//	$('#sel_mnt_uni_operativa').prop('disabled', true);
		      /*  	$('#sel_mnt_anp').prop('disabled', true); */
				} else {
					$('input[name=rb_tip_operacion][value="2"]').prop('checked', true);
					$('input[name=rb_mnt_tip_operacion][value="2"]').prop('checked', true);
					$('#sel_uni_operativa option:eq(1)').attr('selected', 'selected');
					
				}
				
				$('input[name=rb_tip_operacion]').prop('disabled', true);
				$('input[name=rb_mnt_tip_operacion]').prop('disabled', true);
			//	$('input[name=rb_tip_operacion]').prop('disabled', true);
			
			/*	obtenerAnp($('#sel_uni_operativa').val());
				obtenermntAnp($('#sel_mnt_uni_operativa').val());
				obtenerNotasAnp($('#sel_tip_anp_notas').val());*/
				
			}
		
		</script>
	</body>
</html>
