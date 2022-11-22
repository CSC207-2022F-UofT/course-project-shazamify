package user.login.screen;


import user.login.DS.UserLoginDataBaseGateway;
import user.login.DS.UserLoginFileGateway;
import user.login.abr.UserLogInputBoundary;
import user.login.abr.UserLogOutputBoundary;
import user.login.abr.UserLogUseCase;
import interface_adaptors.user_interact_ia.TempFriendListObservable;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserLogUI extends JPanel {
    final JFrame frame = new JFrame();
    JLabel userNameLabel, passWordLabel;
    JTextField userNameField;
    JPasswordField userPassWordField;
    JButton LoginButton, RegisterButton;
    UserLogController controller;

    public UserLogUI(UserLogController controller) {
        this.controller = controller;

        // Set components for interface_adaptors
        frame.setLayout(null);
        createScreenComponents();
        setBoundForComponents();
        addScreenComponents();
        frame.setSize(600,300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
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
        //TODO: finish this part
    }

    private void notifyListenerOnLoginPerformed() {
        String userName = userNameField.getText();
        String password = String.valueOf(userPassWordField.getPassword());

        UserLogViewModel viewModel = controller.login(userName,password);
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
        RegisterButton.setBounds(30,150,100,50);
        LoginButton.setBounds(200,150,100,50);
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
        RegisterButton = new JButton("Register");
        LoginButton = new JButton("Login");

    }
    // Temporary test file
    public static void main(String[] args) {
        UserLoginDataBaseGateway dataBaseGateway = new UserLoginFileGateway();
        UserLogOutputBoundary presenter = new UserLogPresenter();
        UserLogInputBoundary useCase = new UserLogUseCase(presenter, dataBaseGateway);
        UserLogController controller = new UserLogController(useCase);


        UserLogUI LogScreen = new UserLogUI(controller);
    }

}
