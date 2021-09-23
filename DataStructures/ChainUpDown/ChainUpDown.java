package DataStructures.ChainUpDown;

import DataStructures.Chain.Chain;
import DataStructures.ChainDown.ChainDown;
import Exceptions.ChainIndexOutOfBoundsException;

public class ChainUpDown<T> extends ChainDown<T>
{
    private ChainUpDownElement<T> firstElement;
    private ChainUpDownElement<T> lastElement;

    public ChainUpDown()
    {
        // TODO implement    
    }

    @Override
    public void add(T obj, int index) throws ChainIndexOutOfBoundsException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void remove(int index) throws ChainIndexOutOfBoundsException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public T get(int index) throws ChainIndexOutOfBoundsException {
        // TODO Auto-generated method stub
        return null;
    }
}
