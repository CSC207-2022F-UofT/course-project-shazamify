package abr.user_login_abr;

import interface_adaptors.user_login_ia.UserLogViewModel;

public interface UserLogOutputBoundary {
    UserLogViewModel packageAndPresent(UserLogResponseModel responseModel);
}
