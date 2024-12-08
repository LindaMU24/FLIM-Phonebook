import data.RegisteredUsers;
import input.*;
import profile.Profile;
import profile.ProfileHandler;
import profile.SearchProfile;
import user.AdminUser;
import user.RegisteredUser;
import user.User;
import user.UserService;

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

    public static void loginUser(){

    }

    private static void nonAdminMenu(){
        System.out.println("##   Login   ##");
        System.out.println("1. I have an account.");
        System.out.println("2. I want to register for an account.");
        System.out.println("3. I just want to search the phonebook");
        System.out.println("0. Go back.");
        int choice = InputHandler.getIntInRange(0,3);
        switch(choice) {
            case 1:
                boolean reggedMenu = UserService.checkCredentialsUser();
                while(reggedMenu) {
                    System.out.println("##   Welcome to the phonebook, " + UserService.getCurrentUser().getName() + "!   ##");
                    System.out.println("What do you want to do?\n");
                    System.out.println("1. Search");
                    System.out.println("2. Show favorites");
                    System.out.println("3. Add to favorites");
                    System.out.println("4. Delete from favorites");
                    System.out.println("0. Quit to main menu");
                    UserMenuMode mode = InputHandler.getUserMenu();
                    switch (mode) {
                        case UserMenuMode.SEARCH -> searchMenu();
                        case UserMenuMode.SHOW_FAVORITES -> RegisteredUser.printFavorites();
                        case UserMenuMode.ADD_FAVORITES -> UserService.addToFavorites();
                        case UserMenuMode.REMOVE_FAVORITES -> UserService.deleteFavorite();
                        case UserMenuMode.EXITING -> {
                            System.out.println("Goodbye, " + UserService.getCurrentUser().getName() + "!");
                            reggedMenu = false;
                        }
                    }
                }

//                loginUser();
                break;
            case 2:

                UserService.registerUser();
                break;
            case 3:
            boolean nonRegMenu = true;

                while(nonRegMenu){
                    System.out.println("##   Welcome to the phonebook, !   ##");
                    System.out.println("What do you want to do?\n");
                    System.out.println("1. Search");
                    System.out.println("0. Quit to main menu");
                    UserMenuMode mode = InputHandler.getUserMenu();
                    switch(mode) {
                        case UserMenuMode.SEARCH -> searchMenu();
                        case UserMenuMode.EXITING -> {
                            System.out.println("Goodbye!");
                            nonRegMenu = false;
                        }
                    }
                }

                searchMenu();
                break;
            case 0:
                break;
        }
//        System.out.println("Do you want to login to an account? Yes/No");
//        boolean loggedIn = InputHandler.getYesOrNoResponse();
//        if(loggedIn){

//
//        } else if (!loggedIn) {
//            boolean nonRegMenu = true;
//
//        }

    }

    private static void adminMenu() {
        boolean running = checkCredentials();
        while (running) {
            System.out.println("##   Logged in as administrator   ##");
            System.out.println("What do you want to do?\n");
            System.out.println("1. Search");
            System.out.println("2. Add profile");
            System.out.println("3. Remove profile");
            System.out.println("4. Update profile");
            System.out.println("5. Show all users");
            System.out.println("6. Add new user");
            System.out.println("0. Quit to main menu");
            AdminMenuMode mode = InputHandler.getAdminMenuMode();
            switch(mode) {
                case AdminMenuMode.SEARCH -> searchMenu();
                case AdminMenuMode.ADD -> ProfileHandler.addProfile();
                case AdminMenuMode.REMOVE -> ProfileHandler.deleteProfile();
                case AdminMenuMode.UPDATE -> ProfileHandler.updateProfile();
                case AdminMenuMode.SHOW_USERS -> RegisteredUsers.printAllUsers();
                case AdminMenuMode.ADD_USER -> UserService.registerUser();

                case AdminMenuMode.EXITING -> running = false;
            }
        }
    }

    private static void searchMenu(){
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
            SearchMenuMode mode = InputHandler.getSearchMenuMode();
            switch(mode) {
                case SearchMenuMode.BY_FIRSTNAME -> {
                    System.out.println("##   Search by first name   ##");
                    System.out.println("Please enter the first name of the person you wish to find: ");
                    SearchProfile.searchFirstName(InputHandler.getFirstName());
                }
                case SearchMenuMode.BY_LASTNAME -> {
                    System.out.println("##   Search by last name   ##");
                    System.out.println("Please enter the last name of the person you wish to find: ");
                    SearchProfile.searchLastName(InputHandler.getLastName());
                }
                case SearchMenuMode.BY_ADDRESS -> {
                    System.out.println("##   Search by address   ##");
                    System.out.println("Please enter the address wish to find: ");
                    SearchProfile.searchAddress(InputHandler.getSearchAddress());
                }
                case SearchMenuMode.FREE_SEARCH -> {
                    System.out.println("##   Free search   ##");
                    System.out.println("Please enter the term you wish to search for: ");
                    SearchProfile.searchAll(InputHandler.getFreeSearch());
                }
                case SearchMenuMode.EXITING -> running = false;
            }
        }
    }

    private static boolean checkCredentials(){
        List<AdminUser> adminUsers = new ArrayList<>();
        adminUsers.add(new AdminUser("Fredrik", "fredAdmin", "password"));
        adminUsers.add(new AdminUser("Ivana", "ivanaAdmin", "password"));
        adminUsers.add(new AdminUser("Linda", "lindaAdmin", "password"));
        adminUsers.add(new AdminUser("Madde", "maddeAdmin", "password"));
        adminUsers.add(new AdminUser("Bill", "bill", "bill"));
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