package org.example.java;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IterablePractice {

    public static void main (String[] args) {
        List<Integer> values = new ArrayList<>();
        values.add(1);
        values.add(2);
        values.add(3);
        values.add(4);

        //Using Iterator
        Iterator<Integer> valueIterator = values.iterator();
        while(valueIterator.hasNext()){
            int val = valueIterator.next();
            System.out.println(val);
            if (val==3) {
                valueIterator.remove();
            }
        }

        //forEach
        for(int val: values){
            System.out.println(val);
        }

        //forEach Method
        values.forEach((Integer val) -> System.out.println(val));
    }
}
