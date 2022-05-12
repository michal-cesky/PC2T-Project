
import db.DBConnection;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) throws IOException, SQLException {

        Scanner sc = new Scanner(System.in);
        Seznam myDatabase = new Seznam();

        int id;
        int grade;
        int choice;
        boolean run = true;

        while (run) {
            System.out.println("Vyberte pozadovanou cinnost:");
            System.out.println("1 .. set new student");
            System.out.println("2 .. set new grade");
            System.out.println("3 .. fired student");
            System.out.println("4 .. find student");
            System.out.println("5 .. get skill");
            System.out.println("6 .. alphabetical order extract");
            System.out.println("7 .. study average in groups");
            System.out.println("8 .. students group count");
            System.out.println("9 .. save to file");
            System.out.println("10 .. load from file");
            System.out.println("11 .. save to SQL");
            System.out.println("12 .. load from SQL");
            System.out.println("13 .. close app");
            System.out.println("14 .. db connect chack");

            choice = zadavani.OnlyNumbers(sc);
            switch (choice) {
                case 1:
                    System.out.println("1 .. Technical specialization");
                    System.out.println("2 .. Humanitarian specialization");
                    System.out.println("3 .. Combined specialization");
                    String name;
                    String surname;
                    int day;
                    int month;
                    int year;
                    choice = zadavani.OnlyNumbers(sc);
                    switch (choice){
                        case 1:
                            System.out.print("Insert students name surname birthdate (day, month, year):\n");
                            name = sc.next();
                            surname = sc.next();
                            day = zadavani.Day(sc);
                            month = zadavani.Month(sc);
                            year = zadavani.Year(sc);
                            myDatabase.setStudentTO(name, surname, day, month, year);
                            break;
                        case 2:
                            System.out.print("Insert students name surname birthdate (day, month, year):\n");
                            name = sc.next();
                            surname = sc.next();
                            day = zadavani.Day(sc);
                            month = zadavani.Month(sc);
                            year = zadavani.Year(sc);
                            myDatabase.setStudentHO(name, surname, day, month, year);
                            break;
                        case 3:
                            System.out.print("Insert students name surname birthdate (day, month, year):\n");
                            name = sc.next();
                            surname = sc.next();
                            day = zadavani.Day(sc);
                            month = zadavani.Month(sc);
                            year = zadavani.Year(sc);
                            myDatabase.setStudentKS(name, surname, day, month, year);
                            break;
                    }
                    break;
                case 2:
                    Student info = null;
                    System.out.println("Insert students ID");
                    sc.nextLine();
                    id = zadavani.OnlyNumbers(sc);
                    System.out.println("Set grade");
                    sc.nextLine();
                    grade = zadavani.Grade(sc);
                    myDatabase.setGrade(id, grade);
                    try {
                        System.out.println(myDatabase.getStudent(id));
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("Selected item outside the scope of the database");
                    } catch (NullPointerException e) {
                        System.out.println("The selected istudent does not exist");
                    }
                    break;

                case 3:
                    System.out.println("Insert students ID");
                    sc.nextLine();
                    id = zadavani.OnlyNumbers(sc);
                    myDatabase.delStudent(id);
                    System.out.println("Student was fired");
                    try {
                        System.out.println(myDatabase.getStudent(id));
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("Selected item outside the scope of the database");
                    } catch (NullPointerException e) {
                        System.out.println("The selected istudent does not exist");
                    }
                    break;
                case 4:
                    System.out.println("Insert students ID");
                    sc.nextLine();
                    id = zadavani.OnlyNumbers(sc);
                    try {
                        System.out.println(myDatabase.getStudent(id));
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("Selected item outside the scope of the database");
                    } catch (NullPointerException e) {
                        System.out.println("The selected istudent does not exist");
                    }
                    break;
                case 5:
                    System.out.println("Insert students ID");
                    sc.nextLine();
                    id = zadavani.OnlyNumbers(sc);
                    try {
                        System.out.println(myDatabase.getSkill(id));
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("Selected item outside the scope of the database");
                    } catch (NullPointerException e) {
                        System.out.println("The selected istudent does not exist");
                    }
                    break;
                case 6:
                    myDatabase.Alphabetic();
                    break;

                case 7:
                    myDatabase.studyAverageSubject();
                    break;

                case 8:
                    myDatabase.StudentsCount();
                    break;
                case 9:
                    myDatabase.SaveToFile();
                    break;

                case 10:
                    myDatabase.LoadFormFile();
                    break;
                case 11:
                    InsertQueries.insert(myDatabase);
                    break;
                case 12:
                    myDatabase = SelectQueries.selectUser();
                    break;
                case 13:
                    run = false;
                    break;
                case 14:
                    DBConnection.getDBConnection();
                    break;
            }
        }
    }
}