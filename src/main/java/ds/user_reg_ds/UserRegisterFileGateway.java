package ds.user_reg_ds;

import abr.user_reg_abr.UserRegisterDataBaseGateway;
import ds.user_database.UserFileReader;
import ds.user_database.UserFileWriter;
import entities.user_entities.User;
import entities.user_entities.UserFactory;
import entities.user_entities.UserSecurityQuestionPackage;

import java.util.HashMap;
import java.util.Map;

public class UserRegisterFileGateway implements UserRegisterDataBaseGateway {
    /**
     * Check if the userName is valid.
     * If valid, register the user, and return True.
     * Else, return False
     */
    @Override
    public boolean checkAndRegisterUser(String userName, String passWord, UserSecurityQuestionPackage securityQuestionPackage){
        Map<String, User> userMap = UserFileReader.getUserMap("UserDatabase.ser");
        if (!userMap.containsKey(userName)){
            userMap.put(userName, createUser(userName, passWord, securityQuestionPackage));
            UserFileWriter.writeUserMap(userMap, "UserDatabase.ser");
            return true;
        } else {
            return false;
        }
    }
    @Override
    public int getNumberOfUsers(){
        Map<String, User> userMap = UserFileReader.getUserMap("UserDatabase.ser");
        return userMap.size();
    }

    @Override
    public void clearDatabase() {
        UserFileWriter.writeUserMap(new HashMap<>(), "UserDatabase.ser");
    }


    private User createUser(String userName, String passWord, UserSecurityQuestionPackage securityQuestionPackage) {
        // Set up the factory to initalize user
        UserFactory userFactory = new UserFactory();

        // initialize user with userName and password
        User user = userFactory.getUser(userName, passWord, "CommonUser");

        // Set up security question for user
        user.setSecurityQuestions(securityQuestionPackage);
        return user;
    }
}
