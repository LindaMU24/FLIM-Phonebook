package user;

public class AdminUser extends User {

    private String userName;
    private String password;

    public AdminUser(String name, String userName, String password) {
        super(name);
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}
