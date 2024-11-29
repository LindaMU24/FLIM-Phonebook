import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProfileHandler {
    Scanner scanner = new Scanner(System.in);
    List<Profile> profileList = new ArrayList<>();
    List<PhoneNumber> phoneNumbers = new ArrayList<>();

public void addProfile(Scanner scanner){

    System.out.println("Enter the firstname of the person: ");
    String firstName = scanner.nextLine();
    System.out.println("enter the lastname of the person: ");
    String lastName = scanner.nextLine();
    System.out.println("Enter the age of the person: ");
    int age = scanner.nextInt();

addPhoneNumbers(scanner);

    System.out.println("Enter the city: ");
    String city = scanner.nextLine();
    System.out.println("Enter the zipcode: ");
    int zipcode = scanner.nextInt();
    System.out.println("Enter the streetname: ");
    String streetName = scanner.nextLine();
    System.out.println("Enter the streetnumber: ");
    String streetNumber = scanner.nextLine();

    Address address = new Address(city, zipcode, streetName, streetNumber);
    profileList.add(new Profile(firstName, lastName, age, phoneNumbers, address));
}

    public List<Profile> getProfileList() {
        return profileList;
    }

    public void addPhoneNumbers(Scanner scanner){
    boolean addMoreNumbers = true;
    while (addMoreNumbers){
        System.out.println("Enter the phonenumber: ");
        String phoneNumber = scanner.nextLine();
        System.out.println("Enter type of number (mobile, home, work): ");
        String type = scanner.nextLine();
        phoneNumbers.add(new PhoneNumber(phoneNumber, type));

        System.out.println("Do you want to add a another number? Y/N");
        String response = scanner.nextLine();

        if (!response.equalsIgnoreCase("Y")){
            addMoreNumbers = false;}
    }

    }

    public void updateProfile(){

    }

    public void deleteProfile(){

    }
}
