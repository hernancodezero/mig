package pe.com.mig.model.entity.sernanp;

import java.io.Serializable;

import javax.persistence.Embeddable;

/**
 * @className: RolModuloPK.java
 * @description: 
 * @date: 16 de jun. de 2016
 * @author: SUMERIO.
 */
@Embeddable
public class RolModuloPK implements Serializable {

	private static final long serialVersionUID = 1L;
	protected Integer idrol;
    protected Integer idmodulo;
    
    
	/**
	 * 
	 */
	public RolModuloPK() {
		super();
	}

	/**
	 * @param idrol
	 * @param idmodulo
	 */
	public RolModuloPK(Integer idrol, Integer idmodulo) {
		super();
		this.idrol = idrol;
		this.idmodulo = idmodulo;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idmodulo == null) ? 0 : idmodulo.hashCode());
		result = prime * result + ((idrol == null) ? 0 : idrol.hashCode());
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
		RolModuloPK other = (RolModuloPK) obj;
		if (idmodulo == null) {
			if (other.idmodulo != null)
				return false;
		} else if (!idmodulo.equals(other.idmodulo))
			return false;
		if (idrol == null) {
			if (other.idrol != null)
				return false;
		} else if (!idrol.equals(other.idrol))
			return false;
		return true;
	}

	/**
	 * @return the idrol
	 */
	public Integer getIdrol() {
		return idrol;
	}
	/**
	 * @param idrol the idrol to set
	 */
	public void setIdrol(Integer idrol) {
		this.idrol = idrol;
	}
	/**
	 * @return the idmodulo
	 */
	public Integer getIdmodulo() {
		return idmodulo;
	}
	/**
	 * @param idmodulo the idmodulo to set
	 */
	public void setIdmodulo(Integer idmodulo) {
		this.idmodulo = idmodulo;
	}

}
