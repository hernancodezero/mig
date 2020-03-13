
package pe.com.mig.model.bean;

/**
 * @className: EntidadFinancieraBean.java
 * @description: 
 * @date: 16 de jun. de 2016
 * @author: SUMERIO.
 */
public class DireccionFacturaBean extends MBaseBean {
	
	private static final long serialVersionUID = 1L;
	private Integer srl_direc;
	private String cod_direc;
	private String tip_oficina;	
	private String nom_anp;
	private String nom_ubigeo;	
	private String chr_direc;
	private String chr_ref_direc;
	private String chr_legal;
	
	
	/**
	 * 
	 */
	public DireccionFacturaBean() {
		super();
	}

	public DireccionFacturaBean(Integer srl_direc) {
		super();
		this.setSrl_direc(srl_direc);
	}

	public Integer getSrl_direc() {
		return srl_direc;
	}

	public void setSrl_direc(Integer srl_direc) {
		this.srl_direc = srl_direc;
	}

	public String getCod_direc() {
		return cod_direc;
	}

	public void setCod_direc(String cod_direc) {
		this.cod_direc = cod_direc;
	}

	public String getTip_oficina() {
		return tip_oficina;
	}

	public void setTip_oficina(String tip_oficina) {
		this.tip_oficina = tip_oficina;
	}

	public String getNom_anp() {
		return nom_anp;
	}

	public void setNom_anp(String nom_anp) {
		this.nom_anp = nom_anp;
	}

	public String getNom_ubigeo() {
		return nom_ubigeo;
	}

	public void setNom_ubigeo(String nom_ubigeo) {
		this.nom_ubigeo = nom_ubigeo;
	}

	public String getChr_direc() {
		return chr_direc;
	}

	public void setChr_direc(String chr_direc) {
		this.chr_direc = chr_direc;
	}

	public String getChr_ref_direc() {
		return chr_ref_direc;
	}

	public void setChr_ref_direc(String chr_ref_direc) {
		this.chr_ref_direc = chr_ref_direc;
	}

	public String getChr_legal() {
		return chr_legal;
	}

	public void setChr_legal(String chr_legal) {
		this.chr_legal = chr_legal;
	}



}

