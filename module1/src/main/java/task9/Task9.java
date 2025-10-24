package task9;

import java.util.Scanner;

public class Task9 {
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Игра: Крестики-нолики ===");
        System.out.println("Игрок 1 — X, Игрок 2 — O");

        while (true) {
            printBoard(game.getBoard());

            String currentPlayer = game.isFirstPlayerTurn() ? "Игрок 1 (X)" : "Игрок 2 (O)";
            System.out.println(currentPlayer + ", введите координаты (строка и столбец от 0 до 2):");

            System.out.print("Строка: ");
            int row = scanner.nextInt();

            System.out.print("Столбец: ");
            int col = scanner.nextInt();

            game.makeMove(row, col);
        }
    }

    private static void printBoard(char[][] board) {
        System.out.println();
        for (char[] row : board) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
