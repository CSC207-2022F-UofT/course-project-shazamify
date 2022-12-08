package user_unit_test.testing_tools;

import abr.user_avatar_image_management_abr.UserAvatarDatabaseGateway;
import abr.user_avatar_image_management_abr.UserAvatarMngInputBoundary;
import abr.user_avatar_image_management_abr.UserAvatarMngOutputBoundary;
import abr.user_avatar_image_management_abr.UserAvatarMngUseCase;
import ds.user_avatar_image_management_ds.UserAvatarFileGateway;
import interface_adaptors.user_avatar_image_management_ia.UserAvatarMngController;
import interface_adaptors.user_avatar_image_management_ia.UserAvatarMngViewModel;
import interface_adaptors.user_avatar_image_management_ia.UserChangeMngPresenter;

/**
 * @author David Li
 */
public class ChangeAvatarTestingTools {
    public static UserAvatarMngController getChangeAvatarController(){
        // Get componets
        UserAvatarMngOutputBoundary outputBoundary = new UserChangeMngPresenter();
        UserAvatarDatabaseGateway databaseGateway = new UserAvatarFileGateway();
        UserAvatarMngInputBoundary inputBoundary = new UserAvatarMngUseCase(databaseGateway, outputBoundary);

        // get usecase

        return new UserAvatarMngController(inputBoundary);
    }
}