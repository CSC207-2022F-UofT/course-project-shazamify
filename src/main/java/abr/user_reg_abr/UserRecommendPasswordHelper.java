package abr.user_reg_abr;

import java.util.Random;

public class UserRecommendPasswordHelper {
    public UserRegResponseModel giveRandomPassword(UserRegResponseModel responseModel){
        responseModel.setRecommendPassword(generateRandomPassword());
        return responseModel;
    }
    private String generateRandomPassword(){
        final int[] LEFT_LIMIT_SET = {48, 65, 97};
        final int[] RANGE = {10, 26, 26};
        final int PASSWORD_LENGTH = 10;
        Random random = new Random();

        StringBuilder targetPassword = new StringBuilder();
        for (int i = 0; i < PASSWORD_LENGTH; i++){
            // Pick to generate int, Uppercase or lowercase
            int target = random.nextInt(3);
            // Choose the left and right limit for generator
            int leftLimit = LEFT_LIMIT_SET[target];
            int range = RANGE[target];
            char temp = (char) (leftLimit + random.nextInt(range));
            targetPassword.append(temp);
        }
        return String.valueOf(targetPassword);
    }
}
