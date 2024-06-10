import java.sql.*;

public class SelectQuery {

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

            // Query to select all rows from the table
            String query = "SELECT * FROM STUDENTS";

            // Creating a statement
            Statement statement = connection.createStatement();

            // Executing the query
            ResultSet resultSet = statement.executeQuery(query);

            // Printing the table contents
            while (resultSet.next()) {
                int rollNo = resultSet.getInt("rollNo");
                String firstName = resultSet.getString("firstName");
                String dob = resultSet.getString("DOB");
                int percentage = resultSet.getInt("percentage");
                String contactNo = resultSet.getString("contactNo");

                System.out.println("Roll No: " + rollNo +
                        ", First Name: " + firstName +
                        ", DOB: " + dob +
                        ", Percentage: " + percentage +
                        ", Contact No: " + contactNo);
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
