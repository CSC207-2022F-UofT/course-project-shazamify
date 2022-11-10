package user.login.abr;

import user.database.UserDataBaseGateway;
import user.login.screen.UserLogViewModel;

public class UserLogUseCase implements UserLogInputBoundary{
    UserLogOutputBoundary outputBoundary;
    UserDataBaseGateway dataBaseGateway;

    public UserLogUseCase(UserLogOutputBoundary outputBoundary, UserDataBaseGateway dataBaseGateway){
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
