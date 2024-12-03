import input.InputHandler;

import java.util.ArrayList;
import java.util.List;


public class ProfileHandler {
    static List<Profile> profileList = new ArrayList<>();
public static void addProfile(){

    System.out.println("##   Add profile   ##");
    System.out.println("Enter the firstname of the person: ");
    String firstName = InputHandler.getFirstName();
    System.out.println("Enter the lastname of the person: ");
    String lastName = InputHandler.getLastName();
    System.out.println("Enter the age of the person: ");
    int age = InputHandler.getAge();

    List<PhoneNumber> phoneNumbers = addPhoneNumbers();

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

    public static List<PhoneNumber> addPhoneNumbers(){
        List<PhoneNumber> phoneNumbers = new ArrayList<>();

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
return phoneNumbers;
    }

    public static void updateProfile() {
        System.out.println("##   Update profile   ##");
        System.out.println("Enter the firstname of the profile you want to update.");
        String firstName = InputHandler.getFirstName();

        List<Profile> matchingProfiles = new ArrayList<>();

        for (Profile profile : Phonebook.getProfiles()) {
            if (profile.getFirstName().equalsIgnoreCase(firstName)) {
                matchingProfiles.add(profile);
            }
        }
        if (matchingProfiles.isEmpty()) {
            System.out.println(firstName + " profile is not found.");
            return;
        }

        if (matchingProfiles.size() == 1) {

            System.out.println("Profile found: " + matchingProfiles.get(0));
            System.out.println("Do you want to update this profile? Yes/No");
            boolean response = InputHandler.getYesOrNoResponse();
            if (response) {
                updateProfileFields(matchingProfiles.get(0));
            } else {
                System.out.println("The profile is not updated.\n");
            }
            return;
        }


        System.out.println("Multiple profiles found. Please choose which profile you want to update:");
        for (int i = 0; i < matchingProfiles.size(); i++) {
            System.out.println((i + 1) + ". " + matchingProfiles.get(i));
        }
        System.out.println("0. Exit without updating anything.");

        System.out.println("Enter the number of the profile you want to update: ");
        int choice = InputHandler.getIntInRange(0, matchingProfiles.size());

        if (choice == 0) {
            System.out.println("Exit without updating");
            return;
        }
        choice = choice - 1;

        updateProfileFields(matchingProfiles.get(choice));
    }


    private static void updateProfileFields(Profile profile){
        System.out.println("What would you like to update?");
        System.out.println("1. First name");
        System.out.println("2. Last name");
        System.out.println("3. Age");
        System.out.println("4. Phone number");
        System.out.println("5. Address");
        System.out.println("0. Cancel");

        int updateChoice = InputHandler.getIntInRange(0, 5);
                switch (updateChoice) {
                    case 1:
                        System.out.println("Enter the new first name:");
                        String newFirstName = InputHandler.getFirstName();
                        profile.setFirstName(newFirstName);
                        break;
                    case 2:
                        System.out.println("Enter the new last name:");
                        String newLastName = InputHandler.getLastName();
                        profile.setLastName(newLastName);
                        break;
                    case 3:
                        System.out.println("Enter the new age:");
                        int newAge = InputHandler.getAge();
                        profile.setAge(newAge);
                        break;
//                    case 4:
//                        System.out.println("Enter the new phone number");
//                        String newPhoneNumber = InputHandler.getPhoneNumber();
//                        System.out.println("Select the type of phone number:");
//                        System.out.println("1. Mobile");
//                        System.out.println("2. Home");
//                        System.out.println("3. Work");
//                        int phoneTypePick = InputHandler.getIntInRange(1, 3);
//                        String phoneType = "";
//                        switch (phoneTypePick) {
//                            case 1:
//                                phoneType = "Mobile";
//                                break;
//                            case 2:
//                                phoneType = "Home";
//                                break;
//                            case 3:
//                                phoneType = "Work";
//                                break;
//                        }
//                        profile.setPhoneNumber(newPhoneNumber, phoneType);
//                        System.out.println("Phone number is updated to " + newPhoneNumber + " " + phoneType);
//                        break;
                    case 5:
                        System.out.println("Enter new address:");
                        System.out.println("City:");
                        String city = InputHandler.getCity();
                        System.out.println("Zipcode:");
                        String zipcode = InputHandler.getZipCode();
                        System.out.println("Streetname:");
                        String streetName = InputHandler.getStreetName();
                        System.out.println("Streetnumber");
                        String streetNumber = InputHandler.getStreetNumber();
                        updateNewAddress(profile, city, zipcode, streetName, streetNumber);
                        break;
                    case 0:
                            System.out.println("No changes made.");
                            return;

                }

    }

//public static void updateNewNumber(Profile profile, String phoneNumber, String phoneType){
//phonenumber = new PhoneNumber(phoneNumber, phoneType);
//profile.addPhoneNumber(phonenumber);
//}
    public static void updateNewAddress(Profile profile, String city, String zipcode, String streetName, String streetNumber){

    Address newAddress = new Address();
    newAddress.setAddress(city, zipcode, streetName, streetNumber);
    profile.setAddress(newAddress);
    System.out.println("Address is updated to: " + streetName + " " + streetNumber + ", " + city + " " + zipcode);
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

        if(matchingProfiles.size() == 1){

            System.out.println("Profile found: " + matchingProfiles.get(0));
            System.out.println("Do you want to delete this profile? Yes/No");
            boolean response = InputHandler.getYesOrNoResponse();
            if (response) {
                System.out.println("The profile of " + firstName + " is deleted.\n");
            }else{
                System.out.println("The profile is not deleted.\n");
            } return;
        }

        System.out.println("Multiple profiles found. Please choose which profile you want to delete:");
        for (int i = 0; i < matchingProfiles.size(); i++) {
            System.out.println((i + 1) + ". " + matchingProfiles.get(i));
        }
        System.out.println("0. Exit without deleting anything.");

        System.out.println("Enter the number of the profile you want to delete: ");
        int choice = InputHandler.getIntInRange(0, matchingProfiles.size());
        if(choice == 0){
            System.out.println("Exit without deleting.\n");
            return;}
        choice = choice - 1 ;

        if (choice >= 0 && choice < matchingProfiles.size()) {
            Profile choosedProfile = matchingProfiles.get(0);

            System.out.println("The profile of " + choosedProfile.getFirstName()+ " " + choosedProfile.getLastName() + " is removed\n");
        } else {
            System.out.println("Invalid choice.");
        }
    }



}
