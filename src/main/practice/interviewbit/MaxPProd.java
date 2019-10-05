package main.practice.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class MaxPProd {

    public static void main(String[] args) {
//        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        list.addAll(Arrays.asList(5, 9, 6, 8, 6, 4, 6, 9, 5, 4, 9));
        /*list.add(1);
        list.add(4);
        list.add(2);
        list.add(3);*/
        System.out.println(maxSpecialProduct(list));
    }

    public static int maxSpecialProduct(ArrayList<Integer> A) {
        long maxProd =0;
        Stack<Integer> leftStack = new Stack<>();
        Stack<Integer> rightStack = new Stack<>();
        for(int i=1; i< A.size()-1; i++){
            long prod = 0;
            int leftIndex = 0, rightIndex = 0;
            for(int j =i-1; j>=0 ; j--){
                if(A.get(j) > A.get(i)){
                    leftIndex = j;
                    break;
                }
            }
            for(int j =i+1; j< A.size() ; j++){
                if(A.get(j) > A.get(i)){
                    rightIndex = j;
                    break;
                }
            }

            prod = leftIndex * rightIndex;

            if(maxProd < prod){
                maxProd = prod;
            }
        }

        return (int) (maxProd % 1000000007);
    }
}