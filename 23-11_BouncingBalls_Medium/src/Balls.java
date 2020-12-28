
import java.awt.*;
import java.util.Random;

/**
 * The Balls class implements Runnable to specify the task that the thread will execute
 * The class consist of a constructor, the method run, some getters, and a setter
 */
public class Balls implements Runnable {
    /**private double x is used for the x location of the ball */
    private double x;
    /**private double y is used for the y location of the ball */
    private double y;
    /**private double dx is used for the change in x */
    private double dx;
    /**private double dy is used for the change in y */
    private double dy;
    /**private boolean is used to tell if the ball is moving in the x direction */
    private boolean forward;
    /**private boolean is used to tell is the ball is moving in the y direction*/
    private boolean downward;
    /**private Random generator is used to generate a random dx*/
    private Random generator;
    /**private Color randColor is used to get/set the color of the ball */
    private Color randColor;


    /**
     * The constructor will set the instance variables to default
     */
    public Balls(){

        forward = true;
        downward = true;
        x = 0;
        y = 0;
        generator = new Random();
        //will generate a random change in x
        dx = 1 + generator.nextInt(5);
        dy = 5;

    }
    /**
     * The run method comes with the interface Runnable
     * the run method will contains code that defines the task that an object will perform
     * in this case it is the ball
     * The method will set the bounds for the ball
     */
    @Override
    public void run() {
        while (true){
            try{
                //.sleep used for pacing
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }

            if(forward){
                x += dx;
                if(x >= 190){
                    forward = false;
                }
            }
            else{
                x -= dx;
                if(x <= 0){
                    forward = true;
                }
            }
            if(downward){
                y += dy;
                if(y >= 153){
                    downward = false;
                }
            }
            else{
                y -= dy;
                if(y <= 0){
                    downward = true;
                }
            }


        }

    }

    /**
     * @return the x location
     */
    public double getX() {
        return x;
    }

    /**
     * @return the y location
     */
    public double getY() {
        return y;
    }

    /**
     * @return the color of the ball
     */
    public Color getRandColor() {
        return randColor;
    }

    /**
     * will set the color of the ball
     * @param randColor
     */
    public void setRandColor(Color randColor) {
        this.randColor = randColor;
    }
}
