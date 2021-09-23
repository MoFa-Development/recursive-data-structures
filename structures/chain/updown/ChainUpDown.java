package structures.chain.updown;

import java.util.ArrayList;

import exceptions.ChainIndexOutOfBoundsException;
import structures.chain.down.ChainDown;

public class ChainUpDown<T> extends ChainDown<T>
{
    protected ChainUpDownElement<T> firstElement;
    protected ChainUpDownElement<T> lastElement;

    @Override
    public void add(T obj)
    {
        ChainUpDownElement<T> elem = new ChainUpDownElement<T>(obj);
        
        if(firstElement == null) {
            firstElement = elem;
            lastElement = elem;
        }
        else {
            lastElement.setNext(elem);
            elem.setPrev(lastElement);

            lastElement = elem;
        }

        length++;
    }

    @Override
    public void add(T obj, int index) throws ChainIndexOutOfBoundsException
    {
        if(index < 0 || index >= length) {
            throw indexOutOfBounds(index);
        }

        // TODO implement
    }

    @Override
    public void remove(int index) throws ChainIndexOutOfBoundsException
    {
        if(index < 0 || index >= length) {
            throw indexOutOfBounds(index);
        }

        // TODO implement
    }

    protected ChainUpDownElement<T> getElement(int index)
    {
        if(index < 0 || index >= length) {
            return null;
        }
        
        if(index <= length/2) {
            ChainUpDownElement<T> currentElement = firstElement;
            
            for(int i = 0; i < index; i++) {
                if(currentElement != null) {
                    currentElement = currentElement.nextElem;
                }
                else {
                    return null;
                }
            }
            
            return currentElement;
        }
        else {
            ChainUpDownElement<T> currentElement = lastElement;
            
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
    public T getLast() {
        return this.lastElement.get();
    }

    /**
     * @return Array of stored objects
     */
    @SuppressWarnings("unchecked")
    @Override
    public T[] toArray()
    {
        ArrayList<T> list = new ArrayList<T>();
        ChainUpDownElement<T> currentElement = firstElement;
        
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

}
