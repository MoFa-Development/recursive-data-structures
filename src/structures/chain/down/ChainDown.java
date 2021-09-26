package structures.chain.down;

import structures.chain.Chain;
import structures.chain.ChainElement;
import structures.chain.util.ChainDownIterator;

import java.util.ListIterator;

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
    public ChainElement<E> getFirstElem()
    {
        return firstElement;
    }

    @Override
    public ChainElement<E> getLastElem()
    {
        return lastElement;
    }

    @Override
    public void setFirstElem(ChainElement<E> firstElement)
    {
        this.firstElement = (ChainDownElement<E>) firstElement;
    }

    @Override
    public void setLastElem(ChainElement<E> lastElement)
    {
        this.lastElement = (ChainDownElement<E>) lastElement;
    }


    @Override
    public boolean add(E obj)
    {
        ChainDownElement<E> elem = new ChainDownElement<>(obj);
        
        if(getFirstElem() == null) {
            setFirstElem(elem);
            setLastElem(elem);
        }
        else {
            ((ChainDownElement<E>) getLastElem()).setNext(elem);
            setLastElem(elem);
        }

        length++;

        return true;
    }

    @Override
    public void add(int index, E obj) throws ChainIndexOutOfBoundsException
    {
        if(index > length || index < 0) {
            throw indexOutOfBounds(index);
        }
        
        ChainDownElement<E> elem = new ChainDownElement<>(obj);
        
        if(index == 0) {
            if(getFirstElem() != null) {
                ChainDownElement<E> formerFirstElement = (ChainDownElement<E>) getFirstElem();
                elem.setNext(formerFirstElement);
            }

            setFirstElem(elem);
            
            if(length == 0) {
                setLastElem(elem);
            }
        }
        else {
            ChainDownElement<E> predecessorElem = getElem(index-1);
            predecessorElem.setNext(elem);
            elem.setNext(predecessorElem.getNext());
        }

        length++;
    }

    @Override
    public E remove(int index) throws ChainIndexOutOfBoundsException
    {   
        if(index < 0 || index >= length) {
            throw indexOutOfBounds(index);
        }

        ChainDownElement<E> elem = null;

        if(index > 0) {
            ChainDownElement<E> predecessorElem = getElem(index-1);
            elem = predecessorElem.getNext();

            predecessorElem.setNext(elem.getNext());
        }
        else {
            elem = getElem(index);

            setFirstElem(elem.getNext()); 
        }

        length--;

        return elem.get();
    }

    @Override
    public ChainDownElement<E> getElem(int index)
    {
        //? Is this even a good idea?
        if(index < 0 || index >= length) {
            return null;
        }

        ChainDownElement<E> currentElement = (ChainDownElement<E>) getFirstElem();
        
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
        
        ChainDownElement<E> elem = getElem(index);
        
        if(elem == null) {
            throw indexOutOfBounds(index);
        }

        return elem.get();
    }

    @Override
    public ChainDownIterator<E> iterator()
    {
        return new ChainDownIterator<>((ChainDownElement<E>) this.getFirstElem());
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public E set(int arg0, E arg1) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @param fromIndex
     * @param toIndex
     * @return new PackagedChainUpDown with contents of chain in between given indicies
     */
    @Override
    public ChainDown<E> subList(int fromIndex, int toIndex)
    {
        ChainDown<E> subChain = new ChainDown<>();
        
        ChainDownElement<E> beginElem = getElem(fromIndex);
        ChainDownIterator<E> iter = new ChainDownIterator<>(beginElem);
        
        for(int i = 0; i <= toIndex - fromIndex; i++) {
            subChain.add(iter.next());
        }
        
        return subChain;
    }
}
