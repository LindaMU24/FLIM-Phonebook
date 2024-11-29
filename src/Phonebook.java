import java.util.ArrayList;
import java.util.List;

public class Phonebook {

    private static List<Profile> profiles = new ArrayList<>();

    public static void run(){

        addInitialProfilesToList();

    }

    public static void addInitialProfilesToList(){
        List<String> phoneNumber = new ArrayList();
        phoneNumber.add("0123456789");
        profiles.add(new Profile("Fredrik", "Andersson", 38, phoneNumber,new Address("Väderstad", 59636, "Folkungavägen", "1B")));
        profiles.add(new Profile("Bill", "Andersson", 38, phoneNumber,new Address("Väderstad", 59636, "Folkungavägen", "1B")));
        profiles.add(new Profile("Liz", "Andersson", 38, phoneNumber,new Address("Väderstad", 59636, "Folkungavägen", "1B")));
        profiles.add(new Profile("Bob", "Andersson", 38, phoneNumber,new Address("Väderstad", 59636, "Folkungavägen", "1B")));
        profiles.add(new Profile("Ned", "Andersson", 38, phoneNumber,new Address("Väderstad", 59636, "Folkungavägen", "1B")));
        profiles.add(new Profile("Beth", "Andersson", 38, phoneNumber,new Address("Väderstad", 59636, "Folkungavägen", "1B")));
        profiles.add(new Profile("Zid", "Andersson", 38, phoneNumber,new Address("Väderstad", 59636, "Folkungavägen", "1B")));
    }
//test
}