package practice;

/**
 * Practice Problems: ASCII Character Codes
 * Concept 8 from the practice list
 */
public class ASCIICharacterCodes {

    public static void main(String[] args) {
        System.out.println("=== ASCII Character Codes Demo ===\n");
        
        // 1. Print ASCII table for printable characters (32-126)
        printASCIITable();
        
        // 2. Convert between char and int
        demonstrateCharIntConversion();
        
        // 3. Character classification using ASCII ranges
        demonstrateCharacterClassification();
    }

    /**
     * Prints ASCII table for printable characters
     */
    public static void printASCIITable() {
        System.out.println("--- ASCII Printable Characters (32-126) ---");
        System.out.printf("%-6s | %-6s | %-6s\n", "Dec", "Hex", "Char");
        System.out.println("----------------------------");
        
        for (int i = 32; i <= 126; i++) {
            char c = (char) i;
            String charDisplay = (i == 32) ? "SPACE" : (i == 127 ? "DEL" : String.valueOf(c));
            System.out.printf("%-6d | 0x%-4X | %-6s\n", i, i, charDisplay);
            
            // Add spacing every 16 characters for readability
            if ((i - 31) % 16 == 0 && i != 126) {
                System.out.println();
            }
        }
    }

    /**
     * Demonstrates conversion between char and int (ASCII values)
     */
    public static void demonstrateCharIntConversion() {
        System.out.println("\n--- Char to Int (ASCII) Conversion ---");
        
        char[] samples = {'A', 'a', '0', ' ', '@', '#', '\n', '\t'};
        
        for (char c : samples) {
            int ascii = (int) c;
            String desc = getCharDescription(c);
            System.out.printf("Char: '%s' | ASCII: %3d | Hex: 0x%02X | %s\n", 
                (c == ' ' ? "SPACE" : (c == '\n' ? "\\n" : (c == '\t' ? "\\t" : String.valueOf(c)))),
                ascii, ascii, desc);
        }
        
        // Converting int back to char
        System.out.println("\n--- Int to Char Conversion ---");
        int[] codes = {65, 97, 48, 32, 64, 35, 10, 9};
        for (int code : codes) {
            char c = (char) code;
            System.out.printf("ASCII %3d -> Char: '%s'\n", code, 
                (c == ' ' ? "SPACE" : (c == '\n' ? "\\n" : (c == '\t' ? "\\t" : String.valueOf(c)))));
        }
    }

    /**
     * Demonstrates character classification using ASCII ranges
     */
    public static void demonstrateCharacterClassification() {
        System.out.println("\n--- Character Classification via ASCII ---");
        
        String test = "Hello World! 123 @#$";
        int upper = 0, lower = 0, digit = 0, space = 0, special = 0;
        
        for (char c : test.toCharArray()) {
            int ascii = (int) c;
            if (ascii >= 65 && ascii <= 90) upper++;
            else if (ascii >= 97 && ascii <= 122) lower++;
            else if (ascii >= 48 && ascii <= 57) digit++;
            else if (ascii == 32 || ascii == 9 || ascii == 10 || ascii == 13) space++;
            else special++;
        }
        
        System.out.println("Input: \"" + test + "\"");
        System.out.println("Uppercase (65-90): " + upper);
        System.out.println("Lowercase (97-122): " + lower);
        System.out.println("Digits (48-57): " + digit);
        System.out.println("Whitespace: " + space);
        System.out.println("Special chars: " + special);
    }

    private static String getCharDescription(char c) {
        int ascii = (int) c;
        if (ascii >= 65 && ascii <= 90) return "Uppercase Letter";
        if (ascii >= 97 && ascii <= 122) return "Lowercase Letter";
        if (ascii >= 48 && ascii <= 57) return "Digit";
        if (ascii >= 33 && ascii <= 47 || ascii >= 58 && ascii <= 64 || 
            ascii >= 91 && ascii <= 96 || ascii >= 123 && ascii <= 126) return "Special Character";
        if (ascii == 32) return "Space";
        if (ascii == 9) return "Tab";
        if (ascii == 10) return "Newline (LF)";
        if (ascii == 13) return "Carriage Return (CR)";
        return "Control Character";
    }
}