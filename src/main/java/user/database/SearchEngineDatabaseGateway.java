package user.database;

import user.entities.User;

public interface SearchEngineDatabaseGateway {

    User[] getUserArray();
    int getNumberOfUsers();
    void clearDatabase();

}
