package pe.com.mig.model.entity.sernanp;
// Generated 16/06/2016 12:59:06 AM by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Pais generated by hbm2java
 */
@Entity
@Table(name = "pais", schema = "sernanp")
public class Pais implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private int idpais;
	private String codpais;
	private String nompais;
	private String nacpais;
	private Set<Persona> personas = new HashSet<Persona>(0);

	public Pais() {
	}

	public Pais(int idpais) {
		this.idpais = idpais;
	}

	public Pais(int idpais, String codpais, String nompais, String nacpais, Set<Persona> personas) {
		this.idpais = idpais;
		this.codpais = codpais;
		this.nompais = nompais;
		this.nacpais = nacpais;
		this.personas = personas;
	}

	@Id
	@Column(name = "idpais", unique = true, nullable = false)
	public int getIdpais() {
		return this.idpais;
	}

	public void setIdpais(int idpais) {
		this.idpais = idpais;
	}

	@Column(name = "codpais", length = 45)
	public String getCodpais() {
		return this.codpais;
	}

	public void setCodpais(String codpais) {
		this.codpais = codpais;
	}

	@Column(name = "nompais", length = 100)
	public String getNompais() {
		return this.nompais;
	}

	public void setNompais(String nompais) {
		this.nompais = nompais;
	}

	@Column(name = "nacpais", length = 100)
	public String getNacpais() {
		return this.nacpais;
	}

	public void setNacpais(String nacpais) {
		this.nacpais = nacpais;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pais")
	public Set<Persona> getPersonas() {
		return this.personas;
	}

	public void setPersonas(Set<Persona> personas) {
		this.personas = personas;
	}

}