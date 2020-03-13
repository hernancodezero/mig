package pe.com.mig.model.bean.sppi;

import pe.com.mig.model.bean.MBaseBean;

/**
 * @className: EspecificaBean.java
 * @description: 
 * @date: 16 de jun. de 2016
 * @author: SUMERIO.
 */
public class EspecificaBean extends MBaseBean {

	private static final long serialVersionUID = 1L;
	private Long srl_id_esp;
	private String chr_cod_especifica;
	private String var_nom_especifica;	
	private String chr_anio;
	private String chr_estado;
	private Integer int_idmigra;
	
	
	/**
	 * 
	 */
	public EspecificaBean() {
		super();
	}

	/**
	 * @param chr_cod_especifica
	 */
	public EspecificaBean(String chr_cod_especifica) {
		super();
		this.chr_cod_especifica = chr_cod_especifica;
	}
	
	/**
	 * @return the srl_id_esp
	 */
	public Long getSrl_id_esp() {
		return srl_id_esp;
	}
	/**
	 * @param srl_id_esp the srl_id_esp to set
	 */
	public void setSrl_id_esp(Long srl_id_esp) {
		this.srl_id_esp = srl_id_esp;
	}
	/**
	 * @return the chr_cod_especifica
	 */
	public String getChr_cod_especifica() {
		return chr_cod_especifica;
	}
	/**
	 * @param chr_cod_especifica the chr_cod_especifica to set
	 */
	public void setChr_cod_especifica(String chr_cod_especifica) {
		this.chr_cod_especifica = chr_cod_especifica;
	}
	/**
	 * @return the var_nom_especifica
	 */
	public String getVar_nom_especifica() {
		return var_nom_especifica;
	}
	/**
	 * @param var_nom_especifica the var_nom_especifica to set
	 */
	public void setVar_nom_especifica(String var_nom_especifica) {
		this.var_nom_especifica = var_nom_especifica;
	}
	/**
	 * @return the chr_anio
	 */
	public String getChr_anio() {
		return chr_anio;
	}
	/**
	 * @param chr_anio the chr_anio to set
	 */
	public void setChr_anio(String chr_anio) {
		this.chr_anio = chr_anio;
	}
	/**
	 * @return the chr_estado
	 */
	public String getChr_estado() {
		return chr_estado;
	}
	/**
	 * @param chr_estado the chr_estado to set
	 */
	public void setChr_estado(String chr_estado) {
		this.chr_estado = chr_estado;
	}
	/**
	 * @return the int_idmigra
	 */
	public Integer getInt_idmigra() {
		return int_idmigra;
	}
	/**
	 * @param int_idmigra the int_idmigra to set
	 */
	public void setInt_idmigra(Integer int_idmigra) {
		this.int_idmigra = int_idmigra;
	}	

}
