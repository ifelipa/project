package main;

import java.sql.SQLException;
import java.sql.Statement;

import db.Conectar;

public class mainPizza {

	public static void main(String[] args) {
		insertIngredient(7, "wheat flour", 2, 341.00, 90.60, 9.86, 0.00, 2.00, "250");
	}

	private static void insertIngredient(int code, String name, int measuringCode,	double kcal,  double carbohidrates, double proteines, double fat, 
			double salt,String quantity) {
		try {
			String sql="insert into ingredient values(" + code+","+name+","+measuringCode+","+kcal+","+carbohidrates+","+proteines+","+fat+","+salt+","+quantity+");"; 
			System.out.println(sql);
			Statement st = Conectar.getInstance().createConnection().createStatement();
			System.out.println(st.execute(sql));
						
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("la jodimos..! en ingredient");
		}

		
		
		
	}

}
