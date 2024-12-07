package user;

import profile.Profile;

import java.util.ArrayList;
import java.util.List;

public class RegisteredUser extends NonAdminUser implements LoggedInUser{

    private static List<Profile> favorites = new ArrayList<>();


    private String userName;
    private String password;

    public RegisteredUser(String name, String userName, String password, List<Profile> favorites) {
        super(name);
        this.userName = userName;
        this.password = password;
        this.favorites = favorites;
    }

    public static List<Profile> getFavorites() {
        return favorites;
    }

    public static void setFavorites(List<Profile> favorites) {
        RegisteredUser.favorites = favorites;
    }

    public static void addToFavorites(Profile profile) {
        RegisteredUser.favorites.add(profile);
    }

    @Override
    public String getUserName() {
        return "";
    }

    @Override
    public String getPassword() {
        return "";
    }
}
