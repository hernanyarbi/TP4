package ar.edu.unju.fi.poo.TP4;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import junit.framework.TestCase;

@RunWith(JUnit4.class)
public class BancoTest extends TestCase {
	Banco banco;
	
	
	@Before
	public void init(){
		banco = new Banco();
	}
	
	@After
	public void close(){
		banco = null;
	}
	
	
	@Test
	public void testValidar() {
		
		CuentaBancaria cuenta1 = new CuentaBancaria("A-001","Simon Dice",3675683,null,"Smd@",2000);
		banco.agregarCuenta(cuenta1);
		CuentaBancaria cuenta2 = new CuentaBancaria("A-002","Modesto Rosado",3675682,null,"Mdr@",3200);
		
		assertEquals(banco.validar(cuenta2),0);
	
	}
	
	
	
	@Test
	public void testAgregarCuenta(){
		
		CuentaBancaria cuenta = new CuentaBancaria("A-001","Simon Dice",3675683,null,"Smd@",2000);
		banco.agregarCuenta(cuenta);
		
		assertTrue(banco.getCuentas().size()==1);
		
	}

}
