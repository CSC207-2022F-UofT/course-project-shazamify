package user.login.abr;

import user.login.screen.UserLogViewModel;

public interface UserLogInputBoundary {
    UserLogViewModel loginUser(UserLogRequestModel requestModel);

}
