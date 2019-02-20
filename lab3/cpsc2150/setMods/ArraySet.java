package setMods;

// Rex Oliver and Charles Hayes
// CPSC 2151-002 Lab 3
// 2/6/2019
// ArraySet.java
public class ArraySet implements ISet {
    /**
     * @invariant 0 <= size < max_size
     * @invariant [Integer array contains exclusively int data types]
     * Correspondence sizeOfSet = size
     * Correspondence this = arr[0...size-1]
     */

    private Integer [] arr;
    private int size;
    /**
     * Constructor
     * @pre - [Constructor called with new operator]
     * @post [A new Integer array is initialized] and
     * size = 0
     */
    public ArraySet(){
        arr = new Integer[max_size];
        size = 0;
    }

    /**
     * @pre [Integer array has been initialized with constructor] and
     * [0 <= size < max_size]
     * @post [Integer array unmodified] and [String initialized]
     * @return String with correctly formatted data of Integer array for user
     */
    public String toString() {
        String s = "";
        //Add commas in between ints for clarity
        for (int i = 0; i < size; i++)
            s += arr[i] +", ";
        //Return formatted set
        return s;
    }

    /**
     * @pre [Integer array has been initialized with constructor] and
     * [0 <= size < max_size]
     * @post [Integer array contains add at last element]
     * @param add Integer to be added to Integer array
     */
    public void add(Integer add){
        //Input add to last element in arr
        arr[size] = add;
        //Increment size
        size++;
    }

    /**
     * @pre [Integer array has been initialized with constructor] and
     * [0 <= size < max_size]
     * @post [Integer array no longer contains element at pos] and [Integer returned]
     * @param pos the position where an Integer is removed in the Integer array
     * @return the Integer at position pos in the Integer array
     */
    public Integer removePos(int pos)
    {
        //Get last position in array
        Integer result = arr[pos];
        //Move elements to next position for size
        for(int i = pos; i < size-1; i++)
            arr[i] = arr[i+1];
        //Decrement size
        size--;
        //Return last position value
        return result;
    }

    /**
     * @pre [Integer array has been initialized with constructor] and
     * [0 <= size < max_size]
     * @post [Integer array unmodified] and [boolean returned]
     * @param val Integer to be searched for in the Integer array
     * @return true if the Integer array contains val, otherwise false
     */
    public boolean contains(Integer val){
        //Search for val in arr
        for(int i = 0; i < size; i++) {
            if (arr[i] == val)
                //Found val, true
                return true;
        }
        //Didn’t find val, false
        return false;
    }

    /**
     * @pre [Integer array has been initialized with constructor]
     * @post [Integer array unmodified] and [int returned]
     * @return the size of the Integer array
     */
    public int getSize() {return size;}
}
