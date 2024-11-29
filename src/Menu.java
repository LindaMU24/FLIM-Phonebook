import user.AdminUser;

import java.util.ArrayList;
import java.util.List;

public abstract class Menu {

    public static void mainMenu(){
        boolean running = true;
        while(running){
            System.out.println("##   Login   ##");
            System.out.println("1. User");
            System.out.println("2. Admin");
            System.out.println("0. Exit");
            int choice = InputHandler.getIntInRange(0,2);
            switch(choice) {
                case 1 -> nonAdminMenu();
                case 2 -> adminMenu();
                case 0 -> running = false;
            }
        }
    }

    public static void nonAdminMenu(){
        System.out.println("Please enter your name: ");
        String name = InputHandler.getToString();
        boolean running = true;
        while(running){
            System.out.println("##   Welcome to the phonebook, " + name + "!   ##");
            System.out.println("What do you want to do?\n");
            System.out.println("1. Search");
            System.out.println("0. Quit to main menu");
            int choice = InputHandler.getIntInRange(0,1);
            switch(choice) {
                case 1 -> searchMenu();
                case 0 -> {
                    System.out.println("Goodbye, " + name + "!");
                    running = false;
                }
            }
        }
    }

    public static void adminMenu() {
        List<AdminUser> adminUsers = new ArrayList<>();
        adminUsers.add(new AdminUser("fredrik", "fredAdmin", "password"));
        boolean running = true;
        boolean credentialsCheck = false;
        String name = "";
        while(!credentialsCheck) {
            String userName;
            String password;
            int index = 0;
            boolean username = false;
            while (!username) {
                System.out.println("Please enter you username:  ");
                userName = InputHandler.getToString();
                for (AdminUser adminUser : adminUsers) {
                    if (adminUser.getUserName().equals(userName)) {
                        index = adminUsers.indexOf(adminUser);
                        name = adminUsers.get(index).getName();
                        username = true;
                        break;
                    }
                    System.out.println("user.User not found!");
                }

            }
            while (true) {
                System.out.println("Please enter you password:  ");
                password = InputHandler.getToString();
                if (adminUsers.get(index).getPassword().equals(password)) {
                    credentialsCheck = true;
                    break;
                }
                System.out.println("Wrong password!");
            }
        }
        while (running) {
            System.out.println("##   Welcome back " + name + "!   ##");
            System.out.println("##   Logged in as administrator   ##");
            System.out.println("What do you want to do?\n");
            System.out.println("1. Search");
            System.out.println("2. Add profile");
            System.out.println(". Remove profile");
            System.out.println(". Update profile");
            System.out.println("0. Quit to main menu");
            int choice = InputHandler.getIntInRange(0,1);
            switch(choice) {
                case 1 -> searchMenu();
                case 2 -> ProfileHandler.addProfile();
                case 0 -> running = false;
            }
        }
    }

    public static void searchMenu(){
        boolean running = true;
        while(running) {
            System.out.println("##   Search   ##");
            System.out.println("Please select search method: \n");
            System.out.println("1. By first name");
            System.out.println("2. By last name");
            System.out.println("3. By address");
            System.out.println("4. Free search");
            System.out.println("0. Go back");
            int choice = InputHandler.getIntInRange(0,4);
            switch(choice) {
                case 1 -> {
                    System.out.println("##   Search by first name   ##");
                    System.out.println("Please enter the first name of the person you wish to find: ");
                    String query = InputHandler.getToString();
//                    SearchProfile.searchFirstName(query); // Uncomment this line when the method is implemented
                }
                case 2 -> {
                    System.out.println("##   Search by last name   ##");
                    System.out.println("Please enter the last name of the person you wish to find: ");
                    String query = InputHandler.getToString();
//                    SearchProfile.searchLastName(query); // Uncomment this line when the method is implemented
                }
                case 3 -> {
                    System.out.println("##   Search by address   ##");
                    System.out.println("Please enter the address wish to find: ");
                    String query = InputHandler.getToString();
//                    SearchProfile.searchAddress(query); // Uncomment this line when the method is implemented
                }
                case 4 -> {
                    System.out.println("##   Free search   ##");
                    System.out.println("Please enter the term you wish to search for: ");
                    String query = InputHandler.getToString();
//                    SearchProfile.searchAll(query); // Uncomment this line when the method is implemented
                }
                case 0 -> running = false;
            }
        }
    }
}