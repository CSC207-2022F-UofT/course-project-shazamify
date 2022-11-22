package abr.user_login_abr;

import interface_adaptors.user_login_ia.UserLogViewModel;

public interface UserLogInputBoundary {
    UserLogViewModel loginUser(UserLogRequestModel requestModel);

}
