package application;
	
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	
	public static Connection connect() {
		try {
			String url = "jdbc:mysql://localhost:3306/school";
			String user = "root";
			String password = "Kamdeu2007.";
			Connection conn = DriverManager.getConnection(url, user, password);
			System.out.println("Connection success !");
			return conn;
		} catch(Exception e) {
			System.out.println("Error Connecting !");
			e.printStackTrace();
			return null;
		}
		
	}
	
}