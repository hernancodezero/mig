package pe.com.mig.model.bean;

/**
 * @className: EntidadFinancieraBean.java
 * @description: 
 * @date: 16 de jun. de 2016
 * @author: SUMERIO.
 */
public class NacionalidadBean extends MBaseBean {
	
	private static final long serialVersionUID = 1L;
	private int srlIdNacion;
	private String chrCodNacion;
	private String chrNomNacion;
	private String chrFlgActivo;
	private String chrCodUsuaCreacion;
	private String dteFecCreacion;
	private String chrCodUsuaModifica;
	private String dteFecModifica;
	
	
	/**
	 * 
	 */
	public NacionalidadBean() {
		super();
	}
	/**
	 * @param chrFlgActivo
	 */
	public NacionalidadBean(String chrFlgActivo) {
		super();
		this.chrFlgActivo = chrFlgActivo;
	}


	/**
	 * @return the srlIdNacion
	 */
	public int getSrlIdNacion() {
		return srlIdNacion;
	}


	/**
	 * @param srlIdNacion the srlIdNacion to set
	 */
	public void setSrlIdNacion(int srlIdNacion) {
		this.srlIdNacion = srlIdNacion;
	}


	/**
	 * @return the chrCodNacion
	 */
	public String getChrCodNacion() {
		return chrCodNacion;
	}


	/**
	 * @param chrCodNacion the chrCodNacion to set
	 */
	public void setChrCodNacion(String chrCodNacion) {
		this.chrCodNacion = chrCodNacion;
	}


	/**
	 * @return the chrNomNacion
	 */
	public String getChrNomNacion() {
		return chrNomNacion;
	}


	/**
	 * @param chrNomNacion the chrNomNacion to set
	 */
	public void setChrNomNacion(String chrNomNacion) {
		this.chrNomNacion = chrNomNacion;
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
