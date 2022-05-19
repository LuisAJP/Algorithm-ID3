package vista;

import java.util.ArrayList;
import java.util.Scanner;

import controlador.Controlador;
import modelo.Observador;

public class Vista implements Observador{
	private Controlador controlador;

	private static Scanner scanner;

	public Vista(Controlador ctrl) {
		// TODO Auto-generated constructor stub
	
		this.controlador=ctrl;
		this.controlador.addObserver(this);
		scanner = new Scanner(System.in);
	}

	public void run() {
		// TODO Auto-generated method stub
		System.out.print("Introducir nombre del fichero para los atributos>  ");
		String f1 = scanner.nextLine();
		System.out.print("Introducir nombre del fichero para los datos del juego>  ");
		String f2 = scanner.nextLine();
		System.out.print("Introducir numero de filas del tablero>  ");
		String fil = scanner.nextLine();
		int filas= Integer.parseInt(fil);
		controlador.cargaDatos(f1,f2,filas);
		controlador.ejecuta();
		System.out.println();
	}

	@Override
	public void resultado(String res) {
		// TODO Auto-generated method stub
		System.out.println(res);
		
	}

	@Override
	public void muestraTabla(ArrayList<String> attr2, ArrayList<ArrayList<String>> facts2) {
		// TODO Auto-generated method stub
		System.out.println("------------------------------------------TABLA------------------------------------------------------\n");
		System.out.println(attr2);
		for(ArrayList<String> a:facts2)
			System.out.println(a);
		System.out.println("");
		System.out.println("-----------------------------------------------------------------------------------------------------\n");
		
	}
	
	
	

}
