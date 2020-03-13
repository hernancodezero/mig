package pe.com.mig.model.bean;



/**
 * @className: ProductoBean.java
 * @description: 
 * @date: 16 de oct. de 2019
 * @author: SUMERIO.
 */
public class OtrosBean extends MBaseBean {
	
	private static final long serialVersionUID = 1L;
	private Integer cod_otro;
	private String nom_otro;
	private String fla_activo;
	private String siglas;
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

	private String cod_especifica;
	private String cod_cuenta;
	private String mnt_fec_creacion;	
	private String mnt_usu_creacion;
	private String mnt_fec_modificacion;
	private String mnt_usu_modificacion;

	public OtrosBean() {
		super();
	}

	/**
	 * @return the cod_otro
	 */
	public Integer getCod_otro() {
		return cod_otro;
	}

	/**
	 * @param cod_otro the cod_otro to set
	 */
	public void setCod_otro(Integer cod_otro) {
		this.cod_otro = cod_otro;
	}

	/**
	 * @return the nom_otro
	 */
	public String getNom_otro() {
		return nom_otro;
	}

	/**
	 * @param nom_otro the nom_otro to set
	 */
	public void setNom_otro(String nom_otro) {
		this.nom_otro = nom_otro;
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
	 * @return the cod_especifica
	 */
	public String getCod_especifica() {
		return cod_especifica;
	}

	/**
	 * @param cod_especifica the cod_especifica to set
	 */
	public void setCod_especifica(String cod_especifica) {
		this.cod_especifica = cod_especifica;
	}

	/**
	 * @return the cod_cuenta
	 */
	public String getCod_cuenta() {
		return cod_cuenta;
	}

	/**
	 * @param cod_cuenta the cod_cuenta to set
	 */
	public void setCod_cuenta(String cod_cuenta) {
		this.cod_cuenta = cod_cuenta;
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

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}



}
