package structures.chain.circular;

import exceptions.ChainIndexOutOfBoundsException;
import structures.chain.down.ChainDown;
import structures.chain.down.ChainDownElement;
import structures.chain.util.ChainDownIterator;

public class CircularChainDown<E> extends ChainDown<E> {
    @Override
    public ChainDownIterator<E> iterator() {
        return new ChainDownIterator<>((ChainDownElement<E>) this.getFirstElem());
    }

    public void linkBack() {
        ((ChainDownElement<E>) getFirstElem()).setNext((ChainDownElement<E>) this.getFirstElem());
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
}
