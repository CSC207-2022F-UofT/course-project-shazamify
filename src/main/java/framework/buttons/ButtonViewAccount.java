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

public class ButtonViewAccount extends JButton implements UserStatusObserver {

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
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserLogController userLogController = UserManagementInitializer.getLogController();
                UserCPController userCPController = UserManagementInitializer.getChangePasswordController();
                new UserLogUI(userLogController, userCPController);
            }
        });
    }

    @Override
    public void userUpdated() {
        this.setIcon(new ImageIcon(UserStatusViewModel.getInstance().getUserAvatar().getScaledInstance(50,50, Image.SCALE_DEFAULT)));
    }
}
