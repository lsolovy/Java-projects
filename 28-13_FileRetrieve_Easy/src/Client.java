
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Class Client is used to set up everything on the side of the client
 */
public class Client extends JFrame 
{
   /** private JTextField enterField is used to the information the user enters */
   private JTextField enterField;
   /** private JTextArea displayArea is used to display the information to the user */
   private JTextArea displayArea;
   /**private ObjectOutputStream output is used to output the stream to the server */
   private ObjectOutputStream output;
   /**private ObjectInputStream input is used to the input stream from the server */
   private ObjectInputStream input;
   /**private String message is used for the message from the server */
   private String message = "";
   /**private String chatServer is used to host the server for this application */
   private String chatServer;
   /**private Socket client is used as the socket to communicate with the server */
   private Socket client;

   /**
    * Constructor that will initialize chatServer and set up GUI
    * @param host
    */
   public Client(String host)
   {
      super("Client");

      chatServer = host; // set server to which this client connects

      enterField = new JTextField(); // create enterField
      enterField.setEditable(false);
      enterField.addActionListener(
         new ActionListener() 
         {
            // send message to server
            public void actionPerformed(ActionEvent event)
            {
               sendData(event.getActionCommand());
               enterField.setText("");
            } 
         } 
      ); 

      add(enterField, BorderLayout.NORTH);

      displayArea = new JTextArea(); // create displayArea
      add(new JScrollPane(displayArea), BorderLayout.CENTER);

      setSize(300, 150); // set size of window
      setVisible(true); // show window
   }

   /**
    * Will connect to server and process messages from server
    * Will display is the client is terminated
    */
   public void runClient() 
   {
      try // connect to server, get streams, process connection
      {
         connectToServer(); // create a Socket to make connection
         getStreams(); // get the input and output streams
         processConnection(); // process connection
      } 
      catch (EOFException eofException) 
      {
         displayMessage("\nClient terminated connection");
      } 
      catch (IOException ioException) 
      {
         ioException.printStackTrace();
      } 
      finally 
      {
         closeConnection(); // close connection
      }
   }

   /**
    * Will connect to server
     */
   private void connectToServer() throws IOException
   {      
      displayMessage("Attempting connection\n");

      // create Socket to make connection to server
      client = new Socket(InetAddress.getByName(chatServer), 23935);

      // display connection information
      displayMessage("Connected to: " + 
         client.getInetAddress().getHostName());
   }

   /**
    * Will get streams to send and receive data
    * @throws IOException
    */
   private void getStreams() throws IOException
   {
      // set up output stream for objects
      output = new ObjectOutputStream(client.getOutputStream());      
      output.flush(); // flush output buffer to send header information

      // set up input stream for objects
      input = new ObjectInputStream(client.getInputStream());

      displayMessage("\nGot I/O streams\n");
   }

   /**
    * Will process connection with server
    */
   private void processConnection() throws IOException
   {
      // enable enterField so client user can send messages
      setTextFieldEditable(true);

      do // process messages sent from server
      { 
         try // read message and display it
         {
            message = (String) input.readObject(); // read new message
            displayMessage("\n" + message); // display message
         } 
         catch (ClassNotFoundException classNotFoundException) 
         {
            displayMessage("\nUnknown object type received");
         } 

      } while (!message.equals("SERVER>>> TERMINATE"));
   }

   /**
    * Will close streams and socket
    */
   private void closeConnection() 
   {
      displayMessage("\nClosing connection");
      setTextFieldEditable(false); // disable enterField

      try 
      {
         output.close(); // close output stream
         input.close(); // close input stream
         client.close(); // close socket
      } 
      catch (IOException ioException) 
      {
         ioException.printStackTrace();
      } 
   }

   /**
    * Will send message to server
    */
   private void sendData(String message)
   {
      try // send object to server
      {
         output.writeObject("CLIENT>>> " + message);
         output.flush(); // flush data to output
         displayMessage("\nCLIENT>>> " + message);
      } 
      catch (IOException ioException)
      {
         displayArea.append("\nError writing object");
      } 
   }

   /**
    *  manipulates displayArea in the event-dispatch thread
    */
   private void displayMessage(final String messageToDisplay)
   {
      SwingUtilities.invokeLater(
         new Runnable()
         {
            public void run() // updates displayArea
            {
               displayArea.append(messageToDisplay);
            }
         }  
      ); 
   }

   /**
    * manipulates enterField in the event-dispatch thread
    * @param editable  boolean to tell if the textfield if editable
    */
   private void setTextFieldEditable(final boolean editable)
   {
      SwingUtilities.invokeLater(
         new Runnable() 
         {
            public void run() // sets enterField's editability
            {
               enterField.setEditable(editable);
            }
         } 
      ); 
   } 
} 
