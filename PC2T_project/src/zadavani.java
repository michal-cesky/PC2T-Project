
import java.util.Scanner;

public class zadavani {

    public static int OnlyNumbers(Scanner sc) {
        int number = 0;
        try {
            number = sc.nextInt();
        } catch (Exception e) {
            System.out.println("An exception of type occurred \n" + e.toString() + "");
            System.out.println("Please insert intiger ");
            sc.nextLine();
            number = OnlyNumbers(sc);
        }
        return number;
    }

    public static int Day(Scanner sc) {
        int number = 0;
        try {
            number = sc.nextInt();
            if (number < 1 || number > 31){
                throw new RangeException(number);
            }
        } catch (RangeException e) {
            System.out.println("wrong date");
            sc.nextLine();
            number = Day(sc);
        }
        catch (Exception e) {
            System.out.println("An exception of type occurred \n" + e.toString() + "");
            System.out.println("Please insert intiger ");
            sc.nextLine();
            number = Day(sc);
        }
        return number;
    }

    public static int Month(Scanner sc) {
        int number = 0;
        try {
            number = sc.nextInt();
            if (number < 1 || number > 12){
                throw new RangeException(number);
            }
        } catch (RangeException e) {
            System.out.println("wrong date");
            sc.nextLine();
            number = Month(sc);
        }
        catch (Exception e) {
            System.out.println("An exception of type occurred \n" + e.toString() + "");
            System.out.println("Please insert intiger");
            sc.nextLine();
            number = Month(sc);
        }
        return number;
    }

    public static int Year(Scanner sc) {
        int number = 0;
        try {
            number = sc.nextInt();
            if (number < 1900 || number > 2100){
                throw new RangeException(number);
            }
        } catch (RangeException e) {
            System.out.println("wrong date");
            sc.nextLine();
            number = Year(sc);
        }
        catch (Exception e) {
            System.out.println("An exception of type occurred \n" + e.toString() + "");
            System.out.println("Please insert intiger");
            sc.nextLine();
            number = Year(sc);
        }
        return number;
    }

    public static int Grade(Scanner sc) {
        int number = 0;
        try {
            number = sc.nextInt();
            if (number < 1 || number > 5){
                throw new RangeException(number);
            }
        } catch (RangeException e) {
            System.out.println("wrong range");
            sc.nextLine();
            number = Grade(sc);
        }
        catch (Exception e) {
            System.out.println("An exception of type occurred \n" + e.toString() + "");
            System.out.println("Please insert intiger");
            sc.nextLine();
            number = Grade(sc);
        }
        return number;
    }
}
