package classes;

import java.util.TreeMap;
import java.util.Map;

public class Allergen {

	public TreeMap<Integer,String> ingredients= new TreeMap<Integer,String>();
	private int code;
	private String name;
	
	public Allergen(){
		// añade todos los elementos al mapa //
		AddElements(ingredients);
	}

	/*
	 * Getters y setters 
	 */
	
	public TreeMap<Integer, String> getIngredients() {
		return ingredients;
	}

	public void setIngredients(TreeMap<Integer, String> ingredients) {
		this.ingredients = ingredients;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	/*
	 * Metodo que añade elementos iniciales al mapa ya en el constructor 
	 */
	public void AddElements(TreeMap<Integer,String> a){
		a.put(1,"Gluten");
		a.put(2, "Shellfish");
		a.put(3, "Eggs");
		a.put(4, "Fish");
		a.put(5, "Peanuts");
		a.put(6,"Soy");
		a.put(7, "Nuts");
		a.put(8, "Celery");
		a.put(9,"Mustard");
		a.put(10, "Sesame");
		a.put(11,"Sulphites");
		a.put(12, "Mollusk");
		a.put(13, "Lupin");
	}

	/*
	 * Metodo que retorna el tamaño del mapa alergénicos
	 */
	public int tamany() {
		return this.getIngredients().size();
	}

	/*
	 * Añadir un elemento a parte en el mapa 
	 */
	public void AddElement(int code, String name){
		this.getIngredients().put(code, name);
	}

	/*
	 * Sacar un elemento por el codigo 
	 */
	public Object getElement(int code){
		for (Map.Entry<Integer, String> entry : ingredients.entrySet()) {
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
		for (Map.Entry<Integer, String> entry : ingredients.entrySet()) {
			if (entry.getValue() == name) {
				return entry;
			}
		}
		return null;
	}
	
	/*
	 * Imprime un mapa
	 */
	private static void imprimirMap(Map<Integer, String> a) {
		// TODO Auto-generated method stub
		for (Map.Entry<Integer,String> entry : a.entrySet()) {
			System.out.println(entry.getKey() + " => " + entry.getValue());
		}
	}

}