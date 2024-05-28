package bi_socket;

import java.net.*;  
import java.io.*;  

class MyServer{  
    public static void main(String args[]){  
        try{
            ServerSocket ss= new ServerSocket(6666);
            System.out.println("Connection requested");
            Socket s= ss.accept();
            System.out.println("Connected to client!");

            DataOutputStream dout= new DataOutputStream(s.getOutputStream());
            DataInputStream dis= new DataInputStream(s.getInputStream()); 
            BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
// System.in: System.in is the standard input stream, typically associated with keyboard input.
// InputStreamReader: InputStreamReader is a bridge from byte streams to character streams. It reads bytes and decodes them into characters using a specified charset. The default charset is used if none is specified.
// BufferedReader: BufferedReader wraps the InputStreamReader to buffer the input, making the reading process more efficient and providing the readLine() method.

            String str1="";
            String str2="";

            while(!str2.equals("stop")){
                //let client say
                str2=(String)dis.readUTF();
                System.out.println("The Client says: "+str2);
                if (str2.equals("stop")) {  // If client sends "stop", break the loop
                    break;
                }

                //server will speak
                //System.out.print("The Server says: ");
                //str1=br.readLine();
                str1= str2.toUpperCase();
                dout.writeUTF(str1);
                //send it
                dout.flush();
            }

            
            //close
            dout.close();
            dis.close();
            ss.close();
            s.close();
        }
        catch(Exception e){
            System.out.println("The exception is: "+e.getMessage());
        }
    }
}  