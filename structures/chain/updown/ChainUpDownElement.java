package structures.chain.updown;

import structures.chain.down.ChainDownElement;

public class ChainUpDownElement<T> extends ChainDownElement<T>
{
    private ChainUpDownElement<T> prevElem;

    public ChainUpDownElement() {
        super();
        this.prevElem = null;
    }

    public ChainUpDownElement(T obj) {
        super(obj);
        this.prevElem = null;
    }

    public ChainUpDownElement(T obj, ChainUpDownElement<T> prevElem, ChainUpDownElement<T> nextElem) {
        super(obj, nextElem);
        this.prevElem = prevElem;
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
        return this.prevElem == null;
    }
}
