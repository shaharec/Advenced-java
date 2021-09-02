package com.company;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        final int frame_size =500 ; // Frame size.
        JFrame window = new JFrame("Game of life");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(frame_size, frame_size);
        // Define the panel of game of life.
        MyPanel matrix_panel = new MyPanel();
        // Add the panel to the window.
        window.add(matrix_panel);
        window.setVisible(true);
        // Ask the user if he wants to view next generation of game of life.
        while ((JOptionPane.showConfirmDialog(null,"Next generation?\n") == 0)){
            matrix_panel.nextGen();  // Update matrix.
            matrix_panel.repaint();  // Repaint.
        }
    }
}
