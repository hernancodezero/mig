package pe.com.mig.model.entity;
// Generated 22/06/2016 01:16:56 AM by Hibernate Tools 4.3.1

import java.math.BigDecimal;
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

import pe.com.mig.model.entity.sde.TbtRegistroNac;
import pe.com.mig.model.entity.sernanp.Unidadoperativa;

/**
 * TTransferencia generated by hbm2java
 */
@Entity
@Table(name = "t_transferencia", schema = "mig")
public class TTransferencia implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private int idTransferencia;
	private TTipoComprobante TTipoComprobante;
	private TTipoMoneda TTipoMoneda;
	private Unidadoperativa unidadoperativa;
	private TbtRegistroNac tbtRegistroNac;
	private Integer intIdfTransaccion;
	private String chrSerComprobante;
	private String chrNumComprobante;
	private Date dteFecComprobante;
	private String chrCodFte;
	private Integer intNumSiaf;
	private BigDecimal numTipCambio;
	private String chrNumDocuOperacion;
	private Date dteFecDocoperacion;
	private Date dteFecTransferencia;
	private BigDecimal numImpTotal;
	private String chrConcepto;
	private Integer intIdfRegistro;
	private String chrCodUsuaCreacion;
	private Date dteFecCreacion;
	private String chrCodUsuaModifica;
	private Date dteFecModifica;
	private String chrNumRendicion;
	private String indTipoFPE;	
	private Integer intMes;
	private Integer intAnno;
	private Set<TDetalleTranfer> TDetalleTranfers = new HashSet<TDetalleTranfer>(0);

	public TTransferencia() {
	}
	
	public TTransferencia(int idTransferencia) {
		this.idTransferencia = idTransferencia;
	}

	public TTransferencia(int idTransferencia, String chrCodUsuaCreacion, Date dteFecCreacion) {
		this.idTransferencia = idTransferencia;
		this.chrCodUsuaCreacion = chrCodUsuaCreacion;
		this.dteFecCreacion = dteFecCreacion;
	}

	public TTransferencia(int idTransferencia, TTipoComprobante TTipoComprobante, TTipoMoneda TTipoMoneda,
			Integer intIdfTransaccion, String chrSerComprobante, String chrNumComprobante, Date dteFecComprobante,
			String chrCodFte, Integer intNumSiaf, BigDecimal numTipCambio,
			String chrNumDocuOperacion, Date dteFecDocoperacion, Date dteFecTransferencia, BigDecimal numImpTotal,
			String chrConcepto, Integer intIdfRegistro, String chrCodUsuaCreacion, Date dteFecCreacion,
			String chrCodUsuaModifica, Date dteFecModifica, String chrNumRendicion, String indTipoFPE, 
			Integer intMes, Integer intAnno, Set<TDetalleTranfer> TDetalleTranfers) {
		this.idTransferencia = idTransferencia;
		this.TTipoComprobante = TTipoComprobante;
		this.TTipoMoneda = TTipoMoneda;
		this.intIdfTransaccion = intIdfTransaccion;
		this.chrSerComprobante = chrSerComprobante;
		this.chrNumComprobante = chrNumComprobante;
		this.dteFecComprobante = dteFecComprobante;
		this.chrCodFte = chrCodFte;
		this.intNumSiaf = intNumSiaf;
		this.numTipCambio = numTipCambio;
		this.chrNumDocuOperacion = chrNumDocuOperacion;
		this.dteFecDocoperacion = dteFecDocoperacion;
		this.dteFecTransferencia = dteFecTransferencia;
		this.numImpTotal = numImpTotal;
		this.chrConcepto = chrConcepto;
		this.intIdfRegistro = intIdfRegistro;
		this.chrCodUsuaCreacion = chrCodUsuaCreacion;
		this.dteFecCreacion = dteFecCreacion;
		this.chrCodUsuaModifica = chrCodUsuaModifica;
		this.dteFecModifica = dteFecModifica;
		this.TDetalleTranfers = TDetalleTranfers;
		this.chrNumRendicion = chrNumRendicion;
		this.indTipoFPE = indTipoFPE;
		this.intMes = intMes;
		this.intAnno = intAnno;
	}

	@Id
	@SequenceGenerator(name = "seq_transferencia", sequenceName = "mig.t_transferencia_id_transferencia_seq")
	@GeneratedValue(generator = "seq_transferencia")
	@Column(name = "id_transferencia", unique = true, nullable = false)
	public int getIdTransferencia() {
		return this.idTransferencia;
	}

	public void setIdTransferencia(int idTransferencia) {
		this.idTransferencia = idTransferencia;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "srl_id_comprobante")
	public TTipoComprobante getTTipoComprobante() {
		return this.TTipoComprobante;
	}

	public void setTTipoComprobante(TTipoComprobante TTipoComprobante) {
		this.TTipoComprobante = TTipoComprobante;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "srl_id_moneda")
	public TTipoMoneda getTTipoMoneda() {
		return this.TTipoMoneda;
	}

	public void setTTipoMoneda(TTipoMoneda TTipoMoneda) {
		this.TTipoMoneda = TTipoMoneda;
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

	@Column(name = "int_idf_transaccion")
	public Integer getIntIdfTransaccion() {
		return this.intIdfTransaccion;
	}

	public void setIntIdfTransaccion(Integer intIdfTransaccion) {
		this.intIdfTransaccion = intIdfTransaccion;
	}

	@Column(name = "chr_ser_comprobante", length = 7)
	public String getChrSerComprobante() {
		return this.chrSerComprobante;
	}

	public void setChrSerComprobante(String chrSerComprobante) {
		this.chrSerComprobante = chrSerComprobante;
	}

	@Column(name = "chr_num_comprobante", length = 10)
	public String getChrNumComprobante() {
		return this.chrNumComprobante;
	}

	public void setChrNumComprobante(String chrNumComprobante) {
		this.chrNumComprobante = chrNumComprobante;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "dte_fec_comprobante", length = 13)
	public Date getDteFecComprobante() {
		return this.dteFecComprobante;
	}

	public void setDteFecComprobante(Date dteFecComprobante) {
		this.dteFecComprobante = dteFecComprobante;
	}

	@Column(name = "chr_cod_fte", length = 1)
	public String getChrCodFte() {
		return this.chrCodFte;
	}

	public void setChrCodFte(String chrCodFte) {
		this.chrCodFte = chrCodFte;
	}

	@Column(name = "int_num_siaf")
	public Integer getIntNumSiaf() {
		return this.intNumSiaf;
	}

	public void setIntNumSiaf(Integer intNumSiaf) {
		this.intNumSiaf = intNumSiaf;
	}

	@Column(name = "num_tip_cambio", precision = 5)
	public BigDecimal getNumTipCambio() {
		return this.numTipCambio;
	}

	public void setNumTipCambio(BigDecimal numTipCambio) {
		this.numTipCambio = numTipCambio;
	}

	@Column(name = "chr_num_docu_operacion", length = 5)
	public String getChrNumDocuOperacion() {
		return this.chrNumDocuOperacion;
	}

	public void setChrNumDocuOperacion(String chrNumDocuOperacion) {
		this.chrNumDocuOperacion = chrNumDocuOperacion;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "dte_fec_docoperacion", length = 13)
	public Date getDteFecDocoperacion() {
		return this.dteFecDocoperacion;
	}

	public void setDteFecDocoperacion(Date dteFecDocoperacion) {
		this.dteFecDocoperacion = dteFecDocoperacion;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "dte_fec_transferencia", length = 13)
	public Date getDteFecTransferencia() {
		return this.dteFecTransferencia;
	}

	public void setDteFecTransferencia(Date dteFecTransferencia) {
		this.dteFecTransferencia = dteFecTransferencia;
	}

	@Column(name = "num_imp_total", precision = 15)
	public BigDecimal getNumImpTotal() {
		return this.numImpTotal;
	}

	public void setNumImpTotal(BigDecimal numImpTotal) {
		this.numImpTotal = numImpTotal;
	}

	@Column(name = "chr_concepto", length = 250)
	public String getChrConcepto() {
		return this.chrConcepto;
	}

	public void setChrConcepto(String chrConcepto) {
		this.chrConcepto = chrConcepto;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TTransferencia")
	public Set<TDetalleTranfer> getTDetalleTranfers() {
		return this.TDetalleTranfers;
	}

	public void setTDetalleTranfers(Set<TDetalleTranfer> TDetalleTranfers) {
		this.TDetalleTranfers = TDetalleTranfers;
	}

	/**
	 * @return the chrNumRendicion
	 */
	@Column(name = "chr_num_rendicion", length = 20)
	public String getChrNumRendicion() {
		return chrNumRendicion;
	}

	/**
	 * @param chrNumRendicion the chrNumRendicion to set
	 */
	public void setChrNumRendicion(String chrNumRendicion) {
		this.chrNumRendicion = chrNumRendicion;
	}

	/**
	 * @return the indTipoFPE
	 */
	@Column(name = "chr_idf_fpe")
	public String getIndTipoFPE() {
		return indTipoFPE;
	}

	/**
	 * @param indTipoFPE the indTipoFPE to set
	 */
	public void setIndTipoFPE(String indTipoFPE) {
		this.indTipoFPE = indTipoFPE;
	}
	@Column(name = "int_mes")
	public Integer getIntMes() {
		return intMes;
	}

	public void setIntMes(Integer intMes) {
		this.intMes = intMes;
	}
	@Column(name = "int_anno")
	public Integer getIntAnno() {
		return intAnno;
	}

	public void setIntAnno(Integer intAnno) {
		this.intAnno = intAnno;
	}
	
	
}
