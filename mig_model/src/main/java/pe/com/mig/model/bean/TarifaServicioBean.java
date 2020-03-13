package pe.com.mig.model.bean;

import java.math.BigDecimal;

/**
 * @className: TarifaServicioBean.java
 * @description: 
 * @date: 2 de jul. de 2016
 * @author: SUMERIO.
 */
public class TarifaServicioBean extends MBaseBean {
	
	private static final long serialVersionUID = 1L;
	private Integer cod_servicio;
	private String vcod_servicio;
	private String nom_servicio;
	private BigDecimal num_pct_uit;
	private BigDecimal num_imp_val_venta;
	private BigDecimal num_imp_igv;
	private BigDecimal num_imp_pre_venta;
	private String cod_especifica;
	private String cod_cuenta;
	private String fla_activo;
	
	/**
	 * @return the cod_servicio
	 */
	public Integer getCod_servicio() {
		return cod_servicio;
	}
	/**
	 * @param cod_servicio the cod_servicio to set
	 */
	public void setCod_servicio(Integer cod_servicio) {
		this.cod_servicio = cod_servicio;
	}
	/**
	 * @return the vcod_servicio
	 */
	public String getVcod_servicio() {
		return vcod_servicio;
	}
	/**
	 * @param vcod_servicio the vcod_servicio to set
	 */
	public void setVcod_servicio(String vcod_servicio) {
		this.vcod_servicio = vcod_servicio;
	}
	/**
	 * @return the nom_servicio
	 */
	public String getNom_servicio() {
		return nom_servicio;
	}
	/**
	 * @param nom_servicio the nom_servicio to set
	 */
	public void setNom_servicio(String nom_servicio) {
		this.nom_servicio = nom_servicio;
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
	 * @return the num_imp_val_venta
	 */
	public BigDecimal getNum_imp_val_venta() {
		return num_imp_val_venta;
	}
	/**
	 * @param num_imp_val_venta the num_imp_val_venta to set
	 */
	public void setNum_imp_val_venta(BigDecimal num_imp_val_venta) {
		this.num_imp_val_venta = num_imp_val_venta;
	}
	/**
	 * @return the num_imp_igv
	 */
	public BigDecimal getNum_imp_igv() {
		return num_imp_igv;
	}
	/**
	 * @param num_imp_igv the num_imp_igv to set
	 */
	public void setNum_imp_igv(BigDecimal num_imp_igv) {
		this.num_imp_igv = num_imp_igv;
	}
	/**
	 * @return the num_imp_pre_venta
	 */
	public BigDecimal getNum_imp_pre_venta() {
		return num_imp_pre_venta;
	}
	/**
	 * @param num_imp_pre_venta the num_imp_pre_venta to set
	 */
	public void setNum_imp_pre_venta(BigDecimal num_imp_pre_venta) {
		this.num_imp_pre_venta = num_imp_pre_venta;
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
