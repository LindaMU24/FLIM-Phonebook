public class PhoneNumber {
    private String number;
    private String type;
    public PhoneNumber(String number, String type) {
        this.number = number;
        this.type = type;
    }
    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type.substring(0,1).toUpperCase() + type.substring(1).toLowerCase() + " number: " + number;
    }
}
