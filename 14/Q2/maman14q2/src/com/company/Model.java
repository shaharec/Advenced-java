package com.company;

import java.io.*;
import java.time.LocalDate;

import java.util.*;

public class Model implements IModel {

    private HashMap<String,String> notes;
    private String file_path;

    public Model() {
        this.notes = new HashMap<String,String>();
    }

    /**Update note to hashmap.*/
    public void updateNote(String text, LocalDate date) {
        if(! this.notes.containsKey(date)) {
            this.notes.put(date.toString(), text);
        }else {
            this.notes.replace(date.toString(), text);
        }
    }

   /**Get text from hash table.*/
    public String getText(String date) {
        if(! this.notes.containsKey(date))
            return "";
        return this.notes.get(date);
    }

    /**Update File from hash table.*/
    public void updateFile(String action,String path) throws FileNotFoundException {
        this.file_path = path;
        if(action.equals("Save to file")) {
            try {
                this.saveToFile(); // Save hash table to file.
            } catch (IOException e) {
                throw new FileNotFoundException();
            }
        }
        else this.uploadFromFile(); // Upload file to hash table.
    }
    /**
     * Upload hash table from file.
     * File format:
     * 1. date value
     * 2. text
     * 3.-----------------.*/
    private void uploadFromFile() throws FileNotFoundException {
        Scanner sc = new Scanner(new File(file_path));
        this.notes.clear();
        while (sc.hasNext()) {
            String line = sc.nextLine();
            String date = line;
            line = sc.nextLine();;
            String text = "";
            while(sc.hasNext() && !line.equals("-----------------")){// Read text.
                text += line+"\n";
                line = sc.nextLine();
            }
            this.notes.put(date,text);
        }
        sc.close();
    }

    /**
     * Save hash table to File */
    private void saveToFile() throws IOException {
        Formatter output = new Formatter(file_path);
        // getting keySet() into Set
        Set<String> keys = this.notes.keySet();
        String str = "";
        // Collection Iterator
        Iterator<String> it = keys.iterator();

        while (it.hasNext()) {
            String key = it.next();
            str += key + "\n";
            str +=this.notes.get(key) + "\n";
            str += "-----------------\n";
        }
       output.format(str);
       output.close();
   }
}

