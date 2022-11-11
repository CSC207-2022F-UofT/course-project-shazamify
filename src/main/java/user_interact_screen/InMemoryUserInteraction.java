package user_interact_screen;

import user.entities.CommonUser;
import user.entities.User;
import user_interact_abr.friend_manager_abr.FriendManagerDsGateway;
import user_interact_abr.friend_manager_abr.FriendManagerDsRequestModel;

import java.util.HashMap;
import java.util.Map;

public class InMemoryUserInteraction implements FriendManagerDsGateway { // fake user DB for unit tests

    private Map<String, User> userMap = new HashMap<>(); // <userID (userName), User>

    @Override
    public HashMap<String, String> getFriendList(String userID) {

        // if not null returns friendList, else return empty friendList
        if (userMap.get(userID).getFriendList() != null){
            return userMap.get(userID).getFriendList();
        } else {
            return new HashMap<>();
        }

    }

    @Override
    public void save(FriendManagerDsRequestModel requestModel) {
        // modify user and friend's friendList in userMap
        userMap.put(requestModel.getUserID(), getUserWithNewFriendList(requestModel));
        userMap.put(requestModel.getFriendID(), getFriendWithNewFriendList(requestModel));
    }

    //extract long method by creating method obj
    private User getUserWithNewFriendList(FriendManagerDsRequestModel requestModel){
        return new CommonUser(requestModel.getUserID(), "abababab"); //for testing
    }

    private User getFriendWithNewFriendList(FriendManagerDsRequestModel requestModel){
        return new CommonUser(requestModel.getFriendID(), "abababab"); //for testing
    }

    public void setUserMap(Map<String, User> fakeUserMap){ userMap = fakeUserMap;}

}
