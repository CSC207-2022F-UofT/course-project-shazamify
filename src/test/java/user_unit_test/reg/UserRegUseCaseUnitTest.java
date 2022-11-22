package user_unit_test.reg;

import org.junit.Test;
import ds.user_reg_ds.UserRegisterDataBaseGateway;
import ds.user_reg_ds.UserRegisterFileGateway;
import abr.user_reg_abr.UserRegOutputBoundary;
import abr.user_reg_abr.UserRegRequestModel;
import abr.user_reg_abr.UserRegUseCase;
import interface_adaptors.user_reg_screen.UserRegPresenter;
import interface_adaptors.user_reg_screen.UserRegViewModel;

import java.util.HashMap;
import java.util.Map;

public class UserRegUseCaseUnitTest {

    /**
     * Initialize a test environment, and a clean user_database
     * @return a usercase for test purpose
     */
    public UserRegUseCase initial() {
        UserRegisterDataBaseGateway dataBaseGateway = new UserRegisterFileGateway();
        dataBaseGateway.clearDatabase();
        UserRegOutputBoundary boundary = new UserRegPresenter();
        return new UserRegUseCase(boundary, dataBaseGateway);
    }

    @Test
    public void passWordAndRepassWordNotMatch(){
        UserRegUseCase userRegUseCase = initial();
        Map<String, String> securityQuestionMap= new HashMap<>();
        securityQuestionMap.put("1","2");
        UserRegRequestModel requestModel = new UserRegRequestModel("qazwsx741","1404528381","qazwsx741",securityQuestionMap);
        UserRegViewModel viewModel = userRegUseCase.register(requestModel);
        assert viewModel.isPasswordValid();
    }

    @Test
    public void userNameAlreadyExists(){
        UserRegUseCase userRegUseCase = initial();
        Map<String, String> securityQuestionMap= new HashMap<>();
        securityQuestionMap.put("1","2");
        UserRegRequestModel requestModel = new UserRegRequestModel("qazwsx741","140452838","qazwsx741", securityQuestionMap);
        userRegUseCase.register(requestModel);
        // Register the requestModel 2nd times
        UserRegViewModel viewModel2 = userRegUseCase.register(requestModel);
        assert !viewModel2.isUsernameValid();
    }

    @Test
    public void noSecurityQuestionFilled(){
        UserRegUseCase userRegUseCase = initial();
        Map<String, String> securityQuestionMap= new HashMap<>();
        UserRegRequestModel requestModel = new UserRegRequestModel("qazwsx741","140452838","qazwsx741", securityQuestionMap);
        UserRegViewModel viewModel = userRegUseCase.register(requestModel);
        assert !viewModel.isSecurityQuestionValidity();
    }
}
