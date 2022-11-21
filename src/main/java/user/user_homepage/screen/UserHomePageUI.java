package user.user_homepage.screen;

import user.avatar_image_management.abr.UserAvatarMngInputBoundary;
import user.avatar_image_management.abr.UserAvatarMngOutputBoundary;
import user.avatar_image_management.abr.UserAvatarMngUseCase;
import user.avatar_image_management.screen.UserAvatarMngController;
import user.avatar_image_management.screen.UserAvatarMngViewModel;
import user.avatar_image_management.screen.UserChangeMngPresenter;
import user.avatar_image_management.DS.UserAvatarDatabaseGateway;
import user.avatar_image_management.DS.UserAvatarFileGateway;
import user.reg.DS.UserRegisterDataBaseGateway;
import user.reg.DS.UserRegisterFileGateway;
import user.entities.User;
import user.reg.abr.UserRegOutputBoundary;
import user.reg.abr.UserRegRequestModel;
import user.reg.abr.UserRegUseCase;
import user.reg.screen.UserRegPresenter;
import user.reg.screen.UserRegViewModel;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class UserHomePageUI extends JPanel {
    User user;
    UserAvatarMngController controller;
    final JFrame frame = new JFrame();
    JButton avatarImageButton, changeAccountUserName, changeAccountPassword;
    JLabel userName, creationTimeLabel, passwordLabel;

    // The Avatar icon size
    int WIDTH = 100;
    int HEIGHT = 100;


    public UserHomePageUI(User user, UserAvatarMngController controller){
        this.user = user;
        this.controller = controller;

        // Set components for screen
        frame.setLayout(null);
        createScreenComponents();
        setBoundForComponents();
        addScreenComponents();

        // Set frame size
        frame.setSize(700,400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        avatarImageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                notifyListenerOnAvatarClicked();
            }
        });
    }

    private void notifyListenerOnAvatarClicked() {
        // Initialize the fileChooser for Image
        JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

        fileChooser.setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File f) {
                if (f.isDirectory()) {
                    return true;
                } else {
                    String fileName = f.getName().toLowerCase();
                    return fileName.endsWith("jpg");
                }
            }

            @Override
            public String getDescription() {
                return "JPG images";
            }
        });

        int chooseIndicator = fileChooser.showOpenDialog(null);

        if (chooseIndicator == JFileChooser.APPROVE_OPTION) {
            UserAvatarMngViewModel viewModel =
                    controller.verifyAndChangeAvatar(fileChooser.getSelectedFile().getAbsolutePath(), user.getUserName());

            User modifiedUser = viewModel.getUser();
            boolean isValid = viewModel.isDirectoryValid();

            // If we change the avatar successfully, display avatar
            if (isValid){
                this.user = modifiedUser;
                avatarImageButton.setIcon(new ImageIcon(user.getUserAvatar().getScaledInstance(WIDTH,HEIGHT,BufferedImage.TYPE_INT_ARGB)));
            }

        }
    }

    private void addScreenComponents() {
        frame.add(avatarImageButton);
        frame.add(userName);
        frame.add(creationTimeLabel);
        frame.add(passwordLabel);
        frame.add(changeAccountUserName);
        frame.add(changeAccountPassword);

    }

    private void setBoundForComponents() {
        avatarImageButton.setBounds(50,50,WIDTH,HEIGHT);
        userName.setBounds(50,170,100,50);
        creationTimeLabel.setBounds(200, 50, 250,40);
        passwordLabel.setBounds(200,110,250,40);
        changeAccountUserName.setBounds(470,50,150,40);
        changeAccountPassword.setBounds(470,110,150,40);
    }

    private void createScreenComponents() {
        avatarImageButton = new JButton(new ImageIcon(user.getUserAvatar().getScaledInstance(WIDTH,HEIGHT,BufferedImage.TYPE_INT_ARGB)));
        userName = new JLabel(user.getUserName());
        userName.setFont(new Font("Serif", Font.PLAIN, 30));
        creationTimeLabel = new JLabel("Account creation time is: " + user.getAccountCreationTime());
        passwordLabel = new JLabel("Password is:" + user.getPassword());
        changeAccountPassword = new JButton("change password");
        changeAccountUserName = new JButton("change username");
    }

    public static void main(String[] args) {
        // Initialize components for avatar
        UserAvatarMngOutputBoundary userAvatarMngOutputBoundary = new UserChangeMngPresenter();
        UserAvatarDatabaseGateway userAvatarDatabaseGateway = new UserAvatarFileGateway();
        UserAvatarMngInputBoundary userAvatarMngInputBoundary = new UserAvatarMngUseCase(userAvatarDatabaseGateway, userAvatarMngOutputBoundary);
        UserAvatarMngController userAvatarMngController= new UserAvatarMngController(userAvatarMngInputBoundary);

        // Initialize components for register
        UserRegisterDataBaseGateway registerDataBaseGateway = new UserRegisterFileGateway();
        registerDataBaseGateway.clearDatabase();
        UserRegOutputBoundary boundary = new UserRegPresenter();
        UserRegUseCase userRegUseCase = new UserRegUseCase(boundary, registerDataBaseGateway);
        Map<String, String> securityQuestionMap= new HashMap<>();
        securityQuestionMap.put("1","2");

        // Register a sample User
        UserRegRequestModel requestModel = new UserRegRequestModel("111","222","111",securityQuestionMap);
        UserRegViewModel viewModel = userRegUseCase.register(requestModel);

        // Set ip UI
        User user = userAvatarDatabaseGateway.getUser("222");
        UserHomePageUI ui = new UserHomePageUI(user, userAvatarMngController);
    }
}
