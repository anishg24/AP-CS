import java.util.Arrays;
import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//        String string;
//        String string3 = "";
//
//        System.out.print("Enter your word: ");
//        string = input.next();
//        while(!checkPalindrome(string)){
//            System.out.println("That is not a palindrome word. Try again.");
//            string = input.next();
//        }
//        System.out.println("That is a palindrome word.");
//
//        for(int i = 0; i < 3; i++){
//            string3 = string3.concat(string);
//        }
//        System.out.println("Your new word, " + string3 + ", is also a palindrome.");

        System.out.println(Arrays.toString(checkPalindrome("madam madam madam", 5)));

    }

    public static String reverse(String string){
        char[] c_arr = string.toCharArray();
        char[] rev_arr = new char[c_arr.length];
        for (int i = rev_arr.length-1; i >= 0 ; i--){
            rev_arr[(c_arr.length-1) - i] = c_arr[i];
        }
        return new String(rev_arr);
    }

    public static boolean checkPalindrome(String string){
        return string.equals(reverse(string));
    }

    public static String[] checkPalindrome(String string, int limit){
        String[] segmentedArr = new String[string.length()];
        int numberOfPalindromes = 0;
        String stringSegment = "";
        for(int i = 0; i < segmentedArr.length; i++){
            try {
                stringSegment = string.substring(i, i + limit);
            } catch(StringIndexOutOfBoundsException s){
                break;
            }
            if (checkPalindrome(stringSegment)) {
                segmentedArr[i] = stringSegment;
                numberOfPalindromes ++;
            }
        }

        String[] resultArr = new String[numberOfPalindromes];
        for (int j = 0; j < segmentedArr.length; j++){
            if(segmentedArr[j] != null){
                for(int i = 0; i < resultArr.length; i++) {
                    if (resultArr[i] == null) {
                        resultArr[i] = segmentedArr[j];
                        break;
                    }
                }
            }
        }

        return resultArr;
    }
    
}
