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
            if(scanner.hasNextInt()){
                int input = scanner.nextInt();
                if (input >= min && input <= max) {
                    scanner.nextLine();
                    return input;
                }
            }
            scanner.nextLine();
            System.out.println("Invalid input. Enter an Integer between " + min + " and " + max + ".");
        }
    }

    public static String getFirstName() {
        while (true) {
            String answer = scanner.nextLine();
            if (!answer.isEmpty() && answer.length() <= 40 && containsValidCharactersForName(answer)) {
                return answer;
            }
            System.out.println("Invalid input! Maximum length 40 characters. Letters only.");
        }
    }

    public static String getLastName() {
        while(true) {
            String answer = scanner.nextLine();
            if (!answer.isEmpty() && answer.length() <= 50 && containsValidCharactersForName(answer) ) {
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


    /**
     * Use to let the user select of which type the phone number is when adding or updating a number.
     * @return Returns a String with the selected type of phone number. String then used in profile.PhoneNumber-constructor.
     */
    public static String getTypeNumber() {
        System.out.println("Select the type of phone number:");
        System.out.println("1. Mobile");
        System.out.println("2. Home");
        System.out.println("3. Work");
        int phoneTypePick = InputHandler.getIntInRange(1, 3);
        String type = "";
        switch (phoneTypePick) {
            case 1:
                type = "mobile";
                break;
            case 2:
                type = "home";
                break;
            case 3:
                type = "work";
                break;
            default:
                System.out.println("Invalid input! Please enter 'mobile', 'home' or 'work'.");
                break;
        }
        return type;
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
            System.out.println("Please enter a valid choice. Yes/No ");
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
            answer = scanner.next();
        }
        return answer;
    }

    public static String getFreeSearch() {
        String answer = scanner.next();
        while (answer.isEmpty() || answer.length() > 100) {
            System.out.println("Invalid input! Maximum length 100 characters!");
            answer = scanner.next();
        }
        return answer;
    }

    /**
     *
     * @param input String to check if it does not contain
     *             anything other than  the specified characters
     *              (letters, ¨, ^, ~, ´, `, -, :, "space" )
     * @return  Returns true if the provided string does not
     *          contain anything other than the permitted characters.
     */
    private static boolean containsValidCharactersForName(String input){
        boolean result = false;
        for(int i = 0; i < input.length(); i++) {
            if(Character.isLetter(input.charAt(i)) ||
                    input.charAt(i) == '¨'  ||
                    input.charAt(i) == '^' ||
                    input.charAt(i) == '~' ||
                    input.charAt(i) == '´' ||
                    input.charAt(i) == '`' ||
                    input.charAt(i) == '-' ||
                    input.charAt(i) == ':' ||
                    input.charAt(i) == ' ') {
                result = true;
            } else {
                result = false;
                break;
            }
        }
        return result;
    }
}
