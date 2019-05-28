package setMods;

// Rex Oliver and Charles Hayes
// CPSC 2151-002 Lab 5
// 3/1/19
// ArraySet.java
public class ArraySet<T> extends SetAbs<T> {
    /**
     * @invariant 0 <= size < max_size
     * @invariant [T array contains exclusively int data types]
     * Correspondence sizeOfSet = size
     * Correspondence this = arr[0...size-1]
     */

    private T [] arr;
    private int size;
    /**
     * Constructor
     * @pre - [Constructor called with new operator]
     * @post [A new T array is initialized] and
     * size = 0
     */
    public ArraySet(){
        arr = (T[]) new Object[MAX_SIZE];
        size = 0;
    }

    /**
     * @pre [T array has been initialized with constructor] and
     * [0 <= size < max_size]
     * @post [T array contains add at last element]
     * @param add T to be added to T array
     */
    public void add(T add){
        //Input add to last element in arr
        arr[size] = add;
        //Increment size
        size++;
    }

    /**
     * @pre [T array has been initialized with constructor] and
     * [0 <= size < max_size]
     * @post [T array no longer contains element at pos] and [T returned]
     * @param pos the position where an T is removed in the T array
     * @return the T at position pos in the T array
     */
    public T removePos(int pos)
    {
        //Get last position in array
        T result = arr[pos];
        //Move elements to next position for size
        for(int i = pos; i < size-1; i++)
            arr[i] = arr[i+1];
        //Decrement size
        size--;
        //Return last position value
        return result;
    }

    /**
     * @pre [T array has been initialized with constructor] and
     * [0 <= size < max_size]
     * @post [T array unmodified] and [boolean returned]
     * @param val T to be searched for in the T array
     * @return true if the T array contains val, otherwise false
     */
    public boolean contains(T val){
        //Search for val in arr
        for(int i = 0; i < size; i++) {
            if (arr[i].equals(val))
                //Found val, true
                return true;
        }
        //Didn’t find val, false
        return false;
    }

    /**
     * @pre [T array has been initialized with constructor]
     * @post [T array unmodified] and [int returned]
     * @return the size of the T array
     */
    public int getSize() {return size;}
}
