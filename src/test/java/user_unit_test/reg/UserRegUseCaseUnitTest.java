package user_unit_test.reg;

import org.junit.Test;
import abr.user_reg_abr.UserRegRequestModel;
import abr.user_reg_abr.UserRegUseCase;
import interface_adaptors.user_reg_ia.UserRegViewModel;
import user_unit_test.testing_tools.UserDataBaseEraser;
import user_unit_test.testing_tools.UserRegTestUser;

import java.util.HashMap;
import java.util.Map;
/*
@author David Li
 */
public class UserRegUseCaseUnitTest {


    @Test
    public void passWordAndRepassWordNotMatch() {
        UserDataBaseEraser.eraseUserDataBase();
        UserRegViewModel regViewModel = new UserRegViewModel();
        String userName = "001";
        String passWord = "002";
        String rePassword = "003";
        UserRegTestUser.registerUser(userName, passWord, rePassword, regViewModel);
        assert !regViewModel.isPasswordValid();
    }

    @Test
    public void userNameAlreadyExists() {
        UserDataBaseEraser.eraseUserDataBase();
        UserRegViewModel regViewModel = new UserRegViewModel();
        String userName = "001";
        String passWord = "002";
        String rePassword = "002";
        UserRegTestUser.registerUser(userName, passWord, rePassword, regViewModel);
        UserRegTestUser.registerUser(userName, passWord, rePassword, regViewModel);
        assert !regViewModel.isUsernameValid();
    }

    @Test
    public void noSecurityQuestionFilled(){
        UserDataBaseEraser.eraseUserDataBase();
        UserRegViewModel regViewModel = new UserRegViewModel();
        String userName = "001";
        String passWord = "002";
        String rePassword = "002";
        UserRegTestUser.registerUser(userName, passWord, rePassword, regViewModel);
        assert !regViewModel.isSecurityQuestionValidity();
    }

    @Test
    public void trickyUserName(){
        UserDataBaseEraser.eraseUserDataBase();
        UserRegViewModel regViewModel = new UserRegViewModel();
        String userName = "*&^%$%^&*(";
        String passWord = "002";
        String rePassword = "002";
        UserRegTestUser.registerUser(userName, passWord, rePassword, regViewModel);
        assert !regViewModel.isUsernameValid();
    }

    @Test
    public void trickyPassword(){
        UserDataBaseEraser.eraseUserDataBase();
        UserRegViewModel regViewModel = new UserRegViewModel();
        String userName = "001";
        String passWord = "$%^&*(";
        String rePassword = "$%^&*(";
        UserRegTestUser.registerUser(userName, passWord, rePassword, regViewModel);
        assert !regViewModel.isPasswordValid();
    }
}
