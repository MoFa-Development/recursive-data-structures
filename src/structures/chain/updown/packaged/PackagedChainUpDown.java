package structures.chain.updown.packaged;

import java.util.Collection;
import java.util.Iterator;

import exceptions.ChainIndexOutOfBoundsException;
import structures.chain.Chain;
/**
 * Double-linked Chain working with packages for faster read
 * 
 * @author Moritz Decker, Fabian Kessler
 * @version v1.0.1-2021-09-23
 */
public class PackagedChainUpDown<E> extends Chain<E>
{
    @Override
    public boolean add(E obj) {
        // TODO implement
        return true;
    }

    @Override
    public boolean add(E obj, int index) throws ChainIndexOutOfBoundsException {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean remove(int index) throws ChainIndexOutOfBoundsException {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public E get(int index) throws ChainIndexOutOfBoundsException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public E getLast() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public E[] toArray() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "";
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public boolean contains(Object o) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean remove(Object o) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        // TODO Auto-generated method stub
        return null;
    }
}
