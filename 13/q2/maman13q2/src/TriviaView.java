
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class TriviaView extends JFrame implements ITriviaView {

    private  ITriviaModel model;
    private JButton [] answers;
    private final  int NUM_ANSWERS = 4;
    private int timeLeft;
    private JLabel question;
    private JLabel time;
    private JLabel score;
    private final int WIDTH = 600;
    private final int HEIGHT = 200;
    private final int TIME_DEFAULT = 10;
    private Timer timer;

    public TriviaView(ITriviaModel model){
        super("Trivia game");
        this.model = model;
        this.answers = new JButton[NUM_ANSWERS];
        this.timeLeft = TIME_DEFAULT;
        this.time = new JLabel(String.valueOf(this.timeLeft));
        this.score = new JLabel(String.valueOf(this.model.getScore()));
        this.question = new JLabel(model.getCurrentQ().getQuestion());

        // Main panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.Y_AXIS));

        // Buttons panel.
        JPanel bPanel = new JPanel();
        for (int i = 0; i<answers.length;i++) {
            answers[i] = new JButton();
            bPanel.add(answers[i]);
        }
        // Question Panel
        QuestionPanel qP = new QuestionPanel();
        qP.add(question);

        // Info Panel
        TriviaPanel info = new TriviaPanel();
        info.add(time);
        info.add(score);

        // Add panels to main panel.
        mainPanel.add(qP);
        mainPanel.add(bPanel);
        mainPanel.add(info);

        // Add main panel to Frame.
        this.add(mainPanel);

        // Show frame.
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(WIDTH, HEIGHT);
        this.setVisible(true);
    }

    @Override
    public void showMessage(String s) {
        JOptionPane.showMessageDialog(this, s);
    }

    @Override
    // Reset view and update the frame.
    public void reset() throws FileNotFoundException {
        this.timeLeft = TIME_DEFAULT;
        this.timer.restart();
       // Update answers and put them in random buttons
        ArrayList<Integer> q_number = new ArrayList<>(Arrays.asList(0,1,2,3));
        Random rnd = new Random();
        int i = 0;
       if(model.getCurrentQ() != null) {  // Check if there is questions left.
           while (q_number.size() != 0) {
               int arrayIndex = rnd.nextInt(q_number.size());
               answers[i].setText(model.getCurrentQ().getAnswerByindex(q_number.get(arrayIndex)));
               q_number.remove(arrayIndex);
               i++;
           }
           this.repaint();
       }
       else this.printEndGame(); // No questions left end game.
    }
    @Override
    public void setAnswerButtonListiner(ActionListener answersListener) {
        for (int i = 0; i<answers.length;i++)
            answers[i].addActionListener(answersListener);
    }

    @Override
    public void timerStop() {
        this.timer.stop();
    }

    @Override
    public void setTimerListiner(ActionListener timerListener) {
        this.timer = new Timer(1000,timerListener);
        this.timer.start();

    }

    // Preform action each timer tick.
    // Reduce time left and check if time for answering passed.
    @Override
    public void TimerAction() throws FileNotFoundException {
        timeLeft--;
        time.setText(String.valueOf(timeLeft));
        if(timeLeft==0) {
            timer.stop();
            showMessage("Time is over!");
            model.badAnswer();
            model.nextQ();
            this.reset();
            this.repaint();
        }
    }


    // Class for information panel.
    private class TriviaPanel extends JPanel {

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
                time.setText("Time left: "+timeLeft);
                score.setText("Score: "+model.getScore());
            }
    }
    // CLass for quesrion panel.
    private class QuestionPanel extends JPanel {

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            if(model.getCurrentQ() != null) {
                question.setText(model.getCurrentQ().getQuestion());
            }
        }
    }

    //End game, show summary of the game and check if the user wants to plat again.
    private void printEndGame() throws FileNotFoundException {
        String message = "Game over. \nScore: "+model.getScore() + "\nDo you want to play again?";
        timer.stop();
        int reset = JOptionPane.showConfirmDialog(this, message);
        if(reset == JOptionPane.YES_OPTION) { // Restart game.
            model.reset();
            this.reset();
        }else
            System.exit(0);  //Exit application.
    }
}
