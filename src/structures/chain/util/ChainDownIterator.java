
package structures.chain.util;

import java.util.Iterator;
import java.util.NoSuchElementException;

import structures.chain.down.ChainDownElement;

public class ChainDownIterator<E> implements Iterator<E> {

    private ChainDownElement<E> currElem;

    public ChainDownIterator(ChainDownElement<E> beginElem)
    {
        setCurrElem(beginElem);
    }

    @Override
    public boolean hasNext()
    {
        return getCurrElem() != null;
    }

    @Override
    public E next()
    {
        if(getCurrElem() == null) {
            throw new NoSuchElementException("Iterated over end of the chain.");
        }

        E obj = getCurrElem().get();
        setCurrElem(getCurrElem().getNext());

        return obj;
    }
    
    public ChainDownElement<E> getCurrElem()
    {
        return this.currElem;
    }

    public void setCurrElem(ChainDownElement<E> elem)
    {
        this.currElem = elem;
    }
}