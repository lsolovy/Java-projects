import javax.swing.*;
import java.awt.BorderLayout;

/**
 * The Driver class is used to run the program
 * The class will create a frame the adds the BallPanel
 * will center the panel to the middle of the frame
 */
public class Driver {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        BallPanel bp = new BallPanel();
        frame.add(bp, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200,200);
        frame.setResizable(false);
        frame.setVisible(true);
    }

}
