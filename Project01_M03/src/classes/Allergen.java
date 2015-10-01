package classes;

import java.util.ArrayList;
import java.util.List;



public class Allergen {
	// the code is the index of the arrayList //
	private List<String> allergens;

	public Allergen(){
		allergens = new ArrayList<String>();
	}
	// getter //
	public List<String> getAllergens() {
		return allergens;
	}

	// setter //
	public void setAllergens(List<String> allergens) {
		this.allergens = allergens;
	}
	
	
	
}
