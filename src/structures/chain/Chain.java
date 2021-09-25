package structures.chain;

import java.util.ArrayList;
import java.util.Arrays;
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

    @Override
    public void clear()
    {
        setFirstElement(null);
        setLastElement(null);
    }
    
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
     * @param index 
     * @return element at spcified index or null if index out of bounds
     */
    protected abstract ChainElement<E> getElement(int index);

    /**
     * @return data at the beginning of the chain
     */
    public E getFirst() {
        ChainElement<E> firstElem = this.getFirstElement();
        
        if(firstElem == null) {
            return null;
        }

        return firstElem.get();
    }

    /**
     * @return data at the end of the chain
     */
    public E getLast() {
        ChainElement<E> lastElem = this.getLastElement();
        
        if(lastElem == null) {
            return null;
        }

        return lastElem.get();
    }

    /**
     * @return first element of the chain
     */
    public abstract ChainElement<E> getFirstElement();

    /**
     * @return last element of the chain
     */
    public abstract ChainElement<E> getLastElement();

    /**
     * Set first element
     * @param firstElement
     */
    public abstract void setFirstElement(ChainElement<E> firstElement);

    /**
     * Set last element
     * @param lastElement
     */
    public abstract void setLastElement(ChainElement<E> lastElement);

    /**
     * @return array representation of the chain
     */
    @SuppressWarnings("unchecked")
    public E[] toArray()
    {
        ArrayList<E> list = new ArrayList<>();
        
        for(E obj: this) {
            list.add(obj);
        }
        
        return (E[]) list.toArray();
    }

    /**
     * @return array representation of the chain
     */
    @SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] a)
    {
        return (T[]) toArray();
    }

    /**
     * @return string representation of the chain
     */
    public String toString()
    {
        return Arrays.toString(toArray());
    }

    /**
     * @param index
     * @return index out of bounds exception for given index
     */
    protected ChainIndexOutOfBoundsException indexOutOfBounds(int index)
    {
        return new ChainIndexOutOfBoundsException("Index " + Integer.toString(index) + " out of bounds for length " + Integer.toString(length));
    }

    @Override
    public boolean addAll(Collection<? extends E> collection)
    {
        for(E elem: collection) {
            add(elem);
        }
        return true;
    }

    @Override
    public boolean isEmpty()
    {
        return length == 0;
    }

    @Override
    public boolean remove(Object o)
    {
        int index = 0;

        for(E elem: this) {
            if(o == elem) {
                try {
                    remove(index);
                } catch (ChainIndexOutOfBoundsException e) {
                    return false;
                }
            }
            index++;
        }

        return true;
    }

    @Override
    public boolean contains(Object obj)
    {
        for(E elem: this) {
            if(elem == obj) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c)
    {
        for(Object o: c) {
            if(!this.contains(o)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c)
    {
        for(Object elem: c) {
            boolean success = remove(elem);
            
            if(!success) {
                return false;
            }
        }

        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c)
    {
        int index = 0;

        for(E elem: this) {
            if(!c.contains(elem)) {
                try {
                    remove(index);
                    index--;
                } catch (ChainIndexOutOfBoundsException e) {
                    return false;
                }
            }
            index++;
        }

        return true;
    }
}
