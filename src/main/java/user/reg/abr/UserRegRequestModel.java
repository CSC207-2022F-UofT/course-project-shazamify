package user.reg.abr;

public class UserRegRequestModel {
    private final String password;
    private final String userName;
    private final String rePassword;

    public UserRegRequestModel(String password, String userName, String rePassword){
        this.password = password;
        this.userName = userName;
        this.rePassword = rePassword;
    }

    public String getPassword() {
        return password;
    }

    public String getRePassword() {
        return rePassword;
    }

    public String getUserName() {
        return userName;
    }
}
