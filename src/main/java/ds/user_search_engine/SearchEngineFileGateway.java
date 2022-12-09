package ds.user_search_engine;

import abr.search_engine_abr.SearchEngineDatabaseGateway;
import ds.user_database.UserFileReader;
import entities.user_entities.User;

import java.util.Map;

public class SearchEngineFileGateway implements SearchEngineDatabaseGateway {
    @Override
    public User[] getUserArray() {
        Map<String, User> userMap = UserFileReader.getUserMap("UserDatabase.ser");
        return userMap.values().toArray(new User[0]);
    }
}
