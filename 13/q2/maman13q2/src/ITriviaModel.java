import java.io.FileNotFoundException;

public interface ITriviaModel {
    public int getScore();

    public TriviaQuestion getCurrentQ();

    public void badAnswer();

    public void nextQ();

    public void reset() throws FileNotFoundException;

    boolean correctAnswer(String answer);
}
