package org.example.java;

import java.util.*;

class Pair {
    int count;
    char c;
    Pair(int _count, char _c){
        count = _count;
        c = _c;
    }
}
public class MapPractice {
    public static void main (String[] args) {
        char[] tasks = {'A', 'A', 'B', 'A', 'B'};
        Map<Character, Integer> umap = new HashMap<>();

        for(int i=0;i<5;++i){
            if(umap.containsKey(tasks[i])){
                umap.put(tasks[i],umap.get(tasks[i])+1);
            }
            else{
                umap.put(tasks[i],1);
            }
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((Pair p1, Pair p2) -> p2.count - p1.count);

        for(Map.Entry<Character,Integer> e: umap.entrySet()){
            pq.add(new Pair(e.getValue(),e.getKey()));
        }

        while(!pq.isEmpty()){
            System.out.println(pq.poll().count);
        }
    }

}
