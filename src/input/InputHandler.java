package input;

import java.util.Scanner;

public class InputHandler {
    public static Scanner scanner = new Scanner(System.in);

    public static AccessMode getMode() {
        while (true) {
            while (!(scanner.hasNextInt())) {
                scanner.next();
            }
            int input = scanner.nextInt();
            switch (input) {
                case 0:
                    return AccessMode.EXITING;
                case 1:
                    return AccessMode.USER;
                case 2:
                    return AccessMode.ADMIN;
            }

            System.out.println("write number between 0 and 2");
            scanner.next();
        }
    }

    public static UserMenuMode getUserMenu() {
        while (true) {
            while (!(scanner.hasNextInt())) {
                scanner.next();
            }
            int input = scanner.nextInt();
            switch (input) {
                case 0:
                    return UserMenuMode.EXITING;
                case 1:
                    return UserMenuMode.SEARCH;

            }

            System.out.println("write number between 0 and 1");
            scanner.next();
        }
    }

    public static AdminMenuMode getAdminMenuMode() {
        while (true) {
            while (!(scanner.hasNextInt())) {
                scanner.next();
            }
            int input = scanner.nextInt();
            switch (input) {
                case 0:
                    return AdminMenuMode.EXITING;
                case 1:
                    return AdminMenuMode.SEARCH;
                case 2:
                    return AdminMenuMode.ADD;
                case 3:
                    return AdminMenuMode.REMOVE;
//                case 4:
//                    return AdminMenuMode.UPDATE;   TODO: uncomment after implementation
            }

            System.out.println("write number between 0 and 4");
            scanner.next();
        }
    }

    public static SearchMenuMode getSearchMenuMode() {
        while (true) {
            while (!(scanner.hasNextInt())) {
                scanner.next();
            }
            int input = scanner.nextInt();
            switch (input) {
                case 0:
                    return SearchMenuMode.EXITING;
                case 1:
                    return SearchMenuMode.BY_FIRSTNAME;
                case 2:
                    return SearchMenuMode.BY_LASTNAME;
                case 3:
                    return SearchMenuMode.BY_ADDRESS;
                case 4:
                    return SearchMenuMode.FREE_SEARCH;
            }

            System.out.println("write number between 0 and 4");
            scanner.next();
        }
    }


    public static int getIntInRange(int min, int max) {
        while (true) {
            while (!(scanner.hasNextInt())) {
                scanner.nextLine();
                System.out.println("Invalid input. Enter an Integer between " + min + " and " + max + ".");
            }
            int input = scanner.nextInt();
            if (input >= min && input <= max) {
                scanner.nextLine();
                return input;
            }
            scanner.next();


        }
    }

    public static String getFirstName() {
        String answer = scanner.next();
        while (answer.isEmpty() || answer.length() > 40) {
            answer = scanner.next();
            System.out.println("Invalid input! Write max 40 characters!");

        }
        return answer;
    }

    public static String getLastName() {
        String answer = scanner.next();
        while (answer.isEmpty() || answer.length() > 50) {
            System.out.println("Invalid input! Write max 50 characters!");
            answer = scanner.next();
        }
        return answer;
    }


    public static byte getAge() {
        while (true) {
            while (!(scanner.hasNextByte())) {
                scanner.next();
                System.out.println("Invalid input! Write your age between 0 - 127");

            }
            byte age = scanner.nextByte();
            if (age >= 0) {
                return age;
            }
            System.out.println("Invalid input! Write your age between 0 - 127");
            scanner.next();
        }

    }

    public static String getCity() {
        String answer = scanner.next();
        while (answer.isEmpty() || answer.length() > 30) {
            System.out.println("Invalid input! Write max 30 characters!");
            answer = scanner.next();
        }
        return answer;
    }

    public static String getZipCode() {
        String answer = scanner.next();
        while (true) {
            if (answer.length() == 5 && Character.isDigit(answer.charAt(0)) &&
                    Character.isDigit(answer.charAt(1)) &&
                    Character.isDigit(answer.charAt(2)) &&
                    Character.isDigit(answer.charAt(3)) &&
                    Character.isDigit(answer.charAt(4))) {
                return answer;
            }

            System.out.println("Invalid input! Write your Zip Code as 5 digit number!");
            scanner.next();
            return answer;

        }
    }

    public static String getStreetName() {
        String answer = scanner.next();
        while (answer.isEmpty() || answer.length() > 20) {
            System.out.println("Invalid input! Write max 20 characters!");
            answer = scanner.next();
        }
        return answer;
    }

    public static String getStreetNumber() {
        String answer = scanner.next();
        while (answer.isEmpty() || answer.length() > 5) {
            System.out.println("Invalid input! Write max 5 characters!");
            answer = scanner.next();
        }
        return answer;
    }

    public static String getPhoneNumber() {
        String answer = scanner.next();
        while (answer.isEmpty() || answer.length() > 15) {
            System.out.println("Invalid input! Write max 15 characters!");
            answer = scanner.next();
        }
        return answer;

    }

    public static String getTypeNumber() {
        String answer = scanner.next();
        while (!(answer.equals("home") || answer.equals("work") || answer.equals("mobile"))) {
            System.out.println("Invalid input! Write 'mobile', 'home', or 'work'!");
            answer = scanner.next();

        }
        return answer;
    }

    public static boolean getYesOrNoResponse() {
        String answer = scanner.next().toLowerCase();
        return answer.equals("yes") || answer.equals("y");
    }

    public static String getUserName() {
        return scanner.next();                 // what conditions must it contain

    }

    public static String getPassword() {
        return scanner.next();                 // what conditions must it contain

    }

    public static String getSearchAddress() {
        String answer = scanner.next();
        while (answer.isEmpty() || answer.length() > 60) {
            System.out.println("Invalid input! Write max 50 characters!");
            answer = scanner.next();            // what conditions must it contain
        }
        return answer;
    }

    public static String getFreeSearch() {
        String answer = scanner.next();
        while (answer.isEmpty() || answer.length() > 100) {
            System.out.println("Invalid input! Write max 100 characters!");
            answer = scanner.next();
        }
        return answer;                               // what conditions must it contain
    }
}
