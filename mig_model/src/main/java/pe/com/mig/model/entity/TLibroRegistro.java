package pe.com.mig.model.entity;
// Generated 22/06/2016 01:16:56 AM by Hibernate Tools 4.3.1

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * TLibroRegistro generated by hbm2java
 */
@Entity
@Table(name = "t_libro_registro", schema = "mig")
public class TLibroRegistro implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private int srlIdLibro;
	private String chrCodLibro;
	private String chrNomLibro;
	private String chrFlgActivo;
	private String chrCodUsuaCreacion;
	private Date dteFecCreacion;
	private String chrCodUsuaModifica;
	private Date dteFecModifica;

	public TLibroRegistro() {
	}

	public TLibroRegistro(int srlIdLibro) {
		this.srlIdLibro = srlIdLibro;
	}

	public TLibroRegistro(int srlIdLibro, String chrCodLibro, String chrNomLibro, String chrFlgActivo,
			String chrCodUsuaCreacion, Date dteFecCreacion, String chrCodUsuaModifica, Date dteFecModifica) {
		this.srlIdLibro = srlIdLibro;
		this.chrCodLibro = chrCodLibro;
		this.chrNomLibro = chrNomLibro;
		this.chrFlgActivo = chrFlgActivo;
		this.chrCodUsuaCreacion = chrCodUsuaCreacion;
		this.dteFecCreacion = dteFecCreacion;
		this.chrCodUsuaModifica = chrCodUsuaModifica;
		this.dteFecModifica = dteFecModifica;
	}

	@Id
	@SequenceGenerator(name = "seq_libro_registro", sequenceName = "mig.t_libro_registro_srl_id_libro_seq")
	@GeneratedValue(generator = "seq_libro_registro")
	@Column(name = "srl_id_libro", unique = true, nullable = false)
	public int getSrlIdLibro() {
		return this.srlIdLibro;
	}

	public void setSrlIdLibro(int srlIdLibro) {
		this.srlIdLibro = srlIdLibro;
	}

	@Column(name = "chr_cod_libro", length = 2)
	public String getChrCodLibro() {
		return this.chrCodLibro;
	}

	public void setChrCodLibro(String chrCodLibro) {
		this.chrCodLibro = chrCodLibro;
	}

	@Column(name = "chr_nom_libro", length = 400)
	public String getChrNomLibro() {
		return this.chrNomLibro;
	}

	public void setChrNomLibro(String chrNomLibro) {
		this.chrNomLibro = chrNomLibro;
	}

	@Column(name = "chr_flg_activo", length = 1)
	public String getChrFlgActivo() {
		return this.chrFlgActivo;
	}

	public void setChrFlgActivo(String chrFlgActivo) {
		this.chrFlgActivo = chrFlgActivo;
	}

	@Column(name = "chr_cod_usua_creacion", length = 20)
	public String getChrCodUsuaCreacion() {
		return this.chrCodUsuaCreacion;
	}

	public void setChrCodUsuaCreacion(String chrCodUsuaCreacion) {
		this.chrCodUsuaCreacion = chrCodUsuaCreacion;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "dte_fec_creacion", length = 13)
	public Date getDteFecCreacion() {
		return this.dteFecCreacion;
	}

	public void setDteFecCreacion(Date dteFecCreacion) {
		this.dteFecCreacion = dteFecCreacion;
	}

	@Column(name = "chr_cod_usua_modifica", length = 20)
	public String getChrCodUsuaModifica() {
		return this.chrCodUsuaModifica;
	}

	public void setChrCodUsuaModifica(String chrCodUsuaModifica) {
		this.chrCodUsuaModifica = chrCodUsuaModifica;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "dte_fec_modifica", length = 13)
	public Date getDteFecModifica() {
		return this.dteFecModifica;
	}

	public void setDteFecModifica(Date dteFecModifica) {
		this.dteFecModifica = dteFecModifica;
	}

}
