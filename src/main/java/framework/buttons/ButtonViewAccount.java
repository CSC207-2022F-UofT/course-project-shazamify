package framework.buttons;

import framework.UserManagementInitializer;
import framework.user_screen.UserHomePageUI;
import framework.user_screen.UserLogUI;
import framework.user_screen.UserRegUI;
import interface_adaptors.user_avatar_image_management_ia.UserAvatarMngController;
import interface_adaptors.user_avatar_image_management_ia.UserAvatarMngViewModel;
import interface_adaptors.user_change_password_ia.UserCPController;
import interface_adaptors.user_login_ia.UserLogController;
import interface_adaptors.user_login_ia.UserStatusObserver;
import interface_adaptors.user_login_ia.UserStatusViewModel;
import interface_adaptors.user_logout_ia.UserLogOutController;
import interface_adaptors.user_reg_ia.UserRegController;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.MenuKeyEvent;
import javax.swing.event.MenuKeyListener;
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
        loginMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserLogController userLogController = UserManagementInitializer.getLogController();
                UserCPController userCPController = UserManagementInitializer.getChangePasswordController();
                new UserLogUI(userLogController, userCPController);
            }
        });

        return loginMenuItem;
    }
    public JMenuItem renderRegisterMenu(){
        JMenuItem loginMenuItem = new JMenuItem("Register");
        loginMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserRegController userRegController = UserManagementInitializer.getRegController();
                new UserRegUI(userRegController);
            }
        });

        return loginMenuItem;
    }
    public JMenuItem renderSettingsMenu(){
        JMenuItem loginMenuItem = new JMenuItem("Settings");
        loginMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserAvatarMngController userAvatarMngController = UserManagementInitializer.getUserAvatarMngController();
                UserCPController userCPController = UserManagementInitializer.getChangePasswordController();
                new UserHomePageUI(userAvatarMngController, userCPController);
            }
        });

        return loginMenuItem;
    }
    public JMenuItem renderLogoutMenu(){
        JMenuItem loginMenuItem = new JMenuItem("Logout");
        loginMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserLogOutController userLogOutController = UserManagementInitializer.getUserLogoutController();
                userLogOutController.logout();
            }
        });

        return loginMenuItem;
    }


    @Override
    public void userUpdated() {
        this.setIcon(new ImageIcon(UserStatusViewModel.getInstance().getUserAvatar().getScaledInstance(50,50, Image.SCALE_DEFAULT)));
    }
}
