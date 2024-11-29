import java.util.ArrayList;
import java.util.List;

public abstract class User {

    private final String name;

    public User(String name){
        this.name = name;
    }

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
        boolean running = true;
        while(running){
        System.out.println("##   Welcome to the phonebook!   ##");
        System.out.println("What do you want to do?\n");
        System.out.println("1. Search");
        System.out.println("0. Quit to main menu");
        int choice = InputHandler.getIntInRange(0,1);
        switch(choice) {
            case 1 -> searchMenu();
            case 0 -> running = false;
        }
        }
    }


    public static void adminMenu() {
        List<AdminUser> adminUsers = new ArrayList<>();
        adminUsers.add(new AdminUser("fredrik", "fredAdmin", "password"));
        boolean running = true;
        while(true){
            String userName;
            String password;
            while(true) {
                System.out.println("Please enter you username:  ");
                userName = InputHandler.getString();
                for(AdminUser adminUser : adminUsers){
                    if(userName.equals(adminUser.getUserName())){
                        break;
                    }
                    System.out.println("User not found!");
                }
                System.out.println("Please enter you password:  ");
                password = InputHandler.getString();
                for(AdminUser adminUser : adminUsers){
                    if(password.equals(userName.getPassword())){
                        break;
                    }
                    System.out.println("User not found!");
                }
            }


        }
        while (running) {
        System.out.println("##   Welcome to the phonebook!   ##");
        System.out.println("##   Logged in as administrator   ##");
        System.out.println("What do you want to do?\n");
        System.out.println("1. Search");
        System.out.println("2. Add profile");
        System.out.println("3. Remove profile");
        System.out.println("4. Update profile");
        System.out.println("0. Quit to main menu");
        int choice = InputHandler.getIntInRange(0,1);
        switch(choice) {
            case 1 -> searchMenu();
            case 0 -> running = false;
        }
        }
    }

    public static void searchMenu(){
        System.out.println("##   Search   ##");
        System.out.println("Please select search method: \n");
        System.out.println("1. By first name");
        System.out.println("2. By last name");
        System.out.println("3. By address");
        System.out.println("4. Free search");
    }

}
