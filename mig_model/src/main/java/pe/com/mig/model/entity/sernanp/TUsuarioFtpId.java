package pe.com.mig.model.entity.sernanp;
// Generated 16/06/2016 12:59:06 AM by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * TUsuarioFtpId generated by hbm2java
 */
@Embeddable
public class TUsuarioFtpId implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private int idusuario;
	private int idsistema;

	public TUsuarioFtpId() {
	}

	public TUsuarioFtpId(int idusuario, int idsistema) {
		this.idusuario = idusuario;
		this.idsistema = idsistema;
	}

	@Column(name = "idusuario", nullable = false)
	public int getIdusuario() {
		return this.idusuario;
	}

	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}

	@Column(name = "idsistema", nullable = false)
	public int getIdsistema() {
		return this.idsistema;
	}

	public void setIdsistema(int idsistema) {
		this.idsistema = idsistema;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TUsuarioFtpId))
			return false;
		TUsuarioFtpId castOther = (TUsuarioFtpId) other;

		return (this.getIdusuario() == castOther.getIdusuario()) && (this.getIdsistema() == castOther.getIdsistema());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getIdusuario();
		result = 37 * result + this.getIdsistema();
		return result;
	}

}
