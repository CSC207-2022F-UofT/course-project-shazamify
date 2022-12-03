package abr.user_login_abr;

import entities.user_entities.User;

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

        UserLogResponseModel responseModel = new UserLogResponseModel();

        checkIfUserAndPasswordValid(userName, passWord, responseModel);

        // If both the username and password is valid, update the UserStatusViewModel
        if (responseModel.isValidUserName() && responseModel.isUserPasswordValid()){
            User loggedInUser = dataBaseGateway.getUser(requestModel.getUsername());
            // Set all User Information
            setUpUser(responseModel, loggedInUser);
        }
        outputBoundary.packageAndPresent(responseModel);
    }

    private void checkIfUserAndPasswordValid(String userName, String passWord, UserLogResponseModel responseModel) {
        boolean userNameValid = dataBaseGateway.checkValidUserName(userName);
        responseModel.setValidUserName(userNameValid);
        if (userNameValid) {
            // Check if the password is valid after checking the username
            responseModel.setUserPasswordValid(dataBaseGateway.checkValidPassword(userName, passWord));
        } else {
            responseModel.setUserPasswordValid(false);
        }
    }

    private void setUpUser(UserLogResponseModel responseModel, User loggedInUser) {
        responseModel.setAccountCreateTime(loggedInUser.getAccountCreationTime());
        responseModel.setUserAvatar(loggedInUser.getUserAvatar());
        responseModel.setUserName(loggedInUser.getUserName());
        responseModel.setPassWord(loggedInUser.getPassword());
    }
}
