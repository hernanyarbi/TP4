package ar.edu.unju.fi.poo.TP4;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Prueba {

	public static void main(String[] args) throws ParseException {
		
		String fecha="13/02/1992";
		DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		Date date = formato.parse(fecha);
		
		Banco unbanco = new Banco();
		
		CuentaBancaria c = new CuentaBancaria("b","pepe",36756987,date,"joe",3000);
		unbanco.agregarCuenta(c);;
		CuentaBancaria c1 = new CuentaBancaria("a","pancho",36756983,date,"joe1",200);
		unbanco.agregarCuenta(c1);;
		CuentaBancaria c2 = new CuentaBancaria("c","pepo",36756981,date,"joe2",2000);
		unbanco.agregarCuenta(c2);
	
		unbanco.buscarCuenta("b");
		
		System.out.println(unbanco.buscarMayorSalario().getCliente());
		;
		
		
	
	}

}
