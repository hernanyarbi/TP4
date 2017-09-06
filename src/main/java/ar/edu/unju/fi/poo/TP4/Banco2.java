package ar.edu.unju.fi.poo.TP4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

public class Banco2 {
	private TreeMap<String,CuentaBancaria> cuentas;
	private List<CuentaBancaria> listadecuentas;

	
	
	public Banco2() {
		
		cuentas = new TreeMap<String, CuentaBancaria>();
		
		listadecuentas = new ArrayList<CuentaBancaria>();
		
	}
	
	
	
	
	
	public void agregarCuenta(CuentaBancaria cuenta){
			
		switch(validar(cuenta)){
		    case 0:cuentas.put(cuenta.getNrocuenta(), cuenta);
		    	   System.out.println("Agregado correctamente");
		    		break;
		    case 1:System.out.println("DNI repetido");
		    		break;
		    case 2:System.out.println("Email repetido");
		    		break;
		    case 3:System.out.println("Nro de cuenta repetida");
		    		break;
		   }

		listadecuentas.add(cuenta);

		Collections.sort(listadecuentas);
	
	}
	
	
	
	public void agregarArray(){
		
		
	}
	
	
	
	
	public void mostrar(){
		for(CuentaBancaria c : cuentas.values()){
			System.out.println(c.getNrocuenta());
		}
	}
	
	
	
	
	public int validar(CuentaBancaria cuenta){
	
	  int i=0; 
		
	  for(CuentaBancaria c :cuentas.values()){
		  if(cuenta.getDni()==c.getDni())
			     i = 1;
		  else if(cuenta.geteMail()==c.geteMail())
			     i = 2;
		  else if(cuenta.getNrocuenta()==c.getNrocuenta())
			     i = 3;
		   
	  }
	  
	  return i;
	  
 	}
	
	
	
	
	
	public void buscarCuenta(String clave){
		
		if(cuentas.containsKey(clave)==true){
	         
			 CuentaBancaria c = getCuentas().get(clave);
	         System.out.println(c.getCliente() + " "+ c.getDni()+" "+c.geteMail());
		
		}else{
			 
			 System.out.println("no existe cuenta");
		}
					
	}
	
	

	
	
	public TreeMap<String, CuentaBancaria> getCuentas() {
		return cuentas;
	}

	
	public void setCuentas(TreeMap<String, CuentaBancaria> cuentas) {
		this.cuentas = cuentas;
	}
	

}
