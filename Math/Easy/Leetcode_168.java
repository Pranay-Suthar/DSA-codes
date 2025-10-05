package Math.Easy;

public class Leetcode_168 {
//168. Excel Sheet Column Title
//Given an integer columnNumber, return its corresponding column title as it appears in an Excel sheet.
//
//    For example:
//    A -> 1
//    B -> 2
//    C -> 3
//    Z -> 26
//    AA -> 27
//    AB -> 28
//    Example 1:
//
//    Input: columnNumber = 1
//    Output: "A"
//    Example 2:
//
//    Input: columnNumber = 28
//    Output: "AB"
//    Example 3:
//
//    Input: columnNumber = 701
//    Output: "ZY"
    public static void main(String[] args) {
        System.out.println(convertToTitle(701));
    }

    public static String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        String result = "";
        while(columnNumber > 0){
            columnNumber--;
            int rem = columnNumber % 26;
            sb.append((char) (rem + 'A'));
            columnNumber /= 26;
        }
        sb.reverse();
        return sb.toString();
    }
}
