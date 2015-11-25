package classes;

import java.util.TreeMap;
import java.util.Map;

public class Allergen {

	public TreeMap<Integer,String> listAllergen= new TreeMap<Integer,String>();

	
	public Allergen(){
		// añade todos los elementos al mapa //

		listAllergen.put(1,"Gluten");
		listAllergen.put(2, "Shellfish");
		listAllergen.put(3, "Eggs");
		listAllergen.put(4, "Fish");
		listAllergen.put(5, "Peanuts");
		listAllergen.put(6,"Soy");
		listAllergen.put(7, "Nuts");
		listAllergen.put(8, "Celery");
		listAllergen.put(9,"Mustard");
		listAllergen.put(10, "Sesame");
		listAllergen.put(11,"Sulphites");
		listAllergen.put(12, "Mollusk");
		listAllergen.put(13, "Lupin");

	}
	

	/*
	 * Getters y setters 
	 */


	public TreeMap<Integer, String> getListAllergen() {
		return listAllergen;
	}


	public void setListAllergen(TreeMap<Integer, String> listAllergen) {
		this.listAllergen = listAllergen;
	}

	
	/*
	 * Metodo que retorna el tamaño del mapa alergénicos
	 */
	public int tamany() {
		return this.getListAllergen().size();
	}


	/*
	 * Añadir un elemento a parte en el mapa 
	 */
	public void AddElement(int code, String name){
		this.listAllergen.put(code, name);
	}

	/*
	 * Sacar un elemento por el codigo 
	 */
	public Object getElement(int code){
		for (Map.Entry<Integer, String> entry : listAllergen.entrySet()) {
			if (entry.getKey() == code) {
				return entry;
			}
		}
		return null;
	}

	/*
	 * Sacar un elemento por el nombre 
	 */
	public Object getElement(String name){
		for (Map.Entry<Integer, String> entry : listAllergen.entrySet()) {
			if (entry.getValue().equals(name)) {
				return entry;
			}
		}
		return null;
	}
	
	/*
	 * Imprime un mapa
	 * 
	 */
	private static void imprimirMap(Map<Integer, String> a) {
		// TODO Auto-generated method stub
		for (Map.Entry<Integer,String> entry : a.entrySet()) {
			System.out.println(entry.getKey() + " => " + entry.getValue());
		}
	}

}
