

import java.util.Scanner;

public class zadavani {

    public static int OnlyNumbers(Scanner sc) {
        int cislo = 0;
        try {
            cislo = sc.nextInt();
        } catch (Exception e) {
            System.out.println("Nastala vyjimka typu \n" + e.toString() + "");
            System.out.println("zadejte prosim cele cislo!!!");
            sc.nextLine();
            cislo = OnlyNumbers(sc);
        }
        return cislo;
    }

    public static int Day(Scanner sc) {
        int cislo = 0;
        try {
            cislo = sc.nextInt();
            if (cislo < 1 || cislo > 31){
                throw new RangeException(cislo);
            }
        } catch (RangeException e) {
            System.out.println("wrong date");
            sc.nextLine();
            cislo = Day(sc);
        }
        catch (Exception e) {
            System.out.println("Nastala vyjimka typu \n" + e.toString() + "");
            System.out.println("zadejte prosim cele cislo!!!");
            sc.nextLine();
            cislo = Day(sc);
        }
        return cislo;
    }

    public static int Month(Scanner sc) {
        int cislo = 0;
        try {
            cislo = sc.nextInt();
            if (cislo < 1 || cislo > 12){
                throw new RangeException(cislo);
            }
        } catch (RangeException e) {
            System.out.println("wrong date");
            sc.nextLine();
            cislo = Month(sc);
        }
        catch (Exception e) {
            System.out.println("Nastala vyjimka typu \n" + e.toString() + "");
            System.out.println("zadejte prosim cele cislo!!!");
            sc.nextLine();
            cislo = Month(sc);
        }
        return cislo;
    }

    public static int Year(Scanner sc) {
        int cislo = 0;
        try {
            cislo = sc.nextInt();
            if (cislo < 1900 || cislo > 2100){
                throw new RangeException(cislo);
            }
        } catch (RangeException e) {
            System.out.println("wrong date");
            sc.nextLine();
            cislo = Year(sc);
        }
        catch (Exception e) {
            System.out.println("Nastala vyjimka typu \n" + e.toString() + "");
            System.out.println("zadejte prosim cele cislo!!!");
            sc.nextLine();
            cislo = Year(sc);
        }
        return cislo;
    }

    public static int Grade(Scanner sc) {
        int cislo = 0;
        try {
            cislo = sc.nextInt();
            if (cislo < 1 || cislo > 5){
                throw new RangeException(cislo);
            }
        } catch (RangeException e) {
            System.out.println("wrong range");
            sc.nextLine();
            cislo = Grade(sc);
        }
        catch (Exception e) {
            System.out.println("Nastala vyjimka typu \n" + e.toString() + "");
            System.out.println("zadejte prosim cele cislo!!!");
            sc.nextLine();
            cislo = Grade(sc);
        }
        return cislo;
    }
}
