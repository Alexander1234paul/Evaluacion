package evaluacion.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the gerente database table.
 * 
 */
@Entity
@NamedQuery(name="Gerente.findAll", query="SELECT g FROM Gerente g")
public class Gerente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_gerente")
	private Integer idGerente;

	@Temporal(TemporalType.DATE)
	@Column(name="ger_fecha_registro")
	private Date gerFechaRegistro;

	@Column(name="ger_telefono")
	private String gerTelefono;

	//bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name="ger_persona")
	private Persona persona;

	//bi-directional many-to-one association to OrdenProduccion
	@OneToMany(mappedBy="gerente")
	private List<OrdenProduccion> ordenProduccions;

	public Gerente() {
	}

	public Integer getIdGerente() {
		return this.idGerente;
	}

	public void setIdGerente(Integer idGerente) {
		this.idGerente = idGerente;
	}

	public Date getGerFechaRegistro() {
		return this.gerFechaRegistro;
	}

	public void setGerFechaRegistro(Date gerFechaRegistro) {
		this.gerFechaRegistro = gerFechaRegistro;
	}

	public String getGerTelefono() {
		return this.gerTelefono;
	}

	public void setGerTelefono(String gerTelefono) {
		this.gerTelefono = gerTelefono;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public List<OrdenProduccion> getOrdenProduccions() {
		return this.ordenProduccions;
	}

	public void setOrdenProduccions(List<OrdenProduccion> ordenProduccions) {
		this.ordenProduccions = ordenProduccions;
	}

	public OrdenProduccion addOrdenProduccion(OrdenProduccion ordenProduccion) {
		getOrdenProduccions().add(ordenProduccion);
		ordenProduccion.setGerente(this);

		return ordenProduccion;
	}

	public OrdenProduccion removeOrdenProduccion(OrdenProduccion ordenProduccion) {
		getOrdenProduccions().remove(ordenProduccion);
		ordenProduccion.setGerente(null);

		return ordenProduccion;
	}

}