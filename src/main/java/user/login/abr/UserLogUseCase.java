package user.login.abr;

import user.database.UserLoginDataBaseGateway;
import user.login.screen.UserLogViewModel;

public class UserLogUseCase implements UserLogInputBoundary{
    UserLogOutputBoundary outputBoundary;
    UserLoginDataBaseGateway dataBaseGateway;

    public UserLogUseCase(UserLogOutputBoundary outputBoundary, UserLoginDataBaseGateway dataBaseGateway){
        this.outputBoundary = outputBoundary;
        this.dataBaseGateway = dataBaseGateway;
    }

    @Override
    public UserLogViewModel loginUser(UserLogRequestModel requestModel) {
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
        return outputBoundary.packageAndPresent(ResponseModel);
    }
}
