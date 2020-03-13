package pe.com.mig.model.bean;

/**
 * @className: DetalleOtrosBean.java
 * @description: 
 * @date: 7 de jul. de 2016
 * @author: SUMERIO.
 */
public class DetalleOtrosBean extends MBaseBean {
	
	private static final long serialVersionUID = 1L;
	private Integer cod_otros;
	private String nom_otros;
	private String fla_activo;
	private String cod_especifica;
	private String cod_cuenta;
	
	
	/**
	 * @return the cod_otros
	 */
	public Integer getCod_otros() {
		return cod_otros;
	}
	/**
	 * @param cod_otros the cod_otros to set
	 */
	public void setCod_otros(Integer cod_otros) {
		this.cod_otros = cod_otros;
	}
	/**
	 * @return the nom_otros
	 */
	public String getNom_otros() {
		return nom_otros;
	}
	/**
	 * @param nom_otros the nom_otros to set
	 */
	public void setNom_otros(String nom_otros) {
		this.nom_otros = nom_otros;
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
	 * @return the cod_especifica
	 */
	public String getCod_especifica() {
		return cod_especifica;
	}
	/**
	 * @param cod_especifica the cod_especifica to set
	 */
	public void setCod_especifica(String cod_especifica) {
		this.cod_especifica = cod_especifica;
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

}
