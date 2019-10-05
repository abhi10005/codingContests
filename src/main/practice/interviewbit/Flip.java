package main.practice.interviewbit;

import java.util.ArrayList;

public class Flip {

    public static void main(String[] args) {
        flip("0");
        flip("1");
        flip("01");
        flip("00");
        flip("10");
        flip("11");
        flip("010");
        flip("111");
    }

    public static ArrayList<Integer> flip(String A) {
        int[] a = new int[A.length()];
        int[] b = new int[A.length()];
        int[] c = new int[A.length()];

        for(int i=0; i< A.length(); i++){
            a[i] = Character.getNumericValue(A.charAt(i));
            b[i] = 1;
            c[i] = a[i] ^ b[i];
        }

        int max = 0, start = 0, end = 0;
        for(int i=0; i< A.length(); i++){
            if(c[i] == 1){
                int count = 1;
                int j = i+1;
                for(;j<A.length(); j++){
                    if(c[j] == 1){
                        count++;
                    }else{
                        break;
                    }
                }
                if(count > max){
                    max = count;
                    start = i;
                    end = j-1;
                }
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        if(max != 0){
            result.add(start);
            result.add(end);
        }
        System.out.println(result);
        return result;
    }
}