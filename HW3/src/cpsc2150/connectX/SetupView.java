package cpsc2150.connectX;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/*
This class contains the code to create and layout the GUI for the setup screen.
It also is the observer of the submit button. When someone clicks on submit
the action performed method is called, which then calls the controller Object.

You do not need to make any changes to this file, but it is a good example of
a java swing GUI.
 */

public class SetupView extends JFrame implements ActionListener{
    private JButton submitButton;
    private JTextArea numRowsTxt;
    private JTextArea numColsTxt;
    private final Integer[] players = { 2, 3, 4,5 ,6, 7, 8, 9, 10};
    private JComboBox<Integer> numPlayersCB;
    private JLabel errorMessageLbl;
    private JLabel numRowsLbl;
    private JLabel numColsLbl;
    private JLabel numPlayersLbl;
    private JLabel numWinLbl;
    private JTextArea numWinTxt;
    private float fontSize = 40;
    SetupController controller;

    public SetupView()
    {

        submitButton = new JButton("Submit");
        numRowsLbl = new JLabel("Number of Rows: ");
        numRowsTxt = new JTextArea(1, 10);
        numColsLbl = new JLabel("Number of Columns: ");
        numColsTxt = new JTextArea(1, 10);
        errorMessageLbl = new JLabel("");
        numPlayersLbl = new JLabel("Number of Players: ");
        numPlayersCB = new JComboBox<>(players);
        numWinLbl = new JLabel("Number to win: ");
        numWinTxt = new JTextArea(1, 10);


        numRowsLbl.setFont(numRowsLbl.getFont().deriveFont(fontSize));
        numRowsTxt.setFont(numRowsLbl.getFont());

        numColsLbl.setFont(numRowsLbl.getFont());
        numColsTxt.setFont(numRowsLbl.getFont());

        numPlayersLbl.setFont(numRowsLbl.getFont());
        numPlayersCB.setFont(numRowsLbl.getFont());

        errorMessageLbl.setFont(numRowsLbl.getFont());
        submitButton.setFont(numRowsLbl.getFont());

        numWinLbl.setFont(numRowsLbl.getFont());
        numWinTxt.setFont(numRowsLbl.getFont());

        this.setLayout(new GridLayout(6, 1));
        this.add(errorMessageLbl);
        JPanel rowsPanel = new JPanel(new GridLayout(1, 2));
        rowsPanel.add(numRowsLbl);
        rowsPanel.add(numRowsTxt);
        this.add(rowsPanel);

        JPanel colsPanel = new JPanel(new GridLayout(1, 2));
        colsPanel.add(numColsLbl);
        colsPanel.add(numColsTxt);
        this.add(colsPanel);

        JPanel winPanel = new JPanel(new GridLayout(1, 2));
        winPanel.add(numWinLbl);
        winPanel.add(numWinTxt);
        this.add(winPanel);

        JPanel playersPanel = new JPanel(new GridLayout(1, 2));
        playersPanel.add(numPlayersLbl);
        playersPanel.add(numPlayersCB);
        this.add(playersPanel);



        submitButton.addActionListener(this);
        this.add(submitButton);

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

        //is the source submit button
        if(source.equals(submitButton))
        {
            errorMessageLbl.setText("");
            String msg = "";
            int numRows = 0;
            int numCols = 0;
            int numPlayers = 0;
            int numWin = 0;
            // exceptions to check for wrong data types
            //all other validation handled by controller
            try {
                numRows = Integer.parseInt(numRowsTxt.getText());
            }
            catch (NumberFormatException e)
            {
                msg += "Rows must be a number";
            }

            try
            {
                numCols = Integer.parseInt(numColsTxt.getText());
            }
            catch(NumberFormatException e)
            {
                msg += "Cols must be a number";
            }

            try
            {
                numWin = Integer.parseInt(numWinTxt.getText());
            }
            catch(NumberFormatException e)
            {
                msg += "Wins must be a number";
            }

            numPlayers = numPlayersCB.getItemAt(numPlayersCB.getSelectedIndex());

            if(msg.equals(""))
            {
                controller.processButtonClick(numRows, numCols, numPlayers, numWin);
            }
            else
            {
                errorMessageLbl.setText(msg);
            }


        }
        /*
         * Set the cursor back to normal (because we changed it at the beginning
         * of the method body)
         */
        this.setCursor(Cursor.getDefaultCursor());
    }

    public void displayError(String msg)
    {
        errorMessageLbl.setText(msg);
    }

    public void registerObserver(SetupController c){
        controller = c;
    }

    public void closeScreen()
    {
        this.dispose();
    }

}
