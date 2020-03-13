package pe.com.mig.model.bean;

/**
 * @className: FuenteFinanciamientoBean.java
 * @description: 
 * @date: 16 de jun. de 2016
 * @author: SUMERIO.
 */
public class FuenteFinanciamientoBean extends MBaseBean {

	private static final long serialVersionUID = 1L;
	private int cod_fte;
	private String vcod_fte;
	private String nom_fte;
	private String fla_activo;
	
	
	/**
	 * 
	 */
	public FuenteFinanciamientoBean() {
		super();
	}

	/**
	 * @param fla_activo
	 */
	public FuenteFinanciamientoBean(String fla_activo) {
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
	 * @param cod_fte the cod_fte to set
	 */
	public void setCod_fte(int cod_fte) {
		this.cod_fte = cod_fte;
	}
	/**
	 * @return the vcod_fte
	 */
	public String getVcod_fte() {
		return vcod_fte;
	}
	/**
	 * @param vcod_fte the vcod_fte to set
	 */
	public void setVcod_fte(String vcod_fte) {
		this.vcod_fte = vcod_fte;
	}
	/**
	 * @return the nom_fte
	 */
	public String getNom_fte() {
		return nom_fte;
	}
	/**
	 * @param nom_fte the nom_fte to set
	 */
	public void setNom_fte(String nom_fte) {
		this.nom_fte = nom_fte;
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
