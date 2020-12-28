import java.util.Stack;
/**
 * Class PostFixEval defines a stack of doubles that has methods of mathematical operations
 * Has a method that will read a StringBuffer and perform the correct operations
 */
public class PostFixEval {
    /**priavte Stack<Double> stack is used for the stack of doubles */
    private Stack<Double> stack;
    /**Constructor that will define a new stack of doubles */
    public PostFixEval(){
        stack = new Stack<>();
    }

    /**
     * will return the result of the stack
     * @return result as a double
     */
    public double result(){ return stack.pop(); }

    /**
     * will add the two doubles from the stack and then push it to the stack
     */
    public void add() {stack.push(stack.pop() + stack.pop());}

    /**
     * will subtract the doubles from the stack and then push it to the stack
     */
    public void subtract(){
        double a = stack.pop();
        double b = stack.pop();
        stack.push(b-a);
    }

    /**
     * will multiply the doubles from the stack and then push it to the stack
     */
    public void multiply() {stack.push(stack.pop() * stack.pop());}

    /**
     * will divide the doubles from the stack and then push it to the stack
     */
    public void divide(){
        double a = stack.pop();
        double b = stack.pop();
        stack.push(b/a);
    }

    /**
     * will do a module operation of the two doubles from the stack and then push it to the stack
     */
    public void remainder(){
        double a = stack.pop();
        double b = stack.pop();
        stack.push(b%a);
    }

    /**
     * will do the power of the two doubles from the stack and then push it to the stack
     * b^a
     */
    public void power(){
        double a = stack.pop();
        double b = stack.pop();
        stack.push(Math.pow(b,a));
    }

    /**
     * Will read a StringBuffer and split it up by the spaces.
     * When it finds an operation symbol it will do the respective method operation on the elements in the stack
     * @param input a StringBuffer of the correct formatted input for the evaluator
     */
    public void read(StringBuffer input){
        String s = input.toString();
        String[] splitspaces = s.split("\\s");
        for(String temp: splitspaces){
            //matches a num, including negatives
            if(temp.matches("(-?)\\d*\\.?\\d+")){
                stack.push(Double.parseDouble(temp));

            }
            else if(temp.equals("+")){
                add();
            }
            else if(temp.equals("-")){
                subtract();
            }
            else if(temp.equals("/")){
                divide();
            }
            else if(temp.equals("*")){
                multiply();
            }
            else if(temp.equals("^")){
                power();
            }
            else if(temp.equals("%")){
                remainder();
            }


        }




    }

}
