package user;

public class AdminUser extends User {

    private String userName;
    private String password;

    public AdminUser(String name, String userName, String password) {
        super(name);
        this.userName = userName;
        this.password = password;
    }

    /**
     *  Get the username
     * @return Returns username as String.
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Get the password
     * @return Returns the password as String.
     */
    public String getPassword() {
        return password;
    }
}
