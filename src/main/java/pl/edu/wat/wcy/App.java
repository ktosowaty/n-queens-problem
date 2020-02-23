package pl.edu.wat.wcy;

import java.util.Scanner;

public class App {

    private static final int DEFAULT_BOARD_SIZE = 8;

    public static void main(String[] args) {
        int boardSize = getBoardSize();
        NQueensSolver solver = new NQueensSolver(boardSize);
        solver.solve();
    }

    private static int getBoardSize() {
        System.out.print("Enter the board size (n*n): ");
        try (Scanner scanner = new Scanner(System.in)) {
            String input = scanner.next();
            int size = Integer.parseInt(input);
            if (size < 4) {
                System.out.println("Board size should be at least 4. Getting default value instead (8x8).");
                return DEFAULT_BOARD_SIZE;
            }
            return size;
        } catch (NumberFormatException e) {
            e.printStackTrace();
            System.out.println("Wrong board size, getting default value instead (8x8).");
            return DEFAULT_BOARD_SIZE;
        }
    }

}
