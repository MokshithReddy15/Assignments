package assignments;

import java.util.Scanner;

/**
 * Assignment 2: Palindrome Checker (3 Approaches)
 * Concepts: Iterative comparison, recursion, array reversal, string manipulation.
 */
public class PalindromeChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter text to check for palindrome: ");
        String input = scanner.nextLine().trim();
        
        System.out.println("\n--- Palindrome Verification Results ---");
        System.out.println("Input: \"" + input + "\"");
        
        boolean iterative = isPalindromeIterative(input);
        boolean recursive = isPalindromeRecursive(input);
        boolean arrayReversal = isPalindromeArrayReversal(input);
        
        System.out.println("Iterative Approach:     " + (iterative ? "Palindrome" : "Not Palindrome"));
        System.out.println("Recursive Approach:     " + (recursive ? "Palindrome" : "Not Palindrome"));
        System.out.println("Array Reversal Approach:" + (arrayReversal ? "Palindrome" : "Not Palindrome"));
        
        boolean allAgree = (iterative == recursive) && (recursive == arrayReversal);
        System.out.println("\nAll three approaches agree: " + (allAgree ? "Yes" : "No"));
        
        scanner.close();
    }

    /**
     * Approach 1: Iterative comparison - compare characters from both ends moving toward middle.
     */
    public static boolean isPalindromeIterative(String text) {
        String cleaned = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int left = 0;
        int right = cleaned.length() - 1;
        
        while (left < right) {
            if (cleaned.charAt(left) != cleaned.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /**
     * Approach 2: Recursive check - recursively compare first and last characters.
     */
    public static boolean isPalindromeRecursive(String text) {
        String cleaned = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        return isPalindromeRecursiveHelper(cleaned, 0, cleaned.length() - 1);
    }

    private static boolean isPalindromeRecursiveHelper(String text, int left, int right) {
        if (left >= right) {
            return true;
        }
        if (text.charAt(left) != text.charAt(right)) {
            return false;
        }
        return isPalindromeRecursiveHelper(text, left + 1, right - 1);
    }

    /**
     * Approach 3: Array reversal - convert to char array, reverse, and compare.
     */
    public static boolean isPalindromeArrayReversal(String text) {
        String cleaned = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        char[] charArray = cleaned.toCharArray();
        char[] reversedArray = new char[charArray.length];
        
        for (int i = 0; i < charArray.length; i++) {
            reversedArray[i] = charArray[charArray.length - 1 - i];
        }
        
        String reversed = new String(reversedArray);
        return cleaned.equals(reversed);
    }
}