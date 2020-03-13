package pe.com.mig.model.bean;

import java.math.BigDecimal;

/**
 * @className: DetalleComprasBean.java
 * @description: 
 * @date: 12 de jun. de 2016
 * @author: SUMERIO.
 */
public class DetalleComprasBean extends MBaseBean {

	private static final long serialVersionUID = 1L;
	private Integer cod_compra;
	private Integer cod_det_compra;
	private Long cod_especifica;
	private String vcod_especifica;
	private String des_especifica;	
	private Integer cod_cuenta;
	private String vcod_cuenta;
	private String nom_cuenta;	
	private BigDecimal num_imp_servicio;
	private String cod_tip_venta;
	private String des_tip_venta;
	private BigDecimal num_imp_afecto;
	private BigDecimal num_imp_no_afecto;
	private BigDecimal num_imp_igv;
	private BigDecimal num_imp_isc;
	private Integer int_id_registro;
	private String fue_financiamiento;
	private Integer num_siaf;
	private String num_comprobante;
	private String fec_com_transferencia;
	private String ind_retencion;
	private String num_retencion;
	private String fec_pago;
	private String cod_meta;
	

	/**
	 * 
	 */
	public DetalleComprasBean() {
		super();
	}
	
	/**
	 * @param cod_det_compra
	 */
	public DetalleComprasBean(Integer cod_det_compra) {
		super();
		this.cod_det_compra = cod_det_compra;
	}

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
	 * @return the cod_det_compra
	 */
	public Integer getCod_det_compra() {
		return cod_det_compra;
	}

	/**
	 * @param cod_det_compra the cod_det_compra to set
	 */
	public void setCod_det_compra(Integer cod_det_compra) {
		this.cod_det_compra = cod_det_compra;
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
	 * @return the num_imp_servicio
	 */
	public BigDecimal getNum_imp_servicio() {
		return num_imp_servicio;
	}

	/**
	 * @param num_imp_servicio the num_imp_servicio to set
	 */
	public void setNum_imp_servicio(BigDecimal num_imp_servicio) {
		this.num_imp_servicio = num_imp_servicio;
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
	 * @return the fue_financiamiento
	 */
	public String getFue_financiamiento() {
		return fue_financiamiento;
	}

	/**
	 * @param fue_financiamiento the fue_financiamiento to set
	 */
	public void setFue_financiamiento(String fue_financiamiento) {
		this.fue_financiamiento = fue_financiamiento;
	}

	/**
	 * @return the num_siaf
	 */
	public Integer getNum_siaf() {
		return num_siaf;
	}

	/**
	 * @param num_siaf the num_siaf to set
	 */
	public void setNum_siaf(Integer num_siaf) {
		this.num_siaf = num_siaf;
	}

	/**
	 * @return the num_comprobante
	 */
	public String getNum_comprobante() {
		return num_comprobante;
	}

	/**
	 * @param num_comprobante the num_comprobante to set
	 */
	public void setNum_comprobante(String num_comprobante) {
		this.num_comprobante = num_comprobante;
	}

	/**
	 * @return the fec_com_transferencia
	 */
	public String getFec_com_transferencia() {
		return fec_com_transferencia;
	}

	/**
	 * @param fec_com_transferencia the fec_com_transferencia to set
	 */
	public void setFec_com_transferencia(String fec_com_transferencia) {
		this.fec_com_transferencia = fec_com_transferencia;
	}
	
	/**
	 * @return the ind_retencion
	 */
	public String getInd_retencion() {
		return ind_retencion;
	}

	/**
	 * @param ind_retencion the ind_retencion to set
	 */
	public void setInd_retencion(String ind_retencion) {
		this.ind_retencion = ind_retencion;
	}

	/**
	 * @return the num_retencion
	 */
	public String getNum_retencion() {
		return num_retencion;
	}

	/**
	 * @param num_retencion the num_retencion to set
	 */
	public void setNum_retencion(String num_retencion) {
		this.num_retencion = num_retencion;
	}

	/**
	 * @return the fec_pago
	 */
	public String getFec_pago() {
		return fec_pago;
	}

	/**
	 * @param fec_pago the fec_pago to set
	 */
	public void setFec_pago(String fec_pago) {
		this.fec_pago = fec_pago;
	}
	
	/**
	 * @return the cod_meta
	 */
	public String getCod_meta() {
		return cod_meta;
	}

	/**
	 * @param cod_meta the cod_meta to set
	 */
	public void setCod_meta(String cod_meta) {
		this.cod_meta = cod_meta;
	}
}
