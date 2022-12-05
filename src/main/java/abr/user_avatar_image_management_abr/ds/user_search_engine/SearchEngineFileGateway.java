package abr.user_avatar_image_management_abr.ds.user_search_engine;

import abr.search_engine_abr.SearchEngineDatabaseGateway;
import abr.user_avatar_image_management_abr.ds.user_database.UserFileReader;
import entities.user_entities.User;

import java.util.Map;

public class SearchEngineFileGateway implements SearchEngineDatabaseGateway {
    @Override
    public User[] getUserArray() {
        Map<String, User> userMap = UserFileReader.getUserMap("UserDatabase.ser");
        return (User[]) userMap.values().toArray();
    }
}
