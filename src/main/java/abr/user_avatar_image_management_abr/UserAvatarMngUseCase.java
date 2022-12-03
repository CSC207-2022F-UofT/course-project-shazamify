package abr.user_avatar_image_management_abr;

import interface_adaptors.user_avatar_image_management_ia.UserAvatarMngViewModel;
import entities.user_entities.User;
import entities.user_entities.UserAvatar;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @author David Li
 *
 * Verify if the directory of the UserAvatar is Valid. And Change the User Avatar
 */
public class UserAvatarMngUseCase implements UserAvatarMngInputBoundary{
    UserAvatarDatabaseGateway databaseGateway;
    UserAvatarMngResponseModel responseModel = new UserAvatarMngResponseModel();
    UserAvatarMngOutputBoundary outputBoundary;

    /**
     * Initialize the User Avatar Management UseCase
     * @param databaseGateway The Database Gateway of the User Management System
     * @param outputBoundary The Presenter of the User Management System
     */
    public UserAvatarMngUseCase(UserAvatarDatabaseGateway databaseGateway, UserAvatarMngOutputBoundary outputBoundary){
        this.databaseGateway = databaseGateway;
        this.outputBoundary = outputBoundary;
    }

    /**
     * Verify if the Avatar directory is Valid, if Valid, change the User Avatar inside the database. And set response
     * inside the ViewModel though Presenter. The Response will contain:
     * 1) The Validity of Avatar
     * 2) The entities about User After changing Avatar.
     * @param requestModel The
     */
    @Override
    public void verifyAndChangeAvatar(UserAvatarMngRequestModel requestModel) {
        // Initialize the data from package
        String userName = requestModel.userName;
        String directory = requestModel.directory;

        // Check if the directory is end with .jpg
        boolean isValid = verify(directory);

        // If valid, Change avatar in user_database
        if (isValid) {
            try {
                UserAvatar avatar = createUserAvatar(directory);
                User user = databaseGateway.changeAvatar(userName, avatar);
                responseModel.setUser(user);
                responseModel.setDirectoryValid(true);
            } catch (IOException e){
                throw new RuntimeException("File Directory not found when import avatar image");
            }
        } else {
            responseModel.setDirectoryValid(false);
        }

        // call output Boundary
        outputBoundary.packageAndPresent(responseModel);
    }

    private UserAvatar createUserAvatar(String directory) throws IOException {
        BufferedImage img = ImageIO.read(new File(directory));
        return new UserAvatar(img);
    }

    private boolean verify(String directory){
        String fileName = directory.toLowerCase();
        return fileName.endsWith("jpg");
    }
}
