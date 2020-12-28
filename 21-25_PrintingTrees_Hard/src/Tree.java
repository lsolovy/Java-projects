/**
 * The Tree class is used to construct the tree
 * @param <T> type of value
 */
public class Tree<T extends Comparable<T>> {
    /**private TreeNode<T> root is used to define the root*/
    private TreeNode<T> root;
    /**private int totalSpaces is used to space the levels of the tree (depth)*/
    private int totalSpaces;

    /**
     * Constructor that initializes and empty tree of integers with no depth
     */
    public Tree() {
        root = null;
        totalSpaces = 0;
    }

    /**
     * This method is used to insert a new node in the tree
     * @param insertValue value of node
     */
    public void insertNode(T insertValue) {
        if (root == null) {
            root = new TreeNode<T>(insertValue);
        } else
            root.insert(insertValue);

    }

    /**
     * begins outputTree
     */
    public void outputTree(){

        outputTreeHelper(root, totalSpaces);
    }

    /**
     * Recursive method to perform outputTree
     * @param node uses a node to determine the placement
     * @param totalSpaces will set the location of the node
     */
    private void outputTreeHelper(TreeNode<T> node, int totalSpaces){

        if(node == null){
            return;
        }
        totalSpaces += 5;
        outputTreeHelper(node.rightNode, totalSpaces);


        for(int i = 5; i < totalSpaces; i++){

            System.out.print(" ");

        }
        System.out.println(node.data); // outputs the node value

        outputTreeHelper(node.leftNode,totalSpaces);

    }


}


