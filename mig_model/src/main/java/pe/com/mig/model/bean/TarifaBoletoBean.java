package pe.com.mig.model.bean;

import java.math.BigDecimal;

/**
 * @className: TarifaBoletoBean.java
 * @description: 
 * @date: 2 de jul. de 2016
 * @author: SUMERIO.
 */
public class TarifaBoletoBean extends MBaseBean {

	private static final long serialVersionUID = 1L;
	private Integer cod_boleto;
	private Integer cod_uni_operativa;
	private String des_uni_operativa;
	private Integer cod_reg_nac;
	private String des_reg_nac;
	private String nom_boleto;
	private String vcod_boleto;
	private Integer ind_tarifa;
	private String des_ind_tarifa;
	private BigDecimal num_imp_unit;
	private String num_serie;
	private Integer can_ingreso;
	private Integer can_salida;
	private Integer can_stock;
	private Integer num_inicio;
	private Integer num_final;
	private String fla_activo;
	private String cod_partida;
	private String cod_cuenta;
	private String mnt_fec_creacion;	
	private String mnt_usu_creacion;
	private String mnt_fec_modificacion;
	private String mnt_usu_modificacion;
	private int ind_saldo;
	private Long can_sal_stock;
	private String chrNomCuenta;
	
	
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
	 * @return the nom_boleto
	 */
	public String getNom_boleto() {
		return nom_boleto;
	}
	/**
	 * @param nom_boleto the nom_boleto to set
	 */
	public void setNom_boleto(String nom_boleto) {
		this.nom_boleto = nom_boleto;
	}
	/**
	 * @return the vcod_boleto
	 */
	public String getVcod_boleto() {
		return vcod_boleto;
	}
	/**
	 * @param vcod_boleto the vcod_boleto to set
	 */
	public void setVcod_boleto(String vcod_boleto) {
		this.vcod_boleto = vcod_boleto;
	}
	/**
	 * @return the ind_tarifa
	 */
	public Integer getInd_tarifa() {
		return ind_tarifa;
	}
	/**
	 * @param ind_tarifa the ind_tarifa to set
	 */
	public void setInd_tarifa(Integer ind_tarifa) {
		this.ind_tarifa = ind_tarifa;
	}
	/**
	 * @return the num_imp_unit
	 */
	public BigDecimal getNum_imp_unit() {
		return num_imp_unit;
	}
	/**
	 * @param num_imp_unit the num_imp_unit to set
	 */
	public void setNum_imp_unit(BigDecimal num_imp_unit) {
		this.num_imp_unit = num_imp_unit;
	}
	/**
	 * @return the num_serie
	 */
	public String getNum_serie() {
		return num_serie;
	}
	/**
	 * @param num_serie the num_serie to set
	 */
	public void setNum_serie(String num_serie) {
		this.num_serie = num_serie;
	}
	/**
	 * @return the can_ingreso
	 */
	public Integer getCan_ingreso() {
		return can_ingreso;
	}
	/**
	 * @param can_ingreso the can_ingreso to set
	 */
	public void setCan_ingreso(Integer can_ingreso) {
		this.can_ingreso = can_ingreso;
	}
	/**
	 * @return the can_salida
	 */
	public Integer getCan_salida() {
		return can_salida;
	}
	/**
	 * @param can_salida the can_salida to set
	 */
	public void setCan_salida(Integer can_salida) {
		this.can_salida = can_salida;
	}
	/**
	 * @return the can_stock
	 */
	public Integer getCan_stock() {
		return can_stock;
	}
	/**
	 * @param can_stock the can_stock to set
	 */
	public void setCan_stock(Integer can_stock) {
		this.can_stock = can_stock;
	}
	/**
	 * @return the fla_activo
	 */
	public String getFla_activo() {
		return fla_activo;
	}
	/**
	 * @param fla_activo the fla_activo to set
	 */
	public void setFla_activo(String fla_activo) {
		this.fla_activo = fla_activo;
	}
	/**
	 * @return the cod_partida
	 */
	public String getCod_partida() {
		return cod_partida;
	}
	/**
	 * @param cod_partida the cod_partida to set
	 */
	public void setCod_partida(String cod_partida) {
		this.cod_partida = cod_partida;
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
	 * @return the num_inicio
	 */
	public Integer getNum_inicio() {
		return num_inicio;
	}
	/**
	 * @param num_inicio the num_inicio to set
	 */
	public void setNum_inicio(Integer num_inicio) {
		this.num_inicio = num_inicio;
	}
	/**
	 * @return the num_final
	 */
	public Integer getNum_final() {
		return num_final;
	}
	/**
	 * @param num_final the num_final to set
	 */
	public void setNum_final(Integer num_final) {
		this.num_final = num_final;
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
	 * @return the can_sal_stock
	 */
	public Long getCan_sal_stock() {
		return can_sal_stock;
	}
	/**
	 * @param can_sal_stock the can_sal_stock to set
	 */
	public void setCan_sal_stock(Long can_sal_stock) {
		this.can_sal_stock = can_sal_stock;
	}
	/**
	 * @return the cod_cuenta
	 */
	public String getChrNomCuenta() {
		return chrNomCuenta;
	}
	/**
	 * @param cod_cuenta the cod_cuenta to set
	 */
	public void setChrNomCuenta(String chrNomCuenta) {
		this.chrNomCuenta = chrNomCuenta;
	}
	
}
