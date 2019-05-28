/*
Rex Oliver
CPSC 2150 HW5
ConnectXController.java
 */
package cpsc2150.connectX;

/**
 * The controller class will handle communication between our View and our Model (IGameBoard)
 *
 * This is where you will write code
 *
 * You will need to include your IGameBoard interface
 * and both of the IGameBoard implementations from Homework 3
 * If your code was correct you will not need to make any changes to your IGameBoard implementation class
 */

public class ConnectXController {
    //our current game that is being played
    private IGameBoard curGame;

    // current player
    private int curplayer = 0;

    //The screen that provides our view
    private ConnectXView screen;

    public static final int MAX_PLAYERS = 10;
    //our play tokens are hard coded. We could make a screen to get those from the user, but
    //I want to keep this example simple
    private char[] players = {'X', 'O', 'Y', 'Z', 'A', 'K', 'E', 'J', 'N', 'H'};

    // total players go here
   int numPlayers;


    /**
     *
     * @param model the board implementation
     * @param view the screen that is shown
     * @post the controller will respond to actions on the view using the model, it is registered
     */
    ConnectXController(IGameBoard model, ConnectXView view, int np){
        this.curGame = model;
        this.screen = view;
        numPlayers = np;
        // view.registerObserver(this);
    }

    /**
     *
     *
     * @param col the column of the activated button
     * @post will allow the player to place a token in the column if it is not full, otherwise it will display an error
     * and allow them to pick again. Will check for a win as well. If a player wins it will allow for them to play another
     * game hitting any button
     */
    public void processButtonClick(int col) {
        // checks for win
        if(curGame.checkForWin(col))
        {
            newGame();
            return;
        }
        // Checks for tie
        if(curGame.checkTie())
        {
            newGame();
            return;
        }
        // Prompt current player to move
        screen.setMessage("Player " + players[(curplayer+1)%numPlayers] + ", it is your turn");
        if(!curGame.checkIfFree(col)){
            screen.setMessage("Pick a different column.");
        }
        // Actual placing code
        else if(curGame.checkIfFree(col) && !curGame.checkForWin(col) )
        {
            // loop that handles finding the correct row position
            int r = -1;
            for(int i = 0; i < curGame.getNumRows() && r == -1; i++)
                if(curGame.whatsAtPos(i,col) == ' ')
                    r = i;
            // places token on model and view
            curGame.placeToken(players[curplayer%numPlayers], col);
            screen.setMarker(r, col, players[curplayer%numPlayers]); // FILL IN THIS STUFF
            curplayer++;
        }
        // Checks tie condition
        if(curGame.checkTie())
        {
            screen.setMessage("You Tied. Click any button for a new game.");
        }
        // checks for win condition
        if(curGame.checkForWin(col))
        {
            curplayer--; // decrements current player
            screen.setMessage("Player " + players[curplayer%numPlayers] + " Wins! Click any Button to start a new game");
        }
    }

    /**
     * This method will start a new game by returning to the setup screen and controller
     */
    private void newGame()
    {
        //close the current screen
        screen.dispose();
        //start back at the set up menu
        SetupView screen = new SetupView();
        SetupController controller = new SetupController(screen);
        screen.registerObserver(controller);
    }
}
