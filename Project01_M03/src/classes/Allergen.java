package classes;

public class Allergen {
	int codeAl;
	String name;

	public int getCodeAl() {
		return codeAl;
	}

	public void setCodeAl(int codeAl) {
		this.codeAl = codeAl;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Allergen [codeAl=" + codeAl + ", name=" + name + "]";
	}

	public Allergen(int codeAl, String name) {
		super();
		this.codeAl = codeAl;
		this.name = name;
	}

	public Allergen(int codeAl) {
		super();
		this.codeAl = codeAl;
		AllergenDictionary dict = new AllergenDictionary();
		this.name = dict.getElement(codeAl);
	}

	public Allergen() {
		super();
	}

}
