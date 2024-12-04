package input;

import java.util.Scanner;

public class InputHandler {
    public static Scanner scanner = new Scanner(System.in);

    public static AccessMode getMode() {
        while (true) {
            while (!(scanner.hasNextInt())) {
                scanner.nextLine();
                System.out.println("Invalid input. Please enter number between 0 and 2");
            }
            int input = scanner.nextInt();
            scanner.nextLine();
            switch (input) {
                case 0:
                    return AccessMode.EXITING;
                case 1:
                    return AccessMode.USER;
                case 2:
                    return AccessMode.ADMIN;
                default:
                    System.out.println("Invalid input. Please enter number between 0 and 2");
            }
        }
    }

    public static UserMenuMode getUserMenu() {
        while (true) {
            while (!(scanner.hasNextInt())) {
                scanner.nextLine();
                System.out.println("Invalid input. Please enter number between 0 and 1");
            }
            int input = scanner.nextInt();
            scanner.nextLine();
            switch (input) {
                case 0:
                    return UserMenuMode.EXITING;
                case 1:
                    return UserMenuMode.SEARCH;
                default:
                    System.out.println("Invalid input. Please enter number between 0 and 1");
            }
        }
    }

    public static AdminMenuMode getAdminMenuMode() {
        while (true) {
            while (!(scanner.hasNextInt())) {
                scanner.nextLine();
                System.out.println("Invalid input. Please enter number between 0 and 4");
            }
            int input = scanner.nextInt();
            scanner.nextLine();
            switch (input) {
                case 0:
                    return AdminMenuMode.EXITING;
                case 1:
                    return AdminMenuMode.SEARCH;
                case 2:
                    return AdminMenuMode.ADD;
                case 3:
                    return AdminMenuMode.REMOVE;
                case 4:
                    return AdminMenuMode.UPDATE;
                default:
                    System.out.println("Invalid input. Please enter number between 0 and 4");
            }
        }
    }

    public static SearchMenuMode getSearchMenuMode() {
        while (true) {
            while (!(scanner.hasNextInt())) {
                scanner.nextLine();
                System.out.println("Invalid input. Please enter number between 0 and 4");
            }
            int input = scanner.nextInt();
            scanner.nextLine();
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
                default:
                    System.out.println("Invalid input. Please enter number between 0 and 4");
            }
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
        while (true) {
            String answer = scanner.nextLine();
            if (!answer.isEmpty() && answer.length() <= 40) {
                return answer;
            }
            System.out.println("Invalid input! Maximum length 40 characters. Letters only.");
        }
    }

    public static String getLastName() {
        while(true) {
            String answer = scanner.nextLine();
            if (!answer.isEmpty() && answer.length() <= 50) {
                return answer;
            }
            System.out.println("Invalid input! Maximum length  50 characters. Letters only.");
        }
    }


    public static byte getAge() {
        while (true) {
            while (!(scanner.hasNextByte())) {
                scanner.next();
                System.out.println("Invalid input! Write your age between 0 - 127");
            }
            byte age = scanner.nextByte();
            if (age >= 0) {
                scanner.nextLine();
                return age;
            }
            System.out.println("Invalid input! Write your age between 0 - 127");
        }
    }

    public static String getCity() {
        while (true) {
            String answer = scanner.nextLine();
            if(!answer.isEmpty() && answer.length() <= 30) {
                return answer;
            }
            System.out.println("Invalid input! Maximum length 30 characters.");
        }
    }

    public static String getZipCode() {
        while (true) {
            String answer = scanner.nextLine();
            if (answer.length() == 5 && Character.isDigit(answer.charAt(0)) &&
                    Character.isDigit(answer.charAt(1)) &&
                    Character.isDigit(answer.charAt(2)) &&
                    Character.isDigit(answer.charAt(3)) &&
                    Character.isDigit(answer.charAt(4))) {
                return answer;
            }
            System.out.println("Invalid input! Input Zip Code as 5 digit number.");
        }
    }

    public static String getStreetName() {
        while(true) {
            String answer = scanner.nextLine();
            if (!answer.isEmpty() && answer.length() <= 20) {
                return answer;
            }
            System.out.println("Invalid input! Maximum length 20 characters.");
        }
    }

    public static String getStreetNumber() {
        while(true){
            String answer = scanner.nextLine();
            if (!answer.isEmpty() && answer.length() <= 5) {
                return answer;
            }
            System.out.println("Invalid input! Maximum length 5 characters.");
        }
    }

    public static String getPhoneNumber() {
        while (true) {
            String answer = scanner.nextLine();
            String phoneNumber = "";
            if ((answer.length() <= 15) && (answer.matches("[0-9]+") || (answer.startsWith("+") && answer.substring(1).matches("[0-9]+")))) {
                for(int i = 0; i < answer.length(); i++) {
                    phoneNumber += answer.charAt(i);
                }
                return phoneNumber;
            }
            System.out.println("Invalid input! Max 15 characters. Only digits allowed. May start with a plus sign.");
        }
    }

    public static String getTypeNumber() {
        while (true) {
            String answer = scanner.nextLine();
            if ((answer.equals("home") || answer.equals("work") || answer.equals("mobile"))) {
                return answer;
            }
            System.out.println("Invalid input! Please enter 'mobile', 'home' or 'work'.");
        }
    }

    public static boolean getYesOrNoResponse() {
        while(true){
            String answer = scanner.nextLine().toLowerCase();
            if(answer.equals("yes") || answer.equals("y")){
                return true;
            }
            if(answer.equals("no") || answer.equals("n")){
                return false;
            }
            System.out.println("Please enter a valid choice. Y/N ");
        }
    }

    public static String getUserName() {
        while(true){
            String answer = scanner.nextLine();
            if(!answer.isEmpty()) {
                return answer;
            }
            System.out.println("Empty is not a valid input!");
        }
    }

    public static String getPassword() {
        while(true){
            String answer = scanner.nextLine();
            if(!answer.isEmpty()) {
                return answer;
            }
            System.out.println("Empty is not a valid input!");
        }
    }

    public static String getSearchAddress() {
        String answer = scanner.next();
        while (answer.isEmpty() || answer.length() > 60) {
            System.out.println("Invalid input! Maximum length 60 characters!");
            answer = scanner.next();            // what conditions must it contain
        }
        return answer;
    }

    public static String getFreeSearch() {
        String answer = scanner.next();
        while (answer.isEmpty() || answer.length() > 100) {
            System.out.println("Invalid input! Maximum length 100 characters!");
            answer = scanner.next();
        }
        return answer;                               // what conditions must it contain
    }
}
