package cpsc2150.connectX;
import java.util.Scanner;
/*
* Rex Oliver
* CPSC 2150 HW2
* Connect4Game.java
 */
public class Connect4Game {
    public static void main(String [] args)
    {
        // create new scanner object to scan items
        Scanner scan = new Scanner(System.in);
        // create bool to play again or not
        boolean play_again = true;
        // initialize input to something not valid
        int input = -1;
        // while loop that controls whether or not to play a new game
        while(play_again){
            // Asks How many Rows should be on the board
            System.out.println("How many rows should be on the board?");
            // creates int to store row in
            int r = scan.nextInt();
            // loop to handle if row is not valid
            while(r > GameBoard.MAX_SIZE ||  r < GameBoard.MIN_SIZE) {
                // if > GameBoard.MAX_SIZE
                if (r > GameBoard.MAX_SIZE)
                    System.out.println("Can have at most "
                            + GameBoard.MAX_SIZE + " rows");
                // if < GameBoard.MIN_SIZE
                else if (r < GameBoard.MIN_SIZE)
                    System.out.println("Must have at least "
                            + GameBoard.MIN_SIZE + " rows");
                // Ask again how many rows should be on board
                System.out.println("How many rows should be on the board?");
                r = scan.nextInt();
            }
            // Asks how many columns should be on the board
            System.out.println("How many columns should be on the board?");
            // int to store column input in
            int c = scan.nextInt();
            // loop to handle if the column number is invalid
            while(c > GameBoard.MAX_SIZE || c < GameBoard.MIN_SIZE) {
                // if > GameBoard.MAX_SIZE
                if (c > GameBoard.MAX_SIZE)
                    System.out.println("Can have at most "
                            + GameBoard.MAX_SIZE + " columns");
                // if < GameBoard.MIN_SIZE
                else if (c < GameBoard.MIN_SIZE)
                    System.out.println("Must have at least "
                            + GameBoard.MIN_SIZE + " columns");
                // Ask again how many columns should be on the board
                System.out.println("How many columns should be on the board?");
                c = scan.nextInt();
            }
            // Ask how many in a row to win
            System.out.println("How many in a row to win?");
            // int to store row to win input in
            int to_win = scan.nextInt();
            // loop to handle invalid input
            while(to_win > GameBoard.MAX_SIZE_WIN ||
                    to_win < GameBoard.MIN_SIZE) {
                // if >  GameBoard.MAX_SIZE_WIN
                if (to_win > GameBoard.MAX_SIZE_WIN)
                    System.out.println("Can have at most "
                            + GameBoard.MAX_SIZE_WIN + " in a row to win");
                // if < GameBoard.MIN_SIZE
                else if (to_win < GameBoard.MIN_SIZE)
                    System.out.println("Must have at least "
                            + GameBoard.MIN_SIZE + " in a row to win");
                // Ask again how many to win
                System.out.println("How many in a row to win?");
                to_win = scan.nextInt();
            }

            // Create new interface as a Gameboard object using the inputs
            IGameBoard G = new GameBoard(r,c,to_win);
            // used to switch players
            char letters[] = {'O', 'X'};
            // print board
            System.out.println(G);
            // put current player as O
            int current_player = 0;
            do {
                // switch current player
                current_player++;
                // prompt player for input
                System.out.println("Player " + letters[current_player%2] +
                        ", what column do you want to place your marker in?");
                input = scan.nextInt();
                // while loop that handles incorrect inputs
                while(input >= G.getNumColumns() || input < 0
                        || !G.checkIfFree(input)) {
                    if (input < 0)
                        System.out.println("Column cannot be less than 0");
                    else if (input >= G.getNumColumns())
                        System.out.println("Column cannot be greater than "
                                + (G.getNumColumns() - 1));
                    // if column full
                    else if (!G.checkIfFree(input))
                        System.out.println("Column is full");
                    // Asks player for input again
                    System.out.println("Player " + letters[current_player%2]+
                    ", what column do you want to place your marker in?");
                    input = scan.nextInt();
                }
                // case: input is valid, place letter on board
                G.placeToken(letters[current_player%2], input);
                // print board
                System.out.println(G);
                // checks if game is won, if not, prompts
                // other player for their move

            }while(!G.checkForWin(input) && !G.checkTie());
            // If win, print player won
            if(G.checkForWin(input))
                System.out.println("Player " +
                        letters[current_player%2] + " won!");
            // if tie, print tie
            else if(G.checkTie())
                System.out.println("Tie!");
            String cinput = scan.nextLine();
            // loop that handles incorrect input when asked to play again
            while(!cinput.equals("N") && !cinput.equals("Y"))
            {
                System.out.println("Would you like to play again? Y/N");
                cinput = scan.next();
            }
            // if player does not want to play again, exit.
            if(cinput.equals("N"))
                play_again = false;
        }
    }
}
