package structures.chain.down;

import structures.chain.Chain;
import structures.chain.ChainElement;
import structures.chain.util.ChainDownIterator;

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


    @Override
    public ChainElement<E> getFirstElement()
    {
        return firstElement;
    }

    @Override
    public ChainElement<E> getLastElement()
    {
        return lastElement;
    }

    @Override
    public void setFirstElement(ChainElement<E> firstElement)
    {
        this.firstElement = (ChainDownElement<E>) firstElement;
    }

    @Override
    public void setLastElement(ChainElement<E> lastElement)
    {
        this.lastElement = (ChainDownElement<E>) lastElement;
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

    @Override
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
    public ChainDownIterator<E> iterator()
    {
        return new ChainDownIterator<>((ChainDownElement<E>) this.getFirstElement());
    }
}
