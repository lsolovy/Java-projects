import javax.swing.*;

/**
 * Will run the GUI and set the dimensions
 */
public class RunGUI {
    public static void main(String[] args) {
        GUIDriver q = new GUIDriver();
        q.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        q.setSize(350, 400);
        q.setVisible(true);



    }
}
