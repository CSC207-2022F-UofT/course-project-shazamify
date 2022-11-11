package user.database;

import user.entities.User;

public interface UserInteractionDatabaseGateway {

    User[] getUserArray();
    int getNumberOfUsers();
    void clearDatabase();

}
