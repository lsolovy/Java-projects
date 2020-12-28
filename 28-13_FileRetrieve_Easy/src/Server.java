
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Class Server will set up everything on the side of the server from the client
 */
public class Server extends JFrame 
{
   /**private JTextField enterField is used for the user to inputs the message */
   private JTextField enterField;
   /**private JTextArea displayArea is user to the display the information to the user */
   private JTextArea displayArea;
   /**private ObjectOutputStream output is used to output the stream to the client */
   private ObjectOutputStream output;
   /**private ObjectInputStream input is used to input the stream from the client */
   private ObjectInputStream input;
   /**private ServerSocket server is used to created the server socket */
   private ServerSocket server;
   /**private Socket connection is used for the connection to the client */
   private Socket connection;


   /**
    * Constructor that initializes and sets up the GUI
    */
   public Server()
   {
      super("Server");

      enterField = new JTextField(); // create enterField
      enterField.setEditable(false);
      enterField.addActionListener(
         new ActionListener()
         {
            // send message to client
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
    * Creates the server with serverSocket
    */
   public void runServer()
   {
      try // set up server to receive connections; process connections
      {
         server = new ServerSocket(23935, 100); // create ServerSocket

         while (true) 
         {
            try 
            {
               waitForConnection(); // wait for a connection
               getStreams(); // get input & output streams
               processConnection(); // process connection
            } 
            catch (EOFException eofException) 
            {
               //System.out.println("\nServer terminated connection");
               displayMessage("\nServer terminated connection");
            } 
            finally 
            {
               closeConnection(); //  close connection

            } 
         } 
      } 
      catch (IOException ioException) 
      {
         ioException.printStackTrace();
      } 
   }

   /** wait for connection to arrive, then display connection info
    * @throws IOException Throws error if server socket cannot connect to client
    */
   private void waitForConnection() throws IOException
   {
      displayMessage("Waiting for connection\n");
      connection = server.accept(); // allow server to accept connection
      displayMessage("Connection received from: " +
              connection.getInetAddress().getHostName());
   }

   /** get streams to send and receive data*/
   private void getStreams() throws IOException
   {
      // set up output stream for objects
      output = new ObjectOutputStream(connection.getOutputStream());
      output.flush(); // flush output buffer to send header information

      // set up input stream for objects
      input = new ObjectInputStream(connection.getInputStream());
      //System.out.println("\nGot I/O streams\n");
      displayMessage("\nGot I/O streams\n");
   }

   /**
    * Server will receive a file from the client and attempt to retrieve the file said
    * If the file exist it will send the file, if not will say file does not exist
    * Will keep asking for a file until user enters terminate thus then disconnect
    * @throws IOException Throws error if problem will file
    */
   private void processConnection() throws IOException
   {
      //System.out.println("Processing connection");
      String message = "Connection successful";
      sendData(message); // send connection successful message

      // enable enterField so server user can send messages
      setTextFieldEditable(true);

      do // process messages sent from client
      { 
         try // read message and display it
         {
            message = (String) input.readObject(); // read new message

            if(message.equals("TERMINATE")){
               sendData("TERMINATE");
            }else{
               sendData(retrieveFile(message));
            }


         } catch(IOException e){
            System.out.println("Problem encountered while processing connection with message" + e.getMessage());
         }
         catch (ClassNotFoundException classNotFoundException) 
         {
            displayMessage("\nUnknown object type received");
            //System.out.println("Unknown object type received");
         } 

      } while (!message.equals("CLIENT>>> TERMINATE"));
   }

   /**
    * close streams and socket
    */
   private void closeConnection() 
   {
      displayMessage("\nTerminating connection\n");
      setTextFieldEditable(false); // disable enterField

      try 
      {
         output.close(); // close output stream
         input.close(); // close input stream
         connection.close(); // close socket
      } 
      catch (IOException ioException) 
      {
         ioException.printStackTrace();
      } 
   }

   /**
    * send message to client
    * will display if there is an error in writing to the outputStream
    * @param message is a String of the file contents that will send to the client
    */
   private void sendData(String message)
   {
      try // send object to client
      {
         output.writeObject("SERVER>>> " + message);
         output.flush(); // flush output to client
         displayMessage("\nSERVER>>> " + message);
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
               displayArea.append(messageToDisplay); // append message
            } 
         } 
      ); 
   }

   /**
    * manipulates enterField in the event-dispatch thread
    * @param editable boolean to tell if the textfield if editable
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

   /**
    * Retrieves a file and constructs a String based on the content of the file
    * if file is not found, will prompt the user
    * @param file -a String with the name of file to send
    * @return will return a String on the contents of the file
    */
   private String retrieveFile(String file){
      StringBuilder fileContents = new StringBuilder();
      try{
         file = file.substring(10);
         System.out.println(file);

         File fileRetrieved = new File("oral_exam2/28-13_FileRetrieve_Easy/src/" +file);

         Scanner scanner = new Scanner(fileRetrieved);

         while(scanner.hasNextLine()){
            fileContents.append(scanner.nextLine()).append("\n");
         }

      } catch (FileNotFoundException e) {
         fileContents = new StringBuilder("File Not Found");
      }
      return fileContents.toString();
   }
} 

