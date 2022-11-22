package abr.user_login_abr;

import screen.user_login_screen.UserLogViewModel;

public interface UserLogOutputBoundary {
    UserLogViewModel packageAndPresent(UserLogResponseModel responseModel);
}
