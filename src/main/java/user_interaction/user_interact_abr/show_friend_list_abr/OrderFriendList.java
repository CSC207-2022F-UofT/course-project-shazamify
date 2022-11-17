package user_interaction.user_interact_abr.show_friend_list_abr;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class OrderFriendList implements OrderFriendListInputBoundary{


    @Override
    public ArrayList<String> returnOrderedUserFriendList(HashMap<String, String> currentFriendList) {
        ArrayList<String> orderedFriendNames = new ArrayList<>();

        if (currentFriendList != null){
            filterAndSortByAlphabet(orderedFriendNames, currentFriendList);
        }
        // else return empty friendList
        return orderedFriendNames;
    }

    private void filterAndSortByAlphabet(ArrayList<String> orderedFriendNames, HashMap<String, String> currentFriendList){
        for(Map.Entry<String, String> entry: currentFriendList.entrySet()) {
            if (entry.getValue().contains(entry.getKey())){ // if user received friend request from someone
                orderedFriendNames.add(entry.getKey() + "*");
            } else if (entry.getValue().equals("friend")) {
                orderedFriendNames.add(entry.getKey());
            }
            // if user has sent a friend request to someone & it's pending, do not add this person to user's friendList to display

        }
        orderedFriendNames.sort(String::compareToIgnoreCase); // sort by alphabetical order, not case-sensitive
    }
}
