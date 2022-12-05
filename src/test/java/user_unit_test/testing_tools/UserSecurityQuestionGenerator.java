package user_unit_test.testing_tools;

import entities.user_entities.UserSecurityQuestionPackage;

import java.util.HashMap;
import java.util.Map;

/**
 * @author David Li
 *
 * This file is for Register testing
 */
public class UserSecurityQuestionGenerator {
    /**
     * Generate security question according to param
     * @param question security question
     * @param answer security question answer
     * @return A map of security Question
     */
    public static Map<String, String> generateSecurityQuestionMap(String question, String answer){
        Map<String, String> securityQuestion = new HashMap<>();
        securityQuestion.put(question, answer);
        return securityQuestion;
    }

    public static UserSecurityQuestionPackage generateSecurityQuestionPackage(String question, String answer){
        Map<String, String> securityQuestion = new HashMap<>();
        securityQuestion.put(question, answer);
        return new UserSecurityQuestionPackage(securityQuestion);
    }

    /**
     * Generate a security Question
     * @return A map of security Question
     *
     * The Question and answer will be "Test"
     */
    public static Map<String, String> generateSecurityQuestionMap(){
        Map<String, String> securityQuestion = new HashMap<>();
        String question = "Test";
        String answer = "Test";
        securityQuestion.put(question, answer);
        return securityQuestion;
    }

    public static UserSecurityQuestionPackage generateSecurityQuestionPackage(){
        Map<String, String> securityQuestion = new HashMap<>();
        String question = "Test";
        String answer = "Test";
        securityQuestion.put(question, answer);
        return new UserSecurityQuestionPackage(securityQuestion);
    }
}
