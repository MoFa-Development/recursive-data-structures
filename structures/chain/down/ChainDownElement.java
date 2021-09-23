package structures.chain.down;

import structures.chain.ChainElement;

/**
 * Element of an upwards chained list of Objects
 * 
 * @author Moritz Decker, Fabian Kessler
 * @version v1.0.0-2021-09-22
 */
public class ChainDownElement<T> extends ChainElement<T>
{
    protected ChainDownElement<T> nextElem;


    public ChainDownElement()
    {
        super(null);
        this.nextElem = null;
    }

    public ChainDownElement(T obj)
    {
        super(obj);
        this.nextElem = null;
    }

    public ChainDownElement(T obj, ChainDownElement<T> nextElem)
    {
        super(obj);
        this.nextElem = nextElem;
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
        return this.nextElem != null;
    }
}
