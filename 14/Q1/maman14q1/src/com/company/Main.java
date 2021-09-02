package com.company;

public class Main {

    public static void main(String[] args) throws Exception {
	// Ceate and fill sorted group.
        SortedGroup<Student> students = new SortedGroup<>();
        students.add(new Student("12",12));
        students.add(new Student("34",88));
        students.add(new Student("56",76));
        students.add(new Student("78",42));
        students.add(new Student("34",88));
        students.add(new Student("1112",53));

        System.out.println(students);

        // Removing object
        System.out.println("********Removing students******");
        int rem = students.remove(new Student("34",88));
        System.out.println(students);
        System.out.println("Removed students: "+ rem);

        // Add First and last
        System.out.println("********Add first and last students******");
        students.add(new Student("59",1));
        students.add(new Student("64",99));
        System.out.println(students);

        //Creat new group
        System.out.println("********New Group over 75******");
        SortedGroup<Student> newSt = GenMethods.reduce(students,new Student("1",75));
        System.out.println(newSt);
    }
}
