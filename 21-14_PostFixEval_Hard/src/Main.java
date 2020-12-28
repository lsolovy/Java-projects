import java.util.Scanner;
/**
 * Class Main is the main of this program that will run the PostFixEval
 * Will prompt the user to enter an expression to be evaluated
 * Will then output the answer
 */
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        PostFixEval post = new PostFixEval();
        System.out.println("Enter an expression in the correct format: ");
        StringBuffer input = new StringBuffer(scan.nextLine());
        input.append(" )");
        post.read(input);
        double r = post.result();
        System.out.println(r);
    }
}
