package pe.com.mig.model.bean;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @className: ReporteDetalleComprasBean.java
 * @description: 
 * @date: 12 de jun. de 2016
 * @author: SUMERIO.
 */
public class ReporteDetalleComprasBean implements Serializable {

	private static final long serialVersionUID = 1L;
	// Detalle de Compras
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
	private BigDecimal imp_det_total;
	private Double imp_no_gra_igv;
	private Double imp_gra_total;
	private BigDecimal imp_det_total_dolares;
	private String cod_meta;
	// Compras
	private Integer cod_comprobante;
	private String vcod_comprobante;
	private String tip_comprobante;
	private Integer cod_moneda;
	private String tip_moneda;	
	private Integer cod_proveedor;
	private Long num_ruc;
	private String tip_proveedor;
	private String tip_estado;
	private String raz_social;
	private String nombres;
	private String ape_paterno;
	private String ape_materno;
	private String tip_documento;
	private Integer cod_fue_financiamiento;
	private String des_fue_financiamiento;
	private Integer cod_med_pago;
	private String des_med_pago;
	private Integer cod_contrato;
	private String num_contrato;	
	private Integer int_transaccion;
	private String ser_comprobante;
	private String nro_comprobante;
	private String fec_comprobante;
	private Integer nro_siaf;
	private BigDecimal num_tip_cambio;
	private String tip_operacion;
	private String nro_doc_rc;
	private String fec_doc_rc;
	private String nro_cp;
	private Integer nro_sia_operacion;
	private BigDecimal imp_cp;
	private BigDecimal imp_total;
	private String ind_ser_publico;
	private BigDecimal mon_ser_publico;
	private String fec_pago;
	private String fec_vto;
	private String num_constancia;
	private BigDecimal imp_deposito;
	private String fec_pag_deposito;
	private Integer por_deposito;
	private String num_doc_empresa;
    private String fec_doc_empresa;
    private String num_doc_derivacion;
    private String fec_doc_derivacion;
	private Integer cod_uni_operativa;
	private String des_uni_operativa;
	private Integer cod_reg_nac;
	private String des_reg_nac;
	private Integer id_admin;
	private BigDecimal num_imp_tot_venta;
	private Double can_dia_transcurridos;
	private String fec_inicio;
	private String fec_final;
	private String nro_ser_comprobante;
	private BigDecimal imp_partida;
	private BigDecimal imp_saldo;
	private BigDecimal imp_devolucion;
	private Integer num_siaf;
	private String num_comprobante;
	private String fec_com_transferencia;
	private String ruc_nro_doc_prov;
	private String raz_soc_prov;
	private Integer cod_personal;
	private String num_ruc_personal;
	private String nom_personal;
	private String ape_pat_personal;
	private String ape_mat_personal;	
	private String ser_com_not_cre;
	private String nro_com_not_cre;
	private String fec_com_not_cre;
	private String tip_com_not_cre;
	private String ser_nro_comprobante;
	private String fec_vencimiento;
	private Integer cod_pad_com_ingresos;
	private String cod_adq_coa;
	private String tip_mon_coa;
	private String sig_moneda;
	private String tip_doc_proveedor;
	private String des_tip_documento;
	private String tip_orden;
	private String num_orden;
	private String fec_orden;
	private String ind_cp_reten;
	private Integer cod_mes;
	private Integer cod_anno;
	
	/**
	 * @return the tip_orden
	 */
	public String getTip_orden() {
		return tip_orden;
	}

	/**
	 * @param tip_orden the tip_orden to set
	 */
	public void setTip_orden(String tip_orden) {
		this.tip_orden = tip_orden;
	}

	/**
	 * @return the num_orden
	 */
	public String getNum_orden() {
		return num_orden;
	}

	/**
	 * @param num_orden the num_orden to set
	 */
	public void setNum_orden(String num_orden) {
		this.num_orden = num_orden;
	}

	/**
	 * @return the fec_orden
	 */
	public String getFec_orden() {
		return fec_orden;
	}

	/**
	 * @param fec_orden the fec_orden to set
	 */
	public void setFec_orden(String fec_orden) {
		this.fec_orden = fec_orden;
	}

	/**
	 * @return the ind_cp_reten
	 */
	public String getInd_cp_reten() {
		return ind_cp_reten;
	}

	/**
	 * @param ind_cp_reten the tip_cret to set
	 */
	public void setInd_cp_reten(String ind_cp_reten) {
		this.ind_cp_reten = ind_cp_reten;
	}

	/**
	 * 
	 */
	public ReporteDetalleComprasBean() {
		super();
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
	 * @return the cod_fue_financiamiento
	 */
	public Integer getCod_fue_financiamiento() {
		return cod_fue_financiamiento;
	}

	/**
	 * @param cod_fue_financiamiento the cod_fue_financiamiento to set
	 */
	public void setCod_fue_financiamiento(Integer cod_fue_financiamiento) {
		this.cod_fue_financiamiento = cod_fue_financiamiento;
	}

	/**
	 * @return the des_fue_financiamiento
	 */
	public String getDes_fue_financiamiento() {
		return des_fue_financiamiento;
	}

	/**
	 * @param des_fue_financiamiento the des_fue_financiamiento to set
	 */
	public void setDes_fue_financiamiento(String des_fue_financiamiento) {
		this.des_fue_financiamiento = des_fue_financiamiento;
	}

	/**
	 * @return the cod_med_pago
	 */
	public Integer getCod_med_pago() {
		return cod_med_pago;
	}

	/**
	 * @param cod_med_pago the cod_med_pago to set
	 */
	public void setCod_med_pago(Integer cod_med_pago) {
		this.cod_med_pago = cod_med_pago;
	}

	/**
	 * @return the des_med_pago
	 */
	public String getDes_med_pago() {
		return des_med_pago;
	}

	/**
	 * @param des_med_pago the des_med_pago to set
	 */
	public void setDes_med_pago(String des_med_pago) {
		this.des_med_pago = des_med_pago;
	}

	/**
	 * @return the cod_contrato
	 */
	public Integer getCod_contrato() {
		return cod_contrato;
	}

	/**
	 * @param cod_contrato the cod_contrato to set
	 */
	public void setCod_contrato(Integer cod_contrato) {
		this.cod_contrato = cod_contrato;
	}

	/**
	 * @return the num_contrato
	 */
	public String getNum_contrato() {
		return num_contrato;
	}

	/**
	 * @param num_contrato the num_contrato to set
	 */
	public void setNum_contrato(String num_contrato) {
		this.num_contrato = num_contrato;
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
	 * @return the nro_siaf
	 */
	public Integer getNro_siaf() {
		return nro_siaf;
	}

	/**
	 * @param nro_siaf the nro_siaf to set
	 */
	public void setNro_siaf(Integer nro_siaf) {
		this.nro_siaf = nro_siaf;
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
	 * @return the nro_cp
	 */
	public String getNro_cp() {
		return nro_cp;
	}

	/**
	 * @param nro_cp the nro_cp to set
	 */
	public void setNro_cp(String nro_cp) {
		this.nro_cp = nro_cp;
	}

	/**
	 * @return the nro_sia_operacion
	 */
	public Integer getNro_sia_operacion() {
		return nro_sia_operacion;
	}

	/**
	 * @param nro_sia_operacion the nro_sia_operacion to set
	 */
	public void setNro_sia_operacion(Integer nro_sia_operacion) {
		this.nro_sia_operacion = nro_sia_operacion;
	}

	/**
	 * @return the imp_cp
	 */
	public BigDecimal getImp_cp() {
		return imp_cp;
	}

	/**
	 * @param imp_cp the imp_cp to set
	 */
	public void setImp_cp(BigDecimal imp_cp) {
		this.imp_cp = imp_cp;
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
	 * @return the ind_ser_publico
	 */
	public String getInd_ser_publico() {
		return ind_ser_publico;
	}

	/**
	 * @param ind_ser_publico the ind_ser_publico to set
	 */
	public void setInd_ser_publico(String ind_ser_publico) {
		this.ind_ser_publico = ind_ser_publico;
	}

	/**
	 * @return the mon_ser_publico
	 */
	public BigDecimal getMon_ser_publico() {
		return mon_ser_publico;
	}

	/**
	 * @param mon_ser_publico the mon_ser_publico to set
	 */
	public void setMon_ser_publico(BigDecimal mon_ser_publico) {
		this.mon_ser_publico = mon_ser_publico;
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
	 * @return the num_constancia
	 */
	public String getNum_constancia() {
		return num_constancia;
	}

	/**
	 * @param num_constancia the num_constancia to set
	 */
	public void setNum_constancia(String num_constancia) {
		this.num_constancia = num_constancia;
	}

	/**
	 * @return the imp_deposito
	 */
	public BigDecimal getImp_deposito() {
		return imp_deposito;
	}

	/**
	 * @param imp_deposito the imp_deposito to set
	 */
	public void setImp_deposito(BigDecimal imp_deposito) {
		this.imp_deposito = imp_deposito;
	}

	/**
	 * @return the fec_pag_deposito
	 */
	public String getFec_pag_deposito() {
		return fec_pag_deposito;
	}

	/**
	 * @param fec_pag_deposito the fec_pag_deposito to set
	 */
	public void setFec_pag_deposito(String fec_pag_deposito) {
		this.fec_pag_deposito = fec_pag_deposito;
	}

	/**
	 * @return the por_deposito
	 */
	public Integer getPor_deposito() {
		return por_deposito;
	}

	/**
	 * @param por_deposito the por_deposito to set
	 */
	public void setPor_deposito(Integer por_deposito) {
		this.por_deposito = por_deposito;
	}

	/**
	 * @return the num_doc_empresa
	 */
	public String getNum_doc_empresa() {
		return num_doc_empresa;
	}

	/**
	 * @param num_doc_empresa the num_doc_empresa to set
	 */
	public void setNum_doc_empresa(String num_doc_empresa) {
		this.num_doc_empresa = num_doc_empresa;
	}

	/**
	 * @return the fec_doc_empresa
	 */
	public String getFec_doc_empresa() {
		return fec_doc_empresa;
	}

	/**
	 * @param fec_doc_empresa the fec_doc_empresa to set
	 */
	public void setFec_doc_empresa(String fec_doc_empresa) {
		this.fec_doc_empresa = fec_doc_empresa;
	}

	/**
	 * @return the num_doc_derivacion
	 */
	public String getNum_doc_derivacion() {
		return num_doc_derivacion;
	}

	/**
	 * @param num_doc_derivacion the num_doc_derivacion to set
	 */
	public void setNum_doc_derivacion(String num_doc_derivacion) {
		this.num_doc_derivacion = num_doc_derivacion;
	}

	/**
	 * @return the fec_doc_derivacion
	 */
	public String getFec_doc_derivacion() {
		return fec_doc_derivacion;
	}

	/**
	 * @param fec_doc_derivacion the fec_doc_derivacion to set
	 */
	public void setFec_doc_derivacion(String fec_doc_derivacion) {
		this.fec_doc_derivacion = fec_doc_derivacion;
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
	 * @return the id_admin
	 */
	public Integer getId_admin() {
		return id_admin;
	}

	/**
	 * @param id_admin the id_admin to set
	 */
	public void setId_admin(Integer id_admin) {
		this.id_admin = id_admin;
	}

	/**
	 * @return the num_imp_tot_venta
	 */
	public BigDecimal getNum_imp_tot_venta() {
		return num_imp_tot_venta;
	}

	/**
	 * @param num_imp_tot_venta the num_imp_tot_venta to set
	 */
	public void setNum_imp_tot_venta(BigDecimal num_imp_tot_venta) {
		this.num_imp_tot_venta = num_imp_tot_venta;
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
	 * @return the fec_inicio
	 */
	public String getFec_inicio() {
		return fec_inicio;
	}

	/**
	 * @param fec_inicio the fec_inicio to set
	 */
	public void setFec_inicio(String fec_inicio) {
		this.fec_inicio = fec_inicio;
	}

	/**
	 * @return the fec_final
	 */
	public String getFec_final() {
		return fec_final;
	}

	/**
	 * @param fec_final the fec_final to set
	 */
	public void setFec_final(String fec_final) {
		this.fec_final = fec_final;
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
	 * @return the nro_ser_comprobante
	 */
	public String getNro_ser_comprobante() {
		return nro_ser_comprobante;
	}

	/**
	 * @param nro_ser_comprobante the nro_ser_comprobante to set
	 */
	public void setNro_ser_comprobante(String nro_ser_comprobante) {
		this.nro_ser_comprobante = nro_ser_comprobante;
	}

	/**
	 * @return the imp_partida
	 */
	public BigDecimal getImp_partida() {
		return imp_partida;
	}

	/**
	 * @param imp_partida the imp_partida to set
	 */
	public void setImp_partida(BigDecimal imp_partida) {
		this.imp_partida = imp_partida;
	}

	/**
	 * @return the imp_saldo
	 */
	public BigDecimal getImp_saldo() {
		return imp_saldo;
	}

	/**
	 * @param imp_saldo the imp_saldo to set
	 */
	public void setImp_saldo(BigDecimal imp_saldo) {
		this.imp_saldo = imp_saldo;
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
	 * @return the imp_devolucion
	 */
	public BigDecimal getImp_devolucion() {
		return imp_devolucion;
	}

	/**
	 * @param imp_devolucion the imp_devolucion to set
	 */
	public void setImp_devolucion(BigDecimal imp_devolucion) {
		this.imp_devolucion = imp_devolucion;
	}

	/**
	 * @return the cod_personal
	 */
	public Integer getCod_personal() {
		return cod_personal;
	}

	/**
	 * @param cod_personal the cod_personal to set
	 */
	public void setCod_personal(Integer cod_personal) {
		this.cod_personal = cod_personal;
	}

	/**
	 * @return the num_ruc_personal
	 */
	public String getNum_ruc_personal() {
		return num_ruc_personal;
	}

	/**
	 * @param num_ruc_personal the num_ruc_personal to set
	 */
	public void setNum_ruc_personal(String num_ruc_personal) {
		this.num_ruc_personal = num_ruc_personal;
	}

	/**
	 * @return the nom_personal
	 */
	public String getNom_personal() {
		return nom_personal;
	}

	/**
	 * @param nom_personal the nom_personal to set
	 */
	public void setNom_personal(String nom_personal) {
		this.nom_personal = nom_personal;
	}

	/**
	 * @return the ape_pat_personal
	 */
	public String getApe_pat_personal() {
		return ape_pat_personal;
	}

	/**
	 * @param ape_pat_personal the ape_pat_personal to set
	 */
	public void setApe_pat_personal(String ape_pat_personal) {
		this.ape_pat_personal = ape_pat_personal;
	}

	/**
	 * @return the ape_mat_personal
	 */
	public String getApe_mat_personal() {
		return ape_mat_personal;
	}

	/**
	 * @param ape_mat_personal the ape_mat_personal to set
	 */
	public void setApe_mat_personal(String ape_mat_personal) {
		this.ape_mat_personal = ape_mat_personal;
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
	 * @return the imp_no_gra_igv
	 */
	public Double getImp_no_gra_igv() {
		return imp_no_gra_igv;
	}

	/**
	 * @param imp_no_gra_igv the imp_no_gra_igv to set
	 */
	public void setImp_no_gra_igv(Double imp_no_gra_igv) {
		this.imp_no_gra_igv = imp_no_gra_igv;
	}

	/**
	 * @return the imp_gra_total
	 */
	public Double getImp_gra_total() {
		return imp_gra_total;
	}

	/**
	 * @param imp_gra_total the imp_gra_total to set
	 */
	public void setImp_gra_total(Double imp_gra_total) {
		this.imp_gra_total = imp_gra_total;
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
	 * @return the cod_adq_coa
	 */
	public String getCod_adq_coa() {
		return cod_adq_coa;
	}

	/**
	 * @param cod_adq_coa the cod_adq_coa to set
	 */
	public void setCod_adq_coa(String cod_adq_coa) {
		this.cod_adq_coa = cod_adq_coa;
	}

	/**
	 * @return the tip_mon_coa
	 */
	public String getTip_mon_coa() {
		return tip_mon_coa;
	}

	/**
	 * @param tip_mon_coa the tip_mon_coa to set
	 */
	public void setTip_mon_coa(String tip_mon_coa) {
		this.tip_mon_coa = tip_mon_coa;
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
	 * @return the des_tip_documento
	 */
	public String getDes_tip_documento() {
		return des_tip_documento;
	}

	/**
	 * @param des_tip_documento the des_tip_documento to set
	 */
	public void setDes_tip_documento(String des_tip_documento) {
		this.des_tip_documento = des_tip_documento;
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
