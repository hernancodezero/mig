package pe.com.mig.model.bean;

import java.math.BigDecimal;
import java.util.List;

/**
 * @className: TransferenciaBean.java
 * @description: 
 * @date: 12 de jun. de 2016
 * @author: SUMERIO.
 */
public class TransferenciaBean extends MBaseBean {

	private static final long serialVersionUID = 1L;
	private Integer cod_transferencia;
	private Integer cod_comprobante;
	private String tip_comprobante;
	private Integer cod_moneda;
	private String tip_moneda;
	private String ind_transaccion;
	private Integer int_transaccion;
	private String ser_comprobante;
	private String num_comprobante;
	private String fec_comprobante;
	private String cod_fue_financiamiento;
	private Integer num_siaf;
	private BigDecimal num_tip_cambio;
	private Integer cod_uni_operativa;
	private String des_uni_operativa;
	private Integer cod_reg_nac;
	private String des_reg_nac;
	private String num_doc_operacion;	
	private String fec_doc_operacion;
	private String fec_transferencia;
	private BigDecimal imp_total;
	private String concepto;
	private Integer int_id_registro;
	private String fec_desde;
	private String fec_hasta;
	private BigDecimal imp_tot_rc;
	private Double can_dia_transcurridos;
	private List<DetalleTransferenciaBean> lis_detalle;
	private String nro_doc_rc;
	private String fec_doc_rc;
	private String mnt_fec_creacion;	
	private String mnt_usu_creacion;
	private String mnt_fec_modificacion;
	private String mnt_usu_modificacion;
	private int ind_not_credito;
	private String num_doc_rendicion;
	private String ind_tipo_fpe;
	private Integer cod_mes;
	private Integer cod_anno;
	
	/**
	 * 
	 */
	public TransferenciaBean() {
		super();
	}
	
	/**
	 * @param cod_transferencia
	 */
	public TransferenciaBean(Integer cod_transferencia) {
		super();
		this.cod_transferencia = cod_transferencia;
	}
	
	/**
	 * @param num_comprobante
	 * @param num_siaf
	 */
	public TransferenciaBean(String num_comprobante, Integer num_siaf) {
		super();
		this.num_comprobante = num_comprobante;
		this.num_siaf = num_siaf;
	}

	/**
	 * @return the cod_transferencia
	 */
	public Integer getCod_transferencia() {
		return cod_transferencia;
	}
	/**
	 * @param cod_transferencia the cod_transferencia to set
	 */
	public void setCod_transferencia(Integer cod_transferencia) {
		this.cod_transferencia = cod_transferencia;
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
	 * @return the ind_transaccion
	 */
	public String getInd_transaccion() {
		return ind_transaccion;
	}
	/**
	 * @param ind_transaccion the ind_transaccion to set
	 */
	public void setInd_transaccion(String ind_transaccion) {
		this.ind_transaccion = ind_transaccion;
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
	 * @return the cod_fue_financiamiento
	 */
	public String getCod_fue_financiamiento() {
		return cod_fue_financiamiento;
	}
	/**
	 * @param cod_fue_financiamiento the cod_fue_financiamiento to set
	 */
	public void setCod_fue_financiamiento(String cod_fue_financiamiento) {
		this.cod_fue_financiamiento = cod_fue_financiamiento;
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
	 * @return the num_doc_operacion
	 */
	public String getNum_doc_operacion() {
		return num_doc_operacion;
	}
	/**
	 * @param num_doc_operacion the num_doc_operacion to set
	 */
	public void setNum_doc_operacion(String num_doc_operacion) {
		this.num_doc_operacion = num_doc_operacion;
	}
	/**
	 * @return the fec_doc_operacion
	 */
	public String getFec_doc_operacion() {
		return fec_doc_operacion;
	}
	/**
	 * @param fec_doc_operacion the fec_doc_operacion to set
	 */
	public void setFec_doc_operacion(String fec_doc_operacion) {
		this.fec_doc_operacion = fec_doc_operacion;
	}
	/**
	 * @return the fec_transferencia
	 */
	public String getFec_transferencia() {
		return fec_transferencia;
	}
	/**
	 * @param fec_transferencia the fec_transferencia to set
	 */
	public void setFec_transferencia(String fec_transferencia) {
		this.fec_transferencia = fec_transferencia;
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
	 * @return the concepto
	 */
	public String getConcepto() {
		return concepto;
	}
	/**
	 * @param concepto the concepto to set
	 */
	public void setConcepto(String concepto) {
		this.concepto = concepto;
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
	 * @return the fec_desde
	 */
	public String getFec_desde() {
		return fec_desde;
	}
	/**
	 * @param fec_desde the fec_desde to set
	 */
	public void setFec_desde(String fec_desde) {
		this.fec_desde = fec_desde;
	}
	/**
	 * @return the fec_hasta
	 */
	public String getFec_hasta() {
		return fec_hasta;
	}
	/**
	 * @param fec_hasta the fec_hasta to set
	 */
	public void setFec_hasta(String fec_hasta) {
		this.fec_hasta = fec_hasta;
	}
	/**
	 * @return the imp_tot_rc
	 */
	public BigDecimal getImp_tot_rc() {
		return imp_tot_rc;
	}
	/**
	 * @param imp_tot_rc the imp_tot_rc to set
	 */
	public void setImp_tot_rc(BigDecimal imp_tot_rc) {
		this.imp_tot_rc = imp_tot_rc;
	}
	/**
	 * @return the can_dia_transcurridos
	 */
	public Double getCan_dia_transcurridos() {
		return can_dia_transcurridos;
	}
	/**
	 * @param can_dia_transcurridos the can_dia_transcurridos to set
	 */
	public void setCan_dia_transcurridos(Double can_dia_transcurridos) {
		this.can_dia_transcurridos = can_dia_transcurridos;
	}
	/**
	 * @return the lis_detalle
	 */
	public List<DetalleTransferenciaBean> getLis_detalle() {
		return lis_detalle;
	}
	/**
	 * @param lis_detalle the lis_detalle to set
	 */
	public void setLis_detalle(List<DetalleTransferenciaBean> lis_detalle) {
		this.lis_detalle = lis_detalle;
	}
	/**
	 * @return the nro_doc_rc
	 */
	public String getNro_doc_rc() {
		return nro_doc_rc;
	}
	/**
	 * @param nro_doc_rc the nro_doc_rc to set
	 */
	public void setNro_doc_rc(String nro_doc_rc) {
		this.nro_doc_rc = nro_doc_rc;
	}
	/**
	 * @return the fec_doc_rc
	 */
	public String getFec_doc_rc() {
		return fec_doc_rc;
	}
	/**
	 * @param fec_doc_rc the fec_doc_rc to set
	 */
	public void setFec_doc_rc(String fec_doc_rc) {
		this.fec_doc_rc = fec_doc_rc;
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
	/**
	 * @return the ind_not_credito
	 */
	public int getInd_not_credito() {
		return ind_not_credito;
	}
	/**
	 * @param ind_not_credito the ind_not_credito to set
	 */
	public void setInd_not_credito(int ind_not_credito) {
		this.ind_not_credito = ind_not_credito;
	}

	/**
	 * @return the num_doc_rendicion
	 */
	public String getNum_doc_rendicion() {
		return num_doc_rendicion;
	}

	/**
	 * @param num_doc_rendicion the num_doc_rendicion to set
	 */
	public void setNum_doc_rendicion(String num_doc_rendicion) {
		this.num_doc_rendicion = num_doc_rendicion;
	}

	/**
	 * @return the ind_tipo_fpe
	 */
	public String getInd_tipo_fpe() {
		return ind_tipo_fpe;
	}

	/**
	 * @param ind_tipo_fpe the ind_tipo_fpe to set
	 */
	public void setInd_tipo_fpe(String ind_tipo_fpe) {
		this.ind_tipo_fpe = ind_tipo_fpe;
	}

	public Integer getCod_mes() {
		return cod_mes;
	}

	public void setCod_mes(Integer cod_mes) {
		this.cod_mes = cod_mes;
	}

	public Integer getCod_anno() {
		return cod_anno;
	}

	public void setCod_anno(Integer cod_anno) {
		this.cod_anno = cod_anno;
	}
		
	
}
