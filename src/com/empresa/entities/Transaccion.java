package com.empresa.entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

import java.util.Date;


/**
 * The persistent class for the transaccion database table.
 * 
 */
@Entity
@XmlRootElement
@NamedQueries({
	@NamedQuery(name="Transaccion.findAll", query="SELECT t FROM Transaccion t"),
	@NamedQuery(name="transacciones.byCuenta", query="SELECT t FROM Transaccion t WHERE t.cuenta.idCuenta =:idCuenta")
})
public class Transaccion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_transaccion")
	private int idTransaccion;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	private float montoabono;

	private float montocargo;

	//bi-directional many-to-one association to Cuenta
	@ManyToOne
	@JoinColumn(name="id_cuenta")
	private Cuenta cuenta;

	public Transaccion() {
	}

	public int getIdTransaccion() {
		return this.idTransaccion;
	}

	public void setIdTransaccion(int idTransaccion) {
		this.idTransaccion = idTransaccion;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public float getMontoabono() {
		return this.montoabono;
	}

	public void setMontoabono(float montoabono) {
		this.montoabono = montoabono;
	}

	public float getMontocargo() {
		return this.montocargo;
	}

	public void setMontocargo(float montocargo) {
		this.montocargo = montocargo;
	}

	public Cuenta getCuenta() {
		return this.cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

}