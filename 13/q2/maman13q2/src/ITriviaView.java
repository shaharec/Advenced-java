import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

public interface ITriviaView {
    void setAnswerButtonListiner(ActionListener answersListener);

    void setTimerListiner(ActionListener timerListener);

    void reset() throws FileNotFoundException;

    void timerStop();

    void showMessage(String s);

    void TimerAction() throws FileNotFoundException;
}
