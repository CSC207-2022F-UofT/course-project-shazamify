package framework.user_screen;


import framework.UserManagementInitializer;
import interface_adaptors.user_change_password_ia.UserCPController;
import interface_adaptors.user_interact_ia.TempFriendListObservable;
import interface_adaptors.user_login_ia.UserLogController;
import interface_adaptors.user_login_ia.UserLogViewModel;
import interface_adaptors.user_login_ia.UserStatusViewModel;
import interface_adaptors.user_reg_ia.UserRegController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author David Li
 */
public class UserLogUI extends JPanel {
    final JFrame frame = new JFrame();
    JLabel userNameLabel, passWordLabel;
    JTextField userNameField;
    JPasswordField userPassWordField;
    JButton LoginButton, RegisterButton, forgetPassword;
    UserLogController controller;
    UserLogViewModel viewModel;
    UserStatusViewModel userStatusViewModel;
    UserCPController userCPController;

    public UserLogUI(UserLogController controller, UserCPController userCPController) {
        this.controller = controller;
        this.viewModel = UserLogViewModel.getInstance();
        this.userCPController = userCPController;
        this.userStatusViewModel = UserStatusViewModel.getInstance();
        // Set components for interface_adaptors
        frame.setLayout(null);
        createScreenComponents();
        setBoundForComponents();
        addScreenComponents();
        frame.setSize(600, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        LoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                notifyListenerOnLoginPerformed();
            }
        });

        RegisterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                notifyListenerOnRegisterPerformed();
            }
        });
    }
    private void notifyListenerOnRegisterPerformed() {
        UserRegController userRegController = UserManagementInitializer.getRegController();
        new UserRegUI(userRegController);
        frame.dispose();
    }

    private void notifyListenerOnLoginPerformed() {
        String userName = userNameField.getText();
        String password = String.valueOf(userPassWordField.getPassword());

        controller.login(userName,password);
        boolean validUserName = viewModel.isValidUserName();
        boolean validPassword = viewModel.isUserPasswordValid();

        if (validUserName & validPassword){
            JOptionPane.showMessageDialog(this, "valid.");
            TempFriendListObservable.setCurrentUser(userName); // everytime the user login, keep track of their username
        } else if (!validUserName) {
            JOptionPane.showMessageDialog(this, "userName not valid.");
        } else {
            JOptionPane.showMessageDialog(this, "password not valid.");
        }
    }

    private void setBoundForComponents() {
        userNameLabel.setBounds(10,20,165,25);
        userNameField.setBounds(185,20,300,25);
        passWordLabel.setBounds(10,65,165,25);
        userPassWordField.setBounds(185,65,300,25);
        LoginButton.setBounds(200,150,100,50);
        RegisterButton.setBounds(10,150,150,50);
    }

    private void addScreenComponents() {
        frame.add(userNameLabel);
        frame.add(userNameField);
        frame.add(passWordLabel);
        frame.add(userPassWordField);
        frame.add(RegisterButton);
        frame.add(LoginButton);
    }

    private void createScreenComponents() {
        userNameLabel = new JLabel("Choose username");
        passWordLabel = new JLabel("Choose password");
        userNameField = new JTextField();
        userPassWordField = new JPasswordField();
        RegisterButton = new JButton("Go to Register");
        LoginButton = new JButton("Login");
    }

}
