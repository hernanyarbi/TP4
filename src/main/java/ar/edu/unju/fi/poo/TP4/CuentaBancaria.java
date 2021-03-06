package ar.edu.unju.fi.poo.TP4;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 
 * @author AndreaBelen
 *
 */

public class CuentaBancaria implements Comparable<CuentaBancaria> {
	private String nrocuenta;
	private String cliente;
	private int dni;
	private Date fecha;
	private String eMail;
	private double saldo;

	public CuentaBancaria() {

	}

	public CuentaBancaria(String nrocuenta, String cliente, int dni, Date fecha, String eMail, double saldo) {
		super();
		this.nrocuenta = nrocuenta;
		this.cliente = cliente;
		this.dni = dni;
		this.fecha = fecha;
		this.eMail = eMail;
		this.saldo = saldo;
	}

	public String getNrocuenta() {
		return nrocuenta;
	}

	public void setNrocuenta(String nrocuenta) {
		this.nrocuenta = nrocuenta;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	/*
	 * metodo encargado de ordenar por DNI
	 */
	
	public int compareTo(CuentaBancaria cuenta) {
		if (dni < cuenta.dni)
			return -1;
		else if (dni > cuenta.dni)
			return 1;
		return 0;
	}
	
	/*
	 * metodo encargado de mostrar la infirmacion de la cuetnta
	 */
	
	public String info(){
		String datos = new String();
		int anios = antiguedad();
		datos = "Cuenta n°: " + this.nrocuenta + " - " + "Cliente: " + this.cliente + " - " + "Antiguedad: " + anios + " Años" + " - " + "Saldo: " + this.saldo ;
		return datos;
	}
	
	/*
	 * calculo de la antigüedad
	 */
	
	public int antiguedad(){
		Calendar fechahoy = new GregorianCalendar();
		return fechahoy.get(Calendar.YEAR) - (fecha.getYear() + 1900);
	}

}
