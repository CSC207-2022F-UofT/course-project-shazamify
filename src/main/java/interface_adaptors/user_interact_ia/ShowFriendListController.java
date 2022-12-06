package interface_adaptors.user_interact_ia;

import abr.user_interact_abr.show_friend_list_abr.OrderFriendListInputBoundary;
import interface_adaptors.user_login_ia.UserStatusViewModel;
import java.util.ArrayList;

public class ShowFriendListController{
    OrderFriendListInputBoundary inputBoundary;
    UserStatusViewModel userStatusViewModel;

    public ShowFriendListController(OrderFriendListInputBoundary inputBoundary, UserStatusViewModel userStatusViewModel) {
        this.inputBoundary = inputBoundary;
        this.userStatusViewModel = userStatusViewModel;
    }
    /**
     * @return  an ordered arraylist of user friend list that's suitable for displaying on screen
     */
    public ArrayList<String> returnOrderedUserFriendList(){
        return inputBoundary.returnOrderedUserFriendList(userStatusViewModel.getFriendList());
    }

}
