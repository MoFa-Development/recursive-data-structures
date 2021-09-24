package structures.chain.down;

import structures.chain.ChainElement;

/**
 * Element of a downwards only chain
 * 
 * @author Moritz Decker, Fabian Kessler
 * @version v1.0.0-2021-09-22
 */
public class ChainDownElement<E> extends ChainElement<E>
{
    private ChainDownElement<E> nextElem;


    public ChainDownElement()
    {
        super(null);
        this.nextElem = null;
    }

    public ChainDownElement(E obj)
    {
        super(obj);
        this.nextElem = null;
    }

    public ChainDownElement(E obj, ChainDownElement<E> nextElem)
    {
        super(obj);
        this.nextElem = nextElem;
    }


    public void setNext(ChainDownElement<E> nextElem)
    {
        this.nextElem = nextElem;
    }

    public ChainDownElement<E> getNext()
    {
        return this.nextElem;
    }

    public boolean hasNext()
    {
        return getNext() != null;
    }
}
