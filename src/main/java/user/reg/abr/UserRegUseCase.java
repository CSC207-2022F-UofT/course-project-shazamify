package user.reg.abr;

import user.reg.screen.UserRegViewModel;

import java.io.IOException;

public class UserRegUseCase implements UserRegInputBoundary{

    private final UserRegHelper userRegHelper = new UserRegHelper();
    private final UserRecommendPasswordHelper userRecommendPasswordHelper = new UserRecommendPasswordHelper();
    private final UserRegOutputBoundary outputBoundary;

    /**
     * This is a thin layer Facade class, with 2 helper class doing the job of registration and recommend password.
     *
     * @param outputBoundary              Output Boundary for usecase
     */
    public UserRegUseCase(UserRegOutputBoundary outputBoundary){
        this.outputBoundary = outputBoundary;
    }

    @Override
    public UserRegViewModel register(UserRegRequestModel requestModel){
        UserRegResponseModel emptyResponseModel = new UserRegResponseModel();
        UserRegResponseModel processedResponseModel = userRegHelper.register(requestModel, emptyResponseModel);
        return outputBoundary.packageAndPresent(processedResponseModel);
    }

    @Override
    public UserRegViewModel giveRecommendPassword() {
        // TODO
        return null;
    }
}
