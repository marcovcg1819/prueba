package com.empresa.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.empresa.entities.Cliente;
import com.empresa.entities.Cuenta;
import com.empresa.entities.Persona;
import com.empresa.entities.Transaccion;

public class CuentaDao {
	
	private Persona afiliadoSeleccionado;
	private List<Persona> afiliados;
	private Cuenta cuentaSeleccionada;
	private List<Cuenta> cuentas;
	private List<Transaccion> transacciones;
	
	public List<Persona> getClientes(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("cooperativa");
		EntityManager em = emf.createEntityManager();
		try {
			afiliados = new ArrayList<Persona>();
			afiliados = em.createNamedQuery("find.clientes").getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return afiliados;
	}
	
	public Persona getPersona(String numeroDocumento) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("cooperativa");
		EntityManager em = emf.createEntityManager();
			try {
				afiliadoSeleccionado = new Persona();
				afiliadoSeleccionado = (Persona) em.createNamedQuery("persona.byNumeroDocumento").setParameter("numeroDocumento", numeroDocumento).getSingleResult();
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				em.close();
				emf.close();
			}
			return afiliadoSeleccionado;
	}
	
	public List<Cuenta> getCuentas(Cliente cli){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("cooperativa");
		EntityManager em = emf.createEntityManager();
		try {
			cuentas = new ArrayList<Cuenta>();
			cuentas = em.createNamedQuery("cuentas.byCliente").setParameter("idCliente", cli.getIdCliente()).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cuentas;
	}
	
	public List<Transaccion> getTransacciones(Cuenta cuen){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("cooperativa");
		EntityManager em = emf.createEntityManager();
		try {
			transacciones = new ArrayList<Transaccion>();
			transacciones = em.createNamedQuery("transacciones.byCuenta").setParameter("idCuenta", cuen.getIdCuenta()).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return transacciones;
	}
		
}
