package screen.user_interact_screen.friend_manager_screen;

import java.util.ArrayList;
import java.util.HashMap;

public class TempFriendListObservable { //1. initialize this class in view
                                        //2. add all the friend manager controllers to attribute observers
                                        //3. when any controller gets an updated friendList, instance of this class.setFriendList() is called

    static ArrayList<FriendListObserver> observers = new ArrayList<>();

    static String currentUser = "Star"; // default user for testing


    public static void setCurrentUser(String currentUserName){
        currentUser = currentUserName;
        observers.clear(); // this method will be called only when new user logs in -> should empty list of observers for old users
    }

    public static void setFriendList(HashMap<String, String> tempFriendList){
        updateAllFriendList(tempFriendList);

    }

    public static void addObserver(FriendListObserver observer){
        observers.add(observer);
    } // a friend manager controller is added to the list when the controller is initialized

    public static void updateAllFriendList(HashMap<String, String> tempFriendList){
        for (FriendListObserver observer : observers){
            observer.updateTempFriendList(tempFriendList);
        }
    }
}
