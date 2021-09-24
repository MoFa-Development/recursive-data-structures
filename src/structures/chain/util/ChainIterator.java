package structures.chain.util;

import java.util.Iterator;
import java.util.NoSuchElementException;

import structures.chain.down.ChainDownElement;

public class ChainIterator<E> implements Iterator<E> {

    private ChainDownElement<E> currentElement;

    public ChainIterator(ChainDownElement<E> beginElem) {
        this.currentElement = beginElem;
    }

    @Override
    public boolean hasNext() {
        return currentElement != null;
    }

    @Override
    public E next() {
        if(currentElement == null) {
            throw new NoSuchElementException("Iterated over end of the chain.");
        }

        E obj = currentElement.get();
        currentElement = currentElement.getNext();

        return obj;
    }
    
}
