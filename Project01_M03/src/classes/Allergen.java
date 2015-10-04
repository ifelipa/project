package classes;

import java.util.ArrayList;
import java.util.List;

public class Allergen {
	// the code is the index of the arrayList //
	List<String> allergens;
	String [] alergico = { "Gluten", "shellfish", "eggs","fish", "peanuts", "soy", "dairy",
			"nuts", "celery", "mustard","sesame", "sulphites", "mollusk", "lupin"};

	
	public Allergen(){
		allergens = new ArrayList<String>();
		for (String string : alergico) {
			allergens.add(string);
		}	
	}
	
	/*
	 * Metodo que retorna el codigo  
	 */
	public int returnCode(String element){
		return(allergens.contains(element))? allergens.indexOf(element): -1;
	}
	
	/*
	 * Metodo que retorna el nombre 
	 */
	public String returnName(int element){
		return(allergens.contains(element))? allergens.get(element): "-1";
	}

}