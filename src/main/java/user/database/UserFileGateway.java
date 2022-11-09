package user.database;

import user.entities.User;
import user.entities.UserFactory;

import java.io.IOException;
import java.util.Map;

public class UserFileGateway implements UserDataBaseGateway{
    /**
     * Check if the userName is valid.
     * If valid, register the user, and return True.
     * Else, return False
     */
    @Override
    public boolean checkAndRegisterUser(String userName, String passWord){
        Map<String, User> userMap = UserFileReader.getUserMap("UserDatabase.ser");
        if (!userMap.containsKey(userName)){
            userMap.put(userName, createUser(userName, passWord));
            UserFileWriter.writeUserMap(userMap, "UserDatabase.ser");
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean checkValidLogin(String userName, String passWord){
        Map<String, User> userMap = UserFileReader.getUserMap("UserDatabase.ser");
        return userMap.containsKey(userName) & userMap.get(userName).getPassword().equals(passWord);
    }


    private User createUser(String userName, String passWord) {
        UserFactory userFactory = new UserFactory();
        return userFactory.getUser(userName, passWord, "CommonUser");
    }
}
