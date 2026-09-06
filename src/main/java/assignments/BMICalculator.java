package assignments;

import java.util.Random;

/**
 * Assignment 3: BMI Calculator for a Team
 * Concepts: Parallel arrays, arithmetic operations, conditional logic, formatted tabular output.
 */
public class BMICalculator {

    public static void main(String[] args) {
        int teamSize = 10;
        double[] heights = new double[teamSize];
        double[] weights = new double[teamSize];
        
        generateRandomTeamData(heights, weights);
        printWellnessReport(heights, weights);
    }

    /**
     * Generates random height and weight data for demo purposes.
     * Heights: 1.50m - 2.00m, Weights: 50kg - 110kg
     */
    public static void generateRandomTeamData(double[] heights, double[] weights) {
        Random random = new Random();
        for (int i = 0; i < heights.length; i++) {
            heights[i] = 1.50 + random.nextDouble() * 0.50; // 1.50 to 2.00
            weights[i] = 50 + random.nextDouble() * 60;       // 50 to 110
        }
    }

    /**
     * Computes BMI = weight / (height × height).
     */
    public static double calculateBMI(double height, double weight) {
        return weight / (height * height);
    }

    /**
     * Classifies BMI status based on standard ranges.
     */
    public static String getBmiStatus(double bmi) {
        if (bmi < 18.5) return "Underweight";
        else if (bmi < 25.0) return "Normal";
        else if (bmi < 30.0) return "Overweight";
        else return "Obese";
    }

    /**
     * Prints the wellness report in a formatted table.
     */
    public static void printWellnessReport(double[] heights, double[] weights) {
        System.out.println("--- Corporate Wellness Program Report ---");
        System.out.printf("%-10s | %-12s | %-12s | %-8s | %-12s\n", "Person", "Height (m)", "Weight (kg)", "BMI", "Status");
        System.out.println("---------------------------------------------------------------");
        
        for (int i = 0; i < heights.length; i++) {
            double bmi = calculateBMI(heights[i], weights[i]);
            String status = getBmiStatus(bmi);
            System.out.printf("%-10d | %-12.2f | %-12.1f | %-8.2f | %-12s\n", 
                (i + 1), heights[i], weights[i], bmi, status);
        }
    }
}