package framework.user_screen;

import interface_adaptors.user_avatar_image_management_ia.UserAvatarMngController;
import interface_adaptors.user_avatar_image_management_ia.UserAvatarMngViewModel;
import interface_adaptors.user_change_password_ia.UserCPController;
import interface_adaptors.user_login_ia.UserStatusViewModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserChangePasswordUI extends JPanel{
    UserStatusViewModel userStatusViewModel;
    UserCPController controller;
    UserAvatarMngController userAvatarMngController;
    UserAvatarMngViewModel userAvatarMngViewModel;
    JFrame frame = new JFrame();
    JPasswordField userPassWordField, userNewPasswordField;
    JLabel newPasswordLabel, passWordLabel;
    JButton resetPassword;

    public UserChangePasswordUI(UserStatusViewModel userStatusViewModel, UserCPController controller,
                                UserAvatarMngController userAvatarMngController){
        this.userStatusViewModel = userStatusViewModel;
        this.controller = controller;
        frame.setLayout(null);

        // Set components for interface_adaptors
        createScreenComponents();
        setBoundForComponents();
        addScreenComponents();

        // Set frame size
        frame.setSize(700,400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        resetPassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    notifyListenerOnResetPasswordClicked();
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }

    private void notifyListenerOnResetPasswordClicked() throws InterruptedException {
        // If the entered password is the same as previous password
        if (String.valueOf(userPassWordField.getPassword()).equals(userStatusViewModel.getPassWord())){
            // Change the password
            controller.changePassword(userStatusViewModel.getUserName(), String.valueOf(userNewPasswordField.getPassword()));
            JOptionPane.showMessageDialog(this, "Reset Successfully");
            // Wait for 1 second
            Thread.sleep(1000);
            // Close the window, and go back to main page
            new UserHomePageUI(userAvatarMngController, controller);
            frame.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Old Password is not correct");
        }
    }

    private void addScreenComponents() {
        frame.add(passWordLabel);
        frame.add(userNewPasswordField);
        frame.add(newPasswordLabel);
        frame.add(userPassWordField);
        frame.add(resetPassword);
    }

    private void setBoundForComponents() {
        passWordLabel.setBounds(10,20,165,25);
        userPassWordField.setBounds(185,20,300,25);
        newPasswordLabel.setBounds(10,65,165,25);
        userNewPasswordField.setBounds(185,65,300,25);
        resetPassword.setBounds(100,100,80,40);
    }

    private void createScreenComponents() {
        passWordLabel = new JLabel("Enter your old password");
        newPasswordLabel = new JLabel("Enter New password");
        userPassWordField = new JPasswordField();
        userNewPasswordField = new JPasswordField();
        resetPassword = new JButton("Reset Password");
    }


}
