package pe.com.mig.model.bean;

/**
 * @className: EntidadFinancieraBean.java
 * @description: 
 * @date: 16 de jun. de 2016
 * @author: SUMERIO.
 */
public class ZonaBean extends MBaseBean {
	
	private static final long serialVersionUID = 1L;
	private int srlIdZona;
	private String chrCodZona;
	private String chrNomZona;
	private String chrFlgActivo;
	private String chrCodUsuaCreacion;
	private String dteFecCreacion;
	private String chrCodUsuaModifica;
	private String dteFecModifica;
	
	
	/**
	 * 
	 */
	public ZonaBean() {
		super();
	}
	/**
	 * @param chrFlgActivo
	 */
	public ZonaBean(String chrFlgActivo) {
		super();
		this.chrFlgActivo = chrFlgActivo;
	}

	/**
	 * @return the srlIdZona
	 */
	public int getSrlIdZona() {
		return srlIdZona;
	}


	/**
	 * @param srlIdZona the srlIdZona to set
	 */
	public void setSrlIdZona(int srlIdZona) {
		this.srlIdZona = srlIdZona;
	}


	/**
	 * @return the chrCodZona
	 */
	public String getChrCodZona() {
		return chrCodZona;
	}


	/**
	 * @param chrCodZona the chrCodZona to set
	 */
	public void setChrCodZona(String chrCodZona) {
		this.chrCodZona = chrCodZona;
	}


	/**
	 * @return the chrNomZona
	 */
	public String getChrNomZona() {
		return chrNomZona;
	}


	/**
	 * @param chrNomZona the chrNomZona to set
	 */
	public void setChrNomZona(String chrNomZona) {
		this.chrNomZona = chrNomZona;
	}


	/**
	 * @return the chrFlgActivo
	 */
	public String getChrFlgActivo() {
		return chrFlgActivo;
	}


	/**
	 * @param chrFlgActivo the chrFlgActivo to set
	 */
	public void setChrFlgActivo(String chrFlgActivo) {
		this.chrFlgActivo = chrFlgActivo;
	}


	/**
	 * @return the chrCodUsuaCreacion
	 */
	public String getChrCodUsuaCreacion() {
		return chrCodUsuaCreacion;
	}


	/**
	 * @param chrCodUsuaCreacion the chrCodUsuaCreacion to set
	 */
	public void setChrCodUsuaCreacion(String chrCodUsuaCreacion) {
		this.chrCodUsuaCreacion = chrCodUsuaCreacion;
	}

	/**
	 * @return the chrCodUsuaModifica
	 */
	public String getChrCodUsuaModifica() {
		return chrCodUsuaModifica;
	}


	/**
	 * @param chrCodUsuaModifica the chrCodUsuaModifica to set
	 */
	public void setChrCodUsuaModifica(String chrCodUsuaModifica) {
		this.chrCodUsuaModifica = chrCodUsuaModifica;
	}
	/**
	 * @return the dteFecCreacion
	 */
	public String getDteFecCreacion() {
		return dteFecCreacion;
	}
	/**
	 * @param dteFecCreacion the dteFecCreacion to set
	 */
	public void setDteFecCreacion(String dteFecCreacion) {
		this.dteFecCreacion = dteFecCreacion;
	}
	/**
	 * @return the dteFecModifica
	 */
	public String getDteFecModifica() {
		return dteFecModifica;
	}
	/**
	 * @param dteFecModifica the dteFecModifica to set
	 */
	public void setDteFecModifica(String dteFecModifica) {
		this.dteFecModifica = dteFecModifica;
	}

}
