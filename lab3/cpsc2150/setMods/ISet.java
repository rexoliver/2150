package setMods;
// Rex Oliver and Charles Hayes
// CPSC 2151-002 Lab 3
// 2/6/2019
// ISet.java

/**
 ISet represents a set of integers. Indexing starts at 0.
 Initialization ensures: ISet contains only integers and is
 max_size or smaller
 Defines:    sizeOfSet: Z
 Constraints: 0 <= sizeOfSet < max_size
 */
public interface ISet {

    // Maximum possible size of data structures
    public static final int max_size = 100;

    /**
     * @pre  0 <= sizeOfSet < max_size
     * @post [this will contain one of each int from both unionWith and this]
     * @param unionWith ISet to find the union from
     */
    default void union(ISet unionWith) {
        int temp = 0;
        int tsize = unionWith.getSize();
//For every element in unionWith...
        for (int i = 0; i < tsize; i++) {
            //Store value at first position
            //Remove value from unionWith
            temp = unionWith.removePos(0);
            //If this set does not contain value from unionWith...
            if (!this.contains(temp))
                //Add value to this set
                this.add(temp);
        }
    }

    /**
     * @pre 0 <= sizeOfSet < max_size
     * @post [this will contain ints from this that are not in diffWith]
     * @param diffWith ISet to find the difference from
     */
    default void difference(ISet diffWith){
        int temp = 0;
        int i = 0;
        //For every element in this set...
        while (i < this.getSize()){
            //Store value at first position
            //Remove value from this set
            temp = this.removePos(0);
            //If diffWith does not contain value from this set...
            if(!diffWith.contains(temp)){
                //Add value to this set
                this.add(temp);
                //Increment position
                i++;
            }
        }
    }

    /**
     * @pre 0 <= sizeOfSet < max_size
     * @post [this will contain ints from this that are also found in intWith]
     * @param intWith ISet to find the intersection from
     */
    default void intersect(ISet intWith){
        int temp = 0;
        int i = 0;
        //For every element in this set...
        while (i < this.getSize()){
            //Store value at first position
            //Remove value from this set
            temp = this.removePos(0);
            //If intWith does not contain value from this set...
            if(intWith.contains(temp)){
                //Add value to this set
                this.add(temp);
                //Increment position
                i++;
            }
        }

    }


    /**
     * @pre [ISet initialized]
     * @post [ISet contains same elements with a
     * new element - add - placed at the end]
     * @param add Integer value to be added to ISet
     */
    void add(Integer add);

    /**
     * @pre [ISet contains elements (non-NULL)] and pos >= 0
     * @post [ISet contains same elements as
     * when it was passed, without element at pos] and [Integer returned]
     * @param pos position in ISet to be removed
     * @return Integer of position where the element was removed
     */
    Integer removePos(int pos);

    /**
     * @pre [ISet contains elements (non-NULL)] and val != NULL
     * @post [ISet unmodified] and [boolean returned]
     * @param val value to be searched in ISet
     * @return true if ISet contains val, otherwise false
     */
    boolean contains(Integer val);

    /**
     * @pre [ISet initialized with constructor]
     * @post [ISet, size of ISet unmodified] and [int returned]
     * @return int value of the size of the ISet
     */
    int getSize();

}

