package main.practice.interviewbit;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrderMatrix {
    // DO NOT MODIFY THE LIST
    public static ArrayList<Integer> spiralOrder(final List<ArrayList<Integer>> A) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        // Populate result;

        int cols = A.get(0).size();
        int rows = A.size();
        int t = 0, b = rows - 1, l = 0, r = cols - 1;
        while (t <= b && l <= r) {
            for (int j = l; j <= r; j++) {         // right
                result.add(A.get(t).get(j));
            }
            t++;
            for (int i = t; i <= b; i++) {
                result.add(A.get(i).get(r));
            }
            r--;
            for (int j = r; j >= l && t <= b; j--) {
                result.add(A.get(b).get(j));
            }
            b--;
            for (int i = b; i >= t && l<=r ; i--) {
                result.add(A.get(i).get(l));
            }
            l++;
        }
        return result;
    }

    public static void main(String args[]){
        List<ArrayList<Integer>> list = new ArrayList<>();
        ArrayList<Integer> subList = new ArrayList<>();
        subList.add(1);
        subList.add(2);
        subList.add(3);

        list.add(subList);


        System.out.println(list);
        System.out.println(spiralOrder(list));
    }
}
