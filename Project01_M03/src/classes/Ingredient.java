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
	
	// Method which returns if an ingredient contains one Allergen to verify it //
	public boolean containAllergen(Allergen a) {
		if (this.allergens.contains(a)) {
			return true;
		}
		return false;
	}

}
