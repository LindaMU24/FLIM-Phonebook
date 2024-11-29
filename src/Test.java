import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void testDefaultConstructorOfProfile(){
        List<Profile> profiles = new ArrayList<>();
        profiles.add(new Profile());
    }

    public static void testProfileConstructor(){
        Phonebook.addInitialProfilesToList();
        List<Profile> profiles = Phonebook.getProfiles();
        System.out.println(profiles.toString() + "\n");
    }

    public static void main(String[] args) {
        testDefaultConstructorOfProfile();
        testProfileConstructor();
        System.out.println("This works!");
    }
}
