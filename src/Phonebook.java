import java.io.*;
import java.sql.SQLOutput;
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
            readFromFile();
        }
        return instance;
    }

    public static List<Profile> getProfiles() {
        return profiles;
    }

    public static void addProfile(Profile profile) {
        profiles.add(profile);
        writeToFile();
    }

    public static void removeProfile(Profile profile) {
        profiles.remove(profile);
        writeToFile();
    }

    // This is only used to populate the list of contacts at the start of the program.
    private static void addInitialProfilesToList() {
        List<PhoneNumber> phoneNumbers = new ArrayList<>();
        phoneNumbers.add(new PhoneNumber("0123456789", "work"));
        phoneNumbers.add(new PhoneNumber("986532875421", "home"));
        profiles.add(new Profile("Lisa", "Svensson", 19, phoneNumbers, new Address("Stockholm", "12345", "Blåbärsvägen", "12")));
        profiles.add(new Profile("Erik", "Johansson", 28, phoneNumbers, new Address("Göteborg", "54321", "Lingonstigen", "8")));
        profiles.add(new Profile("Anna", "Nilsson", 38, phoneNumbers, new Address("Västerås", "55667", "Hallonvägen", "5")));
        profiles.add(new Profile("Johan", "Persson", 58, phoneNumbers, new Address("Uppsala", "11223", "Smultronstigen", "22")));
        profiles.add(new Profile("Karin", "Larsson", 81, phoneNumbers, new Address("Linköping", "33445", "Körsbärsvägen", "14")));
        profiles.add(new Profile("Fredrik", "Olsson", 22, phoneNumbers, new Address("Västerås", "55667", "Lingonstigen", "7")));
        profiles.add(new Profile("Anna", "Persson", 58, phoneNumbers, new Address("Örebro", "77889", "Äppelstigen", "9")));
    }

    private static void writeToFile() {

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

    private static void readFromFile() {

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
                profiles.add(new Profile(firstName, lastName, age, phoneNumbers, new Address(city, zipCode, streetName, streetNumber)));
            }
            reader.close();
        } catch (FileNotFoundException _) {
            System.out.println("Error reading from file phonebook.txt");
        }
    }
}
