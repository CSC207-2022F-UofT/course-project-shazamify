package entities.user_entities;

public class IdentificationPackage {
    String userName;
    int userID;
    String eMailNumber;

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void seteMailNumber(String eMailNumber) {
        this.eMailNumber = eMailNumber;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public String geteMailNumber() {
        return eMailNumber;
    }

    public int getUserID() {
        return userID;
    }
}
