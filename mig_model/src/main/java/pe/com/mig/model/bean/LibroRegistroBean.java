package pe.com.mig.model.bean;

/**
 * @className: EntidadFinancieraBean.java
 * @description: 
 * @date: 16 de jun. de 2016
 * @author: SUMERIO.
 */
public class LibroRegistroBean extends MBaseBean {
	
	private static final long serialVersionUID = 1L;
	private Integer cod_libroregistro;
	private String cod_entidad;
	private String nom_entidad;	
	private String fla_activo;
	private String mnt_fec_creacion;	
	private String mnt_usu_creacion;
	private String mnt_fec_modificacion;
	private String mnt_usu_modificacion;
	
	
	/**
	 * 
	 */
	public LibroRegistroBean() {
		super();
	}
	
	/**
	 * @param cod_libroregistro
	 */
	public LibroRegistroBean(Integer cod_libroregistro) {
		super();
		this.setcod_libroregistro(cod_libroregistro);
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
	 * @return the cod_libroregistro
	 */
	public Integer getcod_libroregistro() {
		return cod_libroregistro;
	}

	/**
	 * @param cod_libroregistro the cod_libroregistro to set
	 */
	public void setcod_libroregistro(Integer cod_libroregistro) {
		this.cod_libroregistro = cod_libroregistro;
	}

	/**
	 * @return the nom_entidad
	 */
	public String getNom_entidad() {
		return nom_entidad;
	}

	/**
	 * @param nom_entidad the nom_entidad to set
	 */
	public void setNom_entidad(String nom_entidad) {
		this.nom_entidad = nom_entidad;
	}

	/**
	 * @return the cod_entidad
	 */
	public String getCod_entidad() {
		return cod_entidad;
	}

	/**
	 * @param cod_entidad the cod_entidad to set
	 */
	public void setCod_entidad(String cod_entidad) {
		this.cod_entidad = cod_entidad;
	}

}
