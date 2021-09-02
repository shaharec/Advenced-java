import java.awt.*;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javax.swing.*;

public class HangManView extends JFrame implements IHangManView {

    private IHangManModel model;
    private ArrayList<JButton> lettersButton = new ArrayList<>();
    private JButton reset;
    private JLabel guss;
    private final int firstLetter = (int)'A';
    private final int lastLetter = (int)'Z';
    private final int WIDTH = 1250;
    private final int HEIGHT = 600;
    private final int hangingManSteps = 6;


    public HangManView(IHangManModel model) {
        super("Hanging man game");
        this.model = model;

        // Creat main panel.
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // Define sub panels.
        HangManPanel HangingMan = new HangManPanel();
        ButtontsPannel bPanel = new ButtontsPannel();
        LabelsPanel Lpanel = new LabelsPanel();

        // Labels panel.
        this.guss = new JLabel(model.getGuss());
        Lpanel.add(this.guss);
        this.reset = new JButton("Reset");
        Lpanel.add(this.reset);

        // Creat buttons for letters.
        for(int i = firstLetter;i<lastLetter+1;i++) {
           JButton button = new JButton(String.valueOf((char)i));
           lettersButton.add(button);
       }

        // Add buttons to buttons panel.
        for (int i = 0; i< lettersButton.size(); i++)
            bPanel.add(lettersButton.get(i));


        //Add panels to main panel.
        mainPanel.add(Lpanel,BorderLayout.PAGE_START);
        mainPanel.add(HangingMan,BorderLayout.CENTER);
        mainPanel.add(bPanel,BorderLayout.PAGE_END);

        // Add main panel.
        this.add(mainPanel);
        mainPanel.repaint();

        // Show frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(WIDTH, HEIGHT);
        this.setVisible(true);

    }

    public void addLettersActionListener(ActionListener list){
        for (int i = 0; i< lettersButton.size(); i++)
            lettersButton.get(i).addActionListener(list);
    }

    public void addResetActionListener(ActionListener list){
        this.reset.addActionListener(list);
    }



    public void showError(String errMessage) {
        JOptionPane.showMessageDialog(this, errMessage);
    }

    // Restart game, and repaint.
    public void reset() {
        int buttonIndex = 0;
        for (int i = firstLetter; i<lastLetter+1;i++) {
            lettersButton.get(buttonIndex).setText(String.valueOf((char)i));
            buttonIndex++;
        }
        this.repaint();
    }

    // Show losing message, and restart game.
    public void showLose() throws FileNotFoundException {
        JOptionPane.showMessageDialog(this,"You lose!\n Restarting game.");
        this.model.reset();
        this.reset();
    }


    // Labels panel class, Drawing guesses.
    private class LabelsPanel extends JPanel{
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            guss.setText(model.getGuss());
        }
    }

    // Buttons panel, Drawing letters and empty (if the letter was selected).
    private class ButtontsPannel extends JPanel {
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            for (int i = 0; i< lettersButton.size(); i++)
                this.add(lettersButton.get(i));
        }
    }

    // Hanging man panel- Drawing the hanging man.
    private class HangManPanel extends JPanel{

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            paintHangingMan(g,model.getLifes());
        }

        private void paintHangingMan(Graphics g, int lifes) {
            int width = getWidth();
            int height = getHeight();
            int midWidth = width/2,midHeight=height/2,stageW=width/100,stageH=height/100;
            //Draw a clean hanging man.
            g.clearRect(0, 0, width, height);
            g.drawLine(midWidth-45*stageW,98*stageH,midWidth+40*stageW,98*stageH);
            g.drawLine(midWidth-40*stageW,98*stageH,midWidth-40*stageW,5*stageH);
            g.drawLine(midWidth-40*stageW,5*stageH,midWidth,5*stageH);
            g.drawLine(midWidth,5*stageH,midWidth,10*stageH);
            g.setColor(Color.black);
            // Fill the hanging man by the number of lifes.
            for (int i=0;i<hangingManSteps-lifes;i++){
                switch (i ){
                    case 0:
                        g.drawOval(midWidth-10*stageW, 10*stageH, 20*stageW, 20*stageH);
                        break;
                    case 1:
                        g.drawLine(midWidth,30*stageH,midWidth,75*stageH);
                        break;
                    case 2:
                        g.drawLine(midWidth,45*stageH,midWidth+15*stageW,60*stageH);
                        break;
                    case 3:
                        g.drawLine(midWidth,45*stageH,midWidth-15*stageW,60*stageH);
                        break;
                    case 4:
                        g.drawLine(midWidth,75*stageH,midWidth+20*stageW,95*stageH);
                        break;
                    case 5:
                        g.drawLine(midWidth,75*stageH,midWidth-20*stageW,95*stageH);
                        g.setColor(Color.red);
                        g.drawLine(midWidth-20*stageW,10*stageH,midWidth+20*stageW,95*stageH);
                        g.setColor(Color.black);
                        break;

        }
    }




        }
    }

}
