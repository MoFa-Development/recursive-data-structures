package structures.chain;

import java.util.Collection;

import exceptions.ChainIndexOutOfBoundsException;


/**
 * Abstract chain
 * 
 * @author Moritz Decker 
 * @version v1.0.1-2021-09-23
 */
public abstract class Chain<E> implements Collection<E>
{    
    protected int length = 0;

    /**
     * @return total length of the chain
     */
    @Override
    public int size()
    {
        return this.length;
    }

    /**
     * Store data at specific index
     * 
     * @param obj data to store
     * @param index
     * @throws ChainIndexOutOfBoundsException
     */
    public abstract boolean add(E obj, int index) throws ChainIndexOutOfBoundsException;

    /**
     * Remove data at specific index
     * 
     * @param index 
     * @throws ChainIndexOutOfBoundsException
     */
    public abstract boolean remove(int index) throws ChainIndexOutOfBoundsException;

    /**
     * @param index
     * @return data at index
     * @throws ChainIndexOutOfBoundsException
     */
    public abstract E get(int index) throws ChainIndexOutOfBoundsException;

    /**
     * @return data at the end of the chain
     */
    public abstract E getLast();

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
