package entities.user_entities;

import java.util.Map;

public class UserInMemoryDatabase {
    Map<IdentificationPackage, User> userDatabase;
    // Database
    public UserInMemoryDatabase(Map<IdentificationPackage, User> userDatabase){
        this.userDatabase = userDatabase;
    }
}
