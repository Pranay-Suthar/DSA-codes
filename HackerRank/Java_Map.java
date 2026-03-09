package HackerRank;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//Sample Input
//
//3
//uncle sam
//99912222
//tom
//11122222
//harry
//12299933
//uncle sam
//uncle tom
//harry
//Sample Output
//
//uncle sam=99912222
//Not found
//harry=12299933


public class Java_Map {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        in.nextLine();
        Map<String, Integer> map = new HashMap<>(n);
        for(int i=0;i<n;i++)
        {
            String name=in.nextLine();
            int phone=in.nextInt();
            map.put(name, phone);
            in.nextLine();
        }
        while(in.hasNext())
        {
            String s=in.nextLine();

            if (map.get(s) == null){
                System.out.println("Not found");
            } else{
                System.out.println(s + "=" + map.get(s));
            }
        }
    }
}
