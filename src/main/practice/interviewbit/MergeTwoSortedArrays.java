package main.practice.interviewbit;

import java.util.ArrayList;

public class MergeTwoSortedArrays {

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();

        a.add(1);
        a.add(5);
        a.add(8);

        b.add(-6);
        b.add(9);

        merge(a, b);
        System.out.println(a);
    }

    public static void merge(ArrayList<Integer> a, ArrayList<Integer> b) {
        int i = a.size() - 1, j = b.size() - 1;
        ArrayList<Integer> c = new ArrayList<>();
        while (i >= 0 && j >= 0) {
            if (a.get(i) > b.get(j)) {
                c.add(0, a.get(i--));
            } else {
                c.add(0, b.get(j--));
            }
        }
        while (i >= 0) {
            c.add(0, a.get(i--));
        }
        while (j >= 0) {
            c.add(0, b.get(j--));
        }
        a.clear();
        a.addAll(c);
    }
}