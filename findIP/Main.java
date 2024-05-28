package findIP;

import java.net.*;

public class Main{
    public static void main(String[] args){
        try{
            InetAddress local= InetAddress.getLocalHost();

            System.out.println("The local IP is: "+ local.getHostAddress());

            InetAddress remote= InetAddress.getByName("www.google.com");

            System.out.println("The remote IP of Google is: "+ remote.getHostAddress());
        }
        catch(Exception e){
            System.out.println("The exception is: "+e.getMessage());
        }
    }
}