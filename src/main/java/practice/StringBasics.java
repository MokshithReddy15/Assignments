package practice;

/**
 * Practice Problems: Java Strings - Creation, Escape Sequences, Input, Arrays, Methods
 * Covers concepts: 1-7 from the practice list
 */
public class StringBasics {

    public static void main(String[] args) {
        // Problem 1: Creating Strings in different ways
        System.out.println("=== Problem 1: Creating Strings ===");
        demonstrateStringCreation();
        
        // Problem 2: Escape Sequences
        System.out.println("\n=== Problem 2: Escape Sequences ===");
        demonstrateEscapeSequences();
        
        // Problem 3: String Arrays
        System.out.println("\n=== Problem 3: String Arrays ===");
        demonstrateStringArrays();
        
        // Problem 4: Strings as Method Parameters
        System.out.println("\n=== Problem 4: Strings as Method Parameters ===");
        String greeting = "Hello";
        String name = "Student";
        printGreeting(greeting, name);
        
        // Problem 5: String Built-in Methods
        System.out.println("\n=== Problem 5: String Built-in Methods ===");
        demonstrateStringMethods();
    }

    /**
     * Demonstrates different ways to create Strings
     */
    public static void demonstrateStringCreation() {
        // String literal
        String str1 = "Java";
        
        // Using new keyword
        String str2 = new String("Java");
        
        // From character array
        char[] chars = {'J', 'a', 'v', 'a'};
        String str3 = new String(chars);
        
        // From byte array (ASCII)
        byte[] bytes = {74, 97, 118, 97};
        String str4 = new String(bytes);
        
        System.out.println("String literal: " + str1);
        System.out.println("Using new String(): " + str2);
        System.out.println("From char array: " + str3);
        System.out.println("From byte array: " + str4);
        System.out.println("str1 == str2 (reference): " + (str1 == str2));
        System.out.println("str1.equals(str2) (content): " + str1.equals(str2));
    }

    /**
     * Demonstrates escape sequences in Java strings
     */
    public static void demonstrateEscapeSequences() {
        String path = "C:\\Users\\Documents\\file.txt";  // Backslash
        String quote = "He said, \"Java is fun!\"";      // Double quote
        String tab = "Column1\tColumn2\tColumn3";        // Tab
        String newline = "Line 1\nLine 2\nLine 3";       // Newline
        String backspace = "Java\bScript";               // Backspace (removes 'a')
        String unicode = "\u004A\u0061\u0076\u0061";    // Unicode for "Java"
        
        System.out.println("File path: " + path);
        System.out.println("With quotes: " + quote);
        System.out.println("With tabs: " + tab);
        System.out.println("With newlines:");
        System.out.println(newline);
        System.out.println("Backspace demo: " + backspace);
        System.out.println("Unicode: " + unicode);
    }

    /**
     * Demonstrates String arrays
     */
    public static void demonstrateStringArrays() {
        // Declaration and initialization
        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        
        // Accessing elements
        System.out.println("First day: " + days[0]);
        System.out.println("Last day: " + days[days.length - 1]);
        
        // Iterating
        System.out.print("All days: ");
        for (String day : days) {
            System.out.print(day + " ");
        }
        System.out.println();
        
        // Modifying
        days[0] = "Mon";
        System.out.println("Modified first day: " + days[0]);
        
        // Array length
        System.out.println("Number of days: " + days.length);
    }

    /**
     * Demonstrates passing Strings as method parameters
     */
    public static void printGreeting(String greeting, String name) {
        System.out.println(greeting + ", " + name + "!");
        System.out.println("Method received greeting: '" + greeting + "' and name: '" + name + "'");
    }

    /**
     * Demonstrates commonly used String built-in methods
     */
    public static void demonstrateStringMethods() {
        String text = "  Hello Java World  ";
        
        System.out.println("Original: '" + text + "'");
        System.out.println("trim(): '" + text.trim() + "'");
        System.out.println("toUpperCase(): '" + text.toUpperCase() + "'");
        System.out.println("toLowerCase(): '" + text.toLowerCase() + "'");
        System.out.println("length(): " + text.length());
        System.out.println("charAt(3): '" + text.charAt(3) + "'");
        System.out.println("substring(2, 7): '" + text.substring(2, 7) + "'");
        System.out.println("indexOf('Java'): " + text.indexOf("Java"));
        System.out.println("contains('World'): " + text.contains("World"));
        System.out.println("replace('Java', 'Python'): '" + text.replace("Java", "Python") + "'");
        System.out.println("startsWith('  He'): " + text.startsWith("  He"));
        System.out.println("endsWith('ld  '): " + text.endsWith("ld  "));
        
        // Splitting
        String csv = "apple,banana,orange,grape";
        String[] fruits = csv.split(",");
        System.out.print("split(',') result: ");
        for (String fruit : fruits) {
            System.out.print(fruit + " ");
        }
        System.out.println();
    }
}