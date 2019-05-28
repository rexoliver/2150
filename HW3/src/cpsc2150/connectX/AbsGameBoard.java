package cpsc2150.connectX;

public abstract class AbsGameBoard implements IGameBoard {

    /**
     * @return the string representation of the GameBoard
     * @requires this GameBoard != null
     */
    @Override
    public String toString(){
        // Prints top of board
        String s = "";
        for(int i = 0; i < getNumColumns(); i++)
        {
            if(i > 9)
                s += "|" + i;
            else s+= "| " + i;
        }
        s += "|\n";
        // Loops through array in reverse order
        for(int i = getNumRows()-1; i > -1; i--) {
            // adds structure of board to string

            s += "|";
            // loops through board horizontally
            for(int j = 0; j < getNumColumns(); j++)
                // adds the value at index of board to string
                s += " " + whatsAtPos(i,j) + "|";
            // adds newline to end of string
            s+= "\n";
        }
        return s;
    }
}
