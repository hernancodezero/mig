package pe.com.mig.model.bean;

/**
 * @className: CierreMesBean.java
 * @description: 
 * @date: 16 de jun. de 2016
 * @author: SUMERIO.
 */
public class CierreMesBean extends MBaseBean {

	private static final long serialVersionUID = 1L;
	private Integer cod_mes;
	private Integer anio;
	private Integer mes;
	private String fec_cierre;
	private String fec_des_cierre;
	private String fec_apertura;
	private String mes_activo;
	private String fla_apertura;
	private Integer cod_uni_operativa;
	private String des_uni_operativa;
	private Integer cod_reg_nac;
	private String des_reg_nac;
	private String mnt_fec_creacion;	
	private String mnt_usu_creacion;
	private String mnt_fec_modificacion;
	private String mnt_usu_modificacion;
	private String ind_cie_todos;
	private Integer ind_tip_compra;
	private Integer ind_tip_venta;
	private String nom_compra;
	private String nom_venta;
	private String fec_des_cierre_vta;
	private String fla_apertura_vta;
	
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
	 * @return the anio
	 */
	public Integer getAnio() {
		return anio;
	}
	/**
	 * @param anio the anio to set
	 */
	public void setAnio(Integer anio) {
		this.anio = anio;
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
	 * @return the fec_cierre
	 */
	public String getFec_cierre() {
		return fec_cierre;
	}
	/**
	 * @param fec_cierre the fec_cierre to set
	 */
	public void setFec_cierre(String fec_cierre) {
		this.fec_cierre = fec_cierre;
	}
	/**
	 * @return the fec_des_cierre
	 */
	public String getFec_des_cierre() {
		return fec_des_cierre;
	}
	/**
	 * @param fec_des_cierre the fec_des_cierre to set
	 */
	public void setFec_des_cierre(String fec_des_cierre) {
		this.fec_des_cierre = fec_des_cierre;
	}
	/**
	 * @return the fec_apertura
	 */
	public String getFec_apertura() {
		return fec_apertura;
	}
	/**
	 * @param fec_apertura the fec_apertura to set
	 */
	public void setFec_apertura(String fec_apertura) {
		this.fec_apertura = fec_apertura;
	}
	/**
	 * @return the mes_activo
	 */
	public String getMes_activo() {
		return mes_activo;
	}
	/**
	 * @param mes_activo the mes_activo to set
	 */
	public void setMes_activo(String mes_activo) {
		this.mes_activo = mes_activo;
	}
	/**
	 * @return the fla_apertura
	 */
	public String getFla_apertura() {
		return fla_apertura;
	}
	/**
	 * @param fla_apertura the fla_apertura to set
	 */
	public void setFla_apertura(String fla_apertura) {
		this.fla_apertura = fla_apertura;
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
	 * @return the ind_cie_todos
	 */
	public String getInd_cie_todos() {
		return ind_cie_todos;
	}
	/**
	 * @param ind_cie_todos the ind_cie_todos to set
	 */
	public void setInd_cie_todos(String ind_cie_todos) {
		this.ind_cie_todos = ind_cie_todos;
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
	public Integer getInd_tip_compra() {
		return ind_tip_compra;
	}
	public void setInd_tip_compra(Integer ind_tip_compra) {
		this.ind_tip_compra = ind_tip_compra;
	}
	public Integer getInd_tip_venta() {
		return ind_tip_venta;
	}
	public void setInd_tip_venta(Integer ind_tip_venta) {
		this.ind_tip_venta = ind_tip_venta;
	}
	public String getNom_compra() {
		return nom_compra;
	}
	public void setNom_compra(String nom_compra) {
		this.nom_compra = nom_compra;
	}
	public String getNom_venta() {
		return nom_venta;
	}
	public void setNom_venta(String nom_venta) {
		this.nom_venta = nom_venta;
	}
	public String getFec_des_cierre_vta() {
		return fec_des_cierre_vta;
	}
	public void setFec_des_cierre_vta(String fec_des_cierre_vta) {
		this.fec_des_cierre_vta = fec_des_cierre_vta;
	}
	public String getFla_apertura_vta() {
		return fla_apertura_vta;
	}
	public void setFla_apertura_vta(String fla_apertura_vta) {
		this.fla_apertura_vta = fla_apertura_vta;
	}
	
}
