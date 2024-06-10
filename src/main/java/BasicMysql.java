// For MySQL

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

// Model class
class StudentModel {
    int    id;
    String name;
    String fatherName;
    int    age;
    String _class;
    double gpa;

    public StudentModel(int id, String name, String fatherName, int age, String _class, double gpa) {
        this.id = id;
        this.name = name;
        this.fatherName = fatherName;
        this.age = age;
        this._class = _class;
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        // Print record in map format
        Map<String, Object> mapFormatter = new HashMap<>();
        mapFormatter.put("id", id);
        mapFormatter.put("name", name);
        mapFormatter.put("father_name", fatherName);
        mapFormatter.put("age", age);
        mapFormatter.put("class", _class);
        mapFormatter.put("gpa", gpa);
        return mapFormatter.toString();
    }

    public void printElegant() {
        System.out.println(toString());
    }
}

// Mai class
public class BasicMysql {

    public static void main(String[] args) {
        // Database connection parameters
        String url = "jdbc:mysql://localhost:3306/ngp";
        String user = "ngp-user";
        String password = "ngp-pass";

        // Establish a connection to the database
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connected to the database!");

            // Create a statement for executing SQL queries
            Statement statement = connection.createStatement();

            // Example SQL query
            String sqlQuery = "SELECT * FROM students";

            // Execute the query and get the result set
            ResultSet resultSet = statement.executeQuery(sqlQuery);

            // Process the result set (e.g., print data)
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                // Add more columns as needed

                System.out.println("ID: " + id + ", Name: " + name);
                System.out.println("--------\n\nPrint formatted value\n");
                StudentModel stud = new StudentModel(id, name, null, 0, null, 0);
                stud.printElegant();
                System.out.println("================");
            }

        } catch (SQLException e) {
            System.err.println("Database connection error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}