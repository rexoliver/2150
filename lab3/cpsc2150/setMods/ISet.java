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
    public static final int max_size = 100;

    /**
     * @pre
     * @post
     * @param unionWith
     */
    default void union(ISet unionWith) {
        int temp = 0;
        int tsize = unionWith.getSize();
        for (int i = 0; i < tsize; i++) {
            temp = unionWith.removePos(0);
            if (!this.contains(temp))
                this.add(temp);
        }
    }

    /**
     * @pre
     * @post
     * @param diffWith ISet to find the difference from
     */
    default void difference(ISet diffWith){
        int temp = 0;
        //int temp2 = 0;
        //int tsize1 = this.getSize();
        //int tsize2 = intWith.getSize();
        int i = 0;
        while (i < this.getSize()){
            temp = this.removePos(0);
            if(!diffWith.contains(temp)){
                this.add(temp);
                i++;
            }
        }
    }

    /**
     * @pre
     * @post
     * @param intWith
     */
    default void intersect(ISet intWith){
        int temp = 0;
        //int temp2 = 0;
        //int tsize1 = this.getSize();
        //int tsize2 = intWith.getSize();
        int i = 0;
        while (i < this.getSize()){
            temp = this.removePos(0);
            if(intWith.contains(temp)){
                this.add(temp);
                i++;
            }
        }
        /*
        int index = 0;
        while (index < tsize2) {
            temp = inWith.removePos(index);
            if (this.contains(temp)) {
                inWith.add(temp);
                index++;
            }
        }
        */

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

}

