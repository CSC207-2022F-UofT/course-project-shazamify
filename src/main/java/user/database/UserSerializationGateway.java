package user.database;

import user.entities.User;
import user.entities.UserFactory;

import java.util.Map;

public class UserSerializationGateway implements UserDataBaseGateway{

    @Override
    public boolean checkAndRegisterUser(String userName, String passWord) {
        Map<String, User> userMap = UserSerializationReader.getUserMap("./UserDatabase.ser");
        if (!userMap.containsKey(userName)){
            User newUser = createUser(userName, passWord);
            userMap.put(userName, newUser);

            return true;
        }
        return false;
    }

    @Override
    public boolean checkValidLogin(String userName) {
        return false;
    }


    private User createUser(String userName, String passWord) {
        UserFactory userFactory = new UserFactory();
        return userFactory.getUser(userName, passWord, "CommonUser");
    }
}
