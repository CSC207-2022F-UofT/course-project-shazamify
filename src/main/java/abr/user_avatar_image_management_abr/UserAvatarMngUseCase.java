package abr.user_avatar_image_management_abr;

import interface_adaptors.user_avatar_image_management_ia.UserAvatarMngViewModel;
import entities.user_entities.User;
import entities.user_entities.UserAvatar;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class UserAvatarMngUseCase implements UserAvatarMngInputBoundary{
    UserAvatarDatabaseGateway databaseGateway;
    UserAvatarMngResponseModel responseModel = new UserAvatarMngResponseModel();
    UserAvatarMngOutputBoundary outputBoundary;

    public UserAvatarMngUseCase(UserAvatarDatabaseGateway databaseGateway, UserAvatarMngOutputBoundary outputBoundary){
        this.databaseGateway = databaseGateway;
        this.outputBoundary = outputBoundary;
    }
    @Override
    public UserAvatarMngViewModel verifyAndChangeAvatar(UserAvatarMngRequestModel requestModel) {
        // Initialize the data from pacakage
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
        return outputBoundary.packageAndPresent(responseModel);
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
