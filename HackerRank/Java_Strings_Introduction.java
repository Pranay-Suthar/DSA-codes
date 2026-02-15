package HackerRank;

import java.util.Scanner;

public class Java_Strings_Introduction {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        String A=sc.next();
        String B=sc.next();
        /* Enter your code here. Print output to STDOUT. */

        System.out.println(A.length() + B.length());

        if (A.compareTo(B) <= 0){
            System.out.println("No");
        } else {

            System.out.println("Yes");
        }
        sb.append(A.toUpperCase().charAt(0));
        sb.append(A.substring(1));
        sb.append(" ");
        sb.append(B.toUpperCase().charAt(0));
        sb.append(B.substring(1));

        System.out.println(sb);
    }
}
