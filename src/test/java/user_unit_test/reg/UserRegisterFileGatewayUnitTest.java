package user_unit_test.reg;

import org.junit.Test;
import ds.user_database.UserFileReader;
import ds.user_database.UserFileWriter;
import abr.user_reg_abr.UserRegisterDataBaseGateway;
import ds.user_reg_ds.UserRegisterFileGateway;
import entities.user_entities.CommonUser;
import entities.user_entities.User;

import java.util.Map;

public class UserRegisterFileGatewayUnitTest {
    @Test
    public void userFileReadAndWrite(){
        UserRegisterDataBaseGateway dataBaseGateway = new UserRegisterFileGateway();
        dataBaseGateway.clearDatabase();
        Map<String, User> userMap = UserFileReader.getUserMap("UserDatabase.ser");
        dataBaseGateway.clearDatabase();
        User newUser1 = new CommonUser("123123", "ababab");
        User newUser2 = new CommonUser("222222", "ababab");
        userMap.put("123123", newUser1);
        userMap.put("222222", newUser2);
        UserFileWriter.writeUserMap(userMap,"UserDatabase.ser");
        Map<String, User> alteredUserMap = UserFileReader.getUserMap("UserDatabase.ser");
        assert alteredUserMap.size() == 2;
    }

    public static void main(String[] args) {
        Map<String, User> userMap = UserFileReader.getUserMap("UserDatabase.ser");
    }
}
