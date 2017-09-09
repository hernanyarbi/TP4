package ar.edu.unju.fi.poo.TP4;

import java.util.ArrayList;
import java.util.List;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import junit.framework.TestCase;

/**
 * 
 * @author AndreaBelen
 *
 */

@RunWith(JUnit4.class)
public class CuentaBancariaTest extends TestCase {
	
	CuentaBancaria cuenta;
	List<CuentaBancaria> cuentas;
	@Before
	public void init() {
		cuenta = new CuentaBancaria("A-001", "Abel Santillan", 26446592, null, null, 0);
		cuentas = new ArrayList<CuentaBancaria>();
	}
	
	@After
	public void close() {
		cuenta = null;
		cuentas = null;
	}
	
	@Test
	public void compareTo() {
		
		cuentas.add(new CuentaBancaria(null, null, 26446592, null,null , 0));
		cuentas.add(new CuentaBancaria(null, null, 26446591, null,null , 0));
		cuentas.add(new CuentaBancaria(null, null, 26446593, null,null , 0));
		
		assertEquals(cuenta.compareTo(cuentas.get(0)), 0);
		assertEquals(cuenta.compareTo(cuentas.get(1)), 1);
		assertEquals(cuenta.compareTo(cuentas.get(2)), -1);
		
	}

}
