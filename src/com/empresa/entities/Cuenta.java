package com.empresa.entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

import java.util.List;


/**
 * The persistent class for the cuenta database table.
 * 
 */
@Entity
@XmlRootElement
@NamedQueries({
	@NamedQuery(name="Cuenta.findAll", query="SELECT c FROM Cuenta c"),
	@NamedQuery(name="cuentas.byCliente", query="SELECT c FROM Cuenta c WHERE c.cliente.idCliente =:idCliente")
})
public class Cuenta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_cuenta")
	private int idCuenta;

	private String numerocuenta;

	private float saldo;

	private float totalAbonos;

	private float totalCargos;

	//bi-directional many-to-one association to Cuentatipo
	@ManyToOne
	@JoinColumn(name="id_cuentatipo")
	private Cuentatipo cuentatipo;
	
	@ManyToOne
	@JoinColumn(name="id_cliente")
	private Cliente cliente;

	//bi-directional many-to-one association to Transaccion
	@OneToMany(mappedBy="cuenta", cascade=CascadeType.PERSIST)
	private List<Transaccion> transaccions;

	public Cuenta() {
	}

	public int getIdCuenta() {
		return this.idCuenta;
	}

	public void setIdCuenta(int idCuenta) {
		this.idCuenta = idCuenta;
	}

	public String getNumerocuenta() {
		return this.numerocuenta;
	}

	public void setNumerocuenta(String numerocuenta) {
		this.numerocuenta = numerocuenta;
	}

	public float getSaldo() {
		return this.saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	public float getTotalAbonos() {
		return this.totalAbonos;
	}

	public void setTotalAbonos(float totalAbonos) {
		this.totalAbonos = totalAbonos;
	}

	public float getTotalCargos() {
		return this.totalCargos;
	}

	public void setTotalCargos(float totalCargos) {
		this.totalCargos = totalCargos;
	}

	public Cuentatipo getCuentatipo() {
		return this.cuentatipo;
	}

	public void setCuentatipo(Cuentatipo cuentatipo) {
		this.cuentatipo = cuentatipo;
	}

	public List<Transaccion> getTransaccions() {
		return this.transaccions;
	}

	public void setTransaccions(List<Transaccion> transaccions) {
		this.transaccions = transaccions;
	}

	public Transaccion addTransaccion(Transaccion transaccion) {
		getTransaccions().add(transaccion);
		transaccion.setCuenta(this);

		return transaccion;
	}

	public Transaccion removeTransaccion(Transaccion transaccion) {
		getTransaccions().remove(transaccion);
		transaccion.setCuenta(null);

		return transaccion;
	}

}