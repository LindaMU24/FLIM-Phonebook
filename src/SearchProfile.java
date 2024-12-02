import java.util.List;
import java.util.ArrayList;

public class SearchProfile {
    private static List<Profile> profiles;

    public SearchProfile() {
        this.profiles = Phonebook.getProfiles();
    }

    public static List<Profile> searchFirstName(String firstName) {
        List<Profile> matchingFirstName = new ArrayList<>();
        for (Profile profile : Phonebook.getProfiles()) {
            if (profile.getFirstName().toLowerCase().contains(firstName.toLowerCase())) {
                matchingFirstName.add(profile);
            }
        }
        return matchingFirstName;
    }
    public static List<Profile> searchLastName(String lastName) {
        List<Profile> matchingLastName = new ArrayList<>();
        for (Profile profile : Phonebook.getProfiles()) {
            if (profile.getLastName().toLowerCase().contains(lastName.toLowerCase())) {
                matchingLastName.add(profile);
            }
        }
        return matchingLastName;
    }
    public static List<Profile> searchAddress(String searchString) {
        List<Profile> matchingAddress = new ArrayList<>();
        for (Profile profile : Phonebook.getProfiles()) {
            boolean matchesStreetName = profile.getAddress().getStreetName().toLowerCase().contains(searchString.toLowerCase());
            boolean matchesCity = profile.getAddress().getCity().toLowerCase().contains(searchString.toLowerCase());
            if (matchesStreetName || matchesCity) {
                matchingAddress.add(profile);
            }
        }
        return matchingAddress;
    }
    public static List<Profile> searchAll(String searchString) { //Search firstname, lastname, address
        List<Profile> matchingProfiles = new ArrayList<>();
        for (Profile profile : Phonebook.getProfiles()) {
            boolean matchesFirstName = profile.getFirstName().toLowerCase().contains(searchString.toLowerCase());
            boolean matchesLastName = profile.getLastName().toLowerCase().contains(searchString.toLowerCase());
            boolean matchesAddress = profile.getAddress().toString().toLowerCase().contains(searchString.toLowerCase());

            if (matchesFirstName || matchesLastName || matchesAddress) {
                matchingProfiles.add(profile);
            }
        }
        return matchingProfiles;
    }

}
