package com.company;

import java.util.Random;

public  class MatrixOfLife {

    private int [][] _matrix; // Matrix of life.
    private final int _range = 2; // range of the values in the matrix.

    public MatrixOfLife(int n){
        //fill matrix with random 1 or 0 - 1 represent life, 0 death.
        this._matrix = new int[n][n];
        this.randomArray(this._range);// fill the matrix in random values between 0-1.
    }
    // Gets a array and fill it with random int values between 0-range.
    private void randomArray(int range){
        Random rnd = new Random();
        for(int row = 0; row< this._matrix.length; row++)
            for(int col = 0; col<this._matrix[row].length; col++)
                this._matrix[row][col] = rnd.nextInt(range);
    }
    // Get the matrix array
    public int [][] get_matrix(){
        return this._matrix;
    }

   // Calculate the next generation array and update this.matrix
    public void NextGen(){
        int[][] new_mat = new int[this._matrix.length][this._matrix[0].length];
        int num_neighbors = 0;
        for(int row = 0; row< this._matrix.length; row++)
            for(int col = 0; col<this._matrix[row].length; col++){
                num_neighbors = this.getNeighborsLife(col,row);
                // Check birth
                if(this._matrix[row][col] == 0) {
                    if (num_neighbors == 3)
                        new_mat[row][col] = 1;
                    else new_mat[row][col] = this._matrix[row][col];
                }else { // this.matrix[row][col] == 1
                    // Check death
                    if (num_neighbors <= 1 || num_neighbors >= 4)
                        new_mat[row][col] = 0;
                    else
                        // Continue existent
                        new_mat[row][col] = this._matrix[row][col];
                }
            }
        this._matrix = new_mat;
    }

    // Get number of living neighbors in matrix , the method return the count of all living neighbors.
    private int getNeighborsLife(int x,int y){
        int num_life = 0;  // number of living neighbors counter.
        // Check left neighbors
        if(x-1>=0) {
            if (this._matrix[y][x - 1] == 1)
                num_life++;
            if(y-1>=0)
                if (this._matrix[y-1][x - 1] == 1)
                    num_life++;
            if(y+1<this._matrix.length)
                if (this._matrix[y+1][x - 1] == 1)
                    num_life++;
        }
        // Check right neighbors
        if(x+1<this._matrix[y].length) {
            if (this._matrix[y][x + 1] == 1)
                num_life++;
            if(y-1>=0)
                if (this._matrix[y-1][x + 1] == 1)
                    num_life++;
            if(y+1<this._matrix.length)
                if (this._matrix[y+1][x + 1] == 1)
                    num_life++;
        }
        // Check center neighbors
        if(y-1>=0)
            if (this._matrix[y-1][x] == 1)
                num_life++;
        if(y+1<this._matrix.length)
            if (this._matrix[y+1][x] == 1)
                num_life++;

        return num_life;
    }

}
