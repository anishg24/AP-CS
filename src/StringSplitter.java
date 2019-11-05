import java.util.Arrays;

public class StringSplitter {
    public static void main(String[] args) {
        String word = "Hello Cfdas fdasfsad fdasfdsa ffff";

        String[] words = split(word);

        System.out.println(Arrays.toString(words));
    }

    public static String[] split(String word){
        String[] result = new String[get_spaces(word) + 1];
        char[] str_a = word.toCharArray();
        String concat_this = "";
        for(int i = 0 ; i < str_a.length; i ++){
            if (str_a[i] != ' ' && i != str_a.length-1){
                concat_this = concat_this.concat(str_a[i]+"");
            } else if (i == str_a.length-1 && str_a[i] != ' '){
                concat_this = concat_this.concat(str_a[i]+"");
                for (int j = 0; j < result.length; j ++) if (result[j] == null) {
                    result[j] = concat_this;
                    break;
                }
            }
            else {
                for (int j = 0; j < result.length; j ++) if (result[j] == null) {
                    result[j] = concat_this;
                    break;
                }
                concat_this = "";
            }
        }
        return result;
    }

    private static int get_spaces(String string){
        int result = 0;
        for (char i : string.toCharArray()){
            if (i == ' ') result ++;
        }
        return result;
    }
}
