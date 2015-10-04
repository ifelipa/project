package main;

import java.util.ArrayList;
import java.util.List;

// we import all classes added in the package classes //
import classes.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// we create one arraylist of allergens //
		Allergen listaAler = new Allergen();
		System.out.println(listaAler);
		System.out.println(listaAler.returnCode("eggs"));
	}

}
