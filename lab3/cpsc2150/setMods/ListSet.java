package setMods;
import java.util.ArrayList;
import java.util.List;

// Rex Oliver and Charles Hayes
// CPSC 2151-002 Lab 3
// 2/6/2019
// ListSet.java

public class ListSet implements ISet {
    /**
     * @invariant 0 <= size < max_size
     * @invariant [ArrayList contains exclusively int data types]
     * Correspondence sizeOfSet = size
     * Correspondence this = list[0...size-1]
     * */
     List<Integer> list = new ArrayList<Integer>();

    /**
     * @pre [Constructor called with new operator]
     * @post [A new ArrayList is initialized] and
     * size = 0
     */
    public ListSet(){
       // List<Integer> list = new ArrayList<Integer>();
    }

    /**
     * @pre [ArrayList has been initialized with constructor] and
     * [0 <= size < max_size]
     * @post [ArrayList unmodified] and [String initialized]
     * @return String with correctly formatted data of ArrayList for user
     */
    public String toString(){
        String s = "";
//Add first int from list to String
        s += list.get(0);
//For every int in list...
        for(int i = 1; i < list.size(); i++)
//Add Integer at position i from list to String with a comma
            s += ", " + list.get(i);
//Return string
        return s;
    }

    /**
     * @pre [ArrayList has been initialized with constructor] and
     * [0 <= size < max_size]
     * @post [ArrayList contains add at last element]
     * @param add Integer to be added to ArrayList
     */
    public void add(Integer add){
        list.add(list.size(), add);
    }


    /**
     * @pre [ArrayList has been initialized with constructor] and
     * [0 <= size < max_size]
     * @post [ArrayList no longer contains element at pos] and [Integer returned]
     * @param pos the position where an Integer is removed in the ArrayList
     * @return the Integer at position pos in the ArrayList
     */
    public Integer removePos(int pos){
//Store Integer at position pos in list
        int result = list.get(pos);
//Remove Integer at position pos in list
        list.remove(pos);
//Return removed Integer
        return result;
    }

    /**
     * @pre [ArrayList has been initialized with constructor] and
     * [0 <= size < max_size]
     * @post [ArrayList unmodified] and [boolean returned]
     * @param val Integer to be searched for in the ArrayList
     * @return true if the ArrayList contains val, otherwise false
     */
    public boolean contains(Integer val){
        return list.contains(val);
    }

    /**
     * @pre [ArrayList has been initialized with constructor]
     * @post [ArrayList unmodified] and [int returned]
     * @return the size of the ArrayList
     */
    public int getSize(){
        return list.size();
    }
}

