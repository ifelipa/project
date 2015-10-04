package classes;

import java.util.ArrayList;

public class Recipe {

	int code;
	String name;
	int quantity;
	ArrayList<Ingredient> ingredients;
	double kcal;
	double carbohidrates;
	double proteines;
	int fat;
	int salt;
	ArrayList<AllergenAux> allergens;
	
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
	public ArrayList<AllergenAux> getAllergens() {
		return allergens;
	}
	public void setAllergens(ArrayList<AllergenAux> allergens) {
		this.allergens = allergens;
	}
}
