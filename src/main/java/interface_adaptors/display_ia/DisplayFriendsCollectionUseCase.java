//package interface_adaptors.display_ia;
//
//import entities.user_entities.User;
//import interface_adaptors.AbstractDisplayUseCase;
//import interface_adaptors.FriendsCollectionViewModel;
//
//import java.util.ArrayList;
//
//public class DisplayFriendsCollectionUseCase extends AbstractDisplayUseCase {
//
//    private static DisplayFriendsCollectionUseCase instance;
//
//    /**
//     * Gets instance of singleton
//     * @return instance
//     */
//    public static DisplayFriendsCollectionUseCase getInstance() {
//        if (instance == null) {instance = new DisplayFriendsCollectionUseCase();}
//        return instance;
//    }
//
//    public void displayFriends(User user) {
//        // Fetch users from database
//        ArrayList<User> users = user.getFriends();
//        // Send to ViewModel
//        FriendsCollectionViewModel.getInstance().updateView(users);
//    }
//
//}
//
