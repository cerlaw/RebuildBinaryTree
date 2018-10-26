
/**
 * @author zhanghongjie
 * @date 2018/10/24
 * @descrition 把n个骰子仍在地上，所有骰子朝上的一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率
 * 思路：基于循环求骰子点数，时间性能好。利用两个数组来存储骰子点数的每个点数出现的次数。在一轮循环中，第一个数组中的第n个数字表示骰子和为n
 * 的骰子出现的次数。在下一轮循环中，我们加上一个新的骰子，此时的和和为n的骰子出现的次数应该等于上一轮循环中骰子点数和为
 * n-1, n-2, n-3, n-4, n-5与n-6的次数总和。而第k次之前骰子出现的次数为0。
 */
public class PrintProbability {
    private int touziValue = 6;
    private void printProbability(int number) {
        if (number < 1) {
            return;
        }
        int maxValue = touziValue * number;
        int[][] probability = new int[2][];
        probability[0] = new int[maxValue + 1];
        probability[1] = new int[maxValue + 1];

        for (int i = 0; i < maxValue + 1; i++) {
            probability[0][i] = 0;
            probability[1][i] = 0;
        }
        int flag = 0;

        //第一轮的时候，每个数字出现的次数都是1
        for (int i = 1; i <= touziValue; i++) {
            probability[flag][i] = 1;
        }

        //第二轮开始应用思路中的计算方法
        for (int k = 2; k <= number; k++) {
            for (int i = 0; i < k; i++) {
                probability[1-flag][i] = 0;
            }

            for (int i = k; i <= k * touziValue; i++) {
                probability[1-flag][i] = 0;
                for (int j = 1; j <= i && j <= touziValue; j++) {
                    probability[1 - flag][i] += probability[flag][i - j];
                }
            }
            flag = 1 - flag;
        }

        double total = Math.pow(touziValue, number);
        for (int i = number; i <= maxValue; i++) {
            double ratio = probability[flag][i] / total;
            System.out.println(i + ": " + ratio);
        }
    }

    public static void main(String[] args) {
        PrintProbability printProbability = new PrintProbability();
        printProbability.printProbability(3);
    }
}
