package DataStructures.PackagedChainUpDown;

import DataStructures.Chain.Chain;
import DataStructures.ChainDown.ChainDown;
import Exceptions.ChainIndexOutOfBoundsException;

/**
 * @author Moritz Decker, Fabian Kessler
 * @version v1.0.1-2021-09-23
 */
public class PackagedChainUpDown<T> extends Chain<T>
{
    private ChainDown<ChainPackage<T>> packages;
    private ChainPackage<T> lastPackage;

    private int defaultPackageSize;

    public PackagedChainUpDown()
    {
        this.defaultPackageSize = 4;
        this.packages = new ChainDown<ChainPackage<T>>();
    }

    public PackagedChainUpDown(int catalogInterval)
    {
        this.defaultPackageSize = catalogInterval;
        this.packages = new ChainDown<ChainPackage<T>>();
    }


    @Override
    public void add(T obj) {
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

    @Override
    public T getLast() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public T[] toArray() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return null;
    }
}
