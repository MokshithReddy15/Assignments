package assignments;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Assignment 4: First Non-Repeating Character
 * Concepts: Character frequency counting, HashMap, early-exit scanning.
 */
public class FirstNonRepeatingCharacter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a word or sentence: ");
        String input = scanner.nextLine();
        
        char result = findFirstNonRepeatingChar(input);
        
        if (result != '\0') {
            System.out.println("First Non-Repeating Character: '" + result + "'");
        } else {
            System.out.println("No Non-Repeating Character Found");
        }
        
        scanner.close();
    }

    /**
     * Finds the first character that appears exactly once in the string.
     * Returns '\0' (null character) if no such character exists.
     */
    public static char findFirstNonRepeatingChar(String text) {
        if (text == null || text.isEmpty()) {
            return '\0';
        }
        
        // Count frequency of each character
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : text.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
        
        // Scan left to right to find first character with frequency 1
        for (char c : text.toCharArray()) {
            if (frequencyMap.get(c) == 1) {
                return c;
            }
        }
        
        return '\0'; // No non-repeating character found
    }
}