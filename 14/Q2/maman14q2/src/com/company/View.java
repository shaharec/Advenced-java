package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.YearMonth;

public class View extends JFrame implements IView {

    private IModel model;
    private JComboBox day;
    private JComboBox month;
    private JComboBox year;
    private JTextArea textArea;
    private final Integer [] months = {1,2,3,4,5,6,7,8,9,10,11,12} ;
    private final int WIDTH = 500;
    private final int HIEGHT = 300;
    private final int TEXT_WIDTH_SUB = 13;
    private final int TEXT_HIEGHT_SUB = 10;
    private final int NUM_YEAR = 10; // number of year avalable in combobox.
    private JButton saveButton;
    private JButton saveToFile;
    private JButton getFromFile;

    public View(IModel model){
        super("Notes App");
        this.model = model;
        // Set combobox items.
        setDatesInCombobox();

        // Create main panel.
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.Y_AXIS));

        // Add combobox
        JPanel datePanel = new JPanel();
        datePanel.add(this.day);
        datePanel.add(this.month);
        datePanel.add(this.year);

        //Add text panel
        JPanel textPanel = new TextPanel();
        this.textArea = new JTextArea("Write your note here.",this.HIEGHT /TEXT_HIEGHT_SUB,this.WIDTH/TEXT_WIDTH_SUB);
        textPanel.add(this.textArea);

        // buttons
        JPanel buttensP  = new JPanel();
        this.saveButton = new JButton("Save");
        buttensP.add(this.saveButton);

        // File buttons
        JPanel fileButtonsP  = new JPanel();
        this.saveToFile = new JButton("Save to file");
        this.getFromFile = new JButton("Get note from file");
        fileButtonsP.add(this.getFromFile);
        fileButtonsP.add(this.saveToFile);

        // Add panels to main panel
        mainPanel.add(datePanel);
        mainPanel.add(textPanel);
        mainPanel.add(buttensP);
        mainPanel.add(fileButtonsP);

        // Add main panel to frame
        this.add(mainPanel);

        // Activate frame.
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(WIDTH, HIEGHT);
        this.setVisible(true);
    }


    /**Initialize combobox dates.*/
    private void setDatesInCombobox() {

        LocalDate currentDate = LocalDate.now();
        Integer [] years = new Integer[NUM_YEAR];
        // Create years strings
        for(int i = currentDate.getYear();i>currentDate.getYear()-NUM_YEAR;i--) {
            int arrayIndex = currentDate.getYear()-i;
            years[arrayIndex] = i;
        }
        // Create days
        int daysInMonth = YearMonth.of(currentDate.getYear(), currentDate.getMonthValue()).lengthOfMonth();
        Integer [] days = new Integer[daysInMonth];
        for(int i = 1; i<=daysInMonth;i++)
            days[i-1] = i;

        // Save show values.
        this.day = new JComboBox(days);
        this.day.setSelectedItem((int)currentDate.getDayOfMonth());

        this.month = new JComboBox(this.months);
        this.month.setSelectedItem((int)currentDate.getMonthValue());

        this.year = new JComboBox(years);
        this.year.setSelectedItem(currentDate.getYear());
    }

    // Get text from text box.
    public String getText() {
        return this.textArea.getText();
    }

    /**Get selected date from screen.*/
    public LocalDate getSelectedDate() {
        int year = (int)this.year.getSelectedItem();
        int month = (int)this.month.getSelectedItem();
        int day = (int)this.day.getSelectedItem();
        return LocalDate.of(year,month,day);
    }

    public void setButtenListiner(ActionListener saveListiner) {
        this.saveButton.addActionListener(saveListiner);
    }

    public void setComboboxListiner(ActionListener comboboxListiner) {
        this.year.addActionListener(comboboxListiner);
        this.month.addActionListener(comboboxListiner);
        this.day.addActionListener(comboboxListiner);
    }

    /**Update days in a month according to the month and the year.
     * If the selectet day cannot appear in the selected month,
     * set to the first day in the month.*/
    public void updateDays() {
        Integer daysInMonth = YearMonth.of((int) this.month.getSelectedItem(), (int) this.month.getSelectedItem()).lengthOfMonth();
        int selDay = (int)this.day.getSelectedItem();
        this.day.removeAllItems();
        for (int i = 1; i <= daysInMonth; i++)
           this.day.addItem(i);
        this.day.setSelectedItem(selDay);
        this.repaint();
    }

    /**Set Text in the text area*/
    public void setText(String text) {
        this.textArea.setText(text);
        this.repaint();
    }

    /**Get file path from user.*/
    public String showSaveFilePath(){
        return JOptionPane.showInputDialog("Enter file path (.txt type)");
    }

    public boolean notDaysCombo(JComboBox source) {
        return source!= this.day;
    }

    /**Check if the days combobox is empty from items.*/
    public boolean daysNotEmpty() {
        return this.day.getItemCount()>0;
    }

    public void showFileError() {
        JOptionPane.showMessageDialog(this,"Error in file upload/save!");
    }

    public void setFileButtomsListiner(ActionListener fileListeners) {
        this.saveToFile.addActionListener(fileListeners);
        this.getFromFile.addActionListener(fileListeners);
    }

    public void showSuccess(String message) {
        JOptionPane.showMessageDialog(this,message);
    }

    private class TextPanel extends JPanel{
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            // Update text area height and width.
            textArea.setRows(this.getHeight()/TEXT_HIEGHT_SUB);
            textArea.setColumns(this.getWidth()/TEXT_WIDTH_SUB);


        }
    }
}
