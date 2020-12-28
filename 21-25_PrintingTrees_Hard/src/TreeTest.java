import java.security.SecureRandom;


/**
 * TreeTest will test the tree
 */
public class TreeTest {
    //Testing two trees
    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<Integer>(); // will be a hard coded array with a balanced order
        Tree<Integer> tree2 = new Tree<Integer>(); // will be an array of random integers
        SecureRandom randomNumber = new SecureRandom();
        System.out.println("Inserting the following values: ");
        // insert 15 random integers from 0-99 in tree
        for (int i = 1; i <= 15; i++) {
            int value = randomNumber.nextInt(100);
            System.out.printf("%d ", value);
            tree2.insertNode(value);
        }
        System.out.printf("%n%nOutput Tree traversal%n");
        tree2.outputTree();
        System.out.println("\n");
        System.out.println("Inserting the following values: ");
        int[] b = {49,28,83,18,40,71,97,11,19,32,44,69,72,92,99};
        for(int i = 0; i< b.length; i++){
            System.out.printf("%d ", b[i]);
            tree.insertNode(b[i]);
        }


        System.out.printf("%n%nOutput Tree traversal%n");
        tree.outputTree();


    }
}
