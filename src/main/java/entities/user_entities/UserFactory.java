package entities.user_entities;

public class UserFactory{
    public UserFactory(){}

    public User getUser(String userName, String password, String userType) throws RuntimeException{
        if (userType.equals("CommonUser")) {
            return new CommonUser(userName, password);
        } else {
            throw new RuntimeException("Unknown User type in UserFactory");
        }
    }
}
