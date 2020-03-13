package pe.com.mig.model.entity.sernanp;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @className: UsuarioRolPK.java
 * @description: 
 * @date: 16 de jun. de 2016
 * @author: SUMERIO.
 */
@Embeddable
public class UsuarioRolPK implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer idusuario;
	private Integer idrol;

	public UsuarioRolPK() {
		super();
	}

	public UsuarioRolPK(Integer idusuario, Integer idrol) {
		super();
		this.idusuario = idusuario;
		this.idrol = idrol;
	}

	@Column(name = "idusuario", nullable = false)
	public Integer getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(Integer idusuario) {
		this.idusuario = idusuario;
	}

	@Column(name = "idrol", nullable = false)
	public Integer getIdrol() {
		return idrol;
	}

	public void setIdrol(Integer idrol) {
		this.idrol = idrol;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idrol == null) ? 0 : idrol.hashCode());
		result = prime * result + ((idusuario == null) ? 0 : idusuario.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsuarioRolPK other = (UsuarioRolPK) obj;
		if (idrol == null) {
			if (other.idrol != null)
				return false;
		} else if (!idrol.equals(other.idrol))
			return false;
		if (idusuario == null) {
			if (other.idusuario != null)
				return false;
		} else if (!idusuario.equals(other.idusuario))
			return false;
		return true;
	}

}
