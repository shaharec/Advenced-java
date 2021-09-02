import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

public class TriviaController implements ITriviaController {

    private ITriviaModel model;
    private ITriviaView view;

    public TriviaController(ITriviaModel model, ITriviaView view) throws FileNotFoundException {
        this.model = model;
        this.view = view;
        // Set listeners.
        this.view.setAnswerButtonListiner(new AnswersListener());
        this.view.setTimerListiner(new TimerListener());
        // Refresh view.
        this.view.reset();
    }

   // Listener for the answers buttens.
    private class AnswersListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton b = (JButton) e.getSource();
            String answer = b.getText();
            view.timerStop();
            // Check if the user select the correct answer.
            if (model.correctAnswer(answer)) {
                view.showMessage("Correct answer!");
            } else {
                view.showMessage("Bad answer");
                model.badAnswer();
            }
            // Move to the next question.
            model.nextQ();
            try {
                view.reset();
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
        }
    }
    // Timer listener.
    private class TimerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                view.TimerAction();
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
        }
    }

}
