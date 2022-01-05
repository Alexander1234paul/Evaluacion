package evaluacion.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the genero database table.
 * 
 */
@Entity
@NamedQuery(name="Genero.findAll", query="SELECT g FROM Genero g")
public class Genero implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_genero")
	private String idGenero;

	@Column(name="gen_nombre")
	private String genNombre;

	//bi-directional many-to-one association to Persona
	@OneToMany(mappedBy="genero")
	private List<Persona> personas;

	public Genero() {
	}

	public String getIdGenero() {
		return this.idGenero;
	}

	public void setIdGenero(String idGenero) {
		this.idGenero = idGenero;
	}

	public String getGenNombre() {
		return this.genNombre;
	}

	public void setGenNombre(String genNombre) {
		this.genNombre = genNombre;
	}

	public List<Persona> getPersonas() {
		return this.personas;
	}

	public void setPersonas(List<Persona> personas) {
		this.personas = personas;
	}

	public Persona addPersona(Persona persona) {
		getPersonas().add(persona);
		persona.setGenero(this);

		return persona;
	}

	public Persona removePersona(Persona persona) {
		getPersonas().remove(persona);
		persona.setGenero(null);

		return persona;
	}

}