package framework.user_screen;


import interface_adaptors.user_avatar_image_management_ia.UserAvatarMngController;
import interface_adaptors.user_avatar_image_management_ia.UserAvatarMngViewModel;
import interface_adaptors.user_change_password_ia.UserChangePasswordController;
import interface_adaptors.user_login_ia.UserStatusObserver;
import interface_adaptors.user_login_ia.UserStatusViewModel;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * @author David Li
 *
 * Initialize a HomePage JPanel of the User
 */
public class UserHomePageUI extends JPanel implements UserStatusObserver {
    UserStatusViewModel userStatusViewModel;
    UserAvatarMngController userAvatarMngController;
    UserChangePasswordController userChangePasswordController;
    UserAvatarMngViewModel userAvatarMngViewModel;
    final JFrame frame = new JFrame();
    JButton avatarImageButton, changeAccountUserName, changeAccountPassword;
    JLabel userName, creationTimeLabel, passwordLabel;

    // The Avatar icon size
    int WIDTH = 100;
    int HEIGHT = 100;


    public UserHomePageUI(UserAvatarMngController avatarMngController, UserChangePasswordController changePasswordController,
                          UserStatusViewModel userStatusViewModel, UserAvatarMngViewModel avatarMngViewModel){
        this.userStatusViewModel = userStatusViewModel;
        this.userAvatarMngController = avatarMngController;
        this.userAvatarMngViewModel = avatarMngViewModel;
        this.userChangePasswordController = changePasswordController;
        // Set components for interface_adaptors
        frame.setLayout(null);
        createScreenComponents();
        setBoundForComponents();
        addScreenComponents();

        // Set frame size
        frame.setSize(700,400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        avatarImageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                notifyListenerOnAvatarClicked();
            }
        });

        changeAccountPassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                notifyListenerOnChangePasswordClicked();
            }
        });
    }

    private void notifyListenerOnChangePasswordClicked() {
        new UserChangePasswordUI(userStatusViewModel, userChangePasswordController, userAvatarMngController, userAvatarMngViewModel);
        frame.dispose();
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
            userAvatarMngController.verifyAndChangeAvatar(fileChooser.getSelectedFile().getAbsolutePath(), userStatusViewModel.getUserName());

            boolean isValid = userAvatarMngViewModel.isDirectoryValid();
            avatarImageButton.setIcon(new ImageIcon(userStatusViewModel.getUserAvatar().getScaledInstance(WIDTH,HEIGHT,BufferedImage.TYPE_INT_ARGB)));
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
        avatarImageButton.setIcon(new ImageIcon(userStatusViewModel.getUserAvatar().getScaledInstance(WIDTH,HEIGHT,BufferedImage.TYPE_INT_ARGB)));
    }
    /**
     * If the User is get updated, then update the User Homepage components
     */
    @Override
    public void userUpdated() {
        updateScreenComponents();
    }
}
