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
        List<PhoneNumber> phoneNumbersLinaS = new ArrayList<>();
        phoneNumbersLinaS.add(new PhoneNumber("085503332", "home"));
        phoneNumbersLinaS.add(new PhoneNumber("012345678", "work"));
        List<PhoneNumber> phoneNumbersErikJ = new ArrayList<>();
        phoneNumbersErikJ.add(new PhoneNumber("532875421", "home"));
        List<PhoneNumber> phoneNumbersAnnaN = new ArrayList<>();
        phoneNumbersAnnaN.add(new PhoneNumber("+4673444470", "mobile"));
        phoneNumbersAnnaN.add(new PhoneNumber("077666542", "mobile"));
        List<PhoneNumber> phoneNumbersJohanP = new ArrayList<>();
        phoneNumbersJohanP.add(new PhoneNumber("01002000", "work"));
        List<PhoneNumber> phoneNumbersKarinL = new ArrayList<>();
        phoneNumbersKarinL.add(new PhoneNumber("92875421", "home"));
        List<PhoneNumber> phoneNumbersFredrikO = new ArrayList<>();
        phoneNumbersFredrikO.add(new PhoneNumber("05554333", "home"));
        phoneNumbersFredrikO.add(new PhoneNumber("+467200022", "mobile"));
        List<PhoneNumber> phoneNumbersAnnaP = new ArrayList<>();
        phoneNumbersAnnaP.add(new PhoneNumber("66655444", "home"));

        profiles.add(new Profile("Lina", "Svensson", 19, phoneNumbersLinaS,new Address("Stockholm", "12345", "Blåbärsvägen", "12")));
        profiles.add(new Profile("Erik", "Johansson", 28, phoneNumbersErikJ,new Address("Göteborg", "54321", "Lingonstigen", "8")));
        profiles.add(new Profile("Anna", "Nilsson", 38, phoneNumbersAnnaN,new Address("Västerås", "55667", "Hallonvägen", "5")));
        profiles.add(new Profile("Johan", "Lindström", 58, phoneNumbersJohanP,new Address("Uppsala", "11223", "Smultronstigen", "22")));
        profiles.add(new Profile("Sven-André", "H:son-Larson dos Años", 81, phoneNumbersKarinL,new Address("Linköping", "33445", "Körsbärsvägen", "14")));
        profiles.add(new Profile("Fredrik", "Olsson", 22, phoneNumbersFredrikO,new Address("Västerås", "55667", "Lingonstigen", "7")));
        profiles.add(new Profile("Anna", "Persson", 58, phoneNumbersAnnaP,new Address("Örebro", "77889", "Äppelstigen", "9")));
    }

}