<script type="text/javascript">
	try { 
		ace.settings.check('main-container', 'fixed') 
	} catch(e) { }
</script>

<!-- #section:basics/sidebar.horizontal -->
<div id="sidebar" class="sidebar responsive">

	<ul class="nav nav-list">
		<c:if test="${not empty lis_pri_modulo}" >
			<c:forEach items="${lis_pri_modulo}" var="pri">
				<li id="${pri.nom_cor_modulo}">
					<a href="#" class="dropdown-toggle">
						<i class="menu-icon ${pri.img_modulo}"></i>
						<span class="menu-text">${pri.nom_modulo}</span>
						<b class="arrow fa fa-angle-down"></b>
					</a>
					<b class="arrow"></b>					
					<ul class="submenu">
						<c:forEach items="${lis_seg_modulo}" var="seg">
							<c:if test="${seg.niv_dep_modulo == pri.cod_modulo}">
								<li id="${seg.nom_cor_modulo}">
									<a href="${pageContext.request.contextPath}${seg.hre_modulo}">
										<i class="menu-icon fa fa-caret-right"></i>
										${seg.nom_modulo}
									</a>
									<b class="arrow"></b>							
								</li>
							</c:if>
						</c:forEach>
					</ul>
				</li>				
			</c:forEach>
		</c:if>
	</ul><!-- /.nav-list -->
	
	<!-- #section:basics/sidebar.layout.minimize -->
	<div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
		<i class="ace-icon fa fa-angle-double-left" data-icon1="ace-icon fa fa-angle-double-left" data-icon2="ace-icon fa fa-angle-double-right"></i>
	</div>

	<!-- /section:basics/sidebar.layout.minimize -->
	<script type="text/javascript">
		try { 
			ace.settings.check('sidebar' , 'collapsed') 
		} catch(e) { }
	</script>
	
</div>