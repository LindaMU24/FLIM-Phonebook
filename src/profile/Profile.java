package profile;

import java.util.List;

//variabler
public class Profile {
    private String firstName;
    private String lastName;
    private int age;
    private List<PhoneNumber> phoneNumbers;
    private Address address;

    public Profile() {
    }

    public Profile(String firstName, String lastName, int age, List<PhoneNumber> phoneNumbers, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.phoneNumbers = phoneNumbers;
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<PhoneNumber> getPhoneNumber() {
        return phoneNumbers;
    }

    public void setPhoneNumber(List<PhoneNumber> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    private String printPhoneNumbers() {
        String phoneNumbersString = "";
        for (int i = 0; i < phoneNumbers.size(); i++) {
            phoneNumbersString += phoneNumbers.get(i);
            if (i != phoneNumbers.size() - 1){
                phoneNumbersString += "\n";
            }
        }
        return phoneNumbersString;
    }

    @Override
    public String toString() {
        return "\n" + firstName + " " + lastName + ", " + age +
                "\n" + address +
                "\n" + printPhoneNumbers();

    }

}
