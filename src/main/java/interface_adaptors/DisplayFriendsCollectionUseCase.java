package interface_adaptors;

import user.entities.User;

import java.util.ArrayList;

public class DisplayFriendsCollectionUseCase extends AbstractDisplayUseCase {

    private static DisplayFriendsCollectionUseCase instance;

    /**
     * Gets instance of singleton
     * @return instance
     */
    public static DisplayFriendsCollectionUseCase getInstance() {
        if (instance == null) {instance = new DisplayFriendsCollectionUseCase();}
        return instance;
    }

    public void displayFriends(User user) {
        // Fetch users from database
        ArrayList<User> users = getFriends(user);
        // Send to ViewModel
        FriendsCollectionViewModel.getInstance().updateView(users);
    }


    // TODO: this should be in User class or where?
    private ArrayList<User> getFriends(User user) {
        ArrayList<User> users = new ArrayList<>();
        return users;
    }

}

