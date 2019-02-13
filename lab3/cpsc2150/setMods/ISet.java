package setMods;
// Rex Oliver and Charles Hayes
// CPSC 2151-002 Lab 3
// 2/6/2019
// ISet.java

public interface ISet {

    /**
     ISet represents a set of integers. Indexing starts at 0.
     Initialization ensures: ISet contains only integers and is
     max_size or smaller
     Defines:    size: Z
     Constraints: 0 <= size <= max_size
     */

    // Maximum possible size of data structures
    int max_size = 100;

    /**
     * @pre
     * @post
     * @param unionWith
     */
    default void union(ISet unionWith){
        for(int i = 0; i < max_size; i++)
            if(!this.contains(unionWith.get(i)))
                this.add(unionWith.get(i));
    }

    /**
     * @pre
     * @post
     * @param diffWith ISet to find the difference from
     */
    default void difference(ISet diffWith){
        for(int i = 0; i < max_size; i++)
            if(this.contains(diffWith.get(i)))
                for(int j = 0; j < max_size; j++)
                    if(this.get(j) == diffWith.get(i))
                        this.removePos(j);
    }

    /**
     * @pre
     * @post
     * @param intWith
     */
    default void intersect(ISet intWith){
        for(int i = 0; i < max_size; i++)
            if(!this.contains(intWith.get(i)))
                for(int j = 0; j < max_size; j++)
                    if(this.get(j) == intWith.get(i))
                        this.removePos(j);
    }


    /**
     * @pre
     * [Data structure initialized with constructor]
     * @post
     * [Data structure contains same elements with a
     * new element - add - placed at end of data structure]
     * @param add Integer value to be added to data structure
     */
    void add(Integer add);

    /**
     * @pre
     * [Data structure contains elements (non-NULL)] and pos >= 0
     * @post
     * size-- and [data structure contains same elements as
     * when it was passed, without element at pos]
     * @param pos position in data structure to be removed
     * @return Integer data structure with removed element at pos
     */
    Integer removePos(int pos);

    /**
     * @pre
     * [Data structure contains elements (non-NULL)] and val != NULL
     * @post
     * [Data structure unmodified] and [boolean value initialized]
     * @param val value of an element in data structure
     * @return boolean value; true indicates structure does contain val
     * and false indicates structure does not contain val
     */
    boolean contains(Integer val);

    /**
     * @pre
     * [Data structure initialized with constructor]
     * @post
     * [Data structure, size of data structure unmodified]
     * @return int value of the size of the data structure
     */
    int getSize();

    int get(int val);
}
