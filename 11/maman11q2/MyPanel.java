package com.company;

import javax.swing.*;
import java.awt.*;


public class MyPanel extends JPanel {

    private MatrixOfLife _matrix; // matrix of game of life
    private final int _n = 10; // matrix size is n*n

    public MyPanel(){
        // Creat new matrix of life.
        this._matrix = new MatrixOfLife(this._n);
    }

    @Override
    protected  void paintComponent(Graphics g) {
        super.paintComponent(g);
        int rec_hight = this.getHeight()/this._n;
        int rec_width = this.getWidth()/this._n;
        int [][] mat = _matrix.get_matrix();
        //Fill the panel with matrix of life values
        for(int row = 0; row< mat.length;row++)
            for(int col = 0; col<mat[row].length;col++)
                if(mat[row][col] == 1)
                    // Draw and fill rectangle.
                    g.fillRect(row*rec_width,col*rec_hight,rec_width,rec_hight);
                else
                    // Draw a empty rectangle.
                    g.drawRect(row*rec_width,col*rec_hight,rec_width,rec_hight);

    }
    // Update the matrix to next generation.
    public void nextGen() {
        this._matrix.NextGen();

    }

  
}
