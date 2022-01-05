package evaluacion.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the proforma database table.
 * 
 */
@Entity
@NamedQuery(name="Proforma.findAll", query="SELECT p FROM Proforma p")
public class Proforma implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_proforma")
	private Integer idProforma;

	@Column(name="prof_abono")
	private BigDecimal profAbono;

	@Column(name="prof_cancelado")
	private Boolean profCancelado;

	@Column(name="prof_cantidad")
	private Integer profCantidad;

	@Column(name="prof_entregado")
	private Boolean profEntregado;

	@Temporal(TemporalType.DATE)
	@Column(name="prof_fecha_emision")
	private Date profFechaEmision;

	@Temporal(TemporalType.DATE)
	@Column(name="prof_fecha_entrega")
	private Date profFechaEntrega;

	@Column(name="prof_saldo")
	private BigDecimal profSaldo;

	@Column(name="prof_valor_iva")
	private BigDecimal profValorIva;

	@Column(name="prof_valor_subtotal")
	private BigDecimal profValorSubtotal;

	@Column(name="prof_valor_total")
	private BigDecimal profValorTotal;

	//bi-directional many-to-one association to DetalleProforma
	@OneToMany(mappedBy="proforma", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<DetalleProforma> detalleProformas;

	//bi-directional many-to-one association to EntregaFinal
	@OneToMany(mappedBy="proforma")
	private List<EntregaFinal> entregaFinals;

	//bi-directional many-to-one association to OrdenProduccion
	@OneToMany(mappedBy="proforma")
	private List<OrdenProduccion> ordenProduccions;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="prof_cliente")
	private Cliente cliente;

	public Proforma() {
	}

	public Integer getIdProforma() {
		return this.idProforma;
	}

	public void setIdProforma(Integer idProforma) {
		this.idProforma = idProforma;
	}

	public BigDecimal getProfAbono() {
		return this.profAbono;
	}

	public void setProfAbono(BigDecimal profAbono) {
		this.profAbono = profAbono;
	}

	public Boolean getProfCancelado() {
		return this.profCancelado;
	}

	public void setProfCancelado(Boolean profCancelado) {
		this.profCancelado = profCancelado;
	}

	public Integer getProfCantidad() {
		return this.profCantidad;
	}

	public void setProfCantidad(Integer profCantidad) {
		this.profCantidad = profCantidad;
	}

	public Boolean getProfEntregado() {
		return this.profEntregado;
	}

	public void setProfEntregado(Boolean profEntregado) {
		this.profEntregado = profEntregado;
	}

	public Date getProfFechaEmision() {
		return this.profFechaEmision;
	}

	public void setProfFechaEmision(Date profFechaEmision) {
		this.profFechaEmision = profFechaEmision;
	}

	public Date getProfFechaEntrega() {
		return this.profFechaEntrega;
	}

	public void setProfFechaEntrega(Date profFechaEntrega) {
		this.profFechaEntrega = profFechaEntrega;
	}

	public BigDecimal getProfSaldo() {
		return this.profSaldo;
	}

	public void setProfSaldo(BigDecimal profSaldo) {
		this.profSaldo = profSaldo;
	}

	public BigDecimal getProfValorIva() {
		return this.profValorIva;
	}

	public void setProfValorIva(BigDecimal profValorIva) {
		this.profValorIva = profValorIva;
	}

	public BigDecimal getProfValorSubtotal() {
		return this.profValorSubtotal;
	}

	public void setProfValorSubtotal(BigDecimal profValorSubtotal) {
		this.profValorSubtotal = profValorSubtotal;
	}

	public BigDecimal getProfValorTotal() {
		return this.profValorTotal;
	}

	public void setProfValorTotal(BigDecimal profValorTotal) {
		this.profValorTotal = profValorTotal;
	}

	public List<DetalleProforma> getDetalleProformas() {
		return this.detalleProformas;
	}

	public void setDetalleProformas(List<DetalleProforma> detalleProformas) {
		this.detalleProformas = detalleProformas;
	}

	public DetalleProforma addDetalleProforma(DetalleProforma detalleProforma) {
		getDetalleProformas().add(detalleProforma);
		detalleProforma.setProforma(this);

		return detalleProforma;
	}

	public DetalleProforma removeDetalleProforma(DetalleProforma detalleProforma) {
		getDetalleProformas().remove(detalleProforma);
		detalleProforma.setProforma(null);

		return detalleProforma;
	}

	public List<EntregaFinal> getEntregaFinals() {
		return this.entregaFinals;
	}

	public void setEntregaFinals(List<EntregaFinal> entregaFinals) {
		this.entregaFinals = entregaFinals;
	}

	public EntregaFinal addEntregaFinal(EntregaFinal entregaFinal) {
		getEntregaFinals().add(entregaFinal);
		entregaFinal.setProforma(this);

		return entregaFinal;
	}

	public EntregaFinal removeEntregaFinal(EntregaFinal entregaFinal) {
		getEntregaFinals().remove(entregaFinal);
		entregaFinal.setProforma(null);

		return entregaFinal;
	}

	public List<OrdenProduccion> getOrdenProduccions() {
		return this.ordenProduccions;
	}

	public void setOrdenProduccions(List<OrdenProduccion> ordenProduccions) {
		this.ordenProduccions = ordenProduccions;
	}

	public OrdenProduccion addOrdenProduccion(OrdenProduccion ordenProduccion) {
		getOrdenProduccions().add(ordenProduccion);
		ordenProduccion.setProforma(this);

		return ordenProduccion;
	}

	public OrdenProduccion removeOrdenProduccion(OrdenProduccion ordenProduccion) {
		getOrdenProduccions().remove(ordenProduccion);
		ordenProduccion.setProforma(null);

		return ordenProduccion;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}