package structures.chain.updown;

import structures.chain.down.ChainDownElement;

/**
 * Element of a double-linked chain
 * 
 * @author Moritz Decker 
 * @version v1.0.1-2021-09-23
 */
public class ChainUpDownElement<T> extends ChainDownElement<T>
{
    protected ChainUpDownElement<T> prevElem;
    protected ChainUpDownElement<T> nextElem;

    public ChainUpDownElement() {
        super(null);
        this.prevElem = null;
    }

    public ChainUpDownElement(T obj) {
        super(obj);
        this.prevElem = null;
    }

    public ChainUpDownElement(T obj, ChainUpDownElement<T> prevElem, ChainUpDownElement<T> nextElem)
    {
        super(obj);
        this.prevElem = prevElem;
        this.nextElem = nextElem;
    }


    public void setNext(ChainUpDownElement<T> nextElem)
    {
        this.nextElem = nextElem;
        super.nextElem = nextElem;
    }

    public ChainUpDownElement<T> getNext()
    {
        return this.nextElem;
    }

    public void setPrev(ChainUpDownElement<T> prevElem)
    {
        this.prevElem = prevElem;
    }

    public ChainUpDownElement<T> getPrev()
    {
        return this.prevElem;
    }

    public boolean hasPrev()
    {
        return this.prevElem != null;
    }
}
