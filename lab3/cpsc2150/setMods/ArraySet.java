package setMods;

// Rex Oliver and Charles Hayes
// CPSC 2151-002 Lab 3
// 2/6/2019
// ArraySet.java
public class ArraySet implements ISet {
    /**
     * @invariant 0 <= size <= max_size and
     * [Integer array contains exclusively int data types]
     * @c
     */

    private Integer [] arr;
    private int size;
    /**
     * Constructor
     * @pre - none
     * @post [A new Integer array is initialized] and
     * size = 0
     */
    public ArraySet(){
        arr = new Integer[max_size];
        size = 0;
    }


    /**
     * @pre
     * [Integer array has been initialized with constructor] and
     * [returned String assigned to another String in method call]
     * @post
     * [Integer array unmodified] and [String initialized]
     * @return String with correctly formatted data of ArrayList for user
     */
    public String toString() {
        String s = "";
        for (int i = 0; i < size; i++)
            s += arr[i] +", ";
        return s;
    }

    public void add(Integer add){
        arr[size] = add;
        size++;
    }

    public Integer removePos(int pos)
    {
        Integer result = arr[pos];
        for(int i = pos; i < size-1; i++)
            arr[i] = arr[i+1];
        size--;
        return result;
    }

    public boolean contains(Integer val){
        for(int i = 0; i < size; i++) {
            if (arr[i] == val)
                return true;
        }
        return false;
    }

    public int getSize() {return size;}
}
