package user.reg.abr;

import user.reg.screen.UserRegViewModel;

public interface UserRegOutputBoundary {
    UserRegViewModel packageAndPresent(UserRegResponseModel responseModel);
}
