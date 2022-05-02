
import db.DBConnection;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Scanner;
public class Test {

    public static void main(String[] args) throws IOException, SQLException {

        Scanner sc = new Scanner(System.in);
        Seznam mojeDatabaze = new Seznam();

        int id;
        int grade;
        int choice;
        boolean run = true;

        while (run) {
            System.out.println("Vyberte pozadovanou cinnost:");
            System.out.println("1 .. vytvoreni noveho studenta");
            System.out.println("2 .. zadani nove znamky");
            System.out.println("3 .. propusteni studenta");
            System.out.println("4 .. nalezeni studenta");
            System.out.println("5 .. ziskani dovednosti");
            System.out.println("6 .. abecedne razeny vypis");
            System.out.println("7 .. study average in grupes");
            System.out.println("8 .. pocet studentu ve skupinach");
            System.out.println("9 .. save from file");
            System.out.println("10 .. load to file");
            System.out.println("11 .. save to SQL");               //uložení do SQL
            System.out.println("12 .. load from SQL");               //načtení z SQL
            System.out.println("13 .. close app");
            System.out.println("14 .. db connect chack");

            choice = zadavani.OnlyNumbers(sc);
            switch (choice) {
                case 1:
                    System.out.println("1 .. technicky obor");
                    System.out.println("2 .. humanitni obor");
                    System.out.println("3 .. kombinovane studium");
                    String name;
                    String surname;
                    int day;
                    int month;
                    int year;
                    choice = zadavani.OnlyNumbers(sc);
                    switch (choice){
                        case 1:
                            System.out.print("Zadejte name surname datum narozeni (day, month, year) studenta:\n");
                            name = sc.next();
                            surname = sc.next();
                            day = zadavani.Day(sc);
                            month = zadavani.Month(sc);
                            year = zadavani.Year(sc);
                            mojeDatabaze.setStudentTO(name, surname, day, month, year);
                            break;
                        case 2:
                            System.out.print("Zadejte name surname datum narozeni (day, month, year) studenta:\n");
                            name = sc.next();
                            surname = sc.next();
                            day = zadavani.Day(sc);
                            month = zadavani.Month(sc);
                            year = zadavani.Year(sc);
                            mojeDatabaze.setStudentHO(name, surname, day, month, year);
                            break;
                        case 3:
                            System.out.print("Zadejte name surname datum narozeni (day, month, year) studenta:\n");
                            name = sc.next();
                            surname = sc.next();
                            day = zadavani.Day(sc);
                            month = zadavani.Month(sc);
                            year = zadavani.Year(sc);
                            mojeDatabaze.setStudentKS(name, surname, day, month, year);
                            break;
                    }
                    break;
                case 2:
                    Student info = null;
                    System.out.println("Zadejte index studenta");
                    sc.nextLine();
                    id = zadavani.OnlyNumbers(sc);
                    System.out.println("Zadejte znamku");
                    sc.nextLine();
                    grade = zadavani.Grade(sc);
                    mojeDatabaze.setGrade(id, grade);
                    try {
                        System.out.println(mojeDatabaze.getStudent(id));
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("Vybrana polozka mimo rozsah databaze|");
                    } catch (NullPointerException e) {
                        System.out.println("Vybrana polozka neexistuje");
                    }
                    break;

                case 3:
                    System.out.println("Zadejte index studenta");
                    sc.nextLine();
                    id = zadavani.OnlyNumbers(sc);
                    mojeDatabaze.delStudent(id);
                    System.out.println("Student byl propusten");
                    try {
                        System.out.println(mojeDatabaze.getStudent(id));
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("Vybrana polozka mimo rozsah databaze|");
                    } catch (NullPointerException e) {
                        System.out.println("Vybrana polozka neexistuje");
                    }
                    break;
                case 4:
                    System.out.println("Zadejte index studenta");
                    sc.nextLine();
                    id = zadavani.OnlyNumbers(sc);
                    try {
                        System.out.println(mojeDatabaze.getStudent(id));
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("Vybrana polozka mimo rozsah databaze|");
                    } catch (NullPointerException e) {
                        System.out.println("Vybrana polozka neexistuje");
                    }
                    break;
                case 5:
                    System.out.println("Zadejte index studenta");
                    sc.nextLine();
                    id = zadavani.OnlyNumbers(sc);
                    try {
                        System.out.println(mojeDatabaze.getDovednost(id));
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("Vybrana polozka mimo rozsah databaze|");
                    } catch (NullPointerException e) {
                        System.out.println("Vybrana polozka neexistuje");
                    }
                    break;
                case 6:
                    mojeDatabaze.Alphabetic();
                    break;

                case 7:
                    mojeDatabaze.studyAverageSubject();
                    break;

                case 8:
                    mojeDatabaze.StudentsCount();
                    break;
                case 9:
                    mojeDatabaze.SaveToFile();
                    break;

                case 10:
                    mojeDatabaze.LoadFormFile();
                    break;
                case 11:
                    InsertQueries.insert(mojeDatabaze);
                    break;
                case 12:
                    mojeDatabaze = SelectQueries.selectUser();
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