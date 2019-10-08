package main.practice.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;

public class RemoveDuplicates {

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
//        a.addAll(Arrays.asList(1,1,2, 2, 3, 4, 5, 5));
        a.addAll(Arrays.asList(5000, 5000, 5000));
        System.out.println(removeDuplicates2(a));
    }

    public static int removeDuplicates2(ArrayList<Integer> a){
        int i=0,j=1;

        while(j < a.size()){
            if(a.get(i).compareTo(a.get(j)) == 0){
                j++;
            }else {
                i++;
                a.set(i, a.get(j));
                j++;
            }
        }

        return i+1;
    }
}