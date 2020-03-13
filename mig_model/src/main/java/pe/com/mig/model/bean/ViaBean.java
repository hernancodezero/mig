package pe.com.mig.model.bean;

/**
 * @className: EntidadFinancieraBean.java
 * @description: 
 * @date: 16 de jun. de 2016
 * @author: SUMERIO.
 */
public class ViaBean extends MBaseBean {
	
	private static final long serialVersionUID = 1L;
	private int srlIdVia;
	private String chrCodVia;
	private String chrNomVia;
	private String chrFlgActivo;
	private String chrCodUsuaCreacion;
	private String dteFecCreacion;
	private String chrCodUsuaModifica;
	private String dteFecModifica;
	
	
	/**
	 * 
	 */
	public ViaBean() {
		super();
	}
	/**
	 * @param chrFlgActivo
	 */
	public ViaBean(String chrFlgActivo) {
		super();
		this.chrFlgActivo = chrFlgActivo;
	}

	/**
	 * @return the srlIdVia
	 */
	public int getSrlIdVia() {
		return srlIdVia;
	}


	/**
	 * @param srlIdVia the srlIdVia to set
	 */
	public void setSrlIdVia(int srlIdVia) {
		this.srlIdVia = srlIdVia;
	}


	/**
	 * @return the chrCodVia
	 */
	public String getChrCodVia() {
		return chrCodVia;
	}


	/**
	 * @param chrCodVia the chrCodVia to set
	 */
	public void setChrCodVia(String chrCodVia) {
		this.chrCodVia = chrCodVia;
	}


	/**
	 * @return the chrNomVia
	 */
	public String getChrNomVia() {
		return chrNomVia;
	}


	/**
	 * @param chrNomVia the chrNomVia to set
	 */
	public void setChrNomVia(String chrNomVia) {
		this.chrNomVia = chrNomVia;
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
