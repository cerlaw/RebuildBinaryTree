/**
 * @author zhanghongjie
 * @date 2018/9/28
 * @descrition 判断一个数组是否是一棵二叉查找树的后序遍历数组
 */
public class IsPostOrderArrayOfBST {
    private boolean isPostOrderArrayOfBST(int[] array, int start, int end) {
        if (array == null || start < 0 || end > array.length || start >= end) {
            return false;
        }
        int root = array[end - 1];
        int i = start;
        for (; i < end - 1; i++) {
            if (array[i] > root) {
                break;
            }
        }

        int j = i;
        for (; j < end - 1; j++) {
            if (array[j] < root) {
                return false;
            }
        }
        boolean left = true;
        if (i > start) {
            left = isPostOrderArrayOfBST(array, start, i);
        }

        boolean right = true;
        if (i < end - 1) {
            right = isPostOrderArrayOfBST(array, i, end - 1);
        }
        return  left && right;
    }
}
