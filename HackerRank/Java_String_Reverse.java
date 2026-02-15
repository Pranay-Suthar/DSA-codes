package HackerRank;

import java.util.Scanner;

public class Java_String_Reverse {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String A = sc.next();

        int j = 0;
        int k = A.length() - 1;

        while(j < k){
            if (A.charAt(j) != A.charAt(k)){
                System.out.println("No");
                return;
            }
            j++;
            k--;
        }
            System.out.println("Yes");

    }
}
