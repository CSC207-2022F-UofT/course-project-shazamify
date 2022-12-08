package framework.buttons;

import framework.UserManagementInitializer;
import framework.user_screen.UserLogUI;
import interface_adaptors.user_change_password_ia.UserCPController;
import interface_adaptors.user_login_ia.UserLogController;
import interface_adaptors.user_login_ia.UserStatusObserver;
import interface_adaptors.user_login_ia.UserStatusViewModel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ButtonViewAccount extends JMenu implements UserStatusObserver {

    public ButtonViewAccount() {
        try {
            this.setIcon(new ImageIcon(UserStatusViewModel.getInstance().getUserAvatar().getScaledInstance(50,50, Image.SCALE_DEFAULT)));
        } catch (Exception e) {
            System.out.println(e);
        }
        this.setBorderPainted(false);
        this.setBorder(null);
        this.setMargin(new Insets(0, 0, 0, 0));
        this.setContentAreaFilled(false);

        //Add rendered menus
        this.add(renderLoginMenu());
        this.add(renderRegisterMenu());
        this.add(renderSettingsMenu());
        this.add(renderLogoutMenu());
    }
    public JMenuItem renderLoginMenu(){
        JMenuItem loginMenuItem = new JMenuItem("Login");
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //TODO: David please add login here
            }
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
        });

        return loginMenuItem;
    }
    public JMenuItem renderRegisterMenu(){
        JMenuItem loginMenuItem = new JMenuItem("Register");
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //TODO: add register
            }
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
        });

        return loginMenuItem;
    }
    public JMenuItem renderSettingsMenu(){
        JMenuItem loginMenuItem = new JMenuItem("Settings");
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //TODO: add settings
            }
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
        });

        return loginMenuItem;
    }
    public JMenuItem renderLogoutMenu(){
        JMenuItem loginMenuItem = new JMenuItem("Logout");
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //TODO: add logout
            }
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
        });

        return loginMenuItem;
    }


    @Override
    public void userUpdated() {
        this.setIcon(new ImageIcon(UserStatusViewModel.getInstance().getUserAvatar().getScaledInstance(50,50, Image.SCALE_DEFAULT)));
    }
}
