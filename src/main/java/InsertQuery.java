import java.sql.*;

public class InsertQuery {

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

            // Sample data for insertion
            int rollNo = 101;
            String firstName = "Pradheep";
            String dob = "2005-12-06";
            int percentage = 88;
            String contactNo = "56346787954";

            // Query to insert data into the table
            String query = "INSERT INTO STUDENTS (rollNo, firstName, DOB, percentage, contactNo) VALUES (?, ?, ?, ?, ?)";

            // Creating a prepared statement
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, rollNo);
            statement.setString(2, firstName);
            statement.setString(3, dob);
            statement.setInt(4, percentage);
            statement.setString(5, contactNo);

            // Executing the insert query
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Data inserted successfully!");
            }

            // Close the connection
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
