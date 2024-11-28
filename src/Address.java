public class Address {

    private String city;
    private int zipCode;
    private String streetName;
    private String streetNumber;

    public Address() {
    }

    public Address(String city, int zipCode, String streetName, String streetNumber){
        this.city = city;
        this.zipCode = zipCode;
        this.streetName = streetName;
        this.streetNumber = streetNumber;

    }

    public String getCity() {
        return city;
    }

    public int getZipCode() {
        return zipCode;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getStreetNumber() {
        return streetNumber;
    }
}
