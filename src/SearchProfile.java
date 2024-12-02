import input.InputHandler;

import java.util.List;
import java.util.ArrayList;

public class SearchProfile {
    private static List<Profile> profiles;

    public SearchProfile() {
        this.profiles = Phonebook.getProfiles();
    }

    public static void searchFirstName(String firstName) {
        List<Profile> matchingFirstName = new ArrayList<>();
        for (Profile profile : Phonebook.getProfiles()) {
            if (profile.getFirstName().toLowerCase().contains(firstName.toLowerCase())) {
                matchingFirstName.add(profile);
            }
        }
        printSearchResult(matchingFirstName);
    }

    public static void searchLastName(String lastName) {
        List<Profile> matchingLastName = new ArrayList<>();
        for (Profile profile : Phonebook.getProfiles()) {
            if (profile.getLastName().toLowerCase().contains(lastName.toLowerCase())) {
                matchingLastName.add(profile);
            }
        }
        printSearchResult(matchingLastName);
    }

    public static void searchAddress(String searchString) {
        List<Profile> matchingAddress = new ArrayList<>();
        for (Profile profile : Phonebook.getProfiles()) {
            boolean matchesStreetName = profile.getAddress().getStreetName().toLowerCase().contains(searchString.toLowerCase());
            boolean matchesCity = profile.getAddress().getCity().toLowerCase().contains(searchString.toLowerCase());
            if (matchesStreetName || matchesCity) {
                matchingAddress.add(profile);
            }
        }
        printSearchResult(matchingAddress);
    }

    public static void searchAll(String searchString) { //Search firstname, lastname, address
        List<Profile> matchingProfiles = new ArrayList<>();
        for (Profile profile : Phonebook.getProfiles()) {
            boolean matchesFirstName = profile.getFirstName().toLowerCase().contains(searchString.toLowerCase());
            boolean matchesLastName = profile.getLastName().toLowerCase().contains(searchString.toLowerCase());
            boolean matchesAddress = profile.getAddress().toString().toLowerCase().contains(searchString.toLowerCase());

            if (matchesFirstName || matchesLastName || matchesAddress) {
                matchingProfiles.add(profile);
            }
        }
        printSearchResult(matchingProfiles);
    }

    public static void printSearchResult(List<Profile> profiles){
        if (!profiles.isEmpty()){
            for(Profile profile : profiles) {
                System.out.println(profile.toString());
            }
        }else {
            System.out.println("No profiles found");
        }
    }
}
