package com.company;

import java.util.ArrayList;
import java.util.Iterator;

public class SortedGroup <T extends Comparable<T>> {

    private ArrayList<T> group;

    // Creat new sorted group.
    public SortedGroup() {
        this.group = new ArrayList<T>();
    }

    // Add item to the sorted group.
    public void add(T obj) {
        Iterator it = this.group.iterator();
        boolean addItem = false;
        int i = 0; // Index
        while (it.hasNext() && !addItem) {
            if (((T) it.next()).compareTo(obj) > 0) // Add item if the next item in the iterator is larger then obj.
                addItem = true;
            else i++;
        }
        this.group.add(i, obj); // Add object in the sorted group.

    }

    @Override
    public String toString(){
        Iterator it = this.group.iterator();
        String str = "";
        while (it.hasNext()) {
            str += it.next() +"\n";
        }
        return str;
    }

    // Remove obj from the sorted group and return number of removed items.
    public int remove(T obj) {
        Iterator it = this.group.iterator();
        int removed = 0;

        while (it.hasNext()) {
            T item = ((T) it.next());
            if (item.equals(obj)) { // Remove same items.
                it.remove();
                removed++;
            }else {
                if (removed > 0) // If one or more removed Itemes stop searching the sorteg group
                    return removed;
            }
        }
        return removed;
    }
    // Return group Iterator.
    public Iterator<T> iterator(){
        return this.group.iterator();
    }
}


