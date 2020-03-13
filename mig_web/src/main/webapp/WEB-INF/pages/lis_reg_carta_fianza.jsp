<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta charset="utf-8" />
<title>Carta Fianza</title>

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
							Mantenimiento</li>
						<li class="active">Carta Fianza</li>
					</ul>
				</div>

				<div class="page-content">
					<div class="row">
						<div class="col-xs-12">
							<form id="frm_car_fianza" class="form-horizontal" role="form" method="get" 
								  action="${pageContext.request.contextPath}/imprimirCartaFianza">
								<input type="hidden" id="hid_nro_carta" name="nro_carta">  
								<input type="hidden" id="hid_financiero">
			  	  
									<input type="hidden" id="hid_fil_busqueda" name="fil_busqueda">  
								<fieldset class="fsStyle">
									<legend class="legendStyle">Filtros para la Busqueda
										de Carta Fianza</legend>

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
										<!-- volver -->
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
												
												<label
													class="col-sm-1 control-label label-sm no-padding-right">Nro
													Carta Fianza:</label>
												<div class="col-sm-2">
													<input type="text" id="txt_nro_carta"
														class="form-control input-sm onlyNumbers" maxlength="15" />
												</div>
												<label
													class="col-sm-1 control-label label-sm no-padding-right">Fec.
													Inicio:</label>
												<div class="col-sm-2">
													<div class="input-group">
														<input class="form-control input-sm date-picker "
															id="txt_mnt_busq_fec_inicio" type="text"
															placeholder="dd/mm/yyyy" pattern="\d{1,2}/\d{1,2}/\d{4}"
															maxlength="10" /> <span class="input-group-addon"
															id="sp_ico_busq_fec_inicio"> <i
															class="fa fa-calendar bigger-110"></i>
														</span>
													</div>
												</div>
												<label
													class="col-sm-1 control-label label-sm no-padding-right">Fec.
													Fin:</label>
												<div class="col-sm-2">
													<div class="input-group">
														<input class="form-control input-sm date-picker "
															id="txt_mnt_busq_fec_fin" type="text"
															placeholder="dd/mm/yyyy" pattern="\d{1,2}/\d{1,2}/\d{4}"
															maxlength="10" /> <span class="input-group-addon"
															id="sp_ico_busq_fec_fin"> <i
															class="fa fa-calendar bigger-110"></i>
														</span>
													</div>
												</div>
											</div>

											<div class="form-group">
												<div class="form-group">
													<input type="text" id="txt_id_proveedor"
														class="form-control input-sm onlyAmounts hidden"
														maxlength="15" />
												</div>
											 
											    <input type="text" id="hid_buscar_empresa" class="form-control input-sm onlyAmounts hidden" maxlength="15" />
												
												<label class="col-sm-1 control-label label-sm no-padding-right">ANP:</label>
													<div class="col-sm-2">
															<select id="sel_anp" class="form-control input-sm">														
															<option>Seleccionar</option>
															</select>
													</div>	 
												
												<label
													class="col-sm-1 control-label label-sm no-padding-right">Ruc
													Empresa:</label>
												<div class="col-sm-3">
													<input type="text" id="txt_ruc_empresa"
														class="form-control input-sm " maxlength="12" />
												</div>
												<div class="col-sm-4">
													<input type="text" id="txt_nom_empresa"
														class="form-control input-sm " maxlength="30" disabled />
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
											
											<div class="form-group"></div>
											<div class="form-group"></div>
											<div class="form-group"></div>

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
							<div class="clearfix">
								<div class="pull-right">
								   <div class="btn-group btn-overlap">
								      <a title="Exportar a PDF" class="btn btn-white btn-primary btn-bold" id="too_tables_imp_pdf">
								         <span>
											<i class="fa fa-file-pdf-o bigger-110 red"></i>
										 </span>
								      </a>
								      <a title="Exportar a Excel" class="btn btn-white btn-primary btn-bold" id="too_tables_imp_excel">
								         <span>
											<i class="fa fa-file-excel-o bigger-110 green"></i>
										 </span>
								      </a>									      
								   </div>
								</div>
							</div>
							<div class="table-responsive div_financiero">
								<table id="tbl_financiero" class="table table-striped table-bordered table-hover">
									<thead>
										<tr>
											<th>Nro de Carta</th>
											<th>Numero de Fianza</th>
											<th>Fecha Inicio</th>
											<th>Fecha Fin</th>
											<th>Monto</th>
											<th>Banco</th>
											<th>Dias Fin</th>											
											<th>Nro de Doc y Fec.Dev</th>
											<th>Fec. Creación</th>
											<th>Fec. Modificación</th>
											<th>Usuario</th>
											<th>Usuario Modificación</th>
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

		<div id="div_carta_fianza_modal" class="modal" tabindex="-1"
			data-keyboard="false" data-backdrop="static">
			<div class="modal-dialog modal-lg">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 id="h_carta_fianza" class="white bigger center"></h4>
					</div>

					<div class="modal-body">
						<div class="row">
							<div class="col-xs-12">
								<form id="form_carta_fianza" class="form-horizontal" role="form">
									<div class="form-group">
										<input type="text" id="txt_mnt_codigo" class="form-control input-sm onlyAmounts hidden" maxlength="15" />
										<input type="text" id="hid_proveedor" class="form-control input-sm onlyAmounts hidden" maxlength="15" />
										
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
								 	 
									<div class="col-sm-6">
										<div class="form-group">
										<label class="col-sm-3 control-label label-sm no-padding-right">Unidad Operativa:</label>
											<div class="col-sm-9">
												<select id="sel_mnt_uni_operativa" class="form-control input-sm" >
														<option> Seleccionar </option>
													<c:forEach items="${lis_uni_operativa}" var="item">
													    <option value="${item.cod_uni_operativa}">${item.des_uni_operativa}</option>
													</c:forEach>
												</select>
											</div>
										</div> 		
										
										<div class="form-group">
											<label class="col-sm-3 control-label label-sm no-padding-right">Tipo Doc.:</label>
											<div class="col-sm-9">
												<select id="sel_mnt_tip_documento"
													class="form-control input-sm">
														<option>Seleccionar</option>
														<option value="1">OFICIO</option>
														<option value="2">CARTA</option>
														<option value="3">MEMO</option>
												</select>
											</div>
										</div>

										<div class="form-group">
											<label
												class="col-sm-3 control-label input-sm no-padding-right">Nro
												Doc. Presentación:</label>
											<div class="col-sm-9">
												<input type="text" id="txt_mnt_nro_carta" 
													class="form-control input-sm onlynumbers" maxlength="25" />
											</div>
										</div>
										
										<div class="form-group">
											<label
												class="col-sm-3 control-label label-sm no-padding-right">Fech.
												Documento.:</label>
											<div class="col-sm-9">
												<div class="input-group">
													<input class="form-control input-sm date-picker "
														id="txt_mnt_fec_docu" type="text" placeholder="dd/mm/yyyy"
														pattern="\d{1,2}/\d{1,2}/\d{4}" maxlength="10" /> <span
														class="input-group-addon" id="sp_ico_fec_docu"> <i
														class="fa fa-calendar bigger-110"></i>
													</span>
												</div>
											</div>
										</div>
										
										<div class="form-group">
											<label
												class="col-sm-3 control-label input-sm no-padding-right">Nro Carta Fianza:</label>
											<div class="col-sm-9">
												<input type="text" id="txt_mnt_num_fianza"
													class="form-control input-sm onlynumbers" maxlength="30" />
											</div>
										</div>
										
										<div class="form-group">
											<label
												class="col-sm-3 control-label input-sm no-padding-right">Oficina:</label>
											<div class="col-sm-9">
												<input type="text" id="txt_mnt_ofi"
													class="form-control input-sm" maxlength="5" />
											</div>
										</div>
									</div>
									<div class="col-sm-6">
										<div class="form-group">
											<label class="col-sm-3 control-label label-sm no-padding-right">ANP:</label>
											<div class="col-sm-9">
												<select id="sel_mnt_anp" class="form-control input-sm" >
													<option>Seleccionar</option>
												</select>
												
											</div>	
										</div> 
										<div class="form-group">
											<label
												class="col-sm-3 control-label label-sm no-padding-right">Fec.
												Present.:</label>
											<div class="col-sm-9">
												<div class="input-group">
													<input class="form-control input-sm date-picker "
														id="txt_mnt_fec_present" type="text"
														placeholder="dd/mm/yyyy" pattern="\d{1,2}/\d{1,2}/\d{4}"
														maxlength="10" /> <span class="input-group-addon"
														id="sp_ico_fec_present"> <i
														class="fa fa-calendar bigger-110"></i>
													</span>
												</div>
											</div>
										</div>
										<div class="form-group">
											<label
												class="col-sm-3 control-label label-sm no-padding-right">Fec.
												Inicio:</label>
											<div class="col-sm-9">
												<div class="input-group">
													<input class="form-control input-sm date-picker "
														id="txt_mnt_fec_inicio" type="text"
														placeholder="dd/mm/yyyy" pattern="\d{1,2}/\d{1,2}/\d{4}"
														maxlength="10" /> <span class="input-group-addon"
														id="sp_ico_fec_inicio"> <i
														class="fa fa-calendar bigger-110"></i>
													</span>
												</div>
											</div>
										</div>
										<div class="form-group">
											<label
												class="col-sm-3 control-label label-sm no-padding-right">Fec. fin:</label>
											<div class="col-sm-9">
												<div class="input-group">
													<input class="form-control input-sm date-picker "
														id="txt_mnt_fec_fin" type="text" placeholder="dd/mm/yyyy"
														pattern="\d{1,2}/\d{1,2}/\d{4}" maxlength="10" /> <span
														class="input-group-addon" id="sp_ico_fec_fin"> <i
														class="fa fa-calendar bigger-110"></i>
													</span>
												</div>
											</div>
										</div>
										<div class="form-group">
											<label
												class="col-sm-3 control-label label-sm no-padding-right">Fec. Devolución:</label>
											<div class="col-sm-9">
												<div class="input-group">
													<input class="form-control input-sm date-picker "
														id="txt_mnt_fec_devolucion" type="text"
														placeholder="dd/mm/yyyy" pattern="\d{1,2}/\d{1,2}/\d{4}"
														maxlength="10" /> <span class="input-group-addon"
														id="sp_ico_fec_devolucion"> <i
														class="fa fa-calendar bigger-110"></i>
													</span>
												</div>
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-2 control-label label-sm no-padding-right">Legalidad:</label>
											<div class="col-sm-2">
												<div class="checkbox">
													<label class="input-sm">
														<input type="checkbox" id="chk_activo_legal" class="ace input-sm" />
														<span class="lbl"> Activo</span>
													</label>
												</div>
											</div>
											<label class="col-sm-3 control-label label-sm no-padding-right">Estados:</label>
												<div class="col-sm-5">
													<select id="sel_mnt_estados" class="form-control input-sm" >
														<option>Seleccionar</option>
														<option value="1">DEVUELTO A ENTIDAD FINANCIERA</option>
														<option value="2">DEVUELTO AL PROVEEDOR</option>
														<option value="3">EN EJECUCION</option>
														<option value="4">EJECUTADO</option>
														<option value="5">VIGENTE</option>
														<option value="6">VENCIDO</option>	
													</select>
												</div>	
										</div>
									</div>
									<div class="form-group"></div>
									<div class="form-group">
										<label
											class="col-sm-3 control-label input-sm no-padding-right">Concepto:
											</label>
										<div class="col-sm-9">
 										<textarea class="form-control input-sm" rows="3" id="txt_mnt_concepto"  ></textarea>
										</div>
									</div>
									<div class="form-group">
										<label
											class="col-sm-3 control-label input-sm no-padding-right">Ruc Empresa:</label>
										<div class="col-sm-5">
											<input type="text" id="txt_mnt_ruc_empresa"	class="form-control input-sm onlyAmounts" maxlength="11" />
										</div>
									</div>
									<div class="form-group">
										<label
											class="col-sm-3 control-label input-sm no-padding-right">Razón Social:</label>
										<div class="col-sm-9">
											<input type="text" id="txt_mnt_raz_social" class="form-control input-sm" maxlength="30" disabled />
										</div>
									</div>
									<div class="form-group">
										<label
											class="col-sm-3 control-label input-sm no-padding-right">Entidad Financ.:</label>
										<div class="col-sm-3">											
												<select id="sel_mnt_ent_financ"
													class="form-control input-sm">
														<option>Selccionar</option>
													<c:forEach items="${lis_financiero}" var="item">
														<option value="${item.cod_financiero}">${item.nom_entidad}</option>
													</c:forEach>
												</select>
										</div>
										<label
											class="col-sm-3 control-label input-sm no-padding-right"> Importe S/.:</label>
										<div class="col-sm-3">
											<input type="text" id="txt_mnt_mto_carta" class="form-control input-sm onlyAmounts" maxlength="10" onblur="format()"  />
										</div>
									</div>

									<div class="form-group">
										<label
											class="col-sm-3 control-label input-sm no-padding-right">Fecha
											de Creacion:</label>
										<div class="col-sm-3">
											<input type="text" id="txt_fec_creacion" class="form-control input-sm" disabled />
										</div>

										<label
											class="col-sm-3 control-label input-sm no-padding-right">Fecha
											de Modificacion:</label>
										<div class="col-sm-3">
											<input type="text" id="txt_fec_modificacion"
												class="form-control input-sm" disabled />
										</div>
									</div>

									<div class="form-group">
										<label
											class="col-sm-3 control-label input-sm no-padding-right">Creación:</label>
										<div class="col-sm-3">
											<input type="text" id="txt_creacion"
												class="form-control input-sm" disabled />
										</div>

										<label
											class="col-sm-3 control-label input-sm no-padding-right">Modificado:</label>
										<div class="col-sm-3">
											<input type="text" id="txt_modificado"
												class="form-control input-sm" disabled />
										</div>
									</div>
									<fieldset class="fsStyle">
									<legend class="legendStyle">Datos de Documentos de devolución</legend>
										<div class="form-group">
											<label class="col-sm-3 control-label input-sm no-padding-right">Num. Doc. Devolución:</label>
											<div class="col-sm-3">
												<input type="text" id="txt_mnt_num_documento" class="form-control input-sm" maxlength="100"  />
											</div>
	
											<label class="col-sm-3 control-label input-sm no-padding-right">Fech. Documento:</label>
											<div class="col-sm-3">
												<div class="input-group">
													<input class="form-control input-sm date-picker "
														id="txt_mnt_fec_documento" type="text"
														placeholder="dd/mm/yyyy" pattern="\d{1,2}/\d{1,2}/\d{4}"
														maxlength="10" /> <span class="input-group-addon"
														id="sp_ico_fec_documento"> <i
														class="fa fa-calendar bigger-110"></i>
													</span>
												</div>
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
									<i class="ace-icon fa fa-check"></i> Grabar
								</button>
							</div>
						 	<div class="col-sm-3">
							   <button id="btn_eliminar" class="btn btn-sm btn-danger input-sm">
									<i class="ace-icon fa fa-times"></i>
									Eliminar
						 	   </button>
							</div>
							<div class="col-sm-3">
								<button id="btn_salir" class="btn btn-sm input-sm"
									data-dismiss="modal">
									<i class="ace-icon fa fa-times"></i> Salir
								</button>
							</div>
						</div>
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
						 
							<button class="btn btn-sm input-sm" data-dismiss="modal">
								<i class="ace-icon fa fa-times"></i>
								Salir
							</button>
						</div>
						
					</div>
				</div>
			</div>
	</div>
	<!-- /.main-container -->

	<%@ include file="scripts_ini.jsp"%>

	<!-- inline scripts related to this page -->
	<script type="text/javascript">
		
			$(document).ready(function() {
				$('.date-picker').datepicker({
					autoclose: true,
					todayHighlight: true
				});
				
				inicializarDatos();
				$('.input-group-addon').click(function(event){
					event.preventDefault();
					var id_sp = $(this).attr('id').substring(7);
					$('#txt_mnt_'+id_sp).datepicker('show');
				});
				
				
				$('#sel_uni_operativa').on('change', function() {
					obtenerAnp($(this).val());
				});
				$('#sel_mnt_uni_operativa').on('change', function() {
					obtenermntAnp($(this).val());
				});
				
				$("#li_con_seguimiento").addClass('active');
				$("#li_reg_car_fianza").addClass('active');			

				$('#btn_buscar').click(function(e) {					
					e.preventDefault();
					search();
				});
				 $('#txt_mnt_ofi').keyup(function() {
				        this.value = this.value.toUpperCase();
				   });
				 $('#txt_mnt_concepto').keyup(function() {
				        this.value = this.value.toUpperCase();
				   });
				
				$('#btn_nuevo').click(function(e) {					
					
					e.preventDefault();
					$('#h_carta_fianza').html('Registro de Carta Fianza');
					$('#form_carta_fianza').trigger('reset');
					$('#sel_mnt_anp').empty();
					$("#sel_mnt_anp").append($("<option></option>").html("Seleccionar"));
					if ('${ind_sed_principal}' == '1') { // Usuario de Sede Central						
		 				$('input[name=rb_mnt_tip_operacion][value="1"]').prop('checked', true);
						
				 	}  else {
				 		$('input[name=rb_mnt_tip_operacion][value="2"]').prop('checked', true);
				 	}
					$('#div_carta_fianza_modal').modal('show');
				 	$("#btn_eliminar").attr("style","display:none");
					
				});
				
				
				$('#txt_mnt_fec_inicio').datepicker().on('changeDate', function (ev) {
					var fec_comprobante = $(this).val();
					var dia = parseInt(fec_comprobante.substring(0, 2)) + 1;
					var mes = fec_comprobante.substring(3, 5);
					var anio = fec_comprobante.substring(6, 10);
					var fec_form = anio + '-' + mes + '-' + dia;					
					var fec_act = new Date(fec_form);
					$('#txt_mnt_fec_fin').datepicker('setStartDate', fec_act);
				});
				

				$('#txt_mnt_busq_fec_inicio').datepicker().on('changeDate', function (ev) {
					var fec_comprobante = $(this).val();
					var dia = parseInt(fec_comprobante.substring(0, 2)) + 1;
					var mes = fec_comprobante.substring(3, 5);
					var anio = fec_comprobante.substring(6, 10);
					var fec_form = anio + '-' + mes + '-' + dia;					
					var fec_act = new Date(fec_form);
					//$('#txt_fec_documento').datepicker('setEndDate', fec_act);
					$('#txt_mnt_busq_fec_fin').datepicker('setStartDate', fec_act);
				});
				
				
				$('#too_tables_imp_pdf').click(function(e) {					
					e.preventDefault();
					
					var row = $('#tbl_financiero > tbody > tr').length;
					var empty = null;
					$('tr.odd').each(function() {		
						empty = $(this).find('.dataTables_empty').text();
						return false;
					});					
					if (!esnulo(empty) || row < 1) {
						addWarnMessage(null, 'No se encuentran registros para generar el reporte.');
						return;
					}
					
					startAjax();
					var num_carta = $('#txt_nro_carta').val();
					var tip_operacion = $('input[name="rb_tip_operacion"]:checked').val();				
					var dteFecInicio = $('#txt_mnt_busq_fec_inicio').val();
					var dteFecFinal = $('#txt_mnt_busq_fec_fin').val();
					var cod_uni_operativa = $('#sel_uni_operativa').val();  //volver
					
					if (cod_uni_operativa == "Seleccionar"){
						cod_uni_operativa = '';
					}
					
					var des_uni_operativa = ' ';
					if (!esnulo(cod_uni_operativa)) {
						des_uni_operativa = $('#sel_uni_operativa option:selected').text();
					}
					var cod_anp = $('#sel_anp').val();
					var des_anp = ' ';
					if (esnulo(cod_anp)) {
						cod_anp = ' ';
					} else {
						des_anp = $('#sel_anp option:selected').text();
					}
					
					if (cod_anp == "Seleccionar"){
						cod_anp = '';
					}
					var fil_busqueda = '';
					fil_busqueda = fil_busqueda + num_carta + '_';
					fil_busqueda = fil_busqueda + tip_operacion + '_';
					fil_busqueda = fil_busqueda + cod_uni_operativa + '_';
					fil_busqueda = fil_busqueda + cod_anp + '_';
					fil_busqueda = fil_busqueda + dteFecInicio + '_';
					fil_busqueda = fil_busqueda + dteFecFinal + '_';
					fil_busqueda = fil_busqueda + 1; // Indicador PDF
					$('#hid_fil_busqueda').val(fil_busqueda);
					
	                $("#frm_car_fianza").submit();
	                endAjax();
				});	
				
				$('#too_tables_imp_excel').click(function(e) {					
					e.preventDefault();
					
					var row = $('#tbl_financiero > tbody > tr').length;
					var empty = null;
					$('tr.odd').each(function() {		
						empty = $(this).find('.dataTables_empty').text();
						return false;
					});					
					if (!esnulo(empty) || row < 1) {
						addWarnMessage(null, 'No se encuentran registros para generar el reporte.');
						return;
					}
					
					startAjax();
					var num_carta = $('#txt_nro_carta').val();
					var tip_operacion = $('input[name="rb_tip_operacion"]:checked').val();				
					var dteFecInicio = $('#txt_mnt_busq_fec_inicio').val();
					var dteFecFinal = $('#txt_mnt_busq_fec_fin').val();
					var cod_uni_operativa = $('#sel_uni_operativa').val();  //volver
					var des_uni_operativa = ' ';
					if (!esnulo(cod_uni_operativa)) {
						des_uni_operativa = $('#sel_uni_operativa option:selected').text();
					}
					var cod_anp = $('#sel_anp').val();
					var des_anp = ' ';
					if (esnulo(cod_anp)) {
						cod_anp = ' ';
					} else {
						des_anp = $('#sel_anp option:selected').text();
					}
					if (cod_uni_operativa == "Seleccionar"){
						cod_uni_operativa = '';
					}
					if (cod_anp == "Seleccionar"){
						cod_anp = '';
					}
					var fil_busqueda = '';
					fil_busqueda = fil_busqueda + num_carta + '_';
					fil_busqueda = fil_busqueda + tip_operacion + '_';
					fil_busqueda = fil_busqueda + cod_uni_operativa + '_';
					fil_busqueda = fil_busqueda + cod_anp + '_';
					fil_busqueda = fil_busqueda + dteFecInicio + '_';
					fil_busqueda = fil_busqueda + dteFecFinal + '_';
					fil_busqueda = fil_busqueda + 2; // Indicador PDF
					$('#hid_fil_busqueda').val(fil_busqueda);
					
	                $("#frm_car_fianza").submit();
	                endAjax();
				});	
				
				
				
				$('#btn_grabar').click(function(e) {					
					e.preventDefault();
					var intIdfRegistro = 1;
					var srlIdFianza = $('#txt_mnt_codigo').val();
					var chrCodDocumento = $('#sel_mnt_tip_documento').val();
					var dteFecRecepcion =$('#txt_mnt_fec_present').val();  
					var dteFecCarta = $('#txt_mnt_fec_docu').val();
					var dteFecInicio = $('#txt_mnt_fec_inicio').val();
					var dteFecFinal = $('#txt_mnt_fec_fin').val();
					var dteFecDevolucion = $('#txt_mnt_fec_devolucion').val();
					var chrNomEstado = $('#sel_mnt_estados').val();
					var chrSigOficina = $('#txt_mnt_ofi	').val();
					var chrConcepto =$('#txt_mnt_concepto').val();
					var TTipoProveedor = $('#hid_proveedor').val();
					var TEntidadFinanciera = $('#sel_mnt_ent_financ').val();
					var legalidad = 'N';
					if ($('#chk_activo_legal').is(':checked')) {
						legalidad = 'S';
					}
					if($('#txt_mnt_mto_carta').val() == ''){
						var intImpCarta = '';
					}else{
						var intImpCarta = $('#txt_mnt_mto_carta').val();
						 num = intImpCarta.replace(",","");
					  	 num = num.replace(",","");
					  	 num = num.replace(",","");
					  	intImpCarta = num;
					}
					
					var chrNumCarta = $('#txt_mnt_nro_carta').val();           // numero de documento
					if ('${ind_sed_principal}' == '1') {
			        	var chrTipOperacion = '${ind_sed_principal}';
			        }else {
			        	var chrTipOperacion = $('input[name="rb_mnt_tip_operacion"]:checked').val();	
			        }
					
					var chrNumDocumento = $('#txt_mnt_num_documento').val();   // numero de documento de devolución
					var dteFecDocumento =  $('#txt_mnt_fec_documento').val();
					var chrNumFianza = $('#txt_mnt_num_fianza').val();        // numero de fianza
					var cod_uni_operativa	= $('#sel_mnt_uni_operativa').val();
					var cod_reg_nac = $('#sel_mnt_anp').val();
				/* 	var chrNumDocumento = $('#txt_mnt_Ruc').val(); */
			
					
			  	var msg = '';
			 
					if (esnulo(dteFecRecepcion)) {
						msg = msg + 'El campo "Fecha de Recepción" es obligatorio.<br/>';
					}
					if (esnulo(dteFecCarta)) {
						msg = msg + 'El campo "Fecha de Carta" es obligatorio.<br/>';
					}
					if (esnulo(dteFecInicio)) {
						msg = msg + 'El campo "Fecha de Inicio" es obligatorio.<br/>';
					}
					if (esnulo(dteFecFinal)) {
						msg = msg + 'El campo "Fecha de Fin" es obligatorio.<br/>';
					}
					if (esnulo(chrConcepto)) {
						msg = msg + 'El campo "Concepto" es obligatorio.<br/>';
					}
					if (esnulo(TEntidadFinanciera)) {
						msg = msg + 'El campo "Tipo Entidad Financiera" es obligatorio.<br/>';
					}
					if (esnulo(intImpCarta)) {
						msg = msg + 'El campo "Mto Carta " es obligatorio.<br/>';
					}
					if (esnulo(TTipoProveedor)) {
						msg = msg + 'El campo "Razon Social " es obligatorio.<br/>';
					}
					if (chrNomEstado == "Seleccionar") {
						msg = msg + 'El campo "Estado " es obligatorio.<br/>';
					}
					
					var chrNumCarta = $('#txt_mnt_nro_carta').val();
					var chrNumDocumento = $('#txt_mnt_num_documento').val();
					//var dteFecCarta = $('#txt_mnt_fech_documento').val();
					//var dteFecDocumento =  $('#txt_mnt_fech_documento').val();
					if (!esnulo(msg)) {
						showMessage(msg);
						return;
					}	 
					
					var new_record = true;
					if (!esnulo(srlIdFianza)) {
						new_record = false;
					}
													
					$.ajax({
						type: 'POST',
						url: VAR_CONTEXT + '/grabarCartaFianza',
						data: { 
							srlIdFianza : srlIdFianza,
							chrCodDocumento : chrCodDocumento,
							dteFecRecepcion	: dteFecRecepcion,
							dteFecInicio : dteFecInicio,
							dteFecFinal : dteFecFinal,
							dteFecDevolucion : dteFecDevolucion,
							chrSigOficina : chrSigOficina,
							chrConcepto : chrConcepto,
							TTipoProveedor : TTipoProveedor,
							TEntidadFinanciera : TEntidadFinanciera,
							intImpCarta : intImpCarta,
							chrNumCarta : chrNumCarta,
							intIdfRegistro : intIdfRegistro,
							dteFecCarta : dteFecCarta,
							chrNumDocumento : chrNumDocumento,
							dteFecDocumento : dteFecDocumento,
							chrTipOperacion : chrTipOperacion,
							cod_uni_operativa : cod_uni_operativa,
							cod_reg_nac    : cod_reg_nac,
							chrNumFianza  : chrNumFianza, 
							legalidad : legalidad,
							chrNomEstado : chrNomEstado
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
								$('#div_carta_fianza_modal').modal('hide');	
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
			
			$('#btn_eliminar').click(function(e) {					
				e.preventDefault();
				var intIdfRegistro = 2;
				var srlIdFianza = $('#txt_mnt_codigo').val();
			
				var new_record = true;
				if (!esnulo(srlIdFianza)) {
					new_record = false;
				}
												
				$.ajax({
					type: 'POST',
					url: VAR_CONTEXT + '/grabarCartaFianza',
					data: { 
						srlIdFianza : srlIdFianza,
						intIdfRegistro : intIdfRegistro
					},
						dataType: 'json',
						success: function(paramJson) {						
							if (paramJson != null) {
								endAjax();			
								if (new_record) {
									addInfoMessage(null, 'El registro fue grabado.');
								} else {
									addInfoMessage(null, 'Registro Eliminado.');
								}
								$('#div_carta_fianza_modal').modal('hide');	
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
			
			$('#txt_ruc_empresa').change(function() {
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
								$('#hid_buscar_empresa').val(paramJson.cod_proveedor);
								if (parseInt(nro_ruc.substring(0, 1)) == 1) {
									$('#txt_nom_empresa').val(trim(paramJson.nombres) + " " + trim(paramJson.ape_paterno) + " "+ trim(paramJson.ape_materno));
								}
								if (parseInt(nro_ruc.substring(0, 1)) == 2) {
									$('#txt_nom_empresa').val(paramJson.raz_social);
								}
								
							} else {
								$('#hid_buscar_empresa').val("");
								$('#txt_nom_empresa').val("");
								bootbox.dialog({
									message: "<span class='bigger-110'>El proveedor no existe </span>",
								 
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
			
			$('#txt_mnt_ruc_empresa').change(function() {
				 
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
								if (parseInt(nro_ruc.substring(0, 1)) == 1) {
									$('#txt_mnt_raz_social').val(trim(paramJson.nombres) + " " + trim(paramJson.ape_paterno) + " "+ trim(paramJson.ape_materno));
								}
								if (parseInt(nro_ruc.substring(0, 1)) == 2) {
									$('#txt_mnt_raz_social').val(paramJson.raz_social);
								}
								
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
													$('#txt_reg_raz_social').removeAttr("disabled");  
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
			});
						
			$('#btn_sal_proveedor').click(function(e) {
				e.preventDefault();
				$('#div_reg_proveedor').modal('hide');
			});
			
			$('#btn_gra_proveedor').click(function(e) {					
				e.preventDefault();
									
				var num_ruc = $('#txt_mnt_ruc_empresa').val();
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
							$('#hid_proveedor').val(paramJson);
							$('#txt_mnt_ruc_empresa').val(num_ruc);
							$('#txt_mnt_raz_social').val(raz_social);
							$('#div_reg_proveedor').modal('hide');
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
			 
			
						
			function search() {
			//	var href = '/listarCartaFianza';
			 	
				var params = {
						chrNumCarta		: $('#txt_nro_carta').val(),
						dteFecInicio 	: $('#txt_mnt_busq_fec_inicio').val(),
						dteFecFinal 	: $('#txt_mnt_busq_fec_fin').val(),
						chrTipOperacion : $('input[name="rb_tip_operacion"]:checked').val(),
						TTipoProveedor  : $('#hid_buscar_empresa').val(),
			      	  	cod_uni_operativa : $('#sel_uni_operativa').val(),
				  		cod_reg_nac : $('#sel_anp').val()
				};
		 		/*
				var fields = [
					'srlIdFianza', 
					'chrNumCarta' 
				];
				var layout = [ {
					title: 'Nro de Carta',
					field: fields,
					type: 'link',					
					label: '',
					method: 'editar',
				},{
					title: 'Numero de Fianza',
					field: 'chrNumFianza',
				},	{
					title: 'Fecha Inicio',
					field: 'dteFecInicio',
				}, {
					title: 'Fecha Fin',
					field: 'dteFecFinal',
				},{
					title: 'Monto',
					field: 'intImpCarta',
				},{
					title: 'Banco',
					field: 'nom_entidad',
				},{
					title: 'Dias Fin',
					field: 'can_dia_transcurridos',
				},{
					title: 'Nro de Doc y Fec.Dev',
					field: 'concatenado',
				},{	 
					title: 'Fec. Creación',
					field: 'dteFecCreacion',
				},{
					title: 'Fec. Modificación',
					field: 'dteFecModifica',
				}, {
					title: 'Usuario',
					field: 'chrCodUsuaCreacion',
				},{
					title: 'Usuario Modificación',
					field: 'chrCodUsuaModifica',
				}];
				var options = {
					containerTable: '.div_financiero',
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
				simpleGenerateDatatable(href, layout, options, null, null);
				
				*/
				
				
				var tbl_financiero = $('#tbl_financiero');
				
				$.ajax({
					type: 'GET',
					url: VAR_CONTEXT + '/listarCartaFianza',
					data: params,
					dataType: 'json',
					success: function(paramJson) {						
						if (paramJson.length > 0) {
							tbl_financiero.DataTable().destroy();
							tbl_financiero.dataTable({
								data: paramJson,
								columns: [
									{	
										data: 'chrNumCarta',
										render: function(data, type, row) {
											if (type === 'display') {
												return '<a onClick="editar(' + row.srlIdFianza + ')">' + row.chrNumCarta + '</a>';
											}
											return '';
										}
									}, {
										data: 'chrNumFianza'
									}, {
										data: 'dteFecInicio'
									}, {
										data: 'dteFecFinal'
									}, {
										data: 'intImpCarta'
									}, {
										data: 'nom_entidad'
									}, {
										data: 'can_dia_transcurridos',
										render: function(data, type, row) {
											if (type === 'display') {
												if (row.validacion == '1') {
													return '<font color="#FF0000">' + row.can_dia_transcurridos + '</font>';
												} else {
													return String(row.can_dia_transcurridos);
												}
											}
											return '';
										}
									}, {
										data: 'concatenado'
									}, {
										data: 'dteFecCreacion'
									}, {
										data: 'dteFecModifica'
									}, {
										data: 'chrCodUsuaCreacion'
									}, {
										data: 'chrCodUsuaModifica'
									}
								],
								"aoColumnDefs" : [ {
									'bSortable' : true,
									'aTargets' : [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11]
								} ],
								"language" : {
									"url" : VAR_CONTEXT + "/resources/js/Spanish.json"
								},	
								"aLengthMenu": [
												[15, 50, 100],
												[15, 50, 100]
											   ],
								"iDisplayLength": 15,
								"bFilter": false
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
		
			function editar(object) {				
				$("#btn_eliminar").attr("style", "display:display");
			 
				$.ajax({
					type: 'GET',
					url: '${pageContext.request.contextPath}/listarCartaFianza',
					data: {
						srlIdFianza : object
					},
					dataType: 'json',
					success: function(paramJson) {						
						if (paramJson[0] != null) {	
							$('#h_carta_fianza').html('Edicion de Carta Fianza');
							$('#form_carta_fianza').trigger("reset");
						      inicializarDatos();
						      $('#sel_mnt_uni_operativa').val(paramJson[0].cod_uni_operativa);
							  $('#sel_mnt_anp').val(paramJson[0].cod_reg_nac);
							  	setAnpBoleto(paramJson[0].cod_uni_operativa, paramJson[0].cod_reg_nac);
						  	  $('#sel_mnt_tip_documento').val(trim(paramJson[0].chrCodDocumento));
							  $('#txt_mnt_codigo').val(paramJson[0].srlIdFianza);
							  $('#txt_mnt_fec_present').val(paramJson[0].dteFecRecepcion);
							  $('#txt_mnt_fec_inicio').val(paramJson[0].dteFecInicio);
							  $('#txt_mnt_fec_fin').val(paramJson[0].dteFecFinal);
							  $('#txt_mnt_fec_devolucion').val(paramJson[0].dteFecDevolucion);
						 	  $('#sel_mnt_estados').val(paramJson[0].chrNomEstado);
							  $('#txt_mnt_concepto').val(paramJson[0].chrConcepto);
							  $('#txt_mnt_ofi').val(paramJson[0].chrSigOficina);
							  $('#hid_proveedor').val(paramJson[0].ttipoProveedor);
							  $('#txt_mnt_ruc_empresa').val(paramJson[0].numRuc);
							  $('#txt_mnt_num_fianza').val(paramJson[0].chrNumFianza);   
							 
							  if (paramJson[0].legalidad = 'S') {
									$('#chk_activo_legal').attr('checked', true);
								}
							  var nro_ruc = $('#txt_mnt_ruc_empresa').val();
							  
							  $.ajax({
									type: 'GET',
									url: '${pageContext.request.contextPath}/verificarRuc',
									data: {
										nro_ruc : nro_ruc
									},
									dataType: 'json',
									success: function(paramJson) {						
										if (paramJson.num_ruc != null) {				
											
											if (parseInt(nro_ruc.substring(0, 1)) == 1) {
												$('#txt_mnt_raz_social').val(trim(paramJson.nombres) + " " + trim(paramJson.ape_paterno) + " "+ trim(paramJson.ape_materno));
											}
											if (parseInt(nro_ruc.substring(0, 1)) == 2) {
												$('#txt_mnt_raz_social').val(paramJson.raz_social);
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
			 					
							  $('#txt_mnt_raz_social').val(paramJson[0].Razonsocial);
							  $('#sel_mnt_ent_financ').val(paramJson[0].tentidadFinanciera);
							  $('#txt_mnt_mto_carta').val(paramJson[0].intImpCarta);
							  format()
							  $('#txt_mnt_nro_carta').val(trim(paramJson[0].chrNumCarta));
							  
							  $('#txt_mnt_num_documento').val(trim(paramJson[0].chrNumDocumento));
							  $('#txt_mnt_fec_docu').val(paramJson[0].dteFecCarta);
							  $('#txt_mnt_fec_documento').val(paramJson[0].dteFecDocumento);
							  
							$('#txt_fec_creacion').val(paramJson[0].dteFecCreacion);
							$('#txt_fec_modificacion').val(paramJson[0].dteFecModifica);
							$('#txt_creacion').val(paramJson[0].chrCodUsuaCreacion);
							$('#txt_modificado').val(paramJson[0].chrCodUsuaModifica);
							$('#div_carta_fianza_modal').modal('show');
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
	 				params['ind_uni_operativa'] = 1;
	 				params['cod_uni_operativa'] = cod_uni_operativa;
	 				simpleCboAjaxPopulateParam('#sel_anp', ['cod_reg_nac', 'des_reg_nac'], '/listarUnidadOperativa', params, true, false);
				}
			}
			function obtenermntAnp(cod_uni_operativa) {
				if (cod_uni_operativa == 'Seleccionar') {
					$('#sel_mnt_anp').empty();
					$("#sel_mnt_anp").append($("<option></option>").html("Seleccionar"));
				}else {
				var params = new Object();
 				params['ind_uni_operativa'] = 1;
 				params['cod_uni_operativa'] = cod_uni_operativa;
 				simpleCboAjaxPopulateParam('#sel_mnt_anp', ['cod_reg_nac', 'des_reg_nac'], '/listarUnidadOperativa', params, true, false);
				}
			}
			
			function inicializarDatos() {
				if ('${ind_sed_principal}' == '1') { // Usuario de Sede Central						
					$('input[name=rb_tip_operacion][value="1"]').prop('checked', true);
					$('input[name=rb_mnt_tip_operacion][value="1"]').prop('checked', true);
					$('input[name=rb_tip_operacion]').prop('disabled', true);
					$('input[name=rb_mnt_tip_operacion]').prop('disabled', true);
				} else {
					$('input[name=rb_tip_operacion][value="2"]').prop('checked', true);
					$('input[name=rb_mnt_tip_operacion][value="2"]').prop('checked', true);
					$('input[name=rb_tip_operacion]').prop('disabled', true);
					$('input[name=rb_mnt_tip_operacion]').prop('disabled', true);
					
				}
				
			}
		 
			 function format()
			 {
				 var num1 = "";
			  	 var num =  $('#txt_mnt_mto_carta').val();
			  	 num = num.replace(",","");
			  	 num = num.replace(",","");
			  	 num = num.replace(",","");
			  	 num = num.replace(",","");
			  	 
			  	if(num.indexOf('.') != -1){
		     	 num1 = num.substring(num.indexOf('.'),num.indexOf('.')+3);
			     num =	num.substring(0,num.indexOf('.'));
			  	}
				 num = num.toString().split('').reverse().join('').replace(/(?=\d*\.?)(\d{3})/g,'$1,');
				 num = num.split('').reverse().join('').replace(/^[\.]/,'');
				 
				 if (num.substring(0, 1) == ','){
					 num = num.substring(1,num.length);
				 }
					num = num +num1;
				 
				  $('#txt_mnt_mto_carta').val(num);
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
