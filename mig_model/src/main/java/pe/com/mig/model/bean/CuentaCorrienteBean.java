package pe.com.mig.model.bean;

/**
 * @className: CuentaCorrienteBean.java
 * @description: 
 * @date: 12 de jun. de 2016
 * @author: SUMERIO.
 */
public class CuentaCorrienteBean extends MBaseBean {

	private static final long serialVersionUID = 1L;
	private int cod_fte;
	private int cod_cta;
	private String vcod_cta;
	private String nom_cta;
	private String fla_activo;
	
	
	/**
	 * 
	 */
	public CuentaCorrienteBean() {
		super();
	}

	/**
	 * @param fla_activo
	 */
	public CuentaCorrienteBean(String fla_activo) {
		super();
		this.fla_activo = fla_activo;
	}
	
	/**
	 * @return the cod_fte
	 */
	public int getCod_fte() {
		return cod_fte;
	}
	/**
	 * @param cod_cta the cod_cta to set
	 */
	public void setCod_cta(int cod_cta) {
		this.cod_cta = cod_cta;
	}
	/**
	 * @return the cod_fte
	 */
	public int getCod_cta() {
		return cod_cta;
	}
	/**
	 * @param cod_fte the cod_fte to set
	 */
	public void setCod_fte(int cod_fte) {
		this.cod_fte = cod_fte;
	}
	/**
	 * @return the vcod_cta
	 */
	public String getVcod_cta() {
		return vcod_cta;
	}
	/**
	 * @param vcod_fte the vcod_cta to set
	 */
	public void setVcod_cta(String vcod_cta) {
		this.vcod_cta = vcod_cta;
	}
	/**
	 * @return the nom_cta
	 */
	public String getNom_cta() {
		return nom_cta;
	}
	/**
	 * @param nom_cta the nom_cta to set
	 */
	public void setNom_cta(String nom_cta) {
		this.nom_cta = nom_cta;
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

}
