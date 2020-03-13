package pe.com.mig.model.entity;
// Generated 02/07/2016 12:36:04 PM by Hibernate Tools 4.3.1

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

import pe.com.mig.model.entity.sppi.TEspecifica;

/**
 * TDetalleIngresos generated by hbm2java
 */
@Entity
@Table(name = "t_detalle_ingresos", schema = "mig")
public class TDetalleIngresos implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private int srlIdDetalle;
	private TComprasIngresos TComprasIngresos;
	private TProducto TProducto;
	private TTariBoleto TTariBoleto;
	private TTariServicio TTariServicio;
	private TTariTupa TTariTupa;
	private TOtros TOtros;
	private TCuentaContable TCuentaContable;
	private TEspecifica TEspecifica;
	private String chrTipTransaccion;
	private String chrCtaPresupuestal;
	private BigDecimal numPreUnitario;
	private Integer intCanDias;
	//private Integer intCanProducto;
	private BigDecimal intCanProducto;
	private BigDecimal numPreUnitProducto;
	private Integer numSerBoleto;
	private Integer intIniBoleto;
	private Integer intFinBoleto;
	private BigDecimal numPreUnitBoleto;
	private String chrTipVenta;
	private BigDecimal numImpAfecto;
	private BigDecimal numImpNoafecto;
	private BigDecimal numImpIgv;
	private BigDecimal numImpIsc;
	private Integer intIdfRegistro;
	private String chrCodUsuaCreacion;	
	private Date dteFecCreacion;
	private String chrCodUsuaModifica;
	private Date dteFecModifica;
	private Integer intCanPers;
	private String chrCodMeta;
	//
	
	public TDetalleIngresos() {
	}
	
	public TDetalleIngresos(int srlIdDetalle) {
		this.srlIdDetalle = srlIdDetalle;
	}

	public TDetalleIngresos(int srlIdDetalle, TProducto TProducto, TTariBoleto TTariBoleto, TTariServicio TTariServicio,
			TTariTupa TTariTupa, String chrTipTransaccion, String chrCtaPresupuestal, String chrCodUsuaCreacion,
			Date dteFecCreacion) {
		this.srlIdDetalle = srlIdDetalle;
		this.TProducto = TProducto;
		this.TTariBoleto = TTariBoleto;
		this.TTariServicio = TTariServicio;
		this.TTariTupa = TTariTupa;
		this.chrTipTransaccion = chrTipTransaccion;
		this.chrCtaPresupuestal = chrCtaPresupuestal;
		this.chrCodUsuaCreacion = chrCodUsuaCreacion;
		this.dteFecCreacion = dteFecCreacion;
	}

	public TDetalleIngresos(int srlIdDetalle, TComprasIngresos TComprasIngresos, TProducto TProducto,
			TTariBoleto TTariBoleto, TTariServicio TTariServicio, TTariTupa TTariTupa, TCuentaContable TCuentaContable, TEspecifica TEspecifica, String chrTipTransaccion,
			String chrCtaPresupuestal, BigDecimal numPreUnitario, Integer intCanDias, Integer intCanPers, BigDecimal intCanProducto,
			BigDecimal numPreUnitProducto, Integer numSerBoleto, Integer intIniBoleto, Integer intFinBoleto,
			BigDecimal numPreUnitBoleto, String chrCodMeta, String chrCodUsuaCreacion, Integer intIdfRegistro, Date dteFecCreacion,
			String chrCodUsuaModifica, Date dteFecModifica) {
		this.srlIdDetalle = srlIdDetalle;
		this.TComprasIngresos = TComprasIngresos;
		this.TProducto = TProducto;
		this.TTariBoleto = TTariBoleto;
		this.TTariServicio = TTariServicio;
		this.TTariTupa = TTariTupa;
		this.TCuentaContable = TCuentaContable;
		this.TEspecifica= TEspecifica;
		this.chrTipTransaccion = chrTipTransaccion;
		this.chrCtaPresupuestal = chrCtaPresupuestal;
		this.numPreUnitario = numPreUnitario;
		this.intCanDias = intCanDias;
		this.intCanPers = intCanPers;
		this.intCanProducto = intCanProducto;
		this.numPreUnitProducto = numPreUnitProducto;
		this.numSerBoleto = numSerBoleto;
		this.intIniBoleto = intIniBoleto;
		this.intFinBoleto = intFinBoleto;
		this.numPreUnitBoleto = numPreUnitBoleto;
		this.chrCodUsuaCreacion = chrCodUsuaCreacion;
		this.intIdfRegistro = intIdfRegistro;
		this.dteFecCreacion = dteFecCreacion;
		this.chrCodUsuaModifica = chrCodUsuaModifica;
		this.dteFecModifica = dteFecModifica;
		this.chrCodMeta = chrCodMeta;
	}

	@Id
	@SequenceGenerator(name = "seq_detalle_ingresos", sequenceName = "mig.t_detalle_ingresos_srl_id_detalle_seq")
	@GeneratedValue(generator = "seq_detalle_ingresos")
	@Column(name = "srl_id_detalle", unique = true, nullable = false)
	public int getSrlIdDetalle() {
		return this.srlIdDetalle;
	}

	public void setSrlIdDetalle(int srlIdDetalle) {
		this.srlIdDetalle = srlIdDetalle;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "srl_id_compras")
	public TComprasIngresos getTComprasIngresos() {
		return this.TComprasIngresos;
	}

	public void setTComprasIngresos(TComprasIngresos TComprasIngresos) {
		this.TComprasIngresos = TComprasIngresos;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "srl_id_esp")
	public TEspecifica getTEspecifica() {
		return this.TEspecifica;
	}

	public void setTEspecifica(TEspecifica TEspecifica) {
		this.TEspecifica = TEspecifica;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "srl_id_producto")
	public TProducto getTProducto() {
		return this.TProducto;
	}

	public void setTProducto(TProducto TProducto) {
		this.TProducto = TProducto;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "srl_id_boleto")
	public TTariBoleto getTTariBoleto() {
		return this.TTariBoleto;
	}

	public void setTTariBoleto(TTariBoleto TTariBoleto) {
		this.TTariBoleto = TTariBoleto;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "srl_id_servicio")
	public TTariServicio getTTariServicio() {
		return this.TTariServicio;
	}

	public void setTTariServicio(TTariServicio TTariServicio) {
		this.TTariServicio = TTariServicio;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "srl_id_tupa")
	public TTariTupa getTTariTupa() {
		return this.TTariTupa;
	}

	public void setTTariTupa(TTariTupa TTariTupa) {
		this.TTariTupa = TTariTupa;
	}
	
	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="srl_id_otros")
    public TOtros getTOtros() {
        return this.TOtros;
    }
    
    public void setTOtros(TOtros TOtros) {
        this.TOtros = TOtros;
    }
    
	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="srl_id_cuenta")
    public TCuentaContable getTCuentaContable() {
        return this.TCuentaContable;
    }
    
    public void setTCuentaContable(TCuentaContable TCuentaContable) {
        this.TCuentaContable = TCuentaContable;
    }
    

	@Column(name = "chr_tip_transaccion", nullable = false, length = 1)
	public String getChrTipTransaccion() {
		return this.chrTipTransaccion;
	}

	public void setChrTipTransaccion(String chrTipTransaccion) {
		this.chrTipTransaccion = chrTipTransaccion;
	}

	@Column(name = "chr_cta_presupuestal", length = 8)
	public String getChrCtaPresupuestal() {
		return this.chrCtaPresupuestal;
	}

	public void setChrCtaPresupuestal(String chrCtaPresupuestal) {
		this.chrCtaPresupuestal = chrCtaPresupuestal;
	}

	@Column(name = "num_pre_unitario", precision = 10)
	public BigDecimal getNumPreUnitario() {
		return this.numPreUnitario;
	}

	public void setNumPreUnitario(BigDecimal numPreUnitario) {
		this.numPreUnitario = numPreUnitario;
	}

	@Column(name = "int_can_dias")
	public Integer getIntCanDias() {
		return this.intCanDias;
	}

	public void setIntCanDias(Integer intCanDias) {
		this.intCanDias = intCanDias;
	}

	@Column(name = "int_can_producto")
	public BigDecimal getIntCanProducto() {
		return this.intCanProducto;
	}

	public void setIntCanProducto(BigDecimal intCanProducto) {
		this.intCanProducto = intCanProducto;
	}

	@Column(name = "num_pre_unit_producto", precision = 10)
	public BigDecimal getNumPreUnitProducto() {
		return this.numPreUnitProducto;
	}

	public void setNumPreUnitProducto(BigDecimal numPreUnitProducto) {
		this.numPreUnitProducto = numPreUnitProducto;
	}

	@Column(name = "num_ser_boleto")
	public Integer getNumSerBoleto() {
		return this.numSerBoleto;
	}

	public void setNumSerBoleto(Integer numSerBoleto) {
		this.numSerBoleto = numSerBoleto;
	}

	@Column(name = "int_ini_boleto")
	public Integer getIntIniBoleto() {
		return this.intIniBoleto;
	}

	public void setIntIniBoleto(Integer intIniBoleto) {
		this.intIniBoleto = intIniBoleto;
	}

	@Column(name = "int_fin_boleto")
	public Integer getIntFinBoleto() {
		return this.intFinBoleto;
	}

	public void setIntFinBoleto(Integer intFinBoleto) {
		this.intFinBoleto = intFinBoleto;
	}

	@Column(name = "num_pre_unit_boleto", precision = 10)
	public BigDecimal getNumPreUnitBoleto() {
		return this.numPreUnitBoleto;
	}

	public void setNumPreUnitBoleto(BigDecimal numPreUnitBoleto) {
		this.numPreUnitBoleto = numPreUnitBoleto;
	}
	
	@Column(name = "chr_tip_venta", length = 1)
	public String getChrTipVenta() {
		return this.chrTipVenta;
	}

	public void setChrTipVenta(String chrTipVenta) {
		this.chrTipVenta = chrTipVenta;
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

	/**
	 * @return the intCanPers
	 */
	@Column(name = "num_can_pers")
	public Integer getIntCanPers() {
		return intCanPers;
	}

	/**
	 * @param intCanPers the intCanPers to set
	 */
	public void setIntCanPers(Integer intCanPers) {
		this.intCanPers = intCanPers;
	}
	@Column(name = "chr_cod_meta")
	public String getChrCodMeta() {
		return chrCodMeta;
	}

	public void setChrCodMeta(String chrCodMeta) {
		this.chrCodMeta = chrCodMeta;
	}

}