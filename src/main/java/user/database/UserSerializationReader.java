package user.database;

import user.entities.User;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.Map;

public class UserSerializationReader{

    static public Map<String, User> getUserMap(String filename) {
        try {
            FileInputStream fileReader = new FileInputStream(filename);
            ObjectInputStream input = new ObjectInputStream(fileReader);
            Map<String, User> userMap = (Map<String, User>) input;
            input.close();
            return userMap;
        } catch (IOException e) {
            return new HashMap<String, User>();
        }
    }
}
