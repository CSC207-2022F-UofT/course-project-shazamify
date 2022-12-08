package interface_adaptors.user_logout_ia;

import interface_adaptors.user_login_ia.UserStatusViewModel;

/**
 * @author David Li
 */
public class UserLogOutController {
    /**
     * Logout the current user (i.e. set the UserStatusViewModel to default)
     */
    public void logout(){
        UserStatusViewModel.getInstance().logout();
        UserStatusViewModel.getInstance().userUpdated();
    }
}
