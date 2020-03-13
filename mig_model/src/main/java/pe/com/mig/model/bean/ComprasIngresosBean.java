package pe.com.mig.model.bean;

import java.math.BigDecimal;

/**
 * @className: ComprasIngresosBean.java
 * @description: 
 * @date: 14 de jun. de 2016
 * @author: SUMERIO.
 */
public class ComprasIngresosBean extends MBaseBean {
	
	private static final long serialVersionUID = 1L;
	private Integer cod_com_ingresos;
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
	private String nro_doc_operacion;
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
	private Integer cod_sucur;
	private String des_sucur;	
	private String fec_desde;
	private String fec_hasta;
	private Integer int_id_registro;
	private Integer id_admin;
	private BigDecimal num_imp_tot_venta;
	private Double can_dia_transcurridos;
	private String fec_inicio;
	private String fec_final;
	private BigDecimal num_imp_contrato;
	private Integer num_imp_interes;
	private Integer cod_pad_com_ingresos;	
	private String num_voucher;
	private String fec_voucher;
	private BigDecimal num_imp_voucher;	
	private String mnt_fec_creacion;	
	private String mnt_usu_creacion;
	private String mnt_fec_modificacion;
	private String mnt_usu_modificacion;
	private String tip_transaccion;
	private Integer cod_servicio;
	private Integer ind_pro_varios;
	private String num_documento;
	private String ruc_nro_doc_prov;
	private String raz_soc_prov;
	private String tip_com_siglas;
	private Integer cod_mes;
	private Integer cod_personal;
	private String num_ruc_personal;
	private String nom_personal;
	private String ape_pat_personal;
	private String ape_mat_personal;
	private String num_cta_cte;
	private String num_cp_giro;
	private int ind_not_credito;
	private String ind_retencion;
	private String fec_nacimiento;
	private String tip_sexo;
	private String ind_es_salud;
	private String nro_ruc;
	private int ind_gen_archivo;
	private int ind_cua_categoria;
	private String ind_tip_orden;
	private String fec_orden;
	private String num_orden;
	private String ind_cp_reten;
	private String ind_med_pago;
	private String des_glosa;
	private Integer cod_ctacte;
	private String estado;
	private String fec_pago_cp;
	private String ind_tip_fact;
	private Integer cod_anno;
	private Integer cod_serie;
	private Integer cod_dir_fact;
	private String nom_dir_fact;
	

	/**
	 * 
	 */
	public ComprasIngresosBean() {
		super();
	}
	
	/**
	 * @param cod_com_ingresos
	 */
	public ComprasIngresosBean(Integer cod_com_ingresos) {
		super();
		this.cod_com_ingresos = cod_com_ingresos;
	}

	
	
	public ComprasIngresosBean(Integer cod_com_ingresos, Integer cod_serie) {
		super();
		this.cod_com_ingresos = cod_com_ingresos;
		this.cod_serie = cod_serie;
	}

	/**
	 * @return the cod_serie
	 */
	public Integer getCod_serie() {
		return cod_serie;
	}

	/**
	 * @param cod_serie the cod_serie to set
	 */
	public void setCod_serie(Integer cod_serie) {
		this.cod_serie = cod_serie;
	}

	/**
	 * @return the cod_anno
	 */
	public Integer getCod_anno() {
		return cod_anno;
	}

	/**
	 * @param cod_anno the cod_anno to set
	 */
	public void setCod_anno(Integer cod_anno) {
		this.cod_anno = cod_anno;
	}

	/**
	 * @return the ind_tip_fact
	 */
	public String getInd_tip_fact() {
		return ind_tip_fact;
	}

	/**
	 * @param ind_tip_fact the ind_tip_fact to set
	 */
	public void setInd_tip_fact(String ind_tip_fact) {
		this.ind_tip_fact = ind_tip_fact;
	}

	/**
	 * @return the fec_pago_cp
	*/ 
	public String getFec_pago_cp() {
		return fec_pago_cp;
	}

	/**
	 * @param fec_pago_cp the fec_pago_cp to set
	*/ 
	public void setFec_pago_cp(String fec_pago_cp) {
		this.fec_pago_cp = fec_pago_cp;
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
	 * @return the num_imp_contrato
	 */
	public BigDecimal getNum_imp_contrato() {
		return num_imp_contrato;
	}

	/**
	 * @param num_imp_contrato the num_imp_contrato to set
	 */
	public void setNum_imp_contrato(BigDecimal num_imp_contrato) {
		this.num_imp_contrato = num_imp_contrato;
	}

	/**
	 * @return the num_imp_interes
	 */
	public Integer getNum_imp_interes() {
		return num_imp_interes;
	}

	/**
	 * @param num_imp_interes the num_imp_interes to set
	 */
	public void setNum_imp_interes(Integer num_imp_interes) {
		this.num_imp_interes = num_imp_interes;
	}


	
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
	 * @return the int_transaccion
	 */
	public Integer getInt_transaccion() {
		return int_transaccion;
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
	 * @return the nro_doc_operacion
	 */
	public String getNro_doc_operacion() {
		return nro_doc_operacion;
	}
	/**
	 * @param nro_doc_operacion the nro_doc_operacion to set
	 */
	public void setNro_doc_operacion(String nro_doc_operacion) {
		this.nro_doc_operacion = nro_doc_operacion;
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
	 * @return the cod_sucur
	 */
	public Integer getCod_sucur() {
		return cod_sucur;
	}
	/**
	 * @param cod_sucur the cod_sucur to set
	 */
	public void setCod_sucur(Integer cod_sucur) {
		this.cod_sucur = cod_sucur;
	}
	/**
	 * @return the des_sucur
	 */
	public String getDes_sucur() {
		return des_sucur;
	}
	/**
	 * @param des_reg_nac the des_reg_nac to set
	 */
	public void setDes_sucur(String des_sucur) {
		this.des_sucur = des_sucur;
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
	 * @return the ind_pro_varios
	 */
	public Integer getInd_pro_varios() {
		return ind_pro_varios;
	}
	/**
	 * @param ind_pro_varios the ind_pro_varios to set
	 */
	public void setInd_pro_varios(Integer ind_pro_varios) {
		this.ind_pro_varios = ind_pro_varios;
	}
	/**
	 * @return the num_documento
	 */
	public String getNum_documento() {
		return num_documento;
	}
	/**
	 * @param num_documento the num_documento to set
	 */
	public void setNum_documento(String num_documento) {
		this.num_documento = num_documento;
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
	 * @return the cod_mes
	 */
	public Integer getCod_mes() {
		return cod_mes;
	}

	/**
	 * @param cod_mes the cod_mes to set
	 */
	public void setCod_mes(Integer cod_mes) {
		this.cod_mes = cod_mes;
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
	 * @return the num_cp_giro
	 */
	public String getNum_cp_giro() {
		return num_cp_giro;
	}

	/**
	 * @param num_cp_giro the num_cp_giro to set
	 */
	public void setNum_cp_giro(String num_cp_giro) {
		this.num_cp_giro = num_cp_giro;
	}	
	
	/**
	 * @return the ind_tip_orden
	 */
	public String getInd_tip_orden() {
		return ind_tip_orden;
	}
	/**
	 * @param ind_tip_orden the ind_tip_orden to set
	 */
	public void setInd_tip_orden(String ind_tip_orden) {
		this.ind_tip_orden = ind_tip_orden;
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
	public void setFec_orden(String fec_voucher) {
		this.fec_orden = fec_voucher;
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
	 * @return the ind_cp_reten
	 */
	public String getInd_cp_reten() {
		return ind_cp_reten;
	}
	/**
	 * @param ind_tip_orden the ind_tip_orden to set
	 */
	public void setInd_cp_reten(String ind_cp_reten) {
		this.ind_cp_reten = ind_cp_reten;
	}
	
	/**
	 * @return the ind_cp_reten
	 */
	public String getInd_med_pago() {
		return ind_med_pago;
	}
	/**
	 * @param ind_tip_orden the ind_tip_orden to set
	 */
	public void setInd_med_pago(String ind_med_pago) {
		this.ind_med_pago = ind_med_pago;
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
	 * @return the fec_nacimiento
	 */
	public String getFec_nacimiento() {
		return fec_nacimiento;
	}

	/**
	 * @param fec_nacimiento the fec_nacimiento to set
	 */
	public void setFec_nacimiento(String fec_nacimiento) {
		this.fec_nacimiento = fec_nacimiento;
	}

	/**
	 * @return the tip_sexo
	 */
	public String getTip_sexo() {
		return tip_sexo;
	}

	/**
	 * @param tip_sexo the tip_sexo to set
	 */
	public void setTip_sexo(String tip_sexo) {
		this.tip_sexo = tip_sexo;
	}

	/**
	 * @return the ind_es_salud
	 */
	public String getInd_es_salud() {
		return ind_es_salud;
	}

	/**
	 * @param ind_es_salud the ind_es_salud to set
	 */
	public void setInd_es_salud(String ind_es_salud) {
		this.ind_es_salud = ind_es_salud;
	}

	/**
	 * @return the nro_ruc
	 */
	public String getNro_ruc() {
		return nro_ruc;
	}

	/**
	 * @param nro_ruc the nro_ruc to set
	 */
	public void setNro_ruc(String nro_ruc) {
		this.nro_ruc = nro_ruc;
	}

	/**
	 * @return the ind_gen_archivo
	 */
	public int getInd_gen_archivo() {
		return ind_gen_archivo;
	}

	/**
	 * @param ind_gen_archivo the ind_gen_archivo to set
	 */
	public void setInd_gen_archivo(int ind_gen_archivo) {
		this.ind_gen_archivo = ind_gen_archivo;
	}

	/**
	 * @return the ind_cua_categoria
	 */
	public int getInd_cua_categoria() {
		return ind_cua_categoria;
	}

	/**
	 * @param ind_cua_categoria the ind_cua_categoria to set
	 */
	public void setInd_cua_categoria(int ind_cua_categoria) {
		this.ind_cua_categoria = ind_cua_categoria;
	}

	/**
	 * @return the des_glosa
	 */
	public String getDes_glosa() {
		return des_glosa;
	}

	/**
	 * @param des_glosa the des_glosa to set
	 */
	public void setDes_glosa(String des_glosa) {
		this.des_glosa = des_glosa;
	}
	
	/**
	 * @return the cod_ctacte
	 */
	public Integer getCod_ctacte() {
		return cod_ctacte;
	}

	/**
	 * @param cod_ctacte the cod_ctacte to set
	 */
	public void setCod_ctacte(Integer cod_ctacte) {
		this.cod_ctacte = cod_ctacte;
	}

	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Integer getCod_dir_fact() {
		return cod_dir_fact;
	}

	public void setCod_dir_fact(Integer cod_dir_fact) {
		this.cod_dir_fact = cod_dir_fact;
	}

	public String getNom_dir_fact() {
		return nom_dir_fact;
	}

	public void setNom_dir_fact(String nom_dir_fact) {
		this.nom_dir_fact = nom_dir_fact;
	}
	
	
}
