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
}
