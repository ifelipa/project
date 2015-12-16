package modelos;

import java.util.ArrayList;

public class Recipe {

	int code;
	String name;
	int quantity;
	double kcal;
	double carbohidrates;
	double proteines;
	int fat;
	int salt;
	ArrayList<Ingredient> ingredients;
	AllergenDictionary a;

	public Recipe(int code, String name, int quantity, ArrayList<Ingredient> ingredients, double kcal,
			double carbohidrates, double proteines, int fat, int salt, AllergenDictionary a) {
		this.code = code;
		this.name = name;
		this.quantity = quantity;
		this.ingredients = ingredients;
		this.kcal = kcal;
		this.carbohidrates = carbohidrates;
		this.proteines = proteines;
		this.fat = fat;
		this.salt = salt;
		this.a = a;
	}

	public Recipe() {
		super();
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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public ArrayList<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(ArrayList<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	public double getKcal() {
		return kcal;
	}

	public void setKcal(double kcal) {
		this.kcal = kcal;
	}

	public double getCarbohidrates() {
		return carbohidrates;
	}

	public void setCarbohidrates(double carbohidrates) {
		this.carbohidrates = carbohidrates;
	}

	public double getProteines() {
		return proteines;
	}

	public void setProteines(double proteines) {
		this.proteines = proteines;
	}

	public int getFat() {
		return fat;
	}

	public void setFat(int fat) {
		this.fat = fat;
	}

	public int getSalt() {
		return salt;
	}

	public void setSalt(int salt) {
		this.salt = salt;
	}

	public AllergenDictionary getAllergen() {
		return a;
	}

	public void setAllergen(AllergenDictionary a) {
		this.a = a;
	}


}