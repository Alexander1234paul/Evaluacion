package evaluacion.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import evaluacion.controllers.util.JSFUtil;
import evaluacion.model.entities.*;
import evaluacion.model.managers.ManagerCliente;

@Named
@SessionScoped
public class BeanCliente implements Serializable {
	private static final long serialVersionUID = 1L;
	@EJB
	private ManagerCliente managerCliente;
	private Genero genero;
	private Persona persona;
	private Persona pers_cliente;
	private Cliente cliente;
	private String idGenero;
	private Proforma proforma;
	private DetalleProforma detalleProforma;
	private int cantidad;
	private int id_uniforme;
	private List<Genero> listaGeneros;
	private List<Persona> listaPersonas;
	private List<Cliente> listaClientes;
	private List<Talla> listaTallas;
	private List<UniformeDeportivo> listaUniformes;
	private List<Gerente> listGerentes;
	private List<Vendedor> listaVendedores;
	private List<DetalleProforma> listaDetalleProformas;
	private List<EntregaFinal> listaEntregaFinals;
	private List<Proforma> listaProformas;
	private List<UniformeDeportivo> listaUniformesByTalla;
	private String idTalla;

	private String telefono;
	private Date fecha_registro;
	
	private List<Proforma> listaProformaCliente;

	public BeanCliente() {
		// TODO Auto-generated constructor stub
	}

	@PostConstruct
	public void Inicializar() {
		persona = new Persona();
		cliente = new Cliente();
		listaClientes = managerCliente.findAllClientes();
		listaGeneros = managerCliente.findAllGeneros();
		listaPersonas = managerCliente.findAllPersonas();
		listaTallas = managerCliente.findAllTallas();
		listaUniformes = managerCliente.findAllUniformesDeportivos();
		listaDetalleProformas = managerCliente.findAllDetalleProformas();
		listaProformas = managerCliente.findAllProformas();
		listaVendedores = managerCliente.findAllVendedores();
		listGerentes = managerCliente.findAllGerentes();
		listaEntregaFinals = managerCliente.findAllEntregaFinal();
	}

	public String actionRegistrarPersona() {
		String resp = "";
		try {
			pers_cliente = managerCliente.registrarPersona(persona, idGenero);
			if (pers_cliente != null) {
				listaPersonas = managerCliente.findAllPersonas();
				JSFUtil.crearMensajeInfo("Persona registrado con exito!");
				System.out.print("Hola: " + persona.getPerApellidos() + " " + persona.getGenero().getIdGenero());
				resp = "registro_cliente";
			} else {
				JSFUtil.crearMensajeError("Error al registrar persona!");
				resp = "";
			}
		} catch (Exception e) {
			// TODO: handle exception
			JSFUtil.crearMensajeError(e.getMessage());
			e.printStackTrace();
		}
		JSFUtil.crearMensajeWarning("hOLA: " + resp);
		return resp;
	}

	public String actionRegistrarCliente() {
		String resp = "";
		cliente = managerCliente.registrarCliente(persona, telefono);
		if (cliente != null) {
			listaClientes = managerCliente.findAllClientes();
			resp = "/uniformes/index";
			JSFUtil.crearMensajeInfo("Cliente registrado con exito!");
		} else {
			JSFUtil.crearMensajeError("Error al registrar cliente!");
		}
		return resp;
	}

	public void actionListenerAgregarUniforme(int idUniforme) {
		id_uniforme=idUniforme;
		proforma = managerCliente.agregarUniformeDeportivo(proforma, cliente, idUniforme, cantidad);
		JSFUtil.crearMensajeWarning(idUniforme+" "+cantidad+" "+proforma.getCliente().getIdCliente());
	}

	public String actionRegistrarProforma() {
		try {
			managerCliente.registrarProforma(proforma);
			// listaInscripcionesEstudiante=managerInscripciones.findInsInscripcionCabByEstudiante(estudiante.getCedula());
			return "inscripciones";
		} catch (Exception e) {
			// TODO: handle exception
			JSFUtil.crearMensajeError(e.getMessage());
			e.printStackTrace();
			return "";
		}
	}

	public String actioRegistrarProforma() {
			managerCliente.registrarProforma(proforma);
			listaProformaCliente=managerCliente.findProformaByCliente(cliente.getIdCliente());
			JSFUtil.crearMensajeInfo("Proforma Generada con exito!");
			return "/proformas/proforma_cliente";
	}
	
	
	public void actionListenerSeleccionarTalla() {
		listaUniformesByTalla = managerCliente.findUniformesDeportivosByTalla(idTalla);
		
	}

	
	public String getIdTalla() {
		return idTalla;
	}

	public void setIdTalla(String idTalla) {
		this.idTalla = idTalla;
	}

	public String getTelefono() {
		return telefono;
	}

	public List<Proforma> getListaProformaCliente() {
		return listaProformaCliente;
	}
	public void setListaProformaCliente(List<Proforma> listaProformaCliente) {
		this.listaProformaCliente = listaProformaCliente;
	}
	
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Date getFecha_registro() {
		return fecha_registro;
	}

	public void setFecha_registro(Date fecha_registro) {
		this.fecha_registro = fecha_registro;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Genero> getListaGeneros() {
		return listaGeneros;
	}

	public void setListaGeneros(List<Genero> listaGeneros) {
		this.listaGeneros = listaGeneros;
	}

	public List<Persona> getListaPersonas() {
		return listaPersonas;
	}

	public void setListaPersonas(List<Persona> listaPersonas) {
		this.listaPersonas = listaPersonas;
	}

	public List<Cliente> getListaClientes() {
		return listaClientes;
	}

	public void setListaClientes(List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}

	public String getIdGenero() {
		return idGenero;
	}

	public void setIdGenero(String idGenero) {
		this.idGenero = idGenero;
	}

	public void setPers_cliente(Persona pers_cliente) {
		this.pers_cliente = pers_cliente;
	}

	public Persona getPers_cliente() {
		return pers_cliente;
	}

	public List<Talla> getListaTallas() {
		return listaTallas;
	}

	public void setListaTallas(List<Talla> listaTallas) {
		this.listaTallas = listaTallas;
	}

	public List<UniformeDeportivo> getListaUniformes() {
		return listaUniformes;
	}

	public void setListaUniformes(List<UniformeDeportivo> listaUniformes) {
		this.listaUniformes = listaUniformes;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<Gerente> getListGerentes() {
		return listGerentes;
	}

	public void setListGerentes(List<Gerente> listGerentes) {
		this.listGerentes = listGerentes;
	}

	public List<Vendedor> getListaVendedores() {
		return listaVendedores;
	}

	public void setListaVendedores(List<Vendedor> listaVendedores) {
		this.listaVendedores = listaVendedores;
	}

	public List<DetalleProforma> getListaDetalleProformas() {
		return listaDetalleProformas;
	}

	public void setListaDetalleProformas(List<DetalleProforma> listaDetalleProformas) {
		this.listaDetalleProformas = listaDetalleProformas;
	}

	public List<EntregaFinal> getListaEntregaFinals() {
		return listaEntregaFinals;
	}

	public void setListaEntregaFinals(List<EntregaFinal> listaEntregaFinals) {
		this.listaEntregaFinals = listaEntregaFinals;
	}

	public List<Proforma> getListaProformas() {
		return listaProformas;
	}

	public void setListaProformas(List<Proforma> listaProformas) {
		this.listaProformas = listaProformas;
	}

	public void setListaUniformesByTalla(List<UniformeDeportivo> listaUniformesByTalla) {
		this.listaUniformesByTalla = listaUniformesByTalla;
	}

	public List<UniformeDeportivo> getListaUniformesByTalla() {
		return listaUniformesByTalla;
	}

	public Proforma getProforma() {
		return proforma;
	}

	public void setProforma(Proforma proforma) {
		this.proforma = proforma;
	}

	public DetalleProforma getDetalleProforma() {
		return detalleProforma;
	}

	public void setDetalleProforma(DetalleProforma detalleProforma) {
		this.detalleProforma = detalleProforma;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getId_uniforme() {
		return id_uniforme;
	}

	public void setId_uniforme(int id_uniforme) {
		this.id_uniforme = id_uniforme;
	}

}
