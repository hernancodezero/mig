package pe.com.mig.model.entity.sernanp;
// Generated 16/06/2016 12:59:06 AM by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Rol generated by hbm2java
 */
@Entity
@Table(name = "rol", schema = "sernanp")
public class Rol implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private int idrol;
	private Sistema sistema;
	private String desrol;
	private String flagrol;
	private Set<Usuario> usuarios = new HashSet<Usuario>(0);

	public Rol() {
	}

	public Rol(int idrol) {
		this.idrol = idrol;
	}

	public Rol(int idrol, Sistema sistema, String desrol, String flagrol, Set<Usuario> usuarios) {
		this.idrol = idrol;
		this.sistema = sistema;
		this.desrol = desrol;
		this.flagrol = flagrol;
		this.usuarios = usuarios;
	}

	@Id
	@SequenceGenerator(name = "seq_rol", sequenceName = "sernanp.rol_idrol_seq")
	@GeneratedValue(generator = "seq_rol")
	@Column(name = "idrol", unique = true, nullable = false)
	public int getIdrol() {
		return this.idrol;
	}

	public void setIdrol(int idrol) {
		this.idrol = idrol;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idsistema")
	public Sistema getSistema() {
		return this.sistema;
	}

	public void setSistema(Sistema sistema) {
		this.sistema = sistema;
	}

	@Column(name = "desrol", length = 100)
	public String getDesrol() {
		return this.desrol;
	}

	public void setDesrol(String desrol) {
		this.desrol = desrol;
	}

	@Column(name = "flagrol", length = 45)
	public String getFlagrol() {
		return this.flagrol;
	}

	public void setFlagrol(String flagrol) {
		this.flagrol = flagrol;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "rol")
	public Set<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}
