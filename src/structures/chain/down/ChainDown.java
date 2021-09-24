package structures.chain.down;

import structures.chain.Chain;

import java.util.ArrayList;
import java.util.Arrays;

import exceptions.ChainIndexOutOfBoundsException;

/**
 * Downwards only chain 
 * 
 * @author Moritz Decker, Fabian Kessler
 * @version v1.0.0-2021-09-22
 */
public class ChainDown<T> extends Chain<T>
{
    protected ChainDownElement<T> firstElement;
    protected ChainDownElement<T> lastElement;
    
    
    @Override
    public void add(T obj)
    {
        ChainDownElement<T> elem = new ChainDownElement<T>(obj);
        
        if(firstElement == null) {
            firstElement = elem;
            lastElement = elem;
        }
        else {
            lastElement.setNext(elem);
            lastElement = elem;
        }

        length++;
    }

    @Override
    public void add(T obj, int index) throws ChainIndexOutOfBoundsException
    {
        if(index > length || index < 0) {
            throw indexOutOfBounds(index);
        }
        
        ChainDownElement<T> elem = new ChainDownElement<T>(obj);
        
        if(index == 0) {
            if(firstElement != null) {
                ChainDownElement<T> formerFirstElement = firstElement;
                elem.setNext(formerFirstElement);
            }

            firstElement = elem;
            
            if(length == 0) {
                lastElement = elem;
            }
        }
        else {
            ChainDownElement<T> predecessorElem = getElement(index-1);
            predecessorElem.setNext(elem);
            elem.setNext(predecessorElem.getNext());
        }

        length++;
    }

    @Override
    public void remove(int index) throws ChainIndexOutOfBoundsException
    {
        if(index < 0 || index >= length) {
            throw indexOutOfBounds(index);
        }

        // can return null, which would also be correct
        ChainDownElement<T> elemAfterIndex = getElement(index+1);

        if(index > 0) {
            ChainDownElement<T> predecessorElem = getElement(index-1);
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
    protected ChainDownElement<T> getElement(int index)
    {
        //? Is this even a good idea?
        if(index < 0 || index >= length) {
            return null;
        }

        ChainDownElement<T> currentElement = firstElement;
        
        for(int i = 0; i < index; i++) {
            if(currentElement != null) {
                currentElement = currentElement.getNext();
            }
            else {
                return null;
            }
        }
        
        return currentElement;
    }

    @Override
    public T get(int index) throws ChainIndexOutOfBoundsException
    {
        if(index < 0 || index >= length) {
            throw indexOutOfBounds(index);
        }
        
        ChainDownElement<T> elem = getElement(index);
        
        if(elem == null) {
            throw indexOutOfBounds(index);
        }

        return elem.get();
    }

    @Override
    public T getLast() {
        return lastElement.get();
    }

    @SuppressWarnings("unchecked")
    @Override
    public T[] toArray()
    {
        ArrayList<T> list = new ArrayList<T>();
        ChainDownElement<T> currentElement = firstElement;
        
        for(int i = 0; i < getLength(); i++) {
            if(currentElement != null) {
                list.add(currentElement.get());
                
                currentElement = currentElement.getNext();
            }
            else {
                return null;
            }
        }
        
        T[] array = (T[]) list.toArray();

        return array;
    }

    @Override
    public String toString()
    {
        return Arrays.toString(toArray());
    }

}
