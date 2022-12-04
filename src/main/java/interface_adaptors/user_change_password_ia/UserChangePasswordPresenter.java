package interface_adaptors.user_change_password_ia;

import abr.user_change_password_abr.UserChangePasswordOutputBoundary;
import interface_adaptors.user_login_ia.UserStatusObserver;
import interface_adaptors.user_login_ia.UserStatusViewModel;

public class UserChangePasswordPresenter implements UserChangePasswordOutputBoundary {
    UserStatusViewModel userStatusViewModel;

    public UserChangePasswordPresenter(UserStatusViewModel userStatusViewModel){
        this.userStatusViewModel = userStatusViewModel;
    }
    @Override
    public void packageAndPresent(String passWord) {
        userStatusViewModel.setPassWord(passWord);
    }
}
