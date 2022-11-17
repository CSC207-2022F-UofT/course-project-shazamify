package user.reg.abr;

import user.reg.screen.UserRegViewModel;

import java.io.IOException;

public interface UserRegInputBoundary {
    UserRegViewModel register(UserRegRequestModel requestModel);
    UserRegViewModel giveRecommendPassword();
}
