package main;

import java.util.ArrayList;
import java.util.List;

// we import all classes added in the package classes //
import classes.*;

public class Main {

	private static void addElements(List<Allergen> allergens) {
		// TODO Auto-generated method stub
		allergens.add(new Allergen(0,"Gluten"));
		allergens.add(new Allergen(1,"Shellfish"));
		allergens.add(new Allergen(2,"Eggs"));
		allergens.add(new Allergen(3,"Fish"));
		allergens.add(new Allergen(4,"Peanuts"));
		allergens.add(new Allergen(5,"Soy"));
		allergens.add(new Allergen(6,"Dairy"));
		allergens.add(new Allergen(7,"Nuts"));
		allergens.add(new Allergen(8,"Celery"));
		allergens.add(new Allergen(9,"Mustard"));
		allergens.add(new Allergen(10,"Sesame"));
		allergens.add(new Allergen(11,"Sulphites"));
		allergens.add(new Allergen(12,"Mollusk"));
		allergens.add(new Allergen(13,"Lupin"));
	}
	
	private static int lookAllergen(String b, List<Allergen> allergens) {
		int pos = 0;
		for (Allergen a : allergens) {
			if(a.getName() == b){
				pos =  a.getCode();
			}
		}
		return pos;
	}
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// we create one arraylist of allergens //
		List<Allergen> allergens = new ArrayList<Allergen>();
		// we add the allergens to the arraylist of allergens //
		addElements(allergens);
		// we check if the arraylist is empty o full //
		System.out.println(allergens.size());
		
		
		// PRUEBAS SOBRE LA ARRAYLIST PARA VER SI VA BIEN //
		
		// we print the allergens arraylist //
		System.out.println(allergens);
		// extract the zero position of the arraylist //
		System.out.println(allergens.get(0));
		// metodo que me inventé que puede ser util //
		System.out.println(lookAllergen("Dairy", allergens));
	}

}
