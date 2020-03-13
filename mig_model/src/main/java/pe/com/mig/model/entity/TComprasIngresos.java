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
 * TComprasIngresos generated by hbm2java
 */
@Entity
@Table(name = "t_compras_ingresos", schema = "mig")
public class TComprasIngresos implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private int srlIdCompras;
	private TContratos TContratos;
	private TTipoComprobante TTipoComprobante;
	private TTipoMoneda TTipoMoneda;
	private TTipoProveedor TTipoProveedor;
	private TPersonalCuarta TPersonalCuarta;
	private TFteFto TFteFto;
	private TSeries TSeries;
	private TMedioPago TMedioPago;
	private Unidadoperativa unidadoperativa;
	private TbtRegistroNac tbtRegistroNac;
	private TSucursal tsucursal;
	private TDireccionFactura TDireccionFactura;
	private Integer intIdfTransaccion;
	private String chrSerComprobante;
	private String chrNumComprobante;
	private Date dteFecComprobante;
	private Integer intNumSiaf;
	private BigDecimal numTipCambio;
	private String chrTipOperacion;
	private String chrNumDocuOperacion;
	private Date dteFecDocoperacion;
	private String chrNumSeriOperacion;
	private String chrNumCompOperacion;
	private Integer intNumSiafOperacion;
	private BigDecimal numImpCompOperacion;
	private BigDecimal numImpTotal;
	private String chrTipServicio;
	private BigDecimal numImpServicio;
	private Date dteFecPagservicio;
	private Date dteFecVtoservicio;
	private String chrNumConstancia;
	private BigDecimal numImpDeposito;
	private Date dteFecCondeposito;
	private Integer intPorDeposito;
	private String chrNumDocuEmpresa;
	private Date dteFecDocuEmpresa;
	private String chrNumDocuDerivacion;
	private Date dteFecDocuDerivacion;
	private BigDecimal numImpAfecto;
	private BigDecimal numImpNoafecto;
	private BigDecimal numImpIgv;
	private BigDecimal numImpIsc;
	private BigDecimal numImpVtotal;
	private Integer intIdfRegistro;
	private Integer intCodPadComIngresos;
	private String chrNumVoucher;
	private Date dteFecVoucher;
	private BigDecimal numImpVoucher;
	private Integer intMes;
	private String chrNumCtaCte;
	private String chrNumCpGiro;
	private String chrCodUsuaCreacion;
	private Date dteFecCreacion;
	private String chrCodUsuaModifica;
	private Date dteFecModifica;
	private String chrTipOrden;
	private Date dteFecOrden;
	private String chrNumOrden;
	private String chrCpReten;
	private String chrMedPago;
	private String chrDesGlosa;
	private Integer srlIdCtaCte;
	private Date dteFecPagoCP;
	private String chrTipFact;
	private Integer intAnno;
	//private Integer srlIntDirec;
	private Set<TDetalleCompras> TDetalleComprases = new HashSet<TDetalleCompras>(0);
	private Set<TDetalleIngresos> TDetalleIngresos = new HashSet<TDetalleIngresos>(0);
	private Set<TDetalleVoucher> TDetalleVoucher = new HashSet<TDetalleVoucher>(0);

	public TComprasIngresos() {
	}

	public TComprasIngresos(int srlIdCompras) {
		this.srlIdCompras = srlIdCompras;
	}
	

	public TComprasIngresos(int srlIdCompras, TContratos TContratos, TTipoMoneda TTipoMoneda,
			TTipoProveedor TTipoProveedor, String chrCodUsuaCreacion, Date dteFecCreacion) {
		this.srlIdCompras = srlIdCompras;
		this.TContratos = TContratos;
		this.TTipoMoneda = TTipoMoneda;
		this.TTipoProveedor = TTipoProveedor;
		this.chrCodUsuaCreacion = chrCodUsuaCreacion;
		this.dteFecCreacion = dteFecCreacion;
	}

	public TComprasIngresos(int srlIdCompras, TContratos TContratos, TTipoComprobante TTipoComprobante,
			TTipoMoneda TTipoMoneda, TTipoProveedor TTipoProveedor, TSeries TSeries, TDireccionFactura TDireccionFactura,
			Integer intIdfTransaccion, String chrSerComprobante,
			String chrNumComprobante, Date dteFecComprobante, Integer intNumSiaf, BigDecimal numTipCambio,
			String chrTipOperacion, String chrNumDocuOperacion, Date dteFecDocoperacion, String chrNumSeriOperacion,
			String chrNumCompOperacion, Integer intNumSiafOperacion, BigDecimal numImpCompOperacion,
			String chrTipServicio, BigDecimal numImpServicio, Date dteFecPagservicio, Date dteFecVtoservicio,
			String chrNumConstancia, BigDecimal numImpDeposito, Date dteFecCondeposito, Integer intPorDeposito,
			String chrNumDocuEmpresa, Date dteFecDocuEmpresa, String chrNumDocuDerivacion, BigDecimal numImpAfecto,
			BigDecimal numImpNoafecto, BigDecimal numImpIgv, BigDecimal numImpIsc, BigDecimal numImpTotal,
			Integer intIdfRegistro, String chrCodUsuaCreacion, Date dteFecCreacion, String chrCodUsuaModifica,
			Date dteFecModifica, String chrTipOrden,Date dteFecOrden,String chrNumOrden,String chrCpReten, String chrMedPago,
			String chrDesGlosa, int srlIdCtaCte,Date dteFecPagoCP, int srlIntDirec,
			Set<TDetalleCompras> TDetalleComprases, Set<TDetalleIngresos> TDetalleIngresoses) {
		this.srlIdCompras = srlIdCompras;
		this.TContratos = TContratos;
		this.TTipoComprobante = TTipoComprobante;
		this.TTipoMoneda = TTipoMoneda;
		this.TTipoProveedor = TTipoProveedor;
		this.TSeries = TSeries;
		this.TDireccionFactura = TDireccionFactura;
		this.intIdfTransaccion = intIdfTransaccion;
		this.chrSerComprobante = chrSerComprobante;
		this.chrNumComprobante = chrNumComprobante;
		this.dteFecComprobante = dteFecComprobante;
		this.intNumSiaf = intNumSiaf;
		this.numTipCambio = numTipCambio;
		this.chrTipOperacion = chrTipOperacion;
		this.chrNumDocuOperacion = chrNumDocuOperacion;
		this.dteFecDocoperacion = dteFecDocoperacion;
		this.chrNumSeriOperacion = chrNumSeriOperacion;
		this.chrNumCompOperacion = chrNumCompOperacion;
		this.intNumSiafOperacion = intNumSiafOperacion;
		this.numImpCompOperacion = numImpCompOperacion;
		this.chrTipServicio = chrTipServicio;
		this.numImpServicio = numImpServicio;
		this.dteFecPagservicio = dteFecPagservicio;
		this.dteFecVtoservicio = dteFecVtoservicio;
		this.chrNumConstancia = chrNumConstancia;
		this.numImpDeposito = numImpDeposito;
		this.dteFecCondeposito = dteFecCondeposito;
		this.intPorDeposito = intPorDeposito;
		this.chrNumDocuEmpresa = chrNumDocuEmpresa;
		this.dteFecDocuEmpresa = dteFecDocuEmpresa;
		this.chrNumDocuDerivacion = chrNumDocuDerivacion;
		this.numImpAfecto = numImpAfecto;
		this.numImpNoafecto = numImpNoafecto;
		this.numImpIgv = numImpIgv;
		this.numImpIsc = numImpIsc;
		this.numImpTotal = numImpTotal;
		this.intIdfRegistro = intIdfRegistro;
		this.chrCodUsuaCreacion = chrCodUsuaCreacion;
		this.dteFecCreacion = dteFecCreacion;
		this.chrCodUsuaModifica = chrCodUsuaModifica;
		this.dteFecModifica = dteFecModifica;
		this.chrTipOrden = chrTipOrden;
		this.dteFecOrden = dteFecOrden;
		this.chrNumOrden = chrNumOrden;
		this.chrCpReten = chrCpReten;
		this.chrMedPago = chrMedPago;
		this.chrDesGlosa = chrDesGlosa;
		this.srlIdCtaCte = srlIdCtaCte;
		this.dteFecPagoCP = dteFecPagoCP;
		//this.srlIntDirec = srlIntDirec;
		this.TDetalleComprases = TDetalleComprases;
		this.TDetalleIngresos = TDetalleIngresoses;
	
	}

	@Id
	@SequenceGenerator(name = "seq_compras_ingresos", sequenceName = "mig.t_compras_ingresos_srl_id_compras_seq")
	@GeneratedValue(generator = "seq_compras_ingresos")
	@Column(name = "srl_id_compras", unique = true, nullable = false)
	public int getSrlIdCompras() {
		return this.srlIdCompras;
	}

	public void setSrlIdCompras(int srlIdCompras) {
		this.srlIdCompras = srlIdCompras;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "srl_id_contrato")
	public TContratos getTContratos() {
		return this.TContratos;
	}

	public void setTContratos(TContratos TContratos) {
		this.TContratos = TContratos;
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
	@JoinColumn(name = "srl_id_moneda", nullable = false)
	public TTipoMoneda getTTipoMoneda() {
		return this.TTipoMoneda;
	}

	public void setTTipoMoneda(TTipoMoneda TTipoMoneda) {
		this.TTipoMoneda = TTipoMoneda;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "srl_id_proveedor")
	public TTipoProveedor getTTipoProveedor() {
		return this.TTipoProveedor;
	}

	public void setTTipoProveedor(TTipoProveedor TTipoProveedor) {
		this.TTipoProveedor = TTipoProveedor;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "srl_id_personal")
	public TPersonalCuarta getTPersonalCuarta() {
		return this.TPersonalCuarta;
	}
	


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "srl_id_fte", nullable = false)
	public TFteFto getTFteFto() {
		return this.TFteFto;
	}

	public void setTFteFto(TFteFto tFteFto) {
		this.TFteFto = tFteFto;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "srl_id_medio")
	public TMedioPago getTMedioPago() {
		return this.TMedioPago;
	}

	public void setTMedioPago(TMedioPago TMedioPago) {
		this.TMedioPago = TMedioPago;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "srl_id_sucur")
	public TSucursal getTSucursal() {
		return this.tsucursal;
	}

	public void setTSucursal(TSucursal tsucursal) {
		this.tsucursal = tsucursal;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "srl_id_serie")
	public TSeries getTSeries() {
		return this.TSeries;
	}

	public void setTSeries(TSeries TSeries) {
		this.TSeries = TSeries;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "srl_direcc")
	public TDireccionFactura getTDireccionFactura() {
		return this.TDireccionFactura;
	}

	public void setTDireccionFactura(TDireccionFactura TDireccionFactura) {
		this.TDireccionFactura = TDireccionFactura;
	}
	
	public void setTPersonalCuarta(TPersonalCuarta tPersonalCuarta) {
		TPersonalCuarta = tPersonalCuarta;
	}
	@Column(name = "int_idf_transaccion")
	public Integer getIntIdfTransaccion() {
		return this.intIdfTransaccion;
	}

	public void setIntIdfTransaccion(Integer intIdfTransaccion) {
		this.intIdfTransaccion = intIdfTransaccion;
	}

	@Column(name = "chr_ser_comprobante", length = 20)
	public String getChrSerComprobante() {
		return this.chrSerComprobante;
	}

	public void setChrSerComprobante(String chrSerComprobante) {
		this.chrSerComprobante = chrSerComprobante;
	}

	@Column(name = "chr_num_comprobante", length = 20)
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

	@Column(name = "int_num_siaf")
	public Integer getIntNumSiaf() {
		return this.intNumSiaf;
	}

	public void setIntNumSiaf(Integer intNumSiaf) {
		this.intNumSiaf = intNumSiaf;
	}

	@Column(name = "num_tip_cambio", precision = 5, scale = 3)
	public BigDecimal getNumTipCambio() {
		return this.numTipCambio;
	}

	public void setNumTipCambio(BigDecimal numTipCambio) {
		this.numTipCambio = numTipCambio;
	}

	@Column(name = "chr_tip_operacion", length = 1)
	public String getChrTipOperacion() {
		return this.chrTipOperacion;
	}

	public void setChrTipOperacion(String chrTipOperacion) {
		this.chrTipOperacion = chrTipOperacion;
	}

	@Column(name = "chr_num_docu_operacion", length = 15)
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

	@Column(name = "chr_num_seri_operacion", length = 7)
	public String getChrNumSeriOperacion() {
		return this.chrNumSeriOperacion;
	}

	public void setChrNumSeriOperacion(String chrNumSeriOperacion) {
		this.chrNumSeriOperacion = chrNumSeriOperacion;
	}

	@Column(name = "chr_num_comp_operacion", length = 10)
	public String getChrNumCompOperacion() {
		return this.chrNumCompOperacion;
	}

	public void setChrNumCompOperacion(String chrNumCompOperacion) {
		this.chrNumCompOperacion = chrNumCompOperacion;
	}

	@Column(name = "int_num_siaf_operacion")
	public Integer getIntNumSiafOperacion() {
		return this.intNumSiafOperacion;
	}

	public void setIntNumSiafOperacion(Integer intNumSiafOperacion) {
		this.intNumSiafOperacion = intNumSiafOperacion;
	}

	@Column(name = "num_imp_comp_operacion", precision = 10)
	public BigDecimal getNumImpCompOperacion() {
		return this.numImpCompOperacion;
	}

	public void setNumImpCompOperacion(BigDecimal numImpCompOperacion) {
		this.numImpCompOperacion = numImpCompOperacion;
	}

	@Column(name = "num_imp_total", precision = 10)
	public BigDecimal getNumImpTotal() {
		return this.numImpTotal;
	}

	public void setNumImpTotal(BigDecimal numImpTotal) {
		this.numImpTotal = numImpTotal;
	}

	@Column(name = "chr_tip_servicio", length = 1)
	public String getChrTipServicio() {
		return this.chrTipServicio;
	}

	public void setChrTipServicio(String chrTipServicio) {
		this.chrTipServicio = chrTipServicio;
	}

	@Column(name = "chr_tip_orden", length = 1)
	public String getChrTipOrden() {
		return this.chrTipOrden;
	}

	public void setChrTipOrden(String chrTipOrden) {
		this.chrTipOrden = chrTipOrden;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name = "dte_fec_orden", length = 13)
	public Date getDteFecOrden() {
		return this.dteFecOrden;
	}

	public void setDteFecOrden(Date dteFecOrden) {
		this.dteFecOrden = dteFecOrden;
	}	
	
	@Column(name = "chr_num_orden", length = 10)
	public String getChrNumOrden() {
		return this.chrNumOrden;
	}

	public void setChrNumOrden(String chrNumOrden) {
		this.chrNumOrden = chrNumOrden;
	}

	@Column(name = "chr_cp_reten", length = 1)
	public String getChrCpReten() {
		return this.chrCpReten;
	}

	public void setChrCpReten(String chrCpReten) {
		this.chrCpReten = chrCpReten;
	}

	@Column(name = "chr_med_pago", length = 1)
	public String getChrMedPago() {
		return this.chrMedPago;
	}

	public void setChrMedPago(String chrMedPago) {
		this.chrMedPago = chrMedPago;
	}
	
	@Column(name = "num_imp_servicio", precision = 10)
	public BigDecimal getNumImpServicio() {
		return this.numImpServicio;
	}

	public void setNumImpServicio(BigDecimal numImpServicio) {
		this.numImpServicio = numImpServicio;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "dte_fec_pagservicio", length = 13)
	public Date getDteFecPagservicio() {
		return this.dteFecPagservicio;
	}

	public void setDteFecPagservicio(Date dteFecPagservicio) {
		this.dteFecPagservicio = dteFecPagservicio;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "dte_fec_vtoservicio", length = 13)
	public Date getDteFecVtoservicio() {
		return this.dteFecVtoservicio;
	}

	public void setDteFecVtoservicio(Date dteFecVtoservicio) {
		this.dteFecVtoservicio = dteFecVtoservicio;
	}

	@Column(name = "chr_num_constancia", length = 18)
	public String getChrNumConstancia() {
		return this.chrNumConstancia;
	}

	public void setChrNumConstancia(String chrNumConstancia) {
		this.chrNumConstancia = chrNumConstancia;
	}

	@Column(name = "num_imp_deposito", precision = 10)
	public BigDecimal getNumImpDeposito() {
		return this.numImpDeposito;
	}

	public void setNumImpDeposito(BigDecimal numImpDeposito) {
		this.numImpDeposito = numImpDeposito;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "dte_fec_condeposito", length = 13)
	public Date getDteFecCondeposito() {
		return this.dteFecCondeposito;
	}

	public void setDteFecCondeposito(Date dteFecCondeposito) {
		this.dteFecCondeposito = dteFecCondeposito;
	}

	@Column(name = "int_por_deposito")
	public Integer getIntPorDeposito() {
		return this.intPorDeposito;
	}

	public void setIntPorDeposito(Integer intPorDeposito) {
		this.intPorDeposito = intPorDeposito;
	}

	@Column(name = "chr_num_docu_empresa", length = 5)
	public String getChrNumDocuEmpresa() {
		return this.chrNumDocuEmpresa;
	}

	public void setChrNumDocuEmpresa(String chrNumDocuEmpresa) {
		this.chrNumDocuEmpresa = chrNumDocuEmpresa;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "dte_fec_docu_empresa", length = 13)
	public Date getDteFecDocuEmpresa() {
		return this.dteFecDocuEmpresa;
	}

	public void setDteFecDocuEmpresa(Date dteFecDocuEmpresa) {
		this.dteFecDocuEmpresa = dteFecDocuEmpresa;
	}

	@Column(name = "chr_num_docu_derivacion", length = 5)
	public String getChrNumDocuDerivacion() {
		return this.chrNumDocuDerivacion;
	}

	public void setChrNumDocuDerivacion(String chrNumDocuDerivacion) {
		this.chrNumDocuDerivacion = chrNumDocuDerivacion;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "dte_fec_docu_derivacion", length = 13)
	public Date getDteFecDocuDerivacion() {
		return this.dteFecDocuDerivacion;
	}

	public void setDteFecDocuDerivacion(Date dteFecDocuDerivacion) {
		this.dteFecDocuDerivacion = dteFecDocuDerivacion;
	}

	@Column(name = "num_imp_afecto", precision = 10)
	public BigDecimal getNumImpAfecto() {
		return this.numImpAfecto;
	}

	public void setNumImpAfecto(BigDecimal numImpAfecto) {
		this.numImpAfecto = numImpAfecto;
	}

	@Column(name = "num_imp_noafecto", precision = 10)
	public BigDecimal getNumImpNoafecto() {
		return this.numImpNoafecto;
	}

	public void setNumImpNoafecto(BigDecimal numImpNoafecto) {
		this.numImpNoafecto = numImpNoafecto;
	}

	@Column(name = "num_imp_igv", precision = 10)
	public BigDecimal getNumImpIgv() {
		return this.numImpIgv;
	}

	public void setNumImpIgv(BigDecimal numImpIgv) {
		this.numImpIgv = numImpIgv;
	}

	@Column(name = "num_imp_isc", precision = 10)
	public BigDecimal getNumImpIsc() {
		return this.numImpIsc;
	}

	public void setNumImpIsc(BigDecimal numImpIsc) {
		this.numImpIsc = numImpIsc;
	}

	@Column(name = "num_imp_vtotal", precision = 15)
	public BigDecimal getNumImpVtotal() {
		return this.numImpVtotal;
	}

	public void setNumImpVtotal(BigDecimal numImpVtotal) {
		this.numImpVtotal = numImpVtotal;
	}

	@Column(name = "int_idf_registro")
	public Integer getIntIdfRegistro() {
		return this.intIdfRegistro;
	}

	public void setIntIdfRegistro(Integer intIdfRegistro) {
		this.intIdfRegistro = intIdfRegistro;
	}

	@Column(name = "int_cod_pad_com_ingresos")
	public Integer getIntCodPadComIngresos() {
		return this.intCodPadComIngresos;
	}

	public void setIntCodPadComIngresos(Integer intCodPadComIngresos) {
		this.intCodPadComIngresos = intCodPadComIngresos;
	}

	@Column(name = "chr_num_voucher", length = 10)
	public String getChrNumVoucher() {
		return this.chrNumVoucher;
	}

	public void setChrNumVoucher(String chrNumVoucher) {
		this.chrNumVoucher = chrNumVoucher;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "dte_fec_voucher", length = 13)
	public Date getDteFecVoucher() {
		return this.dteFecVoucher;
	}

	public void setDteFecVoucher(Date dteFecVoucher) {
		this.dteFecVoucher = dteFecVoucher;
	}

	@Column(name = "num_imp_voucher", precision = 10)
	public BigDecimal getNumImpVoucher() {
		return this.numImpVoucher;
	}

	public void setNumImpVoucher(BigDecimal numImpVoucher) {
		this.numImpVoucher = numImpVoucher;
	}
	
	@Column(name = "int_mes")
	public Integer getIntMes() {
		return this.intMes;
	}
	public void setIntMes(Integer intMes) {
		this.intMes = intMes;
	}
	/**
	 * @return the intAnno
	 */
	@Column(name = "int_anno")
	public Integer getIntAnno() {
		return intAnno;
	}

	/**
	 * @param intAnno the intAnno to set
	 */
	public void setIntAnno(Integer intAnno) {
		this.intAnno = intAnno;
	}


	
	@Column(name = "chr_num_ctacte", length = 15)
	public String getChrNumCtaCte() {
		return this.chrNumCtaCte;
	}

	public void setChrNumCtaCte(String chrNumCtaCte) {
		this.chrNumCtaCte = chrNumCtaCte;
	}

	@Column(name = "chr_num_cp_giro", length = 10)
	public String getChrNumCpGiro() {
		return this.chrNumCpGiro;
	}

	public void setChrNumCpGiro(String chrNumCpGiro) {
		this.chrNumCpGiro = chrNumCpGiro;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TComprasIngresos")
	public Set<TDetalleCompras> getTDetalleComprases() {
		return this.TDetalleComprases;
	}

	public void setTDetalleComprases(Set<TDetalleCompras> TDetalleComprases) {
		this.TDetalleComprases = TDetalleComprases;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TComprasIngresos")
	public Set<TDetalleIngresos> getTDetalleIngresos() {
		return this.TDetalleIngresos;
	}

	public void setTDetalleIngresos(Set<TDetalleIngresos> tDetalleIngresos) {
		this.TDetalleIngresos = tDetalleIngresos;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TComprasIngresos")
	public Set<TDetalleVoucher> getTDetalleVoucher() {
		return TDetalleVoucher;
	}

	public void setTDetalleVoucher(Set<TDetalleVoucher> tDetalleVoucher) {
		this.TDetalleVoucher = tDetalleVoucher;
	}
	
	/**
	 * @return the chrDesGlosa
	 */
	@Column(name = "chr_des_glosa", length = 10)
	public String getChrDesGlosa() {
		return chrDesGlosa;
	}

	/**
	 * @param chrDesGlosa the chrDesGlosa to set
	 */
	public void setChrDesGlosa(String chrDesGlosa) {
		this.chrDesGlosa = chrDesGlosa;
	}
	
	/**
	 * @return the srlIdCtaCte
	 */
	@Column(name = "srl_id_ctacte")
	public Integer getSrlIdCtaCte() {
		return srlIdCtaCte;
	}

	/**
	 * @param srlIdCtaCte the srlIdCtaCte to set
	 */
	public void setSrlIdCtaCte(Integer srlIdCtaCte) {
		this.srlIdCtaCte = srlIdCtaCte;
	}
	
	/**
	 * @return the dteFecPagoCP
	*/ 
	@Temporal(TemporalType.DATE)
	@Column(name = "dte_fec_pago_cp", length = 13)
	public Date getDteFecPagoCP() {
		return dteFecPagoCP;
	}

	/**
	 * @param dteFecPagoCP the dteFecPagoCP to set
	*/ 
	public void setDteFecPagoCP(Date dteFecPagoCP) {
		this.dteFecPagoCP = dteFecPagoCP;
	}	
	/**
	 * @return the chrTipFact
	 */
	@Column(name = "chr_tip_fact", length = 1)
	public String getChrTipFact() {
		return chrTipFact;
	}

	/**
	 * @param chrTipFact the chrTipFact to set
	 */
	public void setChrTipFact(String chrTipFact) {
		this.chrTipFact = chrTipFact;
	}
/*
	@Column(name = "srl_direcc")
	public Integer getSrlIntDirec() {
		return srlIntDirec;
	}

	public void setSrlIntDirec(Integer srlIntDirec) {
		this.srlIntDirec = srlIntDirec;
	}
*/
	
}
