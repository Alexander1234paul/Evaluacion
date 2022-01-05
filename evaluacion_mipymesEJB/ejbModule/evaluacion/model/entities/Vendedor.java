package evaluacion.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the vendedor database table.
 * 
 */
@Entity
@NamedQuery(name="Vendedor.findAll", query="SELECT v FROM Vendedor v")
public class Vendedor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_vendedor")
	private Integer idVendedor;

	@Temporal(TemporalType.DATE)
	@Column(name="vend_fecha_registro")
	private Date vendFechaRegistro;

	@Column(name="vend_telefono")
	private String vendTelefono;

	//bi-directional many-to-one association to OrdenProduccion
	@OneToMany(mappedBy="vendedor")
	private List<OrdenProduccion> ordenProduccions;

	//bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name="vend_persona")
	private Persona persona;

	public Vendedor() {
	}

	public Integer getIdVendedor() {
		return this.idVendedor;
	}

	public void setIdVendedor(Integer idVendedor) {
		this.idVendedor = idVendedor;
	}

	public Date getVendFechaRegistro() {
		return this.vendFechaRegistro;
	}

	public void setVendFechaRegistro(Date vendFechaRegistro) {
		this.vendFechaRegistro = vendFechaRegistro;
	}

	public String getVendTelefono() {
		return this.vendTelefono;
	}

	public void setVendTelefono(String vendTelefono) {
		this.vendTelefono = vendTelefono;
	}

	public List<OrdenProduccion> getOrdenProduccions() {
		return this.ordenProduccions;
	}

	public void setOrdenProduccions(List<OrdenProduccion> ordenProduccions) {
		this.ordenProduccions = ordenProduccions;
	}

	public OrdenProduccion addOrdenProduccion(OrdenProduccion ordenProduccion) {
		getOrdenProduccions().add(ordenProduccion);
		ordenProduccion.setVendedor(this);

		return ordenProduccion;
	}

	public OrdenProduccion removeOrdenProduccion(OrdenProduccion ordenProduccion) {
		getOrdenProduccions().remove(ordenProduccion);
		ordenProduccion.setVendedor(null);

		return ordenProduccion;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

}