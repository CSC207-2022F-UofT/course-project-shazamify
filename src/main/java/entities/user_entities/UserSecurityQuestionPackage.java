package entities.user_entities;

import java.io.Serializable;
import java.util.Map;

public class UserSecurityQuestionPackage implements Serializable {
    Map<String, String> securityQuestions;

    public UserSecurityQuestionPackage(Map<String, String> userSecurityQuestionMap){
        this.securityQuestions = userSecurityQuestionMap;
    }

    /**
     * Question list:
     * "In what city were you born?",
     * "What is the name of your favorite pet?",
     * "What is your mother's maiden name?",
     * "What high school did you attend?",
     * "What was the name of your elementary school?",
     * "What was the make of your first car?",
     * "What was your favorite food as a child?"
     *
     *
     * @param question the corresponding question number for question
     * @return question answer
     */
    public String getSecurityQuestionsAnswer(String question){
        return securityQuestions.get(question);
    }

    public Map<String, String> getSecurityQuestionsMap() {
        return securityQuestions;
    }
}
