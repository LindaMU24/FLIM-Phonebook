import data.Phonebook;
import data.RegisteredUsers;

public class Main {
    public static void main(String[] args) {
        Phonebook.getInstance();
        RegisteredUsers.readUsers();
        Phonebook.readFromFile();
        RegisteredUsers.getInstance();
        Menu.mainMenu();
        Phonebook.writeToFile();
//        RegisteredUsers.writeUsers();
    }
}