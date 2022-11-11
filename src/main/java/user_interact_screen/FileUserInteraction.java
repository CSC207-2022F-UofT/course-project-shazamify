package user_interact_screen;

import user.database.UserFileReader;
import user.database.UserFileWriter;
import user.entities.User;
import user_interact_abr.friend_manager_abr.FriendManagerDsGateway;
import user_interact_abr.friend_manager_abr.FriendManagerDsRequestModel;

import java.util.HashMap;
import java.util.Map;

public class FileUserInteraction implements FriendManagerDsGateway {
    final private Map<String, User> userMap = UserFileReader.getUserMap("UserDatabase.ser"); // <userID (userName), User>

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
        //save to database
        UserFileWriter.writeUserMap(userMap, "UserDatabase.ser");
    }

    //extract long method by creating method obj
    private User getUserWithNewFriendList(FriendManagerDsRequestModel requestModel){
        User user =userMap.get(requestModel.getUserID());
        user.setFriendList(requestModel.getUserFriendList());
        return user;
    }

    private User  getFriendWithNewFriendList(FriendManagerDsRequestModel requestModel){
        User friend =userMap.get(requestModel.getFriendID());
        friend.setFriendList(requestModel.getFriendFriendList());
        return friend;
    }
}
