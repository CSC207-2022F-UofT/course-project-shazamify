package user_unit_test.testing_tools;

import abr.user_reg_abr.UserRegInputBoundary;
import abr.user_reg_abr.UserRegUseCase;
import abr.user_reg_abr.UserRegisterDataBaseGateway;
import ds.user_reg_ds.UserRegisterFileGateway;
import interface_adaptors.user_reg_ia.UserRegController;
import interface_adaptors.user_reg_ia.UserRegPresenter;
import interface_adaptors.user_reg_ia.UserRegViewModel;

import java.util.Map;
import java.util.Random;

/**
 * @author David Li
 *
 * This file is for Register and Creating test Users.
 */
public class UserRegTestingTools {

    /**
     * By Pass in userViewModel and required parameters, the function will register the user and permute userRegViewModel
     */
    public static void registerUser(String userName, String passWord, String rePassword){
        UserRegController userRegController = initializeTestEnvironment();
        // Generate a UserSecurityQuestion with both question and answer be test.
        Map<String, String> securityQuestionMap = UserSecurityQuestionGenerator.generateSecurityQuestionMap();

        // Register the User into the Database
        userRegController.register(userName, passWord, rePassword, securityQuestionMap);
    }

    /**
     * By given a security question Map, this function will create a User with random 10 digits numeric String
     */
    public static void registerUser(Map<String, String> securityQuestionMap){
        UserRegController userRegController = initializeTestEnvironment();
        Random random = new Random();

        String userName = String.valueOf(random.nextInt(1000000000));
        String passWord = String.valueOf(random.nextInt(1000000000));

        // Register the User into the Database
        userRegController.register(userName, passWord, passWord, securityQuestionMap);
    }

    /**
     * Register a complete random User
     */
    public static void registerUser(){
        UserRegController userRegController = initializeTestEnvironment();
        Random random = new Random();


        String userName = String.valueOf(random.nextInt(1000000000));
        String passWord = String.valueOf(random.nextInt(1000000000));
        // Generate a UserSecurityQuestion with both question and answer be test.
        Map<String, String> securityQuestionMap = UserSecurityQuestionGenerator.generateSecurityQuestionMap();

        // Register the User into the Database
        userRegController.register(userName, passWord, passWord, securityQuestionMap);
    }

    private static UserRegController initializeTestEnvironment(){
        // Initialize the User Presenter
        UserRegPresenter userRegPresenter = new UserRegPresenter();
        // Initialize the User Database Gateway
        UserRegisterDataBaseGateway userRegisterDataBaseGateway = new UserRegisterFileGateway();
        // Initialize the User ABR
        UserRegInputBoundary userRegUseCase = new UserRegUseCase(userRegPresenter, userRegisterDataBaseGateway);
        // Initialize the User Controller

        return new UserRegController(userRegUseCase);
    }
}
