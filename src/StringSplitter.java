import java.util.Arrays;

public class StringSplitter {
    public static void main(String[] args) {
        String word = "Hello Cfdas fdasfsad fdasfdsa ffff";

        String[] words = split(word);

        System.out.println(Arrays.toString(words));
    }

    public static String[] split(String word){
        String[] result = new String[get_spaces(word) + 1];
        char[] carr = word.toCharArray();
        String resultStr = "";
        for(int i = 0 ; i < carr.length; i ++){
            if (carr[i] != ' ' && i != carr.length-1){
                resultStr = resultStr.concat(carr[i]+"");
            } else if (i == carr.length-1 && carr[i] != ' '){
                resultStr = resultStr.concat(carr[i]+"");
                for (int j = 0; j < result.length; j ++) if (result[j] == null) {
                    result[j] = resultStr;
                    break;
                }
            }
            else {
                for (int j = 0; j < result.length; j ++) if (result[j] == null) {
                    result[j] = resultStr;
                    break;
                }
                resultStr = "";
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
