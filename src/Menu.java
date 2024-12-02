import input.InputHandler;
import input.AccessMode;
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
            AccessMode mode = InputHandler.getMode();
            switch(mode) {
                case AccessMode.USER -> nonAdminMenu();
                case AccessMode.ADMIN -> adminMenu();
                case AccessMode.EXITING -> running = false;
            }
        }
    }

    public static void nonAdminMenu(){
        System.out.println("Please enter your name: ");
        String name = InputHandler.getFirstName();
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
        boolean running = checkCredentials();
        while (running) {
            System.out.println("##   Logged in as administrator   ##");
            System.out.println("What do you want to do?\n");
            System.out.println("1. Search");
            System.out.println("2. Add profile");
            System.out.println("3. Remove profile");
            System.out.println(". Update profile");
            System.out.println("0. Quit to main menu");
            int choice = InputHandler.getIntInRange(0,3);
            switch(choice) {
                case 1 -> searchMenu();
                case 2 -> ProfileHandler.addProfile();
                case 3 -> ProfileHandler.deleteProfile();
                case 0 -> running = false;
            }
        }
    }

    public static void searchMenu(){
        boolean running = true;
        while(running) {
            List<Profile> search = new ArrayList<>();
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
                    SearchProfile.searchFirstName(InputHandler.getFirstName());
                }
                case 2 -> {
                    System.out.println("##   Search by last name   ##");
                    System.out.println("Please enter the last name of the person you wish to find: ");
                    SearchProfile.searchLastName(InputHandler.getLastName());
                }
                case 3 -> {
                    System.out.println("##   Search by address   ##");
                    System.out.println("Please enter the address wish to find: ");
                    SearchProfile.searchAddress(InputHandler.getFreeSearch());
                }
                case 4 -> {
                    System.out.println("##   Free search   ##");
                    System.out.println("Please enter the term you wish to search for: ");
                    SearchProfile.searchAll(InputHandler.getFreeSearch());
                }
                case 0 -> running = false;
            }
        }
    }

    private static boolean checkCredentials(){
        List<AdminUser> adminUsers = new ArrayList<>();
        adminUsers.add(new AdminUser("Fredrik", "fredAdmin", "password"));
        adminUsers.add(new AdminUser("Ivana", "ivanaAdmin", "password"));
        adminUsers.add(new AdminUser("Linda", "lindaAdmin", "password"));
        adminUsers.add(new AdminUser("Madde", "maddeAdmin", "password"));
        boolean credentialsCheck = false;
        boolean accessGranted = false;
        boolean passwordCheck = false;
        String name = "";
        while(!credentialsCheck) {
            String userName;
            String password;
            int index = 0;
            boolean username = false;
            while (!username) {
                System.out.println("Please enter you username:  ");
                System.out.println("Enter 0(zero) to abort login. ");
                userName = InputHandler.getUserName();
                if (userName.equals("0")) {
                    passwordCheck = true;
                    credentialsCheck = true;
                    break;
                }else {
                    for (AdminUser adminUser : adminUsers) {
                        if (adminUser.getUserName().equals(userName)) {
                            index = adminUsers.indexOf(adminUser);
                            name = adminUsers.get(index).getName();
                            username = true;
                            break;
                        }
                    }
                    if(!username){
                        System.out.println("User not found!");
                    }
                }
            }
            while (!passwordCheck) {
                System.out.println("Please enter you password:  ");
                System.out.println("Enter 0(zero) to abort login. ");
                password = InputHandler.getPassword();
                    if (password.equals("0")) {
                        passwordCheck = true;
                        credentialsCheck = true;
                        break;
                    }else {
                    if (adminUsers.get(index).getPassword().equals(password)) {
                        credentialsCheck = true;
                        accessGranted = true;
                        System.out.println("##   Welcome back " + name + "!   ##");
                        break;
                    }
                    System.out.println("Wrong password!");
                    }
            }
        }
    return accessGranted;
    }

}