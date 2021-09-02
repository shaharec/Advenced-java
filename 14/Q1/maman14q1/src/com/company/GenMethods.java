package com.company;

import java.util.Iterator;

public abstract class GenMethods {

    /**Get new sorted group with objects with value bigger then obj.*/
    public static  <T extends Comparable<T>> SortedGroup<T> reduce(SortedGroup<T> sGroup , T obj){
        SortedGroup<T> newSortedG = new SortedGroup<T>();
        Iterator it = sGroup.iterator();
        boolean add = false;
        while(it.hasNext()){
            T item = (T)it.next();
            if(item.compareTo(obj)>0)
                newSortedG.add(item);
        }
        return newSortedG;
    }
}
