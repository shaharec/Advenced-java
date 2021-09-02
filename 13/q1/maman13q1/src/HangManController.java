import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

public class HangManController implements IHangManController {
    private IHangManView view;
    private IHangManModel model;

    public HangManController(IHangManModel model, IHangManView view) {
        this.model = model;
        this.view = view;
        this.view.addLettersActionListener(new LetterButtenListener());
        this.view.addResetActionListener(new ResetButtenListener());
    }

    // Letters listener, update hange man and guss according to the letter.
    private class LetterButtenListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton b = (JButton) e.getSource();
            String desc = b.getText();
            char c = desc.charAt(0);
            if (c == ' ') { // If letter was selected show error message.
                view.showError("Letter was selected already");
            } else {
                b.setText(" ");
                model.handelLetter(c);
                view.repaint();
                if (model.getLifes() == 0) { // If the user lost the game.
                    try {
                        view.showLose();
                    } catch (FileNotFoundException fileNotFoundException) {
                        fileNotFoundException.printStackTrace();
                    }
                }
            }
        }
    }
    // Class for restart game button listener
    private class ResetButtenListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {// Reset model and view.
            try {
                model.reset();
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
            view.reset();
        }
    }
}
