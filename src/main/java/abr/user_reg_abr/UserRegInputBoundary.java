package abr.user_reg_abr;

public interface UserRegInputBoundary {
    void register(UserRegRequestModel requestModel);
    void giveRecommendPassword();
}
