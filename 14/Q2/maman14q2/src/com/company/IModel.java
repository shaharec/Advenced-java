package com.company;

import java.io.FileNotFoundException;
import java.time.LocalDate;

public interface IModel {
    /**Update note to hashmap.*/
    void updateNote(String text, LocalDate date);
    /**Get text from hash table.*/
    String getText(String date);
    /**Update File from hash table.*/
    void updateFile(String text, String filePath) throws FileNotFoundException;
}
