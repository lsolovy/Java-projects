
import javax.swing.*;

/**
 * Will create and run the server
 */
public class ServerTest
{
   public static void main(String[] args)
   {
      Server application = new Server();
      application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      application.runServer();
   } 
}

