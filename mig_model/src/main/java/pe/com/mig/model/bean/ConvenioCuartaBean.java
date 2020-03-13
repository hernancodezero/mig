package pe.com.mig.model.bean;

/**
 * @className: EntidadFinancieraBean.java
 * @description: 
 * @date: 16 de jun. de 2016
 * @author: SUMERIO.
 */
public class ConvenioCuartaBean extends MBaseBean {
	
	private static final long serialVersionUID = 1L;
	private int srlIdConvenio;
	private String chrCodConvenio;
	private String chrNomConvenio;
	private String chrFlgActivo;
	private String chrCodUsuaCreacion;
	private String dteFecCreacion;
	private String chrCodUsuaModifica;
	private String dteFecModifica;
	
	
	/**
	 * 
	 */
	public ConvenioCuartaBean() {
		super();
	}
	/**
	 * @param chrFlgActivo
	 */
	public ConvenioCuartaBean(String chrFlgActivo) {
		super();
		this.chrFlgActivo = chrFlgActivo;
	}

	 
	/**
	 * @return the srlIdConvenio
	 */
	public int getSrlIdConvenio() {
		return srlIdConvenio;
	}
	/**
	 * @param srlIdConvenio the srlIdConvenio to set
	 */
	public void setSrlIdConvenio(int srlIdConvenio) {
		this.srlIdConvenio = srlIdConvenio;
	}
	/**
	 * @return the chrCodConvenio
	 */
	public String getChrCodConvenio() {
		return chrCodConvenio;
	}
	/**
	 * @param chrCodConvenio the chrCodConvenio to set
	 */
	public void setChrCodConvenio(String chrCodConvenio) {
		this.chrCodConvenio = chrCodConvenio;
	}
	/**
	 * @return the chrNomConvenio
	 */
	public String getChrNomConvenio() {
		return chrNomConvenio;
	}
	/**
	 * @param chrNomConvenio the chrNomConvenio to set
	 */
	public void setChrNomConvenio(String chrNomConvenio) {
		this.chrNomConvenio = chrNomConvenio;
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
