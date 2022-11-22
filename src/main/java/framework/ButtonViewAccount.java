package framework;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonViewAccount extends JButton {

    public ButtonViewAccount() {
        try {
            this.setIcon(new ImageIcon(ImageIO.read(getClass().getResource( "/profileicon.png")).getScaledInstance(50,50, Image.SCALE_DEFAULT)));
        } catch (Exception e) {
            System.out.println(e);
        }
        this.setBorderPainted(false);
        this.setBorder(null);
        this.setMargin(new Insets(0, 0, 0, 0));
        this.setContentAreaFilled(false);
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

}
