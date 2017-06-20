/**
 * Created by Tanner on 11/30/2015.
 */
public class BinarySearchTree {

    public static Node root;

    public BinarySearchTree() {

        root = null;

    }

    public void insert(int value) throws NullPointerException {

        Node newNode = new Node(value);

        if(root == null){

            root = newNode;

        }

        Node currentNode = root;
        Node parentNode = currentNode;


        while (true) {

            if (currentNode != null) {

                if (value < currentNode.data) {

                    currentNode = currentNode.getLeftChild();

                    if (currentNode == null) {

                        parentNode.leftChild = newNode;

                    }

                } else {

                    currentNode = currentNode.getRightChild();

                    if (currentNode == null) {

                        parentNode.rightChild = newNode;

                    }

                }
            }
        }
    }

}
