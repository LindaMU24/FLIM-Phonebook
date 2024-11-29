import java.util.ArrayList;
import java.util.List;
public class Phonebook {

    private static List<Profile> profiles = new ArrayList<>();
    public static boolean run(){

        addInitialProfilesToList();

        return false;
    }

    static List<Profile> getProfiles(){return profiles;} //I need that for print list

    public static boolean addInitialProfilesToList(){
        ProfileHandler ph = new ProfileHandler();
        List<PhoneNumber> phoneNumbers = new ArrayList();
        phoneNumbers.add(new PhoneNumber("0123456789", "work"));
        phoneNumbers.add(new PhoneNumber("986532875421", "home"));
        ph.addToProfileList(new Profile("Fredrik", "Andersson", 38, phoneNumbers,new Address("Väderstad", 59636, "Folkungavägen", "1B")));
        ph.addToProfileList(new Profile("Bill", "Andersson", 38, phoneNumbers,new Address("Väderstad", 59636, "Folkungavägen", "1B")));
        ph.addToProfileList(new Profile("Liz", "Andersson", 38, phoneNumbers,new Address("Väderstad", 59636, "Folkungavägen", "1B")));
        ph.addToProfileList(new Profile("Bob", "Andersson", 38, phoneNumbers,new Address("Väderstad", 59636, "Folkungavägen", "1B")));
        ph.addToProfileList(new Profile("Ned", "Andersson", 38, phoneNumbers,new Address("Väderstad", 59636, "Folkungavägen", "1B")));
        ph.addToProfileList(new Profile("Beth", "Andersson", 38, phoneNumbers,new Address("Väderstad", 59636, "Folkungavägen", "1B")));
        ph.addToProfileList(new Profile("Zid", "Andersson", 38, phoneNumbers,new Address("Väderstad", 59636, "Folkungavägen", "1B")));
        return false;
    }

}