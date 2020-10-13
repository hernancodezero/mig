package pe.com.mig.model.entity;
// Generated 02/07/2016 12:36:04 PM by Hibernate Tools 4.3.1

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
 * TTariServicio generated by hbm2java
 */
@Entity
@Table(name = "t_tari_servicio", schema = "mig")
public class TTariServicio implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private int srlIdServicio;
	private String chrCodServicio;
	private String chrNomServicio;
	private BigDecimal numPctUit;
	private BigDecimal numImpVventa;
	private BigDecimal numImpIgv;
	private BigDecimal numImpPventa;
	private String chrCodEspecifica;
	private String chrCodCuenta;
	private String chrFlgActivo;
	private String chrCodUsuaCreacion;
	private Date dteFecCreacion;
	private String chrCodUsuaModifica;
	private Date dteFecModifica;
	private Set<TDetalleIngresos> TDetalleIngresoses = new HashSet<TDetalleIngresos>(0);

	public TTariServicio() {
	}

	public TTariServicio(int srlIdServicio) {
		this.srlIdServicio = srlIdServicio;
	}

	public TTariServicio(int srlIdServicio, String chrCodServicio, String chrNomServicio, BigDecimal numPctUit,
			BigDecimal numImpVventa, BigDecimal numImpIgv, BigDecimal numImpPventa, String chrCodEspecifica,
			String chrCodCuenta, String chrFlgActivo, String chrCodUsuaCreacion, Date dteFecCreacion,
			String chrCodUsuaModifica, Date dteFecModifica, Set<TDetalleIngresos> TDetalleIngresoses) {
		this.srlIdServicio = srlIdServicio;
		this.chrCodServicio = chrCodServicio;
		this.chrNomServicio = chrNomServicio;
		this.numPctUit = numPctUit;
		this.numImpVventa = numImpVventa;
		this.numImpIgv = numImpIgv;
		this.numImpPventa = numImpPventa;
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
	@SequenceGenerator(name = "seq_tari_servicio", sequenceName = "mig.t_tari_servicio_srl_id_servicio_seq")
	@GeneratedValue(generator = "seq_tari_servicio")
	@Column(name = "srl_id_servicio", unique = true, nullable = false)
	public int getSrlIdServicio() {
		return this.srlIdServicio;
	}

	public void setSrlIdServicio(int srlIdServicio) {
		this.srlIdServicio = srlIdServicio;
	}

	@Column(name = "chr_cod_servicio", length = 5)
	public String getChrCodServicio() {
		return this.chrCodServicio;
	}

	public void setChrCodServicio(String chrCodServicio) {
		this.chrCodServicio = chrCodServicio;
	}

	@Column(name = "chr_nom_servicio", length = 100)
	public String getChrNomServicio() {
		return this.chrNomServicio;
	}

	public void setChrNomServicio(String chrNomServicio) {
		this.chrNomServicio = chrNomServicio;
	}

	@Column(name = "num_pct_uit", precision = 10, scale = 4)
	public BigDecimal getNumPctUit() {
		return this.numPctUit;
	}

	public void setNumPctUit(BigDecimal numPctUit) {
		this.numPctUit = numPctUit;
	}

	@Column(name = "num_imp_vventa", precision = 10)
	public BigDecimal getNumImpVventa() {
		return this.numImpVventa;
	}

	public void setNumImpVventa(BigDecimal numImpVventa) {
		this.numImpVventa = numImpVventa;
	}

	@Column(name = "num_imp_igv", precision = 10)
	public BigDecimal getNumImpIgv() {
		return this.numImpIgv;
	}

	public void setNumImpIgv(BigDecimal numImpIgv) {
		this.numImpIgv = numImpIgv;
	}

	@Column(name = "num_imp_pventa", precision = 10, scale = 2)
	public BigDecimal getNumImpPventa() {
		return this.numImpPventa;
	}

	public void setNumImpPventa(BigDecimal numImpPventa) {
		this.numImpPventa = numImpPventa;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TTariServicio")
	public Set<TDetalleIngresos> getTDetalleIngresoses() {
		return this.TDetalleIngresoses;
	}

	public void setTDetalleIngresoses(Set<TDetalleIngresos> TDetalleIngresoses) {
		this.TDetalleIngresoses = TDetalleIngresoses;
	}

}