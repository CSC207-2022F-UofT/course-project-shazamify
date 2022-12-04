package interface_adaptors.user_change_password_ia;

import abr.user_change_password_abr.UserCPOutputBoundary;
import interface_adaptors.user_login_ia.UserStatusViewModel;

public class UserCPPresenter implements UserCPOutputBoundary {
    UserStatusViewModel userStatusViewModel;

    public UserCPPresenter(UserStatusViewModel userStatusViewModel){
        this.userStatusViewModel = userStatusViewModel;
    }
    @Override
    public void packageAndPresent(String passWord) {
        userStatusViewModel.setPassWord(passWord);
    }
}
