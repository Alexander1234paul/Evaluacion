package evaluacion.model.managers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import evaluacion.model.entities.*;

/**
 * Session Bean implementation class ManagerCliente
 */
@Stateless
@LocalBean
public class ManagerCliente {
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public ManagerCliente() {
		// TODO Auto-generated constructor stub
	}

	public List<Cliente> findAllClientes() {
		return entityManager.createNamedQuery("Cliente.findAll", Cliente.class).getResultList();
	}

	public List<Genero> findAllGeneros() {
		return entityManager.createNamedQuery("Genero.findAll", Genero.class).getResultList();
	}

	public List<Persona> findAllPersonas() {
		return entityManager.createNamedQuery("Persona.findAll", Persona.class).getResultList();
	}

	public List<UniformeDeportivo> findAllUniformesDeportivos() {
		return entityManager.createNamedQuery("UniformeDeportivo.findAll", UniformeDeportivo.class).getResultList();
	}

	public List<Talla> findAllTallas() {
		return entityManager.createNamedQuery("Talla.findAll", Talla.class).getResultList();
	}

	public List<Proforma> findAllProformas() {
		return entityManager.createNamedQuery("Proforma.findAll", Proforma.class).getResultList();
	}

	public List<DetalleProforma> findAllDetalleProformas() {
		return entityManager.createNamedQuery("DetalleProforma.findAll", DetalleProforma.class).getResultList();
	}

	public List<OrdenProduccion> findAllOrdenProduccion() {
		return entityManager.createNamedQuery("OrdenProduccion.findAll", OrdenProduccion.class).getResultList();
	}

	public List<EntregaFinal> findAllEntregaFinal() {
		return entityManager.createNamedQuery("EntregaFinal.findAll", EntregaFinal.class).getResultList();
	}

	public List<Vendedor> findAllVendedores() {
		return entityManager.createNamedQuery("Vendedor.findAll", Vendedor.class).getResultList();
	}

	public List<Gerente> findAllGerentes() {
		return entityManager.createNamedQuery("Gerente.findAll", Gerente.class).getResultList();
	}

	
	public List<UniformeDeportivo> findUniformesDeportivosByTalla(String idTalla) {
		Query query = entityManager
				.createQuery("select ud from UniformeDeportivo ud where ud.talla.idTalla=:idTalla", UniformeDeportivo.class);
		query.setParameter("idTalla", idTalla);
		return query.getResultList();
	}
	
	public List<Proforma> findProformaByCliente(int idCliente) {
		Query query = entityManager
				.createQuery("select ud from Proforma ud where ud.cliente.idCliente=:idCliente", Proforma.class);
		query.setParameter("idCliente", idCliente);
		return query.getResultList();
	}
	

	public Persona registrarPersona(Persona persona, String idGenero) throws Exception {
		if (entityManager.find(Persona.class, persona.getIdPersona()) == null) {
			Genero genero = entityManager.find(Genero.class, idGenero);
			persona.setGenero(genero);
			System.out.print("Hola: " + persona.getPerApellidos() + " " + persona.getGenero().getIdGenero());
			entityManager.persist(persona);
			return persona;
		} else {
			throw new Exception("Persona ya registrada anteriormente!");
		}
	}

	public Cliente registrarCliente(Persona persona, String telefono) {
		Cliente cliente = new Cliente();
		cliente.setPersona(persona);
		cliente.setCliTelefono(telefono);
		cliente.setCliFechaRegistro(new Date());
		entityManager.persist(cliente);
		return cliente;
	}
	
	
	public Proforma agregarUniformeDeportivo(Proforma proforma, Cliente cliente,int id_uniforme, int cantidad){
		if (proforma == null) {
			proforma = new Proforma();
			proforma.setDetalleProformas(new ArrayList<DetalleProforma>());
			proforma.setCliente(cliente);
			proforma.setProfCantidad(0);
			proforma.setProfValorIva(new BigDecimal(0));
			proforma.setProfFechaEmision(new Date());
			proforma.setProfAbono(new BigDecimal(0));
			proforma.setProfSaldo(new BigDecimal(0));
			proforma.setProfValorTotal(new BigDecimal(0));
			proforma.setProfCancelado(false);
			proforma.setProfEntregado(false);
			proforma.setProfFechaEntrega(null);
		}
		UniformeDeportivo uniformeDeportivo=entityManager.find(UniformeDeportivo.class, id_uniforme);
		DetalleProforma detalle = new DetalleProforma();
		proforma.setProfCantidad(cantidad);
		detalle.setUniformeDeportivo(uniformeDeportivo);
		detalle.setProforma(proforma);
		detalle.setDetCantidad(cantidad);
		detalle.setDetProfPrecioUnitario(new BigDecimal(uniformeDeportivo.getUniPrecio().doubleValue()));
		detalle.setDetProfPrecioTotal(new BigDecimal(uniformeDeportivo.getUniPrecio().doubleValue()*cantidad));
		proforma.setProfValorTotal(proforma.getProfValorTotal().add(detalle.getDetProfPrecioTotal()));
		proforma.getDetalleProformas().add(detalle);
		return proforma;
	}
	
	

	public void registrarProforma(Proforma proforma) {
		if (proforma == null || proforma.getDetalleProformas() == null
				|| proforma.getDetalleProformas().size() == 0) {
		}
		proforma.setProfValorTotal(new BigDecimal(0));
		entityManager.persist(proforma);
	}
	
	public Proforma agregarProforma(Proforma proforma) {
		entityManager.persist(proforma);
		return proforma;
	}
	
	public DetalleProforma agregarDetalleProforma(DetalleProforma detalleProforma) {
		entityManager.persist(detalleProforma);
		return detalleProforma;
	}

	
	

}
