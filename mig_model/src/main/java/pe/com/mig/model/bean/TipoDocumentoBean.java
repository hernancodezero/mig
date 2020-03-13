package pe.com.mig.model.bean;

/**
 * @className: TipoDocumentoBean.java
 * @description: 
 * @date: 15 de jun. de 2016
 * @author: SUMERIO.
 */
public class TipoDocumentoBean extends MBaseBean {

	private static final long serialVersionUID = 1L;
	private Integer cod_documento;
	private String vcod_documento;
	private String nom_documento;
	private String doc_siglas;
	private String fla_activo;
	private String mnt_fec_creacion;	
	private String mnt_usu_creacion;
	private String mnt_fec_modificacion;
	private String mnt_usu_modificacion;
	
	
	/**
	 * 
	 */
	public TipoDocumentoBean() {
		super();
	}
	
	/**
	 * @param fla_activo
	 */
	public TipoDocumentoBean(String fla_activo) {
		super();
		this.fla_activo = fla_activo;
	}
	
	/**
	 * @return the cod_documento
	 */
	public Integer getCod_documento() {
		return cod_documento;
	}
	/**
	 * @param cod_documento the cod_documento to set
	 */
	public void setCod_documento(Integer cod_documento) {
		this.cod_documento = cod_documento;
	}
	/**
	 * @return the vcod_documento
	 */
	public String getVcod_documento() {
		return vcod_documento;
	}
	/**
	 * @param vcod_documento the vcod_documento to set
	 */
	public void setVcod_documento(String vcod_documento) {
		this.vcod_documento = vcod_documento;
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
	 * @return the doc_siglas
	 */
	public String getDoc_siglas() {
		return doc_siglas;
	}
	/**
	 * @param doc_siglas the doc_siglas to set
	 */
	public void setDoc_siglas(String doc_siglas) {
		this.doc_siglas = doc_siglas;
	}
	/**
	 * @return the fla_activo
	 */
	public String getFla_activo() {
		return fla_activo;
	}
	/**
	 * @param fla_activo the fla_activo to set
	 */
	public void setFla_activo(String fla_activo) {
		this.fla_activo = fla_activo;
	}

	/**
	 * @return the mnt_fec_creacion
	 */
	public String getMnt_fec_creacion() {
		return mnt_fec_creacion;
	}

	/**
	 * @param mnt_fec_creacion the mnt_fec_creacion to set
	 */
	public void setMnt_fec_creacion(String mnt_fec_creacion) {
		this.mnt_fec_creacion = mnt_fec_creacion;
	}

	/**
	 * @return the mnt_usu_creacion
	 */
	public String getMnt_usu_creacion() {
		return mnt_usu_creacion;
	}

	/**
	 * @param mnt_usu_creacion the mnt_usu_creacion to set
	 */
	public void setMnt_usu_creacion(String mnt_usu_creacion) {
		this.mnt_usu_creacion = mnt_usu_creacion;
	}

	/**
	 * @return the mnt_fec_modificacion
	 */
	public String getMnt_fec_modificacion() {
		return mnt_fec_modificacion;
	}

	/**
	 * @param mnt_fec_modificacion the mnt_fec_modificacion to set
	 */
	public void setMnt_fec_modificacion(String mnt_fec_modificacion) {
		this.mnt_fec_modificacion = mnt_fec_modificacion;
	}

	/**
	 * @return the mnt_usu_modificacion
	 */
	public String getMnt_usu_modificacion() {
		return mnt_usu_modificacion;
	}

	/**
	 * @param mnt_usu_modificacion the mnt_usu_modificacion to set
	 */
	public void setMnt_usu_modificacion(String mnt_usu_modificacion) {
		this.mnt_usu_modificacion = mnt_usu_modificacion;
	}
}
