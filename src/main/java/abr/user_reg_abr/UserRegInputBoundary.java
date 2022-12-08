package abr.user_reg_abr;

import interface_adaptors.user_reg_ia.UserRegViewModel;

public interface UserRegInputBoundary {
    void register(UserRegRequestModel requestModel);
    void giveRecommendPassword();
}
