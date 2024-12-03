import input.InputHandler;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



public class ProfileHandler {
    static List<Profile> profileList = new ArrayList<>();
    static List<PhoneNumber> phoneNumbers = new ArrayList<>();
public static void addProfile(){

    System.out.println("##   Add profile   ##");
    System.out.println("Enter the firstname of the person: ");
    String firstName = InputHandler.getFirstName();
    System.out.println("Enter the lastname of the person: ");
    String lastName = InputHandler.getLastName();
    System.out.println("Enter the age of the person: ");
    int age = InputHandler.getAge();

    addPhoneNumbers();

    System.out.println("Enter the city: ");
    String city = InputHandler.getCity();
    System.out.println("Enter the zipcode: ");
    String zipcode = InputHandler.getZipCode();        // change from int to string
    System.out.println("Enter the streetname: ");
    String streetName = InputHandler.getStreetName();
    System.out.println("Enter the streetnumber: ");
    String streetNumber = InputHandler.getStreetNumber();

    Address address = new Address(city, zipcode, streetName, streetNumber);
    Profile profileToAdd = new Profile(firstName, lastName, age, phoneNumbers, address);
    Phonebook.addProfile(profileToAdd);
    System.out.println("Added profile: " + profileToAdd + "\n");
}

    public List<Profile> getProfileList() {
        return profileList;
    }

    public static void addPhoneNumbers(){
    boolean addMoreNumbers = true;
    while (addMoreNumbers){
        System.out.println("Enter the phonenumber: ");
        String phoneNumber = InputHandler.getPhoneNumber();
        System.out.println("Enter type of number (mobile, home, work): ");
        String type = InputHandler.getTypeNumber();

        phoneNumbers.add(new PhoneNumber(phoneNumber, type));

        System.out.println("Do you want to add a another number? Y/N");
        boolean response = InputHandler.getYesOrNoResponse();

        if (!response){
            addMoreNumbers = false;}
    }

    }

    public void updateProfile(){

    }

    public static void deleteProfile() {
        System.out.println("##   Delete profile   ##");
        System.out.println("Enter the firstname of the profile you want to delete.");
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
        System.out.println("Multiple profiles found. Please choose which profile you want to delete:");
        for (int i = 0; i < matchingProfiles.size(); i++) {
            System.out.println((i + 1) + ": " + matchingProfiles.get(i));
        }
        System.out.println("0. Exit without deleting anything");

        System.out.println("Enter the number of the profile you want to delete: ");
        int choice = InputHandler.getIntInRange(0, matchingProfiles.size());
        if(choice == 0){
            System.out.println("Exit without deleting.");
            return;}
        choice = choice - 1 ;

        if (choice >= 0 && choice < matchingProfiles.size()) {
            System.out.println("The profile of " + firstName +  " is removed\n");
        } else {
            System.out.println("Invalid choice.");


        }


    }
}
