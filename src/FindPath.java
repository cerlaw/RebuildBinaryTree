import java.util.Stack;

/**
 * @author zhanghongjie
 * @date 2018/9/30
 * @descrition 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的的所有路径。
 * 从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 */
public class FindPath {
    private void findPath(BinaryTree root, int sum) {
        if (root == null) {
            return;
        }
        Stack<Integer> data = new Stack<>();
        int currentNum = 0;
        findPath(root, sum, data, currentNum);
    }

    private void findPath(BinaryTree root, int sum, Stack<Integer> data, int currentNum) {
        currentNum = root.value + currentNum;
        data.push(root.value);

        boolean isLeaf = root.leftChild == null && root.rightChild == null;
        if (currentNum == sum && isLeaf) {
            /*打印路径*/
            for (Integer aData : data) {
                System.out.print(aData + " ");
            }
            System.out.println();
        }

        /*如果不是叶节点，则遍历它的子节点*/
        if (root.leftChild != null) {
            findPath(root.leftChild, sum, data, currentNum);
        }
        if (root.rightChild != null) {
            findPath(root.rightChild, sum, data, currentNum);
        }
        /*返回父节点之前，在路径上删除当前节点*/
        data.pop();
    }

    private BinaryTree initRoot() {
        BinaryTree eight = new BinaryTree(8);
        BinaryTree six = new BinaryTree(6);
        BinaryTree five = new BinaryTree(5);
        BinaryTree seven = new BinaryTree(7);
        BinaryTree ten = new BinaryTree(10);
        BinaryTree nine = new BinaryTree(9);
        BinaryTree eleven = new BinaryTree(11);
        eight.leftChild = six;
        eight.rightChild = ten;
        six.leftChild = five;
        six.rightChild = seven;
        ten.leftChild = nine;
        ten.rightChild = eleven;
        return eight;
    }

    public static void main(String[] args) {
        FindPath findPath = new FindPath();
        BinaryTree root = findPath.initRoot();
        String s = new String("rer");
        StringBuilder sb = new StringBuilder(s);
        findPath.findPath(root, 27);
    }
}
