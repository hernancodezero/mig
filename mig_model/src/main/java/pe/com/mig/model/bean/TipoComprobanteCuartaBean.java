package pe.com.mig.model.bean;

/**
 * @className: EntidadFinancieraBean.java
 * @description: 
 * @date: 16 de jun. de 2016
 * @author: SUMERIO.
 */
public class TipoComprobanteCuartaBean extends MBaseBean {
	
	private static final long serialVersionUID = 1L;
	private Integer cod_comprobante;
	private String nom_comprobante;
	private String vcod_comprobante;
	private String fla_activo;
	private String mnt_fec_creacion;	
	private String mnt_usu_creacion;
	private String mnt_fec_modificacion;
	private String mnt_usu_modificacion;

	/**
	 * 
	 */
	public TipoComprobanteCuartaBean() {
		super();
	}

	/**
	 * @param fla_activo
	 */
	public TipoComprobanteCuartaBean(String fla_activo) {
		super();
		this.fla_activo = fla_activo;
	}
	
	/**
	 * @return the cod_comprobante
	 */
	public Integer getCod_comprobante() {
		return cod_comprobante;
	}
	/**
	 * @param cod_comprobante the cod_comprobante to set
	 */
	public void setCod_comprobante(Integer cod_comprobante) {
		this.cod_comprobante = cod_comprobante;
	}
	/**
	 * @return the vcod_comprobante
	 */
	public String getVcod_comprobante() {
		return vcod_comprobante;
	}
	/**
	 * @param vcod_comprobante the vcod_comprobante to set
	 */
	public void setVcod_comprobante(String vcod_comprobante) {
		this.vcod_comprobante = vcod_comprobante;
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
	 * @return the nom_comprobante
	 */
	public String getNom_comprobante() {
		return nom_comprobante;
	}

	/**
	 * @param nom_comprobante the nom_comprobante to set
	 */
	public void setNom_comprobante(String nom_comprobante) {
		this.nom_comprobante = nom_comprobante;
	}

}
