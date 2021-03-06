package pe.com.mig.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.mig.dao.IUsuarioDao;
import pe.com.mig.model.bean.sernanp.ModuloBean;
import pe.com.mig.model.bean.sernanp.PerfilBean;
import pe.com.mig.model.bean.sernanp.UsuarioBean;
import pe.com.mig.service.IUsuarioService;

/**
 * @className: UsuarioServiceImpl.java
 * @description: 
 * @date: 17 de jun. de 2016
 * @author: SUMERIO.
 */
@Service
public class UsuarioServiceImpl extends GenericServiceImpl implements IUsuarioService {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private IUsuarioDao iUsuarioDao;

	/* (non-Javadoc)
	 * @see pe.com.mig.service.IUsuarioService#obtenerDatosUsuario(java.lang.String)
	 */
	@Override
	public UsuarioBean obtenerDatosUsuario(String clave) throws Exception {
		return iUsuarioDao.obtenerDatosUsuario(clave);
	}

	/* (non-Javadoc)
	 * @see pe.com.mig.service.IUsuarioService#listarPerfiles(pe.com.mig.model.bean.sernanp.PerfilBean)
	 */
	@Override
	public List<PerfilBean> listarPerfiles(PerfilBean perfil) throws Exception {
		return iUsuarioDao.listarPerfiles(perfil);
	}

	/* (non-Javadoc)
	 * @see pe.com.mig.service.IUsuarioService#grabarPerfil(pe.com.mig.model.bean.sernanp.PerfilBean)
	 */
	@Override
	public void grabarPerfil(PerfilBean perfil) throws Exception {
		iUsuarioDao.grabarPerfil(perfil);
	}

	/* (non-Javadoc)
	 * @see pe.com.mig.service.IUsuarioService#listarUsuarios(pe.com.mig.model.bean.sernanp.UsuarioBean)
	 */
	@Override
	public List<UsuarioBean> listarUsuarios(UsuarioBean usuario) throws Exception {
		return iUsuarioDao.listarUsuarios(usuario);
	}

	/* (non-Javadoc)
	 * @see pe.com.mig.service.IUsuarioService#grabarUsuario(pe.com.mig.model.bean.sernanp.UsuarioBean)
	 */
	@Override
	public void grabarUsuario(UsuarioBean usuario) throws Exception {
		iUsuarioDao.grabarUsuario(usuario);
	}

	/* (non-Javadoc)
	 * @see pe.com.mig.service.IUsuarioService#listarModulo(pe.com.mig.model.bean.sernanp.ModuloBean)
	 */
	@Override
	public List<ModuloBean> listarModulo(ModuloBean modulo) throws Exception {
		return iUsuarioDao.listarModulo(modulo);
	}

}
