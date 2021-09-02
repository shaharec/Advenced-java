package com.company;

public class Student implements Comparable<Student>{

    private String id;
    private double score;

    public Student(String id,double score) throws Exception {
        this.id = id;
        if(score<=100 && score>=0) // Only take score between 0-100.
            this.score = score;
        else {
            throw new Exception("Score must be between 0-100");
        }
    }

    @Override
    public int compareTo(Student st) {
         return (int)(this.score-st.getScore());
    }

    public boolean equals(Object o){
        Student st = (Student) o;
        return this.id.equals(st.getId()) && this.score == st.getScore();
    }

    private String getId() {
        return this.id;
    }

    private double getScore() {
        return this.score;
    }

    @Override
    public String toString(){
        return "Id: "+ this.id +
                "\nScore: "+this.score;
    }

}
