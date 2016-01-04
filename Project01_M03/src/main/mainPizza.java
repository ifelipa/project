package main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import db.Conectar;
import db.DbUtil;

public class mainPizza {

	public static void main(String[] args) {
		
//		 insertIngredient(7, "wheat flour", 2, 341.0, 90.6, 9.86, 0.0, 2.0, "250");
//		 insertIngredient(8, "water", 3, 0, 0, 0, 0, 0, "200");
//		 insertIngredient(9, "yeast", 2, 164.0, 27.80, 11.8, 0, 360.00,"100");
//		 insertIngredient(10, "olive oil", 3, 900.0, 1.0, 0.0, 0, 0.0, "20");
//		 insertIngredient(11, "shredded cheese", 2, 392.84, 25.39, 0.36, 0,675, "150");
//		 insertIngredient(12, "Tomate sauce", 3, 38.1, 2.30, 5.55, 0, 990, "200");

		// createRecipe(2, "Pizza", 1, 1835.94, 108.35, 66.35, 0.0, 486.0, "1,14");
		
		 createProcediment(6, "knead until");
		 createProcediment(7, "let raise");
		 createProcediment(8, "knead dough again");
		 createProcediment(9, "lay on oven");
		 createProcediment(10, "lay on oven");
		 createProcediment(11, "Bake in oven ");
		
		// createStepXRecipe(1,1);

	}

	private static void createStepXRecipe(int cod_procedure, int cod_ingredient, int quantity, String time,
			double temperature, int cod_recipe) {

		Connection conexion = null;
		PreparedStatement pr = null;

		// String sql ="insert into recipe values(?,?,?,?,?,?)";
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

			System.out.println(pr.execute());

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Estamos jodidos...! createRecipe");
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

	private static void createRecipe(int code, String name, int quantity, double kcal, double carbohidrates,
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
			System.out.println("Estamos jodidos...! createRecipe");
		} finally {
			DbUtil.close(conexion);
			DbUtil.close(pr);
		}
	}

	private static void insertIngredient(int code, String name, int measuringCode, double kcal, double carbohidrates,
			double proteines, double fat, double salt, String quantity) {
		Statement st = null;
		try {
			String sql = "insert into ingredient values(" + code + ",'" + name + "'," + measuringCode + "," + kcal + ","
					+ carbohidrates + "," + proteines + "," + fat + "," + salt + ",'" + quantity + "');";
			st = Conectar.getInstance().createConnection().createStatement();

			if (st.execute(sql)) {
				System.out.println("Hubo un error al ingresar: " + name);
			} else {
				System.out.println("Se agrego correctament: " + name);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("la jodimos..!  ingredient");
		} finally {
			DbUtil.close(st);
		}
	}

}
