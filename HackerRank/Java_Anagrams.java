package HackerRank;

import java.util.HashMap;

public class Java_Anagrams {
    static boolean isAnagram(String a, String b) {
        if (a.length() != b.length())
            return false;

        a = a.toLowerCase();
        b = b.toLowerCase();

        HashMap<Character, Integer> map = new HashMap<>();

        // Count characters from a
        for (char c : a.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // Subtract using b
        for (char c : b.toCharArray()) {

            if (!map.containsKey(c))
                return false;

            map.put(c, map.get(c) - 1);

            if (map.get(c) < 0)
                return false;
        }

        return true;

    }

//    static boolean isAnagram(String a, String b) {
//
//        if (a.length() != b.length())
//            return false;
//
//        a = a.toLowerCase();
//        b = b.toLowerCase();
//
//        int[] freq = new int[26]; // for a-z
//
//        // Count from a
//        for (int i = 0; i < a.length(); i++) {
//            freq[a.charAt(i) - 'a']++;
//        }
//
//        // Subtract using b
//        for (int i = 0; i < b.length(); i++) {
//
//            freq[b.charAt(i) - 'a']--;
//
//            if (freq[b.charAt(i) - 'a'] < 0)
//                return false;
//        }
//
//        return true;
//    }


    public static void main(String[] args) {
        System.out.println(isAnagram("hello","hellp"));
    }
}
