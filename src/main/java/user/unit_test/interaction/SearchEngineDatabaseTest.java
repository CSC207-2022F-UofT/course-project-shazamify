package user.unit_test.interaction;


import org.junit.Test;
import user.database.SearchEngineDatabaseGateway;
import user.database.SearchEngineFileGateway;
import user.database.UserRegisterDataBaseGateway;
import user.database.UserRegisterFileGateway;
import user.entities.User;

//public class SearchEngineDatabaseTest {
//    @Test
//    public void Test3Users(){
//        UserRegisterDataBaseGateway registerFileGateway = new UserRegisterFileGateway();
//        SearchEngineDatabaseGateway interactionDatabaseGateway = new SearchEngineFileGateway();
//        registerFileGateway.clearDatabase();
//        registerFileGateway.checkAndRegisterUser("1","2");
//        registerFileGateway.checkAndRegisterUser("2","3");
//        registerFileGateway.checkAndRegisterUser("3","4");
//
//        // TODO: Non-testable
////        User[] targetArray = new User[3];
////        UserFactory factory = new UserFactory();
////        for (int i = 1; i < 4; i++){
////             targetArray[i - 1] = factory.getUser(String.valueOf(i), String.valueOf(i+1), "CommonUser");
////        }
//
//
//        User[] userArray = interactionDatabaseGateway.getUserArray();
//
////        assert Arrays.equals(userArray, targetArray);
//    }
//
//}
