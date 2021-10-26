import java.util.Arrays;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        String myString = "Hello Java0";
        System.out.println(reverse(myString));

    }

    public static String reverse(String str) {
        //check input
        char[] charArray = str.toCharArray();

        char[] backwards = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            backwards[i] = charArray[str.length() - 1 - i];
        }

        return Arrays.toString(backwards).toString();
    }

    //recursive approach
    public static String reverseRecursively(String str){

        if (Objects.equals(str, "")) return "";
        else{
            return reverseRecursively(str.substring(1))+str.charAt(0);
        }

    }
}
