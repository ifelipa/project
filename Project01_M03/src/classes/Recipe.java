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
	ArrayList<Allergen> allergens;
	
	/*
	 * Method which returns the recipe code 
	 */
	public int getCode() {
		return code;
	}
	
	/*
	 * Method to set the code of our recipe
	 * 
	 */
	public void setCode(int code) {
		this.code = code;
	}
	
	/*
	 * Method which returns the recipe name
	 */
	
	public String getName() {
		return name;
	}
	
	/*
	 *	Method which sets the recipe name 
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/*
	 * Method which returns the recipe quantity
	 */
	public int getQuantity() {
		return quantity;
	}
	
	/*
	 * Method to set the quantity of our recipe
	 */
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
	public ArrayList<Allergen> getAllergens() {
		return allergens;
	}
	public void setAllergens(ArrayList<Allergen> allergens) {
		this.allergens = allergens;
	}
	
	/*
	 * Print recipe
	 */
	@Override
	public String toString(){
		return this.code + this.name + this.quantity + this.ingredients + this.kcal + this.carbohidrates + this.proteines + this.fat + this.salt + this.allergens;
	}
}
