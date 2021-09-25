package structures.chain.updown;

import exceptions.ChainIndexOutOfBoundsException;
import structures.chain.ChainElement;
import structures.chain.down.ChainDown;
import structures.chain.down.ChainDownElement;
import structures.chain.util.ChainDownIterator;
/**
 * Double-linked chain
 * 
 * @author Moritz Decker 
 * @version v1.0.1-2021-09-23
 */
public class ChainUpDown<E> extends ChainDown<E>
{
    private ChainUpDownElement<E> firstElement;
    private ChainUpDownElement<E> lastElement;


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
        this.firstElement = (ChainUpDownElement<E>) firstElement;
    }

    @Override
    public void setLastElem(ChainElement<E> lastElement)
    {
        this.lastElement = (ChainUpDownElement<E>) lastElement;
    }


    @Override
    public boolean add(E obj)
    {
        ChainUpDownElement<E> elem = new ChainUpDownElement<>(obj);
        
        if(getFirstElem() == null) {
            setFirstElem(elem);
            setLastElem(elem);
        }
        else {
            ((ChainUpDownElement<E>) getLastElem()).setNext(elem);
            elem.setPrev((ChainUpDownElement<E>) getLastElem());

            setLastElem(elem);
        }

        length++;

        return true;
    }

    @Override
    public void add(int index, E obj) throws ChainIndexOutOfBoundsException
    {
        if(index < 0 || index > length) {
            throw indexOutOfBounds(index);
        }

        ChainUpDownElement<E> elem = new ChainUpDownElement<>(obj);
        
        if(index == 0) {
            if(getFirstElem() != null) {
                ChainUpDownElement<E> formerFirstElement = (ChainUpDownElement<E>) getFirstElem();
                elem.setNext(formerFirstElement);
                formerFirstElement.setPrev(elem);
            }

            setFirstElem(elem);
            
            if(length == 0) {
                setLastElem(elem);
            }
        }
        else {
            ChainUpDownElement<E> predecessorElement = getElem(index-1);
            ChainUpDownElement<E> elementAtIndex = predecessorElement.getNext();

            predecessorElement.setNext(elem);
            elem.setPrev(predecessorElement);

            if(elementAtIndex != null) {
                elem.setNext(elementAtIndex);
                elementAtIndex.setPrev(elem);
            } else {
                setLastElem(elem);
            }
        }

        length++;
    }

    @Override
    public ChainUpDownElement<E> getElem(int index)
    {
        if(index < 0 || index >= length) {
            return null;
        }
        
        if(index <= length/2) {
             return (ChainUpDownElement<E>) super.getElem(index);
        }
        else {
            ChainUpDownElement<E> currentElement = (ChainUpDownElement<E>) getLastElem();
            
            for(int i = length; i > index+1; i--) {
                if(currentElement != null) {
                    currentElement = currentElement.getPrev();
                }
                else {
                    return null;
                }
            }
            
            return currentElement;
        }
    }

    @Override
    public E remove(int index) throws ChainIndexOutOfBoundsException
    {
        if(index < 0 || index >= length) {
            throw indexOutOfBounds(index);
        }
        
        ChainUpDownElement<E> elementAtIndex = getElem(index);
        
        if(elementAtIndex.hasNext()) {
            elementAtIndex.getNext().setPrev(elementAtIndex.getPrev());
        } else {
            setLastElem(elementAtIndex.getPrev());
        }

        if(elementAtIndex.hasPrev()) {
            elementAtIndex.getPrev().setNext(elementAtIndex.getNext());
        } else {
            setFirstElem(elementAtIndex.getNext());
        }

        length--;

        return elementAtIndex.get();
    }

    /**
     * @param fromIndex
     * @param toIndex
     * @return new PackagedChainUpDown with contents of chain in between given indicies
     */
    @Override
    public ChainUpDown<E> subList(int fromIndex, int toIndex)
    {
        ChainUpDown<E> subChain = new ChainUpDown<>();
        
        ChainDownElement<E> beginElem = getElem(fromIndex);
        ChainDownIterator<E> iter = new ChainDownIterator<>(beginElem);
        
        for(int i = 0; i <= toIndex - fromIndex; i++) {
            subChain.add(iter.next());
        }
        
        return subChain;
    }
}
