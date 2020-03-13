package pe.com.mig.model.bean;

import java.math.BigDecimal;

/**
 * @className: TarifaTupaBean.java
 * @description: 
 * @date: 2 de jul. de 2016
 * @author: SUMERIO.
 */
public class TarifaTupaBean extends MBaseBean {

	private static final long serialVersionUID = 1L;
	private Integer cod_tupa;
	private String vcod_tupa;
	private String nom_tupa;
	private BigDecimal num_pct_uit;
	private BigDecimal num_imp_unit;
	private String cod_especifica;
	private String cod_cuenta;
	private String fla_activo;	
	
	/**
	 * @return the cod_tupa
	 */
	public Integer getCod_tupa() {
		return cod_tupa;
	}
	/**
	 * @param cod_tupa the cod_tupa to set
	 */
	public void setCod_tupa(Integer cod_tupa) {
		this.cod_tupa = cod_tupa;
	}
	/**
	 * @return the vcod_tupa
	 */
	public String getVcod_tupa() {
		return vcod_tupa;
	}
	/**
	 * @param vcod_tupa the vcod_tupa to set
	 */
	public void setVcod_tupa(String vcod_tupa) {
		this.vcod_tupa = vcod_tupa;
	}
	/**
	 * @return the nom_tupa
	 */
	public String getNom_tupa() {
		return nom_tupa;
	}
	/**
	 * @param nom_tupa the nom_tupa to set
	 */
	public void setNom_tupa(String nom_tupa) {
		this.nom_tupa = nom_tupa;
	}
	/**
	 * @return the num_pct_uit
	 */
	public BigDecimal getNum_pct_uit() {
		return num_pct_uit;
	}
	/**
	 * @param num_pct_uit the num_pct_uit to set
	 */
	public void setNum_pct_uit(BigDecimal num_pct_uit) {
		this.num_pct_uit = num_pct_uit;
	}
	/**
	 * @return the num_imp_unit
	 */
	public BigDecimal getNum_imp_unit() {
		return num_imp_unit;
	}
	/**
	 * @param num_imp_unit the num_imp_unit to set
	 */
	public void setNum_imp_unit(BigDecimal num_imp_unit) {
		this.num_imp_unit = num_imp_unit;
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

}
