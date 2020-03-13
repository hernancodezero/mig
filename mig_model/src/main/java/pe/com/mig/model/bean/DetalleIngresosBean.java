package pe.com.mig.model.bean;

import java.math.BigDecimal;

/**
 * @className: DetalleIngresosBean.java
 * @description: 
 * @date: 2 de jul. de 2016
 * @author: SUMERIO.
 */
public class DetalleIngresosBean extends MBaseBean {

	private static final long serialVersionUID = 1L;	
	private Integer cod_det_ingreso;
	private Integer cod_especifica;
	private Integer cod_compra;
	private Integer cod_producto;
	private String des_producto;
	private Integer cod_boleto;
	private String des_boleto;
	private Integer cod_servicio;
	private String vcod_servicio;
	private String des_servicio;
	private BigDecimal num_imp_pre_ven_servicio;
	private Integer cod_tupa;	
	private String vcod_tupa;
	private String nom_tupa;
	private BigDecimal num_imp_unit_tupa;
	private String tip_transaccion;
	private String cta_presupuestal;
	private BigDecimal num_pre_unitario;
	private Integer can_dias;
	//private Integer can_producto;
	private BigDecimal can_producto;
	private String vcod_producto;
	private String nom_producto;
	private BigDecimal num_pre_uni_producto;
	private String num_ser_boleto;
	private Integer ini_boleto;
	private Integer fin_boleto;
	private BigDecimal num_pre_uni_boleto;
	private String des_ind_tarifa;
	private BigDecimal num_imp_unit_boleto;
	private Integer cod_otros;
	private String des_otros;
	private String cod_tip_venta;
	private String des_tip_venta;
	private BigDecimal num_imp_afecto;
	private BigDecimal num_imp_no_afecto;
	private BigDecimal num_imp_igv;
	private BigDecimal num_imp_isc;
	private Integer int_id_registro;
	private BigDecimal imp_tot_pro;
	private BigDecimal imp_tot_ser;
	private Integer can_pers;
	private Integer cod_cuenta;
	private String vcod_cuenta;
	private String nom_cuenta;
	private Integer cod_espec;
	private String vcod_especifica;
	private String des_especifica;
	private String cod_meta;
	/**
	 * @return the cod_compra
	 */
	public Integer getCod_compra() {
		return cod_compra;
	}
	/**
	 * @param cod_compra the cod_compra to set
	 */
	public void setCod_compra(Integer cod_compra) {
		this.cod_compra = cod_compra;
	}		
	/**
	 * @return the can_pers
	 */
	public Integer getCan_pers() {
		return can_pers;
	}
	/**
	 * @param can_pers the can_pers to set
	 */
	public void setCan_pers(Integer can_pers) {
		this.can_pers = can_pers;
	}
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
	 * @return the des_producto
	 */
	public String getDes_producto() {
		return des_producto;
	}
	/**
	 * @param des_producto the des_producto to set
	 */
	public void setDes_producto(String des_producto) {
		this.des_producto = des_producto;
	}
	/**
	 * @return the cod_boleto
	 */
	public Integer getCod_boleto() {
		return cod_boleto;
	}
	/**
	 * @param cod_boleto the cod_boleto to set
	 */
	public void setCod_boleto(Integer cod_boleto) {
		this.cod_boleto = cod_boleto;
	}
	/**
	 * @return the des_boleto
	 */
	public String getDes_boleto() {
		return des_boleto;
	}
	/**
	 * @param des_boleto the des_boleto to set
	 */
	public void setDes_boleto(String des_boleto) {
		this.des_boleto = des_boleto;
	}
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
	 * @return the des_servicio
	 */
	public String getDes_servicio() {
		return des_servicio;
	}
	/**
	 * @param des_servicio the des_servicio to set
	 */
	public void setDes_servicio(String des_servicio) {
		this.des_servicio = des_servicio;
	}
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
	 * @return the tip_transaccion
	 */
	public String getTip_transaccion() {
		return tip_transaccion;
	}
	/**
	 * @param tip_transaccion the tip_transaccion to set
	 */
	public void setTip_transaccion(String tip_transaccion) {
		this.tip_transaccion = tip_transaccion;
	}
	/**
	 * @return the cta_presupuestal
	 */
	public String getCta_presupuestal() {
		return cta_presupuestal;
	}
	/**
	 * @param cta_presupuestal the cta_presupuestal to set
	 */
	public void setCta_presupuestal(String cta_presupuestal) {
		this.cta_presupuestal = cta_presupuestal;
	}
	/**
	 * @return the num_pre_unitario
	 */
	public BigDecimal getNum_pre_unitario() {
		return num_pre_unitario;
	}
	/**
	 * @param num_pre_unitario the num_pre_unitario to set
	 */
	public void setNum_pre_unitario(BigDecimal num_pre_unitario) {
		this.num_pre_unitario = num_pre_unitario;
	}
	/**
	 * @return the can_dias
	 */
	public Integer getCan_dias() {
		return can_dias;
	}
	/**
	 * @param can_dias the can_dias to set
	 */
	public void setCan_dias(Integer can_dias) {
		this.can_dias = can_dias;
	}
	/**
	 * @return the can_producto
	 */
	public BigDecimal getCan_producto() {
		return can_producto;
	}
	/**
	 * @param can_producto the can_producto to set
	 */
	public void setCan_producto(BigDecimal can_producto) {
		this.can_producto = can_producto;
	}
	/**
	 * @return the num_pre_uni_producto
	 */
	public BigDecimal getNum_pre_uni_producto() {
		return num_pre_uni_producto;
	}
	/**
	 * @param num_pre_uni_producto the num_pre_uni_producto to set
	 */
	public void setNum_pre_uni_producto(BigDecimal num_pre_uni_producto) {
		this.num_pre_uni_producto = num_pre_uni_producto;
	}
	/**
	 * @return the num_ser_boleto
	 */
	public String getNum_ser_boleto() {
		return num_ser_boleto;
	}
	/**
	 * @param num_ser_boleto the num_ser_boleto to set
	 */
	public void setNum_ser_boleto(String num_ser_boleto) {
		this.num_ser_boleto = num_ser_boleto;
	}
	/**
	 * @return the ini_boleto
	 */
	public Integer getIni_boleto() {
		return ini_boleto;
	}
	/**
	 * @param ini_boleto the ini_boleto to set
	 */
	public void setIni_boleto(Integer ini_boleto) {
		this.ini_boleto = ini_boleto;
	}
	/**
	 * @return the fin_boleto
	 */
	public Integer getFin_boleto() {
		return fin_boleto;
	}
	/**
	 * @param fin_boleto the fin_boleto to set
	 */
	public void setFin_boleto(Integer fin_boleto) {
		this.fin_boleto = fin_boleto;
	}
	/**
	 * @return the num_pre_uni_boleto
	 */
	public BigDecimal getNum_pre_uni_boleto() {
		return num_pre_uni_boleto;
	}
	/**
	 * @param num_pre_uni_boleto the num_pre_uni_boleto to set
	 */
	public void setNum_pre_uni_boleto(BigDecimal num_pre_uni_boleto) {
		this.num_pre_uni_boleto = num_pre_uni_boleto;
	}
	/**
	 * @return the int_id_registro
	 */
	public Integer getInt_id_registro() {
		return int_id_registro;
	}
	/**
	 * @param int_id_registro the int_id_registro to set
	 */
	public void setInt_id_registro(Integer int_id_registro) {
		this.int_id_registro = int_id_registro;
	}
	/**
	 * @return the cod_tip_venta
	 */
	public String getCod_tip_venta() {
		return cod_tip_venta;
	}
	/**
	 * @param cod_tip_venta the cod_tip_venta to set
	 */
	public void setCod_tip_venta(String cod_tip_venta) {
		this.cod_tip_venta = cod_tip_venta;
	}
	/**
	 * @return the des_tip_venta
	 */
	public String getDes_tip_venta() {
		return des_tip_venta;
	}
	/**
	 * @param des_tip_venta the des_tip_venta to set
	 */
	public void setDes_tip_venta(String des_tip_venta) {
		this.des_tip_venta = des_tip_venta;
	}
	/**
	 * @return the num_imp_afecto
	 */
	public BigDecimal getNum_imp_afecto() {
		return num_imp_afecto;
	}
	/**
	 * @param num_imp_afecto the num_imp_afecto to set
	 */
	public void setNum_imp_afecto(BigDecimal num_imp_afecto) {
		this.num_imp_afecto = num_imp_afecto;
	}
	/**
	 * @return the num_imp_no_afecto
	 */
	public BigDecimal getNum_imp_no_afecto() {
		return num_imp_no_afecto;
	}
	/**
	 * @param num_imp_no_afecto the num_imp_no_afecto to set
	 */
	public void setNum_imp_no_afecto(BigDecimal num_imp_no_afecto) {
		this.num_imp_no_afecto = num_imp_no_afecto;
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
	 * @return the num_imp_isc
	 */
	public BigDecimal getNum_imp_isc() {
		return num_imp_isc;
	}
	/**
	 * @param num_imp_isc the num_imp_isc to set
	 */
	public void setNum_imp_isc(BigDecimal num_imp_isc) {
		this.num_imp_isc = num_imp_isc;
	}
	/**
	 * @return the cod_especifica
	 */
	public Integer getCod_especifica() {
		return cod_especifica;
	}
	/**
	 * @param cod_especifica the cod_especifica to set
	 */
	public void setCod_especifica(Integer cod_especifica) {
		this.cod_especifica = cod_especifica;
	}
	/**
	 * @return the cod_det_ingreso
	 */
	public Integer getCod_det_ingreso() {
		return cod_det_ingreso;
	}
	/**
	 * @param cod_det_ingreso the cod_det_ingreso to set
	 */
	public void setCod_det_ingreso(Integer cod_det_ingreso) {
		this.cod_det_ingreso = cod_det_ingreso;
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
	 * @return the num_imp_pre_ven_servicio
	 */
	public BigDecimal getNum_imp_pre_ven_servicio() {
		return num_imp_pre_ven_servicio;
	}
	/**
	 * @param num_imp_pre_ven_servicio the num_imp_pre_ven_servicio to set
	 */
	public void setNum_imp_pre_ven_servicio(BigDecimal num_imp_pre_ven_servicio) {
		this.num_imp_pre_ven_servicio = num_imp_pre_ven_servicio;
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
	 * @return the num_imp_unit_tupa
	 */
	public BigDecimal getNum_imp_unit_tupa() {
		return num_imp_unit_tupa;
	}
	/**
	 * @param num_imp_unit_tupa the num_imp_unit_tupa to set
	 */
	public void setNum_imp_unit_tupa(BigDecimal num_imp_unit_tupa) {
		this.num_imp_unit_tupa = num_imp_unit_tupa;
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
	 * @return the des_ind_tarifa
	 */
	public String getDes_ind_tarifa() {
		return des_ind_tarifa;
	}
	/**
	 * @param des_ind_tarifa the des_ind_tarifa to set
	 */
	public void setDes_ind_tarifa(String des_ind_tarifa) {
		this.des_ind_tarifa = des_ind_tarifa;
	}
	/**
	 * @return the num_imp_unit_boleto
	 */
	public BigDecimal getNum_imp_unit_boleto() {
		return num_imp_unit_boleto;
	}
	/**
	 * @param num_imp_unit_boleto the num_imp_unit_boleto to set
	 */
	public void setNum_imp_unit_boleto(BigDecimal num_imp_unit_boleto) {
		this.num_imp_unit_boleto = num_imp_unit_boleto;
	}
	/**
	 * @return the imp_tot_pro
	 */
	public BigDecimal getImp_tot_pro() {
		if (this.can_producto != null && this.num_pre_unitario != null) {
			//return num_pre_unitario.multiply(new BigDecimal(this.can_producto)).setScale(2, BigDecimal.ROUND_HALF_EVEN);
			return num_pre_unitario.multiply((this.can_producto)).setScale(2, BigDecimal.ROUND_HALF_EVEN);
		} else {
			return imp_tot_pro;
		}
	}
	/**
	 * @param imp_tot_pro the imp_tot_pro to set
	 */
	public void setImp_tot_pro(BigDecimal imp_tot_pro) {
		this.imp_tot_pro = imp_tot_pro;
	}
	/**
	 * @return the imp_tot_ser
	 */
	public BigDecimal getImp_tot_ser() {
		if (this.can_dias != null && this.num_pre_unitario != null) {
			return num_pre_unitario.multiply(new BigDecimal(this.can_dias)).setScale(2, BigDecimal.ROUND_HALF_EVEN);
		} else {
			return imp_tot_ser;
		}
	}
	/**
	 * @param imp_tot_ser the imp_tot_ser to set
	 */
	public void setImp_tot_ser(BigDecimal imp_tot_ser) {
		this.imp_tot_ser = imp_tot_ser;
	}
	/**
	 * @return the cod_otros
	 */
	public Integer getCod_otros() {
		return cod_otros;
	}
	/**
	 * @param cod_otros the cod_otros to set
	 */
	public void setCod_otros(Integer cod_otros) {
		this.cod_otros = cod_otros;
	}
	/**
	 * @return the des_otros
	 */
	public String getDes_otros() {
		return des_otros;
	}
	/**
	 * @param des_otros the des_otros to set
	 */
	public void setDes_otros(String des_otros) {
		this.des_otros = des_otros;
	}
	public Integer getCod_cuenta() {
		return cod_cuenta;
	}
	public void setCod_cuenta(Integer cod_cuenta) {
		this.cod_cuenta = cod_cuenta;
	}
	public String getVcod_cuenta() {
		return vcod_cuenta;
	}
	public void setVcod_cuenta(String vcod_cuenta) {
		this.vcod_cuenta = vcod_cuenta;
	}
	public String getNom_cuenta() {
		return nom_cuenta;
	}
	public void setNom_cuenta(String nom_cuenta) {
		this.nom_cuenta = nom_cuenta;
	}
	public Integer getCod_espec() {
		return cod_espec;
	}
	public void setCod_espec(Integer cod_espec) {
		this.cod_espec = cod_espec;
	}
	public String getVcod_especifica() {
		return vcod_especifica;
	}
	public void setVcod_especifica(String vcod_especifica) {
		this.vcod_especifica = vcod_especifica;
	}
	public String getDes_especifica() {
		return des_especifica;
	}
	public void setDes_especifica(String des_especifica) {
		this.des_especifica = des_especifica;
	}
	public String getCod_meta() {
		return cod_meta;
	}
	public void setCod_meta(String cod_meta) {
		this.cod_meta = cod_meta;
	}
	
}
