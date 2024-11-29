import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProfileHandler {
    static List<Profile> profileList = new ArrayList<>();
    static List<PhoneNumber> phoneNumbers = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
public static void addProfile(){

    System.out.println("##   Add profile   ##");
    System.out.println("Enter the firstname of the person: ");
    String firstName = InputHandler.getToString();
    System.out.println("Enter the lastname of the person: ");
    String lastName = InputHandler.getToString();
    System.out.println("Enter the age of the person: ");
    int age = scanner.nextInt(); //kommer en ny för int

    addPhoneNumbers(scanner);

    System.out.println("Enter the city: ");
    String city = InputHandler.getToString();
    System.out.println("Enter the zipcode: ");
    int zipcode = scanner.nextInt();
    System.out.println("Enter the streetname: ");
    String streetName = InputHandler.getToString();
    System.out.println("Enter the streetnumber: ");
    String streetNumber = InputHandler.getToString();

    Address address = new Address(city, zipcode, streetName, streetNumber);
    profileList.add(new Profile(firstName, lastName, age, phoneNumbers, address));
    System.out.println(profileList);
}

    public List<Profile> getProfileList() {
        return profileList;
    }

    public static void addPhoneNumbers(Scanner scanner){
    boolean addMoreNumbers = true;
    while (addMoreNumbers){
        System.out.println("Enter the phonenumber: ");
        String phoneNumber = InputHandler.getToString();
        System.out.println("Enter type of number (mobile, home, work): ");
        String type = InputHandler.getToString();

        phoneNumbers.add(new PhoneNumber(phoneNumber, type));

        System.out.println("Do you want to add a another number? Y/N");
        String response = InputHandler.getToString();

        if (!response.equalsIgnoreCase("Y")){
            addMoreNumbers = false;}
    }

    }

    public void updateProfile(){

    }

    public void deleteProfile(){

    }
}
