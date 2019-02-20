package connectX;
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
            System.out.println("How many rows should be on the board?");
            int r = scan.nextInt();
            while(r > 100 ||  r < 3) {
                if (r > 100)
                    System.out.println("Can have at most 100 rows");
                else if (r < 3)
                    System.out.println("Must have at least 3 rows");
                System.out.println("How many rows should be on the board?");
                r = scan.nextInt();
            }
            System.out.println("How many columns should be on the board?");
            int c = scan.nextInt();
            while(c > 100 || c  < 3) {
                if (c > 100)
                    System.out.println("Can have at most 100 columns");
                else if (c < 3)
                    System.out.println("Must have at least 3 columns");
                System.out.println("How many columns should be on the board?");
                c = scan.nextInt();
            }
            System.out.println("How many in a row to win?");
            int to_win = scan.nextInt();
            while(to_win > 25 || to_win < 3) {
                if (to_win > 25)
                    System.out.println("Can have at most 25 in a row to win");
                else if (to_win < 3)
                    System.out.println("Must have at least 3 in a row to win");
                System.out.println("How many in a row to win?");
                to_win = scan.nextInt();
            }

            // Create new Gameboard object
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
                while(input >= G.getNumColumns() || input < 0 || !G.checkIfFree(input)) {
                    if (input < 0)
                        System.out.println("Column cannot be less than 0");
                    else if (input >= G.getNumColumns())
                        System.out.println("Column cannot be greater than " + G.getNumColumns());
                    // if collumn full
                    else if (!G.checkIfFree(input))
                        System.out.println("Column is full");
                    // Asks player for input again
                    System.out.println("Player " + letters[current_player%2] +
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
            while(!cinput.equals("n") && !cinput.equals("y"))
            {
                System.out.println("Would you like to play again?");
                cinput = scan.next();
            }
            // if player does not want to play again, exit.
            if(cinput.equals("n"))
                play_again = false;
        }
    }
}
