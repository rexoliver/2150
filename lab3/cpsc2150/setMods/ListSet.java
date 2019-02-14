package setMods;
import java.util.ArrayList;
import java.util.List;

// Rex Oliver and Charles Hayes
// CPSC 2151-002 Lab 3
// 2/6/2019
// ListSet.java

public class ListSet implements ISet {
    /**
 * @invariant 0 <= size <= max_size and
 * [ArrayList contains exclusively int data types]
 *
     * */

List<Integer> list = new ArrayList<Integer>();

    /**
     * Constructor
     * @pre - none
     * @post
     * [A new ArrayList is initialized]
     */
    public ListSet(){}

    /**
     * @pre
     * [ArrayList has been initialized with constructor] and
     * [returned String assigned to another String in method call]
     * @post
     * [ArrayList unmodified] and [String initialized]
     * @return String with correctly formatted data of ArrayList for user
     */

    public String toString(){
        String s = "";
        s += list.get(0);
        for(int i = 1; i < list.size(); i++)
            s += ", " + list.get(i);
        return s;
    }

    public void add(Integer add){
        list.add(list.size(), add);
    }

    public Integer removePos(int pos){
        int result = list.get(pos);
        list.remove(pos);
        return result;
    }

    public boolean contains(Integer val){
        return list.contains(val);
    }

    public int getSize(){
        return list.size();
    }
}
