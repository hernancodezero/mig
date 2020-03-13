package pe.com.mig.model.bean;

import java.math.BigDecimal;

/**
 * @className: CierreMesBean.java
 * @description: 
 * @date: 16 de jun. de 2016
 * @author: SUMERIO.
 */
public class CuartaCategoriaBean extends MBaseBean {

	private static final long serialVersionUID = 1L;
	private int cod_retenciones;
	private int cod_personalCuarta;
	private int cod_tipoComprobante;
	private String chrNomComprobante;
	private String chrNumSerie;
	private String chrNumComprobante;
	private String numRuc;
	private String dteFecDocumento;
	private String dteFecDocumentoInicial;
	private String dteFecDocumentoFinal;
	private String dteFecPago;
	private String chrFlgRetencion;
	private String chrNumRetencion;
	private BigDecimal numImpSubtotal;
	private BigDecimal numImpRetenido;
	private BigDecimal numImpTotal;
	private Integer intIdfRegistro;
	private Integer cod_uni_operativa;
	private String des_uni_operativa;
	private Integer cod_reg_nac;
	private String des_reg_nac;
	private String mnt_fec_creacion;	
	private String mnt_usu_creacion;
	private String mnt_fec_modificacion;
	private String mnt_usu_modificacion;
	private String nombres;
	private String ape_paterno;
	private String ape_materno;
	private String chrIndRetencion;
	private String chrTipOperacion;
	private Integer intCodPadComRecibo;
	private String chrNotadeCredito;
	private Integer sedecentral;
	
	 
	/**
	 * @return the chrTipOperacion
	 */
	public String getChrTipOperacion() {
		return chrTipOperacion;
	}
	/**
	 * @param chrTipOperacion the chrTipOperacion to set
	 */
	public void setChrTipOperacion(String chrTipOperacion) {
		this.chrTipOperacion = chrTipOperacion;
	}
	/**
	 * @return the intCodPadComRecibo
	 */
	public Integer getIntCodPadComRecibo() {
		return intCodPadComRecibo;
	}
	/**
	 * @param intCodPadComRecibo the intCodPadComRecibo to set
	 */
	public void setIntCodPadComRecibo(Integer intCodPadComRecibo) {
		this.intCodPadComRecibo = intCodPadComRecibo;
	}
	/**
	 * @return the chrIndRetencion
	 */
	public String getChrIndRetencion() {
		return chrIndRetencion;
	}
	/**
	 * @param chrIndRetencion the chrIndRetencion to set
	 */
	public void setChrIndRetencion(String chrIndRetencion) {
		this.chrIndRetencion = chrIndRetencion;
	}
	/**
	 * @return the cod_retenciones
	 */
	public int getCod_retenciones() {
		return cod_retenciones;
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
	 * @param cod_retenciones the cod_retenciones to set
	 */
	public void setCod_retenciones(int cod_retenciones) {
		this.cod_retenciones = cod_retenciones;
	}
	/**
	 * @return the cod_personalCuarta
	 */
	public int getCod_personalCuarta() {
		return cod_personalCuarta;
	}
	/**
	 * @param cod_personalCuarta the cod_personalCuarta to set
	 */
	public void setCod_personalCuarta(int cod_personalCuarta) {
		this.cod_personalCuarta = cod_personalCuarta;
	}
	/**
	 * @return the cod_tipoComprobante
	 */
	public int getCod_tipoComprobante() {
		return cod_tipoComprobante;
	}
	/**
	 * @param cod_tipoComprobante the cod_tipoComprobante to set
	 */
	public void setCod_tipoComprobante(int cod_tipoComprobante) {
		this.cod_tipoComprobante = cod_tipoComprobante;
	}
	/**
	 * @return the chrNumSerie
	 */
	public String getChrNumSerie() {
		return chrNumSerie;
	}
	/**
	 * @param chrNumSerie the chrNumSerie to set
	 */
	public void setChrNumSerie(String chrNumSerie) {
		this.chrNumSerie = chrNumSerie;
	}
	/**
	 * @return the chrNumComprobante
	 */
	public String getChrNumComprobante() {
		return chrNumComprobante;
	}
	/**
	 * @param chrNumComprobante the chrNumComprobante to set
	 */
	public void setChrNumComprobante(String chrNumComprobante) {
		this.chrNumComprobante = chrNumComprobante;
	}
	 
	/**
	 * @return the chrFlgRetencion
	 */
	public String getChrFlgRetencion() {
		return chrFlgRetencion;
	}
	/**
	 * @param chrFlgRetencion the chrFlgRetencion to set
	 */
	public void setChrFlgRetencion(String chrFlgRetencion) {
		this.chrFlgRetencion = chrFlgRetencion;
	}
	/**
	 * @return the chrNumRetencion
	 */
	public String getChrNumRetencion() {
		return chrNumRetencion;
	}
	/**
	 * @param chrNumRetencion the chrNumRetencion to set
	 */
	public void setChrNumRetencion(String chrNumRetencion) {
		this.chrNumRetencion = chrNumRetencion;
	}
	/**
	 * @return the numImpSubtotal
	 */
	public BigDecimal getNumImpSubtotal() {
		return numImpSubtotal;
	}
	/**
	 * @param numImpSubtotal the numImpSubtotal to set
	 */
	public void setNumImpSubtotal(BigDecimal numImpSubtotal) {
		this.numImpSubtotal = numImpSubtotal;
	}
	/**
	 * @return the numImpRetenido
	 */
	public BigDecimal getNumImpRetenido() {
		return numImpRetenido;
	}
	/**
	 * @param numImpRetenido the numImpRetenido to set
	 */
	public void setNumImpRetenido(BigDecimal numImpRetenido) {
		this.numImpRetenido = numImpRetenido;
	}
	/**
	 * @return the numImpTotal
	 */
	public BigDecimal getNumImpTotal() {
		return numImpTotal;
	}
	/**
	 * @param numImpTotal the numImpTotal to set
	 */
	public void setNumImpTotal(BigDecimal numImpTotal) {
		this.numImpTotal = numImpTotal;
	}
	/**
	 * @return the intIdfRegistro
	 */
	public Integer getIntIdfRegistro() {
		return intIdfRegistro;
	}
	/**
	 * @param intIdfRegistro the intIdfRegistro to set
	 */
	public void setIntIdfRegistro(Integer intIdfRegistro) {
		this.intIdfRegistro = intIdfRegistro;
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
	 * @return the dteFecDocumentoInicial
	 */
	public String getDteFecDocumentoInicial() {
		return dteFecDocumentoInicial;
	}
	/**
	 * @param dteFecDocumentoInicial the dteFecDocumentoInicial to set
	 */
	public void setDteFecDocumentoInicial(String dteFecDocumentoInicial) {
		this.dteFecDocumentoInicial = dteFecDocumentoInicial;
	}
	/**
	 * @return the dteFecDocumentoFinal
	 */
	public String getDteFecDocumentoFinal() {
		return dteFecDocumentoFinal;
	}
	/**
	 * @param dteFecDocumentoFinal the dteFecDocumentoFinal to set
	 */
	public void setDteFecDocumentoFinal(String dteFecDocumentoFinal) {
		this.dteFecDocumentoFinal = dteFecDocumentoFinal;
	}
	/**
	 * @return the chrNotadeCredito
	 */
	public String getChrNotadeCredito() {
		return chrNotadeCredito;
	}
	/**
	 * @param chrNotadeCredito the chrNotadeCredito to set
	 */
	public void setChrNotadeCredito(String chrNotadeCredito) {
		this.chrNotadeCredito = chrNotadeCredito;
	}
	/**
	 * @return the sedecentral
	 */
	public Integer getSedecentral() {
		return sedecentral;
	}
	/**
	 * @param sedecentral the sedecentral to set
	 */
	public void setSedecentral(Integer sedecentral) {
		this.sedecentral = sedecentral;
	}
	/**
	 * @return the chrNomComprobante
	 */
	public String getChrNomComprobante() {
		return chrNomComprobante;
	}
	/**
	 * @param chrNomComprobante the chrNomComprobante to set
	 */
	public void setChrNomComprobante(String chrNomComprobante) {
		this.chrNomComprobante = chrNomComprobante;
	}
	/**
	 * @return the numRuc
	 */
	public String getNumRuc() {
		return numRuc;
	}
	/**
	 * @param numRuc the numRuc to set
	 */
	public void setNumRuc(String numRuc) {
		this.numRuc = numRuc;
	}
	/**
	 * @return the dteFecDocumento
	 */
	public String getDteFecDocumento() {
		return dteFecDocumento;
	}
	/**
	 * @param dteFecDocumento the dteFecDocumento to set
	 */
	public void setDteFecDocumento(String dteFecDocumento) {
		this.dteFecDocumento = dteFecDocumento;
	}
	/**
	 * @return the dteFecPago
	 */
	public String getDteFecPago() {
		return dteFecPago;
	}
	/**
	 * @param dteFecPago the dteFecPago to set
	 */
	public void setDteFecPago(String dteFecPago) {
		this.dteFecPago = dteFecPago;
	}
}
