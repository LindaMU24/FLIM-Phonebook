package data;

import profile.Address;
import profile.PhoneNumber;
import profile.Profile;
import user.RegisteredUser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RegisteredUsers {

    private static RegisteredUsers instance;
    private static List<RegisteredUser> users = new ArrayList<>();
    private static String filename = "users.txt";

    private RegisteredUsers() {
    }

    public static RegisteredUsers getInstance() {
        if (instance == null) {
            instance = new RegisteredUsers();
            addInitialMember();
        }
        return instance;
    }

//    public static List<Profile> getProfiles() {
//        return profiles;
//    }
//
//    public static void addProfile(Profile profile) {
//        profiles.add(profile);
//    }
//
//    public static void removeProfile(Profile profile) {
//        profiles.remove(profile);
//    }


    public static void addInitialMember() {
        List<Profile> profiles = new ArrayList<>();
        profiles.add(Phonebook.getProfiles().get(0));
        profiles.add(Phonebook.getProfiles().get(1));
        users.add(new RegisteredUser("Fredrik", "fredrik", "fredrik", profiles));
    }


    public static void writeUsers() {
        try (FileWriter writer = new FileWriter(filename)) {
            for (RegisteredUser user : users) {
                writer.write("#USERBEGIN\n");
                writer.write((user.getName()) + "\n");
                writer.write((user.getUserName()) + "\n");
                writer.write((user.getPassword()) + "\n");
                writer.write("#FAVORITESBEGIN\n");
                for (Profile profile : RegisteredUser.getFavorites()) {
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
                writer.write("#FAVORITESEND\n");
                writer.write("#USEREND\n");
            }
        } catch (IOException _) {
            System.err.print("Error writing to file " + filename + ".");
        }
    }

    public static void readUsers() {
        List<RegisteredUser> tempUsers = new ArrayList<>();
        try {
            File file = new File(filename);
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                reader.nextLine(); // "#USERBEGIN"
                String name = reader.nextLine();
                String userName = reader.nextLine();
                String password = reader.nextLine();
                String readLine = reader.nextLine();
                ArrayList<Profile> profiles = new ArrayList<>();
                if (!readLine.equals("#FAVORITESEND")) {
                    do {
                        reader.nextLine();
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
                        profiles.add(new Profile(firstName, lastName, age, phoneNumbers, new Address(city, zipCode, streetName, streetNumber)));
                        readLine = reader.nextLine();
                    } while (!readLine.equals("#PROFILEEND"));
                    tempUsers.add(new RegisteredUser(name, userName, password, profiles));

                }
            }
            users = tempUsers;
            reader.close();
        } catch (FileNotFoundException _) {
            System.out.println("Error reading from file " + filename + ".");
        }
    }
}
