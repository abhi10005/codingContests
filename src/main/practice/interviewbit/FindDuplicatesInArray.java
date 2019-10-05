package main.practice.interviewbit;

import java.util.ArrayList;
import java.util.List;

public class FindDuplicatesInArray {
    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>();
        a.add(3);
        a.add(4);
        a.add(1);
        a.add(4);
        a.add(1);
        System.out.println(findDuplicates(a));
    }

    public static int findDuplicates(final List<Integer> a){
        int size = a.size();
        int[] dupArray = new int[size];

        for(int i=0; i< size;i++){
            dupArray[i] = Integer.MIN_VALUE;
        }

        for(int i=0 ;i<size; i++){
            if(dupArray[a.get(i)] == Integer.MIN_VALUE){
                dupArray[a.get(i)] = a.get(i);
            }else{
                return a.get(i);
            }
        }
        return -1;
    }
}