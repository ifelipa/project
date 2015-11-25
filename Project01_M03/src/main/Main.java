package main;

// we import all classes added in the package classes //
import classes.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Prueba
		Allergen a = new Allergen();
		System.out.println(a.tamany());
		a.AddElement(14, "Patatas");
		System.out.println(a.tamany());
		System.out.println(a.getElement(13));
		System.out.println(a.getElement("Lupin"));

		Recipe b = new Recipe(0, "Arroz con algo", 2, null, 200, 300, 150, 150, 5, a);
		Allergen prueba = b.getAllergen();
		System.out.println(prueba.tamany());
		//Ingredient arroz = new Ingredient(01,"Arroz","kg",10,15,1,3,2,alergicoProducto);
//		System.out.println(arroz.containAllergen(eggs));	
//		Procedure pr=new Procedure(1, "Hervir");
//		System.out.println(pr.ProceedIngredient(01, arroz, 10, 1, 45, 45));

	}
}
