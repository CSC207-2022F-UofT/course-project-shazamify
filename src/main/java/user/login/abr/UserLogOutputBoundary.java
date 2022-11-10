package user.login.abr;

import user.login.screen.UserLogViewModel;

public interface UserLogOutputBoundary {
    UserLogViewModel packageAndPresent(UserLogResponseModel responseModel);
}
