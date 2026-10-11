/**
 * Lettcode_2696
 */
public class Lettcode_2696 {

    public static int minLength(String s) {
        StringBuilder sb = new StringBuilder();

        for (char ch : s.toCharArray()) {
            int len = sb.length();
            if (len > 0) {
                char top = sb.charAt(len - 1);
                if ((top == 'A' && ch == 'B') || (top == 'C' && ch == 'D')) {
                    sb.deleteCharAt(len - 1);
                    continue;
                }
            }
            sb.append(ch);
        }

        return sb.length();
    }

    public static void main(String[] args) {

        String str = "ABFCACDB";

        System.out.println(minLength(str));
    }
}