package com.company;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public interface IView {

    void setButtenListiner(ActionListener saveListiner);

    void setComboboxListiner(ActionListener comboboxListiner);

    void setFileButtomsListiner(ActionListener fileListeners);

    /**Get String from text box.*/
    String getText();

    /**Get selected date from screen.*/
    LocalDate getSelectedDate();

    void showSuccess(String s);

    /**Set Text in the text area*/
    void setText(String text);

    /**Get file path from user.*/
    String showSaveFilePath();

    void repaint();

    void showFileError();

    boolean notDaysCombo(JComboBox source);

    /**Check if the days combobox is empty from items.*/
    boolean daysNotEmpty();

    /**Update days in a month according to the month and the year.
     * If the selectet day cannot appear in the selected month,
     * set to the first day in the month.*/
    void updateDays();
}
