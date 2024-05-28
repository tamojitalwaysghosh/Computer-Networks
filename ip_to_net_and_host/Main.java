package ip_to_net_and_host;

import java.util.*;

public class Main{
    public static int validateIP(String[] ip){
        if(ip.length==4){
            for(int i=0;i<ip.length;i++){
                if(Integer.valueOf(ip[i])>=0 && Integer.valueOf(ip[i])<=255){
                    continue;
                }
                else{
                    return 0;
                }
            }
        }else{
            return 0;
        }

        return 1;
    }

    public static char findClass(String s){
        int first_octet=Integer.valueOf(s);

        if(first_octet>=0 && first_octet<=123){
            return 'A';
        }
        else if(first_octet>=124 && first_octet<=191){
            return 'B';
        }
        else if(first_octet>=192 && first_octet<=223){
            return 'C';
        }
        else if(first_octet>=223 && first_octet<=239){
            return 'D';
        }

        return 'E';
    }

    public static void main(String[] args){
        Scanner scanner= new Scanner(System.in);

        System.out.print("Please enter an IP address: ");
        String ip= scanner.nextLine();

        String[] ipArr= ip.split("\\.");

        if(validateIP(ipArr)==1){
            System.out.println("The given IP address is: "+ip);
        }
        else{
            System.out.println("Please enter a valid IP address!");
            return;
        }

        char c= findClass(ipArr[0]);
        System.out.println("The given IP: "+ip+" belongs to class "+c);

        if(c=='A'){
            System.out.println("The Network ID of the given IP address is: "+ipArr[0]+"."+ipArr[1]+"."+ipArr[2]);
            System.out.println("The Host ID of the given IP address is: "+ipArr[3]);
        }
        else if(c=='B'){
            System.out.println("The Network ID of the given IP address is: "+ipArr[0]+"."+ipArr[1]);
            System.out.println("The Host ID of the given IP address is: "+ipArr[2]+"."+ipArr[3]);
        }
        else if(c== 'C'){
            System.out.println("The Network ID of the given IP address is: "+ipArr[0]);
            System.out.println("The Host ID of the given IP address is: "+ipArr[1]+"."+ipArr[2]+"."+ipArr[3]);
        }
        else {
            System.out.println("Classfull Addressing not possible for class "+c);
        }

        scanner.close();
    }
}