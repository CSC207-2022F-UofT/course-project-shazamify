package interface_adaptors;

import entities.user_entities.User;


public class FriendsCollectionController {
    // TODO: need to integrate controllers with others but refactor UseCase names and add these functions
    public static void displayFriends(User user){
        DisplayFriendsCollectionUseCase.getInstance().displayFriends(user);
    }

}
