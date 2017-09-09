package ar.edu.unju.fi.poo.TP4;

import java.util.ArrayList;

import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

/**
 * Esta clase permite agregar ,validar y buscar cuentas bancarias.
 * 
 * @author joel
 *
 */

public class Banco {
	private TreeMap<String, CuentaBancaria> cuentas;
	private List<CuentaBancaria> listadecuentas;

	public Banco() {

		cuentas = new TreeMap<String, CuentaBancaria>();

		listadecuentas = new ArrayList<CuentaBancaria>();

	}

	/*
	 * Agregar cuentas bancarias
	 */

	public String agregarCuenta(CuentaBancaria cuenta) {

		switch (validar(cuenta)) {
		case 0:
			cuentas.put(cuenta.getNrocuenta(), cuenta);
			listadecuentas.add(cuenta);
			Collections.sort(listadecuentas);
			return "Agregado correctamente";

		case 1:

			return "DNI repetido";

		case 2:

			return "Email repetido";

		case 3:

			return "Nro de cuenta repetida";

		default:
			return null;
		}

	}

	/*
	 * varificar que no se repitan las cuentas bancarias.
	 */

	public int validar(CuentaBancaria cuenta) {

		int i = 0;

		for (CuentaBancaria c : cuentas.values()) {
			if (cuenta.getDni() == c.getDni())
				i = 1;
			else if (cuenta.geteMail() == c.geteMail())
				i = 2;
			else if (cuenta.getNrocuenta() == c.getNrocuenta())
				i = 3;

		}

		return i;

	}

	/*
	 * Busqueda por clave de la cuenta.
	 */

	public String buscarCuenta(String clave) {

		if (cuentas.containsKey(clave) == true) {
			CuentaBancaria c = getCuentas().get(clave);
			return (c.getCliente() + " " + c.getDni() + " " + c.geteMail());
		} else {
			return "no existe cuenta";
		}

	}

	/*
	 * Busqueda por dni de la cuenta
	 */

	public String buscarCuenta(int dni) {

		for (CuentaBancaria cuentaBancaria : listadecuentas) {

			if (cuentaBancaria.getDni() == dni) {
				return (cuentaBancaria.getCliente() + " " + cuentaBancaria.getDni() + " " + cuentaBancaria.geteMail());
			}

		}
		return null;

	}

	/*
	 * mostrar datos del cliente con el maximo valor de saldo.
	 */

	public CuentaBancaria buscarMayorSalario() {

		CuentaBancaria cuentaMaximoSaldo = new CuentaBancaria();
		double max = 0;
		for (int i = 0; i < listadecuentas.size(); i++) {

			if (i == 0) {
				max = listadecuentas.get(i).getSaldo();
				cuentaMaximoSaldo = listadecuentas.get(i);
			} else if (max < listadecuentas.get(i).getSaldo()) {
				max = listadecuentas.get(i).getSaldo();
				cuentaMaximoSaldo = listadecuentas.get(i);
			}

		}
		return cuentaMaximoSaldo;
	}

	public TreeMap<String, CuentaBancaria> getCuentas() {
		return cuentas;
	}

	public void setCuentas(TreeMap<String, CuentaBancaria> cuentas) {
		this.cuentas = cuentas;
	}

}
