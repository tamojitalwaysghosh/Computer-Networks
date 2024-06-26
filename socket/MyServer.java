package socket;

import java.io.*;
import java.net.*;

public class MyServer{
    public static void main(String[] args){
        try{
            ServerSocket ss= new ServerSocket(6666);

            Socket s= ss.accept();

            DataInputStream dis= new DataInputStream(s.getInputStream());

            String str= (String) dis.readUTF();
            System.out.println("The receive data is: "+str);

            s.close();
        }
        catch(Exception e){
            System.out.println("The error is: "+e.getMessage());
        }
    }
}