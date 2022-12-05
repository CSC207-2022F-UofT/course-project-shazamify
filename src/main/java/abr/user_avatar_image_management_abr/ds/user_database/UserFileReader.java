package abr.user_avatar_image_management_abr.ds.user_database;

import entities.user_entities.User;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class UserFileReader {

    static public Map<String, User> getUserMap(String filename){
        try {
        InputStream inputStream = new FileInputStream(filename);
        InputStream buffer = new BufferedInputStream(inputStream);
        ObjectInput input = new ObjectInputStream(buffer);

        Map<String, User> UserMap= (Map<String, User>) input.readObject();
        input.close();
        return UserMap;
        } catch (IOException e){
            return new HashMap<>();
        } catch (ClassNotFoundException e){
            throw new RuntimeException("Class in UserDatabase is not a Map");
        }
    }

    static public HashMap<String, String> getUserFriendList(String fileName, String userName) {
        return UserFileReader.getUserMap(fileName).get(userName).getFriendList();
    }
}
