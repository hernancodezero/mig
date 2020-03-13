package pe.com.mig.model.bean;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @className: DetalleContratosBean.java
 * @description: 
 * @date: 
 * @author: 
 */
public class DetalleContratosBean extends MBaseBean {

	private static final long serialVersionUID = 1L;
	private Integer cod_contrato;	
	private Integer cod_detalle;
	private Integer mes;
	private BigDecimal monto_mes;
	private String fec_pago;
	private Integer chrNumCompPago; 
	private String dteFecCompPago;
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
	 * @return the cod_detalle
	 */
	public Integer getCod_detalle() {
		return cod_detalle;
	}
	/**
	 * @param cod_detalle the cod_detalle to set
	 */
	public void setCod_detalle(Integer cod_detalle) {
		this.cod_detalle = cod_detalle;
	}
	/**
	 * @return the mes
	 */
	public Integer getMes() {
		return mes;
	}
	/**
	 * @param mes the mes to set
	 */
	public void setMes(Integer mes) {
		this.mes = mes;
	}
	/**
	 * @return the monto_mes
	 */
	public BigDecimal getMonto_mes() {
		return monto_mes;
	}
	/**
	 * @param monto_mes the monto_mes to set
	 */
	public void setMonto_mes(BigDecimal monto_mes) {
		this.monto_mes = monto_mes;
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
	 * @return the chrNumCompPago
	 */
	public Integer getChrNumCompPago() {
		return chrNumCompPago;
	}
	/**
	 * @param chrNumCompPago the chrNumCompPago to set
	 */
	public void setChrNumCompPago(Integer chrNumCompPago) {
		this.chrNumCompPago = chrNumCompPago;
	}
	/**
	 * @return the dteFecCompPago
	 */
	public String getDteFecCompPago() {
		return dteFecCompPago;
	}
	/**
	 * @param dteFecCompPago the dteFecCompPago to set
	 */
	public void setDteFecCompPago(String dteFecCompPago) {
		this.dteFecCompPago = dteFecCompPago;
	}
	
	
	
}
