import java.util.List;
import java.util.ArrayList;

public class SearchProfile {
    private List<Profile> profiles;

    public SearchProfile() {
        this.profiles = Phonebook.getProfiles();
    }

    public List<Profile> searchFirstName(String firstName) {
        List<Profile> matchingFirstName = new ArrayList<>();
        for (Profile profile : profiles) {
            if (profile.getFirstName().toLowerCase().contains(firstName.toLowerCase())) {
                matchingFirstName.add(profile);
            }
        }
        return matchingFirstName;
    }
    public List<Profile> searchLastName(String lastName) {
        List<Profile> matchingLastName = new ArrayList<>();
        for (Profile profile : profiles) {
            if (profile.getLastName().toLowerCase().contains(lastName.toLowerCase())) {
                matchingLastName.add(profile);
            }
        }
        return matchingLastName;
    }
    public List<Profile> searchAddress(Address address) {
        List<Profile> matchingAddress = new ArrayList<>();
        for (Profile profile : profiles) {
            if (profile.getAddress().equals(address)) {
                matchingAddress.add(profile);
            }
        }
        return matchingAddress;
    }
}
