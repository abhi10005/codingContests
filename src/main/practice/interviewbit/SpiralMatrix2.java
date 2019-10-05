package main.practice.interviewbit;

import java.util.ArrayList;

public class SpiralMatrix2 {

    public static void main(String[] args) {

        System.out.println(generateMatrix(1));
        System.out.println(generateMatrix(2));
        System.out.println(generateMatrix(3));
        System.out.println(generateMatrix(4));
        System.out.println(generateMatrix(5));
    }

    public static ArrayList<ArrayList<Integer>> generateMatrix(int A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for(int i=0; i<A; i++){
            ArrayList<Integer> subList = new ArrayList<>();
            for(int j=0 ;j <A; j++){
                subList.add(0);
            }
            result.add(subList);
        }

        if(A == 1){
            ArrayList<Integer> subList = result.get(0);
            subList.set(0, 1);
        }

        int count =1;
        for(int i =0; i<=A/2; i++){

            for (int j=i; j<A-i; j++){
                result.get(i).set(j, count++);
            }
            for(int j=i+1; j< A-i; j++){
                result.get(j).set(A - i - 1, count++);
            }
            for (int j = A-i-2; j>=i ; j--){
                result.get(A-i-1).set(j, count++);
            }
            for (int j = A-i-2; j > i; j--){
                result.get(j).set(i, count++);
            }
        }

        return result;
    }
}