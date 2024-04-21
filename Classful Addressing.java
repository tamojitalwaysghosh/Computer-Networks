import java.util.Scanner;
public class Main
{
	public static int validIP(String[] ipArr){
	    int count=0;
	    int octet=0;
	    if(ipArr.length!=4){
	        return 0;
	    }
	    for(int i=0;i<ipArr.length;i++){
	        try{
	            octet=Integer.valueOf(ipArr[i]);
	        }
	        catch(NumberFormatException e){
	            System.out.println(e);
	            return 0;
	        }
	        //System.out.println(octet);
	        if(octet>=0 && octet<=255){
	            count++;
	        }else{
	            
	            return 0;
	        }
	    }
	    if(count==4){
	        return 1;
	    }
	    return 0;
	}
	
	public static String getClass(String[] ipArr){
	    int firstOctet=Integer.valueOf(ipArr[0]);
	    
	    if(firstOctet>=0 && firstOctet<=127){
	        return "A";
	    }
	    else if(firstOctet>=128 && firstOctet<=191){
	        return "B";
	    }
	    else if(firstOctet>=192 && firstOctet<=223){
	        return "C";
	    }
	    else if(firstOctet>=224 && firstOctet<=239){
	        return "D";
	    }
	    else{
	        return "E";
	    }
	}
	
	public static String getNetID(String[] ipArr, String netClass){
	    String netID="";
	    if(netClass=="A"){
	        netID=ipArr[0];
	    }
	    else if(netClass=="B"){
	        netID=ipArr[0]+"."+ipArr[1];
	    }
	    else{
	        netID=ipArr[0]+"."+ipArr[1]+"."+ipArr[2];
	    }
	    return netID;
	}
	
	public static String getHostID(String[] ipArr, String netClass){
	    String hostID="";
	    if(netClass=="A"){
	        hostID=ipArr[1]+"."+ipArr[2]+"."+ipArr[3];
	    }
	    else if(netClass=="B"){
	        hostID=ipArr[2]+"."+ipArr[3];
	    }
	    else{
	        hostID=ipArr[3];
	    }
	    return hostID;
	}
	
	public static void main(String[] args) {
	    Scanner scanner =new Scanner(System.in);
	    System.out.println("Enter your IPV4 address: ");
	    String ip=scanner.nextLine().trim();
	    String[] ipArr=ip.split("\\.");
	    int isValidIP=validIP(ipArr);
	   // System.out.println(ipArr);
	   // for(int i=0;i<ipArr.length;i++){
	   //     System.out.println(ipArr[i]);
	   // }
		if(isValidIP==1){
		    System.out.println("The given IPV4 address is: "+ip);
		}else{
		    System.out.println("Please enter a valid IP address");
		    return;
		}
		
		//define class
		String netClass=getClass(ipArr);
		System.out.println("The given IPV4 address belongs to class: "+netClass);
		
		if(netClass=="D" || netClass=="E"){
		    System.out.println("We cannot define Network ID or Host ID for this class");
		}
		else{
		    //define Network ID
		    String netID=getNetID(ipArr, netClass);
		    System.out.println("The Network ID: "+netID);
		    
		    //define Host ID
		    String hostID=getHostID(ipArr, netClass);
		    System.out.println("The Host ID: "+hostID);
		}
	}
}
