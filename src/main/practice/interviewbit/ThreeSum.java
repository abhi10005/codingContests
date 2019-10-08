package main.practice.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ThreeSum {

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
//        a.addAll(Arrays.asList(-1, 2, 1, -4));
        a.addAll(Arrays.asList(10, -6, 3, 4, -8, -5));
        System.out.println(threeSumClosest2(a, 3));
    }

    public static int threeSumClosest2(ArrayList<Integer> A, int B) {
        int i=0, j=A.size()-1, sum = A.get(j) + A.get(j) + A.get(j);
        int diff = Integer.MAX_VALUE;
        Collections.sort(A);
        while(i < j-1){
            for(int k = i+1; k<j; k++){
                int temp = A.get(i) + A.get(j) + A.get(k);
                if(Math.abs(B - temp) < diff){
                    sum = temp;
                    diff = Math.abs(B - temp);
                }
                if(sum > B){
                    j --;
                }
            }
            if(sum > B){
                j --;
            }
            else{
                i++;
            }
        }
        return sum;
    }
    public static int threeSumClosest(ArrayList<Integer> A, int B) {
        int i=0, j= A.size()-1, diff, sum = Integer.MIN_VALUE;
        Collections.sort(A);
        while(i < j){
            int low = i, high = j;
            int mid = low + (high-low)/2;

            diff = Math.abs(A.get(i) + A.get(j) - B);

            while(low < high){

                if(A.get(mid) == diff){
                    return B;
                }else if(A.get(mid) > diff){
                    high = mid-1;
                }else{
                    low = mid + 1;
                }
                mid = low + (high-low)/2;
            }

            int tempSum = A.get(i) + A.get(j) + A.get(mid);
            if(Math.abs(B-tempSum) < Math.abs(B-sum)){
                sum = tempSum;
            }
            if(tempSum > B){
                j--;
            }else{
                i++;
            }
        }

        return sum;
    }
}