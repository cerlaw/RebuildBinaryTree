import java.util.Stack;

/**
 * @author zhanghongjie
 * @date 2018/9/29
 * @descrition 输入两个整数序列，第一个序列表示的是栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序
 */
public class IsPopOreder {
    private boolean isPopOreder(int[] pushArray, int[] popArray) {
        boolean possible = false;
        Stack<Integer> data = new Stack<>();
        if (pushArray != null && popArray != null && pushArray.length == popArray.length) {
            if (pushArray.length == 0) {
                return true;
            }
            int indexOfPushArray = 0;
            int indexOfPopArray = 0;
            int pushLength = pushArray.length;
            int popLength = popArray.length;

            while (indexOfPopArray < popLength) {
                while (data.empty() || data.peek() != popArray[indexOfPopArray]) {
                    if (indexOfPushArray >= pushLength) {
                        /*当一直不相等的时候，防止压入数组溢出，调出循环*/
                        break;
                    }
                    /*压入最后一个数据后，数组越界*/
                    data.push(pushArray[indexOfPushArray++]);
                }
                if (data.peek() != popArray[indexOfPopArray]) {
                    /*当栈顶数据与出栈数组中的元素不等时，即不存在该出栈顺序*/
                    break;
                }
                System.out.print(data.pop());
                /*最后会自加到数组溢出，即不满足循环条件*/
                indexOfPopArray++;
            }

            if (data.empty() && indexOfPushArray - indexOfPopArray == 0) {
                /*辅助栈为空，并且索引相等表明存在该出栈顺序*/
                possible = true;
            }
        }
        return possible;
    }

    public static void main(String[] args) {
        IsPopOreder isPopOreder = new IsPopOreder();
        int[] push = new int[]{1, 2, 3, 4, 5};
//        int[] pop = new int[]{4, 5, 3, 2, 1};
//        int[] pop = new int[]{1, 2, 3, 4, 5};
        int[] pop = new int[]{4, 5, 3, 1, 2};
        System.out.print(isPopOreder.isPopOreder(push, pop));
    }
}
