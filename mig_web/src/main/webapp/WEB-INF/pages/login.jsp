<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta charset="utf-8" />
		<title>Login Page - Sanipes Admin</title>

		<meta name="description" content="User login page" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

		<!-- bootstrap & fontawesome -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/font-awesome.css" />

		<!-- text fonts -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/ace-fonts.css" />

		<!-- ace styles -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/ace.css" />

		<!--[if lte IE 9]>
			<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/ace-part2.css" />
		<![endif]-->
		
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/ace-rtl.css" />
		
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/general.css" />

		<!--[if lte IE 9]>
		  	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/ace-ie.css" />
		<![endif]-->

		<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->

		<!--[if lt IE 9]>
			<script src="${pageContext.request.contextPath}/resources/js/html5shiv.js"></script>
			<script src="${pageContext.request.contextPath}/resources/js/respond.js"></script>
		<![endif]-->
		
		<!--[if !IE]> -->
			<script type="text/javascript">
				window.jQuery || document.write("<script src='${pageContext.request.contextPath}/resources/js/jquery.js'>"+"<"+"/script>");
			</script>
		<!-- <![endif]-->

		<!--[if IE]>
			<script type="text/javascript">
			 window.jQuery || document.write("<script src='${pageContext.request.contextPath}/resources/js/jquery1x.js'>"+"<"+"/script>");
			</script>
		<![endif]-->
		
		<script src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>
		<script src="${pageContext.request.contextPath}/resources/js/bootbox.js"></script>
		
		<script type="text/javascript">
			$(document).ready(function() {
				
				if('ontouchstart' in document.documentElement) { 
					document.write("<script src='${pageContext.request.contextPath}/resources/js/jquery.mobile.custom.js'>"+"<"+"/script>");
				}

				$('#btn_open_login').click(function(e) {
					e.preventDefault();
					$('#div_mod_login').modal('show');
				});	
				
				$('#btn_login').click(function(e) {					
					e.preventDefault();
				/*	var msg = null;
					$.ajax({
						type: 'POST',
						url: '${pageContext.request.contextPath}/login/auth',
						data: {
							username: $('#txt_username').val(), 
							password: $('#txt_password').val()
						},
						dataType: 'json',
						success: function(data) {						
							if (data != null) {
								var rpta = data.sicodestado;
								if (rpta == 0) {
									msg = 'Acceso denegado:<br/>';
									msg = msg + 'Cuenta no existe.';
									showMessage(msg);
								} else if (rpta == 1) {
									var url = '${pageContext.request.contextPath}/page/principal';
									$(location).attr('href', url);
								} else if (rpta == 2) {
									msg = 'Acceso denegado:<br/>';
									msg = msg + 'Contraseña no es correcta';
									showMessage(msg);
								}
								
								
								var url = '${pageContext.request.contextPath}/page/principal';
								$(location).attr('href', url);
								
							}	
						},
						error: function(jqXHR, error, errorThrown) {
							msg = 'Error:<br/>';
							if (jqXHR.status && jqXHR.status == 400) {
								msg = msg + jqXHR.responseText;
								showMessage(msg);
							} else {
								msg = msg + errorThrown;
								showMessage(msg);
							}
						}
					});*/
					
					var url = '${pageContext.request.contextPath}/page/principal';
					$(location).attr('href', url);
					
				});
			});
			
			function showMessage(msg) {
				bootbox.dialog({
					message: "<span class='bigger-110'><b>" + msg + "</b></span>",
					buttons: {
						cancel: {
							label: 'Cerrar',
							className: 'btn-sm btn-danger'
						}
					}
				});
			}
				
		</script>

	</head>

	<body>
		<div class="main-container">
		
			<div class="main-content">
				<div class="row">
					<div class="col-xs-2"></div>
					<div class="col-xs-4">
						<img src="${pageContext.request.contextPath}/resources/images/logo_sanipes1.png" class="img-responsive">
					</div>
					<div class="col-xs-4">
						<img src="${pageContext.request.contextPath}/resources/images/logo_sanipes.png" class="img-responsive">
					</div>
					<div class="col-xs-2"></div>
				</div><!-- /.row -->
				<div class="row">
					<div class="col-xs-12">
						<div class="form-group">
							<div class="col-sm-9">
							</div>
							<div class="col-sm-3">
								<button id="btn_open_login" class="btn btn-sm btn-success" type="button">
									<i class="ace-icon fa fa-key bigger-110"></i>
									Login
								</button>
							</div>
						</div>
					</div>
				</div><!-- /.row -->
				<div class="row">
					<div class="col-xs-2"></div>
					<div class="col-xs-8">
						<img src="${pageContext.request.contextPath}/resources/images/fondo.png" class="img-responsive">
					</div>
					<div class="col-xs-2">						
					</div>
				</div><!-- /.row -->
			</div><!-- /.main-content -->
			
			<div id="div_mod_login" class="modal fade" tabindex="-1" data-keyboard="false" data-backdrop="static">
				<div class="modal-dialog modal-sm">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">&times;</button>
							<h6 class="bolder white">Acceso a Usuarios Registrados:</h6>
						</div>
						<div class="modal-body">
							<div class="row">
								<div class="col-xs-12">
									<div class="form-group">									
										<label class="col-sm-4 control-label">Usuario:</label>											
										<div class="col-sm-8">
											<label class="block clearfix">
												<span class="block input-icon input-icon-right">
													<input id="txt_username" type="text" class="form-control" />
													<i class="ace-icon fa fa-user"></i>
												</span>
											</label>
										</div>
									</div>
									<div class="form-group">									
										<label class="col-sm-4 control-label">Contraseña:</label>											
										<div class="col-sm-8">
											<label class="block clearfix">
												<span class="block input-icon input-icon-right">
													<input id="txt_password" type="password" class="form-control" />
													<i class="ace-icon fa fa-lock"></i>
												</span>
											</label>
										</div>
									</div>
								</div>															
							</div>
							<div class="space"></div>
							<div class="clearfix">				
								<button id="btn_login" type="button" class="width-35 pull-right btn btn-sm btn-primary">
									<i class="ace-icon fa fa-key"></i>
									<span class="bigger-110">Login</span>
								</button>
							</div>
						</div>
					</div>
				</div>
			</div>	
			
		</div><!-- /.main-container -->
	</body>
</html>