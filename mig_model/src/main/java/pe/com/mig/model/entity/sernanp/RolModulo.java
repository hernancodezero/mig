package pe.com.mig.model.entity.sernanp;
// Generated 16/06/2016 12:59:06 AM by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * RolModulo generated by hbm2java
 */
@Entity
@Table(name = "rolmodulo", schema = "sernanp")
public class RolModulo implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
    private RolModuloPK rolModuloPK;
	private Integer pesorol;
	private Integer flagmodulodefault;	
	
	
	@EmbeddedId
	public RolModuloPK getRolModuloPK() {
		return this.rolModuloPK;
	}

	public void setRolModuloPK(RolModuloPK rolModuloPK) {
		this.rolModuloPK = rolModuloPK;
	}

	@Column(name = "pesorol")
	public Integer getPesorol() {
		return this.pesorol;
	}

	public void setPesorol(Integer pesorol) {
		this.pesorol = pesorol;
	}

	@Column(name = "flagmodulodefault")
	public Integer getFlagmodulodefault() {
		return this.flagmodulodefault;
	}

	public void setFlagmodulodefault(Integer flagmodulodefault) {
		this.flagmodulodefault = flagmodulodefault;
	}


}
