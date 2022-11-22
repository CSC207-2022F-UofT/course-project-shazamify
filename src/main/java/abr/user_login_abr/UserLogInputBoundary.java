package abr.user_login_abr;

import screen.user_login_screen.UserLogViewModel;

public interface UserLogInputBoundary {
    UserLogViewModel loginUser(UserLogRequestModel requestModel);

}
