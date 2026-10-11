public class Leetcode_1130 {

    public static int mctFromLeafValues(int[] arr) {
        int res = 0;
        int[] stack = new int[arr.length + 1];
        int top = 0;
        stack[0] = Integer.MAX_VALUE;

        for (int num : arr) {
            while (stack[top] <= num) {
                int mid = stack[top--];
                res += mid * Math.min(stack[top], num);
            }
            stack[++top] = num;
        }

        while (top > 1) {
            res += stack[top] * stack[top - 1];
            top--;
        }

        return res;
    }

    public static void main(String[] args) {

        int[] arr = {6,2,4};

        System.out.println(mctFromLeafValues(arr));
    }
}
