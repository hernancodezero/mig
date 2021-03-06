package pe.com.mig.model.entity;
// Generated 02/07/2016 12:36:04 PM by Hibernate Tools 4.3.1

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
 * TRequeBoletos generated by hbm2java
 */
@Entity
@Table(name = "t_reque_boletos", schema = "mig")
public class TRequeBoletos implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private int srlIdRboleto;
	private Unidadoperativa unidadoperativa;
	private TbtRegistroNac tbtRegistroNac;
	private String chrNumDocu;
	private Date dteFecDocumento;
	private Integer intIdfRegistro;
	private String chrCodUsuaCreacion;
	private Date dteFecCreacion;
	private String chrCodUsuaModifica;
	private Date dteFecModifica;
	private Set<TDetalleBoleto> TDetalleBoletos = new HashSet<TDetalleBoleto>(0);

	public TRequeBoletos() {
	}

	public TRequeBoletos(int srlIdRboleto) {
		this.srlIdRboleto = srlIdRboleto;
	}

	public TRequeBoletos(int srlIdRboleto, String chrNumDocu, Date dteFecDocumento,
			Integer intIdfRegistro, String chrCodUsuaCreacion, Date dteFecCreacion, String chrCodUsuaModifica,
			Date dteFecModifica, Set<TDetalleBoleto> TDetalleBoletos) {
		this.srlIdRboleto = srlIdRboleto;
		this.chrNumDocu = chrNumDocu;
		this.dteFecDocumento = dteFecDocumento;
		this.intIdfRegistro = intIdfRegistro;
		this.chrCodUsuaCreacion = chrCodUsuaCreacion;
		this.dteFecCreacion = dteFecCreacion;
		this.chrCodUsuaModifica = chrCodUsuaModifica;
		this.dteFecModifica = dteFecModifica;
		this.TDetalleBoletos = TDetalleBoletos;
	}

	@Id
	@SequenceGenerator(name = "seq_reque_boletos", sequenceName = "mig.t_reque_boletos_srl_id_rboleto_seq")
	@GeneratedValue(generator = "seq_reque_boletos")
	@Column(name = "srl_id_rboleto", unique = true, nullable = false)
	public int getSrlIdRboleto() {
		return this.srlIdRboleto;
	}

	public void setSrlIdRboleto(int srlIdRboleto) {
		this.srlIdRboleto = srlIdRboleto;
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

	@Column(name = "chr_num_docu", length = 10)
	public String getChrNumDocu() {
		return this.chrNumDocu;
	}

	public void setChrNumDocu(String chrNumDocu) {
		this.chrNumDocu = chrNumDocu;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "dte_fec_documento", length = 13)
	public Date getDteFecDocumento() {
		return this.dteFecDocumento;
	}

	public void setDteFecDocumento(Date dteFecDocumento) {
		this.dteFecDocumento = dteFecDocumento;
	}

	@Column(name = "int_idf_registro")
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TRequeBoletos")
	public Set<TDetalleBoleto> getTDetalleBoletos() {
		return this.TDetalleBoletos;
	}

	public void setTDetalleBoletos(Set<TDetalleBoleto> TDetalleBoletos) {
		this.TDetalleBoletos = TDetalleBoletos;
	}

}
