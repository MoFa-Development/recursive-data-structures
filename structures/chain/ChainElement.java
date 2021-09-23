package structures.chain;

public abstract class ChainElement<T> {
    protected T obj;

    public ChainElement(T obj) {
        this.obj = obj;
    }

    public T get() {
        return obj;
    }
}