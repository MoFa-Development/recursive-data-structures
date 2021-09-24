package structures.chain;

/**
 * Abstract chain element
 * 
 * @author Moritz Decker 
 * @version v1.0.1-2021-09-23
 */
public abstract class ChainElement<E> {
    protected E obj;

    protected ChainElement(E obj) {
        this.obj = obj;
    }

    /**
     * @return data stored in element
     */
    public E get() {
        return obj;
    }
}