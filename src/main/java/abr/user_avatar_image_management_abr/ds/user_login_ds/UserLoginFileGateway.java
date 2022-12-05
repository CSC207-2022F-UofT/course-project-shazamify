package abr.user_avatar_image_management_abr.ds.user_login_ds;

import abr.user_avatar_image_management_abr.ds.user_database.UserFileReader;
import abr.user_avatar_image_management_abr.ds.user_database.UserFileWriter;
import abr.user_login_abr.UserLoginDataBaseGateway;
import entities.user_entities.User;

import java.util.HashMap;
import java.util.Map;

public class UserLoginFileGateway implements UserLoginDataBaseGateway {

    @Override
    public boolean checkValidPassword(String userName, String passWord) {
        Map<String, User> userMap = UserFileReader.getUserMap("UserDatabase.ser");
        return userMap.get(userName).getPassword().equals(passWord);
    }

    @Override
    public boolean checkValidUserName(String userName) {
        Map<String, User> userMap = UserFileReader.getUserMap("UserDatabase.ser");
        return userMap.containsKey(userName);
    }
    @Override
    public User getUser(String userName) {
        Map<String, User> userMap = UserFileReader.getUserMap("UserDatabase.ser");
        return userMap.get(userName);
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
}
