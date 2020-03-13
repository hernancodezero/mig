package pe.com.mig.model.bean;

import java.math.BigDecimal;

/**
 * @className: TransferenciaBean.java
 * @description: 
 * @date: 12 de jun. de 2016
 * @author: SUMERIO.
 */
public class DetalleTransferenciaBean extends MBaseBean {

	private static final long serialVersionUID = 1L;
	private Integer cod_transferencia;
	private Integer cod_det_transferencia;
	private Long cod_especifica;
	private String cod_meta;
	private String vcod_especifica;
	private String des_especifica;
	private BigDecimal imp_partida;
	private Integer int_id_registro;
	private int ind_saldo;
	private BigDecimal imp_saldo;
	private int ind_not_credito;
	
	
	/**
	 * 
	 */
	public DetalleTransferenciaBean() {
		super();
	}

	/**
	 * @param cod_transferencia
	 */
	public DetalleTransferenciaBean(Integer cod_transferencia) {
		super();
		this.cod_transferencia = cod_transferencia;
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
	 * @return the cod_det_transferencia
	 */
	public Integer getCod_det_transferencia() {
		return cod_det_transferencia;
	}
	/**
	 * @param cod_det_transferencia the cod_det_transferencia to set
	 */
	public void setCod_det_transferencia(Integer cod_det_transferencia) {
		this.cod_det_transferencia = cod_det_transferencia;
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
	 * @return the ind_saldo
	 */
	public int getInd_saldo() {
		return ind_saldo;
	}

	/**
	 * @param ind_saldo the ind_saldo to set
	 */
	public void setInd_saldo(int ind_saldo) {
		this.ind_saldo = ind_saldo;
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
	
}
