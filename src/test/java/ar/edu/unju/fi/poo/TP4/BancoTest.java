package ar.edu.unju.fi.poo.TP4;

import java.util.Date;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import junit.framework.TestCase;

/**
 * 
 * @author Hernan Yarbi
 *
 */

@RunWith(JUnit4.class)
public class BancoTest extends TestCase {
	Banco banco;
	
	
	@Before
	public void init(){
		banco = new Banco();
		banco.agregarCuenta( new CuentaBancaria("B-001","Simon Dice", 3677963 ,new Date(),"Smd@",2000));
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
	
	@Test
	public void validar() {
		
		assertEquals(banco.validar(new CuentaBancaria("B-001","Simon Dice",3675683,null,null,2000)), 3);
		assertEquals(banco.validar(new CuentaBancaria("A-001","Simon Dice",3677963,null,null,2000)), 1);
		assertEquals(banco.validar(new CuentaBancaria("A-001","Simon Dice",3675683,null,"Smd@",2000)), 2);
		
	}
	
	@Test
	public void buscarCuenta() {
		
		//busqueda por clave
		assertEquals(banco.buscarCuenta("B-001"), "Cuenta n°: B-001 - Cliente: Simon Dice - Antiguedad: 0 Años - Saldo: 2000.0" );
		assertEquals(banco.buscarCuenta("B-002"), "no existe cuenta");
		//busqueda por dni
		assertEquals(banco.buscarCuenta(3677963), "Cuenta n°: B-001 - Cliente: Simon Dice - Antiguedad: 0 Años - Saldo: 2000.0");
		assertNull(banco.buscarCuenta(3677777));
		
	}
	
	@Test
	public void buscarMayorSalario() {
		assertNotNull(banco.buscarMayorSalario());
	}

}
