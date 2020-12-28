import javax.swing.*;
import java.awt.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * The class BallPanel is used to create a panel to show the balls on the screen
 * Will use the class Balls implement the task in the panel
 */
public class BallPanel extends JPanel {
    /**private ArrayList<Balls> balls is used to create an array of balls  */
    private ArrayList<Balls> balls;
    /**priavte ExecutorService executorService is used to execute the runnable class Balls */
    private ExecutorService executorService;
    /**private int x is used for the R color */
    private int x;
    /**private int y is used for the G color */
    private int y;
    /**private int z is used for the B color */
    private int z;

    /**
     * The constructor is used to create a mouseListener that allows for the user to create a ball,
     * but there is a limit of 20 balls on screen
     * Within the mouseListener the task in Balls will execute while setting a color for the ball
     */
    BallPanel() {
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(balls.size() < 20){
                    Balls b = new Balls();
                    b.setRandColor(new Color(x,y,z));
                    balls.add(b);
                    executorService.execute(b);

                }

            }
        });
        balls = new ArrayList<>();

        executorService = Executors.newCachedThreadPool();
        //needed a timer to repaint/update the screen
        Timer repaintTimer = new Timer(1, actionEvent -> {
            this.repaint();
        });
        repaintTimer.start();
    }

    /**
     * paintComponent will draw the ball to the panel
     * the color of the ball will be set and random for each one
     * @param g
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Balls b : balls) {
            x = (int)(Math.random()*256);
            y = (int)(Math.random()*256);
            z = (int)(Math.random()*256);
            g.setColor(b.getRandColor());
            g.fillOval((int) b.getX(), (int) b.getY(), 10, 10);
        }


    }




}