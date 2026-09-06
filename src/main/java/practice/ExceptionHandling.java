package practice;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Practice Problems: Java Exceptions (Concepts 9-13)
 * Covers: Exception Hierarchy, Types, Checked vs Unchecked, RuntimeException
 */
public class ExceptionHandling {

    public static void main(String[] args) {
        System.out.println("=== Exception Handling Practice ===\n");
        
        // 1. Exception Hierarchy Demonstration
        demonstrateExceptionHierarchy();
        
        // 2. Unchecked Exceptions (RuntimeException)
        demonstrateUncheckedExceptions();
        
        // 3. Checked Exceptions
        demonstrateCheckedExceptions();
        
        // 4. Custom Exception Handling with try-catch-finally
        demonstrateTryCatchFinally();
        
        // 5. Multiple catch blocks and exception propagation
        demonstrateMultipleCatch();
    }

    /**
     * Concept 10: Exception Hierarchy
     * java.lang.Object -> java.lang.Throwable -> java.lang.Exception / java.lang.Error
     */
    public static void demonstrateExceptionHierarchy() {
        System.out.println("--- 1. Exception Hierarchy ---");
        System.out.println("java.lang.Object");
        System.out.println("  └── java.lang.Throwable");
        System.out.println("        ├── java.lang.Error (Unchecked, serious system issues)");
        System.out.println("        │     ├── OutOfMemoryError");
        System.out.println("        │     ├── StackOverflowError");
        System.out.println("        │     └── ...");
        System.out.println("        └── java.lang.Exception");
        System.out.println("              ├── java.lang.RuntimeException (Unchecked)");
        System.out.println("              │     ├── NullPointerException");
        System.out.println("              │     ├── ArrayIndexOutOfBoundsException");
        System.out.println("              │     ├── ArithmeticException");
        System.out.println("              │     ├── NumberFormatException");
        System.out.println("              │     └── ...");
        System.out.println("              └── Checked Exceptions (Compile-time checked)");
        System.out.println("                    ├── IOException");
        System.out.println("                    ├── FileNotFoundException");
        System.out.println("                    ├── ClassNotFoundException");
        System.out.println("                    └── ...");
        System.out.println();
    }

    /**
     * Concept 11 & 12: Unchecked Exceptions / RuntimeException
     * These are not checked at compile-time
     */
    public static void demonstrateUncheckedExceptions() {
        System.out.println("--- 2. Unchecked Exceptions (RuntimeException) ---");
        
        // NullPointerException
        try {
            String str = null;
            System.out.println("Length: " + str.length());
        } catch (NullPointerException e) {
            System.out.println("Caught NullPointerException: " + e.getMessage());
        }
        
        // ArrayIndexOutOfBoundsException
        try {
            int[] arr = {1, 2, 3};
            System.out.println("Element at index 5: " + arr[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught ArrayIndexOutOfBoundsException: " + e.getMessage());
        }
        
        // ArithmeticException
        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Caught ArithmeticException: " + e.getMessage());
        }
        
        // NumberFormatException
        try {
            int num = Integer.parseInt("abc");
        } catch (NumberFormatException e) {
            System.out.println("Caught NumberFormatException: " + e.getMessage());
        }
        
        // InputMismatchException (Scanner)
        try {
            Scanner scanner = new Scanner("hello");
            int num = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Caught InputMismatchException: " + e.getMessage());
        }
        
        System.out.println("Note: These are all subclasses of RuntimeException (Unchecked)\n");
    }

    /**
     * Concept 13: Checked Exceptions
     * These MUST be caught or declared in method signature (throws)
     */
    public static void demonstrateCheckedExceptions() {
        System.out.println("--- 3. Checked Exceptions (Compile-time checked) ---");
        
        // FileNotFoundException - must be handled
        try {
            File file = new File("nonexistent.txt");
            FileReader reader = new FileReader(file);
        } catch (FileNotFoundException e) {
            System.out.println("Caught FileNotFoundException (Checked): " + e.getMessage());
        }
        
        // Demonstrate method that throws checked exception
        try {
            readFileWithThrows("missing.txt");
        } catch (FileNotFoundException e) {
            System.out.println("Caught from method with throws: " + e.getMessage());
        }
        
        System.out.println("Note: Checked exceptions must be caught or declared with 'throws'\n");
    }

    /**
     * Method that declares checked exception in signature
     */
    public static void readFileWithThrows(String filename) throws FileNotFoundException {
        File file = new File(filename);
        FileReader reader = new FileReader(file);
        reader.close();
    }

    /**
     * Demonstrates try-catch-finally block
     */
    public static void demonstrateTryCatchFinally() {
        System.out.println("--- 4. Try-Catch-Finally Block ---");
        
        FileReader reader = null;
        try {
            File file = new File("test.txt");
            reader = new FileReader(file);
            System.out.println("File opened successfully");
        } catch (FileNotFoundException e) {
            System.out.println("Catch block: File not found - " + e.getMessage());
        } finally {
            System.out.println("Finally block: Always executes (cleanup code here)");
            try {
                if (reader != null) reader.close();
            } catch (Exception e) {
                System.out.println("Error closing reader: " + e.getMessage());
            }
        }
        System.out.println();
    }

    /**
     * Demonstrates multiple catch blocks and exception propagation
     */
    public static void demonstrateMultipleCatch() {
        System.out.println("--- 5. Multiple Catch Blocks ---");
        
        String[] testInputs = {"10", "abc", "0"};
        
        for (String input : testInputs) {
            try {
                int number = Integer.parseInt(input);
                int result = 100 / number;
                System.out.println("Input: " + input + " -> 100 / " + number + " = " + result);
            } catch (NumberFormatException e) {
                System.out.println("Input: " + input + " -> NumberFormatException: Not a valid integer");
            } catch (ArithmeticException e) {
                System.out.println("Input: " + input + " -> ArithmeticException: Cannot divide by zero");
            }
        }
        
        System.out.println("\n--- Exception Propagation ---");
        System.out.println("Exceptions propagate up the call stack until caught.");
        System.out.println("If not caught, they terminate the thread (and print stack trace).");
    }
}