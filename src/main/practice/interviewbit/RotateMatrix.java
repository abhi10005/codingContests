package main.practice.interviewbit;

import java.util.ArrayList;

public class RotateMatrix {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> a = new ArrayList<>();
        ArrayList n1 = new ArrayList();
        n1.add(1);
        n1.add(2);
//        n1.add(3);
        ArrayList n2 = new ArrayList();
        n2.add(4);
        n2.add(5);
//        n2.add(6);
        ArrayList n3 = new ArrayList();
        n3.add(7);
        n3.add(8);
//        n3.add(9);

        a.add(n1);
        a.add(n2);
//        a.add(n3);
        System.out.println("before" +a);
        rotate(a);
        System.out.println("After" + a);
    }

    public static void rotate(ArrayList<ArrayList<Integer>> a) {
        int n = a.size();
        for(int i=0; i< n/2; i++){
            for(int k = i; k < n-i-1; k++){
                int temp1 = a.get(k).get(n-i-1);
                int temp2 = a.get(n - i - 1).get(n - k - 1);
                int temp3 = a.get(n-k-1).get(i);

                a.get(k).set(n-i-1, a.get(i).get(k));
                a.get(n - i - 1).set(n-k-1, temp1);
                a.get(n-k-1).set(i, temp2);
                a.get(i).set(k, temp3);
            }
        }
    }
}