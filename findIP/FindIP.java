package findIP;

import java.net.*;

public class FindIP{
    public static void main(String[] args){
        try{
            InetAddress myAdd= InetAddress.getLocalHost();
            System.out.println(myAdd.getHostAddress());

            InetAddress remote=InetAddress.getByName("www.microsoft.com");
            System.out.println(remote.getHostAddress());
        }
        catch(Exception e){
            System.out.println("The exception is: "+e.getMessage());
        }
    }
}