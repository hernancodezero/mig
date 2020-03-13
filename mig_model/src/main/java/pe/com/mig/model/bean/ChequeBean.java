package pe.com.mig.model.bean;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @className: ChequeBean.java
 * @description: 
 * @date: 25/10/2015 04:57:32
 * @author: SUMERIO
 */
public class ChequeBean extends MBaseBean {

	private static final long serialVersionUID = -607679512634347537L;
	private String anio;
	private String mes;
	private String nro_comprobante;
	private String nro_expediente;
	private String descripcion;
	private BigDecimal monto;
	private String nro_ruc;
	private String nombre;
	private String fecha;
	private Date dfecha;
	private String tip_giro;
	private String proveedor;
	private String letras;
	private String nro_cheque;

	/**
	 * 
	 */
	public ChequeBean() {
		super();
	}

	/**
	 * @return the anio
	 */
	public String getAnio() {
		return anio;
	}

	/**
	 * @param anio the anio to set
	 */
	public void setAnio(String anio) {
		this.anio = anio;
	}

	/**
	 * @return the mes
	 */
	public String getMes() {
		return mes;
	}

	/**
	 * @param mes the mes to set
	 */
	public void setMes(String mes) {
		this.mes = mes;
	}

	/**
	 * @return the nro_comprobante
	 */
	public String getNro_comprobante() {
		return nro_comprobante;
	}

	/**
	 * @param nro_comprobante the nro_comprobante to set
	 */
	public void setNro_comprobante(String nro_comprobante) {
		this.nro_comprobante = nro_comprobante;
	}

	/**
	 * @return the nro_expediente
	 */
	public String getNro_expediente() {
		return nro_expediente;
	}

	/**
	 * @param nro_expediente the nro_expediente to set
	 */
	public void setNro_expediente(String nro_expediente) {
		this.nro_expediente = nro_expediente;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the monto
	 */
	public BigDecimal getMonto() {
		return monto;
	}

	/**
	 * @param monto the monto to set
	 */
	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}

	/**
	 * @return the nro_ruc
	 */
	public String getNro_ruc() {
		return nro_ruc;
	}

	/**
	 * @param nro_ruc the nro_ruc to set
	 */
	public void setNro_ruc(String nro_ruc) {
		this.nro_ruc = nro_ruc;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the fecha
	 */
	public String getFecha() {
		return fecha;
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	/**
	 * @return the dfecha
	 */
	public Date getDfecha() {
		return dfecha;
	}

	/**
	 * @param dfecha the dfecha to set
	 */
	public void setDfecha(Date dfecha) {
		this.dfecha = dfecha;
	}

	/**
	 * @return the tip_giro
	 */
	public String getTip_giro() {
		return tip_giro;
	}

	/**
	 * @param tip_giro the tip_giro to set
	 */
	public void setTip_giro(String tip_giro) {
		this.tip_giro = tip_giro;
	}

	/**
	 * @return the proveedor
	 */
	public String getProveedor() {
		return proveedor;
	}

	/**
	 * @param proveedor the proveedor to set
	 */
	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}

	/**
	 * @return the letras
	 */
	public String getLetras() {
		return letras;
	}

	/**
	 * @param letras the letras to set
	 */
	public void setLetras(String letras) {
		this.letras = letras;
	}

	/**
	 * @return the nro_cheque
	 */
	public String getNro_cheque() {
		return nro_cheque;
	}

	/**
	 * @param nro_cheque the nro_cheque to set
	 */
	public void setNro_cheque(String nro_cheque) {
		this.nro_cheque = nro_cheque;
	}

}
