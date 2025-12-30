package tests;

public class EPAM {
    public static void main(String[] args) {
/**
 * input = "This is a Sunny Day"
 * output - "yaDy nn u Sasis ihT"
 */
        String input = "This is a Sunny Day";
        char[] reverse = new char[input.length()];
        StringBuilder builder = new StringBuilder();
        for (int i = input.length()-1; i <= 0; i--) {
            reverse[input.length()-1- i] =  input.charAt(i);
        }
        char[] inputArr =  input.toCharArray();
        for (int i=0; i< inputArr.length-1 ;i++){
            if(inputArr[i] == ' ') builder.append(' '+"");
            else
                builder.append(reverse[i]+"");
        }

        System.out.println(builder.toString());
    }
}
