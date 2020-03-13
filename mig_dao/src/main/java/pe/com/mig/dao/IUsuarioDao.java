package pe.com.mig.dao;

import java.util.List;

import pe.com.mig.model.bean.sernanp.ModuloBean;
import pe.com.mig.model.bean.sernanp.PerfilBean;
import pe.com.mig.model.bean.sernanp.UsuarioBean;

/**
 * @className: IUsuarioDao.java
 * @description: 
 * @date: 17 de jun. de 2016
 * @author: SUMERIO.
 */
public interface IUsuarioDao {
	
	/**
	 * @param clave
	 * @return
	 * @throws Exception
	 */
	public abstract UsuarioBean obtenerDatosUsuario(String clave) throws Exception;
	
	/**
	 * @param perfil
	 * @return
	 * @throws Exception 
	 */
	public abstract List<PerfilBean> listarPerfiles(PerfilBean perfil) throws Exception;
	
	/**
	 * @param perfil
	 * @return
	 * @throws Exception 
	 */
	public abstract void grabarPerfil(PerfilBean perfil) throws Exception;

	/**
	 * @param usuario
	 * @return
	 * @throws Exception 
	 */
	public abstract List<UsuarioBean> listarUsuarios(UsuarioBean usuario) throws Exception;
	
	/**
	 * @param usuario
	 * @throws Exception 
	 */
	public abstract void grabarUsuario(UsuarioBean usuario) throws Exception;
	
	/**
	 * @param modulo
	 * @return
	 * @throws Exception 
	 */
	public abstract List<ModuloBean> listarModulo(ModuloBean modulo) throws Exception;
	
	/**
	 * @param cod_rol
	 * @param cod_rol_act
	 * @param indicador 
	 * @throws Exception 
	 */
	public abstract void grabarRolModulo(Integer cod_rol, Integer cod_rol_act, boolean indicador) throws Exception;

}
