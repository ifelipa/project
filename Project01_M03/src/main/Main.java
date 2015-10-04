package main;

import java.util.ArrayList;
import java.util.List;

// we import all classes added in the package classes //
import classes.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// we create one arraylist of allergens //
//		Allergen listaAler = new Allergen();
//		System.out.println(listaAler.returnCode("eggs"));
//		System.out.println(listaAler.returnName(2));
//		System.out.println(listaAler.returnName(-2));
//		
		//Prueba
		Allergen guten = new Allergen(1, "Gluten");
		Allergen shellfish = new Allergen(2, "shellfish");
		Allergen eggs = new Allergen(3, "eggs");
		Allergen fish = new Allergen(4, "fish");
		Allergen peanuts = new Allergen(5, "peanuts");
		Allergen soy = new Allergen(6, "soy");
		Allergen dairy = new Allergen(7, "dairy");
		Allergen nuts = new Allergen(8, "nuts");
		Allergen celery = new Allergen(9, "celery");
		Allergen mustard = new Allergen(10, "mustard");
		Allergen sesame = new Allergen(11, "sesame");
		Allergen sulphites= new Allergen(12, "sulphites");
		Allergen mollusk = new Allergen(13, "mollusk");
		Allergen lupin = new Allergen(14, "lupin");
		
		List<Allergen>alergicoProducto = new ArrayList<Allergen>();
		alergicoProducto.add(guten);
		alergicoProducto.add(shellfish);
		alergicoProducto.add(eggs);
		
		Ingredient arroz = new Ingredient(01,"Arroz","kg",10,15,1,3,2,alergicoProducto);
		System.out.println(arroz.containAllergen(eggs));
		Procedure pr=new Procedure(1, "Hervir");
		System.out.println(pr.ProceedIngredient(01, arroz, 10, 1, 45, 45));
		
		
	}

}
