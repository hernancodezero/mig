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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * TPersonalCuarta generated by hbm2java
 */
@Entity
@Table(name = "t_personal_cuarta", schema = "mig")
public class TPersonalCuarta implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private int srlIdPersonal;
	private TConvenioCuarta TConvenioCuarta;
	private TDocumentoCuarta TDocumentoCuarta;
	private TNacionalidad TNacionalidad;
	private TVia TVia;
	private TZona TZona;
	private String numRuc;
	private String chrNumDocumento;
	private String chrApePaterno;
	private String chrApeMaterno;
	private String chrNombres;
	private Date dteFecNacimiento;
	private String chrTipSexo;
	private String chrNumTelefono;
	private String chrCorreo;
	private String chrIndEssalud;
	private String chrIndDomiciliario;
	private String numRucConvenio;
	private String chrNomVia;
	private String chrNumHogar;
	private String chrNumInterior;
	private String chrNomZona;
	private String chrReferencia;
	private Integer idubigeo;
	private String chrCodUsuaCreacion;
	private Date dteFecCreacion;
	private String chrCodUsuaModifica;
	private Date dteFecModifica;
	private Set<TRetenciones> TRetencioneses = new HashSet<TRetenciones>(0);
	private Set<TComprasIngresos> TComprasIngresoses = new HashSet<TComprasIngresos>(0);

	public TPersonalCuarta() {
		super();
	}
	
	public TPersonalCuarta(int srlIdPersonal) {
		super();
		this.srlIdPersonal = srlIdPersonal;
	}
	public TPersonalCuarta(String numRuc) {
		super();
		this.numRuc = numRuc;
	}


	public TPersonalCuarta(int srlIdPersonal, TConvenioCuarta TConvenioCuarta, TDocumentoCuarta TDocumentoCuarta,
			TNacionalidad TNacionalidad, TVia TVia, TZona TZona) {
		this.srlIdPersonal = srlIdPersonal;
		this.TConvenioCuarta = TConvenioCuarta;
		this.TDocumentoCuarta = TDocumentoCuarta;
		this.TNacionalidad = TNacionalidad;
		this.TVia = TVia;
		this.TZona = TZona;
	}

	public TPersonalCuarta(int srlIdPersonal, TConvenioCuarta TConvenioCuarta, TDocumentoCuarta TDocumentoCuarta,
			TNacionalidad TNacionalidad, TVia TVia, TZona TZona, String numRuc, String chrNumDocumento,
			String chrApePaterno, String chrApeMaterno, String chrNombres, Date dteFecNacimiento, String chrTipSexo,
			String chrNumTelefono, String chrCorreo, String chrIndEssalud, String chrIndDomiciliario,
			String numRucConvenio, String chrNomVia, String chrNumHogar, String chrNumInterior, String chrNomZona,
			String chrReferencia, Integer idubigeo, String chrCodUsuaCreacion, Date dteFecCreacion,
			String chrCodUsuaModifica, Date dteFecModifica, Set<TRetenciones> TRetencioneses) {
		
		this.srlIdPersonal = srlIdPersonal;
		this.TConvenioCuarta = TConvenioCuarta;
		this.TDocumentoCuarta = TDocumentoCuarta;
		this.TNacionalidad = TNacionalidad;
		this.TVia = TVia;
		this.TZona = TZona;
		this.numRuc = numRuc;
		this.chrNumDocumento = chrNumDocumento;
		this.chrApePaterno = chrApePaterno;
		this.chrApeMaterno = chrApeMaterno;
		this.chrNombres = chrNombres;
		this.dteFecNacimiento = dteFecNacimiento;
		this.chrTipSexo = chrTipSexo;
		this.chrNumTelefono = chrNumTelefono;
		this.chrCorreo = chrCorreo;
		this.chrIndEssalud = chrIndEssalud;
		this.chrIndDomiciliario = chrIndDomiciliario;
		this.numRucConvenio = numRucConvenio;
		this.chrNomVia = chrNomVia;
		this.chrNumHogar = chrNumHogar;
		this.chrNumInterior = chrNumInterior;
		this.chrNomZona = chrNomZona;
		this.chrReferencia = chrReferencia;
		this.idubigeo = idubigeo;
		this.chrCodUsuaCreacion = chrCodUsuaCreacion;
		this.dteFecCreacion = dteFecCreacion;
		this.chrCodUsuaModifica = chrCodUsuaModifica;
		this.dteFecModifica = dteFecModifica;
		this.TRetencioneses = TRetencioneses;
	}

	@Id
	@SequenceGenerator(name = "seq_personal_cuarta", sequenceName = "mig.t_personal_cuarta_srl_id_personal_seq")
	@GeneratedValue(generator = "seq_personal_cuarta")
	@Column(name = "srl_id_personal", unique = true, nullable = false)
	public int getSrlIdPersonal() {
		return this.srlIdPersonal;
	}

	public void setSrlIdPersonal(int srlIdPersonal) {
		this.srlIdPersonal = srlIdPersonal;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "srl_id_convenio", nullable = false)
	public TConvenioCuarta getTConvenioCuarta() {
		return this.TConvenioCuarta;
	}

	public void setTConvenioCuarta(TConvenioCuarta TConvenioCuarta) {
		this.TConvenioCuarta = TConvenioCuarta;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "srl_id_documento", nullable = false)
	public TDocumentoCuarta getTDocumentoCuarta() {
		return this.TDocumentoCuarta;
	}

	public void setTDocumentoCuarta(TDocumentoCuarta TDocumentoCuarta) {
		this.TDocumentoCuarta = TDocumentoCuarta;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "srl_id_nacion", nullable = false)
	public TNacionalidad getTNacionalidad() {
		return this.TNacionalidad;
	}

	public void setTNacionalidad(TNacionalidad TNacionalidad) {
		this.TNacionalidad = TNacionalidad;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "srl_id_via")
	public TVia getTVia() {
		return this.TVia;
	}

	public void setTVia(TVia TVia) {
		this.TVia = TVia;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "srl_id_zona")
	public TZona getTZona() {
		return this.TZona;
	}

	public void setTZona(TZona TZona) {
		this.TZona = TZona;
	}

	@Column(name = "num_ruc", length = 11)
	public String getNumRuc() {
		return this.numRuc;
	}

	public void setNumRuc(String numRuc) {
		this.numRuc = numRuc;
	}

	@Column(name = "chr_num_documento", length = 15)
	public String getChrNumDocumento() {
		return this.chrNumDocumento;
	}

	public void setChrNumDocumento(String chrNumDocumento) {
		this.chrNumDocumento = chrNumDocumento;
	}

	@Column(name = "chr_ape_paterno", length = 30)
	public String getChrApePaterno() {
		return this.chrApePaterno;
	}

	public void setChrApePaterno(String chrApePaterno) {
		this.chrApePaterno = chrApePaterno;
	}

	@Column(name = "chr_ape_materno", length = 30)
	public String getChrApeMaterno() {
		return this.chrApeMaterno;
	}

	public void setChrApeMaterno(String chrApeMaterno) {
		this.chrApeMaterno = chrApeMaterno;
	}

	@Column(name = "chr_nombres", length = 50)
	public String getChrNombres() {
		return this.chrNombres;
	}

	public void setChrNombres(String chrNombres) {
		this.chrNombres = chrNombres;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "dte_fec_nacimiento", length = 13)
	public Date getDteFecNacimiento() {
		return this.dteFecNacimiento;
	}

	public void setDteFecNacimiento(Date dteFecNacimiento) {
		this.dteFecNacimiento = dteFecNacimiento;
	}

	@Column(name = "chr_tip_sexo", length = 1)
	public String getChrTipSexo() {
		return this.chrTipSexo;
	}

	public void setChrTipSexo(String chrTipSexo) {
		this.chrTipSexo = chrTipSexo;
	}

	@Column(name = "chr_num_telefono", length = 10)
	public String getChrNumTelefono() {
		return this.chrNumTelefono;
	}

	public void setChrNumTelefono(String chrNumTelefono) {
		this.chrNumTelefono = chrNumTelefono;
	}

	@Column(name = "chr_correo", length = 20)
	public String getChrCorreo() {
		return this.chrCorreo;
	}

	public void setChrCorreo(String chrCorreo) {
		this.chrCorreo = chrCorreo;
	}

	@Column(name = "chr_ind_essalud", length = 1)
	public String getChrIndEssalud() {
		return this.chrIndEssalud;
	}

	public void setChrIndEssalud(String chrIndEssalud) {
		this.chrIndEssalud = chrIndEssalud;
	}

	@Column(name = "chr_ind_domiciliario", length = 1)
	public String getChrIndDomiciliario() {
		return this.chrIndDomiciliario;
	}

	public void setChrIndDomiciliario(String chrIndDomiciliario) {
		this.chrIndDomiciliario = chrIndDomiciliario;
	}

	@Column(name = "num_ruc_convenio", length = 11)
	public String getNumRucConvenio() {
		return this.numRucConvenio;
	}

	public void setNumRucConvenio(String numRucConvenio) {
		this.numRucConvenio = numRucConvenio;
	}

	@Column(name = "chr_nom_via", length = 30)
	public String getChrNomVia() {
		return this.chrNomVia;
	}

	public void setChrNomVia(String chrNomVia) {
		this.chrNomVia = chrNomVia;
	}

	@Column(name = "chr_num_hogar", length = 3)
	public String getChrNumHogar() {
		return this.chrNumHogar;
	}

	public void setChrNumHogar(String chrNumHogar) {
		this.chrNumHogar = chrNumHogar;
	}

	@Column(name = "chr_num_interior", length = 3)
	public String getChrNumInterior() {
		return this.chrNumInterior;
	}

	public void setChrNumInterior(String chrNumInterior) {
		this.chrNumInterior = chrNumInterior;
	}

	@Column(name = "chr_nom_zona", length = 50)
	public String getChrNomZona() {
		return this.chrNomZona;
	}

	public void setChrNomZona(String chrNomZona) {
		this.chrNomZona = chrNomZona;
	}

	@Column(name = "chr_referencia", length = 100)
	public String getChrReferencia() {
		return this.chrReferencia;
	}

	public void setChrReferencia(String chrReferencia) {
		this.chrReferencia = chrReferencia;
	}

	@Column(name = "idubigeo")
	public Integer getIdubigeo() {
		return this.idubigeo;
	}

	public void setIdubigeo(Integer idubigeo) {
		this.idubigeo = idubigeo;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TPersonalCuarta")
	public Set<TRetenciones> getTRetencioneses() {
		return this.TRetencioneses;
	}

	public void setTRetencioneses(Set<TRetenciones> TRetencioneses) {
		this.TRetencioneses = TRetencioneses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TPersonalCuarta")
	public Set<TComprasIngresos> getTComprasIngresoses() {
		return TComprasIngresoses;
	}

	public void setTComprasIngresoses(Set<TComprasIngresos> tComprasIngresoses) {
		TComprasIngresoses = tComprasIngresoses;
	}


}
