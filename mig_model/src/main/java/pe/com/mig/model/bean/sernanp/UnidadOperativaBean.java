package pe.com.mig.model.bean.sernanp;

import java.io.Serializable;

/**
 * @className: UnidadOperativaBean.java
 * @description: 
 * @date: 23 de jun. de 2016
 * @author: SUMERIO.
 */
public class UnidadOperativaBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Integer cod_usuario;
	private String des_usuario;
	private Integer cod_area;
	private String vcod_area;
	private String des_area;
	private Integer cod_sede;
	private String des_sede;
	private Integer cod_reg_nac;
	private String des_reg_nac;
	private Integer cod_anp;	
	private Long cod_uni_ope_anp;
	private String des_uni_ope_anp;	
	private Integer cod_uni_operativa;
	private String des_uni_operativa;
	private int ind_uni_operativa;
	
	
	/**
	 * 
	 */
	public UnidadOperativaBean() {
		super();
	}
	
	/**
	 * @param cod_usuario
	 */
	public UnidadOperativaBean(Integer cod_usuario) {
		super();
		this.cod_usuario = cod_usuario;
	}
	
	/**
	 * @return the cod_usuario
	 */
	public Integer getCod_usuario() {
		return cod_usuario;
	}
	/**
	 * @param cod_usuario the cod_usuario to set
	 */
	public void setCod_usuario(Integer cod_usuario) {
		this.cod_usuario = cod_usuario;
	}
	/**
	 * @return the des_usuario
	 */
	public String getDes_usuario() {
		return des_usuario;
	}
	/**
	 * @param des_usuario the des_usuario to set
	 */
	public void setDes_usuario(String des_usuario) {
		this.des_usuario = des_usuario;
	}
	/**
	 * @return the cod_area
	 */
	public Integer getCod_area() {
		return cod_area;
	}
	/**
	 * @param cod_area the cod_area to set
	 */
	public void setCod_area(Integer cod_area) {
		this.cod_area = cod_area;
	}
	/**
	 * @return the vcod_area
	 */
	public String getVcod_area() {
		return vcod_area;
	}
	/**
	 * @param vcod_area the vcod_area to set
	 */
	public void setVcod_area(String vcod_area) {
		this.vcod_area = vcod_area;
	}
	/**
	 * @return the des_area
	 */
	public String getDes_area() {
		return des_area;
	}
	/**
	 * @param des_area the des_area to set
	 */
	public void setDes_area(String des_area) {
		this.des_area = des_area;
	}
	/**
	 * @return the cod_sede
	 */
	public Integer getCod_sede() {
		return cod_sede;
	}
	/**
	 * @param cod_sede the cod_sede to set
	 */
	public void setCod_sede(Integer cod_sede) {
		this.cod_sede = cod_sede;
	}
	/**
	 * @return the des_sede
	 */
	public String getDes_sede() {
		return des_sede;
	}
	/**
	 * @param des_sede the des_sede to set
	 */
	public void setDes_sede(String des_sede) {
		this.des_sede = des_sede;
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
	 * @return the des_reg_nac
	 */
	public String getDes_reg_nac() {
		return des_reg_nac;
	}
	/**
	 * @param des_reg_nac the des_reg_nac to set
	 */
	public void setDes_reg_nac(String des_reg_nac) {
		this.des_reg_nac = des_reg_nac;
	}
	/**
	 * @return the cod_anp
	 */
	public Integer getCod_anp() {
		return cod_anp;
	}
	/**
	 * @param cod_anp the cod_anp to set
	 */
	public void setCod_anp(Integer cod_anp) {
		this.cod_anp = cod_anp;
	}
	/**
	 * @return the cod_uni_ope_anp
	 */
	public Long getCod_uni_ope_anp() {
		return cod_uni_ope_anp;
	}
	/**
	 * @param cod_uni_ope_anp the cod_uni_ope_anp to set
	 */
	public void setCod_uni_ope_anp(Long cod_uni_ope_anp) {
		this.cod_uni_ope_anp = cod_uni_ope_anp;
	}
	/**
	 * @return the des_uni_ope_anp
	 */
	public String getDes_uni_ope_anp() {
		return des_uni_ope_anp;
	}
	/**
	 * @param des_uni_ope_anp the des_uni_ope_anp to set
	 */
	public void setDes_uni_ope_anp(String des_uni_ope_anp) {
		this.des_uni_ope_anp = des_uni_ope_anp;
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
	 * @return the des_uni_operativa
	 */
	public String getDes_uni_operativa() {
		return des_uni_operativa;
	}
	/**
	 * @param des_uni_operativa the des_uni_operativa to set
	 */
	public void setDes_uni_operativa(String des_uni_operativa) {
		this.des_uni_operativa = des_uni_operativa;
	}
	/**
	 * @return the ind_uni_operativa
	 */
	public int getInd_uni_operativa() {
		return ind_uni_operativa;
	}
	/**
	 * @param ind_uni_operativa the ind_uni_operativa to set
	 */
	public void setInd_uni_operativa(int ind_uni_operativa) {
		this.ind_uni_operativa = ind_uni_operativa;
	}

}
