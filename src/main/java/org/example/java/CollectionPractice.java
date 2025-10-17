package org.example.java;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CollectionPractice {

    public static void main (String[] args) {
        List<Integer> values = new ArrayList<>();
        values.add(1);
        values.add(2);
        values.add(3);
        values.add(4);
        //size
        System.out.println(values.size());
        //contains
        System.out.println(values.contains(4));
        //remove using index
        System.out.println(values.remove(3));
        //remove using object value
        System.out.println(values.remove(Integer.valueOf(3)));
        //addAll
        Stack<Integer> st = new Stack<>();
        st.add(5);
        st.add(6);
        st.add(7);
        values.addAll(st);
        System.out.println(values.contains(7));
        //containsAll
        System.out.println(values.containsAll(st));
        //removeAll
        System.out.println(values.removeAll(st));
        //clear
        values.clear();
        System.out.println(values.isEmpty());
    }

}
