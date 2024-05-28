package subnet;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get IP address and subnet mask from user
        System.out.print("Enter IP address (e.g., 192.168.1.0): ");
        String ipAddress = scanner.nextLine();

        System.out.print("Enter subnet mask (e.g., 255.255.255.0): ");
        String subnetMask = scanner.nextLine();

        System.out.print("Enter number of subnets: ");
        int numberOfSubnets = scanner.nextInt();

        scanner.close();

        // Calculate subnets
        calculateSubnets(ipAddress, subnetMask, numberOfSubnets);
    }

    public static void calculateSubnets(String ipAddress, String subnetMask, int numberOfSubnets) {
        int[] ip = parseIPAddress(ipAddress);
        int[] mask = parseIPAddress(subnetMask);

        int subnetBits = (int) Math.ceil(Math.log(numberOfSubnets) / Math.log(2));
        int newMaskBits = 32 - subnetBits;

        int[] newMask = new int[4];
        for (int i = 0; i < 4; i++) {
            if (newMaskBits >= 8) {
                newMask[i] = 255;
                newMaskBits -= 8;
            } else {
                newMask[i] = 256 - (int) Math.pow(2, 8 - newMaskBits);
                newMaskBits = 0;
            }
        }

        int subnets = (int) Math.pow(2, subnetBits);
        int increment = 256 - newMask[3];

        System.out.println("Subnets:");
        for (int i = 0; i < subnets; i++) {
            int[] subnetAddress = ip.clone();
            subnetAddress[3] += i * increment;
            System.out.println(i + 1 + ": " + formatIPAddress(subnetAddress));
        }
    }

    public static int[] parseIPAddress(String ipAddress) {
        String[] parts = ipAddress.split("\\.");
        int[] result = new int[4];
        for (int i = 0; i < 4; i++) {
            result[i] = Integer.parseInt(parts[i]);
        }
        return result;
    }

    public static String formatIPAddress(int[] ipAddress) {
        return ipAddress[0] + "." + ipAddress[1] + "." + ipAddress[2] + "." + ipAddress[3];
    }
}
