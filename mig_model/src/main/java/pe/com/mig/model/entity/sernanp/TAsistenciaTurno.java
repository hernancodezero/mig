package pe.com.mig.model.entity.sernanp;
// Generated 16/06/2016 12:59:06 AM by Hibernate Tools 4.3.1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * TAsistenciaTurno generated by hbm2java
 */
@Entity
@Table(name = "t_asistencia_turno", schema = "sernanp")
public class TAsistenciaTurno implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private int srlIdAsisTurno;
	private String varDesAsisTurno;
	private Date horHorIngreso;
	private Date horHorSalida;
	private Date horHorIniRefrig;
	private Date horHorFinRefrig;
	private Integer intCanHoras;
	private Set<Personal> personals = new HashSet<Personal>(0);

	public TAsistenciaTurno() {
	}

	public TAsistenciaTurno(int srlIdAsisTurno) {
		this.srlIdAsisTurno = srlIdAsisTurno;
	}

	public TAsistenciaTurno(int srlIdAsisTurno, String varDesAsisTurno, Date horHorIngreso, Date horHorSalida,
			Date horHorIniRefrig, Date horHorFinRefrig, Integer intCanHoras, Set<Personal> personals) {
		this.srlIdAsisTurno = srlIdAsisTurno;
		this.varDesAsisTurno = varDesAsisTurno;
		this.horHorIngreso = horHorIngreso;
		this.horHorSalida = horHorSalida;
		this.horHorIniRefrig = horHorIniRefrig;
		this.horHorFinRefrig = horHorFinRefrig;
		this.intCanHoras = intCanHoras;
		this.personals = personals;
	}

	@Id
	@Column(name = "srl_id_asis_turno", unique = true, nullable = false)
	public int getSrlIdAsisTurno() {
		return this.srlIdAsisTurno;
	}

	public void setSrlIdAsisTurno(int srlIdAsisTurno) {
		this.srlIdAsisTurno = srlIdAsisTurno;
	}

	@Column(name = "var_des_asis_turno", length = 100)
	public String getVarDesAsisTurno() {
		return this.varDesAsisTurno;
	}

	public void setVarDesAsisTurno(String varDesAsisTurno) {
		this.varDesAsisTurno = varDesAsisTurno;
	}

	@Temporal(TemporalType.TIME)
	@Column(name = "hor_hor_ingreso", length = 15)
	public Date getHorHorIngreso() {
		return this.horHorIngreso;
	}

	public void setHorHorIngreso(Date horHorIngreso) {
		this.horHorIngreso = horHorIngreso;
	}

	@Temporal(TemporalType.TIME)
	@Column(name = "hor_hor_salida", length = 15)
	public Date getHorHorSalida() {
		return this.horHorSalida;
	}

	public void setHorHorSalida(Date horHorSalida) {
		this.horHorSalida = horHorSalida;
	}

	@Temporal(TemporalType.TIME)
	@Column(name = "hor_hor_ini_refrig", length = 15)
	public Date getHorHorIniRefrig() {
		return this.horHorIniRefrig;
	}

	public void setHorHorIniRefrig(Date horHorIniRefrig) {
		this.horHorIniRefrig = horHorIniRefrig;
	}

	@Temporal(TemporalType.TIME)
	@Column(name = "hor_hor_fin_refrig", length = 15)
	public Date getHorHorFinRefrig() {
		return this.horHorFinRefrig;
	}

	public void setHorHorFinRefrig(Date horHorFinRefrig) {
		this.horHorFinRefrig = horHorFinRefrig;
	}

	@Column(name = "int_can_horas")
	public Integer getIntCanHoras() {
		return this.intCanHoras;
	}

	public void setIntCanHoras(Integer intCanHoras) {
		this.intCanHoras = intCanHoras;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TAsistenciaTurno")
	public Set<Personal> getPersonals() {
		return this.personals;
	}

	public void setPersonals(Set<Personal> personals) {
		this.personals = personals;
	}

}
