
package structures.chain.util;

import java.util.Iterator;
import java.util.NoSuchElementException;

import structures.chain.down.ChainDownElement;

public class ChainDownIterator<E> implements Iterator<E> {

    private ChainDownElement<E> currElem;
    private ChainDownElement<E> lastReturnedElement;

    protected void setLastReturnedElem(ChainDownElement<E> elem) {
        this.lastReturnedElement = elem;
    }

    protected ChainDownElement<E> getLastReturnedElem() {
        return lastReturnedElement;
    }

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
        if(!hasNext()) {
            throw new NoSuchElementException("Iterated over end of the chain.");
        }

        return nextElem().get();
    }
    
    public ChainDownElement<E> getCurrElem()
    {
        return this.currElem;
    }

    public void setCurrElem(ChainDownElement<E> elem)
    {
        this.currElem = elem;
    }

    public ChainDownElement<E> nextElem() throws NoSuchElementException
    {
        if(!hasNext()) {
            throw new NoSuchElementException("Iterated over end of chain.");
        }

        ChainDownElement<E> elem = getCurrElem();
        setCurrElem(getCurrElem().getNext());

        setLastReturnedElem(elem);

        return elem;
    }
}