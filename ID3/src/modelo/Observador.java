package modelo;

import java.util.ArrayList;

public interface Observador {

	void resultado(String res);

	void muestraTabla(ArrayList<String> attr2, ArrayList<ArrayList<String>> facts2);

	

}
