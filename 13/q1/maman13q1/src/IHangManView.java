import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

public interface IHangManView {
    void addLettersActionListener(ActionListener list);

    void addResetActionListener(ActionListener list);

    void showError(String letter_was_selected_already);

    void repaint();

    void showLose() throws FileNotFoundException;

    void reset();
}
