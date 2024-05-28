package bi_socket;

import java.net.*;
import java.io.*;

public class MyC{
    public static void main(String[] args){
        try{
            Socket s= new Socket("localhost",6666);
            System.out.println("Connected to server!");

            DataOutputStream dout= new DataOutputStream(s.getOutputStream());
            DataInputStream dis= new DataInputStream(s.getInputStream());
            BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

            String s1="";
            String s2="";

            while(!s2.equals("stop")){
                //let client say
                System.out.print("The client says: ");
                s1= br.readLine();
                dout.writeUTF(s1);

                //send
                dout.flush();

                //let server say
                s2=(String) dis.readUTF();
                System.out.println("The server told: "+s2);
                if(s2.equals("stop")){
                    break;
                }
            }
        }
        catch(Exception e){
            System.out.print("The exception is: "+e.getMessage());
        }
    }
}