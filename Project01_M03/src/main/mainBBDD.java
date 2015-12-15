package main;


public class mainBBDD{
	public static void main(String[] args) throws Exception {
		    MySQLAccess dao = new MySQLAccess();
		    dao.readDataBase();
		    dao.insertTable("Vettel", "vettel@gmail.com", "vettel.com", "vettel f1", "puto amo");
		    dao.readDataBase();
	}
}
