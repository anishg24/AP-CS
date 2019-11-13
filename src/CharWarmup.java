import java.util.Arrays;

public class CharWarmup {
    public static void main(String[] args) {
        char[] c_arr = {'a', 'p', 'p', 'l', 'e'};

        int count = 0;
        for (char c : c_arr){
            if (c == 'p') count++;
        }
        System.out.println("count = " + count);

        char[] rev_arr = new char[c_arr.length];
        for (int i = rev_arr.length-1; i >= 0 ; i--){
            rev_arr[(c_arr.length-1) - i] = c_arr[i];
        }
        System.out.println(rev_arr);

        char[] CAP_arr = new char[c_arr.length];
        for(int i = 0; i < CAP_arr.length; i++){
            CAP_arr[i] = (char)(c_arr[i] - 32);
        }
        System.out.println(CAP_arr);

        /*  SOLUTIONS
            1. 202
            2. r
            3. The letter is: 97
            4. 196 is the letter
         */
    }
}
