package bi_socket;

import java.net.*;
import java.io.*;

public class MyS{
    public static void main(String[] args){
        try{
            ServerSocket ss= new ServerSocket(6666);
            Socket s= ss.accept();
            System.out.println("Connected to client!");

            DataOutputStream dout= new DataOutputStream(s.getOutputStream());
            DataInputStream dis= new DataInputStream(s.getInputStream());
            BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

            String s1="";
            String s2="";

            while(!s2.equals("stop")){
                //let client say
                s2=(String) dis.readUTF();
                System.out.println("The client told: "+s2);
                if(s2.equals("stop")){
                    break;
                }

                //let server say
                System.out.print("The server says: ");
                s1= br.readLine();
                dout.writeUTF(s1);

                //send
                dout.flush();
            }
        }
        catch(Exception e){
            System.out.print("The exception is: "+e.getMessage());
        }
    }
}