package pe.com.mig.model.bean;

/**
 * @className: ProveedorBean.java
 * @description: 
 * @date: 16 de jun. de 2016
 * @author: SUMERIO.
 */
public class ProveedorBean extends MBaseBean {
	
	private static final long serialVersionUID = 1L;
	private Integer cod_proveedor;
	private Integer cod_documento;
	private String vcod_documento;
	private String nom_documento;	
	private Long num_ruc;
	private String tip_proveedor;
	private String desc_tip_proveedor;
	private String tip_estado;
//	private String desc_tip_estado;
	private String raz_social;
	private String num_documento;
	private String nombres;
	private String ape_paterno;
	private String ape_materno;
	private String direccion;
	private String telefono;
	private String mail;
	private String giro;
	private String fla_activo;
	private String mnt_fec_creacion;	
	private String mnt_usu_creacion;
	private String mnt_fec_modificacion;
	private String mnt_usu_modificacion;
	
	
	/**
	 * 
	 */
	public ProveedorBean() {
		super();
	}
	
	/**
	 * @param cod_proveedor
	 */
	public ProveedorBean(Integer cod_proveedor) {
		super();
		this.cod_proveedor = cod_proveedor;
	}

	/**
	 * @param num_ruc
	 */
	public ProveedorBean(Long num_ruc) {
		super();
		this.num_ruc = num_ruc;
	}

	/**
	 * @param num_documento
	 */
	public ProveedorBean(String num_documento) {
		super();
		this.num_documento = num_documento;
	}

	/**
	 * @return the cod_proveedor
	 */
	public Integer getCod_proveedor() {
		return cod_proveedor;
	}
	/**
	 * @param cod_proveedor the cod_proveedor to set
	 */
	public void setCod_proveedor(Integer cod_proveedor) {
		this.cod_proveedor = cod_proveedor;
	}
	/**
	 * @return the cod_documento
	 */
	public Integer getCod_documento() {
		return cod_documento;
	}
	/**
	 * @param cod_documento the cod_documento to set
	 */
	public void setCod_documento(Integer cod_documento) {
		this.cod_documento = cod_documento;
	}
	/**
	 * @return the vcod_documento
	 */
	public String getVcod_documento() {
		return vcod_documento;
	}
	/**
	 * @param vcod_documento the vcod_documento to set
	 */
	public void setVcod_documento(String vcod_documento) {
		this.vcod_documento = vcod_documento;
	}
	/**
	 * @return the nom_documento
	 */
	public String getNom_documento() {
		return nom_documento;
	}
	/**
	 * @param nom_documento the nom_documento to set
	 */
	public void setNom_documento(String nom_documento) {
		this.nom_documento = nom_documento;
	}
	/**
	 * @return the num_ruc
	 */
	public Long getNum_ruc() {
		return num_ruc;
	}
	/**
	 * @param num_ruc the num_ruc to set
	 */
	public void setNum_ruc(Long num_ruc) {
		this.num_ruc = num_ruc;
	}
	/**
	 * @return the tip_proveedor
	 */
	public String getTip_proveedor() {
		return tip_proveedor;
	}
	/**
	 * @param tip_proveedor the tip_proveedor to set
	 */
	public void setTip_proveedor(String tip_proveedor) {
		this.tip_proveedor = tip_proveedor;
	}
	/**
	 * @return the tip_estado
	 */
	public String getTip_estado() {
		return tip_estado;
	}
	/**
	 * @param tip_estado the tip_estado to set
	 */
	public void setTip_estado(String tip_estado) {
		this.tip_estado = tip_estado;
	}
	/**
	 * @return the raz_social
	 */
	public String getRaz_social() {
		return raz_social;
	}
	/**
	 * @param raz_social the raz_social to set
	 */
	public void setRaz_social(String raz_social) {
		this.raz_social = raz_social;
	}
	/**
	 * @return the num_documento
	 */
	public String getNum_documento() {
		return num_documento;
	}
	/**
	 * @param num_documento the num_documento to set
	 */
	public void setNum_documento(String num_documento) {
		this.num_documento = num_documento;
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
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}
	/**
	 * @param direccion the direccion to set
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	/**
	 * @return the telefono
	 */
	public String getTelefono() {
		return telefono;
	}
	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	/**
	 * @return the mail
	 */
	public String getMail() {
		return mail;
	}
	/**
	 * @param mail the mail to set
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}
	/**
	 * @return the giro
	 */
	public String getGiro() {
		return giro;
	}
	/**
	 * @param giro the giro to set
	 */
	public void setGiro(String giro) {
		this.giro = giro;
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
	 * @return the desc_tip_proveedor
	 */
	public String getDesc_tip_proveedor() {
		return desc_tip_proveedor;
	}

	/**
	 * @param desc_tip_proveedor the desc_tip_proveedor to set
	 */
	public void setDesc_tip_proveedor(String desc_tip_proveedor) {
		this.desc_tip_proveedor = desc_tip_proveedor;
	}

/*	*//**
	 * @return the desc_tip_estado
	 *//*
	public String getDesc_tip_estado() {
		if (this.tip_estado.equals("1")) {
			return "Estatal";
		}
		return "Privada";
	}

	*//**
	 * @param desc_tip_estado the desc_tip_estado to set
	 *//*
	public void setDesc_tip_estado(String desc_tip_estado) {
		this.desc_tip_estado = desc_tip_estado;
	}

	*//**
	 * @return the desc_tip_proveedor
	 *//*
	public String getDesc_tip_proveedor() {
		if (this.tip_proveedor.equals("1")) {
			return "Natural";
		}
		return "Jurídico";
	}

	*//**
	 * @param desc_tip_proveedor the desc_tip_proveedor to set
	 *//*
	public void setDesc_tip_proveedor(String desc_tip_proveedor) {
		this.desc_tip_proveedor = desc_tip_proveedor;
	}*/

}
