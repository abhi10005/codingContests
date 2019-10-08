package main.practice.interviewbit;

import java.util.ArrayList;

public class MatrixSearch {

    public static void main(String[] args) {
        MatrixSearch obj = new MatrixSearch();

        ArrayList<ArrayList<Integer>> a = new ArrayList<>();
        ArrayList<Integer> subList1 = new ArrayList<>();
        subList1.add(1);
        subList1.add(3);
        subList1.add(4);
        subList1.add(7);
        a.add(subList1);

        ArrayList<Integer> subList2 = new ArrayList<>();
        subList2.add(10);
        subList2.add(11);
        subList2.add(16);
        subList2.add(20);
        a.add(subList2);

        ArrayList<Integer> subList3 = new ArrayList<>();
        subList3.add(23);
        subList3.add(30);
        subList3.add(34);
        subList3.add(50);
        a.add(subList3);

        System.out.println(obj.searchMatrix(a, 3));
        System.out.println(obj.searchMatrix(a, 20));
        System.out.println(obj.searchMatrix(a, 36));
        System.out.println(obj.searchMatrix(a, 50));
    }

    public int searchMatrix(ArrayList<ArrayList<Integer>> a, int b) {
        int m = a.size();

        for(int row = 0; row < m; row++){
            ArrayList<Integer> rowList = a.get(row);
            int low = 0;
            int high = rowList.size()-1;
            int mid = low + (high-low)/2;


            if(b > rowList.get(high) || b < rowList.get(low)){
                continue;
            }

            while(low <= high) {
                if(rowList.get(mid) == b){
                    return 1;
                }

                if(rowList.get(mid) > b){
                    high = mid-1;
                }else{
                    low = mid+1;
                }
                mid = low + (high-low)/2;
            }
        }

        return 0;
    }
}