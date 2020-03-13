
<!-- #section:basics/navbar.layout -->
<div id="navbar" class="navbar navbar-default navbar-collapse h-navbar" style="background-color:#FABB37">
	<script type="text/javascript">
		try { 
			ace.settings.check('navbar' , 'fixed');
			var VAR_CONTEXT = '${pageContext.request.contextPath}';
			// Si la session se encuentra inactiva
			if ('${usuarioBean}' == null || '${usuarioBean}' == '') {
				if (confirm('Su session se encuentra inactiva, inicie nuevamente !!!')) {
					window.location.href = '${pageContext.request.contextPath}/login/close';
				} else {
					window.location.href = '${pageContext.request.contextPath}/login/close';
				}
			}			
		} catch(e) {}
	</script>
	
	<div style="background-color:white;">
		<img src="${pageContext.request.contextPath}/resources/images/logo_sernanp.jpg" class="img-responsive">
	</div>

	<div class="navbar-container" id="navbar-container">
	
		<!-- #section:basics/sidebar.mobile.toggle -->
		<button type="button" class="navbar-toggle menu-toggler pull-left" id="menu-toggler" data-target="#sidebar">
			<span class="sr-only">Toggle sidebar</span>

			<span class="icon-bar"></span>

			<span class="icon-bar"></span>

			<span class="icon-bar"></span>
		</button>

		<!-- /section:basics/sidebar.mobile.toggle -->
		<div class="navbar-header pull-left">
			<!-- #section:basics/navbar.layout.brand -->
			<a href="#" class="navbar-brand">
				<small>
					<i class="fa fa-leaf"></i>
					SISTEMA INTEGRADO
				</small>
			</a>

			<!-- /section:basics/navbar.layout.brand -->

			<!-- #section:basics/navbar.toggle -->

			<!-- /section:basics/navbar.toggle -->
		</div>
		
		<!-- #section:basics/navbar.dropdown -->
		<div class="navbar-buttons navbar-header pull-right  collapse navbar-collapse" role="navigation">
			<ul class="nav ace-nav">

				<li class="li-user">
					Usuario: ${usuarioBean.des_usuario}
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					Oficina: ${usuarioBean.des_area}		
				</li>
			
				<!-- #section:basics/navbar.user_menu -->
				<li class="light-blue user-min">
					<a href="${pageContext.request.contextPath}/login/close">
						<i class="ace-icon fa fa-power-off"></i>
						Cerrar Sesión
					</a>
				</li>
				
			</ul>
		</div>

		<!-- /section:basics/navbar.dropdown -->
	</div><!-- /.navbar-container -->
</div>