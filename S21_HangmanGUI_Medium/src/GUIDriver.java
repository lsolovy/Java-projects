

import javax.swing.*;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Graphics;
import java.awt.Color;

/**
 * GUIDriver is a class that extends JFrame that will create the GUI
 * It consist of a constructor that initializes the GUI,
 * a public class called Hangman that implements ActionListener that allow the user to play
 * and a public class called DrawHang that extends JPanel that makes the hangman picture
 */
public class GUIDriver extends JFrame {
    /** private JLabel a is a label for incorrect letters*/
    private JLabel a;
    /**private JLabel l is a label for entering letters*/
    private JLabel l;
    /** private JTextField incorrect is for displaying the incorrect letters */
    private JTextField incorrect;
    /**private JTextField guesses is for displaying the number of guesses */
    private JTextField guesses;
    /**private JTextField letter is for allowing the user to enter a letter */
    private JTextField letter;
    /**private JTextField halfAnswer is for showing the correct letters in the right spot without revealing the answer */
    private JTextField halfAnswer;
    /** private JPasswordField halfAnswer is for hiding the correct word */
    private JPasswordField answer;
    /** private String s is the answer */
    private String s = "covid";
    /**private int guess is the number of guesses */
    private int guess  = 9;
    /**private int body is the number of body part the man has */
    private int body = 0;
    /**private StringBuilder wrong is for creating a string of wrong letter */
    private StringBuilder wrong = new StringBuilder();
    /**private StringBuilder right is for creating a string of the correct letters with letters to still guess */
    private StringBuilder right = new StringBuilder();
    /** private DrawHang d is the class that draw the man */
    private DrawHang d = new DrawHang();
    /**
     * GUIDriver initializes the GUI
     */
    public GUIDriver(){

        setTitle("Hangman game");
        setLayout(new FlowLayout(FlowLayout.CENTER));

        l = new JLabel("Enter letter here");
        add(l);
        letter = new JTextField(30);
        add(letter);
        answer = new JPasswordField(s);
        answer.setEditable(false);
        add(answer);
        guesses = new JTextField("Number of guesses:" + guess);
        add(guesses);
        //will create a string of the length of the answer but with "*"
        for(int i = 0; i<s.length();i++){
            right.append("*");
        }
        halfAnswer = new JTextField(right.toString(),30);
        add(halfAnswer);
        a = new JLabel("Letters incorrect");
        add(a);
        incorrect = new JTextField(30);
        add(incorrect);



        d.setBackground(Color.WHITE);

        add(d);
        d.repaint();


        //calls to ActionListener
        HangMan hang = new HangMan();
        letter.addActionListener(hang);
        halfAnswer.addActionListener(hang);
        guesses.addActionListener(hang);
        incorrect.addActionListener(hang);


        setVisible(true);
    }

    /**
     * Hangman implements ActionListener that will update the game
     * It will increment the guess is they are right and wrong
     * It will increment the the number of body parts
     * It will add the incorrect and correct letters to their respective location
     * It also display a game over if the user doesn't get the word
     * And it display if the user has won (got the word)
     */
    private class HangMan implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            String input = letter.getText();
            String inputlower = input.toLowerCase();
            char c = inputlower.charAt(0);
            char[] stringToCharArray = s.toCharArray();
            int i = 0;
            boolean charNotUsed = true;
            //goes through loop of array of char
            //if a letter is correct will delete the "*" in that position and add the letter
            for(char h : stringToCharArray){
                if(h == c){
                    charNotUsed = false;
                    right.deleteCharAt(i);
                    right.insert(i,c);
                    guess--;
                    guesses.setText("Number of guesses:" + guess);
                    halfAnswer.setText(right.toString());
                }
                i++;
            }
            //appends if the letter is not used
            if(charNotUsed) {
                wrong.append(c);
                incorrect.setText(wrong.toString());
                guess--;
                guesses.setText("Number of guesses:" + guess);
                body++;
                add(d);


            }
            if(halfAnswer.getText().equals(s)){
                halfAnswer.setText("YOU WIN!");
            }else if(guess == 0){
                halfAnswer.setText( "*****  == covid, GAMEOVER! ");

            }

        }
    }

    /**
     * DrawHang extend JPanel to create a panel that will draw the man
     * the man will get drawn by body parts depending on the body int
     */
    public class DrawHang extends JPanel{

        public void paintComponent(Graphics g){
            super.paintComponent(g);
            d.setSize(100,200);
            g.setColor(Color.BLUE);
            //sets the frame for the man
            g.drawLine(60,150,100,150);
            g.drawLine(80,20,80,150);
            g.drawLine(37,20,80,20);
            g.drawLine(37,20,37,25);
            if(body >= 1){
                //draws head
                g.setColor(Color.BLACK);
                g.drawOval(25,25,25,25);
                if(body >= 2){
                    // draws body
                    g.setColor(Color.BLACK);
                    g.drawLine(38,50,38,100);
                    if(body >= 3){
                        //draws left arm
                        g.setColor(Color.BLACK);
                        g.drawLine(10,60,38,70);
                        if(body >= 4) {
                            //draws right arm
                            g.setColor(Color.BLACK);
                            g.drawLine(60,60,38,70);
                            if(body >= 5){
                                //draws right leg
                                g.setColor(Color.BLACK);
                                g.drawLine(38,100,50,120);
                                if(body >= 6){
                                    //draws left leg
                                    g.setColor(Color.BLACK);
                                    g.drawLine(38,100,25,120);
                                    if(body >= 7){
                                        //draws left eye
                                        g.setColor(Color.GRAY);
                                        g.drawOval(30,32,5,5);
                                        if(body >= 8){
                                            //draws right eye
                                            g.setColor(Color.GRAY);
                                            g.drawOval(40,32,5,5);
                                            if(body >= 9){
                                                //draws mouth
                                                g.setColor(Color.RED);
                                                g.drawArc(33,35,10,10,0,-180);
                                            }
                                        }
                                    }
                                }
                            }
                        }

                    }
                }
            }

            d.repaint();



        }
    }



}
