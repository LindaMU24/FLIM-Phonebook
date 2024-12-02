import input.InputHandler;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ProfileHandler {
    static List<Profile> profileList = new ArrayList<>();
    static List<PhoneNumber> phoneNumbers = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in); // tabort när int inputhandler kommer
public static void addProfile(){

    System.out.println("##   Add profile   ##");
    System.out.println("Enter the firstname of the person: ");
    String firstName = InputHandler.getFirstName();
    System.out.println("Enter the lastname of the person: ");
    String lastName = InputHandler.getLastName();
    System.out.println("Enter the age of the person: ");
    int age = InputHandler.getAge();

    addPhoneNumbers(scanner);

    System.out.println("Enter the city: ");
    String city = InputHandler.getCity();
    System.out.println("Enter the zipcode: ");
    String zipcode = InputHandler.getZipCode();        // change from int to string
    System.out.println("Enter the streetname: ");
    String streetName = InputHandler.getStreetName();
    System.out.println("Enter the streetnumber: ");
    String streetNumber = InputHandler.getStreetNumber();

    Address address = new Address(city, zipcode, streetName, streetNumber);
    profileList.add(new Profile(firstName, lastName, age, phoneNumbers, address));
    System.out.println("Added profile: " + profileList + "\n");
}

    public List<Profile> getProfileList() {
        return profileList;
    }

    public static void addPhoneNumbers(Scanner scanner){
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

    public static void deleteProfile(){
        System.out.println("##   Delete profile   ##");
        System.out.println("Enter the firstname of the profile you want to delete.");
        String firstName = InputHandler.getFirstName();
for (Iterator<Profile> iterator = profileList.iterator(); iterator.hasNext();) {
    Profile profile = iterator.next();{
        if (profile.getFirstName().equals(firstName)) {
            iterator.remove();
            System.out.println("The profile of " + firstName + " is removed");
            return;
        }
    }
        }   System.out.println(firstName + " profile is not found");
    }






}
