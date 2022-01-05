package evaluacion.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the cliente database table.
 * 
 */
@Entity
@NamedQuery(name="Cliente.findAll", query="SELECT c FROM Cliente c")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_cliente")
	private Integer idCliente;

	@Temporal(TemporalType.DATE)
	@Column(name="cli_fecha_registro")
	private Date cliFechaRegistro;

	@Column(name="cli_telefono")
	private String cliTelefono;

	//bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name="cli_persona")
	private Persona persona;

	//bi-directional many-to-one association to Proforma
	@OneToMany(mappedBy="cliente")
	private List<Proforma> proformas;

	public Cliente() {
	}

	public Integer getIdCliente() {
		return this.idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public Date getCliFechaRegistro() {
		return this.cliFechaRegistro;
	}

	public void setCliFechaRegistro(Date cliFechaRegistro) {
		this.cliFechaRegistro = cliFechaRegistro;
	}

	public String getCliTelefono() {
		return this.cliTelefono;
	}

	public void setCliTelefono(String cliTelefono) {
		this.cliTelefono = cliTelefono;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public List<Proforma> getProformas() {
		return this.proformas;
	}

	public void setProformas(List<Proforma> proformas) {
		this.proformas = proformas;
	}

	public Proforma addProforma(Proforma proforma) {
		getProformas().add(proforma);
		proforma.setCliente(this);

		return proforma;
	}

	public Proforma removeProforma(Proforma proforma) {
		getProformas().remove(proforma);
		proforma.setCliente(null);

		return proforma;
	}

}