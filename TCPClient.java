import java.net.*; //Client side
import java.io.*;
 
public class TCPClient
{

    private Socket socket = null;
    private DataInputStream  input = null;
    private DataOutputStream out = null;
 
    public TCPClient(String address, int port)
    {
        try
        {
            socket = new Socket(address, port);
            System.out.println("Connection sucessful");
 
            input  = new DataInputStream(System.in);
 
            out    = new DataOutputStream(socket.getOutputStream());
        }
        catch(UnknownHostException u)
        {
            System.out.println(u);
        }
        catch(IOException i)
        {
            System.out.println(i);
        }
 
        String line = "";
 
        while (!line.equals("Over"))
        {
            try
            {
                line = input.readLine();
                out.writeUTF(line);
            }
            catch(IOException i)
            {
                System.out.println(i);
            }
        }
 
        try
        {
            input.close();
            out.close();
            socket.close();
        }
        catch(IOException i)
        {
            System.out.println(i);
        }
    }
 
    public static void main(String args[])
    {
        TCPClient client = new TCPClient("127.0.0.1", 7896);
    }
}