package cpsc2150.connectX;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import java.util.*;
import java.util.List;

/**
 * This class is the view of our Connect X
 * our view has a message area, and a list of buttons
 * the buttons will be arranges in a ROWS_IN_BUTTON_PANEL x COLUMNS_IN_BUTTON_PANEL Grid
 * Players will use another set of buttons above the grid to select the column to place in
 * All events will be passed to the controller
 *
 * You do not need to make any changes to this code, but you do need to understand much of what is happening
 */


public class ConnectXView  extends JFrame implements ActionListener{
    private ConnectXController controller;

    private final JTextArea message;
    private final List<JButton>  buttons;
    private final List<JButton>  colButtons;

    private static final int LINES_IN_TEXT = 4, LINE_TEXT_LENGTHS = 20;
    private static int ROWS_IN_BUTTON_PANEL;

    private static int COLUMNS_IN_BUTTON_PANEL;
    private float fontSize = 40;



    /**
     *
     * @param row the number of rows you want in the tic tac toe grid
     * @param col the number of columns you want in the tic tac toe grid
     * @requires row > 0 and col > 0
     * @ensures a functional screen with a row x col grid of buttons will be created
     */
    public ConnectXView(int row, int col)
    {
        //call super constructor to make JFrame
        super("Connect X Game");
        ROWS_IN_BUTTON_PANEL = row;
        COLUMNS_IN_BUTTON_PANEL = col;





        //create the widgets
        this.message = new JTextArea("It is X\'s turn. ", LINES_IN_TEXT, LINE_TEXT_LENGTHS);
        //read only
        this.message.setEditable(false);
        this.message.setLineWrap(true);
        this.message.setWrapStyleWord(true);
        message.setFont(message.getFont().deriveFont(fontSize));

        //set up buttons to be used to select a column
        colButtons = new ArrayList<>();
        for(int i=0; i < COLUMNS_IN_BUTTON_PANEL; i++)
        {
            // text is down arrow character
            JButton button = new JButton( Character.toString((char)8595) );
            button.setPreferredSize(new Dimension(50, 50));
            button.setMinimumSize(new Dimension(50, 50));
            button.setMaximumSize(new Dimension(50, 50));
            button.setFont(message.getFont().deriveFont(fontSize));
            colButtons.add(button);

        }


        //Add buttons to our list of buttons
        //These buttons will be used to create our grid for our game board
        //Buttons would not generally be used like this, however its an easy way to get nice rectangular cells for our grid

        buttons = new ArrayList<JButton>();
        for(int i=0; i < ROWS_IN_BUTTON_PANEL * COLUMNS_IN_BUTTON_PANEL; i++)
        {
            //these buttons are spaces on the board that start empty
            JButton button = new JButton("");
            button.setPreferredSize(new Dimension(50, 50));
            button.setMinimumSize(new Dimension(50, 50));
            button.setMaximumSize(new Dimension(50, 50));
            button.setFont(message.getFont().deriveFont(fontSize));
            //set enabled to false. we don't want players clicking these buttons
            //we don't register as an observer because we only use these buttons to display our board
            button.setEnabled(false);
            buttons.add(button);

        }




        //create layout for the screen
        this.setLayout(new GridLayout(ROWS_IN_BUTTON_PANEL + 2, 1));
        //add our message box on top
        this.add(message);

        //create a panel with buttons to select a column
        JPanel colButtonPanel = new JPanel(new GridLayout(1, COLUMNS_IN_BUTTON_PANEL));
        for(int i=0; i<COLUMNS_IN_BUTTON_PANEL; i++)
        {
            //register as an observer
            colButtons.get(i).addActionListener(this);
            //add to the panel
            colButtonPanel.add(colButtons.get(i));
        }
        this.add(colButtonPanel);



        //add our rows of buttons for the board
        for(int i=0; i<ROWS_IN_BUTTON_PANEL; i++)
        {
            //create a panel to hold a row of buttons
            JPanel buttonPanel = new JPanel(new GridLayout(1, COLUMNS_IN_BUTTON_PANEL));
            for(int j=0; j<COLUMNS_IN_BUTTON_PANEL; j++)
            {
                //add a button in each column
                int index = (i*COLUMNS_IN_BUTTON_PANEL) + j;
                //add the screen as a listener
                //buttons.get(index).addActionListener(this);
                buttonPanel.add(buttons.get(index));


            }
            //row is complete, add it to out screen
            this.add(buttonPanel);

        }




        // Start the main application window --------------------------------

        /*
         * Make sure the main window is appropriately sized for the widgets in
         * it, that it exits this program when closed, and that it becomes
         * visible to the user now
         */
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    /**
     * Register argument as observer/listener of this; this must be done first,
     * before any other methods of this class are called.
     *
     * @param c
     *            controller to register
     * @requires c is a valid controller for this view
     * @ensures this.controller = c
     */
    public void registerObserver(ConnectXController c) {
        this.controller = c;
    }

    /**
     *
     * @param event the event on the screen that is observed
     * @ensures button events will be sent to the controller
     */
    @Override
    public void actionPerformed(ActionEvent event) {
        /*
         * Set cursor to indicate computation on-going; this matters only if
         * processing the event might take a noticeable amount of time as seen
         * by the user
         */
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        /*
         * Determine which event has occurred that we are being notified of by
         * this callback; in this case, the source of the event (i.e, the widget
         * calling actionPerformed) is all we need because only buttons are
         * involved here, so the event must be a button press; in each case,
         * tell the controller to do whatever is needed to update the model and
         * to refresh the view
         */
        Object source = event.getSource();

        //is the source one of our buttons?
        if(colButtons.contains(source))
        {
            //get row and columns
            int column =  colButtons.indexOf(source);



            //call the controller event
            controller.processButtonClick(column);



        }
        /*
         * Set the cursor back to normal (because we changed it at the beginning
         * of the method body)
         */
        this.setCursor(Cursor.getDefaultCursor());
    }

    /**
     *
     * @param m the message to display in our text area
     * @ensures the this.message text = m
     */
    public void setMessage(String m)
    {
        message.setText(m);
    }

    /**
     *
     * @param row the row of the button in our grid
     * @param col the column of the button in our grid
     * @param player the player who will now claim that button
     * @requires 0<= row < ROWS_IN_BUTTON_PANEL and 0<= col <= COLUMNS_IN_BUTTON_PANEL
     * @ensures the button at row, col will display the character for the player
     *
     */
    public void setMarker(int row, int col, char player)
    {
        //find index, remember the indexing starts in top left
        int index = ((ROWS_IN_BUTTON_PANEL - (row+1)) * COLUMNS_IN_BUTTON_PANEL) + col;
        //set the text of the button
        buttons.get(index).setText(Character.toString(player));

    }
}
