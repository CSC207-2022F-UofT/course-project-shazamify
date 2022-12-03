package abr.user_reg_abr;

import interface_adaptors.user_reg_ia.UserRegViewModel;

public class UserRegUseCase implements UserRegInputBoundary{

    private final UserRegHelper userRegHelper = new UserRegHelper();
    private final UserRecommendPasswordHelper userRecommendPasswordHelper = new UserRecommendPasswordHelper();
    private final UserRegOutputBoundary outputBoundary;
    private final UserRegisterDataBaseGateway dataBaseGateway;

    /**
     * This is a thin layer Facade class, with 2 helper class doing the job of registration and recommend password.
     *
     * @param outputBoundary  Output Boundary for usecase
     * @param dataBaseGateway Database Gateway used by User user_database.
     */
    public UserRegUseCase(UserRegOutputBoundary outputBoundary, UserRegisterDataBaseGateway dataBaseGateway){
        this.outputBoundary = outputBoundary;
        this.dataBaseGateway = dataBaseGateway;
    }

    @Override
    public void register(UserRegRequestModel requestModel){
        UserRegResponseModel emptyResponseModel = new UserRegResponseModel();
        UserRegResponseModel processedResponseModel = userRegHelper.register(requestModel,
                emptyResponseModel, dataBaseGateway);
        outputBoundary.packageAndPresent(processedResponseModel);
    }

    @Override
    public void giveRecommendPassword() {
        UserRegResponseModel emptyResponseModel = new UserRegResponseModel();
        UserRegResponseModel responseModel = userRecommendPasswordHelper.giveRandomPassword(emptyResponseModel);
        outputBoundary.packageAndPresent(responseModel);
    }
}
