package user.entities;

import java.io.Serializable;

public interface User extends Serializable {
    int getUserID();
    String getUserName();
    String getPassword();
}
