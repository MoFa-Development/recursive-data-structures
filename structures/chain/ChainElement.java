package structures.chain;

/**
 * Abstract chain element
 * 
 * @author Moritz Decker 
 * @version v1.0.1-2021-09-23
 */
public abstract class ChainElement<T> {
    protected T obj;

    public ChainElement(T obj) {
        this.obj = obj;
    }

    /**
     * @return data stored in element
     */
    public T get() {
        return obj;
    }
}