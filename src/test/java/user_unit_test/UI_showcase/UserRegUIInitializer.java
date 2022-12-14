package user_unit_test.UI_showcase;

import abr.user_reg_abr.UserRegInputBoundary;
import abr.user_reg_abr.UserRegUseCase;
import abr.user_reg_abr.UserRegisterDataBaseGateway;
import ds.user_reg_ds.UserRegisterFileGateway;
import framework.user_screen.UserRegUI;
import interface_adaptors.user_reg_ia.UserRegController;
import interface_adaptors.user_reg_ia.UserRegPresenter;

/**
@author David Li

This file can initialize a RegisterScreen For Testing.
 */
public class UserRegUIInitializer {
    public static void initializeUI(){
        // Initialize the User Presenter
        UserRegPresenter userRegPresenter = new UserRegPresenter();
        // Initialize the User Database Gateway
        UserRegisterDataBaseGateway userRegisterDataBaseGateway = new UserRegisterFileGateway();
        // Initialize the User ABR
        UserRegInputBoundary userRegUseCase = new UserRegUseCase(userRegPresenter, userRegisterDataBaseGateway);
        // Initialize the User Controller
        UserRegController userRegController = new UserRegController(userRegUseCase);
        // Initialize the User UI.
        new UserRegUI(userRegController);
    }

    public static void main(String[] args) {
        UserRegUIInitializer.initializeUI();
    }
}
