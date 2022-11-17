package user.reg.abr;

import user.database.UserRegisterDataBaseGateway;
import user.reg.screen.UserRegViewModel;

public class UserRegUseCase implements UserRegInputBoundary{

    private final UserRegHelper userRegHelper = new UserRegHelper();
    private final UserRecommendPasswordHelper userRecommendPasswordHelper = new UserRecommendPasswordHelper();
    private final UserRegOutputBoundary outputBoundary;
    private final UserRegisterDataBaseGateway dataBaseGateway;

    /**
     * This is a thin layer Facade class, with 2 helper class doing the job of registration and recommend password.
     *
     * @param outputBoundary  Output Boundary for usecase
     * @param dataBaseGateway Database Gateway used by User database.
     */
    public UserRegUseCase(UserRegOutputBoundary outputBoundary, UserRegisterDataBaseGateway dataBaseGateway){
        this.outputBoundary = outputBoundary;
        this.dataBaseGateway = dataBaseGateway;
    }

    @Override
    public UserRegViewModel register(UserRegRequestModel requestModel){
        UserRegResponseModel emptyResponseModel = new UserRegResponseModel();
        UserRegResponseModel processedResponseModel = userRegHelper.register(requestModel,
                emptyResponseModel, dataBaseGateway);
        return outputBoundary.packageAndPresent(processedResponseModel);
    }

    @Override
    public UserRegViewModel giveRecommendPassword() {
        UserRegResponseModel emptyResponseModel = new UserRegResponseModel();
        UserRegResponseModel responseModel = userRecommendPasswordHelper.giveRandomPassword(emptyResponseModel);
        return outputBoundary.packageAndPresent(responseModel);
    }
}
