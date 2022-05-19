package modelo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;




public class Modelo {
	private ArrayList<Observador> observers;
	private ArrayList<ArrayList<String>> facts;
	private ArrayList<String> attr;
	private String interestAttribute;
	private ArbolDecision arbolDecision;

	public Modelo() {
		this.observers = new ArrayList<>();
	}
	
	public void cargaDatos(String f1, String f2,int f) {
		String line = null;
		try{
			BufferedReader bf1 = new BufferedReader(new FileReader(f1));
			BufferedReader bf2 = new BufferedReader(new FileReader(f2));
			 facts = new ArrayList<ArrayList<String>>();
			 attr = new ArrayList<String>();
			line = bf1.readLine();
			for(String s:line.split(" "))
				attr.add(s);
			
			//extraemos el atributo de intenres
			this.interestAttribute=attr.get(attr.size()-1);
			
			for(int i=0; i<f; i++){
				line = bf2.readLine();
				ArrayList<String> tmp = new ArrayList<String>();
				for(String s:line.split(","))
					tmp.add(s);	
				facts.add(tmp);
			}
			bf1.close();
			bf2.close();
			notificaTabla(attr,facts);
		}
		catch(Exception e){
			e.printStackTrace();
			
		}	
	}

	private void notificaTabla(ArrayList<String> attr2, ArrayList<ArrayList<String>> facts2) {
		// TODO Auto-generated method stub
		for (Observador ob : observers) 
			ob.muestraTabla(attr2,facts2);
		
	}

	public void ejecuta() {
		// TODO Auto-generated method stub
		 //Creo el objeto arbol de decision
        arbolDecision = new ArbolDecision();
        arbolDecision.setMatrizDatos(facts);
        arbolDecision.setCantAtributos(attr.size()-1);
        arbolDecision.setCantClases(2);
        arbolDecision.setNombreAtributos(attr);
        //Corro el algoritmo con el problema cargado
        arbolDecision.runArbolDecision();
        String cadena =arbolDecision.getProceso();
        notificaResultado(cadena);
        //System.out.println(cadena);
		
	}
	
	private void notificaResultado(String res) {
		for (Observador ob : observers) 
			ob.resultado(res);
	}
	
	
	public void addObserver(Observador o) {
		// TODO Auto-generated method stub
		observers.add(o);
		
	}

}
