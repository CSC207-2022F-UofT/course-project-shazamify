package user.database;

import user.entities.User;

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
    public int getNumberOfUsers(){
        Map<String, User> userMap = UserFileReader.getUserMap("UserDatabase.ser");
        return userMap.size();
}

    @Override
    public void clearDatabase() {
        UserFileWriter.writeUserMap(new HashMap<>(), "UserDatabase.ser");
    }
}
