package user_interact_abr_test;


import abr.user_interact_abr.show_friend_list_abr.*;
import org.junit.Test;
import java.util.*;
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