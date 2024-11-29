
import java.util.Scanner;

public class InputHandler {
    public static Scanner scanner = new Scanner(System.in);

    public static int getIntInRange(int min, int max) {
        while (true) {
            while (!(scanner.hasNextInt())) {
                scanner.next();
            }
            int input = scanner.nextInt();
            if (input >= min && input <= max) {
                scanner.nextLine();
                return input;
            }
            System.out.println("write number between " + min + " - " + max);
            scanner.nextLine();


        }
    }
    public static String getToString() {
            return scanner.nextLine();
        }


}
