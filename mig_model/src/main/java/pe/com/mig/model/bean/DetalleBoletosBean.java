package pe.com.mig.model.bean;

/**
 * @className: RequeBoletosBean.java
 * @description: 
 * @date: 18 de jul. de 2016
 * @author: SUMERIO.
 */
public class DetalleBoletosBean extends MBaseBean {

	private static final long serialVersionUID = 1L;
	private Integer cod_det_boleto;
	private Integer cod_req_boleto;
	private String fec_documento;
	private Integer cod_tar_boleto;
	private String num_serie;
	private String nom_boleto;
	private String des_ind_tarifa;
	private Integer num_can_boleto;
	private Integer num_inicio;
	private Integer num_final;
	private Integer int_id_registro;
	private String mnt_fec_creacion;	
	private String mnt_usu_creacion;
	private String mnt_fec_modificacion;
	private String mnt_usu_modificacion;
	private Integer can_adi_boleto;
	
	
	/**
	 * 
	 */
	public DetalleBoletosBean() {
		super();
	}

	/**
	 * @param cod_req_boleto
	 */
	public DetalleBoletosBean(Integer cod_req_boleto) {
		super();
		this.cod_req_boleto = cod_req_boleto;
	}
	
	/**
	 * @return the cod_det_boleto
	 */
	public Integer getCod_det_boleto() {
		return cod_det_boleto;
	}
	/**
	 * @param cod_det_boleto the cod_det_boleto to set
	 */
	public void setCod_det_boleto(Integer cod_det_boleto) {
		this.cod_det_boleto = cod_det_boleto;
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
	 * @return the cod_tar_boleto
	 */
	public Integer getCod_tar_boleto() {
		return cod_tar_boleto;
	}
	/**
	 * @param cod_tar_boleto the cod_tar_boleto to set
	 */
	public void setCod_tar_boleto(Integer cod_tar_boleto) {
		this.cod_tar_boleto = cod_tar_boleto;
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
	 * @return the num_can_boleto
	 */
	public Integer getNum_can_boleto() {
		return num_can_boleto;
	}
	/**
	 * @param num_can_boleto the num_can_boleto to set
	 */
	public void setNum_can_boleto(Integer num_can_boleto) {
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
	 * @return the can_adi_boleto
	 */
	public Integer getCan_adi_boleto() {
		return can_adi_boleto;
	}
	/**
	 * @param can_adi_boleto the can_adi_boleto to set
	 */
	public void setCan_adi_boleto(Integer can_adi_boleto) {
		this.can_adi_boleto = can_adi_boleto;
	}
	
}
