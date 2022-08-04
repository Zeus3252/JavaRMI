import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;
import java.lang.Math;
import java.rmi.Remote;
import java.rmi.RemoteException;
 interface Hello extends Remote {
    String sayHello() throws RemoteException;
}


        
public class Server implements Hello {

        
    public Server() {}

    public String sayHello() {
        return "Hello, world!";
    }
     
    public static void main(String args[]) {
        System.out.println("Enter 3 integers: ");
            Scanner input = new Scanner(System.in);
            int a = input.nextInt(); int b = input.nextInt(); int c = input.nextInt();
            int max =  Math.max(Math.max(a,b),c);
            System.out.println(a + " " + b + " "+ c);
            System.out.println("Maximum: " + max + "\n");
        try {
            
            Server obj = new Server();
            Hello stub = (Hello) UnicastRemoteObject.exportObject(obj, 0);
    
            
            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 1099);
            registry.bind("Hello", stub);
    
            System.err.println("Server is running");
            
        
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();}

        }
            


        static double estimatedCalories(String activity, int time){
            
                
    
                double calories = 0;
                if(activity.equals("sit")){
                    calories = 1.4;
                }
                else if(activity.equals("walk")){
                    calories = 5.4;
                }
                else if(activity.equals("jog")){
                    calories = 13.0;
                }
                else if(activity.equals("bike")){
                    calories = 6.8;
                }
                else if(activity.equals("swim")){
                    calories = 8.7;
                }
                    return calories*time;
            }
    
            static Scanner scan = new Scanner(System.in);
            static{
            System.out.println("What's your activity?");
            }
            static String activity = scan.next();
            static{ 
                System.out.println("What's your duration?");
            }
            static int duration = scan.nextInt();
            static{
                System.out.println("Calories expended: "+ estimatedCalories(activity, duration) + "\n");
            }
    
            
    
            public static double PickupMinutes(double[] customer, double[] driver1, double[] driver2, double[] driver3) {
            
                double distance1 = Math.abs(customer[0] - driver1[0]) + Math.abs(customer[1] - driver1[1]);
                double time1 = distance1 * 3.5;
                double minimumTime = time1;
                double distance2 = Math.abs(customer[0] - driver2[0]) + Math.abs(customer[1] - driver2[1]);
                double time2 = distance2 * 3.5;
        
                if (minimumTime > time2) {
                    minimumTime = time2;
                }
        
                double distance3 = Math.abs(customer[0] - driver3[0]) + Math.abs(customer[1] - driver3[1]);
                double time3 = distance2 * 3.5; 
        
                if (minimumTime > time3) {
                    minimumTime = time3;
                }
                return minimumTime;
                
            }
            
            {System.out.println("Enter 8 single digits for four x,y coordinates: ");}
            Scanner pickup = new Scanner(System.in);
            static double[] customer = new double[2]; static double[] driver1 = new double[2]; static double[] driver2 = new double[2]; static double[] driver3 = new double[2];{
            
            customer[0] = pickup.nextDouble(); customer[1] = pickup.nextDouble(); driver1[0] = pickup.nextDouble(); driver1[1] = pickup.nextDouble(); driver2[0] = pickup.nextDouble(); driver2[1] = pickup.nextDouble(); driver3[0] = pickup.nextDouble(); driver3[1] = pickup.nextDouble();
            
                System.out.printf("Pickup Time = %.2f min." + "\n", PickupMinutes(customer, driver1, driver2, driver3));
                System.out.printf("Attempting to start server..." + "\n");
            
        
        
    

        
    }

        
           

         
} 

  

    

         






