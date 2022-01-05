package evaluacion.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the detalle_proforma database table.
 * 
 */
@Entity
@Table(name="detalle_proforma")
@NamedQuery(name="DetalleProforma.findAll", query="SELECT d FROM DetalleProforma d")
public class DetalleProforma implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_detalle_proforma")
	private Integer idDetalleProforma;

	@Column(name="det_cantidad")
	private Integer detCantidad;

	@Column(name="det_prof_precio_total")
	private BigDecimal detProfPrecioTotal;

	@Column(name="det_prof_precio_unitario")
	private BigDecimal detProfPrecioUnitario;

	@Column(name="det_prof_uniforme")
	private Integer detProfUniforme;

	//bi-directional many-to-one association to Proforma
	@ManyToOne
	@JoinColumn(name="det_proforma")
	private Proforma proforma;

	//bi-directional many-to-one association to UniformeDeportivo
	@ManyToOne
	@JoinColumn(name="det_uniforme")
	private UniformeDeportivo uniformeDeportivo;

	public DetalleProforma() {
	}

	public Integer getIdDetalleProforma() {
		return this.idDetalleProforma;
	}

	public void setIdDetalleProforma(Integer idDetalleProforma) {
		this.idDetalleProforma = idDetalleProforma;
	}

	public Integer getDetCantidad() {
		return this.detCantidad;
	}

	public void setDetCantidad(Integer detCantidad) {
		this.detCantidad = detCantidad;
	}

	public BigDecimal getDetProfPrecioTotal() {
		return this.detProfPrecioTotal;
	}

	public void setDetProfPrecioTotal(BigDecimal detProfPrecioTotal) {
		this.detProfPrecioTotal = detProfPrecioTotal;
	}

	public BigDecimal getDetProfPrecioUnitario() {
		return this.detProfPrecioUnitario;
	}

	public void setDetProfPrecioUnitario(BigDecimal detProfPrecioUnitario) {
		this.detProfPrecioUnitario = detProfPrecioUnitario;
	}

	public Integer getDetProfUniforme() {
		return this.detProfUniforme;
	}

	public void setDetProfUniforme(Integer detProfUniforme) {
		this.detProfUniforme = detProfUniforme;
	}

	public Proforma getProforma() {
		return this.proforma;
	}

	public void setProforma(Proforma proforma) {
		this.proforma = proforma;
	}

	public UniformeDeportivo getUniformeDeportivo() {
		return this.uniformeDeportivo;
	}

	public void setUniformeDeportivo(UniformeDeportivo uniformeDeportivo) {
		this.uniformeDeportivo = uniformeDeportivo;
	}

}