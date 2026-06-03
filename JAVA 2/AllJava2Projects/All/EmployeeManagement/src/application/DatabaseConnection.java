// DatabaseConnection.java
package application;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/employee";
    private static final String USERNAME = "root"; // Change as per your setup
    private static final String PASSWORD = "Kamdeu2007."; // Change as per your setup
    
    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new SQLException("MySQL JDBC Driver not found. Please add mysql-connector-java.jar to classpath", e);
        }
    }
}