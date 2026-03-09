package HackerRank;

//Output Format
//
//After each operation,
//print the respective number of set bits in BitSet  and BitSet  as  space-separated integers on a new line.
//
//    Sample Input
//
//        5 4
//        AND 1 2
//        SET 1 4
//        FLIP 2 2
//        OR 2 1
//
//    Sample Output
//
//        0 0
//        1 0
//        1 1
//        1 2

import java.util.BitSet;
import java.util.Scanner;

public class Java_BitSet {

    public static Scanner sc  = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println();
        int n = sc.nextInt();
        int m = sc.nextInt();

        BitSet b1 = new BitSet(n);
        BitSet b2 = new BitSet(n);

        for (int i = 0; i < m; i++) {
            String operation = sc.next();
            int a = sc.nextInt();
            int b = sc.nextInt();

            if (operation.equals("AND")){
                if (a == 1){
                    b1.and(b2);
                } else{
                    b2.and(b1);
                }
                
            } else if (operation.equals("SET")) {
                if (a == 1){
                    b1.set(b);
                } else{
                    b2.set(b);
                }
            } else if (operation.equals("FLIP")) {
                if (a == 1){
                    b1.flip(b);
                } else{
                    b2.flip(b);
                }
            } else if (operation.equals("XOR")) {
                if (a == 1){
                    b1.xor(b2);
                } else{
                    b2.xor(b1);
                }
            } else if (operation.equals("OR")){
                if (a == 1){
                    b1.or(b2);
                } else{
                    b2.or(b1);
                }
            }
            System.out.println(b1.cardinality() + " " + b2.cardinality());
        }

    }
}
