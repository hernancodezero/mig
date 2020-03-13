package pe.com.mig.model.bean;

import java.math.BigDecimal;

/**
 * @className: ProductoBean.java
 * @description: 
 * @date: 2 de jul. de 2016
 * @author: SUMERIO.
 */
public class ProductoBean extends MBaseBean {
	
	private static final long serialVersionUID = 1L;
	private Integer cod_producto;
	private Integer cod_uni_medida;
	private String nom_uni_medida;
	private String vcod_producto;
	private String nom_producto;
	private BigDecimal imp_pct_uit;
	private BigDecimal num_imp_unit;
	private BigDecimal num_imp_igv;
	private BigDecimal num_imp_pre_venta;
	private BigDecimal num_imp_producto;
	private String mnt_fec_creacion;	
	private String mnt_usu_creacion;
	private String mnt_fec_modificacion;
	private String mnt_usu_modificacion;
	private String fla_activo;
	private String cod_especifica;
	private String cod_cuenta;
	private String chrNomCuenta;
	
	
	/**
	 * @return the cod_producto
	 */
	public Integer getCod_producto() {
		return cod_producto;
	}
	/**
	 * @param cod_producto the cod_producto to set
	 */
	public void setCod_producto(Integer cod_producto) {
		this.cod_producto = cod_producto;
	}
	/**
	 * @return the cod_uni_medida
	 */
	public Integer getCod_uni_medida() {
		return cod_uni_medida;
	}
	/**
	 * @param cod_uni_medida the cod_uni_medida to set
	 */
	public void setCod_uni_medida(Integer cod_uni_medida) {
		this.cod_uni_medida = cod_uni_medida;
	}
	/**
	 * @return the nom_uni_medida
	 */
	public String getNom_uni_medida() {
		return nom_uni_medida;
	}
	/**
	 * @param nom_uni_medida the nom_uni_medida to set
	 */
	public void setNom_uni_medida(String nom_uni_medida) {
		this.nom_uni_medida = nom_uni_medida;
	}
	/**
	 * @return the vcod_producto
	 */
	public String getVcod_producto() {
		return vcod_producto;
	}
	/**
	 * @param vcod_producto the vcod_producto to set
	 */
	public void setVcod_producto(String vcod_producto) {
		this.vcod_producto = vcod_producto;
	}
	/**
	 * @return the nom_producto
	 */
	public String getNom_producto() {
		return nom_producto;
	}
	/**
	 * @param nom_producto the nom_producto to set
	 */
	public void setNom_producto(String nom_producto) {
		this.nom_producto = nom_producto;
	}
	/**
	 * @return the imp_pct_uit
	 */
	public BigDecimal getImp_pct_uit() {
		return imp_pct_uit;
	}
	/**
	 * @param imp_pct_uit the imp_pct_uit to set
	 */
	public void setImp_pct_uit(BigDecimal imp_pct_uit) {
		this.imp_pct_uit = imp_pct_uit;
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
	 * @return the cod_cuenta
	 */
	public String getChrNomCuenta() {
		return chrNomCuenta;
	}
	/**
	 * @param cod_cuenta the cod_cuenta to set
	 */
	public void setChrNomCuenta(String chrNomCuenta) {
		this.chrNomCuenta = chrNomCuenta;
	}
	
	/**
	 * @return the num_imp_producto
	 */
	public BigDecimal getNum_imp_producto() {
		return num_imp_producto;
	}
	/**
	 * @param num_imp_producto the num_imp_producto to set
	 */
	public void setNum_imp_producto(BigDecimal num_imp_producto) {
		this.num_imp_producto = num_imp_producto;
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
