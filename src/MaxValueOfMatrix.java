/**
 * @author zhanghongjie
 * @date 2018/10/15
 * @descrition 计算礼物的最大值，一个二维数组，从左上角到达右下角的数字之和最大值
 */
public class MaxValueOfMatrix {
    public int getMaxValueOfMatrix(int[][] values, int rows, int cols) {
        if(values == null || rows <= 0 || cols <= 0) {
            return 0;
        }

        int[] maxValues = new int[cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int left = 0;
                int top = 0;

                if (i > 0) {
                    top = maxValues[j];
                }
                if (j > 0) {
                    left = maxValues[j - 1];
                }
                //比较上跟左的值来更新j
                maxValues[j] = (top > left ? top : left) + values[i][j];
                System.out.println(maxValues[j]);
            }
        }
        return maxValues[cols - 1];
    }

    public static void main(String[] args) {
        int[][] values = new int[][]{{1, 10, 3, 8}, {12, 2, 9, 6}, {5, 7, 4, 11}, {3, 7, 16, 5}};
        MaxValueOfMatrix solution = new MaxValueOfMatrix();
        System.out.println(solution.getMaxValueOfMatrix(values, 4, 4));
    }
}
