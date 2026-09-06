package assignments;

import java.util.Random;
import java.util.Scanner;

/**
 * Assignment 1: Rock-Paper-Scissors Game
 * Concepts: Random number generation, loops, conditional logic, formatted output.
 */
public class RockPaperScissors {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rounds = 5;
        String[] playerMoves = new String[rounds];
        String[] computerMoves = new String[rounds];
        String[] results = new String[rounds];
        
        int wins = 0, losses = 0, draws = 0;

        System.out.println("--- Rock-Paper-Scissors Game (5 Rounds) ---");
        for (int i = 0; i < rounds; i++) {
            System.out.print("Round " + (i + 1) + " - Enter your move (Rock, Paper, Scissors): ");
            String playerMove = scanner.nextLine().trim();
            String computerMove = generateComputerMove();
            
            String result = playRound(playerMove, computerMove);
            
            playerMoves[i] = playerMove;
            computerMoves[i] = computerMove;
            results[i] = result;

            if (result.equals("Player Wins")) wins++;
            else if (result.equals("Computer Wins")) losses++;
            else draws++;

            System.out.println(result);
        }

        printSummary(rounds, playerMoves, computerMoves, results, wins, losses, draws);
        scanner.close();
    }

    public static String generateComputerMove() {
        String[] moves = {"Rock", "Paper", "Scissors"};
        return moves[new Random().nextInt(3)];
    }

    public static String playRound(String playerMove, String computerMove) {
        if (playerMove.equalsIgnoreCase(computerMove)) return "Draw";
        
        switch (playerMove.toLowerCase()) {
            case "rock":
                return computerMove.equals("Scissors") ? "Player Wins" : "Computer Wins";
            case "paper":
                return computerMove.equals("Rock") ? "Player Wins" : "Computer Wins";
            case "scissors":
                return computerMove.equals("Paper") ? "Player Wins" : "Computer Wins";
            default:
                return "Invalid Move (Computer Wins by default)";
        }
    }

    public static void printSummary(int rounds, String[] pMoves, String[] cMoves, String[] results, int w, int l, int d) {
        System.out.println("\nFinal Summary Table:");
        System.out.printf("%-10s | %-12s | %-15s | %-15s\n", "Round", "Player Move", "Computer Move", "Result");
        System.out.println("---------------------------------------------------------------");
        for (int i = 0; i < rounds; i++) {
            System.out.printf("%-10d | %-12s | %-15s | %-15s\n", (i + 1), pMoves[i], cMoves[i], results[i]);
        }
        
        double winPercentage = ((double) w / rounds) * 100;
        System.out.printf("\nWins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%\n", w, l, d, winPercentage);
    }
}
