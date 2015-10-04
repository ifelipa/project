package classes;

import java.util.ArrayList;
import java.util.List;

public class Allergen {

	private String name;
	private int code;
	
	public Allergen(int code, String name){
		this.name = name;
		this.code = code;
	}
	
	/*
	 * returnCode
	 * 
	 * @param element is String, It큦 the name of allergen.
	 * 
	 * @return is integer, It큦 code of the name.
	 * 
	 */
	public int returnCode(List allergens, String element) {
		return (allergens.contains(element)) ? allergens.indexOf(element) : -1;
	}

	/*
	 * returnName
	 * 
	 * @param element is Integer, It큦 the code of allergen.
	 * 
	 * @return is String, It큦 name of the code.
	 * 
	 */
	public String returnName(List <Allergen> allergens, int element) {
		return (element > 0 && element < allergens.size()) ? (allergens.get(element).getName())
				: "Error..! That code don't appear in our allergens";
	}
	
	

	//Setter's and Getter's
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
	
	
	@Override
	public String toString() {
		return this.name;
	}

}