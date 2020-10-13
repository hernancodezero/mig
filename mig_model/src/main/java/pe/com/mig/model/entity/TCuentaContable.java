package pe.com.mig.model.entity;
// Generated 10/07/2016 06:15:17 PM by Hibernate Tools 4.3.1

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import pe.com.mig.model.entity.sppi.TEspecifica;

/**
 * TCuentaContable generated by hbm2java
 */
@Entity
@Table(name = "t_cuenta_contable", schema = "mig")
public class TCuentaContable implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private int srlIdCuenta;
	private TEspecifica TEspecifica;
	private String chrCodCuenta;
	private String chrNomCuenta;
	private String chrFlgActivo;
	private String chrCodUsuaCreacion;
	private Date dteFecCreacion;
	private String chrCodUsuaModifica;
	private Date dteFecModifica;
	private Set<TDetalleCompras> TDetalleComprases = new HashSet<TDetalleCompras>(0);

	public TCuentaContable() {
	}

	public TCuentaContable(int srlIdCuenta) {
		this.srlIdCuenta = srlIdCuenta;
	}

	public TCuentaContable(int srlIdCuenta, String chrCodCuenta, String chrNomCuenta,
			String chrFlgActivo, String chrCodUsuaCreacion, Date dteFecCreacion, String chrCodUsuaModifica,
			Date dteFecModifica, Set<TDetalleCompras> TDetalleComprases) {
		this.srlIdCuenta = srlIdCuenta;
		this.chrCodCuenta = chrCodCuenta;
		this.chrNomCuenta = chrNomCuenta;
		this.chrFlgActivo = chrFlgActivo;
		this.chrCodUsuaCreacion = chrCodUsuaCreacion;
		this.dteFecCreacion = dteFecCreacion;
		this.chrCodUsuaModifica = chrCodUsuaModifica;
		this.dteFecModifica = dteFecModifica;
		this.TDetalleComprases = TDetalleComprases;
	}

	@Id
	@SequenceGenerator(name = "seq_cuenta_contable", sequenceName = "mig.t_cuenta_contable_srl_id_cuenta_seq")
	@GeneratedValue(generator = "seq_cuenta_contable")
	@Column(name = "srl_id_cuenta", unique = true, nullable = false)
	public int getSrlIdCuenta() {
		return this.srlIdCuenta;
	}

	public void setSrlIdCuenta(int srlIdCuenta) {
		this.srlIdCuenta = srlIdCuenta;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "srl_id_espec")
	public TEspecifica getTEspecifica() {
		return this.TEspecifica;
	}

	public void setTEspecifica(TEspecifica TEspecifica) {
		this.TEspecifica = TEspecifica;
	}

	@Column(name = "chr_cod_cuenta", length = 15)
	public String getChrCodCuenta() {
		return this.chrCodCuenta;
	}

	public void setChrCodCuenta(String chrCodCuenta) {
		this.chrCodCuenta = chrCodCuenta;
	}

	@Column(name = "chr_nom_cuenta", length = 80)
	public String getChrNomCuenta() {
		return this.chrNomCuenta;
	}

	public void setChrNomCuenta(String chrNomCuenta) {
		this.chrNomCuenta = chrNomCuenta;
	}

	@Column(name = "chr_flg_activo", length = 1)
	public String getChrFlgActivo() {
		return this.chrFlgActivo;
	}

	public void setChrFlgActivo(String chrFlgActivo) {
		this.chrFlgActivo = chrFlgActivo;
	}

	@Column(name = "chr_cod_usua_creacion", length = 20)
	public String getChrCodUsuaCreacion() {
		return this.chrCodUsuaCreacion;
	}

	public void setChrCodUsuaCreacion(String chrCodUsuaCreacion) {
		this.chrCodUsuaCreacion = chrCodUsuaCreacion;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "dte_fec_creacion", length = 13)
	public Date getDteFecCreacion() {
		return this.dteFecCreacion;
	}

	public void setDteFecCreacion(Date dteFecCreacion) {
		this.dteFecCreacion = dteFecCreacion;
	}

	@Column(name = "chr_cod_usua_modifica", length = 20)
	public String getChrCodUsuaModifica() {
		return this.chrCodUsuaModifica;
	}

	public void setChrCodUsuaModifica(String chrCodUsuaModifica) {
		this.chrCodUsuaModifica = chrCodUsuaModifica;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "dte_fec_modifica", length = 13)
	public Date getDteFecModifica() {
		return this.dteFecModifica;
	}

	public void setDteFecModifica(Date dteFecModifica) {
		this.dteFecModifica = dteFecModifica;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TCuentaContable")
	public Set<TDetalleCompras> getTDetalleComprases() {
		return this.TDetalleComprases;
	}

	public void setTDetalleComprases(Set<TDetalleCompras> TDetalleComprases) {
		this.TDetalleComprases = TDetalleComprases;
	}

}