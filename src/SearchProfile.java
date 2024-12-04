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
                break; // Kommentera bort denna rad om man vill visa alla sökresultat
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

    public static void searchAll(String searchString) {
        List<Profile> matchingProfiles = new ArrayList<>();
        boolean isNumeric = searchString.matches("[+]?[0-9]+"); //Allow search to include +

        for (Profile profile : Phonebook.getProfiles()) {
            boolean matches = false;

            if (!isNumeric) {
                // Focus on textsearch
                matches = profile.getFirstName().toLowerCase().contains(searchString.toLowerCase()) ||
                        profile.getLastName().toLowerCase().contains(searchString.toLowerCase()) ||
                        profile.getAddress().toString().toLowerCase().contains(searchString.toLowerCase());
            } else {
                // Focus on numbersearch
                int searchNumber = Integer.parseInt(searchString);
                matches = profile.getAge() == searchNumber;

                for (PhoneNumber phoneNumber : profile.getPhoneNumber()) {
                    if (phoneNumber.getNumber().contains(searchString)) {
                        matches = true;
                        break;
                    }
                }
            }

            if (matches) {
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
