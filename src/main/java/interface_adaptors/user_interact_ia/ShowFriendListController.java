package interface_adaptors.user_interact_ia;

import abr.user_interact_abr.show_friend_list_abr.OrderFriendListInputBoundary;

import java.util.ArrayList;
import java.util.HashMap;

public class ShowFriendListController implements FriendListObserver{
    final OrderFriendListInputBoundary inputBoundary;

    HashMap<String, String> tempFriendList;


    public ShowFriendListController(OrderFriendListInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
        TempFriendListObservable.addObserver(this);
    }

    public ArrayList<String> returnOrderedUserFriendList(){
        return inputBoundary.returnOrderedUserFriendList(tempFriendList);
    }

    @Override
    public void updateTempFriendList(HashMap<String, String> tempFriendList) {
        this.tempFriendList = tempFriendList;
    }
}