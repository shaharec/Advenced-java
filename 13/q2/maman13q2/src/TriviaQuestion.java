public class TriviaQuestion {
    /** Class represent a trivia question.
     * Contain:
     * 1. question
     * 2. Correct answer
     * 3. 3 incorrect answers.**/

    private String question;
    private String correctAnswer;
    private String answer2;
    private String answer3;
    private String answer4;

    public TriviaQuestion(String question){
        this.question = question;
    }


    public TriviaQuestion() {

    }

    public void setCorrectAnswer(String answer){
        this.correctAnswer = answer;
    }
    public void setAnswer2(String answer){
        this.answer2 = answer;
    }
    public void setAnswer3(String answer){
        this.answer3 = answer;
    }
    public void setAnswer4(String answer){
        this.answer4 = answer;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public String getQuestion() {
        return question;
    }


    public String getAnswerByindex(int answerNum) {
        switch(answerNum){
            case 0:
                return this.correctAnswer;
            case 1:
                return this.answer2;
            case 2:
                return this.answer3;
            case 3:
                return this.answer4;
        }
        // If answerNum is not in 0-4 range return empty String.
        return "";
    }
}
