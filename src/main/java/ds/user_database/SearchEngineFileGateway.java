package ds.user_database;

import entities.user_entities.User;

import java.util.Map;

public class SearchEngineFileGateway implements SearchEngineDatabaseGateway{
    @Override
    public User[] getUserArray() {
        Map<String, User> userMap = UserFileReader.getUserMap("UserDatabase.ser");
        return (User[]) userMap.values().toArray();
    }
}
