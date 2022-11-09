package user.reg.abr;

import user.reg.screen.UserRegViewModel;

public interface UserRegInputBoundary {
    public UserRegViewModel register(UserRegRequestModel requestModel);
    public UserRegViewModel giveRecommendPassword();
}
