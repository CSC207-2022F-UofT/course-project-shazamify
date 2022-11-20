package user.entities;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class UserAvatar implements Serializable {
    transient BufferedImage userAvatar;

    public UserAvatar(BufferedImage userAvatar){
        this.userAvatar = userAvatar;
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();

        ImageIO.write(userAvatar, "jpg", out);
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();

        userAvatar = ImageIO.read(in);
    }

    public BufferedImage getBufferedImage() {
        return userAvatar;
    }
}
