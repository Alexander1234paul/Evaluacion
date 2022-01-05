package evaluacion.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the talla database table.
 * 
 */
@Entity
@NamedQuery(name="Talla.findAll", query="SELECT t FROM Talla t")
public class Talla implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_talla")
	private String idTalla;

	@Column(name="talla_nombre")
	private String tallaNombre;

	//bi-directional many-to-one association to UniformeDeportivo
	@OneToMany(mappedBy="talla")
	private List<UniformeDeportivo> uniformeDeportivos;

	public Talla() {
	}

	public String getIdTalla() {
		return this.idTalla;
	}

	public void setIdTalla(String idTalla) {
		this.idTalla = idTalla;
	}

	public String getTallaNombre() {
		return this.tallaNombre;
	}

	public void setTallaNombre(String tallaNombre) {
		this.tallaNombre = tallaNombre;
	}

	public List<UniformeDeportivo> getUniformeDeportivos() {
		return this.uniformeDeportivos;
	}

	public void setUniformeDeportivos(List<UniformeDeportivo> uniformeDeportivos) {
		this.uniformeDeportivos = uniformeDeportivos;
	}

	public UniformeDeportivo addUniformeDeportivo(UniformeDeportivo uniformeDeportivo) {
		getUniformeDeportivos().add(uniformeDeportivo);
		uniformeDeportivo.setTalla(this);

		return uniformeDeportivo;
	}

	public UniformeDeportivo removeUniformeDeportivo(UniformeDeportivo uniformeDeportivo) {
		getUniformeDeportivos().remove(uniformeDeportivo);
		uniformeDeportivo.setTalla(null);

		return uniformeDeportivo;
	}

}