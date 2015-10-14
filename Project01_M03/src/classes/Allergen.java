package classes;

import java.util.TreeMap;

import java.util.List;
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
	 * Metodo que añade elementos al mapa ya en el constructor 
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

}