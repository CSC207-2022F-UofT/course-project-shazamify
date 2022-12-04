package framework.user_screen;

import interface_adaptors.user_change_password_ia.UserChangePasswordController;
import interface_adaptors.user_login_ia.UserLogController;
import interface_adaptors.user_login_ia.UserLogViewModel;
import interface_adaptors.user_login_ia.UserStatusViewModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserForgetPasswordUI extends JPanel{
    UserStatusViewModel userStatusViewModel;
    UserChangePasswordController changePasswordController;
    UserLogController userLogController;
    UserLogViewModel userLogViewModel;
    String securityQuestion;
    String securityQuestionAnswer;
    JFrame frame = new JFrame();
    JPasswordField userNewPasswordField;
    JLabel newPasswordLabel, securityQuestionLabel;
    JTextField securityQuestionAnswerField;
    JButton resetPassword;

    public UserForgetPasswordUI(UserStatusViewModel userStatusViewModel, UserChangePasswordController changePasswordController,
                                UserLogController userLogController, UserLogViewModel userLogViewModel){
        this.userStatusViewModel = userStatusViewModel;
        this.changePasswordController = changePasswordController;
        this.securityQuestion = (String) userStatusViewModel.getSecurityQuestions().keySet().toArray()[0];
        this.securityQuestionAnswer = userStatusViewModel.getSecurityQuestions().get(securityQuestion);
        this.userLogController = userLogController;
        this.userLogViewModel = userLogViewModel;
        frame.setLayout(null);

        // Set components for interface_adaptors
        createScreenComponents();
        setBoundForComponents();
        addScreenComponents();

        // Set frame size
        frame.setSize(700,400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

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
        if (String.valueOf(securityQuestionAnswerField.getText()).equals(securityQuestionAnswer)){
            // Change the password
            changePasswordController.changePassword(userStatusViewModel.getUserName(), String.valueOf(userNewPasswordField.getPassword()));
            JOptionPane.showMessageDialog(this, "Reset Password Successfully");
            // Wait for 1 second
            Thread.sleep(1000);
            // Close the window, and go back to main page
            new UserLogUI(userLogController, userLogViewModel, userStatusViewModel, changePasswordController);
            frame.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Old Password is not correct");
        }
    }

    private void addScreenComponents() {
        frame.add(securityQuestionLabel);
        frame.add(userNewPasswordField);
        frame.add(newPasswordLabel);
        frame.add(securityQuestionAnswerField);
        frame.add(resetPassword);
    }

    private void setBoundForComponents() {
        securityQuestionLabel.setBounds(10,20,465,25);
        securityQuestionAnswerField.setBounds(10,65,465,25);
        newPasswordLabel.setBounds(10,100,165,25);
        userNewPasswordField.setBounds(185,100,300,25);
        resetPassword.setBounds(100,145,80,40);
    }

    private void createScreenComponents() {
        securityQuestionLabel = new JLabel(securityQuestion);
        newPasswordLabel = new JLabel("Enter New password");
        securityQuestionAnswerField = new JTextField();
        userNewPasswordField = new JPasswordField();
        resetPassword = new JButton("Reset Password");
    }

}
