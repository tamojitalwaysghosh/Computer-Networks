import java.util.Scanner;

public class ClasslessAddress {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the IP address in CIDR notation (e.g., 192.168.1.0/24): ");
        String ipAddress = scanner.nextLine();

        // Splitting the input into IP address and subnet mask
        String[] parts = ipAddress.split("/");
        String ip = parts[0];
        int subnetMask = Integer.parseInt(parts[1]);

        // Convert IP address to binary
        String[] ipAddressParts = ip.split("\\.");
        StringBuilder binaryIp = new StringBuilder();
        for (String part : ipAddressParts) {
            String binaryPart = Integer.toBinaryString(Integer.parseInt(part));
            // Append leading zeros if necessary
            while (binaryPart.length() < 8) {
                binaryPart = "0" + binaryPart;
            }
            binaryIp.append(binaryPart);
        }

        // Calculate network ID and host ID
        String networkId = binaryIp.substring(0, subnetMask);
        String hostId = binaryIp.substring(subnetMask);

        // Convert network ID and host ID back to decimal
        StringBuilder decimalNetworkId = new StringBuilder();
        StringBuilder decimalHostId = new StringBuilder();
        for (int i = 0; i < 32; i += 8) {
            decimalNetworkId.append(Integer.parseInt(networkId.substring(i, i + 8), 2)).append(".");
            decimalHostId.append(Integer.parseInt(hostId.substring(i, i + 8), 2)).append(".");
        }

        // Output results
        System.out.println("Network ID: " + decimalNetworkId.substring(0, decimalNetworkId.length() - 1));
        System.out.println("Host ID: " + decimalHostId.substring(0, decimalHostId.length() - 1));

        scanner.close();
    }
}
