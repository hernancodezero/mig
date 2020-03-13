package pe.com.mig.model.bean;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @className: ReporteDetalleIngresosBean.java
 * @description: 
 * @date: 2 de jul. de 2016
 * @author: SUMERIO.
 */
public class ReporteDetalleIngresosBean implements Serializable {

	private static final long serialVersionUID = 1L;
	// Detalle de Ingresos
	private Integer cod_det_ingreso;
	private String cod_especifica;
	private Integer cod_com_ingresos;
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
	private BigDecimal imp_det_total;
	private BigDecimal imp_det_total_dolares;
	private String cod_cuenta;
	private String cod_tip_doc_proveedor;	
	private BigDecimal imp_no_afe_tip_ven_exo;
	private BigDecimal imp_no_afe_tip_ven_no_gra;
	// Detalle de Papeletas
	private String num_voucher;
	private String fec_voucher;
	// Ingresos
	private Integer cod_comprobante;
	private String tip_comprobante;
	private Integer cod_moneda;
	private String tip_moneda;
	private BigDecimal num_tip_cambio;
	private Integer cod_proveedor;
	private Long num_ruc;
	private String tip_proveedor;
	private String tip_estado;
	private String raz_social;
	private String nombres;
	private String ape_paterno;
	private String ape_materno;
	private Integer cod_uni_operativa;
	private String des_uni_operativa;
	private Integer cod_reg_nac;
	private String des_reg_nac;
	private Integer int_transaccion;
	private String ser_comprobante;
	private String nro_comprobante;
	private String fec_comprobante;
	private BigDecimal imp_total;
	private Integer cod_pad_com_ingresos;	
	private BigDecimal num_imp_voucher;
	private String ruc_nro_doc_prov;
	private String raz_soc_prov;
	private String tip_com_siglas;
	private String num_cta_cte;
	private String periodo;
	private String tip_documento;
	private String ser_nro_comprobante;
	private String tip_operacion;
	private String fec_vto;
	private String vcod_comprobante;
	private String tip_doc_proveedor;
	private String ser_com_not_cre;
	private String nro_com_not_cre;
	private String fec_com_not_cre;
	private String tip_com_not_cre;
	private String fec_vencimiento;
	private String sig_moneda;

	
	/**
	 * @return the cod_com_ingresos
	 */
	public Integer getCod_com_ingresos() {
		return cod_com_ingresos;
	}
	/**
	 * @param cod_com_ingresos the cod_com_ingresos to set
	 */
	public void setCod_com_ingresos(Integer cod_com_ingresos) {
		this.cod_com_ingresos = cod_com_ingresos;
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
	 * @return the tip_comprobante
	 */
	public String getTip_comprobante() {
		return tip_comprobante;
	}
	/**
	 * @param tip_comprobante the tip_comprobante to set
	 */
	public void setTip_comprobante(String tip_comprobante) {
		this.tip_comprobante = tip_comprobante;
	}
	/**
	 * @return the cod_moneda
	 */
	public Integer getCod_moneda() {
		return cod_moneda;
	}
	/**
	 * @param cod_moneda the cod_moneda to set
	 */
	public void setCod_moneda(Integer cod_moneda) {
		this.cod_moneda = cod_moneda;
	}
	/**
	 * @return the tip_moneda
	 */
	public String getTip_moneda() {
		return tip_moneda;
	}
	/**
	 * @param tip_moneda the tip_moneda to set
	 */
	public void setTip_moneda(String tip_moneda) {
		this.tip_moneda = tip_moneda;
	}
	/**
	 * @return the cod_proveedor
	 */
	public Integer getCod_proveedor() {
		return cod_proveedor;
	}
	/**
	 * @param cod_proveedor the cod_proveedor to set
	 */
	public void setCod_proveedor(Integer cod_proveedor) {
		this.cod_proveedor = cod_proveedor;
	}
	/**
	 * @return the num_ruc
	 */
	public Long getNum_ruc() {
		return num_ruc;
	}
	/**
	 * @param num_ruc the num_ruc to set
	 */
	public void setNum_ruc(Long num_ruc) {
		this.num_ruc = num_ruc;
	}
	/**
	 * @return the tip_proveedor
	 */
	public String getTip_proveedor() {
		return tip_proveedor;
	}
	/**
	 * @param tip_proveedor the tip_proveedor to set
	 */
	public void setTip_proveedor(String tip_proveedor) {
		this.tip_proveedor = tip_proveedor;
	}
	/**
	 * @return the tip_estado
	 */
	public String getTip_estado() {
		return tip_estado;
	}
	/**
	 * @param tip_estado the tip_estado to set
	 */
	public void setTip_estado(String tip_estado) {
		this.tip_estado = tip_estado;
	}
	/**
	 * @return the raz_social
	 */
	public String getRaz_social() {
		return raz_social;
	}
	/**
	 * @param raz_social the raz_social to set
	 */
	public void setRaz_social(String raz_social) {
		this.raz_social = raz_social;
	}
	/**
	 * @return the nombres
	 */
	public String getNombres() {
		return nombres;
	}
	/**
	 * @param nombres the nombres to set
	 */
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	/**
	 * @return the ape_paterno
	 */
	public String getApe_paterno() {
		return ape_paterno;
	}
	/**
	 * @param ape_paterno the ape_paterno to set
	 */
	public void setApe_paterno(String ape_paterno) {
		this.ape_paterno = ape_paterno;
	}
	/**
	 * @return the ape_materno
	 */
	public String getApe_materno() {
		return ape_materno;
	}
	/**
	 * @param ape_materno the ape_materno to set
	 */
	public void setApe_materno(String ape_materno) {
		this.ape_materno = ape_materno;
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
	 * @return the ser_comprobante
	 */
	public String getSer_comprobante() {
		return ser_comprobante;
	}
	/**
	 * @param ser_comprobante the ser_comprobante to set
	 */
	public void setSer_comprobante(String ser_comprobante) {
		this.ser_comprobante = ser_comprobante;
	}
	/**
	 * @return the nro_comprobante
	 */
	public String getNro_comprobante() {
		return nro_comprobante;
	}
	/**
	 * @param nro_comprobante the nro_comprobante to set
	 */
	public void setNro_comprobante(String nro_comprobante) {
		this.nro_comprobante = nro_comprobante;
	}
	/**
	 * @return the fec_comprobante
	 */
	public String getFec_comprobante() {
		return fec_comprobante;
	}
	/**
	 * @param fec_comprobante the fec_comprobante to set
	 */
	public void setFec_comprobante(String fec_comprobante) {
		this.fec_comprobante = fec_comprobante;
	}
	/**
	 * @return the cod_pad_com_ingresos
	 */
	public Integer getCod_pad_com_ingresos() {
		return cod_pad_com_ingresos;
	}
	/**
	 * @param cod_pad_com_ingresos the cod_pad_com_ingresos to set
	 */
	public void setCod_pad_com_ingresos(Integer cod_pad_com_ingresos) {
		this.cod_pad_com_ingresos = cod_pad_com_ingresos;
	}
	/**
	 * @return the num_voucher
	 */
	public String getNum_voucher() {
		return num_voucher;
	}
	/**
	 * @param num_voucher the num_voucher to set
	 */
	public void setNum_voucher(String num_voucher) {
		this.num_voucher = num_voucher;
	}
	/**
	 * @return the fec_voucher
	 */
	public String getFec_voucher() {
		return fec_voucher;
	}
	/**
	 * @param fec_voucher the fec_voucher to set
	 */
	public void setFec_voucher(String fec_voucher) {
		this.fec_voucher = fec_voucher;
	}
	/**
	 * @return the num_imp_voucher
	 */
	public BigDecimal getNum_imp_voucher() {
		return num_imp_voucher;
	}
	/**
	 * @param num_imp_voucher the num_imp_voucher to set
	 */
	public void setNum_imp_voucher(BigDecimal num_imp_voucher) {
		this.num_imp_voucher = num_imp_voucher;
	}
	/**
	 * @return the imp_total
	 */
	public BigDecimal getImp_total() {
		return imp_total;
	}
	/**
	 * @param imp_total the imp_total to set
	 */
	public void setImp_total(BigDecimal imp_total) {
		this.imp_total = imp_total;
	}
	/**
	 * @return the int_transaccion
	 */
	public Integer getInt_transaccion() {
		return int_transaccion;
	}
	/**
	 * @param int_transaccion the int_transaccion to set
	 */
	public void setInt_transaccion(Integer int_transaccion) {
		this.int_transaccion = int_transaccion;
	}
	/**
	 * @return the imp_det_total
	 */
	public BigDecimal getImp_det_total() {
		return imp_det_total;
	}
	/**
	 * @param imp_det_total the imp_det_total to set
	 */
	public void setImp_det_total(BigDecimal imp_det_total) {
		this.imp_det_total = imp_det_total;
	}
	/**
	 * @return the ruc_nro_doc_prov
	 */
	public String getRuc_nro_doc_prov() {
		return ruc_nro_doc_prov;
	}
	/**
	 * @param ruc_nro_doc_prov the ruc_nro_doc_prov to set
	 */
	public void setRuc_nro_doc_prov(String ruc_nro_doc_prov) {
		this.ruc_nro_doc_prov = ruc_nro_doc_prov;
	}
	/**
	 * @return the raz_soc_prov
	 */
	public String getRaz_soc_prov() {
		return raz_soc_prov;
	}
	/**
	 * @param raz_soc_prov the raz_soc_prov to set
	 */
	public void setRaz_soc_prov(String raz_soc_prov) {
		this.raz_soc_prov = raz_soc_prov;
	}
	/**
	 * @return the tip_com_siglas
	 */
	public String getTip_com_siglas() {
		return tip_com_siglas;
	}
	/**
	 * @param tip_com_siglas the tip_com_siglas to set
	 */
	public void setTip_com_siglas(String tip_com_siglas) {
		this.tip_com_siglas = tip_com_siglas;
	}
	/**
	 * @return the num_tip_cambio
	 */
	public BigDecimal getNum_tip_cambio() {
		return num_tip_cambio;
	}
	/**
	 * @param num_tip_cambio the num_tip_cambio to set
	 */
	public void setNum_tip_cambio(BigDecimal num_tip_cambio) {
		this.num_tip_cambio = num_tip_cambio;
	}
	/**
	 * @return the num_cta_cte
	 */
	public String getNum_cta_cte() {
		return num_cta_cte;
	}
	/**
	 * @param num_cta_cte the num_cta_cte to set
	 */
	public void setNum_cta_cte(String num_cta_cte) {
		this.num_cta_cte = num_cta_cte;
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
	 * @return the periodo
	 */
	public String getPeriodo() {
		return periodo;
	}
	/**
	 * @param periodo the periodo to set
	 */
	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
	/**
	 * @return the tip_documento
	 */
	public String getTip_documento() {
		return tip_documento;
	}
	/**
	 * @param tip_documento the tip_documento to set
	 */
	public void setTip_documento(String tip_documento) {
		this.tip_documento = tip_documento;
	}
	/**
	 * @return the ser_nro_comprobante
	 */
	public String getSer_nro_comprobante() {
		return ser_nro_comprobante;
	}
	/**
	 * @param ser_nro_comprobante the ser_nro_comprobante to set
	 */
	public void setSer_nro_comprobante(String ser_nro_comprobante) {
		this.ser_nro_comprobante = ser_nro_comprobante;
	}
	/**
	 * @return the tip_operacion
	 */
	public String getTip_operacion() {
		return tip_operacion;
	}
	/**
	 * @param tip_operacion the tip_operacion to set
	 */
	public void setTip_operacion(String tip_operacion) {
		this.tip_operacion = tip_operacion;
	}
	/**
	 * @return the fec_vto
	 */
	public String getFec_vto() {
		return fec_vto;
	}
	/**
	 * @param fec_vto the fec_vto to set
	 */
	public void setFec_vto(String fec_vto) {
		this.fec_vto = fec_vto;
	}
	/**
	 * @return the vcod_comprobante
	 */
	public String getVcod_comprobante() {
		return vcod_comprobante;
	}
	/**
	 * @param vcod_comprobante the vcod_comprobante to set
	 */
	public void setVcod_comprobante(String vcod_comprobante) {
		this.vcod_comprobante = vcod_comprobante;
	}
	/**
	 * @return the tip_doc_proveedor
	 */
	public String getTip_doc_proveedor() {
		return tip_doc_proveedor;
	}
	/**
	 * @param tip_doc_proveedor the tip_doc_proveedor to set
	 */
	public void setTip_doc_proveedor(String tip_doc_proveedor) {
		this.tip_doc_proveedor = tip_doc_proveedor;
	}
	/**
	 * @return the cod_tip_doc_proveedor
	 */
	public String getCod_tip_doc_proveedor() {
		return cod_tip_doc_proveedor;
	}
	/**
	 * @param cod_tip_doc_proveedor the cod_tip_doc_proveedor to set
	 */
	public void setCod_tip_doc_proveedor(String cod_tip_doc_proveedor) {
		this.cod_tip_doc_proveedor = cod_tip_doc_proveedor;
	}
	/**
	 * @return the ser_com_not_cre
	 */
	public String getSer_com_not_cre() {
		return ser_com_not_cre;
	}
	/**
	 * @param ser_com_not_cre the ser_com_not_cre to set
	 */
	public void setSer_com_not_cre(String ser_com_not_cre) {
		this.ser_com_not_cre = ser_com_not_cre;
	}
	/**
	 * @return the nro_com_not_cre
	 */
	public String getNro_com_not_cre() {
		return nro_com_not_cre;
	}
	/**
	 * @param nro_com_not_cre the nro_com_not_cre to set
	 */
	public void setNro_com_not_cre(String nro_com_not_cre) {
		this.nro_com_not_cre = nro_com_not_cre;
	}
	/**
	 * @return the fec_com_not_cre
	 */
	public String getFec_com_not_cre() {
		return fec_com_not_cre;
	}
	/**
	 * @param fec_com_not_cre the fec_com_not_cre to set
	 */
	public void setFec_com_not_cre(String fec_com_not_cre) {
		this.fec_com_not_cre = fec_com_not_cre;
	}
	/**
	 * @return the tip_com_not_cre
	 */
	public String getTip_com_not_cre() {
		return tip_com_not_cre;
	}
	/**
	 * @param tip_com_not_cre the tip_com_not_cre to set
	 */
	public void setTip_com_not_cre(String tip_com_not_cre) {
		this.tip_com_not_cre = tip_com_not_cre;
	}
	/**
	 * @return the fec_vencimiento
	 */
	public String getFec_vencimiento() {
		return fec_vencimiento;
	}
	/**
	 * @param fec_vencimiento the fec_vencimiento to set
	 */
	public void setFec_vencimiento(String fec_vencimiento) {
		this.fec_vencimiento = fec_vencimiento;
	}
	/**
	 * @return the sig_moneda
	 */
	public String getSig_moneda() {
		return sig_moneda;
	}
	/**
	 * @param sig_moneda the sig_moneda to set
	 */
	public void setSig_moneda(String sig_moneda) {
		this.sig_moneda = sig_moneda;
	}
	/**
	 * @return the imp_no_afe_tip_ven_exo
	 */
	public BigDecimal getImp_no_afe_tip_ven_exo() {
		return imp_no_afe_tip_ven_exo;
	}
	/**
	 * @param imp_no_afe_tip_ven_exo the imp_no_afe_tip_ven_exo to set
	 */
	public void setImp_no_afe_tip_ven_exo(BigDecimal imp_no_afe_tip_ven_exo) {
		this.imp_no_afe_tip_ven_exo = imp_no_afe_tip_ven_exo;
	}
	/**
	 * @return the imp_no_afe_tip_ven_no_gra
	 */
	public BigDecimal getImp_no_afe_tip_ven_no_gra() {
		return imp_no_afe_tip_ven_no_gra;
	}
	/**
	 * @param imp_no_afe_tip_ven_no_gra the imp_no_afe_tip_ven_no_gra to set
	 */
	public void setImp_no_afe_tip_ven_no_gra(BigDecimal imp_no_afe_tip_ven_no_gra) {
		this.imp_no_afe_tip_ven_no_gra = imp_no_afe_tip_ven_no_gra;
	}
	/**
	 * @return the imp_det_total_dolares
	 */
	public BigDecimal getImp_det_total_dolares() {
		return imp_det_total_dolares;
	}
	/**
	 * @param imp_det_total_dolares the imp_det_total_dolares to set
	 */
	public void setImp_det_total_dolares(BigDecimal imp_det_total_dolares) {
		this.imp_det_total_dolares = imp_det_total_dolares;
	}
	
}
