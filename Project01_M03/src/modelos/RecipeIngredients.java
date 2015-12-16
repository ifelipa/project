package modelos;

public class RecipeIngredients {

	int quantity;
	int codeIngredient;

	public RecipeIngredients(int quantity, int codeIngredient) {
		super();
		this.quantity = quantity;
		this.codeIngredient = codeIngredient;
	}

	public RecipeIngredients() {
		super();
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getCodeIngredient() {
		return codeIngredient;
	}

	public void setCodeIngredient(int codeIngredient) {
		this.codeIngredient = codeIngredient;
	}

	
}
