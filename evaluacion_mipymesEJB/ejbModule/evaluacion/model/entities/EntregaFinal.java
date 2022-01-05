package evaluacion.model.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the entrega_final database table.
 * 
 */
@Entity
@Table(name="entrega_final")
@NamedQuery(name="EntregaFinal.findAll", query="SELECT e FROM EntregaFinal e")
public class EntregaFinal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_entrega")
	private Integer idEntrega;

	@Column(name="ent_descripcion")
	private String entDescripcion;

	@Column(name="ent_verificacion")
	private Boolean entVerificacion;

	//bi-directional many-to-one association to OrdenProduccion
	@ManyToOne
	@JoinColumn(name="ent_orden_produccion")
	private OrdenProduccion ordenProduccion;

	//bi-directional many-to-one association to Proforma
	@ManyToOne
	@JoinColumn(name="ent_proforma")
	private Proforma proforma;

	public EntregaFinal() {
	}

	public Integer getIdEntrega() {
		return this.idEntrega;
	}

	public void setIdEntrega(Integer idEntrega) {
		this.idEntrega = idEntrega;
	}

	public String getEntDescripcion() {
		return this.entDescripcion;
	}

	public void setEntDescripcion(String entDescripcion) {
		this.entDescripcion = entDescripcion;
	}

	public Boolean getEntVerificacion() {
		return this.entVerificacion;
	}

	public void setEntVerificacion(Boolean entVerificacion) {
		this.entVerificacion = entVerificacion;
	}

	public OrdenProduccion getOrdenProduccion() {
		return this.ordenProduccion;
	}

	public void setOrdenProduccion(OrdenProduccion ordenProduccion) {
		this.ordenProduccion = ordenProduccion;
	}

	public Proforma getProforma() {
		return this.proforma;
	}

	public void setProforma(Proforma proforma) {
		this.proforma = proforma;
	}

}