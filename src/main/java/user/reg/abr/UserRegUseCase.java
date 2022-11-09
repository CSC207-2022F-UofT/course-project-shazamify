package user.reg.abr;

import user.reg.screen.UserRegViewModel;

public class UserRegUseCase implements UserRegInputBoundary{

    private UserRegHelper userRegHelper;
    private UserRecommendPasswordHelper userRecommendPasswordHelper;

    /**
     * This is a thin layer Facade class, with 2 helper class doing the job of registration and recommend password.
     * @param userRegHelper A helper class doing the job of user registration.
     * @param userRecommendPasswordHelper A helper class doing the job of password recommendation.
     */
    public UserRegUseCase(UserRegHelper userRegHelper, UserRecommendPasswordHelper userRecommendPasswordHelper){
        this.userRegHelper = userRegHelper;
        this.userRecommendPasswordHelper = userRecommendPasswordHelper;
    }

    @Override
    public UserRegViewModel register(UserRegRequestModel requestModel) {
        return userRegHelper.register(requestModel);
    }

    @Override
    public UserRegViewModel giveRecommendPassword() {
        // TODO
        return null;
    }
}
