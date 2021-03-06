package pe.com.mig.model.entity;
// Generated 17/07/2016 04:00:33 PM by Hibernate Tools 4.3.1

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import pe.com.mig.model.entity.sde.TbtRegistroNac;
import pe.com.mig.model.entity.sernanp.Unidadoperativa;

/**
 * TCartaFianza generated by hbm2java
 */
@Entity
@Table(name = "t_carta_fianza", schema = "mig")
public class TCartaFianza implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private int srlIdFianza;
	private TEntidadFinanciera TEntidadFinanciera;
	private TTipoProveedor TTipoProveedor;
	private String chrNumCarta;
	private Date dteFecInicio;
	private Date dteFecFinal;
	private Date dteFecDevolucion;
	private String chrConcepto;
	private BigDecimal intImpCarta;
	private String chrCodDocumento;
	private String chrNumDocumento;
	private Date dteFecEnvio;
	private String chrSigOficina;
	private Integer intIdfRegistro;
	private String chrCodUsuaCreacion;
	private Date dteFecCreacion;
	private String chrCodUsuaModifica;
	private Date dteFecModifica;
	private Date dteFecCarta;
	private Date dteFecRecepcion;
	private Date dteFecDocumento;
	private String chrTipOperacion;
	private Unidadoperativa unidadoperativa;
	private TbtRegistroNac tbtRegistroNac;
	private String chrNumFianza;
	private String chrflglegal;
	private String chrNomEstado;
	
	public TCartaFianza() {
	}
	
	public TCartaFianza(int srlIdFianza) {
		this.srlIdFianza = srlIdFianza;
	}

	public TCartaFianza(int srlIdFianza, TEntidadFinanciera TEntidadFinanciera, TTipoProveedor TTipoProveedor,
			String chrCodUsuaCreacion, Date dteFecCreacion) {
		this.srlIdFianza = srlIdFianza;
		this.TEntidadFinanciera = TEntidadFinanciera;
		this.TTipoProveedor = TTipoProveedor;
		this.chrCodUsuaCreacion = chrCodUsuaCreacion;
		this.dteFecCreacion = dteFecCreacion;
	}

	public TCartaFianza(int srlIdFianza, TEntidadFinanciera TEntidadFinanciera, TTipoProveedor TTipoProveedor,
			String chrNumCarta, Date dteFecInicio, Date dteFecFinal, Date dteFecDevolucion, String chrConcepto,
			BigDecimal intImpCarta, String chrCodDocumento, String chrNumDocumento, Date dteFecEnvio,
			String chrSigOficina, Integer intIdfRegistro, String chrCodUsuaCreacion, Date dteFecCreacion,
			String chrCodUsuaModifica, Date dteFecModifica) {
		this.srlIdFianza = srlIdFianza;
		this.TEntidadFinanciera = TEntidadFinanciera;
		this.TTipoProveedor = TTipoProveedor;
		this.chrNumCarta = chrNumCarta;
		this.dteFecInicio = dteFecInicio;
		this.dteFecFinal = dteFecFinal;
		this.dteFecDevolucion = dteFecDevolucion;
		this.chrConcepto = chrConcepto;
		this.intImpCarta = intImpCarta;
		this.chrCodDocumento = chrCodDocumento;
		this.chrNumDocumento = chrNumDocumento;
		this.dteFecEnvio = dteFecEnvio;
		this.chrSigOficina = chrSigOficina;
		this.intIdfRegistro = intIdfRegistro;
		this.chrCodUsuaCreacion = chrCodUsuaCreacion;
		this.dteFecCreacion = dteFecCreacion;
		this.chrCodUsuaModifica = chrCodUsuaModifica;
		this.dteFecModifica = dteFecModifica;
	}

	@Id
	@SequenceGenerator(name = "seq_carta_fianza", sequenceName = "mig.t_carta_fianza_srl_id_fianza_seq")
	@GeneratedValue(generator = "seq_carta_fianza")
	@Column(name = "srl_id_fianza", unique = true, nullable = false)
	public int getSrlIdFianza() {
		return this.srlIdFianza;
	}

	public void setSrlIdFianza(int srlIdFianza) {
		this.srlIdFianza = srlIdFianza;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "srl_id_entidad", nullable = false)
	public TEntidadFinanciera getTEntidadFinanciera() {
		return this.TEntidadFinanciera;
	}

	public void setTEntidadFinanciera(TEntidadFinanciera TEntidadFinanciera) {
		this.TEntidadFinanciera = TEntidadFinanciera;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "srl_id_proveedor", nullable = false)
	public TTipoProveedor getTTipoProveedor() {
		return this.TTipoProveedor;
	}

	public void setTTipoProveedor(TTipoProveedor TTipoProveedor) {
		this.TTipoProveedor = TTipoProveedor;
	}

	@Column(name = "chr_num_carta", length = 15)
	public String getChrNumCarta() {
		return this.chrNumCarta;
	}

	public void setChrNumCarta(String chrNumCarta) {
		this.chrNumCarta = chrNumCarta;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "dte_fec_inicio", length = 13)
	public Date getDteFecInicio() {
		return this.dteFecInicio;
	}

	public void setDteFecInicio(Date dteFecInicio) {
		this.dteFecInicio = dteFecInicio;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "dte_fec_final", length = 13)
	public Date getDteFecFinal() {
		return this.dteFecFinal;
	}

	public void setDteFecFinal(Date dteFecFinal) {
		this.dteFecFinal = dteFecFinal;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "dte_fec_devolucion", length = 13)
	public Date getDteFecDevolucion() {
		return this.dteFecDevolucion;
	}

	public void setDteFecDevolucion(Date dteFecDevolucion) {
		this.dteFecDevolucion = dteFecDevolucion;
	}

	@Column(name = "chr_concepto", length = 250)
	public String getChrConcepto() {
		return this.chrConcepto;
	}

	public void setChrConcepto(String chrConcepto) {
		this.chrConcepto = chrConcepto;
	}

	@Column(name = "int_imp_carta", precision = 12, scale = 2)
	public BigDecimal getIntImpCarta() {
		return this.intImpCarta;
	}

	public void setIntImpCarta(BigDecimal intImpCarta) {
		this.intImpCarta = intImpCarta;
	}

	@Column(name = "chr_cod_documento", length = 2)
	public String getChrCodDocumento() {
		return this.chrCodDocumento;
	}

	public void setChrCodDocumento(String chrCodDocumento) {
		this.chrCodDocumento = chrCodDocumento;
	}

	@Column(name = "chr_num_documento", length = 10)
	public String getChrNumDocumento() {
		return this.chrNumDocumento;
	}

	public void setChrNumDocumento(String chrNumDocumento) {
		this.chrNumDocumento = chrNumDocumento;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "dte_fec_envio", length = 13)
	public Date getDteFecEnvio() {
		return this.dteFecEnvio;
	}

	public void setDteFecEnvio(Date dteFecEnvio) {
		this.dteFecEnvio = dteFecEnvio;
	}

	@Column(name = "chr_sig_oficina", length = 5)
	public String getChrSigOficina() {
		return this.chrSigOficina;
	}

	public void setChrSigOficina(String chrSigOficina) {
		this.chrSigOficina = chrSigOficina;
	}

	@Column(name = "int_idf_registro")
	public Integer getIntIdfRegistro() {
		return this.intIdfRegistro;
	}

	public void setIntIdfRegistro(Integer intIdfRegistro) {
		this.intIdfRegistro = intIdfRegistro;
	}

	@Column(name = "chr_cod_usua_creacion", nullable = false, length = 20)
	public String getChrCodUsuaCreacion() {
		return this.chrCodUsuaCreacion;
	}

	public void setChrCodUsuaCreacion(String chrCodUsuaCreacion) {
		this.chrCodUsuaCreacion = chrCodUsuaCreacion;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "dte_fec_creacion", nullable = false, length = 13)
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

	@Temporal(TemporalType.DATE)
	@Column(name = "dte_fec_carta", length = 13)
	public Date getDteFecCarta() {
		return this.dteFecCarta;
	}


	public void setDteFecCarta(Date dteFecCarta) {
		this.dteFecCarta = dteFecCarta;
	}


	@Temporal(TemporalType.DATE)
	@Column(name = "dte_fec_recepcion", length = 13)
	public Date getDteFecRecepcion() {
		return this.dteFecRecepcion;
	}

	public void setDteFecRecepcion(Date dteFecRecepcion) {
		this.dteFecRecepcion = dteFecRecepcion;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "dte_fec_documento", length = 13)
	public Date getDteFecDocumento() {
		return this.dteFecDocumento;
	}

	public void setDteFecDocumento(Date dteFecDocumento) {
		this.dteFecDocumento = dteFecDocumento;
	}

	@Column(name = "chr_tip_operacion", length = 1)
	public String getChrTipOperacion() {
		return this.chrTipOperacion;
	}

	public void setChrTipOperacion(String chrTipOperacion) {
		this.chrTipOperacion = chrTipOperacion;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idunidad")
	public Unidadoperativa getUnidadoperativa() {
		return this.unidadoperativa;
	}

	public void setUnidadoperativa(Unidadoperativa unidadoperativa) {
		this.unidadoperativa = unidadoperativa;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "srl_id_adm")
	public TbtRegistroNac getTbtRegistroNac() {
		return this.tbtRegistroNac;
	}

	public void setTbtRegistroNac(TbtRegistroNac tbtRegistroNac) {
		this.tbtRegistroNac = tbtRegistroNac;
	}

	/**
	 * @return the chrNumFianza
	 */
	@Column(name = "chr_num_fianza", length = 20)
	public String getChrNumFianza() {
		return chrNumFianza;
	}

	/**
	 * @param chrNumFianza the chrNumFianza to set
	 */
	public void setChrNumFianza(String chrNumFianza) {
		this.chrNumFianza = chrNumFianza;
	}

	/**
	 * @return the chrflglegal
	 */
	@Column(name = "chr_flg_legal", length = 1)
	public String getChrflglegal() {
		return chrflglegal;
	}

	/**
	 * @param chrflglegal the chrflglegal to set
	 */
	public void setChrflglegal(String chrflglegal) {
		this.chrflglegal = chrflglegal;
	}
	
	/**
	 * @return the chrflglegal
	 */
	@Column(name = "chr_nom_estado", length = 5)
	public String getChrNomEstado() {
		return chrNomEstado;
	}
	
	/**
	 * @param chrflglegal the chrflglegal to set
	 */
	public void setChrNomEstado(String chrNomEstado) {
		this.chrNomEstado = chrNomEstado;
	}

	
}