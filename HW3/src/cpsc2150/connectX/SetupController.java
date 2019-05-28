package cpsc2150.connectX;

/*
This class is the controller for our setup screen. The processButtonClick method is called by
SetupView when someone clicks on the submit button. It is passed in the rows, cols, players and
the number to win by the view, but it still needs to validate that input. If there are any
errors it can use the displayError method in the SetupView class to inform the player of the
error, then wait for them to fix it and resubmit.

If there are no errors it will create a new IGameBoard object (the implementation will depend on
the size of the game board) to serve as the model, and the ConnectXController and ConnectXView.
Control is then passed over the the event dispatch thread that will wait for an event to occur

No changes need to be made to this class.
 */

public class SetupController {
    private SetupView view;
    private int max_size = 20;
    private final int BOARD_CUTOFF = 100;

    public SetupController(SetupView v)
    {
        view = v;
    }

    public void processButtonClick(int rows, int cols, int players, int numWin )
    {
        String errorMsg = "";
        if(rows < 1 || rows > max_size)
        {
            errorMsg += "Rows must be between 1 and " + max_size;
        }

        if(cols < 1 || cols > max_size)
        {
            errorMsg += "Columns must be between 1 and " + max_size;
        }

        if (numWin > rows)
        {
            errorMsg += "Can't have more to win than the number of rows";
        }
        if (numWin > cols)
        {
            errorMsg += "Can't have more to win than the number of Columns";
        }

        if(numWin < 2)
        {
            errorMsg += "Number to win must be at least 2";
        }

        if(!errorMsg.equals(""))
        {
            view.displayError(errorMsg);

        }
        else
        {
            view.closeScreen();
            IGameBoard model;
            //if the board is too big we'll want the memory efficient version
            if(rows*cols > BOARD_CUTOFF)
            {
                model = new GameBoardMem(rows, cols, numWin);
            }
            else {
                model = new GameBoard(rows, cols, numWin);
            }
            ConnectXView tview = new ConnectXView(rows, cols);
            ConnectXController tcontroller = new ConnectXController(model, tview, players);

            tview.registerObserver(tcontroller);
        }
    }
}
