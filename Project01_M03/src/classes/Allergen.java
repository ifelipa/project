package classes;

// import java.util.ArrayList;
// import java.util.List;

public class Allergen {
	// the code is the index of the arrayList //
	
	//private List<String> allergens;
	private String name;
	private int code;
	public Allergen(int code, String name){
		//allergens = new ArrayList<String>();
		this.name = name;
		this.code = code;
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
	
	@Override
	public String toString() {
		return this.name;
	}

}