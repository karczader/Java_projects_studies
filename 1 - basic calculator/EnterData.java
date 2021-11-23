import java.util.Scanner;

public class EnterData {
    public static String enterStringValue() {
        System.out.println("Choice: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static double enterDoubleValue() {
        System.out.println("Enter length: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextDouble();
    }

}
