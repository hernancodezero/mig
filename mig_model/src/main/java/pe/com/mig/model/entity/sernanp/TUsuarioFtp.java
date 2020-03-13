package pe.com.mig.model.entity.sernanp;
// Generated 16/06/2016 12:59:06 AM by Hibernate Tools 4.3.1

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * TUsuarioFtp generated by hbm2java
 */
@Entity
@Table(name = "t_usuario_ftp", schema = "sernanp")
public class TUsuarioFtp implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private TUsuarioFtpId id;
	private Sistema sistema;
	private Usuario usuario;
	private String varUsuarioFtp;
	private String varClaveFtp;

	public TUsuarioFtp() {
	}

	public TUsuarioFtp(TUsuarioFtpId id, Sistema sistema, Usuario usuario) {
		this.id = id;
		this.sistema = sistema;
		this.usuario = usuario;
	}

	public TUsuarioFtp(TUsuarioFtpId id, Sistema sistema, Usuario usuario, String varUsuarioFtp, String varClaveFtp) {
		this.id = id;
		this.sistema = sistema;
		this.usuario = usuario;
		this.varUsuarioFtp = varUsuarioFtp;
		this.varClaveFtp = varClaveFtp;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "idusuario", column = @Column(name = "idusuario", nullable = false) ),
			@AttributeOverride(name = "idsistema", column = @Column(name = "idsistema", nullable = false) ) })
	public TUsuarioFtpId getId() {
		return this.id;
	}

	public void setId(TUsuarioFtpId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idsistema", nullable = false, insertable = false, updatable = false)
	public Sistema getSistema() {
		return this.sistema;
	}

	public void setSistema(Sistema sistema) {
		this.sistema = sistema;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idusuario", nullable = false, insertable = false, updatable = false)
	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Column(name = "var_usuario_ftp", length = 50)
	public String getVarUsuarioFtp() {
		return this.varUsuarioFtp;
	}

	public void setVarUsuarioFtp(String varUsuarioFtp) {
		this.varUsuarioFtp = varUsuarioFtp;
	}

	@Column(name = "var_clave_ftp", length = 100)
	public String getVarClaveFtp() {
		return this.varClaveFtp;
	}

	public void setVarClaveFtp(String varClaveFtp) {
		this.varClaveFtp = varClaveFtp;
	}

}
