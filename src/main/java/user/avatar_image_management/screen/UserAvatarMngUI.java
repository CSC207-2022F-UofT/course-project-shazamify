package user.avatar_image_management.screen;

import user.avatar_image_management.abr.UserAvatarMngInputBoundary;
import user.avatar_image_management.abr.UserAvatarMngOutputBoundary;
import user.avatar_image_management.abr.UserAvatarMngUseCase;
import user.database.UserAvatarDatabaseGateway;
import user.database.UserAvatarFileGateway;
import user.database.UserRegisterDataBaseGateway;
import user.database.UserRegisterFileGateway;
import user.entities.CommonUser;
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

public class UserAvatarMngUI extends JPanel {
    User user;
    UserAvatarMngController controller;
    final JFrame frame = new JFrame();
    JButton avatarImageButton;
    JLabel userName;

    // The Avatar icon size
    int WIDTH = 100;
    int HEIGHT = 100;


    public UserAvatarMngUI(User user, UserAvatarMngController controller){
        this.user = user;
        this.controller = controller;

        // Set components for screen
        frame.setLayout(null);
        createScreenComponents();
        setBoundForComponents();
        addScreenComponents();

        // Set frame size
        frame.setSize(600,400);
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
    }

    private void setBoundForComponents() {
        avatarImageButton.setBounds(50,50,WIDTH,HEIGHT);
        userName.setBounds(50,170,100,50);
    }

    private void createScreenComponents() {
        avatarImageButton = new JButton(new ImageIcon(user.getUserAvatar().getScaledInstance(WIDTH,HEIGHT,BufferedImage.TYPE_INT_ARGB)));
        userName = new JLabel(user.getUserName());
        userName.setFont(new Font("Serif", Font.PLAIN, 30));
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
        UserAvatarMngUI ui = new UserAvatarMngUI(user, userAvatarMngController);
    }
}
