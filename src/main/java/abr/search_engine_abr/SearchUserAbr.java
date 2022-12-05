package abr.search_engine_abr;

import abr.user_avatar_image_management_abr.ds.user_search_engine.SearchEngineFileGateway;
import entities.user_entities.User;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zhaolang05
 * @date 2022/11/18/17:01
 */
public class SearchUserAbr {
    private SearchEngineFileGateway userDao = new SearchEngineFileGateway();
    private int limitCount = 5;

    /**
     * Search user by name, first match equals, then match starts with, and finally matches contains.
     * @param searchName userName
     * @return List<User>
     */
    public List<User> searchUsers(String searchName) {
        List<User> searchResult = new ArrayList<>();
        List<User> startWithResult = new ArrayList<>();
        List<User> containsResult = new ArrayList<>();
        User[] users = userDao.getUserArray();
        for (int i = 0; i < users.length; i++) {
            if (users[i].getUserName().equals(searchName)) {
                searchResult.add(users[i]);
            } else if (users[i].getUserName().startsWith(searchName)) {
                startWithResult.add(users[i]);
            } else if (users[i].getUserName().contains(searchName)) {
                containsResult.add(users[i]);
            }
        }
        searchResult.addAll(startWithResult);
        searchResult.addAll(containsResult);
        //return limitCount users
        if (searchResult.size()>limitCount)
        {
            return searchResult.subList(0,limitCount);
        }
        else
        {
             return searchResult;
        }

    }


}
