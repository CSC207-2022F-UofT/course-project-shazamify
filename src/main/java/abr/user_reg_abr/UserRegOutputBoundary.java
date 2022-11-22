package abr.user_reg_abr;

import screen.user_reg_screen.UserRegViewModel;

public interface UserRegOutputBoundary {
    UserRegViewModel packageAndPresent(UserRegResponseModel responseModel);
}
