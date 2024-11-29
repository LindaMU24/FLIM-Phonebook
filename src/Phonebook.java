import java.util.ArrayList;
import java.util.List;
public class Phonebook {

    private static List<Profile> profiles = new ArrayList<>();
    public static void run(){

        addInitialProfilesToList();

    }

    static List<Profile> getProfiles(){return profiles;} //I need that for print list

    public static void addInitialProfilesToList(){
        List<PhoneNumber> phoneNumbers = new ArrayList<>();
        phoneNumbers.add(new PhoneNumber("0123456789", "work"));
        phoneNumbers.add(new PhoneNumber("986532875421", "home"));
        profiles.add(new Profile("Fredrik", "Andersson", 38, phoneNumbers,new Address("Väderstad", 59636, "Folkungavägen", "1B")));
        profiles.add(new Profile("Bill", "Andersson", 38, phoneNumbers,new Address("Väderstad", 59636, "Folkungavägen", "1B")));
        profiles.add(new Profile("Liz", "Andersson", 38, phoneNumbers,new Address("Väderstad", 59636, "Folkungavägen", "1B")));
        profiles.add(new Profile("Bob", "Andersson", 38, phoneNumbers,new Address("Väderstad", 59636, "Folkungavägen", "1B")));
        profiles.add(new Profile("Ned", "Andersson", 38, phoneNumbers,new Address("Väderstad", 59636, "Folkungavägen", "1B")));
        profiles.add(new Profile("Beth", "Andersson", 38, phoneNumbers,new Address("Väderstad", 59636, "Folkungavägen", "1B")));
        profiles.add(new Profile("Zid", "Andersson", 38, phoneNumbers,new Address("Väderstad", 59636, "Folkungavägen", "1B")));
    }

}