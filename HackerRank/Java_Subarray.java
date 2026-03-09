package HackerRank;

//Sample Input
//
//        5
//        1 -2 4 -5 1
//Sample Output
//
//        9
//Explanation
//
//There are nine negative subarrays of : A = [1, -2, 4, -5, 1]
//Thus, we print  9 on a new line.

import java.util.ArrayList;
import java.util.Scanner;

public class Java_Subarray {



    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int count = 0;

        // Start index
        for (int i = 0; i < n; i++) {

            int sum = 0;

            // End index
            for (int j = i; j < n; j++) {

                sum += arr[j];
                if (sum < 0) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
