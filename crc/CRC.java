package crc;

import java.util.Arrays;

public class CRC {
    // CRC generator polynomial (example: CRC-8, x^8 + x^2 + x + 1 => 100000111)
    private static final String GENERATOR_POLYNOMIAL = "100000111";

    public static void main(String[] args) {
        String data = "11010011101100"; // Example data
        System.out.println("Original Data: " + data);

        String encodedData = encodeData(data, GENERATOR_POLYNOMIAL);
        System.out.println("Encoded Data with CRC: " + encodedData);

        boolean isValid = verifyData(encodedData, GENERATOR_POLYNOMIAL);
        System.out.println("Is the received data valid? " + isValid);
    }

    public static String encodeData(String data, String generator) {
        int dataLength = data.length();
        int generatorLength = generator.length();

        // Append zeros to the end of the data (equal to the length of the generator polynomial minus 1)
        String appendedData = data + "0".repeat(generatorLength - 1);

        // Perform division and get the remainder
        String remainder = performDivision(appendedData, generator);

        // Append the remainder to the original data
        return data + remainder;
    }

    public static boolean verifyData(String receivedData, String generator) {
        // Perform division on the received data
        String remainder = performDivision(receivedData, generator);

        // If the remainder is all zeros, then there is no error
        return remainder.equals("0".repeat(generator.length() - 1));
    }

    private static String performDivision(String dividend, String divisor) {
        int dividendLength = dividend.length();
        int divisorLength = divisor.length();

        // Convert strings to arrays for easier manipulation
        int[] dividendArray = Arrays.stream(dividend.split("")).mapToInt(Integer::parseInt).toArray();
        int[] divisorArray = Arrays.stream(divisor.split("")).mapToInt(Integer::parseInt).toArray();

        // Perform division using XOR
        for (int i = 0; i <= dividendLength - divisorLength; i++) {
            if (dividendArray[i] == 1) { // Only perform XOR if the bit is 1
                for (int j = 0; j < divisorLength; j++) {
                    dividendArray[i + j] ^= divisorArray[j];
                }
            }
        }

        // Extract the remainder from the dividend array
        StringBuilder remainder = new StringBuilder();
        for (int i = dividendLength - divisorLength + 1; i < dividendLength; i++) {
            remainder.append(dividendArray[i]);
        }

        return remainder.toString();
    }
}
