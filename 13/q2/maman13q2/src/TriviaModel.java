import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.Timer;

public class TriviaModel implements ITriviaModel {

    private ArrayList<TriviaQuestion> questions;
    private TriviaQuestion currentQ;
    private int score;
    private final String FILE_PATH = "src/input.txt";
    private final int ROWS_TRIVIA = 5;

    public TriviaModel() throws FileNotFoundException {

        fillQuestions();
        this.currentQ = getNewQuestion();
        this.score =0;
    }

    public TriviaQuestion getCurrentQ() {
        return this.currentQ;
    }

    public TriviaQuestion getNewQuestion() {
        // Select random question from the questions list
        Random rnd = new Random();
        int index=0;
        TriviaQuestion q;
        if(questions.size() == 0)
            return null;
        if(questions.size()>1)
            index = rnd.nextInt(questions.size());
        q= questions.get(index);
        this.questions.remove(index);
        return q;
    }

   // Fill questions Array List from the input file
    /**Format of input file is
     * question
     * correct answer.
     * incorrect answer 1
     * incorrect answer 2
     * incorrect answer 3**/
    private void fillQuestions() throws FileNotFoundException {
        Scanner sc = new Scanner(new File(FILE_PATH));
        this.questions = new ArrayList<>();
        int index = 0;
        TriviaQuestion q = new TriviaQuestion();
        while (sc.hasNext()) {
            switch (index % ROWS_TRIVIA) {
                case 0:
                    if (index == 0) {
                        q = new TriviaQuestion(sc.nextLine());
                    }else {
                        questions.add(q);
                        q = new TriviaQuestion(sc.nextLine());
                    }
                    break;
                case 1:
                    q.setCorrectAnswer(sc.nextLine());
                    break;
                case 2:
                    q.setAnswer2(sc.nextLine());
                    break;
                case 3:
                    q.setAnswer3(sc.nextLine());
                    break;
                case 4:
                    q.setAnswer4(sc.nextLine());
                    break;
            }
            index++;
        }
        questions.add(q);
        sc.close();
    }
    // Rest model for new game.
    public void reset() throws FileNotFoundException {
        this.fillQuestions();
        this.currentQ = getNewQuestion();
        this.score =0;

    }

    // Returns if the answer is correct and update the score.
    public boolean correctAnswer(String answer) {
        if( answer == currentQ.getCorrectAnswer()) {
            score += 100;
            return true;
        }
        return false;

    }
    // Reduce the Score for bad answer.
    public void badAnswer() {
        score -=100;
    }

    public int getScore() {
        return this.score;
    }
    // Set next questions in the current question variable.
    public void nextQ() {
        this.currentQ = getNewQuestion();
    }
}
