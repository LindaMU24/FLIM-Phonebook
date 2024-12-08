package user;

public class AdminUser extends User implements LoggedInUser{

    private String userName;
    private String password;

    public AdminUser(String name, String userName, String password) {
        super(name);
        this.userName = userName;
        this.password = password;
    }

    @Override
    public String getUserName() {
        return userName;
    }

    @Override
    public String getPassword() {
        return password;
    }
}
