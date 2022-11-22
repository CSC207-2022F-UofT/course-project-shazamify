package interface_adaptors.user_reg_screen;

import ds.user_reg_ds.UserRegisterDataBaseGateway;
import ds.user_reg_ds.UserRegisterFileGateway;
import abr.user_reg_abr.UserRegInputBoundary;
import abr.user_reg_abr.UserRegOutputBoundary;
import abr.user_reg_abr.UserRegUseCase;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class UserRegUI extends JPanel {
    final JFrame frame = new JFrame();
    JLabel userNameLabel, passWordLabel, rePasswordLabel;
    JTextField userNameField, securityQuestionField;
    JPasswordField userPassWordField, userRePassWordField;
    JButton RegisterButton, RecommendPasswordButton, backToLogin;
    JComboBox<String> securityQuestions;

    UserRegController controller;

    public UserRegUI(UserRegController controller){
        this.controller = controller;

        // Set components for interface_adaptors
        frame.setLayout(null);
        createScreenComponents();
        setBoundForComponents();
        addScreenComponents();

        // Set frame size
        frame.setSize(600,400);
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

    /**
     * Event triggered when user clicked on recommend password
     */
    private void notifyListenerOnRecommendPassword() {
        UserRegViewModel viewModel = controller.giveRecommendPassword();
        String recommendPassword = viewModel.getRecommendPassword();
        userPassWordField.setText(recommendPassword);
        userRePassWordField.setText(recommendPassword);
        JOptionPane.showMessageDialog(this, recommendPassword);
    }

    /**
     * Event triggered when user clicked on register
     */
    private void notifyListenerOnRegisterClicked(){
        String name = userNameField.getText();
        String password = String.valueOf(userPassWordField.getPassword());
        String rePassword = String.valueOf(userRePassWordField.getPassword());
        Map<String, String> securityQuestionMap = new HashMap<>();
        securityQuestionMap.put((String) securityQuestions.getSelectedItem(), securityQuestionField.getText());

        UserRegViewModel viewModel = controller.register(name, password, rePassword, securityQuestionMap);
        if (viewModel.isPasswordValid() & viewModel.isUsernameValid() & viewModel.isSecurityQuestionValidity()) {
            String registerSuccessMessage = "register success\n password: %1$s.\n username: %2$s.\n security questions: %3$s\n";
            registerSuccessMessage = String.format(registerSuccessMessage, viewModel.isPasswordValid(), viewModel.isUsernameValid(), viewModel.isSecurityQuestionValidity());
            JOptionPane.showMessageDialog(this, registerSuccessMessage);
        } else {String registerFailureMessage = "register failed\n password: %1$s.\n username: %2$s.\n security questions: %3$s\n";
            registerFailureMessage = String.format(registerFailureMessage, viewModel.isPasswordValid(), viewModel.isUsernameValid(), viewModel.isSecurityQuestionValidity());
            JOptionPane.showMessageDialog(this, registerFailureMessage);
    }}

    private void setBoundForComponents() {
        // Set up Boundaries for Labels and text fields.
        userNameLabel.setBounds(10,20,220,25);
        userNameField.setBounds(240,20,300,25);
        passWordLabel.setBounds(10,65,220,25);
        userPassWordField.setBounds(240,65,300,25);
        rePasswordLabel.setBounds(10,110,220,25);
        userRePassWordField.setBounds(240,110,300,25);
        securityQuestions.setBounds(10,155,220,25);
        securityQuestionField.setBounds(240,155,300,25);
        // Set up Buttons
        RegisterButton.setBounds(30,250,100,50);
        RecommendPasswordButton.setBounds(180,250,200,50);
        backToLogin.setBounds(410,250,150,50);
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
        frame.add(securityQuestionField);
        frame.add(securityQuestions);
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
        securityQuestionField = new JTextField();
        String[] tempSecurityQuestions = {
                "In what city were you born?",
                "What is the name of your favorite pet?",
                "What is your mother's maiden name?",
                "What high school did you attend?",
                "What was the name of your elementary school?",
                "What was the make of your first car?",
                "What was your favorite food as a child?"};
        securityQuestions = new JComboBox<>(tempSecurityQuestions);
    }


    /**
     * Temporary test method
     */
    public static void main(String[] args) {
        UserRegisterDataBaseGateway dataBaseGateway = new UserRegisterFileGateway();
        UserRegOutputBoundary presenter = new UserRegPresenter();
        UserRegInputBoundary useCase = new UserRegUseCase(presenter, dataBaseGateway);
        UserRegController controller = new UserRegController(useCase);


        UserRegUI registerScreen = new UserRegUI(controller);
    }
}
