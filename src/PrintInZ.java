import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author zhanghongjie
 * @date 2018/9/28
 * @descrition z型打印二叉树
 */
public class PrintInZ {
    public void printInZ(BinaryTree root) {
        if (root == null) {
            return;
        }
        LinkedList<BinaryTree> queue = new LinkedList<>();
        /*第一层的分隔符，表示第一层开始*/
        queue.addLast(null);
        queue.addLast(root);
        /*从左到右的控制位*/
        boolean leftToRight = true;
        while (queue.size() != 1) {
            BinaryTree node = queue.removeFirst();
            if (node == null) {
                Iterator<BinaryTree> iterator = null;
                if (leftToRight) {
                    /*从前往后遍历*/
                    iterator = queue.iterator();
                }else {
                    /*从后往前遍历*/
                    iterator = queue.descendingIterator();
                }
                /*控制位反向*/
                leftToRight = !leftToRight;
                while (iterator.hasNext()) {
                    BinaryTree temp = iterator.next();
                    /*打印节点的值，当前节点还保存在队列中*/
                    System.out.print(temp.value + " ");
                }
                System.out.println();
                queue.addLast(null);
                /*continue将该层节点的子节点添加到队列中去*/
                continue;
            }
            if (node.leftChild != null) {
                queue.addLast(node.leftChild);
            }
            if (node.rightChild != null) {
                queue.addLast(node.rightChild);
            }
        }
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
        PrintInZ printInZ = new PrintInZ();
        BinaryTree root = printInZ.initRoot();
        printInZ.printInZ(root);
    }
}
