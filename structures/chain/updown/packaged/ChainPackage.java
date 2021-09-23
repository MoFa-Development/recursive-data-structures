package structures.chain.updown.packaged;

import structures.chain.updown.ChainUpDownElement;

public class ChainPackage<T>
{
    private ChainUpDownElement<T> beginElem;
    private int length;

    public ChainPackage()
    {
        this.beginElem = null; 
        this.length = 0;
    }

    public ChainPackage(ChainUpDownElement<T> beginElem)
    {
        this.beginElem = beginElem;
        this.length = 1;
    }

    public int getLength()
    {
        return this.length;
    }
}
