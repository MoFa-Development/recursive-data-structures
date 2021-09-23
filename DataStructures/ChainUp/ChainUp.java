package DataStructures.ChainUp;

import Exceptions.ChainIndexOutOfBoundsException;
import java.util.ArrayList;
import java.util.Arrays;

import DataStructures.Chain.Chain;

/**
 * Upwards only chained list of s 
 * 
 * @author Moritz Decker, Fabian Kessler
 * @version v1.0.0-2021-09-22
 */
public class ChainUp<T> extends Chain<T>
{
    private ChainUpElement<T> firstElement;
    private ChainUpElement<T> lastElement;

    public ChainUp()
    {
        firstElement = null;
        lastElement = null;
        
        length = 0;
    }

    /**
     * Append  at the end of the chain
     * 
     * @param obj  to store
     */
    @Override
    public void add(T obj)
    {
        ChainUpElement<T> elem = new ChainUpElement<T>(obj);
        
        if(firstElement == null) {
            firstElement = elem;
            lastElement = elem;
        } else {
            lastElement.setNext(elem);
            lastElement = elem;
        }

        length++;
    }

    /**
     * Store  at specific index
     * 
     * @param obj  so store
     * @param index index to store  at
     * @throws ChainIndexOutOfBoundsException
     */
    @Override
    public void add(T obj, int index) throws ChainIndexOutOfBoundsException
    {
        if(index > length || index < 0) {
            throw new ChainIndexOutOfBoundsException("Index " + Integer.toString(index) + " out of bounds for length " + Integer.toString(length));
        }
        
        ChainUpElement<T> elem = new ChainUpElement<T>(obj);
        
        if(index == 0) {
            if(firstElement != null) {
                ChainUpElement<T> formerFirstElement = firstElement;
                elem.setNext(formerFirstElement);
            }

            firstElement = elem;
            
            if(length == 0) {
                lastElement = elem;
            }
        } else {
            ChainUpElement<T> predecessorElem = getElem(index-1);
            predecessorElem.setNext(elem);
            elem.setNext(predecessorElem.getNext());
        }

        length++;
    }

    /**
     * Remove  at given index from chain 
     * 
     * @param index
     * @throws ChainIndexOutOfBoundsException
     */
    @Override
    public void remove(int index) throws ChainIndexOutOfBoundsException
    {
        if(index >= length || index < 0) {
            throw new ChainIndexOutOfBoundsException("Index " + Integer.toString(index) + " out of bounds for length " + Integer.toString(length));
        }

        // can return null, which would also be correct
        ChainUpElement<T> elemAfterIndex = getElem(index+1);

        if(index > 0) {
            ChainUpElement<T> predecessorElem = getElem(index-1);
            predecessorElem.setNext(elemAfterIndex);
        }

        if(index == 0) {
            firstElement = elemAfterIndex; 
        }

        length--;
    }

    /**
     * @return ObjecChainUpElement at spcified index or null if index out of bounds
     * @param index the index to get the element from
     */
    private ChainUpElement<T> getElem(int index)
    {
        //? Is this even a good idea?
        if(index < 0 || index > length) {
            return null;
        }

        ChainUpElement<T> currentElement = firstElement;
        
        for(int i = 0; i < index; i++) {
            if(currentElement != null) {
                currentElement = currentElement.getNext();
            } else {
                return null;
            }
        }
        
        return currentElement;
    }

    /**
     * @param index
     * @return  at given index
     */
    @Override
    public T get(int index)
    {
        return getElem(index).get();
    }

    /**
     * @return at the end of the chain
     */
    @Override
    public T getLast() {
        return lastElement.get();
    }

    /**
     * @return Array of stored objects
     */
    @SuppressWarnings("unchecked")
    @Override
    public T[] toArray()
    {
        ArrayList<T> list = new ArrayList<T>();
        ChainUpElement<T> currentElement = firstElement;
        
        for(int i = 0; i < getLength(); i++) {
            if(currentElement != null) {
                list.add(currentElement.get());
                
                currentElement = currentElement.getNext();
            } else {
                return null;
            }
        }
        
        T[] array = (T[]) list.toArray();

        return array;
    }

    /**
     * @return String representation of the whole chain
     */
    @Override
    public String toString()
    {
        return Arrays.toString(toArray());
    }

}
