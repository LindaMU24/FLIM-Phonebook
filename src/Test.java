import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void testDefaultConstructorOfProfile(){
        List<Profile> profiles = new ArrayList<>();
        profiles.add(new Profile());
    }

    public static void main(String[] args) {
        testDefaultConstructorOfProfile();
        System.out.println("This works!");
    }
}
