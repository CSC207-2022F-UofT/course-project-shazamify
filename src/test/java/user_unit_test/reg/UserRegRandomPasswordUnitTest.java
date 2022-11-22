package user_unit_test.reg;

import org.junit.Test;
import abr.user_reg_abr.UserRecommendPasswordHelper;
import abr.user_reg_abr.UserRegResponseModel;

public class UserRegRandomPasswordUnitTest {
    @Test
    public void testRandomPassword() {
        UserRecommendPasswordHelper passwordHelper = new UserRecommendPasswordHelper();
        UserRegResponseModel responseModel = new UserRegResponseModel();
        System.out.println(passwordHelper.giveRandomPassword(responseModel).getRecommendPassword());
    }

}