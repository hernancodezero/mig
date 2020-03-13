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
 * TContratos generated by hbm2java
 */
@Entity
@Table(name = "t_contratos", schema = "mig")
public class TContratos implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private int srlIdContrato;
	private TDocumentoIdentidad TDocumentoIdentidad;
	private TTipoProveedor TTipoProveedor;
	private Unidadoperativa unidadoperativa;
	private TbtRegistroNac tbtRegistroNac;
	private String chrNumContrato;
	private Date dteFecInicio;
	private Date dteFecFinal;
	private String chrTipContrato;
    private String chrNomConcedente;
    private String chrApeConcedente;
    private String chrTipPago;
    private String chrNumComprobante;
    private Date dteFecComprobante;
    private String chrConcepto;
    private BigDecimal intImpContrato;
    private BigDecimal intImpGarantia;
    private BigDecimal intImpAlquiler;
    private BigDecimal intImpTributo;
    private Integer intImpInteres;
    private Integer intIdfRegistro;
	private String chrCodUsuaCreacion;
	private Date dteFecCreacion;
	private String chrCodUsuaModifica;
	private Date dteFecModifica;
	private String chrTipOperacion;
	private Integer SrlIdMoneda;
	
	private Set<TComprasIngresos> TComprasIngresoses = new HashSet<TComprasIngresos>(0);
	private Set<TDetalleContratos> TDetalleContratoses = new HashSet<TDetalleContratos>(0);

	public TContratos() {
	}

	public TContratos(int srlIdContrato) {
		this.srlIdContrato = srlIdContrato;
	}

	@Id
	@SequenceGenerator(name = "seq_contratos", sequenceName = "mig.t_contratos_srl_id_contrato_seq")
	@GeneratedValue(generator = "seq_contratos")
	@Column(name = "srl_id_contrato", unique = true, nullable = false)
	public int getSrlIdContrato() {
		return this.srlIdContrato;
	}

	public void setSrlIdContrato(int srlIdContrato) {
		this.srlIdContrato = srlIdContrato;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "srl_id_documento")
	public TDocumentoIdentidad getTDocumentoIdentidad() {
		return this.TDocumentoIdentidad;
	}

	public void setTDocumentoIdentidad(TDocumentoIdentidad TDocumentoIdentidad) {
		this.TDocumentoIdentidad = TDocumentoIdentidad;
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

	@Column(name = "chr_num_contrato", length = 20)
	public String getChrNumContrato() {
		return this.chrNumContrato;
	}

	public void setChrNumContrato(String chrNumContrato) {
		this.chrNumContrato = chrNumContrato;
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

	@Column(name="chr_tip_contrato", length=1)
    public String getChrTipContrato() {
        return this.chrTipContrato;
    }
    
    public void setChrTipContrato(String chrTipContrato) {
        this.chrTipContrato = chrTipContrato;
    }

    
    @Column(name="chr_nom_concedente", length=30)
    public String getChrNomConcedente() {
        return this.chrNomConcedente;
    }
    
    public void setChrNomConcedente(String chrNomConcedente) {
        this.chrNomConcedente = chrNomConcedente;
    }

    
    @Column(name="chr_ape_concedente", length=30)
    public String getChrApeConcedente() {
        return this.chrApeConcedente;
    }
    
    public void setChrApeConcedente(String chrApeConcedente) {
        this.chrApeConcedente = chrApeConcedente;
    }

    
    @Column(name="chr_tip_pago", length=1)
    public String getChrTipPago() {
        return this.chrTipPago;
    }
    
    public void setChrTipPago(String chrTipPago) {
        this.chrTipPago = chrTipPago;
    }

    
    @Column(name="chr_num_comprobante", length=7)
    public String getChrNumComprobante() {
        return this.chrNumComprobante;
    }
    
    public void setChrNumComprobante(String chrNumComprobante) {
        this.chrNumComprobante = chrNumComprobante;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="dte_fec_comprobante", length=13)
    public Date getDteFecComprobante() {
        return this.dteFecComprobante;
    }
    
    public void setDteFecComprobante(Date dteFecComprobante) {
        this.dteFecComprobante = dteFecComprobante;
    }

    
    @Column(name="chr_concepto", length=500)
    public String getChrConcepto() {
        return this.chrConcepto;
    }
    
    public void setChrConcepto(String chrConcepto) {
        this.chrConcepto = chrConcepto;
    }

    
    @Column(name="int_imp_contrato", precision=10)
    public BigDecimal getIntImpContrato() {
        return this.intImpContrato;
    }
    
    public void setIntImpContrato(BigDecimal intImpContrato) {
        this.intImpContrato = intImpContrato;
    }

    
    @Column(name="int_imp_garantia", precision=10)
    public BigDecimal getIntImpGarantia() {
        return this.intImpGarantia;
    }
    
    public void setIntImpGarantia(BigDecimal intImpGarantia) {
        this.intImpGarantia = intImpGarantia;
    }

    
    @Column(name="int_imp_alquiler", precision=10)
    public BigDecimal getIntImpAlquiler() {
        return this.intImpAlquiler;
    }
    
    public void setIntImpAlquiler(BigDecimal intImpAlquiler) {
        this.intImpAlquiler = intImpAlquiler;
    }

    
    @Column(name="int_imp_tributo", precision=10)
    public BigDecimal getIntImpTributo() {
        return this.intImpTributo;
    }
    
    public void setIntImpTributo(BigDecimal intImpTributo) {
        this.intImpTributo = intImpTributo;
    }

    
    @Column(name="int_imp_interes")
    public Integer getIntImpInteres() {
        return this.intImpInteres;
    }
    
    public void setIntImpInteres(Integer intImpInteres) {
        this.intImpInteres = intImpInteres;
    }

    
    @Column(name="int_idf_registro")
    public Integer getIntIdfRegistro() {
        return this.intIdfRegistro;
    }
    
    public void setIntIdfRegistro(Integer intIdfRegistro) {
        this.intIdfRegistro = intIdfRegistro;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TContratos")
	public Set<TComprasIngresos> getTComprasIngresoses() {
		return this.TComprasIngresoses;
	}

	public void setTComprasIngresoses(Set<TComprasIngresos> TComprasIngresoses) {
		this.TComprasIngresoses = TComprasIngresoses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TContratos")
	public Set<TDetalleContratos> getTDetalleContratoses() {
		return this.TDetalleContratoses;
	}

	public void setTDetalleContratoses(Set<TDetalleContratos> TDetalleContratoses) {
		this.TDetalleContratoses = TDetalleContratoses;
	}

	@Column(name = "chr_tip_operacion", length = 1)
	public String getChrTipOperacion() {
		return this.chrTipOperacion;
	}

	public void setChrTipOperacion(String chrTipOperacion) {
		this.chrTipOperacion = chrTipOperacion;
	}

	/**
	 * @return the srlIdMoneda
	 */
    @Column(name="srl_id_moneda")
	public Integer getSrlIdMoneda() {
		return SrlIdMoneda;
	}
	/**
	 * @param srlIdMoneda the srlIdMoneda to set
	 */
	public void setSrlIdMoneda(Integer srlIdMoneda) {
		SrlIdMoneda = srlIdMoneda;
	}

}
