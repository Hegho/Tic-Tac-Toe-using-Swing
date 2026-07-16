import java.util.Scanner;
import java.util.Objects;

public class TicTacToe {
   static char[][] board;
    static void main(String[] args) {
        char currentPlayer = 'x';
        board = createBoard();
        while(true) {
            printBoard(board);
            int[] move = getPlayerMove(currentPlayer);
            placeMove(board, move, currentPlayer);
            if(checkWin(board, currentPlayer)) {
                printBoard(board);
                System.out.print(currentPlayer + " has won!");
                if(playAgain()){
                    board = createBoard();
                    continue;
                } else {
                    break;}
            }
            if(isBoardFull(board)) {
                printBoard(board);
                System.out.print("Draw!");
                if(playAgain()){
                    board = createBoard();
                    continue;
                } else {
                break;}
            }
            currentPlayer = (currentPlayer == 'x') ? 'O':'x';

        }

    }

static char[][] createBoard() {
        char[][] board = new char[3][3];
    for (int row = 0; row < 3 ; row++) {
        for (int col = 0; col < 3 ; col++){
        board[row][col]= '_';

        }
    }
return board;


}

static void printBoard(char[][] board) {
        System.out.print(board[0][0]);
        System.out.print(board[0][1]);
        System.out.print(board[0][2]);
    System.out.print("\n");
        System.out.print(board[1][0]);
        System.out.print(board[1][1]);
        System.out.print(board[1][2]);
    System.out.print("\n");
        System.out.print(board[2][0]);
        System.out.print(board[2][1]);
        System.out.print(board[2][2]);
    System.out.print("\n");

}

static int[] getPlayerMove(char player) {
        Scanner girdi = new Scanner(System.in);
        int row, col;
        while(true) {
            System.out.println("Player " + player + " Enter row (0-2)");
            if(!girdi.hasNextInt()) {
                System.out.println("Enter a valid number");
                girdi.next();
                continue;
            }
            row = girdi.nextInt();

            System.out.println("Player " + player + " Enter col (0-2)");
            if(!girdi.hasNextInt()) {
                System.out.println("Enter a valid number");
                girdi.next();
                continue;
            }
            col = girdi.nextInt();

            if (row < 0 || row > 2 || col < 0 || col > 2) {
                System.out.println("Row and column must be between 0 and 2.");
                continue;

            }
            if (board[row][col] != '_') {
                System.out.println("That cell is already taken.");
                continue;
            }
            break;
        }
        int[] move = new int[2];
        move[0] = row;
        move[1] = col;
        return move;
    }

static void placeMove(char[][] board, int[] move, char player) {
        int row = move[0];
        int col = move[1];
        board[row][col] = player;
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
                if('_' == board[row][col]) {
                    return false;
                }
            }
        } return true;
     }

static boolean playAgain() {

        System.out.println("Play Again ? (yes/no)");
        Scanner tekrarGirdi = new Scanner(System.in);
        while(true) {
            String tekrarCevap = tekrarGirdi.next();
            if (tekrarCevap.equals("yes")) {
                System.out.println("Starting new Game");

                return true;
            } else if (tekrarCevap.equals("no")){
                System.out.println("Goodbye");
                return false;
            } else {
                System.out.println("yes/no");
            }
        }
    }}




