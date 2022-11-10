package user.unit_test.interaction;

import org.junit.Test;
import user.database.UserInteractionDatabaseGateway;
import user.database.UserInteractionFileGateway;
import user.database.UserRegisterDataBaseGateway;
import user.database.UserRegisterFileGateway;
import user.entities.User;
import user.entities.UserFactory;

import java.util.Arrays;
import java.util.HashMap;

public class InteractionDatabaseTest {
    @Test
    public void Test3Users(){
        UserRegisterDataBaseGateway registerFileGateway = new UserRegisterFileGateway();
        UserInteractionDatabaseGateway interactionDatabaseGateway = new UserInteractionFileGateway();
        registerFileGateway.clearDatabase();
        registerFileGateway.checkAndRegisterUser("1","2");
        registerFileGateway.checkAndRegisterUser("2","3");
        registerFileGateway.checkAndRegisterUser("3","4");

        // TODO: Non-testable
//        User[] targetArray = new User[3];
//        UserFactory factory = new UserFactory();
//        for (int i = 1; i < 4; i++){
//             targetArray[i - 1] = factory.getUser(String.valueOf(i), String.valueOf(i+1), "CommonUser");
//        }


        User[] userArray = interactionDatabaseGateway.getUserArray();

//        assert Arrays.equals(userArray, targetArray);
    }

}
