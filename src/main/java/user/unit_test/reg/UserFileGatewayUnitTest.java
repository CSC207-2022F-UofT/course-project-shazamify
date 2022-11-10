package user.unit_test.reg;

import org.junit.Test;
import user.database.UserFileReader;
import user.database.UserFileWriter;
import user.entities.CommonUser;
import user.entities.User;

import java.util.Map;

public class UserFileGatewayUnitTest {
    @Test
    public void userFileReadAndWrite(){
        Map<String, User> userMap = UserFileReader.getUserMap("UserDatabase.ser");
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
