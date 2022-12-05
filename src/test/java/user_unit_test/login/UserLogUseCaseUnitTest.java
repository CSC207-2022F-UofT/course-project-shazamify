package user_unit_test.login;

import interface_adaptors.user_login_ia.UserLogViewModel;
import interface_adaptors.user_login_ia.UserStatusViewModel;
import org.junit.Test;
import user_unit_test.testing_tools.GenerateTenUsersDatabase;
import user_unit_test.testing_tools.UserLogTestingTools;

/**
@author David Li

 Cover all cases
 */

public class UserLogUseCaseUnitTest {
    // Initialize ViewModel
    UserLogViewModel userLogViewModel = new UserLogViewModel();
    UserStatusViewModel userStatusViewModel = new UserStatusViewModel();

    @Test
    public void TestCorrectUserNameAndPassword(){
        // Initialize Database
        GenerateTenUsersDatabase.generateTenUserDatabase();

        // Login the User
        String userName = "1";
        String passWord = "1";
        UserLogTestingTools.LoginUser(userName, passWord, userLogViewModel, userStatusViewModel);
        assert userLogViewModel.isValidUserName() && userLogViewModel.isUserPasswordValid();
        assert userName.equals(userStatusViewModel.getUserName());
    }

    @Test
    public void TestWrongPassword(){
        // Initialize Database and ViewModel
        GenerateTenUsersDatabase.generateTenUserDatabase();

        // Login the User
        String userName = "1";
        String passWord = "2";
        UserLogTestingTools.LoginUser(userName, passWord, userLogViewModel, userStatusViewModel);
        assert userLogViewModel.isValidUserName() && !userLogViewModel.isUserPasswordValid();

    }

    @Test
    public void TestWrongUserName(){
        // Initialize Database and ViewModel
        GenerateTenUsersDatabase.generateTenUserDatabase();

        // Login the User
        String userName = "11";
        String passWord = "2";
        UserLogTestingTools.LoginUser(userName, passWord, userLogViewModel, userStatusViewModel);
        assert !userLogViewModel.isValidUserName() && !userLogViewModel.isUserPasswordValid();
    }
}
