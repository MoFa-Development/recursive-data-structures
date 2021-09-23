package structures.chain.updown;

import exceptions.ChainIndexOutOfBoundsException;
import structures.chain.down.ChainDown;

public class ChainUpDown<T> extends ChainDown<T>
{
    protected ChainUpDownElement<T> firstElement;
    protected ChainUpDownElement<T> lastElement;
    

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

    @Override
    protected ChainUpDownElement<T> getElement(int index)
    {
        if(index < 0 || index >= length) {
            return null;
        }
        
        if(index < length/2) {
            ChainUpDownElement<T> currentElement = firstElement;
            
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
        else {
            ChainUpDownElement<T> currentElement = lastElement;
            
            for(int i = length; i > index; i--) {
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
}
