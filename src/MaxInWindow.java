import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author zhanghongjie
 * @date 2018/10/23
 * @descrition 滑动窗口的最大值，给定一个数组和滑动窗口的大小，请找出所有滑动窗口里的最大值
 */
public class MaxInWindow {
    private ArrayList<Integer> maxInWindows(int[] num, int size)
    {
        ArrayList<Integer> maxInWindow = new ArrayList<>();
        if (num.length >= size && size >= 1) {
            LinkedList<Integer> index = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                while (!index.isEmpty() && num[i] >= num[index.peekLast()]) {
                    index.pollLast();
                }
                index.addLast(i);
            }

            for (int i = size; i < num.length; i++) {
                maxInWindow.add(num[index.peekFirst()]);

                while (!index.isEmpty() && num[i] >= num[index.peekLast()]) {
                    index.pollLast();
                }
                if (!index.isEmpty() && index.peekFirst() <= i - size) {
                    index.pollFirst();
                }
                index.addLast(i);
            }
            maxInWindow.add(num[index.peekFirst()]);
        }
        return maxInWindow;
    }

    public static void main(String[] args) {
        int[] data1 = new int[]{2, 3, 4, 2, 6, 2, 5, 1};
        int[] data2 = new int[]{10, 14, 12, 11};
        MaxInWindow maxInWindow = new MaxInWindow();
//        ArrayList<Integer> max1 = maxInWindow.maxInWindows(data1, 3);
//        for (int i = 0; i < max1.size(); i++) {
//            System.out.println(max1.get(i));
//        }
        System.out.println("----------");
        ArrayList<Integer> max2 = maxInWindow.maxInWindows(data2, 4);
        for (int i = 0; i < max2.size(); i++) {
            System.out.println(max2.get(i));
        }
    }
}
