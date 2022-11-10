package user.reg.screen;

import user.database.UserDataBaseGateway;
import user.database.UserFileGateway;
import user.reg.abr.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserRegUI extends JPanel {
    final JFrame frame = new JFrame();
    JLabel userNameLabel, passWordLabel, rePasswordLabel;
    JTextField userNameField;
    JPasswordField userPassWordField, userRePassWordField;
    JButton RegisterButton, RecommendPasswordButton, backToLogin;

    UserRegController controller;

    public UserRegUI(UserRegController controller){
        this.controller = controller;

        // Set components for screen
        frame.setLayout(null);
        createScreenComponents();
        setBoundForComponents();
        addScreenComponents();

        // Set frame size
        frame.setSize(600,300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // Configure the Register Button
        RegisterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                notifyListenerOnRegisterClicked();
            }
        });

        RecommendPasswordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                notifyListenerOnRecommendPassword();
            }
        });
    }

    private void notifyListenerOnRecommendPassword() {
        UserRegViewModel viewModel = controller.giveRecommendPassword();
        String recommendPassword = viewModel.getRecommendPassword();
        JOptionPane.showMessageDialog(this, recommendPassword);
    }
    private void notifyListenerOnRegisterClicked(){
        String name = userNameField.getText();
        String password = String.valueOf(userPassWordField.getPassword());
        String rePassword = String.valueOf(userRePassWordField.getPassword());
        UserRegViewModel viewModel = controller.register(name, password, rePassword);
        if (viewModel.isPasswordValid() & viewModel.isUsernameValid()) {
            JOptionPane.showMessageDialog(this, "created.");
        } else if (!viewModel.isPasswordValid()) {
            JOptionPane.showMessageDialog(this, "password Invalid.");
        } else {
            JOptionPane.showMessageDialog(this, "Username Invalid.");
        }
    }
    private void setBoundForComponents() {
        userNameLabel.setBounds(10,20,165,25);
        userNameField.setBounds(185,20,300,25);
        passWordLabel.setBounds(10,65,165,25);
        userPassWordField.setBounds(185,65,300,25);
        rePasswordLabel.setBounds(10,110,165,25);
        userRePassWordField.setBounds(185,110,300,25);
        RegisterButton.setBounds(30,150,100,50);
        RecommendPasswordButton.setBounds(180,150,200,50);
        backToLogin.setBounds(410,150,150,50);
    }

    private void addScreenComponents() {
        frame.add(userNameLabel);
        frame.add(userNameField);
        frame.add(passWordLabel);
        frame.add(userPassWordField);
        frame.add(rePasswordLabel);
        frame.add(userRePassWordField);
        frame.add(RegisterButton);
        frame.add(RecommendPasswordButton);
        frame.add(backToLogin);
    }

    private void createScreenComponents() {
        userNameLabel = new JLabel("Choose username");
        passWordLabel = new JLabel("Choose password");
        rePasswordLabel = new JLabel("Enter password again");
        userNameField = new JTextField();
        userPassWordField = new JPasswordField();
        userRePassWordField = new JPasswordField();
        RegisterButton = new JButton("Register");
        RecommendPasswordButton = new JButton("Get Recommend Password");
        backToLogin = new JButton("Back to login");

    }


    /**
     * Temporary test method
     */
    public static void main(String[] args) {
        UserDataBaseGateway dataBaseGateway = new UserFileGateway();
        UserRegOutputBoundary presenter = new UserRegPresenter();
        UserRegInputBoundary useCase = new UserRegUseCase(presenter, dataBaseGateway);
        UserRegController controller = new UserRegController(useCase);


        UserRegUI registerScreen = new UserRegUI(controller);
    }
}
