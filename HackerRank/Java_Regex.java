package HackerRank;

public class Java_Regex {
    public static boolean checkIPV4(String s){
        if (s == null || s.isEmpty()){
            return false;
        }
        int len = s.length();

        if (s.charAt(0) == '.' || s.charAt(len - 1) == '.'){
            return false;
        }

        String[] str = s.split("\\.");

        if (str.length != 4) return false;

        for(String st : str){
            int num = Integer.parseInt(st);
            if (num < 0 || num > 255) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(checkIPV4("666.666.23.23"));
    }
}
//Some valid IP address:
//
//        000.12.12.034
//        121.234.12.12
//        23.45.12.56
//Some invalid IP address:
//
//        000.12.234.23.23
//        666.666.23.23
//        .213.123.23.32
//        23.45.22.32.
//I.Am.not.an.ip