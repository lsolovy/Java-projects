/**
 * The TreeNode class uses the generic type T that will compare the nodes
 * This class includes a constructor and a method for inserting the value types
 * @param <T> type of value
 */
public class TreeNode <T extends Comparable<T>> {
    /**TreeNode <T>leftNode is used if the value is a left branch of the tree */
    TreeNode <T>leftNode;
    /** T data is the node value */
    T data;
    /**TreeNode <T>rightNode is used if the value is a right branch of the tree */
    TreeNode <T>rightNode;


    /**
     * Constructor that initializes the data and makes a leaf node
     * @param nodeData is the value of the node
     */
    public TreeNode(T nodeData) {
        data = nodeData;
        leftNode = null;
        rightNode = null;


    }


    /**
     * The method insert will place the new node in the correct location
     * It ignores duplicate values
     * @param insertValue value of node inserting
     */
    public void insert(T insertValue) {

        if (insertValue.compareTo(data) < 0) {

            if (leftNode == null) {
                leftNode = new TreeNode<T>(insertValue);
            }

            else {
                leftNode.insert(insertValue);
            }
        }

        else if (insertValue.compareTo(data) > 0) {

            if (rightNode == null) {
                rightNode = new TreeNode<T>(insertValue);
            }
            else {
                rightNode.insert(insertValue);
            }
        }
    }



}
