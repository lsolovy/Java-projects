

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 * will run the GUI
 */
public class GUITest {
    public static void main(String[] args)
    {
       GUIDriver a = new GUIDriver();
        a.setSize(400,400);
        a.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}

