package user_unit_test.reg;

import org.junit.Test;
import interface_adaptors.user_reg_ia.UserRegViewModel;
import user_unit_test.testing_tools.UserDataBaseEraser;
import user_unit_test.testing_tools.UserRegTestingTools;
import user_unit_test.testing_tools.UserSecurityQuestionGenerator;

import java.util.HashMap;
import java.util.Map;

/**
 @author David Li

 Cover all cases
 */
public class UserRegUseCaseUnitTest {


    @Test
    public void passWordAndRepassWordNotMatch() {
        UserDataBaseEraser.eraseUserDataBase();
        UserRegViewModel regViewModel = new UserRegViewModel();
        String userName = "001";
        String passWord = "002";
        String rePassword = "003";
        UserRegTestingTools.registerUser(userName, passWord, rePassword, regViewModel);
        assert !regViewModel.isPasswordValid();
    }

    @Test
    public void userNameAlreadyExists() {
        UserDataBaseEraser.eraseUserDataBase();
        UserRegViewModel regViewModel = new UserRegViewModel();
        String userName = "001";
        String passWord = "002";
        String rePassword = "002";
        UserRegTestingTools.registerUser(userName, passWord, rePassword, regViewModel);
        UserRegTestingTools.registerUser(userName, passWord, rePassword, regViewModel);
        assert !regViewModel.isUsernameValid();
    }

    @Test
    public void noSecurityQuestionFilled(){
        UserDataBaseEraser.eraseUserDataBase();
        UserRegViewModel regViewModel = new UserRegViewModel();
        Map<String, String> securityQuestion = UserSecurityQuestionGenerator.generateSecurityQuestionMap("Test","");
        UserRegTestingTools.registerUser(securityQuestion, regViewModel);
        assert !regViewModel.isSecurityQuestionValidity();
    }

    @Test
    public void trickyUserName(){
        UserDataBaseEraser.eraseUserDataBase();
        UserRegViewModel regViewModel = new UserRegViewModel();
        String userName = "*&^%$%^&*(";
        String passWord = "002";
        String rePassword = "002";
        UserRegTestingTools.registerUser(userName, passWord, rePassword, regViewModel);
        assert !regViewModel.isUsernameValid();
    }

    @Test
    public void trickyPassword(){
        UserDataBaseEraser.eraseUserDataBase();
        UserRegViewModel regViewModel = new UserRegViewModel();
        String userName = "001";
        String passWord = "$%^&*(";
        String rePassword = "$%^&*(";
        UserRegTestingTools.registerUser(userName, passWord, rePassword, regViewModel);
        assert !regViewModel.isPasswordValid();
    }
}
