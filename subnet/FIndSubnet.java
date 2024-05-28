package subnet;

import java.util.*;

public class FindSubnet{
    public static void main(String[] args){
        Scanner scanner= new Scanner(System.in);

        System.out.print("Enter the IP Address: ");
        String ip= scanner.nextLine();

        System.out.print("Enter the Block Number: ");
        int block= scanner.nextInt();

        System.out.println("Entered IP Address is: "+ ip+"/"+block);

        System.out.print("Enter the number of subnets you want to divide to: ");
        int subnets= scanner.nextInt();

        int multiple=0;

        while(Math.pow(2,multiple)<subnets){
            multiple++;
        }

        int inc_bits= 32-(block+multiple);

        if(inc_bits<=0){
            System.out.println("Not possible to divide");
            return;
        }

        String[] ipArr= ip.split("\\.");

        String three_octet=ipArr[0]+"."+ipArr[1]+"."+ipArr[2];

        System.out.println("We need to borrow: "+multiple+" bits from the host ID");

        int increment= (int)Math.pow(2, inc_bits);

        int base=0;

        while(base+increment<=256){
            System.out.println(three_octet+"."+base);
            base+=increment;
        }
    }
}