package abr.user_login_abr;

import entities.user_entities.User;

/**
 * @author David Li
 *
 * The UseCase of Login Activity, will check for userName and Password Validity
 * If both UserName and Password is valid, will renew UserStatusViewModel
 */
public class UserLogUseCase implements UserLogInputBoundary{
    UserLogOutputBoundary outputBoundary;
    UserLoginDataBaseGateway dataBaseGateway;

    /**
     * Initialize the UserLogUseCase
     * @param outputBoundary The Presenter of the User Log
     * @param dataBaseGateway The Database Gateway to the User Database
     */
    public UserLogUseCase(UserLogOutputBoundary outputBoundary, UserLoginDataBaseGateway dataBaseGateway){
        this.outputBoundary = outputBoundary;
        this.dataBaseGateway = dataBaseGateway;
    }

    /**
     * Login given user with user identification entities(Username, Password) contain inside request model
     * If both Username and Password are Valid, will renew Valid message to UserLogViewModel, and Renew UserStatusViewModel
     * If either UserName or Password is not Valid, will renew invalid message to UserLogViewModel, will not Renew UserStatusModel
     * @param requestModel user identification entities package
     */
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
        responseModel.setFriendList(loggedInUser.getFriendList());
        responseModel.setPlayListIDs(loggedInUser.getPlaylistIDs());
    }
}
