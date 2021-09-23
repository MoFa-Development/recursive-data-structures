package DataStructures.ChainUpDown;

public class ChainUpDownElement<T> {
    private ChainUpDownElement<T> prevElem;
    private ChainUpDownElement<T> nextElem;

    private T obj;


    public ChainUpDownElement() {
        this.prevElem = null;
        this.nextElem = null;

        this.obj = null;
    }

    public ChainUpDownElement(T obj) {
        this.prevElem = null;
        this.nextElem = null;
        
        this.obj = obj;
    }

    public ChainUpDownElement(T obj, ChainUpDownElement<T> prev, ChainUpDownElement<T> next) {
        this.prevElem = prev;
        this.nextElem = next;

        this.obj = obj;
    }


    public T get()
    {
        return this.obj;
    }

    public void setNext(ChainUpDownElement<T> nextElem)
    {
        this.nextElem = nextElem;
    }

    public ChainUpDownElement<T> getNext()
    {
        return this.nextElem;
    }

    public boolean hasNext()
    {
        return this.nextElem == null;
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
