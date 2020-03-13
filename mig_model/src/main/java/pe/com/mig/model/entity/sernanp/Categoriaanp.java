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
 * Categoriaanp generated by hbm2java
 */
@Entity
@Table(name = "categoriaanp", schema = "sernanp")
public class Categoriaanp implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private int idcategoriaanp;
	private String codcategoriaanp;
	private String descategoriaanp;
	private Integer estado;
	private String siglascategoriaanp;
	private Set<Areanatural> areanaturals = new HashSet<Areanatural>(0);

	public Categoriaanp() {
	}

	public Categoriaanp(int idcategoriaanp) {
		this.idcategoriaanp = idcategoriaanp;
	}

	public Categoriaanp(int idcategoriaanp, String codcategoriaanp, String descategoriaanp, Integer estado,
			String siglascategoriaanp, Set<Areanatural> areanaturals) {
		this.idcategoriaanp = idcategoriaanp;
		this.codcategoriaanp = codcategoriaanp;
		this.descategoriaanp = descategoriaanp;
		this.estado = estado;
		this.siglascategoriaanp = siglascategoriaanp;
		this.areanaturals = areanaturals;
	}

	@Id
	@Column(name = "idcategoriaanp", unique = true, nullable = false)
	public int getIdcategoriaanp() {
		return this.idcategoriaanp;
	}

	public void setIdcategoriaanp(int idcategoriaanp) {
		this.idcategoriaanp = idcategoriaanp;
	}

	@Column(name = "codcategoriaanp", length = 2)
	public String getCodcategoriaanp() {
		return this.codcategoriaanp;
	}

	public void setCodcategoriaanp(String codcategoriaanp) {
		this.codcategoriaanp = codcategoriaanp;
	}

	@Column(name = "descategoriaanp", length = 200)
	public String getDescategoriaanp() {
		return this.descategoriaanp;
	}

	public void setDescategoriaanp(String descategoriaanp) {
		this.descategoriaanp = descategoriaanp;
	}

	@Column(name = "estado")
	public Integer getEstado() {
		return this.estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	@Column(name = "siglascategoriaanp", length = 45)
	public String getSiglascategoriaanp() {
		return this.siglascategoriaanp;
	}

	public void setSiglascategoriaanp(String siglascategoriaanp) {
		this.siglascategoriaanp = siglascategoriaanp;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "categoriaanp")
	public Set<Areanatural> getAreanaturals() {
		return this.areanaturals;
	}

	public void setAreanaturals(Set<Areanatural> areanaturals) {
		this.areanaturals = areanaturals;
	}

}
