package pe.com.mig.model.bean;

import java.math.BigDecimal;

/**
 * @className: EntidadFinancieraBean.java
 * @description: 
 * @date: 16 de jun. de 2016
 * @author: SUMERIO.
 */
public class FiltrosCartaFianzaBean extends MBaseBean {
	
	private static final long serialVersionUID = 1L;
	private int srlIdFianza;
	private int TEntidadFinanciera;
	private String nom_entidad;
	private int TTipoProveedor;
	private String chrNumCarta;
	private String dteFecInicio;
	private String dteFecFinal;
	private String dteFecDevolucion;
	private String chrConcepto;
	private BigDecimal intImpCarta;
	private String chrCodDocumento;
	private String chrNumDocumento;
	private String dteFecEnvio;
	private String chrSigOficina;
	private Integer intIdfRegistro;
	private String chrCodUsuaCreacion;
	private String dteFecCreacion;
	private String chrCodUsuaModifica;
	private String dteFecModifica;
	private Integer cod_uni_operativa;
	private String des_uni_operativa;
	private Integer cod_reg_nac;
	private String des_reg_nac;
	private Double can_dia_transcurridos;
	private String dteFecCarta;
	private String dteFecDocumento;
	private String Razonsocial;
	private long numRuc;
	private String dteFecRecepcion;
	private String chrTipOperacion;
	
	/**
	 * @return the dteFecInicio
	 */
	public String getDteFecInicio() {
		return dteFecInicio;
	}
	/**
	 * @param dteFecInicio the dteFecInicio to set
	 */
	public void setDteFecInicio(String dteFecInicio) {
		this.dteFecInicio = dteFecInicio;
	}
	/**
	 * @return the dteFecFinal
	 */
	public String getDteFecFinal() {
		return dteFecFinal;
	}
	/**
	 * @param dteFecFinal the dteFecFinal to set
	 */
	public void setDteFecFinal(String dteFecFinal) {
		this.dteFecFinal = dteFecFinal;
	}
	/**
	 * @return the dteFecDevolucion
	 */
	public String getDteFecDevolucion() {
		return dteFecDevolucion;
	}
	/**
	 * @param dteFecDevolucion the dteFecDevolucion to set
	 */
	public void setDteFecDevolucion(String dteFecDevolucion) {
		this.dteFecDevolucion = dteFecDevolucion;
	}
	/**
	 * @return the chrConcepto
	 */
	public String getChrConcepto() {
		return chrConcepto;
	}
	/**
	 * @param chrConcepto the chrConcepto to set
	 */
	public void setChrConcepto(String chrConcepto) {
		this.chrConcepto = chrConcepto;
	}
	/**
	 * @return the intImpCarta
	 */
	public BigDecimal getIntImpCarta() {
		return intImpCarta;
	}
	/**
	 * @param intImpCarta the intImpCarta to set
	 */
	public void setIntImpCarta(BigDecimal intImpCarta) {
		this.intImpCarta = intImpCarta;
	}
	/**
	 * @return the chrCodDocumento
	 */
	public String getChrCodDocumento() {
		return chrCodDocumento;
	}
	/**
	 * @param chrCodDocumento the chrCodDocumento to set
	 */
	public void setChrCodDocumento(String chrCodDocumento) {
		this.chrCodDocumento = chrCodDocumento;
	}
	/**
	 * @return the dteFecEnvio
	 */
	public String getDteFecEnvio() {
		return dteFecEnvio;
	}
	/**
	 * @param dteFecEnvio the dteFecEnvio to set
	 */
	public void setDteFecEnvio(String dteFecEnvio) {
		this.dteFecEnvio = dteFecEnvio;
	}
	/**
	 * @return the chrSigOficina
	 */
	public String getChrSigOficina() {
		return chrSigOficina;
	}
	/**
	 * @param chrSigOficina the chrSigOficina to set
	 */
	public void setChrSigOficina(String chrSigOficina) {
		this.chrSigOficina = chrSigOficina;
	}
	/**
	 * @return the srlIdFianza
	 */
	public int getSrlIdFianza() {
		return srlIdFianza;
	}
	/**
	 * @param srlIdFianza the srlIdFianza to set
	 */
	public void setSrlIdFianza(int srlIdFianza) {
		this.srlIdFianza = srlIdFianza;
	}
	/**
	 * @return the tEntidadFinanciera
	 */
	public int getTEntidadFinanciera() {
		return TEntidadFinanciera;
	}
	/**
	 * @param tEntidadFinanciera the tEntidadFinanciera to set
	 */
	public void setTEntidadFinanciera(int tEntidadFinanciera) {
		TEntidadFinanciera = tEntidadFinanciera;
	}
	/**
	 * @return the tTipoProveedor
	 */
	public int getTTipoProveedor() {
		return TTipoProveedor;
	}
	/**
	 * @param tTipoProveedor the tTipoProveedor to set
	 */
	public void setTTipoProveedor(int tTipoProveedor) {
		TTipoProveedor = tTipoProveedor;
	}
	/**
	 * @return the chrNumCarta
	 */
	public String getChrNumCarta() {
		return chrNumCarta;
	}
	/**
	 * @param chrNumCarta the chrNumCarta to set
	 */
	public void setChrNumCarta(String chrNumCarta) {
		this.chrNumCarta = chrNumCarta;
	}
	
	 
	/**
	 * @return the chrNumDocumento
	 */
	public String getChrNumDocumento() {
		return chrNumDocumento;
	}
	/**
	 * @param chrNumDocumento the chrNumDocumento to set
	 */
	public void setChrNumDocumento(String chrNumDocumento) {
		this.chrNumDocumento = chrNumDocumento;
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
	 * @return the chrCodUsuaCreacion
	 */
	public String getChrCodUsuaCreacion() {
		return chrCodUsuaCreacion;
	}
	/**
	 * @param chrCodUsuaCreacion the chrCodUsuaCreacion to set
	 */
	public void setChrCodUsuaCreacion(String chrCodUsuaCreacion) {
		this.chrCodUsuaCreacion = chrCodUsuaCreacion;
	}
	/**
	 * @return the dteFecCreacion
	 */
	public String getDteFecCreacion() {
		return dteFecCreacion;
	}
	/**
	 * @param dteFecCreacion the dteFecCreacion to set
	 */
	public void setDteFecCreacion(String dteFecCreacion) {
		this.dteFecCreacion = dteFecCreacion;
	}
	/**
	 * @return the chrCodUsuaModifica
	 */
	public String getChrCodUsuaModifica() {
		return chrCodUsuaModifica;
	}
	/**
	 * @param chrCodUsuaModifica the chrCodUsuaModifica to set
	 */
	public void setChrCodUsuaModifica(String chrCodUsuaModifica) {
		this.chrCodUsuaModifica = chrCodUsuaModifica;
	}
	/**
	 * @return the dteFecModifica
	 */
	public String getDteFecModifica() {
		return dteFecModifica;
	}
	/**
	 * @param dteFecModifica the dteFecModifica to set
	 */
	public void setDteFecModifica(String dteFecModifica) {
		this.dteFecModifica = dteFecModifica;
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
	 * @return the nom_entidad
	 */
	public String getNom_entidad() {
		return nom_entidad;
	}
	/**
	 * @param nom_entidad the nom_entidad to set
	 */
	public void setNom_entidad(String nom_entidad) {
		this.nom_entidad = nom_entidad;
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
	 * @return the dteFecCarta
	 */
	public String getDteFecCarta() {
		return dteFecCarta;
	}
	/**
	 * @param dteFecCarta the dteFecCarta to set
	 */
	public void setDteFecCarta(String dteFecCarta) {
		this.dteFecCarta = dteFecCarta;
	}
	/**
	 * @return the dteFecRecepcion
	 */
	public String getDteFecRecepcion() {
		return dteFecRecepcion;
	}
	/**
	 * @param dteFecRecepcion the dteFecRecepcion to set
	 */
	public void setDteFecRecepcion(String dteFecRecepcion) {
		this.dteFecRecepcion = dteFecRecepcion;
	}
	/**
	 * @return the razonsocial
	 */
	public String getRazonsocial() {
		return Razonsocial;
	}
	/**
	 * @param razonsocial the razonsocial to set
	 */
	public void setRazonsocial(String razonsocial) {
		Razonsocial = razonsocial;
	}
	/**
	 * @return the numRuc
	 */
	public long getNumRuc() {
		return numRuc;
	}
	/**
	 * @param numRuc the numRuc to set
	 */
	public void setNumRuc(long numRuc) {
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
	 
	
}
