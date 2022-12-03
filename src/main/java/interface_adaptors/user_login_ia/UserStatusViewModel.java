package interface_adaptors.user_login_ia;

import entities.user_entities.User;

public class UserStatusViewModel {
    User user;

    public UserStatusViewModel(){
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
