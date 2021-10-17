import java.util.Arrays;

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
}
