package evaluacion.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the orden_produccion database table.
 * 
 */
@Entity
@Table(name="orden_produccion")
@NamedQuery(name="OrdenProduccion.findAll", query="SELECT o FROM OrdenProduccion o")
public class OrdenProduccion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_orden_produccion")
	private Integer idOrdenProduccion;

	@Column(name="ord_decripcion")
	private String ordDecripcion;

	@Column(name="ord_fallas_graves")
	private Boolean ordFallasGraves;

	@Column(name="ord_fallas_leves")
	private Boolean ordFallasLeves;

	@Temporal(TemporalType.DATE)
	@Column(name="ord_fecha_inicio")
	private Date ordFechaInicio;

	@Temporal(TemporalType.DATE)
	@Column(name="ord_fecha_limite")
	private Date ordFechaLimite;

	@Column(name="ord_finalizado")
	private Boolean ordFinalizado;

	//bi-directional many-to-one association to EntregaFinal
	@OneToMany(mappedBy="ordenProduccion")
	private List<EntregaFinal> entregaFinals;

	//bi-directional many-to-one association to Gerente
	@ManyToOne
	@JoinColumn(name="ord_gerente")
	private Gerente gerente;

	//bi-directional many-to-one association to Proforma
	@ManyToOne
	@JoinColumn(name="ord_proforma")
	private Proforma proforma;

	//bi-directional many-to-one association to Vendedor
	@ManyToOne
	@JoinColumn(name="ord_vendedor")
	private Vendedor vendedor;

	public OrdenProduccion() {
	}

	public Integer getIdOrdenProduccion() {
		return this.idOrdenProduccion;
	}

	public void setIdOrdenProduccion(Integer idOrdenProduccion) {
		this.idOrdenProduccion = idOrdenProduccion;
	}

	public String getOrdDecripcion() {
		return this.ordDecripcion;
	}

	public void setOrdDecripcion(String ordDecripcion) {
		this.ordDecripcion = ordDecripcion;
	}

	public Boolean getOrdFallasGraves() {
		return this.ordFallasGraves;
	}

	public void setOrdFallasGraves(Boolean ordFallasGraves) {
		this.ordFallasGraves = ordFallasGraves;
	}

	public Boolean getOrdFallasLeves() {
		return this.ordFallasLeves;
	}

	public void setOrdFallasLeves(Boolean ordFallasLeves) {
		this.ordFallasLeves = ordFallasLeves;
	}

	public Date getOrdFechaInicio() {
		return this.ordFechaInicio;
	}

	public void setOrdFechaInicio(Date ordFechaInicio) {
		this.ordFechaInicio = ordFechaInicio;
	}

	public Date getOrdFechaLimite() {
		return this.ordFechaLimite;
	}

	public void setOrdFechaLimite(Date ordFechaLimite) {
		this.ordFechaLimite = ordFechaLimite;
	}

	public Boolean getOrdFinalizado() {
		return this.ordFinalizado;
	}

	public void setOrdFinalizado(Boolean ordFinalizado) {
		this.ordFinalizado = ordFinalizado;
	}

	public List<EntregaFinal> getEntregaFinals() {
		return this.entregaFinals;
	}

	public void setEntregaFinals(List<EntregaFinal> entregaFinals) {
		this.entregaFinals = entregaFinals;
	}

	public EntregaFinal addEntregaFinal(EntregaFinal entregaFinal) {
		getEntregaFinals().add(entregaFinal);
		entregaFinal.setOrdenProduccion(this);

		return entregaFinal;
	}

	public EntregaFinal removeEntregaFinal(EntregaFinal entregaFinal) {
		getEntregaFinals().remove(entregaFinal);
		entregaFinal.setOrdenProduccion(null);

		return entregaFinal;
	}

	public Gerente getGerente() {
		return this.gerente;
	}

	public void setGerente(Gerente gerente) {
		this.gerente = gerente;
	}

	public Proforma getProforma() {
		return this.proforma;
	}

	public void setProforma(Proforma proforma) {
		this.proforma = proforma;
	}

	public Vendedor getVendedor() {
		return this.vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

}