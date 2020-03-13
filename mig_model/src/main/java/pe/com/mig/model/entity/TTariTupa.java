package pe.com.mig.model.entity;
// Generated 25/06/2016 11:26:23 AM by Hibernate Tools 4.3.1

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * TTariTupa generated by hbm2java
 */
@Entity
@Table(name = "t_tari_tupa", schema = "mig")
public class TTariTupa implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private int srlIdTupa;
	private String chrCodTupa;
	private String chrNomTupa;
	private BigDecimal numPctUit;
	private BigDecimal numImpUnit;
	private String chrCodEspecifica;
	private String chrCodCuenta;
	private String chrFlgActivo;
	private String chrCodUsuaCreacion;
	private Date dteFecCreacion;
	private String chrCodUsuaModifica;
	private Date dteFecModifica;
	private Set<TDetalleIngresos> TDetalleIngresoses = new HashSet<TDetalleIngresos>(0);

	public TTariTupa() {
	}
	
	public TTariTupa(int srlIdTupa) {
		this.srlIdTupa = srlIdTupa;
	}

	public TTariTupa(int srlIdTupa, String chrCodTupa, String chrNomTupa, BigDecimal numPctUit, BigDecimal numImpUnit,
			String chrCodEspecifica, String chrCodCuenta, String chrFlgActivo, String chrCodUsuaCreacion,
			Date dteFecCreacion, String chrCodUsuaModifica, Date dteFecModifica,
			Set<TDetalleIngresos> TDetalleIngresoses) {
		this.srlIdTupa = srlIdTupa;
		this.chrCodTupa = chrCodTupa;
		this.chrNomTupa = chrNomTupa;
		this.numPctUit = numPctUit;
		this.numImpUnit = numImpUnit;
		this.chrCodEspecifica = chrCodEspecifica;
		this.chrCodCuenta = chrCodCuenta;
		this.chrFlgActivo = chrFlgActivo;
		this.chrCodUsuaCreacion = chrCodUsuaCreacion;
		this.dteFecCreacion = dteFecCreacion;
		this.chrCodUsuaModifica = chrCodUsuaModifica;
		this.dteFecModifica = dteFecModifica;
		this.TDetalleIngresoses = TDetalleIngresoses;
	}

	@Id
	@SequenceGenerator(name = "seq_tari_tupa", sequenceName = "mig.t_tari_tupa_srl_id_tupa_seq")
	@GeneratedValue(generator = "seq_tari_tupa")
	@Column(name = "srl_id_tupa", unique = true, nullable = false)
	public int getSrlIdTupa() {
		return this.srlIdTupa;
	}

	public void setSrlIdTupa(int srlIdTupa) {
		this.srlIdTupa = srlIdTupa;
	}

	@Column(name = "chr_cod_tupa", length = 6)
	public String getChrCodTupa() {
		return this.chrCodTupa;
	}

	public void setChrCodTupa(String chrCodTupa) {
		this.chrCodTupa = chrCodTupa;
	}

	@Column(name = "chr_nom_tupa", length = 200)
	public String getChrNomTupa() {
		return this.chrNomTupa;
	}

	public void setChrNomTupa(String chrNomTupa) {
		this.chrNomTupa = chrNomTupa;
	}

	@Column(name = "num_pct_uit", precision = 10, scale = 4)
	public BigDecimal getNumPctUit() {
		return this.numPctUit;
	}

	public void setNumPctUit(BigDecimal numPctUit) {
		this.numPctUit = numPctUit;
	}

	@Column(name = "num_imp_unit", precision = 10)
	public BigDecimal getNumImpUnit() {
		return this.numImpUnit;
	}

	public void setNumImpUnit(BigDecimal numImpUnit) {
		this.numImpUnit = numImpUnit;
	}

	@Column(name = "chr_cod_especifica", length = 15)
	public String getChrCodEspecifica() {
		return this.chrCodEspecifica;
	}

	public void setChrCodEspecifica(String chrCodEspecifica) {
		this.chrCodEspecifica = chrCodEspecifica;
	}

	@Column(name = "chr_cod_cuenta", length = 15)
	public String getChrCodCuenta() {
		return this.chrCodCuenta;
	}

	public void setChrCodCuenta(String chrCodCuenta) {
		this.chrCodCuenta = chrCodCuenta;
	}

	@Column(name = "chr_flg_activo", length = 1)
	public String getChrFlgActivo() {
		return this.chrFlgActivo;
	}

	public void setChrFlgActivo(String chrFlgActivo) {
		this.chrFlgActivo = chrFlgActivo;
	}

	@Column(name = "chr_cod_usua_creacion", length = 10)
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

	@Column(name = "chr_cod_usua_modifica", length = 10)
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TTariTupa")
	public Set<TDetalleIngresos> getTDetalleIngresoses() {
		return this.TDetalleIngresoses;
	}

	public void setTDetalleIngresoses(Set<TDetalleIngresos> TDetalleIngresoses) {
		this.TDetalleIngresoses = TDetalleIngresoses;
	}

}
