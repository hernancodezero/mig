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
 * Enlaceterritorial generated by hbm2java
 */
@Entity
@Table(name = "enlaceterritorial", schema = "sernanp")
public class Enlaceterritorial implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private int idenlaceterritorial;
	private String desenlaceterritorial;
	private Set<Areanatural> areanaturals = new HashSet<Areanatural>(0);

	public Enlaceterritorial() {
	}

	public Enlaceterritorial(int idenlaceterritorial) {
		this.idenlaceterritorial = idenlaceterritorial;
	}

	public Enlaceterritorial(int idenlaceterritorial, String desenlaceterritorial, Set<Areanatural> areanaturals) {
		this.idenlaceterritorial = idenlaceterritorial;
		this.desenlaceterritorial = desenlaceterritorial;
		this.areanaturals = areanaturals;
	}

	@Id
	@Column(name = "idenlaceterritorial", unique = true, nullable = false)
	public int getIdenlaceterritorial() {
		return this.idenlaceterritorial;
	}

	public void setIdenlaceterritorial(int idenlaceterritorial) {
		this.idenlaceterritorial = idenlaceterritorial;
	}

	@Column(name = "desenlaceterritorial", length = 45)
	public String getDesenlaceterritorial() {
		return this.desenlaceterritorial;
	}

	public void setDesenlaceterritorial(String desenlaceterritorial) {
		this.desenlaceterritorial = desenlaceterritorial;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "enlaceterritorial")
	public Set<Areanatural> getAreanaturals() {
		return this.areanaturals;
	}

	public void setAreanaturals(Set<Areanatural> areanaturals) {
		this.areanaturals = areanaturals;
	}

}
