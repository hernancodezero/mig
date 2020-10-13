package pe.com.mig.model.entity;
// Generated 22/06/2016 01:16:56 AM by Hibernate Tools 4.3.1

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

/**
 * TDetalleContratos generated by hbm2java
 */
@Entity
@Table(name = "t_detalle_contratos", schema = "mig")
public class TDetalleContratos implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private int srlIdDetalle;
	private TContratos TContratos;
	private Integer numMes;
	private BigDecimal numImpPago;
	private Date dteFecPago;
	private Integer intIdfRegistro;
	private String chrCodUsuaCreacion;
	private Date dteFecCreacion;
	private String chrCodUsuaModifica;
	private Date dteFecModifica;
	private Integer chrNumCompPago; 
	private Date dteFecCompPago;

	public TDetalleContratos() {
	}
	
	public TDetalleContratos(int srlIdDetalle) {
		this.srlIdDetalle = srlIdDetalle;
	}

	public TDetalleContratos(int srlIdDetalle, String chrCodUsuaCreacion, Date dteFecCreacion) {
		this.srlIdDetalle = srlIdDetalle;
		this.chrCodUsuaCreacion = chrCodUsuaCreacion;
		this.dteFecCreacion = dteFecCreacion;
	}

	public TDetalleContratos(int srlIdDetalle, TContratos TContratos, Integer numMes, BigDecimal numImpPago,
			Date dteFecPago, String chrCodUsuaCreacion, Date dteFecCreacion, String chrCodUsuaModifica,
			Date dteFecModifica) {
		this.srlIdDetalle = srlIdDetalle;
		this.TContratos = TContratos;
		this.numMes = numMes;
		this.numImpPago = numImpPago;
		this.dteFecPago = dteFecPago;
		this.chrCodUsuaCreacion = chrCodUsuaCreacion;
		this.dteFecCreacion = dteFecCreacion;
		this.chrCodUsuaModifica = chrCodUsuaModifica;
		this.dteFecModifica = dteFecModifica;
	}

	@Id
	@SequenceGenerator(name = "seq_detalle_contratos", sequenceName = "mig.t_detalle_contratos_srl_id_detalle_seq")
	@GeneratedValue(generator = "seq_detalle_contratos")
	@Column(name = "srl_id_detalle", unique = true, nullable = false)
	public int getSrlIdDetalle() {
		return this.srlIdDetalle;
	}

	public void setSrlIdDetalle(int srlIdDetalle) {
		this.srlIdDetalle = srlIdDetalle;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "srl_id_contrato")
	public TContratos getTContratos() {
		return this.TContratos;
	}

	public void setTContratos(TContratos TContratos) {
		this.TContratos = TContratos;
	}

	@Column(name = "int_num_mes")
	public Integer getNumMes() {
		return this.numMes;
	}

	public void setNumMes(Integer numMes) {
		this.numMes = numMes;
	}

	@Column(name = "int_imp_pago", precision = 10)
	public BigDecimal getNumImpPago() {
		return this.numImpPago;
	}

	public void setNumImpPago(BigDecimal numImpPago) {
		this.numImpPago = numImpPago;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "dte_fec_pago", length = 13)
	public Date getDteFecPago() {
		return this.dteFecPago;
	}

	public void setDteFecPago(Date dteFecPago) {
		this.dteFecPago = dteFecPago;
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

	@Column(name = "chr_cod_usua_modifica", length = 30)
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
	 * @return the chrNumCompPago
	 */
	@Column(name = "chr_num_comp_pago", length = 7)
	public Integer getChrNumCompPago() {
		return chrNumCompPago;
	}

	/**
	 * @param chrNumCompPago the chrNumCompPago to set
	 */
	public void setChrNumCompPago(Integer chrNumCompPago) {
		this.chrNumCompPago = chrNumCompPago;
	}

	/**
	 * @return the dteFecCompPago
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "dte_fec_comp_pago", length = 13)
	public Date getDteFecCompPago() {
		return dteFecCompPago;
	}

	/**
	 * @param dteFecCompPago the dteFecCompPago to set
	 */
	public void setDteFecCompPago(Date dteFecCompPago) {
		this.dteFecCompPago = dteFecCompPago;
	}
}