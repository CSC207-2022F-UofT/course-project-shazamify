package abr.user_change_password_abr;

public class UserChangePasswordUseCase implements UserChangePasswordInputBoundary{
    UserChangePasswordOutputBoundary outputBoundary;
    UserChangePasswordDatabaseGateway databaseGateway;
    public UserChangePasswordUseCase(UserChangePasswordOutputBoundary outputBoundary, UserChangePasswordDatabaseGateway databaseGateway){
        this.outputBoundary = outputBoundary;
        this.databaseGateway = databaseGateway;
    }
    @Override
    public void changePassword(UserChangePasswordRequestModel requestModel) {
        String userName = requestModel.getUserName();
        String passWord = requestModel.getPassword();
        databaseGateway.changePassword(userName, passWord);
        outputBoundary.packageAndPresent(passWord);
    }
}
