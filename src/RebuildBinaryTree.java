import java.util.Arrays;
import java.util.Stack;

public class RebuildBinaryTree {

    public static void main(String[] args) {
//        int[] pre = {1,2,4,7,3,5,6,8};
//        int[] in = {4,7,2,1,5,3,8,6};
//        int[] post = {7,4,2,5,8,6,3,1};
//        RebuildBinaryTree rebuild = new RebuildBinaryTree();
//        try {
////            BinaryTree node = rebuild.construct(pre, in);
//            BinaryTree node = rebuild.constructWithInorderAndPostoder(in, post);
//            System.out.print("先序遍历：");
//            rebuild.printPreOrder(node);
//            System.out.println();
//            System.out.print("中序遍历：");
//            rebuild.printInOrder(node);
//            System.out.println();
//            System.out.print("后序遍历：");
//            rebuild.printPostOrder(node);
//        } catch (Exception e) {
////            e.printStackTrace();
//            System.out.print(e.getMessage());
//        }
        RebuildBinaryTree rebuildBinaryTree = new RebuildBinaryTree();
        BinaryTree root = rebuildBinaryTree.initRoot();
//        rebuildBinaryTree.mirror(root);
        rebuildBinaryTree.mirrorInrecursively(root);
        rebuildBinaryTree.printInOrder(root);
    }

    private void printPreOrder(BinaryTree root) {
        if (root == null) {
            return;
        }
        System.out.print(root.value + " ");
        printPreOrder(root.leftChild);
        printPreOrder(root.rightChild);
    }

    private void printInOrder(BinaryTree root) {
        if (root == null) {
            return;
        }
        printInOrder(root.leftChild);
        System.out.print(root.value + " ");
        printInOrder(root.rightChild);
    }

    private void printPostOrder(BinaryTree root) {
        if (root == null) {
            return;
        }
        printPostOrder(root.leftChild);
        printPostOrder(root.rightChild);
        System.out.print(root.value + " ");
    }

    public BinaryTree construct(int[] preOrder, int[] inOrder) throws Exception {

        //数组为空的话直接返回null，递归的终止条件
        if (preOrder.length == 0 || inOrder.length == 0) {
//            throw new Exception("invalid input");
            return null;
        }

        //先序遍历数组中的第一个元素作为根元素
        BinaryTree root = new BinaryTree(preOrder[0]);
        //先找到根节点在中序遍历中的位置
        int rootIndex = -1;
        for (int i = 0; i < inOrder.length; i++) {
            if (preOrder[0] == inOrder[i]) {
                rootIndex = i;
                break;
            }
        }
        if (rootIndex == -1) {
            throw new Exception("invalid input");
        }

        /**
        * 将preOrder和inOrder分为左右两部分再进行递归
         * preOrderLeft: [1..index];
         * preOrderRight: [index + 1..preOrder.length - 1];
         * inOrderLeft: [0..index - 1];
         * inOrderRight: [index + 1..inOrder.length - 1];
        * */
        int[] preLeft = Arrays.copyOfRange(preOrder, 1, rootIndex + 1);
        int[] preRight = Arrays.copyOfRange(preOrder, rootIndex + 1, preOrder.length);

        int[] inLeft = Arrays.copyOfRange(inOrder, 0, rootIndex);
        int[] inRight = Arrays.copyOfRange(inOrder, rootIndex + 1, inOrder.length);

        root.leftChild = construct(preLeft, inLeft);
        root.rightChild = construct(preRight, inRight);
        return root;
    }

    public BinaryTree constructWithInorderAndPostoder(int[] inOrder, int[] postOrder) throws Exception {
        if (inOrder.length == 0 || postOrder.length == 0) {
//            throw new Exception("invalid input");
            return null;
        }

        int postLength = postOrder.length;
        int inLength = inOrder.length;
        //后序遍历数组中最后一个元素为根元素
        BinaryTree root = new BinaryTree(postOrder[postLength - 1]);
        //先找出根元素在中序遍历中的位置
        int index = -1;
        for (int i = 0; i < inLength; i++) {
            if (postOrder[postLength - 1] == inOrder[i]) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            throw new Exception("invalid input");
        }

        /**
         * 将postOrder和inOrder分为左右两部分再进行递归处理
         * inOrderLeft: [0..index - 1];
         * inorderRight: [index + 1..inLength - 1];
         * postOrderLeft: [0..index - 1];
         * postOrderRight: [index..postLength - 2];
         * */
        int[] inLeft = Arrays.copyOfRange(inOrder, 0, index);
        int[] inRight = Arrays.copyOfRange(inOrder, index + 1, inLength);
        int[] postLeft = Arrays.copyOfRange(postOrder, 0, index);
        int[] postRight = Arrays.copyOfRange(postOrder, index, postLength - 1);
        root.leftChild = constructWithInorderAndPostoder(inLeft, postLeft);
        root.rightChild = constructWithInorderAndPostoder(inRight, postRight);

        return root;
    }

    private BinaryTree mirror(BinaryTree root) {
        if (root == null || (root.rightChild == null && root.leftChild == null)) {
            return null;
        }

        Stack<BinaryTree> stack = new Stack<>();
        BinaryTree node = root;
        while (node != null || stack.size() > 0) {
            while (node != null) {
                if (root.leftChild == null && root.rightChild == null) {
                    break;
                }
                BinaryTree temp = node.leftChild;
                node.leftChild = node.rightChild;
                node.rightChild = temp;
                stack.push(node);
                node = node.leftChild;
            }
            if (stack.size() > 0) {
                node = stack.pop();
                System.out.print(node.value);
                node = node.rightChild;
            }
        }

        return node;
    }

    private void mirrorInrecursively(BinaryTree root) {
        if (root == null) {
            return;
        }
        if (root.rightChild == null && root.leftChild == null) {
            return;
        }
        BinaryTree temp = root.leftChild;
        root.leftChild = root.rightChild;
        root.rightChild = temp;
        if (root.leftChild != null) {
            mirrorInrecursively(root.leftChild);
        }
        if (root.rightChild != null) {
             mirrorInrecursively(root.rightChild);
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
//        ten.leftChild = nine;
        ten.rightChild = eleven;
        return eight;
    }
}
