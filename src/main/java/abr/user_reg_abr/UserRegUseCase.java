package abr.user_reg_abr;

/**
 * @author David Li
 *
 * This is a thin layer Facade class, with 2 helper class doing the job of registration and recommend password.
 */
public class UserRegUseCase implements UserRegInputBoundary{

    private final UserRegHelper userRegHelper = new UserRegHelper();
    private final UserRecommendPasswordHelper userRecommendPasswordHelper = new UserRecommendPasswordHelper();
    private final UserRegOutputBoundary outputBoundary;
    private final UserRegisterDataBaseGateway dataBaseGateway;

    /**
     * Initialize the User Register Use Case
     * 1) Can be used to Check the validity as well as register a given User.
     * 2) Can be used to give a recommended password
     *
     * @param outputBoundary  The User Register Presenter Class
     * @param dataBaseGateway Database Gateway used by User Register.
     */
    public UserRegUseCase(UserRegOutputBoundary outputBoundary, UserRegisterDataBaseGateway dataBaseGateway){
        this.outputBoundary = outputBoundary;
        this.dataBaseGateway = dataBaseGateway;
    }

    /**
     * Register the given User entities inside the request Model.
     * 1) Check if the UserName and Password does not contain illegal symbols
     * 2) Check if the UserName is not repeat inside the User Database
     * 3) Register the User into the User Database
     * 4) Update UserRegViewModel of the validity of the above steps.
     * @param requestModel Contain User entities to Register
     */
    @Override
    public void register(UserRegRequestModel requestModel){
        UserRegResponseModel emptyResponseModel = new UserRegResponseModel();
        UserRegResponseModel processedResponseModel = userRegHelper.register(requestModel,
                emptyResponseModel, dataBaseGateway);
        outputBoundary.packageAndPresent(processedResponseModel);
    }

    /**
     * Given a recommendation password to the User.
     * The password will be 10 digits, and contain AlphaNumeric combination
     * Example: "123plk13ep" will be a Valid output
     */
    @Override
    public void giveRecommendPassword() {
        UserRegResponseModel emptyResponseModel = new UserRegResponseModel();
        UserRegResponseModel responseModel = userRecommendPasswordHelper.giveRandomPassword(emptyResponseModel);
        outputBoundary.packageAndPresent(responseModel);
    }
}
