package HackerRank;

import java.util.Scanner;


//Sample Input
//
    //He is a very very good boy, isn't he?
//Sample Output
//
    //10
    //He
    //is
    //a
    //very
    //very
    //good
    //boy
    //isn
    //t
    //he
public class Java_String_Tokens {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        // Write your code here.

        if (s.trim().isEmpty()){
            System.out.println("0");
            return;
        }

        String[] arr = s.trim().split("[^A-Za-z]+");
        System.out.println(arr.length);

        for (String s1 : arr){
            System.out.println(s1);
        }

        scan.close();
    }
}
