import java.net.*; //server side
import java.io.*;
 
public class Server
{
    
    private Socket socket   = null;
    private ServerSocket server   = null;
    private DataInputStream in =  null;
 
    public Server(int port)
    {
        try
        {
            server = new ServerSocket(port);
            server.setSoTimeout(10_000); // server timeout after 10 seconds of no connect
            System.out.println("Server is running.");
 
            System.out.println("Waiting for client to connect.");
           
 
            socket = server.accept();
            
            
            System.out.println("Client connected.");
 
            in = new DataInputStream(
                new BufferedInputStream(socket.getInputStream()));
 
            String line = "";
 
            while (!line.equals("Over"))
            {
                try
                {
                    line = in.readUTF();
                    System.out.println(line);
 
                }
                catch(IOException i)
                {
                    System.out.println(i);
                }
            }
            System.out.println("Closing.");
 
            socket.close();
            in.close();
        }
        catch(IOException i)
        {
            System.out.println(i);
        }
    }
 
    public static void main(String args[])
    {
        Server server = new Server(7896);
    }
}