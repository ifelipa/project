package main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.Conectar;
import db.DbUtil;

public class mainPizza {

	public static void main(String[] args) {
		
//		 insertIngredient(7, "wheat flour", 2, 341.0, 90.6, 9.86, 0.0, 2.0, "250", 1);
//		 insertIngredient(8, "water", 3, 0, 0, 0, 0, 0, "200",0);
//		 insertIngredient(9, "yeast", 2, 164.0, 27.80, 11.8, 0, 360.00,"100",0);
//		 insertIngredient(10, "olive oil", 3, 900.0, 1.0, 0.0, 0, 0.0, "20",0);
//		 insertIngredient(11, "shredded cheese", 2, 392.84, 25.39, 0.36, 0,675, "150",14);
//		 insertIngredient(12, "Tomate sauce", 3, 38.1, 2.30, 5.55, 0, 990, "200", 0);

		
		
//		 createProcediment(6, "knead until");
//		 createProcediment(7, "let raise");
//		 createProcediment(8, "knead dough again");
//		 createProcediment(9, "lay on oven");
//		 createProcediment(10, "lay on oven");
//		 createProcediment(11, "Bake in oven ");
//		createProcediment(12, "In bold");
//		

		/*
		
		// primera linea //
		createStepXRecipe(12, 0, 0, "0", 0.0, 2);
		createStepXRecipe(3, 7, 250, "0", 0, 2);
		createStepXRecipe(3, 8, 200, "0", 0, 2);
		createStepXRecipe(3, 10, 20, "0", 0, 2);
		createStepXRecipe(3, 9, 15, "0", 0, 2);
		// segunda linea //
		createStepXRecipe(6, 0, 0, "0", 0, 2);
		// tercera linea //
		createStepXRecipe(7, 0, 0, "45", 0, 2);
		// cuarta linea //
		createStepXRecipe(8, 0, 0, "0", 0, 2);
		// quinta linea //
		createStepXRecipe(9, 0, 0, "0", 0, 2);
		// sexta linea //
		createStepXRecipe(3, 11, 150, "0", 0, 2);
		createStepXRecipe(3, 12, 200, "0", 0, 2);
		// septima linea //
		createStepXRecipe(11, 0, 0, "20", 220, 2);
		*/
		
		//crea la receta
		
		//createRecipe(2,"Pizza", 4);
		
		//lista los alergicos de la receta
		//listAllergenOfRecipe(2);
		
	}
	

	private static void listAllergenOfRecipe(int code) {
		String sql="select (select name from allergen where code = codeAllergen) from allergenxingredients where codeIngredient in (select code_ingredient from ingredientxrecipe where code_recipe="+code+")";
		Statement st = null;
		ResultSet resul = null;
		try {
			st = Conectar.createConnection().createStatement();
			resul = st.executeQuery(sql);
			
			while (resul.next()){
				
				System.out.println("* "+resul.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DbUtil.close(st);
			DbUtil.close(resul);
		}
		
		
	}


	private static void createRecipe(int code, String name, int quantity ) {
		
		//Sentencias para recuperar datos 
		String sqlTotalkcal="select sum(kcal) from ingredient where code in (select code_ingredient from ingredientxrecipe where code_recipe="+code+")";
		String sqlTotalcarb="select sum(carbohidrates) from ingredient where code in (select code_ingredient from ingredientxrecipe where code_recipe="+code+")";
		String sqlTotalProt="select sum(Proteines) from ingredient where code in (select code_ingredient from ingredientxrecipe where code_recipe="+code+")";
		String sqlTotalFat="select sum(Fat) from ingredient where code in (select code_ingredient from ingredientxrecipe where code_recipe="+code+")";
		String sqlTotalSalt="select sum(Salt) from ingredient where code in (select code_ingredient from ingredientxrecipe where code_recipe="+code+")";
		String sqltotalAllergen="select codeAllergen from allergenxingredients where codeIngredient in (select code_ingredient from ingredientxrecipe where code_recipe="+code+")";
		
		//recuperar datos
		
		try {
			double kcal = dataRecovery(sqlTotalkcal);
			double carb = dataRecovery(sqlTotalcarb);
			double prot = dataRecovery(sqlTotalProt);
			double fat = dataRecovery(sqlTotalFat);
			double salt = dataRecovery(sqlTotalSalt);
			String aler = dataRecoveryAllergenList(sqltotalAllergen);
			createRecipeData(code, name, quantity,  kcal, carb, prot, fat,  salt,  aler);
		} catch (Exception e) {
			System.out.println("Hubo un error al crear la receta");
			e.printStackTrace();
		}
	}
	
	
	
	private static String dataRecoveryAllergenList(String sql) {
		Statement st = null;
		ResultSet resul = null;
		String data = "";
		 
		 try {
			 
			st = Conectar.getInstance().createConnection().createStatement();
			resul = st.executeQuery(sql);
			while (resul.next()){
				int aux=resul.getInt("codeAllergen");
				data+= Integer.toString(aux)+",";
			}
			
			
		} catch (SQLException e) {
			System.out.println("Error al recuperar datos de la sentencia"+ sql);
			e.printStackTrace();
		}finally {
			DbUtil.close(st);
			DbUtil.close(resul);
		}
		return data;
	}


	private static double dataRecovery(String sql) {
		Connection conexion = null;
		Statement st = null;
		ResultSet resul = null;
		double data = 0;
		 
		 try {
			 
			st = Conectar.getInstance().createConnection().createStatement();
			resul = st.executeQuery(sql);
			resul.next();
			data = resul.getDouble(1);
			
		} catch (SQLException e) {
			System.out.println("Error al recuperar datos de la sentencia"+ sql);
			e.printStackTrace();
		}finally {
			DbUtil.close(st);
			DbUtil.close(resul);
		}
		 
		return data;
	}


	private static void createIngredientxRecipe( int code_recipe, int code_ingredient) {

		Connection conexion = null;
		PreparedStatement pr = null;

		String sql = "insert into ingredientxrecipe values(?,?)";

		try {
			conexion = Conectar.getInstance().createConnection();
			pr = conexion.prepareStatement(sql);
			pr.setInt(1, code_recipe);
			pr.setInt(2, code_ingredient);
			

			if (pr.execute()) {
				System.out.println("Hubo un error al ingresar:  "+ code_ingredient);
			} else {
				System.out.println("Se agrego correctamente el ingrediente: " + code_ingredient);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Estamos jodidos...! createIngredientxRecipe");
		} finally {
			DbUtil.close(conexion);
			DbUtil.close(pr);
		}

	}



	private static void createStepXRecipe(int cod_procedure, int cod_ingredient, int quantity, String time,
			double temperature, int cod_recipe) {

		Connection conexion = null;
		PreparedStatement pr = null;

		String sql = "insert into stepxrecipe values(?,?,?,?,?,?)";

		try {
			conexion = Conectar.getInstance().createConnection();
			pr = conexion.prepareStatement(sql);
			pr.setInt(1, cod_procedure);
			pr.setInt(2, cod_ingredient);
			pr.setInt(3, quantity);
			pr.setString(4, time);
			pr.setDouble(5, temperature);
			pr.setDouble(6, cod_recipe);

			if (pr.execute()) {
				System.out.println("Hubo un error al ingresar:  "+ cod_procedure);
			} else {
				System.out.println("Se agrego correctamente el procedimiento: " + cod_procedure);
				if (cod_ingredient !=0){
					createIngredientxRecipe(cod_recipe,cod_ingredient );
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Estamos jodidos...! stepxrecipe");
		} finally {
			DbUtil.close(conexion);
			DbUtil.close(pr);
		}

	}

	private static void createProcediment(int code, String name) {
		Statement st = null;
		try {
			String sql = "insert into cookingprocedure  values(" + code + ",'" + name + "')";

			st = Conectar.getInstance().createConnection().createStatement();
			if (st.execute(sql)) {
				System.out.println("Hubo un error al ingresar: " + name);
			} else {
				System.out.println("Se agrego correctament: " + name);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("la jodimos..!  cookingprocedure");
		} finally {
			DbUtil.close(st);
		}
	}

	private static void createRecipeData(int code, String name, int quantity, double kcal, double carbohidrates,
			double proteines, double fat, double salt, String aler) {
		
		Connection conexion = null;
		PreparedStatement pr = null;

		String sql = "insert into recipe values(?,?,?,?,?,?,?,?,?)";

		try {
			conexion = Conectar.getInstance().createConnection();
			pr = conexion.prepareStatement(sql);

			pr.setInt(1, code);
			pr.setString(2, name);
			pr.setInt(3, quantity);
			pr.setDouble(4, kcal);
			pr.setDouble(5, carbohidrates);
			pr.setDouble(6, proteines);
			pr.setDouble(7, fat);
			pr.setDouble(8, salt);
			pr.setString(9, aler);

			if (pr.execute()) {
				System.out.println("Hubo un error al ingresar: " + name);
			} else {
				System.out.println("Se agrego correctament: " + name);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Estamos jodidos...! createRecipeData");
		} finally {
			DbUtil.close(conexion);
			DbUtil.close(pr);
		}
	}

	private static void insertIngredient(int code, String name, int measuringCode, double kcal, double carbohidrates,
			double proteines, double fat, double salt, String quantity, int allergen) {
		Statement st = null;
		try {
			String sql = "insert into ingredient values(" + code + ",'" + name + "'," + measuringCode + "," + kcal + ","
					+ carbohidrates + "," + proteines + "," + fat + "," + salt + ",'" + quantity + "');";
			st = Conectar.getInstance().createConnection().createStatement();

			if (st.execute(sql)) {
				System.out.println("Hubo un error al ingresar: " + name);
			} else {
				if (allergen != 0)insertAllergenxIngredient(code, allergen);
				System.out.println("Se agrego correctament: " + name);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("la jodimos..!  ingredient");
		} finally {
			DbUtil.close(st);
		}
	}
	
	private static void insertAllergenxIngredient(int code, int allergen) {
		String sqlAllergenxIngredient = "insert into allergenxingredients value ("+code+","+allergen+");";
		Statement st = null;
		
		try {
			st=Conectar.createConnection().createStatement();
			if (st.execute(sqlAllergenxIngredient)){
				System.out.println("Hubo un error al ingresar el alergico con codigo: " + allergen);
			}
		} catch (SQLException e) {
			System.out.println("error al ingresar en la tabala allergenxingredient");
			e.printStackTrace();
		} finally {
			DbUtil.close(st);
		}
	}

}
