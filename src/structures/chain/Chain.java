package structures.chain;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import exceptions.ChainIndexOutOfBoundsException;

/**
 * Abstract chain
 * 
 * @author Moritz Decker 
 * @version v1.0.1-2021-09-23
 */
public abstract class Chain<E> extends AbstractList<E>
{    
    protected int length = 0;


    public void shrink(int amount) {
        this.length -= amount;
    }

    public void addAll(E[] arr) {
        for(E obj: arr) {
            this.add(obj);
        }
    }

    @Override
    public void clear()
    {
        setFirstElem(null);
        setLastElem(null);
    }
    
    /**
     * @param index
     * @return data at index
     * @throws ChainIndexOutOfBoundsException
     */
    public abstract E get(int index);

    /**
     * @param index 
     * @return element at spcified index or null if index out of bounds
     */
    public abstract ChainElement<E> getElem(int index);

    /**
     * @return data at the beginning of the chain
     */
    public E getFirst() {
        ChainElement<E> firstElem = this.getFirstElem();
        
        if(firstElem == null) {
            return null;
        }

        return firstElem.get();
    }

    /**
     * @return first element of the chain
     */
    public abstract ChainElement<E> getFirstElem();

    /**
     * @return data at the end of the chain
     */
    public E getLast() {
        ChainElement<E> lastElem = this.getLastElem();
        
        if(lastElem == null) {
            return null;
        }

        return lastElem.get();
    }

    /**
     * @return last element of the chain
     */
    public abstract ChainElement<E> getLastElem();

    /**
     * @param index
     * @return index out of bounds exception for given index
     */
    protected ChainIndexOutOfBoundsException indexOutOfBounds(int index)
    {
        return new ChainIndexOutOfBoundsException("Index " + Integer.toString(index) + " out of bounds for length " + Integer.toString(length));
    }

    @Override
    public Iterator<E> iterator()
    {
        return listIterator();
    }

    @Override
    public abstract ListIterator<E> listIterator();

    @Override
    public abstract E remove(int index);

    @Override
    public E set(int index, E obj) throws ChainIndexOutOfBoundsException {
        if(index < 0 || index >= length) {
            throw indexOutOfBounds(index);
        }
        
        ChainElement<E> elem = getElem(index);

        if(elem == null) {
            throw indexOutOfBounds(index);
        }

        elem.set(obj);

        return obj;
    }
    
    /**
     * Set first element
     * @param firstElement
     */
    public abstract void setFirstElem(ChainElement<E> firstElement);

    /**
     * Set last element
     * @param lastElement
     */
    public abstract void setLastElem(ChainElement<E> lastElement);

    @Override
    public int size()
    {
        return this.length;
    }

    @Override
    public abstract List<E> subList(int fromIndex, int toIndex);

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + length;
        return result;
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean equals(Object obj) {
        if(obj == null) {
            return false;
        }
        
        if(this == obj) {
            return true;
        }
            
        try {
            if (!super.equals(obj))
                return false;    
        } catch (Exception ignored) {}
        
        if (getClass() != obj.getClass())
            return false;

        Chain<E> other = (Chain<E>) obj;
        
        if(length != other.length)
            return false;

        Iterator<E> otherIter = other.iterator();
        Iterator<E> iter = this.iterator();

        while(otherIter.hasNext() && iter.hasNext()) {
            if(otherIter.next() != iter.next()) {
                return false;
            }
        }

        return true;
    }
}
