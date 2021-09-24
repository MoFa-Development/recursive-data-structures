package structures.chain.updown;

import structures.chain.down.ChainDownElement;

/**
 * Element of a double-linked chain
 * 
 * @author Moritz Decker 
 * @version v1.0.1-2021-09-23
 */
public class ChainUpDownElement<E> extends ChainDownElement<E>
{
    private ChainUpDownElement<E> prevElem;
    private ChainUpDownElement<E> nextElem;

    public ChainUpDownElement() {
        super(null);
        this.prevElem = null;
    }

    public ChainUpDownElement(E obj) {
        super(obj);
        this.prevElem = null;
    }

    public ChainUpDownElement(E obj, ChainUpDownElement<E> prevElem, ChainUpDownElement<E> nextElem)
    {
        super(obj);
        this.prevElem = prevElem;
        this.nextElem = nextElem;
    }


    public void setNext(ChainUpDownElement<E> nextElem)
    {
        this.nextElem = nextElem;
    }

    @Override
    public ChainUpDownElement<E> getNext()
    {
        return this.nextElem;
    }

    public void setPrev(ChainUpDownElement<E> prevElem)
    {
        this.prevElem = prevElem;
    }

    public ChainUpDownElement<E> getPrev()
    {
        return this.prevElem;
    }

    public boolean hasPrev()
    {
        return getPrev() != null;
    }
}
