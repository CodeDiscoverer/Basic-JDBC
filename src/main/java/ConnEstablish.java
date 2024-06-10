import java.sql.*;

public class ConnEstablish {

    public static void main(String[] args) {
        // DB Login Credentials
        String username = "SYS AS SYSDBA";
        String password = "Krithvik8055";

        // Establishing connection
        try {
            // Loading the Oracle JDBC driver
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // Establishing connection
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", username, password);
            System.out.println("Connected to the database!");

            // Close the connection when done
            connection.close();
        } catch (ClassNotFoundException ex) {
            System.err.println("Oracle JDBC driver not found!");
            ex.printStackTrace();
        } catch (SQLException ex) {
            System.err.println("Failed to connect to the database: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
