package pe.com.mig.model.bean;

/**
 * @className: CuentaContableBean.java
 * @description: 
 * @date: 10 de jul. de 2016
 * @author: SUMERIO.
 */
public class CuentaContableBean extends MBaseBean {

	private static final long serialVersionUID = 1L;
	private Integer cod_cuenta;
	private Long cod_especifica;
	private String vcod_especifica;
	private String des_especifica;
	private String vcod_cuenta;
	private String nom_cuenta;
	private String fla_activo;	
	private String mnt_fec_creacion;	
	private String mnt_usu_creacion;
	private String mnt_fec_modificacion;
	private String mnt_usu_modificacion;
	
	
	/**
	 * @return the cod_cuenta
	 */
	public Integer getCod_cuenta() {
		return cod_cuenta;
	}
	/**
	 * @param cod_cuenta the cod_cuenta to set
	 */
	public void setCod_cuenta(Integer cod_cuenta) {
		this.cod_cuenta = cod_cuenta;
	}
	/**
	 * @return the cod_especifica
	 */
	public Long getCod_especifica() {
		return cod_especifica;
	}
	/**
	 * @param cod_especifica the cod_especifica to set
	 */
	public void setCod_especifica(Long cod_especifica) {
		this.cod_especifica = cod_especifica;
	}
	/**
	 * @return the vcod_especifica
	 */
	public String getVcod_especifica() {
		return vcod_especifica;
	}
	/**
	 * @param vcod_especifica the vcod_especifica to set
	 */
	public void setVcod_especifica(String vcod_especifica) {
		this.vcod_especifica = vcod_especifica;
	}
	/**
	 * @return the des_especifica
	 */
	public String getDes_especifica() {
		return des_especifica;
	}
	/**
	 * @param des_especifica the des_especifica to set
	 */
	public void setDes_especifica(String des_especifica) {
		this.des_especifica = des_especifica;
	}
	/**
	 * @return the vcod_cuenta
	 */
	public String getVcod_cuenta() {
		return vcod_cuenta;
	}
	/**
	 * @param vcod_cuenta the vcod_cuenta to set
	 */
	public void setVcod_cuenta(String vcod_cuenta) {
		this.vcod_cuenta = vcod_cuenta;
	}
	/**
	 * @return the nom_cuenta
	 */
	public String getNom_cuenta() {
		return nom_cuenta;
	}
	/**
	 * @param nom_cuenta the nom_cuenta to set
	 */
	public void setNom_cuenta(String nom_cuenta) {
		this.nom_cuenta = nom_cuenta;
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
