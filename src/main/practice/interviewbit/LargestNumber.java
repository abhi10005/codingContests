package main.practice.interviewbit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LargestNumber {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(30);
        list.add(34);
        list.add(5);
        list.add(9);
        LargestNumber obj =new LargestNumber();
        System.out.println(obj.largestNumber(list));
    }

    public String largestNumber(final List<Integer> A){

        List<String> stringList = new ArrayList<>();
        long sum = 0;
        for(Integer a : A){
            sum+=a;
            stringList.add(a.toString());
        }
        if(sum ==0){
            return "0";
        }
        Collections.sort(stringList, (o1, o2) -> (o2 + o1).compareTo((o1 + o2)));

        StringBuilder stringBuilder = new StringBuilder();
        for(String str : stringList){
            stringBuilder.append(str);
        }
        return stringBuilder.toString();
    }
}