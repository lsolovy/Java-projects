

import javax.swing.*;

/**
 * Will declare the client application and run the client
 */
public class ClientTest 
{
   public static void main(String[] args)
   {
      Client application; // declare client application

      // if no command line args
      if (args.length == 0)
         application = new Client("128.255.17.152"); // connect to localhost
      else
         application = new Client(args[0]); // use args to connect

      application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      application.runClient(); // run client application
   } 
} 


