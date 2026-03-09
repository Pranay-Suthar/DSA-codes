package HackerRank;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

//Sample Input
//
//5
//john tom
//john mary
//john tom
//mary anna
//mary anna
//
//Sample Output
//
//        1
//        2
//        2
//        3
//        3

public class Java_Hashset {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        String [] pair_left = new String[t];
        String [] pair_right = new String[t];

        for (int i = 0; i < t; i++) {
            pair_left[i] = s.next();
            pair_right[i] = s.next();
        }
        //write here

//        HashSet<List<String>> set = new HashSet<>();
//        for (int i = 0; i < t; i++) {
//            List<String> list = Arrays.asList(pair_left[i] , pair_right[i]);
//            set.add(list);
//            System.out.println(set.size());
//        }

        if (t < 2){
            System.out.println(t);
        } else {
            HashSet<String> set = new HashSet<>();
            int counter = 0;
            for (int i = 0; i < t; i++) {
                if (!set.contains(pair_left[i] + " " + pair_right[i])){
                    set.add(pair_left[i] + " " + pair_right[i]);
                    counter++;
                }
                System.out.println(counter);
            }
        }

    }
}
