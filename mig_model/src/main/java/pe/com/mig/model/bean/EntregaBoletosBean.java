package pe.com.mig.model.bean;

/**
 * @className: RequeBoletosBean.java
 * @description: 
 * @date: 18 de jul. de 2016
 * @author: SUMERIO.
 */
public class EntregaBoletosBean extends MBaseBean {

	private static final long serialVersionUID = 1L;
	private Integer cod_ent_boleto;
	private Integer cod_det_boleto;
	private Integer cod_tar_boleto;
	private String num_serie;
	private String num_acta;
	private String fec_acta;
	private Integer num_can_boleto;
	private Integer can_sal_bol;
	private Integer num_inicio;
	private Integer num_final;
	private Integer int_id_registro;
	private String mnt_fec_creacion;	
	private String mnt_usu_creacion;
	private String mnt_fec_modificacion;
	private String mnt_usu_modificacion;
	
	
	/**
	 * 
	 */
	public EntregaBoletosBean() {
		super();
	}
	/**
	 * @param cod_det_boleto
	 */
	public EntregaBoletosBean(Integer cod_det_boleto) {
		super();
		this.cod_det_boleto = cod_det_boleto;
	}
	/**
	 * @return the cod_ent_boleto
	 */
	public Integer getCod_ent_boleto() {
		return cod_ent_boleto;
	}
	/**
	 * @param cod_ent_boleto the cod_ent_boleto to set
	 */
	public void setCod_ent_boleto(Integer cod_ent_boleto) {
		this.cod_ent_boleto = cod_ent_boleto;
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
	 * @return the num_acta
	 */
	public String getNum_acta() {
		return num_acta;
	}
	/**
	 * @param num_acta the num_acta to set
	 */
	public void setNum_acta(String num_acta) {
		this.num_acta = num_acta;
	}
	/**
	 * @return the fec_acta
	 */
	public String getFec_acta() {
		return fec_acta;
	}
	/**
	 * @param fec_acta the fec_acta to set
	 */
	public void setFec_acta(String fec_acta) {
		this.fec_acta = fec_acta;
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
	 * @return the can_sal_bol
	 */
	public Integer getCan_sal_bol() {
		return can_sal_bol;
	}
	/**
	 * @param can_sal_bol the can_sal_bol to set
	 */
	public void setCan_sal_bol(Integer can_sal_bol) {
		this.can_sal_bol = can_sal_bol;
	}

}
