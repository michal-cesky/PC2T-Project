import db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertQueries {

    public static void insertNewUser(Student student) {

        Connection conn = DBConnection.getDBConnection();

        String insertUser = "INSERT INTO student  " + "(id, name, surname, day, month, year, grupe, grade)" + "VALUES(?,?,?,?,?,?,?,?)";

        try (PreparedStatement prStmt = conn.prepareStatement(insertUser)) {
            prStmt.setInt(1, student.getID());
            prStmt.setString(2, student.getName());
            prStmt.setString(3, student.getSurname());
            prStmt.setInt(4, student.getDay());
            prStmt.setInt(5, student.getMonth());
            prStmt.setInt(6, student.getYear());
            prStmt.setString(7, student.getGrupe());
            prStmt.setString(8, student.saveGradeToDatabaze());

            prStmt.executeUpdate();
            System.out.println("Nový uživatel byl vložen do databáze!");
        } catch (SQLException e) {
            System.out.println("Uživatel už byl vložen nebo jste zadali špatně SQL příkaz INSERT");
            // e.printStackTrace();
        }
    }
        public static void insert (Seznam students){

            for (Student student : students.getValuesHashMap().values()) {
                InsertQueries.insertNewUser(student);
            }

        }


    }


