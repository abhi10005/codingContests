package main.practice.interviewbit;

import java.util.*;

public class ThreeSumZero {

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
//        a.addAll(Arrays.asList(-1, 2, 1, -4));
//        a.addAll(Arrays.asList(10, -6, 3, 4, -8, -5));
        a.addAll(Arrays.asList(-1, 0, 1, 2, -1, 4));
        System.out.println(threeSumClosest2(a));
    }

    public static ArrayList<ArrayList<Integer>>  threeSumClosest2(ArrayList<Integer> A) {
        int i=0, j, sum;
        Collections.sort(A);
        Set<Integer> hashSet = new HashSet<>();
        ArrayList<ArrayList<Integer>> solution = new ArrayList<>();
        for(; i< A.size(); i++){
            j = A.size() - 1;
            int k = i+1;
            while(k < j){
                sum = A.get(i) + A.get(j) + A.get(k);
                if(sum == 0){
                    ArrayList<Integer> ans = new ArrayList<>();
                    ans.add(A.get(i));
                    ans.add(A.get(k));
                    ans.add(A.get(j));
                    if(hashSet.add(getHashCode(ans))){
                        solution.add(ans);
                    }
                    k = i+1;
                    j--;
                }else if(sum > 0){
                    j--;
                }else{
                    k++;
                }
            }
        }
        return solution;

    }

    public static ArrayList<ArrayList<Integer>>  threeSumClosest(ArrayList<Integer> A) {
        int i=0, j= A.size()-1, sum;
        Collections.sort(A);
        Set<Integer> hashSet = new HashSet<>();
        ArrayList<ArrayList<Integer>> solution = new ArrayList<>();
        while(i< j){

            for(int k= i+1; k< j-1; k++){
                int low = k, high = j;
                int mid = low + (high-low)/2;
                boolean found = false;
                sum = A.get(i) + A.get(j);
                int search = 0-sum;

                while(low < high){
                    if(A.get(mid)  == search){
                        ArrayList<Integer> ans = new ArrayList<>();
                        ans.add(A.get(i));
                        ans.add(A.get(mid));
                        ans.add(A.get(j));
                        if(hashSet.add(getHashCode(ans))){
                            solution.add(ans);
                        }
                        found = true;
                        break;
                    }else if(A.get(mid) > search){
                        high = mid-1;
                    }else{
                        low = mid + 1;
                    }
                    mid = low + (high-low)/2;
                }

            }

        }
        return solution;

    }

    private static int getHashCode(List<Integer> numbers){
        String hash = "";
        for(Integer number : numbers){
            hash = hash + number;
        }
        return hash.hashCode();
    }

}