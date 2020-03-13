package pe.com.mig.model.bean;

import java.util.Date;

/**
 * @className: CierreMesBean.java
 * @description: 
 * @date: 16 de jun. de 2016
 * @author: SUMERIO.
 */
public class PersonaCuartaBean extends MBaseBean {

	private static final long serialVersionUID = 1L;
	private int srlIdPersonal;
	private int TConvenioCuarta;
	private int TDocumentoCuarta;
	private int TNacionalidad;
	private int TVia;
	private int TZona;
	private String numRuc;
	private String chrNumDocumento;
	private String chrApePaterno;
	private String chrApeMaterno;
	private String chrNombres;
	private String dteFecNacimiento;
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
	private String dteFecModifica;
	private String nombre;
	private String cod_convenio;
	private String nom_convenio;
	private String cod_documento;
	private String nom_documento;	
	private String chrCodNacion;
	private String chrNomNacion;	
	private String cod_via;
	private String nom_via;	
	private String cod_zona;
	private String nom_zona;	
	private String nom_ubi;
	private String direccion_persona;
	private Integer srlIdNacion;
	private Integer srlIdConvenio;
	private Integer srlIdDocumento;
	private Integer srlIdVia;
	private Integer srlIdZona;
	private String coddpto;
	private String codprov;
	private String coddist;
	/**
	 * @return the srlIdPersonal
	 */
	public int getSrlIdPersonal() {
		return srlIdPersonal;
	}
	/**
	 * @param srlIdPersonal the srlIdPersonal to set
	 */
	public void setSrlIdPersonal(int srlIdPersonal) {
		this.srlIdPersonal = srlIdPersonal;
	}
	/**
	 * @return the numRuc
	 */
	public String getNumRuc() {
		return numRuc;
	}
	/**
	 * @param numRuc the numRuc to set
	 */
	public void setNumRuc(String numRuc) {
		this.numRuc = numRuc;
	}
	/**
	 * @return the chrApePaterno
	 */
	public String getChrApePaterno() {
		return chrApePaterno;
	}
	/**
	 * @param chrApePaterno the chrApePaterno to set
	 */
	public void setChrApePaterno(String chrApePaterno) {
		this.chrApePaterno = chrApePaterno;
	}
	/**
	 * @return the chrApeMaterno
	 */
	public String getChrApeMaterno() {
		return chrApeMaterno;
	}
	/**
	 * @param chrApeMaterno the chrApeMaterno to set
	 */
	public void setChrApeMaterno(String chrApeMaterno) {
		this.chrApeMaterno = chrApeMaterno;
	}
	/**
	 * @return the chrNombres
	 */
	public String getChrNombres() {
		return chrNombres;
	}
	/**
	 * @param chrNombres the chrNombres to set
	 */
	public void setChrNombres(String chrNombres) {
		this.chrNombres = chrNombres;
	}
	 

	/**
	 * @return the dteFecNacimiento
	 */
	public String getDteFecNacimiento() {
		return dteFecNacimiento;
	}
	/**
	 * @param dteFecNacimiento the dteFecNacimiento to set
	 */
	public void setDteFecNacimiento(String dteFecNacimiento) {
		this.dteFecNacimiento = dteFecNacimiento;
	}
	/**
	 * @return the tConvenioCuarta
	 */
	public int getTConvenioCuarta() {
		return TConvenioCuarta;
	}
	/**
	 * @param tConvenioCuarta the tConvenioCuarta to set
	 */
	public void setTConvenioCuarta(int tConvenioCuarta) {
		TConvenioCuarta = tConvenioCuarta;
	}
	/**
	 * @return the tDocumentoCuarta
	 */
	public int getTDocumentoCuarta() {
		return TDocumentoCuarta;
	}
	/**
	 * @param tDocumentoCuarta the tDocumentoCuarta to set
	 */
	public void setTDocumentoCuarta(int tDocumentoCuarta) {
		TDocumentoCuarta = tDocumentoCuarta;
	}
	/**
	 * @return the tNacionalidad
	 */
	public int getTNacionalidad() {
		return TNacionalidad;
	}
	/**
	 * @param tNacionalidad the tNacionalidad to set
	 */
	public void setTNacionalidad(int tNacionalidad) {
		TNacionalidad = tNacionalidad;
	}
	/**
	 * @return the tVia
	 */
	public int getTVia() {
		return TVia;
	}
	/**
	 * @param tVia the tVia to set
	 */
	public void setTVia(int tVia) {
		TVia = tVia;
	}
	/**
	 * @return the tZona
	 */
	public int getTZona() {
		return TZona;
	}
	/**
	 * @param tZona the tZona to set
	 */
	public void setTZona(int tZona) {
		TZona = tZona;
	}
	/**
	 * @return the chrNumDocumento
	 */
	public String getChrNumDocumento() {
		return chrNumDocumento;
	}
	/**
	 * @param chrNumDocumento the chrNumDocumento to set
	 */
	public void setChrNumDocumento(String chrNumDocumento) {
		this.chrNumDocumento = chrNumDocumento;
	}
	/**
	 * @return the idubigeo
	 */
	public Integer getIdubigeo() {
		return idubigeo;
	}
	/**
	 * @param idubigeo the idubigeo to set
	 */
	public void setIdubigeo(Integer idubigeo) {
		this.idubigeo = idubigeo;
	}
	/**
	 * @return the chrCodUsuaCreacion
	 */
	public String getChrCodUsuaCreacion() {
		return chrCodUsuaCreacion;
	}
	/**
	 * @param chrCodUsuaCreacion the chrCodUsuaCreacion to set
	 */
	public void setChrCodUsuaCreacion(String chrCodUsuaCreacion) {
		this.chrCodUsuaCreacion = chrCodUsuaCreacion;
	}
	/**
	 * @return the dteFecCreacion
	 */
	public Date getDteFecCreacion() {
		return dteFecCreacion;
	}
	/**
	 * @param dteFecCreacion the dteFecCreacion to set
	 */
	public void setDteFecCreacion(Date dteFecCreacion) {
		this.dteFecCreacion = dteFecCreacion;
	}
	/**
	 * @return the chrCodUsuaModifica
	 */
	public String getChrCodUsuaModifica() {
		return chrCodUsuaModifica;
	}
	/**
	 * @param chrCodUsuaModifica the chrCodUsuaModifica to set
	 */
	public void setChrCodUsuaModifica(String chrCodUsuaModifica) {
		this.chrCodUsuaModifica = chrCodUsuaModifica;
	}
	/**
	 * @return the dteFecModifica
	 */
	public String getDteFecModifica() {
		return dteFecModifica;
	}
	/**
	 * @param dteFecModifica the dteFecModifica to set
	 */
	public void setDteFecModifica(String dteFecModifica) {
		this.dteFecModifica = dteFecModifica;
	}
 
	/**
	 * @return the chrTipSexo
	 */
	public String getChrTipSexo() {
		return chrTipSexo;
	}
	/**
	 * @param chrTipSexo the chrTipSexo to set
	 */
	public void setChrTipSexo(String chrTipSexo) {
		this.chrTipSexo = chrTipSexo;
	}
	/**
	 * @return the chrNumTelefono
	 */
	public String getChrNumTelefono() {
		return chrNumTelefono;
	}
	/**
	 * @param chrNumTelefono the chrNumTelefono to set
	 */
	public void setChrNumTelefono(String chrNumTelefono) {
		this.chrNumTelefono = chrNumTelefono;
	}
	/**
	 * @return the chrCorreo
	 */
	public String getChrCorreo() {
		return chrCorreo;
	}
	/**
	 * @param chrCorreo the chrCorreo to set
	 */
	public void setChrCorreo(String chrCorreo) {
		this.chrCorreo = chrCorreo;
	}
	/**
	 * @return the chrIndEssalud
	 */
	public String getChrIndEssalud() {
		return chrIndEssalud;
	}
	/**
	 * @param chrIndEssalud the chrIndEssalud to set
	 */
	public void setChrIndEssalud(String chrIndEssalud) {
		this.chrIndEssalud = chrIndEssalud;
	}
	/**
	 * @return the chrIndDomiciliario
	 */
	public String getChrIndDomiciliario() {
		return chrIndDomiciliario;
	}
	/**
	 * @param chrIndDomiciliario the chrIndDomiciliario to set
	 */
	public void setChrIndDomiciliario(String chrIndDomiciliario) {
		this.chrIndDomiciliario = chrIndDomiciliario;
	}
	/**
	 * @return the numRucConvenio
	 */
	public String getNumRucConvenio() {
		return numRucConvenio;
	}
	/**
	 * @param numRucConvenio the numRucConvenio to set
	 */
	public void setNumRucConvenio(String numRucConvenio) {
		this.numRucConvenio = numRucConvenio;
	}
	/**
	 * @return the chrNomVia
	 */
	public String getChrNomVia() {
		return chrNomVia;
	}
	/**
	 * @param chrNomVia the chrNomVia to set
	 */
	public void setChrNomVia(String chrNomVia) {
		this.chrNomVia = chrNomVia;
	}
	/**
	 * @return the chrNumHogar
	 */
	public String getChrNumHogar() {
		return chrNumHogar;
	}
	/**
	 * @param chrNumHogar the chrNumHogar to set
	 */
	public void setChrNumHogar(String chrNumHogar) {
		this.chrNumHogar = chrNumHogar;
	}
	/**
	 * @return the chrNumInterior
	 */
	public String getChrNumInterior() {
		return chrNumInterior;
	}
	/**
	 * @param chrNumInterior the chrNumInterior to set
	 */
	public void setChrNumInterior(String chrNumInterior) {
		this.chrNumInterior = chrNumInterior;
	}
	/**
	 * @return the chrNomZona
	 */
	public String getChrNomZona() {
		return chrNomZona;
	}
	/**
	 * @param chrNomZona the chrNomZona to set
	 */
	public void setChrNomZona(String chrNomZona) {
		this.chrNomZona = chrNomZona;
	}
	/**
	 * @return the chrReferencia
	 */
	public String getChrReferencia() {
		return chrReferencia;
	}
	/**
	 * @param chrReferencia the chrReferencia to set
	 */
	public void setChrReferencia(String chrReferencia) {
		this.chrReferencia = chrReferencia;
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the cod_convenio
	 */
	public String getCod_convenio() {
		return cod_convenio;
	}
	/**
	 * @param cod_convenio the cod_convenio to set
	 */
	public void setCod_convenio(String cod_convenio) {
		this.cod_convenio = cod_convenio;
	}
	/**
	 * @return the nom_convenio
	 */
	public String getNom_convenio() {
		return nom_convenio;
	}
	/**
	 * @param nom_convenio the nom_convenio to set
	 */
	public void setNom_convenio(String nom_convenio) {
		this.nom_convenio = nom_convenio;
	}
	/**
	 * @return the cod_documento
	 */
	public String getCod_documento() {
		return cod_documento;
	}
	/**
	 * @param cod_documento the cod_documento to set
	 */
	public void setCod_documento(String cod_documento) {
		this.cod_documento = cod_documento;
	}
	/**
	 * @return the nom_documento
	 */
	public String getNom_documento() {
		return nom_documento;
	}
	/**
	 * @param nom_documento the nom_documento to set
	 */
	public void setNom_documento(String nom_documento) {
		this.nom_documento = nom_documento;
	}

	/**
	 * @return the chrCodNacion
	 */
	public String getChrCodNacion() {
		return chrCodNacion;
	}
	/**
	 * @param chrCodNacion the chrCodNacion to set
	 */
	public void setChrCodNacion(String chrCodNacion) {
		this.chrCodNacion = chrCodNacion;
	}
	/**
	 * @return the chrNomNacion
	 */
	public String getChrNomNacion() {
		return chrNomNacion;
	}
	/**
	 * @param chrNomNacion the chrNomNacion to set
	 */
	public void setChrNomNacion(String chrNomNacion) {
		this.chrNomNacion = chrNomNacion;
	}
	/**
	 * @return the cod_via
	 */
	public String getCod_via() {
		return cod_via;
	}
	/**
	 * @param cod_via the cod_via to set
	 */
	public void setCod_via(String cod_via) {
		this.cod_via = cod_via;
	}
	/**
	 * @return the nom_via
	 */
	public String getNom_via() {
		return nom_via;
	}
	/**
	 * @param nom_via the nom_via to set
	 */
	public void setNom_via(String nom_via) {
		this.nom_via = nom_via;
	}
	/**
	 * @return the cod_zona
	 */
	public String getCod_zona() {
		return cod_zona;
	}
	/**
	 * @param cod_zona the cod_zona to set
	 */
	public void setCod_zona(String cod_zona) {
		this.cod_zona = cod_zona;
	}
	/**
	 * @return the nom_zona
	 */
	public String getNom_zona() {
		return nom_zona;
	}
	/**
	 * @param nom_zona the nom_zona to set
	 */
	public void setNom_zona(String nom_zona) {
		this.nom_zona = nom_zona;
	}
	/**
	 * @return the nom_ubi
	 */
	public String getNom_ubi() {
		return nom_ubi;
	}
	/**
	 * @param nom_ubi the nom_ubi to set
	 */
	public void setNom_ubi(String nom_ubi) {
		this.nom_ubi = nom_ubi;
	}
	/**
	 * @return the direccion_persona
	 */
	public String getDireccion_persona() {
		return direccion_persona;
	}
	/**
	 * @param direccion_persona the direccion_persona to set
	 */
	public void setDireccion_persona(String direccion_persona) {
		this.direccion_persona = direccion_persona;
	}
	/**
	 * @return the srlIdNacion
	 */
	public Integer getSrlIdNacion() {
		return srlIdNacion;
	}
	/**
	 * @param srlIdNacion the srlIdNacion to set
	 */
	public void setSrlIdNacion(Integer srlIdNacion) {
		this.srlIdNacion = srlIdNacion;
	}
	/**
	 * @return the srlIdConvenio
	 */
	public Integer getSrlIdConvenio() {
		return srlIdConvenio;
	}
	/**
	 * @param srlIdConvenio the srlIdConvenio to set
	 */
	public void setSrlIdConvenio(Integer srlIdConvenio) {
		this.srlIdConvenio = srlIdConvenio;
	}
	/**
	 * @return the srlIdDocumento
	 */
	public Integer getSrlIdDocumento() {
		return srlIdDocumento;
	}
	/**
	 * @param srlIdDocumento the srlIdDocumento to set
	 */
	public void setSrlIdDocumento(Integer srlIdDocumento) {
		this.srlIdDocumento = srlIdDocumento;
	}
	/**
	 * @return the srlIdVia
	 */
	public Integer getSrlIdVia() {
		return srlIdVia;
	}
	/**
	 * @param srlIdVia the srlIdVia to set
	 */
	public void setSrlIdVia(Integer srlIdVia) {
		this.srlIdVia = srlIdVia;
	}
	/**
	 * @return the srlIdZona
	 */
	public Integer getSrlIdZona() {
		return srlIdZona;
	}
	/**
	 * @param srlIdZona the srlIdZona to set
	 */
	public void setSrlIdZona(Integer srlIdZona) {
		this.srlIdZona = srlIdZona;
	}
	/**
	 * @return the coddpto
	 */
	public String getCoddpto() {
		return coddpto;
	}
	/**
	 * @param coddpto the coddpto to set
	 */
	public void setCoddpto(String coddpto) {
		this.coddpto = coddpto;
	}
	/**
	 * @return the codprov
	 */
	public String getCodprov() {
		return codprov;
	}
	/**
	 * @param codprov the codprov to set
	 */
	public void setCodprov(String codprov) {
		this.codprov = codprov;
	}
	/**
	 * @return the coddist
	 */
	public String getCoddist() {
		return coddist;
	}
	/**
	 * @param coddist the coddist to set
	 */
	public void setCoddist(String coddist) {
		this.coddist = coddist;
	}

	
}
