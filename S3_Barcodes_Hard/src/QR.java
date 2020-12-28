

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.IOException;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.google.zxing.*;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

/**
 * creates a frame,panel,label,textfield,button that can be used in the class
 * implements and abstract class (interface) of ActionListener that gains all of its methods
 * used for when the button is clicked
 *
 */
public class QR implements ActionListener{

    JFrame f = new JFrame();
    JPanel p = new JPanel();
    JLabel l = new JLabel();
    JTextField t = new JTextField(30);
    JButton b = new JButton("Generate");

    /**
     * will set up the GUI with a frame,panel,label,textfield,and a button
     * once the button is clicked it will execute the action listener and output the QR code
     */
    public QR (){

        f.setTitle("QR Code Generator");

        f.setSize(400,400);
        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
        p.add(t);
        p.add(b);
        f.add(p);
        p.add(l);
        //calls the action listener
        b.addActionListener(this);
        p.setVisible(true);
        l.setVisible(true);
        f.setVisible(true);
    }

    /**
     * Boolean function that will return if a string is a valid URL
     * @param url a string of a url
     * @return will return if the string is a valid URL
     */
    public boolean isValid (String url){
        try{
            new URL(url).toURI();
            return true;
        } catch (MalformedURLException e) {
            e.printStackTrace();
            System.out.println("ERROR");
        } catch (URISyntaxException e) {
            e.printStackTrace();
            System.out.println("ERROR");
            return false;
        }
        return false;
    }

    /**
     * Will make sure that the input from the user is a valid URL
     * If it is valid, it will create a 2D QR code that is outputted to the GUI
     * Will keep updating the QR code if the URL is valid
     * If the URL is not valid will output an error message
     * @param actionEvent
     */
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String a;
        a = t.getText();
        if(isValid(a)){
            System.out.println(a);
            // path images is saved to
            String imagepath = "oral_exam1/S3_Barcodes_Hard/QR.png";
            //using zxing library to create QRcodeWriter
            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            try {
                //https://www.callicoder.com/generate-qr-code-in-java-using-zxing/
                //encodes out URL into a bitmatix (bitmatirx is a zxing from zxing library) 2D array of bit
                BitMatrix bit = qrCodeWriter.encode(a, BarcodeFormat.QR_CODE,200,200);
                Path path = Paths.get(imagepath);
                //outputs bitmatirx to png
                MatrixToImageWriter.writeToPath(bit,"PNG",path);
            } catch (WriterException | IOException e ) {
                e.printStackTrace();
            }
            //l.revalidate();
            ImageIcon image = new ImageIcon("oral_exam1/S3_Barcodes_Hard/QR.png");
            //refreshes the image
            image.getImage().flush();
            l.setIcon(image);
            p.add(l);
        }else {
            System.out.println("Not a valid URL");
        }

    }



}
