package pe.com.mig.model.bean;

import java.math.BigDecimal;

/**
 * @className: DetalleVoucherBean.java
 * @description: 
 * @date: 12 de ago. de 2016
 * @author: SUMERIO.
 */
public class DetalleVoucherBean extends MBaseBean {

	private static final long serialVersionUID = 1L;
	private Integer cod_voucher;
	private Integer cod_com_ingresos;
	private String num_voucher;
	private String fec_voucher;
	private BigDecimal imp_voucher;
	private String img_voucher;
	private String fec_inicio;
	private String fec_final;
	private Integer cod_mes;
	
	
	/**
	 * 
	 */
	public DetalleVoucherBean() {
		super();
	}
	
	/**
	 * @param cod_com_ingresos
	 */
	public DetalleVoucherBean(Integer cod_com_ingresos) {
		super();
		this.cod_com_ingresos = cod_com_ingresos;
	}
	
	/**
	 * @return the cod_voucher
	 */
	public Integer getCod_voucher() {
		return cod_voucher;
	}
	/**
	 * @param cod_voucher the cod_voucher to set
	 */
	public void setCod_voucher(Integer cod_voucher) {
		this.cod_voucher = cod_voucher;
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
	 * @return the imp_voucher
	 */
	public BigDecimal getImp_voucher() {
		return imp_voucher;
	}
	/**
	 * @param imp_voucher the imp_voucher to set
	 */
	public void setImp_voucher(BigDecimal imp_voucher) {
		this.imp_voucher = imp_voucher;
	}
	/**
	 * @return the img_voucher
	 */
	public String getImg_voucher() {
		return img_voucher;
	}
	/**
	 * @param img_voucher the img_voucher to set
	 */
	public void setImg_voucher(String img_voucher) {
		this.img_voucher = img_voucher;
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
	
}
