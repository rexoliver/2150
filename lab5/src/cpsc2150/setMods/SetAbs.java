package setMods;

// Rex Oliver and Charles Hayes
// CPSC 2151-002 Lab 5
// 3/1/19
// SetAbs.java

/**
 * @invariant this = [instance of ISet]
 * @invariant T =  [generic type]
 */

public abstract class SetAbs<T> implements ISet<T> {

    /**
     * @pre [this has been initialized with constructor] and
     * [0 <= size < max_size]
     * @post [this contains same order of elements as before]
     * and [String initialized]
     * @return String with correctly formatted data of this for user
     */
    public String toString(){
        // String for output
        String s = "";
        // get init size of this
        int size = this.getSize();
        // loop thru this
        for(int i = 0; i < size; i++)
        {
            // Get first element of this
            T value = this.removePos(0);
            // concat string  with 1st element
            s += value + ", ";
            // add element back to this
            this.add(value);
        }
        // return string
        return s;
    }

    /**
     * @pre [this has been initialized with constructor] and
     * [0 <= size < max_size]
     * @post equals(o) = true iff [this and o contain the same element]
     * @param o = [data structure that is to be compared]
     * @return true iff [this and o contain the same element]
     */
    public boolean equals(Object o){
        // assert o is a member of iset
        if (o instanceof ISet)
        {
            // copy o into temp, cast as ISet<T>
            ISet<T> temp = (ISet<T>)o;
            // if the sizes are the same
            if (temp.getSize() != this.getSize())
                return false;
            // set original size of temp
            int size = temp.getSize();
            // loop thru this
            for(int i = 0; i < size; i++)
            {
                // Get first element of this
                T value = this.removePos(0);
                // if temp does not have value, return false
                if (!temp.contains(value))
                    return false;
                // else add value back to this
                this.add(value);
            }
            // sets are equal
            return true;
        }
        //sets are not equal
        return false;
    }

    public abstract void add(T add);

    public abstract T removePos(int pos);

    public abstract boolean contains(T val);

    public abstract int getSize();
}
