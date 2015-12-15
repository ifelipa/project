package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;


public class MySQLAccess {
  private Connection connect = null;
  private Statement statement = null;
  private ResultSet resultSet = null;
  
  public void readDataBase() throws Exception {
    try {
      // This will load the MySQL driver, each DB has its own driver
      Class.forName("com.mysql.jdbc.Driver");
      // Setup the connection with the DB
      connect = DriverManager
          .getConnection("jdbc:mysql://localhost/kitchen?"
              + "user=root&password=123");
      
      // Statements allow to issue SQL queries to the database
      statement = connect.createStatement();
      // Result set get the result of the SQL query
      resultSet = statement
          .executeQuery("select * from kitchen.allergen");
      writeResultSet(resultSet);


    } catch (Exception e) {
      throw e;
    } finally {
      close();
    }

  }

  public void insertTable(String usuari, String email, String pagina, String resum, String comentari) throws Exception {
	    try {
	      // This will load the MySQL driver, each DB has its own driver
	      Class.forName("com.mysql.jdbc.Driver");
	      // Setup the connection with the DB
	      connect = DriverManager
	          .getConnection("jdbc:mysql://localhost/feedback?"
	              + "user=sqluser&password=sqluserpw");
	      
	      String sentencia= "INSERT INTO comments (MYUSER,EMAIL,WEBPAGE,DATUM,SUMMARY,COMMENTS) VALUES(?,?,?,CURRENT_TIMESTAMP,?,?)";
	      PreparedStatement s = connect.prepareStatement(sentencia);
	      s.setString(1, usuari);
	      s.setString(2, email);
	      s.setString(3, pagina);
	      s.setString(4,resum);
	      s.setString(5, pagina);
	      
	      s.executeUpdate();
	       
	    } catch (Exception e) {
	      throw e;
	    } finally {
	      close();
	    }

	  }
 
  private void writeResultSet(ResultSet resultSet) throws SQLException {
    // ResultSet is initially before the first data set
    while (resultSet.next()) {
      // It is possible to get the columns via name
	// also possible to get the columns via the column number
      // which starts at 1
      // e.g. resultSet.getString(2);
      String user = resultSet.getString("myuser");
      String website = resultSet.getString("webpage");
      String summary = resultSet.getString("summary");
      Date date = resultSet.getDate("datum");
      String comment = resultSet.getString("comments");
      System.out.println("User: " + user);
      System.out.println("Website: " + website);
      System.out.println("Summary: " + summary);
      System.out.println("Date: " + date);
      System.out.println("Comment: " + comment);
    }
  }

  // You need to close the resultSet
  private void close() {
    try {
      if (resultSet != null) {
        resultSet.close();
      }

      if (statement != null) {
        statement.close();
      }

      if (connect != null) {
        connect.close();
      }
    } catch (Exception e) {

    }
  }

} 