package structures.chain;

import exceptions.ChainIndexOutOfBoundsException;


/**
 * Abstract chain
 * 
 * @author Moritz Decker 
 * @version v1.0.1-2021-09-23
 */
public abstract class Chain<T>
{    
    protected int length = 0;

    /**
     * @return total length of the chain
     */
    public int getLength()
    {
        return this.length;
    }

    /**
     * Append data to the end of the chain
     * 
     * @param obj data to store
     */
    public abstract void add(T obj);

    /**
     * Store data at specific index
     * 
     * @param obj data to store
     * @param index
     * @throws ChainIndexOutOfBoundsException
     */
    public abstract void add(T obj, int index) throws ChainIndexOutOfBoundsException;

    /**
     * Remove data at specific index
     * 
     * @param index 
     * @throws ChainIndexOutOfBoundsException
     */
    public abstract void remove(int index) throws ChainIndexOutOfBoundsException;

    /**
     * @param index
     * @return data at index
     * @throws ChainIndexOutOfBoundsException
     */
    public abstract T get(int index) throws ChainIndexOutOfBoundsException;

    /**
     * @return data at the end of the chain
     */
    public abstract T getLast();

    /**
     * @return chain data in native array representation
     */
    public abstract T[] toArray();
    
    /**
     * @return chain data in string representation
     */
    public abstract String toString();

    /**
     * @param index
     * @return index out of bounds exception for given index
     */
    protected ChainIndexOutOfBoundsException indexOutOfBounds(int index)
    {
        return new ChainIndexOutOfBoundsException("Index " + Integer.toString(index) + " out of bounds for length " + Integer.toString(length));
    }
}
