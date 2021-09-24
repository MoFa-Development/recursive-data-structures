package structures.chain.updown;

import java.util.ArrayList;

import exceptions.ChainIndexOutOfBoundsException;
import structures.chain.ChainElement;
import structures.chain.down.ChainDown;
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
    public ChainElement<E> getFirstElement() {
        return firstElement;
    }

    @Override
    public ChainElement<E> getLastElement() {
        return lastElement;
    }

    @Override
    public void setFirstElement(ChainElement<E> firstElement) {
        this.firstElement = (ChainUpDownElement<E>) firstElement;
    }

    @Override
    public void setLastElement(ChainElement<E> lastElement) {
        this.lastElement = (ChainUpDownElement<E>) lastElement;
    }

    @Override
    public boolean add(E obj)
    {
        ChainUpDownElement<E> elem = new ChainUpDownElement<>(obj);
        
        if(getFirstElement() == null) {
            setFirstElement(elem);
            setLastElement(elem);
        }
        else {
            ((ChainUpDownElement<E>) getLastElement()).setNext(elem);
            elem.setPrev((ChainUpDownElement<E>) getLastElement());

            setLastElement(elem);
        }

        length++;

        return true;
    }

    @Override
    public boolean add(E obj, int index) throws ChainIndexOutOfBoundsException
    {
        if(index < 0 || index > length) {
            throw indexOutOfBounds(index);
        }

        ChainUpDownElement<E> elem = new ChainUpDownElement<>(obj);
        
        if(index == 0) {
            if(getFirstElement() != null) {
                ChainUpDownElement<E> formerFirstElement = (ChainUpDownElement<E>) getFirstElement();
                elem.setNext(formerFirstElement);
                formerFirstElement.setPrev(elem);
            }

            setFirstElement(elem);
            
            if(length == 0) {
                setLastElement(elem);
            }
        }
        else {
            ChainUpDownElement<E> predecessorElement = getElement(index-1);
            ChainUpDownElement<E> elementAtIndex = predecessorElement.getNext();

            predecessorElement.setNext(elem);
            elem.setPrev(predecessorElement);

            if(elementAtIndex != null) {
                elem.setNext(elementAtIndex);
                elementAtIndex.setPrev(elem);
            } else {
                setLastElement(elem);
            }
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
        
        ChainUpDownElement<E> elementAtIndex = getElement(index);
        
        if(elementAtIndex.hasNext()) {
            elementAtIndex.getNext().setPrev(elementAtIndex.getPrev());
        } else {
            setLastElement(elementAtIndex.getPrev());
        }

        if(elementAtIndex.hasPrev()) {
            elementAtIndex.getPrev().setNext(elementAtIndex.getNext());
        } else {
            setFirstElement(elementAtIndex.getNext());
        }

        length--;

        return true;
    }

    @Override
    protected ChainUpDownElement<E> getElement(int index)
    {
        if(index < 0 || index >= length) {
            return null;
        }
        
        if(index <= length/2) {
             return (ChainUpDownElement<E>) super.getElement(index);
        }
        else {
            ChainUpDownElement<E> currentElement = (ChainUpDownElement<E>) getLastElement();
            
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
    public E getLast() {
        return getLastElement().get();
    }

    @SuppressWarnings("unchecked")
    @Override
    public E[] toArray()
    {
        ArrayList<E> list = new ArrayList<>();
        ChainUpDownElement<E> currentElement = (ChainUpDownElement<E>) getFirstElement();
        
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
}
