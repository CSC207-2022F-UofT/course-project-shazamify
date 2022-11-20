package user_interact_abr_test;


import org.junit.Test;
import user_interaction.user_interact_abr.show_friend_list_abr.OrderFriendList;
import user_interaction.user_interact_abr.show_friend_list_abr.OrderFriendListInputBoundary;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class OrderFriendListTest {

    @Test
    public void returnOrderedUserFriendList() {
        HashMap<String, String> friendList = new HashMap<>();
        friendList.put("Jae", "pending_Jae");
        friendList.put("Angela", "pending_Star");
        friendList.put("Mandy", "friend");
        friendList.put("Millie", "friend");

        OrderFriendListInputBoundary orderFriendList = new OrderFriendList();


        //expected return
        ArrayList<String> orderedFriendList = new ArrayList<>();
        orderedFriendList.add("Jae*");
        orderedFriendList.add("Mandy");
        orderedFriendList.add("Millie");
        orderedFriendList.sort(String::compareToIgnoreCase);

        assertEquals(orderedFriendList, orderFriendList.returnOrderedUserFriendList(friendList));
    }

    @Test
    public void returnEmptyOrderedUserFriendList() {
        HashMap<String, String> friendList = new HashMap<>();

        OrderFriendListInputBoundary orderFriendList = new OrderFriendList();


        //expected return
        ArrayList<String> orderedFriendList = new ArrayList<>();

        assertEquals(orderedFriendList, orderFriendList.returnOrderedUserFriendList(friendList));
    }
}