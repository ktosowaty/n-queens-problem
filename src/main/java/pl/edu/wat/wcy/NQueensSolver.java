package pl.edu.wat.wcy;

import java.util.ArrayList;
import java.util.List;

public class NQueensSolver {
    private int[][] board;

    public NQueensSolver(int boardSize) {
        board = new int[boardSize][boardSize];
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                board[i][j] = 0;
            }
        }
    }

    public void solve() {
        if (placeQueens(0, null)) {
            printBoard();
        } else {
            System.out.println("Solution not found.");
        }
    }

    private void printBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(" " + board[i][j]);
            }
            System.out.println();
        }
    }

    private boolean placeQueens(int column, Placement previousPlacement) {
        if (column == board.length) {
            return true;
        }
        List<Placement> possiblePlacements = getPossiblePlacements(column, previousPlacement);
        possiblePlacements.sort((o1, o2) -> Double.compare(o2.getFunctionValue(), o1.getFunctionValue()));
        for (Placement placement : possiblePlacements) {
            int row = placement.getRow();
            if (canPlaceQueen(row, column)) {
                board[row][column] = 1;
                if (placeQueens(column + 1, placement)) {
                    return true;
                }
                board[row][column] = 0;
            }
        }
        return false;
    }

    private List<Placement> getPossiblePlacements(int column, Placement previousPlacement) {
        List<Placement> possiblePlacements = new ArrayList<>();
        for (int currentRow = 0; currentRow < board.length; currentRow++) {
            Placement placement = new Placement(currentRow, column, -1.0);
            int isAttacked = canPlaceQueen(currentRow, column) ? 1 : 0;
            int previousRow = -1;
            int previousDirection = 1;
            if (previousPlacement != null) {
                previousRow = previousPlacement.getRow();
                previousDirection = previousPlacement.getDirection();
            }
            int directionIndicator = 0;
            if (currentRow - previousRow > 0) {
                placement.setDirection(1);
                if (previousDirection == 1) {
                    directionIndicator = 1;
                } else {
                    directionIndicator = -1;
                }
            } else if (currentRow - previousRow < 0) {
                placement.setDirection(-1);
                if (previousDirection == -1) {
                    directionIndicator = 1;
                } else {
                    directionIndicator = -1;
                }
            }
            double functionValue = isAttacked * (previousRow - currentRow + board.length + directionIndicator);
            placement.setFunctionValue(functionValue);
            possiblePlacements.add(placement);
        }
        return possiblePlacements;
    }

    private boolean canPlaceQueen(int row, int column) {
        for (int i = 0; i < column; i++) {
            if (board[row][i] == 1) {
                return false;
            }
        }
        for (int i = row, j = column; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        for (int i = row, j = column; i < board.length && j >= 0; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        return true;
    }

}
