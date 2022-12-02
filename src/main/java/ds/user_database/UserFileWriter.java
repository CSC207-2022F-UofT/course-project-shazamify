package ds.user_database;

import entities.user_entities.User;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class UserFileWriter {
    static public void writeUserMap(Map<String, User> UserMap, String filename){
        try {
            OutputStream outputStream = new FileOutputStream(filename);
            OutputStream buffer = new BufferedOutputStream(outputStream);
            ObjectOutput output = new ObjectOutputStream(buffer);

            output.writeObject(UserMap);
            output.close();
        } catch(IOException e){
            throw new RuntimeException("Filename of the UserDatabase is not correct or User Object is not serializable");
        }
    }

    static public void setUserFriendList(String filename, String userName, HashMap<String, String> userFriendList){
        Map<String, User> updatedUserMap = UserFileReader.getUserMap(filename);

        updatedUserMap.get(userName).setFriendList(userFriendList);

        UserFileWriter.writeUserMap(updatedUserMap, filename);
    }
}
