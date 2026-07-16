import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TicTacToeGUI {
    static char[][] board = new char[3][3];
    static char currentPlayer = 'x';
    static JButton[][] buttons = new JButton[3][3];

    static void main(String[] args) {
        JFrame frame = new JFrame("Tic-Tac-Toe");
        frame.setSize(400,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(3,3));

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col] = ' ';
                JButton button = new JButton("");
                button.setFont(new Font("Arial", Font.BOLD, 40));

                int finalrow = row;
                int finalcol = col;

                button.addActionListener(e -> handleClick(finalrow, finalcol, button));

                buttons[row][col] = button;
                frame.add(button);

            }
        } frame.setVisible(true);
    }
static void handleClick(int row, int col, JButton button) {
        if (board[row][col] != ' ') {
            return;
        }
        board[row][col] = currentPlayer;
        button.setText(String.valueOf(currentPlayer));
        if (checkWin(board, currentPlayer)) {
            JOptionPane.showMessageDialog(null, currentPlayer + " has won!");
            int choice = JOptionPane.showConfirmDialog(null, "Play again?", "Game Over", JOptionPane.YES_NO_OPTION);

            if (choice == JOptionPane.YES_OPTION) {
                resetBoard();
            } else {
                System.exit(0);
            }
        }
        if(isBoardFull(board)) {
            JOptionPane.showMessageDialog(null,"Draw!");
            int choice = JOptionPane.showConfirmDialog(null, "Play again?", "Game Over", JOptionPane.YES_NO_OPTION);

            if (choice == JOptionPane.YES_OPTION) {
                resetBoard();
            } else {
                System.exit(0);
            }
        }
    currentPlayer = (currentPlayer == 'x') ? 'O':'x';
}


    static boolean checkWin(char[][] board, char player) {
        for(int row = 0; row < 3; row++){
            if (board[row][0] == player && board[row][1] == player && board[row][2] == player) {
                return true;
            }
        }
        for(int col = 0; col < 3; col++) {
            if (board[0][col] == player && board[1][col] == player && board[2][col] == player) {
                return true;
            }
        }
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        } else {
            return false;
        }
    }
    static boolean isBoardFull(char[][] board) {
        for (int row = 0; row < 3; row++) {
            for(int col= 0; col < 3; col++){
                if(' ' == board[row][col]) {
                    return false;
                }
            }
        } return true;
    }
    static void resetBoard() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col] = ' ';
                buttons[row][col].setText("");
            }
        }
        currentPlayer = 'X';
    }
}



