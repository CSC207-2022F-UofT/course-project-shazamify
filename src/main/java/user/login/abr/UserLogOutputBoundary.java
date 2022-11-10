package user.login.abr;

import user.login.screen.UserLogViewModel;
import user.reg.abr.UserRegResponseModel;

public interface UserLogOutputBoundary {
    UserLogViewModel packageAndPresent(UserLogResponseModel responseModel);
}
