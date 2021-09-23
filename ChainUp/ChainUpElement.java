package ChainUp;

/**
 * Element of an upwards chained list of Objects
 * 
 * @author Moritz Decker, Fabian Kessler
 * @version v1.0.0-2021-09-22
 */
public class ChainUpElement<T>
{
    private T obj;
    private ChainUpElement<T> nextElem;


    public ChainUpElement()
    {
        this.obj = null;
        this.nextElem = null;
    }

    public ChainUpElement(T obj)
    {
        this.obj = obj;
        this.nextElem = null;
    }

    public ChainUpElement(T obj, ChainUpElement<T> nextElem)
    {
        this.obj = obj;
        this.nextElem = nextElem;
    }

    /**
     * Returns the element's object
     * 
     */
    public T get()
    {
        return this.obj;
    }

    public void setNext(ChainUpElement<T> nextElem)
    {
        this.nextElem = nextElem;
    }

    public ChainUpElement<T> getNext()
    {
        return this.nextElem;
    }

    public boolean hasNext()
    {
        return this.nextElem == null;
    }
}
