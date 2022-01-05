package evaluacion.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the uniforme_deportivo database table.
 * 
 */
@Entity
@Table(name="uniforme_deportivo")
@NamedQuery(name="UniformeDeportivo.findAll", query="SELECT u FROM UniformeDeportivo u")
public class UniformeDeportivo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_uniforme")
	private Integer idUniforme;

	@Column(name="uni_descripcion")
	private String uniDescripcion;

	@Column(name="uni_dorsal")
	private Integer uniDorsal;

	@Column(name="uni_precio")
	private BigDecimal uniPrecio;

	//bi-directional many-to-one association to DetalleProforma
	@OneToMany(mappedBy="uniformeDeportivo")
	private List<DetalleProforma> detalleProformas;

	//bi-directional many-to-one association to Talla
	@ManyToOne
	@JoinColumn(name="uni_talla")
	private Talla talla;

	public UniformeDeportivo() {
	}

	public Integer getIdUniforme() {
		return this.idUniforme;
	}

	public void setIdUniforme(Integer idUniforme) {
		this.idUniforme = idUniforme;
	}

	public String getUniDescripcion() {
		return this.uniDescripcion;
	}

	public void setUniDescripcion(String uniDescripcion) {
		this.uniDescripcion = uniDescripcion;
	}

	public Integer getUniDorsal() {
		return this.uniDorsal;
	}

	public void setUniDorsal(Integer uniDorsal) {
		this.uniDorsal = uniDorsal;
	}

	public BigDecimal getUniPrecio() {
		return this.uniPrecio;
	}

	public void setUniPrecio(BigDecimal uniPrecio) {
		this.uniPrecio = uniPrecio;
	}

	public List<DetalleProforma> getDetalleProformas() {
		return this.detalleProformas;
	}

	public void setDetalleProformas(List<DetalleProforma> detalleProformas) {
		this.detalleProformas = detalleProformas;
	}

	public DetalleProforma addDetalleProforma(DetalleProforma detalleProforma) {
		getDetalleProformas().add(detalleProforma);
		detalleProforma.setUniformeDeportivo(this);

		return detalleProforma;
	}

	public DetalleProforma removeDetalleProforma(DetalleProforma detalleProforma) {
		getDetalleProformas().remove(detalleProforma);
		detalleProforma.setUniformeDeportivo(null);

		return detalleProforma;
	}

	public Talla getTalla() {
		return this.talla;
	}

	public void setTalla(Talla talla) {
		this.talla = talla;
	}

}