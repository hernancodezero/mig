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

import pe.com.mig.model.entity.sppi.TEspecifica;

/**
 * TDetalleTranfer generated by hbm2java
 */
@Entity
@Table(name = "t_detalle_tranfer", schema = "mig")
public class TDetalleTranfer implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private int srlIdDetalle;
	private TTransferencia TTransferencia;
	private TEspecifica TEspecifica;	
	private BigDecimal numImpPartida;
	private Integer intIdfRegistro;
	private String chrCodUsuaCreacion;
	private Date dteFecCreacion;
	private String chrCodUsuaModifica;
	private Date dteFecModifica;
	private String ChrCodMeta;

	public TDetalleTranfer() {
	}
	
	public TDetalleTranfer(int srlIdDetalle) {
		this.srlIdDetalle = srlIdDetalle;
	}

	public TDetalleTranfer(int srlIdDetalle, TTransferencia TTransferencia, String chrCodUsuaCreacion,
			Date dteFecCreacion) {
		this.srlIdDetalle = srlIdDetalle;
		this.TTransferencia = TTransferencia;
		this.chrCodUsuaCreacion = chrCodUsuaCreacion;
		this.dteFecCreacion = dteFecCreacion;
	}

	public TDetalleTranfer(int srlIdDetalle, TTransferencia TTransferencia,BigDecimal numImpPartida,
			Integer intIdfRegistro, String chrCodUsuaCreacion, Date dteFecCreacion, String chrCodUsuaModifica,
			Date dteFecModifica, String ChrCodMeta) {
		this.srlIdDetalle = srlIdDetalle;
		this.TTransferencia = TTransferencia;
		this.numImpPartida = numImpPartida;
		this.intIdfRegistro = intIdfRegistro;
		this.chrCodUsuaCreacion = chrCodUsuaCreacion;
		this.dteFecCreacion = dteFecCreacion;
		this.chrCodUsuaModifica = chrCodUsuaModifica;
		this.dteFecModifica = dteFecModifica;
		this.ChrCodMeta = ChrCodMeta;
	}

	@Id
	@SequenceGenerator(name = "seq_detalle_tranfer", sequenceName = "mig.t_detalle_tranfer_srl_id_detalle_seq")
	@GeneratedValue(generator = "seq_detalle_tranfer")
	@Column(name = "srl_id_detalle", unique = true, nullable = false)
	public int getSrlIdDetalle() {
		return this.srlIdDetalle;
	}

	public void setSrlIdDetalle(int srlIdDetalle) {
		this.srlIdDetalle = srlIdDetalle;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_transferencia", nullable = false)
	public TTransferencia getTTransferencia() {
		return this.TTransferencia;
	}

	public void setTTransferencia(TTransferencia TTransferencia) {
		this.TTransferencia = TTransferencia;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "srl_id_esp")
	public TEspecifica getTEspecifica() {
		return this.TEspecifica;
	}

	public void setTEspecifica(TEspecifica TEspecifica) {
		this.TEspecifica = TEspecifica;
	}

	@Column(name = "chr_cod_meta")
	public String getChrCodMeta() {
		return ChrCodMeta;
	}

	public void setChrCodMeta(String chrCodMeta) {
		ChrCodMeta = chrCodMeta;
	}

	@Column(name = "num_imp_partida", precision = 15)
	public BigDecimal getNumImpPartida() {
		return this.numImpPartida;
	}

	public void setNumImpPartida(BigDecimal numImpPartida) {
		this.numImpPartida = numImpPartida;
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

}
