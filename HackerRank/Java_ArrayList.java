package HackerRank;

import java.util.*;

//Input :-
//        5
//        5 41 77 74 22 44
//        1 12
//        4 37 34 36 52
//        0
//        3 20 22 33
//        5
//        1 3
//        3 4
//        3 1
//        4 3
//        5 5

//Output :-
//        74
//        52
//        37
//        ERROR!
//        ERROR!

public class Java_ArrayList {

    public static void printList(ArrayList<ArrayList<Integer>> list1){
        for (ArrayList<Integer> a : list1){
            for (Integer num : a){
                System.out.print(a.get(num) + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        ArrayList<ArrayList<Integer>> list1 = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i < n; i++){
            list1.add(new ArrayList<>());
            int d = sc.nextInt();
            for(int j = 0; j < d; j++){
                int num = sc.nextInt();
                list1.get(i).add(num);
            }
        }

        //Queries input section
        int q = sc.nextInt();

        for (int y = 0; y < q; y++) {

            int a = sc.nextInt();
            int b = sc.nextInt();

            try {
                System.out.println(list1.get(a - 1).get(b - 1));
            } catch (IndexOutOfBoundsException e) {
                System.out.println("ERROR!");
            }
        }

        printList(list1);
    }
}
