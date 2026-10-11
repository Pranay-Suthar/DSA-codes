public class Leetcode_1504 {

    public static int numSubmat(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        int[] heights = new int[col];
        int totalSubmatrices = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                heights[j] = mat[i][j] == 0 ? 0 : heights[j] + 1;
            }

            int[] stack = new int[col + 1];
            int[] sum = new int[col];
            int top = -1;

            for (int j = 0; j < col; j++) {
                while (top >= 0 && heights[stack[top]] >= heights[j]) {
                    top--;
                }

                if (top < 0) {
                    sum[j] = heights[j] * (j + 1);
                } else {
                    int prevIdx = stack[top];
                    sum[j] = sum[prevIdx] + heights[j] * (j - prevIdx);
                }

                top++;
                stack[top] = j;
                totalSubmatrices += sum[j];
            }
        }
        return totalSubmatrices;
    }

    public static void main(String[] args) {

        int[][] mat = {{0,1,1,0},{0,1,1,1},{1,1,1,0}};

        System.out.println(numSubmat(mat));
    }

}
