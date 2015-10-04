package classes;

import java.util.ArrayList;
import java.util.List;

public class AllergenNOSIRVE {
	// the code is the index of the arrayList//
	List<String> allergens;
	String[] alergico = { "Gluten", "shellfish", "eggs", "fish", "peanuts", "soy", "dairy", "nuts", "celery", "mustard",
			"sesame", "sulphites", "mollusk", "lupin" };

	public AllergenNOSIRVE() {
		allergens = new ArrayList<String>();
		for (String string : alergico) {
			allergens.add(string);
		}
	}

	public List createAllergenList(String[] list) {
		List<Integer> lista = new ArrayList<Integer>();
		for (String element : list) {
			lista.add(returnCode(element));
		}
		return lista;
	}

	/*
	 * returnCode
	 * 
	 * @param element is String, It큦 the name of allergen.
	 * 
	 * @return is integer, It큦 code of the name.
	 * 
	 */
	public int returnCode(String element) {
		return (allergens.contains(element)) ? allergens.indexOf(element) : -1;
	}

	/*
	 * returnName
	 * 
	 * @param element is Integer, It큦 the code of allergen.
	 * 
	 * @return is String, It큦 name of the code.
	 * 
	 */
	public String returnName(int element) {
		return (element > 0 && element < allergens.size()) ? allergens.get(element)
				: "Error..! That code don't appear in our allergens";
	}

}