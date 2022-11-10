package user.database;

import user.entities.User;

import java.util.HashMap;
import java.util.Map;

public class UserInteractionFileGateway implements UserInteractionDatabaseGateway {
    @Override
    public User[] getUserArray() {
        Map<String, User> userMap = UserFileReader.getUserMap("UserDatabase.ser");
        return userMap.values().toArray(new User[0]);
    }

    @Override
    public int getNumberOfUsers() {
        Map<String, User> userMap = UserFileReader.getUserMap("UserDatabase.ser");
        return userMap.size();
    }

    @Override
    public void clearDatabase() {
        UserFileWriter.writeUserMap(new HashMap<>(), "UserDatabase.ser");
    }
}
