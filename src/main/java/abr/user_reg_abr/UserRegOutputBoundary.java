package abr.user_reg_abr;

import interface_adaptors.user_reg_ia.UserRegViewModel;

public interface UserRegOutputBoundary {
    void packageAndPresent(UserRegResponseModel responseModel);
}
