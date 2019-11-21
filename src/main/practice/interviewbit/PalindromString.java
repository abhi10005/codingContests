package main.practice.interviewbit;

public class PalindromString {

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("\"A man, a plan, a canal: Panama\""));
        System.out.println(isPalindrome("0110"));
        System.out.println(isPalindrome("race a car"));
        System.out.println(isPalindrome("Jahaj"));

    }

    public static int isPalindrome(String A) {
        A = A.toLowerCase();
        int j = A.length()-1;
        boolean isPalindrome = true;
        for(int i=0; i<j ; i++){
            if(isAlphaNumeric(A.charAt(i)) && isAlphaNumeric(A.charAt(j)) && A.charAt(i) == A.charAt(j)){
                j--;
            }else if(isAlphaNumeric(A.charAt(i)) && isAlphaNumeric(A.charAt(j)) && A.charAt(i) != A.charAt(j)){
                isPalindrome = false;
                break;
            }else if(!isAlphaNumeric(A.charAt(i))){
                continue;
            }
            else if(!isAlphaNumeric(A.charAt(j))){
                for(; j >i; j--){
                    if(isAlphaNumeric(A.charAt(j))){
                        if(A.charAt(i) != A.charAt(j))
                            isPalindrome = false;
                        j--;
                        break;
                    }
                }
            }
        }
        if(isPalindrome){
            return 1;
        }else{
            return 0;
        }
    }

    private static boolean isAlphaNumeric(char ch){
        if((int)ch >= 97 && (int)ch <= 122){
            return true;
        }
        if(ch >= '0' && ch <= '9'){
            return true;
        }
        return false;
    }
}
