package structures.chain.util;

import java.util.ListIterator;

import structures.chain.Chain;
import structures.chain.down.ChainDownElement;
import structures.chain.updown.ChainUpDownElement;

public class ChainUpDownListIterator<E> extends ChainDownIterator<E> implements ListIterator<E> {
    
    protected Chain<E> chain;
    private ChainUpDownElement<E> currElem;
    protected int index;

    public ChainUpDownListIterator(Chain<E> chain, ChainDownElement<E> beginElem)
    {
        super(beginElem);
        index = 0;
        this.chain = chain;
    }

    public ChainUpDownListIterator(Chain<E> chain, int index)
    {
        super((ChainDownElement<E>) chain.getElem(index));
        index = 0;
        this.chain = chain;
    }

    @Override
    public ChainDownElement<E> getCurrElem()
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
        // TODO implement
        return false;
    }

    @Override
    public int nextIndex()
    {
        // TODO Auto-generated method stub
        return -1;
    }

    @Override
    public E previous()
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int previousIndex()
    {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void remove()
    {
        // TODO Auto-generated method stub
    }

    @Override
    public void set(E e)
    {
        // TODO Auto-generated method stub
    }
}
