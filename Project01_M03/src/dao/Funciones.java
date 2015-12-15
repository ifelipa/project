package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import db.Conectar;
import db.DbUtil;

public class Funciones {
	private Connection conexion;
	private Statement statement;
	private ResultSet resultset;
	public PreparedStatement prepared;

	public void Insert(String nombreTabla, ArrayList<String>argumentos) {
		
		conexion=Conectar.getInstance().createConnection();
		
		switch (nombreTabla) {

		case "allergen":
			if (argumentos.size() == 2){
				String sql = "INSERT INTO kitchen.allergen"+"(code, name)"+"(?,?)";			
				
				try {					
					prepared = conexion.prepareStatement(sql);
					prepared.setInt(1,Integer.parseInt(argumentos.get(0)));				
					prepared.setString(2, argumentos.get(1));
				} catch (SQLException e) {				
					e.printStackTrace();
					System.out.println("Error..! Insert again. ");
				}finally {
					DbUtil.close(conexion);
					DbUtil.close(prepared);
				}				
								
			}
			
			break;
		case "allergenxIngredients":
			
			if (argumentos.size() == 2){
				
				String sql = "INSERT INTO kitchen.allergen"+"(code, name)"+"(?,?)";		
				
				try {
					prepared = conexion.prepareStatement(sql);
					prepared.setInt(1,Integer.parseInt(argumentos.get(0)));				
					prepared.setString(2, argumentos.get(1));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
								
			}
			
			break;
		case "cookingProcedure":

			break;
		case "ingredients":

			break;
		case "measuringMethod":

			break;
		case "procedurexRecipe":

			break;
		default:
			break;
		}
	}

}
