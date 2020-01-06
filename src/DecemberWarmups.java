import java.util.ArrayList;
import java.util.Arrays;

public class DecemberWarmups {
    public static void main(String[] args) {
        // 12/4
        ArrayList<Character> alphabet = new ArrayList<Character>();
        for (char c = 'A'; c <= 'Z'; c++){
            alphabet.add(c);
        }
        System.out.println(alphabet);

        double[] a = {1,2,3,4,5};
        System.out.println(Arrays.toString(add(a, 5, 6)));
    }

    public static double[] add(double[] arr, int index, double number){
        double[] result = new double[arr.length+1];
        if (index == result.length){
            System.arraycopy(arr, 0 , result, arr.length, arr.length);
            result[result.length-1] = number;
        }

        if (index >= 0) System.arraycopy(arr, 0, result, 0, index);

        result[index] = number;

        if (arr.length - index >= 0) System.arraycopy(arr, index, result, index + 1, arr.length - index);

        return result;
    }
}
