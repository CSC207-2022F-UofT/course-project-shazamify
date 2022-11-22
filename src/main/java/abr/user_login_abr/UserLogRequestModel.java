package abr.user_login_abr;

public class UserLogRequestModel {
    private final String username;
    private final String password;

    public UserLogRequestModel(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
}
