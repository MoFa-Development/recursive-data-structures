package DataStructures.CataloguedChainUpDown;

import DataStructures.Chain.Chain;
import DataStructures.ChainUp.ChainUp;
import Exceptions.ChainIndexOutOfBoundsException;

/**
 * @author Moritz Decker, Fabian Kessler
 * @version v1.0.1-2021-09-23
 */
public class CataloguedChainUpDown<T> extends Chain<T>
{
    private ChainUp<CataloguedChainUpDownElement<T>> catalogue;
    private CataloguedChainUpDownElement<T> lastElement;

    private int catalogueInterval;

    public CataloguedChainUpDown()
    {
        this.catalogueInterval = 4;
        this.catalogue = new ChainUp<CataloguedChainUpDownElement<T>>();
    }

    public CataloguedChainUpDown(int catalogInterval)
    {
        this.catalogueInterval = catalogInterval;
        this.catalogue = new ChainUp<CataloguedChainUpDownElement<T>>();
    }


    @Override
    public void add(T obj) {
        CataloguedChainUpDownElement<T> elem = new CataloguedChainUpDownElement<T>();
        
        if(length == 0) {
            this.catalogue.add(elem);
        } else {
            this.lastElement.setNext(elem);
            this.lastElement = elem;
        }
        
        if(catalogueInterval % length == 0) {
            this.catalogue.add(elem);
        }

        length++;
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
