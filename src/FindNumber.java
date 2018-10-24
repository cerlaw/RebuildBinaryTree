/**
 * @author zhanghongjie
 * @date 2018/10/17
 * @descrition 统计一个数字在排序数组中出现的次数
 */
public class FindNumber {
    private int findNumber(int[] datas, int length, int k) {
        int number = 0;

        if (datas != null && length > 0) {
            int first = getFirstK(datas, length, k, 0, length - 1);
            int last = getLastK(datas, length, k, 0, length - 1);

            System.out.println("first:" + first + ",last:" + last);
            if (first > -1 && last > -1) {
                number = last - first + 1;
            }
        }
        return number;
    }

    private int getFirstK(int[] datas, int length, int k, int start, int end) {
        if (start > end) {
            return -1;
        }

        int middleIndex = (start + end) / 2;
        int middleData = datas[middleIndex];
        if (middleData == k) {
            if ((middleIndex > 0 && datas[middleIndex - 1] != k) || middleIndex == 0) {
                return middleIndex;
            }else {
                end = middleIndex - 1;
            }
        }else if (middleData > k) {
            end = middleIndex - 1;
        }else {
            start = middleIndex + 1;
        }
        return getFirstK(datas, length, k, start, end);
    }

    private int getLastK(int[] datas, int length, int k, int start, int end) {
        if (start > end) {
            return -1;
        }

        int middleIndex = (start + end) / 2;
        int middleData = datas[middleIndex];
        if (middleData == k) {
            if ((middleIndex < length - 1 && datas[middleIndex + 1] != k) || middleIndex == length -1) {
                return middleIndex;
            }else {
                return middleIndex + 1;
            }
        }else if (middleData > k) {
            end = middleIndex - 1;
        }else {
            start = middleIndex + 1;
        }
        return getLastK(datas, length, k, start, end);
    }

    public static void main(String[] args) {
        int[] data1 = new int[]{1, 2, 3, 3, 3, 3, 4, 5};
        int[] data2 = new int[]{3};
        FindNumber findNumber = new FindNumber();
        System.out.println(findNumber.findNumber(data1, data1.length, 3));
        System.out.println(findNumber.findNumber(data2, data2.length, 3));
        System.out.println(findNumber.findNumber(data1, data1.length, 5));
        System.out.println(findNumber.findNumber(data1, data1.length, 7));
    }
}
