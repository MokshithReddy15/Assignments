package assignments;

import java.util.Scanner;

/**
 * Assignment 5: Reverse Customer Name
 * Concepts: String traversal, character array manipulation, string reconstruction.
 */
public class ReverseCustomerName {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter customer name: ");
        String customerName = scanner.nextLine();
        
        String reversedName = reverseCustomerName(customerName);
        
        System.out.println("Original Name: " + customerName);
        System.out.println("Reversed Name: " + reversedName);
        
        scanner.close();
    }

    /**
     * Reverses the given customer name.
     * 
     * @param customerName The original customer name
     * @return The name in reverse order
     */
    public static String reverseCustomerName(String customerName) {
        if (customerName == null) {
            return "";
        }
        
        char[] charArray = customerName.toCharArray();
        char[] reversedArray = new char[charArray.length];
        
        for (int i = 0; i < charArray.length; i++) {
            reversedArray[i] = charArray[charArray.length - 1 - i];
        }
        
        return new String(reversedArray);
    }
}