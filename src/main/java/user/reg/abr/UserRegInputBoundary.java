package user.reg.abr;

import user.reg.screen.UserRegViewModel;

public interface UserRegInputBoundary {
    UserRegViewModel register(UserRegRequestModel requestModel);
    UserRegViewModel giveRecommendPassword();
}
