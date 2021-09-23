package DataStructures.ChainDown;

/**
 * Element of an upwards chained list of Objects
 * 
 * @author Moritz Decker, Fabian Kessler
 * @version v1.0.0-2021-09-22
 */
public class ChainDownElement<T>
{
    private T obj;
    private ChainDownElement<T> nextElem;


    public ChainDownElement()
    {
        this.obj = null;
        this.nextElem = null;
    }

    public ChainDownElement(T obj)
    {
        this.obj = obj;
        this.nextElem = null;
    }

    public ChainDownElement(T obj, ChainDownElement<T> nextElem)
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

    public void setNext(ChainDownElement<T> nextElem)
    {
        this.nextElem = nextElem;
    }

    public ChainDownElement<T> getNext()
    {
        return this.nextElem;
    }

    public boolean hasNext()
    {
        return this.nextElem == null;
    }
}
