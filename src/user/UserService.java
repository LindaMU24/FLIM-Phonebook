package user;

import data.Phonebook;
import data.RegisteredUsers;
import input.InputHandler;
import profile.Profile;

import java.util.ArrayList;
import java.util.List;

public class UserService {

    public static RegisteredUser currentUser;


        public static RegisteredUser getCurrentUser(){
            return currentUser;
        }

        public static void setCurrentUser(RegisteredUser user){
            UserService.currentUser = user;
        }





        public static void registerUser(){
            System.out.println("Please enter first name:");
            String name = InputHandler.getFirstName();
            String userName = "";
            boolean userExists = true;
            while(userExists){
                System.out.println("Please enter desired username:");
                userName = InputHandler.getFirstName();
                for(RegisteredUser user : RegisteredUsers.getUsers()){
                    if(user.getUserName().equals(name)){
                        System.out.println("User already exists!");
                    } else {
                        userExists = false;
                    }
                }
            }
            System.out.println("Please enter desired password:");
            String password = InputHandler.getFirstName();

            RegisteredUsers.addUser(new RegisteredUser(name, userName, password));

            System.out.println("Thank you for registering, " + name + "!");

        }

    public static boolean checkCredentialsUser(){
        boolean credentialsCheck = false;
        boolean accessGranted = false;
        boolean passwordCheck = false;
        List<RegisteredUser> users = RegisteredUsers.getUsers();
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
                    for (RegisteredUser user : users) {
                        if (user.getUserName().equals(userName)) {
                            index = users.indexOf(user);
                            name = users.get(index).getName();
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
                    if (users.get(index).getPassword().equals(password)) {
                        credentialsCheck = true;
                        accessGranted = true;
                        setCurrentUser(users.get(index));
                        System.out.println("##   Welcome back " + name + "!   ##");
                        break;
                    }
                    System.out.println("Wrong password!");
                }
            }
        }
        return accessGranted;
    }

    public static void deleteFavorite() {
        System.out.println("##   Delete contact   ##");
        System.out.println("Enter the firstname of the contact you want to delete.");
        String firstName = InputHandler.getFirstName();
        List<Profile> matchingProfiles = new ArrayList<>();
        RegisteredUser user = getCurrentUser();
        for (Profile profile : getCurrentUser().getFavorites()) {
            if (profile.getFirstName().equalsIgnoreCase(firstName)) {
                matchingProfiles.add(profile);
            }
        }
        if (matchingProfiles.isEmpty()) {
            System.out.println(firstName + " contact is not found");
            return;
        }
        if(matchingProfiles.size() == 1){
            System.out.println("Contact found: " + matchingProfiles.get(0));
            System.out.println("Do you want to delete this contact? Yes/No");
            boolean response = InputHandler.getYesOrNoResponse();
            if (response) {
                RegisteredUser.removeFromFavorites(matchingProfiles.get(0));

                System.out.println("The contact of " + firstName + " is deleted.\n");
            }else{
                System.out.println("The contact is not deleted.\n");
            } return;
        }
        System.out.println("Multiple contacts found. Please choose which contact you want to delete:");
        for (int i = 0; i < matchingProfiles.size(); i++) {
            System.out.println((i + 1) + ". " + matchingProfiles.get(i));
        }
        System.out.println("0. Exit without deleting anything.");
        System.out.println("Enter the number of the contact you want to delete: ");
        int choice = InputHandler.getIntInRange(0, matchingProfiles.size());
        if(choice == 0){
            System.out.println("Exit without deleting.\n");
            return;}
        choice = choice - 1;
        if (choice >= 0 && choice < matchingProfiles.size()) {
            Profile choosedProfile = matchingProfiles.get(choice);
            RegisteredUser.removeFromFavorites(choosedProfile);
            System.out.println("The contact of " + choosedProfile.getFirstName()+ " " + choosedProfile.getLastName() + " is removed\n");
        } else {
            System.out.println("Invalid choice.");
        }
    }


    public static void addToFavorites() {
        System.out.println("##   Add favorite   ##");
        System.out.println("Enter the firstname of the profile you want to add to your favorites.");
        String firstName = InputHandler.getFirstName();
        List<Profile> matchingProfiles = new ArrayList<>();
        for (Profile profile : Phonebook.getProfiles()) {
            if (profile.getFirstName().equalsIgnoreCase(firstName)) {
                matchingProfiles.add(profile);
            }
        }
        if (matchingProfiles.isEmpty()) {
            System.out.println(firstName + " profile is not found");
            return;
        }
        if(matchingProfiles.size() == 1){
            System.out.println("profile.Profile found: " + matchingProfiles.get(0));
            System.out.println("Do you want to add this profile? Yes/No");
            boolean response = InputHandler.getYesOrNoResponse();
            if (response) {
                UserService.getCurrentUser().addToFavorites(matchingProfiles.get(0));

                System.out.println("The profile of " + firstName + " is added.\n");
            }else{
                System.out.println("The profile is not added.\n");
            } return;
        }
        System.out.println("Multiple profiles found. Please choose which profile you want to add:");
        for (int i = 0; i < matchingProfiles.size(); i++) {
            System.out.println((i + 1) + ". " + matchingProfiles.get(i));
        }
        System.out.println("0. Exit without adding anything.");
        System.out.println("Enter the number of the profile you want to add: ");
        int choice = InputHandler.getIntInRange(0, matchingProfiles.size());
        if(choice == 0){
            System.out.println("Exit without adding.\n");
            return;}
        choice = choice - 1;
        if (choice >= 0 && choice < matchingProfiles.size()) {
            Profile choosedProfile = matchingProfiles.get(choice);
            UserService.getCurrentUser().addToFavorites(choosedProfile);

            System.out.println("The profile of " + choosedProfile.getFirstName()+ " " + choosedProfile.getLastName() + " is added\n");
        } else {
            System.out.println("Invalid choice.");
        }
    }






    }
//