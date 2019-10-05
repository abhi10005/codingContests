package main.practice.interviewbit;

import java.util.ArrayList;
import java.util.Collections;

public class WaveArray {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        /*list.add(6);*/
        System.out.println(wave(list));
    }

    public static ArrayList<Integer> wave(ArrayList<Integer> A) {
        Collections.sort(A);
        for(int i=0; i<A.size(); i+=2){
            // swap a(i) with a(i+1);
            if(i != A.size()-1){
                int temp = A.get(i);
                A.set(i, A.get(i+1));
                A.set(i+1, temp);
            }

        }
        return A;
    }
}