package main;
import java.io.IOException;
import controlador.Controlador;
import modelo.Modelo;
import vista.Vista;


public class Main {
	
	private static void iniciaModoEstandar() throws IOException {
	
		Modelo modelo = new Modelo();
		Controlador ctrl = new Controlador(modelo);
		Vista vista= new Vista(ctrl);	
		vista.run();
		System.out.println("Done!");

	}

	public static void main(String[] args) throws IOException{
		startGame();			
	}
	
	private static void startGame() throws IOException{
		// TODO Auto-generated method stub
		Main.iniciaModoEstandar();
		
	}
	

	
	

}
