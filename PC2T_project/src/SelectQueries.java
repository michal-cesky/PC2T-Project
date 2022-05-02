import db.DBConnection;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class SelectQueries {

    public static Seznam selectUser() {
        Connection conn = DBConnection.getDBConnection();
        Seznam mojeDatabaze = new Seznam();

        String selectUser = "SELECT id, name, surname, day, month, year, grupe, grade FROM student";

        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(selectUser);

            while (rs.next()) {

                String grades = rs.getString("grade");

                String[] gradearry = grades.split(", ");

                try {
                Integer[] arr2 = Stream.of(gradearry).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);         //strig array to int array
                for (int i = 0; i < arr2.length; i++) {
                }

                List<Integer> intList = null;

                intList = new ArrayList<Integer>(arr2.length);
                for (int i : arr2) {
                    intList.add(i);
                }

                mojeDatabaze.addtoHashMapfromSQL(rs.getInt("id"), new Obor(rs.getInt("id"), rs.getString("name"), rs.getString("surname"), rs.getInt("day"), rs.getInt("month"), rs.getInt("year"), rs.getString("grupe")));

                mojeDatabaze.setGradefromSQL(rs.getInt("id"),intList);

                } catch (NumberFormatException e) {
                    mojeDatabaze.addtoHashMapfromSQL(rs.getInt("id"), new Obor(rs.getInt("id"), rs.getString("name"), rs.getString("surname"), rs.getInt("day"), rs.getInt("month"), rs.getInt("year"), rs.getString("grupe")));
                }
            }
            return mojeDatabaze;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

