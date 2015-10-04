package main;

import java.util.ArrayList;
import java.util.List;

// we import all classes added in the package classes //
import classes.*;

public class Main {

	private static void addElements(List<AllergenAux> allergens) {
		// TODO Auto-generated method stub
		allergens.add(new AllergenAux(0,"Gluten"));
		allergens.add(new AllergenAux(1,"Shellfish"));
		allergens.add(new AllergenAux(2,"Eggs"));
		allergens.add(new AllergenAux(3,"Fish"));
		allergens.add(new AllergenAux(4,"Peanuts"));
		allergens.add(new AllergenAux(5,"Soy"));
		allergens.add(new AllergenAux(6,"Dairy"));
		allergens.add(new AllergenAux(7,"Nuts"));
		allergens.add(new AllergenAux(8,"Celery"));
		allergens.add(new AllergenAux(9,"Mustard"));
		allergens.add(new AllergenAux(10,"Sesame"));
		allergens.add(new AllergenAux(11,"Sulphites"));
		allergens.add(new AllergenAux(12,"Mollusk"));
		allergens.add(new AllergenAux(13,"Lupin"));
	}
	
	private static int lookAllergen(String b, List<AllergenAux> allergens) {
		int pos = 0;
		for (AllergenAux a : allergens) {
			if(a.getName() == b){
				pos =  a.getCode();
			}
		}
		return pos;
	}
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// we create one arraylist of allergens //
		List<AllergenAux> allergens = new ArrayList<AllergenAux>();
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
