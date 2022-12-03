package framework.user_screen;

import abr.user_avatar_image_management_abr.UserAvatarMngInputBoundary;
import abr.user_avatar_image_management_abr.UserAvatarMngOutputBoundary;
import abr.user_avatar_image_management_abr.UserAvatarMngUseCase;
import abr.user_avatar_image_management_abr.UserAvatarDatabaseGateway;
import ds.user_avatar_image_management_ds.UserAvatarFileGateway;
import abr.user_reg_abr.UserRegisterDataBaseGateway;
import ds.user_reg_ds.UserRegisterFileGateway;
import abr.user_reg_abr.UserRegOutputBoundary;
import abr.user_reg_abr.UserRegRequestModel;
import abr.user_reg_abr.UserRegUseCase;
import interface_adaptors.user_avatar_image_management_ia.UserAvatarMngController;
import interface_adaptors.user_avatar_image_management_ia.UserAvatarMngViewModel;
import interface_adaptors.user_avatar_image_management_ia.UserChangeMngPresenter;
import interface_adaptors.user_login_ia.UserStatusObserver;
import interface_adaptors.user_login_ia.UserStatusViewModel;
import interface_adaptors.user_reg_ia.UserRegPresenter;
import interface_adaptors.user_reg_ia.UserRegViewModel;

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

public class UserHomePageUI extends JPanel implements UserStatusObserver {
    UserStatusViewModel userStatusViewModel;
    UserAvatarMngController controller;
    UserAvatarMngViewModel userAvatarMngViewModel;
    final JFrame frame = new JFrame();
    JButton avatarImageButton, changeAccountUserName, changeAccountPassword;
    JLabel userName, creationTimeLabel, passwordLabel;

    // The Avatar icon size
    int WIDTH = 100;
    int HEIGHT = 100;


    public UserHomePageUI(UserAvatarMngController controller, UserStatusViewModel userStatusViewModel, UserAvatarMngViewModel avatarMngViewModel){
        this.userStatusViewModel = userStatusViewModel;
        this.controller = controller;
        this.userAvatarMngViewModel = avatarMngViewModel;

        // Set components for interface_adaptors
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
            controller.verifyAndChangeAvatar(fileChooser.getSelectedFile().getAbsolutePath(), userStatusViewModel.getUserName());

            boolean isValid = userAvatarMngViewModel.isDirectoryValid();

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
        avatarImageButton = new JButton(new ImageIcon(userStatusViewModel.getUserAvatar().getScaledInstance(WIDTH,HEIGHT,BufferedImage.TYPE_INT_ARGB)));
        userName = new JLabel(userStatusViewModel.getUserName());
        userName.setFont(new Font("Serif", Font.PLAIN, 30));
        creationTimeLabel = new JLabel("Account creation time is: " + userStatusViewModel.getAccountCreateTime());
        passwordLabel = new JLabel("Password is:" + userStatusViewModel.getPassWord());
        changeAccountPassword = new JButton("change password");
        changeAccountUserName = new JButton("change username");
    }

    private void updateScreenComponents(){
        userName.setText(userStatusViewModel.getUserName());
        passwordLabel.setText("Password is:" + userStatusViewModel.getPassWord());
    }

    public static void main(String[] args) {
        // Initialize components for avatar
        UserAvatarMngViewModel avatarMngViewModel= new UserAvatarMngViewModel();
        UserStatusViewModel statusViewModel = new UserStatusViewModel();
        UserAvatarMngOutputBoundary userAvatarMngOutputBoundary = new UserChangeMngPresenter(avatarMngViewModel, statusViewModel);
        UserAvatarDatabaseGateway userAvatarDatabaseGateway = new UserAvatarFileGateway();
        UserAvatarMngInputBoundary userAvatarMngInputBoundary = new UserAvatarMngUseCase(userAvatarDatabaseGateway, userAvatarMngOutputBoundary);
        UserAvatarMngController userAvatarMngController= new UserAvatarMngController(userAvatarMngInputBoundary);

        // Initialize components for register
        UserRegViewModel regViewModel = new UserRegViewModel();
        UserRegisterDataBaseGateway registerDataBaseGateway = new UserRegisterFileGateway();
        registerDataBaseGateway.clearDatabase();
        UserRegOutputBoundary boundary = new UserRegPresenter(regViewModel);
        UserRegUseCase userRegUseCase = new UserRegUseCase(boundary, registerDataBaseGateway);
        Map<String, String> securityQuestionMap= new HashMap<>();
        securityQuestionMap.put("1","2");

        // Register a sample User
        UserRegRequestModel requestModel = new UserRegRequestModel("111","222","111",securityQuestionMap);
        userRegUseCase.register(requestModel);

        //Set ip UI
        UserStatusViewModel userStatusViewModel = new UserStatusViewModel();
        UserAvatarMngViewModel userAvatarMngViewModel = new UserAvatarMngViewModel();
        UserHomePageUI ui = new UserHomePageUI(userAvatarMngController, userStatusViewModel, userAvatarMngViewModel);
    }

    /**
     * If the User is get updated
     */
    @Override
    public void userUpdated() {
        updateScreenComponents();
    }
}
