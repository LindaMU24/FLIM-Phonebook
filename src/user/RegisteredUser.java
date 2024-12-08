package user;

import profile.Profile;

import java.util.ArrayList;
import java.util.List;

public class RegisteredUser extends NonAdminUser implements LoggedInUser{

    private static List<Profile> favorites = new ArrayList<>();
    private String userName;
    private String password;

    public RegisteredUser(String name, String userName, String password) {
        super(name);
        this.userName = userName;
        this.password = password;
        this.favorites = new ArrayList<>();
    }

    public RegisteredUser(String name, String userName, String password, List<Profile> favorites) {
        super(name);
        this.userName = userName;
        this.password = password;
        this.favorites = favorites;
    }

    public static List<Profile> getFavorites() {
        return favorites;
    }

    public static void printFavorites() {
        if(favorites.size() > 0) {
            for (Profile profile : favorites) {
                System.out.println(profile);
            }
        } else {
            System.out.println("No favorites");
        }

    }

    public static void setFavorites(List<Profile> favorites) {
        RegisteredUser.favorites = favorites;
    }

    public static void addToFavorites(Profile profile) {
        RegisteredUser.favorites.add(profile);
    }

    public static void removeFromFavorites(Profile profile) {
        RegisteredUser.favorites.remove(profile);
    }

    @Override
    public String getUserName() {
        return userName;
    }

    @Override
    public String getPassword() {
        return password;
    }


    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String toString() {
        return "\nName: " + getName() +
                "\nUsername: " + userName +
                "\nPassword: " + password;
    }
}
