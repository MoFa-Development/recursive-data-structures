package structures.chain.circular;

import java.util.ArrayList;
import java.util.Arrays;

import exceptions.ChainIndexOutOfBoundsException;
import structures.chain.updown.ChainUpDown;
import structures.chain.util.ChainDownIterator;

public class CircularChainUpDown<E> extends ChainUpDown<E> {
    @Override
    public ChainDownIterator<E> iterator() {
        return new ChainDownIterator<>(this.getFirstElem());
    }

    public void linkBack() {
        getLastElem().setNext(this.getFirstElem());
        getFirstElem().setPrev(this.getLastElem());
    }

    @Override
    public boolean add(E obj) {
        boolean result = super.add(obj);
        linkBack();
        return result;
    }

    @Override
    public void add(int index, E obj) throws ChainIndexOutOfBoundsException {
        super.add(index, obj);
        linkBack();
    }

    @Override
    public E remove(int index) throws ChainIndexOutOfBoundsException {
        E result = super.remove(index);
        linkBack();
        return result;
    }

    @Override
    public Object[] toArray() {
        ArrayList<E> arrList = new ArrayList<>();
        
        int index = 0;
        for(E obj: this) {
            index++;
            arrList.add(obj);
            
            if(index >= size()) {
                break;
            }
        }
        
        return arrList.toArray();
    }

    @Override
    public String toString() {
        return Arrays.toString(this.toArray());
    }
}
