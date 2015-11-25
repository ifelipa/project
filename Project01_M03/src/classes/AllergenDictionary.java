package classes;

import java.util.TreeMap;
import java.util.ArrayList;
import java.util.Map;

public class AllergenDictionary {

	public ArrayList<Allergen> listAllergen= new ArrayList<Allergen>();

	
	public AllergenDictionary() {
		super();
		this.listAllergen.add(new Allergen (1, "Gluten"));
		this.listAllergen.add(new Allergen (2, "Shellfish"));
		this.listAllergen.add(new Allergen (3, "Eggs"));
		this.listAllergen.add(new Allergen (4, "Fish"));
		this.listAllergen.add(new Allergen (5, "Peanuts"));
		this.listAllergen.add(new Allergen (6, "Soy"));
		this.listAllergen.add(new Allergen (7, "Nuts"));
		this.listAllergen.add(new Allergen (8, "Celery"));
		this.listAllergen.add(new Allergen (9,"Mustard"));
		this.listAllergen.add(new Allergen (10, "Sesame"));
		this.listAllergen.add(new Allergen (11,"Sulphites"));
		this.listAllergen.add(new Allergen (12, "Mollusk"));
		this.listAllergen.add(new Allergen (13, "Lupin"));
	}
	

	/*
	 * Getters y setters 
	 */


	public ArrayList<Allergen> getListAllergen() {
		return listAllergen;
	}


	public void setListAllergen(ArrayList<Allergen> listAllergen) {
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
	public Boolean AddElement(Allergen allergen){
		return this.listAllergen.add(allergen);
	}

	/*
	 * Sacar un elemento por el codigo 
	 */
	public String getElement(int code){
		for (Allergen a : this.listAllergen) {
			if (a.codeAl == code) {
				return a.name;
			}
		}
		return null;
	}

	/*
	 * Sacar un elemento por el nombre 
	 */
//	public Object getElement(String name){
//		for (Map.Entry<Integer, String> entry : listAllergen.entrySet()) {
//			if (entry.getValue().equals(name)) {
//				return entry;
//			}
//		}
//		return null;
//	}
	
	/*
	 * Imprime un mapa
	 * 
	 */
//	private static void imprimirMap(Map<Integer, String> a) {
//		// TODO Auto-generated method stub
//		for (Map.Entry<Integer,String> entry : a.entrySet()) {
//			System.out.println(entry.getKey() + " => " + entry.getValue());
//		}
//	}

}
