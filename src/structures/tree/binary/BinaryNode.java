package structures.tree.binary;

public class BinaryNode<E> {
    protected BinaryNode<E> parent;
    protected BinaryNode<E> childLeft;
    protected BinaryNode<E> childRight;
    
    protected E obj;

    public BinaryNode(E obj) {
        this.obj = obj;
    }

    public BinaryNode<E> getParent() {
        return parent;
    }

    public BinaryNode<E> getChildLeft() {
        return childLeft;
    }

    public BinaryNode<E> getChildRight() {
        return childRight;
    }

    public E getObj() {
        return obj;
    }

    public void setObj(E obj) {
        this.obj = obj;
    }

    public void setChildLeft(BinaryNode<E> childLeft) {
        this.childLeft = childLeft;
        this.childLeft.setParent(this);
    }

    public void setChildRight(BinaryNode<E> childRight) {
        this.childRight = childRight;
        this.childRight.setParent(this);
    }

    public void setParent(BinaryNode<E> parent) {
        this.parent = parent;
    }
}