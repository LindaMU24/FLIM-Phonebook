public class Main {
    public static void main(String[] args) {
        Phonebook.getInstance();
        Phonebook.readFromFile();
        Menu.mainMenu();
        Phonebook.writeToFile();
    }
}