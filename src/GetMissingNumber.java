/**
 * @author zhanghongjie
 * @date 2018/10/18
 * @descrition
 */
public class GetMissingNumber {
    private int getMissingNumber(int[] numbers, int length) {
        if (numbers == null || length <= 0) {
            return -1;
        }

        int start = 0;
        int end = length - 1;
        while (start <= end) {
            int middle = (start + end) >> 1;
            if (middle != numbers[middle]) {
                if (middle == 0 || middle - 1 == numbers[middle - 1]) {
                    return middle;
                }else {
                    end = middle -1;
                }
            }else {
                start = middle + 1;
            }
        }
        if (start == length) {
            return length;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] data1 = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        int[] data2 = new int[]{1};
        int[] data3 = new int[]{0, 1, 2, 4};
        int[] data4 = new int[]{4, 2, 4, 4};
        int[] data5 = new int[]{};
        int[] data6 = new int[]{0};
        GetMissingNumber getMissingNumber = new GetMissingNumber();
        System.out.println(getMissingNumber.getMissingNumber(data1, data1.length));
        System.out.println(getMissingNumber.getMissingNumber(data2, data2.length));
        System.out.println(getMissingNumber.getMissingNumber(data3, data3.length));
        System.out.println(getMissingNumber.getMissingNumber(data4, data4.length));
        System.out.println(getMissingNumber.getMissingNumber(data5, data5.length));
        System.out.println(getMissingNumber.getMissingNumber(data6, data6.length));
    }
}
