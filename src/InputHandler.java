
import java.util.Scanner;

public class InputHandler {


    private static Scanner scanner = new Scanner(System.in);

    // menu which user is admin or guest
    public int readWhichUser() {
        int answer = scanner.nextInt();
        if (answer == 1) {                                   // can just read file (search)
            System.out.println("Welcome guest!\n");
            return 1;
        }
        if (answer == 2) {
            System.out.println("Welcome admin!\n");
            System.out.println("Menu for admin! \n");    // can read (search) and write (update, delete...)file
            return 2;
        } else {
            System.out.println("Invalid input! You are guest!");   // default is guest
        }

        return answer;
    }

    private int getIntInRange(int min, int max) {
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
