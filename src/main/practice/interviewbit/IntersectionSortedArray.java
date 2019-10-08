package main.practice.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;

public class IntersectionSortedArray {

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();
        a.addAll(Arrays.asList(10000000));
        b.addAll(Arrays.asList(10000000));
        System.out.println(sortedArray(a, b));
    }

    public static ArrayList<Integer> sortedArray(ArrayList<Integer> A, ArrayList<Integer> B){
        ArrayList<Integer> C = new ArrayList<>();
        int i=0, j=0, k=0;

        while(i < A.size() && j < B.size()){
            if(A.get(i).compareTo(B.get(j)) == 0){
                C.add(A.get(i));
                i++;
                j++;
            }else if(A.get(i).compareTo(B.get(j)) < 0){
                i++;
            }else{
                j++;
            }
        }
        return C;
    }
}