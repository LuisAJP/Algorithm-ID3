package controlador;





import modelo.Modelo;
import modelo.Observador;


public class Controlador {
	private Modelo modelo;
	
	
	
	public Controlador(Modelo modelo) {
		// TODO Auto-generated constructor stub
		this.modelo=modelo;
	}

	public void cargaDatos(String f1, String f2,int f) {
		modelo.cargaDatos(f1,f2,f);
	}

	public void ejecuta() {
		// TODO Auto-generated method stub
		modelo.ejecuta();
		
	}
	
	
	public  void addObserver(Observador  o) {
		// TODO Auto-generated method stub
		modelo.addObserver(o);
		
	}

}
