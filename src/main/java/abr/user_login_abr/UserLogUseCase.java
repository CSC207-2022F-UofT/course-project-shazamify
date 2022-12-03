package abr.user_login_abr;

public class UserLogUseCase implements UserLogInputBoundary{
    UserLogOutputBoundary outputBoundary;
    UserLoginDataBaseGateway dataBaseGateway;

    public UserLogUseCase(UserLogOutputBoundary outputBoundary, UserLoginDataBaseGateway dataBaseGateway){
        this.outputBoundary = outputBoundary;
        this.dataBaseGateway = dataBaseGateway;
    }

    @Override
    public void loginUser(UserLogRequestModel requestModel) {
        String userName = requestModel.getUsername();
        String passWord = requestModel.getPassword();

        UserLogResponseModel ResponseModel = new UserLogResponseModel();
        boolean userNameValid = dataBaseGateway.checkValidUserName(userName);
        ResponseModel.setValidUserName(userNameValid);
        if (userNameValid) {
            ResponseModel.setUserPasswordValid(dataBaseGateway.checkValidPassword(userName, passWord));
        } else {
            ResponseModel.setUserPasswordValid(false);
        }
        outputBoundary.packageAndPresent(ResponseModel);
    }
}
