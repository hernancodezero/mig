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
 * TRegimenContractual generated by hbm2java
 */
@Entity
@Table(name = "t_regimen_contractual", schema = "sernanp")
public class TRegimenContractual implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private int srlIdRegimenContractual;
	private String varDescripcionRegimenContractual;
	private Integer intCodRegimenContractual;
	private Set<TRegimenPensionario> TRegimenPensionarios = new HashSet<TRegimenPensionario>(0);
	private Set<Personal> personals = new HashSet<Personal>(0);

	public TRegimenContractual() {
	}

	public TRegimenContractual(int srlIdRegimenContractual, String varDescripcionRegimenContractual) {
		this.srlIdRegimenContractual = srlIdRegimenContractual;
		this.varDescripcionRegimenContractual = varDescripcionRegimenContractual;
	}

	public TRegimenContractual(int srlIdRegimenContractual, String varDescripcionRegimenContractual,
			Integer intCodRegimenContractual, Set<TRegimenPensionario> TRegimenPensionarios, Set<Personal> personals) {
		this.srlIdRegimenContractual = srlIdRegimenContractual;
		this.varDescripcionRegimenContractual = varDescripcionRegimenContractual;
		this.intCodRegimenContractual = intCodRegimenContractual;
		this.TRegimenPensionarios = TRegimenPensionarios;
		this.personals = personals;
	}

	@Id
	@Column(name = "srl_id_regimen_contractual", unique = true, nullable = false)
	public int getSrlIdRegimenContractual() {
		return this.srlIdRegimenContractual;
	}

	public void setSrlIdRegimenContractual(int srlIdRegimenContractual) {
		this.srlIdRegimenContractual = srlIdRegimenContractual;
	}

	@Column(name = "var_descripcion_regimen_contractual", nullable = false, length = 100)
	public String getVarDescripcionRegimenContractual() {
		return this.varDescripcionRegimenContractual;
	}

	public void setVarDescripcionRegimenContractual(String varDescripcionRegimenContractual) {
		this.varDescripcionRegimenContractual = varDescripcionRegimenContractual;
	}

	@Column(name = "int_cod_regimen_contractual")
	public Integer getIntCodRegimenContractual() {
		return this.intCodRegimenContractual;
	}

	public void setIntCodRegimenContractual(Integer intCodRegimenContractual) {
		this.intCodRegimenContractual = intCodRegimenContractual;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TRegimenContractual")
	public Set<TRegimenPensionario> getTRegimenPensionarios() {
		return this.TRegimenPensionarios;
	}

	public void setTRegimenPensionarios(Set<TRegimenPensionario> TRegimenPensionarios) {
		this.TRegimenPensionarios = TRegimenPensionarios;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TRegimenContractual")
	public Set<Personal> getPersonals() {
		return this.personals;
	}

	public void setPersonals(Set<Personal> personals) {
		this.personals = personals;
	}

}