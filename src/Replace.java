import java.lang.reflect.Array;
import java.util.Arrays;

public class Replace {
    public static void main(String[] args) {
        int[] array = generate_array(20);

        System.out.println("Normal Array:");
        print_array(array);
//        Arrays.stream(array).forEach(System.out::print);
//        System.out.println(Arrays.toString(array));

        System.out.println("\nReplaced Array:");
        print_array(replace(replace(replace(array,2),3),5));

    }
    static int[] replace(int[] array, int factor){
        int num;

        for(int i = 0; i<array.length; i++){
            num = array[i];
            if (num == 1 || num == 0){
                continue;
            }
            else if (num % factor == 0){
                array[i] = 0;
            }
        }
        return array;
    }
    static void print_array(int[] array){
        for(int i : array){
            System.out.print(i + " ");
        }
    }
    static int[] generate_array(int size){
        int[] array = new int[size];
        for(int i = 0; i< array.length; i++){
            array[i] = (int)(100*Math.random() + 1);
        }
        return array;
    }
}
