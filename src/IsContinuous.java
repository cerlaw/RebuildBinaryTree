import java.util.Arrays;

/**
 * @author zhanghongjie
 * @date 2018/10/26
 * @descrition 从扑克牌中随机抽取5张牌，判断是不是一个顺子，即这5张牌是不是连续的。将大小王看成任意数字。
 */
public class IsContinuous {
    public boolean isContinuous(int[] numbers) {
        if (numbers == null || numbers.length < 5) {
            return false;
        }

        Arrays.sort(numbers);

        int numberOfZero = 0;
        int numberOfGap = 0;

        for (int i = 0; i < numbers.length && numbers[i] == 0; i++) {
            numberOfZero++;
        }

        int small = numberOfZero;
        int big = small + 1;

        while (big < numbers.length) {
            //有对子的话不可能是顺子
            if (numbers[big] == numbers[small]) {
                return false;
            }


            numberOfGap += numbers[big] - numbers[small] - 1;
            small = big;
            big++;
        }
        return numberOfGap <= numberOfZero;
    }
}
