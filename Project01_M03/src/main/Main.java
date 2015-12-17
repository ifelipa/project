package main;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import modelos.Allergen;
import modelos.AllergenDictionary;
import modelos.Ingredient;
import modelos.Procedure;
import modelos.Recipe;
import modelos.RecipeIngredients;
import dao.*;
import db.Conectar;

public class Main {
	public static Statement statement = null;
	public static ResultSet resultSet = null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Prueba
		// Allergen a = new Allergen();
		//
		// System.out.println(a.tamany());
		// a.AddElement(14, "Patatas");
		// System.out.println(a.tamany());
		// System.out.println(a.getElement(13));
		// System.out.println(a.getElement("Lupin"));
		//
		// //Lista de alergico
		//
		// List<Allergen> al = new ArrayList<Allergen>();
		//
		// 01, 07, 14
		// Lista de Ingredientes

		List<Allergen> al = new ArrayList<Allergen>();
		// Allergen a = new Allergen(01);
		// al.add(a);
		// a = new Allergen(07);
		// al.add(a);
		// a = new Allergen(14);
		// al.add(a);
		//// Ingredient ingr = new Ingredient(01, "Gallo Breadcrumbs", "grams",
		// 395, 71.98, 13.35, 5.3, 2, al);
		// ArrayList <String> llistaIngredients=new ArrayList<String>();
		// llistaIngredients.add("ous");
		// llistaIngredients.add("oli");
		// llistaIngredients.add("sal");
		//

		Ingredient banana = new Ingredient(1, "banana", "unit", 110.0, 30.0, 1.0, 0.0, 0.0, al);
		Ingredient kiwi = new Ingredient(2, "kiwi", "unit", 46.0, 11.14, 0.87, 0.4, 2.0, al);
		Ingredient apple = new Ingredient(3, "apple", "unit", 72.0, 19.06, 0.36, 0.23, 1.0, al);
		Ingredient sugar = new Ingredient(4, "sugar", "g", 0.387, 0.99, 0, 0, 0, al);
		Ingredient oj = new Ingredient(5, "orange juice", "ml", 0.41, 0.095, 0.006, 0.001, 0, al);
		Ingredient almonds = new Ingredient(6, "almonds", "g", 621, 6.6, 22.9, 52.93, 14, al);

		RecipeIngredients ingredientes = new RecipeIngredients();
		ArrayList<RecipeIngredients> llistaIngredients = new ArrayList<RecipeIngredients>();
		llistaIngredients.add(new RecipeIngredients(1, 1));
		llistaIngredients.add(new RecipeIngredients(2, 1));
		llistaIngredients.add(new RecipeIngredients(3, 1));
		llistaIngredients.add(new RecipeIngredients(4, 100));
		llistaIngredients.add(new RecipeIngredients(5, 200));
		llistaIngredients.add(new RecipeIngredients(6, 10));

		Procedure cutslice = new Procedure(1, "cut in slice", 0);
		Procedure cutcubes = new Procedure(1, "cut in cubes", 0);
		Procedure attachd = new Procedure(1, "add", 0);
		Procedure keepcold = new Procedure(1, "keep cold", 10);

		// constructor que coja y cree con sólo los ingredientes (+nombre de
		// receta, + código de receta) la receta y rellene el resto

		Recipe b = createRecipe(0, "Fruit Salad", 4, llistaIngredients);

		// Recipe b = new Recipe(0, "Fruit salad", 4, null, 200, 300, 150, 150,
		// 5, a);
		// Allergen prueba = b.getAllergen();
		// System.out.println(prueba.tamany());
		//
		// Ingredient arroz = new
		// Ingredient(01,"Arroz","kg",10,15,1,3,2,alergicoProducto);
		// System.out.println(arroz.containAllergen(eggs));
		// Procedure pr=new Procedure(1, "Hervir");
		// System.out.println(pr.ProceedIngredient(01, arroz, 10, 1, 45, 45));

		String sql = "select * from recipe";
		try {

			statement = Conectar.getInstance().createConnection().createStatement();
			resultSet = statement.executeQuery(sql);
			printRecipe (resultSet);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	static Recipe createRecipe(int code, String name, int quantity, ArrayList<RecipeIngredients> listOfIngredients) {
		Recipe r = new Recipe();
		return r;
	}

	private static void printRecipe(ResultSet r) throws SQLException {
		 Statement stat = null;
		 ResultSet resul = null;
		while (r.next()) {
			int code = r.getInt("code");
			String name = r.getString("name");
			String quantity = r.getString("quantity");
			double kcal = r.getDouble("kcal");
			double carbohidrates = r.getDouble("carbohidrates");
			double proteines = r.getDouble("proteines");
			double fat = r.getDouble("fat");
			double salt = r.getDouble("salt");
			String allergensList = r.getString("allergensList");
			System.out.println("Receta n�: " + code);
			System.out.println("Nombre: "+ name);
			System.out.println("Para "+quantity+" personas.");
			System.out.println("Los ingredientes son: ");
//			String sql_ingredientes = "select name, quantity, measuringCode from ingredient where code in ("
//					+ "	select code_ingredient from ingredientxrecipe where code_recipe ="+code +")";
			
			String sql_ingredientes = "select name, quantity,(select Name from measuringmethod where code= measuringCode) from ingredient where code in ("
					+ "	select code_ingredient from ingredientxrecipe where code_recipe ="+code +")";
			
			stat = Conectar.getInstance().createConnection().createStatement();
			resul = stat.executeQuery(sql_ingredientes);
			//fala realizar una tablar donde almacenar receta, ingrediente, `procedimientos
			while (resul.next()){
				int quan = resul.getInt("quantity");
				String name_ingre= resul.getString("name");
				String me = resul.getString(3);
				System.out.println(quan+" "+ me +" "+name_ingre);
				
			}
		}
	}

	private void close() {
		try {
			if (resultSet != null) {
				resultSet.close();
			}
			if (statement != null) {
				statement.close();
			}

		} catch (Exception e) {
			System.out.println("error");

		}
	}

}
