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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * TTipoComprobante generated by hbm2java
 */
@Entity
@Table(name = "t_tipo_comprobante", schema = "mig")
public class TTipoComprobante implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private int srlIdComprobante;
	private String chrCodComprobante;
	private String chrNomComprobante;
	private String chrSiglas;
	private Integer intNumDias;
	private Integer intNumMes;
	private Integer numSerie;
	private Integer numComprobante;
	private String chrFlgActivo;
	private String chrCodUsuaCreacion;
	private Date dteFecCreacion;
	private String chrCodUsuaModifica;
	private Date dteFecModifica;
	private Set<TTransferencia> TTransferencias = new HashSet<TTransferencia>(0);
	private Set<TComprasIngresos> TComprasIngresoses = new HashSet<TComprasIngresos>(0);
	private String chrFlgCompras;
	private String chrFlgVentas;
	private String chrFlgFactu;
	
	public TTipoComprobante() {
	}

	public TTipoComprobante(int srlIdComprobante) {
		this.srlIdComprobante = srlIdComprobante;
	}

	public TTipoComprobante(int srlIdComprobante, String chrCodComprobante, String chrNomComprobante, String chrSiglas,
			Integer intNumDias, Integer intNumMes, Integer numSerie, Integer numComprobante, String chrFlgActivo,
			String chrCodUsuaCreacion, Date dteFecCreacion, String chrCodUsuaModifica, Date dteFecModifica,String chrFlgFactu,
			Set<TTransferencia> TTransferencias, Set<TComprasIngresos> TComprasIngresoses) {
		this.srlIdComprobante = srlIdComprobante;
		this.chrCodComprobante = chrCodComprobante;
		this.chrNomComprobante = chrNomComprobante;
		this.chrSiglas = chrSiglas;
		this.intNumDias = intNumDias;
		this.intNumMes = intNumMes;
		this.numSerie = numSerie;
		this.numComprobante = numComprobante;
		this.chrFlgActivo = chrFlgActivo;
		this.chrCodUsuaCreacion = chrCodUsuaCreacion;
		this.dteFecCreacion = dteFecCreacion;
		this.chrCodUsuaModifica = chrCodUsuaModifica;
		this.dteFecModifica = dteFecModifica;
		this.TTransferencias = TTransferencias;
		this.TComprasIngresoses = TComprasIngresoses;
		this.chrFlgFactu = chrFlgFactu;
	}

	@Id
	@SequenceGenerator(name = "seq_tipo_comprobante", sequenceName = "mig.t_tipo_comprobante_srl_id_comprobante_seq")
	@GeneratedValue(generator = "seq_tipo_comprobante")
	@Column(name = "srl_id_comprobante", unique = true, nullable = false)
	public int getSrlIdComprobante() {
		return this.srlIdComprobante;
	}

	public void setSrlIdComprobante(int srlIdComprobante) {
		this.srlIdComprobante = srlIdComprobante;
	}

	@Column(name = "chr_cod_comprobante", length = 2)
	public String getChrCodComprobante() {
		return this.chrCodComprobante;
	}

	public void setChrCodComprobante(String chrCodComprobante) {
		this.chrCodComprobante = chrCodComprobante;
	}

	@Column(name = "chr_nom_comprobante", length = 400)
	public String getChrNomComprobante() {
		return this.chrNomComprobante;
	}

	public void setChrNomComprobante(String chrNomComprobante) {
		this.chrNomComprobante = chrNomComprobante;
	}

	@Column(name = "chr_siglas", length = 5)
	public String getChrSiglas() {
		return this.chrSiglas;
	}

	public void setChrSiglas(String chrSiglas) {
		this.chrSiglas = chrSiglas;
	}

	@Column(name = "int_num_dias")
	public Integer getIntNumDias() {
		return this.intNumDias;
	}

	public void setIntNumDias(Integer intNumDias) {
		this.intNumDias = intNumDias;
	}

	@Column(name = "int_num_mes")
	public Integer getIntNumMes() {
		return this.intNumMes;
	}

	public void setIntNumMes(Integer intNumMes) {
		this.intNumMes = intNumMes;
	}

	@Column(name = "num_serie")
	public Integer getNumSerie() {
		return this.numSerie;
	}

	public void setNumSerie(Integer numSerie) {
		this.numSerie = numSerie;
	}

	@Column(name = "num_comprobante")
	public Integer getNumComprobante() {
		return this.numComprobante;
	}

	public void setNumComprobante(Integer numComprobante) {
		this.numComprobante = numComprobante;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TTipoComprobante")
	public Set<TTransferencia> getTTransferencias() {
		return this.TTransferencias;
	}

	public void setTTransferencias(Set<TTransferencia> TTransferencias) {
		this.TTransferencias = TTransferencias;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TTipoComprobante")
	public Set<TComprasIngresos> getTComprasIngresoses() {
		return this.TComprasIngresoses;
	}

	public void setTComprasIngresoses(Set<TComprasIngresos> TComprasIngresoses) {
		this.TComprasIngresoses = TComprasIngresoses;
	}

	@Column(name = "chr_flg_compras", length = 1)
	public String getChrFlgCompras() {
		return this.chrFlgCompras;
	}

	public void setChrFlgCompras(String chrFlgCompras) {
		this.chrFlgCompras = chrFlgCompras;
	}

	@Column(name = "chr_flg_ventas", length = 1)
	public String getChrFlgVentas() {
		return this.chrFlgVentas;
	}

	public void setChrFlgVentas(String chrFlgVentas) {
		this.chrFlgVentas = chrFlgVentas;
	}

	@Column(name = "chr_flg_fact", length = 1)
	public String getChrFlgFactu() {
		return this.chrFlgFactu;
	}

	public void setChrFlgFactu(String chrFlgFactu) {
		this.chrFlgFactu = chrFlgFactu;
	}
}