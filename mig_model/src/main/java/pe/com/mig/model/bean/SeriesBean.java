package pe.com.mig.model.bean;

/**
 * @className: SeriesBean.java
 * @description: 
 * @date: 12 de jun. de 2016
 * @author: SUMERIO.
 */
public class SeriesBean extends MBaseBean {

	private static final long serialVersionUID = 1L;
	private Integer cod_serie;
	private Integer cod_uni_operativa;
	private String des_uni_operativa;
	private Integer cod_reg_nac;
	private String des_reg_nac;
	private Integer cod_unidad;
	private Integer cod_ranac;
	private Integer cod_comprobante;
	private String nom_cp;
	private String cod_sunat;
	private String num_serie;
	private String fla_activo;
	private String num_cp;
	private String mnt_fec_creacion;	
	private String mnt_usu_creacion;
	private String mnt_fec_modificacion;
	private String mnt_usu_modificacion;
	/**
	 * 
	 */
	public SeriesBean() {
		super();
	}
	
	
	/**
	 * @return the cod_unidad
	 */
	public Integer getCod_unidad() {
		return cod_unidad;
	}


	/**
	 * @param cod_unidad the cod_unidad to set
	 */
	public void setCod_unidad(Integer cod_unidad) {
		this.cod_unidad = cod_unidad;
	}


	/**
	 * @return the cod_ranac
	 */
	public Integer getCod_ranac() {
		return cod_ranac;
	}


	/**
	 * @param cod_ranac the cod_ranac to set
	 */
	public void setCod_ranac(Integer cod_ranac) {
		this.cod_ranac = cod_ranac;
	}


	/**
	 * @return the nom_unidad
	 */
	public String getDes_uni_operativa() {
		return des_uni_operativa;
	}

	/**
	 * @param nom_unidad the nom_unidad to set
	 */
	public void setDes_uni_operativa(String des_uni_operativa) {
		this.des_uni_operativa = des_uni_operativa;
	}

	/**
	 * @return the nom_anp
	 */
	public String getDes_reg_nac() {
		return des_reg_nac;
	}

	/**
	 * @param nom_anp the nom_anp to set
	 */
	public void setDes_reg_nac(String des_reg_nac) {
		this.des_reg_nac = des_reg_nac;
	}

	/**
	 * @return the nom_cp
	 */
	public String getNom_cp() {
		return nom_cp;
	}

	/**
	 * @param nom_cp the nom_cp to set
	 */
	public void setNom_cp(String nom_cp) {
		this.nom_cp = nom_cp;
	}

	/**
	 * @return the num_cp
	 */
	public String getNum_cp() {
		return num_cp;
	}
	/**
	 * @param num_cp the num_cp to set
	 */
	public void setNum_cp(String num_cp) {
		this.num_cp = num_cp;
	}
	
	/**
	 * @return the cod_serie
	 */
	public Integer getCod_serie() {
		return cod_serie;
	}
	/**
	 * @param cod_serie the cod_serie to set
	 */
	public void setCod_serie(Integer cod_serie) {
		this.cod_serie = cod_serie;
	}
	/**
	 * @return the cod_uni_operativa
	 */
	public Integer getCod_uni_operativa() {
		return cod_uni_operativa;
	}
	/**
	 * @param cod_uni_operativa the cod_uni_operativa to set
	 */
	public void setCod_uni_operativa(Integer cod_uni_operativa) {
		this.cod_uni_operativa = cod_uni_operativa;
	}
	/**
	 * @return the cod_reg_nac
	 */
	public Integer getCod_reg_nac() {
		return cod_reg_nac;
	}
	/**
	 * @param cod_reg_nac the cod_reg_nac to set
	 */
	public void setCod_reg_nac(Integer cod_reg_nac) {
		this.cod_reg_nac = cod_reg_nac;
	}
	/**
	 * @return the cod_comprobante
	 */
	public Integer getCod_comprobante() {
		return cod_comprobante;
	}
	/**
	 * @param cod_comprobante the cod_comprobante to set
	 */
	public void setCod_comprobante(Integer cod_comprobante) {
		this.cod_comprobante = cod_comprobante;
	}
	/**
	 * @return the cod_sunat
	 */
	public String getCod_sunat() {
		return cod_sunat;
	}
	/**
	 * @param cod_sunat the cod_sunat to set
	 */
	public void setCod_sunat(String cod_sunat) {
		this.cod_sunat = cod_sunat;
	}
	/**
	 * @return the num_serie
	 */
	public String getNum_serie() {
		return num_serie;
	}
	/**
	 * @param num_serie the num_serie to set
	 */
	public void setNum_serie(String num_serie) {
		this.num_serie = num_serie;
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