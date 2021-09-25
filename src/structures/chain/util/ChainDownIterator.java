package structures.chain.util;

import java.util.ListIterator;
import java.util.NoSuchElementException;

import structures.chain.Chain;
import structures.chain.down.ChainDownElement;

public class ChainDownIterator<E> implements ListIterator<E> {
    
    private Chain<E> chain;
    private ChainDownElement<E> prevElem;
    private ChainDownElement<E> currElem;
    private int index;

    public ChainDownIterator(Chain<E> chain, ChainDownElement<E> beginElem)
    {
        index = 0;
        this.chain = chain;
        this.currElem = beginElem;
    }

    @Override
    public boolean hasNext()
    {
        return currElem != null;
    }

    @Override
    public E next()
    {
        if(currElem == null) {
            throw new NoSuchElementException("Iterated over end of the chain.");
        }

        E obj = currElem.get();
        currElem = currElem.getNext();

        return obj;
    }
    
    public ChainDownElement<E> getCurrentElement() {
        return currElem;
    }

    @Override
    public void add(E e) {
        chain.add(index, e);
    }

    @Override
    public boolean hasPrevious() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public int nextIndex() {
        // TODO Auto-generated method stub
        return -1;
    }

    @Override
    public E previous() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int previousIndex() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void remove() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void set(E e) {
        // TODO Auto-generated method stub
        
    }
}
