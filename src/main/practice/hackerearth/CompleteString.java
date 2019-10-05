package main.practice.hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class CompleteString {

    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        while(N-- > 0){
            String input = br.readLine();
            System.out.println(isCompleteString(input));
        }
    }

    private static String isCompleteString(String input){
        Set characterSet = new HashSet<>();
        char[] chars = input.toCharArray();
        for(int i=0; i<chars.length & characterSet.size()<26; i++){
            characterSet.add(chars[i]);
        }

        return characterSet.size() == 26 ? "YES" : "NO";
    }
}