/**
 * Created by Tanner on 12/1/2015.
 */
public class BST {

    public void insert(Node node, int value) {
        if (value < node.value) {
            if (node.left != null) {
                insert(node.left, value);
            } else {
                node.left = new Node(value);
            }
        } else if (value > node.value) {
            if (node.right != null) {
                insert(node.right, value);
            } else {
                node.right = new Node(value);
            }
        }
    }

    /*public boolean search(Node node, int value) {
        if (value == node.value) {
            return true;
        } else if (value < node.value) {
            if (node.left == null) {
                return false;
            } else {
                return node.left.search(node, value);
            }
        } else if (value > node.value) {
            if (node.right == null){
                return false;
            }else {
                return node.right.search(node, value);
            }
        } else {
            return false;
        }
    }
    **/

    public void clearTree(Node node) {
        if (node != null) {
            clearTree(node.left);
            clearTree(node.right);
            node = null;
        }
        System.gc();
    }

    public int heightOfTree(Node node) {

        if(node == null){
            return 0;
        } else {
            return 1 + Math.max(heightOfTree(node.left), heightOfTree(node.right));
        }
    }

    public void run() {
        Node root = new Node(8);
        insert(root, 2);
        insert(root, 9);
        insert(root, 5);
        insert(root, 3);
        insert(root, 4);
        insert(root, 6);
        insert(root, 1);
        System.out.println(heightOfTree(root));
        clearTree(root);
    }

    public static void main(String[] args) {
        BST testTree = new BST();
        testTree.run();

    }
}
