package socket;

import java.io.*;
import java.net.*;
import java.util.*;

public class MyClient{
    public static void main(String[] args){
        try{
            Socket s= new Socket("localhost",6666);

            DataOutputStream dout= new DataOutputStream(s.getOutputStream());
            Date date=new Date();

            dout.writeUTF(date.toString());
            dout.flush();

            dout.close();
            s.close();
        }
        catch(Exception e){
            System.out.println("The error is: "+e.getMessage());
        }
    }
}