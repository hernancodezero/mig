package pe.com.mig.model.bean;

/**
 * @className: TipoMonedaBean.java
 * @description: 
 * @date: 15 de jun. de 2016
 * @author: SUMERIO.
 */
public class TipoMonedaBean extends MBaseBean {

	private static final long serialVersionUID = 1L;
	private Integer cod_moneda;
	private String vcod_moneda;
	private String nom_moneda;
	private String siglas;
	private String fla_activo;
	private String mnt_fec_creacion;	
	private String mnt_usu_creacion;
	private String mnt_fec_modificacion;
	private String mnt_usu_modificacion;
	
	
	/**
	 * 
	 */
	public TipoMonedaBean() {
		super();
	}

	/**
	 * @param fla_activo
	 */
	public TipoMonedaBean(String fla_activo) {
		super();
		this.fla_activo = fla_activo;
	}
	
	/**
	 * @return the cod_moneda
	 */
	public Integer getCod_moneda() {
		return cod_moneda;
	}
	/**
	 * @param cod_moneda the cod_moneda to set
	 */
	public void setCod_moneda(Integer cod_moneda) {
		this.cod_moneda = cod_moneda;
	}
	/**
	 * @return the vcod_moneda
	 */
	public String getVcod_moneda() {
		return vcod_moneda;
	}
	/**
	 * @param vcod_moneda the vcod_moneda to set
	 */
	public void setVcod_moneda(String vcod_moneda) {
		this.vcod_moneda = vcod_moneda;
	}
	/**
	 * @return the nom_moneda
	 */
	public String getNom_moneda() {
		return nom_moneda;
	}
	/**
	 * @param nom_moneda the nom_moneda to set
	 */
	public void setNom_moneda(String nom_moneda) {
		this.nom_moneda = nom_moneda;
	}
	/**
	 * @return the siglas
	 */
	public String getSiglas() {
		return siglas;
	}
	/**
	 * @param siglas the siglas to set
	 */
	public void setSiglas(String siglas) {
		this.siglas = siglas;
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
