import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * A class that extends JFrame for the use of GUI implementation
 * will create a frame that has two text boxes that the user can write in
 * In one text box the user could enter the Arabic number and in real time will display the Roman numeral in the other text box
 * Vice versa for the user entering the Roman numeral
 * will display if the Roman numeral is not valid with "Invalid"
 * KeyLisenter allows for this type of interaction
 * when the user types the conversion class is called
 * These conversions only work for 1-3999
 */
public class GUIDriver extends JFrame  {

    private JFrame f;
    private JPanel p;
    private JLabel a;
    private JLabel r;
    private JTextField arabic;
    private JTextField roman;
    private ArabicToRoman ar;
    private RomanToArabic ro;
    private Roman rokey;
    private Arabic arkey;

    public GUIDriver(){
         f = new JFrame();
         p = new JPanel();
         a = new JLabel("Enter Arabic number");
         r = new JLabel("Roman numeral");
         arabic = new JTextField(30);
         roman = new JTextField(30);
         ar = new ArabicToRoman();
         ro = new RomanToArabic();
         arkey = new Arabic();
         rokey = new Roman();
         f.setTitle("Arabic to Roman 1-3999");

         f.setSize(400,400);
         f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
         roman.addKeyListener(rokey);
         arabic.addKeyListener(arkey);
         p.add(a);
         p.add(arabic);
         p.add(r);
         p.add(roman);

         f.add(p);
         p.setVisible(true);
         f.setVisible(true);

    }


    //KeyLisenter becasue user is using the keyboard
    public class Arabic implements KeyListener{

        @Override
        public void keyTyped(KeyEvent keyEvent) {

        }

        @Override
        public void keyPressed(KeyEvent keyEvent) {

        }

        @Override
        public void keyReleased(KeyEvent keyEvent) {
            if(!arabic.getText().isEmpty()){
                roman.setText(ar.AtoR(arabic.getText()));
            }

        }
    }
    public class Roman implements KeyListener{

        @Override
        public void keyTyped(KeyEvent keyEvent) {

        }

        @Override
        public void keyPressed(KeyEvent keyEvent) {

        }

        @Override
        public void keyReleased(KeyEvent keyEvent) {
            if(!roman.getText().isEmpty()){
                arabic.setText(ro.RtoA(roman.getText()));
            }

        }
    }
}

