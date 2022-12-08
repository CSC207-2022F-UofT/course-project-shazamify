package abr.user_change_password_abr;

public class UserCPUseCase implements UserCPInputBoundary {
    UserCPOutputBoundary outputBoundary;
    UserCPDatabaseGateway databaseGateway;
    public UserCPUseCase(UserCPOutputBoundary outputBoundary, UserCPDatabaseGateway databaseGateway){
        this.outputBoundary = outputBoundary;
        this.databaseGateway = databaseGateway;
    }
    @Override
    public void changePassword(UserCPRequestModel requestModel) {
        String userName = requestModel.getUserName();
        String passWord = requestModel.getPassword();
        databaseGateway.changePassword(userName, passWord);
        outputBoundary.packageAndPresent(passWord);
    }
}
