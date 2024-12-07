package data;

import profile.Address;
import profile.PhoneNumber;
import profile.Profile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Phonebook {

    private static Phonebook instance;
    private static List<Profile> profiles = new ArrayList<>();

    private Phonebook() {
    }

    public static Phonebook getInstance() {
        if (instance == null) {
            instance = new Phonebook();
        }
        return instance;
    }

    public static List<Profile> getProfiles() {
        return profiles;
    }

    public static void addProfile(Profile profile) {
        profiles.add(profile);
    }

    public static void removeProfile(Profile profile) {
        profiles.remove(profile);
    }

    public static void writeToFile() {
        try (FileWriter writer = new FileWriter("phonebook.txt")) {
            for (Profile profile : profiles) {
                writer.write("#PROFILEBEGIN\n");
                writer.write(profile.getFirstName() + "\n");
                writer.write(profile.getLastName() + "\n");
                writer.write(profile.getAge() + "\n");
                writer.write("#PHONNUMBERSBEGIN\n");
                for (PhoneNumber number : profile.getPhoneNumber()) {
                    writer.write(number.getNumber() + "\n");
                    writer.write(number.getType() + "\n");
                }
                writer.write("#PHONENUMBEREND\n");
                writer.write(profile.getAddress().getCity() + "\n");
                writer.write(profile.getAddress().getZipCode() + "\n");
                writer.write(profile.getAddress().getStreetName() + "\n");
                writer.write(profile.getAddress().getStreetNumber() + "\n");
                writer.write("#PROFILEEND\n");
            }

        } catch (IOException _) {
            System.err.print("Error writing to file phonebook.txt");
        }
    }

    public static void readFromFile() {
        List<Profile> tempProfiles = new ArrayList<>();

        try {
            File file = new File("phonebook.txt");
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                reader.nextLine(); // "#PROFILEBEGIN"
                String firstName = reader.nextLine();
                String lastName = reader.nextLine();
                int age = Integer.parseInt(reader.nextLine());
                reader.nextLine(); // #PHONENUMBERBEGIN

                String data = reader.nextLine();
                ArrayList<PhoneNumber> phoneNumbers = new ArrayList<>();
                if (!data.equals("#PHONENUMBEREND")) {
                    do {
                        String phoneNumber = data;
                        String type = reader.nextLine();
                        phoneNumbers.add(new PhoneNumber(phoneNumber, type));
                        data = reader.nextLine();

                    } while (!data.equals("#PHONENUMBEREND"));
                }

                String city = reader.nextLine();
                String zipCode = reader.nextLine();
                String streetName = reader.nextLine();
                String streetNumber = reader.nextLine();
                reader.nextLine();
                tempProfiles.add(new Profile(firstName, lastName, age, phoneNumbers, new Address(city, zipCode, streetName, streetNumber)));
            }
            profiles = tempProfiles;
            reader.close();
        } catch (FileNotFoundException _) {
            System.out.println("Error reading from file phonebook.txt");
        }
    }
}
