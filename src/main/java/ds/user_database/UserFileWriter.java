package ds.user_database;

import import entities.user_entities.User;;

import java.io.*;
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
}
