package HackerRank;

import java.util.*;

public class Java_Dequeue {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        Deque<Integer> deque = new ArrayDeque<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        int n = in.nextInt();
        int m = in.nextInt();

        int max = 0;

        for (int i = 0; i < n; i++) {

            int num = in.nextInt();

            // Add new element
            deque.addLast(num);
            map.put(num, map.getOrDefault(num, 0) + 1);

            // Remove if window > m
            if (deque.size() > m) {

                int removed = deque.removeFirst();

                map.put(removed, map.get(removed) - 1);

                if (map.get(removed) == 0) {
                    map.remove(removed);
                }
            }

            // Update max
            if (deque.size() == m) {
                max = Math.max(max, map.size());
            }
        }

        System.out.println(max);
    }
}
