package pe.com.mig.model.bean;

/**
 * @className: DocumentoCuartaBean.java
 * @description: 
 * @date: 16 de jun. de 2016
 * @author: SUMERIO.
 */
public class DocumentoCuartaBean extends MBaseBean {
	
	private static final long serialVersionUID = 1L;
	private int srlIdDocumento;
	private String chrCodDocumento;
	private String chrNomDocumento;
	private String chrFlgActivo;
	private String chrCodUsuaCreacion;
	private String dteFecCreacion;
	private String chrCodUsuaModifica;
	private String dteFecModifica;
	
	
	/**
	 * 
	 */
	public DocumentoCuartaBean() {
		super();
	}
	
	/**
	 * @param chrFlgActivo
	 */
	public DocumentoCuartaBean(String chrFlgActivo) {
		super();
		this.chrFlgActivo = chrFlgActivo;
	}

	/**
	 * @return the srlIdDocumento
	 */
	public int getSrlIdDocumento() {
		return srlIdDocumento;
	}

	/**
	 * @param srlIdDocumento the srlIdDocumento to set
	 */
	public void setSrlIdDocumento(int srlIdDocumento) {
		this.srlIdDocumento = srlIdDocumento;
	}

	/**
	 * @return the chrCodDocumento
	 */
	public String getChrCodDocumento() {
		return chrCodDocumento;
	}

	/**
	 * @param chrCodDocumento the chrCodDocumento to set
	 */
	public void setChrCodDocumento(String chrCodDocumento) {
		this.chrCodDocumento = chrCodDocumento;
	}

	/**
	 * @return the chrNomDocumento
	 */
	public String getChrNomDocumento() {
		return chrNomDocumento;
	}

	/**
	 * @param chrNomDocumento the chrNomDocumento to set
	 */
	public void setChrNomDocumento(String chrNomDocumento) {
		this.chrNomDocumento = chrNomDocumento;
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
