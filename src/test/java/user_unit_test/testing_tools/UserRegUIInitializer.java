package user_unit_test.testing_tools;

import abr.user_reg_abr.UserRegInputBoundary;
import abr.user_reg_abr.UserRegUseCase;
import abr.user_reg_abr.UserRegisterDataBaseGateway;
import ds.user_reg_ds.UserRegisterFileGateway;
import framework.user_screen.UserRegUI;
import interface_adaptors.user_reg_ia.UserRegController;
import interface_adaptors.user_reg_ia.UserRegPresenter;
import interface_adaptors.user_reg_ia.UserRegViewModel;

public class UserRegUIInitializer {
    public static void initializeUI(UserRegViewModel regViewModel){
        // Initialize the User Presenter
        UserRegPresenter userRegPresenter = new UserRegPresenter(regViewModel);
        // Initialize the User Database Gateway
        UserRegisterDataBaseGateway userRegisterDataBaseGateway = new UserRegisterFileGateway();
        // Initialize the User ABR
        UserRegInputBoundary userRegUseCase = new UserRegUseCase(userRegPresenter, userRegisterDataBaseGateway);
        // Initialize the User Controller
        UserRegController userRegController = new UserRegController(userRegUseCase);
        // Initialize the User UI.
        new UserRegUI(userRegController, regViewModel);
    }

    public static void main(String[] args) {
        UserRegViewModel regViewModel = new UserRegViewModel();
        UserRegUIInitializer.initializeUI(regViewModel);
    }
}
