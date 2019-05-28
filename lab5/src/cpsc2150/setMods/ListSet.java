package setMods;
import java.util.ArrayList;
import java.util.List;

// Rex Oliver and Charles Hayes
// CPSC 2151-002 Lab 5
// 3/1/2019
// ListSet.java

public class ListSet<T> extends SetAbs<T> {
    /**
     * @invariant 0 <= size < max_size
     * @invariant [ArrayList contains exclusively int data types]
     * Correspondence sizeOfSet = size
     * Correspondence this = list[0...size-1]
     * */
     List<T> list = new ArrayList<T>();

    /**
     * @pre [Constructor called with new operator]
     * @post [A new ArrayList is initialized] and
     * size = 0
     */
    public ListSet(){
       // List<T> list = new ArrayList<T>();
    }

    /**
     * @pre [ArrayList has been initialized with constructor] and
     * [0 <= size < max_size]
     * @post [ArrayList contains add at last element]
     * @param add T to be added to ArrayList
     */
    public void add(T add){
        list.add(list.size(), add);
    }


    /**
     * @pre [ArrayList has been initialized with constructor] and
     * [0 <= size < max_size]
     * @post [ArrayList no longer contains element at pos] and [T returned]
     * @param pos the position where an T is removed in the ArrayList
     * @return the T at position pos in the ArrayList
     */
    public T removePos(int pos){
        //Store T at position pos in list
        T result = list.get(pos);
        //Remove T at position pos in list
        list.remove(pos);
        //Return removed T
        return result;
    }

    /**
     * @pre [ArrayList has been initialized with constructor] and
     * [0 <= size < max_size]
     * @post [ArrayList unmodified] and [boolean returned]
     * @param val T to be searched for in the ArrayList
     * @return true if the ArrayList contains val, otherwise false
     */
    public boolean contains(T val){
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

