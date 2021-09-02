package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.time.LocalDate;

public class Controller {

    private IModel model;
    private IView view;

    public Controller(IModel model, IView view) {
        this.model = model;
        this.view = view;
        this.view.setButtenListiner(new SaveListiner());
        this.view.setComboboxListiner(new ComboboxListiner());
        this.view.setFileButtomsListiner(new FileListeners());
    }

    /** Listener for the save butten.*/
    private class SaveListiner implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String text = view.getText();
            LocalDate date = view.getSelectedDate();
            model.updateNote(text,date);
        }
    }

    /** Listener for the save butten.*/
    private class FileListeners implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton b = (JButton) e.getSource();
            try { // Try upload/save file.
                model.updateFile(b.getText(),view.showSaveFilePath());
                view.showSuccess("Saved/uploaded successfully.");
                String date = view.getSelectedDate().toString();
                String text = model.getText(date);
                view.setText(text);
                view.repaint();
            }catch (FileNotFoundException fileNotFoundException){
                view.showFileError(); // Show error message if an error occurred.
            }

        }
    }

    /** Listener for the combobox of the month.*/
    private class ComboboxListiner implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(view.notDaysCombo((JComboBox)e.getSource())) // Update days if a month or year was selected.
                view.updateDays();
            if(view.daysNotEmpty()) { // If days combobox is not empty.
                String date = view.getSelectedDate().toString();
                String text = model.getText(date);
                view.setText(text);
                view.repaint();
            }
        }
    }
}
