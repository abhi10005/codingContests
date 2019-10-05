package main.practice.interviewbit;

import java.util.ArrayList;
import java.util.Collections;

public class FirstMissingInteger {

    public static void main(String[] args) {

    }

    public int firstMissingPositive(ArrayList<Integer> A) {
        Collections.sort(A);
        int positiveSearch = 1;
        for(Integer val: A){
            if(positiveSearch == val){
                positiveSearch++;
            }
        }
        return positiveSearch;
    }
}