package pe.com.mig.model.bean;

/**
 * @className: SucursalBean.java
 * @description: 
 * @date: 12 de jun. de 2016
 * @author: SUMERIO.
 */
public class SucursalBean extends MBaseBean {

	private static final long serialVersionUID = 1L;
	private int cod_sucur;
	private int cod_uni_operativa;
	private int cod_reg_nac;
	private String des_sucur;
	private String fla_activo;
	private String mnt_fec_creacion;	
	private String mnt_usu_creacion;
	private String mnt_fec_modificacion;
	private String mnt_usu_modificacion;	


	public SucursalBean() {
		super();
	}

	public SucursalBean(String flagActivo) {
		super();
	}

	/**
	 * @return the cod_sucur
	 */
	public int getCod_sucur() {
		return cod_sucur;
	}

	/**
	 * @param cod_sucur the cod_sucur to set
	 */
	public void setCod_sucur(int cod_sucur) {
		this.cod_sucur = cod_sucur;
	}

	/**
	 * @return the cod_unidad
	 */
	public int getCod_uni_operativa() {
		return cod_uni_operativa;
	}

	/**
	 * @param cod_unidad the cod_unidad to set
	 */
	public void setCod_uni_operativa(int cod_uni_operativa) {
		this.cod_uni_operativa = cod_uni_operativa;
	}

	/**
	 * @return the cod_anp
	 */
	public int getCod_reg_nac() {
		return cod_reg_nac;
	}

	/**
	 * @param cod_anp the cod_anp to set
	 */
	public void setCod_reg_nac(int cod_reg_nac) {
		this.cod_reg_nac = cod_reg_nac;
	}

	/**
	 * @return the des_sucur
	 */
	public String getDes_sucur() {
		return des_sucur;
	}

	/**
	 * @param nom_sucur the nom_sucur to set
	 */
	public void setDes_sucur(String des_sucur) {
		this.des_sucur = des_sucur;
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