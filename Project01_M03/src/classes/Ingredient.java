package classes;

import java.util.List;

public class Ingredient {
	int code;
	String name;
	String measuring;
	double kcal;
	double Carbohidrates;
	double proteines;
	double fat;
	double salt;
	List<Allergen> allergens;


	public Ingredient(int code, String name, String measuring, double kcal, double carbohidrates, double proteines, double fat, double salt, List<Allergen> allergens) {
		super();
		this.code = code;
		this.name = name;
		this.measuring = measuring;
		this.kcal = kcal;
		Carbohidrates = carbohidrates;
		this.proteines = proteines;
		this.fat = fat;
		this.salt = salt;
		this.allergens = allergens;
	}
	/*
	 * searchByCode
	 * @param a is a List of Ingredient.
	 * @param code is Integer, It's the code to search. 
	 * @return String, It's full ingredient according to the code. 
	 */
	public Ingredient searchByCode(List<Ingredient> a,int code){
		for (int i = 0; i< a.size(); i++){
			if (a.get(i).getCode() == code){
				return a.get(i);
			}
		}
		return null;	
	}
	
	@Override
	public String toString() {
		return "Ingredient [code=" + code + ", name=" + name + ", measuring=" + measuring + ", kcal=" + kcal
				+ ", Carbohidrates=" + Carbohidrates + ", proteines=" + proteines + ", fat=" + fat + ", salt=" + salt
				+ ", allergens=" + allergens + "]";
	}
	/*
	 * Method which retrieves full ingredient according to the name
	 */
	public Ingredient searchByName(List<Ingredient> a,String name){
		for (int i = 0; i< a.size(); i++){
			if (a.get(i).getName() == name){
				return a.get(i);
			}
		}
		return null;
	}
	
	// Method which returns if an ingredient contains one Allergen to verify it //
	public boolean containAllergen(Allergen b) {
		if (this.allergens.contains(b)) {
			return true;
		}
		return false;
	}
	
	
	// Setter's and Getter's
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

	public String getMeasuring() {
		return measuring;
	}

	public void setMeasuring(String measuring) {
		this.measuring = measuring;
	}

	public double getKcal() {
		return kcal;
	}

	public void setKcal(double kcal) {
		this.kcal = kcal;
	}

	public double getCarbohidrates() {
		return Carbohidrates;
	}

	public void setCarbohidrates(double carbohidrates) {
		Carbohidrates = carbohidrates;
	}

	public double getProteines() {
		return proteines;
	}

	public void setProteines(double proteines) {
		this.proteines = proteines;
	}

	public double getFat() {
		return fat;
	}

	public void setFat(double fat) {
		this.fat = fat;
	}

	public double getSalt() {
		return salt;
	}

	public void setSalt(double salt) {
		this.salt = salt;
	}

	public List<Allergen> getAllergens() {
		return allergens;
	}

	public void setAllergens(List<Allergen> allergens) {
		this.allergens = allergens;
	}
	

}
