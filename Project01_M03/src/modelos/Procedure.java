package modelos;

public class Procedure {
	int code;
	String name;
	int time;

	public Procedure(int code, String name, int time) {
		this.code = code;
		this.name = name;
		this.time = time;
	}
	
	public Procedure(){}
	

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



	public int getTime() {
		return time;
	}



	public void setTime(int time) {
		this.time = time;
	}







	/*
	 * ProceedIngredient
	 * @param codeProcedure is integer, It's the code of procedure.
	 * @param codeIngredient is integer, It's the code of Ingredient.
	 * @param quantity is integer, It's  int times, int time, int temperature
	 * 
	 */
	public String ProceedIngredient(int codeProcedure, Ingredient codeIngredient, int quantity, int times, int time, int temperature) {
		return this.getName()+" "+quantity +" "+ codeIngredient.getName()+" "+ time+ " "+ temperature ;
	}
}
