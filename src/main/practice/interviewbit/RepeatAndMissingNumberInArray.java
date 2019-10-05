package main.practice.interviewbit;

import java.util.ArrayList;
import java.util.List;

public class RepeatAndMissingNumberInArray {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(1);
        list.add(2);
        list.add(5);
        list.add(3);
        System.out.println(repeatedNumber(list));

    }

    public static ArrayList<Integer> repeatedNumber(final List<Integer> A) {
        int[] resultArray = new int[A.size()];
        for(int i=1; i< A.size(); i++){
            resultArray[i] = 0;
        }

        ArrayList<Integer> result = new ArrayList<>();
        for(int i=0; i< A.size(); i++){
            if(resultArray[A.get(i)-1] == 0){
                resultArray[A.get(i)-1] = 1;
            }else{
                result.add(A.get(i));
            }
        }
        for(int i=0; i<A.size(); i++){
            if(resultArray[i] == 0){
                result.add(i+1);
                break;
            }
        }

        return result;
    }
}