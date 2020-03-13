package pe.com.mig.dao.impl;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.com.mig.dao.IUsuarioDao;
import pe.com.mig.model.bean.sernanp.ModuloBean;
import pe.com.mig.model.bean.sernanp.PerfilBean;
import pe.com.mig.model.bean.sernanp.UsuarioBean;
import pe.com.mig.model.entity.sernanp.Modulo;
import pe.com.mig.model.entity.sernanp.Rol;
import pe.com.mig.model.entity.sernanp.RolModulo;
import pe.com.mig.model.entity.sernanp.RolModuloPK;
import pe.com.mig.model.entity.sernanp.Sistema;
import pe.com.mig.model.entity.sernanp.UsuarioRol;
import pe.com.mig.model.entity.sernanp.UsuarioRolPK;
import pe.com.mig.util.Constantes;

/**
 * @className: UsuarioDaoImpl.java
 * @description: 
 * @date: 17 de jun. de 2016
 * @author: SUMERIO.
 */
@Repository
public class UsuarioDaoImpl extends GenericDaoImpl implements IUsuarioDao {

	private static final long serialVersionUID = 1L;

	/* (non-Javadoc)
	 * @see pe.com.mig.dao.IUsuarioDao#obtenerDatosUsuario(java.lang.String)
	 */
	@Transactional(readOnly = true)
	@Override
	public UsuarioBean obtenerDatosUsuario(String clave) throws Exception {
		try {
			StringBuilder hql = new StringBuilder();			
			hql.append("select lg.idlogin as cod_login, us.idusuario as cod_usuario, ");
			hql.append("us.usuario as des_usuario, ar.idarea as cod_area, ");
			hql.append("ar.codarea as vcod_area, ar.desarea as des_area, ");
			hql.append("rl.idrol as cod_rol, rl.desrol as des_rol ");
			hql.append("from Login lg ");
			hql.append("inner join lg.usuario us ");
			hql.append("inner join us.areaorganica ar, ");			
			hql.append("UsuarioRol ur, ");
			hql.append("Rol rl ");
			hql.append("where md5(lg.clave) = :clave ");
			hql.append("and ur.usuarioRolPK.idusuario = us.idusuario ");
			hql.append("and ur.usuarioRolPK.idrol = rl.idrol ");
			hql.append("and rl.idrol in ");
			hql.append("(select roln.idrol ");
			hql.append("from Rol roln ");
			hql.append("inner join roln.sistema sisn, ");
			hql.append("RolModulo rmon, ");
			hql.append("Modulo modn ");
			hql.append("where roln.idrol = rmon.rolModuloPK.idrol ");
			hql.append("and rmon.rolModuloPK.idmodulo = modn.idmodulo ");
			hql.append("and sisn.idsistema = :cod_sistema ");
			hql.append("and modn.nombrecortomodulo = :cod_mod_mig ");
			hql.append("and roln.flagrol = :fla_rol) ");
			Query query = super.getSession().createQuery(hql.toString());
			query.setParameter("clave", clave);
			query.setParameter("cod_sistema", Constantes.CODIGO_SISTEMA_MIG);
			query.setParameter("cod_mod_mig", Constantes.CODIGO_MODULO_MIG);
			query.setParameter("fla_rol", Constantes.CODIGO_ROL_ACTIVO);			
			query.setMaxResults(Constantes.ONE_INT);
			return (UsuarioBean)query.setResultTransformer(Transformers.aliasToBean(UsuarioBean.class)).uniqueResult();		
		} catch (Exception e) {
			throw new Exception(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(), 
								Constantes.NIVEL_APP_DAO, 
								this.getClass().getName(), e.getMessage()));
		}
	}

	/* (non-Javadoc)
	 * @see pe.com.mig.dao.IUsuarioDao#listarPerfiles(pe.com.mig.model.bean.sernanp.PerfilBean)
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<PerfilBean> listarPerfiles(PerfilBean perfil) throws Exception {
		try {
			StringBuilder hql = new StringBuilder();			
			hql.append("select rol.idrol as cod_rol, rol.desrol as des_rol, ");
			hql.append("rol.flagrol as fla_rol, ");
			hql.append("mod.nombremodulo as nom_modulo, sis.dessistema as des_sistema ");
			hql.append("from Rol rol ");
			hql.append("inner join rol.sistema sis, ");
			hql.append("RolModulo rmo, ");
			hql.append("Modulo mod ");
			hql.append("where rol.idrol = rmo.rolModuloPK.idrol ");
			hql.append("and rmo.rolModuloPK.idmodulo = mod.idmodulo ");
			hql.append("and sis.idsistema = :cod_sistema ");
			hql.append("and mod.nombrecortomodulo = :cod_mod_mig ");
			hql.append("and rol.flagrol = :fla_rol ");
			if (!isNullInteger(perfil.getCod_rol())) {
				hql.append("and rol.idrol = :cod_rol ");
			}
			if (!isNullOrEmpty(perfil.getDes_rol())) {
				hql.append("and upper(rol.desrol) like :des_rol ");
			}			
			hql.append("order by rol.desrol");
			Query query = super.getSession().createQuery(hql.toString());
			query.setParameter("cod_sistema", Constantes.CODIGO_SISTEMA_MIG);
			query.setParameter("cod_mod_mig", Constantes.CODIGO_MODULO_MIG);
			query.setParameter("fla_rol", perfil.getFla_rol());
			if (!isNullInteger(perfil.getCod_rol())) {
				query.setParameter("cod_rol", perfil.getCod_rol());
			}
			if (!isNullOrEmpty(perfil.getDes_rol())) {
				query.setParameter("des_rol", Constantes.PORCENTAJE+perfil.getDes_rol()+Constantes.PORCENTAJE);
			}
			return query.setResultTransformer(Transformers.aliasToBean(PerfilBean.class)).list();		
		} catch (Exception e) {
			throw new Exception(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(), 
								Constantes.NIVEL_APP_DAO, 
								this.getClass().getName(), e.getMessage()));
		}
	}

	/* (non-Javadoc)
	 * @see pe.com.mig.dao.IUsuarioDao#grabarPerfil(pe.com.mig.model.bean.sernanp.PerfilBean)
	 */
	@Transactional
	@Override
	public void grabarPerfil(PerfilBean perfil) throws Exception {
		try {
			Rol rol = null;
			Integer cod_rol = perfil.getCod_rol();
			if (!isNullInteger(cod_rol)) {
				rol = (Rol) getById(Rol.class, cod_rol);
				rol.setDesrol(perfil.getDes_rol());
				rol.setFlagrol(perfil.getFla_rol());
				
				grabarRolModulo(cod_rol, null, false);
			} else {
				rol = new Rol(); 
				rol.setDesrol(perfil.getDes_rol());	
				rol.setFlagrol(perfil.getFla_rol());
				rol.setSistema(new Sistema(Constantes.CODIGO_SISTEMA_MIG));
				cod_rol = getByIdSave(rol);

				Modulo modulo = (Modulo) getByProperty(Modulo.class.getName(), 
													   Constantes.TABLA_NOMBRE_MODULO, 
													   Constantes.NOMBRE_MODULO);
				RolModulo rolmodulo = new RolModulo();
				rolmodulo.setRolModuloPK(new RolModuloPK(cod_rol, modulo.getIdmodulo()));
				rolmodulo.setPesorol(Constantes.ONE_INT);
				rolmodulo.setFlagmodulodefault(Constantes.ESTADO_ACTIVO);
				save(rolmodulo);
				
				grabarRolModulo(cod_rol, perfil.getCod_rol_act(), true);
			}
			
			List<Integer> lis_cod_menu = new ArrayList<Integer>();
			String arr_menu[] = perfil.getDet_menu().split("\\|", -1);
			// Recorro todos los elementos
			for (String item : arr_menu) {
				// Saco el valor de cada elemento
				String[] arr_det_menu = item.split("_");
				int lon_det_menu = arr_det_menu.length;
				// Almacenamos los codigo de menu asociado
				if (lon_det_menu == 1) { // primer nivel
					lis_cod_menu.add(getInteger(arr_det_menu[0]));
				} else if (lon_det_menu == 2) { // segundo nivel
					lis_cod_menu.add(getInteger(arr_det_menu[0]));	
					lis_cod_menu.add(getInteger(arr_det_menu[1]));
				}
			}		
			// Removemos codigos duplicados
			Set<Integer> set_cod_menu = new LinkedHashSet<Integer>(lis_cod_menu);
			lis_cod_menu.clear();
			lis_cod_menu.addAll(set_cod_menu);
			
			ModuloBean seg_modulo = new ModuloBean();
			seg_modulo.setCod_rol(cod_rol);
			List<ModuloBean> lis_seg_modulo = listarModulo(seg_modulo);
			
			// Actualizamos el estado activo a las opciones del menu marcados
			for (ModuloBean seg : lis_seg_modulo) {
				for (Integer codigo : lis_cod_menu) {
					if (codigo.equals(seg.getCod_modulo())) {
						StringBuilder hql = new StringBuilder();
						hql.append("update RolModulo ");
						hql.append("set flagmodulodefault = :fla_rol_mod ");
						hql.append("where rolModuloPK.idrol = :cod_rol ");
						hql.append("and rolModuloPK.idmodulo = :cod_modulo ");
						Query query = super.getSession().createQuery(hql.toString());
						query.setParameter("fla_rol_mod", Constantes.ESTADO_ACTIVO);
						query.setParameter("cod_rol", cod_rol);
						query.setParameter("cod_modulo", codigo);
						query.executeUpdate();
					}
				}
			}			
			
		} catch (Exception e) {
			throw new Exception(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(), 
								Constantes.NIVEL_APP_DAO, 
								this.getClass().getName(), e.getMessage()));
		}
	}

	/* (non-Javadoc)
	 * @see pe.com.mig.dao.IUsuarioDao#listarUsuarios(pe.com.mig.model.bean.sernanp.UsuarioBean)
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<UsuarioBean> listarUsuarios(UsuarioBean usuario) throws Exception {
		try {
			StringBuilder hql = new StringBuilder();
			if (!isNullInteger(usuario.getInd_per_mig())) {
				hql.append("select distinct usu.idusuario as cod_usuario, ");
				hql.append("usu.usuario as des_usuario, pen.nombre as nombres, ");
				hql.append("concat(upper(pen.apepat), ' ', upper(pen.apemat)) as apellidos, ");
				hql.append("usu.estado as cod_estado ");
				hql.append("from Usuario usu ");
				hql.append("inner join usu.areaorganica are, ");
				hql.append("Rol rol ");
				hql.append("inner join rol.sistema sis, ");
				hql.append("Personanatural pen ");
				hql.append("inner join pen.persona per ");
				hql.append("where usu.idpersona = per.idpersona ");
			} else {			
				hql.append("select usu.idusuario as cod_usuario, ");				
				hql.append("usu.usuario as des_usuario, rol.idrol as cod_rol, ");
				hql.append("rol.desrol as des_rol, pen.nombre as nombres, ");
				hql.append("concat(upper(pen.apepat), ' ', upper(pen.apemat)) as apellidos, ");
				hql.append("are.idarea as cod_area, are.desarea as des_area, ");
				hql.append("usu.estado as cod_estado ");
				hql.append("from Usuario usu ");
				hql.append("inner join usu.areaorganica are, ");
				hql.append("UsuarioRol usr, ");
				hql.append("Rol rol ");
				hql.append("inner join rol.sistema sis, ");		
				hql.append("Personanatural pen ");
				hql.append("inner join pen.persona per ");
				hql.append("where usu.idusuario = usr.usuarioRolPK.idusuario ");
				hql.append("and usr.usuarioRolPK.idrol = rol.idrol ");
				hql.append("and usu.idpersona = per.idpersona ");
			}			
			if (!isNullInteger(usuario.getInd_per_mig())) {
				hql.append("and sis.idsistema != :cod_sistema ");
				hql.append("and usu.idusuario not in "); 
				hql.append("(select distinct usun.idusuario ");
				hql.append("from Usuario usun ");
				hql.append("inner join usun.areaorganica aren, ");
				hql.append("UsuarioRol usrn, ");
				hql.append("Rol roln ");
				hql.append("inner join roln.sistema sisn, ");		
				hql.append("Personanatural penn ");
				hql.append("inner join penn.persona pern ");
				hql.append("where usun.idusuario = usrn.usuarioRolPK.idusuario ");
				hql.append("and usrn.usuarioRolPK.idrol = roln.idrol ");
				hql.append("and usun.idpersona = pern.idpersona ");
				hql.append("and sisn.idsistema = :cod_sistema) ");				
			} else {
				hql.append("and sis.idsistema = :cod_sistema ");
			}			
			if (!isNullInteger(usuario.getCod_rol())) {
				hql.append("and rol.idrol = :cod_rol ");
			}
			if (!isNullInteger(usuario.getCod_usuario())) {
				hql.append("and usu.idusuario = :cod_usuario ");
			}
			if (!isNullOrEmpty(usuario.getDes_usuario())) {
				hql.append("and upper(usu.usuario) like :des_usuario ");
			}
			if (!isNullOrEmpty(usuario.getNombres())) {
				hql.append("and upper(pen.nombre) like :nombres ");
			}
			if (!isNullOrEmpty(usuario.getApellidos())) {
				hql.append("and concat(upper(pen.apepat), ' ', upper(pen.apemat)) like :apellidos ");
			}
			hql.append("and usu.estado = :cod_estado ");
			hql.append("order by usu.usuario");
			Query query = super.getSession().createQuery(hql.toString());
			query.setParameter("cod_sistema", Constantes.CODIGO_SISTEMA_MIG);
			if (!isNullInteger(usuario.getCod_rol())) {
				query.setParameter("cod_rol", usuario.getCod_rol());
			}
			if (!isNullInteger(usuario.getCod_usuario())) {
				query.setParameter("cod_usuario", usuario.getCod_usuario());
			}
			if (!isNullOrEmpty(usuario.getDes_usuario())) {
				query.setParameter("des_usuario", Constantes.PORCENTAJE+usuario.getDes_usuario()+Constantes.PORCENTAJE);
			}
			if (!isNullOrEmpty(usuario.getNombres())) {
				query.setParameter("nombres", Constantes.PORCENTAJE+usuario.getNombres()+Constantes.PORCENTAJE);
			}
			if (!isNullOrEmpty(usuario.getApellidos())) {
				query.setParameter("apellidos", Constantes.PORCENTAJE+usuario.getApellidos()+Constantes.PORCENTAJE);
			}
			query.setParameter("cod_estado", usuario.getCod_estado());
			return query.setResultTransformer(Transformers.aliasToBean(UsuarioBean.class)).list();		
		} catch (Exception e) {
			throw new Exception(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(), 
								Constantes.NIVEL_APP_DAO,
								this.getClass().getName(), e.getMessage()));
		}
	}

	/* (non-Javadoc)
	 * @see pe.com.mig.dao.IUsuarioDao#grabarUsuario(pe.com.mig.model.bean.sernanp.UsuarioBean)
	 */
	@Transactional
	@Override
	public void grabarUsuario(UsuarioBean usuario) throws Exception {
		try {
			if (!isNullInteger(usuario.getInd_per_mig())) {
				StringBuilder hql1 = new StringBuilder();
				hql1.append("update UsuarioRol ");
				hql1.append("set usuarioRolPK.idrol = :cod_rol_nue ");
				hql1.append("where usuarioRolPK.idusuario = :cod_usuario ");
				hql1.append("and usuarioRolPK.idrol = :cod_rol_ant ");
				Query query1 = super.getSession().createQuery(hql1.toString());
				query1.setParameter("cod_rol_nue", usuario.getCod_rol());
				query1.setParameter("cod_usuario", usuario.getCod_usuario());
				query1.setParameter("cod_rol_ant", usuario.getInd_per_mig());
				query1.executeUpdate();
			} else {
				UsuarioRol usuariorol = new UsuarioRol(); 
				UsuarioRolPK usuariorolpk = new UsuarioRolPK();
				usuariorolpk.setIdusuario(usuario.getCod_usuario());
				usuariorolpk.setIdrol(usuario.getCod_rol());
				usuariorol.setUsuarioRolPK(usuariorolpk);
				save(usuariorol);
			}
			StringBuilder hql2 = new StringBuilder();
			hql2.append("update Usuario ");
			hql2.append("set estado = :cod_estado ");
			hql2.append("where idusuario = :cod_usuario ");
			Query query2 = super.getSession().createQuery(hql2.toString());
			query2.setParameter("cod_estado", usuario.getCod_estado());
			query2.setParameter("cod_usuario", usuario.getCod_usuario());
			query2.executeUpdate();
		} catch (Exception e) {
			throw new Exception(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(), 
								Constantes.NIVEL_APP_DAO, 
								this.getClass().getName(), e.getMessage()));
		}
	}

	/* (non-Javadoc)
	 * @see pe.com.mig.dao.IUsuarioDao#listarModulo(pe.com.mig.model.bean.sernanp.ModuloBean)
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<ModuloBean> listarModulo(ModuloBean modulo) throws Exception {
		try {
			StringBuilder hql = new StringBuilder();			
			hql.append("select mod.idmodulo as cod_modulo, mod.nombremodulo as nom_modulo, ");
			hql.append("mod.nombrecortomodulo as nom_cor_modulo, mod.imgmodulo as img_modulo, ");
			hql.append("mod.nivelmodulo as niv_modulo, mod.niveldependemodulo as niv_dep_modulo, ");
			hql.append("mod.ordenmodulo as ord_modulo, mod.flagmodulo as fla_modulo, ");
			hql.append("mod.hrefmodulo as hre_modulo, mod.titlemodulo as tit_modulo ");
			hql.append("from Rol rol ");
			hql.append("inner join rol.sistema sis, ");
			hql.append("RolModulo rmo, ");
			hql.append("Modulo mod ");
			hql.append("where rol.idrol = rmo.rolModuloPK.idrol ");
			hql.append("and rmo.rolModuloPK.idmodulo = mod.idmodulo ");
			hql.append("and sis.idsistema = :cod_sistema ");
			hql.append("and mod.nombrecortomodulo != :cod_mod_mig ");
			hql.append("and mod.flagmodulo = :fla_modulo ");
			hql.append("and rol.idrol = :cod_rol ");
			if (!isNullInteger(modulo.getNiv_dep_modulo())) {
				hql.append("and mod.niveldependemodulo = :niv_dep_modulo ");
			}
			if (!isNullInteger(modulo.getNiv_modulo())) {
				hql.append("and mod.nivelmodulo = :niv_modulo ");
			}
			if (!isNullInteger(modulo.getFla_rol_mod())) {
				hql.append("and rmo.flagmodulodefault = :fla_rol_mod ");
			}
			hql.append("order by mod.idmodulo");
			Query query = super.getSession().createQuery(hql.toString());
			query.setParameter("cod_sistema", Constantes.CODIGO_SISTEMA_MIG);
			query.setParameter("cod_mod_mig", Constantes.CODIGO_MODULO_MIG);
			query.setParameter("fla_modulo", Constantes.ESTADO_ACTIVO);
			query.setParameter("cod_rol", modulo.getCod_rol());
			if (!isNullInteger(modulo.getNiv_dep_modulo())) {
				query.setParameter("niv_dep_modulo", modulo.getNiv_dep_modulo());
			}
			if (!isNullInteger(modulo.getNiv_modulo())) {
				query.setParameter("niv_modulo", modulo.getNiv_modulo());
			}
			if (!isNullInteger(modulo.getFla_rol_mod())) {
				query.setParameter("fla_rol_mod", modulo.getFla_rol_mod());
			}
			return query.setResultTransformer(Transformers.aliasToBean(ModuloBean.class)).list();		
		} catch (Exception e) {
			throw new Exception(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(), 
								Constantes.NIVEL_APP_DAO, 
								this.getClass().getName(), e.getMessage()));
		}
	}

	/* (non-Javadoc)
	 * @see pe.com.mig.dao.IUsuarioDao#grabarRolModulo(java.lang.Integer, java.lang.Integer, boolean)
	 */
	@Transactional
	@Override
	public void grabarRolModulo(Integer cod_rol, Integer cod_rol_act, boolean indicador) throws Exception {
		try {
			if (indicador) {			
				ModuloBean pri_modulo = new ModuloBean();
				pri_modulo.setCod_rol(cod_rol_act);
				List<ModuloBean> lis_pri_modulo = listarModulo(pri_modulo);
				for (ModuloBean pri : lis_pri_modulo) {					
					RolModulo rol_mod_pri = new RolModulo();
					rol_mod_pri.setRolModuloPK(new RolModuloPK(cod_rol, pri.getCod_modulo()));
					rol_mod_pri.setPesorol(Constantes.ONE_INT);
					rol_mod_pri.setFlagmodulodefault(Constantes.ESTADO_INACTIVO);
					save(rol_mod_pri);	
				}
			} else {
				StringBuilder hql = new StringBuilder();
				hql.append("update RolModulo ");
				hql.append("set flagmodulodefault = :fla_rol_mod ");
				hql.append("where rolModuloPK.idrol = :cod_rol ");
				Query query = super.getSession().createQuery(hql.toString());
				query.setParameter("fla_rol_mod", Constantes.ESTADO_INACTIVO);
				query.setParameter("cod_rol", cod_rol);
				query.executeUpdate();
			}
		} catch (Exception e) {
			throw new Exception(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(), 
								Constantes.NIVEL_APP_DAO, 
								this.getClass().getName(), e.getMessage()));
		}
	}

}
