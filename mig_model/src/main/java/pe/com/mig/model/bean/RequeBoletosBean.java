package pe.com.mig.model.bean;

import java.util.List;

/**
 * @className: RequeBoletosBean.java
 * @description: 
 * @date: 18 de jul. de 2016
 * @author: SUMERIO.
 */
public class RequeBoletosBean extends MBaseBean {

	private static final long serialVersionUID = 1L;
	private Integer cod_req_boleto;
	private Integer cod_uni_operativa;
	private String des_uni_operativa;
	private Integer cod_reg_nac;
	private String des_reg_nac;
	private String num_docu;
	private String fec_documento;
	private Integer int_id_registro;
	private String mnt_fec_creacion;	
	private String mnt_usu_creacion;
	private String mnt_fec_modificacion;
	private String mnt_usu_modificacion;
	private String fec_ini;
	private String fec_fin;
	private List<DetalleBoletosBean> detalle;
	private List<EntregaBoletosBean> entrega;
	private int ind_detalle;
	private Long num_can_boleto;
	private Integer num_inicio;
	
	
	/**
	 * 
	 */
	public RequeBoletosBean() {
		super();
	}

	/**
	 * @param cod_req_boleto
	 */
	public RequeBoletosBean(Integer cod_req_boleto) {
		super();
		this.cod_req_boleto = cod_req_boleto;
	}
	
	/**
	 * @return the cod_req_boleto
	 */
	public Integer getCod_req_boleto() {
		return cod_req_boleto;
	}
	/**
	 * @param cod_req_boleto the cod_req_boleto to set
	 */
	public void setCod_req_boleto(Integer cod_req_boleto) {
		this.cod_req_boleto = cod_req_boleto;
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
	 * @return the num_docu
	 */
	public String getNum_docu() {
		return num_docu;
	}
	/**
	 * @param num_docu the num_docu to set
	 */
	public void setNum_docu(String num_docu) {
		this.num_docu = num_docu;
	}
	/**
	 * @return the fec_documento
	 */
	public String getFec_documento() {
		return fec_documento;
	}
	/**
	 * @param fec_documento the fec_documento to set
	 */
	public void setFec_documento(String fec_documento) {
		this.fec_documento = fec_documento;
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
	 * @return the fec_ini
	 */
	public String getFec_ini() {
		return fec_ini;
	}
	/**
	 * @param fec_ini the fec_ini to set
	 */
	public void setFec_ini(String fec_ini) {
		this.fec_ini = fec_ini;
	}
	/**
	 * @return the fec_fin
	 */
	public String getFec_fin() {
		return fec_fin;
	}
	/**
	 * @param fec_fin the fec_fin to set
	 */
	public void setFec_fin(String fec_fin) {
		this.fec_fin = fec_fin;
	}
	/**
	 * @return the detalle
	 */
	public List<DetalleBoletosBean> getDetalle() {
		return detalle;
	}
	/**
	 * @param detalle the detalle to set
	 */
	public void setDetalle(List<DetalleBoletosBean> detalle) {
		this.detalle = detalle;
	}
	/**
	 * @return the entrega
	 */
	public List<EntregaBoletosBean> getEntrega() {
		return entrega;
	}
	/**
	 * @param entrega the entrega to set
	 */
	public void setEntrega(List<EntregaBoletosBean> entrega) {
		this.entrega = entrega;
	}
	/**
	 * @return the ind_detalle
	 */
	public int getInd_detalle() {
		return ind_detalle;
	}
	/**
	 * @param ind_detalle the ind_detalle to set
	 */
	public void setInd_detalle(int ind_detalle) {
		this.ind_detalle = ind_detalle;
	}
	/**
	 * @return the num_can_boleto
	 */
	public Long getNum_can_boleto() {
		return num_can_boleto;
	}
	/**
	 * @param num_can_boleto the num_can_boleto to set
	 */
	public void setNum_can_boleto(Long num_can_boleto) {
		this.num_can_boleto = num_can_boleto;
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
	
}
