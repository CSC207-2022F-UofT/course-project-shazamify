package user.entities;

import java.io.Serializable;

public interface User extends Serializable {
    public String getUserName();
    public String getPassword();
}
