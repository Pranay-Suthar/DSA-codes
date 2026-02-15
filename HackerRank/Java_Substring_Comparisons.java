package HackerRank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Java_Substring_Comparisons {

    public static String getSmallestAndLargest(String s, int k) {


        //String smallest = s.substring(0, k);
        //String largest  = s.substring(0, k);
        //
        //    for (int i = 1; i <= s.length() - k; i++) {
        //
        //String sub = s.substring(i, i + k);
        //
        //        if (sub.compareTo(smallest) < 0) {
        //smallest = sub;
        //        }
        //
        //                if (sub.compareTo(largest) > 0) {
        //largest = sub;
        //        }
        //                }

        String smallest = "";
        String largest = "";

        // Complete the function
        // 'smallest' must be the lexicographically smallest substring of length 'k'
        // 'largest' must be the lexicographically largest substring of length 'k'

        ArrayList<String> list1 = new ArrayList<>();

        for(int i = 0; i <= s.length() - k; i++){
            String sub = s.substring(i , i + k);
                list1.add(sub);
        }

//        System.out.println(list1);

        Collections.sort(list1);

        smallest = list1.getFirst();
        largest = list1.getLast();

        return smallest + "\n" + largest;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int n = sc.nextInt();
        System.out.println(getSmallestAndLargest(s, n));
    }
}
//
