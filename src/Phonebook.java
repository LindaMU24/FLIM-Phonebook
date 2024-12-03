import java.util.ArrayList;
import java.util.List;
public class Phonebook {

    private static Phonebook instance;
    private static List<Profile> profiles = new ArrayList<>();

    private Phonebook(){}

    public static Phonebook getInstance(){
        if( instance == null){
            instance = new Phonebook();
            addInitialProfilesToList();
        }
        return instance;
    }

    public static List<Profile> getProfiles(){
        return profiles;
    }

    public static void addProfile(Profile profile){
        profiles.add(profile);
    }

    public static void removeProfile(Profile profile){
        profiles.remove(profile);
    }

    // This is only used to populate the list of contacts at the start of the program.
    private static void addInitialProfilesToList(){
        List<PhoneNumber> phoneNumbers = new ArrayList<>();
        phoneNumbers.add(new PhoneNumber("0123456789", "work"));
        phoneNumbers.add(new PhoneNumber("986532875421", "home"));
        profiles.add(new Profile("Lisa", "Svensson", 19, phoneNumbers,new Address("Stockholm", "12345", "Blåbärsvägen", "12")));
        profiles.add(new Profile("Erik", "Johansson", 28, phoneNumbers,new Address("Göteborg", "54321", "Lingonstigen", "8")));
        profiles.add(new Profile("Anna", "Nilsson", 38, phoneNumbers,new Address("Västerås", "55667", "Hallonvägen", "5")));
        profiles.add(new Profile("Johan", "Persson", 58, phoneNumbers,new Address("Uppsala", "11223", "Smultronstigen", "22")));
        profiles.add(new Profile("Karin", "Larsson", 81, phoneNumbers,new Address("Linköping", "33445", "Körsbärsvägen", "14")));
        profiles.add(new Profile("Fredrik", "Olsson", 22, phoneNumbers,new Address("Västerås", "55667", "Lingonstigen", "7")));
        profiles.add(new Profile("Anna", "Persson", 58, phoneNumbers,new Address("Örebro", "77889", "Äppelstigen", "9")));
    }

}