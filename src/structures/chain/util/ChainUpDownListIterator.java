package structures.chain.util;

import java.util.ListIterator;
import java.util.NoSuchElementException;

import structures.chain.Chain;
import structures.chain.down.ChainDownElement;
import structures.chain.updown.ChainUpDownElement;

public class ChainUpDownListIterator<E> extends ChainDownIterator<E> implements ListIterator<E> {
    
    protected Chain<E> chain;
    private ChainUpDownElement<E> currElem;
    protected int index;
    private ChainUpDownElement<E> lastReturnedElem;

    public int getIndex() {
        return index;
    }

    public ChainUpDownListIterator(Chain<E> chain) {
        super((ChainDownElement<E>) chain.getFirstElem());
        this.index = 0;
        this.chain = chain;
    }

    public ChainUpDownListIterator(Chain<E> chain, int index)
    {
        super((ChainDownElement<E>) chain.getElem(index));
        this.index = index;
        this.chain = chain;
    }

    public ChainUpDownListIterator(Chain<E> chain, ChainUpDownElement<E> beginElem, int index)
    {
        super(beginElem);
        this.index = index;
        this.chain = chain;
    }

    @Override
    protected void setLastReturnedElem(ChainDownElement<E> elem) {
        this.lastReturnedElem = (ChainUpDownElement<E>) elem;
    }

    @Override
    public ChainUpDownElement<E> getLastReturnedElem() {
        return lastReturnedElem;
    }

    @Override
    public E next() throws NoSuchElementException
    {
        index++;
        return nextElem().get();
    }

    @Override
    public ChainUpDownElement<E> getCurrElem()
    {
        return this.currElem;
    }

    @Override
    public void setCurrElem(ChainDownElement<E> elem)
    {
        this.currElem = (ChainUpDownElement<E>) elem;
    }

    @Override
    public void add(E e)
    {
        chain.add(index, e);
    }

    @Override
    public boolean hasPrevious()
    {
        return currElem.hasPrev();
    }

    @Override
    public int nextIndex()
    {
        return index+1;
    }

    @Override
    public E previous()
    {
        if(!hasPrevious()) {
            throw new NoSuchElementException("Iterated over end of the chain.");
        }

        E obj = getCurrElem().getPrev().get();
        setCurrElem(getCurrElem().getPrev());

        return obj;
    }

    @Override
    public int previousIndex()
    {
        return index-1;
    }

    @Override
    public void remove()
    {
        //TODO this only works with circular chains, implement first and last elem too
        
        if(chain.getFirstElem() == lastReturnedElem) {
            chain.setFirstElem(lastReturnedElem.getNext());
        }

        if(chain.getLastElem() == lastReturnedElem) {
            chain.setLastElem(lastReturnedElem.getPrev());
        }

        lastReturnedElem.getPrev().setNext(lastReturnedElem.getNext());
        lastReturnedElem.getNext().setPrev(lastReturnedElem.getPrev());
        chain.shrink(1);
    }

    @Override
    public void set(E e)
    {
        // TODO Auto-generated method stub
    }
}
