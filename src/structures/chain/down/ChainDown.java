package structures.chain.down;

import structures.chain.Chain;
import structures.chain.ChainElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

import exceptions.ChainIndexOutOfBoundsException;

/**
 * Downwards only chain 
 * 
 * @author Moritz Decker, Fabian Kessler
 * @version v1.0.0-2021-09-22
 */
public class ChainDown<E> extends Chain<E>
{
    private ChainDownElement<E> firstElement;
    private ChainDownElement<E> lastElement;


    public ChainElement<E> getFirstElement() {
        return firstElement;
    }

    public ChainElement<E> getLastElement() {
        return lastElement;
    }

    public void setFirstElement(ChainElement<E> firstElement) {
        this.firstElement = (ChainDownElement<E>) firstElement;
    }

    public void setLastElement(ChainElement<E> lastElement) {
        this.lastElement = (ChainDownElement<E>) lastElement;
    }

    @Override
    public void clear() {
        setFirstElement(null);
        setLastElement(null);
    }
    
    @Override
    public boolean add(E obj)
    {
        ChainDownElement<E> elem = new ChainDownElement<>(obj);
        
        if(getFirstElement() == null) {
            setFirstElement(elem);
            setLastElement(elem);
        }
        else {
            ((ChainDownElement<E>) getLastElement()).setNext(elem);
            setLastElement(elem);
        }

        length++;

        return true;
    }

    @Override
    public boolean add(E obj, int index) throws ChainIndexOutOfBoundsException
    {
        if(index > length || index < 0) {
            throw indexOutOfBounds(index);
        }
        
        ChainDownElement<E> elem = new ChainDownElement<>(obj);
        
        if(index == 0) {
            if(getFirstElement() != null) {
                ChainDownElement<E> formerFirstElement = (ChainDownElement<E>) getFirstElement();
                elem.setNext(formerFirstElement);
            }

            setFirstElement(elem);
            
            if(length == 0) {
                setLastElement(elem);
            }
        }
        else {
            ChainDownElement<E> predecessorElem = getElement(index-1);
            predecessorElem.setNext(elem);
            elem.setNext(predecessorElem.getNext());
        }

        length++;
    
        return true;
    }

    @Override
    public boolean remove(int index) throws ChainIndexOutOfBoundsException
    {
        if(index < 0 || index >= length) {
            throw indexOutOfBounds(index);
        }

        // can return null, which would also be correct
        ChainDownElement<E> elemAfterIndex = getElement(index+1);

        if(index > 0) {
            ChainDownElement<E> predecessorElem = getElement(index-1);
            predecessorElem.setNext(elemAfterIndex);
        }

        if(index == 0) {
            setFirstElement(elemAfterIndex); 
        }

        length--;

        return true;
    }

    /**
     * @return ObjecChainUpElement at spcified index or null if index out of bounds
     * @param index the index to get the element from
     */
    protected ChainDownElement<E> getElement(int index)
    {
        //? Is this even a good idea?
        if(index < 0 || index >= length) {
            return null;
        }

        ChainDownElement<E> currentElement = (ChainDownElement<E>) getFirstElement();
        
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
    public E get(int index) throws ChainIndexOutOfBoundsException
    {
        if(index < 0 || index >= length) {
            throw indexOutOfBounds(index);
        }
        
        ChainDownElement<E> elem = getElement(index);
        
        if(elem == null) {
            throw indexOutOfBounds(index);
        }

        return elem.get();
    }

    @Override
    public E getLast() {
        return getLastElement().get();
    }

    @SuppressWarnings("unchecked")
    @Override
    public E[] toArray()
    {
        ArrayList<E> list = new ArrayList<>();
        ChainDownElement<E> currentElement = (ChainDownElement<E>) getFirstElement();
        
        for(int i = 0; i < size(); i++) {
            if(currentElement != null) {
                list.add(currentElement.get());
                
                currentElement = currentElement.getNext();
            }
            else {
                return null;
            }
        }
        
        return (E[]) list.toArray();
    }

    @Override
    public String toString()
    {
        return Arrays.toString(toArray());
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean contains(Object o) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean remove(Object o) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        // TODO Auto-generated method stub
        return null;
    }
}
