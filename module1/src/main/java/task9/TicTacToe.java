package task9;

public class TicTacToe {
    private char[][] board = {
            {'_', '_', '_'}, 
            {'_', '_', '_'},
            {'_', '_', '_'},
    };

    private boolean isFirstPlayerTurn = true;

    public void makeMove(int row, int col) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            System.out.println("Вы вышли на границу доски");
            return;
        }

        if (isFirstPlayerTurn) {
            board[row][col] = 'X';
        }
        else {
            board[row][col] = 'O';
        }

        isFirstPlayerTurn = !isFirstPlayerTurn;
    }

    public char[][] getBoard() {
        return board;
    }

    public boolean isFirstPlayerTurn() {
        return isFirstPlayerTurn;
    }
}
