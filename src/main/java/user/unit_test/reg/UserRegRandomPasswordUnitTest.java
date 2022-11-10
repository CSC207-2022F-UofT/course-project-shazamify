package user.unit_test.reg;

import org.junit.Test;
import user.reg.abr.UserRecommendPasswordHelper;
import user.reg.abr.UserRegResponseModel;

public class UserRegRandomPasswordUnitTest {
    @Test
    public void testRandomPassword() {
        UserRecommendPasswordHelper passwordHelper = new UserRecommendPasswordHelper();
        UserRegResponseModel responseModel = new UserRegResponseModel();
        System.out.println(passwordHelper.giveRandomPassword(responseModel).getRecommendPassword());
    }

}