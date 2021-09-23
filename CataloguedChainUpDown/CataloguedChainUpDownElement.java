package CataloguedChainUpDown;

public class CataloguedChainUpDownElement<T> {
    private CataloguedChainUpDownElement<T> prevElem;
    private CataloguedChainUpDownElement<T> nextElem;

    private T obj;


    public CataloguedChainUpDownElement() {
        this.prevElem = null;
        this.nextElem = null;

        this.obj = null;
    }

    public CataloguedChainUpDownElement(T obj) {
        this.prevElem = null;
        this.nextElem = null;
        
        this.obj = obj;
    }

    public CataloguedChainUpDownElement(T obj, CataloguedChainUpDownElement<T> prev, CataloguedChainUpDownElement<T> next) {
        this.prevElem = prev;
        this.nextElem = next;

        this.obj = obj;
    }


    public T get()
    {
        return this.obj;
    }

    public void setNext(CataloguedChainUpDownElement<T> nextElem)
    {
        this.nextElem = nextElem;
    }

    public CataloguedChainUpDownElement<T> getNext()
    {
        return this.nextElem;
    }

    public boolean hasNext()
    {
        return this.nextElem == null;
    }

    public void setPrev(CataloguedChainUpDownElement<T> prevElem)
    {
        this.prevElem = prevElem;
    }

    public CataloguedChainUpDownElement<T> getPrev()
    {
        return this.prevElem;
    }

    public boolean hasPrev()
    {
        return this.prevElem == null;
    }
}
