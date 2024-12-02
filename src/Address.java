public class Address {

    private String city;
    private String zipCode;
    private String streetName;
    private String streetNumber;

    public Address() {
    }

    public Address(String city, String zipCode, String streetName, String streetNumber){
        this.city = city;
        this.zipCode = zipCode;
        this.streetName = streetName;
        this.streetNumber = streetNumber;

    }

    public Address(String väderstad, int i, String folkungavägen, String streetNumber) {
    } // temporary solution

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;}

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;}

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;}

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;}

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", zipCode=" + zipCode +
                ", streetName='" + streetName + '\'' +
                ", streetNumber='" + streetNumber + '\'' +
                '}';
    }

    //Här kommer en test kommentar för att kolla att det funkar att pusha
}
